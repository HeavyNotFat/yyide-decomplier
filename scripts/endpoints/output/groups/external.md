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
- 请求数：5

## 分组索引

| 分组 | 名称 | 请求数 |
| --- | --- | ---: |
| `external` | 外部/手工接口 | 5 |

## 外部/手工接口（`external`，5 个）

| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| external-001 | POST | `https://api.yyide.com/ai/chat/completion/stream` | — | {"sessionId":"{session_id}","prompt":"{prompt}"} | — | Bearer {access_token} | application/json | yes | AI 流式对话（text/event-stream） |
| external-002 | POST | `https://api.yyide.com/brand/brand/album/list` | — | {"classesId":"{classes_id}","kind":"1","type":"1","limitNum":10} | — | Bearer {access_token} | application/json | yes | 旧相册列表（HttpUtils.post） |
| external-003 | POST | `https://api.yyide.com/brand/brand/album/listDetail` | — | {"classesId":"{classes_id}","kind":"1","type":"1"} | — | Bearer {access_token} | application/json | yes | 旧相册详情（HttpUtils.post） |
| external-004 | POST | `https://api.yyide.com/brand/class-brand-management/android/videoalbum/list` | — | {"classesId":"{classes_id}","pageNo":1,"pageSize":20} | — | Bearer {access_token} | application/json | yes | 旧视频列表（HttpUtils2.post） |
| external-005 | POST | `https://console.tim.qq.com/v4/openim/get_c2c_unread_msg_num` | {"sdkappid":"{tim_sdkappid}","identifier":"{tim_admin_identifier}","usersig":"{tim_admin_usersig}","random":"{random}","contenttype":"json"} | {"To_Account":"{student_id}"} | — | — | application/json | no | 腾讯云 IM：查询单聊未读数（需要管理员 UserSig） |

