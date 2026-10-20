# 3.0.15 有什么新功能？

**结论：没有新增功能。** 3.0.15 是 3.0.14 的小型维护/修复版本；没有新页面、
新菜单、新接口、新权限，也没有新增业务字段或组件。

详细的逐类、逐资源证据见 [DIFF-3.0.14-to-3.0.15.md](DIFF-3.0.14-to-3.0.15.md)。

---

## 一眼看完

| 变化 | 类型 | 影响 |
| --- | --- | --- |
| WiFi 图标按信号等级显示；断网/无 NetworkInfo 时显示断网图标 | 修复 | 顶部网络状态更准确 |
| `top_layout.xml` 的 WiFi 图标固定 48dp、补默认图 `@drawable/wifi` | UI 修复 | 不再出现空白/尺寸跳变 |
| **删除**顶部 WiFi/日历点击进入 `TeacherCheackActivity` | 行为/安全 | 现场“点 WiFi/日历进教师端”的操作失效；齿轮入口仍在 |
| `AppClient` / `BaseNetworkApi` 增加 BODY 级 HTTP 日志 | 调试代码回归 | **正式包也会把 token、密码、学生数据写入 Logcat** |
| 视频页 `onResume` 增加 10 秒防抖 | 性能/修复 | 10 秒内返回视频页不重复请求 |
| 轮播/屏保补 `setSlideShowNotificationBar(false)` | 修复 | 通知栏也一起隐藏 |
| `NetWorkManager` 改静态内部类单例，`remove()` 简化 | 重构 | 行为等价 |
| 相册二级列表、窗口点击增加日志；新增未使用的 `getDensityDpi` | 调试/预留 | 无功能影响 |
| 删除空的 `sendFaceSync()` | 清理 | 无功能影响 |

---

## 数字

- APK 文件清单：4,857 → 4,857（完全一致）
- `assets`：逐文件完全一致
- `res`：只有 `layout/top_layout.xml` 一个文件不同
- Manifest：组件/权限集合完全一致
- smali 类：44,999 → 45,000（+1）
- 真实变更的应用类：**13 个**
- 新增类：3 个（日志拦截器、`AppClient$2`、`NetWorkManagerHolder`）
- 删除类：2 个（`MainActivity_ViewBinding$9/$10`）
- 新增接口/端点：**0**
- `versionName`：3.0.14 → 3.0.15；`versionCode`：**仍为 3002**

---

## 最需要注意的两件事

1. **BODY 日志**：3.0.15 在 release 包中启用了
   `HttpLoggingInterceptor.Level.BODY`，会把完整请求/响应（含
   `Authorization`、账号密码、学生数据）打到 Logcat。这是调试代码误入正式版，
   现场使用前应移除或加 `BuildConfig.DEBUG` 条件。
2. **隐藏教师入口被删**：3.0.14 点顶部 WiFi 图标或日期区会进入
   `TeacherCheackActivity`；3.0.15 删除了这两个 `@OnClick`。
   仍可点齿轮（`R.id.img_set` / `R.id.layout_setting`）进入，或使用本仓库
   `RestoreVerificationRouter` 的全 8 卡号/`1145`/`1024` 入口。
