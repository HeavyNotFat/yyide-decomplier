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
- 请求数：9

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `iot` | 设备物联与扩展 | 9 |

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

