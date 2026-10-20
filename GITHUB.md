# GitHub 上传清单

> 当前仓库约 900MB，其中 `vendor-src/`、`src/main/lib/`、`src/main/assets/`、`libs/`、`dist/` 占了大头。
> 不要把整个目录直接 `git add -A`；按下面的分层上传。

## 1. 必须上传（最小可读仓库，约 70MB）

| 路径 | 大小 | 说明 |
| --- | ---: | --- |
| `README.md`、`RESTORE.md`、`ENDPOINTS.md`、`CLOUD.md`、`GITHUB.md` | ~0.3MB | 构建/使用/API/云端控制器/上传说明 |
| `.gitignore` | 4KB | 排除密钥、APK、构建产物 |
| `build.gradle`、`settings.gradle`、`gradle.properties`、`gradlew`、`gradlew.bat`、`gradle/` | ~100KB | Gradle 构建入口 |
| `proguard-rules.pro` | 1KB | 混淆规则 |
| `scripts/` | 1.5MB | 还原版/云端版构建、脱敏、接口表/客户端 |
| `cloud-server/` | ~1MB | 云端控制器：Flask 服务、Web 控制台、组件目录、演示数据生成器（运行时 JSON/assets 已忽略） |
| `src/main/java/` | 26MB | 反编译应用源码（含本次 7 个补丁类） |
| `src/main/res/` | 44MB | 布局、drawable、values、raw |
| `src/main/AndroidManifest.xml` | 56KB | 应用清单 |
| `src/main/*.properties`、`*.txt`、`*.json` | ~2MB | 资源/构建元数据 |
| `libs/app-r.jar` | 217KB | 补丁类编译需要的 R 常量 |

> `libs/original-classes.jar`、`app-classes.jar` 等编译 jar 含有原版硬编码凭据，**不随公开仓库发布**；本地构建时保留即可。公开仓库只放 `libs/app-r.jar`。

这些足够：

- 阅读完整应用源码、布局、接口；
- 阅读/修改补丁源码；本地构建另需自备原版 APK + 本地 `libs/original-classes.jar`；
- 用 `scripts/endpoints` 调 API；
- 运行 `scripts/secrets.py` 做发布检查。

## 2. 可选（大文件，建议 Git LFS / Release / 单独仓库）

| 路径 | 大小 | 不带会怎样 |
| --- | ---: | --- |
| `src/main/lib/` | 165MB | 原生库缺失；视频/人脸/串口等 native 功能不可用 |
| `src/main/assets/` | 71MB | 人脸模型、皮肤、字体缺失；人脸/部分 UI 资源不可用 |
| `vendor-src/` | 299MB | 第三方库源码缺失；不影响还原版补丁构建，但不利于完整审计 |
| `libs/original-classes.jar`、`app-classes.jar`、`app-support-classes.jar`、`app-patch-classes.jar`、`decompiled-libs.jar` | 100MB | **本地构建/实验用，含原版编译字节码和硬编码配置，不要公开上传** |
| `dist/智慧班牌-3.0.14-还原版.apk` | 185MB | 不能直接下载 APK；建议作为 GitHub Release 附件 |
| `dist/智慧班牌-3.0.14-云端版.apk` | 185MB | 云端控制器调试包；同样走 Release，不要进 git |

建议：

- `src/main/lib/`、`src/main/assets/`、`vendor-src/` 用 **Git LFS**，或打成 zip 放 Release；
- APK 不要进 git，直接：

```powershell
gh release create v3.0.14 `
  "dist\智慧班牌-3.0.14-还原版.apk" `
  --title "智慧班牌 3.0.14 还原版" `
  --notes "固定设备身份 + 8×6 真实布局 + 刷卡/离线快捷入口"
```

## 3. 绝对不要上传

| 路径 | 原因 |
| --- | --- |
| `_private/` | 脱敏备份 + `secrets.json`，含真实凭据 |
| 本地凭据清单（第三方 APPID/Key/Secret/账号） | 第三方 APPID/Key/Secret/账号 |
| `src/main/res/raw/server.key` | TLS/MQTT 私钥 |
| `src/main/assets/*.cert` | 人脸 SDK 证书 |
| `*.jks`、`*.keystore` | 签名私钥 |
| `libs/*.jar`（除 `app-r.jar`） | 编译后的原版类，含硬编码凭据 |
| `dist/*.apk` | 体积大，且已签名；走 Release |
| `build/`、`.gradle/`、`.idea/` | 构建/IDE 缓存 |
| `local.properties` | 本机 SDK 路径 |
| `scripts/endpoints/output/*.resolved.*`、`run-*.jsonl`、`forged-requests.json` | 含真实 token/响应 |
| `*.log`、`mock-server/requests.log` | 可能含账号/Token |

`.gitignore` 已经覆盖了大部分；上传前仍然执行：

```powershell
python scripts/secrets.py check
python scripts/secrets.py scrub
python scripts/secrets.py check
```

## 4. 推荐上传命令

```powershell
git init
git branch -M main

# 文档与构建
git add .gitignore README.md RESTORE.md ENDPOINTS.md GITHUB.md `
        build.gradle settings.gradle gradle.properties gradlew gradlew.bat `
        gradle proguard-rules.pro

# 脚本
git add scripts

# 源码与资源
git add src/main/java src/main/res src/main/AndroidManifest.xml
git add src/main/*.properties src/main/*.txt src/main/*.json

# 最小构建依赖
git add libs/app-r.jar

git status
git commit -m "feat: restore class board with real layout and verification shortcuts"
git remote add origin https://github.com/<user>/<repo>.git
git push -u origin main
```

确认 `git status` 里没有：

```text
_private/
*.apk
src/main/res/raw/server.key
src/main/assets/*.cert
scripts/endpoints/output/*.resolved.*
```

## 5. 如果确实要上传完整逆向工程

```powershell
git lfs install
git lfs track "vendor-src/**" "src/main/lib/**" "src/main/assets/**" "libs/*.jar"
git add .gitattributes
```

然后按第 4 节添加目录；注意 GitHub LFS 免费额度（1GB 存储/带宽）可能不够，建议把 `vendor-src/`、`src/main/lib/`、`src/main/assets/` 打成 `vendor-src.zip` 放 Release，而不是全部进 git。

## 6. 发布前最后检查

```powershell
python scripts/secrets.py check
git status --ignored
git diff --cached --stat
```

- 确认没有 `_private/`、真实账号、MAC、Android ID、Secret、证书、私钥；
- 确认 APK 只在 Release，不在 commit；

- 如果之前 push 过敏感内容，删除文件不够，需要 `git filter-repo` 清理历史并轮换凭据。
