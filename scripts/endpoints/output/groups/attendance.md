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
- 请求数：18

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `attendance` | 考勤与打卡 | 18 |

## 考勤与打卡（`attendance`，18 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| attendance-001 | POST | `https://api.yyide.com/attweb/app/attendance/createBrandAttendanceSignIn` | — | [{"attendanceIds":"{attendance_id}","deviceName":"班牌","deviceNo":"{mac}","signInImg":"","signInTime":"2026-10-19 08:01:00","siteId":"{site_id}","siteName":"{site_name}","siteTimetableId":"","studentId":"{student_id}","timetableId":"{timetable_id}","type":"1"}] | — | Bearer {access_token} | application/json | yes | 考勤与打卡 / brandAttendanceClock |
| attendance-002 | GET | `https://api.yyide.com/attweb/app/attendance/getAttendanceEventTimetableByClasses` | {"classesId":"{classes_id}"} | — | — | Bearer {access_token} | — | yes | 考勤与打卡 / getAttenceKB |
| attendance-003 | POST | `https://api.yyide.com/attweb/app/attendance/getAttendanceSiteTimetable` | — | {"timetableIds":["{timetable_id}"]} | — | Bearer {access_token} | application/json | yes | 考勤与打卡 / getAttendanceSiteTimetable |
| attendance-004 | GET | `https://api.yyide.com/attweb/app/attendance/getBrandAttendanceRule` | {"no":"{mac}"} | — | — | Bearer {access_token} | — | yes | 考勤与打卡 / Attendlist |
| attendance-005 | GET | `https://api.yyide.com/attweb/app/attendance/getBrandAttendanceUser` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 考勤与打卡 / getBrandAttendanceUser |
| attendance-006 | POST | `https://api.yyide.com/attweb/app/attendance/listToDay` | — | {"attendanceTimeIds":[]} | — | Bearer {access_token} | application/json | yes | 今日考勤 |
| attendance-007 | POST | `https://api.yyide.com/attweb/app/attendance/listToDay` | — | {"attendanceTimeIds":[]} | — | Bearer {access_token} | application/json | yes | 今日考勤 |
| attendance-008 | POST | `https://api.yyide.com/attweb/app/attendance/listToDayDetail` | — | {"attendanceTimeId":"{attendance_time_id}","attendanceId":"{attendance_id}","type":"1"} | — | Bearer {access_token} | application/json | yes | 考勤明细 |
| attendance-009 | POST | `https://api.yyide.com/attweb/attendanceSignTask/app/add` | — | {} | — | Bearer {access_token} | application/json | yes | 考勤与打卡 / requestAddTask |
| attendance-010 | POST | `https://api.yyide.com/attweb/attendanceSignTask/app/delete` | — | {} | — | Bearer {access_token} | application/json | yes | 考勤与打卡 / requestDeleteTask |
| attendance-011 | POST | `https://api.yyide.com/attweb/attendanceSignTask/app/update` | — | {} | — | Bearer {access_token} | application/json | yes | 考勤与打卡 / requestUpdateTask |
| attendance-012 | POST | `https://api.yyide.com/attweb/attendanceSignTask/brand/brandBillBoard` | — | {} | — | Bearer {access_token} | application/json | yes | 考勤与打卡 / requestTaskList |
| attendance-013 | POST | `https://api.yyide.com/attweb/attendanceSignTask/brand/get` | — | {} | — | Bearer {access_token} | application/json | yes | 考勤与打卡 / requestTaskDetail |
| attendance-014 | POST | `https://api.yyide.com/attweb/attendanceSignTask/brand/list` | — | {"status":"not_start","pageNo":1,"pageSize":20,"studentId":"{student_id}","schoolId":"{school_id}"} | — | Bearer {access_token} | application/json | yes | 打卡任务列表 |
| attendance-015 | POST | `https://api.yyide.com/attweb/attendanceSignTask/brand/sign` | — | {} | — | Bearer {access_token} | application/json | yes | 考勤与打卡 / requestSignTask |
| attendance-016 | POST | `https://api.yyide.com/face/cloud-face/attendance/brand/app/v2/queryBrandAttendanceByClassIds` | — | {} | — | Bearer {access_token} | application/json | yes | 考勤与打卡 / queryBrandAttendanceByClassIds |
| attendance-017 | POST | `https://api.yyide.com/face/cloud-face/attendance/peopleAttendance` | — | {} | — | Bearer {access_token} | application/json | yes | 考勤与打卡 / attendance |
| attendance-018 | POST | `https://api.yyide.com/face/cloud-face/attendance/viewCbAttendance` | — | {} | — | Bearer {access_token} | application/json | yes | 考勤与打卡 / getAttencelist |

