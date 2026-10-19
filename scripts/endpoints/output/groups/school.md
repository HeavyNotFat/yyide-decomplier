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
- 请求数：19

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `school` | 学校、班级与首页布局 | 19 |

## 学校、班级与首页布局（`school`，19 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| school-001 | GET | `https://api.yyide.com/app/area/list` | — | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / requestAreaInfo |
| school-002 | GET | `https://api.yyide.com/brand/brand/campus/style` | — | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / SchoolStyle |
| school-003 | POST | `https://api.yyide.com/brand/brand/campus/teachers` | — | {} | — | Bearer {access_token} | application/json | yes | 学校、班级与首页布局 / Teachers |
| school-004 | GET | `https://api.yyide.com/brand/brand/classes/info` | {"classesId":"{classes_id}"} | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / selectNewClassesInfo |
| school-005 | GET | `https://api.yyide.com/brand/brand/classes/info` | — | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / getClassesInfo |
| school-006 | POST | `https://api.yyide.com/brand/brand/classes/watchword/list` | — | {"classesId":"{classes_id}"} | — | Bearer {access_token} | application/json | yes | 学校、班级与首页布局 / getWatchWord |
| school-007 | POST | `https://api.yyide.com/brand/brand/classes/watchword/list` | — | {"classesId":"{classes_id}"} | — | Bearer {access_token} | application/json | yes | 学校、班级与首页布局 / getWatchWord |
| school-008 | GET | `https://api.yyide.com/brand/brand/countdown/list` | {"classesId":"{classes_id}"} | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / getNewCountdownList |
| school-009 | GET | `https://api.yyide.com/brand/brand/getBrandDominateScreen` | — | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / requestDominateScreenLevel |
| school-010 | POST | `https://api.yyide.com/brand/brand/layoutclasssign/layoutlist` | — | {"id":"{brand_id}","showType":0,"deviceType":"2"} | — | Bearer {access_token} | application/json | yes | 首页模块布局（x/y/tag/width/height） |
| school-011 | GET | `https://api.yyide.com/brand/brand/remind/list` | {"brandId":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / newRemind |
| school-012 | GET | `https://api.yyide.com/brand/brand/school/semester/current` | — | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / getSemesterTime |
| school-013 | POST | `https://api.yyide.com/brand/class-brand-management/android/class/selectClassesInfo` | {"brandClassLoginName":"{username}"} | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / selectClassesInfo |
| school-014 | GET | `https://api.yyide.com/brand/v2/custom/mode/list` | {"brandId":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / requestDominateScreenLevel |
| school-015 | GET | `https://api.yyide.com/brand/v2/custom/mode/list` | {"brandId":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / requestCustomDominateScreenList |
| school-016 | POST | `https://api.yyide.com/cloud/brand/calendar/getSchoolCalendar` | — | {} | — | Bearer {access_token} | application/json | yes | 学校、班级与首页布局 / getSchoolCalendar |
| school-017 | POST | `https://api.yyide.com/cloud/calendar/selectSchoolCalendar` | — | {} | — | Bearer {access_token} | application/json | yes | 学校、班级与首页布局 / selectSchoolCalendar |
| school-018 | GET | `https://api.yyide.com/cloud/site/getSite` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / requestSiteInfo |
| school-019 | GET | `https://api.yyide.com/management/cloud-system/pc/getClassesInfo/{classes_id}` | — | — | — | Bearer {access_token} | — | yes | 学校、班级与首页布局 / getClassesInfo |

