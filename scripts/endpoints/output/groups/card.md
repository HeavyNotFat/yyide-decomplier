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
- 请求数：11

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `card` | 刷卡、人脸与身份识别 | 11 |

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

