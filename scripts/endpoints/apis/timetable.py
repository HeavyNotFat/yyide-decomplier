"""课表（由 scripts/endpoints 生成）"""
from __future__ import annotations

from ..common import Endpoint

GROUP = "timetable"
TITLE = "课表"

ENDPOINTS = [
    Endpoint(
        id='timetable-001',
        method='POST',
        path='/brand/class-brand-management/android/course/classSchedule',
        params={},
        json_body={},
        files=None,
        auth=True,
        base=None,
        description='课表 / UserTable',
        source='UserTable',
    ),
    Endpoint(
        id='timetable-002',
        method='POST',
        path='/brand/class-brand-management/android/course/classSchedule',
        params={},
        json_body={},
        files=None,
        auth=True,
        base=None,
        description='课表 / getClassSchedule',
        source='getClassSchedule',
    ),
    Endpoint(
        id='timetable-003',
        method='POST',
        path='/cloud/app/timetable/getWeekTime',
        params={},
        json_body={'weekTime': '', 'typeId': '{classes_id}', 'type': '1'},
        files=None,
        auth=True,
        base=None,
        description='班级/教师/学生课表',
        source='getCDKB',
    ),
    Endpoint(
        id='timetable-004',
        method='POST',
        path='/cloud/app/timetable/getWeekTime',
        params={},
        json_body={'weekTime': '', 'typeId': '{classes_id}', 'type': '1'},
        files=None,
        auth=True,
        base=None,
        description='班级/教师/学生课表',
        source='requestCourseList',
    ),
    Endpoint(
        id='timetable-005',
        method='POST',
        path='/cloud/app/timetable/getWeekTime',
        params={},
        json_body={'weekTime': '', 'typeId': '{classes_id}', 'type': '1'},
        files=None,
        auth=True,
        base=None,
        description='班级/教师/学生课表',
        source='getCDKB',
    ),
    Endpoint(
        id='timetable-006',
        method='POST',
        path='/timetable/cloud-timetable/v1/kcb/classes',
        params={'bjid': '{classes_id}', 'skzc': '1'},
        json_body=None,
        files=None,
        auth=True,
        base=None,
        description='课表 / getKB',
        source='getKB',
    ),
]
