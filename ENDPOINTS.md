# 智慧班牌 3.0.14 API 文档

> 文档导航：[README.md](README.md)（构建/使用/目录） · [RESTORE.md](RESTORE.md)（还原版与 8×6 布局） · [scripts/endpoints/README.md](scripts/endpoints/README.md)（请求表/客户端）
>
> 本文档面向**自有班牌设备的离线调试、接口联调和兼容性研究**。
>
> - 数据来源：`src/main/java` 中 19 个 Retrofit 接口文件（222 个注解）、`vendor-src` 中的 TTLock/人脸/IM 接口，以及公开博客 [《班牌破解新思路》](https://blog.cqjszx.cn/index.php/archives/8/) 的 API 构建方式。
> - 所有接口均来自静态源码，**没有逐条在真机验证**；响应字段以服务端实际返回为准。
> - 文中账号、密钥、Token 均以占位符或脱敏形式展示；真实值只放在本地凭据/环境变量中，不随仓库发布。**不要用于未授权设备或线上系统。**

---

## 目录

- [1. 5 分钟跑通](#1-5-分钟跑通)
- [2. API 构建方式（参考博客）](#2-api-构建方式参考博客)
- [3. 登录与鉴权流程](#3-登录与鉴权流程)
- [4. 通用约定](#4-通用约定)
- [5. 业务接口（20 类）](#5-业务接口20-类)
  - [5.1 鉴权与登录](#51-鉴权与登录)
  - [5.2 设备激活、绑定与升级](#52-设备激活绑定与升级)
  - [5.3 学校、班级与首页布局](#53-学校班级与首页布局)
  - [5.4 首页卡片与班级展示](#54-首页卡片与班级展示)
  - [5.5 消息公告与 IM](#55-消息公告与-im)
  - [5.6 课表](#56-课表)
  - [5.7 考勤与打卡](#57-考勤与打卡)
  - [5.8 刷卡、人脸与身份识别](#58-刷卡人脸与身份识别)
  - [5.9 学生空间、请假与报修](#59-学生空间请假与报修)
  - [5.10 活动与报名](#510-活动与报名)
  - [5.11 德育评价、荣誉与勋章](#511-德育评价荣誉与勋章)
  - [5.12 考试](#512-考试)
  - [5.13 图书与阅读](#513-图书与阅读)
  - [5.14 场地预约与咨询](#514-场地预约与咨询)
  - [5.15 巡课](#515-巡课)
  - [5.16 投票与问卷](#516-投票与问卷)
  - [5.17 宿舍](#517-宿舍)
  - [5.18 AI 助手](#518-ai-助手)
  - [5.19 文件上传与日志](#519-文件上传与日志)
  - [5.20 设备物联与扩展](#520-设备物联与扩展)
- [6. 第三方与外部接口](#6-第三方与外部接口)
- [7. 完整索引（按源码文件）](#7-完整索引按源码文件)
- [8. Mock Server 与本地调试](#8-mock-server-与本地调试)
- [9. 代码示例](#9-代码示例)
- [10. 附录](#10-附录)

---

## 1. 5 分钟跑通

### 1.1 启动 Mock Server

```powershell
cd mock-server
python mock_server.py
```

输出：

```text
mock server: http://0.0.0.0:8765
emulator URL: http://10.0.2.2:8765
requests log: ...\mock-server\requests.log
```

- 宿主机/浏览器：`http://127.0.0.1:8765`
- Android 模拟器：`http://10.0.2.2:8765`
- 真机：需要把 Mock APK 的 host 改成电脑局域网 IP，或使用 `adb reverse`（见 8.3）

### 1.2 登录拿 Token

```bash
curl -s -X POST \
  "http://127.0.0.1:8765/auth/oauth/token?username=admin&password=123456&client_id=yide-cloud&grant_type=brand&client_secret=<client_secret>&random=abcdefgh12345678"
```

真实服务返回：

```json
{
  "code": 0,
  "message": "操作成功",
  "detailMessage": "",
  "data": {
    "accessToken": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
    "expiresIn": 863999,
    "refreshToken": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9...",
    "tokenHead": "Bearer "
  }
}
```

`Authorization` 头的值是 `tokenHead + accessToken`，即 `Bearer eyJ...`。

> Mock Server 的登录响应是简化格式（`data.token` / `data.accessToken` / `tokenHead`），两种都兼容；真实服务字段名以 `accessToken` 为准。

### 1.3 调一个业务接口

```bash
curl -s -X POST "http://127.0.0.1:8765/brand/brand/mess/recive/page" \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer mock-token" \
  -d '{
    "identifier": "announcement",
    "pageNo": 1,
    "pageSize": "18",
    "approverId": "",
    "startTime": "2026-10-01 00:00:00",
    "endTime": "2026-10-19 23:59:59"
  }'
```

换成真实环境时：

1. `http://127.0.0.1:8765` → `https://api.yyide.com`；
2. 账号/密码换成真实账号；
3. `client_id` / `client_secret` 仍是 `yide-cloud` / `<client_secret>`（源码硬编码，见 本地凭据）。

### 1.4 Python 最小客户端

```python
import random
import string
import requests

BASE = "http://127.0.0.1:8765"

s = requests.Session()
s.headers.update({"Content-Type": "application/json"})

r = s.post(f"{BASE}/auth/oauth/token", params={
    "username": "admin",
    "password": "123456",
    "client_id": "yide-cloud",
    "client_secret": "<client_secret>",
    "grant_type": "brand",
    "random": "".join(random.choices(string.ascii_letters + string.digits, k=16)),
})
r.raise_for_status()
data = r.json()["data"]
token = (data.get("tokenHead") or "Bearer ") + (
    data.get("accessToken") or data.get("access_token") or data.get("token")
)
s.headers["Authorization"] = token

r = s.post(f"{BASE}/brand/brand/mess/recive/page", json={
    "identifier": "announcement",
    "pageNo": 1,
    "pageSize": "18",
    "approverId": "",
    "startTime": "2026-10-01 00:00:00",
    "endTime": "2026-10-19 23:59:59",
})
print(r.json())
```

完整客户端（含分页、错误处理、上传、SSE）见 [9.1](#91-python-完整客户端)。

---

## 2. API 构建方式（参考博客）

博客《班牌破解新思路》给出的核心结论：

> 任何有效操作均需要通过 OAuth 登录保存 Session 后执行。  
> 基 URL：`https://api.yyide.com`  
> 兼善 schoolId：`1959804909729640450`

这和我们从源码中看到的一致：所有业务接口都走同一个网关，登录用 OAuth 密码模式，业务请求带 `Authorization`，返回统一 JSON 外壳。

### 2.1 基 URL 与多域名

| 用途 | Base URL | 说明 |
| --- | --- | --- |
| 主站 API | `https://api.yyide.com` | 222 个 Retrofit 接口的默认 baseUrl |
| 开发/内网 API | `http://192.168.3.158:9528` | `BaseConstant.URL_DEV_IP`，源码可切换 |
| 图书 SaaS | `https://open-lcs.libsaas.com.cn/` | `BookApiStores.API_SERVER_URL` |
| 图书/人脸外部系统 | `http://120.76.189.190/api/library/...`、`:800/yide_manager/...`、`:8099/java-external-docking` | `GetData`，使用 `AuthcodeTwo` 签名 |
| 天气 | `https://zhwnlapi.etouch.cn` | `WeatherApiStores`，`/Ecalender/weather_mini` |
| 腾讯云 IM REST | `https://console.tim.qq.com` | `/v4/openim/...`，UserSig 由主站接口下发 |
| 扫码验证页 | `https://mcloud.yyide.com/#/verify` | `HTTP_QRCODE_UEL` |
| 文档预览 | `https://preview.fsse.vip/onlinePreview?url=` | `HTTP_BROWSE_DOCUMENT` |
| 数字教材 | `https://scyd.flyread.com.cn/`、`https://demo.flyread.com.cn/` | WebView 地址 |
| Mock | `http://10.0.2.2:8765` | 模拟器访问宿主机；真机需改 host |

### 2.2 OAuth 密码模式

**接口：** `POST /auth/oauth/token`

源码用 Retrofit `@Query` 发送，也就是说参数在 URL 上；博客的 Flask 版本用 `application/x-www-form-urlencoded` 表单。两种方式服务端通常都兼容，优先按源码的 Query。

| 参数 | 必填 | 示例 | 说明 |
| --- | --- | --- | --- |
| `username` | 是 | `<账号>` | 班牌登录账号 |
| `password` | 是 | `<密码>` | 登录密码 |
| `client_id` | 是 | `yide-cloud` | 固定客户端 ID |
| `client_secret` | 是 | `<client_secret>` | 固定应用密钥 |
| `grant_type` | 是 | `brand` | 固定 `brand`，不是标准 `password` |
| `random` | 是 | `aB3kL9mZ12345678` | 16 位随机串；部分自动登录场景传空串 |

```bash
curl -X POST "https://api.yyide.com/auth/oauth/token?username=<账号>&password=<密码>&client_id=yide-cloud&grant_type=brand&client_secret=<client_secret>&random=aB3kL9mZ12345678"
```

响应字段：

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| `code` | int | `0` 成功 |
| `message` | string | 消息 |
| `detailMessage` | string | 详细错误，成功时为空 |
| `data.accessToken` | string | JWT 访问令牌 |
| `data.expiresIn` | int | 有效期（秒），约 864000（10 天） |
| `data.refreshToken` | string | 刷新令牌；源码未发现 refresh 接口，过期后直接重新登录 |
| `data.tokenHead` | string | 固定 `Bearer ` |

### 2.3 请求头

| Header | 值 | 来源 | 说明 |
| --- | --- | --- | --- |
| `Authorization` | `Bearer <accessToken>` | `AppClient` / `BaseNetworkApi` 拦截器 | 业务接口必带 |
| `Content-Type` | `application/json` | Retrofit `@Headers` / `MediaType` | POST 业务接口 |
| `Accept` | `application/json` | `INetworkService` 的 `@Headers` | 部分接口 |
| `brand` | `Build.BRAND` | `CommonRequestInterceptor` | 设备品牌，如 `HUAWEI`、`Xiaomi` |
| `model` | `Build.MODEL` | `CommonRequestInterceptor` | 设备型号 |
| `Connection` | `close` | `AppClient` | 老 OkHttp 栈会加 |
| `Cache-Control` | `no-cache` | `AppClient` / `BaseNetworkApi` | 防缓存 |

> 两套网络栈的行为不一样：
> - `AppClient`（`DingApiStores`/`LocalApiStores`/`BookApiStores`/`WeatherApiStores`）：加 `Authorization`、`Connection: close`、`no-cache`；
> - `BaseNetworkApi`（`INetworkService` 等协程接口）：加 `brand`、`model`、`Authorization`、`no-cache`，并移除 `Pragma`。
>
> 自己写脚本时，`Authorization` + `Content-Type` 就够；`brand`/`model` 只是设备画像，不是鉴权必需。

### 2.4 统一响应外壳

大多数接口：

```json
{
  "code": 0,
  "message": "操作成功",
  "detailMessage": "",
  "success": true,
  "error": false,
  "data": {}
}
```

| 字段 | 类型 | 说明 |
| --- | --- | --- |
| `code` | int | `0` 成功；非 0 失败；`401` 通常 token 失效 |
| `message` | string | 业务消息 |
| `detailMessage` | string/null | 详细错误 |
| `success` | bool | 是否成功（部分接口） |
| `error` | bool | 是否错误（部分接口） |
| `data` | any | 业务数据；可能是对象、数组、分页对象、字符串 |

`BaseResponse<T>`（协程接口）只解析 `code`、`message`、`data`；`DingApiStores` 的返回模型多数是裸对象（如 `NewLoginRsp`、`LayoutListRsp`），字段名以模型为准。

### 2.5 分页约定

| 字段 | 说明 |
| --- | --- |
| `pageNo` | 页码，从 1 开始 |
| `pageSize` | 每页条数；有的接口是字符串 `"18"`，有的接口是数字 `20` |
| `total` | 总条数 |
| `list` | 当前页数据（部分接口叫 `records`） |

`BasePageResponse<T>` 的常见结构：

```json
{
  "total": 1,
  "pageNo": 1,
  "pageSize": 20,
  "list": []
}
```

### 2.6 常用 ID、时间与设备字段

| 字段 | 示例 | 说明 |
| --- | --- | --- |
| `schoolId` | `1959804909729640450` | 学校 ID（兼善示例） |
| `classesId` | `mock-class-001` | 班级 ID |
| `studentId` / `userId` | `student-1` | 学生/用户 ID |
| `teacherId` | `teacher-1` | 教师 ID |
| `brandId` / `id` | `mock-device-001` | 班牌设备/品牌 ID |
| `deviceNo` / `no` | `__SEC_MAC_PUT_92F7D57E__` | MAC，去掉冒号、转小写 |
| `deviceType` | `"2"` | 班牌设备类型，固定字符串 |
| `identity` | `0` / `1` | 身份类型，不同接口含义不同 |
| 时间 | `2026-10-19 08:00:00` | 多数接口用 `yyyy-MM-dd HH:mm:ss` |
| `weekTime` | `""` / `2026-10-19` | 课表周次/日期 |

### 2.7 请求签名与加密

只有少数外部系统需要额外签名/加密：

| 系统 | 方式 | 代码 |
| --- | --- | --- |
| 图书/人脸外部系统 | `input=AuthcodeTwo(k=v&k2=v2, URL_KEY)` | `GetData.requestUrl()`、`AuthcodeTwo` |
| 设备激活/登录参数 | RSA/ECB/PKCS1Padding | `RsaUtil.encrypt()` |
| 本地数据/密码 | AES-ECB / DES-ECB | `AESEncryptUtils`、`DesCipherUtils` |
| MQTT | 用户名/密码 | `MQTTClient` |
| 腾讯 IM | UserSig（HMAC-SHA256） | `GenerateTestUserSig` |

`AuthcodeTwo` 是 Discuz `authcode` 变体：MD5 派生密钥 + RC4 + Base64。Python 移植见 [9.7](#97-图书系统-authcodetwo-签名)。

> 这些密钥都在 APK 里，客户端加密只能防“误读”，不能防逆向。真正敏感的逻辑应放服务端。

### 2.8 本地重定向/劫持调试

博客的做法（仅用于自有设备）：

1. Clash TUN 模式拦截 `api.yyide.com`，规则 `DOMAIN,api.yyide.com,DIRECT`；
2. 修改 hosts：

```text
# C:\Windows\System32\drivers\etc\hosts
127.0.0.1 api.yyide.com
```

3. 本地起 HTTPS/HTTP 服务，伪造公告等内容，让班牌 WebView 加载链接。

本仓库更安全的等价做法：

- 直接用 `dist/智慧班牌-3.0.14-MOCK.apk`，它已经把 host 改成 `http://10.0.2.2:8765`；
- 或对真机做 `adb reverse tcp:8765 tcp:8765`，再把 APK 的 host 改成 `http://127.0.0.1:8765`（需要重打包）；
- 不要在生产网络里改 DNS/hosts 影响其他设备。

---

## 3. 登录与鉴权流程

### 3.1 完整时序

```text
┌─────────┐                          ┌──────────────────────┐
│  班牌   │                          │  api.yyide.com       │
└────┬────┘                          └──────────┬───────────┘
     │ 1. POST /auth/oauth/token                 │
     │    username/password/client_id/secret     │
     │    grant_type=brand&random=16位           │
     │──────────────────────────────────────────>│
     │<──────────── accessToken/refreshToken ────│
     │                                           │
     │ 2. POST /brand/obtain                     │
     │    {no, seriaNo, wlanMac, loginName,      │
     │     direction}                            │
     │──────────────────────────────────────────>│
     │<──── schoolId/classesId/brandId/siteId ───│
     │                                           │
     │ 3. POST /brand/brand/layoutclasssign/     │
     │         layoutlist                        │
     │    {id, showType, deviceType}             │
     │──────────────────────────────────────────>│
     │<──── 首页模块 x/y/width/height/tag ───────│
     │                                           │
     │ 4. 后续请求 Authorization: Bearer ...      │
     │──────────────────────────────────────────>│
```

### 3.2 第 1 步：换 Token

见 [2.2](#22-oauth-密码模式)。源码调用点：

| 文件 | 方法 | 场景 |
| --- | --- | --- |
| `presenter/LoginPresenter.java` | `getToken()` | 登录页 |
| `presenter/WelcomePresenter.java` | `getNewToken()` | 启动页自动登录 |
| `presenter/HomePresenter.java` | `newLogin(...)` | 首页续登 |
| `network/NetworkApi$login$2.java` | `login()` | 协程封装（疑似未使用，见 5.1） |

### 3.3 第 2 步：`/brand/obtain` 换学校/班级/场地

**接口：** `POST /brand/obtain`

源码请求体（`LoginPresenter.getNewBrandLogin`）：

```json
{
  "loginName": "<账号>",
  "no": "__SEC_MAC_PUT_92F7D57E__",
  "wlanMac": "aa:bb:cc:dd:ee:ff",
  "seriaNo": "37fb6ff724b93cca",
  "direction": "0"
}
```

| 字段 | 说明 |
| --- | --- |
| `loginName` | 登录账号 |
| `no` | 设备 MAC（去冒号、小写） |
| `wlanMac` | WiFi MAC；可为空 |
| `seriaNo` | Android ID / 设备序列号 |
| `direction` | `0` 横屏 / 其他值按源码，班牌通常 `0` |

响应 `NewBrandLoginRsp.DataBean` 关键字段：

| 字段 | 说明 |
| --- | --- |
| `brandName` | 班牌名称 |
| `classesId` | 班级 ID |
| `schoolId` | 学校 ID |
| `id` | 班牌/品牌 ID（后续 `layoutlist` 的 `id`） |
| `siteId` / `siteName` | 场地 ID/名称 |
| `loginName` | 登录名 |
| `direction` | 横竖屏 |
| `isSecond` | 是否启用二级页面 |
| `schoolType` | 学校类型 |
| `plaintextPassword` | 服务端返回的明文密码（敏感，仅调试用） |
| `verify` | 验证方式列表（刷卡/人脸/扫码/离线） |
| `badgeUrl` | 校徽/图标 |

### 3.4 第 3 步：首页布局

**接口：** `POST /brand/brand/layoutclasssign/layoutlist`

```json
{
  "id": "<brandId / 设备 id>",
  "showType": 0,
  "deviceType": "2"
}
```

`showType`：`0` 正常皮肤，`1` 使用皮肤（`SpData.SKIN` 为 true 时）。

响应 `LayoutListRsp.DataBean`：

```json
{
  "id": "mock-layout-1",
  "pagination": "1",
  "layoutClassSignDetailsEntityList": [
    {
      "id": "hbbjxx22",
      "moduleId": "hbbjxx22",
      "moduleName": "班级信息",
      "tag": "hbbjxx22",
      "x": 0, "y": 0, "width": 2, "height": 2,
      "size": 4, "current": 1, "total": 1,
      "backgropColour": "#FF1565C0",
      "backgropPhoto": "",
      "borderColor": "#FF42A5F5",
      "descriptive": "班级信息",
      "url": "", "imgType": "", "images": "",
      "jsonParam": "{}", "secPageBackTime": 0, "versionStamp": 1
    }
  ]
}
```

> `HomeFragment` 只使用 `x/y` 做 margin，卡片宽高由各 Fragment 的 XML 决定。Mock 的 `x/y` 是近似值，想 1:1 还原必须拿到真机响应或 `HomeData2`。

### 3.5 二维码登录

| 接口 | 说明 |
| --- | --- |
| `GET /auth/qrcode/gene?type=<type>&schoolId=<id>` | 生成登录二维码；`type=3` 在源码中出现 |
| `GET /auth/qrcode/check?random=<random>` | 轮询扫码结果 |

```bash
curl "https://api.yyide.com/auth/qrcode/gene?type=3&schoolId=<schoolId>" \
  -H "Authorization: Bearer <token>"
```

### 3.6 自动登录与 Token 过期

- App 把 `tokenHead + accessToken` 存到 `SpData.TOKEN`，`refreshToken` 存 `SpData.REFRESHTOKEN`；
- 源码**没有发现**独立的 refresh 接口，Token 过期后一般重新走 `/auth/oauth/token`；
- `LoginActivity`、`WelcomeActivity`、`MainActivity` 都有“保存 token”逻辑；
- 如果接口返回 `code=401`，先检查 `Authorization` 是否带了 `Bearer ` 前缀，再重新登录。

### 3.7 设备激活/绑定流程

首次使用/换设备时：

```text
GET  /manage/machineInfo/getMachineConfigByDeviceNo?deviceNo=<MAC>
POST /cloud/v2/barrier/getRegistrationCode          {no, deviceType:"2", schoolId?}
POST /cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo {deviceNo, deviceType:"2"}
POST /cloud/v2/barrier/updateRegistrationCode       {no, registrationCode, deviceType:"2", schoolId?}
POST /cloud/v2/barrier/getOrBindingDevice           {no, deviceType:"2", type:"3", schoolId?}
POST /cloud/v2/barrier/getAppVersion                {schoolId, versionType:2, deviceType:"2"}
```

详细字段见 [5.2](#52-设备激活绑定与升级)。

---

## 4. 通用约定

### 4.1 HTTP 方法与参数位置

| 注解 | 位置 | 说明 |
| --- | --- | --- |
| `@Query` | URL query | 登录、二维码、部分列表 |
| `@Path` | URL path | `getClassesInfo/{classId}`、`/opac/ctrl/{ctrlNo}` |
| `@Body` | JSON body | 大多数 POST 业务接口 |
| `@Field` / `@FieldMap` | form-urlencoded | TTLock 的 `/oauth2/token`、`/v3/*` |
| `@Part` | multipart | `/app/file/upload`、`/file/upload/path` |

> 表中如果出现 `Query(CommentsHomeFragment.TYPE_CLASSESID)` 或 `Query(CommentsHomeFragment.TYPE_ID)`，实际 query 名分别是 `classesId` 和 `studentId`（见 `CommentsHomeFragment.java:34-35`）。

### 4.2 状态码与错误处理

| `code` | 含义 | 处理 |
| --- | --- | --- |
| `0` | 成功 | 读 `data` |
| `401` | 未登录/Token 失效 | 重新登录，刷新 `Authorization` |
| 其他非 0 | 业务失败 | 展示 `message` / `detailMessage`，不要重试写操作 |

源码 `BaseNetworkApi.getResult()` 在 `code != 0` 时直接抛 `GlobalException`，并 Toast `message`；`AppClient` 的 `ApiCallback` 走 `onFailure`。

### 4.3 文件上传

| 接口 | Content-Type | 字段 |
| --- | --- | --- |
| `POST /app/file/upload` | `multipart/form-data` | `file`（文件名/字节流） |
| `POST /file/upload/path` | `multipart/form-data` | `path`（如 `libBrand`）+ `file` |

响应 `UploadFileBean`：`name`、`size`、`url`。

### 4.4 字符串/数字类型不一致

反编译模型里很多字段是 `String`，但服务端可能返回数字（如 `pageSize`、`total`）。源码用 Gson `GsonTypeAdapterFactory` 做了兼容；自己写脚本时：

- 分页参数优先按源码类型传（`pageSize` 有的接口要字符串，有的要数字）；
- 解析响应时对 `pageNo/pageSize/total/id` 做 `str()` / `int()` 兼容；
- 不要假设 `data` 一定是对象，列表接口可能直接返回数组。

### 4.5 时间与排序

- 时间统一用 `yyyy-MM-dd HH:mm:ss`；
- 公告 `startTime`/`endTime` 是字符串；博客版本用 `startDate`/`endDate` 时间戳，服务端可能两个版本都兼容；
- 课表 `weekTime` 空串表示当前周，也可以传日期。

### 4.6 频率与重试

- 源码 OkHttp 超时：`connect/read/write = 30s`；
- `BaseNetworkApi` 对连接失败重试 2 次；`AppClient` 的 `retryOnConnectionFailure` 为 false；
- 写操作（提交请假、投票、报名、开门）不要自动重试，避免重复提交；
- 轮询类（扫码、MQTT 状态）建议 ≥2s，带退避。

---

## 5. 业务接口（20 类）

> 每节先给“重点接口”的请求/响应示例，再给该分类的**全部接口表**。  
> 表中“参数 / Body”列：`Query(x)`/`Path(x)` 是显式参数；`JSON Body` 表示源码用 `@Body RequestBody`；`multipart/form-data` 是上传。  
> 222 个接口按业务分类，另有重复路径是不同接口文件/不同网络栈的封装，调用时任选其一即可。

### 5.1 鉴权与登录

本类包含 OAuth 登录、二维码登录、`/brand/obtain`、按设备序列号查场地，以及一个**疑似注解错位**的 `INetworkService.login`。

#### 5.1.1 `POST /auth/oauth/token`

完整说明见 [2.2](#22-oauth-密码模式) 和 [3.2](#32-第-1-步换-token)。

#### 5.1.2 `POST /brand/obtain`

完整说明见 [3.3](#33-第-2-步brandobtain-换学校班级场地)。

#### 5.1.3 二维码登录

```http
GET /auth/qrcode/gene?type=3&schoolId=<schoolId>
GET /auth/qrcode/check?random=<random>
```

`LoginQrCodeBean` / `ScanQrCodeBean` 的字段以模型为准；`random` 是生成二维码时返回的随机串，轮询时带回。

#### 5.1.4 `GET /brand/class-brand-management/app/loginCheck/getSiteByUserName`

按设备序列号查场地：

```http
POST /brand/class-brand-management/app/loginCheck/getSiteByUserName?equipmentSerialNumber=<AndroidID>
```

注意源码注解是 `@POST`，但参数是 `@Query`，没有 body。

#### 5.1.5 关于 `INetworkService.login`

`src/main/java/com/yd/android_brand_mvp/network/INetworkService.java:129` 中：

```java
@POST("/brand/brand/mess/recive/index")
Object login(@Query("username") ..., @Query("password") ...);
```

这个路径与登录不符，且 `NetworkApi.login()` 在源码中没有实际调用点（`LoginRepository` 用的是本地 `dataSource.login`，登录页用 `DingApiStores.newLogin`）。它大概率是 JADX 注解错位或历史遗留，**不要按这个路径实现登录**。实际登录用 `POST /auth/oauth/token`。

#### 5.1.6 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/auth/oauth/token` | `newLogin` | `Query(username)` `str`<br>`Query(password)` `str2`<br>`Query(client_id)` `str3`<br>`Query(grant_type)` `str4`<br>`Query(client_secret)` `str5`<br>`Query(random)` `str6` | `NewLoginRsp` |
| 2 | GET | `/auth/qrcode/check` | `getCheckLoginQrCode` | `Query(random)` `str` | `BaseResponse<LoginQrCodeBean>` |
| 3 | GET | `/auth/qrcode/check` | `requestQrCodeCheck` | `Query(random)` `str` | `BaseResponse<ScanQrCodeBean>` |
| 4 | GET | `/auth/qrcode/gene` | `getLoginQrCode` | `Query(type)` `str` | `BaseResponse<LoginQrCodeBean>` |
| 5 | GET | `/auth/qrcode/gene` | `requestQrCode` | `Query(type)` `str`<br>`Query(schoolId)` `str2` | `BaseResponse<ScanQrCodeBean>` |
| 6 | POST | `/brand/brand/mess/recive/index` | `login` | `Query(username)` `str`<br>`Query(password)` `str2`<br>`Query(client_id)` `str3`<br>`Query(grant_type)` `str4`<br>`Query(client_secret)` `str5` | `BaseResponse<NewLoginRsp>` |
| 7 | POST | `/brand/class-brand-management/app/loginCheck/getSiteByUserName` | `getSiteByUserName` | `Query(equipmentSerialNumber)` `str` | `GetSiteByUserNameRsp` |
| 8 | POST | `/brand/obtain` | `getBrandObtain` | JSON Body | `NewBrandLoginRsp` |
| 9 | POST | `/brand/obtain` | `getBrandInfo` | JSON Body | `BaseResponse<NewBrandLoginRsp>` |

---

### 5.2 设备激活、绑定与升级

设备首次上线、换教室、换学校、升级 APK 都走这一组。核心是 `/cloud/v2/barrier/*` 和 `/cloud/v2/equipment/brand/*`。

#### 5.2.1 激活/绑定时序

```text
1. 读取机器配置
   GET /manage/machineInfo/getMachineConfigByDeviceNo?deviceNo=<MAC>
2. 生成注册码
   POST /cloud/v2/barrier/getRegistrationCode
   {"no":"<MAC>","deviceType":"2","schoolId":"<schoolId?>"}
3. 品牌授权码信息
   POST /cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo
   {"deviceNo":"<MAC>","deviceType":"2"}
4. 提交注册码（绑定）
   POST /cloud/v2/barrier/updateRegistrationCode
   {"no":"<MAC>","registrationCode":"<code>","deviceType":"2","schoolId":"<schoolId?>"}
5. 查询绑定设备
   POST /cloud/v2/barrier/getOrBindingDevice
   {"no":"<MAC>","deviceType":"2","type":"3","schoolId":"<schoolId?>"}
6. 检查版本
   POST /cloud/v2/barrier/getAppVersion
   {"schoolId":"<schoolId>","versionType":2,"deviceType":"2"}
```

#### 5.2.2 `GET /manage/machineInfo/getMachineConfigByDeviceNo`

按 MAC 获取机器配置：读卡器品牌/型号/串口/波特率、摄像头角度/预览、主板、主题、人脸状态等。

```json
{
  "cardReaderBrand": 0,
  "cardReaderBrandCode": "0",
  "cardReaderFrequencyCode": "0",
  "cardReaderModel": "MOCK",
  "cardReaderSerialPortCode": "0",
  "cameraAngle": 0,
  "cameraAngleCode": "0",
  "cameraPreview": 0,
  "cameraPreviewCode": "0",
  "motherboardBrand": 0,
  "motherboardBrandCode": "0",
  "motherboardModel": 0,
  "motherboardModelCode": "0",
  "theme": 0,
  "themeCode": "0",
  "faceStatus": false
}
```

#### 5.2.3 注册码相关

| 接口 | 请求体 | 响应 |
| --- | --- | --- |
| `POST /cloud/v2/barrier/getRegistrationCode` | `{"no":"<MAC>","deviceType":"2","schoolId":"..."}` | `getRegistrationCodeRsp` |
| `POST /cloud/v2/barrier/updateRegistrationCode` | `{"no":"<MAC>","registrationCode":"...","deviceType":"2","schoolId":"..."}` | `getRegistrationCodeRsp` |
| `POST /cloud/v2/barrier/getOrBindingDevice` | `{"no":"<MAC>","deviceType":"2","type":"3","schoolId":"..."}` | 绑定信息/注册码 |
| `POST /cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo` | `{"deviceNo":"<MAC>","deviceType":"2"}` | 品牌授权码 |

#### 5.2.4 升级相关

| 接口 | 用途 | 请求体 |
| --- | --- | --- |
| `POST /cloud/v2/barrier/getAppVersion` | 查最新版本 | `{"schoolId":"...","versionType":2,"deviceType":"2"}` |
| `POST /backstage/cloud-backstage/kf/application/getNewestVersion` | 备用版本接口 | 同上/按模型 |
| `POST /brand/brand/updateApkVersion` | 上报当前版本 | `{"id":"<brandId>","apkVersion":"3.0.14"}` |
| `POST /brand/class-brand-management/android/appRegistraCode/insetVersionUpdatedSchool` | 记录学校版本更新 | 按模型 |
| `POST /backstage/cloud-backstage/kf/application/queryClassificList` | 版本分类列表 | 按模型 |

#### 5.2.5 开关与放学日志

| 接口 | 用途 |
| --- | --- |
| `GET /brand/brand/getSwitchsType?id=<brandId>` | 首页/功能开关 |
| `POST /brand/after/school/log/board` | 上报班牌日志 |
| `POST /brand/after/school/log/afterSchool` | 一键放学/放学状态 |

#### 5.2.6 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/backstage/cloud-backstage/kf/application/getNewestVersion` | `getNewestVersion` | JSON Body | `getNewestVersionRsp` |
| 2 | POST | `/backstage/cloud-backstage/kf/application/queryClassificList` | `queryClassificList` | JSON Body | `queryClassificListRsp` |
| 3 | POST | `/brand/after/school/log/afterSchool` | `oneKeySchool` | JSON Body | `BaseResponse<Boolean>` |
| 4 | POST | `/brand/after/school/log/board` | `classesOverInfo` | JSON Body | `BaseResponse<ClassesOverInfoBean>` |
| 5 | GET | `/brand/brand/getSwitchsType` | `switchNewList` | `Query(id)` `str` | `switchlistRsp` |
| 6 | POST | `/brand/brand/updateApkVersion` | `updateApkVersion` | JSON Body | `Object` |
| 7 | POST | `/brand/class-brand-management/android/appRegistraCode/insetVersionUpdatedSchool` | `insetVersionUpdatedSchool` | JSON Body | `insetVersionUpdatedSchoolRsp` |
| 8 | POST | `/cloud/v2/barrier/getAppVersion` | `getNewestVersion` | JSON Body | `getNewestVersionRsp` |
| 9 | POST | `/cloud/v2/barrier/getOrBindingDevice` | `getOrBindingDevice` | JSON Body | `getRegistrationCodeRsp` |
| 10 | POST | `/cloud/v2/barrier/getOrBindingDevice` | `getActivationCode` | JSON Body | `BaseResponse<getRegistrationCodeRsp>` |
| 11 | POST | `/cloud/v2/barrier/getOrBindingDevice` | `getActivationCode` | JSON Body | `BaseResponse<getRegistrationCodeRsp.RegistrationCode>` |
| 12 | POST | `/cloud/v2/barrier/getRegistrationCode` | `getRegistrationCode` | JSON Body | `getRegistrationCodeRsp` |
| 13 | POST | `/cloud/v2/barrier/getRegistrationCode` | `getRegistrationCode` | JSON Body | `BaseResponse<getRegistrationCodeRsp>` |
| 14 | POST | `/cloud/v2/barrier/updateRegistrationCode` | `updateNewRegistrationCodeByCode` | JSON Body | `getRegistrationCodeRsp` |
| 15 | POST | `/cloud/v2/barrier/updateRegistrationCode` | `updateNewRegistrationCodeByCode` | JSON Body | `BaseResponse<getRegistrationCodeRsp>` |
| 16 | POST | `/cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo` | `getBrandRegistrationCode` | JSON Body | `BrandRegistrationCodeRsp` |
| 17 | POST | `/cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo` | `getBrandRegistrationCode` | JSON Body | `BaseResponse<BrandRegistrationCodeRsp>` |
| 18 | GET | `/manage/machineInfo/getMachineConfigByDeviceNo` | `requestDeviceConfig` | `Query(deviceNo)` `str` | `BaseResponse<BrandConfigBean>` |

---

### 5.3 学校、班级与首页布局

这一组决定班牌“长什么样”：校园样式、班级信息、班级口号、学期/校历/提醒/倒计时、首页模块布局、霸屏/自定义模式、场地/地区。

#### 5.3.1 `POST /brand/brand/layoutclasssign/layoutlist`（首页布局）

完整请求/响应见 [3.4](#34-第-3-步首页布局)。

补充：

- `showType=1` 时走皮肤；
- `id` 用 `/brand/obtain` 返回的 `DataBean.id`；
- 模块 `tag` 决定首页用哪个 Fragment 渲染；
- 常见 tag：`hbbjxx22`（班级信息）、`hbryq22`（班级荣誉）、`hbbjxc23`（班级相册）、`hbtzgg24`（通知公告）、`hbbjsp23`（视频展示）、`sbkb42`（学生课表）、`hbcdxx_46`/`hbcdxx_66`（场地信息）等。

#### 5.3.2 班级信息与口号

| 接口 | 说明 |
| --- | --- |
| `GET /brand/brand/classes/info?classesId=<id>` | 班级信息（`NewClassInfoRsp`） |
| `POST /brand/brand/classes/watchword/list` · body `{"classesId":"<id>"}` | 班级口号/班主任寄语 |
| `GET /management/cloud-system/pc/getClassesInfo/{classId}` | PC 端班级详情 |
| `POST /brand/class-brand-management/android/class/selectClassesInfo?brandClassLoginName=<loginName>` | 按班牌登录名选班级 |

`watchword` 响应示例：

```json
[
  {"id": "w1", "classesId": 1, "project": "班级口号", "projectValue": "团结奋进，快乐成长", "sort": 1},
  {"id": "w2", "classesId": 1, "project": "班主任", "projectValue": "王老师", "sort": 2}
]
```

#### 5.3.3 校园样式与教师

| 接口 | 说明 |
| --- | --- |
| `GET /brand/brand/campus/style` | 学校 Logo、主题色、背景 |
| `POST /brand/brand/campus/teachers` | 教师列表 |

#### 5.3.4 学期、校历、提醒、倒计时

| 接口 | 说明 |
| --- | --- |
| `GET /brand/brand/school/semester/current` | 当前学期 |
| `POST /cloud/brand/calendar/getSchoolCalendar` | 学校校历 |
| `POST /cloud/calendar/selectSchoolCalendar` | 查询某月校历 |
| `GET /brand/brand/remind/list?brandId=<id>` | 提醒列表 |
| `GET /brand/brand/countdown/list?classesId=<id>` | 倒计时（考试/活动） |

#### 5.3.5 霸屏/自定义模式

| 接口 | 说明 |
| --- | --- |
| `GET /brand/v2/custom/mode/list?brandId=<id>` | 自定义霸屏模式列表 |
| `GET /brand/brand/getBrandDominateScreen` | 当前霸屏配置 |
| `POST /brand/layoutclasssign/getVideoStreams` | 视频流/摄像头（见 5.20） |

#### 5.3.6 场地与地区

| 接口 | 说明 |
| --- | --- |
| `GET /cloud/site/getSite?id=<siteId>` | 场地详情 |
| `GET /app/area/list` | 省市区列表（天气/地址选择） |

#### 5.3.7 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | GET | `/app/area/list` | `requestAreaInfo` | — | `BaseResponse<List<AreaBean>>` |
| 2 | GET | `/brand/brand/campus/style` | `SchoolStyle` | — | `SchoolStytleRsp` |
| 3 | POST | `/brand/brand/campus/teachers` | `Teachers` | JSON Body | `TeachersRsp` |
| 4 | GET | `/brand/brand/classes/info` | `selectNewClassesInfo` | `Query(CommentsHomeFragment.TYPE_CLASSESID)` `str` | `NewClassInfoRsp` |
| 5 | GET | `/brand/brand/classes/info` | `getClassesInfo` | — | `BaseResponse<NewClassInfoRsp.DataDTO>` |
| 6 | POST | `/brand/brand/classes/watchword/list` | `getWatchWord` | JSON Body | `NewWatchWordRsp` |
| 7 | POST | `/brand/brand/classes/watchword/list` | `getWatchWord` | JSON Body | `BaseResponse<List<NewWatchWordRsp.DataDTO>>` |
| 8 | GET | `/brand/brand/countdown/list` | `getNewCountdownList` | `Query(CommentsHomeFragment.TYPE_CLASSESID)` `str` | `TimelistRsp` |
| 9 | GET | `/brand/brand/getBrandDominateScreen` | `requestDominateScreenLevel` | — | `BaseResponse<List<DominateDetailLevelBean>>` |
| 10 | POST | `/brand/brand/layoutclasssign/layoutlist` | `getNewLayoutList` | JSON Body | `LayoutListRsp` |
| 11 | GET | `/brand/brand/remind/list` | `newRemind` | `Query(brandId)` `str` | `NewRemindRsp` |
| 12 | GET | `/brand/brand/school/semester/current` | `getSemesterTime` | — | `BaseResponse<SemesterTimeRsp>` |
| 13 | POST | `/brand/class-brand-management/android/class/selectClassesInfo` | `selectClassesInfo` | `Query(brandClassLoginName)` `str` | `selectClassesInfoRsp` |
| 14 | GET | `/brand/v2/custom/mode/list` | `requestDominateScreenLevel` | `Query(brandId)` `str` | `BaseResponse<List<DominateDetailLevelBean>>` |
| 15 | GET | `/brand/v2/custom/mode/list` | `requestCustomDominateScreenList` | `Query(brandId)` `str` | `BaseResponse<List<DominateCustomBean>>` |
| 16 | POST | `/cloud/brand/calendar/getSchoolCalendar` | `getSchoolCalendar` | JSON Body | `getSchoolCalendarRsp` |
| 17 | POST | `/cloud/calendar/selectSchoolCalendar` | `selectSchoolCalendar` | JSON Body | `selectSchoolCalendarRsp` |
| 18 | GET | `/cloud/site/getSite` | `requestSiteInfo` | `Query(id)` `str` | `BaseResponse<SiteInfoBean>` |
| 19 | GET | `/management/cloud-system/pc/getClassesInfo/{classId}` | `getClassesInfo` | `Path(classId)` `j` | `ClassesInfoBean` |

---

### 5.4 首页卡片与班级展示

首页卡片的数据源：班级相册、视频、学生作品、值日、天气、本周作业。

#### 5.4.1 班级相册/视频

| 接口 | 请求体 | 说明 |
| --- | --- | --- |
| `POST /brand/brand/album/list` | `{"classesId":"<id>","kind":"1","type":"1","limitNum":10}` | 图片列表 |
| `POST /brand/brand/album/index` | `{"classesId":"<id>","kind":"1","type":"2"}` | 视频列表 |
| `POST /brand/brand/album/listDetail` | `{"classesId":"<id>","kind":"1","type":"1"}` | 图片详情/全部 |
| `POST /brand/class-brand-management/android/videoalbum/classifylist` | `{"classesId":"<id>"}` | 视频分类 |

响应示例（`album/list`）：

```json
[
  {"type": "1", "url": "http://10.0.2.2:8765/mock/img/photo1.png"}
]
```

`type`：`"1"` 图片，`"2"` 视频；`url` 可直接给 Glide/IjkPlayer。

#### 5.4.2 学生作品

| 接口 | 请求/参数 | 说明 |
| --- | --- | --- |
| `POST /brand/brand/studentwork/list` | `{"classesId":"<id>","pageNo":"1","pageSize":"10"}` | 作品列表 |
| `GET /brand/brand/studentwork/selectStudentInfo?id=<workId>` | Query `id` | 作品详情/作者 |
| `POST /brand/brand/studentwork/workComment` | `{"workId":"...","content":"..."}` | 评论 |
| `GET /brand/brand/studentwork/workLike?id=<workId>&userId=<userId>` | Query | 点赞 |

作品列表响应字段：`id`、`workName`、`workDesc`、`studentName`、`studentId`、`classesId`、`schoolId`、`createdDateTime`、`likeCount`、`commentCount`、`isLike`、`isFine`、`avatar`、`userImg`、`worksUrl[]`、`workCommentVos[]`。

#### 5.4.3 值日

| 接口 | 请求/参数 | 说明 |
| --- | --- | --- |
| `GET /brand/brand/studentduty/selectRecord` | 无参数/按模型 | 旧值日记录 |
| `POST /brand/brand/v3/studentduty/selectRecord` | JSON Body | 新值日周列表 |
| `GET /brand/class-brand-management/app/studentDuty/selectRecord?classId=<id>` | Query | 按班级查值日 |

#### 5.4.4 天气

| 接口 | 请求体 | 说明 |
| --- | --- | --- |
| `POST /brand/weather/now` | `{}` | 当前天气 |
| `POST /brand/weather/day7` | `{}` | 7 天天气 |
| `GET https://zhwnlapi.etouch.cn/Ecalender/weather_mini?city=<city>` | Query | 第三方天气（`WeatherApiStores`） |

天气字段：`city`、`temp`、`weather`、`humidity`、`wind`、`aqi`、`quality`、`forecast[]` 等；不同接口字段不同。

#### 5.4.5 本周作业

`POST /cloud/app/work/pageThisWeekWork`，body 按 `StudentTaskBean` 请求模型；响应为作业列表（`StudentTaskBean`）。

#### 5.4.6 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | GET | `/Ecalender/weather_mini` | `getWeather` | `Query(city)` `str` | `WeatherRsp` |
| 2 | POST | `/brand/brand/album/index` | `getHomeVideo` | JSON Body | `VideoListBean` |
| 3 | POST | `/brand/brand/album/list` | `getNewClassPhotoList` | JSON Body | `VideoListBean` |
| 4 | POST | `/brand/brand/album/listDetail` | `getNewPhotoList` | JSON Body | `PhotoAlbumTwoBean` |
| 5 | GET | `/brand/brand/studentduty/selectRecord` | `getNewStudentDuty` | — | `StudenDutyBean` |
| 6 | POST | `/brand/brand/studentwork/list` | `getNewStudentWorkList` | JSON Body | `StudentWorkListBean` |
| 7 | GET | `/brand/brand/studentwork/selectStudentInfo` | `selectNewStudentInfo` | `Query(id)` `str` | `StudentInfoBean` |
| 8 | POST | `/brand/brand/studentwork/workComment` | `setNewWorkComment` | JSON Body | `NewWorkCommentRsp` |
| 9 | GET | `/brand/brand/studentwork/workLike` | `setNewWorkLike` | `Query(id)` `str`<br>`Query(userId)` `str2` | `NewWorkCommentRsp` |
| 10 | POST | `/brand/brand/v3/studentduty/selectRecord` | `getDutyWeekList` | JSON Body | `BaseResponse<List<DutyModel>>` |
| 11 | POST | `/brand/class-brand-management/android/videoalbum/classifylist` | `getPhotoAlbumTablist` | JSON Body | `PhotoAlbumTabBean` |
| 12 | GET | `/brand/class-brand-management/app/studentDuty/selectRecord` | `getStudentDuty` | `Query(classId)` `str` | `StudenDutyBean` |
| 13 | POST | `/brand/weather/day7` | `getNewWeatherList` | JSON Body | `BaseResponse<NewWeatherListBean>` |
| 14 | POST | `/brand/weather/now` | `getNewWeather` | JSON Body | `BaseResponse<NewWeatherBean>` |
| 15 | POST | `/cloud/app/work/pageThisWeekWork` | `getNewTaskList` | JSON Body | `StudentTaskBean` |

---

### 5.5 消息公告与 IM

#### 5.5.1 `POST /brand/brand/mess/recive/page`（公告分页）

源码/抓包里的请求体（班牌端）：

```json
{
  "identifier": "announcement",
  "pageNo": 1,
  "pageSize": "18",
  "approverId": "<brandId>",
  "startTime": "2026-10-11 00:00:00",
  "endTime": "2026-10-18 17:16:38"
}
```

博客版本（Python/Flask）用的是：

```json
{
  "pageNo": 1,
  "pageSize": 20,
  "type": "announcement",
  "searchKey": "",
  "startDate": "",
  "endDate": ""
}
```

服务端可能同时接受两套字段；优先按班牌端的 `identifier/approverId/startTime/endTime`。

响应：

```json
{
  "code": 0,
  "message": "操作成功",
  "detailMessage": null,
  "success": true,
  "error": false,
  "data": {
    "list": [
      {
        "id": "2094265167356387330",
        "identityUserName": "马品",
        "coverImg": "",
        "author": "",
        "source": "",
        "title": "重磅！重庆市青少年创新人才培养雏鹰计划（初中）第七期学员遴选通知",
        "content": "<p>...</p>",
        "contentType": 0,
        "messType": 1,
        "timerDate": "2026-08-31 11:25:00",
        "attachments": [],
        "isTop": true
      }
    ],
    "total": 5,
    "pageNo": 1,
    "pageSize": 20
  }
}
```

| 字段 | 说明 |
| --- | --- |
| `id` | 公告 ID |
| `identityUserName` | 发布人 |
| `title` / `content` | 标题/正文（HTML） |
| `contentType` | `0` 图文 |
| `messType` | `1` 通知公告 |
| `timerDate` | 发布时间 |
| `attachments` | 附件列表 |
| `isTop` | 是否置顶 |

#### 5.5.2 消息首页/霸屏消息

| 接口 | 说明 |
| --- | --- |
| `GET /brand/brand/mess/recive/index` | 消息首页聚合 |
| `POST /brand/brand/mess/recive/dominateScreen/list` | 霸屏消息列表 |
| `POST /brand/brand/mess/recive/page` | 公告/消息分页（多个封装） |

#### 5.5.3 字幕/跑马灯

`GET /cloud/device/mess/publish/getCaptionsNoticeInfo?schoolId=<id>&deviceId=<id>`

响应字段：`id`、`content`、`textColor`、`backgroundColor`、`backgroundTransparency`、`rollSpeed`、`fontSize`、`position`、`circulationMode`、`circulationNumber`、`intervalTime`、`isShowBtn`、`playCount`、`playTime`、`isPlaySuccess`。

#### 5.5.4 IM UserSig

| 接口 | 参数 | 说明 |
| --- | --- | --- |
| `GET /cloud/im/user/sig/gen?identifier=<userId>` | Query | 生成普通用户 UserSig |
| `GET /cloud/im/user/sig/getSystemSig` | 无 | 系统号 UserSig |
| `POST /management/cloud-system/im/getUserSigByUserId` | JSON Body | 按 userId 获取 |

拿到 UserSig 后：

```java
TUIKit.login(userId, userSig, callback);
TUIKit.init(context, GenerateTestUserSig.SDKAPPID, configs);
```

腾讯云 IM 的 SDKAppID/SecretKey 见 本地凭据；不要在客户端生成 UserSig。

#### 5.5.5 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/brand/brand/mess/recive/dominateScreen/list` | `getMessageDominateScreenList` | JSON Body | `BaseResponse<List<MessageItemBean>>` |
| 2 | POST | `/brand/brand/mess/recive/dominateScreen/list` | `requestMessageDominateScreenList` | JSON Body | `BaseResponse<List<MessageItemBean>>` |
| 3 | GET | `/brand/brand/mess/recive/index` | `requestMessageHome` | — | `BaseResponse<MessageListBean>` |
| 4 | POST | `/brand/brand/mess/recive/page` | `getNewNoticeWithPag` | JSON Body | `getNoticeRsp` |
| 5 | POST | `/brand/brand/mess/recive/page` | `requestMessage` | JSON Body | `BaseResponse<getNoticeRsp.DataDTO>` |
| 6 | POST | `/brand/brand/mess/recive/page` | `requestMessageList` | JSON Body | `BaseResponse<BasePageResponse<List<MessageItemBean>>>` |
| 7 | GET | `/cloud/device/mess/publish/getCaptionsNoticeInfo` | `getCaptionsNoticeInfo` | `Query(schoolId)` `str`<br>`Query(deviceId)` `str2` | `BaseResponse<MessageCaptionBean>` |
| 8 | GET | `/cloud/device/mess/publish/getCaptionsNoticeInfo` | `requestHomeCaption` | `Query(schoolId)` `str`<br>`Query(deviceId)` `str2` | `BaseResponse<MessageCaptionBean>` |
| 9 | GET | `/cloud/im/user/sig/gen` | `getUserSig` | `Query(identifier)` `str` | `getUserSigByUserIdRsp` |
| 10 | GET | `/cloud/im/user/sig/gen` | `getUserSig` | `Query(identifier)` `str` | `BaseResponse<getUserSigByUserIdRsp.DataBean>` |
| 11 | GET | `/cloud/im/user/sig/getSystemSig` | `getSystemSign` | — | `BaseResponse<String>` |
| 12 | POST | `/management/cloud-system/im/getUserSigByUserId` | `getUserSigByUserId` | JSON Body | `getUserSigByUserIdRsp` |

---

### 5.6 课表

#### 5.6.1 `POST /cloud/app/timetable/getWeekTime`

班级课表：

```json
{
  "weekTime": "",
  "typeId": "<classesId>",
  "type": "1"
}
```

教师/学生课表在 `HomePresenter` 里用 `type:"2"` + `typeId:<teacherId/studentId>`；以实际账号身份为准。

响应 `KBRsp2.DataDTO`：

| 字段 | 说明 |
| --- | --- |
| `thisWeek` | 当前周 |
| `weekTotal` | 总周数 |
| `siteClassesName` | 班级名 |
| `weekList` | 周一到周日日期 |
| `sectionList` | 早自习/上午/下午/晚自习节次 |
| `timetableList[]` | 课程：`id`、`date`、`week`、`section`、`sectionName`、`startTime`、`endTime`、`subjectName`、`courseType`、`sectionType`、`teacherList[]` |

#### 5.6.2 `POST /brand/class-brand-management/android/course/classSchedule`

按班级/教师查课表，body 按 `ClassScheduleRsp` 请求模型；`UserTable`/`getClassSchedule` 两个封装。

#### 5.6.3 `POST /timetable/cloud-timetable/v1/kcb/classes`

Query：`bjid`（班级 ID）、`skzc`（周次）。返回 `KBRsp`。

#### 5.6.4 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/brand/class-brand-management/android/course/classSchedule` | `UserTable` | JSON Body | `UserTableRsp` |
| 2 | POST | `/brand/class-brand-management/android/course/classSchedule` | `getClassSchedule` | JSON Body | `ClassScheduleRsp` |
| 3 | POST | `/cloud/app/timetable/getWeekTime` | `getCDKB` | JSON Body | `KBRsp2` |
| 4 | POST | `/cloud/app/timetable/getWeekTime` | `requestCourseList` | JSON Body | `BaseResponse<KBRsp2.DataDTO>` |
| 5 | POST | `/cloud/app/timetable/getWeekTime` | `getCDKB` | JSON Body | `KBRsp2` |
| 6 | POST | `/timetable/cloud-timetable/v1/kcb/classes` | `getKB` | `Query(bjid)` `str`<br>`Query(skzc)` `str2` | `KBRsp` |

---

### 5.7 考勤与打卡

#### 5.7.1 今日考勤

`POST /attweb/app/attendance/listToDay`

源码有多种 body：

```json
{"attendanceTimeIds": []}
```

```json
{"timetableId": "<timetableId>"}
```

```json
{"attendanceTimeIds": ["<id>"], "siteTimetableId": "<id>"}
```

响应 `AttenceNewListBean`：

```json
[
  {
    "name": "上午考勤",
    "total": 32,
    "normalNum": 29,
    "beLateNum": 1,
    "leaveEarlyNum": 0,
    "leaveNum": 1,
    "absenteeismNum": 1,
    "startDate": "08:00",
    "endDate": "11:40",
    "type": 1,
    "attendanceId": "a1",
    "attendanceTimeId": "at1"
  }
]
```

#### 5.7.2 考勤明细

`POST /attweb/app/attendance/listToDayDetail`

```json
{
  "attendanceTimeId": "<id>",
  "attendanceId": "<id>",
  "type": "<type>"
}
```

响应 `AttanceTodatDetailsRsp.DataDTO`：`absenteeismList`、`beLateList`、`leaveEarlyList`、`leaveList`（学生姓名/ID 列表）。

#### 5.7.3 场地考勤

`POST /attweb/app/attendance/getAttendanceSiteTimetable`

```json
{"timetableIds": ["c7"]}
```

#### 5.7.4 考勤规则与刷卡签到

| 接口 | 参数/请求体 | 说明 |
| --- | --- | --- |
| `GET /attweb/app/attendance/getBrandAttendanceRule?no=<MAC>` | Query | 考勤规则 |
| `GET /attweb/app/attendance/getBrandAttendanceUser?id=<id>` | Query | 考勤用户 |
| `GET /attweb/app/attendance/getAttendanceEventTimetableByClasses?classesId=<id>` | Query | 事件课表 |
| `POST /attweb/app/attendance/createBrandAttendanceSignIn` | JSON 数组 | 班牌签到 |

签到 body 是 `PostAttenceBean[]`：

```json
[
  {
    "attendanceIds": "a1",
    "deviceName": "班牌01",
    "deviceNo": "__SEC_MAC_PUT_92F7D57E__",
    "signInImg": "",
    "signInTime": "2026-10-19 08:01:00",
    "siteId": "site-1",
    "siteName": "教学楼A",
    "siteTimetableId": "",
    "studentId": "student-1",
    "timetableId": "c1",
    "type": "1"
  }
]
```

#### 5.7.5 人脸考勤

| 接口 | 说明 |
| --- | --- |
| `POST /face/cloud-face/attendance/peopleAttendance` | 人员考勤（人脸） |
| `POST /face/cloud-face/attendance/viewCbAttendance` | 考勤统计/列表 |
| `POST /face/cloud-face/attendance/brand/app/v2/queryBrandAttendanceByClassIds` | 按班级查考勤 |

#### 5.7.6 打卡任务

| 接口 | 说明 |
| --- | --- |
| `POST /attweb/attendanceSignTask/brand/list` | 我的任务列表 |
| `POST /attweb/attendanceSignTask/brand/get` | 任务详情 |
| `POST /attweb/attendanceSignTask/brand/sign` | 打卡 |
| `POST /attweb/attendanceSignTask/brand/brandBillBoard` | 任务看板 |
| `POST /attweb/attendanceSignTask/app/add` | 新建任务 |
| `POST /attweb/attendanceSignTask/app/update` | 修改任务 |
| `POST /attweb/attendanceSignTask/app/delete` | 删除任务 |

任务列表 body 示例：

```json
{
  "status": "not_start",
  "pageNo": 1,
  "pageSize": 20,
  "studentId": "student-1",
  "schoolId": "mock-school-001"
}
```

#### 5.7.7 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/attweb/app/attendance/createBrandAttendanceSignIn` | `brandAttendanceClock` | JSON Body | `GeneralBean2` |
| 2 | GET | `/attweb/app/attendance/getAttendanceEventTimetableByClasses` | `getAttenceKB` | `Query(CommentsHomeFragment.TYPE_CLASSESID)` `str` | `KBRsp2` |
| 3 | POST | `/attweb/app/attendance/getAttendanceSiteTimetable` | `getAttendanceSiteTimetable` | JSON Body | `BaseResponse<List<SiteAttendanceBean>>` |
| 4 | GET | `/attweb/app/attendance/getBrandAttendanceRule` | `Attendlist` | `Query(no)` `str` | `AttencelistRsp2` |
| 5 | GET | `/attweb/app/attendance/getBrandAttendanceUser` | `getBrandAttendanceUser` | `Query(id)` `str` | `AttenceUser` |
| 6 | POST | `/attweb/app/attendance/listToDay` | `queryBrandAttendanceByAttendanceTimeId` | JSON Body | `AttenceNewListBean` |
| 7 | POST | `/attweb/app/attendance/listToDay` | `requestAttendance` | JSON Body | `BaseResponse<List<AttenceNewListBean.DataDTO>>` |
| 8 | POST | `/attweb/app/attendance/listToDayDetail` | `listToDayDetail` | JSON Body | `AttanceTodatDetailsRsp` |
| 9 | POST | `/attweb/attendanceSignTask/app/add` | `requestAddTask` | JSON Body | `BaseResponse<String>` |
| 10 | POST | `/attweb/attendanceSignTask/app/delete` | `requestDeleteTask` | JSON Body | `BaseResponse<String>` |
| 11 | POST | `/attweb/attendanceSignTask/app/update` | `requestUpdateTask` | JSON Body | `BaseResponse<String>` |
| 12 | POST | `/attweb/attendanceSignTask/brand/brandBillBoard` | `requestTaskList` | JSON Body | `BaseResponse<List<MyTaskListItem>>` |
| 13 | POST | `/attweb/attendanceSignTask/brand/get` | `requestTaskDetail` | JSON Body | `BaseResponse<TaskDetailBean>` |
| 14 | POST | `/attweb/attendanceSignTask/brand/list` | `requestMyTaskList` | JSON Body | `BaseResponse<MyTaskListBean>` |
| 15 | POST | `/attweb/attendanceSignTask/brand/sign` | `requestSignTask` | JSON Body | `BaseResponse<String>` |
| 16 | POST | `/face/cloud-face/attendance/brand/app/v2/queryBrandAttendanceByClassIds` | `queryBrandAttendanceByClassIds` | JSON Body | `AttenceListBean` |
| 17 | POST | `/face/cloud-face/attendance/peopleAttendance` | `attendance` | JSON Body | `GeneralBean` |
| 18 | POST | `/face/cloud-face/attendance/viewCbAttendance` | `getAttencelist` | JSON Body | `AttenceBean` |

---

### 5.8 刷卡、人脸与身份识别

#### 5.8.1 两步识别流程

班牌刷卡不是“一次接口”，而是：

```text
1. POST /brand/brand/Authority/selectUserInfoByIcCard
   {"icCardNo":"8888888888"}
   -> UserIcCardBean.DataBean {userId, name, isStudent, schoolId, classesId, identityId}

2. 学生：POST /brand/brand/Authority/selectStudentByIcCard
         {"userId":"<userId>","type":"<type>"}
   教师：POST /brand/brand/Authority/selectTeacherByIcCard
         {"userId":"<userId>","type":"<type>"}
   -> 学生/教师完整信息
```

`CheackMsgPresenter` 的实际代码就是这样：先 `selectUserInfoByIcCard`，再按 `isStudent` 调学生/教师接口。

有的旧页面直接 `selectStudentByIcCard` 传 `icCardNo`；Mock Server 同时兼容两种：

```json
{"icCardNo": "1234567890"}
```

或

```json
{"userId": "student-1", "type": "1"}
```

#### 5.8.2 用户信息响应

`selectUserInfoByIcCard` → `UserIcCardBean.DataBean`：

```json
{
  "id": "student-1",
  "userId": "student-1",
  "name": "张三",
  "userName": "张三",
  "isStudent": true,
  "icCardNo": "8888888888",
  "schoolId": "mock-school-001",
  "classesId": "mock-class-001",
  "identityId": "identity-1"
}
```

学生接口额外返回：`className`、`teacherName`、`avatar`；教师接口返回：`cardNo`、`jobNumber`、`jobTitle`、`position` 等。

#### 5.8.3 教师密码验证（门禁）

`POST /brand/brand/Authority/checkIotControlByPassword`

用于门禁/物联网控制的教师验证，body 按 `VerifyTeacherLoginBean` 请求模型（密码/账号字段）。返回 `VerifyTeacherLoginBean`。

#### 5.8.4 刷脸/刷卡签到日志

`POST /brand/upload/signInLog`，body 按签到日志模型；`AllFaceFragment` / `AllCardFragment` 使用。

#### 5.8.5 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/brand/brand/Authority/checkIotControlByPassword` | `verifyTeacherLogin` | JSON Body | `BaseResponse<VerifyTeacherLoginBean>` |
| 2 | POST | `/brand/brand/Authority/selectStudentByIcCard` | `selectNewStudentByIcCard` | JSON Body | `selectNewStudentByIcCardRsp` |
| 3 | POST | `/brand/brand/Authority/selectStudentByIcCard` | `selectNewStudentByIcCard` | JSON Body | `BaseResponse<selectNewStudentByIcCardRsp.DataBean>` |
| 4 | POST | `/brand/brand/Authority/selectTeacherByClassesId` | `selectNewTeacherByClassesId` | JSON Body | `selectTeacherByClassesIdRsp` |
| 5 | POST | `/brand/brand/Authority/selectTeacherByIcCard` | `selectNewTeacherByIcCard` | JSON Body | `selectTeacherByIcCardRsp` |
| 6 | POST | `/brand/brand/Authority/selectTeacherByIcCard` | `selectTeacherInfoByCardOrFace` | JSON Body | `BaseResponse<selectTeacherByIcCardRsp.DataDTO>` |
| 7 | POST | `/brand/brand/Authority/selectUserInfoByIcCard` | `selectNewUserInfoByIcCard` | JSON Body | `UserIcCardBean` |
| 8 | POST | `/brand/brand/Authority/selectUserInfoByIcCard` | `selectUserByCardOrFace` | JSON Body | `BaseResponse<UserIcCardBean.DataBean>` |
| 9 | POST | `/brand/class-brand-management/Android/Authority/selectTeacherByIcCard` | `selectTeacherByIcCard` | JSON Body | `selectTeacherByIcCardRsp` |
| 10 | POST | `/brand/class-brand-management/android/studentspace/selectStudentByIcCard` | `selectStudentByIcCard` | JSON Body | `selectStudentByIcCardRsp` |
| 11 | POST | `/brand/upload/signInLog` | `pauschCard` | JSON Body | `BaseResponse<String>` |

---

### 5.9 学生空间、请假与报修

学生空间左侧：课表、请假、报名、打卡、消息、荣誉、意见箱、考试、勋章。这里主要是请假/报修/意见箱/通讯录。

#### 5.9.1 请假表单

`GET /app/formProcessTemplates/getDefaultStudentLeave`

响应 `LeaveFormBean`：

```json
{
  "settings": "{}",
  "process": "{}",
  "isStop": false,
  "promoterType": "student",
  "fromKey": "leave",
  "icon": "",
  "remark": "学生请假",
  "isNew": true,
  "formGroupId": "1",
  "isDefault": true,
  "formItems": "[]",
  "background": "",
  "formName": "学生请假",
  "schoolId": "mock-school-001",
  "id": "leave-form-1",
  "kitKey": "student_leave"
}
```

`formItems` 是**字符串化的 JSON**，里面是动态表单组件；`FormComponentUtil.getComponentFragment()` 在 JADX 里没有方法体，所以模拟包改用原生 `MockLeaveActivity`。

#### 5.9.2 请假流程

| 接口 | 请求体 | 说明 |
| --- | --- | --- |
| `POST /app/v2/proc/getFlowElements` | `{"fromKey":"studentLeave_<schoolId>","studentId":"<id>","fromComponent":"<formJson>"}` | 获取审批流节点 |
| `POST /app/v2/proc/startInstance` | `{"fromKey":"studentLeave_<schoolId>","formItems":"[]","assigneeId":"<studentId>","assigneeName":"张三","flowElementList":[]}` | 提交请假 |
| `POST /app/v2/proc/updateApprovalProc` | JSON Body | 修改审批流 |
| `POST /app/v2/proc/deleteInstance` | JSON Body | 撤销流程 |

`startInstance` 实际字段会随表单/审批流变化；上面是源码 `StudentApplyLeaveViewModel` 的字段。

#### 5.9.3 请假记录/详情/撤销

| 接口 | 参数/请求体 | 说明 |
| --- | --- | --- |
| `POST /cloud/app/userAppr/page` | `{"pageNo":"1","pageSize":"20","userId":"<id>"}` | 旧版请假记录 |
| `POST /app/v2/proc/pageTask` | `{"pageNo":1,"pageSize":20,"type":3,"assignee":"<studentId>","fromKey":"studentLeave_<schoolId>","queryNewStatus":true}` | 新版请假记录 |
| `GET /app/userAppr/v2/getInfo?id=<id>` | Query | 新版详情 |
| `GET /cloud/app/userAppr/getInfo?id=<id>` | Query | 旧版详情 |
| `POST /cloud/app/procAppr/deleteInstance` | `{"processInstanceId":"...","deleteReason":""}` | 旧版撤销 |
| `POST /app/v2/proc/deleteInstance` | `{"processInstanceId":"...","schoolId":"...","assigneeId":"...","sponsorType":0,"assigneeName":"..."}` | 新版撤销 |
| `GET /cloud/actLeaveVacation/list?type=0` | Query | 请假类型 |
| `POST /app/actLeaveVacation/calculateLeaveDays` | `{"startTime":"...","endTime":"...","durationType":"...","durationWay":"...","userId":"<studentId>"}` | 计算请假天数 |

旧版提交请假：

`POST /cloud/proc/startInstance`

```json
{
  "jsonData": "...",
  "procId": "<processId>",
  "dept": "<deptId>",
  "isBack": false,
  "deptName": "一年级1班",
  "apprs": [],
  "ccIds": "",
  "sponsorType": "0",
  "identityUserId": "<userId>"
}
```

`LocalApiStores` 还有一个备用提交：

`POST /leave-server/cloud-leave/student/addStudentLeaveByStudentUserId`

#### 5.9.4 报修

| 接口 | 参数/请求体 | 说明 |
| --- | --- | --- |
| `GET /cloud/formProcessTemplates/getByKey?formKey=teacherDeviceRepair` | Query | 报修表单模板 |
| `POST /app/userAppr/pageDeviceAppr` | `{"pageNo":1,"pageSize":20,"schoolId":"...","siteId":"...","queryNewStatus":true}` | 报修列表 |
| `POST /app/v2/proc/startInstance` | 同请假 | 提交报修 |
| `POST /app/v2/proc/deleteInstance` | 同请假 | 撤销报修 |

#### 5.9.5 意见箱

| 接口 | 参数/请求体 | 说明 |
| --- | --- | --- |
| `GET /cloud/leaveWord/getLeaveWordSetting?type=1` | Query | 意见箱配置 |
| `POST /cloud/leaveWord/brand/create` | `{"classesId":"...","content":"...","userId":"...","type":"1","anonymity":false}` | 提交意见 |
| `POST /cloud/leaveWord/page` | `{"pageNo":1,"pageSize":20,...}` | 意见列表 |
| `GET /cloud/leaveWord/get?id=<id>` | Query | 意见详情 |
| `GET /cloud/leaveWord/delete?id=<id>` | Query | 删除意见 |

#### 5.9.6 通讯录/学生列表

| 接口 | 参数 | 说明 |
| --- | --- | --- |
| `GET /cloud/address/book/student?studentId=<id>` | Query | 学生通讯录 |
| `POST /cloud/student/allStudents` | `{"pageNo":1,"pageSize":100,"id":"<classesId>","type":4,"key":"classes"}` | 班级学生列表 |

#### 5.9.7 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/app/actLeaveVacation/calculateLeaveDays` | `requestLeaveLength` | JSON Body | `BaseResponse<String>` |
| 2 | GET | `/app/formProcessTemplates/getDefaultStudentLeave` | `requestStudentLeaveForm` | — | `BaseResponse<LeaveFormBean>` |
| 3 | POST | `/app/userAppr/pageDeviceAppr` | `requestRepairList` | JSON Body | `BaseResponse<BasePageResponse<List<LeaveRecordBean>>>` |
| 4 | GET | `/app/userAppr/v2/getInfo` | `requestLeaveDetail` | `Query(id)` `str` | `BaseResponse<LeaveDetailBean>` |
| 5 | POST | `/app/v2/proc/deleteInstance` | `requestRevokeLeave` | JSON Body | `BaseResponse<Boolean>` |
| 6 | POST | `/app/v2/proc/getFlowElements` | `requestStudentLeaveProcess` | JSON Body | `BaseResponse<LeaveProcessBean>` |
| 7 | POST | `/app/v2/proc/pageTask` | `requestLeaveRecord` | JSON Body | `BaseResponse<BasePageResponse<List<LeaveRecordBean>>>` |
| 8 | POST | `/app/v2/proc/startInstance` | `requestSubmitStudentLeave` | JSON Body | `BaseResponse<String>` |
| 9 | POST | `/app/v2/proc/updateApprovalProc` | `requestFormModify` | JSON Body | `BaseResponse<Boolean>` |
| 10 | GET | `/cloud/actLeaveVacation/list` | `requestLeaveTypeOption` | `Query(type)` `str` | `BaseResponse<List<LeaveTypeBean>>` |
| 11 | GET | `/cloud/address/book/student` | `getAddressBook` | `Query(CommentsHomeFragment.TYPE_ID)` `str` | `BaseResponse<List<AddressBookBean>>` |
| 12 | POST | `/cloud/app/procAppr/deleteInstance` | `deleteInstance` | JSON Body | `BaseContentRsp` |
| 13 | POST | `/cloud/app/procAppr/deleteInstance` | `requestOldRevokeLeave` | JSON Body | `BaseResponse<String>` |
| 14 | POST | `/cloud/app/procAppr/getApprList` | `getApprover` | JSON Body | `ApproverListRsp` |
| 15 | GET | `/cloud/app/userAppr/getInfo` | `getApproverInfo` | `Query(id)` `str` | `ApproverInfoRsp` |
| 16 | GET | `/cloud/app/userAppr/getInfo` | `requestOldLeaveDetail` | `Query(id)` `str` | `BaseResponse<ApproverInfoRsp.DataDTO>` |
| 17 | POST | `/cloud/app/userAppr/page` | `askForLeaveRecordBandList` | JSON Body | `GetAskLeaveRecordBandRsp` |
| 18 | GET | `/cloud/formProcessTemplates/getByKey` | `requestRepairForm` | `Query(formKey)` `str` | `BaseResponse<LeaveFormBean>` |
| 19 | POST | `/cloud/leaveWord/brand/create` | `requestAddComments` | JSON Body | `BaseResponse<String>` |
| 20 | GET | `/cloud/leaveWord/delete` | `requestCommentsDelete` | `Query(id)` `str` | `BaseResponse<String>` |
| 21 | GET | `/cloud/leaveWord/get` | `requestCommentsDetail` | `Query(id)` `str` | `BaseResponse<CommentsDetailBean>` |
| 22 | GET | `/cloud/leaveWord/getLeaveWordSetting` | `getLeaveWordSetting` | `Query(type)` `str` | `BaseResponse<ConfigComplaintBean>` |
| 23 | POST | `/cloud/leaveWord/page` | `requestCommentsList` | JSON Body | `BaseResponse<BasePageResponse<List<CommentsDetailBean>>>` |
| 24 | POST | `/cloud/proc/startInstance` | `addLeave` | JSON Body | `BaseContentRsp` |
| 25 | POST | `/cloud/student/allStudents` | `allStudents` | JSON Body | `AllstudentRsp` |
| 26 | POST | `/leave-server/cloud-leave/student/addStudentLeaveByStudentUserId` | `LeaveCommit` | JSON Body | `LeaveCommitRsp` |

---

### 5.10 活动与报名

| 接口 | 请求体 | 说明 |
| --- | --- | --- |
| `POST /brand/activity/enroll/page` | `{"pageNo":1,"pageSize":10}` | 活动列表 |
| `POST /brand/activity/enroll/detail` | `{"activityId":"..."}` | 活动详情 |
| `POST /brand/activity/enroll/activityEnrollInfo` | `{"activityId":"...","userId":"...","identifyType":0}` | 登录用户报名详情 |
| `POST /brand/activity/enroll/userActivityEnroll` | `{"activityId":"...","userId":"...","identifyType":0,"activitySubIds":[...]}` | 报名 |
| `POST /brand/activity/enroll/userEnrollPage` | `{"pageNo":1,"pageSize":10,"activityName":"","userId":"student-1"}` | 我的报名 |

我的报名响应：

```json
{
  "total": 1,
  "pageNo": 1,
  "pageSize": 10,
  "list": [
    {
      "activityId": "active-1",
      "activityName": "校园科技节",
      "createTime": "2026-10-18 09:00",
      "id": "reg-1",
      "remarks": "已报名，等待审核",
      "status": 1,
      "subName": "科技小制作",
      "subType": 1,
      "userName": "张三"
    }
  ]
}
```

#### 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/brand/activity/enroll/activityEnrollInfo` | `requestLoginActiveDetails` | JSON Body | `BaseResponse<ActiveDetailsBean>` |
| 2 | POST | `/brand/activity/enroll/detail` | `requestActiveDetails` | JSON Body | `BaseResponse<ActiveDetailsBean>` |
| 3 | POST | `/brand/activity/enroll/page` | `requestActiveList` | JSON Body | `BaseResponse<BasePageResponse<List<ActiveRegistrationBean>>>` |
| 4 | POST | `/brand/activity/enroll/userActivityEnroll` | `requestActiveRegistration` | JSON Body | `BaseResponse<ActiveSuccessBean>` |
| 5 | POST | `/brand/activity/enroll/userEnrollPage` | `requestMyRegistrationList` | JSON Body | `BaseResponse<BasePageResponse<List<ActiveMyRegistrationBean>>>` |

---

### 5.11 德育评价、荣誉与勋章

这一组覆盖：荣誉墙、学生/班级/个人荣誉、勋章、积分/评价卡、德育活动（评分/排名/安全检查）。

#### 5.11.1 荣誉墙

`POST /cloud/app/honor/brandPage`

```json
{"pageNo": 1, "pageSize": 5}
```

响应 `HonorWallBean`：`total`、`pageNo`、`pageSize`、`list[]`。`HonorWallItem` 常见字段：`honorType`、`level`、`winnerNames`、`name`、`id`、`imgPaths`、`createTime`。

#### 5.11.2 学生/班级/儿童荣誉

| 接口 | 请求体 | 说明 |
| --- | --- | --- |
| `POST /cloud/evaluationPrize/studentHonor` | `{"pageNo":1,"pageSize":20,"studentId":"..."}` | 学生荣誉 |
| `POST /cloud/evaluationPrize/classHonor` | `{"pageNo":1,"pageSize":20,"classesId":"..."}` | 班级荣誉 |
| `POST /cloud/evaluationActivityMobile/childrenHonor` | `{"childrenId":"student-1","pageNo":1,"pageSize":20}` | 家长端/儿童荣誉 |
| `POST /cloud/evaluationActivityBrand/identityDetail` | `{"personId":"...","identity":...}` | 个人荣誉明细 |
| `POST /cloud/evaluationActivityBrand/detail` | `{"activityId":"..."}` | 荣誉活动详情 |
| `POST /cloud/evaluationActivityBrand/list` | `{"pageNo":1,"pageSize":20}` | 荣誉活动列表 |
| `POST /cloud/evaluationActivityBrand/result` | `{"activityId":"..."}` | 活动结果 |

`childrenHonor` 响应示例：

```json
{
  "total": 1,
  "pageNo": 1,
  "pageSize": 20,
  "list": [
    {
      "activityId": "honor-1",
      "activityTitle": "校园之星评选",
      "className": "一年级1班",
      "honorTitle": "文明之星",
      "medalUrl": "http://10.0.2.2:8765/mock/img/honor1.png",
      "obtainTime": "2026-10-01"
    }
  ]
}
```

#### 5.11.3 勋章

| 接口 | 请求/参数 | 说明 |
| --- | --- | --- |
| `GET /brand/appEvalMedal/listEvalMedalType` | 无 | 勋章类型 |
| `POST /brand/appEvalMedal/pageEvalUserMedal` | `{"pageNo":1,"pageSize":20,"personId":"student-1","identity":0}` | 我的勋章 |
| `POST /brand/appEvalMedal/getUserMedalInfo` | `{"medalCode":"..."}` | 勋章详情 |

勋章字段：`evalTypeId`、`evalTypeName`、`getTime`、`groupNameList[]`、`issuanceMethod`、`medalCode`、`medalIconUrl`、`medalName`、`medalScore`、`personName`、`schoolId`、`owned`。

#### 5.11.4 评价积分/评价卡

| 接口 | 请求体/参数 | 说明 |
| --- | --- | --- |
| `POST /brand/evalDataCountStatistic/rankListByClass` | JSON Body | 班级排名 |
| `POST /brand/evalScoreRecord/page` | `{"pageNo":1,"pageSize":20,"personId":"..."}` | 积分记录 |
| `POST /brand/evalScoreCard/getUserScoreCardInfo` | `{"personId":"..."}` | 积分卡详情 |
| `POST /brand/evalScoreCard/pageUserScoreCard` | `{"pageNo":1,"pageSize":20}` | 积分卡列表 |
| `GET /brand/evalPersonScore/getEvalPersonScoreInfo?personId=<id>&identity=<n>` | Query | 个人积分 |

#### 5.11.5 德育活动

| 接口 | 说明 |
| --- | --- |
| `POST /cloud/moralEducationActivityBrand/race` | 班级德育排行 |
| `POST /cloud/moralEducationActivityBrand/overviewDetail` | 德育总览/每日评分 |
| `POST /cloud/moralEducationActivityBrand/gotoScore` | 进入评分 |
| `POST /cloud/moralEducationActivityBrand/scoringRubric` | 评分指标 |
| `POST /cloud/moralEducationActivityBrand/securityCheck` | 安全检查 |
| `POST /cloud/evaluationActivityBrand/queryActivityCycle` | 评价周期 |
| `POST /cloud/evaluationActivityBrand/queryLastClassScoreResult` | 最近班级评分结果 |
| `POST /cloud/evaluationActivityBrand/scoreClass` | 班级评分 |
| `POST /cloud/evaluationActivityBrand/scoreStudent` | 学生评分 |
| `POST /cloud/evaluationActivityBrand/goToScore` | 进入评分 |

`scoringRubric` 响应为 `FirstIndicatorModel[]`（一级指标/评分项）；`securityCheck` 响应为 `CheckSecurityModel`。

#### 5.11.6 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/brand/appEvalMedal/getUserMedalInfo` | `requestEvaluationMedalDetails` | JSON Body | `BaseResponse<EvaluationMedalBean>` |
| 2 | GET | `/brand/appEvalMedal/listEvalMedalType` | `requestEvaluationMedalTypeList` | — | `BaseResponse<List<EvaluationMedalTypeBean>>` |
| 3 | POST | `/brand/appEvalMedal/pageEvalUserMedal` | `requestEvaluationMedalPageList` | JSON Body | `BaseResponse<BasePageResponse<List<EvaluationMedalBean>>>` |
| 4 | POST | `/brand/evalDataCountStatistic/rankListByClass` | `requestEvaluationList` | JSON Body | `BaseResponse<List<EvaluationBean>>` |
| 5 | GET | `/brand/evalPersonScore/getEvalPersonScoreInfo` | `requestEvaluationPointDetails` | `Query(personId)` `str`<br>`Query(identity)` `str2` | `BaseResponse<EvaluationPointBean>` |
| 6 | POST | `/brand/evalScoreCard/getUserScoreCardInfo` | `requestEvaluationPointCardDetails` | JSON Body | `BaseResponse<EvaluationPointCardCancelBean>` |
| 7 | POST | `/brand/evalScoreCard/pageUserScoreCard` | `requestEvaluationPointCardPageList` | JSON Body | `BaseResponse<BasePageResponse<List<EvaluationPointCardBean>>>` |
| 8 | POST | `/brand/evalScoreRecord/page` | `requestEvaluationPointPageList` | JSON Body | `BaseResponse<BasePageResponse<List<EvaluationPointBean>>>` |
| 9 | POST | `/cloud/app/honor/brandPage` | `requestHonorWallList` | JSON Body | `BaseResponse<HonorWallBean>` |
| 10 | POST | `/cloud/evaluationActivityBrand/detail` | `requestActiveDetail` | JSON Body | `BaseResponse<HonorActiveDetailBean>` |
| 11 | POST | `/cloud/evaluationActivityBrand/goToScore` | `requestGoToScore` | JSON Body | `BaseResponse<HonorGoCommentBean>` |
| 12 | POST | `/cloud/evaluationActivityBrand/identityDetail` | `requestIdentityDetail` | JSON Body | `BaseResponse<BasePageResponse<List<HonorScoreDetailBean>>>` |
| 13 | POST | `/cloud/evaluationActivityBrand/list` | `requestActiveHonorList` | JSON Body | `BaseResponse<BasePageResponse<List<HonorActiveBean>>>` |
| 14 | POST | `/cloud/evaluationActivityBrand/queryActivityCycle` | `requestActivityCycle` | JSON Body | `BaseResponse<List<HonorScoreCycleBean>>` |
| 15 | POST | `/cloud/evaluationActivityBrand/queryLastClassScoreResult` | `requestClassScoreResult` | JSON Body | `BaseResponse<List<HonorScoreListBean>>` |
| 16 | POST | `/cloud/evaluationActivityBrand/result` | `requestActiveResultList` | JSON Body | `BaseResponse<HonorCommentResultBean>` |
| 17 | POST | `/cloud/evaluationActivityBrand/scoreClass` | `requestClassScoreComment` | JSON Body | `BaseResponse<String>` |
| 18 | POST | `/cloud/evaluationActivityBrand/scoreStudent` | `requestStudentScoreComment` | JSON Body | `BaseResponse<String>` |
| 19 | POST | `/cloud/evaluationActivityMobile/childrenHonor` | `requestKidsHonorList` | JSON Body | `BaseResponse<BasePageResponse<List<HonorKidsLIstBean>>>` |
| 20 | POST | `/cloud/evaluationPrize/classHonor` | `requestClassHonorList` | JSON Body | `BaseResponse<BasePageResponse<List<HonorClassBean>>>` |
| 21 | POST | `/cloud/evaluationPrize/studentHonor` | `requestStudentHonorList` | JSON Body | `BaseResponse<BasePageResponse<List<HonorStudentBean>>>` |
| 22 | POST | `/cloud/moralEducationActivityBrand/gotoScore` | `gotoScore` | JSON Body | `BaseResponse<Float>` |
| 23 | POST | `/cloud/moralEducationActivityBrand/overviewDetail` | `requestDailyScoreDetails` | JSON Body | `BaseResponse<List<ScoringDetailCycleModel>>` |
| 24 | POST | `/cloud/moralEducationActivityBrand/race` | `requestClassMe` | JSON Body | `BaseResponse<IndexClassMEModel>` |
| 25 | POST | `/cloud/moralEducationActivityBrand/scoringRubric` | `requestScoringRubric` | JSON Body | `BaseResponse<List<FirstIndicatorModel>>` |
| 26 | POST | `/cloud/moralEducationActivityBrand/securityCheck` | `securityCheck` | JSON Body | `BaseResponse<CheckSecurityModel>` |

---

### 5.12 考试

| 接口 | 请求体 | 说明 |
| --- | --- | --- |
| `POST /brand/exam/recent` | `{"examStartTime":"2026-10-19 00:00:00","examEndTime":"2026-10-19 23:59:59","limit":10}` | 今日/最近考试 |
| `POST /brand/exam/plan/week` | `{}` | 本周考试安排 |
| `POST /brand/exam/by/student` | `{"studentId":"student-1"}` | 学生考试列表 |
| `POST /brand/exam/detail` | `{"siteId":"...","subjectId":"...","examinationId":"..."}` | 考试详情 |
| `POST /brand/exam/person` | `{"siteId":"...","subjectId":"...","examinationId":"..."}` | 考场/座位 |
| `POST /brand/exam/student/sing/in` | `{"studentId":"...","siteId":"...","subjectId":"...","examinationId":"..."}` | 学生签到 |

`by/student` 响应示例：

```json
[
  {
    "examinationId": "exam-1",
    "subjectId": "subject-1",
    "subjectName": "语文",
    "examStartTime": "2026-10-20 09:00",
    "examEndTime": "2026-10-20 10:30",
    "siteId": "site-1",
    "siteName": "模拟考场",
    "buildingName": "教学楼A",
    "examinationRoomName": "101",
    "studentSeat": "1",
    "signIn": false,
    "signInPerson": 0,
    "examPeopleNum": 30,
    "examinationPersonCount": 30,
    "totalPerson": 30,
    "weekDay": 2,
    "showed": false,
    "isSelect": false,
    "group": [],
    "invigilators": []
  }
]
```

#### 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/brand/exam/by/student` | `requestUserExamList` | JSON Body | `BaseResponse<List<ExamPlanItem>>` |
| 2 | POST | `/brand/exam/detail` | `requestExamDetail` | JSON Body | `BaseResponse<ExamPlanItem>` |
| 3 | POST | `/brand/exam/person` | `requestExamPersonSeat` | JSON Body | `BaseResponse<List<ExamPersonSeatBean>>` |
| 4 | POST | `/brand/exam/plan/week` | `requestWeekExam` | JSON Body | `BaseResponse<List<ExamArrangementBean>>` |
| 5 | POST | `/brand/exam/recent` | `requestTodayExam` | JSON Body | `BaseResponse<List<ExamPlanItem>>` |
| 6 | POST | `/brand/exam/student/sing/in` | `requestSignExam` | JSON Body | `BaseResponse<Boolean>` |

---

### 5.13 图书与阅读

两套图书系统：

1. **图书 SaaS OPAC**：`BookApiStores`，base `https://open-lcs.libsaas.com.cn/`；
2. **旧图书/人脸外部系统**：`GetData`，`http://120.76.189.190/api/library/...` 或 `http://120.76.189.190:800/yide_manager/...` + `AuthcodeTwo` 签名（见 6.4）。

#### 5.13.1 `BookApiStores`（Open LCS）

| 接口 | 参数/请求体 | 说明 |
| --- | --- | --- |
| `GET /opac/ctrl/{ctrlNo}` | Path | 图书控制号详情 |
| `GET /opac/assets/{ctrlNo}` | Path | 图书资产/馆藏 |
| `GET /opac/tops/{topType}?days=&flag=&language=&type=` | Path + Query | 排行榜/推荐 |
| `POST /opac/search` | JSON Body | 图书搜索 |

注意：`@Query("language ")` 有个**尾随空格**（源码原样），服务端可能要求这个 key 带空格；自己写脚本时可以两个都试。

`bookDetail`/`search` 字段（`LibraryItemBean`）：`bookIsbn`、`callNumber`、`categoryCode`、`description`、`firstAuthor`、`id`、`publicationTime`、`publisherName`、`title`、`url`。

#### 5.13.2 `ILibraryService`（RFID 班牌图书）

| 接口 | 请求体/参数 | 说明 |
| --- | --- | --- |
| `POST /rfid/hm-board/library/list` | JSON Body | 图书馆列表 |
| `POST /rfid/class-board/category/list` | JSON Body | 图书分类 |
| `GET /rfid/class-board/opac/itemTypeList?libraryId=<id>` | Query | 图书类型 |
| `POST /rfid/class-board/opac/book` | 搜索条件 | 图书搜索 |
| `POST /rfid/class-board/opac/bookDetail` | `{"id":"..."}` | 图书详情/馆藏 |
| `POST /rfid/class-board/rank/hot-circulation-rank` | JSON Body | 热门借阅榜 |
| `POST /rfid/class-board/rank/new-book-recommend` | JSON Body | 新书推荐 |

搜索 body 示例（`LibraryFragmentViewModel`）：

```json
{
  "pageNo": 1,
  "pageSize": 20,
  "libraryId": "lib-1",
  "fullText": "",
  "type": "",
  "title": "",
  "firstAuthor": "",
  "publisherName": "",
  "startPublication": "",
  "endPublication": "",
  "order": ""
}
```

#### 5.13.3 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | GET | `/opac/assets/{ctrlNo}` | `getBookMsgAssets` | `Path(ctrlNo)` `str` | `List<BookassetsRsp>` |
| 2 | GET | `/opac/ctrl/{ctrlNo}` | `getBookMsg` | `Path(ctrlNo)` `str` | `ctrlNoRsp` |
| 3 | POST | `/opac/search` | `searchBook` | JSON Body | `SearchBookRsp` |
| 4 | GET | `/opac/tops/{topType}` | `getTops` | `Path(topType)` `str`<br>`Query(days)` `str2`<br>`Query(flag)` `str3`<br>`Query(language)` `str4`<br>`Query(type)` `str5` | `List<YwBookRsp>` |
| 5 | POST | `/rfid/class-board/category/list` | `requestLibraryClassifyList` | JSON Body | `BaseResponse<List<LibraryTypeBean>>` |
| 6 | POST | `/rfid/class-board/opac/book` | `requestLibrarySearch` | JSON Body | `BaseResponse<BasePageResponse<List<LibraryItemBean>>>` |
| 7 | POST | `/rfid/class-board/opac/bookDetail` | `requestLibraryBookSituation` | JSON Body | `BaseResponse<BasePageResponse<List<LibraryCollectBookSituationBean>>>` |
| 8 | GET | `/rfid/class-board/opac/itemTypeList` | `requestLibraryTypeList` | `Query(libraryId)` `str` | `BaseResponse<List<LibraryTypeBean>>` |
| 9 | POST | `/rfid/class-board/rank/hot-circulation-rank` | `requestHotList` | JSON Body | `BaseResponse<List<LibraryItemBean>>` |
| 10 | POST | `/rfid/class-board/rank/new-book-recommend` | `requestLibraryNewList` | JSON Body | `BaseResponse<List<LibraryItemBean>>` |
| 11 | POST | `/rfid/hm-board/library/list` | `requestLibraryList` | JSON Body | `BaseResponse<List<LibraryBean>>` |

---

### 5.14 场地预约与咨询

#### 5.14.1 场地预约

| 接口 | 请求体/参数 | 说明 |
| --- | --- | --- |
| `POST /cloud/siteBooking/bookingRecordPage` | `{"pageNo":1,"pageSize":20,"userId":"...","status":...}` | 预约记录 |
| `GET /cloud/siteBooking/get?id=<id>` | Query | 预约详情 |
| `POST /cloud/siteBooking/siteBookingSign` | `{"siteBookingId":"...","userId":"..."}` | 单个签到 |
| `POST /cloud/siteBooking/siteBookingBatchSign` | `{"siteBookingIds":[...],"userId":"..."}` | 批量签到 |

`ReservationRecordBean` 字段：`bookingTime`、`siteBookingTypeId`、`siteTypeName`、`approverId`、`sponsorId`、`sponsorName`、`siteName`、`siteBookingTypeName`、`buildingName`、`schedule`、`roomNum`、`schoolId`、`name`、`peppleNum`、`siteId`、`startTimeStr`、`describe`、`endTimeStr`、`id`、`floor`、`refuseReason`、`status`、`week`、`signList[]`。

#### 5.14.2 咨询/教师

| 接口 | 请求体/参数 | 说明 |
| --- | --- | --- |
| `POST /cloud/employee/getEmployeeListByLabel` | `{"labelId":"...","pageNo":1,"pageSize":20}` | 咨询教师列表 |
| `GET /cloud/employee/get?id=<id>` | Query | 教师详情 |

#### 5.14.3 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | GET | `/cloud/employee/get` | `requestEmployeeDetails` | `Query(id)` `str` | `BaseResponse<ConsultTeacherBean>` |
| 2 | POST | `/cloud/employee/getEmployeeListByLabel` | `requestConsultList` | JSON Body | `BaseResponse<List<ConsultTeacherBean>>` |
| 3 | POST | `/cloud/siteBooking/bookingRecordPage` | `requestReservationRecordList` | JSON Body | `BaseResponse<BasePageResponse<List<ReservationRecordBean>>>` |
| 4 | GET | `/cloud/siteBooking/get` | `requestReservationRecordDetail` | `Query(id)` `str` | `BaseResponse<ReservationDetailBean>` |
| 5 | POST | `/cloud/siteBooking/siteBookingBatchSign` | `requestReservationOfflineSign` | JSON Body | `BaseResponse<Integer>` |
| 6 | POST | `/cloud/siteBooking/siteBookingSign` | `requestReservationSign` | JSON Body | `BaseResponse<Boolean>` |

---

### 5.15 巡课

| 接口 | 请求体/参数 | 说明 |
| --- | --- | --- |
| `POST /app/patrolDayTaskSite/page` | `{"patrolType":1,"pageNo":1,"siteId":"...","pageSize":20,"userId":"...","status":0}` | 巡课任务列表 |
| `GET /app/patrolDayTaskSite/get?id=<id>` | Query | 任务详情 |
| `POST /app/patrolDayTaskSite/updateClockIn` | `{"id":"...","formJson":"...","userId":"..."}` | 打卡（表单） |
| `POST /app/patrolDayTaskSite/updateNowClock` | `{"userId":"...","businessId":"..."}` | 立即打卡 |
| `POST /app/patrolDayTaskSite/finishSiteTask` | `{"id":"...","formJson":"...","userId":"..."}` | 完成任务 |
| `GET /app/patrolQrCode/getSiteQrCodeStatus?siteId=<id>` | Query | 场地二维码状态 |

`PatrolListBean` 字段：`siteRange`、`finishTime`、`finishUserName`、`dayProjectId`、`businessId`、`businessName`、`typeName`、`userId`、`businessCode`、`startAndEndTime`、`executeNames`、`formJson`、`id`、`projectName`、`taskId`、`startTime`、`endTime`。

#### 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/app/patrolDayTaskSite/finishSiteTask` | `requestSubmitPatrol` | JSON Body | `BaseResponse<Boolean>` |
| 2 | GET | `/app/patrolDayTaskSite/get` | `requestPatrolDetail` | `Query(id)` `str` | `BaseResponse<PatrolDetailBean>` |
| 3 | POST | `/app/patrolDayTaskSite/page` | `requestPatrolList` | JSON Body | `BaseResponse<BasePageResponse<List<PatrolListBean>>>` |
| 4 | POST | `/app/patrolDayTaskSite/updateClockIn` | `requestUpdatePatrolPunch` | JSON Body | `BaseResponse<Boolean>` |
| 5 | POST | `/app/patrolDayTaskSite/updateNowClock` | `requestPatrolPunch` | JSON Body | `BaseResponse<Boolean>` |
| 6 | GET | `/app/patrolQrCode/getSiteQrCodeStatus` | `requestScanQrCodeStatus` | `Query(siteId)` `str` | `BaseResponse<VerifyPeopleBean>` |

---

### 5.16 投票与问卷

#### 5.16.1 投票

| 接口 | 请求体 | 说明 |
| --- | --- | --- |
| `POST /cloud/vote/page` | `{"pageNo":1,"pageSize":10,"status":0,"showAll":false,"isHave":true}` | 投票列表 |
| `POST /cloud/vote/get` | `{"voteId":"...","brandStudentInfo":""}` | 投票详情 |
| `POST /cloud/vote/clickVote` | `{"voteId":"...","isBrandStudent":true,"userId":"...","userName":"...","voteDetails":[...]}` | 提交投票 |

`VoteDetailBean` 字段：`teacherIds[]`、`title`、`setting`、`schoolId`、`options[]`、`startTime`、`endTime`、`id`、`desc`、`voteDate`、`userId`、`userName`、`url`。

#### 5.16.2 问卷/收集表

| 接口 | 请求体/参数 | 说明 |
| --- | --- | --- |
| `POST /app/collectTableBrand/overview` | `{"pageNo":1,"pageSize":99}` | 收集表列表 |
| `POST /app/collectTableBrand/lookOver` | `{"id":"<formId>"}` | 收集情况 |
| `POST /app/collectTableBrand/check` | `{"id":"<formId>"}` | 表单详情 |
| `POST /app/collectTableBrand/write` | `{"id":"<formId>","components":[{"componentId":"...","value":"..."}]}` | 提交表单 |
| `POST /app/collectTableComponent/brand` | JSON Body | 首页问卷卡片 |
| `GET /app/student/selectClassByStudentId?studentId=<id>` | Query | 学生班级 |
| `GET /app/employee/getDeptById?shcoolId=<id>&employeeId=<id>` | Query | 教师部门（注意 `shcoolId` 拼写） |

`HomeCollectBean` 字段：`name`、`description`、`id`、`formId`、`questionList[]`。

#### 5.16.3 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/app/collectTableBrand/check` | `requestFormDetail` | JSON Body | `BaseResponse<FormDetailBean>` |
| 2 | POST | `/app/collectTableBrand/lookOver` | `requestCollectSituation` | JSON Body | `BaseResponse<CollectSituationBean>` |
| 3 | POST | `/app/collectTableBrand/overview` | `requestCollectList` | JSON Body | `BaseResponse<BasePageResponse<List<CollectListBean>>>` |
| 4 | POST | `/app/collectTableBrand/write` | `requestSubmitFormContent` | JSON Body | `BaseResponse<Boolean>` |
| 5 | POST | `/app/collectTableComponent/brand` | `requestHomeCollectList` | JSON Body | `BaseResponse<BasePageResponse<List<HomeCollectBean>>>` |
| 6 | GET | `/app/employee/getDeptById` | `requestTeacherDeptList` | `Query(shcoolId)` `str`<br>`Query(employeeId)` `str2` | `BaseResponse<List<DeptListBean>>` |
| 7 | GET | `/app/student/selectClassByStudentId` | `requestStudentClasses` | `Query(CommentsHomeFragment.TYPE_ID)` `str` | `BaseResponse<StudentClassesBean>` |
| 8 | POST | `/cloud/vote/clickVote` | `requestSubmitVote` | JSON Body | `BaseResponse<Boolean>` |
| 9 | POST | `/cloud/vote/get` | `requestVoteDetail` | JSON Body | `BaseResponse<VoteDetailBean>` |
| 10 | POST | `/cloud/vote/page` | `requestHomeVoteList` | JSON Body | `BaseResponse<BasePageResponse<List<VoteDetailBean>>>` |

---

### 5.17 宿舍

| 接口 | 参数 | 说明 |
| --- | --- | --- |
| `GET /brand/brand/dormitory/dormitoryHomepage/detail?id=<id>` | Query | 宿舍首页详情 |
| `GET /cloud/moralEducationActivityBrand/dormitory?schoolId=<id>&classesId=<id>` | Query | 宿舍德育数据 |

#### 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | GET | `/brand/brand/dormitory/dormitoryHomepage/detail` | `requestHomeDormitoryDetail` | `Query(id)` `str` | `BaseResponse<DormitoryDetailsBean>` |
| 2 | GET | `/cloud/moralEducationActivityBrand/dormitory` | `requestHomeDormitoryEducation` | `Query(schoolId)` `str`<br>`Query(CommentsHomeFragment.TYPE_CLASSESID)` `str2` | `BaseResponse<DormitoryEducationBean>` |

---

### 5.18 AI 助手

| 接口 | 请求体 | 说明 |
| --- | --- | --- |
| `POST /ai/chat/session/create` | `{"assistantId":"...","userId":"..."}` | 创建会话 |
| `POST /ai/chat/models` | `{}` | 模型列表 |
| `POST /ai/assistant/public/list` | `{}` | 公开助手列表 |
| `POST /ai/assistant/get` | `{"id":"..."}` | 助手详情 |

流式对话不在 Retrofit 里，而是 `SSEClient`：

```http
POST https://api.yyide.com/ai/chat/completion/stream
Content-Type: application/json
Accept: text/event-stream

{"sessionId":"<sessionId>","prompt":"你好"}
```

响应是 SSE：

```text
data: {"content":"你"}
data: {"content":"好"}
data: [DONE]
```

源码 `SSEClient` 逐行读取 `data:`，把同一事件的多行拼接后回调 `onMessage`。Python/JS 示例见 [9.5](#95-sse-流式对话)。

#### 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/ai/assistant/get` | `requestAIGetInfo` | JSON Body | `BaseResponse<AIProblemBean>` |
| 2 | POST | `/ai/assistant/public/list` | `requestAIHomeList` | JSON Body | `BaseResponse<List<AIIntellectHomeBean>>` |
| 3 | POST | `/ai/chat/models` | `requestAIModelList` | JSON Body | `BaseResponse<List<AIModelBean>>` |
| 4 | POST | `/ai/chat/session/create` | `requestAICreateSession` | JSON Body | `BaseResponse<AICreateSessionBean>` |

---

### 5.19 文件上传与日志

#### 5.19.1 上传文件

`POST /app/file/upload`（multipart）

```bash
curl -X POST "https://api.yyide.com/app/file/upload" \
  -H "Authorization: Bearer <token>" \
  -F "file=@./photo.jpg"
```

响应：

```json
{
  "code": 0,
  "message": "ok",
  "data": [
    {"name": "photo.jpg", "size": 12345, "url": "https://.../photo.jpg"}
  ]
}
```

#### 5.19.2 上传日志/路径

`POST /file/upload/path`（multipart）

| 字段 | 值 |
| --- | --- |
| `path` | `libBrand`（源码固定） |
| `file` | 日志 zip |

源码 `HomePresenter.uploadLog()`：

```java
MultipartBody.Builder builder = new MultipartBody.Builder();
builder.addFormDataPart("path", "libBrand");
builder.addPart(filePart);
```

#### 5.19.3 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/app/file/upload` | `upload` | `multipart/form-data` | `BaseResponse<List<UploadFileBean>>` |
| 2 | POST | `/app/file/upload` | `upload` | `multipart/form-data` | `BaseResponse<List<UploadFileBean>>` |
| 3 | POST | `/file/upload/path` | `uploadLogFile` | `multipart/form-data` | `BaseResponse<List<UploadFileBean>>` |

---

### 5.20 设备物联与扩展

#### 5.20.1 人脸同步/配置

| 接口 | 请求体 | 说明 |
| --- | --- | --- |
| `POST /cloud/device/shared-config/get` | `{"schoolId":"...","deviceNo":"...","type":...}` | 人脸激活/共享配置 |
| `POST /cloud/device/face-sync/update-status` | `{"schoolId":"...","deviceNo":"...","status":...}` | 更新人脸同步状态 |

人脸同步的 3 个接口在 `com.yyide.facepass.network.INetworkService`（见 6.2）。

#### 5.20.2 传感器/场地环境（SKS）

| 接口 | 说明 |
| --- | --- |
| `POST /cloud/sks/site/get` | 场地信息 |
| `POST /cloud/sks/site/getSiteEnvIndicators` | 环境指标（温湿度/PM2.5 等） |
| `POST /cloud/sks/site/getSiteImages` | 场地图片/告警图 |

#### 5.20.3 校园电视台/视频流

`POST /brand/layoutclasssign/getVideoStreams`

请求体按 `LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean`/`StreamDetails`；响应含 `brandId`、`nums`、`streamUrls[].url`，给 `CCTVFragment` 播放 RTSP/RTMP。

#### 5.20.4 门禁记录

`POST /brand/openDoor/records/create`，body 按开门记录模型；用于门禁/闸机。

#### 5.20.5 TTLock 蓝牙锁

`LocalApiStores` 中还有两个本地锁接口：

| 接口 | 说明 |
| --- | --- |
| `POST /api/lock/listSwk.html` | 锁列表 |
| `POST /api/lock/saveSwk` | 保存锁 |

完整的 TTLock 26 个接口见 [6.1](#61-ttlock-通通锁)。

#### 5.20.6 全部接口

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/api/lock/listSwk.html` | `listSwk` | JSON Body | `listSwkRsp` |
| 2 | POST | `/api/lock/saveSwk` | `saveSwk` | JSON Body | `saveSwkRsp` |
| 3 | POST | `/brand/layoutclasssign/getVideoStreams` | `requestRTSPPath` | JSON Body | `BaseResponse<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean>` |
| 4 | POST | `/brand/openDoor/records/create` | `requestRecords` | JSON Body | `BaseResponse<String>` |
| 5 | POST | `/cloud/device/face-sync/update-status` | `requestSynchronizeStatusFaceExtraction` | JSON Body | `BaseResponse<String>` |
| 6 | POST | `/cloud/device/shared-config/get` | `requestFaceConfig` | JSON Body | `BaseResponse<FaceActiveConfigBean>` |
| 7 | POST | `/cloud/sks/site/get` | `requestSiteInfo` | JSON Body | `BaseResponse<CustomSiteInfoBean>` |
| 8 | POST | `/cloud/sks/site/getSiteEnvIndicators` | `requestSensorInfoList` | JSON Body | `BaseResponse<CustomSensorBean>` |
| 9 | POST | `/cloud/sks/site/getSiteImages` | `requestWarningInfoList` | JSON Body | `BaseResponse<CustomSiteInfoBean>` |

---

## 6. 第三方与外部接口

> 这些接口不属于 `src/main/java` 的 222 个 Retrofit 注解，但同样会在班牌上被调用。

### 6.1 TTLock 通通锁

| 项目 | 值 |
| --- | --- |
| Base URL | `https://api.ttlock.com.cn` |
| 认证 | `POST /oauth2/token`，`application/x-www-form-urlencoded` |
| 客户端 | `demo.retrofit.ApiService` / `RetrofitAPIManager` |
| 凭据 | 见 本地凭据 第 5 节 |

**26 个接口：**

| # | 方法 | 路径 | 用途 |
| ---: | --- | --- | --- |
| 1 | POST | `/oauth2/token` | OAuth 登录（client_id/client_secret/grant_type/username/password/redirect_uri） |
| 2 | POST | `/v3/fingerprint/add` | 添加指纹 |
| 3 | POST | `/v3/identityCard/add` | 添加 IC 卡 |
| 4 | POST | `/v3/wirelessKeyboard/add` | 添加无线键盘 |
| 5 | POST | `/v3/lock/changeAdminKeyboardPwd` | 修改管理员键盘密码 |
| 6 | POST | `/v3/fingerprint/clear` | 清空指纹 |
| 7 | POST | `/v3/identityCard/clear` | 清空 IC 卡 |
| 8 | POST | `/v3/fingerprint/delete` | 删除指纹 |
| 9 | POST | `/v3/identityCard/delete` | 删除 IC 卡 |
| 10 | POST | `/v3/lock/delete` | 删除锁 |
| 11 | POST | `/v3/gateway/isInitSuccess` | 网关初始化状态 |
| 12 | POST | `/v3/gateway/upgradeCheck` | 网关升级检查 |
| 13 | POST | `/v3/gateway/list` | 网关列表 |
| 14 | POST | `/v3/lock/list` | 锁列表 |
| 15 | GET | `/v3/fingerprint/list` | 指纹列表 |
| 16 | GET | `/v3/identityCard/list` | IC 卡列表 |
| 17 | GET | `/v3/key/list` | 钥匙列表 |
| 18 | POST | `/v3/lock/initialize` | 初始化锁 |
| 19 | POST | `/v3/lock/upgradeCheck` | 锁升级检查 |
| 20 | POST | `/v3/lock/upgradeRecheck` | 锁升级复查 |
| 21 | POST | `/v3/identityCard/changePeriod` | 修改 IC 卡有效期 |
| 22 | POST | `/room/registerNb` | 注册 NB 物联网模块 |
| 23 | POST | `/v3/lock/resetKeyboardPwd` | 重置键盘密码 |
| 24 | POST | `/v3/lock/resetKey` | 重置 eKey |
| 25 | POST | `/v3/gateway/uploadDetail` | 上传网关详情 |
| 26 | POST | `/lockRecords/fromLock` | 上传锁记录 |

**登录示例：**

```bash
curl -X POST "https://api.ttlock.com.cn/oauth2/token" \
  -H "Content-Type: application/x-www-form-urlencoded" \
  --data-urlencode "client_id=__SEC_API_KEY_86897F0C__" \
  --data-urlencode "client_secret=__SEC_CLIENT_SECRET_EFE7E365__" \
  --data-urlencode "grant_type=password" \
  --data-urlencode "username=15920012647" \
  --data-urlencode "password=<MD5(__SEC_PASSWORD_6BEF24BC__)>" \
  --data-urlencode "redirect_uri=http://www.1yide.com/"
```

**锁列表示例：**

```bash
curl -X POST "https://api.ttlock.com.cn/v3/lock/list" \
  -d "clientId=__SEC_API_KEY_86897F0C__" \
  -d "accessToken=<token>" \
  -d "pageNo=1" \
  -d "pageSize=100" \
  -d "date=<毫秒时间戳>"
```

> `date` 是毫秒时间戳；TTLock 服务端会校验时间窗口，注意设备时间同步。

### 6.2 人脸同步（FacePass）

| 接口 | 请求体 | 说明 |
| --- | --- | --- |
| `POST /cloud/device/face-sync/sync-page` | 分页参数 | 拉取人脸分页 |
| `POST /cloud/device/face-sync/sync-all` | 同步参数 | 全量同步 |
| `POST /cloud/device/face-sync/batch-update-status` | 状态列表 | 批量更新同步状态 |
| `POST /cloud/v2/machine/updateApkVersion` | 版本参数 | 更新 APK 版本 |

源码：`vendor-src/java/com/yyide/facepass/network/INetworkService.java`，base URL 由 `FaceManager.initFaceSyncConfig(..., "https://api.yyide.com", schoolId, mac)` 传入。

### 6.3 天气（第三方）

`GET https://zhwnlapi.etouch.cn/Ecalender/weather_mini?city=<city>`

| 字段 | 说明 |
| --- | --- |
| `city` / `cityid` | 城市 |
| `temp` / `tem2` | 当前/最低温 |
| `weather` / `wea` | 天气 |
| `humidity` | 湿度 |
| `wind` / `windsc` | 风向/风力 |
| `aqi` / `quality` / `pm25` | 空气质量 |
| `forecast[]` | 预报 |
| `data.wendu` / `data.ganmao` | 温度/感冒提示 |

源码：`WeatherApiStores`，无 Key。

### 6.4 旧图书/人脸外部系统

| 项目 | 值 |
| --- | --- |
| 主机 | `120.76.189.190` |
| 图书（通用） | `http://120.76.189.190/api/library/...`（`requestUrl`，端口 80） |
| 图书（yide_manager） | `http://120.76.189.190:800/yide_manager/api/library/...`（`requestUrlYydUrl`） |
| 人脸对接 | `http://120.76.189.190:8099/java-external-docking` |
| 签名 | `input=<AuthcodeTwo(k=v&k2=v2, URL_KEY)>` |
| URL_KEY | `<URL_KEY>`（见本地凭据） |

> 注意：Java 里传入的是 `MyHashMap.toString()`，格式是 `key=value&key2=value2`，**不是 JSON**。`Object2Map` 会把对象字段转成字符串 Map，`MyHashMap.toString()` 用 `&` 拼接，再由 `AuthcodeTwo` 签名。Python 移植见 9.7。

示例：

```text
POST http://120.76.189.190:800/yide_manager/<业务地址>?input=<urlencode(authcode)>
```

`GetData` 里的方法：

| 方法 | 地址 | 用途 |
| --- | --- | --- |
| `requestUrl` | `http://<URL_IP>/api/library/...` | 通用图书/业务（端口 80） |
| `requestUrlYydUrl` | `http://<URL_IP>:800/yide_manager/api/library/...` | 图书（yide_manager） |
| `requestUrlHRFace` / `requestFaceUrl` | `http://120.76.189.190:8099/java-external-docking/api/library/...` | 人脸 |
| `requestUrlBend` | `http://192.168.3.105:8777/api/library/...` | 内网测试 |
| `requestUrl130` | `http://192.168.3.102:8777/api/library/...` | 内网测试 |
| `requestUrl2` | `http://120.76.189.190/api/library/...` | 备用（端口 80） |
| `uploadUrl` | `http://<host>/api/upload/photo.html` | 上传照片 |

签名算法见 [9.7](#97-图书系统-authcodetwo-签名)。

### 6.5 AI 流式对话（SSE）

`POST https://api.yyide.com/ai/chat/completion/stream`

| Header | 值 |
| --- | --- |
| `Content-Type` | `application/json` |
| `Accept` | `text/event-stream` |

Body：

```json
{"sessionId": "<sessionId>", "prompt": "你好"}
```

响应：

```text
data: {"content":"你"}
data: {"content":"好"}
data: [DONE]
```

源码 `SSEClient`：`readTimeout(0)`、逐行 `readUtf8Line()`、只处理 `data:` 前缀。

### 6.6 MQTT

| 项目 | 值 |
| --- | --- |
| Broker | `tcp://116.63.71.76:1883`（生产）、`tcp://192.168.3.158:1883`（UAT） |
| 用户名 | `yide` |
| 密码 | 见 本地凭据 第 6 节 |
| ClientID | `brand/<schoolId>/<mac>` |
| 连接参数 | keepAlive 10s、connectTimeout 10s、自动重连、cleanSession=true |

**主题：**

| 主题 | 方向 | 用途 |
| --- | --- | --- |
| `brand/<schoolId>/<mac>` | 双向 | 设备主主题 |
| `brand/sync/message/status` | 订阅 | 同步消息状态 |
| `upload/log/message` | 发布 | 上传日志 |
| `device_web/deviceImages/<mac>` | 发布 | 设备图片/截屏 |
| `device_web/push/<mac>` | 订阅 | Web 推送 |
| `/biz/sync/device/system/information` | 发布 | 设备系统信息 |
| `/biz/sync/device/running/state` | 发布 | 设备运行状态 |

示例 payload（`AppUtil.getDeviceInfo()`）：

```json
{
  "mac": "__SEC_MAC_PUT_92F7D57E__",
  "schoolId": "mock-school-001",
  "version": "3.0.14",
  "status": "online"
}
```

Python 示例见 [9.6](#96-mqtt-客户端)。

### 6.7 WebSocket（旧）

`BaseConstant.WS_HOST = "192.168.3.229"`，`JWebSocketClientService` 用它创建 `URI`。没有 `ws://`/`wss://` 前缀和端口，像是内网遗留；实际班牌可能不使用。协议/心跳参考 `JWebSocketClientService`：

- 5 秒心跳；
- 心跳 payload 是 JSON；
- 断线重连；
- 主要接收服务端推送。

### 6.8 手工 OkHttp 调用

除了 Retrofit，源码还有几处直接写 URL：

| 地址 | 方法 | 说明 |
| --- | --- | --- |
| `https://api.yyide.com/brand/brand/album/list` | `HttpUtils.post` | 旧相册 |
| `https://api.yyide.com/brand/brand/album/listDetail` | `HttpUtils.post` | 旧相册详情 |
| `https://api.yyide.com/brand/class-brand-management/android/videoalbum/list` | `HttpUtils2.post` | 旧视频列表 |
| `https://console.tim.qq.com/v4/openim/get_c2c_unread_msg_num?<query>` | OkHttp POST | 腾讯 IM 未读数 |
| `https://zhwnlapi.etouch.cn/Ecalender/weather_mini` | Retrofit | 天气 |

`console.tim.qq.com` 的 query 由 `GetUserSig` 相关逻辑拼接（`sdkappid`、`identifier`、`usersig`、`random`、`contenttype`），body 是 `{"To_Account":"<userId>"}`。

### 6.9 腾讯云 IM UserSig

源码 `GenerateTestUserSig.genTestUserSig(identifier)`：

1. 组装 `TLS.ver/identifier/sdkappid/expire/time`；
2. HMAC-SHA256（SecretKey）；
3. Deflate + Base64URL（`+`→`*`、`/`→`-`、`=`→`_`）；
4. 返回 `TLS.userbuf`/`TLS.sig` 的压缩串。

服务端接口 `/cloud/im/user/sig/gen` 下发的 UserSig 优先使用；客户端 SecretKey 是泄露的，见本地凭据。

---

## 7. 完整索引（按源码文件）

> 这一节按 19 个 Retrofit 接口文件列出全部 222 个接口，方便按源码查找。业务分类见第 5 节。

### BookApiStores（4 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | GET | `/opac/assets/{ctrlNo}` | `getBookMsgAssets` | `Path(ctrlNo)` `str` | `List<BookassetsRsp>` |
| 2 | GET | `/opac/ctrl/{ctrlNo}` | `getBookMsg` | `Path(ctrlNo)` `str` | `ctrlNoRsp` |
| 3 | POST | `/opac/search` | `searchBook` | JSON Body | `SearchBookRsp` |
| 4 | GET | `/opac/tops/{topType}` | `getTops` | `Path(topType)` `str`<br>`Query(days)` `str2`<br>`Query(flag)` `str3`<br>`Query(language)` `str4`<br>`Query(type)` `str5` | `List<YwBookRsp>` |


### DingApiStores（70 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/app/file/upload` | `upload` | `multipart/form-data` | `BaseResponse<List<UploadFileBean>>` |
| 2 | POST | `/attweb/app/attendance/createBrandAttendanceSignIn` | `brandAttendanceClock` | JSON Body | `GeneralBean2` |
| 3 | GET | `/attweb/app/attendance/getAttendanceEventTimetableByClasses` | `getAttenceKB` | `Query(CommentsHomeFragment.TYPE_CLASSESID)` `str` | `KBRsp2` |
| 4 | POST | `/attweb/app/attendance/getAttendanceSiteTimetable` | `getAttendanceSiteTimetable` | JSON Body | `BaseResponse<List<SiteAttendanceBean>>` |
| 5 | GET | `/attweb/app/attendance/getBrandAttendanceRule` | `Attendlist` | `Query(no)` `str` | `AttencelistRsp2` |
| 6 | GET | `/attweb/app/attendance/getBrandAttendanceUser` | `getBrandAttendanceUser` | `Query(id)` `str` | `AttenceUser` |
| 7 | POST | `/attweb/app/attendance/listToDay` | `queryBrandAttendanceByAttendanceTimeId` | JSON Body | `AttenceNewListBean` |
| 8 | POST | `/attweb/app/attendance/listToDayDetail` | `listToDayDetail` | JSON Body | `AttanceTodatDetailsRsp` |
| 9 | POST | `/auth/oauth/token` | `newLogin` | `Query(username)` `str`<br>`Query(password)` `str2`<br>`Query(client_id)` `str3`<br>`Query(grant_type)` `str4`<br>`Query(client_secret)` `str5`<br>`Query(random)` `str6` | `NewLoginRsp` |
| 10 | POST | `/backstage/cloud-backstage/kf/application/queryClassificList` | `queryClassificList` | JSON Body | `queryClassificListRsp` |
| 11 | POST | `/brand/brand/Authority/selectStudentByIcCard` | `selectNewStudentByIcCard` | JSON Body | `selectNewStudentByIcCardRsp` |
| 12 | POST | `/brand/brand/Authority/selectTeacherByClassesId` | `selectNewTeacherByClassesId` | JSON Body | `selectTeacherByClassesIdRsp` |
| 13 | POST | `/brand/brand/Authority/selectTeacherByIcCard` | `selectNewTeacherByIcCard` | JSON Body | `selectTeacherByIcCardRsp` |
| 14 | POST | `/brand/brand/Authority/selectUserInfoByIcCard` | `selectNewUserInfoByIcCard` | JSON Body | `UserIcCardBean` |
| 15 | POST | `/brand/brand/album/index` | `getHomeVideo` | JSON Body | `VideoListBean` |
| 16 | POST | `/brand/brand/album/list` | `getNewClassPhotoList` | JSON Body | `VideoListBean` |
| 17 | POST | `/brand/brand/album/listDetail` | `getNewPhotoList` | JSON Body | `PhotoAlbumTwoBean` |
| 18 | GET | `/brand/brand/campus/style` | `SchoolStyle` | — | `SchoolStytleRsp` |
| 19 | POST | `/brand/brand/campus/teachers` | `Teachers` | JSON Body | `TeachersRsp` |
| 20 | GET | `/brand/brand/classes/info` | `selectNewClassesInfo` | `Query(CommentsHomeFragment.TYPE_CLASSESID)` `str` | `NewClassInfoRsp` |
| 21 | POST | `/brand/brand/classes/watchword/list` | `getWatchWord` | JSON Body | `NewWatchWordRsp` |
| 22 | GET | `/brand/brand/countdown/list` | `getNewCountdownList` | `Query(CommentsHomeFragment.TYPE_CLASSESID)` `str` | `TimelistRsp` |
| 23 | GET | `/brand/brand/getSwitchsType` | `switchNewList` | `Query(id)` `str` | `switchlistRsp` |
| 24 | POST | `/brand/brand/layoutclasssign/layoutlist` | `getNewLayoutList` | JSON Body | `LayoutListRsp` |
| 25 | POST | `/brand/brand/mess/recive/dominateScreen/list` | `getMessageDominateScreenList` | JSON Body | `BaseResponse<List<MessageItemBean>>` |
| 26 | POST | `/brand/brand/mess/recive/page` | `getNewNoticeWithPag` | JSON Body | `getNoticeRsp` |
| 27 | GET | `/brand/brand/remind/list` | `newRemind` | `Query(brandId)` `str` | `NewRemindRsp` |
| 28 | GET | `/brand/brand/school/semester/current` | `getSemesterTime` | — | `BaseResponse<SemesterTimeRsp>` |
| 29 | GET | `/brand/brand/studentduty/selectRecord` | `getNewStudentDuty` | — | `StudenDutyBean` |
| 30 | POST | `/brand/brand/studentwork/list` | `getNewStudentWorkList` | JSON Body | `StudentWorkListBean` |
| 31 | GET | `/brand/brand/studentwork/selectStudentInfo` | `selectNewStudentInfo` | `Query(id)` `str` | `StudentInfoBean` |
| 32 | POST | `/brand/brand/studentwork/workComment` | `setNewWorkComment` | JSON Body | `NewWorkCommentRsp` |
| 33 | GET | `/brand/brand/studentwork/workLike` | `setNewWorkLike` | `Query(id)` `str`<br>`Query(userId)` `str2` | `NewWorkCommentRsp` |
| 34 | POST | `/brand/brand/updateApkVersion` | `updateApkVersion` | JSON Body | `Object` |
| 35 | POST | `/brand/class-brand-management/Android/Authority/selectTeacherByIcCard` | `selectTeacherByIcCard` | JSON Body | `selectTeacherByIcCardRsp` |
| 36 | POST | `/brand/class-brand-management/android/appRegistraCode/insetVersionUpdatedSchool` | `insetVersionUpdatedSchool` | JSON Body | `insetVersionUpdatedSchoolRsp` |
| 37 | POST | `/brand/class-brand-management/android/class/selectClassesInfo` | `selectClassesInfo` | `Query(brandClassLoginName)` `str` | `selectClassesInfoRsp` |
| 38 | POST | `/brand/class-brand-management/android/course/classSchedule` | `UserTable` | JSON Body | `UserTableRsp` |
| 39 | POST | `/brand/class-brand-management/android/course/classSchedule` | `getClassSchedule` | JSON Body | `ClassScheduleRsp` |
| 40 | POST | `/brand/class-brand-management/android/studentspace/selectStudentByIcCard` | `selectStudentByIcCard` | JSON Body | `selectStudentByIcCardRsp` |
| 41 | POST | `/brand/class-brand-management/android/videoalbum/classifylist` | `getPhotoAlbumTablist` | JSON Body | `PhotoAlbumTabBean` |
| 42 | GET | `/brand/class-brand-management/app/studentDuty/selectRecord` | `getStudentDuty` | `Query(classId)` `str` | `StudenDutyBean` |
| 43 | POST | `/brand/obtain` | `getBrandObtain` | JSON Body | `NewBrandLoginRsp` |
| 44 | GET | `/brand/v2/custom/mode/list` | `requestDominateScreenLevel` | `Query(brandId)` `str` | `BaseResponse<List<DominateDetailLevelBean>>` |
| 45 | POST | `/brand/weather/day7` | `getNewWeatherList` | JSON Body | `BaseResponse<NewWeatherListBean>` |
| 46 | POST | `/brand/weather/now` | `getNewWeather` | JSON Body | `BaseResponse<NewWeatherBean>` |
| 47 | POST | `/cloud/app/procAppr/deleteInstance` | `deleteInstance` | JSON Body | `BaseContentRsp` |
| 48 | POST | `/cloud/app/procAppr/getApprList` | `getApprover` | JSON Body | `ApproverListRsp` |
| 49 | POST | `/cloud/app/timetable/getWeekTime` | `getCDKB` | JSON Body | `KBRsp2` |
| 50 | GET | `/cloud/app/userAppr/getInfo` | `getApproverInfo` | `Query(id)` `str` | `ApproverInfoRsp` |
| 51 | POST | `/cloud/app/userAppr/page` | `askForLeaveRecordBandList` | JSON Body | `GetAskLeaveRecordBandRsp` |
| 52 | POST | `/cloud/app/work/pageThisWeekWork` | `getNewTaskList` | JSON Body | `StudentTaskBean` |
| 53 | POST | `/cloud/brand/calendar/getSchoolCalendar` | `getSchoolCalendar` | JSON Body | `getSchoolCalendarRsp` |
| 54 | POST | `/cloud/calendar/selectSchoolCalendar` | `selectSchoolCalendar` | JSON Body | `selectSchoolCalendarRsp` |
| 55 | GET | `/cloud/device/mess/publish/getCaptionsNoticeInfo` | `getCaptionsNoticeInfo` | `Query(schoolId)` `str`<br>`Query(deviceId)` `str2` | `BaseResponse<MessageCaptionBean>` |
| 56 | GET | `/cloud/im/user/sig/gen` | `getUserSig` | `Query(identifier)` `str` | `getUserSigByUserIdRsp` |
| 57 | GET | `/cloud/im/user/sig/getSystemSig` | `getSystemSign` | — | `BaseResponse<String>` |
| 58 | POST | `/cloud/proc/startInstance` | `addLeave` | JSON Body | `BaseContentRsp` |
| 59 | POST | `/cloud/student/allStudents` | `allStudents` | JSON Body | `AllstudentRsp` |
| 60 | POST | `/cloud/v2/barrier/getAppVersion` | `getNewestVersion` | JSON Body | `getNewestVersionRsp` |
| 61 | POST | `/cloud/v2/barrier/getOrBindingDevice` | `getOrBindingDevice` | JSON Body | `getRegistrationCodeRsp` |
| 62 | POST | `/cloud/v2/barrier/getRegistrationCode` | `getRegistrationCode` | JSON Body | `getRegistrationCodeRsp` |
| 63 | POST | `/cloud/v2/barrier/updateRegistrationCode` | `updateNewRegistrationCodeByCode` | JSON Body | `getRegistrationCodeRsp` |
| 64 | POST | `/cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo` | `getBrandRegistrationCode` | JSON Body | `BrandRegistrationCodeRsp` |
| 65 | POST | `/face/cloud-face/attendance/brand/app/v2/queryBrandAttendanceByClassIds` | `queryBrandAttendanceByClassIds` | JSON Body | `AttenceListBean` |
| 66 | POST | `/face/cloud-face/attendance/peopleAttendance` | `attendance` | JSON Body | `GeneralBean` |
| 67 | POST | `/face/cloud-face/attendance/viewCbAttendance` | `getAttencelist` | JSON Body | `AttenceBean` |
| 68 | POST | `/file/upload/path` | `uploadLogFile` | `multipart/form-data` | `BaseResponse<List<UploadFileBean>>` |
| 69 | GET | `/management/cloud-system/pc/getClassesInfo/{classId}` | `getClassesInfo` | `Path(classId)` `j` | `ClassesInfoBean` |
| 70 | POST | `/timetable/cloud-timetable/v1/kcb/classes` | `getKB` | `Query(bjid)` `str`<br>`Query(skzc)` `str2` | `KBRsp` |


### IAIService（4 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/ai/assistant/get` | `requestAIGetInfo` | JSON Body | `BaseResponse<AIProblemBean>` |
| 2 | POST | `/ai/assistant/public/list` | `requestAIHomeList` | JSON Body | `BaseResponse<List<AIIntellectHomeBean>>` |
| 3 | POST | `/ai/chat/models` | `requestAIModelList` | JSON Body | `BaseResponse<List<AIModelBean>>` |
| 4 | POST | `/ai/chat/session/create` | `requestAICreateSession` | JSON Body | `BaseResponse<AICreateSessionBean>` |


### IActiveService（5 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/brand/activity/enroll/activityEnrollInfo` | `requestLoginActiveDetails` | JSON Body | `BaseResponse<ActiveDetailsBean>` |
| 2 | POST | `/brand/activity/enroll/detail` | `requestActiveDetails` | JSON Body | `BaseResponse<ActiveDetailsBean>` |
| 3 | POST | `/brand/activity/enroll/page` | `requestActiveList` | JSON Body | `BaseResponse<BasePageResponse<List<ActiveRegistrationBean>>>` |
| 4 | POST | `/brand/activity/enroll/userActivityEnroll` | `requestActiveRegistration` | JSON Body | `BaseResponse<ActiveSuccessBean>` |
| 5 | POST | `/brand/activity/enroll/userEnrollPage` | `requestMyRegistrationList` | JSON Body | `BaseResponse<BasePageResponse<List<ActiveMyRegistrationBean>>>` |


### ICollectService（7 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/app/collectTableBrand/check` | `requestFormDetail` | JSON Body | `BaseResponse<FormDetailBean>` |
| 2 | POST | `/app/collectTableBrand/lookOver` | `requestCollectSituation` | JSON Body | `BaseResponse<CollectSituationBean>` |
| 3 | POST | `/app/collectTableBrand/overview` | `requestCollectList` | JSON Body | `BaseResponse<BasePageResponse<List<CollectListBean>>>` |
| 4 | POST | `/app/collectTableBrand/write` | `requestSubmitFormContent` | JSON Body | `BaseResponse<Boolean>` |
| 5 | POST | `/app/collectTableComponent/brand` | `requestHomeCollectList` | JSON Body | `BaseResponse<BasePageResponse<List<HomeCollectBean>>>` |
| 6 | GET | `/app/employee/getDeptById` | `requestTeacherDeptList` | `Query(shcoolId)` `str`<br>`Query(employeeId)` `str2` | `BaseResponse<List<DeptListBean>>` |
| 7 | GET | `/app/student/selectClassByStudentId` | `requestStudentClasses` | `Query(CommentsHomeFragment.TYPE_ID)` `str` | `BaseResponse<StudentClassesBean>` |


### ICustomizedService（3 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/cloud/sks/site/get` | `requestSiteInfo` | JSON Body | `BaseResponse<CustomSiteInfoBean>` |
| 2 | POST | `/cloud/sks/site/getSiteEnvIndicators` | `requestSensorInfoList` | JSON Body | `BaseResponse<CustomSensorBean>` |
| 3 | POST | `/cloud/sks/site/getSiteImages` | `requestWarningInfoList` | JSON Body | `BaseResponse<CustomSiteInfoBean>` |


### IDormitoryService（2 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | GET | `/brand/brand/dormitory/dormitoryHomepage/detail` | `requestHomeDormitoryDetail` | `Query(id)` `str` | `BaseResponse<DormitoryDetailsBean>` |
| 2 | GET | `/cloud/moralEducationActivityBrand/dormitory` | `requestHomeDormitoryEducation` | `Query(schoolId)` `str`<br>`Query(CommentsHomeFragment.TYPE_CLASSESID)` `str2` | `BaseResponse<DormitoryEducationBean>` |


### IEvaluationService（8 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/brand/appEvalMedal/getUserMedalInfo` | `requestEvaluationMedalDetails` | JSON Body | `BaseResponse<EvaluationMedalBean>` |
| 2 | GET | `/brand/appEvalMedal/listEvalMedalType` | `requestEvaluationMedalTypeList` | — | `BaseResponse<List<EvaluationMedalTypeBean>>` |
| 3 | POST | `/brand/appEvalMedal/pageEvalUserMedal` | `requestEvaluationMedalPageList` | JSON Body | `BaseResponse<BasePageResponse<List<EvaluationMedalBean>>>` |
| 4 | POST | `/brand/evalDataCountStatistic/rankListByClass` | `requestEvaluationList` | JSON Body | `BaseResponse<List<EvaluationBean>>` |
| 5 | GET | `/brand/evalPersonScore/getEvalPersonScoreInfo` | `requestEvaluationPointDetails` | `Query(personId)` `str`<br>`Query(identity)` `str2` | `BaseResponse<EvaluationPointBean>` |
| 6 | POST | `/brand/evalScoreCard/getUserScoreCardInfo` | `requestEvaluationPointCardDetails` | JSON Body | `BaseResponse<EvaluationPointCardCancelBean>` |
| 7 | POST | `/brand/evalScoreCard/pageUserScoreCard` | `requestEvaluationPointCardPageList` | JSON Body | `BaseResponse<BasePageResponse<List<EvaluationPointCardBean>>>` |
| 8 | POST | `/brand/evalScoreRecord/page` | `requestEvaluationPointPageList` | JSON Body | `BaseResponse<BasePageResponse<List<EvaluationPointBean>>>` |


### IExamManageService（7 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/brand/exam/by/student` | `requestUserExamList` | JSON Body | `BaseResponse<List<ExamPlanItem>>` |
| 2 | POST | `/brand/exam/detail` | `requestExamDetail` | JSON Body | `BaseResponse<ExamPlanItem>` |
| 3 | POST | `/brand/exam/person` | `requestExamPersonSeat` | JSON Body | `BaseResponse<List<ExamPersonSeatBean>>` |
| 4 | POST | `/brand/exam/plan/week` | `requestWeekExam` | JSON Body | `BaseResponse<List<ExamArrangementBean>>` |
| 5 | POST | `/brand/exam/recent` | `requestTodayExam` | JSON Body | `BaseResponse<List<ExamPlanItem>>` |
| 6 | POST | `/brand/exam/student/sing/in` | `requestSignExam` | JSON Body | `BaseResponse<Boolean>` |
| 7 | GET | `/manage/machineInfo/getMachineConfigByDeviceNo` | `requestDeviceConfig` | `Query(deviceNo)` `str` | `BaseResponse<BrandConfigBean>` |


### ILibraryService（7 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/rfid/class-board/category/list` | `requestLibraryClassifyList` | JSON Body | `BaseResponse<List<LibraryTypeBean>>` |
| 2 | POST | `/rfid/class-board/opac/book` | `requestLibrarySearch` | JSON Body | `BaseResponse<BasePageResponse<List<LibraryItemBean>>>` |
| 3 | POST | `/rfid/class-board/opac/bookDetail` | `requestLibraryBookSituation` | JSON Body | `BaseResponse<BasePageResponse<List<LibraryCollectBookSituationBean>>>` |
| 4 | GET | `/rfid/class-board/opac/itemTypeList` | `requestLibraryTypeList` | `Query(libraryId)` `str` | `BaseResponse<List<LibraryTypeBean>>` |
| 5 | POST | `/rfid/class-board/rank/hot-circulation-rank` | `requestHotList` | JSON Body | `BaseResponse<List<LibraryItemBean>>` |
| 6 | POST | `/rfid/class-board/rank/new-book-recommend` | `requestLibraryNewList` | JSON Body | `BaseResponse<List<LibraryItemBean>>` |
| 7 | POST | `/rfid/hm-board/library/list` | `requestLibraryList` | JSON Body | `BaseResponse<List<LibraryBean>>` |


### INetworkService（60 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | GET | `/app/area/list` | `requestAreaInfo` | — | `BaseResponse<List<AreaBean>>` |
| 2 | POST | `/app/file/upload` | `upload` | `multipart/form-data` | `BaseResponse<List<UploadFileBean>>` |
| 3 | POST | `/attweb/app/attendance/listToDay` | `requestAttendance` | JSON Body | `BaseResponse<List<AttenceNewListBean.DataDTO>>` |
| 4 | GET | `/auth/qrcode/check` | `getCheckLoginQrCode` | `Query(random)` `str` | `BaseResponse<LoginQrCodeBean>` |
| 5 | GET | `/auth/qrcode/check` | `requestQrCodeCheck` | `Query(random)` `str` | `BaseResponse<ScanQrCodeBean>` |
| 6 | GET | `/auth/qrcode/gene` | `getLoginQrCode` | `Query(type)` `str` | `BaseResponse<LoginQrCodeBean>` |
| 7 | GET | `/auth/qrcode/gene` | `requestQrCode` | `Query(type)` `str`<br>`Query(schoolId)` `str2` | `BaseResponse<ScanQrCodeBean>` |
| 8 | POST | `/brand/after/school/log/afterSchool` | `oneKeySchool` | JSON Body | `BaseResponse<Boolean>` |
| 9 | POST | `/brand/after/school/log/board` | `classesOverInfo` | JSON Body | `BaseResponse<ClassesOverInfoBean>` |
| 10 | POST | `/brand/brand/Authority/checkIotControlByPassword` | `verifyTeacherLogin` | JSON Body | `BaseResponse<VerifyTeacherLoginBean>` |
| 11 | POST | `/brand/brand/Authority/selectStudentByIcCard` | `selectNewStudentByIcCard` | JSON Body | `BaseResponse<selectNewStudentByIcCardRsp.DataBean>` |
| 12 | POST | `/brand/brand/Authority/selectTeacherByIcCard` | `selectTeacherInfoByCardOrFace` | JSON Body | `BaseResponse<selectTeacherByIcCardRsp.DataDTO>` |
| 13 | POST | `/brand/brand/Authority/selectUserInfoByIcCard` | `selectUserByCardOrFace` | JSON Body | `BaseResponse<UserIcCardBean.DataBean>` |
| 14 | GET | `/brand/brand/classes/info` | `getClassesInfo` | — | `BaseResponse<NewClassInfoRsp.DataDTO>` |
| 15 | POST | `/brand/brand/classes/watchword/list` | `getWatchWord` | JSON Body | `BaseResponse<List<NewWatchWordRsp.DataDTO>>` |
| 16 | GET | `/brand/brand/getBrandDominateScreen` | `requestDominateScreenLevel` | — | `BaseResponse<List<DominateDetailLevelBean>>` |
| 17 | POST | `/brand/brand/mess/recive/dominateScreen/list` | `requestMessageDominateScreenList` | JSON Body | `BaseResponse<List<MessageItemBean>>` |
| 18 | GET | `/brand/brand/mess/recive/index` | `requestMessageHome` | — | `BaseResponse<MessageListBean>` |
| 19 | POST | `/brand/brand/mess/recive/index` | `login` | `Query(username)` `str`<br>`Query(password)` `str2`<br>`Query(client_id)` `str3`<br>`Query(grant_type)` `str4`<br>`Query(client_secret)` `str5` | `BaseResponse<NewLoginRsp>` |
| 20 | POST | `/brand/brand/mess/recive/page` | `requestMessage` | JSON Body | `BaseResponse<getNoticeRsp.DataDTO>` |
| 21 | POST | `/brand/brand/mess/recive/page` | `requestMessageList` | JSON Body | `BaseResponse<BasePageResponse<List<MessageItemBean>>>` |
| 22 | POST | `/brand/brand/v3/studentduty/selectRecord` | `getDutyWeekList` | JSON Body | `BaseResponse<List<DutyModel>>` |
| 23 | POST | `/brand/layoutclasssign/getVideoStreams` | `requestRTSPPath` | JSON Body | `BaseResponse<LayoutListRsp.DataBean.LayoutClassSignDetailsEntityListBean>` |
| 24 | POST | `/brand/obtain` | `getBrandInfo` | JSON Body | `BaseResponse<NewBrandLoginRsp>` |
| 25 | POST | `/brand/openDoor/records/create` | `requestRecords` | JSON Body | `BaseResponse<String>` |
| 26 | POST | `/brand/upload/signInLog` | `pauschCard` | JSON Body | `BaseResponse<String>` |
| 27 | GET | `/brand/v2/custom/mode/list` | `requestCustomDominateScreenList` | `Query(brandId)` `str` | `BaseResponse<List<DominateCustomBean>>` |
| 28 | POST | `/cloud/app/honor/brandPage` | `requestHonorWallList` | JSON Body | `BaseResponse<HonorWallBean>` |
| 29 | POST | `/cloud/app/timetable/getWeekTime` | `requestCourseList` | JSON Body | `BaseResponse<KBRsp2.DataDTO>` |
| 30 | POST | `/cloud/device/face-sync/update-status` | `requestSynchronizeStatusFaceExtraction` | JSON Body | `BaseResponse<String>` |
| 31 | GET | `/cloud/device/mess/publish/getCaptionsNoticeInfo` | `requestHomeCaption` | `Query(schoolId)` `str`<br>`Query(deviceId)` `str2` | `BaseResponse<MessageCaptionBean>` |
| 32 | POST | `/cloud/device/shared-config/get` | `requestFaceConfig` | JSON Body | `BaseResponse<FaceActiveConfigBean>` |
| 33 | POST | `/cloud/evaluationActivityBrand/detail` | `requestActiveDetail` | JSON Body | `BaseResponse<HonorActiveDetailBean>` |
| 34 | POST | `/cloud/evaluationActivityBrand/goToScore` | `requestGoToScore` | JSON Body | `BaseResponse<HonorGoCommentBean>` |
| 35 | POST | `/cloud/evaluationActivityBrand/identityDetail` | `requestIdentityDetail` | JSON Body | `BaseResponse<BasePageResponse<List<HonorScoreDetailBean>>>` |
| 36 | POST | `/cloud/evaluationActivityBrand/list` | `requestActiveHonorList` | JSON Body | `BaseResponse<BasePageResponse<List<HonorActiveBean>>>` |
| 37 | POST | `/cloud/evaluationActivityBrand/queryActivityCycle` | `requestActivityCycle` | JSON Body | `BaseResponse<List<HonorScoreCycleBean>>` |
| 38 | POST | `/cloud/evaluationActivityBrand/queryLastClassScoreResult` | `requestClassScoreResult` | JSON Body | `BaseResponse<List<HonorScoreListBean>>` |
| 39 | POST | `/cloud/evaluationActivityBrand/result` | `requestActiveResultList` | JSON Body | `BaseResponse<HonorCommentResultBean>` |
| 40 | POST | `/cloud/evaluationActivityBrand/scoreClass` | `requestClassScoreComment` | JSON Body | `BaseResponse<String>` |
| 41 | POST | `/cloud/evaluationActivityBrand/scoreStudent` | `requestStudentScoreComment` | JSON Body | `BaseResponse<String>` |
| 42 | POST | `/cloud/evaluationActivityMobile/childrenHonor` | `requestKidsHonorList` | JSON Body | `BaseResponse<BasePageResponse<List<HonorKidsLIstBean>>>` |
| 43 | POST | `/cloud/evaluationPrize/classHonor` | `requestClassHonorList` | JSON Body | `BaseResponse<BasePageResponse<List<HonorClassBean>>>` |
| 44 | POST | `/cloud/evaluationPrize/studentHonor` | `requestStudentHonorList` | JSON Body | `BaseResponse<BasePageResponse<List<HonorStudentBean>>>` |
| 45 | GET | `/cloud/im/user/sig/gen` | `getUserSig` | `Query(identifier)` `str` | `BaseResponse<getUserSigByUserIdRsp.DataBean>` |
| 46 | POST | `/cloud/leaveWord/brand/create` | `requestAddComments` | JSON Body | `BaseResponse<String>` |
| 47 | GET | `/cloud/leaveWord/delete` | `requestCommentsDelete` | `Query(id)` `str` | `BaseResponse<String>` |
| 48 | GET | `/cloud/leaveWord/get` | `requestCommentsDetail` | `Query(id)` `str` | `BaseResponse<CommentsDetailBean>` |
| 49 | GET | `/cloud/leaveWord/getLeaveWordSetting` | `getLeaveWordSetting` | `Query(type)` `str` | `BaseResponse<ConfigComplaintBean>` |
| 50 | POST | `/cloud/leaveWord/page` | `requestCommentsList` | JSON Body | `BaseResponse<BasePageResponse<List<CommentsDetailBean>>>` |
| 51 | POST | `/cloud/moralEducationActivityBrand/gotoScore` | `gotoScore` | JSON Body | `BaseResponse<Float>` |
| 52 | POST | `/cloud/moralEducationActivityBrand/overviewDetail` | `requestDailyScoreDetails` | JSON Body | `BaseResponse<List<ScoringDetailCycleModel>>` |
| 53 | POST | `/cloud/moralEducationActivityBrand/race` | `requestClassMe` | JSON Body | `BaseResponse<IndexClassMEModel>` |
| 54 | POST | `/cloud/moralEducationActivityBrand/scoringRubric` | `requestScoringRubric` | JSON Body | `BaseResponse<List<FirstIndicatorModel>>` |
| 55 | POST | `/cloud/moralEducationActivityBrand/securityCheck` | `securityCheck` | JSON Body | `BaseResponse<CheckSecurityModel>` |
| 56 | GET | `/cloud/site/getSite` | `requestSiteInfo` | `Query(id)` `str` | `BaseResponse<SiteInfoBean>` |
| 57 | POST | `/cloud/v2/barrier/getOrBindingDevice` | `getActivationCode` | JSON Body | `BaseResponse<getRegistrationCodeRsp>` |
| 58 | POST | `/cloud/v2/barrier/getRegistrationCode` | `getRegistrationCode` | JSON Body | `BaseResponse<getRegistrationCodeRsp>` |
| 59 | POST | `/cloud/v2/barrier/updateRegistrationCode` | `updateNewRegistrationCodeByCode` | JSON Body | `BaseResponse<getRegistrationCodeRsp>` |
| 60 | POST | `/cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo` | `getBrandRegistrationCode` | JSON Body | `BaseResponse<BrandRegistrationCodeRsp>` |


### IPatrolService（6 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/app/patrolDayTaskSite/finishSiteTask` | `requestSubmitPatrol` | JSON Body | `BaseResponse<Boolean>` |
| 2 | GET | `/app/patrolDayTaskSite/get` | `requestPatrolDetail` | `Query(id)` `str` | `BaseResponse<PatrolDetailBean>` |
| 3 | POST | `/app/patrolDayTaskSite/page` | `requestPatrolList` | JSON Body | `BaseResponse<BasePageResponse<List<PatrolListBean>>>` |
| 4 | POST | `/app/patrolDayTaskSite/updateClockIn` | `requestUpdatePatrolPunch` | JSON Body | `BaseResponse<Boolean>` |
| 5 | POST | `/app/patrolDayTaskSite/updateNowClock` | `requestPatrolPunch` | JSON Body | `BaseResponse<Boolean>` |
| 6 | GET | `/app/patrolQrCode/getSiteQrCodeStatus` | `requestScanQrCodeStatus` | `Query(siteId)` `str` | `BaseResponse<VerifyPeopleBean>` |


### IReservationService（6 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | GET | `/cloud/employee/get` | `requestEmployeeDetails` | `Query(id)` `str` | `BaseResponse<ConsultTeacherBean>` |
| 2 | POST | `/cloud/employee/getEmployeeListByLabel` | `requestConsultList` | JSON Body | `BaseResponse<List<ConsultTeacherBean>>` |
| 3 | POST | `/cloud/siteBooking/bookingRecordPage` | `requestReservationRecordList` | JSON Body | `BaseResponse<BasePageResponse<List<ReservationRecordBean>>>` |
| 4 | GET | `/cloud/siteBooking/get` | `requestReservationRecordDetail` | `Query(id)` `str` | `BaseResponse<ReservationDetailBean>` |
| 5 | POST | `/cloud/siteBooking/siteBookingBatchSign` | `requestReservationOfflineSign` | JSON Body | `BaseResponse<Integer>` |
| 6 | POST | `/cloud/siteBooking/siteBookingSign` | `requestReservationSign` | JSON Body | `BaseResponse<Boolean>` |


### ISettingActivationService（1 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/cloud/v2/barrier/getOrBindingDevice` | `getActivationCode` | JSON Body | `BaseResponse<getRegistrationCodeRsp.RegistrationCode>` |


### ITaskSignService（8 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/attweb/attendanceSignTask/app/add` | `requestAddTask` | JSON Body | `BaseResponse<String>` |
| 2 | POST | `/attweb/attendanceSignTask/app/delete` | `requestDeleteTask` | JSON Body | `BaseResponse<String>` |
| 3 | POST | `/attweb/attendanceSignTask/app/update` | `requestUpdateTask` | JSON Body | `BaseResponse<String>` |
| 4 | POST | `/attweb/attendanceSignTask/brand/brandBillBoard` | `requestTaskList` | JSON Body | `BaseResponse<List<MyTaskListItem>>` |
| 5 | POST | `/attweb/attendanceSignTask/brand/get` | `requestTaskDetail` | JSON Body | `BaseResponse<TaskDetailBean>` |
| 6 | POST | `/attweb/attendanceSignTask/brand/list` | `requestMyTaskList` | JSON Body | `BaseResponse<MyTaskListBean>` |
| 7 | POST | `/attweb/attendanceSignTask/brand/sign` | `requestSignTask` | JSON Body | `BaseResponse<String>` |
| 8 | GET | `/cloud/address/book/student` | `getAddressBook` | `Query(CommentsHomeFragment.TYPE_ID)` `str` | `BaseResponse<List<AddressBookBean>>` |


### IUserSpaceService（13 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/app/actLeaveVacation/calculateLeaveDays` | `requestLeaveLength` | JSON Body | `BaseResponse<String>` |
| 2 | GET | `/app/formProcessTemplates/getDefaultStudentLeave` | `requestStudentLeaveForm` | — | `BaseResponse<LeaveFormBean>` |
| 3 | POST | `/app/userAppr/pageDeviceAppr` | `requestRepairList` | JSON Body | `BaseResponse<BasePageResponse<List<LeaveRecordBean>>>` |
| 4 | GET | `/app/userAppr/v2/getInfo` | `requestLeaveDetail` | `Query(id)` `str` | `BaseResponse<LeaveDetailBean>` |
| 5 | POST | `/app/v2/proc/deleteInstance` | `requestRevokeLeave` | JSON Body | `BaseResponse<Boolean>` |
| 6 | POST | `/app/v2/proc/getFlowElements` | `requestStudentLeaveProcess` | JSON Body | `BaseResponse<LeaveProcessBean>` |
| 7 | POST | `/app/v2/proc/pageTask` | `requestLeaveRecord` | JSON Body | `BaseResponse<BasePageResponse<List<LeaveRecordBean>>>` |
| 8 | POST | `/app/v2/proc/startInstance` | `requestSubmitStudentLeave` | JSON Body | `BaseResponse<String>` |
| 9 | POST | `/app/v2/proc/updateApprovalProc` | `requestFormModify` | JSON Body | `BaseResponse<Boolean>` |
| 10 | GET | `/cloud/actLeaveVacation/list` | `requestLeaveTypeOption` | `Query(type)` `str` | `BaseResponse<List<LeaveTypeBean>>` |
| 11 | POST | `/cloud/app/procAppr/deleteInstance` | `requestOldRevokeLeave` | JSON Body | `BaseResponse<String>` |
| 12 | GET | `/cloud/app/userAppr/getInfo` | `requestOldLeaveDetail` | `Query(id)` `str` | `BaseResponse<ApproverInfoRsp.DataDTO>` |
| 13 | GET | `/cloud/formProcessTemplates/getByKey` | `requestRepairForm` | `Query(formKey)` `str` | `BaseResponse<LeaveFormBean>` |


### IVoteService（3 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/cloud/vote/clickVote` | `requestSubmitVote` | JSON Body | `BaseResponse<Boolean>` |
| 2 | POST | `/cloud/vote/get` | `requestVoteDetail` | JSON Body | `BaseResponse<VoteDetailBean>` |
| 3 | POST | `/cloud/vote/page` | `requestHomeVoteList` | JSON Body | `BaseResponse<BasePageResponse<List<VoteDetailBean>>>` |


### LocalApiStores（7 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | POST | `/api/lock/listSwk.html` | `listSwk` | JSON Body | `listSwkRsp` |
| 2 | POST | `/api/lock/saveSwk` | `saveSwk` | JSON Body | `saveSwkRsp` |
| 3 | POST | `/backstage/cloud-backstage/kf/application/getNewestVersion` | `getNewestVersion` | JSON Body | `getNewestVersionRsp` |
| 4 | POST | `/brand/class-brand-management/app/loginCheck/getSiteByUserName` | `getSiteByUserName` | `Query(equipmentSerialNumber)` `str` | `GetSiteByUserNameRsp` |
| 5 | POST | `/cloud/app/timetable/getWeekTime` | `getCDKB` | JSON Body | `KBRsp2` |
| 6 | POST | `/leave-server/cloud-leave/student/addStudentLeaveByStudentUserId` | `LeaveCommit` | JSON Body | `LeaveCommitRsp` |
| 7 | POST | `/management/cloud-system/im/getUserSigByUserId` | `getUserSigByUserId` | JSON Body | `getUserSigByUserIdRsp` |


### WeatherApiStores（1 个）

| # | 方法 | 路径 | 源码方法 | 参数 / Body | 返回类型 |
| ---: | --- | --- | --- | --- | --- |
| 1 | GET | `/Ecalender/weather_mini` | `getWeather` | `Query(city)` `str` | `WeatherRsp` |

---

## 8. Mock Server 与本地调试

### 8.1 启动与日志

```powershell
cd mock-server
python mock_server.py --host 0.0.0.0 --port 8765
```

- 每个请求打印到 stdout；
- 追加 JSON Lines 到 `mock-server/requests.log`；
- 静态图片/视频在 `/mock/img/*`、`/mock/mock-video.mp4`；
- 响应统一 `{"code":0,"message":"ok","data":...}`（登录等少数接口直接返回数据）。

`requests.log` 单行示例：

```json
{"ts":"2026-10-19T01:18:31","method":"POST","path":"/auth/oauth/token","query":{"username":["admin"],"password":["123456"],"client_id":["yide-cloud"],"grant_type":["brand"],"client_secret":["<client_secret>"]},"body":""}
```

### 8.2 Mock APK 的改动

| 改动 | 值 |
| --- | --- |
| API host | `http://10.0.2.2:8765` |
| MAC | `__SEC_MAC_PUT_92F7D57E__` |
| 登录 | 任意账号密码 |
| 额外 Activity | `MockLeaveActivity`、`MockManagerActivity`、`MockPortalActivity` |
| 注入 dex | `classes7.dex` |
| Launcher | `WelcomeActivity`（未改） |

打开功能大厅：

```powershell
adb shell am start -n com.yd.android_brand_mvp/com.yd.android_brand_mvp.MockPortalActivity
```

### 8.3 真机调试的 host 方案

| 方案 | 做法 | 适用 |
| --- | --- | --- |
| Mock APK | 已固定 `10.0.2.2` | 模拟器 |
| `adb reverse` | `adb reverse tcp:8765 tcp:8765`，再把 APK host 改成 `http://127.0.0.1:8765` | 真机（需重打包） |
| 局域网 IP | 把 APK host 改成电脑 IP，如 `http://192.168.1.10:8765` | 真机（需重打包） |
| hosts/Clash | 把 `api.yyide.com` 指到本地，需 HTTPS 证书 | 抓包/劫持调试（仅自有设备） |

### 8.4 给 Mock Server 加一个接口

编辑 `mock-server/mock_server.py` 的 `data_for()`：

```python
if "my/new/endpoint" in p:
    return {
        "total": 1,
        "pageNo": 1,
        "pageSize": 20,
        "list": [{"id": "1", "name": "示例"}],
    }
```

重启服务即可；请求会出现在 `requests.log`。

### 8.5 调试清单

1. App 是否请求 `http://10.0.2.2:8765`？看 `requests.log` 最后一条；
2. 响应 `code` 是否 0？`message`/`detailMessage` 是什么？
3. 返回类型是否是列表/对象？Mock Server 对 `list/page/record` 返回分页对象，对 `album` 等返回数组；
4. 字段名是否和 Gson 模型一致？大小写、下划线、数字/字符串；
5. 是否需要 token？Mock Server 不校验，但 App 拦截器会加；
6. 图片/视频 URL 是否指向 `10.0.2.2:8765` 且能访问？

---

## 9. 代码示例

### 9.1 Python 完整客户端

> 以下代码在 Mock Server 上跑通过；换成 `https://api.yyide.com` 和真实账号即可用于自有环境。

```python
#!/usr/bin/env python3
"""智慧班牌 API 客户端（示例）。"""
from __future__ import annotations

import os
import random
import string
from datetime import datetime, timedelta
from typing import Any, Iterator

import requests


class YideError(RuntimeError):
    pass


class YideClient:
    def __init__(self, base_url: str = "https://api.yyide.com", timeout: int = 15):
        self.base_url = base_url.rstrip("/")
        self.timeout = timeout
        self.session = requests.Session()
        self.session.headers.update({
            "Content-Type": "application/json",
            "Accept": "application/json",
            "brand": "Android",
            "model": "SDK",
        })
        self.token = ""
        self.user: dict[str, Any] = {}

    # ---------- 基础请求 ----------
    def request(self, method: str, path: str, **kwargs) -> dict:
        url = f"{self.base_url}{path}"
        resp = self.session.request(method, url, timeout=self.timeout, **kwargs)
        resp.raise_for_status()
        body = resp.json()
        if isinstance(body, dict) and body.get("code") not in (None, 0):
            raise YideError(f"{body.get('code')}: {body.get('message')} / {body.get('detailMessage')}")
        return body

    def get(self, path: str, **params) -> dict:
        return self.request("GET", path, params=params)

    def post(self, path: str, body: Any | None = None) -> dict:
        return self.request("POST", path, json=body if body is not None else {})

    # ---------- 登录 ----------
    def login(self, username: str, password: str) -> dict:
        payload = {
            "username": username,
            "password": password,
            "client_id": "yide-cloud",
            "client_secret": "<client_secret>",
            "grant_type": "brand",
            "random": "".join(random.choices(string.ascii_letters + string.digits, k=16)),
        }
        body = self.request("POST", "/auth/oauth/token", params=payload)
        data = body.get("data") or {}
        access = data.get("accessToken") or data.get("access_token") or data.get("token")
        if not access:
            raise YideError(f"登录响应没有 access token: {body}")
        head = data.get("tokenHead") or "Bearer "
        self.token = head + access
        self.session.headers["Authorization"] = self.token
        return body

    # ---------- 设备/学校 ----------
    def obtain(self, login_name: str, mac: str, android_id: str = "", direction: str = "0") -> dict:
        body = self.post("/brand/obtain", {
            "loginName": login_name,
            "no": mac,
            "wlanMac": "",
            "seriaNo": android_id,
            "direction": direction,
        })
        self.user = (body.get("data") or {})
        return body

    def layout(self, brand_id: str, show_type: int = 0) -> dict:
        return self.post("/brand/brand/layoutclasssign/layoutlist", {
            "id": brand_id,
            "showType": show_type,
            "deviceType": "2",
        })

    # ---------- 首页数据 ----------
    def announcements(self, page_no: int = 1, page_size: int = 18,
                      identifier: str = "announcement") -> dict:
        end = datetime.now()
        start = end - timedelta(days=7)
        return self.post("/brand/brand/mess/recive/page", {
            "identifier": identifier,
            "pageNo": page_no,
            "pageSize": str(page_size),
            "approverId": self.user.get("id", ""),
            "startTime": start.strftime("%Y-%m-%d 00:00:00"),
            "endTime": end.strftime("%Y-%m-%d %H:%M:%S"),
        })

    def timetable(self, type_id: str, type_: str = "1") -> dict:
        return self.post("/cloud/app/timetable/getWeekTime", {
            "weekTime": "",
            "typeId": type_id,
            "type": type_,
        })

    def students(self, classes_id: str, page_size: int = 100) -> dict:
        return self.post("/cloud/student/allStudents", {
            "pageNo": 1,
            "pageSize": page_size,
            "id": classes_id,
            "type": 4,
            "key": "classes",
        })

    def classes_info(self, classes_id: str) -> dict:
        return self.get("/brand/brand/classes/info", classesId=classes_id)

    def weather(self) -> dict:
        return self.post("/brand/weather/now", {})

    # ---------- 刷卡 ----------
    def card_user(self, card_no: str) -> dict:
        return self.post("/brand/brand/Authority/selectUserInfoByIcCard", {"icCardNo": card_no})

    def card_student(self, user_id: str, type_: str = "1") -> dict:
        return self.post("/brand/brand/Authority/selectStudentByIcCard", {"userId": user_id, "type": type_})

    def card_teacher(self, user_id: str, type_: str = "1") -> dict:
        return self.post("/brand/brand/Authority/selectTeacherByIcCard", {"userId": user_id, "type": type_})

    # ---------- 分页 ----------
    def iter_pages(self, path: str, body: dict, page_size: int = 20,
                   max_pages: int = 100) -> Iterator[dict]:
        page = 1
        while page <= max_pages:
            payload = dict(body)
            payload["pageNo"] = page
            payload["pageSize"] = page_size
            data = (self.post(path, payload).get("data") or {})
            rows = data.get("list") or data.get("records") or []
            if not rows:
                break
            yield from rows
            total = int(data.get("total") or 0)
            if page * page_size >= total:
                break
            page += 1

    # ---------- 上传 ----------
    def upload(self, file_path: str) -> dict:
        with open(file_path, "rb") as fh:
            resp = self.session.post(
                f"{self.base_url}/app/file/upload",
                files={"file": (os.path.basename(file_path), fh, "application/octet-stream")},
                timeout=60,
            )
        resp.raise_for_status()
        return resp.json()

    # ---------- SSE ----------
    def chat_stream(self, session_id: str, prompt: str):
        url = f"{self.base_url}/ai/chat/completion/stream"
        headers = {"Accept": "text/event-stream", "Content-Type": "application/json"}
        with self.session.post(url, json={"sessionId": session_id, "prompt": prompt},
                               headers=headers, stream=True, timeout=(15, None)) as resp:
            resp.raise_for_status()
            for line in resp.iter_lines(decode_unicode=True):
                if not line or not line.startswith("data:"):
                    continue
                chunk = line[5:].strip()
                if chunk == "[DONE]":
                    break
                yield chunk


if __name__ == "__main__":
    c = YideClient("http://127.0.0.1:8765")
    c.login("admin", "123456")
    c.obtain("admin", "__SEC_MAC_PUT_92F7D57E__")
    print(c.announcements())
    print(c.layout(c.user.get("id", "mock-device-001")))
```

### 9.2 Node.js / 浏览器 fetch

```javascript
const BASE = "https://api.yyide.com";

async function request(path, { method = "GET", body, token } = {}) {
  const headers = {
    "Content-Type": "application/json",
    Accept: "application/json",
  };
  if (token) headers.Authorization = token;

  const resp = await fetch(`${BASE}${path}`, {
    method,
    headers,
    body: body === undefined ? undefined : JSON.stringify(body),
  });
  if (!resp.ok) throw new Error(`HTTP ${resp.status}`);
  const data = await resp.json();
  if (data.code !== 0) throw new Error(`${data.code}: ${data.message}`);
  return data;
}

async function login(username, password) {
  const random = Array.from(crypto.getRandomValues(new Uint8Array(16)))
    .map((b) => (b % 36).toString(36))
    .join("")
    .slice(0, 16);

  const qs = new URLSearchParams({
    username,
    password,
    client_id: "yide-cloud",
    client_secret: "<client_secret>",
    grant_type: "brand",
    random,
  });

  const resp = await fetch(`${BASE}/auth/oauth/token?${qs}`, { method: "POST" });
  const body = await resp.json();
  if (body.code !== 0) throw new Error(body.message);

  const d = body.data || {};
  const access = d.accessToken || d.access_token || d.token;
  return (d.tokenHead || "Bearer ") + access;
}

(async () => {
  const token = await login("admin", "123456");
  const page = await request("/brand/brand/mess/recive/page", {
    method: "POST",
    token,
    body: {
      identifier: "announcement",
      pageNo: 1,
      pageSize: "18",
      approverId: "",
      startTime: "2026-10-01 00:00:00",
      endTime: "2026-10-19 23:59:59",
    },
  });
  console.log(page.data.list);
})();
```

### 9.3 Android Retrofit

```kotlin
interface BrandApi {
    @POST("/auth/oauth/token")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("client_id") clientId: String = "yide-cloud",
        @Query("grant_type") grantType: String = "brand",
        @Query("client_secret") clientSecret: String = "<client_secret>",
        @Query("random") random: String,
    ): NewLoginRsp

    @POST("/brand/obtain")
    suspend fun obtain(@Body body: ObtainRequest): NewBrandLoginRsp

    @POST("/brand/brand/layoutclasssign/layoutlist")
    suspend fun layout(@Body body: LayoutRequest): LayoutListRsp
}

val client = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val token = SpData.getToken() // "Bearer eyJ..."
        val req = chain.request().newBuilder()
            .addHeader("Authorization", token)
            .addHeader("brand", Build.BRAND)
            .addHeader("model", Build.MODEL)
            .build()
        chain.proceed(req)
    }
    .build()

val retrofit = Retrofit.Builder()
    .baseUrl("https://api.yyide.com")
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val api = retrofit.create(BrandApi::class.java)
```

源码里的 Retrofit 定义见：

- `src/main/java/com/yd/android_brand_mvp/net/DingApiStores.java`（RxJava3）
- `src/main/java/com/yd/android_brand_mvp/network/INetworkService.java`（协程）
- `src/main/java/com/yd/android_brand_mvp/net/LocalApiStores.java`
- `src/main/java/com/yd/android_brand_mvp/net/BookApiStores.java`
- `src/main/java/com/yd/android_brand_mvp/net/WeatherApiStores.java`

### 9.4 Flask Mock Server（博客风格）

```python
from functools import wraps
from flask import Flask, jsonify, request

app = Flask(__name__)

MOCK_USERS = {
    "admin": {"password": "123456", "name": "管理员"},
    "<账号>": {"password": "<密码>", "name": "马品"},
}


def ok(data=None, message="操作成功"):
    return jsonify({"code": 0, "data": data, "message": message,
                    "detailMessage": None, "success": True, "error": False})


def err(message="操作失败", detail="", code=-1):
    return jsonify({"code": code, "data": None, "message": message,
                    "detailMessage": detail, "success": False, "error": True}), 400


def require_auth(f):
    @wraps(f)
    def wrapper(*args, **kwargs):
        auth = request.headers.get("Authorization", "")
        if not auth.startswith("Bearer ") or len(auth) < 17:
            return err("未提供有效的访问令牌", "Authorization header missing", 401)
        return f(*args, **kwargs)
    return wrapper


@app.post("/auth/oauth/token")
def token():
    username = request.values.get("username")
    password = request.values.get("password")
    if request.values.get("client_id") != "yide-cloud":
        return err("client_id 不正确")
    if request.values.get("client_secret") != "<client_secret>":
        return err("client_secret 不正确")
    if request.values.get("grant_type") != "brand":
        return err("grant_type 必须为 brand")
    if len(request.values.get("random") or "") != 16:
        return err("random 必须为 16 位")

    user = MOCK_USERS.get(username)
    if not user or user["password"] != password:
        return err("用户名或密码错误")

    return ok({
        "accessToken": "mock-access-token",
        "expiresIn": 863999,
        "refreshToken": "mock-refresh-token",
        "tokenHead": "Bearer ",
    })


@app.post("/brand/brand/mess/recive/page")
@require_auth
def notices():
    body = request.get_json(silent=True) or {}
    page_no = int(body.get("pageNo") or 1)
    page_size = int(body.get("pageSize") or 20)
    items = [{
        "id": "notice-1",
        "identityUserName": "管理员",
        "title": "欢迎使用智慧班牌",
        "content": "<p>这是 Mock 公告</p>",
        "contentType": 0,
        "messType": 1,
        "timerDate": "2026-10-19 08:00:00",
        "attachments": [],
        "isTop": True,
    }]
    return ok({"list": items, "total": len(items), "pageNo": page_no, "pageSize": page_size})


if __name__ == "__main__":
    app.run(host="127.0.0.1", port=5000, debug=True)
```

### 9.5 SSE 流式对话

Python：

```python
import requests

url = "https://api.yyide.com/ai/chat/completion/stream"
headers = {
    "Authorization": "Bearer <token>",
    "Content-Type": "application/json",
    "Accept": "text/event-stream",
}
with requests.post(url, json={"sessionId": "<id>", "prompt": "你好"},
                   headers=headers, stream=True, timeout=(15, None)) as r:
    r.raise_for_status()
    for line in r.iter_lines(decode_unicode=True):
        if line and line.startswith("data:"):
            print(line[5:].strip())
```

浏览器（`EventSource` 不能自定义 Header，需要 fetch + ReadableStream）：

```javascript
const resp = await fetch("https://api.yyide.com/ai/chat/completion/stream", {
  method: "POST",
  headers: {
    "Authorization": "Bearer <token>",
    "Content-Type": "application/json",
    "Accept": "text/event-stream",
  },
  body: JSON.stringify({ sessionId: "<id>", prompt: "你好" }),
});
const reader = resp.body.getReader();
const decoder = new TextDecoder();
let buffer = "";
while (true) {
  const { value, done } = await reader.read();
  if (done) break;
  buffer += decoder.decode(value, { stream: true });
  const lines = buffer.split("\n");
  buffer = lines.pop();
  for (const line of lines) {
    if (line.startsWith("data:")) console.log(line.slice(5).trim());
  }
}
```

### 9.6 MQTT 客户端

```python
import json
import paho.mqtt.client as mqtt

HOST = "116.63.71.76"
PORT = 1883
USERNAME = "yide"
PASSWORD = "<见 本地凭据>"

client = mqtt.Client(client_id="brand/mock-school-001/__SEC_MAC_PUT_92F7D57E__")
client.username_pw_set(USERNAME, PASSWORD)


def on_connect(c, userdata, flags, rc):
    print("connected", rc)
    c.subscribe("brand/sync/message/status", qos=1)
    c.subscribe("device_web/push/__SEC_MAC_PUT_92F7D57E__", qos=1)
    c.publish("/biz/sync/device/system/information", json.dumps({
        "mac": "__SEC_MAC_PUT_92F7D57E__",
        "schoolId": "mock-school-001",
        "version": "3.0.14",
    }), qos=1)


def on_message(c, userdata, msg):
    print(msg.topic, msg.payload.decode("utf-8", "replace"))


client.on_connect = on_connect
client.on_message = on_message
client.connect(HOST, PORT, keepalive=10)
client.loop_forever()
```

> 生产 Broker 是 `tcp://`，口令明文传输；不要在公网环境直接使用。

### 9.7 图书系统 AuthcodeTwo 签名

`AuthcodeTwo` 是 Discuz `authcode` 变体。Python 移植（已做 encode/decode 自测）：

```python
import base64
import hashlib

URL_KEY = "<URL_KEY>"


def _md5(s: str) -> str:
    return hashlib.md5(s.encode("utf-8")).hexdigest()


def _cut(s: str, start: int, length: int | None = None) -> str:
    return s[start:] if length is None else s[start:start + length]


def _rc4(data: bytes, key: bytes) -> bytes:
    s = list(range(256))
    j = 0
    for i in range(256):
        j = (j + s[i] + key[i % len(key)]) % 256
        s[i], s[j] = s[j], s[i]

    out = bytearray()
    i = j = 0
    for ch in data:
        i = (i + 1) % 256
        j = (j + s[i]) % 256
        s[i], s[j] = s[j], s[i]
        out.append(ch ^ s[(s[i] + s[j]) % 256])
    return bytes(out)


def _keys(key: str) -> tuple[str, str]:
    md5_key = _md5(key)
    key_a = _md5(_cut(md5_key, 0, 16))
    key_b = _md5(_cut(md5_key, 16, 16))
    rc4_key = key_a + _md5(key_a)
    return key_b, rc4_key


def authcode_encode(text: str, key: str = URL_KEY) -> str:
    key_b, rc4_key = _keys(key)
    payload = "0000000000" + _cut(_md5(text + key_b), 0, 16) + text
    return base64.b64encode(_rc4(payload.encode("gbk"), rc4_key.encode())).decode("ascii")


def authcode_decode(encoded: str, key: str = URL_KEY) -> str:
    key_b, rc4_key = _keys(key)
    raw = _rc4(base64.b64decode(encoded), rc4_key.encode()).decode("gbk")
    if raw[10:26] != _md5(raw[26:] + key_b)[:16]:
        raise ValueError("authcode checksum mismatch")
    return raw[26:]


def signed_url(base: str, addr: str, payload: dict) -> str:
    from urllib.parse import quote

    # 对应 Java: MyHashMap.toString() -> "key=value&key2=value2"
    data = "&".join(f"{k}={v}" for k, v in payload.items())
    return f"{base}{addr}?input={quote(authcode_encode(data, URL_KEY))}"


if __name__ == "__main__":
    text = "pageNo=1&pageSize=10"
    enc = authcode_encode(text)
    print(enc)
    print(authcode_decode(enc) == text)
```

`GetData` 的 Java 实现见 `src/main/java/com/yd/android_brand_mvp/landscape/book/AuthcodeTwo.java`。

### 9.8 cURL 速查

```bash
# 1. 登录（真实环境）
curl -s -X POST "https://api.yyide.com/auth/oauth/token?username=<user>&password=<pwd>&client_id=yide-cloud&grant_type=brand&client_secret=<client_secret>&random=abcdefgh12345678"

# 2. 学校/班级
curl -s -X POST "https://api.yyide.com/brand/obtain" \
  -H "Authorization: Bearer <token>" -H "Content-Type: application/json" \
  -d '{"loginName":"<user>","no":"__SEC_MAC_PUT_92F7D57E__","wlanMac":"","seriaNo":"<androidid>","direction":"0"}'

# 3. 首页布局
curl -s -X POST "https://api.yyide.com/brand/brand/layoutclasssign/layoutlist" \
  -H "Authorization: Bearer <token>" -H "Content-Type: application/json" \
  -d '{"id":"<brandId>","showType":0,"deviceType":"2"}'

# 4. 公告
curl -s -X POST "https://api.yyide.com/brand/brand/mess/recive/page" \
  -H "Authorization: Bearer <token>" -H "Content-Type: application/json" \
  -d '{"identifier":"announcement","pageNo":1,"pageSize":"18","approverId":"<brandId>","startTime":"2026-10-01 00:00:00","endTime":"2026-10-19 23:59:59"}'

# 5. 课表
curl -s -X POST "https://api.yyide.com/cloud/app/timetable/getWeekTime" \
  -H "Authorization: Bearer <token>" -H "Content-Type: application/json" \
  -d '{"weekTime":"","typeId":"<classesId>","type":"1"}'

# 6. 刷卡用户
curl -s -X POST "https://api.yyide.com/brand/brand/Authority/selectUserInfoByIcCard" \
  -H "Authorization: Bearer <token>" -H "Content-Type: application/json" \
  -d '{"icCardNo":"8888888888"}'

# 7. 上传
curl -s -X POST "https://api.yyide.com/app/file/upload" \
  -H "Authorization: Bearer <token>" -F "file=@photo.jpg"

# 8. SSE
curl -N -X POST "https://api.yyide.com/ai/chat/completion/stream" \
  -H "Authorization: Bearer <token>" -H "Accept: text/event-stream" \
  -H "Content-Type: application/json" \
  -d '{"sessionId":"<id>","prompt":"你好"}'
```

---

## 10. 附录

### 10.1 接口数量统计

| 分类 | 数量 |
| --- | ---: |
| 01 鉴权与登录 | 9 |
| 02 设备激活、绑定与升级 | 18 |
| 03 学校、班级与首页布局 | 19 |
| 04 首页卡片与班级展示 | 15 |
| 05 消息公告与 IM | 12 |
| 06 课表 | 6 |
| 07 考勤与打卡 | 18 |
| 08 刷卡、人脸与身份识别 | 11 |
| 09 学生空间、请假与报修 | 26 |
| 10 活动与报名 | 5 |
| 11 德育评价、荣誉与勋章 | 26 |
| 12 考试 | 6 |
| 13 图书与阅读 | 11 |
| 14 场地预约与咨询 | 6 |
| 15 巡课 | 6 |
| 16 投票与问卷 | 10 |
| 17 宿舍 | 2 |
| 18 AI 助手 | 4 |
| 19 文件上传与日志 | 3 |
| 20 设备物联与扩展 | 9 |
| **合计** | **222** |

另有：TTLock 26 个、人脸同步 4 个、天气 1 个、图书 SaaS 4 个、旧图书/人脸外部系统若干、AI SSE 1 个、MQTT 主题 7 个、手工 OkHttp 调用 4 处。

### 10.2 常见业务码

| `code` | 说明 | 处理 |
| --- | --- | --- |
| 0 | 成功 | 读 `data` |
| 401 | 未登录/Token 失效 | 重新登录 |
| 其他 | 业务错误 | 看 `message` / `detailMessage` |
| `success=false` | 失败 | 部分接口用布尔字段 |
| `error=true` | 有错误 | 部分接口用布尔字段 |

HTTP 层错误（非 200）单独处理：404 检查路径/方法，500 看服务端日志，超时加大 `timeout`。

### 10.3 常用字段速查

| 字段 | 所属 | 说明 |
| --- | --- | --- |
| `accessToken` / `tokenHead` / `refreshToken` | 登录 | Token |
| `brandName` / `id` / `schoolId` / `classesId` | `/brand/obtain` | 学校/班级/设备 |
| `layoutClassSignDetailsEntityList` | 布局 | 首页模块 |
| `tag` / `x` / `y` / `width` / `height` | 布局模块 | 渲染位置 |
| `list` / `total` / `pageNo` / `pageSize` | 分页 | 列表 |
| `records` | 部分分页 | 兼容字段 |
| `icCardNo` / `userId` / `isStudent` | 刷卡 | 身份 |
| `formItems` / `flowElementList` | 请假 | 动态表单/审批流 |
| `medalCode` / `medalName` | 勋章 | 评价 |
| `examinationId` / `studentSeat` | 考试 | 考场 |
| `url` / `name` / `size` | 上传 | 文件 |
