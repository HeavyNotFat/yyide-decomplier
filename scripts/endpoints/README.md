# scripts/endpoints：接口请求表与 Python 客户端

> 文档导航：[README.md](../../README.md)（构建/使用/目录） · [ENDPOINTS.md](../../ENDPOINTS.md)（API） · [RESTORE.md](../../RESTORE.md)（还原版）

这套脚本把反编译源码里的 Retrofit 接口、TTLock/人脸/外部接口整理成**可预览、可执行、可伪造**的请求表，并提供一个包含全部 257 个方法的 `BrandClient`。

- 默认目标：`https://api.yyide.com`（真实环境）
- 其它 host：TTLock、图书 SaaS、天气、腾讯 IM
- 不会把真实密钥写进生成表；凭据从**环境变量**或本地私有配置读取

> 发布到 GitHub 前运行 `python scripts/secrets.py scrub`，不要提交 `output/run-*.jsonl` 或本地凭据。

---

## 目录

- [1. 安装](#1-安装)
- [2. 目录结构](#2-目录结构)
- [3. 凭据从哪里来](#3-凭据从哪里来)
- [4. 生成请求表](#4-生成请求表)
- [5. 预览请求](#5-预览请求)
- [6. 真实执行](#6-真实执行)
- [7. 伪造请求](#7-伪造请求)
- [8. BrandClient](#8-brandclient)
- [9. 输出文件](#9-输出文件)
- [10. 分组](#10-分组)
- [11. 脱敏与发布](#11-脱敏与发布)
- [12. 排查](#12-排查)

---

## 1. 安装

要求 Python 3.10+。

```powershell
python -m pip install -r scripts/endpoints/requirements.txt
```

只依赖 `requests`。

---

## 2. 目录结构

```text
scripts/endpoints/
├─ __init__.py
├─ __main__.py                 # python -m scripts.endpoints
├─ common.py                   # Endpoint / RequestSpec / ApiClient / 登录 / 模板渲染 / 脱敏
├─ credentials.py              # base URL、环境变量、本地凭据
├─ permission_loader.py        # 解析本地凭据表（不随仓库发布）
├─ runner.py                   # CLI：列表 / 预览 / 执行 / 伪造
├─ build_request_table.py      # 生成 output/requests.*
├─ client.py                   # BrandClient：257 个接口方法
├─ device_info.py              # adb 读取 MAC / Android ID / 型号
├─ requirements.txt
├─ apis/
│  ├─ auth.py                  # 9
│  ├─ device.py                # 18
│  ├─ school.py                # 19
│  ├─ home.py                  # 15
│  ├─ messages.py              # 12
│  ├─ timetable.py             # 6
│  ├─ attendance.py            # 18
│  ├─ card.py                  # 11
│  ├─ userspace.py             # 26
│  ├─ activity.py              # 5
│  ├─ honor.py                 # 26
│  ├─ exam.py                  # 6
│  ├─ library.py               # 11
│  ├─ reservation.py           # 6
│  ├─ patrol.py                # 6
│  ├─ vote.py                  # 10
│  ├─ dormitory.py             # 2
│  ├─ ai.py                    # 4
│  ├─ upload.py                # 3
│  ├─ iot.py                   # 9
│  ├─ ttlock.py                # 26
│  ├─ face.py                  # 4
│  └─ external.py              # 5
└─ output/
   ├─ requests.csv / .json / .md
   ├─ groups/<group>.csv / .md
   └─ run-*.jsonl             # 仅 --execute 时生成
```

总计 **257** 条：

- 222 个 Retrofit 接口（应用源码 19 个接口文件）；
- 26 个 TTLock；
- 4 个人脸同步；
- 5 个外部/手工接口（SSE、旧相册、IM REST 模板等）。

---

## 3. 凭据从哪里来

优先级：

```text
命令行参数 > 环境变量 > 本地凭据表
```

常用环境变量：

| 变量 | 说明 |
| --- | --- |
| `YIDE_BASE_URL` | 默认 `https://api.yyide.com` |
| `YIDE_USERNAME` | 班牌账号 |
| `YIDE_PASSWORD` | 班牌密码 |
| `YIDE_CLIENT_ID` | 默认 `yide-cloud` |
| `YIDE_CLIENT_SECRET` | OAuth 客户端密钥 |
| `YIDE_SCHOOL_ID` | 学校 ID |
| `YIDE_MAC` | 设备 MAC，12 位小写 |
| `YIDE_ANDROID_ID` | 16 位 Android ID |
| `TTLOCK_CLIENT_ID` / `TTLOCK_CLIENT_SECRET` | TTLock |
| `TTLOCK_USERNAME` / `TTLOCK_PASSWORD` | TTLock 账号 |
| `BOOK_URL_KEY` | 图书/人脸外部系统签名密钥 |
| `TIM_SDKAPPID` / `TIM_SECRET_KEY` | 腾讯 IM |

PowerShell 示例：

```powershell
$env:YIDE_USERNAME = "<账号>"
$env:YIDE_PASSWORD = "<密码>"
$env:YIDE_MAC = "<MAC>"
$env:YIDE_ANDROID_ID = "<Android ID>"
$env:YIDE_CLIENT_SECRET = "<client_secret>"
```

也可以使用本地凭据表（不随仓库发布）：

```powershell
python -m scripts.endpoints.runner --list
```

`credentials.py` 会按环境变量优先、本地表兜底的方式解析；生成表不会打印真实值。

### 3.1 设备 ID

`/brand/obtain` 的 `seriaNo` 是 **Android ID**，不是硬件序列号。

```powershell
adb shell settings get secure android_id
python -m scripts.endpoints.device_info
python -m scripts.endpoints.device_info --serial <adb-serial> --json
```

`--mac auto --android-id auto` 会让 runner 通过 adb 读取。

---

## 4. 生成请求表

```powershell
python -m scripts.endpoints.build_request_table --split
```

输出：

- `output/requests.csv`（UTF-8 BOM，Excel 可打开）
- `output/requests.json`
- `output/requests.md`
- `output/groups/<group>.csv` / `.md`

字段：分组、ID、方法、base URL、真实 URL、Query、JSON Body、Form、Auth Header、Content-Type、是否可执行、源码方法、说明。

表里的 `{mac}`、`{classes_id}`、`{lock_id}` 等是**运行时占位符**；真实 secret 不会写入。

### 4.1 带真实 token 的表

```powershell
# 登录后生成 *.resolved.*
python -m scripts.endpoints.build_request_table --resolve --split

# 或使用已有 token
python -m scripts.endpoints.build_request_table --token <accessToken> --split
```

输出 `requests.resolved.csv/json/md` 和 `groups-resolved/`。**含真实 token，不要外传。**

---

## 5. 预览请求

默认只打印，不发送：

```powershell
# 只看登录
python -m scripts.endpoints.runner --id auth-001

# 某个分组
python -m scripts.endpoints.runner --group school

# 全部
python -m scripts.endpoints.runner
```

预览会打印：

- 真实 URL；
- Query（密码/secret 已脱敏）；
- JSON/Form；
- `Authorization: Bearer ...`（执行时才生成真实值）；
- 未解析的占位符；
- 可直接复制的 curl（secret 脱敏）。

---

## 6. 真实执行

```powershell
# 单条
python -m scripts.endpoints.runner --id auth-001 --execute

# 某个分组
python -m scripts.endpoints.runner --group school --execute

# 全部（谨慎：会修改数据/触发真实业务）
python -m scripts.endpoints.runner --execute
```

执行日志写入 `output/run-<timestamp>.jsonl`，含真实响应；不要提交。

---

## 7. 伪造请求

不发送，只生成完整请求（含真实 token 时可注入）：

```powershell
# 登录后伪造全部
python -m scripts.endpoints.runner --forge --mac <MAC> --android-id <Android ID>

# 已有 token
python -m scripts.endpoints.runner --forge --token <accessToken>

# 只伪造一个分组
python -m scripts.endpoints.runner --forge --token <accessToken> --group home
```

输出在 `output/forged-requests.json`，`unresolved` 列出仍缺的真实 ID。

---

## 8. BrandClient

```python
from scripts.endpoints.client import BrandClient

client = BrandClient(
    username="<账号>",
    password="<密码>",
    mac="<MAC>",
    android_id="<Android ID>",
    school_id="<学校 ID>",
    auto_obtain=True,      # 自动 /brand/obtain，填充 brand_id/classes_id/site_id
)

# 方法名 = 分组 + 接口方法名
layout = client.school_get_new_layout_list(id=client.context["brand_id"])
classes = client.school_select_new_classes_info(classesId=client.context["classes_id"])
students = client.userspace_all_students(id=client.context["classes_id"])
announcements = client.messages_get_new_notice_with_pag(pageNo=1, pageSize="18")

# 按 endpoint id 调用
data = client.call("home-002", classesId=client.context["classes_id"])

# 完整外壳
raw = client.home_get_new_layout_list(full=True, id=client.context["brand_id"])

# 只伪造，不发送
req = client.forge("home-002")
all_requests = client.forge_all()
```

要点：

- 构造时自动 `POST /auth/oauth/token`；
- 后续 `auth=True` 请求自动带 `Authorization: Bearer ...`；
- TTLock 首次调用时自动登录；
- `client.method_names` / `client.method_index` 可查看 257 个方法；
- TTLock/人脸/外部接口也包含在 `client` 中。

### 8.1 自定义 context

```python
client.context.update({
    "brand_id": "...",
    "classes_id": "...",
    "site_id": "...",
})
```

### 8.2 只调登录

```python
client.login()
print(client.token)
```

---

## 9. 输出文件

| 文件 | 是否含真实值 | 说明 |
| --- | --- | --- |
| `output/requests.csv/json/md` | 否 | 默认请求表 |
| `output/groups/*.csv/md` | 否 | 分组表 |
| `output/requests.resolved.*` | **是（token）** | 登录后生成 |
| `output/forged-requests.json` | **是（token）** | `--forge` 生成 |
| `output/run-*.jsonl` | **是（响应）** | `--execute` 生成 |

发布前删除 `*.resolved.*`、`forged-requests.json`、`run-*.jsonl`，并运行脱敏脚本。

---

## 10. 分组

```text
auth device school home messages timetable attendance card userspace
activity honor exam library reservation patrol vote dormitory ai
upload iot ttlock face external
```

查看分组：

```powershell
python -m scripts.endpoints.runner --list
python -m scripts.endpoints --list
```

---

## 11. 脱敏与发布

```powershell
python scripts/secrets.py check
python scripts/secrets.py scrub
python scripts/secrets.py check
```

`secrets.py` 会把：

- 本地凭据清单移到 `_private/`；
- 请求日志/执行日志中的 token、账号、MAC 替换为占位符；
- 文本中的 OAuth Secret、API Key、JWT、密码替换为 `__SEC_*__`。

本地继续联调：

```powershell
python scripts/secrets.py restore
```

**不要**把 `output/` 下的 `*.resolved.*`、`run-*.jsonl`、`forged-requests.json` 提交。

---

## 12. 排查

| 问题 | 处理 |
| --- | --- |
| `YIDE_CLIENT_SECRET 未配置` | 设置环境变量或本地凭据 |
| `401/403` | token 过期，重新登录；检查 `Authorization` |
| `UnknownHostException` | 设备/电脑 DNS 无法解析 `api.yyide.com` |
| `code=500 系统繁忙` | 接口侧限流/繁忙，降低频率后重试 |
| 占位符未解析 | 用 `--mac` / `--android-id` / `--classes-id` 补齐，或先 `auto_obtain` |
| 表里没有真实 secret | 设计如此；执行时从环境变量注入 |

---

## 13. 最小示例

```python
import os
from scripts.endpoints.client import BrandClient

client = BrandClient(
    os.environ["YIDE_USERNAME"],
    os.environ["YIDE_PASSWORD"],
    mac=os.environ["YIDE_MAC"],
    android_id=os.environ["YIDE_ANDROID_ID"],
    auto_obtain=True,
)

layout = client.school_get_new_layout_list(id=client.context["brand_id"])
for page in layout:
    for module in page["layoutClassSignDetailsEntityList"]:
        print(module["tag"], module["x"], module["y"], module["width"], module["height"])
```
