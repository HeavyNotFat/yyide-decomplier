"""文件上传与日志（由 scripts/endpoints 生成）"""
from __future__ import annotations

from ..common import Endpoint

GROUP = "upload"
TITLE = "文件上传与日志"

ENDPOINTS = [
    Endpoint(
        id='upload-001',
        method='POST',
        path='/app/file/upload',
        params={},
        json_body=None,
        files={'file': '{file}'},
        auth=True,
        base=None,
        description='文件上传（multipart）',
        source='upload',
    ),
    Endpoint(
        id='upload-002',
        method='POST',
        path='/app/file/upload',
        params={},
        json_body=None,
        files={'file': '{file}'},
        auth=True,
        base=None,
        description='文件上传（multipart）',
        source='upload',
    ),
    Endpoint(
        id='upload-003',
        method='POST',
        path='/file/upload/path',
        params={},
        json_body=None,
        files={'file': '{file}'},
        auth=True,
        base=None,
        description='日志上传（multipart）',
        source='uploadLogFile',
    ),
]
