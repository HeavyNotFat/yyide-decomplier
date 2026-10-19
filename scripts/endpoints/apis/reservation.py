"""场地预约与咨询（由 scripts/endpoints 生成）"""
from __future__ import annotations

from ..common import Endpoint

GROUP = "reservation"
TITLE = "场地预约与咨询"

ENDPOINTS = [
    Endpoint(
        id='reservation-001',
        method='GET',
        path='/cloud/employee/get',
        params={'id': '{brand_id}'},
        json_body=None,
        files=None,
        auth=True,
        base=None,
        description='场地预约与咨询 / requestEmployeeDetails',
        source='requestEmployeeDetails',
    ),
    Endpoint(
        id='reservation-002',
        method='POST',
        path='/cloud/employee/getEmployeeListByLabel',
        params={},
        json_body={'pageNo': 1, 'pageSize': 20},
        files=None,
        auth=True,
        base=None,
        description='场地预约与咨询 / requestConsultList',
        source='requestConsultList',
    ),
    Endpoint(
        id='reservation-003',
        method='POST',
        path='/cloud/siteBooking/bookingRecordPage',
        params={},
        json_body={'pageNo': 1, 'pageSize': 20, 'userId': '{student_id}', 'status': 0},
        files=None,
        auth=True,
        base=None,
        description='预约记录',
        source='requestReservationRecordList',
    ),
    Endpoint(
        id='reservation-004',
        method='GET',
        path='/cloud/siteBooking/get',
        params={'id': '{brand_id}'},
        json_body=None,
        files=None,
        auth=True,
        base=None,
        description='场地预约与咨询 / requestReservationRecordDetail',
        source='requestReservationRecordDetail',
    ),
    Endpoint(
        id='reservation-005',
        method='POST',
        path='/cloud/siteBooking/siteBookingBatchSign',
        params={},
        json_body={'siteBookingIds': ['{site_booking_id}'], 'userId': '{student_id}'},
        files=None,
        auth=True,
        base=None,
        description='场地预约与咨询 / requestReservationOfflineSign',
        source='requestReservationOfflineSign',
    ),
    Endpoint(
        id='reservation-006',
        method='POST',
        path='/cloud/siteBooking/siteBookingSign',
        params={},
        json_body={'siteBookingId': '{site_booking_id}', 'userId': '{student_id}'},
        files=None,
        auth=True,
        base=None,
        description='场地预约与咨询 / requestReservationSign',
        source='requestReservationSign',
    ),
]
