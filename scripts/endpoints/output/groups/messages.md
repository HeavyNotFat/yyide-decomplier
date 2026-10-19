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
- 请求数：12

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `messages` | 消息公告与 IM | 12 |

## 消息公告与 IM（`messages`，12 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| messages-001 | POST | `https://api.yyide.com/brand/brand/mess/recive/dominateScreen/list` | — | {"brandId":"{brand_id}"} | — | Bearer {access_token} | application/json | yes | 消息公告与 IM / getMessageDominateScreenList |
| messages-002 | POST | `https://api.yyide.com/brand/brand/mess/recive/dominateScreen/list` | — | {"brandId":"{brand_id}"} | — | Bearer {access_token} | application/json | yes | 消息公告与 IM / requestMessageDominateScreenList |
| messages-003 | GET | `https://api.yyide.com/brand/brand/mess/recive/index` | — | — | — | Bearer {access_token} | — | yes | 消息公告与 IM / requestMessageHome |
| messages-004 | POST | `https://api.yyide.com/brand/brand/mess/recive/page` | — | {"identifier":"announcement","pageNo":1,"pageSize":"18","approverId":"{brand_id}","startTime":"2026-10-01 00:00:00","endTime":"2026-10-19 23:59:59"} | — | Bearer {access_token} | application/json | yes | 公告/消息分页 |
| messages-005 | POST | `https://api.yyide.com/brand/brand/mess/recive/page` | — | {"identifier":"announcement","pageNo":1,"pageSize":"18","approverId":"{brand_id}","startTime":"2026-10-01 00:00:00","endTime":"2026-10-19 23:59:59"} | — | Bearer {access_token} | application/json | yes | 公告/消息分页 |
| messages-006 | POST | `https://api.yyide.com/brand/brand/mess/recive/page` | — | {"identifier":"announcement","pageNo":1,"pageSize":"18","approverId":"{brand_id}","startTime":"2026-10-01 00:00:00","endTime":"2026-10-19 23:59:59"} | — | Bearer {access_token} | application/json | yes | 公告/消息分页 |
| messages-007 | GET | `https://api.yyide.com/cloud/device/mess/publish/getCaptionsNoticeInfo` | {"schoolId":"{school_id}","deviceId":"{deviceId}"} | — | — | Bearer {access_token} | — | yes | 消息公告与 IM / getCaptionsNoticeInfo |
| messages-008 | GET | `https://api.yyide.com/cloud/device/mess/publish/getCaptionsNoticeInfo` | {"schoolId":"{school_id}","deviceId":"{deviceId}"} | — | — | Bearer {access_token} | — | yes | 消息公告与 IM / requestHomeCaption |
| messages-009 | GET | `https://api.yyide.com/cloud/im/user/sig/gen` | {"identifier":"announcement"} | — | — | Bearer {access_token} | — | yes | 消息公告与 IM / getUserSig |
| messages-010 | GET | `https://api.yyide.com/cloud/im/user/sig/gen` | {"identifier":"announcement"} | — | — | Bearer {access_token} | — | yes | 消息公告与 IM / getUserSig |
| messages-011 | GET | `https://api.yyide.com/cloud/im/user/sig/getSystemSig` | — | — | — | Bearer {access_token} | — | yes | 消息公告与 IM / getSystemSign |
| messages-012 | POST | `https://api.yyide.com/management/cloud-system/im/getUserSigByUserId` | — | {} | — | Bearer {access_token} | application/json | yes | 消息公告与 IM / getUserSigByUserId |

