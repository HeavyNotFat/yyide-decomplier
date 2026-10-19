"""AI 助手（由 scripts/endpoints 生成）"""
from __future__ import annotations

from ..common import Endpoint

GROUP = "ai"
TITLE = "AI 助手"

ENDPOINTS = [
    Endpoint(
        id='ai-001',
        method='POST',
        path='/ai/assistant/get',
        params={},
        json_body={'id': 'assistant-1'},
        files=None,
        auth=True,
        base=None,
        description='AI 助手 / requestAIGetInfo',
        source='requestAIGetInfo',
    ),
    Endpoint(
        id='ai-002',
        method='POST',
        path='/ai/assistant/public/list',
        params={},
        json_body={},
        files=None,
        auth=True,
        base=None,
        description='AI 助手 / requestAIHomeList',
        source='requestAIHomeList',
    ),
    Endpoint(
        id='ai-003',
        method='POST',
        path='/ai/chat/models',
        params={},
        json_body={},
        files=None,
        auth=True,
        base=None,
        description='AI 助手 / requestAIModelList',
        source='requestAIModelList',
    ),
    Endpoint(
        id='ai-004',
        method='POST',
        path='/ai/chat/session/create',
        params={},
        json_body={'assistantId': 'assistant-1', 'userId': '{student_id}'},
        files=None,
        auth=True,
        base=None,
        description='AI 会话创建',
        source='requestAICreateSession',
    ),
]
