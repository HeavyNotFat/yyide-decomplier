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
| `honor` | 德育评价、荣誉与勋章 | 26 |

## 德育评价、荣誉与勋章（`honor`，26 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| honor-001 | POST | `https://api.yyide.com/brand/appEvalMedal/getUserMedalInfo` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestEvaluationMedalDetails |
| honor-002 | GET | `https://api.yyide.com/brand/appEvalMedal/listEvalMedalType` | — | — | — | Bearer {access_token} | — | yes | 德育评价、荣誉与勋章 / requestEvaluationMedalTypeList |
| honor-003 | POST | `https://api.yyide.com/brand/appEvalMedal/pageEvalUserMedal` | — | {"pageNo":1,"pageSize":20,"personId":"{student_id}","identity":0} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestEvaluationMedalPageList |
| honor-004 | POST | `https://api.yyide.com/brand/evalDataCountStatistic/rankListByClass` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestEvaluationList |
| honor-005 | GET | `https://api.yyide.com/brand/evalPersonScore/getEvalPersonScoreInfo` | {"personId":"{student_id}","identity":"0"} | — | — | Bearer {access_token} | — | yes | 德育评价、荣誉与勋章 / requestEvaluationPointDetails |
| honor-006 | POST | `https://api.yyide.com/brand/evalScoreCard/getUserScoreCardInfo` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestEvaluationPointCardDetails |
| honor-007 | POST | `https://api.yyide.com/brand/evalScoreCard/pageUserScoreCard` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestEvaluationPointCardPageList |
| honor-008 | POST | `https://api.yyide.com/brand/evalScoreRecord/page` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestEvaluationPointPageList |
| honor-009 | POST | `https://api.yyide.com/cloud/app/honor/brandPage` | — | {"pageNo":1,"pageSize":5} | — | Bearer {access_token} | application/json | yes | 荣誉墙 |
| honor-010 | POST | `https://api.yyide.com/cloud/evaluationActivityBrand/detail` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestActiveDetail |
| honor-011 | POST | `https://api.yyide.com/cloud/evaluationActivityBrand/goToScore` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestGoToScore |
| honor-012 | POST | `https://api.yyide.com/cloud/evaluationActivityBrand/identityDetail` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestIdentityDetail |
| honor-013 | POST | `https://api.yyide.com/cloud/evaluationActivityBrand/list` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestActiveHonorList |
| honor-014 | POST | `https://api.yyide.com/cloud/evaluationActivityBrand/queryActivityCycle` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestActivityCycle |
| honor-015 | POST | `https://api.yyide.com/cloud/evaluationActivityBrand/queryLastClassScoreResult` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestClassScoreResult |
| honor-016 | POST | `https://api.yyide.com/cloud/evaluationActivityBrand/result` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestActiveResultList |
| honor-017 | POST | `https://api.yyide.com/cloud/evaluationActivityBrand/scoreClass` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestClassScoreComment |
| honor-018 | POST | `https://api.yyide.com/cloud/evaluationActivityBrand/scoreStudent` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestStudentScoreComment |
| honor-019 | POST | `https://api.yyide.com/cloud/evaluationActivityMobile/childrenHonor` | — | {"childrenId":"{student_id}","pageNo":1,"pageSize":20} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestKidsHonorList |
| honor-020 | POST | `https://api.yyide.com/cloud/evaluationPrize/classHonor` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestClassHonorList |
| honor-021 | POST | `https://api.yyide.com/cloud/evaluationPrize/studentHonor` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestStudentHonorList |
| honor-022 | POST | `https://api.yyide.com/cloud/moralEducationActivityBrand/gotoScore` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / gotoScore |
| honor-023 | POST | `https://api.yyide.com/cloud/moralEducationActivityBrand/overviewDetail` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestDailyScoreDetails |
| honor-024 | POST | `https://api.yyide.com/cloud/moralEducationActivityBrand/race` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestClassMe |
| honor-025 | POST | `https://api.yyide.com/cloud/moralEducationActivityBrand/scoringRubric` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / requestScoringRubric |
| honor-026 | POST | `https://api.yyide.com/cloud/moralEducationActivityBrand/securityCheck` | — | {} | — | Bearer {access_token} | application/json | yes | 德育评价、荣誉与勋章 / securityCheck |

