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
| `reservation` | 场地预约与咨询 | 6 |

## 场地预约与咨询（`reservation`，6 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| reservation-001 | GET | `https://api.yyide.com/cloud/employee/get` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 场地预约与咨询 / requestEmployeeDetails |
| reservation-002 | POST | `https://api.yyide.com/cloud/employee/getEmployeeListByLabel` | — | {"pageNo":1,"pageSize":20} | — | Bearer {access_token} | application/json | yes | 场地预约与咨询 / requestConsultList |
| reservation-003 | POST | `https://api.yyide.com/cloud/siteBooking/bookingRecordPage` | — | {"pageNo":1,"pageSize":20,"userId":"{student_id}","status":0} | — | Bearer {access_token} | application/json | yes | 预约记录 |
| reservation-004 | GET | `https://api.yyide.com/cloud/siteBooking/get` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 场地预约与咨询 / requestReservationRecordDetail |
| reservation-005 | POST | `https://api.yyide.com/cloud/siteBooking/siteBookingBatchSign` | — | {"siteBookingIds":["{site_booking_id}"],"userId":"{student_id}"} | — | Bearer {access_token} | application/json | yes | 场地预约与咨询 / requestReservationOfflineSign |
| reservation-006 | POST | `https://api.yyide.com/cloud/siteBooking/siteBookingSign` | — | {"siteBookingId":"{site_booking_id}","userId":"{student_id}"} | — | Bearer {access_token} | application/json | yes | 场地预约与咨询 / requestReservationSign |

