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
- 请求数：10

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `vote` | 投票与问卷 | 10 |

## 投票与问卷（`vote`，10 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| vote-001 | POST | `https://api.yyide.com/app/collectTableBrand/check` | — | {"id":"{form_id}"} | — | Bearer {access_token} | application/json | yes | 投票与问卷 / requestFormDetail |
| vote-002 | POST | `https://api.yyide.com/app/collectTableBrand/lookOver` | — | {"id":"{form_id}"} | — | Bearer {access_token} | application/json | yes | 投票与问卷 / requestCollectSituation |
| vote-003 | POST | `https://api.yyide.com/app/collectTableBrand/overview` | — | {"pageNo":1,"pageSize":99} | — | Bearer {access_token} | application/json | yes | 投票与问卷 / requestCollectList |
| vote-004 | POST | `https://api.yyide.com/app/collectTableBrand/write` | — | {"id":"{form_id}","components":[]} | — | Bearer {access_token} | application/json | yes | 提交问卷/收集表 |
| vote-005 | POST | `https://api.yyide.com/app/collectTableComponent/brand` | — | {} | — | Bearer {access_token} | application/json | yes | 投票与问卷 / requestHomeCollectList |
| vote-006 | GET | `https://api.yyide.com/app/employee/getDeptById` | {"shcoolId":"{school_id}","employeeId":"{teacher_id}"} | — | — | Bearer {access_token} | — | yes | 投票与问卷 / requestTeacherDeptList |
| vote-007 | GET | `https://api.yyide.com/app/student/selectClassByStudentId` | {"studentId":"{student_id}"} | — | — | Bearer {access_token} | — | yes | 投票与问卷 / requestStudentClasses |
| vote-008 | POST | `https://api.yyide.com/cloud/vote/clickVote` | — | {"voteId":"{vote_id}","isBrandStudent":true,"userId":"{student_id}","userName":"{student_name}","voteDetails":[]} | — | Bearer {access_token} | application/json | yes | 投票与问卷 / requestSubmitVote |
| vote-009 | POST | `https://api.yyide.com/cloud/vote/get` | — | {"voteId":"{vote_id}","brandStudentInfo":""} | — | Bearer {access_token} | application/json | yes | 投票与问卷 / requestVoteDetail |
| vote-010 | POST | `https://api.yyide.com/cloud/vote/page` | — | {"pageNo":1,"pageSize":10,"status":0,"showAll":false,"isHave":true} | — | Bearer {access_token} | application/json | yes | 投票列表 |

