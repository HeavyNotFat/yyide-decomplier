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
| `exam` | 考试 | 6 |

## 考试（`exam`，6 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| exam-001 | POST | `https://api.yyide.com/brand/exam/by/student` | — | {"studentId":"{student_id}"} | — | Bearer {access_token} | application/json | yes | 学生考试列表 |
| exam-002 | POST | `https://api.yyide.com/brand/exam/detail` | — | {"siteId":"{site_id}","subjectId":"{subject_id}","examinationId":"{examination_id}"} | — | Bearer {access_token} | application/json | yes | 考试 / requestExamDetail |
| exam-003 | POST | `https://api.yyide.com/brand/exam/person` | — | {"siteId":"{site_id}","subjectId":"{subject_id}","examinationId":"{examination_id}"} | — | Bearer {access_token} | application/json | yes | 考试 / requestExamPersonSeat |
| exam-004 | POST | `https://api.yyide.com/brand/exam/plan/week` | — | {} | — | Bearer {access_token} | application/json | yes | 考试 / requestWeekExam |
| exam-005 | POST | `https://api.yyide.com/brand/exam/recent` | — | {"examStartTime":"2026-10-19 00:00:00","examEndTime":"2026-10-19 23:59:59","limit":10} | — | Bearer {access_token} | application/json | yes | 考试 / requestTodayExam |
| exam-006 | POST | `https://api.yyide.com/brand/exam/student/sing/in` | — | {"studentId":"{student_id}","siteId":"{site_id}","subjectId":"{subject_id}","examinationId":"{examination_id}"} | — | Bearer {access_token} | application/json | yes | 考试 / requestSignExam |

