"""JSON persistence and demo seeds for the cloud controller."""
from __future__ import annotations

import json
import os
import shutil
import subprocess
import threading
import time
from datetime import datetime, timedelta
from pathlib import Path
from typing import Any

ROOT = Path(__file__).resolve().parent
DATA = ROOT / "data"
ASSETS = ROOT / "assets"
CATALOG = DATA / "catalog.json"

_LOCK = threading.RLock()

FILES = {
    "site": DATA / "site.json",
    "layout": DATA / "layout.json",
    "content": DATA / "content.json",
    "overrides": DATA / "overrides.json",
}


def _now() -> datetime:
    return datetime.now()


def _date(days: int = 0, fmt: str = "%Y-%m-%d %H:%M:%S") -> str:
    return (_now() + timedelta(days=days)).strftime(fmt)


def _read_json(path: Path, default: Any) -> Any:
    try:
        if path.exists():
            return json.loads(path.read_text(encoding="utf-8"))
    except Exception:
        pass
    return default


def _write_json(path: Path, value: Any) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    tmp = path.with_suffix(path.suffix + ".tmp")
    tmp.write_text(json.dumps(value, ensure_ascii=False, indent=2), encoding="utf-8")
    os.replace(tmp, path)


def load(name: str, default: Any = None) -> Any:
    with _LOCK:
        return _read_json(FILES[name], default)


def save(name: str, value: Any) -> Any:
    with _LOCK:
        _write_json(FILES[name], value)
        return value


def catalog() -> dict:
    return _read_json(CATALOG, {})


def component_index() -> dict[str, dict]:
    return {c["tag"]: c for c in catalog().get("components", [])}


# ---------------------------------------------------------------------------
# Seed data
# ---------------------------------------------------------------------------

def default_site() -> dict:
    return {
        "login": {"username": "demo", "password": "demo"},
        "brand": {
            "id": "brand-1001",
            "brandName": "高一（6）班",
            "schoolId": "school-1001",
            "siteId": "site-1001",
            "siteName": "教学楼 A 区",
            "classesId": "class-1001",
            "loginName": "demo",
            "plaintextPassword": "demo",
            "schoolType": "1",
            "cityCode": "500000",
            "direction": "2",
            "isMessage": True,
            "isSecond": True,
            "badgeUrl": "/mock/logo.png",
            "verify": [{"id": "verify-1", "name": "刷卡验证"}, {"id": "verify-2", "name": "离线码"}],
        },
        "school": {
            "schoolName": "示范智慧中学",
            "englishName": "DEMO SMART CAMPUS",
            "schoolLogo": "/mock/logo.png",
            "schoolBackground": "/mock/school-bg.jpg",
            "areaName": "重庆市 · 示范区",
            "schoolType": "1",
        },
        "classes": {
            "classesName": "高一（6）班",
            "className": "高一（6）班",
            "gradeName": "高一",
            "headerTeacher": "张明",
            "slogan": "厚德博学 · 笃行致远",
            "studentCount": 48,
            "classPhoto": "/mock/album-1.jpg",
            "classroom": "教学楼 A 区 305",
            "classesId": "class-1001",
        },
        "teachers": [
            {"id": "teacher-1", "name": "张明", "subject": "语文", "role": "班主任", "avatar": "/mock/avatar-1.png", "phone": "13800000001"},
            {"id": "teacher-2", "name": "李华", "subject": "数学", "role": "任课教师", "avatar": "/mock/avatar-2.png", "phone": "13800000002"},
            {"id": "teacher-3", "name": "王芳", "subject": "英语", "role": "任课教师", "avatar": "/mock/avatar-3.png", "phone": "13800000003"},
            {"id": "teacher-4", "name": "赵磊", "subject": "物理", "role": "任课教师", "avatar": "/mock/avatar-4.png", "phone": "13800000004"},
        ],
        "students": [
            {"id": "student-1", "name": "陈一鸣", "number": "01", "avatar": "/mock/avatar-5.png", "cardNo": "1234567890", "role": "student"},
            {"id": "student-2", "name": "刘思远", "number": "02", "avatar": "/mock/avatar-6.png", "cardNo": "1234567891", "role": "student"},
            {"id": "student-3", "name": "周子涵", "number": "03", "avatar": "/mock/avatar-7.png", "cardNo": "1234567892", "role": "student"},
            {"id": "student-4", "name": "林小雨", "number": "04", "avatar": "/mock/avatar-8.png", "cardNo": "1234567893", "role": "student"},
            {"id": "student-5", "name": "孙浩然", "number": "05", "avatar": "/mock/avatar-5.png", "cardNo": "1234567894", "role": "student"},
            {"id": "student-6", "name": "吴佳怡", "number": "06", "avatar": "/mock/avatar-6.png", "cardNo": "1234567895", "role": "student"},
        ],
        "teacher": {"id": "teacher-1", "name": "张明", "avatar": "/mock/avatar-1.png", "cardNo": "8888888888"},
        "weather": {
            "area": "重庆", "province": "重庆", "areaid": "101040100", "city": "重庆",
            "weather": "多云", "real": "24", "lowest": "18", "highest": "27",
            "humidity": "62", "wind": "东南风", "windsc": "2级", "aqi": "42",
            "quality": "优", "pm25": "28", "tips": "天气舒适，适合户外活动",
            "sunrise": "06:52", "sunset": "18:24", "uv_index": "4", "vis": "16",
            "weatherimg": "cloudy", "weathercode": "01", "week": "星期二",
        },
        "device": {
            "mac": "__SEC_MAC_PUT_92F7D57E__",
            "androidId": "0123456789abcdef",
            "model": "YD-BRAND-3",
            "version": "3.0.14",
        },
    }


def default_layout() -> dict:
    cards = [
        {"tag": "hbcdxx21", "moduleName": "场地提示", "x": 0, "y": 0, "width": 2, "height": 1},
        {"tag": "hbtzgg25", "moduleName": "通知公告", "x": 0, "y": 1, "width": 2, "height": 5},
        {"tag": "hbbjxx22", "moduleName": "班级信息", "x": 2, "y": 0, "width": 2, "height": 2},
        {"tag": "hbryq22", "moduleName": "荣誉墙", "x": 4, "y": 0, "width": 2, "height": 2},
        {"tag": "hbbjxc23", "moduleName": "班级相册", "x": 6, "y": 0, "width": 2, "height": 3},
        {"tag": "hbxjxc44", "moduleName": "校园相册", "x": 2, "y": 2, "width": 4, "height": 4},
        {"tag": "hbxjsp23", "moduleName": "校园视频", "x": 6, "y": 3, "width": 2, "height": 3},
    ]
    return {
        "pages": [{"id": "home", "name": "默认首页", "pagination": "home", "cards": _finish_cards(cards)}],
        "activePage": "home",
        "nextId": 100,
    }


def _finish_cards(cards: list[dict]) -> list[dict]:
    out = []
    for i, card in enumerate(cards):
        item = {
            "id": card.get("id") or f"card-{i + 1}",
            "tag": card["tag"],
            "moduleName": card.get("moduleName", ""),
            "x": int(card.get("x", 0)),
            "y": int(card.get("y", 0)),
            "width": int(card.get("width", 2)),
            "height": int(card.get("height", 2)),
            "borderColor": card.get("borderColor", ""),
            "backgroundColor": card.get("backgroundColor", ""),
            "showModuleName": bool(card.get("showModuleName", True)),
            "jsonParam": card.get("jsonParam", ""),
            "url": card.get("url", ""),
            "imgType": card.get("imgType", ""),
            "images": card.get("images", ""),
            "descriptive": card.get("descriptive", ""),
            "secPageBackTime": int(card.get("secPageBackTime", 10)),
            "enabled": bool(card.get("enabled", True)),
        }
        out.append(item)
    return out


def default_content() -> dict:
    notices = []
    titles = [
        ("关于开展校园读书月活动的通知", 1, "校级"),
        ("高一（6）班期中考试安排", 1, "班级"),
        ("秋季运动会报名开始啦", 1, "校园"),
        ("本周值日安排与流动红旗评比", 2, "班级"),
        ("校园安全检查通知", 1, "校园"),
        ("家长会邀请函", 1, "班级"),
    ]
    for i, (title, mess_type, source) in enumerate(titles, 1):
        notices.append({
            "id": f"notice-{i}",
            "title": title,
            "content": f"<p>{title}。</p><p>请同学们关注时间节点，按时参加。本通知由云端控制器生成，可在后台修改。</p>",
            "contentType": 1,
            "messType": mess_type,
            "coverImg": f"/mock/cover-{i}.jpg",
            "contentImg": f"/mock/cover-{i}.jpg",
            "author": "学生处",
            "source": source,
            "identityUserName": "张明",
            "timerDate": _date(-i),
            "publishTime": _date(-i),
            "type": 1,
            "attachments": [],
            "details": [],
        })
    return {
        "notices": notices,
        "albums": {
            "class": [
                {"id": "album-c1", "name": "运动会精彩瞬间", "cover": "/mock/album-1.jpg",
                 "images": [f"/mock/album-{i}.jpg" for i in range(1, 5)], "date": _date(-3, "%Y-%m-%d")},
                {"id": "album-c2", "name": "班级文化墙", "cover": "/mock/album-2.jpg",
                 "images": [f"/mock/album-{i}.jpg" for i in range(2, 7)], "date": _date(-8, "%Y-%m-%d")},
            ],
            "campus": [
                {"id": "album-s1", "name": "校园秋色", "cover": "/mock/album-3.jpg",
                 "images": [f"/mock/album-{i}.jpg" for i in range(3, 9)], "date": _date(-5, "%Y-%m-%d")},
                {"id": "album-s2", "name": "社团招新", "cover": "/mock/album-4.jpg",
                 "images": [f"/mock/album-{i}.jpg" for i in range(1, 7)], "date": _date(-12, "%Y-%m-%d")},
            ],
        },
        "videos": [
            {"id": "video-1", "name": "校园宣传片", "url": "/mock/video-1.mp4", "cover": "/mock/cover-7.jpg"},
            {"id": "video-2", "name": "班级风采", "url": "/mock/video-2.mp4", "cover": "/mock/cover-8.jpg"},
            {"id": "video-3", "name": "运动会集锦", "url": "/mock/video-3.mp4", "cover": "/mock/cover-9.jpg"},
        ],
        "honors": [
            {"id": "honor-1", "name": "文明班级", "studentName": "高一（6）班", "avatar": "/mock/avatar-1.png", "reason": "九月文明班级评比第一名", "date": _date(-2, "%Y-%m-%d"), "level": "校级"},
            {"id": "honor-2", "name": "学习之星", "studentName": "陈一鸣", "avatar": "/mock/avatar-5.png", "reason": "期中考试年级前十", "date": _date(-4, "%Y-%m-%d"), "level": "年级"},
            {"id": "honor-3", "name": "劳动标兵", "studentName": "刘思远", "avatar": "/mock/avatar-6.png", "reason": "值日工作认真负责", "date": _date(-6, "%Y-%m-%d"), "level": "班级"},
            {"id": "honor-4", "name": "进步之星", "studentName": "周子涵", "avatar": "/mock/avatar-7.png", "reason": "数学成绩进步 30 分", "date": _date(-9, "%Y-%m-%d"), "level": "班级"},
            {"id": "honor-5", "name": "体育之星", "studentName": "林小雨", "avatar": "/mock/avatar-8.png", "reason": "校运会 800 米冠军", "date": _date(-11, "%Y-%m-%d"), "level": "校级"},
            {"id": "honor-6", "name": "优秀班干部", "studentName": "孙浩然", "avatar": "/mock/avatar-5.png", "reason": "班级管理突出", "date": _date(-15, "%Y-%m-%d"), "level": "班级"},
        ],
        "duty": [
            {"id": "duty-1", "week": "本周", "day": "星期一", "studentName": "陈一鸣", "task": "教室卫生", "avatar": "/mock/avatar-5.png"},
            {"id": "duty-2", "week": "本周", "day": "星期二", "studentName": "刘思远", "task": "走廊卫生", "avatar": "/mock/avatar-6.png"},
            {"id": "duty-3", "week": "本周", "day": "星期三", "studentName": "周子涵", "task": "黑板整理", "avatar": "/mock/avatar-7.png"},
            {"id": "duty-4", "week": "本周", "day": "星期四", "studentName": "林小雨", "task": "讲台整理", "avatar": "/mock/avatar-8.png"},
            {"id": "duty-5", "week": "本周", "day": "星期五", "studentName": "孙浩然", "task": "门窗检查", "avatar": "/mock/avatar-5.png"},
        ],
        "works": [
            {"id": "work-1", "title": "我的暑假生活", "studentName": "陈一鸣", "content": "这个暑假我参观了科技馆，收获很多。", "avatar": "/mock/avatar-5.png", "date": _date(-2, "%Y-%m-%d"), "likes": 12, "comments": 3},
            {"id": "work-2", "title": "读《平凡的世界》有感", "studentName": "刘思远", "content": "平凡的人也可以有不平凡的人生。", "avatar": "/mock/avatar-6.png", "date": _date(-4, "%Y-%m-%d"), "likes": 18, "comments": 5},
            {"id": "work-3", "title": "秋日校园写生", "studentName": "周子涵", "content": "用画笔记录校园的秋天。", "avatar": "/mock/avatar-7.png", "date": _date(-6, "%Y-%m-%d"), "likes": 9, "comments": 1},
        ],
        "countdowns": [
            {"id": "cd-1", "title": "期中考试", "date": _date(9, "%Y-%m-%d"), "type": "考试", "color": "#FF6B6B"},
            {"id": "cd-2", "title": "校园运动会", "date": _date(16, "%Y-%m-%d"), "type": "活动", "color": "#4ECDC4"},
            {"id": "cd-3", "title": "元旦联欢", "date": _date(72, "%Y-%m-%d"), "type": "节日", "color": "#FFD93D"},
        ],
        "exams": [
            {"id": "exam-1", "name": "期中考试", "date": _date(9, "%Y-%m-%d"), "startTime": "08:30", "endTime": "10:00", "subject": "语文", "room": "A305", "seat": "12"},
            {"id": "exam-2", "name": "期中考试", "date": _date(9, "%Y-%m-%d"), "startTime": "10:20", "endTime": "11:50", "subject": "数学", "room": "A305", "seat": "12"},
            {"id": "exam-3", "name": "期中考试", "date": _date(10, "%Y-%m-%d"), "startTime": "08:30", "endTime": "10:00", "subject": "英语", "room": "A305", "seat": "12"},
        ],
        "books": [
            {"id": "book-1", "title": "平凡的世界", "author": "路遥", "cover": "/mock/cover-10.jpg", "status": "在馆", "isbn": "9787530216781"},
            {"id": "book-2", "title": "三体", "author": "刘慈欣", "cover": "/mock/cover-11.jpg", "status": "借出", "isbn": "9787536692930"},
            {"id": "book-3", "title": "活着", "author": "余华", "cover": "/mock/cover-12.jpg", "status": "在馆", "isbn": "9787506365437"},
            {"id": "book-4", "title": "朝花夕拾", "author": "鲁迅", "cover": "/mock/cover-10.jpg", "status": "在馆", "isbn": "9787020002207"},
        ],
        "activities": [
            {"id": "active-1", "title": "秋季运动会", "content": "报名项目：100 米、跳远、4×100 接力。", "startTime": _date(16, "%Y-%m-%d"), "cover": "/mock/cover-8.jpg", "state": 1},
            {"id": "active-2", "title": "读书分享会", "content": "分享你最喜欢的一本书。", "startTime": _date(4, "%Y-%m-%d"), "cover": "/mock/cover-9.jpg", "state": 1},
        ],
        "votes": [
            {"id": "vote-1", "title": "十月文明之星评选", "endTime": _date(3, "%Y-%m-%d"), "options": [
                {"id": "opt-1", "name": "陈一鸣", "count": 18}, {"id": "opt-2", "name": "刘思远", "count": 15},
                {"id": "opt-3", "name": "周子涵", "count": 12}], "state": 1},
        ],
        "schedule": [
            {"day": "周一", "items": ["语文", "数学", "英语", "物理", "体育", "自习"]},
            {"day": "周二", "items": ["数学", "英语", "化学", "语文", "美术", "自习"]},
            {"day": "周三", "items": ["英语", "物理", "数学", "历史", "音乐", "班会"]},
            {"day": "周四", "items": ["语文", "化学", "数学", "英语", "体育", "自习"]},
            {"day": "周五", "items": ["数学", "语文", "物理", "地理", "信息", "自习"]},
        ],
        "repairs": [
            {"id": "repair-1", "title": "教室日光灯闪烁", "status": "处理中", "date": _date(-1, "%Y-%m-%d"), "contact": "张明"},
            {"id": "repair-2", "title": "讲台多媒体无信号", "status": "已完成", "date": _date(-5, "%Y-%m-%d"), "contact": "张明"},
        ],
    }


def default_overrides() -> dict:
    return {"items": {}}


# ---------------------------------------------------------------------------
# Assets
# ---------------------------------------------------------------------------

GRADIENTS = [
    ((47, 107, 255), (0, 194, 255)),
    ((255, 107, 107), (255, 179, 71)),
    ((46, 204, 113), (22, 160, 133)),
    ((155, 89, 182), (52, 152, 219)),
    ((241, 196, 15), (230, 126, 34)),
    ((26, 188, 156), (44, 62, 80)),
    ((231, 76, 60), (192, 57, 43)),
    ((52, 73, 94), (44, 62, 80)),
]


def _font(size: int):
    from PIL import ImageFont
    for path in (r"C:/Windows/Fonts/msyhbd.ttc", r"C:/Windows/Fonts/msyh.ttc", r"C:/Windows/Fonts/simhei.ttf"):
        try:
            return ImageFont.truetype(path, size)
        except Exception:
            continue
    return ImageFont.load_default()


def _gradient_image(path: Path, size: tuple[int, int], colors, title: str, subtitle: str = "") -> None:
    from PIL import Image, ImageDraw
    w, h = size
    img = Image.new("RGB", size, colors[0])
    draw = ImageDraw.Draw(img)
    for y in range(h):
        t = y / max(h - 1, 1)
        draw.line([(0, y), (w, y)], fill=tuple(int(colors[0][i] * (1 - t) + colors[1][i] * t) for i in range(3)))
    draw.text((int(w * 0.08), int(h * 0.36)), title, font=_font(max(24, int(h * 0.12))), fill=(255, 255, 255))
    if subtitle:
        draw.text((int(w * 0.08), int(h * 0.58)), subtitle, font=_font(max(14, int(h * 0.055))), fill=(255, 255, 255))
    noise = Image.effect_noise(size, 12).convert("L")
    img = Image.composite(img, Image.new("RGB", size, colors[1]), noise.point(lambda v: 235 + v // 8))
    img.save(path, quality=88)


def ensure_assets() -> None:
    ASSETS.mkdir(parents=True, exist_ok=True)
    try:
        from PIL import Image, ImageDraw
    except Exception:
        return
    if not (ASSETS / "logo.png").exists():
        img = Image.new("RGB", (256, 256), (47, 107, 255))
        d = ImageDraw.Draw(img)
        d.ellipse((18, 18, 238, 238), fill=(255, 255, 255))
        d.text((66, 82), "班牌", font=_font(58), fill=(47, 107, 255))
        img.save(ASSETS / "logo.png")
    covers = [
        ("校园读书月", "READING MONTH"), ("期中考试", "EXAM WEEK"), ("秋季运动会", "SPORTS DAY"),
        ("值日评比", "DUTY"), ("校园安全", "SAFETY"), ("家长会", "PARENTS"),
        ("校园宣传片", "CAMPUS"), ("班级风采", "CLASS"), ("运动会集锦", "SPORTS"),
        ("平凡的世界", "BOOK"), ("三体", "BOOK"), ("活着", "BOOK"),
    ]
    for i, (title, sub) in enumerate(covers, 1):
        path = ASSETS / f"cover-{i}.jpg"
        if not path.exists():
            _gradient_image(path, (960, 540), GRADIENTS[(i - 1) % len(GRADIENTS)], title, sub)
    for i in range(1, 9):
        path = ASSETS / f"album-{i}.jpg"
        if not path.exists():
            _gradient_image(path, (960, 540), GRADIENTS[i % len(GRADIENTS)], f"相册 · {i}", "DEMO ALBUM")
    if not (ASSETS / "school-bg.jpg").exists():
        _gradient_image(ASSETS / "school-bg.jpg", (1920, 1080), ((20, 30, 48), (47, 107, 255)), "示范智慧中学", "DEMO SMART CAMPUS")
    for i in range(1, 9):
        path = ASSETS / f"avatar-{i}.png"
        if not path.exists():
            img = Image.new("RGB", (200, 200), GRADIENTS[i % len(GRADIENTS)][0])
            d = ImageDraw.Draw(img)
            d.ellipse((20, 20, 180, 180), fill=(255, 255, 255))
            d.text((70, 54), "同学", font=_font(42), fill=GRADIENTS[i % len(GRADIENTS)][0])
            img.save(path)
    for i in (1, 2, 3):
        path = ASSETS / f"video-{i}.mp4"
        if not path.exists():
            _make_video(path, f"Demo Video {i}")


def _make_video(path: Path, text: str) -> None:
    ffmpeg = shutil.which("ffmpeg")
    if not ffmpeg:
        path.write_bytes(b"")
        return
    font = r"C\:/Windows/Fonts/msyhbd.ttc"
    vf = f"drawtext=fontfile='{font}':text='{text}':fontcolor=white:fontsize=48:x=(w-text_w)/2:y=(h-text_h)/2"
    cmd = [
        ffmpeg, "-y", "-f", "lavfi", "-i", "color=c=0x2f6bff:s=640x360:d=6",
        "-vf", vf, "-c:v", "libx264", "-pix_fmt", "yuv420p", "-t", "6", str(path),
    ]
    try:
        subprocess.run(cmd, capture_output=True, timeout=60)
    except Exception:
        path.write_bytes(b"")


def reset() -> None:
    DATA.mkdir(parents=True, exist_ok=True)
    save("site", default_site())
    save("layout", default_layout())
    save("content", default_content())
    save("overrides", default_overrides())


def ensure() -> None:
    DATA.mkdir(parents=True, exist_ok=True)
    if not FILES["site"].exists():
        save("site", default_site())
    if not FILES["layout"].exists():
        save("layout", default_layout())
    if not FILES["content"].exists():
        save("content", default_content())
    if not FILES["overrides"].exists():
        save("overrides", default_overrides())
    ensure_assets()
