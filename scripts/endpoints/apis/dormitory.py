"""宿舍（由 scripts/endpoints 生成）"""
from __future__ import annotations

from ..common import Endpoint

GROUP = "dormitory"
TITLE = "宿舍"

ENDPOINTS = [
    Endpoint(
        id='dormitory-001',
        method='GET',
        path='/brand/brand/dormitory/dormitoryHomepage/detail',
        params={'id': '{brand_id}'},
        json_body=None,
        files=None,
        auth=True,
        base=None,
        description='宿舍 / requestHomeDormitoryDetail',
        source='requestHomeDormitoryDetail',
    ),
    Endpoint(
        id='dormitory-002',
        method='GET',
        path='/cloud/moralEducationActivityBrand/dormitory',
        params={'schoolId': '{school_id}', 'classesId': '{classes_id}'},
        json_body=None,
        files=None,
        auth=True,
        base=None,
        description='宿舍 / requestHomeDormitoryEducation',
        source='requestHomeDormitoryEducation',
    ),
]
