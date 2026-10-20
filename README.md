# 智慧班牌 3.0.15 逆向与还原工程

> 包名：`com.yd.android_brand_mvp`　versionCode：`3002`　versionName：`3.0.15`
> minSdk：`22`　targetSdk：`29`　compileSdk：`31`
>
> 本项目面向**自有班牌设备的离线调试、教学研究和兼容性验证**。APK、签名、账号和密钥均来自原始安装包，请勿用于未授权设备、线上系统或商业分发。
>
> **3.0.15 没有新增功能，是一次维护版本。** 快速结论见 [WHATS_NEW.md](WHATS_NEW.md)，完整证据见 [DIFF-3.0.14-to-3.0.15.md](DIFF-3.0.14-to-3.0.15.md)。

---

## 1. 这个工程包含什么

| 内容 | 位置 | 说明 |
| --- | --- | --- |
| 反编译应用源码 | `src/main/java/` | 2,897 个 `.java`，JADX 1.5.6 输出 + 3.0.14 已修复源码的逐类替换 |
| 应用资源 | `src/main/res/` | 布局、图片、字符串、颜色、样式、`public.xml` |
| Assets | `src/main/assets/` | 字体、皮肤、模型、证书、视频等（与 3.0.15 原包一致） |
| Native 库 | `src/main/lib/` | armeabi / armeabi-v7a / arm64-v8a / x86 / x86_64 |
| AndroidManifest | `src/main/AndroidManifest.xml` | 3.0.15 原包组件/权限集合 |
| 编译输入 jar | `libs/` | 原版 dex2jar、库类、R 常量、ECJ 源编译产物 |
| 反编译工具链 | `tools/` | ECJ、ASM、StripAnnotations |
| 构建脚本 | `scripts/` | ECJ 重编译、云端 APK、还原 APK、接口客户端 |
| 差异报告 | [DIFF-3.0.14-to-3.0.15.md](DIFF-3.0.14-to-3.0.15.md) | 3.0.14 → 3.0.15 的逐类、逐资源差异 |
| 云端控制器 | `cloud-server/` | 本地替代 `api.yyide.com` 的可视化模拟服务 |
| 接口文档/客户端 | `scripts/endpoints/` | 257 个 Retrofit 接口的 Python 客户端和请求表 |

### 3.0.15 源码是怎么来的

1. 用 **apktool 3.0.3** 解出 `AndroidManifest.xml / res / assets / lib / classes*.dex`；
2. 用 **JADX 1.5.6** 对 `com.yd.android_brand_mvp` 的 7,071 个 smali 类做反编译，得到 2,897 个 Java 文件；
3. 3.0.15 与 3.0.14 的真实差异只有 **13 个类**（见差异报告），其余类直接复用 3.0.14 还原工程中已经修复到可编译的源码；
4. 3.0.14 源码缺失的两个类（`FormFileFragment`、`DownRepository`）从 3.0.15 反编译结果补回；
5. `R.java` 由 AGP 根据 3.0.15 资源重新生成；`R$styleable` 因 AGP 7.4 不生成，从 `libs/app-r.jar` 补入。

这样既保证 `src` 覆盖 3.0.15 的全部应用类，又避免重新修复数千个 JADX/ECJ 编译错误。

> 范围说明：`src/main/java` 覆盖应用包全部 2,897 个 Java 文件；第三方库（androidx、kotlin、腾讯、阿里等）
> 以 `libs/library-classes.jar` 形式提供，不展开为源码。smali 对比显示这些库的字节码在 3.0.14/3.0.15 之间
> 没有任何变化；如需库源码，可直接复用 `HackedBrand/vendor-src`。

---

## 2. 构建

### 2.1 环境

| 工具 | 版本 / 路径 | 用途 |
| --- | --- | --- |
| JDK | 17（`D:\java-se-17\jdk-17.0.20.1+1`） | Gradle / ECJ / javac |
| Gradle | 7.6.6（wrapper） | AGP 构建 |
| Android SDK | compileSdk 31，build-tools 34.0.0 | 编译 / 打包 |
| ECJ | `tools/ecj.jar` | 容错编译 JADX 源码 |

`gradle.properties` 已固定 JDK 路径；`local.properties` 指向 Android SDK。换机器时改这两个文件即可。

### 2.2 从源码重新编译（默认）

如果 `libs/original-classes.jar` 不存在（首次 clone 时它是 git-ignored 的），先生成它：

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\build-original-classes.ps1
```

然后：

```powershell
# 1) 重新编译 src/main/java，生成 libs/app-classes*.jar 和 libs/library-classes.jar
powershell -ExecutionPolicy Bypass -File .\scripts\build-ecj-jars.ps1

# 2) 打包
.\gradlew.bat :assembleDebug
```

输出：

```text
build/outputs/apk/debug/智慧班牌-debug.apk
```

只检查工具链输入、不编译：

```powershell
powershell -ExecutionPolicy Bypass -File .\scripts\build-ecj-jars.ps1 -Check
```

### 2.3 原版类构建（运行最接近官方包）

不重新编译源码，直接使用 `libs/original-classes.jar`（3.0.15 的 dex2jar 结果）：

```powershell
.\gradlew.bat :assembleDebug -PuseOriginalClasses
```

两种模式的区别：

| 模式 | 使用的类 | 说明 |
| --- | --- | --- |
| 默认 | `app-classes-hybrid.jar` + `library-classes.jar` | 源码编译；ECJ 失败/无法生成的类用原版字节码补齐 |
| `-PuseOriginalClasses` | `original-classes.jar` | 全部原版字节码，运行行为最接近官方 APK |

### 2.4 libs 说明

| 文件 | 来源 | 是否提交 |
| --- | --- | --- |
| `original-classes.jar` | 3.0.15 APK 的 dex2jar 结果 | 否（含生产密钥，本地保留） |
| `library-classes.jar` | 从 `original-classes.jar` 剔除 `com/yd/android_brand_mvp/**` | 否（派生） |
| `app-classes.jar` | ECJ 编译 `src/main/java` 并通过 StripAnnotations | 否（派生） |
| `app-classes-hybrid.jar` | `app-classes.jar` + ECJ 未能生成的 2,554 个原版类 + `R$styleable` | 否（派生） |
| `app-r.jar` | 与 3.0.15 资源 ID 完全一致的 R 常量（已逐项校验 0 mismatch） | 是 |
| `app-support-classes.jar` | 3.0.14 库类补充（仅 ECJ classpath） | 否 |

`.gitignore` 只放行 `libs/app-r.jar`，其余 jar 需要在本机从原始 APK 重新生成。

---

## 3. 与 3.0.14 的差异

完整报告见 **[DIFF-3.0.14-to-3.0.15.md](DIFF-3.0.14-to-3.0.15.md)**。

一句话：**3.0.15 没有新增功能、页面、接口或权限**，是一次小型维护/修复版本：

- WiFi 图标按信号等级显示，断网/取不到网络信息时显示断网图标；`top_layout.xml` 的 WiFi 图标固定 48dp 并补默认图；
- **删除**顶部 WiFi/日历点击进入 `TeacherCheackActivity` 的隐藏入口；
- `AppClient` / `BaseNetworkApi` 增加 **BODY 级 HTTP 日志**（正式包也会打印，需重点关注）；
- 视频页 `onResume` 增加 10 秒防抖；
- 轮播/屏保补隐藏通知栏；
- `NetWorkManager` 改用静态内部类单例；
- 若干日志、工具方法和死代码变化。

资源层面只有 `res/layout/top_layout.xml` 不同，`assets/` 完全一致，Manifest 组件/权限集合完全一致；`versionCode` 仍是 `3002`。

---

## 4. 云端控制器（可选）

`cloud-server/` 是本地替代 `api.yyide.com` 的可视化模拟服务（293 个首页组件、90 个 Activity、257 个接口）：

```powershell
python -m pip install -r cloud-server/requirements.txt
python cloud-server/server.py --port 8765
start http://127.0.0.1:8765/admin
```

构建指向本机的调试包：

```powershell
.\scripts\build-cloud-apk.ps1 -CloudUrl "http://10.0.2.2:8765"
adb install -r "dist\智慧班牌-3.0.15-云端版.apk"
```

模拟器用 `10.0.2.2`，真机用电脑局域网 IP。详见 [CLOUD.md](CLOUD.md)。
3.0.15 没有新增接口，因此 3.0.14 的接口目录/组件目录仍然适用。

> `build-cloud-apk.ps1` 默认从 `dist/` 找基础 APK；请先把上一步构建出的
> `build/outputs/apk/debug/智慧班牌-debug.apk` 复制到 `dist/`，或用 `-BaseApk` 指定。

---

## 5. 已知限制

1. **源码构建不保证运行完全正确**。JADX 输出含大量 ECJ 仍无法解析的构造，ECJ 以
   `-proceedOnError` 继续生成 class，报错方法在运行时会抛
   `Unresolved compilation problems`。需要稳定运行请用 `-PuseOriginalClasses`
   或参考 `RESTORE.md` 的 patch-dex 方式。
2. **versionCode 没有递增**：3.0.14/3.0.15 都是 `3002`，应用商店/OTA 不会把它当升级。
3. **BODY 级 HTTP 日志**：正式包会把 token、密码、学生数据写入 Logcat；
   现场使用前建议移除或加 `BuildConfig.DEBUG` 条件。
4. **隐藏教师入口被删**：依赖“点 WiFi/日历进教师端”的现场流程需要改用齿轮入口，
   或使用本仓库 `RestoreVerificationRouter` 的卡号/离线码入口。
5. **SDK 路径/版本**：工程按本机 `D:\java-se-17`、`D:\Android SDK` 配置；
   其他机器需改 `gradle.properties` 和 `local.properties`。

---

## 6. 验证记录

- `.\scripts\build-ecj-jars.ps1`：ECJ 编译 2,897 个源文件，生成 5,931 个 class；
  `app-classes.jar` 6,054 个 class，hybrid 8,613 个条目。
- `.\gradlew.bat :assembleDebug`：**BUILD SUCCESSFUL**，输出
  `build/outputs/apk/debug/智慧班牌-debug.apk`，205,567,280 字节（约 196 MiB）。
- APK dex 检查：46,350 个类；原版 7,071 个应用类 **全部存在**；
  `getWifiDrawableByLevel`、`NetWorkManagerHolder`、`mwindowview` 存在；
  `sendFaceSync`、`view7f0a015b`、`view7f0a0cae` 已消失。
- 复验：`python analysis/verify_apk.py "build/outputs/apk/debug/智慧班牌-debug.apk" libs/original-classes.jar`。
- 资源/资源 ID：3.0.15 `public.xml` 与 `libs/app-r.jar` 逐项对比，**0 个 ID 不一致**。
- 差异统计：45,000 个 smali 类中，新增 3、删除 2、归一化后真实变化 13 个应用类；
  `assets` 0 差异；`res` 仅 `top_layout.xml` 差异。

---

## 7. 目录

```text
HackedBrand3.0.15/
├─ src/main/
│  ├─ AndroidManifest.xml
│  ├─ java/com/yd/android_brand_mvp/      # 2,897 个应用源文件
│  ├─ res/                                 # 3.0.15 资源
│  ├─ assets/                              # 3.0.15 assets
│  └─ lib/                                 # native 库
├─ libs/                                   # 原版/库/R/ECJ jar
├─ tools/                                  # ecj.jar / asm / StripAnnotations
├─ scripts/
│  ├─ build-original-classes.ps1           # APK → libs/original-classes.jar
│  ├─ build-ecj-jars.ps1                   # 源码 → app-classes*.jar
│  ├─ build-cloud-apk.ps1                  # 云端调试包
│  ├─ build-restore-apk.ps1                # 还原版 patch 包
│  └─ endpoints/                           # 接口客户端
├─ analysis/                               # 差异分析/APK 校验脚本
├─ cloud-server/                           # 云端控制器
├─ build.gradle / settings.gradle / gradle.properties
├─ DIFF-3.0.14-to-3.0.15.md
└─ CLOUD.md / RESTORE.md / GITHUB.md / PERMISSION.md
```

---

## 8. 合规提示

- 仅在**自有设备**上安装调试；不要连接生产环境或使用真实学生数据。
- `libs/original-classes.jar`、`src/main/res/raw/server.key`、证书和任何账号/密钥
  都可能来自原厂，发布前必须脱敏并轮换（参考 `scripts/secrets.py`）。
- 本项目不提供、也不鼓励绕过任何授权或计费机制。
