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
| `device` | 设备激活、绑定与升级 | 18 |

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

