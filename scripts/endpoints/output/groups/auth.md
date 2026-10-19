# 智慧班牌完整请求表（真实环境）

> 由 `scripts/endpoints/build_request_table.py` 生成。
> 所有 host 均为真实生产/厂商地址；`{...}` 是需要在运行时提供的真实上下文（MAC、班级 ID、锁 ID 等）。
> 凭据由 `credentials.py` 从环境变量/本地凭据读取，本表不打印任何密钥。

**统一 User-Agent：**

```text
Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/154.0.0.0 Safari/537.36 Edg/154.0.0.0
```

**鉴权头：** `Authorization: Bearer {access_token}`（TTLock 用 form 中的 `accessToken`，不走 Bearer）。
> `{access_token}` 是运行时变量：用 `build_request_table --resolve`、`runner --resolve-token`、`runner --forge` 或 `BrandClient` 注入真实 token。

- 分组数：1
- 请求数：9

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `auth` | 鉴权与登录 | 9 |

## 鉴权与登录（`auth`，9 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| auth-001 | POST | `https://api.yyide.com/auth/oauth/token` | {"username":"{username}","password":"{password}","client_id":"{client_id}","grant_type":"brand","client_secret":"{client_secret}","random":"{random}"} | — | — | — | — | yes | OAuth 密码模式登录，获取 accessToken |
| auth-002 | GET | `https://api.yyide.com/auth/qrcode/check` | {"random":"{random}"} | — | — | — | — | yes | 鉴权与登录 / getCheckLoginQrCode |
| auth-003 | GET | `https://api.yyide.com/auth/qrcode/check` | {"random":"{random}"} | — | — | — | — | yes | 鉴权与登录 / requestQrCodeCheck |
| auth-004 | GET | `https://api.yyide.com/auth/qrcode/gene` | {"type":"1"} | — | — | — | — | yes | 鉴权与登录 / getLoginQrCode |
| auth-005 | GET | `https://api.yyide.com/auth/qrcode/gene` | {"type":"1","schoolId":"{school_id}"} | — | — | — | — | yes | 鉴权与登录 / requestQrCode |
| auth-006 | POST | `https://api.yyide.com/brand/brand/mess/recive/index` | {"username":"{username}","password":"{password}","client_id":"{client_id}","grant_type":"brand","client_secret":"{client_secret}"} | — | — | Bearer {access_token} | — | yes | 鉴权与登录 / login |
| auth-007 | POST | `https://api.yyide.com/brand/class-brand-management/app/loginCheck/getSiteByUserName` | {"equipmentSerialNumber":"{android_id}"} | — | — | — | — | yes | 鉴权与登录 / getSiteByUserName |
| auth-008 | POST | `https://api.yyide.com/brand/obtain` | — | {"loginName":"{username}","no":"{mac}","wlanMac":"","seriaNo":"{android_id}","direction":"0"} | — | — | application/json | yes | 班牌登录：换取学校/班级/场地/品牌信息 |
| auth-009 | POST | `https://api.yyide.com/brand/obtain` | — | {"loginName":"{username}","no":"{mac}","wlanMac":"","seriaNo":"{android_id}","direction":"0"} | — | — | application/json | yes | 班牌登录：换取学校/班级/场地/品牌信息 |

