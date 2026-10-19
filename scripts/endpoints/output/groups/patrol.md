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
- 请求数：6

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `patrol` | 巡课 | 6 |

## 巡课（`patrol`，6 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| patrol-001 | POST | `https://api.yyide.com/app/patrolDayTaskSite/finishSiteTask` | — | {"id":"{patrol_id}","formJson":"{}","userId":"{teacher_id}"} | — | Bearer {access_token} | application/json | yes | 巡课 / requestSubmitPatrol |
| patrol-002 | GET | `https://api.yyide.com/app/patrolDayTaskSite/get` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 巡课 / requestPatrolDetail |
| patrol-003 | POST | `https://api.yyide.com/app/patrolDayTaskSite/page` | — | {"patrolType":1,"pageNo":1,"siteId":"{site_id}","pageSize":20,"userId":"{teacher_id}","status":0} | — | Bearer {access_token} | application/json | yes | 巡课任务列表 |
| patrol-004 | POST | `https://api.yyide.com/app/patrolDayTaskSite/updateClockIn` | — | {"id":"{patrol_id}","formJson":"{}","userId":"{teacher_id}"} | — | Bearer {access_token} | application/json | yes | 巡课 / requestUpdatePatrolPunch |
| patrol-005 | POST | `https://api.yyide.com/app/patrolDayTaskSite/updateNowClock` | — | {"userId":"{teacher_id}","businessId":"{patrol_id}"} | — | Bearer {access_token} | application/json | yes | 巡课 / requestPatrolPunch |
| patrol-006 | GET | `https://api.yyide.com/app/patrolQrCode/getSiteQrCodeStatus` | {"siteId":"{site_id}"} | — | — | Bearer {access_token} | — | yes | 巡课 / requestScanQrCodeStatus |

