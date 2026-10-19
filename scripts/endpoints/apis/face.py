"""人脸同步（FacePass）真实接口，base = https://api.yyide.com。"""
from __future__ import annotations

from ..common import Endpoint

GROUP = "face"
TITLE = "人脸同步（FacePass）"


def _ep(ep_id: str, path: str, description: str, body: dict) -> Endpoint:
    return Endpoint(
        id=ep_id,
        method="POST",
        path=path,
        json_body=body,
        auth=True,
        client="yide",
        description=description,
        source="com/yyide/facepass/network/INetworkService",
    )


ENDPOINTS = [
    _ep("face-001", "/cloud/device/face-sync/sync-page", "分页拉取人脸", {
        "schoolId": "{school_id}", "deviceNo": "{mac}", "pageNo": 1, "pageSize": 100,
    }),
    _ep("face-002", "/cloud/device/face-sync/sync-all", "全量同步人脸", {
        "schoolId": "{school_id}", "deviceNo": "{mac}",
    }),
    _ep("face-003", "/cloud/device/face-sync/batch-update-status", "批量更新同步状态", {
        "schoolId": "{school_id}", "deviceNo": "{mac}", "list": [],
    }),
    _ep("face-004", "/cloud/v2/machine/updateApkVersion", "上报 APK 版本", {
        "deviceNo": "{mac}", "version": "3.0.14",
    }),
]
