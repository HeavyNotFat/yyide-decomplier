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
| `library` | 图书与阅读 | 11 |

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

