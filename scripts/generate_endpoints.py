#!/usr/bin/env python3
"""Extract the raw Retrofit endpoint list from the decompiled sources.

By default this writes ``ENDPOINTS.raw.md``.  The curated ``ENDPOINTS.md``
(business categories, request/response examples, code samples) is maintained
by hand and is intentionally *not* overwritten.

Usage:
    python scripts/generate_endpoints.py
    python scripts/generate_endpoints.py --out ENDPOINTS.raw.md
    python scripts/generate_endpoints.py --out ENDPOINTS.md   # destructive
"""

from __future__ import annotations

import argparse
import os
import re
from collections import OrderedDict

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
SRC = os.path.join(ROOT, "src", "main", "java")
DEFAULT_OUT = os.path.join(ROOT, "ENDPOINTS.raw.md")

INTERFACE_FILES = [
    "com/yd/android_brand_mvp/net/DingApiStores.java",
    "com/yd/android_brand_mvp/net/LocalApiStores.java",
    "com/yd/android_brand_mvp/net/BookApiStores.java",
    "com/yd/android_brand_mvp/net/WeatherApiStores.java",
    "com/yd/android_brand_mvp/network/INetworkService.java",
    "com/yd/android_brand_mvp/network/active/IActiveService.java",
    "com/yd/android_brand_mvp/network/ai/IAIService.java",
    "com/yd/android_brand_mvp/network/collect/ICollectService.java",
    "com/yd/android_brand_mvp/network/customized/ICustomizedService.java",
    "com/yd/android_brand_mvp/network/dormitory/IDormitoryService.java",
    "com/yd/android_brand_mvp/network/evaluation/IEvaluationService.java",
    "com/yd/android_brand_mvp/network/exam/IExamManageService.java",
    "com/yd/android_brand_mvp/network/library/ILibraryService.java",
    "com/yd/android_brand_mvp/network/patrol/IPatrolService.java",
    "com/yd/android_brand_mvp/network/reservation/IReservationService.java",
    "com/yd/android_brand_mvp/network/setting/ISettingActivationService.java",
    "com/yd/android_brand_mvp/network/task/ITaskSignService.java",
    "com/yd/android_brand_mvp/network/userspace/IUserSpaceService.java",
    "com/yd/android_brand_mvp/network/vote/IVoteService.java",
]


def balanced(text: str, start: int) -> str:
    assert text[start] == "<"
    depth = 0
    for i in range(start, len(text)):
        if text[i] == "<":
            depth += 1
        elif text[i] == ">":
            depth -= 1
            if depth == 0:
                return text[start + 1:i]
    return text[start + 1:]


def normalize_path(path: str) -> str:
    if path.startswith("http://") or path.startswith("https://"):
        path = re.sub(r"^https?://[^/]+", "", path)
    return "/" + path.strip("/")


def parse(path: str) -> list[dict]:
    text = open(path, encoding="utf-8", errors="replace").read()
    out = []
    for m in re.finditer(r'@(GET|POST|PUT|DELETE)\("([^"]+)"\)', text):
        method, raw_path = m.group(1), m.group(2)
        tail = text[m.end():m.end() + 4000]
        semi = tail.find(";")
        if semi == -1:
            continue
        sig = tail[:semi]

        ret = ""
        om = re.search(r"Observable\s*<", sig)
        if om:
            ret = balanced(sig, om.end() - 1)
        else:
            cm = re.search(r"Continuation\s*<", sig)
            if cm:
                inner = balanced(sig, cm.end() - 1)
                ret = re.sub(r"^\s*\?\s*super\s+", "", inner).strip()
        ret = re.sub(r"\s+", "", ret)

        names = re.findall(r"([A-Za-z_]\w*)\s*\(", sig)
        skip = {"Query", "Path", "Body", "Part", "Header", "Field", "Url",
                "Headers", "Continuation", "Observable"}
        names = [n for n in names if n not in skip]
        name = names[0] if names else ""
        params = []
        for pm in re.finditer(
            r'@(Query|Path|Body|Part|Header|Field|Url)\(([^)]*)\)\s*'
            r'([\w.$<>\[\]]+)\s+(\w+)',
            sig,
        ):
            ann, value, typ, pname = pm.groups()
            params.append((ann, value.strip('"'), typ, pname))
        out.append({
            "method": method,
            "path": normalize_path(raw_path),
            "name": name,
            "params": params,
            "return": ret,
        })
    return out


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "--out",
        default=DEFAULT_OUT,
        help="output markdown path (default: ENDPOINTS.raw.md)",
    )
    args = parser.parse_args()
    out = os.path.abspath(args.out)
    if out == os.path.join(ROOT, "ENDPOINTS.md"):
        print("WARNING: --out ENDPOINTS.md will overwrite the hand-curated document")

    services = OrderedDict()
    total = 0
    for rel in INTERFACE_FILES:
        path = os.path.join(SRC, rel)
        if not os.path.exists(path):
            continue
        eps = parse(path)
        total += len(eps)
        services[os.path.basename(rel).replace(".java", "")] = eps

    lines = []
    add = lines.append
    add("# 智慧班牌 API 说明")
    add("")
    add("> 本文档由 `scripts/generate_endpoints.py` 从反编译源码中的 Retrofit 接口自动整理。")
    add("> 接口路径和参数来自源码，未在真机逐条验证；实际响应以服务端为准。")
    add("")
    add("## 0. 公共约定")
    add("")
    add("| 项目 | 值 |")
    add("| --- | --- |")
    add("| 基 URL | `https://api.yyide.com` |")
    add("| 兼容 schoolId（兼善） | `1959804909729640450` |")
    add("| 鉴权头 | `Authorization: Bearer <accessToken>` |")
    add("| 常用 Content-Type | `application/json` |")
    add("| 本地 Mock 基 URL | `http://10.0.2.2:8765`（Android 模拟器访问宿主机） |")
    add("")
    add("任何有效操作都需要先通过 OAuth 登录，保存 `accessToken` / `refreshToken`，后续请求带 `Authorization`。")
    add("")
    add("统一响应外壳（大多数接口）：")
    add("")
    add("```json")
    add('{"code":0,"message":"操作成功","detailMessage":"","data":{}}')
    add("```")
    add("")
    add("`code == 0` 表示成功；`code == 401` 通常表示 token 失效，需要刷新或重新登录。")
    add("")
    add("## 1. OAuth 登录获取令牌")
    add("")
    add("**接口地址：** `POST /auth/oauth/token`")
    add("")
    add("**用途：** 通过 OAuth 密码模式登录，获取访问令牌。源码中参数以 Query 形式发送。")
    add("")
    add("| 参数名 | 必填 | 示例值 | 说明 |")
    add("| --- | --- | --- | --- |")
    add("| username | 是 | __SEC_ACCOUNT_CD95B3FB__、__SEC_ACCOUNT_37A5B57C__ | 登录账号 |")
    add("| password | 是 | __SEC_PASSWORD_E55E161A__、224614 | 登录密码 |")
    add("| client_id | 是 | yide-cloud | 客户端 ID |")
    add("| client_secret | 是 | __SEC_CLIENT_SECRET_68B09CCF__ | 应用凭证/密钥 |")
    add("| grant_type | 是 | brand | 授权类型，固定 brand |")
    add("| random | 是 | aB3kL9mZ... | 16 位随机字符串，用于 CDN 刷新标识 |")
    add("")
    add("示例：")
    add("")
    add("```bash")
    add('curl -X POST "https://api.yyide.com/auth/oauth/token?username=__SEC_ACCOUNT_CD95B3FB__&password=__SEC_PASSWORD_E55E161A__&client_id=yide-cloud&client_secret=__SEC_CLIENT_SECRET_68B09CCF__&grant_type=brand&random=aB3kL9mZ12345678"')
    add("```")
    add("")
    add("返回：")
    add("")
    add("```json")
    add('{')
    add('  "code": 0,')
    add('  "data": {')
    add('    "accessToken": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",')
    add('    "expiresIn": 863999,')
    add('    "refreshToken": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",')
    add('    "tokenHead": "Bearer "')
    add('  },')
    add('  "detailMessage": "",')
    add('  "message": "操作成功"')
    add('}')
    add("```")
    add("")
    add("| 字段路径 | 类型 | 说明 |")
    add("| --- | --- | --- |")
    add("| code | Integer | 状态码，0 表示成功 |")
    add("| message | String | 响应消息 |")
    add("| detailMessage | String | 详细错误信息，成功时为空 |")
    add("| data.accessToken | String | JWT 访问令牌 |")
    add("| data.expiresIn | Integer | 有效期，单位秒（863999 ≈ 10 天） |")
    add("| data.refreshToken | String | 刷新令牌 |")
    add("| data.tokenHead | String | 固定 `Bearer `，拼在 accessToken 前 |")
    add("")
    add("后续请求示例：")
    add("")
    add("```bash")
    add('curl -H "Authorization: Bearer <accessToken>" \\')
    add('     -H "Content-Type: application/json" \\')
    add('     "https://api.yyide.com/brand/brand/classes/info?classesId=mock-class-001"')
    add("```")
    add("")
    add("## 2. 核心业务接口")
    add("")
    add("### 2.1 设备激活/登录/布局")
    add("")
    add("| 接口 | 用途 |")
    add("| --- | --- |")
    add("| `GET /manage/machineInfo/getMachineConfigByDeviceNo?deviceNo=<MAC>` | 按设备 MAC 获取机器配置 |")
    add("| `POST /brand/obtain` | 班牌登录/获取学校、班级、场地信息 |")
    add("| `POST /brand/brand/layoutclasssign/layoutlist` | 获取首页模块布局（x/y/tag/width/height） |")
    add("| `GET /brand/brand/classes/info?classesId=<id>` | 班级信息 |")
    add("| `POST /brand/brand/classes/watchword/list` | 班级口号/班主任寄语 |")
    add("| `GET /brand/brand/campus/style` | 学校样式/Logo |")
    add("")
    add("### 2.2 首页卡片")
    add("")
    add("| 接口 | 用途 |")
    add("| --- | --- |")
    add("| `POST /brand/weather/now` | 当前天气 |")
    add("| `POST /brand/weather/day7` | 7 天天气 |")
    add("| `POST /brand/brand/mess/recive/page` | 通知公告 |")
    add("| `POST /cloud/app/timetable/getWeekTime` | 课表 |")
    add("| `GET /attweb/app/attendance/getBrandAttendanceRule?no=<MAC>` | 考勤规则 |")
    add("| `POST /brand/brand/studentwork/list` | 学生作品 |")
    add("| `POST /brand/brand/album/list` | 班级相册 |")
    add("| `POST /brand/brand/album/index` | 班级视频 |")
    add("| `POST /cloud/app/honor/brandPage` | 荣誉墙 |")
    add("")
    add("### 2.3 学生刷卡/学生空间")
    add("")
    add("| 接口 | 用途 |")
    add("| --- | --- |")
    add("| `POST /brand/brand/Authority/selectStudentByIcCard` | 学生卡号换学生信息 |")
    add("| `GET /cloud/im/user/sig/gen?identifier=<userId>` | 生成 IM UserSig |")
    add("| `POST /cloud/app/timetable/getWeekTime` | 学生课表 |")
    add("| `GET /app/formProcessTemplates/getDefaultStudentLeave` | 学生请假表单 |")
    add("| `POST /app/v2/proc/getFlowElements` | 请假流程 |")
    add("| `POST /app/v2/proc/startInstance` | 提交请假 |")
    add("| `POST /brand/activity/enroll/userEnrollPage` | 我的报名 |")
    add("| `POST /attweb/attendanceSignTask/brand/list` | 打卡任务 |")
    add("| `POST /cloud/evaluationActivityMobile/childrenHonor` | 个人荣誉 |")
    add("| `POST /brand/exam/by/student` | 学生考试 |")
    add("| `GET /brand/appEvalMedal/listEvalMedalType` | 勋章类型 |")
    add("| `POST /brand/appEvalMedal/pageEvalUserMedal` | 我的勋章 |")
    add("| `GET /cloud/leaveWord/getLeaveWordSetting?type=1` | 意见箱配置 |")
    add("| `POST /cloud/leaveWord/brand/create` | 提交意见 |")
    add("")
    add("### 2.4 常见 POST 请求体示例")
    add("")
    add("| 接口 | 请求体示例 |")
    add("| --- | --- |")
    add('| `/brand/obtain` | `{"no":"<MAC>","seriaNo":"<AndroidID>","wlanMac":"","loginName":"__SEC_ACCOUNT_CD95B3FB__","direction":"0"}` |')
    add('| `/brand/brand/layoutclasssign/layoutlist` | `{"id":"<brandId>","showType":0,"deviceType":"2"}` |')
    add('| `/cloud/app/timetable/getWeekTime` | `{"weekTime":"","typeId":"<classesId>","type":"1"}` |')
    add('| `/cloud/student/allStudents` | `{"pageNo":1,"pageSize":100,"id":"<classesId>","type":4,"key":"classes"}` |')
    add('| `/attweb/app/attendance/listToDay` | `{"attendanceTimeIds":[]}` |')
    add('| `/brand/brand/studentwork/list` | `{"classesId":"<classesId>","pageNo":"1","pageSize":"10"}` |')
    add('| `/cloud/app/honor/brandPage` | `{"pageNo":1,"pageSize":5}` |')
    add('| `/brand/brand/Authority/selectStudentByIcCard` | `{"icCardNo":"1234567890"}` |')
    add('| `/brand/activity/enroll/userEnrollPage` | `{"pageNo":1,"pageSize":10,"userId":"<studentId>"}` |')
    add('| `/attweb/attendanceSignTask/brand/list` | `{"status":"not_start","pageNo":1,"pageSize":20,"studentId":"<studentId>","schoolId":"<schoolId>"}` |')
    add('| `/brand/exam/by/student` | `{"studentId":"<studentId>"}` |')
    add('| `/cloud/leaveWord/brand/create` | `{"classesId":"<classesId>","content":"意见内容","userId":"<studentId>","type":"1","anonymity":false}` |')
    add("")
    add("## 3. 完整接口清单")
    add("")
    add(f"共 **{total}** 个 Retrofit 接口，按源码接口文件分组。")
    add("")
    for service, eps in services.items():
        add(f"### {service}")
        add("")
        add("| # | Method | Path | 源码方法 | 参数 | 返回类型 |")
        add("| ---: | --- | --- | --- | --- | --- |")
        for i, e in enumerate(eps, 1):
            if e["params"]:
                ps = "<br>".join(
                    f"`{a}({v})` {t} `{n}`" for a, v, t, n in e["params"]
                )
            else:
                ps = "-"
            ret = e["return"].replace("|", "\\|")
            add(f"| {i} | {e['method']} | `{e['path']}` | `{e['name']}` | {ps} | `{ret}` |")
        add("")
    add("## 4. 错误码/鉴权说明")
    add("")
    add("- `code == 0`：成功。")
    add("- `code == 401`：token 过期或未登录，重新走 OAuth 或 refreshToken。")
    add("- `code != 0`：业务失败，读取 `message` / `detailMessage`。")
    add("- 设备相关接口通常还要求 `deviceNo`（MAC，去掉冒号、小写）。")
    add("")
    add("## 5. 本地 Mock Server")
    add("")
    add("调试包把 host 改为 `http://10.0.2.2:8765`，由 `mock-server/mock_server.py` 返回本地数据。")
    add("")
    add("```powershell")
    add("cd mock-server")
    add("python mock_server.py")
    add("```")
    add("")
    add("请求日志会写到 `mock-server/requests.log`。")
    add("")

    with open(out, "w", encoding="utf-8") as fh:
        fh.write("\n".join(lines))
    print(f"wrote {out}: {total} endpoints")


if __name__ == "__main__":
    main()
