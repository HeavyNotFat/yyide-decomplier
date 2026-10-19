# 云端控制器（Cloud Controller）

> 文档导航：[README.md](README.md) · [RESTORE.md](RESTORE.md) · [ENDPOINTS.md](ENDPOINTS.md) · [GITHUB.md](GITHUB.md)
>
> 本工具面向**自有班牌设备的离线调试、教学研究与兼容性验证**，请勿用于未授权设备或线上系统。

云端控制器是 `api.yyide.com` 的本地替代品，同时提供一个浏览器控制台。班牌连上它之后，首页卡片、公告、相册、视频、荣誉、课表等内容全部由你控制，且不需要改一行服务端业务代码。

---

## 1. 能做什么

| 能力 | 说明 |
| --- | --- |
| 293 个首页组件 | 从 `HomeFragment.fragment()` 的 293 个 tag 中完整提取，组件库可搜索、筛选、加入布局 |
| 8×6 卡片布局 | 拖拽、缩放、增删卡片，支持多分页；保存后班牌刷新即生效 |
| 257 个接口 | 覆盖源码里的全部 Retrofit 接口；可为任意路径设置自定义响应 |
| 90 个 Activity | 功能地图列出全部页面、导出状态和 adb 启动命令 |
| 内容中心 | 公告、班级/校园相册、视频、荣誉、值日、作品、考试、图书、活动、投票、课表等 |
| 接口日志 | 实时显示班牌请求、命中处理器、耗时；可清空 |
| 组件巡展 | 一键把组件自动排成多页布局，左右滑动逐页浏览 |
| 演示数据 | 内置示例学校、班级、教师、学生、公告、图片、视频，开箱即用 |

控制台地址：`http://127.0.0.1:8765/admin`，演示账号 `demo / demo`（服务端其实不校验密码）。

---

## 2. 目录结构

```text
cloud-server/
  server.py                 Flask 服务：控制台 API + 班牌接口模拟
  store.py                  JSON 存储、演示数据、图片/视频生成
  data/
    catalog.json            293 组件 + 90 Activity + 257 接口（自动生成）
    site.json               学校/班级/教师/学生/天气/设备身份（运行时生成）
    layout.json             分页与卡片布局（运行时生成）
    content.json            各模块内容（运行时生成）
    overrides.json          接口覆盖（运行时生成）
    requests.log            请求日志（运行时生成）
  web/                      控制台前端（纯 HTML/CSS/JS，无需构建）
  assets/                   自动生成的演示图片/视频
  tools/extract_catalog.py  从反编译源码重新生成 catalog.json
```

相关脚本：

| 脚本 | 作用 |
| --- | --- |
| `scripts/build-cloud-apk.ps1` | 把 APK 内的接口域名替换成控制器地址，重新签名 |
| `scripts/repack_cloud.py` | 替换 APK 中的 dex 并重打包 |
| `scripts/patch_smali_urls.py` | 在 baksmali 输出里批量替换 URL |
| `scripts/repack_restore.py` | 还原版补丁 dex 的重打包（原流程） |

---

## 3. 启动

### 3.1 依赖

- Python 3.10+，安装依赖：`pip install -r cloud-server/requirements.txt`
- 图片/视频演示资源需要 Pillow；视频可选 ffmpeg（没有则视频卡片为空）
- 控制器默认监听 `0.0.0.0:8765`

### 3.2 启动

```powershell
python cloud-server/server.py --port 8765
```

输出示例：

```text
  智慧班牌 · 云端控制器
  ----------------------------------------------------
  控制台     http://127.0.0.1:8765/admin
  模拟接口   http://127.0.0.1:8765
  模拟器     http://10.0.2.2:8765
  局域网     http://192.168.1.10:8765
  演示账号   demo / demo
```

- 宿主机浏览器：`http://127.0.0.1:8765/admin`
- Android 模拟器：`http://10.0.2.2:8765`
- 真机：把电脑的局域网 IP 填到 `build-cloud-apk.ps1 -CloudUrl`，手机和电脑需同一局域网

### 3.3 第一次启动

首次运行会自动生成 `data/site.json`、`layout.json`、`content.json`、`overrides.json` 和演示图片/视频。想恢复初始演示数据：

```powershell
curl -X POST http://127.0.0.1:8765/api/reset
```

或在控制台「设备连接 → 数据管理 → 恢复全部演示数据」。

---

## 4. 控制台

### 4.1 概览

显示可布组件数、可模拟接口数、Activity 数、当前分页/卡片数、最近请求和快捷入口。

### 4.2 卡片布局

- 画布是 **8 列 × 6 行**；
- 拖动卡片移动，拖动右下角缩放；
- 点击卡片在右侧修改模块名、坐标、尺寸、边框/背景色、跳转链接、图片列表、JSON 参数、二次页返回时间；
- 「添加卡片」从组件库选一个组件；当前页满了会自动新建分页；
- 分页标签可重命名、复制、清空、删除；
- 「保存布局」写入 `data/layout.json`，班牌下拉刷新或重启后读取；
- 「恢复默认」恢复 7 张卡片的默认首页。

### 4.3 组件库

293 个组件按分类、尺寸和关键字筛选。每个组件显示：

- `tag`：服务端下发的标签，决定班牌用哪个 Fragment 渲染；
- 尺寸：从 tag 后缀解析（如 `hbbjxx22` = 2×2，`hbbjxc441` = 4×4）；
- Fragment：真正渲染该组件的类名；
- 分类：消息公告、班级/校园、相册/视频、课表、考勤、德育、场地、考试、图书、自定义等。

点「加入布局」会加到当前分页；当前分页满时自动新建分页。

### 4.4 内容中心

| 子页 | 内容 |
| --- | --- |
| 站点与班级 | 学校名、英文名、班级、年级、班主任、口号、人数、教室、MAC、版本 |
| 通知公告 | 标题、来源、发布人、日期、封面、正文 HTML |
| 相册 | 班级/校园相册，封面与图片 URL 列表 |
| 视频 | 名称、视频 URL、封面 |
| 荣誉 | 荣誉名、获得者、事迹、日期、级别、头像 |
| 其他模块 | 值日、作品、考试、图书、活动、投票、课表、报修的 JSON 编辑 |
| 天气/倒计时 | 天气字段与倒计时 JSON |

保存后即时写入 `data/content.json`，班牌下次请求即生效。

### 4.5 接口模拟

- 左侧 257 个接口，可按分组和关键字搜索；
- 选中接口后可以：
  - 勾选「启用自定义响应」；
  - 编辑返回 JSON（原样返回，可包含 `code`、`message`、`data`）；
  - 插入默认模板；
  - 删除覆盖；
- 覆盖按 **路径** 匹配，写入 `data/overrides.json`；
- 右侧「实时请求」每 2 秒刷新，显示时间、方法、路径、命中处理器、耗时。

覆盖示例（让 `/brand/weather/now` 固定返回 30℃）：

```json
{
  "code": 0,
  "message": "操作成功",
  "data": {
    "area": "重庆",
    "weather": "晴",
    "real": "30",
    "highest": "33",
    "lowest": "25"
  }
}
```

### 4.6 设备连接

- 显示控制台、模拟器、局域网三个地址；
- 给出构建/安装/登录/刷新步骤；
- 命令行速查（adb reverse、重启应用、看日志、清缓存）；
- 一键生成组件巡展；
- 演示身份与数据管理。

### 4.7 功能地图

- 90 个 Activity 的名称、包名、是否导出、adb 启动命令；
- 组件分类分布；
- 「如何浏览全部功能」提示。

> 未导出的 Activity 无法被 adb 直接启动；请从对应卡片进入。组件库里的每个 tag 都能放进首页，因此 293 个首页组件就是最完整的可视化入口。

---

## 5. 布局协议

控制器对 `POST /brand/brand/layoutclasssign/layoutlist` 返回：

```json
{
  "code": 0,
  "msg": "",
  "data": [
    {
      "id": "home",
      "pagination": "home",
      "layoutClassSignDetailsEntityList": [
        {
          "id": "card-2",
          "tag": "hbtzgg25",
          "moduleName": "通知公告",
          "x": 0, "y": 1, "width": 2, "height": 5,
          "borderColor": "",
          "showModuleName": true,
          "jsonParam": "",
          "url": "",
          "images": "",
          "descriptive": "",
          "secPageBackTime": 10
        }
      ]
    }
  ]
}
```

- `pagination`：班牌按它匹配分页；多分页时首页左右滑动；
- `x/y`：8×6 栅格坐标；
- `width/height`：卡片占格（班牌实际渲染尺寸主要由 Fragment 自身布局决定，建议与 tag 后缀一致）；
- `jsonParam`：自定义/网页组件的 JSON 内容，原样传给 Fragment；
- `images/imagesList`、`url`、`borderColor`、`showModuleName` 等按原版字段下发。

> 修改布局后，班牌端需要重启 App 或下拉刷新；部分页面会先用 SharedPreferences/MMKV 缓存渲染，再请求新布局。

---

## 6. 让班牌连上控制器

### 6.1 构建云端调试包

推荐以还原版 APK 为基础（保留真实设备身份和刷卡快捷入口）：

```powershell
.\scripts\build-cloud-apk.ps1 -CloudUrl "http://10.0.2.2:8765"
```

输出：`dist/智慧班牌-3.0.14-云端版.apk`

脚本做的事：

1. 解包基础 APK 的 `classes*.dex`；
2. 只对包含 `https://api.yyide.com`、`https://zhwnlapi.etouch.cn`、`https://open-lcs.libsaas.com.cn` 的 dex 做 baksmali；
3. 把 URL 替换成 `-CloudUrl`；
4. 用 smali 重新汇编 dex；
5. 重打包、zipalign、用 Android Debug keystore 签名。

工具链（baksmali/smali/dexlib2/guava/jcommander/antlr）会在首次运行时下载到 `build/smali`；离线环境可提前放好并用 `-SmaliHome` 指定目录。

> URL 是**编译进 dex 的常量**，换电脑/换 IP 后需要重新构建；模拟器固定用 `10.0.2.2`。

### 6.2 安装

```powershell
adb uninstall com.yd.android_brand_mvp
adb install -r "dist\智慧班牌-3.0.14-云端版.apk"
```

- 云端版使用 Android Debug 签名，不能覆盖原版（原版 `CN=ChenHao`）；
- 卸载会清掉原 App 的本地数据，包括已登录账号和缓存布局；
- 如果之前装过还原版（同为 Debug 签名），可以 `adb install -r` 直接覆盖，保留数据。

### 6.3 登录

- 账号 `demo`，密码 `demo`；
- 任意账号也能登录（服务端不校验），登录后返回演示学校/班级；
- 登录成功后服务端会把 `plaintextPassword` 写成 `demo`，后续启动可自动登录。

### 6.4 真机

1. 查电脑 IP：`ipconfig`；
2. 重新构建：`.\scripts\build-cloud-apk.ps1 -CloudUrl "http://192.168.1.10:8765"`；
3. 手机与电脑同一 Wi-Fi，安装后登录；
4. 如果局域网不通，可用 USB + `adb reverse`，但 APK 内的地址必须是 `http://127.0.0.1:8765`，同样需要重新构建。

### 6.5 不重新打包的方案（可选）

把 `api.yyide.com` 指向本地需要 HTTPS 证书和受信任 CA，且要处理 Android 的证书校验；对普通调试不如直接重打包稳定，本文不展开。

---

## 7. 浏览全部功能

293 个首页组件覆盖了绝大多数界面能力。推荐两种方式：

1. **组件库逐一点选**：搜索/筛选任意组件，加入布局，保存，班牌刷新即可看到该功能；
2. **组件巡展**：在组件库或设备连接页点「生成组件巡展」，选择分类后自动生成多页布局。

> 巡展默认最多 10 页（可在弹窗里调整到 20）。班牌首页会一次性保留所有分页的 Fragment，页数过多会占内存；组件多时建议按分类分批生成。未排入的组件数量会在提示里显示。

功能地图里的 Activity 可用 `adb shell am start -n ...` 启动（仅导出的）；未导出页面从对应卡片进入。

---

## 8. 数据、备份与重置

运行时数据都在 `cloud-server/data/`：

| 文件 | 说明 |
| --- | --- |
| `catalog.json` | 组件/Activity/接口目录，由源码生成，可重新生成 |
| `site.json` | 学校、班级、教师、学生、天气、设备身份 |
| `layout.json` | 分页与卡片 |
| `content.json` | 各模块内容 |
| `overrides.json` | 接口覆盖 |
| `requests.log` | JSON Lines 请求日志 |

- 备份：直接复制这几个 JSON；
- 重置：`POST /api/reset`；
- 只重置布局：`POST /api/layout/reset`；
- 清空日志：`POST /api/logs/clear`；
- 重新生成 catalog：

```powershell
python cloud-server/tools/extract_catalog.py
```

该脚本解析 `HomeFragment.java` 的 tag 哈希分支与 Fragment 返回分支，用 `javap -constants` 解析常量，再解析 `AndroidManifest.xml` 和 `scripts/endpoints`。

---

## 9. 接口覆盖原理

请求到达时：

1. 先查 `overrides.json` 中是否有该路径且 `enabled`；
2. 有则原样返回 `body`；
3. 否则按路径前缀分派到内置处理器（auth/brand/school/messages/home/timetable/honor/exam/library/...）；
4. 未知接口返回通用 `{code:0,data:{list:[]}}` 或空对象，保证 App 不崩。

覆盖的 key 是**路径**，所以同一路径的多个接口（例如多个 `getBrandObtain`）会一起被覆盖。

### 增加一个内置接口

编辑 `cloud-server/server.py`：

```python
def handle_home(path: str) -> dict:
    if path == "brand/my/new/endpoint":
        return envelope({"hello": "world"})
    ...
```

或在 `PATH_HANDLERS` / `route_key` 里加分组。

---

## 10. 已覆盖与未覆盖

### 已覆盖（有演示数据）

登录/设备激活、学校/班级、首页布局、公告/消息、相册、视频、天气、倒计时、值日、学生作品、课表、考勤、荣誉/德育、考试、图书、活动、投票/问卷、请假/报修、场地预约、宿舍、AI、文件上传、物联网基础、人脸同步基础。

### 未完整模拟

| 能力 | 现状 |
| --- | --- |
| MQTT（`tcp://116.63.71.76:1883`） | 未实现 broker；设备状态推送不可用 |
| TTLock / 门锁 | 接口可返回通用数据，但签名/加密流程未实现 |
| 人脸 SDK / 摄像头 | 依赖设备原生库和证书，未接 |
| 腾讯 IM UserSig | 返回演示字符串，真实 IM 不可用 |
| 流媒体 RTSP / CCTV | 只返回演示 mp4 |
| AI SSE | 返回固定的流式文本，不调用真实模型 |

首页卡片大多能在无这些依赖时显示占位或“暂无数据”，不会影响布局浏览。

---

## 11. 故障排查

| 现象 | 排查 |
| --- | --- |
| 班牌仍请求 `api.yyide.com` | 安装的是未打补丁的 APK；用 `build-cloud-apk.ps1` 重新构建，或看控制台「实时请求」是否有日志 |
| 登录后一直转圈 | 服务端是否在运行；`curl http://127.0.0.1:8765/api/health`；模拟器用 `10.0.2.2` |
| 页面白屏/闪退 | 先恢复默认布局；查看 logcat：`adb logcat -d | grep AndroidRuntime` |
| 图片/视频不显示 | 确认服务端 `/mock/...` 可访问；视频需要 ffmpeg 生成 mp4；媒体 URL 会自动转成绝对地址 |
| 布局改了没生效 | 班牌重启或下拉刷新；服务端日志里应有新的 `layoutclasssign/layoutlist` |
| 巡展页数太多卡顿 | 减少「最多生成页数」，按分类生成；删除不需要的分页 |
| 端口被占用 | `--port 8766`，同时重新构建 APK 的 `-CloudUrl` |
| 控制台面板空白 | 浏览器开发者工具看 `/api/state` 是否 200；清缓存强制刷新 |

---

## 12. 安全与发布

- 控制器默认监听 `0.0.0.0` 且**没有登录鉴权**，只应在可信局域网使用；
- 不要把 `cloud-server/data/`、`assets/`、`requests.log` 提交到公开仓库（已在 `.gitignore` 中排除运行时文件）；
- 云端版 APK 使用 Android Debug 签名，仅供自有设备调试；
- 发布仓库前执行 `python scripts/secrets.py check/scrub`，确认没有真实 MAC、Android ID、账号、密钥；
- 本工具不改变原版业务逻辑，只替换网络端点；请遵守设备与服务的使用条款。

---

## 13. 开发备忘

- 服务端无数据库，全部 JSON；并发写入用锁 + 原子替换；
- 媒体路径统一以 `/mock/` 开头，响应前由 `absolutize()` 转成当前请求的绝对地址（模拟器/局域网都能用）；
- 组件目录来自反编译源码，不是手写清单；升级 APK 后重新运行 `extract_catalog.py`；
- 控制台是纯静态文件，改完刷新浏览器即可，不需要构建；
- 需要新增页面时，在 `web/app.js` 里加 `viewXxx()` 并挂到 `VIEW_META` / `render()` 即可。
