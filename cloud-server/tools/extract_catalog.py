#!/usr/bin/env python3
"""Build the cloud controller catalog from the decompiled app.

Outputs 'cloud-server/data/catalog.json' with:

* every home-screen component tag understood by HomeFragment.fragment()
* the fragment class each tag maps to and the normalised grid size
* every activity declared in AndroidManifest.xml (feature browser)
* the 257 endpoints from scripts/endpoints (endpoint simulator)

The catalog is regenerated whenever the APK is re-decompiled:

    python cloud-server/tools/extract_catalog.py
"""
from __future__ import annotations

import json
import os
import re
import shutil
import subprocess
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[2]
HOME = ROOT / "src" / "main" / "java" / "com" / "yd" / "android_brand_mvp" / "HomeFragment.java"
MANIFEST = ROOT / "src" / "main" / "AndroidManifest.xml"
ORIGINAL_JAR = ROOT / "libs" / "original-classes.jar"
JAVAP = Path(os.environ.get("JAVAP") or shutil.which("javap") or r"D:/java-se-17/jdk-17.0.20.1+1/bin/javap.exe")
OUT = ROOT / "cloud-server" / "data" / "catalog.json"

# Tag prefix -> (human name, category).  Longest prefix wins.
TAG_NAMES: dict[str, tuple[str, str]] = {
    "hbtzgg": ("通知公告", "消息公告"),
    "hbtzggmb": ("通知公告模板", "消息公告"),
    "hbxxfb": ("信息发布", "消息公告"),
    "hbcdxx": ("场地信息", "场地/走班"),
    "hbcdkb": ("场地课表", "场地/走班"),
    "hbcdxk": ("场地巡课", "场地/走班"),
    "hbcdxl": ("场地巡览", "场地/走班"),
    "hbcdyy": ("场地预约", "场地/走班"),
    "hbkq": ("考勤", "考勤/打卡"),
    "hbjz": ("奖惩记录", "德育/评价"),
    "hbryq": ("荣誉墙", "德育/评价"),
    "hbdypj": ("德育评价", "德育/评价"),
    "hbsj": ("校园事件", "德育/评价"),
    "hbbjxx": ("班级信息", "班级/校园"),
    "hbbjxq": ("班级详情", "班级/校园"),
    "hbbjxc": ("班级相册", "相册/视频"),
    "hbxjxc": ("校园相册", "相册/视频"),
    "hbbjsp": ("班级视频", "相册/视频"),
    "hbxjsp": ("校园视频", "相册/视频"),
    "hbtsg": ("图书馆", "图书/阅读"),
    "hblibrary": ("图书馆", "图书/阅读"),
    "hbdztsg": ("电子图书馆", "图书/阅读"),
    "hbzrs": ("值周生", "值日/值周"),
    "hbzr": ("值日", "值日/值周"),
    "hbssdy": ("宿舍德育", "宿舍"),
    "hbssxq": ("宿舍详情", "宿舍"),
    "hbksgl": ("考试管理", "考试"),
    "hbskcd": ("上课/课表", "课表"),
    "hbdjs": ("倒计时", "倒计时/时钟"),
    "hbxl": ("校历", "校历/日历"),
    "hbxlyy": ("校园留言", "留言/咨询"),
    "hbhy": ("会议", "会议/预约"),
    "hbreservation": ("场地预约", "会议/预约"),
    "hbwl": ("物联网", "物联网"),
    "hbzdy": ("自定义", "自定义"),
    "hbzj": ("自定义", "自定义"),
    "hbtjcustom": ("天津自定义", "自定义"),
    "hb_ipad": ("iPad 布局", "特殊布局"),
    "hbchemistry": ("化学", "学科/特色"),
    # student-device / template tags
    "sbtzggmb": ("通知公告模板", "消息公告"),
    "sbxlyy": ("校园留言", "留言/咨询"),
    "sbaifull": ("AI 助手", "AI"),
    "sbtsgrm": ("图书热门", "图书/阅读"),
    "sbtsgxs": ("图书新书", "图书/阅读"),
    "sbyjfx": ("预警分析", "德育/评价"),
    "sbdypj": ("德育评价", "德育/评价"),
    "zhhb": ("智慧黑板", "特殊布局"),
    "dxhbxl": ("大学校历", "校历/日历"),
}

# Fragment class -> (human name, category).  Longest prefix wins.  The
# fragment is the truth: the tag prefix sometimes lies (hbtzgg_kt_24 actually
# renders ClassInfoFragment2_4L).
FRAGMENT_NAMES: list[tuple[str, str, str]] = [
    ("AnnouncementFragment", "通知公告", "消息公告"),
    ("MessageNoticeFragment", "通知公告", "消息公告"),
    ("MessageHomeFragment", "消息公告", "消息公告"),
    ("MessageFragment", "消息公告", "消息公告"),
    ("HomeHonorFragment", "荣誉墙", "德育/评价"),
    ("HonorFragment", "荣誉榜", "德育/评价"),
    ("EvaluationFragment", "德育评价", "德育/评价"),
    ("IndexClassMEFragment", "班级德育", "德育/评价"),
    ("ClassesOverFragment", "班级评比", "德育/评价"),
    ("ClassInfoFragment", "班级信息", "班级/校园"),
    ("StudentCenter", "学生空间", "学生空间"),
    ("StudentProductionFragment", "学生作品", "学生空间"),
    ("StudentDutyFragment", "值日生", "值日/值周"),
    ("DutyFragment", "值周", "值日/值周"),
    ("AssignmentFragment", "作业", "作业/任务"),
    ("PunchThirdFragment", "第三方打卡", "考勤/打卡"),
    ("PunchFragment", "打卡", "考勤/打卡"),
    ("AttendanceFragment", "考勤", "考勤/打卡"),
    ("ClassScheduleFragment", "课表", "课表"),
    ("KBBJFragment", "班级课表", "课表"),
    ("KBCDFragment", "场地课表", "课表"),
    ("KBFragment", "课表", "课表"),
    ("UniversityTableFragment", "大学课表", "课表"),
    ("UniversityNextTableFragment", "大学课表", "课表"),
    ("UniversityDrakTableFragment", "大学课表", "课表"),
    ("NCalendarLFragment", "校历", "校历/日历"),
    ("UniversityDateFragment", "日期", "校历/日历"),
    ("TimerFragment", "倒计时", "倒计时/时钟"),
    ("TimeClockFragment", "时钟", "倒计时/时钟"),
    ("WeatherFragment", "天气", "天气/环境"),
    ("BannerImageFragment", "相册", "相册/视频"),
    ("VideoFragment", "视频", "相册/视频"),
    ("BookFragment", "图书", "图书/阅读"),
    ("BookYwFragment", "图书业务", "图书/阅读"),
    ("LibraryFragment", "图书馆", "图书/阅读"),
    ("ExamArrangement", "考试安排", "考试"),
    ("HomeReservationFragment", "场地预约", "会议/预约"),
    ("HomeReservation44Fragment", "场地预约", "会议/预约"),
    ("HomeReservation36Fragment", "场地预约", "会议/预约"),
    ("UniversityReservationFragment", "大学预约", "会议/预约"),
    ("UniversityNextReservationFragment", "大学预约", "会议/预约"),
    ("HomeVote23Fragment", "投票", "投票/问卷"),
    ("HomeCollectForm", "问卷", "投票/问卷"),
    ("ActiveApplyFragment", "活动报名", "活动"),
    ("DormitoryEducationFragment", "宿舍德育", "宿舍"),
    ("DormitoryFragment", "宿舍", "宿舍"),
    ("HomePatrolFragment", "巡课", "巡课"),
    ("SiteInfo46Fragment", "场地信息", "场地/走班"),
    ("SiteInfo68Fragment", "场地信息", "场地/走班"),
    ("SiteInfo66Fragment", "场地信息", "场地/走班"),
    ("SiteInfo86Fragment", "场地信息", "场地/走班"),
    ("SiteInfoFragment", "场地信息", "场地/走班"),
    ("UniversitySiteInfoFragment", "大学场地", "场地/走班"),
    ("ConsultFragment", "校园留言", "留言/咨询"),
    ("CartoonMenuFragment", "卡通菜单", "自定义"),
    ("CustomHomeFragment", "自定义首页", "自定义"),
    ("CustomBannerFragment", "自定义轮播", "自定义"),
    ("CustomRecyclerviewFragment", "自定义列表", "自定义"),
    ("CustomTextFragment", "自定义文本", "自定义"),
    ("CustomImageText", "自定义图文", "自定义"),
    ("CustomizedRecyclerviewFragment", "自定义列表", "自定义"),
    ("CustomizedTextFragment", "自定义文本", "自定义"),
    ("CustomVerifyFragment", "自定义验证", "自定义"),
    ("WebViewFragment", "自定义网页", "自定义"),
    ("AIFragmentFull", "AI 助手", "AI"),
    ("Wlkz2_2L", "物联网控制", "物联网"),
    ("UniversityMusicFragment", "校园音乐", "特色"),
    ("UniversityTrainingDeviceFragment", "实训设备", "特色"),
    ("UniversityInternetFragment", "网络服务", "特色"),
    ("HomeChemistryFragment", "化学", "学科/特色"),
    ("Ipad_10_Fragment", "iPad 布局", "特殊布局"),
    ("HomeRepair21Fragment", "报修", "报修"),
    ("HomeRepair22Fragment", "报修", "报修"),
]

CATEGORY_ORDER = [
    "消息公告", "班级/校园", "学生空间", "作业/任务", "相册/视频", "课表",
    "考勤/打卡", "值日/值周", "德育/评价", "场地/走班", "考试", "图书/阅读",
    "会议/预约", "投票/问卷", "活动", "宿舍", "巡课", "报修", "留言/咨询",
    "AI", "物联网", "校历/日历", "倒计时/时钟", "天气/环境", "自定义",
    "特色", "特殊布局", "学科/特色", "其他",
]


IMPORT_RE = re.compile(r"^import ([\w.$]+);", re.M)


def resolve_constants(imports: dict[str, str], names: set[str]) -> dict[str, int]:
    """Read compile-time constants of every class referenced by the switch."""
    targets = []
    for name in sorted(names):
        fqn = imports.get(name)
        if fqn:
            targets.append(fqn)
    if not JAVAP.exists() or not ORIGINAL_JAR.exists() or not targets:
        if not JAVAP.exists():
            print("warning: javap missing, named constants unresolved", file=sys.stderr)
        return {}
    proc = subprocess.run(
        [str(JAVAP), "-constants", "-cp", str(ORIGINAL_JAR), *targets],
        capture_output=True, text=True, encoding="utf-8", errors="replace",
    )
    table: dict[str, int] = {}
    headers = [
        (m.start(), m.group(1))
        for m in re.finditer(
            r"^(?:public |final |abstract |static |interface )*class ([\w.$]+)",
            proc.stdout, re.M,
        )
    ]
    for i, (pos, fqn) in enumerate(headers):
        end = headers[i + 1][0] if i + 1 < len(headers) else len(proc.stdout)
        section = proc.stdout[pos:end]
        simple = fqn.rsplit(".", 1)[-1]
        for m in re.finditer(r"static final (byte|short|int|long|char) ([A-Za-z_][A-Za-z0-9_]*) = (-?\d+);", section):
            value = int(m.group(3))
            table[f"{fqn}.{m.group(2)}"] = value
            table[f"{simple}.{m.group(2)}"] = value
    return table


def eval_b(expr: str, constants: dict[str, int]) -> int | None:
    expr = expr.strip()
    if re.fullmatch(r"-?\d+", expr):
        value = int(expr)
    else:
        value = constants.get(expr)
    if value is None:
        return None
    # byte constants are sign-extended by javap but the app compares them as
    # unsigned command codes (0..255); the fragment switch has no negative cases.
    if -128 <= value < 0:
        return value + 256
    return value


def case_value(label: str, constants: dict[str, int]) -> int | None:
    """Resolve a switch case label such as 'case 226:' or 'case Tbs... /* 227 */:'."""
    m = re.search(r"/\*\s*(\d+)\s*\*/", label)
    if m:
        return int(m.group(1))
    label = label.strip()
    if re.fullmatch(r"-?\d+", label):
        return int(label)
    return eval_b(label, constants)


def parse_home(path: Path) -> list[dict]:
    text = path.read_text(encoding="utf-8", errors="replace")
    imports = {fqn.rsplit(".", 1)[-1]: fqn for fqn in IMPORT_RE.findall(text)}

    # ---- 0. collect every symbolic constant used by the switch ----------
    names: set[str] = set()
    for m in re.finditer(r"\b([A-Z][\w$]*)\.([A-Za-z_][\w$]*)\b", text):
        names.add(m.group(1))
    constants = resolve_constants(imports, names)

    # ---- 1. tag -> case index -------------------------------------------
    tags: list[tuple[str, int | None]] = []
    for m in re.finditer(
        r'if \(str6\.equals\("([^"]+)"\)\) \{\s*b = ([^;]+);\s*\}',
        text,
    ):
        tag, rhs = m.group(1), m.group(2)
        tags.append((tag, eval_b(rhs, constants)))

    # ---- 2. case index -> fragment class --------------------------------
    fragment_by_case: dict[int, str] = {}
    start = text.find("switch (b) {", text.find("Fragment fragment("))
    if start < 0:
        raise SystemExit("cannot find the fragment switch")
    body = text[start:]
    pending: list[int] = []
    for line in body.splitlines():
        label = re.match(r"\s*case (.+?):\s*$", line)
        if label:
            value = case_value(label.group(1), constants)
            if value is not None:
                pending.append(value)
            continue
        ret = re.search(r"^\s*return (.+);", line)
        if ret:
            expr = ret.group(1).strip()
            frag = None
            m = re.match(r"new\s+([A-Za-z0-9_]+)\s*\(", expr)
            if m:
                frag = m.group(1)
            else:
                m = re.match(r"([A-Za-z0-9_]+)\.(?:INSTANCE|newInstance|newFragment|new)", expr)
                if m:
                    frag = m.group(1)
                elif "WebViewFragment" in expr:
                    frag = "WebViewFragment"
                elif "CustomBannerFragment" in expr:
                    frag = "CustomBannerFragment"
                elif "CustomRecyclerviewFragment" in expr:
                    frag = "CustomRecyclerviewFragment"
                elif "CustomTextFragment" in expr:
                    frag = "CustomTextFragment"
                elif "CustomImageText" in expr:
                    frag = "CustomImageText"
                elif "Customized" in expr:
                    frag = "CustomizedFragment"
            for c in pending:
                if c not in fragment_by_case:
                    # 128..159 share one giant custom/web block; every tag in
                    # that block is a web or custom-content card.
                    fragment_by_case[c] = "WebViewFragment" if 128 <= c <= 159 else (frag or "")
            pending = []

    components = []
    seen = set()
    for tag, case in tags:
        if tag in seen:
            continue
        seen.add(tag)
        fragment = fragment_by_case.get(case, "") if case is not None else ""
        size = tag_size(tag)
        name, category = component_name(tag, fragment)
        components.append({
            "tag": tag,
            "case": case,
            "fragment": fragment,
            "name": name,
            "category": category,
            "width": size[0],
            "height": size[1],
            "size": f"{size[0]}×{size[1]}" if size[0] else "?",
        })
    components.sort(key=lambda c: (CATEGORY_ORDER.index(c["category"]) if c["category"] in CATEGORY_ORDER else 99,
                                   c["name"], c["tag"]))
    return components


def tag_size(tag: str) -> tuple[int, int]:
    m = re.search(r"(\d+)\s*[xX]\s*(\d+)", tag)
    if m:
        return int(m.group(1)), int(m.group(2))
    # 3 trailing digits = width, height, variant (e.g. hbbjxc441 = 4x4 v1)
    m = re.search(r"(\d)(\d)(\d)$", tag)
    if m:
        return int(m.group(1)), int(m.group(2))
    m = re.search(r"(\d)(\d)$", tag)
    if m:
        return int(m.group(1)), int(m.group(2))
    return 0, 0


def component_name(tag: str, fragment: str) -> tuple[str, str]:
    best = None
    for prefix, name, category in FRAGMENT_NAMES:
        if fragment.startswith(prefix) and (best is None or len(prefix) > best[0]):
            best = (len(prefix), name, category)
    if best:
        return best[1], best[2]
    best = None
    for prefix in TAG_NAMES:
        if tag.startswith(prefix) and (best is None or len(prefix) > len(best)):
            best = prefix
    if best:
        return TAG_NAMES[best]
    return ("未分类组件", "其他")


def parse_manifest(path: Path) -> list[dict]:
    text = path.read_text(encoding="utf-8", errors="replace")
    features = []
    for m in re.finditer(r"<activity\b(.*?)(?:/>|</activity>)", text, re.S):
        block = m.group(1)
        name = re.search(r'android:name="([^"]+)"', block)
        if not name:
            continue
        cls = name.group(1)
        if not cls.startswith("com.yd.android_brand_mvp"):
            continue
        exported = 'android:exported="true"' in block
        launcher = "android.intent.action.MAIN" in block
        features.append({
            "name": cls,
            "short": cls.rsplit(".", 1)[-1],
            "package": cls.rsplit(".", 1)[0],
            "exported": exported or launcher,
            "launcher": launcher,
        })
    features.sort(key=lambda f: f["name"])
    return features


def parse_endpoints() -> list[dict]:
    sys.path.insert(0, str(ROOT))
    try:
        from scripts.endpoints.apis import all_endpoints
    except Exception as exc:  # pragma: no cover - optional
        print(f"warning: endpoint registry unavailable: {exc}", file=sys.stderr)
        return []
    out = []
    for ep in all_endpoints():
        out.append({
            "id": ep.id,
            "group": ep.id.split("-")[0],
            "method": ep.method,
            "path": ep.path,
            "description": ep.description,
            "source": ep.source,
            "base": ep.base or "",
            "auth": bool(ep.auth),
        })
    return out


def main() -> int:
    components = parse_home(HOME)
    activities = parse_manifest(MANIFEST)
    endpoints = parse_endpoints()
    payload = {
        "generatedFrom": "HomeFragment.java / AndroidManifest.xml / scripts/endpoints",
        "counts": {
            "components": len(components),
            "activities": len(activities),
            "endpoints": len(endpoints),
        },
        "categories": CATEGORY_ORDER,
        "components": components,
        "activities": activities,
        "endpoints": endpoints,
    }
    OUT.parent.mkdir(parents=True, exist_ok=True)
    OUT.write_text(json.dumps(payload, ensure_ascii=False, indent=1), encoding="utf-8")
    missing_frag = [c for c in components if not c["fragment"]]
    print(f"components={len(components)} unmapped={len(missing_frag)} "
          f"activities={len(activities)} endpoints={len(endpoints)} -> {OUT}")
    for c in components[:12]:
        print(" ", c["tag"], c["size"], c["fragment"], c["name"])
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
