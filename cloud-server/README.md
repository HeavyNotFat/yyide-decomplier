# 云端控制器

本地替代 `api.yyide.com`，并提供一个可视化控制台，用来编排首页卡片、编辑模块内容、覆盖接口响应。

## 启动

```powershell
python -m pip install -r cloud-server/requirements.txt
python cloud-server/server.py --port 8765
```

打开 <http://127.0.0.1:8765/admin>，账号 `demo / demo`。

## 连接班牌

```powershell
.\scripts\build-cloud-apk.ps1 -CloudUrl "http://10.0.2.2:8765"
adb install -r "dist\智慧班牌-3.0.15-云端版.apk"
```

模拟器用 `10.0.2.2`；真机用电脑局域网 IP，并重新构建 APK。

## 组件数据

控制台侧边栏「组件数据」把 293 个首页组件与它们读取的接口对应起来。可对任意组件：

- 查看它读取的接口、共用组件数；
- 勾选「启用自定义」编辑 JSON 响应；
- 载入默认模板 / 清除自定义；
- 手动添加任意接口；
- 一键补全所有组件的模拟数据。

## 目录

| 路径 | 说明 |
| --- | --- |
| `server.py` | Flask：班牌接口模拟 + 控制台 API |
| `store.py` | JSON 持久化、演示数据、班牌演示素材生成 |
| `data/catalog.json` | 293 个首页组件、90 个 Activity、257 个接口 |
| `data/*.json` | 站点/布局/内容/接口覆盖（首次启动生成） |
| `web/` | 控制台前端（无需构建） |
| `tools/extract_catalog.py` | 从反编译源码重新生成 catalog.json |

完整说明见 [../CLOUD.md](../CLOUD.md)。
