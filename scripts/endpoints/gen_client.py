#!/usr/bin/env python3
"""Regenerate typed BrandClient methods and JSON TypedDict schemas.

Run from the repository root:

    python -m scripts.endpoints.gen_client
    python -m scripts.endpoints.gen_client --check

The endpoint registry in scripts/endpoints/apis/ is the single source of truth.
This script rewrites two generated areas:

* scripts/endpoints/schemas.py - one TypedDict per JSON body with known
  fields (including documented {} templates), so IDEs can complete
  client.some_method(body={...}).
* scripts/endpoints/client.py - method_index / method_names plus all endpoint
  methods, each with explicit keyword arguments and a docstring that lists
  every path/query/JSON/form/upload field.

Hand-written code in client.py (the constructor, call, forge and _invoke) lives
outside the generated markers and is never touched.
"""
from __future__ import annotations

import argparse
import keyword
import re
import sys
import textwrap
from dataclasses import dataclass
from pathlib import Path
from typing import Any, Dict, Iterable, List, Optional, Sequence, Tuple

from .apis import MODULES
from .common import Endpoint

HERE = Path(__file__).resolve().parent
CLIENT_PATH = HERE / "client.py"
SCHEMA_PATH = HERE / "schemas.py"

PLACEHOLDER = re.compile(r"\{([a-zA-Z_][\w]*)\}")

# Endpoints in these groups have no useful Retrofit method name (their source
# is a class name), so the method name is derived from the URL path instead.
PATH_NAMED_GROUPS = {"ttlock", "face", "external"}

# Context keys that ApiClient fills automatically: credentials, device
# identifiers, /brand/obtain results, the OAuth token and the TTLock token.
AUTO_PLACEHOLDER_NOTES = {
    "timestamp_ms": "发送前自动填当前毫秒时间戳",
    "random": "自动生成 16 位随机串",
    "mac": "取 --mac / YIDE_MAC / adb",
    "android_id": "取 --android-id / YIDE_ANDROID_ID / adb",
    "username": "取登录账号凭据",
    "password": "取登录密码凭据",
    "client_id": "取 OAuth 配置",
    "client_secret": "取 OAuth 配置",
    "brand_id": "/brand/obtain 后写入 context",
    "classes_id": "/brand/obtain 后写入 context",
    "site_id": "/brand/obtain 后写入 context",
    "school_id": "取学校配置或 /brand/obtain",
    "student_id": "自动发现或由参数写入 context",
    "student_name": "自动发现学生后写入 context",
    "ttlock_access_token": "TTLock 自动登录后写入 context",
    "ttlock_client_id": "取 TTLock 凭据",
}

EXAMPLE_AUTO_KEYS = {
    "brand_id", "classes_id", "school_id", "site_id",
    "student_id", "student_name", "mac", "android_id",
}

AUTO_CONTEXT = {
    "username", "password", "client_id", "client_secret",
    "mac", "android_id", "school_id", "device_type",
    "random", "access_token", "refresh_token",
    "brand_id", "brand_name", "classes_id", "site_id",
    "student_id", "student_name", "obtain",
    "ttlock_username", "ttlock_password", "ttlock_client_id",
    "ttlock_client_secret", "ttlock_access_token",
    "ttlock_password_md5", "timestamp_ms",
}

# Fields documented in ENDPOINTS.md but missing from the endpoint template
# (the decompiled client builds those request bodies dynamically).  They are
# exposed as optional typed fields; passing one adds it to the JSON body,
# while leaving it out keeps the original "{}" request unchanged.
KNOWN_BODY_FIELDS: Dict[str, Dict[str, Any]] = {
    "home-002": {"classesId": "{classes_id}", "kind": "1", "type": "2"},
    "home-003": {"classesId": "{classes_id}", "kind": "1", "type": "1", "limitNum": 10},
    "home-004": {"classesId": "{classes_id}", "kind": "1", "type": "1"},
    "home-008": {"workId": "{work_id}", "content": ""},
    "home-011": {"classesId": "{classes_id}"},
    "honor-001": {"medalCode": "{medal_code}"},
    "honor-006": {"personId": "{student_id}"},
    "honor-007": {"pageNo": 1, "pageSize": 20},
    "honor-008": {"pageNo": 1, "pageSize": 20, "personId": "{student_id}"},
    "honor-010": {"activityId": "{activity_id}"},
    "honor-012": {"personId": "{student_id}", "identity": 0},
    "honor-013": {"pageNo": 1, "pageSize": 20},
    "honor-016": {"activityId": "{activity_id}"},
    "honor-020": {"pageNo": 1, "pageSize": 20, "classesId": "{classes_id}"},
    "honor-021": {"pageNo": 1, "pageSize": 20, "studentId": "{student_id}"},
    "library-006": {
        "pageNo": 1,
        "pageSize": 20,
        "libraryId": "{library_id}",
        "fullText": "",
        "type": "",
        "title": "",
        "firstAuthor": "",
        "publisherName": "",
        "startPublication": "",
        "endPublication": "",
        "order": "",
    },
    "library-007": {"id": "{book_id}"},
}

# Chinese descriptions for every field name used by the registry.  The
# generator asserts that the inventory is complete, so adding a new field to
# apis/*.py produces a clear error instead of a silent TODO comment.
PARAM_DOCS: Dict[str, str] = {
    "To_Account": "腾讯云 IM 目标账号（学生 userId）",
    "accessToken": "TTLock access_token；首次调用会自动登录并填入",
    "activityId": "活动 ID",
    "activityName": "活动名称（模糊筛选）",
    "activitySubIds": "活动子项 ID 列表",
    "anonymity": "是否匿名提交",
    "apkVersion": "APK 版本号，如 3.0.14",
    "approverId": "审批人/接收人 ID；公告接口传班牌 brandId",
    "apprs": "审批人列表（流程节点）",
    "assignee": "当前处理人 ID（通常为学生 ID）",
    "assigneeId": "审批人/办理人 ID",
    "assigneeName": "审批人/办理人姓名",
    "assistantId": "AI 助手 ID",
    "attendanceId": "考勤活动 ID",
    "attendanceIds": "考勤活动 ID 列表",
    "attendanceTimeId": "考勤时段 ID",
    "attendanceTimeIds": "考勤时段 ID 列表",
    "bjid": "班级 ID（服务端历史参数名）",
    "brandClassLoginName": "班牌登录账号",
    "brandId": "班牌/品牌 ID（/brand/obtain 返回的 id）",
    "brandStudentInfo": "班牌学生信息（JSON 字符串）",
    "businessId": "业务 ID（巡课任务 ID）",
    "ccIds": "抄送人 ID，逗号分隔",
    "childrenId": "学生（儿童）ID",
    "city": "城市名（中文），如 重庆",
    "classId": "班级 ID",
    "classesId": "班级 ID",
    "clientId": "TTLock 客户端 ID（自动填入）",
    "client_id": "OAuth 客户端 ID（默认 yide-cloud）",
    "client_secret": "OAuth 客户端密钥",
    "components": "问卷组件作答列表",
    "content": "意见/评论内容",
    "contenttype": "IM 请求内容类型，固定 json",
    "ctrlNo": "图书控制号/资产编号",
    "date": "毫秒时间戳；TTLock 接口自动填当前时间",
    "days": "榜单统计天数",
    "dept": "部门 ID",
    "deptName": "部门/班级名称",
    "deviceId": "设备 ID（消息字幕接口使用）",
    "deviceName": "设备名称，如 班牌",
    "deviceNo": "设备 MAC（12 位，去冒号、小写）",
    "deviceType": "设备类型；班牌固定 '2'",
    "direction": "方向；班牌登录固定 '0'",
    "durationType": "请假时长类型（服务端枚举，不同学校取值不同）",
    "durationWay": "请假时长计算方式（服务端枚举）",
    "employeeId": "教师/员工 ID",
    "endDate": "结束日期，yyyy-MM-dd",
    "endTime": "结束时间，yyyy-MM-dd HH:mm:ss",
    "equipmentSerialNumber": "设备序列号；班牌用 Android ID",
    "examEndTime": "考试结束时间，yyyy-MM-dd HH:mm:ss",
    "examStartTime": "考试开始时间，yyyy-MM-dd HH:mm:ss",
    "examinationId": "考试 ID",
    "file": "上传文件的本地路径（multipart）",
    "fingerprint": "指纹数据（base64）",
    "fingerprintId": "指纹记录 ID",
    "firmwareInfo": "固件信息（JSON）",
    "firmwareRevision": "固件版本",
    "flag": "榜单标记（1）",
    "flowElementList": "审批流节点列表",
    "formItems": "动态表单作答（JSON 字符串）",
    "formJson": "表单内容（JSON 字符串）",
    "formKey": "表单模板 key，如 teacherDeviceRepair",
    "fromComponent": "表单组件数据（JSON 字符串）",
    "fromKey": "流程表单标识，如 studentLeave_{schoolId}",
    "gatewayId": "网关 ID",
    "gatewayNetMac": "网关 MAC",
    "grant_type": "授权类型：brand（班牌）/ password（TTLock）",
    "hardwareRevision": "硬件版本",
    "icCardNo": "IC 卡号",
    "id": "记录 ID；含义随接口（设备/场地/作品/表单/锁等）",
    "identifier": "标识；公告接口固定 announcement，IM 接口为用户 ID",
    "identifyType": "身份类型：0 学生 / 1 教师（活动接口用 0）",
    "identity": "身份类型：0 学生 / 1 教师（不同接口可能相反）",
    "identityCard": "IC 卡号（TTLock）",
    "identityCardId": "IC 卡记录 ID",
    "identityUserId": "身份用户 ID（学生/教师 ID）",
    "isBack": "是否退回",
    "isBrandStudent": "是否班牌学生",
    "isHave": "是否包含已参与",
    "jsonData": "流程业务数据（JSON 字符串）",
    "key": "查询键；班级学生列表固定 classes",
    "keyboardPwd": "键盘密码",
    "kind": "类型；相册接口 1=班级相册",
    "language": "语言，如 zh",
    "libraryId": "图书馆 ID",
    "limit": "返回条数上限",
    "limitNum": "返回条数上限",
    "list": "人脸同步状态列表",
    "lockAlias": "锁别名",
    "lockData": "锁数据（初始化时由锁读取）",
    "lockId": "锁 ID",
    "loginName": "登录账号",
    "modelNum": "设备型号",
    "name": "指纹/卡/键盘名称",
    "nbCardNumber": "NB 卡号",
    "nbNodeId": "NB 节点 ID",
    "nbOperator": "NB 运营商",
    "nbRssi": "NB 信号强度",
    "networkName": "Wi-Fi 名称",
    "no": "设备 MAC（12 位，去冒号、小写）",
    "pageNo": "页码，从 1 开始",
    "pageSize": "每页条数；服务端混用 str/int，按模板类型传",
    "password": "密码；登录接口为账号密码，门禁接口为门禁密码",
    "patrolType": "巡课类型",
    "personId": "人员 ID（学生/教师）",
    "procId": "流程定义 ID",
    "processInstanceId": "流程实例 ID",
    "prompt": "用户提问内容",
    "pwdInfo": "键盘密码信息（云端生成）",
    "queryNewStatus": "是否只查新状态",
    "random": "16 位随机串，自动生成",
    "records": "锁记录列表（JSON）",
    "redirect_uri": "OAuth 回调地址，固定 http://www.1yide.com/",
    "registrationCode": "设备注册码",
    "schoolId": "学校 ID",
    "sdkappid": "腾讯云 IM SDKAppID",
    "seriaNo": "/brand/obtain 的设备序列号，传 Android ID",
    "sessionId": "AI 会话 ID",
    "shcoolId": "学校 ID（服务端历史拼写，等同于 schoolId）",
    "showAll": "是否显示全部",
    "showType": "显示类型（首页布局固定 0）",
    "signInImg": "签到照片 URL/Base64，可为空",
    "signInTime": "签到时间，yyyy-MM-dd HH:mm:ss",
    "siteBookingId": "场地预约记录 ID",
    "siteBookingIds": "场地预约记录 ID 列表",
    "siteId": "场地 ID",
    "siteName": "场地名称",
    "siteTimetableId": "场地课表 ID，可为空",
    "skzc": "上课周次",
    "sponsorType": "发起人类型（0/1）",
    "startDate": "开始日期，yyyy-MM-dd",
    "startTime": "开始时间，yyyy-MM-dd HH:mm:ss",
    "status": "状态筛选；取值随接口（如 not_start/0/1）",
    "studentId": "学生 ID",
    "subjectId": "科目 ID",
    "teacherId": "教师 ID",
    "timestamp": "毫秒时间戳（密码重置用）",
    "timetableId": "课表 ID",
    "timetableIds": "课表 ID 列表",
    "topType": "榜单类型",
    "type": "类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）",
    "typeId": "课表类型 ID；通常传班级 ID",
    "userId": "用户 ID；学生或教师，随接口",
    "userName": "用户姓名",
    "username": "登录账号",
    "usersig": "腾讯云 IM UserSig（管理员签名）",
    "version": "版本号，如 3.0.14",
    "versionType": "版本类型（2）",
    "voteDetails": "投票选项列表",
    "voteId": "投票 ID",
    "weekTime": "课表周次/日期；空字符串表示本周",
    "wlanMac": "无线 MAC，通常留空",
    "workId": "学生作品 ID",
    "medalCode": "勋章编码",
    "fullText": "全文检索关键词",
    "title": "书名",
    "firstAuthor": "第一作者",
    "publisherName": "出版社",
    "startPublication": "出版起始日期",
    "endPublication": "出版结束日期",
    "order": "排序方式",
}

# A few names mean different things on different endpoints.  Keep the
# endpoint-specific wording here rather than making the generic text vague.
PARAM_DOC_OVERRIDES: Dict[Tuple[str, str], str] = {
    ("vote-001", "id"): "问卷/收集表 ID",
    ("vote-002", "id"): "问卷/收集表 ID",
    ("vote-004", "id"): "问卷/收集表 ID",
    ("ai-001", "id"): "AI 助手 ID",
    ("card-001", "password"): "门禁密码（不是登录密码）",
    ("card-002", "userId"): "学生 ID",
    ("card-002", "type"): "用户类型（学生固定 1）",
    ("card-003", "type"): "用户类型（学生固定 1）",
    ("library-007", "id"): "图书 ID",
    ("messages-007", "deviceId"): "设备 ID",
    ("messages-008", "deviceId"): "设备 ID",
}

KIND_TITLES = {
    "path": "路径参数（URL Path）",
    "query": "Query 参数",
    "body": "JSON 请求体（application/json）",
    "form": "Form 请求体（application/x-www-form-urlencoded）",
    "files": "上传文件（multipart/form-data）",
}

MARKERS = {
    "imports": ("# <generated: schema imports>", "# </generated: schema imports>"),
    "index": ("    # <generated: index>", "    # </generated: index>"),
    "methods": ("    # <generated: methods>", "    # </generated: methods>"),
}


@dataclass(frozen=True)
class Field:
    name: str
    kind: str
    annotation: str
    td_type: str
    default: Any
    default_text: str
    required: bool
    auto: bool
    placeholders: Tuple[str, ...]
    doc: str
    template: Any
    synthetic: bool = False


@dataclass(frozen=True)
class BodyInfo:
    endpoint: Endpoint
    kind: str  # typed | empty | list | list_item
    annotation: str
    class_name: str = ""
    item_name: str = ""
    fields: Tuple[Field, ...] = ()
    synthetic: bool = False


# --------------------------------------------------------------------- names
def _snake(name: str) -> str:
    value = re.sub(r"(?<!^)(?=[A-Z])", "_", name)
    return re.sub(r"[^0-9a-zA-Z_]+", "_", value).strip("_").lower()


def _path_slug(path: str) -> str:
    return re.sub(r"[^0-9a-zA-Z]+", "_", path.lower()).strip("_")


def _pascal(name: str) -> str:
    parts = [part for part in re.split(r"[^0-9a-zA-Z]+", name) if part]
    return "".join(part[:1].upper() + part[1:] for part in parts)


def build_method_names(groups: Sequence[Tuple[str, List[Endpoint]]]) -> Dict[str, str]:
    """Reproduce the historical method naming scheme exactly."""
    names: Dict[str, str] = {}
    counts: Dict[str, int] = {}
    for group, endpoints in groups:
        for ep in endpoints:
            if group in PATH_NAMED_GROUPS:
                base = f"{group}_{_path_slug(ep.path)}"
            else:
                base = f"{group}_{_snake(ep.source)}"
            counts[base] = counts.get(base, 0) + 1
            names[ep.id] = base if counts[base] == 1 else f"{base}_{counts[base]}"
    return names


def _body_class(method_name: str) -> str:
    return _pascal(method_name) + "Body"


def _item_class(method_name: str) -> str:
    return _pascal(method_name) + "Item"


# -------------------------------------------------------------------- values
def _placeholders(value: Any) -> Tuple[str, ...]:
    found: List[str] = []

    def walk(item: Any) -> None:
        if isinstance(item, str):
            found.extend(PLACEHOLDER.findall(item))
        elif isinstance(item, dict):
            for val in item.values():
                walk(val)
        elif isinstance(item, (list, tuple)):
            for val in item:
                walk(val)

    walk(value)
    return tuple(dict.fromkeys(found))


def _type_name(value: Any) -> str:
    if isinstance(value, bool):
        return "bool"
    if isinstance(value, int):
        return "int"
    if isinstance(value, float):
        return "float"
    if isinstance(value, str):
        return "str"
    if isinstance(value, list):
        if not value:
            return "List[Any]"
        if all(isinstance(item, str) for item in value):
            return "List[str]"
        if all(isinstance(item, int) and not isinstance(item, bool) for item in value):
            return "List[int]"
        if all(isinstance(item, dict) for item in value):
            return "List[Dict[str, Any]]"
        return "List[Any]"
    if isinstance(value, dict):
        return "Dict[str, Any]"
    return "Any"


def _default_text(value: Any) -> str:
    if value == "":
        return "空字符串"
    if isinstance(value, str):
        return f'"{value}"'
    if isinstance(value, (bool, int, float)):
        return repr(value)
    if isinstance(value, list):
        return "[]" if not value else repr(value)
    if isinstance(value, dict):
        return "{}" if not value else "JSON 对象"
    return repr(value)


def _make_field(endpoint_id: str, name: str, kind: str, value: Any, synthetic: bool = False) -> Field:
    placeholders = _placeholders(value)
    manual = [p for p in placeholders if p not in AUTO_CONTEXT]
    auto = [p for p in placeholders if p in AUTO_CONTEXT]
    required = kind == "path" or bool(manual)
    td_type = _type_name(value)
    doc = PARAM_DOC_OVERRIDES.get((endpoint_id, name)) or PARAM_DOCS.get(name)
    if not doc:
        raise SystemExit(f"missing PARAM_DOCS entry for {name!r} ({endpoint_id})")
    if placeholders:
        annotation = td_type + " | None"
        default: Any = None
        default_text = ""
    else:
        default_text = _default_text(value)
        if synthetic:
            # Documented example value, not a template default: only send it
            # when the caller explicitly passes the field.
            annotation = td_type + " | None"
            default = None
        elif isinstance(value, (str, bool, int, float)):
            annotation = td_type
            default = value
        else:
            annotation = td_type + " | None"
            default = None
    return Field(
        name=name,
        kind=kind,
        annotation=annotation,
        td_type=td_type,
        default=default,
        default_text=default_text,
        required=required,
        auto=bool(auto) and not manual,
        placeholders=placeholders,
        doc=doc.rstrip("。"),
        template=value,
        synthetic=synthetic,
    )


def _collect_fields(ep: Endpoint) -> List[Field]:
    fields: List[Field] = []
    seen = set()
    path_keys = PLACEHOLDER.findall(ep.path)

    def add(name: str, kind: str, value: Any, synthetic: bool = False) -> None:
        if name in seen:
            return
        if not name.isidentifier() or keyword.iskeyword(name):
            raise SystemExit(f"field {name!r} ({ep.id}) is not a Python identifier")
        if name in {"self", "body", "full", "extra"}:
            raise SystemExit(f"field {name!r} ({ep.id}) collides with a method parameter")
        seen.add(name)
        fields.append(_make_field(ep.id, name, kind, value, synthetic=synthetic))

    for name in path_keys:
        value = ep.params.get(name)
        if value is None:
            value = "{" + name + "}"
        add(name, "path", value)
    for name, value in ep.params.items():
        if name not in path_keys:
            add(name, "query", value)
    if isinstance(ep.json_body, dict):
        synthetic = not ep.json_body and ep.id in KNOWN_BODY_FIELDS
        body_fields = ep.json_body or KNOWN_BODY_FIELDS.get(ep.id, {})
        for name, value in body_fields.items():
            add(name, "body", value, synthetic=synthetic)
    for name, value in (ep.form_body or {}).items():
        add(name, "form", value)
    for name, value in (ep.files or {}).items():
        add(name, "files", value)
    return fields


def _collect_body_fields(ep: Endpoint, body: Dict[str, Any], synthetic: bool = False) -> List[Field]:
    return [
        _make_field(ep.id, name, "body", value, synthetic=synthetic)
        for name, value in body.items()
    ]


def _body_info(ep: Endpoint, method_name: str) -> Optional[BodyInfo]:
    body = ep.json_body
    if body is None:
        return None
    if isinstance(body, list):
        item_fields = _collect_body_fields(
            ep, body[0] if body and isinstance(body[0], dict) else {}
        )
        return BodyInfo(
            endpoint=ep,
            kind="list",
            annotation=_body_class(method_name),
            class_name=_body_class(method_name),
            item_name=_item_class(method_name),
            fields=tuple(item_fields),
        )
    if not body:
        known = KNOWN_BODY_FIELDS.get(ep.id)
        if known:
            return BodyInfo(
                endpoint=ep,
                kind="typed",
                annotation=_body_class(method_name),
                class_name=_body_class(method_name),
                fields=tuple(_collect_body_fields(ep, known, synthetic=True)),
                synthetic=True,
            )
        return BodyInfo(endpoint=ep, kind="empty", annotation="Dict[str, Any]")
    return BodyInfo(
        endpoint=ep,
        kind="typed",
        annotation=_body_class(method_name),
        class_name=_body_class(method_name),
        fields=tuple(_collect_body_fields(ep, body)),
    )


# --------------------------------------------------------------- formatting
def _wrap(text: str, indent: str, width: int = 86) -> List[str]:
    lines = textwrap.wrap(
        text,
        width=max(40, width - len(indent)),
        break_long_words=False,
        break_on_hyphens=False,
    )
    return [indent + line for line in lines] or [indent]


def _placeholder_note(field: Field) -> str:
    manual = [p for p in field.placeholders if p not in AUTO_CONTEXT]
    auto = [p for p in field.placeholders if p in AUTO_CONTEXT]
    parts: List[str] = []
    if manual:
        names = "、".join("{" + p + "}" for p in manual)
        keys = "、".join(f"context['{p}']" for p in manual)
        parts.append(f"占位符 {names} 需传参或写入 {keys}")
    if auto:
        names = "、".join("{" + p + "}" for p in auto)
        notes = "；".join(
            AUTO_PLACEHOLDER_NOTES.get(p, f"自动从 context['{p}'] 读取")
            for p in auto
        )
        parts.append(f"占位符 {names} {notes}")
    return "；".join(parts)


def _label(field: Field) -> str:
    if field.kind == "path":
        return "必填，路径参数"
    if field.required:
        return "必填"
    if field.auto:
        return "自动"
    if field.synthetic:
        return f"可选，示例 {field.default_text}"
    return f"可选，默认 {field.default_text}"


def _doc_field(lines: List[str], field: Field, indent: str = "            ") -> None:
    lines.append(f"{indent}{field.name}: {field.annotation}（{_label(field)}）")
    note = field.doc
    placeholders = _placeholder_note(field)
    if placeholders:
        note = note + "；" + placeholders
    lines.extend(_wrap(note, indent + "    "))


def _section(lines: List[str], title: str, fields: Iterable[Field]) -> None:
    fields = list(fields)
    if not fields:
        return
    lines.append("")
    lines.append(f"        {title}：")
    for field in fields:
        _doc_field(lines, field)


def _example(ep: Endpoint, method_name: str, fields: Sequence[Field], body: Optional[BodyInfo]) -> str:
    if method_name == "auth_new_login":
        return f"client.{method_name}()"
    chosen: List[Field] = []
    for field in [f for f in fields if f.required]:
        if len(chosen) >= 2:
            break
        chosen.append(field)
    if not chosen:
        for field in [
            f for f in fields
            if f.auto
            and isinstance(f.template, str)
            and f.template == "{" + f.placeholders[0] + "}"
            and f.placeholders[0] in EXAMPLE_AUTO_KEYS
        ]:
            if len(chosen) >= 2:
                break
            chosen.append(field)
    args: List[str] = []
    for field in chosen:
        if field.kind == "files":
            args.append(f'{field.name}="<本地文件路径>"')
        elif field.placeholders:
            manual_ph = [p for p in field.placeholders if p not in AUTO_CONTEXT]
            auto_ph = [p for p in field.placeholders if p in AUTO_CONTEXT]
            if manual_ph:
                args.append(f'{field.name}="<{manual_ph[0]}>"')
            else:
                args.append(f'{field.name}=client.context["{auto_ph[0]}"]')
    if not args and body is not None and body.kind == "list":
        args.append("body=[...]")
    if not args:
        return f"client.{method_name}()"
    one_line = f"client.{method_name}(" + ", ".join(args) + ")"
    if len(one_line) <= 96:
        return one_line
    inner = ",\n".join("    " + arg for arg in args)
    return f"client.{method_name}(\n{inner}\n)"


def _render_docstring(
    ep: Endpoint,
    method_name: str,
    group_title: str,
    fields: Sequence[Field],
    body: Optional[BodyInfo],
) -> List[str]:
    generic = ep.description == f"{group_title} / {ep.source}"
    summary = ep.source if generic else ep.description
    header = f"{group_title} · {summary}" if summary else group_title
    lines = ['        """' + header, ""]
    lines.append(f"        接口：{ep.method} {ep.path}（{ep.id}）")
    lines.append(f"        源码方法：{ep.source}")

    if ep.client == "ttlock":
        auth_note = "TTLock form 参数（clientId/accessToken/date），不使用 Bearer"
    elif ep.auth:
        auth_note = "需要 Bearer token（BrandClient 登录后自动注入）"
    else:
        auth_note = "无需 Bearer token"
    lines.append(f"        鉴权：{auth_note}")

    if ep.client == "ttlock" and ep.path != "/oauth2/token":
        lines.append("        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。")
    if ep.stream:
        lines.append("        说明：SSE 流式响应，返回 requests.Response，用 iter_lines() 读取。")
    if not ep.executable:
        lines.append("        注意：源码需要额外签名/UserSig，runner 默认不执行，仅用于预览或伪造。")

    summary_fields = list(fields)
    if body is not None and body.kind == "list":
        summary_fields.extend(body.fields)
    required_names = [field.name for field in summary_fields if field.required]
    auto_names = [field.name for field in summary_fields if field.auto and not field.required]
    if required_names:
        lines.extend(_wrap("必填：" + "、".join(required_names), "        "))
    else:
        lines.append("        必填：无")
    if auto_names:
        lines.extend(_wrap("自动：" + "、".join(auto_names), "        "))

    by_kind: Dict[str, List[Field]] = {kind: [] for kind in KIND_TITLES}
    for field in fields:
        by_kind[field.kind].append(field)
    for kind in ("path", "query", "body", "form", "files"):
        _section(lines, KIND_TITLES[kind], by_kind[kind])

    if body is not None:
        if body.kind == "empty":
            lines.append("")
            lines.append("        JSON 请求体：")
            lines.extend(_wrap(
                "模板为 {}，反编译源码中由 RequestBody 动态组装。"
                "可用 body={...} 传入完整 JSON，或用 **extra 追加字段。",
                "            ",
            ))
        elif body.kind == "list":
            lines.append("")
            lines.append("        JSON 请求体：")
            lines.extend(_wrap(
                "模板是列表，请用 body=[...] 一次传入完整列表。",
                "            ",
            ))
        lines.append(f"            body: {body.annotation} | None")
        lines.extend(_wrap(
            "完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。"
            if body.kind == "typed" else
            ("完整 JSON 请求体；覆盖模板中的 {}。" if body.kind == "empty" else
             "完整列表请求体。"),
            "                ",
        ))
        if body.synthetic:
            lines.extend(_wrap(
                "模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。",
                "                ",
            ))
        if body.kind == "list" and body.fields:
            lines.append("")
            lines.append("            列表元素字段：")
            for field in body.fields:
                _doc_field(lines, field, indent="                ")

    lines.append("")
    lines.append("        其它参数：")
    lines.append('            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；')
    lines.append("                默认只返回 data 字段。")
    lines.append("            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；")
    lines.append("                也兼容 params/json_body/form_body/files 覆盖。")

    lines.append("")
    lines.append("        返回：")
    if ep.stream:
        lines.append("            requests.Response（SSE 流），用 iter_lines() 逐行读取。")
    else:
        lines.append("            data 字段（dict/list/str/None）；失败抛 ApiError。")

    lines.append("")
    lines.append("        示例：")
    example = _example(ep, method_name, fields, body)
    for line in example.splitlines():
        lines.append("            " + line)
    lines.append('        """')
    return lines


def _render_signature(
    method_name: str,
    fields: Sequence[Field],
    body: Optional[BodyInfo],
) -> List[str]:
    params = ["self", "*"]
    for field in fields:
        if field.default is None:
            params.append(f"{field.name}: {field.annotation} = None")
        else:
            params.append(f"{field.name}: {field.annotation} = {field.default!r}")
    if body is not None:
        params.append(f"body: {body.annotation} | None = None")
    params.append("full: bool = False")
    params.append("**extra: Any")

    one_line = f"    def {method_name}(" + ", ".join(params) + ") -> Any:"
    if len(one_line) <= 110:
        return [one_line]
    lines = [f"    def {method_name}("]
    lines.extend(f"        {param}," for param in params)
    lines.append("    ) -> Any:")
    return lines


def _render_invoke(
    endpoint_id: str,
    fields: Sequence[Field],
    body: Optional[BodyInfo],
) -> List[str]:
    lines = ["        return self._invoke(", f'            "{endpoint_id}",']
    if not fields:
        lines.append("            fields={},")
    elif len(fields) <= 2:
        pairs = ", ".join(f'"{field.name}": {field.name}' for field in fields)
        lines.append("            fields={" + pairs + "},")
    else:
        lines.append("            fields={")
        lines.extend(f'                "{field.name}": {field.name},' for field in fields)
        lines.append("            },")
    if body is not None:
        lines.append("            body=body,")
    lines.append("            extra=extra,")
    lines.append("            full=full,")
    lines.append("        )")
    return lines


def _render_method(
    ep: Endpoint,
    method_name: str,
    group_title: str,
    fields: Sequence[Field],
    body: Optional[BodyInfo],
) -> str:
    lines = _render_signature(method_name, fields, body)
    lines.extend(_render_docstring(ep, method_name, group_title, fields, body))
    lines.extend(_render_invoke(ep.id, fields, body))
    return "\n".join(lines)


# ------------------------------------------------------------------- blocks
def _render_imports(body_infos: Sequence[BodyInfo]) -> str:
    names: List[str] = ["SYNTHETIC_FIELDS"]
    for body in body_infos:
        if body.kind == "typed":
            names.append(body.class_name)
        elif body.kind == "list":
            names.extend([body.item_name, body.class_name])
    names = list(dict.fromkeys(names))
    lines: List[str] = []
    current = "    "
    for name in names:
        addition = name + ", "
        if len(current) + len(addition) > 96:
            lines.append(current.rstrip())
            current = "    "
        current += addition
    if current.strip():
        lines.append(current.rstrip())
    return "from .schemas import (\n" + "\n".join(lines) + "\n)\n"


def _render_index(
    groups: Sequence[Tuple[str, List[Endpoint]]],
    method_names: Dict[str, str],
) -> str:
    lines = ["    endpoint_ids = ["]
    ids = [ep.id for _, endpoints in groups for ep in endpoints]
    for start in range(0, len(ids), 4):
        chunk = ", ".join(f'"{item}"' for item in ids[start:start + 4])
        lines.append(f"        {chunk},")
    lines.append("    ]")
    lines.append("")
    lines.append("    method_index = {")
    for ep_id, name in method_names.items():
        lines.append(f'        "{name}": "{ep_id}",')
    lines.append("    }")
    lines.append("")
    lines.append("    method_names = list(method_index)")
    return "\n".join(lines) + "\n"


def _render_methods(
    groups: Sequence[Tuple[str, List[Endpoint]]],
    method_names: Dict[str, str],
) -> str:
    chunks: List[str] = []
    for group, endpoints in groups:
        title = next((m.TITLE for m in MODULES if m.GROUP == group), group)
        for ep in endpoints:
            fields = _collect_fields(ep)
            body = _body_info(ep, method_names[ep.id])
            chunks.append(_render_method(ep, method_names[ep.id], title, fields, body))
    return "\n\n".join(chunks) + "\n"


def _render_typed_dict(body: BodyInfo, method_name: str) -> List[str]:
    ep = body.endpoint
    class_name = body.class_name
    subject = "列表元素" if body.kind == "list_item" else "JSON 请求体"
    lines = [f"class {class_name}(TypedDict, total=False):"]
    required = [field.name for field in body.fields if field.required]
    first = f"{ep.method} {ep.path} 的 {subject}（TypedDict，total=False）。"
    wrapped_first = _wrap(first, "    ")
    lines.append('    """' + wrapped_first[0].strip())
    lines.extend(wrapped_first[1:])
    lines.append("")
    if required:
        lines.extend(_wrap(
            "必填字段：" + "、".join(required) + "；其余字段可选。",
            "    ",
        ))
    elif any(field.auto for field in body.fields):
        lines.extend(_wrap(
            "没有必须手填的字段；标为‘自动’的字段由 BrandClient context 提供。",
            "    ",
        ))
    else:
        lines.extend(_wrap("该模板没有必填字段；所有字段都可以省略。", "    "))
    if body.synthetic:
        lines.append("")
        lines.extend(_wrap(
            "字段来自接口文档示例；模板请求体为 {}，只有传参时才会加入。",
            "    ",
        ))
    lines.append("")
    lines.extend(_wrap(f"字段说明见 BrandClient.{method_name}。", "    "))
    lines.append('    """')
    lines.append("")
    if not body.fields:
        lines.append("    pass")
        return lines
    for field in body.fields:
        label = _label(field)
        note = field.doc
        if field.placeholders:
            manual = [p for p in field.placeholders if p not in AUTO_CONTEXT]
            auto = [p for p in field.placeholders if p in AUTO_CONTEXT]
            extra: List[str] = []
            if manual:
                extra.append("占位符 " + "、".join("{" + p + "}" for p in manual))
            if auto:
                notes = "；".join(
                    AUTO_PLACEHOLDER_NOTES.get(p, "自动填充") for p in auto
                )
                extra.append(
                    "占位符 " + "、".join("{" + p + "}" for p in auto) + " " + notes
                )
            note = note + "；" + "；".join(extra)
        lines.append(f"    {field.name}: {field.td_type}  # {label}；{note}")
    return lines


def _render_schema(body_infos: Sequence[BodyInfo], method_names: Dict[str, str]) -> str:
    header = "\n".join([
        '"""Typed JSON request bodies for BrandClient.',
        "",
        "Generated by python -m scripts.endpoints.gen_client; do not edit by hand.",
        "",
        "Every JSON body with known fields has a TypedDict (total=False), so",
        "IDEs can complete field names when calling method(body={...}).",
        "Required fields are listed in the class docstring; omitted optional",
        "fields keep the endpoint template defaults.  SYNTHETIC_FIELDS records",
        "documented fields that are missing from an empty {} template.",
        "",
        "Example:",
        "",
        "    from scripts.endpoints.schemas import SchoolGetNewLayoutListBody",
        '    body: SchoolGetNewLayoutListBody = {"id": client.context["brand_id"]}',
        '"""',
        "",
        "from __future__ import annotations",
        "",
        "from typing import Any, Dict, List, TypedDict",
    ])
    exported: List[str] = []
    blocks: List[str] = []
    for body in body_infos:
        if body.kind == "typed":
            exported.append(body.class_name)
            blocks.append("\n".join(_render_typed_dict(body, method_names[body.endpoint.id])))
        elif body.kind == "list":
            exported.extend([body.item_name, body.class_name])
            item_body = BodyInfo(
                endpoint=body.endpoint,
                kind="list_item",
                annotation=body.item_name,
                class_name=body.item_name,
                fields=body.fields,
            )
            item_block = "\n".join(_render_typed_dict(item_body, method_names[body.endpoint.id]))
            alias = f"{body.class_name} = List[{body.item_name}]"
            blocks.append(item_block + "\n\n" + alias)
    exported.append("BODY_TYPES")
    exported.append("SYNTHETIC_FIELDS")
    synthetic_lines: List[str] = []
    for body in body_infos:
        if not body.synthetic:
            continue
        known = KNOWN_BODY_FIELDS[body.endpoint.id]
        if len(known) <= 3:
            pairs = ", ".join(f'"{key}": {value!r}' for key, value in known.items())
            synthetic_lines.append(f'    "{body.endpoint.id}": {{{pairs}}},')
        else:
            synthetic_lines.append(f'    "{body.endpoint.id}": {{')
            for key, value in known.items():
                synthetic_lines.append(f'        "{key}": {value!r},')
            synthetic_lines.append("    },")
    tail = "\n".join([
        "__all__ = [",
        *[f'    "{name}",' for name in exported],
        "]",
        "",
        "BODY_TYPES: Dict[str, Any] = {",
        *[
            f'    "{body.endpoint.id}": {body.class_name},'
            for body in body_infos
            if body.kind in ("typed", "list")
        ],
        "}",
        "",
        "# Documented request-body fields that are absent from the {} template.",
        "# BrandClient._invoke() fills placeholder values from context before",
        "# applying an explicit body= override.",
        "SYNTHETIC_FIELDS: Dict[str, Dict[str, Any]] = {",
        *synthetic_lines,
        "}",
    ])
    blocks.append(tail)
    return header + "\n\n\n" + "\n\n\n".join(blocks) + "\n"


# ------------------------------------------------------------------- update
def _replace_block(text: str, start: str, end: str, replacement: str) -> str:
    pattern = re.compile(re.escape(start) + r".*?" + re.escape(end), re.S)
    if not pattern.search(text):
        raise SystemExit(
            f"marker block not found: {start!r} ... {end!r}\n"
            "Add the generated markers to client.py before running the generator."
        )
    return pattern.sub(start + "\n" + replacement.rstrip("\n") + "\n" + end, text, count=1)


def _update_client(text: str, imports: str, index: str, methods: str) -> str:
    text = _replace_block(text, *MARKERS["imports"], imports)
    text = _replace_block(text, *MARKERS["index"], index)
    text = _replace_block(text, *MARKERS["methods"], methods)
    return text


def _parse_existing_method_index(text: str) -> Dict[str, str]:
    match = re.search(
        re.escape(MARKERS["index"][0]) + r"(.*?)" + re.escape(MARKERS["index"][1]),
        text,
        re.S,
    )
    if not match:
        return {}
    return dict(re.findall(r'"([a-z0-9_]+)": "([a-z0-9-]+)"', match.group(1)))


def _first_difference(old: str, new: str) -> str:
    old_lines = old.splitlines()
    new_lines = new.splitlines()
    for index, (left, right) in enumerate(zip(old_lines, new_lines), 1):
        if left != right:
            return f"line {index}:\n  old: {left}\n  new: {right}"
    if len(old_lines) != len(new_lines):
        return f"line count differs: old={len(old_lines)} new={len(new_lines)}"
    return "identical"


def main(argv: Optional[List[str]] = None) -> int:
    parser = argparse.ArgumentParser(
        description=__doc__,
        formatter_class=argparse.RawDescriptionHelpFormatter,
    )
    parser.add_argument("--check", action="store_true", help="只检查生成结果是否最新，不写文件")
    parser.add_argument("--dry-run", action="store_true", help="打印统计信息，不写文件")
    args = parser.parse_args(argv)

    groups: List[Tuple[str, List[Endpoint]]] = [
        (m.GROUP, list(m.ENDPOINTS)) for m in MODULES
    ]
    method_names = build_method_names(groups)
    endpoints = [ep for _, items in groups for ep in items]
    if len(method_names) != len(endpoints):
        raise SystemExit("duplicate method name generated; check PATH_NAMED_GROUPS")

    body_infos: List[BodyInfo] = []
    for ep in endpoints:
        info = _body_info(ep, method_names[ep.id])
        if info is not None:
            body_infos.append(info)

    imports = _render_imports(body_infos)
    index = _render_index(groups, method_names)
    methods = _render_methods(groups, method_names)
    schema = _render_schema(body_infos, method_names)

    old_client = CLIENT_PATH.read_text(encoding="utf-8")
    old_schema = SCHEMA_PATH.read_text(encoding="utf-8") if SCHEMA_PATH.exists() else ""
    new_client = _update_client(old_client, imports, index, methods)

    old_index = _parse_existing_method_index(old_client)
    old_by_id = {endpoint_id: name for name, endpoint_id in old_index.items()}
    if old_by_id and old_by_id != method_names:
        changed = sorted(
            (key, old_by_id.get(key), method_names.get(key))
            for key in set(old_by_id) | set(method_names)
            if old_by_id.get(key) != method_names.get(key)
        )
        print("WARNING: method names changed:", file=sys.stderr)
        for name, before, after in changed[:10]:
            print(f"  {name}: {before} -> {after}", file=sys.stderr)

    typed = sum(1 for body in body_infos if body.kind == "typed")
    lists = sum(1 for body in body_infos if body.kind == "list")
    empty = sum(1 for body in body_infos if body.kind == "empty")
    print(f"endpoints: {len(endpoints)}  methods: {len(method_names)}")
    print(f"json bodies: typed={typed}  list={lists}  empty={empty}")
    print(f"schemas.py: {len(schema.splitlines())} lines")
    print(f"client.py: {len(new_client.splitlines())} lines")

    if args.dry_run:
        print("--- sample ---")
        print("\n".join(methods.splitlines()[:40]))
        return 0
    if args.check:
        problems = []
        if old_schema != schema:
            problems.append("schemas.py is stale: " + _first_difference(old_schema, schema))
        if old_client != new_client:
            problems.append("client.py is stale: " + _first_difference(old_client, new_client))
        if problems:
            for problem in problems:
                print(problem, file=sys.stderr)
            return 1
        print("generated files are up to date")
        return 0

    SCHEMA_PATH.write_text(schema, encoding="utf-8")
    CLIENT_PATH.write_text(new_client, encoding="utf-8")
    print(f"wrote {SCHEMA_PATH}")
    print(f"wrote {CLIENT_PATH}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
