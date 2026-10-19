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
- 请求数：15

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `home` | 首页卡片与班级展示 | 15 |

## 首页卡片与班级展示（`home`，15 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| home-001 | GET | `https://zhwnlapi.etouch.cn/Ecalender/weather_mini` | {"city":"{city}"} | — | — | — | — | yes | 首页卡片与班级展示 / getWeather |
| home-002 | POST | `https://api.yyide.com/brand/brand/album/index` | — | {} | — | Bearer {access_token} | application/json | yes | 首页卡片与班级展示 / getHomeVideo |
| home-003 | POST | `https://api.yyide.com/brand/brand/album/list` | — | {} | — | Bearer {access_token} | application/json | yes | 首页卡片与班级展示 / getNewClassPhotoList |
| home-004 | POST | `https://api.yyide.com/brand/brand/album/listDetail` | — | {} | — | Bearer {access_token} | application/json | yes | 首页卡片与班级展示 / getNewPhotoList |
| home-005 | GET | `https://api.yyide.com/brand/brand/studentduty/selectRecord` | — | — | — | Bearer {access_token} | — | yes | 首页卡片与班级展示 / getNewStudentDuty |
| home-006 | POST | `https://api.yyide.com/brand/brand/studentwork/list` | — | {"classesId":"{classes_id}","pageNo":"1","pageSize":"10"} | — | Bearer {access_token} | application/json | yes | 首页卡片与班级展示 / getNewStudentWorkList |
| home-007 | GET | `https://api.yyide.com/brand/brand/studentwork/selectStudentInfo` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 首页卡片与班级展示 / selectNewStudentInfo |
| home-008 | POST | `https://api.yyide.com/brand/brand/studentwork/workComment` | — | {} | — | Bearer {access_token} | application/json | yes | 首页卡片与班级展示 / setNewWorkComment |
| home-009 | GET | `https://api.yyide.com/brand/brand/studentwork/workLike` | {"id":"{brand_id}","userId":"{student_id}"} | — | — | Bearer {access_token} | — | yes | 首页卡片与班级展示 / setNewWorkLike |
| home-010 | POST | `https://api.yyide.com/brand/brand/v3/studentduty/selectRecord` | — | {} | — | Bearer {access_token} | application/json | yes | 首页卡片与班级展示 / getDutyWeekList |
| home-011 | POST | `https://api.yyide.com/brand/class-brand-management/android/videoalbum/classifylist` | — | {} | — | Bearer {access_token} | application/json | yes | 首页卡片与班级展示 / getPhotoAlbumTablist |
| home-012 | GET | `https://api.yyide.com/brand/class-brand-management/app/studentDuty/selectRecord` | {"classId":"{classes_id}"} | — | — | Bearer {access_token} | — | yes | 首页卡片与班级展示 / getStudentDuty |
| home-013 | POST | `https://api.yyide.com/brand/weather/day7` | — | {} | — | Bearer {access_token} | application/json | yes | 首页卡片与班级展示 / getNewWeatherList |
| home-014 | POST | `https://api.yyide.com/brand/weather/now` | — | {} | — | Bearer {access_token} | application/json | yes | 首页卡片与班级展示 / getNewWeather |
| home-015 | POST | `https://api.yyide.com/cloud/app/work/pageThisWeekWork` | — | {"pageNo":1,"pageSize":20,"classesId":"{classes_id}"} | — | Bearer {access_token} | application/json | yes | 首页卡片与班级展示 / getNewTaskList |

