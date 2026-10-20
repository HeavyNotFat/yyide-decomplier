# 还原版说明

> 文档导航：[README.md](README.md) · [ENDPOINTS.md](ENDPOINTS.md) · [scripts/endpoints/README.md](scripts/endpoints/README.md) · [GITHUB.md](GITHUB.md)

产物：`dist/智慧班牌-3.0.14-还原版.apk`
包名 / 版本：`com.yd.android_brand_mvp` / `3.0.14 (3002)`

## 改了什么

| 源码 | 改动 |
| --- | --- |
| `BaseApplication.java` | `getMac()` 固定为真实班牌 MAC |
| `LoginPresenter.java` | `/brand/obtain` 的 `seriaNo` 固定为真实 Android ID |
| `verfity/RestoreVerificationRouter.java` | 刷卡/离线快捷入口 |
| `CardFragment3/4.java`、`CardFragment.java` | 全 8 卡号 / `1234567890` 分流 |
| `VerificationCodeFragment.java` | 离线码 `1145` / `1024` 分流 |

真实 MAC / Android ID 不写入文档；发布前由 `scripts/secrets.py` 脱敏。

## 快捷入口

| 输入 | 页面 |
| --- | --- |
| 卡号全是 `8`（如 `8888888888`） | 教师端 `SettingActivity` / `SettingPActivity` |
| 离线码 `1145` | 教师端 |
| 卡号 `1234567890` | 学生空间 `UserCenterActivity` |
| 离线码 `1024` | 学生空间 |

其它输入保持原版服务端查卡/随机码校验。学生空间使用本地“测试学生”身份，服务端无此学生时业务数据显示“暂无数据”。

## 首页布局

`POST /brand/brand/layoutclasssign/layoutlist` 返回 **8 列 × 6 行**：

| 模块 | tag | x | y | w | h |
| --- | --- | ---: | ---: | ---: | ---: |
| 泡泡消息/场地提示 | `hbcdxx21` | 0 | 0 | 2 | 1 |
| 通知公告 | `hbtzgg25` | 0 | 1 | 2 | 5 |
| 班级信息 | `hbbjxx22` | 2 | 0 | 2 | 2 |
| 荣誉墙 | `hbryq22` | 4 | 0 | 2 | 2 |
| 班级相册 | `hbbjxc23` | 6 | 0 | 2 | 3 |
| 校园相册 | `hbxjxc44` | 2 | 2 | 4 | 4 |
| 校园视频 | `hbxjsp23` | 6 | 3 | 2 | 3 |

首页仍由原版 `HomeFragment` 按 tag 选择 Fragment、按 x/y/w/h 放入栅格；服务端改布局无需改 APK。

## 构建

```powershell
# 如果执行过脱敏，先恢复本地凭据/源码
python scripts/secrets.py restore

.\scripts\build-restore-apk.ps1 `
  -BaseApk "D:\path\to\智慧班牌_3.0.14.apk"
```

流程：`javac`（7 个补丁类）→ `d8` → 注入 patch `classes.dex` → 原 dex 后移 → `zipalign` → `apksigner`。

> 完整源码 Gradle 重建（`-PuseDecompiledClasses`）能出包，但 ECJ 恢复的库类启动时会抛 `Unresolved compilation problems`，正式出包用“原版字节码 + 补丁类”。

## 验证

- Android 15 x86_64 模拟器，1920×1200；
- 登录后 7 个模块全部加载，强杀重启自动登录；
- 全 8 卡号 / `1145` → 教师端设置页；
- `1234567890` / `1024` → 学生空间（显示“测试学生 / 高一6班”）；


## 注意

- APK 使用 Android Debug 签名，原版是 `CN=ChenHao`，安装前需卸载原版；
- 换班牌/账号时改源码里的 MAC/Android ID 后重新构建；
- 发布前运行 `python scripts/secrets.py scrub`，不要把设备身份、账号、服务器密钥推到 GitHub。
