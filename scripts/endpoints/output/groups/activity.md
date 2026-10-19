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
- 请求数：5

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `activity` | 活动与报名 | 5 |

## 活动与报名（`activity`，5 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| activity-001 | POST | `https://api.yyide.com/brand/activity/enroll/activityEnrollInfo` | — | {"activityId":"{activity_id}","userId":"{student_id}","identifyType":0} | — | Bearer {access_token} | application/json | yes | 活动与报名 / requestLoginActiveDetails |
| activity-002 | POST | `https://api.yyide.com/brand/activity/enroll/detail` | — | {"activityId":"{activity_id}"} | — | Bearer {access_token} | application/json | yes | 活动与报名 / requestActiveDetails |
| activity-003 | POST | `https://api.yyide.com/brand/activity/enroll/page` | — | {"pageNo":1,"pageSize":10} | — | Bearer {access_token} | application/json | yes | 活动列表 |
| activity-004 | POST | `https://api.yyide.com/brand/activity/enroll/userActivityEnroll` | — | {"activityId":"{activity_id}","userId":"{student_id}","identifyType":0,"activitySubIds":[]} | — | Bearer {access_token} | application/json | yes | 活动与报名 / requestActiveRegistration |
| activity-005 | POST | `https://api.yyide.com/brand/activity/enroll/userEnrollPage` | — | {"pageNo":1,"pageSize":10,"activityName":"","userId":"{student_id}"} | — | Bearer {access_token} | application/json | yes | 活动与报名 / requestMyRegistrationList |

