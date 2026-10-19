# 智慧班牌 3.0.14 逆向与还原工程

> 包名：`com.yd.android_brand_mvp`　versionCode：`3002`　versionName：`3.0.14`
> minSdk：`22`　targetSdk：`29`　compileSdk：`31`

本项目面向**自有班牌设备的离线调试、教学研究、兼容性验证**。仓库中的 APK、签名、账号、密钥均来自原始安装包；请勿用于未授权设备、线上系统或商业分发。

> **发布前必读**：本仓库包含真实账号、OAuth Secret、第三方 Key/AppID、证书和私钥。上传 GitHub 前必须运行 [`scripts/secrets.py`](scripts/secrets.py) 脱敏，并轮换已泄露的凭据。详见 [凭据与发布](#8-凭据与发布)。

---

## 目录

- [1. 这个仓库包含什么](#1-这个仓库包含什么)
- [2. 5 分钟跑起来](#2-5-分钟跑起来)
- [3. 构建](#3-构建)
- [4. 使用](#4-使用)
- [5. 文件结构](#5-文件结构)
- [6. scripts 都是干嘛的](#6-scripts-都是干嘛的)
- [7. 文档导航](#7-文档导航)
- [8. 凭据与发布](#8-凭据与发布)
- [9. 已知限制与排查](#9-已知限制与排查)

---

## 1. 这个仓库包含什么

| 内容 | 位置 | 说明 |
| --- | --- | --- |
| 还原版 APK | `dist/智慧班牌-3.0.14-还原版.apk` | 固定班牌设备身份，保留原版完整界面与 8×6 首页布局；新增刷卡/离线验证快捷入口 |
| 还原版截图 | `dist/preview-home.png`、`preview-teacher.png`、`preview-student.png` | 首页、教师端、学生空间 |
| 反编译应用源码 | `src/main/java/` | JADX 输出，约 2,895 个 `.java` |
| 应用资源 | `src/main/res/`、`src/main/assets/` | 布局、图片、字符串、证书、字体、皮肤 |
| 原生库 | `src/main/lib/` | armeabi-v7a / arm64-v8a / x86 / x86_64 |
| 第三方库源码 | `vendor-src/` | 反编译依赖库、jar-only、隔离类 |
| 编译用 jar | `libs/` | `original-classes.jar`（dex2jar）、ECJ 重建 jar、`app-r.jar` |
| 构建脚本 | `scripts/` | 还原版打包、旧 Mock 流程、接口表生成、脱敏 |
| 接口文档 | `ENDPOINTS.md` | 222 个 Retrofit 接口 + 外部接口 + 示例 |
| 还原说明 | `RESTORE.md` | 设备身份、布局、快捷入口、构建与验证记录 |
| Python 接口客户端 | `scripts/endpoints/` | 257 条请求、真实环境客户端、预览/执行/伪造 |
| 云端控制器 | `cloud-server/` | 本地替代 `api.yyide.com`：293 组件布局、257 接口、内容管理、请求日志、Web 控制台 |
| 云端控制器文档 | `CLOUD.md` | 启动、控制台、布局协议、构建云端版 APK、故障排查 |

### 还原版做了什么

- `/brand/obtain` 使用真实班牌 MAC 与 Android ID，而不是当前手机/模拟器的值；
- 首页仍由原版 `HomeFragment` 从 `/brand/brand/layoutclasssign/layoutlist` 实时读取 8×6 布局；
- 在原版刷卡/离线验证流程中增加四个本地入口：
  - 卡号全是 `8`（如 `8888888888`）或离线码 `1145` → 教师端设置页；
  - 卡号 `1234567890` 或离线码 `1024` → 学生空间。

细节见 [RESTORE.md](RESTORE.md)。

---

## 2. 5 分钟跑起来

### 2.1 直接安装还原版 APK

```powershell
adb uninstall com.yd.android_brand_mvp
adb install "dist\智慧班牌-3.0.14-还原版.apk"
```

安装后：

1. 授予相机、存储/照片、悬浮窗、通知等权限；
2. 首次登录班牌账号，之后会自动登录；
3. 等待首页右下角的资源更新进度结束；
4. 从顶部 Wi-Fi / 天气 / 日历区域打开验证页，按需测试刷卡或离线码。

> APK 使用 Android Debug 签名。原版是 `CN=ChenHao`，两者不能覆盖安装；卸载原版会清掉原 App 的本地数据。
>
> `dist/*.apk` 已被 `.gitignore` 忽略。发布时建议把 APK 作为 **GitHub Release 附件**，不要直接提交进仓库。

### 2.2 只调 API

```powershell
python -m pip install -r scripts/endpoints/requirements.txt

$env:YIDE_USERNAME = "<班牌账号>"
$env:YIDE_PASSWORD = "<班牌密码>"
$env:YIDE_CLIENT_SECRET = "<client_secret>"
$env:YIDE_MAC = "<设备 MAC，12 位小写>"
$env:YIDE_ANDROID_ID = "<16 位 Android ID>"

python -m scripts.endpoints.runner --id auth-001
```

预览某个请求（不发送）：

```powershell
python -m scripts.endpoints.runner --id home-002
python -m scripts.endpoints.runner --group school
```

用 Python 客户端：

```python
from scripts.endpoints.client import BrandClient

client = BrandClient(
    username="<班牌账号>",
    password="<班牌密码>",
    mac="<设备 MAC>",
    android_id="<Android ID>",
    auto_obtain=True,
)
layout = client.school_get_new_layout_list(id=client.context["brand_id"])
print(layout)
```

完整说明见 [scripts/endpoints/README.md](scripts/endpoints/README.md)。

### 2.3 生成接口请求表

```powershell
python -m scripts.endpoints.build_request_table --split
```

输出在 `scripts/endpoints/output/`：`requests.csv/json/md` 以及 `groups/<分组>.csv/md`。

---

## 3. 构建

### 3.1 环境

| 工具 | 版本 / 路径 | 用途 |
| --- | --- | --- |
| JDK | 17（默认 `D:\java-se-17\jdk-17.0.20.1+1`） | Gradle / javac / d8 |
| Gradle | 7.6.6（wrapper） | AGP 构建 |
| Android SDK | compileSdk 31，build-tools 34.0.0 | 编译 / 打包 / 签名 |
| Python | 3.10+（开发用 3.12） | 接口客户端、脱敏脚本 |
| apktool | 3.0.3 | **仅旧 Mock 流程需要，当前未随仓库提供** |

`gradle.properties` 已固定 JDK 路径；如本机不同，改：

```properties
org.gradle.java.home=D:\\path\\to\\jdk-17
```

`local.properties` 指向 Android SDK：

```properties
sdk.dir=D:\\Android SDK
```

### 3.2 构建还原版 APK（推荐）

准备一个 **3.0.14 原版 APK**（例如 `dist\智慧班牌-3.0.14-原版签名.apk`，或从原设备导出），然后：

```powershell
# 如果当前仓库已执行过 secrets.py scrub，先恢复本地凭据/源码
python scripts/secrets.py restore

.\scripts\build-restore-apk.ps1 `
  -BaseApk "D:\path\to\智慧班牌_3.0.14.apk"
```

> `libs/original-classes.jar` 是原版 dex2jar 结果，里面含编译后的硬编码配置/密钥，**不随公开仓库发布**；请从自己的原版 APK 本地保留或生成。`libs/app-r.jar` 只是 R 常量，可以公开。

脚本流程：

1. `javac` 编译 `src/main/java` 中本次改动的 7 个类（classpath：`android.jar` + `libs/app-r.jar` + `libs/original-classes.jar`）；
2. `d8` 生成 patch `classes.dex`；
3. [`scripts/repack_restore.py`](scripts/repack_restore.py) 把 patch dex 放到 `classes.dex`，原版 `classes.dex`…`classes6.dex` 依次后移为 `classes2.dex`…`classes7.dex`；
4. `zipalign`；
5. `apksigner`（Android Debug keystore）。

输出：

```text
dist/智慧班牌-3.0.14-还原版.apk
```

> 只替换同名 Java 类，原版资源、assets、native 库保持不变。类加载顺序是 `classes.dex` → `classes2.dex` → …，所以 patch 类会覆盖原版同名类。

### 3.3 从反编译源码构建（实验）

```powershell
.\gradlew.bat :assembleDebug
```

默认使用 `libs/original-classes.jar`（原 APK 的 dex2jar 结果）。这适合构建/对比实验，**不保证运行**：dex2jar 会丢失 R8 lambda 类。

使用 ECJ 重建的 class：

```powershell
.\gradlew.bat :assembleDebug -PuseDecompiledClasses
```

同样**不保证可运行**。实测 ECJ 恢复的库类会抛：

```text
java.lang.Error: Unresolved compilation problems: e cannot be resolved to a variable
```

因此正式出包请用 3.2 的补丁方式。

### 3.4 旧 Mock APK 流程

```powershell
.\scripts\build-mock.ps1
```

该脚本依赖：

- `build\apktool.jar`（apktool 3.0.3）；
- `build\apktool-mock\`（已打补丁的反编译树）；
- `mock-portal\`（模拟页面源码）。

当前仓库没有 `build/`、`mock-portal/`，脚本会直接报 `missing: ...`。如果只是调试，建议直接用还原版，或在本地补齐这些目录后再运行。

### 3.5 更新接口文档

```powershell
python scripts/generate_endpoints.py
# 默认输出 ENDPOINTS.raw.md，不覆盖手工维护的 ENDPOINTS.md
```

---

## 4. 使用

### 4.1 还原版功能

| 功能 | 入口 | 说明 |
| --- | --- | --- |
| 首页 | 启动后自动进入 | 8×6 布局，7 个模块实时数据 |
| 通知公告 | 首页“通知公告” | 公告列表/正文 |
| 班级信息 | 首页“班级信息” | 班级、班主任、班名、口号 |
| 荣誉墙 | 首页“荣誉墙” | 服务端无数据时显示占位 |
| 班级/校园相册 | 首页相册卡片 | 图片轮播 |
| 校园视频 | 首页视频卡片 | 视频播放 |
| 教师端 | 全 8 卡号 / 离线 `1145` | `SettingActivity` / `SettingPActivity` |
| 学生空间 | 卡号 `1234567890` / 离线 `1024` | `UserCenterActivity` |

### 4.2 刷卡与离线验证

原版从 USB/串口读卡器取 10 位卡号，按回车提交；离线验证页输入 4 位码。

还原版规则：

```text
8888888888  -> 教师端
1145        -> 教师端
1234567890  -> 学生空间
1024        -> 学生空间
```

其它卡号/验证码继续走原版服务端查卡或随机码校验。

### 4.3 Python 接口客户端

```python
from scripts.endpoints.client import BrandClient

client = BrandClient(
    username="<账号>",
    password="<密码>",
    mac="<MAC>",
    android_id="<Android ID>",
)

# 完整返回外壳
raw = client.school_get_new_layout_list(full=True, id=client.context["brand_id"])
# 只要 data
layout = client.school_get_new_layout_list(id=client.context["brand_id"])
```

- 构造时自动 OAuth 登录；
- `auto_obtain=True` 时自动 `/brand/obtain`，填充 `brand_id/classes_id/site_id`；
- 257 个方法见 `client.method_names`；
- 按 ID 调用：`client.call("home-002", classesId=...)`；
- 只伪造请求：`client.forge("home-002")`、`client.forge_all()`。

### 4.4 真实执行与伪造

```powershell
# 预览，不发送
python -m scripts.endpoints.runner --id auth-001

# 真实执行单条
python -m scripts.endpoints.runner --id auth-001 --execute

# 伪造全部请求（不发送）
python -m scripts.endpoints.runner --forge --mac <MAC> --android-id <ID>
```

详见 [scripts/endpoints/README.md](scripts/endpoints/README.md)。

### 4.5 云端控制器（推荐）

不依赖线上服务，在本地接管班牌的首页布局和全部业务数据：

```powershell
python -m pip install flask pillow
python cloud-server/server.py --port 8765

# 浏览器打开
start http://127.0.0.1:8765/admin

# 构建指向本机的云端调试包（模拟器用 10.0.2.2）
.\scripts\build-cloud-apk.ps1 -CloudUrl "http://10.0.2.2:8765"
adb install -r "dist\智慧班牌-3.0.14-云端版.apk"
```

控制台提供：

- **卡片布局**：8×6 栅格拖拽/缩放，293 个组件任意组合，多分页；
- **组件库**：全部首页组件，可搜索、按分类/尺寸筛选；
- **内容中心**：公告、相册、视频、荣誉、值日、考试、图书、活动、投票、课表；
- **接口模拟**：257 个接口的自定义响应覆盖 + 实时请求日志；
- **组件巡展**：一键生成多页布局，逐页浏览全部组件；
- **功能地图**：90 个 Activity、导出状态与 adb 启动命令。

登录账号 `demo / demo`。完整说明见 [CLOUD.md](CLOUD.md)。

![云端控制器](dist/preview-cloud-admin.png)

![云端版首页](dist/preview-cloud-home.png)

---

## 5. 文件结构

```text
HackedBrand/
├─ src/
│  └─ main/
│     ├─ java/com/yd/android_brand_mvp/   反编译应用源码
│     │  ├─ presenter/                    登录、首页等 Presenter
│     │  ├─ verfity/                      刷卡/人脸/离线验证
│     │  ├─ landscape/                    横屏首页、设置、业务 Fragment
│     │  ├─ network/                      协程 Retrofit 接口
│     │  ├─ net/                          旧 Retrofit/OkHttp 接口
│     │  └─ model/                        响应模型
│     ├─ res/                             布局、drawable、values、raw
│     ├─ assets/                          人脸模型、证书、字体、皮肤
│     ├─ lib/                             原生 .so
│     └─ AndroidManifest.xml
├─ vendor-src/
│  ├─ java/                               第三方库反编译源码
│  ├─ libsrc/                             同批库的第二份副本
│  ├─ jar-only/                           只有 jar 的库
│  └─ quarantine/                         不可编译/隔离类
├─ libs/
│  ├─ original-classes.jar                原 APK dex2jar 结果（构建默认）
│  ├─ app-classes.jar                     ECJ 重建的应用 class
│  ├─ app-r.jar                           应用 R 常量
│  ├─ app-support-classes.jar             支撑类
│  └─ decompiled-libs.jar                 ECJ 重建的依赖库
├─ scripts/
│  ├─ build-restore-apk.ps1               还原版 APK 构建
│  ├─ build-cloud-apk.ps1                 云端版 APK 构建（替换接口域名）
│  ├─ repack_restore.py                   注入 patch dex / 重打包
│  ├─ repack_cloud.py                     替换 dex / 重打包
│  ├─ patch_smali_urls.py                 smali URL 批量替换
│  ├─ secrets.py                          脱敏 / 恢复 / 泄漏检查
│  ├─ build-mock.ps1                      旧 Mock APK 流程（当前缺依赖）
│  ├─ generate_endpoints.py               从 Retrofit 提取接口清单
│  ├─ call_endpoint.py                    最小接口调用示例
│  └─ endpoints/                          257 条请求 + Python 客户端
├─ cloud-server/                          云端控制器（Flask + Web 控制台）
│  ├─ server.py                           接口模拟 + 控制台 API
│  ├─ store.py                            JSON 数据、演示内容、媒体生成
│  ├─ web/                                控制台前端
│  ├─ data/catalog.json                   293 组件 / 90 Activity / 257 接口
│  └─ tools/extract_catalog.py            从源码重新生成组件目录
├─ dist/
│  ├─ 智慧班牌-3.0.14-还原版.apk
│  ├─ 智慧班牌-3.0.14-云端版.apk
│  ├─ preview-home.png
│  ├─ preview-teacher.png
│  ├─ preview-student.png
│  └─ preview-cloud-*.png                 云端控制器与云端版截图
├─ ENDPOINTS.md                           接口文档
├─ CLOUD.md                               云端控制器说明
├─ RESTORE.md                             还原版说明
├─ GITHUB.md                              GitHub 上传清单
├─ README.md
├─ build.gradle
├─ gradle.properties
├─ settings.gradle
└─ gradlew / gradlew.bat
```

> `build/`、`.gradle/`、`.idea/`、`_private/` 是本地生成目录，不进入发布仓库。

---

## 6. scripts 都是干嘛的

| 脚本 | 作用 | 输入 / 输出 |
| --- | --- | --- |
| [`build-restore-apk.ps1`](scripts/build-restore-apk.ps1) | 编译 7 个补丁类、d8、注入原版 APK、zipalign、签名 | 输入原版 APK；输出 `dist/智慧班牌-3.0.14-还原版.apk` |
| [`repack_restore.py`](scripts/repack_restore.py) | 把 patch dex 放到 `classes.dex`，原 dex 后移 | 原版 APK + patch dex → 未签名 APK |
| [`build-cloud-apk.ps1`](scripts/build-cloud-apk.ps1) | 只反汇编含接口域名的 dex，改 URL 后重新汇编、重打包、签名 | 还原版/原版 APK + `-CloudUrl` → `dist/智慧班牌-3.0.14-云端版.apk` |
| [`repack_cloud.py`](scripts/repack_cloud.py) | 替换 APK 中的 dex 并去掉旧签名 | 基础 APK + `dex=path` → 未签名 APK |
| [`patch_smali_urls.py`](scripts/patch_smali_urls.py) | 在 baksmali 输出树里替换 URL | smali 目录 + 旧/新 URL |
| [`secrets.py`](scripts/secrets.py) | 发布前脱敏、恢复本地凭据、检查泄漏 | `scrub` / `restore` / `check` / `status` |
| [`build-mock.ps1`](scripts/build-mock.ps1) | 旧 Mock APK 流程：编译 mock-portal、d8、apktool、注入 `classes7.dex` | 需要 `build/apktool*`、`mock-portal/`；当前缺依赖 |
| [`generate_endpoints.py`](scripts/generate_endpoints.py) | 从 19 个 Retrofit 接口文件提取原始清单 | 输出 `ENDPOINTS.raw.md`（默认不覆盖手工文档） |
| [`call_endpoint.py`](scripts/call_endpoint.py) | 最小 BrandClient 调用示例 | 读取环境变量，打印返回值 |
| [`endpoints/`](scripts/endpoints/README.md) | 257 条真实请求、分组、预览/执行/伪造、Python 客户端 | 见子目录 README |

### scripts/endpoints 子目录

| 文件 | 作用 |
| --- | --- |
| `common.py` | `Endpoint`/`RequestSpec`/`ApiClient`、登录、模板渲染、脱敏 |
| `credentials.py` | 读取环境变量/本地凭据，提供 base URL |
| `permission_loader.py` | 解析本地凭据表（不随仓库发布） |
| `runner.py` | CLI：列表、预览、执行、伪造 |
| `build_request_table.py` | 生成 `output/requests.*` 和分组表 |
| `client.py` | `BrandClient`，257 个接口方法 |
| `device_info.py` | 通过 adb 读 MAC/Android ID/型号 |
| `apis/*.py` | 20 个分组的接口定义 |
| `output/` | 生成的请求表与执行日志 |

---

## 7. 文档导航

| 文档 | 内容 |
| --- | --- |
| [ENDPOINTS.md](ENDPOINTS.md) | 222 个 Retrofit 接口、外部接口、请求参数、示例 |
| [RESTORE.md](RESTORE.md) | 还原版改了什么、8×6 布局、快捷入口、构建与验证记录 |
| [CLOUD.md](CLOUD.md) | 云端控制器：启动、控制台、布局协议、云端版 APK、故障排查 |
| [scripts/endpoints/README.md](scripts/endpoints/README.md) | 请求表、预览/执行/伪造、BrandClient |
| [GITHUB.md](GITHUB.md) | 上传清单：必须上传 / 可选大文件 / 绝对不要上传 |
| [README.md](README.md) | 本文件：构建、使用、目录、脚本、发布 |

> 凭据清单不随仓库发布，也不在文档中列出。

---

## 8. 凭据与发布

### 8.1 哪些东西不能提交

- 本地凭据清单（第三方 APPID/Key/Secret，不随仓库发布）；
- 请求日志、抓包日志、`output/run-*.jsonl`；
- OAuth `client_secret`、账号密码、JWT、UserSig；
- 腾讯云 IM SecretKey、TTLock Client Secret/账号、MQTT 密码；
- 人脸 SDK 证书/密钥、TLS 私钥、签名 keystore；
- 设备 MAC / Android ID（属于设备身份）。

### 8.2 脱敏脚本

[`scripts/secrets.py`](scripts/secrets.py) 用**本地私有目录**保存原始值，仓库里只留占位符：

```powershell
# 查看当前有多少处敏感内容
python scripts/secrets.py check

# 预览会改哪些文件（不写入）
python scripts/secrets.py scrub --dry-run

# 执行脱敏：备份敏感文件到 _private/，替换文本中的密钥/账号/设备标识
python scripts/secrets.py scrub

# 发布前再次确认
python scripts/secrets.py check

# 本地继续开发/构建前恢复
python scripts/secrets.py restore
```

它会：

1. 把本地凭据清单、请求日志、`server.key`、`*.cert`、`*.jks` 等整体移到 `_private/backup/`；
2. 对 `.md/.py/.java/.xml/.json/.properties/.ps1/.gradle` 等文本中的 Secret、密码、JWT、API Key、APPID、MAC、Android ID 做占位符替换；
3. 把映射写入 `_private/secrets.json`（已 gitignore）；
4. `restore` 反向替换并把整体文件搬回；
5. `check` 扫描常见泄漏模式，有命中时退出码非 0。

> `_private/` 只在执行过 `scrub` 的机器上存在。新克隆的公开仓库没有真实值，需要自己配置账号/设备信息后才能构建或联调。

### 8.3 发布流程

```powershell
python scripts/secrets.py check
python scripts/secrets.py scrub
python scripts/secrets.py check

git add -A
git status
git commit -m "docs: rewrite build/usage and add secret scrub"
```

确认 `git status` 中没有：

```text
_private/
*.apk
src/main/res/raw/server.key
src/main/assets/*.cert
```

### 8.4 重要

- **脱敏不等于轮换**。这些值曾经出现在原 APK/公开博客/旧仓库中，发布前应在对应平台吊销或轮换：OAuth client_secret、TIM SecretKey、TTLock、MQTT、Sophix、人脸证书、TLS 私钥。
- 不要把 `_private/`、`secrets.json`、本地凭据清单上传到 Issue、网盘或聊天记录。
- 如果已经 push 过敏感内容，仅删除文件不够，需要 `git filter-repo` 清理历史并轮换凭据。

---

## 9. 已知限制与排查

| 问题 | 原因 / 处理 |
| --- | --- |
| 安装报 `INSTALL_FAILED_UPDATE_INCOMPATIBLE` | 签名不同；先 `adb uninstall com.yd.android_brand_mvp` |
| 登录提示“网络异常” | 设备无法解析 `api.yyide.com`；检查 Wi-Fi/DNS |
| 首页空白/模块缺失 | 布局接口或模块接口 500；看 `adb logcat` 与接口返回 |
| 人脸提示“人脸未授权激活” | FacePass 激活码/证书无效或设备不匹配 |
| 学生空间“暂无数据” | 还原版使用本地测试学生身份，服务端没有该学生 |
| `gradlew -PuseDecompiledClasses` 启动崩溃 | ECJ 反编译库类存在未解析符号；改用 3.2 补丁构建 |
| `build-mock.ps1` 报 `missing: build\apktool.jar` | 旧流程依赖未随仓库提供；补齐 `build/apktool*` 和 `mock-portal/` |
| 63K 方法/多 dex | 原 APK 已启用 multidex；不要关闭 `multiDexEnabled` |

---

## 10. 说明

- 本项目只用于自有设备的离线调试、教学研究与兼容性验证；
- APK、资源、商标、证书归原厂商/学校所有；
- 因使用本项目造成的设备损坏、数据丢失或法律风险由使用者自行承担。
