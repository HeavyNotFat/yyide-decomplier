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

- 分组数：23
- 请求数：257

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `auth` | 鉴权与登录 | 9 |
| `device` | 设备激活、绑定与升级 | 18 |
| `school` | 学校、班级与首页布局 | 19 |
| `home` | 首页卡片与班级展示 | 15 |
| `messages` | 消息公告与 IM | 12 |
| `timetable` | 课表 | 6 |
| `attendance` | 考勤与打卡 | 18 |
| `card` | 刷卡、人脸与身份识别 | 11 |
| `userspace` | 学生空间、请假与报修 | 26 |
| `activity` | 活动与报名 | 5 |
| `honor` | 德育评价、荣誉与勋章 | 26 |
| `exam` | 考试 | 6 |
| `library` | 图书与阅读 | 11 |
| `reservation` | 场地预约与咨询 | 6 |
| `patrol` | 巡课 | 6 |
| `vote` | 投票与问卷 | 10 |
| `dormitory` | 宿舍 | 2 |
| `ai` | AI 助手 | 4 |
| `upload` | 文件上传与日志 | 3 |
| `iot` | 设备物联与扩展 | 9 |
| `ttlock` | TTLock 通通锁 | 26 |
| `face` | 人脸同步（FacePass） | 4 |
| `external` | 外部/手工接口 | 5 |

## 鉴权与登录（`auth`，9 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| auth-001 | POST | `https://api.yyide.com/auth/oauth/token` | {"username":"{username}","password":"{password}","client_id":"{client_id}","grant_type":"brand","client_secret":"{client_secret}","random":"{random}"} | — | — | — | — | yes | OAuth 密码模式登录，获取 accessToken |
| auth-002 | GET | `https://api.yyide.com/auth/qrcode/check` | {"random":"{random}"} | — | — | — | — | yes | 鉴权与登录 / getCheckLoginQrCode |
| auth-003 | GET | `https://api.yyide.com/auth/qrcode/check` | {"random":"{random}"} | — | — | — | — | yes | 鉴权与登录 / requestQrCodeCheck |
| auth-004 | GET | `https://api.yyide.com/auth/qrcode/gene` | {"type":"1"} | — | — | — | — | yes | 鉴权与登录 / getLoginQrCode |
| auth-005 | GET | `https://api.yyide.com/auth/qrcode/gene` | {"type":"1","schoolId":"{school_id}"} | — | — | — | — | yes | 鉴权与登录 / requestQrCode |
| auth-006 | POST | `https://api.yyide.com/brand/brand/mess/recive/index` | {"username":"{username}","password":"{password}","client_id":"{client_id}","grant_type":"brand","client_secret":"{client_secret}"} | — | — | Bearer {access_token} | — | yes | 鉴权与登录 / login |
| auth-007 | POST | `https://api.yyide.com/brand/class-brand-management/app/loginCheck/getSiteByUserName` | {"equipmentSerialNumber":"{android_id}"} | — | — | — | — | yes | 鉴权与登录 / getSiteByUserName |
| auth-008 | POST | `https://api.yyide.com/brand/obtain` | — | {"loginName":"{username}","no":"{mac}","wlanMac":"","seriaNo":"{android_id}","direction":"0"} | — | — | application/json | yes | 班牌登录：换取学校/班级/场地/品牌信息 |
| auth-009 | POST | `https://api.yyide.com/brand/obtain` | — | {"loginName":"{username}","no":"{mac}","wlanMac":"","seriaNo":"{android_id}","direction":"0"} | — | — | application/json | yes | 班牌登录：换取学校/班级/场地/品牌信息 |

## 设备激活、绑定与升级（`device`，18 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| device-001 | POST | `https://api.yyide.com/backstage/cloud-backstage/kf/application/getNewestVersion` | — | {} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / getNewestVersion |
| device-002 | POST | `https://api.yyide.com/backstage/cloud-backstage/kf/application/queryClassificList` | — | {} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / queryClassificList |
| device-003 | POST | `https://api.yyide.com/brand/after/school/log/afterSchool` | — | {} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / oneKeySchool |
| device-004 | POST | `https://api.yyide.com/brand/after/school/log/board` | — | {} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / classesOverInfo |
| device-005 | GET | `https://api.yyide.com/brand/brand/getSwitchsType` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 设备激活、绑定与升级 / switchNewList |
| device-006 | POST | `https://api.yyide.com/brand/brand/updateApkVersion` | — | {"id":"{brand_id}","apkVersion":"3.0.14"} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / updateApkVersion |
| device-007 | POST | `https://api.yyide.com/brand/class-brand-management/android/appRegistraCode/insetVersionUpdatedSchool` | — | {} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / insetVersionUpdatedSchool |
| device-008 | POST | `https://api.yyide.com/cloud/v2/barrier/getAppVersion` | — | {"schoolId":"{school_id}","versionType":2,"deviceType":"2"} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / getNewestVersion |
| device-009 | POST | `https://api.yyide.com/cloud/v2/barrier/getOrBindingDevice` | — | {"no":"{mac}","deviceType":"2","type":"3","schoolId":"{school_id}"} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / getOrBindingDevice |
| device-010 | POST | `https://api.yyide.com/cloud/v2/barrier/getOrBindingDevice` | — | {"no":"{mac}","deviceType":"2","type":"3","schoolId":"{school_id}"} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / getActivationCode |
| device-011 | POST | `https://api.yyide.com/cloud/v2/barrier/getOrBindingDevice` | — | {"no":"{mac}","deviceType":"2","type":"3","schoolId":"{school_id}"} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / getActivationCode |
| device-012 | POST | `https://api.yyide.com/cloud/v2/barrier/getRegistrationCode` | — | {"no":"{mac}","deviceType":"2","schoolId":"{school_id}"} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / getRegistrationCode |
| device-013 | POST | `https://api.yyide.com/cloud/v2/barrier/getRegistrationCode` | — | {"no":"{mac}","deviceType":"2","schoolId":"{school_id}"} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / getRegistrationCode |
| device-014 | POST | `https://api.yyide.com/cloud/v2/barrier/updateRegistrationCode` | — | {"no":"{mac}","registrationCode":"","deviceType":"2","schoolId":"{school_id}"} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / updateNewRegistrationCodeByCode |
| device-015 | POST | `https://api.yyide.com/cloud/v2/barrier/updateRegistrationCode` | — | {"no":"{mac}","registrationCode":"","deviceType":"2","schoolId":"{school_id}"} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / updateNewRegistrationCodeByCode |
| device-016 | POST | `https://api.yyide.com/cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo` | — | {"deviceNo":"{mac}","deviceType":"2"} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / getBrandRegistrationCode |
| device-017 | POST | `https://api.yyide.com/cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo` | — | {"deviceNo":"{mac}","deviceType":"2"} | — | Bearer {access_token} | application/json | yes | 设备激活、绑定与升级 / getBrandRegistrationCode |
| device-018 | GET | `https://api.yyide.com/manage/machineInfo/getMachineConfigByDeviceNo` | {"deviceNo":"{mac}"} | — | — | Bearer {access_token} | — | yes | 设备激活、绑定与升级 / requestDeviceConfig |

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

## 消息公告与 IM（`messages`，12 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| messages-001 | POST | `https://api.yyide.com/brand/brand/mess/recive/dominateScreen/list` | — | {"brandId":"{brand_id}"} | — | Bearer {access_token} | application/json | yes | 消息公告与 IM / getMessageDominateScreenList |
| messages-002 | POST | `https://api.yyide.com/brand/brand/mess/recive/dominateScreen/list` | — | {"brandId":"{brand_id}"} | — | Bearer {access_token} | application/json | yes | 消息公告与 IM / requestMessageDominateScreenList |
| messages-003 | GET | `https://api.yyide.com/brand/brand/mess/recive/index` | — | — | — | Bearer {access_token} | — | yes | 消息公告与 IM / requestMessageHome |
| messages-004 | POST | `https://api.yyide.com/brand/brand/mess/recive/page` | — | {"identifier":"announcement","pageNo":1,"pageSize":"18","approverId":"{brand_id}","startTime":"2026-10-01 00:00:00","endTime":"2026-10-19 23:59:59"} | — | Bearer {access_token} | application/json | yes | 公告/消息分页 |
| messages-005 | POST | `https://api.yyide.com/brand/brand/mess/recive/page` | — | {"identifier":"announcement","pageNo":1,"pageSize":"18","approverId":"{brand_id}","startTime":"2026-10-01 00:00:00","endTime":"2026-10-19 23:59:59"} | — | Bearer {access_token} | application/json | yes | 公告/消息分页 |
| messages-006 | POST | `https://api.yyide.com/brand/brand/mess/recive/page` | — | {"identifier":"announcement","pageNo":1,"pageSize":"18","approverId":"{brand_id}","startTime":"2026-10-01 00:00:00","endTime":"2026-10-19 23:59:59"} | — | Bearer {access_token} | application/json | yes | 公告/消息分页 |
| messages-007 | GET | `https://api.yyide.com/cloud/device/mess/publish/getCaptionsNoticeInfo` | {"schoolId":"{school_id}","deviceId":"{deviceId}"} | — | — | Bearer {access_token} | — | yes | 消息公告与 IM / getCaptionsNoticeInfo |
| messages-008 | GET | `https://api.yyide.com/cloud/device/mess/publish/getCaptionsNoticeInfo` | {"schoolId":"{school_id}","deviceId":"{deviceId}"} | — | — | Bearer {access_token} | — | yes | 消息公告与 IM / requestHomeCaption |
| messages-009 | GET | `https://api.yyide.com/cloud/im/user/sig/gen` | {"identifier":"announcement"} | — | — | Bearer {access_token} | — | yes | 消息公告与 IM / getUserSig |
| messages-010 | GET | `https://api.yyide.com/cloud/im/user/sig/gen` | {"identifier":"announcement"} | — | — | Bearer {access_token} | — | yes | 消息公告与 IM / getUserSig |
| messages-011 | GET | `https://api.yyide.com/cloud/im/user/sig/getSystemSig` | — | — | — | Bearer {access_token} | — | yes | 消息公告与 IM / getSystemSign |
| messages-012 | POST | `https://api.yyide.com/management/cloud-system/im/getUserSigByUserId` | — | {} | — | Bearer {access_token} | application/json | yes | 消息公告与 IM / getUserSigByUserId |

## 课表（`timetable`，6 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| timetable-001 | POST | `https://api.yyide.com/brand/class-brand-management/android/course/classSchedule` | — | {} | — | Bearer {access_token} | application/json | yes | 课表 / UserTable |
| timetable-002 | POST | `https://api.yyide.com/brand/class-brand-management/android/course/classSchedule` | — | {} | — | Bearer {access_token} | application/json | yes | 课表 / getClassSchedule |
| timetable-003 | POST | `https://api.yyide.com/cloud/app/timetable/getWeekTime` | — | {"weekTime":"","typeId":"{classes_id}","type":"1"} | — | Bearer {access_token} | application/json | yes | 班级/教师/学生课表 |
| timetable-004 | POST | `https://api.yyide.com/cloud/app/timetable/getWeekTime` | — | {"weekTime":"","typeId":"{classes_id}","type":"1"} | — | Bearer {access_token} | application/json | yes | 班级/教师/学生课表 |
| timetable-005 | POST | `https://api.yyide.com/cloud/app/timetable/getWeekTime` | — | {"weekTime":"","typeId":"{classes_id}","type":"1"} | — | Bearer {access_token} | application/json | yes | 班级/教师/学生课表 |
| timetable-006 | POST | `https://api.yyide.com/timetable/cloud-timetable/v1/kcb/classes` | {"bjid":"{classes_id}","skzc":"1"} | — | — | Bearer {access_token} | — | yes | 课表 / getKB |

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

## 刷卡、人脸与身份识别（`card`，11 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| card-001 | POST | `https://api.yyide.com/brand/brand/Authority/checkIotControlByPassword` | — | {"password":"{door_password}","userId":"{teacher_id}"} | — | Bearer {access_token} | application/json | yes | 刷卡、人脸与身份识别 / verifyTeacherLogin |
| card-002 | POST | `https://api.yyide.com/brand/brand/Authority/selectStudentByIcCard` | — | {"userId":"{student_id}","type":"1"} | — | Bearer {access_token} | application/json | yes | 刷卡：学生信息 |
| card-003 | POST | `https://api.yyide.com/brand/brand/Authority/selectStudentByIcCard` | — | {"userId":"{student_id}","type":"1"} | — | Bearer {access_token} | application/json | yes | 刷卡：学生信息 |
| card-004 | POST | `https://api.yyide.com/brand/brand/Authority/selectTeacherByClassesId` | — | {"teacherId":"{teacher_id}","icCardNo":"{ic_card_no}"} | — | Bearer {access_token} | application/json | yes | 刷卡、人脸与身份识别 / selectNewTeacherByClassesId |
| card-005 | POST | `https://api.yyide.com/brand/brand/Authority/selectTeacherByIcCard` | — | {"userId":"{teacher_id}","type":"1"} | — | Bearer {access_token} | application/json | yes | 刷卡：教师信息 |
| card-006 | POST | `https://api.yyide.com/brand/brand/Authority/selectTeacherByIcCard` | — | {"userId":"{teacher_id}","type":"1"} | — | Bearer {access_token} | application/json | yes | 刷卡：教师信息 |
| card-007 | POST | `https://api.yyide.com/brand/brand/Authority/selectUserInfoByIcCard` | — | {"icCardNo":"{ic_card_no}"} | — | Bearer {access_token} | application/json | yes | 刷卡：卡号换用户（判断学生/教师） |
| card-008 | POST | `https://api.yyide.com/brand/brand/Authority/selectUserInfoByIcCard` | — | {"icCardNo":"{ic_card_no}"} | — | Bearer {access_token} | application/json | yes | 刷卡：卡号换用户（判断学生/教师） |
| card-009 | POST | `https://api.yyide.com/brand/class-brand-management/Android/Authority/selectTeacherByIcCard` | — | {"icCardNo":"{ic_card_no}"} | — | Bearer {access_token} | application/json | yes | 刷卡、人脸与身份识别 / selectTeacherByIcCard |
| card-010 | POST | `https://api.yyide.com/brand/class-brand-management/android/studentspace/selectStudentByIcCard` | — | {"icCardNo":"{ic_card_no}"} | — | Bearer {access_token} | application/json | yes | 刷卡、人脸与身份识别 / selectStudentByIcCard |
| card-011 | POST | `https://api.yyide.com/brand/upload/signInLog` | — | {"deviceNo":"{mac}","studentId":"{student_id}","type":"1"} | — | Bearer {access_token} | application/json | yes | 刷卡、人脸与身份识别 / pauschCard |

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

## 活动与报名（`activity`，5 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| activity-001 | POST | `https://api.yyide.com/brand/activity/enroll/activityEnrollInfo` | — | {"activityId":"{activity_id}","userId":"{student_id}","identifyType":0} | — | Bearer {access_token} | application/json | yes | 活动与报名 / requestLoginActiveDetails |
| activity-002 | POST | `https://api.yyide.com/brand/activity/enroll/detail` | — | {"activityId":"{activity_id}"} | — | Bearer {access_token} | application/json | yes | 活动与报名 / requestActiveDetails |
| activity-003 | POST | `https://api.yyide.com/brand/activity/enroll/page` | — | {"pageNo":1,"pageSize":10} | — | Bearer {access_token} | application/json | yes | 活动列表 |
| activity-004 | POST | `https://api.yyide.com/brand/activity/enroll/userActivityEnroll` | — | {"activityId":"{activity_id}","userId":"{student_id}","identifyType":0,"activitySubIds":[]} | — | Bearer {access_token} | application/json | yes | 活动与报名 / requestActiveRegistration |
| activity-005 | POST | `https://api.yyide.com/brand/activity/enroll/userEnrollPage` | — | {"pageNo":1,"pageSize":10,"activityName":"","userId":"{student_id}"} | — | Bearer {access_token} | application/json | yes | 活动与报名 / requestMyRegistrationList |

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

## 考试（`exam`，6 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| exam-001 | POST | `https://api.yyide.com/brand/exam/by/student` | — | {"studentId":"{student_id}"} | — | Bearer {access_token} | application/json | yes | 学生考试列表 |
| exam-002 | POST | `https://api.yyide.com/brand/exam/detail` | — | {"siteId":"{site_id}","subjectId":"{subject_id}","examinationId":"{examination_id}"} | — | Bearer {access_token} | application/json | yes | 考试 / requestExamDetail |
| exam-003 | POST | `https://api.yyide.com/brand/exam/person` | — | {"siteId":"{site_id}","subjectId":"{subject_id}","examinationId":"{examination_id}"} | — | Bearer {access_token} | application/json | yes | 考试 / requestExamPersonSeat |
| exam-004 | POST | `https://api.yyide.com/brand/exam/plan/week` | — | {} | — | Bearer {access_token} | application/json | yes | 考试 / requestWeekExam |
| exam-005 | POST | `https://api.yyide.com/brand/exam/recent` | — | {"examStartTime":"2026-10-19 00:00:00","examEndTime":"2026-10-19 23:59:59","limit":10} | — | Bearer {access_token} | application/json | yes | 考试 / requestTodayExam |
| exam-006 | POST | `https://api.yyide.com/brand/exam/student/sing/in` | — | {"studentId":"{student_id}","siteId":"{site_id}","subjectId":"{subject_id}","examinationId":"{examination_id}"} | — | Bearer {access_token} | application/json | yes | 考试 / requestSignExam |

## 图书与阅读（`library`，11 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| library-001 | GET | `https://open-lcs.libsaas.com.cn/opac/assets/{ctrl_no}` | — | — | — | — | — | yes | 图书与阅读 / getBookMsgAssets |
| library-002 | GET | `https://open-lcs.libsaas.com.cn/opac/ctrl/{ctrl_no}` | — | — | — | — | — | yes | 图书与阅读 / getBookMsg |
| library-003 | POST | `https://open-lcs.libsaas.com.cn/opac/search` | — | {} | — | — | application/json | yes | 图书与阅读 / searchBook |
| library-004 | GET | `https://open-lcs.libsaas.com.cn/opac/tops/{top_type}` | {"days":"30","flag":"1","language":"zh","type":"1"} | — | — | — | — | yes | 图书与阅读 / getTops |
| library-005 | POST | `https://api.yyide.com/rfid/class-board/category/list` | — | {} | — | Bearer {access_token} | application/json | yes | 图书与阅读 / requestLibraryClassifyList |
| library-006 | POST | `https://api.yyide.com/rfid/class-board/opac/book` | — | {} | — | Bearer {access_token} | application/json | yes | 图书与阅读 / requestLibrarySearch |
| library-007 | POST | `https://api.yyide.com/rfid/class-board/opac/bookDetail` | — | {} | — | Bearer {access_token} | application/json | yes | 图书与阅读 / requestLibraryBookSituation |
| library-008 | GET | `https://api.yyide.com/rfid/class-board/opac/itemTypeList` | {"libraryId":"{library_id}"} | — | — | Bearer {access_token} | — | yes | 图书与阅读 / requestLibraryTypeList |
| library-009 | POST | `https://api.yyide.com/rfid/class-board/rank/hot-circulation-rank` | — | {} | — | Bearer {access_token} | application/json | yes | 图书与阅读 / requestHotList |
| library-010 | POST | `https://api.yyide.com/rfid/class-board/rank/new-book-recommend` | — | {} | — | Bearer {access_token} | application/json | yes | 图书与阅读 / requestLibraryNewList |
| library-011 | POST | `https://api.yyide.com/rfid/hm-board/library/list` | — | {} | — | Bearer {access_token} | application/json | yes | 图书与阅读 / requestLibraryList |

## 场地预约与咨询（`reservation`，6 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| reservation-001 | GET | `https://api.yyide.com/cloud/employee/get` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 场地预约与咨询 / requestEmployeeDetails |
| reservation-002 | POST | `https://api.yyide.com/cloud/employee/getEmployeeListByLabel` | — | {"pageNo":1,"pageSize":20} | — | Bearer {access_token} | application/json | yes | 场地预约与咨询 / requestConsultList |
| reservation-003 | POST | `https://api.yyide.com/cloud/siteBooking/bookingRecordPage` | — | {"pageNo":1,"pageSize":20,"userId":"{student_id}","status":0} | — | Bearer {access_token} | application/json | yes | 预约记录 |
| reservation-004 | GET | `https://api.yyide.com/cloud/siteBooking/get` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 场地预约与咨询 / requestReservationRecordDetail |
| reservation-005 | POST | `https://api.yyide.com/cloud/siteBooking/siteBookingBatchSign` | — | {"siteBookingIds":["{site_booking_id}"],"userId":"{student_id}"} | — | Bearer {access_token} | application/json | yes | 场地预约与咨询 / requestReservationOfflineSign |
| reservation-006 | POST | `https://api.yyide.com/cloud/siteBooking/siteBookingSign` | — | {"siteBookingId":"{site_booking_id}","userId":"{student_id}"} | — | Bearer {access_token} | application/json | yes | 场地预约与咨询 / requestReservationSign |

## 巡课（`patrol`，6 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| patrol-001 | POST | `https://api.yyide.com/app/patrolDayTaskSite/finishSiteTask` | — | {"id":"{patrol_id}","formJson":"{}","userId":"{teacher_id}"} | — | Bearer {access_token} | application/json | yes | 巡课 / requestSubmitPatrol |
| patrol-002 | GET | `https://api.yyide.com/app/patrolDayTaskSite/get` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 巡课 / requestPatrolDetail |
| patrol-003 | POST | `https://api.yyide.com/app/patrolDayTaskSite/page` | — | {"patrolType":1,"pageNo":1,"siteId":"{site_id}","pageSize":20,"userId":"{teacher_id}","status":0} | — | Bearer {access_token} | application/json | yes | 巡课任务列表 |
| patrol-004 | POST | `https://api.yyide.com/app/patrolDayTaskSite/updateClockIn` | — | {"id":"{patrol_id}","formJson":"{}","userId":"{teacher_id}"} | — | Bearer {access_token} | application/json | yes | 巡课 / requestUpdatePatrolPunch |
| patrol-005 | POST | `https://api.yyide.com/app/patrolDayTaskSite/updateNowClock` | — | {"userId":"{teacher_id}","businessId":"{patrol_id}"} | — | Bearer {access_token} | application/json | yes | 巡课 / requestPatrolPunch |
| patrol-006 | GET | `https://api.yyide.com/app/patrolQrCode/getSiteQrCodeStatus` | {"siteId":"{site_id}"} | — | — | Bearer {access_token} | — | yes | 巡课 / requestScanQrCodeStatus |

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

## 宿舍（`dormitory`，2 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| dormitory-001 | GET | `https://api.yyide.com/brand/brand/dormitory/dormitoryHomepage/detail` | {"id":"{brand_id}"} | — | — | Bearer {access_token} | — | yes | 宿舍 / requestHomeDormitoryDetail |
| dormitory-002 | GET | `https://api.yyide.com/cloud/moralEducationActivityBrand/dormitory` | {"schoolId":"{school_id}","classesId":"{classes_id}"} | — | — | Bearer {access_token} | — | yes | 宿舍 / requestHomeDormitoryEducation |

## AI 助手（`ai`，4 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| ai-001 | POST | `https://api.yyide.com/ai/assistant/get` | — | {"id":"assistant-1"} | — | Bearer {access_token} | application/json | yes | AI 助手 / requestAIGetInfo |
| ai-002 | POST | `https://api.yyide.com/ai/assistant/public/list` | — | {} | — | Bearer {access_token} | application/json | yes | AI 助手 / requestAIHomeList |
| ai-003 | POST | `https://api.yyide.com/ai/chat/models` | — | {} | — | Bearer {access_token} | application/json | yes | AI 助手 / requestAIModelList |
| ai-004 | POST | `https://api.yyide.com/ai/chat/session/create` | — | {"assistantId":"assistant-1","userId":"{student_id}"} | — | Bearer {access_token} | application/json | yes | AI 会话创建 |

## 文件上传与日志（`upload`，3 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| upload-001 | POST | `https://api.yyide.com/app/file/upload` | — | — | — | Bearer {access_token} | multipart/form-data | yes | 文件上传（multipart） |
| upload-002 | POST | `https://api.yyide.com/app/file/upload` | — | — | — | Bearer {access_token} | multipart/form-data | yes | 文件上传（multipart） |
| upload-003 | POST | `https://api.yyide.com/file/upload/path` | — | — | — | Bearer {access_token} | multipart/form-data | yes | 日志上传（multipart） |

## 设备物联与扩展（`iot`，9 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| iot-001 | POST | `https://api.yyide.com/api/lock/listSwk.html` | — | {} | — | Bearer {access_token} | application/json | yes | 设备物联与扩展 / listSwk |
| iot-002 | POST | `https://api.yyide.com/api/lock/saveSwk` | — | {} | — | Bearer {access_token} | application/json | yes | 设备物联与扩展 / saveSwk |
| iot-003 | POST | `https://api.yyide.com/brand/layoutclasssign/getVideoStreams` | — | {"brandId":"{brand_id}"} | — | Bearer {access_token} | application/json | yes | 设备物联与扩展 / requestRTSPPath |
| iot-004 | POST | `https://api.yyide.com/brand/openDoor/records/create` | — | {"deviceNo":"{mac}","userId":"{student_id}","type":"1"} | — | Bearer {access_token} | application/json | yes | 设备物联与扩展 / requestRecords |
| iot-005 | POST | `https://api.yyide.com/cloud/device/face-sync/update-status` | — | {"schoolId":"{school_id}","deviceNo":"{mac}","status":1} | — | Bearer {access_token} | application/json | yes | 设备物联与扩展 / requestSynchronizeStatusFaceExtraction |
| iot-006 | POST | `https://api.yyide.com/cloud/device/shared-config/get` | — | {"schoolId":"{school_id}","deviceNo":"{mac}","type":1} | — | Bearer {access_token} | application/json | yes | 设备物联与扩展 / requestFaceConfig |
| iot-007 | POST | `https://api.yyide.com/cloud/sks/site/get` | — | {} | — | Bearer {access_token} | application/json | yes | 设备物联与扩展 / requestSiteInfo |
| iot-008 | POST | `https://api.yyide.com/cloud/sks/site/getSiteEnvIndicators` | — | {} | — | Bearer {access_token} | application/json | yes | 设备物联与扩展 / requestSensorInfoList |
| iot-009 | POST | `https://api.yyide.com/cloud/sks/site/getSiteImages` | — | {} | — | Bearer {access_token} | application/json | yes | 设备物联与扩展 / requestWarningInfoList |

## TTLock 通通锁（`ttlock`，26 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| ttlock-001 | POST | `https://api.ttlock.com.cn/oauth2/token` | — | — | {"client_id":"{ttlock_client_id}","client_secret":"{ttlock_client_secret}","grant_type":"password","username":"{ttlock_username}","password":"{ttlock_password_md5}","redirect_uri":"http://www.1yide.com/"} | — | application/x-www-form-urlencoded | yes | OAuth 登录，获取 access_token |
| ttlock-002 | POST | `https://api.ttlock.com.cn/v3/fingerprint/add` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","fingerprint":"{fingerprint}","startDate":"{start_date}","endDate":"{end_date}","name":"{fingerprint_name}"} | — | application/x-www-form-urlencoded | yes | 添加指纹 |
| ttlock-003 | POST | `https://api.ttlock.com.cn/v3/identityCard/add` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","identityCard":"{identity_card}","startDate":"{start_date}","endDate":"{end_date}","name":"{card_name}"} | — | application/x-www-form-urlencoded | yes | 添加 IC 卡 |
| ttlock-004 | POST | `https://api.ttlock.com.cn/v3/wirelessKeyboard/add` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","keyboardPwd":"{keyboard_pwd}","startDate":"{start_date}","endDate":"{end_date}","name":"{keyboard_name}"} | — | application/x-www-form-urlencoded | yes | 添加无线键盘 |
| ttlock-005 | POST | `https://api.ttlock.com.cn/v3/lock/changeAdminKeyboardPwd` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","keyboardPwd":"{new_keyboard_pwd}"} | — | application/x-www-form-urlencoded | yes | 修改管理员键盘密码 |
| ttlock-006 | POST | `https://api.ttlock.com.cn/v3/fingerprint/clear` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}"} | — | application/x-www-form-urlencoded | yes | 清空指纹 |
| ttlock-007 | POST | `https://api.ttlock.com.cn/v3/identityCard/clear` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}"} | — | application/x-www-form-urlencoded | yes | 清空 IC 卡 |
| ttlock-008 | POST | `https://api.ttlock.com.cn/v3/fingerprint/delete` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","fingerprintId":"{fingerprint_id}"} | — | application/x-www-form-urlencoded | yes | 删除指纹 |
| ttlock-009 | POST | `https://api.ttlock.com.cn/v3/identityCard/delete` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","identityCardId":"{identity_card_id}"} | — | application/x-www-form-urlencoded | yes | 删除 IC 卡 |
| ttlock-010 | POST | `https://api.ttlock.com.cn/v3/lock/delete` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}"} | — | application/x-www-form-urlencoded | yes | 删除锁 |
| ttlock-011 | POST | `https://api.ttlock.com.cn/v3/gateway/isInitSuccess` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","gatewayNetMac":"{gateway_net_mac}"} | — | application/x-www-form-urlencoded | yes | 网关初始化状态 |
| ttlock-012 | POST | `https://api.ttlock.com.cn/v3/gateway/upgradeCheck` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","gatewayId":"{gateway_id}"} | — | application/x-www-form-urlencoded | yes | 网关升级检查 |
| ttlock-013 | POST | `https://api.ttlock.com.cn/v3/gateway/list` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","pageNo":1,"pageSize":100} | — | application/x-www-form-urlencoded | yes | 网关列表 |
| ttlock-014 | POST | `https://api.ttlock.com.cn/v3/lock/list` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","pageNo":1,"pageSize":100} | — | application/x-www-form-urlencoded | yes | 锁列表 |
| ttlock-015 | GET | `https://api.ttlock.com.cn/v3/fingerprint/list` | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","pageNo":1,"pageSize":100} | — | — | — | — | yes | 指纹列表 |
| ttlock-016 | GET | `https://api.ttlock.com.cn/v3/identityCard/list` | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","pageNo":1,"pageSize":100} | — | — | — | — | yes | IC 卡列表 |
| ttlock-017 | GET | `https://api.ttlock.com.cn/v3/key/list` | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","pageNo":1,"pageSize":100} | — | — | — | — | yes | 钥匙列表 |
| ttlock-018 | POST | `https://api.ttlock.com.cn/v3/lock/initialize` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockData":"{lock_data}","lockAlias":"{lock_alias}"} | — | application/x-www-form-urlencoded | yes | 初始化锁 |
| ttlock-019 | POST | `https://api.ttlock.com.cn/v3/lock/upgradeCheck` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}"} | — | application/x-www-form-urlencoded | yes | 锁升级检查 |
| ttlock-020 | POST | `https://api.ttlock.com.cn/v3/lock/upgradeRecheck` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","firmwareInfo":"{firmware_info}"} | — | application/x-www-form-urlencoded | yes | 锁升级复查 |
| ttlock-021 | POST | `https://api.ttlock.com.cn/v3/identityCard/changePeriod` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","identityCardId":"{identity_card_id}","startDate":"{start_date}","endDate":"{end_date}"} | — | application/x-www-form-urlencoded | yes | 修改 IC 卡有效期 |
| ttlock-022 | POST | `https://api.ttlock.com.cn/room/registerNb` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","nbNodeId":"{nb_node_id}","nbCardNumber":"{nb_card_number}","nbRssi":"{nb_rssi}","nbOperator":"{nb_operator}"} | — | application/x-www-form-urlencoded | yes | 注册 NB 物联网模块 |
| ttlock-023 | POST | `https://api.ttlock.com.cn/v3/lock/resetKeyboardPwd` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","pwdInfo":"{pwd_info}","timestamp":"{pwd_timestamp}"} | — | application/x-www-form-urlencoded | yes | 重置键盘密码 |
| ttlock-024 | POST | `https://api.ttlock.com.cn/v3/lock/resetKey` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}"} | — | application/x-www-form-urlencoded | yes | 重置 eKey |
| ttlock-025 | POST | `https://api.ttlock.com.cn/v3/gateway/uploadDetail` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","gatewayId":"{gateway_id}","modelNum":"{model_num}","hardwareRevision":"{hardware_revision}","firmwareRevision":"{firmware_revision}","networkName":"{network_name}"} | — | application/x-www-form-urlencoded | yes | 上传网关详情 |
| ttlock-026 | POST | `https://api.ttlock.com.cn/lockRecords/fromLock` | — | — | {"clientId":"{ttlock_client_id}","accessToken":"{ttlock_access_token}","date":"{timestamp_ms}","lockId":"{lock_id}","records":"{lock_records}"} | — | application/x-www-form-urlencoded | yes | 上传锁记录 |

## 人脸同步（FacePass）（`face`，4 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| face-001 | POST | `https://api.yyide.com/cloud/device/face-sync/sync-page` | — | {"schoolId":"{school_id}","deviceNo":"{mac}","pageNo":1,"pageSize":100} | — | Bearer {access_token} | application/json | yes | 分页拉取人脸 |
| face-002 | POST | `https://api.yyide.com/cloud/device/face-sync/sync-all` | — | {"schoolId":"{school_id}","deviceNo":"{mac}"} | — | Bearer {access_token} | application/json | yes | 全量同步人脸 |
| face-003 | POST | `https://api.yyide.com/cloud/device/face-sync/batch-update-status` | — | {"schoolId":"{school_id}","deviceNo":"{mac}","list":[]} | — | Bearer {access_token} | application/json | yes | 批量更新同步状态 |
| face-004 | POST | `https://api.yyide.com/cloud/v2/machine/updateApkVersion` | — | {"deviceNo":"{mac}","version":"3.0.14"} | — | Bearer {access_token} | application/json | yes | 上报 APK 版本 |

## 外部/手工接口（`external`，5 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| external-001 | POST | `https://api.yyide.com/ai/chat/completion/stream` | — | {"sessionId":"{session_id}","prompt":"{prompt}"} | — | Bearer {access_token} | application/json | yes | AI 流式对话（text/event-stream） |
| external-002 | POST | `https://api.yyide.com/brand/brand/album/list` | — | {"classesId":"{classes_id}","kind":"1","type":"1","limitNum":10} | — | Bearer {access_token} | application/json | yes | 旧相册列表（HttpUtils.post） |
| external-003 | POST | `https://api.yyide.com/brand/brand/album/listDetail` | — | {"classesId":"{classes_id}","kind":"1","type":"1"} | — | Bearer {access_token} | application/json | yes | 旧相册详情（HttpUtils.post） |
| external-004 | POST | `https://api.yyide.com/brand/class-brand-management/android/videoalbum/list` | — | {"classesId":"{classes_id}","pageNo":1,"pageSize":20} | — | Bearer {access_token} | application/json | yes | 旧视频列表（HttpUtils2.post） |
| external-005 | POST | `https://console.tim.qq.com/v4/openim/get_c2c_unread_msg_num` | {"sdkappid":"{tim_sdkappid}","identifier":"{tim_admin_identifier}","usersig":"{tim_admin_usersig}","random":"{random}","contenttype":"json"} | {"To_Account":"{student_id}"} | — | — | application/json | no | 腾讯云 IM：查询单聊未读数（需要管理员 UserSig） |

