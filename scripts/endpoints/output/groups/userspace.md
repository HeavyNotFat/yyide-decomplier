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
- 请求数：26

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `userspace` | 学生空间、请假与报修 | 26 |

## 学生空间、请假与报修（`userspace`，26 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| userspace-001 | POST | `https://api.yyide.com/app/actLeaveVacation/calculateLeaveDays` | — | {"startTime":"2026-10-20 08:00:00","endTime":"2026-10-20 12:00:00","durationType":"1","durationWay":"1","userId":"{student_id}"} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / requestLeaveLength |
| userspace-002 | GET | `https://api.yyide.com/app/formProcessTemplates/getDefaultStudentLeave` | — | — | — | Bearer {access_token} | — | yes | 学生空间、请假与报修 / requestStudentLeaveForm |
| userspace-003 | POST | `https://api.yyide.com/app/userAppr/pageDeviceAppr` | — | {"pageNo":1,"pageSize":20,"schoolId":"{school_id}","siteId":"{site_id}","queryNewStatus":true} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / requestRepairList |
| userspace-004 | GET | `https://api.yyide.com/app/userAppr/v2/getInfo` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 学生空间、请假与报修 / requestLeaveDetail |
| userspace-005 | POST | `https://api.yyide.com/app/v2/proc/deleteInstance` | — | {"processInstanceId":"{process_instance_id}","schoolId":"{school_id}","assigneeId":"{student_id}","sponsorType":0,"assigneeName":"{student_name}"} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / requestRevokeLeave |
| userspace-006 | POST | `https://api.yyide.com/app/v2/proc/getFlowElements` | — | {"fromKey":"studentLeave_{school_id}","studentId":"{student_id}","fromComponent":"{}"} | — | Bearer {access_token} | application/json | yes | 请假/报修审批流节点 |
| userspace-007 | POST | `https://api.yyide.com/app/v2/proc/pageTask` | — | {"pageNo":1,"pageSize":20,"type":3,"assignee":"{student_id}","fromKey":"studentLeave_{school_id}","queryNewStatus":true} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / requestLeaveRecord |
| userspace-008 | POST | `https://api.yyide.com/app/v2/proc/startInstance` | — | {"fromKey":"studentLeave_{school_id}","formItems":"[]","assigneeId":"{student_id}","assigneeName":"{student_name}","flowElementList":[]} | — | Bearer {access_token} | application/json | yes | 提交请假/报修 |
| userspace-009 | POST | `https://api.yyide.com/app/v2/proc/updateApprovalProc` | — | {} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / requestFormModify |
| userspace-010 | GET | `https://api.yyide.com/cloud/actLeaveVacation/list` | {"type":"1"} | — | — | Bearer {access_token} | — | yes | 学生空间、请假与报修 / requestLeaveTypeOption |
| userspace-011 | GET | `https://api.yyide.com/cloud/address/book/student` | {"studentId":"{student_id}"} | — | — | Bearer {access_token} | — | yes | 学生空间、请假与报修 / getAddressBook |
| userspace-012 | POST | `https://api.yyide.com/cloud/app/procAppr/deleteInstance` | — | {} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / deleteInstance |
| userspace-013 | POST | `https://api.yyide.com/cloud/app/procAppr/deleteInstance` | — | {} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / requestOldRevokeLeave |
| userspace-014 | POST | `https://api.yyide.com/cloud/app/procAppr/getApprList` | — | {"startDate":"","endDate":"","classesId":"{classes_id}","identity":"0","id":"{student_id}"} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / getApprover |
| userspace-015 | GET | `https://api.yyide.com/cloud/app/userAppr/getInfo` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 学生空间、请假与报修 / getApproverInfo |
| userspace-016 | GET | `https://api.yyide.com/cloud/app/userAppr/getInfo` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 学生空间、请假与报修 / requestOldLeaveDetail |
| userspace-017 | POST | `https://api.yyide.com/cloud/app/userAppr/page` | — | {"pageNo":"1","pageSize":"20","userId":"{student_id}"} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / askForLeaveRecordBandList |
| userspace-018 | GET | `https://api.yyide.com/cloud/formProcessTemplates/getByKey` | {"formKey":"teacherDeviceRepair"} | — | — | Bearer {access_token} | — | yes | 学生空间、请假与报修 / requestRepairForm |
| userspace-019 | POST | `https://api.yyide.com/cloud/leaveWord/brand/create` | — | {"classesId":"{classes_id}","content":"测试意见","userId":"{student_id}","type":"1","anonymity":false} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / requestAddComments |
| userspace-020 | GET | `https://api.yyide.com/cloud/leaveWord/delete` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 学生空间、请假与报修 / requestCommentsDelete |
| userspace-021 | GET | `https://api.yyide.com/cloud/leaveWord/get` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 学生空间、请假与报修 / requestCommentsDetail |
| userspace-022 | GET | `https://api.yyide.com/cloud/leaveWord/getLeaveWordSetting` | {"type":"1"} | — | — | Bearer {access_token} | — | yes | 学生空间、请假与报修 / getLeaveWordSetting |
| userspace-023 | POST | `https://api.yyide.com/cloud/leaveWord/page` | — | {} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / requestCommentsList |
| userspace-024 | POST | `https://api.yyide.com/cloud/proc/startInstance` | — | {"jsonData":"{}","procId":"proc-1","dept":"dept-1","isBack":false,"deptName":"一年级1班","apprs":[],"ccIds":"","sponsorType":"0","identityUserId":"{student_id}"} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / addLeave |
| userspace-025 | POST | `https://api.yyide.com/cloud/student/allStudents` | — | {"pageNo":1,"pageSize":100,"id":"{classes_id}","type":4,"key":"classes"} | — | Bearer {access_token} | application/json | yes | 班级学生列表 |
| userspace-026 | POST | `https://api.yyide.com/leave-server/cloud-leave/student/addStudentLeaveByStudentUserId` | — | {} | — | Bearer {access_token} | application/json | yes | 学生空间、请假与报修 / LeaveCommit |

