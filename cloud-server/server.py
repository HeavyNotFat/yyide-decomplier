"""智慧班牌 cloud controller.

A local replacement for https://api.yyide.com plus a web console used to design
the home-screen card layout, edit every module's content and emulate any of the
257 known endpoints.

    python cloud-server/server.py --port 8765

Endpoints:
    /admin            web console
    /api/state        console state (site/layout/content)
    /brand/...        mocked app API (same paths as the real service)
"""
from __future__ import annotations

import argparse
import json
import os
import re
import socket
import threading
import time
from collections import deque
from datetime import datetime, timedelta
from pathlib import Path
from typing import Any

from flask import Flask, Response, jsonify, request, send_from_directory

import store

ROOT = Path(__file__).resolve().parent
WEB = ROOT / "web"

app = Flask(__name__, static_folder=None)

LOG_LOCK = threading.Lock()
LOG_ITEMS: deque[dict] = deque(maxlen=1000)
LOG_SEQ = 0
LOG_FILE = ROOT / "data" / "requests.log"


# ---------------------------------------------------------------------------
# helpers
# ---------------------------------------------------------------------------

def now_str() -> str:
    return datetime.now().strftime("%Y-%m-%d %H:%M:%S")


def envelope(data: Any = None, code: int = 0, message: str = "操作成功", **extra: Any) -> dict:
    body = {"code": code, "message": message, "msg": message, "data": data}
    body.update(extra)
    return body


def page_data(items: list, page_no: int = 1, page_size: int = 20) -> dict:
    return {"list": items, "records": items, "total": len(items), "size": len(items),
            "current": page_no, "pageNo": page_no, "pageSize": page_size, "pages": 1}


def as_int(value: Any, default: int = 1) -> int:
    try:
        return int(value)
    except Exception:
        return default


def body_json() -> dict:
    if request.is_json:
        data = request.get_json(silent=True)
        return data if isinstance(data, dict) else {}
    raw = request.get_data(as_text=True)
    if raw:
        try:
            data = json.loads(raw)
            return data if isinstance(data, dict) else {}
        except Exception:
            return {}
    return {}


def log_request(path: str, method: str, body: Any, status: int, handler: str, took_ms: int) -> None:
    global LOG_SEQ
    item = {
        "id": 0,
        "ts": datetime.now().strftime("%H:%M:%S"),
        "method": method,
        "path": "/" + path,
        "query": {k: v for k, v in request.args.items()},
        "body": body,
        "status": status,
        "handler": handler,
        "ms": took_ms,
        "ua": request.headers.get("User-Agent", "")[:120],
    }
    with LOG_LOCK:
        LOG_SEQ += 1
        item["id"] = LOG_SEQ
        LOG_ITEMS.append(item)
    try:
        LOG_FILE.parent.mkdir(parents=True, exist_ok=True)
        with LOG_FILE.open("a", encoding="utf-8") as fh:
            fh.write(json.dumps(item, ensure_ascii=False) + "\n")
    except Exception:
        pass


def find_override(path: str) -> dict | None:
    data = store.load("overrides", {"items": {}})
    wanted = path.strip("/")
    for key, item in data.get("items", {}).items():
        if key.strip("/") == wanted and item and item.get("enabled", True):
            return item
    return None


def absolutize(value: Any) -> Any:
    """Turn /mock/... paths into absolute URLs so Glide/VideoView can load them."""
    root = request.host_url.rstrip("/")
    if isinstance(value, str):
        if value.startswith("/mock/") or value.startswith("/assets/"):
            return root + value
        return value
    if isinstance(value, list):
        return [absolutize(v) for v in value]
    if isinstance(value, dict):
        return {k: absolutize(v) for k, v in value.items()}
    return value


def plain_text(html: str) -> str:
    text = re.sub(r"<[^>]+>", " ", html or "")
    text = re.sub(r"\s+", " ", text).strip()
    return text


# ---------------------------------------------------------------------------
# layout
# ---------------------------------------------------------------------------

def card_to_model(page: dict, card: dict, index: int) -> dict:
    tag = card.get("tag", "")
    comp = store.component_index().get(tag, {})
    images = card.get("images") or ""
    images_list = [u.strip() for u in images.split(",") if u.strip()] if isinstance(images, str) else (images or [])
    return {
        "id": card.get("id") or f"{page['id']}-{index}",
        "tag": tag,
        "moduleName": card.get("moduleName") or comp.get("name", ""),
        "moduleId": card.get("moduleId", ""),
        "x": int(card.get("x", 0)),
        "y": int(card.get("y", 0)),
        "width": int(card.get("width", comp.get("width", 2) or 2)),
        "height": int(card.get("height", comp.get("height", 2) or 2)),
        "size": int(card.get("width", 2)) * int(card.get("height", 2)),
        "borderColor": card.get("borderColor", ""),
        "backgropColour": card.get("backgroundColor", ""),
        "backgropPhoto": card.get("backgroundPhoto", ""),
        "showModuleName": bool(card.get("showModuleName", True)),
        "jsonParam": card.get("jsonParam", ""),
        "url": card.get("url", ""),
        "imgType": card.get("imgType", ""),
        "images": images if isinstance(images, str) else ",".join(images),
        "imagesList": images_list,
        "descriptive": card.get("descriptive", ""),
        "secPageBackTime": int(card.get("secPageBackTime", 10)),
        "current": index + 1,
        "total": len(page.get("cards", [])),
        "versionStamp": 1,
        "delInd": "0",
        "layoutId": None,
        "createdBy": None,
        "updatedBy": None,
        "createdDateTime": now_str(),
        "updatedDateTime": now_str(),
        "streamDetails": {"brandId": store.load("site", {}).get("brand", {}).get("id", ""),
                          "nums": 0, "streamUrls": []},
        "layoutClassSignDetailsEntityList": [],
    }


def layout_response() -> dict:
    layout = store.load("layout", {"pages": []})
    pages = []
    for page in layout.get("pages", []):
        cards = [card_to_model(page, c, i) for i, c in enumerate(page.get("cards", []))
                 if c.get("enabled", True)]
        pages.append({
            "id": page.get("id", "home"),
            "pagination": page.get("pagination") or page.get("id") or "home",
            "layoutClassSignDetailsEntityList": cards,
            "createdDateTime": now_str(),
            "updatedDateTime": now_str(),
            "versionStamp": 1,
        })
    return {"code": 0, "msg": "", "data": pages}


# ---------------------------------------------------------------------------
# content adapters
# ---------------------------------------------------------------------------

def site() -> dict:
    return store.load("site", {})


def content() -> dict:
    return store.load("content", {})


def notices() -> list[dict]:
    return content().get("notices", [])


def albums(kind: str = "class") -> list[dict]:
    return content().get("albums", {}).get(kind, [])


def videos() -> list[dict]:
    return content().get("videos", [])


def honors() -> list[dict]:
    return content().get("honors", [])


def duty() -> list[dict]:
    return content().get("duty", [])


def classes_info() -> dict:
    c = site().get("classes", {})
    teachers = site().get("teachers", [])
    head = c.get("headerTeacher", "")
    return {
        "classesId": c.get("classesId", "class-1001"),
        "classesName": c.get("classesName", ""),
        "classesIcon": c.get("classPhoto", ""),
        "headmaster": head,
        "master": head,
        "f2016master": head,
        "masterId": "teacher-1",
        "peopleNums": c.get("studentCount", 0),
        "studentNums": str(c.get("studentCount", 0)),
        "teacherNums": str(len(teachers)),
        "slogan": c.get("slogan", ""),
        "classroom": c.get("classroom", ""),
        "gradeName": c.get("gradeName", ""),
        "teacherList": teachers,
    }


def weather() -> dict:
    w = site().get("weather", {})
    return {
        "aqi": str(w.get("aqi", "")), "area": w.get("area", ""), "areaid": w.get("areaid", ""),
        "date": datetime.now().strftime("%Y-%m-%d"), "highest": str(w.get("highest", "")),
        "humidity": str(w.get("humidity", "")), "lowest": str(w.get("lowest", "")),
        "moondown": "", "moonrise": "", "pcpn": "0", "province": w.get("province", ""),
        "quality": w.get("quality", ""), "real": str(w.get("real", "")),
        "sunrise": w.get("sunrise", ""), "sunset": w.get("sunset", ""),
        "tips": w.get("tips", ""), "uv_index": str(w.get("uv_index", "")),
        "vis": str(w.get("vis", "")), "weather": w.get("weather", ""),
        "weathercode": w.get("weathercode", ""), "weatherimg": w.get("weatherimg", ""),
        "week": w.get("week", ""), "wind": w.get("wind", ""), "windsc": w.get("windsc", ""),
        "windspeed": "12",
    }


def schedule_rows() -> list[dict]:
    rows = []
    for item in content().get("schedule", []):
        rows.append({"day": item.get("day"), "week": item.get("day"), "list": item.get("items", []),
                     "courses": [{"courseName": n, "teacher": "", "room": ""} for n in item.get("items", [])]})
    return rows


# ---------------------------------------------------------------------------
# module handlers
# ---------------------------------------------------------------------------

def handle_auth(path: str) -> dict:
    token = "eyJhbGciOiJIUzI1NiJ9.demo-cloud-token." + str(int(time.time()))
    if path == "auth/oauth/token":
        return {"code": 0, "message": "操作成功", "msg": "操作成功",
                "data": {"accessToken": token, "tokenHead": "Bearer ", "expiresIn": "863999",
                         "refreshToken": token + ".refresh"}}
    if path in ("auth/qrcode/gene", "auth/qrcode/check"):
        return envelope({"qrcode": "", "random": "demo-qr", "status": 0})
    return envelope({})


def handle_brand(path: str) -> dict:
    s = site()
    brand = dict(s.get("brand", {}))
    brand["plaintextPassword"] = brand.get("plaintextPassword") or s.get("login", {}).get("password", "demo")
    brand["loginName"] = brand.get("loginName") or s.get("login", {}).get("username", "demo")
    if path in ("brand/obtain", "brand/brand/info"):
        return {"code": 0, "message": "", "data": brand}
    if path in ("cloud/v2/barrier/getRegistrationCode", "cloud/v2/barrier/getOrBindingDevice"):
        return {"code": 0, "message": "操作成功", "data": {
            "id": "reg-1", "no": s.get("device", {}).get("mac", "aabbccddeeff"),
            "schoolId": brand.get("schoolId"), "name": brand.get("brandName"),
            "registrationCode": "DEMO-REG-3002", "authorizeCode": "DEMO-AUTH-3002",
            "authorizeCodeId": "auth-1", "type": "1",
        }}
    if path == "cloud/v2/barrier/updateRegistrationCode":
        return {"code": 0, "message": "操作成功", "data": {"registrationCode": "DEMO-REG-3002"}}
    if path == "cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo":
        return {"code": 0, "message": "操作成功", "data": {"authorizeCode": "DEMO-AUTH-3002", "authorizeCodeId": "auth-1"}}
    return envelope({})


def handle_layout(path: str) -> dict:
    if path == "brand/brand/layoutclasssign/layoutlist":
        return layout_response()
    if path == "brand/layoutclasssign/getVideoStreams":
        return envelope({"streamUrls": [{"url": "/mock/video-1.mp4"}]})
    return envelope({})


def handle_school(path: str) -> dict:
    s = site()
    school = s.get("school", {})
    cls = classes_info()
    brand = s.get("brand", {})
    if path == "brand/brand/campus/style":
        return envelope({**school, "schoolId": brand.get("schoolId"), "id": brand.get("schoolId")})
    if path == "brand/brand/campus/teachers":
        return envelope(s.get("teachers", []))
    if path in ("brand/brand/classes/info", "brand/class-brand-management/android/class/selectClassesInfo"):
        return {"code": 0, "message": "", "data": cls}
    if path.startswith("management/cloud-system/pc/getClassesInfo"):
        return {"code": 0, "msg": "", "success": True, "data": cls}
    if path == "brand/brand/classes/watchword/list":
        c = s.get("classes", {})
        rows = [
            {"id": "word-1", "classesId": 1001, "project": "班训",
             "projectValue": "厚德博学", "sort": 1},
            {"id": "word-2", "classesId": 1001, "project": "班风",
             "projectValue": "团结奋进", "sort": 2},
        ]
        return {"code": 0, "message": "", "data": rows}
    if path == "brand/brand/countdown/list":
        items = []
        for cd in content().get("countdowns", []):
            target = datetime.strptime(cd.get("date", "2030-01-01"), "%Y-%m-%d")
            items.append({
                "id": cd.get("id"), "activityTheme": cd.get("title"), "activityTime": cd.get("date"),
                "countDown": max(0, (target - datetime.now()).days), "kind": cd.get("type"),
                "templateUrl": cd.get("color", ""), "classesId": brand.get("classesId"),
                "schoolId": brand.get("schoolId"),
            })
        return {"code": 0, "msg": "", "data": items}
    if path == "brand/brand/remind/list":
        return {"code": 0, "message": "", "data": []}
    if path == "brand/brand/school/semester/current":
        start = datetime.now() - timedelta(days=40)
        return envelope({"semesterName": "2026 秋季学期", "startDate": start.strftime("%Y-%m-%d"),
                         "endDate": (start + timedelta(days=140)).strftime("%Y-%m-%d"),
                         "week": 6, "term": 1})
    if path == "cloud/site/getSite":
        c = s.get("classes", {})
        return envelope({
            "id": brand.get("siteId"), "name": brand.get("siteName"),
            "siteName": brand.get("siteName"), "schoolId": brand.get("schoolId"),
            "siteTypeId": "1", "siteTypeName": "多媒体教室",
            "buildingId": "building-1", "buildingName": "教学楼 A 区",
            "roomNum": (c.get("classroom") or "A305").split(" ")[-1],
            "floor": 3, "space": 60, "peppleNum": c.get("studentCount", 48),
            "classesId": c.get("classesId"), "classesName": c.get("classesName"),
            "describe": c.get("slogan", ""), "imgPaths": "/mock/school-bg.jpg",
            "qrCode": "", "versionStamp": 1, "list": [],
        })
    if path == "app/area/list":
        return envelope([{"id": "500000", "name": "重庆市", "children": []}])
    if path == "brand/brand/getBrandDominateScreen" or path == "brand/v2/custom/mode/list":
        return envelope([])
    if path == "cloud/brand/calendar/getSchoolCalendar" or path == "cloud/calendar/selectSchoolCalendar":
        return envelope({"list": [], "calendar": []})
    return envelope({})


def notice_items() -> list[dict]:
    """MessageItemBean friendly records (contentType 0 = rich text page)."""
    rows = []
    for n in notices():
        item = dict(n)
        item["contentType"] = 0
        timer = str(item.get("timerDate") or "")
        if len(timer) == 10:
            item["timerDate"] = timer + " 08:00:00"
        item["identityUserName"] = n.get("identityUserName") or n.get("author") or "学生处"
        item["details"] = n.get("details") or []
        item["attachments"] = n.get("attachments") or []
        item["isTop"] = False
        item["messJson"] = ""
        item["dominateStartTime"] = ""
        item["dominateEndTime"] = ""
        rows.append(item)
    return rows


def handle_messages(path: str) -> dict:
    items = notice_items()
    if path in ("brand/brand/mess/recive/page", "brand/brand/mess/recive/home"):
        return {"code": 0, "msg": "", "success": True,
                "data": page_data(items[:18], page_size=18)}
    if path == "brand/brand/mess/recive/index":
        return {"code": 0, "msg": "", "success": True, "data": {"list": items, "total": len(items)}}
    if path == "brand/brand/mess/recive/dominateScreen/list":
        return {"code": 0, "msg": "", "data": items[:5]}
    if path == "cloud/device/mess/publish/getCaptionsNoticeInfo":
        first = items[0] if items else {}
        return envelope({"id": first.get("id") or "cap-1",
                         "content": plain_text(first.get("content", "")),
                         "textColor": "#FFFFFF", "backgroundColor": "#0F172A",
                         "backgroundTransparency": 0, "rollSpeed": 60, "fontSize": 20,
                         "position": 0, "circulationMode": 1, "circulationNumber": 1,
                         "intervalTime": 10, "isShowBtn": False, "playCount": 0,
                         "playTime": 0, "isPlaySuccess": True})
    if path == "cloud/im/user/sig/gen" or path == "cloud/im/user/sig/getSystemSig":
        return envelope("demo-usersig")
    if path == "management/cloud-system/im/getUserSigByUserId":
        return envelope({"userSig": "demo-usersig", "usersig": "demo-usersig"})
    if path == "v4/openim/get_c2c_unread_msg_num":
        return {"ActionStatus": "OK", "ErrorCode": 0, "ErrorInfo": "", "UnreadMsgNum": 0}
    return envelope({})


def handle_home(path: str) -> dict:
    c = content()
    if path == "brand/brand/album/index":
        return {"code": 0, "msg": "", "data": [{"type": "1", "url": v.get("url")} for v in videos()]}
    if path == "brand/brand/album/list":
        imgs = []
        for album in albums("class") + albums("campus"):
            for url in album.get("images", []):
                imgs.append({"type": "1", "url": url})
        return {"code": 0, "msg": "", "data": imgs}
    if path == "brand/brand/album/listDetail":
        groups = []
        for i, album in enumerate(albums("class") + albums("campus"), 1):
            groups.append({"id": i, "name": album.get("name"), "isShow": True, "sort": str(i),
                           "albumDTOList": [{"id": j + 1, "name": album.get("name"), "url": u}
                                            for j, u in enumerate(album.get("images", []))]})
        return {"code": 0, "msg": "", "data": groups}
    if path == "brand/class-brand-management/android/videoalbum/classifylist":
        groups = []
        for i, album in enumerate(albums("class") + albums("campus"), 1):
            groups.append({"id": i, "name": album.get("name"), "show": "1", "classesId": 0,
                           "albumDTOList": [], "current": 1, "size": 1, "total": 1})
        return {"code": 0, "message": "", "data": groups}
    if path == "brand/class-brand-management/android/videoalbum/list":
        return {"code": 0, "message": "", "data": [
            {"id": i, "name": v.get("name"), "url": v.get("url"), "cover": v.get("cover"),
             "type": "1"} for i, v in enumerate(videos(), 1)]}
    if path in ("brand/brand/studentduty/selectRecord", "brand/class-brand-management/app/studentDuty/selectRecord"):
        return {"code": 0, "msg": "", "data": duty()}
    if path == "brand/brand/v3/studentduty/selectRecord":
        return {"code": 0, "msg": "", "data": {"list": duty(), "week": duty()}}
    if path == "brand/brand/studentwork/list":
        return {"code": 0, "msg": "", "data": page_data(c.get("works", []), page_size=10)}
    if path == "cloud/app/work/pageThisWeekWork":
        return {"code": 0, "msg": "", "data": page_data(c.get("works", []), page_size=20)}
    if path == "brand/brand/studentwork/selectStudentInfo":
        return {"code": 0, "msg": "", "data": site().get("students", [])}
    if path == "brand/brand/studentwork/workLike" or path == "brand/brand/studentwork/workComment":
        return envelope(True)
    if path == "brand/weather/now":
        return {"code": 0, "message": "操作成功", "msg": "操作成功", "data": weather()}
    if path == "brand/weather/day7":
        base = weather()
        days = []
        for i in range(7):
            d = datetime.now() + timedelta(days=i)
            days.append({**base, "date": d.strftime("%Y-%m-%d"),
                         "week": ["星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"][d.weekday()],
                         "highest": str(26 + (i % 3)), "lowest": str(17 + (i % 3)),
                         "weather": ["多云", "晴", "小雨", "阴"][i % 4]})
        return {"code": 0, "message": "操作成功", "data": {"area": base.get("area"),
                                                           "areaid": base.get("areaid"),
                                                           "province": base.get("province"),
                                                           "list": days}}
    if path == "Ecalender/weather_mini":
        base = weather()
        return {"status": 1000, "desc": "OK", "data": {
            "city": base.get("area"), "wendu": base.get("real"), "ganmao": base.get("tips"),
            "forecast": [{"date": (datetime.now() + timedelta(days=i)).strftime("%Y-%m-%d"),
                          "high": "高温 " + str(26 + i % 3) + "℃",
                          "low": "低温 " + str(17 + i % 3) + "℃",
                          "type": ["多云", "晴", "小雨", "阴"][i % 4],
                          "fx": "东南风", "fl": "2级"} for i in range(7)]}}
    return envelope({})


def timetable_bean() -> dict:
    """KBRsp2 shape used by 课表 components (sectionList + timetableList + weekList)."""
    subjects = ["语文", "数学", "英语", "物理", "化学", "自习"]
    times = [("08:00", "08:45"), ("08:55", "09:40"), ("10:00", "10:45"),
             ("10:55", "11:40"), ("14:00", "14:45"), ("14:55", "15:40")]
    sections = []
    for i, (start, end) in enumerate(times, 1):
        sections.append({"id": f"sec-{i}", "name": f"第{i}节", "startTime": start, "endTime": end,
                         "sequence": i, "periodType": 1 if i <= 4 else 2})
    today = datetime.now()
    monday = today - timedelta(days=today.weekday())
    week_list = {}
    for i, key in enumerate(["monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"]):
        week_list[key] = (monday + timedelta(days=i)).strftime("%m-%d")
    timetable = []
    teachers = ["张明", "李华", "王芳", "赵磊"]
    for day_index, row in enumerate(content().get("schedule", [])[:5], 1):
        items = row.get("items", [])
        for sec_index, subject in enumerate(items[:6], 1):
            start, end = times[sec_index - 1]
            timetable.append({
                "courseType": "1", "date": (monday + timedelta(days=day_index - 1)).strftime("%Y-%m-%d"),
                "endTime": end, "id": f"course-{day_index}-{sec_index}", "isStudent": True,
                "section": sec_index, "sectionName": f"第{sec_index}节",
                "sectionType": "1" if sec_index <= 4 else "2", "sectionTypeNum": sec_index,
                "startTime": start, "subjectName": subject, "week": day_index,
                "teacherList": [{"id": "teacher-1", "name": teachers[(day_index + sec_index) % len(teachers)],
                                 "cardNumber": "8888888888"}],
            })
    return {"code": 0, "message": "", "data": {
        "siteClassesName": site().get("classes", {}).get("classesName", ""),
        "thisWeek": 6, "weekTotal": 20, "weekList": week_list,
        "sectionList": {"morningList": sections[:4], "afternoonList": sections[4:],
                        "earlySelfStudyList": [], "lateSelfStudyList": [], "nightList": []},
        "timetableList": timetable,
    }}


def handle_timetable(path: str) -> dict:
    rows = schedule_rows()
    if path in ("cloud/app/timetable/getWeekTime",
                "brand/class-brand-management/android/course/classSchedule"):
        return timetable_bean()
    if path == "timetable/cloud-timetable/v1/kcb/classes":
        return {"code": 0, "msg": "", "data": {"list": rows, "week": 6,
                                               "classesName": site().get("classes", {}).get("classesName", "")}}
    return envelope({"list": rows})


def honor_items() -> list[dict]:
    rows = []
    level_map = {"校级": 1, "省级": 2, "国家级": 3, "班级": 1, "年级": 1}
    for h in honors():
        winner = h.get("studentName", "")
        is_class = "班" in winner
        rows.append({
            "id": h.get("id"), "name": h.get("name"), "winnerNames": winner,
            "honorType": 1 if is_class else 2,
            "level": level_map.get(h.get("level", ""), 3),
            "imgPaths": h.get("cover") or h.get("avatar") or "",
            "createTime": h.get("date", ""),
        })
    return rows


def handle_honor(path: str) -> dict:
    items = honor_items()
    bean = {"total": len(items), "pageNo": 1, "pageSize": 20, "list": items}
    if path in ("cloud/app/honor/brandPage", "cloud/evaluationPrize/classHonor",
                "cloud/evaluationPrize/studentHonor", "cloud/evaluationActivityBrand/list",
                "brand/evalDataCountStatistic/rankListByClass"):
        return {"code": 0, "message": "", "data": bean}
    if path.startswith("cloud/evaluationActivityBrand/"):
        return {"code": 0, "message": "", "data": bean}
    return {"code": 0, "message": "", "data": bean}


def handle_exam(path: str) -> dict:
    exams = content().get("exams", [])
    if path in ("brand/exam/recent", "brand/exam/by/student", "brand/exam/plan/week"):
        return envelope(page_data(exams))
    if path == "brand/exam/detail":
        return envelope(exams[0] if exams else {})
    if path == "brand/exam/person":
        return envelope({"seat": "12", "room": "A305", "studentName": "陈一鸣"})
    return envelope(page_data(exams))


def handle_library(path: str) -> dict:
    books = content().get("books", [])
    if path.startswith("rfid/class-board/") or path.startswith("rfid/hm-board/") or path.startswith("opac/"):
        return envelope(page_data(books))
    return envelope(page_data(books))


def handle_activity(path: str) -> dict:
    acts = content().get("activities", [])
    if path in ("brand/activity/enroll/page", "brand/activity/enroll/userEnrollPage"):
        return envelope(page_data(acts))
    if path == "brand/activity/enroll/detail":
        return envelope(acts[0] if acts else {})
    return envelope(page_data(acts))


def handle_vote(path: str) -> dict:
    votes = content().get("votes", [])
    if path in ("cloud/vote/page", "app/collectTableComponent/brand",
                "app/collectTableBrand/overview"):
        return envelope(page_data(votes))
    if path == "cloud/vote/get":
        return envelope(votes[0] if votes else {})
    if path == "cloud/vote/clickVote":
        return envelope(True)
    return envelope(page_data(votes))


def handle_userspace(path: str) -> dict:
    c = content()
    if path == "app/userAppr/pageDeviceAppr" or path == "cloud/app/userAppr/page":
        return envelope(page_data(c.get("repairs", [])))
    if path == "cloud/student/allStudents":
        return envelope(page_data(site().get("students", [])))
    if path == "cloud/address/book/student":
        return envelope(site().get("students", []))
    if path == "cloud/leaveWord/page":
        return envelope(page_data([]))
    if path in ("app/v2/proc/pageTask", "cloud/app/procAppr/getApprList"):
        return envelope(page_data([]))
    return envelope({})


def handle_attendance(path: str) -> dict:
    students = site().get("students", [])
    if path in ("attweb/app/attendance/getBrandAttendanceUser",
                "face/cloud-face/attendance/brand/app/v2/queryBrandAttendanceByClassIds"):
        return envelope(page_data(students))
    if path == "attweb/attendanceSignTask/brand/list":
        return envelope(page_data([]))
    return envelope(page_data(students))


def handle_reservation(path: str) -> dict:
    if path == "cloud/siteBooking/bookingRecordPage":
        return envelope(page_data([{"id": "bk-1", "siteName": "报告厅", "userName": "张明",
                                    "startTime": now_str(), "state": "已预约"}]))
    return envelope(page_data([]))


def handle_ai(path: str) -> dict:
    if path == "ai/assistant/public/list":
        return envelope([{"id": "ai-1", "name": "班级助手", "description": "可以回答问题、生成通知"}])
    if path == "ai/assistant/get":
        return envelope({"id": "ai-1", "name": "班级助手", "welcome": "你好，我是班级 AI 助手"})
    if path == "ai/chat/models":
        return envelope([{"id": "deepseek", "name": "DeepSeek"}])
    if path == "ai/chat/session/create":
        return envelope({"sessionId": "session-demo"})
    return envelope({})


def handle_dormitory(path: str) -> dict:
    if path == "brand/brand/dormitory/dormitoryHomepage/detail":
        return envelope({"list": [{"dormitoryName": "3 号楼 502", "score": 96, "rank": 2}],
                         "score": 96})
    return envelope({"list": [], "score": 0})


def handle_patrol(path: str) -> dict:
    if path == "app/patrolDayTaskSite/page":
        return envelope(page_data([{"id": "patrol-1", "siteName": "A305", "state": "待巡课",
                                    "teacherName": "张明"}]))
    return envelope(page_data([]))


def handle_device(path: str) -> dict:
    s = site()
    if path == "brand/brand/getSwitchsType":
        return envelope({"type": "1"})
    if path == "cloud/v2/barrier/getAppVersion":
        return envelope({"version": s.get("device", {}).get("version", "3.0.15"),
                         "url": "", "updateType": "0"})
    if path == "manage/machineInfo/getMachineConfigByDeviceNo":
        return envelope({"mac": s.get("device", {}).get("mac"), "deviceType": "2"})
    if path == "brand/brand/updateApkVersion":
        return envelope(True)
    return envelope({})


def handle_iot(path: str) -> dict:
    if path == "cloud/sks/site/get":
        return envelope({"siteName": site().get("brand", {}).get("siteName"), "devices": []})
    if path in ("cloud/sks/site/getSiteEnvIndicators", "cloud/sks/site/getSiteImages",
                "cloud/device/shared-config/get", "brand/openDoor/records/create"):
        return envelope([] if "Images" in path or "Indicators" in path else {})
    return envelope([])


def handle_upload(path: str) -> dict:
    return envelope({"url": "/mock/cover-1.jpg", "path": "/mock/cover-1.jpg"})


# ---------------------------------------------------------------------------
# dispatcher
# ---------------------------------------------------------------------------

HANDLERS = [
    ("auth", handle_auth),
    ("brand", handle_brand),
    ("layout", handle_layout),
    ("school", handle_school),
    ("messages", handle_messages),
    ("home", handle_home),
    ("timetable", handle_timetable),
    ("honor", handle_honor),
    ("exam", handle_exam),
    ("library", handle_library),
    ("activity", handle_activity),
    ("vote", handle_vote),
    ("userspace", handle_userspace),
    ("attendance", handle_attendance),
    ("reservation", handle_reservation),
    ("ai", handle_ai),
    ("dormitory", handle_dormitory),
    ("patrol", handle_patrol),
    ("device", handle_device),
    ("iot", handle_iot),
    ("upload", handle_upload),
]


def route_key(path: str) -> str:
    """Map path to a coarse handler family."""
    p = path.lower().strip("/")
    if p.startswith("auth/"):
        return "auth"
    if p.startswith("brand/obtain") or p.startswith("cloud/v2/barrier") or p.startswith("cloud/v2/equipment") or p in ("brand/brand/info",):
        return "brand"
    if "layoutclasssign/layoutlist" in p:
        return "layout"
    if p.startswith("brand/brand/campus") or p.startswith("brand/brand/classes") or p.startswith("brand/class-brand-management/android/class") or p.startswith("management/cloud-system/pc/getclassesinfo") or p.startswith("brand/brand/countdown") or p.startswith("brand/brand/school") or p.startswith("brand/brand/remind") or p.startswith("cloud/site/") or p.startswith("app/area/") or p.startswith("brand/v2/custom/") or p.startswith("cloud/brand/calendar") or p.startswith("cloud/calendar/"):
        return "school"
    if p.startswith("brand/brand/mess") or p.startswith("cloud/device/mess") or p.startswith("cloud/im/") or p.startswith("management/cloud-system/im/") or p.startswith("v4/openim/"):
        return "messages"
    if p.startswith("brand/brand/album") or p.startswith("brand/class-brand-management/android/videoalbum") or p.startswith("brand/weather") or p.startswith("ecalender/") or p.startswith("brand/brand/studentduty") or p.startswith("brand/brand/v3/studentduty") or p.startswith("brand/class-brand-management/app/studentduty") or p.startswith("brand/brand/studentwork") or p.startswith("cloud/app/work"):
        return "home"
    if p.startswith("brand/class-brand-management/android/course") or p.startswith("timetable/") or p.startswith("cloud/app/timetable"):
        return "timetable"
    if p.startswith("cloud/app/honor") or p.startswith("brand/appevalmedal") or p.startswith("brand/eval") or p.startswith("cloud/evaluation") or p.startswith("cloud/moraleducation") or p.startswith("cloud/evaluationprize"):
        return "honor"
    if p.startswith("brand/exam"):
        return "exam"
    if p.startswith("rfid/") or p.startswith("opac/"):
        return "library"
    if p.startswith("brand/activity"):
        return "activity"
    if p.startswith("cloud/vote") or p.startswith("app/collect"):
        return "vote"
    if p.startswith("app/userappr") or p.startswith("app/v2/proc") or p.startswith("cloud/app/userappr") or p.startswith("cloud/app/procappr") or p.startswith("cloud/student/") or p.startswith("cloud/address/") or p.startswith("cloud/leaveword") or p.startswith("app/actleave") or p.startswith("app/formprocess") or p.startswith("cloud/formprocess") or p.startswith("cloud/proc/") or p.startswith("leave-server/"):
        return "userspace"
    if p.startswith("attweb/") or p.startswith("face/cloud-face/attendance"):
        return "attendance"
    if p.startswith("cloud/sitebooking/"):
        return "reservation"
    if p.startswith("ai/"):
        return "ai"
    if p.startswith("brand/brand/dormitory") or p.startswith("cloud/moraleducationactivitybrand/dormitory"):
        return "dormitory"
    if p.startswith("app/patroldaytasksite") or p.startswith("app/patrolqrcode"):
        return "patrol"
    if p.startswith("brand/brand/getswitchstype") or p.startswith("cloud/v2/barrier/getappversion") or p.startswith("manage/machineinfo") or p.startswith("brand/brand/updateapkversion") or p.startswith("brand/after/"):
        return "device"
    if p.startswith("cloud/sks/") or p.startswith("api/lock/") or p.startswith("cloud/device/face-sync") or p.startswith("brand/opendoor") or p.startswith("brand/layoutclasssign/getvideostreams"):
        return "iot"
    if p.startswith("app/file/") or p.startswith("file/upload"):
        return "upload"
    return "fallback"


PATH_HANDLERS = {
    "auth": handle_auth, "brand": handle_brand, "layout": handle_layout, "school": handle_school,
    "messages": handle_messages, "home": handle_home, "timetable": handle_timetable,
    "honor": handle_honor, "exam": handle_exam, "library": handle_library,
    "activity": handle_activity, "vote": handle_vote, "userspace": handle_userspace,
    "attendance": handle_attendance, "reservation": handle_reservation, "ai": handle_ai,
    "dormitory": handle_dormitory, "patrol": handle_patrol, "device": handle_device,
    "iot": handle_iot, "upload": handle_upload,
}


def dispatch(path: str) -> tuple[dict, str]:
    normalized = path.strip("/")
    override = find_override(normalized)
    if override is not None:
        body = override.get("body")
        if isinstance(body, str):
            try:
                body = json.loads(body)
            except Exception:
                pass
        return body, "override"
    family = route_key(normalized)
    if normalized.startswith("ai/chat/completion/stream"):
        return {"error": "stream handled separately"}, "stream"
    handler = PATH_HANDLERS.get(family)
    if handler is None:
        return fallback(normalized), "fallback"
    try:
        return handler(normalized), family
    except Exception as exc:  # keep the device alive even if a handler breaks
        app.logger.exception("handler failed: %s", exc)
        return envelope({}, message=f"mock handler error: {exc}"), family


def fallback(path: str) -> dict:
    lower = path.lower()
    if any(k in lower for k in ("/page", "/list", "/record", "records", "home", "query", "rank", "overview")):
        return envelope(page_data([]))
    return envelope({})


# ---------------------------------------------------------------------------
# web routes
# ---------------------------------------------------------------------------

@app.after_request
def add_cors(response: Response) -> Response:
    response.headers["Access-Control-Allow-Origin"] = "*"
    response.headers["Access-Control-Allow-Headers"] = "Content-Type, Authorization"
    response.headers["Access-Control-Allow-Methods"] = "GET, POST, PUT, DELETE, OPTIONS"
    response.headers["Cache-Control"] = "no-store"
    return response


@app.route("/api/state", methods=["GET"])
def api_state():
    site_data = store.load("site", {})
    layout = store.load("layout", {})
    content_data = store.load("content", {})
    overrides = store.load("overrides", {"items": {}})
    cat = store.catalog()
    return jsonify({
        "site": site_data,
        "layout": layout,
        "content": content_data,
        "overrides": overrides,
        "catalog": cat,
        "server": {"time": now_str(), "host": request.host, "lan": lan_ip(),
                   "port": request.environ.get("SERVER_PORT", "8765")},
    })


@app.route("/api/site", methods=["PUT", "POST"])
def api_site():
    payload = request.get_json(force=True)
    if not isinstance(payload, dict):
        return jsonify({"ok": False, "error": "site must be an object"}), 400
    store.save("site", payload)
    return jsonify({"ok": True})


@app.route("/api/layout", methods=["PUT", "POST"])
def api_layout():
    payload = request.get_json(force=True)
    if not isinstance(payload, dict) or "pages" not in payload:
        return jsonify({"ok": False, "error": "layout.pages is required"}), 400
    store.save("layout", payload)
    return jsonify({"ok": True})


@app.route("/api/content", methods=["PUT", "POST"])
def api_content():
    payload = request.get_json(force=True)
    if not isinstance(payload, dict):
        return jsonify({"ok": False, "error": "content must be an object"}), 400
    store.save("content", payload)
    return jsonify({"ok": True})


@app.route("/api/overrides", methods=["PUT", "POST"])
def api_overrides():
    payload = request.get_json(force=True)
    if not isinstance(payload, dict):
        return jsonify({"ok": False, "error": "overrides must be an object"}), 400
    store.save("overrides", payload)
    return jsonify({"ok": True})


@app.route("/api/reset", methods=["POST"])
def api_reset():
    store.reset()
    return jsonify({"ok": True})


@app.route("/api/layout/reset", methods=["POST"])
def api_layout_reset():
    store.save("layout", store.default_layout())
    return jsonify({"ok": True})


@app.route("/api/logs", methods=["GET"])
def api_logs():
    since = as_int(request.args.get("since", 0), 0)
    with LOG_LOCK:
        items = [item for item in LOG_ITEMS if item["id"] > since]
        last = LOG_SEQ
    return jsonify({"items": items, "lastId": last})


@app.route("/api/logs/clear", methods=["POST"])
def api_logs_clear():
    with LOG_LOCK:
        LOG_ITEMS.clear()
    try:
        LOG_FILE.write_text("", encoding="utf-8")
    except Exception:
        pass
    return jsonify({"ok": True})


@app.route("/api/showcase", methods=["POST"])
def api_showcase():
    payload = request.get_json(silent=True) or {}
    categories = payload.get("categories") or []
    tags = payload.get("tags") or []
    components = store.catalog().get("components", [])
    selected = [c for c in components
                if (not categories or c["category"] in categories)
                and (not tags or c["tag"] in tags)]
    if not selected:
        return jsonify({"ok": False, "error": "no components selected"}), 400
    max_pages = max(1, min(20, as_int(payload.get("maxPages", 10), 10)))
    pages, used = build_showcase_pages(selected, start_pagination=int(payload.get("startIndex", 1)),
                                       max_pages=max_pages)
    if payload.get("replace", True):
        layout = {"pages": pages, "activePage": pages[0]["id"], "nextId": 100 + len(pages)}
        store.save("layout", layout)
    return jsonify({"ok": True, "pages": len(pages), "components": used,
                    "requested": len(selected), "skipped": len(selected) - used})


def build_showcase_pages(components: list[dict], start_pagination: int = 1,
                         max_pages: int = 10) -> tuple[list[dict], int]:
    """Pack components into 8x6 pages, one page per screen."""
    pages = []
    grid_w, grid_h = 8, 6
    used: list[list[bool]] = []
    cards: list[dict] = []

    def new_page():
        nonlocal used, cards
        used = [[False] * grid_w for _ in range(grid_h)]
        cards = []

    def find_slot(w: int, h: int):
        for y in range(grid_h - h + 1):
            for x in range(grid_w - w + 1):
                if all(not used[yy][xx] for yy in range(y, y + h) for xx in range(x, x + w)):
                    return x, y
        return None

    def mark(x: int, y: int, w: int, h: int):
        for yy in range(y, y + h):
            for xx in range(x, x + w):
                if 0 <= yy < grid_h and 0 <= xx < grid_w:
                    used[yy][xx] = True

    new_page()
    for comp in components:
        w = max(1, min(grid_w, int(comp.get("width") or 2)))
        h = max(1, min(grid_h, int(comp.get("height") or 2)))
        if w > grid_w or h > grid_h:
            continue
        slot = find_slot(w, h)
        if slot is None:
            if len(pages) >= max_pages - 1:
                break
            pages.append(make_page(pages, start_pagination, cards))
            new_page()
            slot = find_slot(w, h)
        if slot is None:
            continue
        x, y = slot
        mark(x, y, w, h)
        cards.append({"id": f"showcase-{len(pages) + 1}-{len(cards) + 1}", "tag": comp["tag"],
                      "moduleName": comp["name"], "x": x, "y": y, "width": w, "height": h,
                      "borderColor": "", "backgroundColor": "", "showModuleName": True,
                      "jsonParam": "", "url": "", "imgType": "", "images": "",
                      "descriptive": "", "secPageBackTime": 10, "enabled": True})
    if cards:
        pages.append(make_page(pages, start_pagination, cards))
    return pages, sum(len(p["cards"]) for p in pages)


def make_page(pages: list, start: int, cards: list[dict]) -> dict:
    index = start + len(pages)
    return {"id": f"showcase-{index}", "name": f"组件巡展 {index}", "pagination": f"showcase-{index}",
            "cards": cards}


@app.route("/api/health", methods=["GET"])
def api_health():
    return jsonify({"ok": True, "time": now_str()})


@app.route("/mock/<path:filename>")
def mock_asset(filename: str):
    return send_from_directory(store.ASSETS, filename, max_age=3600)


@app.route("/admin")
@app.route("/admin/")
def admin_index():
    return send_from_directory(WEB, "index.html")


@app.route("/admin/<path:filename>")
def admin_files(filename: str):
    return send_from_directory(WEB, filename)


@app.route("/favicon.ico", methods=["GET"])
def favicon():
    return ("", 204)


@app.route("/", defaults={"path": ""}, methods=["GET"])
def index(path: str):
    return admin_index()


@app.route("/<path:path>", methods=["GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS"])
def catch_all(path: str):
    started = time.time()
    if request.method == "OPTIONS":
        return ("", 204)
    normalized = path.strip("/")
    payload = body_json() if request.method in ("POST", "PUT", "PATCH", "DELETE") else {}
    if request.args:
        payload = {**{k: v for k, v in request.args.items()}, **payload}
    if normalized == "ai/chat/completion/stream":
        def generate():
            for chunk in ("你好，", "我是", "云端控制器", "接入的", "AI 助手。"):
                yield "data: " + json.dumps({"content": chunk}, ensure_ascii=False) + "\n\n"
                time.sleep(0.05)
            yield "data: [DONE]\n\n"
        log_request(normalized, request.method, payload, 200, "ai-stream", int((time.time() - started) * 1000))
        return Response(generate(), mimetype="text/event-stream")
    body, handler = dispatch(normalized)
    body = absolutize(body)
    took = int((time.time() - started) * 1000)
    log_request(normalized, request.method, payload, 200, handler, took)
    return Response(json.dumps(body, ensure_ascii=False), mimetype="application/json")


def lan_ip() -> str:
    try:
        sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
        sock.connect(("8.8.8.8", 80))
        ip = sock.getsockname()[0]
        sock.close()
        return ip
    except Exception:
        return "127.0.0.1"


def main() -> int:
    parser = argparse.ArgumentParser(description="智慧班牌 cloud controller")
    parser.add_argument("--host", default="0.0.0.0")
    parser.add_argument("--port", type=int, default=8765)
    parser.add_argument("--debug", action="store_true")
    args = parser.parse_args()

    store.ensure()
    ip = lan_ip()
    print()
    print("  智慧班牌 · 云端控制器")
    print("  ----------------------------------------------------")
    print(f"  控制台     http://127.0.0.1:{args.port}/admin")
    print(f"  模拟接口   http://127.0.0.1:{args.port}")
    print(f"  模拟器     http://10.0.2.2:{args.port}")
    print(f"  局域网     http://{ip}:{args.port}")
    print(f"  演示账号   demo / demo")
    print("  ----------------------------------------------------")
    print("  提示：修改布局后，班牌下拉刷新或重启即可生效。")
    print()
    app.run(host=args.host, port=args.port, debug=args.debug, threaded=True, use_reloader=False)
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
