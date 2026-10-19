"""外部/手工调用接口（真实地址，不是 Retrofit 222 的一部分）。

- AI SSE：https://api.yyide.com/ai/chat/completion/stream
- 旧相册/视频：https://api.yyide.com/brand/...
- 腾讯云 IM REST：https://console.tim.qq.com/v4/...
"""
from __future__ import annotations

from ..common import Endpoint

GROUP = "external"
TITLE = "外部/手工接口"


ENDPOINTS = [
    Endpoint(
        id="external-001",
        method="POST",
        path="/ai/chat/completion/stream",
        json_body={"sessionId": "{session_id}", "prompt": "{prompt}"},
        auth=True,
        client="yide",
        description="AI 流式对话（text/event-stream）",
        source="network/base/SSEClient",
        headers={"Accept": "text/event-stream"},
        stream=True,
    ),
    Endpoint(
        id="external-002",
        method="POST",
        path="/brand/brand/album/list",
        json_body={"classesId": "{classes_id}", "kind": "1", "type": "1", "limitNum": 10},
        auth=True,
        client="yide",
        description="旧相册列表（HttpUtils.post）",
        source="net/MachineIpService",
    ),
    Endpoint(
        id="external-003",
        method="POST",
        path="/brand/brand/album/listDetail",
        json_body={"classesId": "{classes_id}", "kind": "1", "type": "1"},
        auth=True,
        client="yide",
        description="旧相册详情（HttpUtils.post）",
        source="net/MachineIpService",
    ),
    Endpoint(
        id="external-004",
        method="POST",
        path="/brand/class-brand-management/android/videoalbum/list",
        json_body={"classesId": "{classes_id}", "pageNo": 1, "pageSize": 20},
        auth=True,
        client="yide",
        description="旧视频列表（HttpUtils2.post）",
        source="net/MachineIpService2",
    ),
    Endpoint(
        id="external-005",
        method="POST",
        path="/v4/openim/get_c2c_unread_msg_num",
        base="https://console.tim.qq.com",
        params={
            "sdkappid": "{tim_sdkappid}",
            "identifier": "{tim_admin_identifier}",
            "usersig": "{tim_admin_usersig}",
            "random": "{random}",
            "contenttype": "json",
        },
        json_body={"To_Account": "{student_id}"},
        auth=False,
        client="external",
        description="腾讯云 IM：查询单聊未读数（需要管理员 UserSig）",
        source="MainActivity.getStudentMsg",
        executable=False,
    ),
]
