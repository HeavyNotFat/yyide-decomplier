"""活动与报名（由 scripts/endpoints 生成）"""
from __future__ import annotations

from ..common import Endpoint

GROUP = "activity"
TITLE = "活动与报名"

ENDPOINTS = [
    Endpoint(
        id='activity-001',
        method='POST',
        path='/brand/activity/enroll/activityEnrollInfo',
        params={},
        json_body={'activityId': '{activity_id}', 'userId': '{student_id}', 'identifyType': 0},
        files=None,
        auth=True,
        base=None,
        description='活动与报名 / requestLoginActiveDetails',
        source='requestLoginActiveDetails',
    ),
    Endpoint(
        id='activity-002',
        method='POST',
        path='/brand/activity/enroll/detail',
        params={},
        json_body={'activityId': '{activity_id}'},
        files=None,
        auth=True,
        base=None,
        description='活动与报名 / requestActiveDetails',
        source='requestActiveDetails',
    ),
    Endpoint(
        id='activity-003',
        method='POST',
        path='/brand/activity/enroll/page',
        params={},
        json_body={'pageNo': 1, 'pageSize': 10},
        files=None,
        auth=True,
        base=None,
        description='活动列表',
        source='requestActiveList',
    ),
    Endpoint(
        id='activity-004',
        method='POST',
        path='/brand/activity/enroll/userActivityEnroll',
        params={},
        json_body={'activityId': '{activity_id}', 'userId': '{student_id}', 'identifyType': 0, 'activitySubIds': []},
        files=None,
        auth=True,
        base=None,
        description='活动与报名 / requestActiveRegistration',
        source='requestActiveRegistration',
    ),
    Endpoint(
        id='activity-005',
        method='POST',
        path='/brand/activity/enroll/userEnrollPage',
        params={},
        json_body={'pageNo': 1, 'pageSize': 10, 'activityName': '', 'userId': '{student_id}'},
        files=None,
        auth=True,
        base=None,
        description='活动与报名 / requestMyRegistrationList',
        source='requestMyRegistrationList',
    ),
]
