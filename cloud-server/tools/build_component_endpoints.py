#!/usr/bin/env python3
"""Map every home component tag to the HTTP endpoints its Fragment uses.

Outputs cloud-server/data/component_endpoints.json:

    {
      "shared": {"/path": 12, ...},
      "components": {
        "hbbjxx22": {
          "tag": "hbbjxx22", "fragment": "ClassInfoFragment2_2L",
          "endpoints": [{"method": "GET", "path": "/brand/brand/classes/info", "service": "DingApiStores"}],
          "layoutFields": ["images", "url", "jsonParam"],
          "suggested": [...]
        }
      }
    }

Usage:
    python cloud-server/tools/build_component_endpoints.py
"""
from __future__ import annotations

import json
import re
from collections import Counter
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
SRC = ROOT / "src" / "main" / "java"
CATALOG = ROOT / "cloud-server" / "data" / "catalog.json"
OUT = ROOT / "cloud-server" / "data" / "component_endpoints.json"

SERVICE_FILES = sorted(
    p for p in SRC.rglob("*.java")
    if "@POST(" in p.read_text(encoding="utf-8", errors="replace")
    or "@GET(" in p.read_text(encoding="utf-8", errors="replace")
)

EXCLUDE_PREFIXES = (
    "/brand/obtain",
    "/auth/",
    "/cloud/v2/barrier",
    "/manage/machineInfo",
    "/brand/brand/layoutclasssign",
    "/cloud/im/",
    "/management/cloud-system/im/",
    "/app/file/",
    "/file/upload",
    "/cloud/device/face-sync",
    "/brand/after/",
)

CATEGORY_GROUPS = {
    "消息公告": ["brand/brand/mess/recive/page", "brand/brand/mess/recive/dominateScreen/list"],
    "班级/校园": ["brand/brand/classes/info", "brand/brand/campus/style", "brand/brand/campus/teachers"],
    "学生空间": ["app/v2/proc/pageTask", "cloud/student/allStudents", "cloud/leaveWord/page"],
    "作业/任务": ["cloud/app/work/pageThisWeekWork", "brand/brand/studentwork/list"],
    "相册/视频": ["brand/brand/album/list", "brand/brand/album/listDetail", "brand/brand/album/index"],
    "课表": ["cloud/app/timetable/getWeekTime", "brand/class-brand-management/android/course/classSchedule"],
    "考勤/打卡": ["attweb/app/attendance/getBrandAttendanceUser", "attweb/attendanceSignTask/brand/list"],
    "值日/值周": ["brand/brand/studentduty/selectRecord", "brand/class-brand-management/app/studentDuty/selectRecord"],
    "德育/评价": ["cloud/app/honor/brandPage", "cloud/evaluationActivityBrand/list"],
    "场地/走班": ["cloud/site/getSite", "brand/brand/campus/style"],
    "考试": ["brand/exam/recent", "brand/exam/by/student", "brand/exam/plan/week"],
    "图书/阅读": ["rfid/hm-board/library/list", "rfid/class-board/rank/hot-circulation-rank"],
    "会议/预约": ["cloud/siteBooking/bookingRecordPage", "cloud/employee/get"],
    "投票/问卷": ["cloud/vote/page", "app/collectTableComponent/brand"],
    "活动": ["brand/activity/enroll/page", "brand/activity/enroll/detail"],
    "宿舍": ["brand/brand/dormitory/dormitoryHomepage/detail"],
    "巡课": ["app/patrolDayTaskSite/page"],
    "报修": ["app/userAppr/pageDeviceAppr"],
    "留言/咨询": ["cloud/leaveWord/page", "cloud/employee/getEmployeeListByLabel"],
    "AI": ["ai/assistant/get", "ai/assistant/public/list"],
    "物联网": ["cloud/sks/site/get", "cloud/sks/site/getSiteEnvIndicators"],
    "校历/日历": ["cloud/brand/calendar/getSchoolCalendar", "cloud/calendar/selectSchoolCalendar"],
    "倒计时/时钟": ["brand/brand/countdown/list"],
    "天气/环境": ["brand/weather/now", "brand/weather/day7"],
    "特殊布局": [],
    "其他": [],
}

LAYOUT_FIELD_RULES = [
    ("WebView", ["url", "images", "jsonParam"]),
    ("Custom", ["images", "url", "jsonParam"]),
    ("Banner", ["images"]),
    ("Image", ["images"]),
    ("Video", ["url", "images"]),
    ("Cartoon", ["jsonParam"]),
    ("SiteInfo", ["images"]),
    ("Honor", ["images"]),
]


def parse_services() -> dict[str, list[dict]]:
    methods: dict[str, list[dict]] = {}
    for path in SERVICE_FILES:
        text = path.read_text(encoding="utf-8", errors="replace")
        for m in re.finditer(r'@(GET|POST|PUT|DELETE)\("([^"]+)"\)', text):
            rest = text[m.end():m.end() + 700]
            mm = re.search(
                r'\b(?:Observable<[^;]+?>|[A-Za-z0-9_<>?,. \[\]]+?)\s+(\w+)\s*\(', rest)
            if not mm:
                continue
            methods.setdefault(mm.group(1), []).append({
                "method": m.group(1), "path": m.group(2), "service": path.stem,
            })
    return methods


def candidate_files(fragment: str, files: dict[str, Path]) -> list[Path]:
    out: list[Path] = []
    path = files.get(fragment)
    if path:
        out.append(path)
        text = path.read_text(encoding="utf-8", errors="replace")
        names = set(re.findall(r'\b(\w+(?:Presenter|ViewModel|Network|Api))\b', text))
        for name in names:
            q = files.get(name)
            if q and q not in out:
                out.append(q)
    return out


def layout_fields(fragment: str) -> list[str]:
    for prefix, fields in LAYOUT_FIELD_RULES:
        if prefix in fragment:
            return fields
    return []


def main() -> int:
    catalog = json.loads(CATALOG.read_text(encoding="utf-8"))
    methods = parse_services()
    files = {p.stem: p for p in SRC.rglob("*.java")}
    components = {}
    shared: Counter = Counter()

    for comp in catalog["components"]:
        tag = comp["tag"]
        fragment = comp["fragment"]
        texts = [p.read_text(encoding="utf-8", errors="replace") for p in candidate_files(fragment, files)]
        # Kotlin interfaces are called through JADX-renamed methods such as
        # m430getHonorWallListgIAlus, whose inner name differs from the
        # interface method (requestHonorWallList).  Match both spellings.
        kotlin_names: set[str] = set()
        for text in texts:
            for m in re.finditer(r"m\d+([A-Za-z]\w*?)(?:gIAlus|IoAF18A|0E7RQCE)?\(", text):
                inner = m.group(1)
                if len(inner) >= 6:
                    kotlin_names.add(inner)

        def words(value: str) -> set[str]:
            parts = re.findall(r"[A-Z]?[a-z]+|[A-Z]+(?![a-z])", value)
            ignore = {"request", "get", "query", "select", "list", "info", "data"}
            return {p.lower() for p in parts if p.lower() not in ignore}

        def method_hit(text: str, name: str) -> bool:
            if "." + name + "(" in text:
                return True
            if re.search(r"m\d+" + re.escape(name) + r"\w*\(", text):
                return True
            name_words = words(name)
            for inner in kotlin_names:
                if inner == name:
                    return True
                if len(name) >= 8 and (inner in name or name in inner):
                    return True
                if len(name_words & words(inner)) >= 2:
                    return True
            return False

        found = []
        seen = set()
        for name, defs in methods.items():
            hit = any(method_hit(text, name) for text in texts)
            if not hit:
                continue
            for d in defs:
                key = (d["method"], d["path"])
                if key in seen:
                    continue
                seen.add(key)
                found.append(d)
        found = [d for d in found if not d["path"].startswith(EXCLUDE_PREFIXES)]
        found.sort(key=lambda d: (d["path"], d["method"]))

        category = comp.get("category", "")
        suggestions = [p for p in CATEGORY_GROUPS.get(category, [])
                       if not p.startswith(EXCLUDE_PREFIXES)]

        components[tag] = {
            "tag": tag,
            "fragment": fragment,
            "category": category,
            "endpoints": found,
            "layoutFields": layout_fields(fragment),
            "suggested": suggestions,
        }
        for d in found:
            shared[d["path"]] += 1

    payload = {
        "generatedFrom": "src/main/java service interfaces + Fragment/Presenter/ViewModel scan",
        "shared": dict(shared.most_common()),
        "components": components,
        "counts": {
            "components": len(components),
            "withEndpoints": sum(1 for c in components.values() if c["endpoints"]),
            "endpoints": len({e["path"] for c in components.values() for e in c["endpoints"]}),
        },
    }
    OUT.write_text(json.dumps(payload, ensure_ascii=False, indent=1), encoding="utf-8")
    print(f"components={payload['counts']['components']} "
          f"withEndpoints={payload['counts']['withEndpoints']} "
          f"endpoints={payload['counts']['endpoints']} -> {OUT}")
    for tag in list(components)[:5]:
        print(tag, [e["path"] for e in components[tag]["endpoints"]])
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
