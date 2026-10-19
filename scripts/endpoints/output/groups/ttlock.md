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
| `ttlock` | TTLock 通通锁 | 26 |

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

