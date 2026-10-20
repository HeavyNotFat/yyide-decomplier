"""BrandClient: typed methods for every endpoint (real environment).

The constructor logs in, resolves context ids and then exposes one method per
endpoint.  Every method has explicit keyword-only parameters, so IDEs show the
JSON/Query/Form fields while typing; each docstring lists required fields, the
context placeholders they come from, and an example call.

Generated blocks are maintained by "python -m scripts.endpoints.gen_client".
Edit the generator (scripts/endpoints/gen_client.py), not the generated blocks.

Example:
    from scripts.endpoints.client import BrandClient
    from scripts.endpoints.schemas import SchoolGetNewLayoutListBody

    c = BrandClient('<账号>', '<密码>', mac='__SEC_DEVICE_MAC_E8635151__')
    layout = c.school_get_new_layout_list(id=c.context['brand_id'])
    print(layout)

    # The TypedDict also gives IDE completion inside a JSON dict literal.
    body: SchoolGetNewLayoutListBody = {"id": c.context["brand_id"]}
    layout = c.school_get_new_layout_list(body=body)
"""
from __future__ import annotations

import copy
import re
from collections.abc import Mapping
from typing import Any, Dict, List, Optional

from .apis import all_endpoints
from .common import ApiClient, ApiError, Endpoint, render
from .credentials import load_settings

_ENDPOINTS = {ep.id: ep for ep in all_endpoints()}
_PATH_KEYS = {
    endpoint_id: set(re.findall(r"\{([a-zA-Z_][\w]*)\}", endpoint.path))
    for endpoint_id, endpoint in _ENDPOINTS.items()
}

# <generated: schema imports>
from .schemas import (
    SYNTHETIC_FIELDS, AuthGetBrandObtainBody, AuthGetBrandInfoBody, DeviceUpdateApkVersionBody,
    DeviceGetNewestVersion2Body, DeviceGetOrBindingDeviceBody, DeviceGetActivationCodeBody,
    DeviceGetActivationCode2Body, DeviceGetRegistrationCodeBody,
    DeviceGetRegistrationCode2Body, DeviceUpdateNewRegistrationCodeByCodeBody,
    DeviceUpdateNewRegistrationCodeByCode2Body, DeviceGetBrandRegistrationCodeBody,
    DeviceGetBrandRegistrationCode2Body, SchoolGetWatchWordBody, SchoolGetWatchWord2Body,
    SchoolGetNewLayoutListBody, HomeGetHomeVideoBody, HomeGetNewClassPhotoListBody,
    HomeGetNewPhotoListBody, HomeGetNewStudentWorkListBody, HomeSetNewWorkCommentBody,
    HomeGetPhotoAlbumTablistBody, HomeGetNewTaskListBody,
    MessagesGetMessageDominateScreenListBody, MessagesRequestMessageDominateScreenListBody,
    MessagesGetNewNoticeWithPagBody, MessagesRequestMessageBody,
    MessagesRequestMessageListBody, TimetableGetCDKBBody, TimetableRequestCourseListBody,
    TimetableGetCDKB2Body, AttendanceBrandAttendanceClockItem,
    AttendanceBrandAttendanceClockBody, AttendanceGetAttendanceSiteTimetableBody,
    AttendanceQueryBrandAttendanceByAttendanceTimeIdBody, AttendanceRequestAttendanceBody,
    AttendanceListToDayDetailBody, AttendanceRequestMyTaskListBody, CardVerifyTeacherLoginBody,
    CardSelectNewStudentByIcCardBody, CardSelectNewStudentByIcCard2Body,
    CardSelectNewTeacherByClassesIdBody, CardSelectNewTeacherByIcCardBody,
    CardSelectTeacherInfoByCardOrFaceBody, CardSelectNewUserInfoByIcCardBody,
    CardSelectUserByCardOrFaceBody, CardSelectTeacherByIcCardBody,
    CardSelectStudentByIcCardBody, CardPauschCardBody, UserspaceRequestLeaveLengthBody,
    UserspaceRequestRepairListBody, UserspaceRequestRevokeLeaveBody,
    UserspaceRequestStudentLeaveProcessBody, UserspaceRequestLeaveRecordBody,
    UserspaceRequestSubmitStudentLeaveBody, UserspaceGetApproverBody,
    UserspaceAskForLeaveRecordBandListBody, UserspaceRequestAddCommentsBody,
    UserspaceAddLeaveBody, UserspaceAllStudentsBody, ActivityRequestLoginActiveDetailsBody,
    ActivityRequestActiveDetailsBody, ActivityRequestActiveListBody,
    ActivityRequestActiveRegistrationBody, ActivityRequestMyRegistrationListBody,
    HonorRequestEvaluationMedalDetailsBody, HonorRequestEvaluationMedalPageListBody,
    HonorRequestEvaluationPointCardDetailsBody, HonorRequestEvaluationPointCardPageListBody,
    HonorRequestEvaluationPointPageListBody, HonorRequestHonorWallListBody,
    HonorRequestActiveDetailBody, HonorRequestIdentityDetailBody,
    HonorRequestActiveHonorListBody, HonorRequestActiveResultListBody,
    HonorRequestKidsHonorListBody, HonorRequestClassHonorListBody,
    HonorRequestStudentHonorListBody, ExamRequestUserExamListBody, ExamRequestExamDetailBody,
    ExamRequestExamPersonSeatBody, ExamRequestTodayExamBody, ExamRequestSignExamBody,
    LibraryRequestLibrarySearchBody, LibraryRequestLibraryBookSituationBody,
    ReservationRequestConsultListBody, ReservationRequestReservationRecordListBody,
    ReservationRequestReservationOfflineSignBody, ReservationRequestReservationSignBody,
    PatrolRequestSubmitPatrolBody, PatrolRequestPatrolListBody,
    PatrolRequestUpdatePatrolPunchBody, PatrolRequestPatrolPunchBody,
    VoteRequestFormDetailBody, VoteRequestCollectSituationBody, VoteRequestCollectListBody,
    VoteRequestSubmitFormContentBody, VoteRequestSubmitVoteBody, VoteRequestVoteDetailBody,
    VoteRequestHomeVoteListBody, AiRequestAIGetInfoBody, AiRequestAICreateSessionBody,
    IotRequestRTSPPathBody, IotRequestRecordsBody,
    IotRequestSynchronizeStatusFaceExtractionBody, IotRequestFaceConfigBody,
    FaceCloudDeviceFaceSyncSyncPageBody, FaceCloudDeviceFaceSyncSyncAllBody,
    FaceCloudDeviceFaceSyncBatchUpdateStatusBody, FaceCloudV2MachineUpdateapkversionBody,
    ExternalAiChatCompletionStreamBody, ExternalBrandBrandAlbumListBody,
    ExternalBrandBrandAlbumListdetailBody,
    ExternalBrandClassBrandManagementAndroidVideoalbumListBody,
    ExternalV4OpenimGetC2cUnreadMsgNumBody,
)
# </generated: schema imports>


class BrandClient(ApiClient):
    """Real-environment client with one typed method per API endpoint.

    The constructor logs in with the supplied account/password; every method
    returns the response data field (use full=True for the complete envelope).

    Each generated method documents its parameters in the docstring:

    * 必填 - pass the value or put it in client.context before the call.
    * 自动 - filled by login / /brand/obtain / credentials / context.
    * 可选 - the endpoint template default is used when omitted.

    JSON bodies can also be passed whole through the typed body= keyword; the
    matching TypedDict lives in scripts/endpoints/schemas.py and gives IDE key
    completion.  Undocumented fields can be passed through **extra.
    """

    # <generated: index>
    endpoint_ids = [
        "auth-001", "auth-002", "auth-003", "auth-004",
        "auth-005", "auth-006", "auth-007", "auth-008",
        "auth-009", "device-001", "device-002", "device-003",
        "device-004", "device-005", "device-006", "device-007",
        "device-008", "device-009", "device-010", "device-011",
        "device-012", "device-013", "device-014", "device-015",
        "device-016", "device-017", "device-018", "school-001",
        "school-002", "school-003", "school-004", "school-005",
        "school-006", "school-007", "school-008", "school-009",
        "school-010", "school-011", "school-012", "school-013",
        "school-014", "school-015", "school-016", "school-017",
        "school-018", "school-019", "home-001", "home-002",
        "home-003", "home-004", "home-005", "home-006",
        "home-007", "home-008", "home-009", "home-010",
        "home-011", "home-012", "home-013", "home-014",
        "home-015", "messages-001", "messages-002", "messages-003",
        "messages-004", "messages-005", "messages-006", "messages-007",
        "messages-008", "messages-009", "messages-010", "messages-011",
        "messages-012", "timetable-001", "timetable-002", "timetable-003",
        "timetable-004", "timetable-005", "timetable-006", "attendance-001",
        "attendance-002", "attendance-003", "attendance-004", "attendance-005",
        "attendance-006", "attendance-007", "attendance-008", "attendance-009",
        "attendance-010", "attendance-011", "attendance-012", "attendance-013",
        "attendance-014", "attendance-015", "attendance-016", "attendance-017",
        "attendance-018", "card-001", "card-002", "card-003",
        "card-004", "card-005", "card-006", "card-007",
        "card-008", "card-009", "card-010", "card-011",
        "userspace-001", "userspace-002", "userspace-003", "userspace-004",
        "userspace-005", "userspace-006", "userspace-007", "userspace-008",
        "userspace-009", "userspace-010", "userspace-011", "userspace-012",
        "userspace-013", "userspace-014", "userspace-015", "userspace-016",
        "userspace-017", "userspace-018", "userspace-019", "userspace-020",
        "userspace-021", "userspace-022", "userspace-023", "userspace-024",
        "userspace-025", "userspace-026", "activity-001", "activity-002",
        "activity-003", "activity-004", "activity-005", "honor-001",
        "honor-002", "honor-003", "honor-004", "honor-005",
        "honor-006", "honor-007", "honor-008", "honor-009",
        "honor-010", "honor-011", "honor-012", "honor-013",
        "honor-014", "honor-015", "honor-016", "honor-017",
        "honor-018", "honor-019", "honor-020", "honor-021",
        "honor-022", "honor-023", "honor-024", "honor-025",
        "honor-026", "exam-001", "exam-002", "exam-003",
        "exam-004", "exam-005", "exam-006", "library-001",
        "library-002", "library-003", "library-004", "library-005",
        "library-006", "library-007", "library-008", "library-009",
        "library-010", "library-011", "reservation-001", "reservation-002",
        "reservation-003", "reservation-004", "reservation-005", "reservation-006",
        "patrol-001", "patrol-002", "patrol-003", "patrol-004",
        "patrol-005", "patrol-006", "vote-001", "vote-002",
        "vote-003", "vote-004", "vote-005", "vote-006",
        "vote-007", "vote-008", "vote-009", "vote-010",
        "dormitory-001", "dormitory-002", "ai-001", "ai-002",
        "ai-003", "ai-004", "upload-001", "upload-002",
        "upload-003", "iot-001", "iot-002", "iot-003",
        "iot-004", "iot-005", "iot-006", "iot-007",
        "iot-008", "iot-009", "ttlock-001", "ttlock-002",
        "ttlock-003", "ttlock-004", "ttlock-005", "ttlock-006",
        "ttlock-007", "ttlock-008", "ttlock-009", "ttlock-010",
        "ttlock-011", "ttlock-012", "ttlock-013", "ttlock-014",
        "ttlock-015", "ttlock-016", "ttlock-017", "ttlock-018",
        "ttlock-019", "ttlock-020", "ttlock-021", "ttlock-022",
        "ttlock-023", "ttlock-024", "ttlock-025", "ttlock-026",
        "face-001", "face-002", "face-003", "face-004",
        "external-001", "external-002", "external-003", "external-004",
        "external-005",
    ]

    method_index = {
        "auth_new_login": "auth-001",
        "auth_get_check_login_qr_code": "auth-002",
        "auth_request_qr_code_check": "auth-003",
        "auth_get_login_qr_code": "auth-004",
        "auth_request_qr_code": "auth-005",
        "auth_login": "auth-006",
        "auth_get_site_by_user_name": "auth-007",
        "auth_get_brand_obtain": "auth-008",
        "auth_get_brand_info": "auth-009",
        "device_get_newest_version": "device-001",
        "device_query_classific_list": "device-002",
        "device_one_key_school": "device-003",
        "device_classes_over_info": "device-004",
        "device_switch_new_list": "device-005",
        "device_update_apk_version": "device-006",
        "device_inset_version_updated_school": "device-007",
        "device_get_newest_version_2": "device-008",
        "device_get_or_binding_device": "device-009",
        "device_get_activation_code": "device-010",
        "device_get_activation_code_2": "device-011",
        "device_get_registration_code": "device-012",
        "device_get_registration_code_2": "device-013",
        "device_update_new_registration_code_by_code": "device-014",
        "device_update_new_registration_code_by_code_2": "device-015",
        "device_get_brand_registration_code": "device-016",
        "device_get_brand_registration_code_2": "device-017",
        "device_request_device_config": "device-018",
        "school_request_area_info": "school-001",
        "school_school_style": "school-002",
        "school_teachers": "school-003",
        "school_select_new_classes_info": "school-004",
        "school_get_classes_info": "school-005",
        "school_get_watch_word": "school-006",
        "school_get_watch_word_2": "school-007",
        "school_get_new_countdown_list": "school-008",
        "school_request_dominate_screen_level": "school-009",
        "school_get_new_layout_list": "school-010",
        "school_new_remind": "school-011",
        "school_get_semester_time": "school-012",
        "school_select_classes_info": "school-013",
        "school_request_dominate_screen_level_2": "school-014",
        "school_request_custom_dominate_screen_list": "school-015",
        "school_get_school_calendar": "school-016",
        "school_select_school_calendar": "school-017",
        "school_request_site_info": "school-018",
        "school_get_classes_info_2": "school-019",
        "home_get_weather": "home-001",
        "home_get_home_video": "home-002",
        "home_get_new_class_photo_list": "home-003",
        "home_get_new_photo_list": "home-004",
        "home_get_new_student_duty": "home-005",
        "home_get_new_student_work_list": "home-006",
        "home_select_new_student_info": "home-007",
        "home_set_new_work_comment": "home-008",
        "home_set_new_work_like": "home-009",
        "home_get_duty_week_list": "home-010",
        "home_get_photo_album_tablist": "home-011",
        "home_get_student_duty": "home-012",
        "home_get_new_weather_list": "home-013",
        "home_get_new_weather": "home-014",
        "home_get_new_task_list": "home-015",
        "messages_get_message_dominate_screen_list": "messages-001",
        "messages_request_message_dominate_screen_list": "messages-002",
        "messages_request_message_home": "messages-003",
        "messages_get_new_notice_with_pag": "messages-004",
        "messages_request_message": "messages-005",
        "messages_request_message_list": "messages-006",
        "messages_get_captions_notice_info": "messages-007",
        "messages_request_home_caption": "messages-008",
        "messages_get_user_sig": "messages-009",
        "messages_get_user_sig_2": "messages-010",
        "messages_get_system_sign": "messages-011",
        "messages_get_user_sig_by_user_id": "messages-012",
        "timetable_user_table": "timetable-001",
        "timetable_get_class_schedule": "timetable-002",
        "timetable_get_c_d_k_b": "timetable-003",
        "timetable_request_course_list": "timetable-004",
        "timetable_get_c_d_k_b_2": "timetable-005",
        "timetable_get_k_b": "timetable-006",
        "attendance_brand_attendance_clock": "attendance-001",
        "attendance_get_attence_k_b": "attendance-002",
        "attendance_get_attendance_site_timetable": "attendance-003",
        "attendance_attendlist": "attendance-004",
        "attendance_get_brand_attendance_user": "attendance-005",
        "attendance_query_brand_attendance_by_attendance_time_id": "attendance-006",
        "attendance_request_attendance": "attendance-007",
        "attendance_list_to_day_detail": "attendance-008",
        "attendance_request_add_task": "attendance-009",
        "attendance_request_delete_task": "attendance-010",
        "attendance_request_update_task": "attendance-011",
        "attendance_request_task_list": "attendance-012",
        "attendance_request_task_detail": "attendance-013",
        "attendance_request_my_task_list": "attendance-014",
        "attendance_request_sign_task": "attendance-015",
        "attendance_query_brand_attendance_by_class_ids": "attendance-016",
        "attendance_attendance": "attendance-017",
        "attendance_get_attencelist": "attendance-018",
        "card_verify_teacher_login": "card-001",
        "card_select_new_student_by_ic_card": "card-002",
        "card_select_new_student_by_ic_card_2": "card-003",
        "card_select_new_teacher_by_classes_id": "card-004",
        "card_select_new_teacher_by_ic_card": "card-005",
        "card_select_teacher_info_by_card_or_face": "card-006",
        "card_select_new_user_info_by_ic_card": "card-007",
        "card_select_user_by_card_or_face": "card-008",
        "card_select_teacher_by_ic_card": "card-009",
        "card_select_student_by_ic_card": "card-010",
        "card_pausch_card": "card-011",
        "userspace_request_leave_length": "userspace-001",
        "userspace_request_student_leave_form": "userspace-002",
        "userspace_request_repair_list": "userspace-003",
        "userspace_request_leave_detail": "userspace-004",
        "userspace_request_revoke_leave": "userspace-005",
        "userspace_request_student_leave_process": "userspace-006",
        "userspace_request_leave_record": "userspace-007",
        "userspace_request_submit_student_leave": "userspace-008",
        "userspace_request_form_modify": "userspace-009",
        "userspace_request_leave_type_option": "userspace-010",
        "userspace_get_address_book": "userspace-011",
        "userspace_delete_instance": "userspace-012",
        "userspace_request_old_revoke_leave": "userspace-013",
        "userspace_get_approver": "userspace-014",
        "userspace_get_approver_info": "userspace-015",
        "userspace_request_old_leave_detail": "userspace-016",
        "userspace_ask_for_leave_record_band_list": "userspace-017",
        "userspace_request_repair_form": "userspace-018",
        "userspace_request_add_comments": "userspace-019",
        "userspace_request_comments_delete": "userspace-020",
        "userspace_request_comments_detail": "userspace-021",
        "userspace_get_leave_word_setting": "userspace-022",
        "userspace_request_comments_list": "userspace-023",
        "userspace_add_leave": "userspace-024",
        "userspace_all_students": "userspace-025",
        "userspace_leave_commit": "userspace-026",
        "activity_request_login_active_details": "activity-001",
        "activity_request_active_details": "activity-002",
        "activity_request_active_list": "activity-003",
        "activity_request_active_registration": "activity-004",
        "activity_request_my_registration_list": "activity-005",
        "honor_request_evaluation_medal_details": "honor-001",
        "honor_request_evaluation_medal_type_list": "honor-002",
        "honor_request_evaluation_medal_page_list": "honor-003",
        "honor_request_evaluation_list": "honor-004",
        "honor_request_evaluation_point_details": "honor-005",
        "honor_request_evaluation_point_card_details": "honor-006",
        "honor_request_evaluation_point_card_page_list": "honor-007",
        "honor_request_evaluation_point_page_list": "honor-008",
        "honor_request_honor_wall_list": "honor-009",
        "honor_request_active_detail": "honor-010",
        "honor_request_go_to_score": "honor-011",
        "honor_request_identity_detail": "honor-012",
        "honor_request_active_honor_list": "honor-013",
        "honor_request_activity_cycle": "honor-014",
        "honor_request_class_score_result": "honor-015",
        "honor_request_active_result_list": "honor-016",
        "honor_request_class_score_comment": "honor-017",
        "honor_request_student_score_comment": "honor-018",
        "honor_request_kids_honor_list": "honor-019",
        "honor_request_class_honor_list": "honor-020",
        "honor_request_student_honor_list": "honor-021",
        "honor_goto_score": "honor-022",
        "honor_request_daily_score_details": "honor-023",
        "honor_request_class_me": "honor-024",
        "honor_request_scoring_rubric": "honor-025",
        "honor_security_check": "honor-026",
        "exam_request_user_exam_list": "exam-001",
        "exam_request_exam_detail": "exam-002",
        "exam_request_exam_person_seat": "exam-003",
        "exam_request_week_exam": "exam-004",
        "exam_request_today_exam": "exam-005",
        "exam_request_sign_exam": "exam-006",
        "library_get_book_msg_assets": "library-001",
        "library_get_book_msg": "library-002",
        "library_search_book": "library-003",
        "library_get_tops": "library-004",
        "library_request_library_classify_list": "library-005",
        "library_request_library_search": "library-006",
        "library_request_library_book_situation": "library-007",
        "library_request_library_type_list": "library-008",
        "library_request_hot_list": "library-009",
        "library_request_library_new_list": "library-010",
        "library_request_library_list": "library-011",
        "reservation_request_employee_details": "reservation-001",
        "reservation_request_consult_list": "reservation-002",
        "reservation_request_reservation_record_list": "reservation-003",
        "reservation_request_reservation_record_detail": "reservation-004",
        "reservation_request_reservation_offline_sign": "reservation-005",
        "reservation_request_reservation_sign": "reservation-006",
        "patrol_request_submit_patrol": "patrol-001",
        "patrol_request_patrol_detail": "patrol-002",
        "patrol_request_patrol_list": "patrol-003",
        "patrol_request_update_patrol_punch": "patrol-004",
        "patrol_request_patrol_punch": "patrol-005",
        "patrol_request_scan_qr_code_status": "patrol-006",
        "vote_request_form_detail": "vote-001",
        "vote_request_collect_situation": "vote-002",
        "vote_request_collect_list": "vote-003",
        "vote_request_submit_form_content": "vote-004",
        "vote_request_home_collect_list": "vote-005",
        "vote_request_teacher_dept_list": "vote-006",
        "vote_request_student_classes": "vote-007",
        "vote_request_submit_vote": "vote-008",
        "vote_request_vote_detail": "vote-009",
        "vote_request_home_vote_list": "vote-010",
        "dormitory_request_home_dormitory_detail": "dormitory-001",
        "dormitory_request_home_dormitory_education": "dormitory-002",
        "ai_request_a_i_get_info": "ai-001",
        "ai_request_a_i_home_list": "ai-002",
        "ai_request_a_i_model_list": "ai-003",
        "ai_request_a_i_create_session": "ai-004",
        "upload_upload": "upload-001",
        "upload_upload_2": "upload-002",
        "upload_upload_log_file": "upload-003",
        "iot_list_swk": "iot-001",
        "iot_save_swk": "iot-002",
        "iot_request_r_t_s_p_path": "iot-003",
        "iot_request_records": "iot-004",
        "iot_request_synchronize_status_face_extraction": "iot-005",
        "iot_request_face_config": "iot-006",
        "iot_request_site_info": "iot-007",
        "iot_request_sensor_info_list": "iot-008",
        "iot_request_warning_info_list": "iot-009",
        "ttlock_oauth2_token": "ttlock-001",
        "ttlock_v3_fingerprint_add": "ttlock-002",
        "ttlock_v3_identitycard_add": "ttlock-003",
        "ttlock_v3_wirelesskeyboard_add": "ttlock-004",
        "ttlock_v3_lock_changeadminkeyboardpwd": "ttlock-005",
        "ttlock_v3_fingerprint_clear": "ttlock-006",
        "ttlock_v3_identitycard_clear": "ttlock-007",
        "ttlock_v3_fingerprint_delete": "ttlock-008",
        "ttlock_v3_identitycard_delete": "ttlock-009",
        "ttlock_v3_lock_delete": "ttlock-010",
        "ttlock_v3_gateway_isinitsuccess": "ttlock-011",
        "ttlock_v3_gateway_upgradecheck": "ttlock-012",
        "ttlock_v3_gateway_list": "ttlock-013",
        "ttlock_v3_lock_list": "ttlock-014",
        "ttlock_v3_fingerprint_list": "ttlock-015",
        "ttlock_v3_identitycard_list": "ttlock-016",
        "ttlock_v3_key_list": "ttlock-017",
        "ttlock_v3_lock_initialize": "ttlock-018",
        "ttlock_v3_lock_upgradecheck": "ttlock-019",
        "ttlock_v3_lock_upgraderecheck": "ttlock-020",
        "ttlock_v3_identitycard_changeperiod": "ttlock-021",
        "ttlock_room_registernb": "ttlock-022",
        "ttlock_v3_lock_resetkeyboardpwd": "ttlock-023",
        "ttlock_v3_lock_resetkey": "ttlock-024",
        "ttlock_v3_gateway_uploaddetail": "ttlock-025",
        "ttlock_lockrecords_fromlock": "ttlock-026",
        "face_cloud_device_face_sync_sync_page": "face-001",
        "face_cloud_device_face_sync_sync_all": "face-002",
        "face_cloud_device_face_sync_batch_update_status": "face-003",
        "face_cloud_v2_machine_updateapkversion": "face-004",
        "external_ai_chat_completion_stream": "external-001",
        "external_brand_brand_album_list": "external-002",
        "external_brand_brand_album_listdetail": "external-003",
        "external_brand_class_brand_management_android_videoalbum_list": "external-004",
        "external_v4_openim_get_c2c_unread_msg_num": "external-005",
    }

    method_names = list(method_index)
    # </generated: index>

    def __init__(
        self,
        username: str,
        password: str,
        *,
        mac: str | None = None,
        android_id: str | None = None,
        school_id: str | None = None,
        base_url: str | None = None,
        token: str | None = None,
        auto_login: bool = True,
        auto_obtain: bool = False,
        timeout: float | None = None,
        verify_tls: bool = True,
        permission_path: str | None = None,
    ) -> None:
        if mac == 'auto' or android_id == 'auto':
            from .device_info import get_android_id, get_mac
            if mac == 'auto':
                mac = get_mac()
            if android_id == 'auto':
                android_id = get_android_id()
        settings = load_settings(permission_path)
        settings.yide_username = username
        settings.yide_password = password
        if mac is not None:
            settings.yide_mac = mac
        if android_id is not None:
            settings.yide_android_id = android_id
        if school_id is not None:
            settings.yide_school_id = school_id
        if base_url:
            settings.yide_base_url = base_url.rstrip('/')
        if timeout is not None:
            settings.timeout = timeout
        settings.verify_tls = verify_tls
        super().__init__(settings)
        if mac:
            self.context['mac'] = mac
        if android_id:
            self.context['android_id'] = android_id
        if school_id:
            self.context['school_id'] = school_id
        if token:
            self.set_token(token)
        elif auto_login:
            self.login_yide()
        if auto_obtain:
            self.obtain()

    def set_token(self, token: str) -> None:
        '''Set an existing Authorization token (with or without Bearer).'''
        if not token.lower().startswith('bearer '):
            token = 'Bearer ' + token
        self.token = token
        self.session.headers['Authorization'] = token
        self.context['access_token'] = token[7:]

    def login(self) -> Any:
        return self.login_yide().get('data')

    def authenticate(self) -> Any:
        return self.login()

    def obtain(self, mac: str | None = None, android_id: str | None = None) -> Any:
        return super().obtain(mac=mac, android_id=android_id).get('data')

    def call(self, endpoint_id: str, *, full: bool = False, **kwargs: Any) -> Any:
        """Call an endpoint by id with loose keyword overrides.

        This is the low-level escape hatch.  The generated methods
        (self.home_get_home_video(...)) are typed and route each field to the
        right place; use this method when the endpoint id is dynamic or when
        you need a complete override.

        Recognised keyword arguments:
            params: extra query parameters (dict).
            json_body / json: complete JSON replacement.
            form_body: complete form replacement.
            files: complete multipart file map (key -> local path).
            <other>: added to query parameters, the JSON body and the form
                body, and stored in self.context so later placeholders resolve.

        Request templates are copied, so a call cannot mutate the global
        endpoint registry.

        Args:
            endpoint_id: e.g. 'home-002'.
            full: return the whole {"code": 0, ..., "data": ...} envelope.
            **kwargs: field overrides, see above.

        Returns:
            The response 'data' field (or the complete envelope when
            full=True); SSE endpoints return requests.Response.

        Raises:
            KeyError: unknown endpoint id.
            ApiError: HTTP error or a non-zero response 'code'.
        """
        endpoint = _ENDPOINTS.get(endpoint_id)
        if endpoint is None:
            raise KeyError(f'unknown endpoint id: {endpoint_id}')
        params = dict(endpoint.params)
        json_body = copy.deepcopy(endpoint.json_body)
        form_body = copy.deepcopy(endpoint.form_body) if endpoint.form_body else None
        files = dict(endpoint.files) if endpoint.files else None

        params_override = kwargs.pop('params', None)
        if params_override:
            params.update(params_override)
        if 'json_body' in kwargs:
            json_body = copy.deepcopy(kwargs.pop('json_body'))
        if 'json' in kwargs:
            json_body = copy.deepcopy(kwargs.pop('json'))
        if 'form_body' in kwargs:
            form_body = copy.deepcopy(kwargs.pop('form_body'))
        if 'files' in kwargs:
            files = dict(kwargs.pop('files'))

        for key, value in kwargs.items():
            params[key] = value
            if isinstance(json_body, dict):
                json_body[key] = value
            if isinstance(form_body, dict):
                form_body[key] = value
            self._set_context(key, value)

        if endpoint.client == 'ttlock' and not self.context.get('ttlock_access_token'):
            self.login_ttlock()

        temp = Endpoint(
            id=endpoint.id,
            method=endpoint.method,
            path=endpoint.path,
            params=params,
            json_body=json_body,
            form_body=form_body,
            files=files,
            auth=endpoint.auth,
            base=endpoint.base,
            client=endpoint.client,
            description=endpoint.description,
            source=endpoint.source,
            headers=endpoint.headers,
            stream=endpoint.stream,
            executable=endpoint.executable,
        )
        spec = self.prepare(temp)
        response = self.execute(spec)
        if spec.stream:
            return response
        try:
            body = response.json()
        except ValueError:
            return response.text
        if isinstance(body, dict) and body.get('code') not in (None, 0):
            print(body)
            raise ApiError(
                f"code={body.get('code')} message={body.get('message')} detail={body.get('detailMessage')}",
                response.status_code,
                body,
            )
        if full:
            return body
        if isinstance(body, dict) and 'data' in body:
            return body['data']
        return body

    def _invoke(
        self,
        endpoint_id: str,
        *,
        fields: Dict[str, Any],
        body: Any = None,
        extra: Optional[Dict[str, Any]] = None,
        full: bool = False,
    ) -> Any:
        """Route generated-method keyword arguments to the correct request slot.

        Generated methods pass every documented field here.  A value of None
        leaves that field out of the override; documented auto defaults (for
        fields missing from an empty template) are still resolved from
        self.context.

        Routing rules:
            * path placeholders -> self.context (prepare() renders the path)
            * query fields      -> params
            * JSON body fields  -> merged into a copy of the template body
            * form fields       -> merged into a copy of the template form
            * upload fields     -> merged into a copy of the template files
            * unknown fields    -> JSON body when the endpoint has one,
                                   otherwise form/query (legacy call() style)

        Merge order for a JSON body: template -> documented auto defaults ->
        body= -> explicit fields -> extra fields.  Values equal to the template
        default are ignored, so body= overrides are not overwritten by
        signature defaults.  The body= and **extra overrides may also be
        supplied with the legacy names json_body, json, form_body, files and
        params.

        Raises:
            TypeError: a list body is used with named fields, or body= has the
                wrong container type.
        """
        endpoint = _ENDPOINTS.get(endpoint_id)
        if endpoint is None:
            raise KeyError(f'unknown endpoint id: {endpoint_id}')
        path_keys = _PATH_KEYS[endpoint_id]

        def template_value(key: str) -> Any:
            if key in endpoint.params:
                return endpoint.params[key]
            if isinstance(endpoint.json_body, dict) and key in endpoint.json_body:
                return endpoint.json_body[key]
            if endpoint.form_body and key in endpoint.form_body:
                return endpoint.form_body[key]
            if endpoint.files and key in endpoint.files:
                return endpoint.files[key]
            return None

        # Only forward values that differ from the template.  Generated
        # signatures show literal template defaults (pageNo=1, deviceType='2',
        # ...), and forwarding those defaults would overwrite a body= override.
        values: Dict[str, Any] = {}
        for key, value in fields.items():
            if value is None or value == template_value(key):
                continue
            values[key] = value

        extras = dict(extra or {})
        json_override = extras.pop('json_body', None)
        if 'json' in extras:
            json_override = extras.pop('json')
        form_override = extras.pop('form_body', None)
        files_override = extras.pop('files', None)
        params_override = extras.pop('params', None)
        if json_override is not None:
            body = json_override
        for key, value in extras.items():
            if value is None or value == template_value(key):
                continue
            values[key] = value

        query: Dict[str, Any] = {}
        body_fields: Dict[str, Any] = {}
        form_fields: Dict[str, Any] = {}
        file_fields: Dict[str, Any] = {}
        param_keys = set(endpoint.params) - path_keys
        body_keys = set(endpoint.json_body) if isinstance(endpoint.json_body, dict) else set()
        form_keys = set(endpoint.form_body or {})
        file_keys = set(endpoint.files or {})

        for key, value in values.items():
            self._set_context(key, value)
            matched = False
            if key in param_keys:
                query[key] = value
                matched = True
            if key in body_keys:
                body_fields[key] = value
                matched = True
            if key in form_keys:
                form_fields[key] = value
                matched = True
            if key in file_keys:
                file_fields[key] = value
                matched = True
            if matched or key in path_keys:
                continue
            if endpoint.json_body is not None:
                body_fields[key] = value
            elif endpoint.form_body is not None:
                form_fields[key] = value
            else:
                query[key] = value

        if body_fields and not isinstance(endpoint.json_body, dict):
            raise TypeError(
                f"{endpoint_id} 的请求体是列表；请用 body=[...] 传入完整列表，"
                "不要使用单个字段名。"
            )

        # Some documented bodies are absent from the {} template.  Resolve
        # their context placeholders first; body= and explicit fields win.
        auto_fields: Dict[str, Any] = {}
        for key, template in SYNTHETIC_FIELDS.get(endpoint_id, {}).items():
            if isinstance(template, str) and "{" in template:
                rendered, unresolved = render(template, self.context)
                if not unresolved:
                    auto_fields[key] = rendered

        json_body: Any = None
        if isinstance(endpoint.json_body, dict):
            if body is not None and not isinstance(body, Mapping):
                raise TypeError(f"{endpoint_id} 的请求体是 JSON 对象，body= 必须是 dict")
            merged: Dict[str, Any] = copy.deepcopy(endpoint.json_body)
            merged.update(auto_fields)
            if isinstance(body, Mapping):
                merged.update(body)
            merged.update(body_fields)
            json_body = merged
        elif isinstance(endpoint.json_body, list):
            if body is not None and not isinstance(body, list):
                raise TypeError(f"{endpoint_id} 的请求体是列表，body= 必须是 list")
            json_body = copy.deepcopy(body if body is not None else endpoint.json_body)
        elif body is not None:
            json_body = copy.deepcopy(body)

        form_body = copy.deepcopy(endpoint.form_body) if endpoint.form_body is not None else None
        if form_body is not None:
            if form_override is not None:
                form_body = dict(form_override)
            form_body.update(form_fields)

        files = dict(endpoint.files) if endpoint.files else None
        if files is not None:
            if files_override is not None:
                files = dict(files_override)
            files.update(file_fields)

        if params_override:
            query.update(params_override)

        kwargs: Dict[str, Any] = {}
        if query:
            kwargs['params'] = query
        if json_body is not None:
            kwargs['json_body'] = json_body
        if form_body is not None:
            kwargs['form_body'] = form_body
        if files is not None:
            kwargs['files'] = files
        return self.call(endpoint_id, full=full, **kwargs)

    call_by_id = call

    def forge(self, endpoint_id: str, ensure_auth: bool = True) -> Dict[str, Any]:
        '''Build one request (with the current real token) without sending it.'''
        endpoint = _ENDPOINTS.get(endpoint_id)
        if endpoint is None:
            raise KeyError(f'unknown endpoint id: {endpoint_id}')
        if ensure_auth and endpoint.client == 'ttlock' and not self.context.get('ttlock_access_token'):
            self.login_ttlock()
        spec = self.prepare(endpoint)
        return {
            'id': endpoint.id,
            'method': endpoint.method,
            'url': spec.url,
            'params': spec.params,
            'json': spec.json_body,
            'form': spec.form_body,
            'files': spec.files,
            'headers': spec.headers,
            'unresolved': spec.unresolved,
        }

    def forge_all(self, ensure_auth: bool = True) -> List[Dict[str, Any]]:
        '''Build every request (with the current real token) without sending it.'''
        return [self.forge(ep.id, ensure_auth=ensure_auth) for ep in _ENDPOINTS.values()]

    # <generated: methods>
    def auth_new_login(
        self,
        *,
        username: str | None = None,
        password: str | None = None,
        client_id: str | None = None,
        grant_type: str = 'brand',
        client_secret: str | None = None,
        random: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """鉴权与登录 · OAuth 密码模式登录，获取 accessToken

        接口：POST /auth/oauth/token（auth-001）
        源码方法：newLogin
        鉴权：无需 Bearer token
        必填：无
        自动：username、password、client_id、client_secret、random

        Query 参数：
            username: str | None（自动）
                登录账号；占位符 {username} 取登录账号凭据
            password: str | None（自动）
                密码；登录接口为账号密码，门禁接口为门禁密码；占位符 {password} 取登录密码凭据
            client_id: str | None（自动）
                OAuth 客户端 ID（默认 yide-cloud）；占位符 {client_id} 取 OAuth 配置
            grant_type: str（可选，默认 "brand"）
                授权类型：brand（班牌）/ password（TTLock）
            client_secret: str | None（自动）
                OAuth 客户端密钥；占位符 {client_secret} 取 OAuth 配置
            random: str | None（自动）
                16 位随机串，自动生成；占位符 {random} 自动生成 16 位随机串

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.auth_new_login()
        """
        return self._invoke(
            "auth-001",
            fields={
                "username": username,
                "password": password,
                "client_id": client_id,
                "grant_type": grant_type,
                "client_secret": client_secret,
                "random": random,
            },
            extra=extra,
            full=full,
        )

    def auth_get_check_login_qr_code(
        self,
        *,
        random: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """鉴权与登录 · getCheckLoginQrCode

        接口：GET /auth/qrcode/check（auth-002）
        源码方法：getCheckLoginQrCode
        鉴权：无需 Bearer token
        必填：无
        自动：random

        Query 参数：
            random: str | None（自动）
                16 位随机串，自动生成；占位符 {random} 自动生成 16 位随机串

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.auth_get_check_login_qr_code()
        """
        return self._invoke(
            "auth-002",
            fields={"random": random},
            extra=extra,
            full=full,
        )

    def auth_request_qr_code_check(
        self,
        *,
        random: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """鉴权与登录 · requestQrCodeCheck

        接口：GET /auth/qrcode/check（auth-003）
        源码方法：requestQrCodeCheck
        鉴权：无需 Bearer token
        必填：无
        自动：random

        Query 参数：
            random: str | None（自动）
                16 位随机串，自动生成；占位符 {random} 自动生成 16 位随机串

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.auth_request_qr_code_check()
        """
        return self._invoke(
            "auth-003",
            fields={"random": random},
            extra=extra,
            full=full,
        )

    def auth_get_login_qr_code(self, *, type: str = '1', full: bool = False, **extra: Any) -> Any:
        """鉴权与登录 · getLoginQrCode

        接口：GET /auth/qrcode/gene（auth-004）
        源码方法：getLoginQrCode
        鉴权：无需 Bearer token
        必填：无

        Query 参数：
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.auth_get_login_qr_code()
        """
        return self._invoke(
            "auth-004",
            fields={"type": type},
            extra=extra,
            full=full,
        )

    def auth_request_qr_code(
        self,
        *,
        type: str = '1',
        schoolId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """鉴权与登录 · requestQrCode

        接口：GET /auth/qrcode/gene（auth-005）
        源码方法：requestQrCode
        鉴权：无需 Bearer token
        必填：无
        自动：schoolId

        Query 参数：
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.auth_request_qr_code(schoolId=client.context["school_id"])
        """
        return self._invoke(
            "auth-005",
            fields={"type": type, "schoolId": schoolId},
            extra=extra,
            full=full,
        )

    def auth_login(
        self,
        *,
        username: str | None = None,
        password: str | None = None,
        client_id: str | None = None,
        grant_type: str = 'brand',
        client_secret: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """鉴权与登录 · login

        接口：POST /brand/brand/mess/recive/index（auth-006）
        源码方法：login
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：username、password、client_id、client_secret

        Query 参数：
            username: str | None（自动）
                登录账号；占位符 {username} 取登录账号凭据
            password: str | None（自动）
                密码；登录接口为账号密码，门禁接口为门禁密码；占位符 {password} 取登录密码凭据
            client_id: str | None（自动）
                OAuth 客户端 ID（默认 yide-cloud）；占位符 {client_id} 取 OAuth 配置
            grant_type: str（可选，默认 "brand"）
                授权类型：brand（班牌）/ password（TTLock）
            client_secret: str | None（自动）
                OAuth 客户端密钥；占位符 {client_secret} 取 OAuth 配置

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.auth_login()
        """
        return self._invoke(
            "auth-006",
            fields={
                "username": username,
                "password": password,
                "client_id": client_id,
                "grant_type": grant_type,
                "client_secret": client_secret,
            },
            extra=extra,
            full=full,
        )

    def auth_get_site_by_user_name(
        self,
        *,
        equipmentSerialNumber: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """鉴权与登录 · getSiteByUserName

        接口：POST /brand/class-brand-management/app/loginCheck/getSiteByUserName（auth-007）
        源码方法：getSiteByUserName
        鉴权：无需 Bearer token
        必填：无
        自动：equipmentSerialNumber

        Query 参数：
            equipmentSerialNumber: str | None（自动）
                设备序列号；班牌用 Android ID；占位符 {android_id} 取 --android-id / YIDE_ANDROID_ID
                / adb

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.auth_get_site_by_user_name(equipmentSerialNumber=client.context["android_id"])
        """
        return self._invoke(
            "auth-007",
            fields={"equipmentSerialNumber": equipmentSerialNumber},
            extra=extra,
            full=full,
        )

    def auth_get_brand_obtain(
        self,
        *,
        loginName: str | None = None,
        no: str | None = None,
        wlanMac: str = '',
        seriaNo: str | None = None,
        direction: str = '0',
        body: AuthGetBrandObtainBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """鉴权与登录 · 班牌登录：换取学校/班级/场地/品牌信息

        接口：POST /brand/obtain（auth-008）
        源码方法：getBrandObtain
        鉴权：无需 Bearer token
        必填：无
        自动：loginName、no、seriaNo

        JSON 请求体（application/json）：
            loginName: str | None（自动）
                登录账号；占位符 {username} 取登录账号凭据
            no: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            wlanMac: str（可选，默认 空字符串）
                无线 MAC，通常留空
            seriaNo: str | None（自动）
                /brand/obtain 的设备序列号，传 Android ID；占位符 {android_id} 取 --android-id /
                YIDE_ANDROID_ID / adb
            direction: str（可选，默认 "0"）
                方向；班牌登录固定 '0'
            body: AuthGetBrandObtainBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.auth_get_brand_obtain(no=client.context["mac"], seriaNo=client.context["android_id"])
        """
        return self._invoke(
            "auth-008",
            fields={
                "loginName": loginName,
                "no": no,
                "wlanMac": wlanMac,
                "seriaNo": seriaNo,
                "direction": direction,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def auth_get_brand_info(
        self,
        *,
        loginName: str | None = None,
        no: str | None = None,
        wlanMac: str = '',
        seriaNo: str | None = None,
        direction: str = '0',
        body: AuthGetBrandInfoBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """鉴权与登录 · 班牌登录：换取学校/班级/场地/品牌信息

        接口：POST /brand/obtain（auth-009）
        源码方法：getBrandInfo
        鉴权：无需 Bearer token
        必填：无
        自动：loginName、no、seriaNo

        JSON 请求体（application/json）：
            loginName: str | None（自动）
                登录账号；占位符 {username} 取登录账号凭据
            no: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            wlanMac: str（可选，默认 空字符串）
                无线 MAC，通常留空
            seriaNo: str | None（自动）
                /brand/obtain 的设备序列号，传 Android ID；占位符 {android_id} 取 --android-id /
                YIDE_ANDROID_ID / adb
            direction: str（可选，默认 "0"）
                方向；班牌登录固定 '0'
            body: AuthGetBrandInfoBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.auth_get_brand_info(no=client.context["mac"], seriaNo=client.context["android_id"])
        """
        return self._invoke(
            "auth-009",
            fields={
                "loginName": loginName,
                "no": no,
                "wlanMac": wlanMac,
                "seriaNo": seriaNo,
                "direction": direction,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def device_get_newest_version(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · getNewestVersion

        接口：POST /backstage/cloud-backstage/kf/application/getNewestVersion（device-001）
        源码方法：getNewestVersion
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_get_newest_version()
        """
        return self._invoke(
            "device-001",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def device_query_classific_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · queryClassificList

        接口：POST /backstage/cloud-backstage/kf/application/queryClassificList（device-002）
        源码方法：queryClassificList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_query_classific_list()
        """
        return self._invoke(
            "device-002",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def device_one_key_school(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · oneKeySchool

        接口：POST /brand/after/school/log/afterSchool（device-003）
        源码方法：oneKeySchool
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_one_key_school()
        """
        return self._invoke(
            "device-003",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def device_classes_over_info(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · classesOverInfo

        接口：POST /brand/after/school/log/board（device-004）
        源码方法：classesOverInfo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_classes_over_info()
        """
        return self._invoke(
            "device-004",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def device_switch_new_list(self, *, id: str | None = None, full: bool = False, **extra: Any) -> Any:
        """设备激活、绑定与升级 · switchNewList

        接口：GET /brand/brand/getSwitchsType（device-005）
        源码方法：switchNewList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_switch_new_list(id=client.context["brand_id"])
        """
        return self._invoke(
            "device-005",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def device_update_apk_version(
        self,
        *,
        id: str | None = None,
        apkVersion: str = '3.0.14',
        body: DeviceUpdateApkVersionBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · updateApkVersion

        接口：POST /brand/brand/updateApkVersion（device-006）
        源码方法：updateApkVersion
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        JSON 请求体（application/json）：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context
            apkVersion: str（可选，默认 "3.0.14"）
                APK 版本号，如 3.0.14
            body: DeviceUpdateApkVersionBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_update_apk_version(id=client.context["brand_id"])
        """
        return self._invoke(
            "device-006",
            fields={"id": id, "apkVersion": apkVersion},
            body=body,
            extra=extra,
            full=full,
        )

    def device_inset_version_updated_school(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · insetVersionUpdatedSchool

        接口：POST /brand/class-brand-management/android/appRegistraCode/insetVersionUpdatedSchool（device-007）
        源码方法：insetVersionUpdatedSchool
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_inset_version_updated_school()
        """
        return self._invoke(
            "device-007",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def device_get_newest_version_2(
        self,
        *,
        schoolId: str | None = None,
        versionType: int = 2,
        deviceType: str = '2',
        body: DeviceGetNewestVersion2Body | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · getNewestVersion

        接口：POST /cloud/v2/barrier/getAppVersion（device-008）
        源码方法：getNewestVersion
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：schoolId

        JSON 请求体（application/json）：
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            versionType: int（可选，默认 2）
                版本类型（2）
            deviceType: str（可选，默认 "2"）
                设备类型；班牌固定 '2'
            body: DeviceGetNewestVersion2Body | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_get_newest_version_2(schoolId=client.context["school_id"])
        """
        return self._invoke(
            "device-008",
            fields={
                "schoolId": schoolId,
                "versionType": versionType,
                "deviceType": deviceType,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def device_get_or_binding_device(
        self,
        *,
        no: str | None = None,
        deviceType: str = '2',
        type: str = '3',
        schoolId: str | None = None,
        body: DeviceGetOrBindingDeviceBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · getOrBindingDevice

        接口：POST /cloud/v2/barrier/getOrBindingDevice（device-009）
        源码方法：getOrBindingDevice
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：no、schoolId

        JSON 请求体（application/json）：
            no: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            deviceType: str（可选，默认 "2"）
                设备类型；班牌固定 '2'
            type: str（可选，默认 "3"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            body: DeviceGetOrBindingDeviceBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_get_or_binding_device(
                no=client.context["mac"],
                schoolId=client.context["school_id"]
            )
        """
        return self._invoke(
            "device-009",
            fields={
                "no": no,
                "deviceType": deviceType,
                "type": type,
                "schoolId": schoolId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def device_get_activation_code(
        self,
        *,
        no: str | None = None,
        deviceType: str = '2',
        type: str = '3',
        schoolId: str | None = None,
        body: DeviceGetActivationCodeBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · getActivationCode

        接口：POST /cloud/v2/barrier/getOrBindingDevice（device-010）
        源码方法：getActivationCode
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：no、schoolId

        JSON 请求体（application/json）：
            no: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            deviceType: str（可选，默认 "2"）
                设备类型；班牌固定 '2'
            type: str（可选，默认 "3"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            body: DeviceGetActivationCodeBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_get_activation_code(
                no=client.context["mac"],
                schoolId=client.context["school_id"]
            )
        """
        return self._invoke(
            "device-010",
            fields={
                "no": no,
                "deviceType": deviceType,
                "type": type,
                "schoolId": schoolId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def device_get_activation_code_2(
        self,
        *,
        no: str | None = None,
        deviceType: str = '2',
        type: str = '3',
        schoolId: str | None = None,
        body: DeviceGetActivationCode2Body | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · getActivationCode

        接口：POST /cloud/v2/barrier/getOrBindingDevice（device-011）
        源码方法：getActivationCode
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：no、schoolId

        JSON 请求体（application/json）：
            no: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            deviceType: str（可选，默认 "2"）
                设备类型；班牌固定 '2'
            type: str（可选，默认 "3"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            body: DeviceGetActivationCode2Body | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_get_activation_code_2(
                no=client.context["mac"],
                schoolId=client.context["school_id"]
            )
        """
        return self._invoke(
            "device-011",
            fields={
                "no": no,
                "deviceType": deviceType,
                "type": type,
                "schoolId": schoolId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def device_get_registration_code(
        self,
        *,
        no: str | None = None,
        deviceType: str = '2',
        schoolId: str | None = None,
        body: DeviceGetRegistrationCodeBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · getRegistrationCode

        接口：POST /cloud/v2/barrier/getRegistrationCode（device-012）
        源码方法：getRegistrationCode
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：no、schoolId

        JSON 请求体（application/json）：
            no: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            deviceType: str（可选，默认 "2"）
                设备类型；班牌固定 '2'
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            body: DeviceGetRegistrationCodeBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_get_registration_code(
                no=client.context["mac"],
                schoolId=client.context["school_id"]
            )
        """
        return self._invoke(
            "device-012",
            fields={
                "no": no,
                "deviceType": deviceType,
                "schoolId": schoolId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def device_get_registration_code_2(
        self,
        *,
        no: str | None = None,
        deviceType: str = '2',
        schoolId: str | None = None,
        body: DeviceGetRegistrationCode2Body | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · getRegistrationCode

        接口：POST /cloud/v2/barrier/getRegistrationCode（device-013）
        源码方法：getRegistrationCode
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：no、schoolId

        JSON 请求体（application/json）：
            no: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            deviceType: str（可选，默认 "2"）
                设备类型；班牌固定 '2'
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            body: DeviceGetRegistrationCode2Body | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_get_registration_code_2(
                no=client.context["mac"],
                schoolId=client.context["school_id"]
            )
        """
        return self._invoke(
            "device-013",
            fields={
                "no": no,
                "deviceType": deviceType,
                "schoolId": schoolId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def device_update_new_registration_code_by_code(
        self,
        *,
        no: str | None = None,
        registrationCode: str = '',
        deviceType: str = '2',
        schoolId: str | None = None,
        body: DeviceUpdateNewRegistrationCodeByCodeBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · updateNewRegistrationCodeByCode

        接口：POST /cloud/v2/barrier/updateRegistrationCode（device-014）
        源码方法：updateNewRegistrationCodeByCode
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：no、schoolId

        JSON 请求体（application/json）：
            no: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            registrationCode: str（可选，默认 空字符串）
                设备注册码
            deviceType: str（可选，默认 "2"）
                设备类型；班牌固定 '2'
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            body: DeviceUpdateNewRegistrationCodeByCodeBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_update_new_registration_code_by_code(
                no=client.context["mac"],
                schoolId=client.context["school_id"]
            )
        """
        return self._invoke(
            "device-014",
            fields={
                "no": no,
                "registrationCode": registrationCode,
                "deviceType": deviceType,
                "schoolId": schoolId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def device_update_new_registration_code_by_code_2(
        self,
        *,
        no: str | None = None,
        registrationCode: str = '',
        deviceType: str = '2',
        schoolId: str | None = None,
        body: DeviceUpdateNewRegistrationCodeByCode2Body | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · updateNewRegistrationCodeByCode

        接口：POST /cloud/v2/barrier/updateRegistrationCode（device-015）
        源码方法：updateNewRegistrationCodeByCode
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：no、schoolId

        JSON 请求体（application/json）：
            no: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            registrationCode: str（可选，默认 空字符串）
                设备注册码
            deviceType: str（可选，默认 "2"）
                设备类型；班牌固定 '2'
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            body: DeviceUpdateNewRegistrationCodeByCode2Body | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_update_new_registration_code_by_code_2(
                no=client.context["mac"],
                schoolId=client.context["school_id"]
            )
        """
        return self._invoke(
            "device-015",
            fields={
                "no": no,
                "registrationCode": registrationCode,
                "deviceType": deviceType,
                "schoolId": schoolId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def device_get_brand_registration_code(
        self,
        *,
        deviceNo: str | None = None,
        deviceType: str = '2',
        body: DeviceGetBrandRegistrationCodeBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · getBrandRegistrationCode

        接口：POST /cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo（device-016）
        源码方法：getBrandRegistrationCode
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：deviceNo

        JSON 请求体（application/json）：
            deviceNo: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            deviceType: str（可选，默认 "2"）
                设备类型；班牌固定 '2'
            body: DeviceGetBrandRegistrationCodeBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_get_brand_registration_code(deviceNo=client.context["mac"])
        """
        return self._invoke(
            "device-016",
            fields={"deviceNo": deviceNo, "deviceType": deviceType},
            body=body,
            extra=extra,
            full=full,
        )

    def device_get_brand_registration_code_2(
        self,
        *,
        deviceNo: str | None = None,
        deviceType: str = '2',
        body: DeviceGetBrandRegistrationCode2Body | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · getBrandRegistrationCode

        接口：POST /cloud/v2/equipment/brand/getBrandAuthorizeCodeInfo（device-017）
        源码方法：getBrandRegistrationCode
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：deviceNo

        JSON 请求体（application/json）：
            deviceNo: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            deviceType: str（可选，默认 "2"）
                设备类型；班牌固定 '2'
            body: DeviceGetBrandRegistrationCode2Body | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_get_brand_registration_code_2(deviceNo=client.context["mac"])
        """
        return self._invoke(
            "device-017",
            fields={"deviceNo": deviceNo, "deviceType": deviceType},
            body=body,
            extra=extra,
            full=full,
        )

    def device_request_device_config(
        self,
        *,
        deviceNo: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备激活、绑定与升级 · requestDeviceConfig

        接口：GET /manage/machineInfo/getMachineConfigByDeviceNo（device-018）
        源码方法：requestDeviceConfig
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：deviceNo

        Query 参数：
            deviceNo: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.device_request_device_config(deviceNo=client.context["mac"])
        """
        return self._invoke(
            "device-018",
            fields={"deviceNo": deviceNo},
            extra=extra,
            full=full,
        )

    def school_request_area_info(self, *, full: bool = False, **extra: Any) -> Any:
        """学校、班级与首页布局 · requestAreaInfo

        接口：GET /app/area/list（school-001）
        源码方法：requestAreaInfo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_request_area_info()
        """
        return self._invoke(
            "school-001",
            fields={},
            extra=extra,
            full=full,
        )

    def school_school_style(self, *, full: bool = False, **extra: Any) -> Any:
        """学校、班级与首页布局 · SchoolStyle

        接口：GET /brand/brand/campus/style（school-002）
        源码方法：SchoolStyle
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_school_style()
        """
        return self._invoke(
            "school-002",
            fields={},
            extra=extra,
            full=full,
        )

    def school_teachers(self, *, body: Dict[str, Any] | None = None, full: bool = False, **extra: Any) -> Any:
        """学校、班级与首页布局 · Teachers

        接口：POST /brand/brand/campus/teachers（school-003）
        源码方法：Teachers
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_teachers()
        """
        return self._invoke(
            "school-003",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def school_select_new_classes_info(
        self,
        *,
        classesId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学校、班级与首页布局 · selectNewClassesInfo

        接口：GET /brand/brand/classes/info（school-004）
        源码方法：selectNewClassesInfo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        Query 参数：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_select_new_classes_info(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "school-004",
            fields={"classesId": classesId},
            extra=extra,
            full=full,
        )

    def school_get_classes_info(self, *, full: bool = False, **extra: Any) -> Any:
        """学校、班级与首页布局 · getClassesInfo

        接口：GET /brand/brand/classes/info（school-005）
        源码方法：getClassesInfo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_get_classes_info()
        """
        return self._invoke(
            "school-005",
            fields={},
            extra=extra,
            full=full,
        )

    def school_get_watch_word(
        self,
        *,
        classesId: str | None = None,
        body: SchoolGetWatchWordBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学校、班级与首页布局 · getWatchWord

        接口：POST /brand/brand/classes/watchword/list（school-006）
        源码方法：getWatchWord
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        JSON 请求体（application/json）：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            body: SchoolGetWatchWordBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_get_watch_word(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "school-006",
            fields={"classesId": classesId},
            body=body,
            extra=extra,
            full=full,
        )

    def school_get_watch_word_2(
        self,
        *,
        classesId: str | None = None,
        body: SchoolGetWatchWord2Body | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学校、班级与首页布局 · getWatchWord

        接口：POST /brand/brand/classes/watchword/list（school-007）
        源码方法：getWatchWord
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        JSON 请求体（application/json）：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            body: SchoolGetWatchWord2Body | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_get_watch_word_2(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "school-007",
            fields={"classesId": classesId},
            body=body,
            extra=extra,
            full=full,
        )

    def school_get_new_countdown_list(
        self,
        *,
        classesId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学校、班级与首页布局 · getNewCountdownList

        接口：GET /brand/brand/countdown/list（school-008）
        源码方法：getNewCountdownList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        Query 参数：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_get_new_countdown_list(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "school-008",
            fields={"classesId": classesId},
            extra=extra,
            full=full,
        )

    def school_request_dominate_screen_level(self, *, full: bool = False, **extra: Any) -> Any:
        """学校、班级与首页布局 · requestDominateScreenLevel

        接口：GET /brand/brand/getBrandDominateScreen（school-009）
        源码方法：requestDominateScreenLevel
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_request_dominate_screen_level()
        """
        return self._invoke(
            "school-009",
            fields={},
            extra=extra,
            full=full,
        )

    def school_get_new_layout_list(
        self,
        *,
        id: str | None = None,
        showType: int = 0,
        deviceType: str = '2',
        body: SchoolGetNewLayoutListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学校、班级与首页布局 · 首页模块布局（x/y/tag/width/height）

        接口：POST /brand/brand/layoutclasssign/layoutlist（school-010）
        源码方法：getNewLayoutList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        JSON 请求体（application/json）：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context
            showType: int（可选，默认 0）
                显示类型（首页布局固定 0）
            deviceType: str（可选，默认 "2"）
                设备类型；班牌固定 '2'
            body: SchoolGetNewLayoutListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_get_new_layout_list(id=client.context["brand_id"])
        """
        return self._invoke(
            "school-010",
            fields={
                "id": id,
                "showType": showType,
                "deviceType": deviceType,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def school_new_remind(self, *, brandId: str | None = None, full: bool = False, **extra: Any) -> Any:
        """学校、班级与首页布局 · newRemind

        接口：GET /brand/brand/remind/list（school-011）
        源码方法：newRemind
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：brandId

        Query 参数：
            brandId: str | None（自动）
                班牌/品牌 ID（/brand/obtain 返回的 id）；占位符 {brand_id} /brand/obtain 后写入
                context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_new_remind(brandId=client.context["brand_id"])
        """
        return self._invoke(
            "school-011",
            fields={"brandId": brandId},
            extra=extra,
            full=full,
        )

    def school_get_semester_time(self, *, full: bool = False, **extra: Any) -> Any:
        """学校、班级与首页布局 · getSemesterTime

        接口：GET /brand/brand/school/semester/current（school-012）
        源码方法：getSemesterTime
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_get_semester_time()
        """
        return self._invoke(
            "school-012",
            fields={},
            extra=extra,
            full=full,
        )

    def school_select_classes_info(
        self,
        *,
        brandClassLoginName: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学校、班级与首页布局 · selectClassesInfo

        接口：POST /brand/class-brand-management/android/class/selectClassesInfo（school-013）
        源码方法：selectClassesInfo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：brandClassLoginName

        Query 参数：
            brandClassLoginName: str | None（自动）
                班牌登录账号；占位符 {username} 取登录账号凭据

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_select_classes_info()
        """
        return self._invoke(
            "school-013",
            fields={"brandClassLoginName": brandClassLoginName},
            extra=extra,
            full=full,
        )

    def school_request_dominate_screen_level_2(
        self,
        *,
        brandId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学校、班级与首页布局 · requestDominateScreenLevel

        接口：GET /brand/v2/custom/mode/list（school-014）
        源码方法：requestDominateScreenLevel
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：brandId

        Query 参数：
            brandId: str | None（自动）
                班牌/品牌 ID（/brand/obtain 返回的 id）；占位符 {brand_id} /brand/obtain 后写入
                context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_request_dominate_screen_level_2(brandId=client.context["brand_id"])
        """
        return self._invoke(
            "school-014",
            fields={"brandId": brandId},
            extra=extra,
            full=full,
        )

    def school_request_custom_dominate_screen_list(
        self,
        *,
        brandId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学校、班级与首页布局 · requestCustomDominateScreenList

        接口：GET /brand/v2/custom/mode/list（school-015）
        源码方法：requestCustomDominateScreenList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：brandId

        Query 参数：
            brandId: str | None（自动）
                班牌/品牌 ID（/brand/obtain 返回的 id）；占位符 {brand_id} /brand/obtain 后写入
                context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_request_custom_dominate_screen_list(brandId=client.context["brand_id"])
        """
        return self._invoke(
            "school-015",
            fields={"brandId": brandId},
            extra=extra,
            full=full,
        )

    def school_get_school_calendar(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学校、班级与首页布局 · getSchoolCalendar

        接口：POST /cloud/brand/calendar/getSchoolCalendar（school-016）
        源码方法：getSchoolCalendar
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_get_school_calendar()
        """
        return self._invoke(
            "school-016",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def school_select_school_calendar(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学校、班级与首页布局 · selectSchoolCalendar

        接口：POST /cloud/calendar/selectSchoolCalendar（school-017）
        源码方法：selectSchoolCalendar
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_select_school_calendar()
        """
        return self._invoke(
            "school-017",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def school_request_site_info(self, *, id: str | None = None, full: bool = False, **extra: Any) -> Any:
        """学校、班级与首页布局 · requestSiteInfo

        接口：GET /cloud/site/getSite（school-018）
        源码方法：requestSiteInfo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_request_site_info(id=client.context["brand_id"])
        """
        return self._invoke(
            "school-018",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def school_get_classes_info_2(
        self,
        *,
        classId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学校、班级与首页布局 · getClassesInfo

        接口：GET /management/cloud-system/pc/getClassesInfo/{classId}（school-019）
        源码方法：getClassesInfo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：classId

        路径参数（URL Path）：
            classId: str | None（必填，路径参数）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.school_get_classes_info_2(classId=client.context["classes_id"])
        """
        return self._invoke(
            "school-019",
            fields={"classId": classId},
            extra=extra,
            full=full,
        )

    def home_get_weather(self, *, city: str | None = None, full: bool = False, **extra: Any) -> Any:
        """首页卡片与班级展示 · getWeather

        接口：GET /Ecalender/weather_mini（home-001）
        源码方法：getWeather
        鉴权：无需 Bearer token
        必填：city

        Query 参数：
            city: str | None（必填）
                城市名（中文），如 重庆；占位符 {city} 需传参或写入 context['city']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_get_weather(city="<city>")
        """
        return self._invoke(
            "home-001",
            fields={"city": city},
            extra=extra,
            full=full,
        )

    def home_get_home_video(
        self,
        *,
        classesId: str | None = None,
        kind: str | None = None,
        type: str | None = None,
        body: HomeGetHomeVideoBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """首页卡片与班级展示 · getHomeVideo

        接口：POST /brand/brand/album/index（home-002）
        源码方法：getHomeVideo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        JSON 请求体（application/json）：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            kind: str | None（可选，示例 "1"）
                类型；相册接口 1=班级相册
            type: str | None（可选，示例 "2"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            body: HomeGetHomeVideoBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_get_home_video(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "home-002",
            fields={
                "classesId": classesId,
                "kind": kind,
                "type": type,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def home_get_new_class_photo_list(
        self,
        *,
        classesId: str | None = None,
        kind: str | None = None,
        type: str | None = None,
        limitNum: int | None = None,
        body: HomeGetNewClassPhotoListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """首页卡片与班级展示 · getNewClassPhotoList

        接口：POST /brand/brand/album/list（home-003）
        源码方法：getNewClassPhotoList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        JSON 请求体（application/json）：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            kind: str | None（可选，示例 "1"）
                类型；相册接口 1=班级相册
            type: str | None（可选，示例 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            limitNum: int | None（可选，示例 10）
                返回条数上限
            body: HomeGetNewClassPhotoListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_get_new_class_photo_list(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "home-003",
            fields={
                "classesId": classesId,
                "kind": kind,
                "type": type,
                "limitNum": limitNum,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def home_get_new_photo_list(
        self,
        *,
        classesId: str | None = None,
        kind: str | None = None,
        type: str | None = None,
        body: HomeGetNewPhotoListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """首页卡片与班级展示 · getNewPhotoList

        接口：POST /brand/brand/album/listDetail（home-004）
        源码方法：getNewPhotoList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        JSON 请求体（application/json）：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            kind: str | None（可选，示例 "1"）
                类型；相册接口 1=班级相册
            type: str | None（可选，示例 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            body: HomeGetNewPhotoListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_get_new_photo_list(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "home-004",
            fields={
                "classesId": classesId,
                "kind": kind,
                "type": type,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def home_get_new_student_duty(self, *, full: bool = False, **extra: Any) -> Any:
        """首页卡片与班级展示 · getNewStudentDuty

        接口：GET /brand/brand/studentduty/selectRecord（home-005）
        源码方法：getNewStudentDuty
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_get_new_student_duty()
        """
        return self._invoke(
            "home-005",
            fields={},
            extra=extra,
            full=full,
        )

    def home_get_new_student_work_list(
        self,
        *,
        classesId: str | None = None,
        pageNo: str = '1',
        pageSize: str = '10',
        body: HomeGetNewStudentWorkListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """首页卡片与班级展示 · getNewStudentWorkList

        接口：POST /brand/brand/studentwork/list（home-006）
        源码方法：getNewStudentWorkList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        JSON 请求体（application/json）：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            pageNo: str（可选，默认 "1"）
                页码，从 1 开始
            pageSize: str（可选，默认 "10"）
                每页条数；服务端混用 str/int，按模板类型传
            body: HomeGetNewStudentWorkListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_get_new_student_work_list(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "home-006",
            fields={
                "classesId": classesId,
                "pageNo": pageNo,
                "pageSize": pageSize,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def home_select_new_student_info(self, *, id: str | None = None, full: bool = False, **extra: Any) -> Any:
        """首页卡片与班级展示 · selectNewStudentInfo

        接口：GET /brand/brand/studentwork/selectStudentInfo（home-007）
        源码方法：selectNewStudentInfo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_select_new_student_info(id=client.context["brand_id"])
        """
        return self._invoke(
            "home-007",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def home_set_new_work_comment(
        self,
        *,
        workId: str | None = None,
        content: str | None = None,
        body: HomeSetNewWorkCommentBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """首页卡片与班级展示 · setNewWorkComment

        接口：POST /brand/brand/studentwork/workComment（home-008）
        源码方法：setNewWorkComment
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：workId

        JSON 请求体（application/json）：
            workId: str | None（必填）
                学生作品 ID；占位符 {work_id} 需传参或写入 context['work_id']
            content: str | None（可选，示例 空字符串）
                意见/评论内容
            body: HomeSetNewWorkCommentBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_set_new_work_comment(workId="<work_id>")
        """
        return self._invoke(
            "home-008",
            fields={"workId": workId, "content": content},
            body=body,
            extra=extra,
            full=full,
        )

    def home_set_new_work_like(
        self,
        *,
        id: str | None = None,
        userId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """首页卡片与班级展示 · setNewWorkLike

        接口：GET /brand/brand/studentwork/workLike（home-009）
        源码方法：setNewWorkLike
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id、userId

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_set_new_work_like(
                id=client.context["brand_id"],
                userId=client.context["student_id"]
            )
        """
        return self._invoke(
            "home-009",
            fields={"id": id, "userId": userId},
            extra=extra,
            full=full,
        )

    def home_get_duty_week_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """首页卡片与班级展示 · getDutyWeekList

        接口：POST /brand/brand/v3/studentduty/selectRecord（home-010）
        源码方法：getDutyWeekList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_get_duty_week_list()
        """
        return self._invoke(
            "home-010",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def home_get_photo_album_tablist(
        self,
        *,
        classesId: str | None = None,
        body: HomeGetPhotoAlbumTablistBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """首页卡片与班级展示 · getPhotoAlbumTablist

        接口：POST /brand/class-brand-management/android/videoalbum/classifylist（home-011）
        源码方法：getPhotoAlbumTablist
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        JSON 请求体（application/json）：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            body: HomeGetPhotoAlbumTablistBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_get_photo_album_tablist(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "home-011",
            fields={"classesId": classesId},
            body=body,
            extra=extra,
            full=full,
        )

    def home_get_student_duty(self, *, classId: str | None = None, full: bool = False, **extra: Any) -> Any:
        """首页卡片与班级展示 · getStudentDuty

        接口：GET /brand/class-brand-management/app/studentDuty/selectRecord（home-012）
        源码方法：getStudentDuty
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classId

        Query 参数：
            classId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_get_student_duty(classId=client.context["classes_id"])
        """
        return self._invoke(
            "home-012",
            fields={"classId": classId},
            extra=extra,
            full=full,
        )

    def home_get_new_weather_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """首页卡片与班级展示 · getNewWeatherList

        接口：POST /brand/weather/day7（home-013）
        源码方法：getNewWeatherList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_get_new_weather_list()
        """
        return self._invoke(
            "home-013",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def home_get_new_weather(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """首页卡片与班级展示 · getNewWeather

        接口：POST /brand/weather/now（home-014）
        源码方法：getNewWeather
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_get_new_weather()
        """
        return self._invoke(
            "home-014",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def home_get_new_task_list(
        self,
        *,
        pageNo: int = 1,
        pageSize: int = 20,
        classesId: str | None = None,
        body: HomeGetNewTaskListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """首页卡片与班级展示 · getNewTaskList

        接口：POST /cloud/app/work/pageThisWeekWork（home-015）
        源码方法：getNewTaskList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        JSON 请求体（application/json）：
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 20）
                每页条数；服务端混用 str/int，按模板类型传
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            body: HomeGetNewTaskListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.home_get_new_task_list(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "home-015",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "classesId": classesId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def messages_get_message_dominate_screen_list(
        self,
        *,
        brandId: str | None = None,
        body: MessagesGetMessageDominateScreenListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """消息公告与 IM · getMessageDominateScreenList

        接口：POST /brand/brand/mess/recive/dominateScreen/list（messages-001）
        源码方法：getMessageDominateScreenList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：brandId

        JSON 请求体（application/json）：
            brandId: str | None（自动）
                班牌/品牌 ID（/brand/obtain 返回的 id）；占位符 {brand_id} /brand/obtain 后写入
                context
            body: MessagesGetMessageDominateScreenListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.messages_get_message_dominate_screen_list(brandId=client.context["brand_id"])
        """
        return self._invoke(
            "messages-001",
            fields={"brandId": brandId},
            body=body,
            extra=extra,
            full=full,
        )

    def messages_request_message_dominate_screen_list(
        self,
        *,
        brandId: str | None = None,
        body: MessagesRequestMessageDominateScreenListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """消息公告与 IM · requestMessageDominateScreenList

        接口：POST /brand/brand/mess/recive/dominateScreen/list（messages-002）
        源码方法：requestMessageDominateScreenList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：brandId

        JSON 请求体（application/json）：
            brandId: str | None（自动）
                班牌/品牌 ID（/brand/obtain 返回的 id）；占位符 {brand_id} /brand/obtain 后写入
                context
            body: MessagesRequestMessageDominateScreenListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.messages_request_message_dominate_screen_list(brandId=client.context["brand_id"])
        """
        return self._invoke(
            "messages-002",
            fields={"brandId": brandId},
            body=body,
            extra=extra,
            full=full,
        )

    def messages_request_message_home(self, *, full: bool = False, **extra: Any) -> Any:
        """消息公告与 IM · requestMessageHome

        接口：GET /brand/brand/mess/recive/index（messages-003）
        源码方法：requestMessageHome
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.messages_request_message_home()
        """
        return self._invoke(
            "messages-003",
            fields={},
            extra=extra,
            full=full,
        )

    def messages_get_new_notice_with_pag(
        self,
        *,
        identifier: str = 'announcement',
        pageNo: int = 1,
        pageSize: str = '18',
        approverId: str | None = None,
        startTime: str = '2026-10-01 00:00:00',
        endTime: str = '2026-10-19 23:59:59',
        body: MessagesGetNewNoticeWithPagBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """消息公告与 IM · 公告/消息分页

        接口：POST /brand/brand/mess/recive/page（messages-004）
        源码方法：getNewNoticeWithPag
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：approverId

        JSON 请求体（application/json）：
            identifier: str（可选，默认 "announcement"）
                标识；公告接口固定 announcement，IM 接口为用户 ID
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: str（可选，默认 "18"）
                每页条数；服务端混用 str/int，按模板类型传
            approverId: str | None（自动）
                审批人/接收人 ID；公告接口传班牌 brandId；占位符 {brand_id} /brand/obtain 后写入 context
            startTime: str（可选，默认 "2026-10-01 00:00:00"）
                开始时间，yyyy-MM-dd HH:mm:ss
            endTime: str（可选，默认 "2026-10-19 23:59:59"）
                结束时间，yyyy-MM-dd HH:mm:ss
            body: MessagesGetNewNoticeWithPagBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.messages_get_new_notice_with_pag(approverId=client.context["brand_id"])
        """
        return self._invoke(
            "messages-004",
            fields={
                "identifier": identifier,
                "pageNo": pageNo,
                "pageSize": pageSize,
                "approverId": approverId,
                "startTime": startTime,
                "endTime": endTime,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def messages_request_message(
        self,
        *,
        identifier: str = 'announcement',
        pageNo: int = 1,
        pageSize: str = '18',
        approverId: str | None = None,
        startTime: str = '2026-10-01 00:00:00',
        endTime: str = '2026-10-19 23:59:59',
        body: MessagesRequestMessageBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """消息公告与 IM · 公告/消息分页

        接口：POST /brand/brand/mess/recive/page（messages-005）
        源码方法：requestMessage
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：approverId

        JSON 请求体（application/json）：
            identifier: str（可选，默认 "announcement"）
                标识；公告接口固定 announcement，IM 接口为用户 ID
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: str（可选，默认 "18"）
                每页条数；服务端混用 str/int，按模板类型传
            approverId: str | None（自动）
                审批人/接收人 ID；公告接口传班牌 brandId；占位符 {brand_id} /brand/obtain 后写入 context
            startTime: str（可选，默认 "2026-10-01 00:00:00"）
                开始时间，yyyy-MM-dd HH:mm:ss
            endTime: str（可选，默认 "2026-10-19 23:59:59"）
                结束时间，yyyy-MM-dd HH:mm:ss
            body: MessagesRequestMessageBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.messages_request_message(approverId=client.context["brand_id"])
        """
        return self._invoke(
            "messages-005",
            fields={
                "identifier": identifier,
                "pageNo": pageNo,
                "pageSize": pageSize,
                "approverId": approverId,
                "startTime": startTime,
                "endTime": endTime,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def messages_request_message_list(
        self,
        *,
        identifier: str = 'announcement',
        pageNo: int = 1,
        pageSize: str = '18',
        approverId: str | None = None,
        startTime: str = '2026-10-01 00:00:00',
        endTime: str = '2026-10-19 23:59:59',
        body: MessagesRequestMessageListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """消息公告与 IM · 公告/消息分页

        接口：POST /brand/brand/mess/recive/page（messages-006）
        源码方法：requestMessageList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：approverId

        JSON 请求体（application/json）：
            identifier: str（可选，默认 "announcement"）
                标识；公告接口固定 announcement，IM 接口为用户 ID
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: str（可选，默认 "18"）
                每页条数；服务端混用 str/int，按模板类型传
            approverId: str | None（自动）
                审批人/接收人 ID；公告接口传班牌 brandId；占位符 {brand_id} /brand/obtain 后写入 context
            startTime: str（可选，默认 "2026-10-01 00:00:00"）
                开始时间，yyyy-MM-dd HH:mm:ss
            endTime: str（可选，默认 "2026-10-19 23:59:59"）
                结束时间，yyyy-MM-dd HH:mm:ss
            body: MessagesRequestMessageListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.messages_request_message_list(approverId=client.context["brand_id"])
        """
        return self._invoke(
            "messages-006",
            fields={
                "identifier": identifier,
                "pageNo": pageNo,
                "pageSize": pageSize,
                "approverId": approverId,
                "startTime": startTime,
                "endTime": endTime,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def messages_get_captions_notice_info(
        self,
        *,
        schoolId: str | None = None,
        deviceId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """消息公告与 IM · getCaptionsNoticeInfo

        接口：GET /cloud/device/mess/publish/getCaptionsNoticeInfo（messages-007）
        源码方法：getCaptionsNoticeInfo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：deviceId
        自动：schoolId

        Query 参数：
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            deviceId: str | None（必填）
                设备 ID；占位符 {deviceId} 需传参或写入 context['deviceId']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.messages_get_captions_notice_info(deviceId="<deviceId>")
        """
        return self._invoke(
            "messages-007",
            fields={"schoolId": schoolId, "deviceId": deviceId},
            extra=extra,
            full=full,
        )

    def messages_request_home_caption(
        self,
        *,
        schoolId: str | None = None,
        deviceId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """消息公告与 IM · requestHomeCaption

        接口：GET /cloud/device/mess/publish/getCaptionsNoticeInfo（messages-008）
        源码方法：requestHomeCaption
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：deviceId
        自动：schoolId

        Query 参数：
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            deviceId: str | None（必填）
                设备 ID；占位符 {deviceId} 需传参或写入 context['deviceId']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.messages_request_home_caption(deviceId="<deviceId>")
        """
        return self._invoke(
            "messages-008",
            fields={"schoolId": schoolId, "deviceId": deviceId},
            extra=extra,
            full=full,
        )

    def messages_get_user_sig(
        self,
        *,
        identifier: str = 'announcement',
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """消息公告与 IM · getUserSig

        接口：GET /cloud/im/user/sig/gen（messages-009）
        源码方法：getUserSig
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        Query 参数：
            identifier: str（可选，默认 "announcement"）
                标识；公告接口固定 announcement，IM 接口为用户 ID

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.messages_get_user_sig()
        """
        return self._invoke(
            "messages-009",
            fields={"identifier": identifier},
            extra=extra,
            full=full,
        )

    def messages_get_user_sig_2(
        self,
        *,
        identifier: str = 'announcement',
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """消息公告与 IM · getUserSig

        接口：GET /cloud/im/user/sig/gen（messages-010）
        源码方法：getUserSig
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        Query 参数：
            identifier: str（可选，默认 "announcement"）
                标识；公告接口固定 announcement，IM 接口为用户 ID

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.messages_get_user_sig_2()
        """
        return self._invoke(
            "messages-010",
            fields={"identifier": identifier},
            extra=extra,
            full=full,
        )

    def messages_get_system_sign(self, *, full: bool = False, **extra: Any) -> Any:
        """消息公告与 IM · getSystemSign

        接口：GET /cloud/im/user/sig/getSystemSig（messages-011）
        源码方法：getSystemSign
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.messages_get_system_sign()
        """
        return self._invoke(
            "messages-011",
            fields={},
            extra=extra,
            full=full,
        )

    def messages_get_user_sig_by_user_id(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """消息公告与 IM · getUserSigByUserId

        接口：POST /management/cloud-system/im/getUserSigByUserId（messages-012）
        源码方法：getUserSigByUserId
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.messages_get_user_sig_by_user_id()
        """
        return self._invoke(
            "messages-012",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def timetable_user_table(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """课表 · UserTable

        接口：POST /brand/class-brand-management/android/course/classSchedule（timetable-001）
        源码方法：UserTable
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.timetable_user_table()
        """
        return self._invoke(
            "timetable-001",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def timetable_get_class_schedule(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """课表 · getClassSchedule

        接口：POST /brand/class-brand-management/android/course/classSchedule（timetable-002）
        源码方法：getClassSchedule
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.timetable_get_class_schedule()
        """
        return self._invoke(
            "timetable-002",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def timetable_get_c_d_k_b(
        self,
        *,
        weekTime: str = '',
        typeId: str | None = None,
        type: str = '1',
        body: TimetableGetCDKBBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """课表 · 班级/教师/学生课表

        接口：POST /cloud/app/timetable/getWeekTime（timetable-003）
        源码方法：getCDKB
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：typeId

        JSON 请求体（application/json）：
            weekTime: str（可选，默认 空字符串）
                课表周次/日期；空字符串表示本周
            typeId: str | None（自动）
                课表类型 ID；通常传班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            body: TimetableGetCDKBBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.timetable_get_c_d_k_b(typeId=client.context["classes_id"])
        """
        return self._invoke(
            "timetable-003",
            fields={
                "weekTime": weekTime,
                "typeId": typeId,
                "type": type,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def timetable_request_course_list(
        self,
        *,
        weekTime: str = '',
        typeId: str | None = None,
        type: str = '1',
        body: TimetableRequestCourseListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """课表 · 班级/教师/学生课表

        接口：POST /cloud/app/timetable/getWeekTime（timetable-004）
        源码方法：requestCourseList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：typeId

        JSON 请求体（application/json）：
            weekTime: str（可选，默认 空字符串）
                课表周次/日期；空字符串表示本周
            typeId: str | None（自动）
                课表类型 ID；通常传班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            body: TimetableRequestCourseListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.timetable_request_course_list(typeId=client.context["classes_id"])
        """
        return self._invoke(
            "timetable-004",
            fields={
                "weekTime": weekTime,
                "typeId": typeId,
                "type": type,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def timetable_get_c_d_k_b_2(
        self,
        *,
        weekTime: str = '',
        typeId: str | None = None,
        type: str = '1',
        body: TimetableGetCDKB2Body | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """课表 · 班级/教师/学生课表

        接口：POST /cloud/app/timetable/getWeekTime（timetable-005）
        源码方法：getCDKB
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：typeId

        JSON 请求体（application/json）：
            weekTime: str（可选，默认 空字符串）
                课表周次/日期；空字符串表示本周
            typeId: str | None（自动）
                课表类型 ID；通常传班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            body: TimetableGetCDKB2Body | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.timetable_get_c_d_k_b_2(typeId=client.context["classes_id"])
        """
        return self._invoke(
            "timetable-005",
            fields={
                "weekTime": weekTime,
                "typeId": typeId,
                "type": type,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def timetable_get_k_b(
        self,
        *,
        bjid: str | None = None,
        skzc: str = '1',
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """课表 · getKB

        接口：POST /timetable/cloud-timetable/v1/kcb/classes（timetable-006）
        源码方法：getKB
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：bjid

        Query 参数：
            bjid: str | None（自动）
                班级 ID（服务端历史参数名）；占位符 {classes_id} /brand/obtain 后写入 context
            skzc: str（可选，默认 "1"）
                上课周次

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.timetable_get_k_b(bjid=client.context["classes_id"])
        """
        return self._invoke(
            "timetable-006",
            fields={"bjid": bjid, "skzc": skzc},
            extra=extra,
            full=full,
        )

    def attendance_brand_attendance_clock(
        self,
        *,
        body: AttendanceBrandAttendanceClockBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · brandAttendanceClock

        接口：POST /attweb/app/attendance/createBrandAttendanceSignIn（attendance-001）
        源码方法：brandAttendanceClock
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：attendanceIds、siteName、timetableId
        自动：deviceNo、siteId、studentId

        JSON 请求体：
            模板是列表，请用 body=[...] 一次传入完整列表。
            body: AttendanceBrandAttendanceClockBody | None
                完整列表请求体。

            列表元素字段：
                attendanceIds: str | None（必填）
                    考勤活动 ID 列表；占位符 {attendance_id} 需传参或写入 context['attendance_id']
                deviceName: str（可选，默认 "班牌"）
                    设备名称，如 班牌
                deviceNo: str | None（自动）
                    设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
                signInImg: str（可选，默认 空字符串）
                    签到照片 URL/Base64，可为空
                signInTime: str（可选，默认 "2026-10-19 08:01:00"）
                    签到时间，yyyy-MM-dd HH:mm:ss
                siteId: str | None（自动）
                    场地 ID；占位符 {site_id} /brand/obtain 后写入 context
                siteName: str | None（必填）
                    场地名称；占位符 {site_name} 需传参或写入 context['site_name']
                siteTimetableId: str（可选，默认 空字符串）
                    场地课表 ID，可为空
                studentId: str | None（自动）
                    学生 ID；占位符 {student_id} 自动发现或由参数写入 context
                timetableId: str | None（必填）
                    课表 ID；占位符 {timetable_id} 需传参或写入 context['timetable_id']
                type: str（可选，默认 "1"）
                    类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_brand_attendance_clock(body=[...])
        """
        return self._invoke(
            "attendance-001",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_get_attence_k_b(
        self,
        *,
        classesId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · getAttenceKB

        接口：GET /attweb/app/attendance/getAttendanceEventTimetableByClasses（attendance-002）
        源码方法：getAttenceKB
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        Query 参数：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_get_attence_k_b(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "attendance-002",
            fields={"classesId": classesId},
            extra=extra,
            full=full,
        )

    def attendance_get_attendance_site_timetable(
        self,
        *,
        timetableIds: List[str] | None = None,
        body: AttendanceGetAttendanceSiteTimetableBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · getAttendanceSiteTimetable

        接口：POST /attweb/app/attendance/getAttendanceSiteTimetable（attendance-003）
        源码方法：getAttendanceSiteTimetable
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：timetableIds

        JSON 请求体（application/json）：
            timetableIds: List[str] | None（必填）
                课表 ID 列表；占位符 {timetable_id} 需传参或写入 context['timetable_id']
            body: AttendanceGetAttendanceSiteTimetableBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_get_attendance_site_timetable(timetableIds="<timetable_id>")
        """
        return self._invoke(
            "attendance-003",
            fields={"timetableIds": timetableIds},
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_attendlist(self, *, no: str | None = None, full: bool = False, **extra: Any) -> Any:
        """考勤与打卡 · Attendlist

        接口：GET /attweb/app/attendance/getBrandAttendanceRule（attendance-004）
        源码方法：Attendlist
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：no

        Query 参数：
            no: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_attendlist(no=client.context["mac"])
        """
        return self._invoke(
            "attendance-004",
            fields={"no": no},
            extra=extra,
            full=full,
        )

    def attendance_get_brand_attendance_user(
        self,
        *,
        id: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · getBrandAttendanceUser

        接口：GET /attweb/app/attendance/getBrandAttendanceUser（attendance-005）
        源码方法：getBrandAttendanceUser
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_get_brand_attendance_user(id=client.context["brand_id"])
        """
        return self._invoke(
            "attendance-005",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def attendance_query_brand_attendance_by_attendance_time_id(
        self,
        *,
        attendanceTimeIds: List[Any] | None = None,
        body: AttendanceQueryBrandAttendanceByAttendanceTimeIdBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · 今日考勤

        接口：POST /attweb/app/attendance/listToDay（attendance-006）
        源码方法：queryBrandAttendanceByAttendanceTimeId
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体（application/json）：
            attendanceTimeIds: List[Any] | None（可选，默认 []）
                考勤时段 ID 列表
            body: AttendanceQueryBrandAttendanceByAttendanceTimeIdBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_query_brand_attendance_by_attendance_time_id()
        """
        return self._invoke(
            "attendance-006",
            fields={"attendanceTimeIds": attendanceTimeIds},
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_request_attendance(
        self,
        *,
        attendanceTimeIds: List[Any] | None = None,
        body: AttendanceRequestAttendanceBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · 今日考勤

        接口：POST /attweb/app/attendance/listToDay（attendance-007）
        源码方法：requestAttendance
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体（application/json）：
            attendanceTimeIds: List[Any] | None（可选，默认 []）
                考勤时段 ID 列表
            body: AttendanceRequestAttendanceBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_request_attendance()
        """
        return self._invoke(
            "attendance-007",
            fields={"attendanceTimeIds": attendanceTimeIds},
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_list_to_day_detail(
        self,
        *,
        attendanceTimeId: str | None = None,
        attendanceId: str | None = None,
        type: str = '1',
        body: AttendanceListToDayDetailBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · 考勤明细

        接口：POST /attweb/app/attendance/listToDayDetail（attendance-008）
        源码方法：listToDayDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：attendanceTimeId、attendanceId

        JSON 请求体（application/json）：
            attendanceTimeId: str | None（必填）
                考勤时段 ID；占位符 {attendance_time_id} 需传参或写入 context['attendance_time_id']
            attendanceId: str | None（必填）
                考勤活动 ID；占位符 {attendance_id} 需传参或写入 context['attendance_id']
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            body: AttendanceListToDayDetailBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_list_to_day_detail(
                attendanceTimeId="<attendance_time_id>",
                attendanceId="<attendance_id>"
            )
        """
        return self._invoke(
            "attendance-008",
            fields={
                "attendanceTimeId": attendanceTimeId,
                "attendanceId": attendanceId,
                "type": type,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_request_add_task(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · requestAddTask

        接口：POST /attweb/attendanceSignTask/app/add（attendance-009）
        源码方法：requestAddTask
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_request_add_task()
        """
        return self._invoke(
            "attendance-009",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_request_delete_task(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · requestDeleteTask

        接口：POST /attweb/attendanceSignTask/app/delete（attendance-010）
        源码方法：requestDeleteTask
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_request_delete_task()
        """
        return self._invoke(
            "attendance-010",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_request_update_task(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · requestUpdateTask

        接口：POST /attweb/attendanceSignTask/app/update（attendance-011）
        源码方法：requestUpdateTask
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_request_update_task()
        """
        return self._invoke(
            "attendance-011",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_request_task_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · requestTaskList

        接口：POST /attweb/attendanceSignTask/brand/brandBillBoard（attendance-012）
        源码方法：requestTaskList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_request_task_list()
        """
        return self._invoke(
            "attendance-012",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_request_task_detail(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · requestTaskDetail

        接口：POST /attweb/attendanceSignTask/brand/get（attendance-013）
        源码方法：requestTaskDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_request_task_detail()
        """
        return self._invoke(
            "attendance-013",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_request_my_task_list(
        self,
        *,
        status: str = 'not_start',
        pageNo: int = 1,
        pageSize: int = 20,
        studentId: str | None = None,
        schoolId: str | None = None,
        body: AttendanceRequestMyTaskListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · 打卡任务列表

        接口：POST /attweb/attendanceSignTask/brand/list（attendance-014）
        源码方法：requestMyTaskList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：studentId、schoolId

        JSON 请求体（application/json）：
            status: str（可选，默认 "not_start"）
                状态筛选；取值随接口（如 not_start/0/1）
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 20）
                每页条数；服务端混用 str/int，按模板类型传
            studentId: str | None（自动）
                学生 ID；占位符 {student_id} 自动发现或由参数写入 context
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            body: AttendanceRequestMyTaskListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_request_my_task_list(
                studentId=client.context["student_id"],
                schoolId=client.context["school_id"]
            )
        """
        return self._invoke(
            "attendance-014",
            fields={
                "status": status,
                "pageNo": pageNo,
                "pageSize": pageSize,
                "studentId": studentId,
                "schoolId": schoolId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_request_sign_task(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · requestSignTask

        接口：POST /attweb/attendanceSignTask/brand/sign（attendance-015）
        源码方法：requestSignTask
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_request_sign_task()
        """
        return self._invoke(
            "attendance-015",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_query_brand_attendance_by_class_ids(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · queryBrandAttendanceByClassIds

        接口：POST /face/cloud-face/attendance/brand/app/v2/queryBrandAttendanceByClassIds（attendance-016）
        源码方法：queryBrandAttendanceByClassIds
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_query_brand_attendance_by_class_ids()
        """
        return self._invoke(
            "attendance-016",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_attendance(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · attendance

        接口：POST /face/cloud-face/attendance/peopleAttendance（attendance-017）
        源码方法：attendance
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_attendance()
        """
        return self._invoke(
            "attendance-017",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def attendance_get_attencelist(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考勤与打卡 · getAttencelist

        接口：POST /face/cloud-face/attendance/viewCbAttendance（attendance-018）
        源码方法：getAttencelist
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.attendance_get_attencelist()
        """
        return self._invoke(
            "attendance-018",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def card_verify_teacher_login(
        self,
        *,
        password: str | None = None,
        userId: str | None = None,
        body: CardVerifyTeacherLoginBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """刷卡、人脸与身份识别 · verifyTeacherLogin

        接口：POST /brand/brand/Authority/checkIotControlByPassword（card-001）
        源码方法：verifyTeacherLogin
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：password、userId

        JSON 请求体（application/json）：
            password: str | None（必填）
                门禁密码（不是登录密码）；占位符 {door_password} 需传参或写入 context['door_password']
            userId: str | None（必填）
                用户 ID；学生或教师，随接口；占位符 {teacher_id} 需传参或写入 context['teacher_id']
            body: CardVerifyTeacherLoginBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.card_verify_teacher_login(password="<door_password>", userId="<teacher_id>")
        """
        return self._invoke(
            "card-001",
            fields={"password": password, "userId": userId},
            body=body,
            extra=extra,
            full=full,
        )

    def card_select_new_student_by_ic_card(
        self,
        *,
        userId: str | None = None,
        type: str = '1',
        body: CardSelectNewStudentByIcCardBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """刷卡、人脸与身份识别 · 刷卡：学生信息

        接口：POST /brand/brand/Authority/selectStudentByIcCard（card-002）
        源码方法：selectNewStudentByIcCard
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：userId

        JSON 请求体（application/json）：
            userId: str | None（自动）
                学生 ID；占位符 {student_id} 自动发现或由参数写入 context
            type: str（可选，默认 "1"）
                用户类型（学生固定 1）
            body: CardSelectNewStudentByIcCardBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.card_select_new_student_by_ic_card(userId=client.context["student_id"])
        """
        return self._invoke(
            "card-002",
            fields={"userId": userId, "type": type},
            body=body,
            extra=extra,
            full=full,
        )

    def card_select_new_student_by_ic_card_2(
        self,
        *,
        userId: str | None = None,
        type: str = '1',
        body: CardSelectNewStudentByIcCard2Body | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """刷卡、人脸与身份识别 · 刷卡：学生信息

        接口：POST /brand/brand/Authority/selectStudentByIcCard（card-003）
        源码方法：selectNewStudentByIcCard
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：userId

        JSON 请求体（application/json）：
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            type: str（可选，默认 "1"）
                用户类型（学生固定 1）
            body: CardSelectNewStudentByIcCard2Body | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.card_select_new_student_by_ic_card_2(userId=client.context["student_id"])
        """
        return self._invoke(
            "card-003",
            fields={"userId": userId, "type": type},
            body=body,
            extra=extra,
            full=full,
        )

    def card_select_new_teacher_by_classes_id(
        self,
        *,
        teacherId: str | None = None,
        icCardNo: str | None = None,
        body: CardSelectNewTeacherByClassesIdBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """刷卡、人脸与身份识别 · selectNewTeacherByClassesId

        接口：POST /brand/brand/Authority/selectTeacherByClassesId（card-004）
        源码方法：selectNewTeacherByClassesId
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：teacherId、icCardNo

        JSON 请求体（application/json）：
            teacherId: str | None（必填）
                教师 ID；占位符 {teacher_id} 需传参或写入 context['teacher_id']
            icCardNo: str | None（必填）
                IC 卡号；占位符 {ic_card_no} 需传参或写入 context['ic_card_no']
            body: CardSelectNewTeacherByClassesIdBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.card_select_new_teacher_by_classes_id(teacherId="<teacher_id>", icCardNo="<ic_card_no>")
        """
        return self._invoke(
            "card-004",
            fields={"teacherId": teacherId, "icCardNo": icCardNo},
            body=body,
            extra=extra,
            full=full,
        )

    def card_select_new_teacher_by_ic_card(
        self,
        *,
        userId: str | None = None,
        type: str = '1',
        body: CardSelectNewTeacherByIcCardBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """刷卡、人脸与身份识别 · 刷卡：教师信息

        接口：POST /brand/brand/Authority/selectTeacherByIcCard（card-005）
        源码方法：selectNewTeacherByIcCard
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：userId

        JSON 请求体（application/json）：
            userId: str | None（必填）
                用户 ID；学生或教师，随接口；占位符 {teacher_id} 需传参或写入 context['teacher_id']
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            body: CardSelectNewTeacherByIcCardBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.card_select_new_teacher_by_ic_card(userId="<teacher_id>")
        """
        return self._invoke(
            "card-005",
            fields={"userId": userId, "type": type},
            body=body,
            extra=extra,
            full=full,
        )

    def card_select_teacher_info_by_card_or_face(
        self,
        *,
        userId: str | None = None,
        type: str = '1',
        body: CardSelectTeacherInfoByCardOrFaceBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """刷卡、人脸与身份识别 · 刷卡：教师信息

        接口：POST /brand/brand/Authority/selectTeacherByIcCard（card-006）
        源码方法：selectTeacherInfoByCardOrFace
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：userId

        JSON 请求体（application/json）：
            userId: str | None（必填）
                用户 ID；学生或教师，随接口；占位符 {teacher_id} 需传参或写入 context['teacher_id']
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            body: CardSelectTeacherInfoByCardOrFaceBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.card_select_teacher_info_by_card_or_face(userId="<teacher_id>")
        """
        return self._invoke(
            "card-006",
            fields={"userId": userId, "type": type},
            body=body,
            extra=extra,
            full=full,
        )

    def card_select_new_user_info_by_ic_card(
        self,
        *,
        icCardNo: str | None = None,
        body: CardSelectNewUserInfoByIcCardBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """刷卡、人脸与身份识别 · 刷卡：卡号换用户（判断学生/教师）

        接口：POST /brand/brand/Authority/selectUserInfoByIcCard（card-007）
        源码方法：selectNewUserInfoByIcCard
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：icCardNo

        JSON 请求体（application/json）：
            icCardNo: str | None（必填）
                IC 卡号；占位符 {ic_card_no} 需传参或写入 context['ic_card_no']
            body: CardSelectNewUserInfoByIcCardBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.card_select_new_user_info_by_ic_card(icCardNo="<ic_card_no>")
        """
        return self._invoke(
            "card-007",
            fields={"icCardNo": icCardNo},
            body=body,
            extra=extra,
            full=full,
        )

    def card_select_user_by_card_or_face(
        self,
        *,
        icCardNo: str | None = None,
        body: CardSelectUserByCardOrFaceBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """刷卡、人脸与身份识别 · 刷卡：卡号换用户（判断学生/教师）

        接口：POST /brand/brand/Authority/selectUserInfoByIcCard（card-008）
        源码方法：selectUserByCardOrFace
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：icCardNo

        JSON 请求体（application/json）：
            icCardNo: str | None（必填）
                IC 卡号；占位符 {ic_card_no} 需传参或写入 context['ic_card_no']
            body: CardSelectUserByCardOrFaceBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.card_select_user_by_card_or_face(icCardNo="<ic_card_no>")
        """
        return self._invoke(
            "card-008",
            fields={"icCardNo": icCardNo},
            body=body,
            extra=extra,
            full=full,
        )

    def card_select_teacher_by_ic_card(
        self,
        *,
        icCardNo: str | None = None,
        body: CardSelectTeacherByIcCardBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """刷卡、人脸与身份识别 · selectTeacherByIcCard

        接口：POST /brand/class-brand-management/Android/Authority/selectTeacherByIcCard（card-009）
        源码方法：selectTeacherByIcCard
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：icCardNo

        JSON 请求体（application/json）：
            icCardNo: str | None（必填）
                IC 卡号；占位符 {ic_card_no} 需传参或写入 context['ic_card_no']
            body: CardSelectTeacherByIcCardBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.card_select_teacher_by_ic_card(icCardNo="<ic_card_no>")
        """
        return self._invoke(
            "card-009",
            fields={"icCardNo": icCardNo},
            body=body,
            extra=extra,
            full=full,
        )

    def card_select_student_by_ic_card(
        self,
        *,
        icCardNo: str | None = None,
        body: CardSelectStudentByIcCardBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """刷卡、人脸与身份识别 · selectStudentByIcCard

        接口：POST /brand/class-brand-management/android/studentspace/selectStudentByIcCard（card-010）
        源码方法：selectStudentByIcCard
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：icCardNo

        JSON 请求体（application/json）：
            icCardNo: str | None（必填）
                IC 卡号；占位符 {ic_card_no} 需传参或写入 context['ic_card_no']
            body: CardSelectStudentByIcCardBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.card_select_student_by_ic_card(icCardNo="<ic_card_no>")
        """
        return self._invoke(
            "card-010",
            fields={"icCardNo": icCardNo},
            body=body,
            extra=extra,
            full=full,
        )

    def card_pausch_card(
        self,
        *,
        deviceNo: str | None = None,
        studentId: str | None = None,
        type: str = '1',
        body: CardPauschCardBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """刷卡、人脸与身份识别 · pauschCard

        接口：POST /brand/upload/signInLog（card-011）
        源码方法：pauschCard
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：deviceNo、studentId

        JSON 请求体（application/json）：
            deviceNo: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            studentId: str | None（自动）
                学生 ID；占位符 {student_id} 自动发现或由参数写入 context
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            body: CardPauschCardBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.card_pausch_card(deviceNo=client.context["mac"], studentId=client.context["student_id"])
        """
        return self._invoke(
            "card-011",
            fields={
                "deviceNo": deviceNo,
                "studentId": studentId,
                "type": type,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_request_leave_length(
        self,
        *,
        startTime: str = '2026-10-20 08:00:00',
        endTime: str = '2026-10-20 12:00:00',
        durationType: str = '1',
        durationWay: str = '1',
        userId: str | None = None,
        body: UserspaceRequestLeaveLengthBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestLeaveLength

        接口：POST /app/actLeaveVacation/calculateLeaveDays（userspace-001）
        源码方法：requestLeaveLength
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：userId

        JSON 请求体（application/json）：
            startTime: str（可选，默认 "2026-10-20 08:00:00"）
                开始时间，yyyy-MM-dd HH:mm:ss
            endTime: str（可选，默认 "2026-10-20 12:00:00"）
                结束时间，yyyy-MM-dd HH:mm:ss
            durationType: str（可选，默认 "1"）
                请假时长类型（服务端枚举，不同学校取值不同）
            durationWay: str（可选，默认 "1"）
                请假时长计算方式（服务端枚举）
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            body: UserspaceRequestLeaveLengthBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_leave_length(userId=client.context["student_id"])
        """
        return self._invoke(
            "userspace-001",
            fields={
                "startTime": startTime,
                "endTime": endTime,
                "durationType": durationType,
                "durationWay": durationWay,
                "userId": userId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_request_student_leave_form(self, *, full: bool = False, **extra: Any) -> Any:
        """学生空间、请假与报修 · requestStudentLeaveForm

        接口：GET /app/formProcessTemplates/getDefaultStudentLeave（userspace-002）
        源码方法：requestStudentLeaveForm
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_student_leave_form()
        """
        return self._invoke(
            "userspace-002",
            fields={},
            extra=extra,
            full=full,
        )

    def userspace_request_repair_list(
        self,
        *,
        pageNo: int = 1,
        pageSize: int = 20,
        schoolId: str | None = None,
        siteId: str | None = None,
        queryNewStatus: bool = True,
        body: UserspaceRequestRepairListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestRepairList

        接口：POST /app/userAppr/pageDeviceAppr（userspace-003）
        源码方法：requestRepairList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：schoolId、siteId

        JSON 请求体（application/json）：
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 20）
                每页条数；服务端混用 str/int，按模板类型传
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            siteId: str | None（自动）
                场地 ID；占位符 {site_id} /brand/obtain 后写入 context
            queryNewStatus: bool（可选，默认 True）
                是否只查新状态
            body: UserspaceRequestRepairListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_repair_list(
                schoolId=client.context["school_id"],
                siteId=client.context["site_id"]
            )
        """
        return self._invoke(
            "userspace-003",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "schoolId": schoolId,
                "siteId": siteId,
                "queryNewStatus": queryNewStatus,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_request_leave_detail(
        self,
        *,
        id: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestLeaveDetail

        接口：GET /app/userAppr/v2/getInfo（userspace-004）
        源码方法：requestLeaveDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_leave_detail(id=client.context["brand_id"])
        """
        return self._invoke(
            "userspace-004",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def userspace_request_revoke_leave(
        self,
        *,
        processInstanceId: str | None = None,
        schoolId: str | None = None,
        assigneeId: str | None = None,
        sponsorType: int = 0,
        assigneeName: str | None = None,
        body: UserspaceRequestRevokeLeaveBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestRevokeLeave

        接口：POST /app/v2/proc/deleteInstance（userspace-005）
        源码方法：requestRevokeLeave
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：processInstanceId
        自动：schoolId、assigneeId、assigneeName

        JSON 请求体（application/json）：
            processInstanceId: str | None（必填）
                流程实例 ID；占位符 {process_instance_id} 需传参或写入
                context['process_instance_id']
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            assigneeId: str | None（自动）
                审批人/办理人 ID；占位符 {student_id} 自动发现或由参数写入 context
            sponsorType: int（可选，默认 0）
                发起人类型（0/1）
            assigneeName: str | None（自动）
                审批人/办理人姓名；占位符 {student_name} 自动发现学生后写入 context
            body: UserspaceRequestRevokeLeaveBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_revoke_leave(processInstanceId="<process_instance_id>")
        """
        return self._invoke(
            "userspace-005",
            fields={
                "processInstanceId": processInstanceId,
                "schoolId": schoolId,
                "assigneeId": assigneeId,
                "sponsorType": sponsorType,
                "assigneeName": assigneeName,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_request_student_leave_process(
        self,
        *,
        fromKey: str | None = None,
        studentId: str | None = None,
        fromComponent: str = '{}',
        body: UserspaceRequestStudentLeaveProcessBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · 请假/报修审批流节点

        接口：POST /app/v2/proc/getFlowElements（userspace-006）
        源码方法：requestStudentLeaveProcess
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：fromKey、studentId

        JSON 请求体（application/json）：
            fromKey: str | None（自动）
                流程表单标识，如 studentLeave_{schoolId}；占位符 {school_id} 取学校配置或 /brand/obtain
            studentId: str | None（自动）
                学生 ID；占位符 {student_id} 自动发现或由参数写入 context
            fromComponent: str（可选，默认 "{}"）
                表单组件数据（JSON 字符串）
            body: UserspaceRequestStudentLeaveProcessBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_student_leave_process(studentId=client.context["student_id"])
        """
        return self._invoke(
            "userspace-006",
            fields={
                "fromKey": fromKey,
                "studentId": studentId,
                "fromComponent": fromComponent,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_request_leave_record(
        self,
        *,
        pageNo: int = 1,
        pageSize: int = 20,
        type: int = 3,
        assignee: str | None = None,
        fromKey: str | None = None,
        queryNewStatus: bool = True,
        body: UserspaceRequestLeaveRecordBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestLeaveRecord

        接口：POST /app/v2/proc/pageTask（userspace-007）
        源码方法：requestLeaveRecord
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：assignee、fromKey

        JSON 请求体（application/json）：
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 20）
                每页条数；服务端混用 str/int，按模板类型传
            type: int（可选，默认 3）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            assignee: str | None（自动）
                当前处理人 ID（通常为学生 ID）；占位符 {student_id} 自动发现或由参数写入 context
            fromKey: str | None（自动）
                流程表单标识，如 studentLeave_{schoolId}；占位符 {school_id} 取学校配置或 /brand/obtain
            queryNewStatus: bool（可选，默认 True）
                是否只查新状态
            body: UserspaceRequestLeaveRecordBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_leave_record(assignee=client.context["student_id"])
        """
        return self._invoke(
            "userspace-007",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "type": type,
                "assignee": assignee,
                "fromKey": fromKey,
                "queryNewStatus": queryNewStatus,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_request_submit_student_leave(
        self,
        *,
        fromKey: str | None = None,
        formItems: str = '[]',
        assigneeId: str | None = None,
        assigneeName: str | None = None,
        flowElementList: List[Any] | None = None,
        body: UserspaceRequestSubmitStudentLeaveBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · 提交请假/报修

        接口：POST /app/v2/proc/startInstance（userspace-008）
        源码方法：requestSubmitStudentLeave
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：fromKey、assigneeId、assigneeName

        JSON 请求体（application/json）：
            fromKey: str | None（自动）
                流程表单标识，如 studentLeave_{schoolId}；占位符 {school_id} 取学校配置或 /brand/obtain
            formItems: str（可选，默认 "[]"）
                动态表单作答（JSON 字符串）
            assigneeId: str | None（自动）
                审批人/办理人 ID；占位符 {student_id} 自动发现或由参数写入 context
            assigneeName: str | None（自动）
                审批人/办理人姓名；占位符 {student_name} 自动发现学生后写入 context
            flowElementList: List[Any] | None（可选，默认 []）
                审批流节点列表
            body: UserspaceRequestSubmitStudentLeaveBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_submit_student_leave(
                assigneeId=client.context["student_id"],
                assigneeName=client.context["student_name"]
            )
        """
        return self._invoke(
            "userspace-008",
            fields={
                "fromKey": fromKey,
                "formItems": formItems,
                "assigneeId": assigneeId,
                "assigneeName": assigneeName,
                "flowElementList": flowElementList,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_request_form_modify(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestFormModify

        接口：POST /app/v2/proc/updateApprovalProc（userspace-009）
        源码方法：requestFormModify
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_form_modify()
        """
        return self._invoke(
            "userspace-009",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_request_leave_type_option(
        self,
        *,
        type: str = '1',
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestLeaveTypeOption

        接口：GET /cloud/actLeaveVacation/list（userspace-010）
        源码方法：requestLeaveTypeOption
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        Query 参数：
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_leave_type_option()
        """
        return self._invoke(
            "userspace-010",
            fields={"type": type},
            extra=extra,
            full=full,
        )

    def userspace_get_address_book(
        self,
        *,
        studentId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · getAddressBook

        接口：GET /cloud/address/book/student（userspace-011）
        源码方法：getAddressBook
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：studentId

        Query 参数：
            studentId: str | None（自动）
                学生 ID；占位符 {student_id} 自动发现或由参数写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_get_address_book(studentId=client.context["student_id"])
        """
        return self._invoke(
            "userspace-011",
            fields={"studentId": studentId},
            extra=extra,
            full=full,
        )

    def userspace_delete_instance(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · deleteInstance

        接口：POST /cloud/app/procAppr/deleteInstance（userspace-012）
        源码方法：deleteInstance
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_delete_instance()
        """
        return self._invoke(
            "userspace-012",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_request_old_revoke_leave(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestOldRevokeLeave

        接口：POST /cloud/app/procAppr/deleteInstance（userspace-013）
        源码方法：requestOldRevokeLeave
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_old_revoke_leave()
        """
        return self._invoke(
            "userspace-013",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_get_approver(
        self,
        *,
        startDate: str = '',
        endDate: str = '',
        classesId: str | None = None,
        identity: str = '0',
        id: str | None = None,
        body: UserspaceGetApproverBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · getApprover

        接口：POST /cloud/app/procAppr/getApprList（userspace-014）
        源码方法：getApprover
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId、id

        JSON 请求体（application/json）：
            startDate: str（可选，默认 空字符串）
                开始日期，yyyy-MM-dd
            endDate: str（可选，默认 空字符串）
                结束日期，yyyy-MM-dd
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            identity: str（可选，默认 "0"）
                身份类型：0 学生 / 1 教师（不同接口可能相反）
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {student_id} 自动发现或由参数写入 context
            body: UserspaceGetApproverBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_get_approver(
                classesId=client.context["classes_id"],
                id=client.context["student_id"]
            )
        """
        return self._invoke(
            "userspace-014",
            fields={
                "startDate": startDate,
                "endDate": endDate,
                "classesId": classesId,
                "identity": identity,
                "id": id,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_get_approver_info(self, *, id: str | None = None, full: bool = False, **extra: Any) -> Any:
        """学生空间、请假与报修 · getApproverInfo

        接口：GET /cloud/app/userAppr/getInfo（userspace-015）
        源码方法：getApproverInfo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_get_approver_info(id=client.context["brand_id"])
        """
        return self._invoke(
            "userspace-015",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def userspace_request_old_leave_detail(
        self,
        *,
        id: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestOldLeaveDetail

        接口：GET /cloud/app/userAppr/getInfo（userspace-016）
        源码方法：requestOldLeaveDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_old_leave_detail(id=client.context["brand_id"])
        """
        return self._invoke(
            "userspace-016",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def userspace_ask_for_leave_record_band_list(
        self,
        *,
        pageNo: str = '1',
        pageSize: str = '20',
        userId: str | None = None,
        body: UserspaceAskForLeaveRecordBandListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · askForLeaveRecordBandList

        接口：POST /cloud/app/userAppr/page（userspace-017）
        源码方法：askForLeaveRecordBandList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：userId

        JSON 请求体（application/json）：
            pageNo: str（可选，默认 "1"）
                页码，从 1 开始
            pageSize: str（可选，默认 "20"）
                每页条数；服务端混用 str/int，按模板类型传
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            body: UserspaceAskForLeaveRecordBandListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_ask_for_leave_record_band_list(userId=client.context["student_id"])
        """
        return self._invoke(
            "userspace-017",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "userId": userId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_request_repair_form(
        self,
        *,
        formKey: str = 'teacherDeviceRepair',
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestRepairForm

        接口：GET /cloud/formProcessTemplates/getByKey（userspace-018）
        源码方法：requestRepairForm
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        Query 参数：
            formKey: str（可选，默认 "teacherDeviceRepair"）
                表单模板 key，如 teacherDeviceRepair

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_repair_form()
        """
        return self._invoke(
            "userspace-018",
            fields={"formKey": formKey},
            extra=extra,
            full=full,
        )

    def userspace_request_add_comments(
        self,
        *,
        classesId: str | None = None,
        content: str = '测试意见',
        userId: str | None = None,
        type: str = '1',
        anonymity: bool = False,
        body: UserspaceRequestAddCommentsBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestAddComments

        接口：POST /cloud/leaveWord/brand/create（userspace-019）
        源码方法：requestAddComments
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId、userId

        JSON 请求体（application/json）：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            content: str（可选，默认 "测试意见"）
                意见/评论内容
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            anonymity: bool（可选，默认 False）
                是否匿名提交
            body: UserspaceRequestAddCommentsBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_add_comments(
                classesId=client.context["classes_id"],
                userId=client.context["student_id"]
            )
        """
        return self._invoke(
            "userspace-019",
            fields={
                "classesId": classesId,
                "content": content,
                "userId": userId,
                "type": type,
                "anonymity": anonymity,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_request_comments_delete(
        self,
        *,
        id: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestCommentsDelete

        接口：GET /cloud/leaveWord/delete（userspace-020）
        源码方法：requestCommentsDelete
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_comments_delete(id=client.context["brand_id"])
        """
        return self._invoke(
            "userspace-020",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def userspace_request_comments_detail(
        self,
        *,
        id: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestCommentsDetail

        接口：GET /cloud/leaveWord/get（userspace-021）
        源码方法：requestCommentsDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_comments_detail(id=client.context["brand_id"])
        """
        return self._invoke(
            "userspace-021",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def userspace_get_leave_word_setting(self, *, type: str = '1', full: bool = False, **extra: Any) -> Any:
        """学生空间、请假与报修 · getLeaveWordSetting

        接口：GET /cloud/leaveWord/getLeaveWordSetting（userspace-022）
        源码方法：getLeaveWordSetting
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        Query 参数：
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_get_leave_word_setting()
        """
        return self._invoke(
            "userspace-022",
            fields={"type": type},
            extra=extra,
            full=full,
        )

    def userspace_request_comments_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · requestCommentsList

        接口：POST /cloud/leaveWord/page（userspace-023）
        源码方法：requestCommentsList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_request_comments_list()
        """
        return self._invoke(
            "userspace-023",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_add_leave(
        self,
        *,
        jsonData: str = '{}',
        procId: str = 'proc-1',
        dept: str = 'dept-1',
        isBack: bool = False,
        deptName: str = '一年级1班',
        apprs: List[Any] | None = None,
        ccIds: str = '',
        sponsorType: str = '0',
        identityUserId: str | None = None,
        body: UserspaceAddLeaveBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · addLeave

        接口：POST /cloud/proc/startInstance（userspace-024）
        源码方法：addLeave
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：identityUserId

        JSON 请求体（application/json）：
            jsonData: str（可选，默认 "{}"）
                流程业务数据（JSON 字符串）
            procId: str（可选，默认 "proc-1"）
                流程定义 ID
            dept: str（可选，默认 "dept-1"）
                部门 ID
            isBack: bool（可选，默认 False）
                是否退回
            deptName: str（可选，默认 "一年级1班"）
                部门/班级名称
            apprs: List[Any] | None（可选，默认 []）
                审批人列表（流程节点）
            ccIds: str（可选，默认 空字符串）
                抄送人 ID，逗号分隔
            sponsorType: str（可选，默认 "0"）
                发起人类型（0/1）
            identityUserId: str | None（自动）
                身份用户 ID（学生/教师 ID）；占位符 {student_id} 自动发现或由参数写入 context
            body: UserspaceAddLeaveBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_add_leave(identityUserId=client.context["student_id"])
        """
        return self._invoke(
            "userspace-024",
            fields={
                "jsonData": jsonData,
                "procId": procId,
                "dept": dept,
                "isBack": isBack,
                "deptName": deptName,
                "apprs": apprs,
                "ccIds": ccIds,
                "sponsorType": sponsorType,
                "identityUserId": identityUserId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_all_students(
        self,
        *,
        pageNo: int = 1,
        pageSize: int = 100,
        id: str | None = None,
        type: int = 4,
        key: str = 'classes',
        body: UserspaceAllStudentsBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · 班级学生列表

        接口：POST /cloud/student/allStudents（userspace-025）
        源码方法：allStudents
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        JSON 请求体（application/json）：
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 100）
                每页条数；服务端混用 str/int，按模板类型传
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {classes_id} /brand/obtain 后写入 context
            type: int（可选，默认 4）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            key: str（可选，默认 "classes"）
                查询键；班级学生列表固定 classes
            body: UserspaceAllStudentsBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_all_students(id=client.context["classes_id"])
        """
        return self._invoke(
            "userspace-025",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "id": id,
                "type": type,
                "key": key,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def userspace_leave_commit(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """学生空间、请假与报修 · LeaveCommit

        接口：POST /leave-server/cloud-leave/student/addStudentLeaveByStudentUserId（userspace-026）
        源码方法：LeaveCommit
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.userspace_leave_commit()
        """
        return self._invoke(
            "userspace-026",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def activity_request_login_active_details(
        self,
        *,
        activityId: str | None = None,
        userId: str | None = None,
        identifyType: int = 0,
        body: ActivityRequestLoginActiveDetailsBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """活动与报名 · requestLoginActiveDetails

        接口：POST /brand/activity/enroll/activityEnrollInfo（activity-001）
        源码方法：requestLoginActiveDetails
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：activityId
        自动：userId

        JSON 请求体（application/json）：
            activityId: str | None（必填）
                活动 ID；占位符 {activity_id} 需传参或写入 context['activity_id']
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            identifyType: int（可选，默认 0）
                身份类型：0 学生 / 1 教师（活动接口用 0）
            body: ActivityRequestLoginActiveDetailsBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.activity_request_login_active_details(activityId="<activity_id>")
        """
        return self._invoke(
            "activity-001",
            fields={
                "activityId": activityId,
                "userId": userId,
                "identifyType": identifyType,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def activity_request_active_details(
        self,
        *,
        activityId: str | None = None,
        body: ActivityRequestActiveDetailsBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """活动与报名 · requestActiveDetails

        接口：POST /brand/activity/enroll/detail（activity-002）
        源码方法：requestActiveDetails
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：activityId

        JSON 请求体（application/json）：
            activityId: str | None（必填）
                活动 ID；占位符 {activity_id} 需传参或写入 context['activity_id']
            body: ActivityRequestActiveDetailsBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.activity_request_active_details(activityId="<activity_id>")
        """
        return self._invoke(
            "activity-002",
            fields={"activityId": activityId},
            body=body,
            extra=extra,
            full=full,
        )

    def activity_request_active_list(
        self,
        *,
        pageNo: int = 1,
        pageSize: int = 10,
        body: ActivityRequestActiveListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """活动与报名 · 活动列表

        接口：POST /brand/activity/enroll/page（activity-003）
        源码方法：requestActiveList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体（application/json）：
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 10）
                每页条数；服务端混用 str/int，按模板类型传
            body: ActivityRequestActiveListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.activity_request_active_list()
        """
        return self._invoke(
            "activity-003",
            fields={"pageNo": pageNo, "pageSize": pageSize},
            body=body,
            extra=extra,
            full=full,
        )

    def activity_request_active_registration(
        self,
        *,
        activityId: str | None = None,
        userId: str | None = None,
        identifyType: int = 0,
        activitySubIds: List[Any] | None = None,
        body: ActivityRequestActiveRegistrationBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """活动与报名 · requestActiveRegistration

        接口：POST /brand/activity/enroll/userActivityEnroll（activity-004）
        源码方法：requestActiveRegistration
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：activityId
        自动：userId

        JSON 请求体（application/json）：
            activityId: str | None（必填）
                活动 ID；占位符 {activity_id} 需传参或写入 context['activity_id']
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            identifyType: int（可选，默认 0）
                身份类型：0 学生 / 1 教师（活动接口用 0）
            activitySubIds: List[Any] | None（可选，默认 []）
                活动子项 ID 列表
            body: ActivityRequestActiveRegistrationBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.activity_request_active_registration(activityId="<activity_id>")
        """
        return self._invoke(
            "activity-004",
            fields={
                "activityId": activityId,
                "userId": userId,
                "identifyType": identifyType,
                "activitySubIds": activitySubIds,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def activity_request_my_registration_list(
        self,
        *,
        pageNo: int = 1,
        pageSize: int = 10,
        activityName: str = '',
        userId: str | None = None,
        body: ActivityRequestMyRegistrationListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """活动与报名 · requestMyRegistrationList

        接口：POST /brand/activity/enroll/userEnrollPage（activity-005）
        源码方法：requestMyRegistrationList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：userId

        JSON 请求体（application/json）：
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 10）
                每页条数；服务端混用 str/int，按模板类型传
            activityName: str（可选，默认 空字符串）
                活动名称（模糊筛选）
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            body: ActivityRequestMyRegistrationListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.activity_request_my_registration_list(userId=client.context["student_id"])
        """
        return self._invoke(
            "activity-005",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "activityName": activityName,
                "userId": userId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_evaluation_medal_details(
        self,
        *,
        medalCode: str | None = None,
        body: HonorRequestEvaluationMedalDetailsBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestEvaluationMedalDetails

        接口：POST /brand/appEvalMedal/getUserMedalInfo（honor-001）
        源码方法：requestEvaluationMedalDetails
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：medalCode

        JSON 请求体（application/json）：
            medalCode: str | None（必填）
                勋章编码；占位符 {medal_code} 需传参或写入 context['medal_code']
            body: HonorRequestEvaluationMedalDetailsBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_evaluation_medal_details(medalCode="<medal_code>")
        """
        return self._invoke(
            "honor-001",
            fields={"medalCode": medalCode},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_evaluation_medal_type_list(self, *, full: bool = False, **extra: Any) -> Any:
        """德育评价、荣誉与勋章 · requestEvaluationMedalTypeList

        接口：GET /brand/appEvalMedal/listEvalMedalType（honor-002）
        源码方法：requestEvaluationMedalTypeList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_evaluation_medal_type_list()
        """
        return self._invoke(
            "honor-002",
            fields={},
            extra=extra,
            full=full,
        )

    def honor_request_evaluation_medal_page_list(
        self,
        *,
        pageNo: int = 1,
        pageSize: int = 20,
        personId: str | None = None,
        identity: int = 0,
        body: HonorRequestEvaluationMedalPageListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestEvaluationMedalPageList

        接口：POST /brand/appEvalMedal/pageEvalUserMedal（honor-003）
        源码方法：requestEvaluationMedalPageList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：personId

        JSON 请求体（application/json）：
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 20）
                每页条数；服务端混用 str/int，按模板类型传
            personId: str | None（自动）
                人员 ID（学生/教师）；占位符 {student_id} 自动发现或由参数写入 context
            identity: int（可选，默认 0）
                身份类型：0 学生 / 1 教师（不同接口可能相反）
            body: HonorRequestEvaluationMedalPageListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_evaluation_medal_page_list(personId=client.context["student_id"])
        """
        return self._invoke(
            "honor-003",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "personId": personId,
                "identity": identity,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_evaluation_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestEvaluationList

        接口：POST /brand/evalDataCountStatistic/rankListByClass（honor-004）
        源码方法：requestEvaluationList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_evaluation_list()
        """
        return self._invoke(
            "honor-004",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_evaluation_point_details(
        self,
        *,
        personId: str | None = None,
        identity: str = '0',
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestEvaluationPointDetails

        接口：GET /brand/evalPersonScore/getEvalPersonScoreInfo（honor-005）
        源码方法：requestEvaluationPointDetails
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：personId

        Query 参数：
            personId: str | None（自动）
                人员 ID（学生/教师）；占位符 {student_id} 自动发现或由参数写入 context
            identity: str（可选，默认 "0"）
                身份类型：0 学生 / 1 教师（不同接口可能相反）

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_evaluation_point_details(personId=client.context["student_id"])
        """
        return self._invoke(
            "honor-005",
            fields={"personId": personId, "identity": identity},
            extra=extra,
            full=full,
        )

    def honor_request_evaluation_point_card_details(
        self,
        *,
        personId: str | None = None,
        body: HonorRequestEvaluationPointCardDetailsBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestEvaluationPointCardDetails

        接口：POST /brand/evalScoreCard/getUserScoreCardInfo（honor-006）
        源码方法：requestEvaluationPointCardDetails
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：personId

        JSON 请求体（application/json）：
            personId: str | None（自动）
                人员 ID（学生/教师）；占位符 {student_id} 自动发现或由参数写入 context
            body: HonorRequestEvaluationPointCardDetailsBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_evaluation_point_card_details(personId=client.context["student_id"])
        """
        return self._invoke(
            "honor-006",
            fields={"personId": personId},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_evaluation_point_card_page_list(
        self,
        *,
        pageNo: int | None = None,
        pageSize: int | None = None,
        body: HonorRequestEvaluationPointCardPageListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestEvaluationPointCardPageList

        接口：POST /brand/evalScoreCard/pageUserScoreCard（honor-007）
        源码方法：requestEvaluationPointCardPageList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体（application/json）：
            pageNo: int | None（可选，示例 1）
                页码，从 1 开始
            pageSize: int | None（可选，示例 20）
                每页条数；服务端混用 str/int，按模板类型传
            body: HonorRequestEvaluationPointCardPageListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_evaluation_point_card_page_list()
        """
        return self._invoke(
            "honor-007",
            fields={"pageNo": pageNo, "pageSize": pageSize},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_evaluation_point_page_list(
        self,
        *,
        pageNo: int | None = None,
        pageSize: int | None = None,
        personId: str | None = None,
        body: HonorRequestEvaluationPointPageListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestEvaluationPointPageList

        接口：POST /brand/evalScoreRecord/page（honor-008）
        源码方法：requestEvaluationPointPageList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：personId

        JSON 请求体（application/json）：
            pageNo: int | None（可选，示例 1）
                页码，从 1 开始
            pageSize: int | None（可选，示例 20）
                每页条数；服务端混用 str/int，按模板类型传
            personId: str | None（自动）
                人员 ID（学生/教师）；占位符 {student_id} 自动发现或由参数写入 context
            body: HonorRequestEvaluationPointPageListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_evaluation_point_page_list(personId=client.context["student_id"])
        """
        return self._invoke(
            "honor-008",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "personId": personId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_honor_wall_list(
        self,
        *,
        pageNo: int = 1,
        pageSize: int = 5,
        body: HonorRequestHonorWallListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · 荣誉墙

        接口：POST /cloud/app/honor/brandPage（honor-009）
        源码方法：requestHonorWallList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体（application/json）：
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 5）
                每页条数；服务端混用 str/int，按模板类型传
            body: HonorRequestHonorWallListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_honor_wall_list()
        """
        return self._invoke(
            "honor-009",
            fields={"pageNo": pageNo, "pageSize": pageSize},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_active_detail(
        self,
        *,
        activityId: str | None = None,
        body: HonorRequestActiveDetailBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestActiveDetail

        接口：POST /cloud/evaluationActivityBrand/detail（honor-010）
        源码方法：requestActiveDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：activityId

        JSON 请求体（application/json）：
            activityId: str | None（必填）
                活动 ID；占位符 {activity_id} 需传参或写入 context['activity_id']
            body: HonorRequestActiveDetailBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_active_detail(activityId="<activity_id>")
        """
        return self._invoke(
            "honor-010",
            fields={"activityId": activityId},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_go_to_score(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestGoToScore

        接口：POST /cloud/evaluationActivityBrand/goToScore（honor-011）
        源码方法：requestGoToScore
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_go_to_score()
        """
        return self._invoke(
            "honor-011",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_identity_detail(
        self,
        *,
        personId: str | None = None,
        identity: int | None = None,
        body: HonorRequestIdentityDetailBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestIdentityDetail

        接口：POST /cloud/evaluationActivityBrand/identityDetail（honor-012）
        源码方法：requestIdentityDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：personId

        JSON 请求体（application/json）：
            personId: str | None（自动）
                人员 ID（学生/教师）；占位符 {student_id} 自动发现或由参数写入 context
            identity: int | None（可选，示例 0）
                身份类型：0 学生 / 1 教师（不同接口可能相反）
            body: HonorRequestIdentityDetailBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_identity_detail(personId=client.context["student_id"])
        """
        return self._invoke(
            "honor-012",
            fields={"personId": personId, "identity": identity},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_active_honor_list(
        self,
        *,
        pageNo: int | None = None,
        pageSize: int | None = None,
        body: HonorRequestActiveHonorListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestActiveHonorList

        接口：POST /cloud/evaluationActivityBrand/list（honor-013）
        源码方法：requestActiveHonorList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体（application/json）：
            pageNo: int | None（可选，示例 1）
                页码，从 1 开始
            pageSize: int | None（可选，示例 20）
                每页条数；服务端混用 str/int，按模板类型传
            body: HonorRequestActiveHonorListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_active_honor_list()
        """
        return self._invoke(
            "honor-013",
            fields={"pageNo": pageNo, "pageSize": pageSize},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_activity_cycle(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestActivityCycle

        接口：POST /cloud/evaluationActivityBrand/queryActivityCycle（honor-014）
        源码方法：requestActivityCycle
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_activity_cycle()
        """
        return self._invoke(
            "honor-014",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_class_score_result(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestClassScoreResult

        接口：POST /cloud/evaluationActivityBrand/queryLastClassScoreResult（honor-015）
        源码方法：requestClassScoreResult
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_class_score_result()
        """
        return self._invoke(
            "honor-015",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_active_result_list(
        self,
        *,
        activityId: str | None = None,
        body: HonorRequestActiveResultListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestActiveResultList

        接口：POST /cloud/evaluationActivityBrand/result（honor-016）
        源码方法：requestActiveResultList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：activityId

        JSON 请求体（application/json）：
            activityId: str | None（必填）
                活动 ID；占位符 {activity_id} 需传参或写入 context['activity_id']
            body: HonorRequestActiveResultListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_active_result_list(activityId="<activity_id>")
        """
        return self._invoke(
            "honor-016",
            fields={"activityId": activityId},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_class_score_comment(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestClassScoreComment

        接口：POST /cloud/evaluationActivityBrand/scoreClass（honor-017）
        源码方法：requestClassScoreComment
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_class_score_comment()
        """
        return self._invoke(
            "honor-017",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_student_score_comment(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestStudentScoreComment

        接口：POST /cloud/evaluationActivityBrand/scoreStudent（honor-018）
        源码方法：requestStudentScoreComment
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_student_score_comment()
        """
        return self._invoke(
            "honor-018",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_kids_honor_list(
        self,
        *,
        childrenId: str | None = None,
        pageNo: int = 1,
        pageSize: int = 20,
        body: HonorRequestKidsHonorListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestKidsHonorList

        接口：POST /cloud/evaluationActivityMobile/childrenHonor（honor-019）
        源码方法：requestKidsHonorList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：childrenId

        JSON 请求体（application/json）：
            childrenId: str | None（自动）
                学生（儿童）ID；占位符 {student_id} 自动发现或由参数写入 context
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 20）
                每页条数；服务端混用 str/int，按模板类型传
            body: HonorRequestKidsHonorListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_kids_honor_list(childrenId=client.context["student_id"])
        """
        return self._invoke(
            "honor-019",
            fields={
                "childrenId": childrenId,
                "pageNo": pageNo,
                "pageSize": pageSize,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_class_honor_list(
        self,
        *,
        pageNo: int | None = None,
        pageSize: int | None = None,
        classesId: str | None = None,
        body: HonorRequestClassHonorListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestClassHonorList

        接口：POST /cloud/evaluationPrize/classHonor（honor-020）
        源码方法：requestClassHonorList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        JSON 请求体（application/json）：
            pageNo: int | None（可选，示例 1）
                页码，从 1 开始
            pageSize: int | None（可选，示例 20）
                每页条数；服务端混用 str/int，按模板类型传
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            body: HonorRequestClassHonorListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_class_honor_list(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "honor-020",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "classesId": classesId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_student_honor_list(
        self,
        *,
        pageNo: int | None = None,
        pageSize: int | None = None,
        studentId: str | None = None,
        body: HonorRequestStudentHonorListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestStudentHonorList

        接口：POST /cloud/evaluationPrize/studentHonor（honor-021）
        源码方法：requestStudentHonorList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：studentId

        JSON 请求体（application/json）：
            pageNo: int | None（可选，示例 1）
                页码，从 1 开始
            pageSize: int | None（可选，示例 20）
                每页条数；服务端混用 str/int，按模板类型传
            studentId: str | None（自动）
                学生 ID；占位符 {student_id} 自动发现或由参数写入 context
            body: HonorRequestStudentHonorListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_student_honor_list(studentId=client.context["student_id"])
        """
        return self._invoke(
            "honor-021",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "studentId": studentId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def honor_goto_score(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · gotoScore

        接口：POST /cloud/moralEducationActivityBrand/gotoScore（honor-022）
        源码方法：gotoScore
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_goto_score()
        """
        return self._invoke(
            "honor-022",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_daily_score_details(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestDailyScoreDetails

        接口：POST /cloud/moralEducationActivityBrand/overviewDetail（honor-023）
        源码方法：requestDailyScoreDetails
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_daily_score_details()
        """
        return self._invoke(
            "honor-023",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_class_me(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestClassMe

        接口：POST /cloud/moralEducationActivityBrand/race（honor-024）
        源码方法：requestClassMe
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_class_me()
        """
        return self._invoke(
            "honor-024",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_request_scoring_rubric(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · requestScoringRubric

        接口：POST /cloud/moralEducationActivityBrand/scoringRubric（honor-025）
        源码方法：requestScoringRubric
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_request_scoring_rubric()
        """
        return self._invoke(
            "honor-025",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def honor_security_check(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """德育评价、荣誉与勋章 · securityCheck

        接口：POST /cloud/moralEducationActivityBrand/securityCheck（honor-026）
        源码方法：securityCheck
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.honor_security_check()
        """
        return self._invoke(
            "honor-026",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def exam_request_user_exam_list(
        self,
        *,
        studentId: str | None = None,
        body: ExamRequestUserExamListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考试 · 学生考试列表

        接口：POST /brand/exam/by/student（exam-001）
        源码方法：requestUserExamList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：studentId

        JSON 请求体（application/json）：
            studentId: str | None（自动）
                学生 ID；占位符 {student_id} 自动发现或由参数写入 context
            body: ExamRequestUserExamListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.exam_request_user_exam_list(studentId=client.context["student_id"])
        """
        return self._invoke(
            "exam-001",
            fields={"studentId": studentId},
            body=body,
            extra=extra,
            full=full,
        )

    def exam_request_exam_detail(
        self,
        *,
        siteId: str | None = None,
        subjectId: str | None = None,
        examinationId: str | None = None,
        body: ExamRequestExamDetailBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考试 · requestExamDetail

        接口：POST /brand/exam/detail（exam-002）
        源码方法：requestExamDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：subjectId、examinationId
        自动：siteId

        JSON 请求体（application/json）：
            siteId: str | None（自动）
                场地 ID；占位符 {site_id} /brand/obtain 后写入 context
            subjectId: str | None（必填）
                科目 ID；占位符 {subject_id} 需传参或写入 context['subject_id']
            examinationId: str | None（必填）
                考试 ID；占位符 {examination_id} 需传参或写入 context['examination_id']
            body: ExamRequestExamDetailBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.exam_request_exam_detail(subjectId="<subject_id>", examinationId="<examination_id>")
        """
        return self._invoke(
            "exam-002",
            fields={
                "siteId": siteId,
                "subjectId": subjectId,
                "examinationId": examinationId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def exam_request_exam_person_seat(
        self,
        *,
        siteId: str | None = None,
        subjectId: str | None = None,
        examinationId: str | None = None,
        body: ExamRequestExamPersonSeatBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考试 · requestExamPersonSeat

        接口：POST /brand/exam/person（exam-003）
        源码方法：requestExamPersonSeat
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：subjectId、examinationId
        自动：siteId

        JSON 请求体（application/json）：
            siteId: str | None（自动）
                场地 ID；占位符 {site_id} /brand/obtain 后写入 context
            subjectId: str | None（必填）
                科目 ID；占位符 {subject_id} 需传参或写入 context['subject_id']
            examinationId: str | None（必填）
                考试 ID；占位符 {examination_id} 需传参或写入 context['examination_id']
            body: ExamRequestExamPersonSeatBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.exam_request_exam_person_seat(subjectId="<subject_id>", examinationId="<examination_id>")
        """
        return self._invoke(
            "exam-003",
            fields={
                "siteId": siteId,
                "subjectId": subjectId,
                "examinationId": examinationId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def exam_request_week_exam(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考试 · requestWeekExam

        接口：POST /brand/exam/plan/week（exam-004）
        源码方法：requestWeekExam
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.exam_request_week_exam()
        """
        return self._invoke(
            "exam-004",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def exam_request_today_exam(
        self,
        *,
        examStartTime: str = '2026-10-19 00:00:00',
        examEndTime: str = '2026-10-19 23:59:59',
        limit: int = 10,
        body: ExamRequestTodayExamBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考试 · requestTodayExam

        接口：POST /brand/exam/recent（exam-005）
        源码方法：requestTodayExam
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体（application/json）：
            examStartTime: str（可选，默认 "2026-10-19 00:00:00"）
                考试开始时间，yyyy-MM-dd HH:mm:ss
            examEndTime: str（可选，默认 "2026-10-19 23:59:59"）
                考试结束时间，yyyy-MM-dd HH:mm:ss
            limit: int（可选，默认 10）
                返回条数上限
            body: ExamRequestTodayExamBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.exam_request_today_exam()
        """
        return self._invoke(
            "exam-005",
            fields={
                "examStartTime": examStartTime,
                "examEndTime": examEndTime,
                "limit": limit,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def exam_request_sign_exam(
        self,
        *,
        studentId: str | None = None,
        siteId: str | None = None,
        subjectId: str | None = None,
        examinationId: str | None = None,
        body: ExamRequestSignExamBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """考试 · requestSignExam

        接口：POST /brand/exam/student/sing/in（exam-006）
        源码方法：requestSignExam
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：subjectId、examinationId
        自动：studentId、siteId

        JSON 请求体（application/json）：
            studentId: str | None（自动）
                学生 ID；占位符 {student_id} 自动发现或由参数写入 context
            siteId: str | None（自动）
                场地 ID；占位符 {site_id} /brand/obtain 后写入 context
            subjectId: str | None（必填）
                科目 ID；占位符 {subject_id} 需传参或写入 context['subject_id']
            examinationId: str | None（必填）
                考试 ID；占位符 {examination_id} 需传参或写入 context['examination_id']
            body: ExamRequestSignExamBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.exam_request_sign_exam(subjectId="<subject_id>", examinationId="<examination_id>")
        """
        return self._invoke(
            "exam-006",
            fields={
                "studentId": studentId,
                "siteId": siteId,
                "subjectId": subjectId,
                "examinationId": examinationId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def library_get_book_msg_assets(
        self,
        *,
        ctrlNo: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """图书与阅读 · getBookMsgAssets

        接口：GET /opac/assets/{ctrlNo}（library-001）
        源码方法：getBookMsgAssets
        鉴权：无需 Bearer token
        必填：ctrlNo

        路径参数（URL Path）：
            ctrlNo: str | None（必填，路径参数）
                图书控制号/资产编号；占位符 {ctrl_no} 需传参或写入 context['ctrl_no']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.library_get_book_msg_assets(ctrlNo="<ctrl_no>")
        """
        return self._invoke(
            "library-001",
            fields={"ctrlNo": ctrlNo},
            extra=extra,
            full=full,
        )

    def library_get_book_msg(self, *, ctrlNo: str | None = None, full: bool = False, **extra: Any) -> Any:
        """图书与阅读 · getBookMsg

        接口：GET /opac/ctrl/{ctrlNo}（library-002）
        源码方法：getBookMsg
        鉴权：无需 Bearer token
        必填：ctrlNo

        路径参数（URL Path）：
            ctrlNo: str | None（必填，路径参数）
                图书控制号/资产编号；占位符 {ctrl_no} 需传参或写入 context['ctrl_no']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.library_get_book_msg(ctrlNo="<ctrl_no>")
        """
        return self._invoke(
            "library-002",
            fields={"ctrlNo": ctrlNo},
            extra=extra,
            full=full,
        )

    def library_search_book(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """图书与阅读 · searchBook

        接口：POST /opac/search（library-003）
        源码方法：searchBook
        鉴权：无需 Bearer token
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.library_search_book()
        """
        return self._invoke(
            "library-003",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def library_get_tops(
        self,
        *,
        topType: str | None = None,
        days: str = '30',
        flag: str = '1',
        language: str = 'zh',
        type: str = '1',
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """图书与阅读 · getTops

        接口：GET /opac/tops/{topType}（library-004）
        源码方法：getTops
        鉴权：无需 Bearer token
        必填：topType

        路径参数（URL Path）：
            topType: str | None（必填，路径参数）
                榜单类型；占位符 {top_type} 需传参或写入 context['top_type']

        Query 参数：
            days: str（可选，默认 "30"）
                榜单统计天数
            flag: str（可选，默认 "1"）
                榜单标记（1）
            language: str（可选，默认 "zh"）
                语言，如 zh
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.library_get_tops(topType="<top_type>")
        """
        return self._invoke(
            "library-004",
            fields={
                "topType": topType,
                "days": days,
                "flag": flag,
                "language": language,
                "type": type,
            },
            extra=extra,
            full=full,
        )

    def library_request_library_classify_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """图书与阅读 · requestLibraryClassifyList

        接口：POST /rfid/class-board/category/list（library-005）
        源码方法：requestLibraryClassifyList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.library_request_library_classify_list()
        """
        return self._invoke(
            "library-005",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def library_request_library_search(
        self,
        *,
        pageNo: int | None = None,
        pageSize: int | None = None,
        libraryId: str | None = None,
        fullText: str | None = None,
        type: str | None = None,
        title: str | None = None,
        firstAuthor: str | None = None,
        publisherName: str | None = None,
        startPublication: str | None = None,
        endPublication: str | None = None,
        order: str | None = None,
        body: LibraryRequestLibrarySearchBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """图书与阅读 · requestLibrarySearch

        接口：POST /rfid/class-board/opac/book（library-006）
        源码方法：requestLibrarySearch
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：libraryId

        JSON 请求体（application/json）：
            pageNo: int | None（可选，示例 1）
                页码，从 1 开始
            pageSize: int | None（可选，示例 20）
                每页条数；服务端混用 str/int，按模板类型传
            libraryId: str | None（必填）
                图书馆 ID；占位符 {library_id} 需传参或写入 context['library_id']
            fullText: str | None（可选，示例 空字符串）
                全文检索关键词
            type: str | None（可选，示例 空字符串）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            title: str | None（可选，示例 空字符串）
                书名
            firstAuthor: str | None（可选，示例 空字符串）
                第一作者
            publisherName: str | None（可选，示例 空字符串）
                出版社
            startPublication: str | None（可选，示例 空字符串）
                出版起始日期
            endPublication: str | None（可选，示例 空字符串）
                出版结束日期
            order: str | None（可选，示例 空字符串）
                排序方式
            body: LibraryRequestLibrarySearchBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.library_request_library_search(libraryId="<library_id>")
        """
        return self._invoke(
            "library-006",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "libraryId": libraryId,
                "fullText": fullText,
                "type": type,
                "title": title,
                "firstAuthor": firstAuthor,
                "publisherName": publisherName,
                "startPublication": startPublication,
                "endPublication": endPublication,
                "order": order,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def library_request_library_book_situation(
        self,
        *,
        id: str | None = None,
        body: LibraryRequestLibraryBookSituationBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """图书与阅读 · requestLibraryBookSituation

        接口：POST /rfid/class-board/opac/bookDetail（library-007）
        源码方法：requestLibraryBookSituation
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：id

        JSON 请求体（application/json）：
            id: str | None（必填）
                图书 ID；占位符 {book_id} 需传参或写入 context['book_id']
            body: LibraryRequestLibraryBookSituationBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。
                模板为 {}；上述字段来自接口文档示例，只有传参时才会加入请求体。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.library_request_library_book_situation(id="<book_id>")
        """
        return self._invoke(
            "library-007",
            fields={"id": id},
            body=body,
            extra=extra,
            full=full,
        )

    def library_request_library_type_list(
        self,
        *,
        libraryId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """图书与阅读 · requestLibraryTypeList

        接口：GET /rfid/class-board/opac/itemTypeList（library-008）
        源码方法：requestLibraryTypeList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：libraryId

        Query 参数：
            libraryId: str | None（必填）
                图书馆 ID；占位符 {library_id} 需传参或写入 context['library_id']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.library_request_library_type_list(libraryId="<library_id>")
        """
        return self._invoke(
            "library-008",
            fields={"libraryId": libraryId},
            extra=extra,
            full=full,
        )

    def library_request_hot_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """图书与阅读 · requestHotList

        接口：POST /rfid/class-board/rank/hot-circulation-rank（library-009）
        源码方法：requestHotList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.library_request_hot_list()
        """
        return self._invoke(
            "library-009",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def library_request_library_new_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """图书与阅读 · requestLibraryNewList

        接口：POST /rfid/class-board/rank/new-book-recommend（library-010）
        源码方法：requestLibraryNewList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.library_request_library_new_list()
        """
        return self._invoke(
            "library-010",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def library_request_library_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """图书与阅读 · requestLibraryList

        接口：POST /rfid/hm-board/library/list（library-011）
        源码方法：requestLibraryList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.library_request_library_list()
        """
        return self._invoke(
            "library-011",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def reservation_request_employee_details(
        self,
        *,
        id: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """场地预约与咨询 · requestEmployeeDetails

        接口：GET /cloud/employee/get（reservation-001）
        源码方法：requestEmployeeDetails
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.reservation_request_employee_details(id=client.context["brand_id"])
        """
        return self._invoke(
            "reservation-001",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def reservation_request_consult_list(
        self,
        *,
        pageNo: int = 1,
        pageSize: int = 20,
        body: ReservationRequestConsultListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """场地预约与咨询 · requestConsultList

        接口：POST /cloud/employee/getEmployeeListByLabel（reservation-002）
        源码方法：requestConsultList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体（application/json）：
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 20）
                每页条数；服务端混用 str/int，按模板类型传
            body: ReservationRequestConsultListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.reservation_request_consult_list()
        """
        return self._invoke(
            "reservation-002",
            fields={"pageNo": pageNo, "pageSize": pageSize},
            body=body,
            extra=extra,
            full=full,
        )

    def reservation_request_reservation_record_list(
        self,
        *,
        pageNo: int = 1,
        pageSize: int = 20,
        userId: str | None = None,
        status: int = 0,
        body: ReservationRequestReservationRecordListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """场地预约与咨询 · 预约记录

        接口：POST /cloud/siteBooking/bookingRecordPage（reservation-003）
        源码方法：requestReservationRecordList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：userId

        JSON 请求体（application/json）：
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 20）
                每页条数；服务端混用 str/int，按模板类型传
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            status: int（可选，默认 0）
                状态筛选；取值随接口（如 not_start/0/1）
            body: ReservationRequestReservationRecordListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.reservation_request_reservation_record_list(userId=client.context["student_id"])
        """
        return self._invoke(
            "reservation-003",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "userId": userId,
                "status": status,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def reservation_request_reservation_record_detail(
        self,
        *,
        id: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """场地预约与咨询 · requestReservationRecordDetail

        接口：GET /cloud/siteBooking/get（reservation-004）
        源码方法：requestReservationRecordDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.reservation_request_reservation_record_detail(id=client.context["brand_id"])
        """
        return self._invoke(
            "reservation-004",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def reservation_request_reservation_offline_sign(
        self,
        *,
        siteBookingIds: List[str] | None = None,
        userId: str | None = None,
        body: ReservationRequestReservationOfflineSignBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """场地预约与咨询 · requestReservationOfflineSign

        接口：POST /cloud/siteBooking/siteBookingBatchSign（reservation-005）
        源码方法：requestReservationOfflineSign
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：siteBookingIds
        自动：userId

        JSON 请求体（application/json）：
            siteBookingIds: List[str] | None（必填）
                场地预约记录 ID 列表；占位符 {site_booking_id} 需传参或写入 context['site_booking_id']
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            body: ReservationRequestReservationOfflineSignBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.reservation_request_reservation_offline_sign(siteBookingIds="<site_booking_id>")
        """
        return self._invoke(
            "reservation-005",
            fields={"siteBookingIds": siteBookingIds, "userId": userId},
            body=body,
            extra=extra,
            full=full,
        )

    def reservation_request_reservation_sign(
        self,
        *,
        siteBookingId: str | None = None,
        userId: str | None = None,
        body: ReservationRequestReservationSignBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """场地预约与咨询 · requestReservationSign

        接口：POST /cloud/siteBooking/siteBookingSign（reservation-006）
        源码方法：requestReservationSign
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：siteBookingId
        自动：userId

        JSON 请求体（application/json）：
            siteBookingId: str | None（必填）
                场地预约记录 ID；占位符 {site_booking_id} 需传参或写入 context['site_booking_id']
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            body: ReservationRequestReservationSignBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.reservation_request_reservation_sign(siteBookingId="<site_booking_id>")
        """
        return self._invoke(
            "reservation-006",
            fields={"siteBookingId": siteBookingId, "userId": userId},
            body=body,
            extra=extra,
            full=full,
        )

    def patrol_request_submit_patrol(
        self,
        *,
        id: str | None = None,
        formJson: str = '{}',
        userId: str | None = None,
        body: PatrolRequestSubmitPatrolBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """巡课 · requestSubmitPatrol

        接口：POST /app/patrolDayTaskSite/finishSiteTask（patrol-001）
        源码方法：requestSubmitPatrol
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：id、userId

        JSON 请求体（application/json）：
            id: str | None（必填）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {patrol_id} 需传参或写入
                context['patrol_id']
            formJson: str（可选，默认 "{}"）
                表单内容（JSON 字符串）
            userId: str | None（必填）
                用户 ID；学生或教师，随接口；占位符 {teacher_id} 需传参或写入 context['teacher_id']
            body: PatrolRequestSubmitPatrolBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.patrol_request_submit_patrol(id="<patrol_id>", userId="<teacher_id>")
        """
        return self._invoke(
            "patrol-001",
            fields={
                "id": id,
                "formJson": formJson,
                "userId": userId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def patrol_request_patrol_detail(self, *, id: str | None = None, full: bool = False, **extra: Any) -> Any:
        """巡课 · requestPatrolDetail

        接口：GET /app/patrolDayTaskSite/get（patrol-002）
        源码方法：requestPatrolDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.patrol_request_patrol_detail(id=client.context["brand_id"])
        """
        return self._invoke(
            "patrol-002",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def patrol_request_patrol_list(
        self,
        *,
        patrolType: int = 1,
        pageNo: int = 1,
        siteId: str | None = None,
        pageSize: int = 20,
        userId: str | None = None,
        status: int = 0,
        body: PatrolRequestPatrolListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """巡课 · 巡课任务列表

        接口：POST /app/patrolDayTaskSite/page（patrol-003）
        源码方法：requestPatrolList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：userId
        自动：siteId

        JSON 请求体（application/json）：
            patrolType: int（可选，默认 1）
                巡课类型
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            siteId: str | None（自动）
                场地 ID；占位符 {site_id} /brand/obtain 后写入 context
            pageSize: int（可选，默认 20）
                每页条数；服务端混用 str/int，按模板类型传
            userId: str | None（必填）
                用户 ID；学生或教师，随接口；占位符 {teacher_id} 需传参或写入 context['teacher_id']
            status: int（可选，默认 0）
                状态筛选；取值随接口（如 not_start/0/1）
            body: PatrolRequestPatrolListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.patrol_request_patrol_list(userId="<teacher_id>")
        """
        return self._invoke(
            "patrol-003",
            fields={
                "patrolType": patrolType,
                "pageNo": pageNo,
                "siteId": siteId,
                "pageSize": pageSize,
                "userId": userId,
                "status": status,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def patrol_request_update_patrol_punch(
        self,
        *,
        id: str | None = None,
        formJson: str = '{}',
        userId: str | None = None,
        body: PatrolRequestUpdatePatrolPunchBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """巡课 · requestUpdatePatrolPunch

        接口：POST /app/patrolDayTaskSite/updateClockIn（patrol-004）
        源码方法：requestUpdatePatrolPunch
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：id、userId

        JSON 请求体（application/json）：
            id: str | None（必填）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {patrol_id} 需传参或写入
                context['patrol_id']
            formJson: str（可选，默认 "{}"）
                表单内容（JSON 字符串）
            userId: str | None（必填）
                用户 ID；学生或教师，随接口；占位符 {teacher_id} 需传参或写入 context['teacher_id']
            body: PatrolRequestUpdatePatrolPunchBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.patrol_request_update_patrol_punch(id="<patrol_id>", userId="<teacher_id>")
        """
        return self._invoke(
            "patrol-004",
            fields={
                "id": id,
                "formJson": formJson,
                "userId": userId,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def patrol_request_patrol_punch(
        self,
        *,
        userId: str | None = None,
        businessId: str | None = None,
        body: PatrolRequestPatrolPunchBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """巡课 · requestPatrolPunch

        接口：POST /app/patrolDayTaskSite/updateNowClock（patrol-005）
        源码方法：requestPatrolPunch
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：userId、businessId

        JSON 请求体（application/json）：
            userId: str | None（必填）
                用户 ID；学生或教师，随接口；占位符 {teacher_id} 需传参或写入 context['teacher_id']
            businessId: str | None（必填）
                业务 ID（巡课任务 ID）；占位符 {patrol_id} 需传参或写入 context['patrol_id']
            body: PatrolRequestPatrolPunchBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.patrol_request_patrol_punch(userId="<teacher_id>", businessId="<patrol_id>")
        """
        return self._invoke(
            "patrol-005",
            fields={"userId": userId, "businessId": businessId},
            body=body,
            extra=extra,
            full=full,
        )

    def patrol_request_scan_qr_code_status(
        self,
        *,
        siteId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """巡课 · requestScanQrCodeStatus

        接口：GET /app/patrolQrCode/getSiteQrCodeStatus（patrol-006）
        源码方法：requestScanQrCodeStatus
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：siteId

        Query 参数：
            siteId: str | None（自动）
                场地 ID；占位符 {site_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.patrol_request_scan_qr_code_status(siteId=client.context["site_id"])
        """
        return self._invoke(
            "patrol-006",
            fields={"siteId": siteId},
            extra=extra,
            full=full,
        )

    def vote_request_form_detail(
        self,
        *,
        id: str | None = None,
        body: VoteRequestFormDetailBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """投票与问卷 · requestFormDetail

        接口：POST /app/collectTableBrand/check（vote-001）
        源码方法：requestFormDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：id

        JSON 请求体（application/json）：
            id: str | None（必填）
                问卷/收集表 ID；占位符 {form_id} 需传参或写入 context['form_id']
            body: VoteRequestFormDetailBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.vote_request_form_detail(id="<form_id>")
        """
        return self._invoke(
            "vote-001",
            fields={"id": id},
            body=body,
            extra=extra,
            full=full,
        )

    def vote_request_collect_situation(
        self,
        *,
        id: str | None = None,
        body: VoteRequestCollectSituationBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """投票与问卷 · requestCollectSituation

        接口：POST /app/collectTableBrand/lookOver（vote-002）
        源码方法：requestCollectSituation
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：id

        JSON 请求体（application/json）：
            id: str | None（必填）
                问卷/收集表 ID；占位符 {form_id} 需传参或写入 context['form_id']
            body: VoteRequestCollectSituationBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.vote_request_collect_situation(id="<form_id>")
        """
        return self._invoke(
            "vote-002",
            fields={"id": id},
            body=body,
            extra=extra,
            full=full,
        )

    def vote_request_collect_list(
        self,
        *,
        pageNo: int = 1,
        pageSize: int = 99,
        body: VoteRequestCollectListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """投票与问卷 · requestCollectList

        接口：POST /app/collectTableBrand/overview（vote-003）
        源码方法：requestCollectList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体（application/json）：
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 99）
                每页条数；服务端混用 str/int，按模板类型传
            body: VoteRequestCollectListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.vote_request_collect_list()
        """
        return self._invoke(
            "vote-003",
            fields={"pageNo": pageNo, "pageSize": pageSize},
            body=body,
            extra=extra,
            full=full,
        )

    def vote_request_submit_form_content(
        self,
        *,
        id: str | None = None,
        components: List[Any] | None = None,
        body: VoteRequestSubmitFormContentBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """投票与问卷 · 提交问卷/收集表

        接口：POST /app/collectTableBrand/write（vote-004）
        源码方法：requestSubmitFormContent
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：id

        JSON 请求体（application/json）：
            id: str | None（必填）
                问卷/收集表 ID；占位符 {form_id} 需传参或写入 context['form_id']
            components: List[Any] | None（可选，默认 []）
                问卷组件作答列表
            body: VoteRequestSubmitFormContentBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.vote_request_submit_form_content(id="<form_id>")
        """
        return self._invoke(
            "vote-004",
            fields={"id": id, "components": components},
            body=body,
            extra=extra,
            full=full,
        )

    def vote_request_home_collect_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """投票与问卷 · requestHomeCollectList

        接口：POST /app/collectTableComponent/brand（vote-005）
        源码方法：requestHomeCollectList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.vote_request_home_collect_list()
        """
        return self._invoke(
            "vote-005",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def vote_request_teacher_dept_list(
        self,
        *,
        shcoolId: str | None = None,
        employeeId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """投票与问卷 · requestTeacherDeptList

        接口：GET /app/employee/getDeptById（vote-006）
        源码方法：requestTeacherDeptList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：employeeId
        自动：shcoolId

        Query 参数：
            shcoolId: str | None（自动）
                学校 ID（服务端历史拼写，等同于 schoolId）；占位符 {school_id} 取学校配置或 /brand/obtain
            employeeId: str | None（必填）
                教师/员工 ID；占位符 {teacher_id} 需传参或写入 context['teacher_id']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.vote_request_teacher_dept_list(employeeId="<teacher_id>")
        """
        return self._invoke(
            "vote-006",
            fields={"shcoolId": shcoolId, "employeeId": employeeId},
            extra=extra,
            full=full,
        )

    def vote_request_student_classes(
        self,
        *,
        studentId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """投票与问卷 · requestStudentClasses

        接口：GET /app/student/selectClassByStudentId（vote-007）
        源码方法：requestStudentClasses
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：studentId

        Query 参数：
            studentId: str | None（自动）
                学生 ID；占位符 {student_id} 自动发现或由参数写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.vote_request_student_classes(studentId=client.context["student_id"])
        """
        return self._invoke(
            "vote-007",
            fields={"studentId": studentId},
            extra=extra,
            full=full,
        )

    def vote_request_submit_vote(
        self,
        *,
        voteId: str | None = None,
        isBrandStudent: bool = True,
        userId: str | None = None,
        userName: str | None = None,
        voteDetails: List[Any] | None = None,
        body: VoteRequestSubmitVoteBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """投票与问卷 · requestSubmitVote

        接口：POST /cloud/vote/clickVote（vote-008）
        源码方法：requestSubmitVote
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：voteId
        自动：userId、userName

        JSON 请求体（application/json）：
            voteId: str | None（必填）
                投票 ID；占位符 {vote_id} 需传参或写入 context['vote_id']
            isBrandStudent: bool（可选，默认 True）
                是否班牌学生
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            userName: str | None（自动）
                用户姓名；占位符 {student_name} 自动发现学生后写入 context
            voteDetails: List[Any] | None（可选，默认 []）
                投票选项列表
            body: VoteRequestSubmitVoteBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.vote_request_submit_vote(voteId="<vote_id>")
        """
        return self._invoke(
            "vote-008",
            fields={
                "voteId": voteId,
                "isBrandStudent": isBrandStudent,
                "userId": userId,
                "userName": userName,
                "voteDetails": voteDetails,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def vote_request_vote_detail(
        self,
        *,
        voteId: str | None = None,
        brandStudentInfo: str = '',
        body: VoteRequestVoteDetailBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """投票与问卷 · requestVoteDetail

        接口：POST /cloud/vote/get（vote-009）
        源码方法：requestVoteDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：voteId

        JSON 请求体（application/json）：
            voteId: str | None（必填）
                投票 ID；占位符 {vote_id} 需传参或写入 context['vote_id']
            brandStudentInfo: str（可选，默认 空字符串）
                班牌学生信息（JSON 字符串）
            body: VoteRequestVoteDetailBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.vote_request_vote_detail(voteId="<vote_id>")
        """
        return self._invoke(
            "vote-009",
            fields={"voteId": voteId, "brandStudentInfo": brandStudentInfo},
            body=body,
            extra=extra,
            full=full,
        )

    def vote_request_home_vote_list(
        self,
        *,
        pageNo: int = 1,
        pageSize: int = 10,
        status: int = 0,
        showAll: bool = False,
        isHave: bool = True,
        body: VoteRequestHomeVoteListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """投票与问卷 · 投票列表

        接口：POST /cloud/vote/page（vote-010）
        源码方法：requestHomeVoteList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体（application/json）：
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 10）
                每页条数；服务端混用 str/int，按模板类型传
            status: int（可选，默认 0）
                状态筛选；取值随接口（如 not_start/0/1）
            showAll: bool（可选，默认 False）
                是否显示全部
            isHave: bool（可选，默认 True）
                是否包含已参与
            body: VoteRequestHomeVoteListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.vote_request_home_vote_list()
        """
        return self._invoke(
            "vote-010",
            fields={
                "pageNo": pageNo,
                "pageSize": pageSize,
                "status": status,
                "showAll": showAll,
                "isHave": isHave,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def dormitory_request_home_dormitory_detail(
        self,
        *,
        id: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """宿舍 · requestHomeDormitoryDetail

        接口：GET /brand/brand/dormitory/dormitoryHomepage/detail（dormitory-001）
        源码方法：requestHomeDormitoryDetail
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：id

        Query 参数：
            id: str | None（自动）
                记录 ID；含义随接口（设备/场地/作品/表单/锁等）；占位符 {brand_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.dormitory_request_home_dormitory_detail(id=client.context["brand_id"])
        """
        return self._invoke(
            "dormitory-001",
            fields={"id": id},
            extra=extra,
            full=full,
        )

    def dormitory_request_home_dormitory_education(
        self,
        *,
        schoolId: str | None = None,
        classesId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """宿舍 · requestHomeDormitoryEducation

        接口：GET /cloud/moralEducationActivityBrand/dormitory（dormitory-002）
        源码方法：requestHomeDormitoryEducation
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：schoolId、classesId

        Query 参数：
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.dormitory_request_home_dormitory_education(
                schoolId=client.context["school_id"],
                classesId=client.context["classes_id"]
            )
        """
        return self._invoke(
            "dormitory-002",
            fields={"schoolId": schoolId, "classesId": classesId},
            extra=extra,
            full=full,
        )

    def ai_request_a_i_get_info(
        self,
        *,
        id: str = 'assistant-1',
        body: AiRequestAIGetInfoBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """AI 助手 · requestAIGetInfo

        接口：POST /ai/assistant/get（ai-001）
        源码方法：requestAIGetInfo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体（application/json）：
            id: str（可选，默认 "assistant-1"）
                AI 助手 ID
            body: AiRequestAIGetInfoBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ai_request_a_i_get_info()
        """
        return self._invoke(
            "ai-001",
            fields={"id": id},
            body=body,
            extra=extra,
            full=full,
        )

    def ai_request_a_i_home_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """AI 助手 · requestAIHomeList

        接口：POST /ai/assistant/public/list（ai-002）
        源码方法：requestAIHomeList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ai_request_a_i_home_list()
        """
        return self._invoke(
            "ai-002",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def ai_request_a_i_model_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """AI 助手 · requestAIModelList

        接口：POST /ai/chat/models（ai-003）
        源码方法：requestAIModelList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ai_request_a_i_model_list()
        """
        return self._invoke(
            "ai-003",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def ai_request_a_i_create_session(
        self,
        *,
        assistantId: str = 'assistant-1',
        userId: str | None = None,
        body: AiRequestAICreateSessionBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """AI 助手 · AI 会话创建

        接口：POST /ai/chat/session/create（ai-004）
        源码方法：requestAICreateSession
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：userId

        JSON 请求体（application/json）：
            assistantId: str（可选，默认 "assistant-1"）
                AI 助手 ID
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            body: AiRequestAICreateSessionBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ai_request_a_i_create_session(userId=client.context["student_id"])
        """
        return self._invoke(
            "ai-004",
            fields={"assistantId": assistantId, "userId": userId},
            body=body,
            extra=extra,
            full=full,
        )

    def upload_upload(self, *, file: str | None = None, full: bool = False, **extra: Any) -> Any:
        """文件上传与日志 · 文件上传（multipart）

        接口：POST /app/file/upload（upload-001）
        源码方法：upload
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：file

        上传文件（multipart/form-data）：
            file: str | None（必填）
                上传文件的本地路径（multipart）；占位符 {file} 需传参或写入 context['file']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.upload_upload(file="<本地文件路径>")
        """
        return self._invoke(
            "upload-001",
            fields={"file": file},
            extra=extra,
            full=full,
        )

    def upload_upload_2(self, *, file: str | None = None, full: bool = False, **extra: Any) -> Any:
        """文件上传与日志 · 文件上传（multipart）

        接口：POST /app/file/upload（upload-002）
        源码方法：upload
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：file

        上传文件（multipart/form-data）：
            file: str | None（必填）
                上传文件的本地路径（multipart）；占位符 {file} 需传参或写入 context['file']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.upload_upload_2(file="<本地文件路径>")
        """
        return self._invoke(
            "upload-002",
            fields={"file": file},
            extra=extra,
            full=full,
        )

    def upload_upload_log_file(self, *, file: str | None = None, full: bool = False, **extra: Any) -> Any:
        """文件上传与日志 · 日志上传（multipart）

        接口：POST /file/upload/path（upload-003）
        源码方法：uploadLogFile
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：file

        上传文件（multipart/form-data）：
            file: str | None（必填）
                上传文件的本地路径（multipart）；占位符 {file} 需传参或写入 context['file']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.upload_upload_log_file(file="<本地文件路径>")
        """
        return self._invoke(
            "upload-003",
            fields={"file": file},
            extra=extra,
            full=full,
        )

    def iot_list_swk(self, *, body: Dict[str, Any] | None = None, full: bool = False, **extra: Any) -> Any:
        """设备物联与扩展 · listSwk

        接口：POST /api/lock/listSwk.html（iot-001）
        源码方法：listSwk
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.iot_list_swk()
        """
        return self._invoke(
            "iot-001",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def iot_save_swk(self, *, body: Dict[str, Any] | None = None, full: bool = False, **extra: Any) -> Any:
        """设备物联与扩展 · saveSwk

        接口：POST /api/lock/saveSwk（iot-002）
        源码方法：saveSwk
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.iot_save_swk()
        """
        return self._invoke(
            "iot-002",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def iot_request_r_t_s_p_path(
        self,
        *,
        brandId: str | None = None,
        body: IotRequestRTSPPathBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备物联与扩展 · requestRTSPPath

        接口：POST /brand/layoutclasssign/getVideoStreams（iot-003）
        源码方法：requestRTSPPath
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：brandId

        JSON 请求体（application/json）：
            brandId: str | None（自动）
                班牌/品牌 ID（/brand/obtain 返回的 id）；占位符 {brand_id} /brand/obtain 后写入
                context
            body: IotRequestRTSPPathBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.iot_request_r_t_s_p_path(brandId=client.context["brand_id"])
        """
        return self._invoke(
            "iot-003",
            fields={"brandId": brandId},
            body=body,
            extra=extra,
            full=full,
        )

    def iot_request_records(
        self,
        *,
        deviceNo: str | None = None,
        userId: str | None = None,
        type: str = '1',
        body: IotRequestRecordsBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备物联与扩展 · requestRecords

        接口：POST /brand/openDoor/records/create（iot-004）
        源码方法：requestRecords
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：deviceNo、userId

        JSON 请求体（application/json）：
            deviceNo: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            userId: str | None（自动）
                用户 ID；学生或教师，随接口；占位符 {student_id} 自动发现或由参数写入 context
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            body: IotRequestRecordsBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.iot_request_records(deviceNo=client.context["mac"], userId=client.context["student_id"])
        """
        return self._invoke(
            "iot-004",
            fields={
                "deviceNo": deviceNo,
                "userId": userId,
                "type": type,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def iot_request_synchronize_status_face_extraction(
        self,
        *,
        schoolId: str | None = None,
        deviceNo: str | None = None,
        status: int = 1,
        body: IotRequestSynchronizeStatusFaceExtractionBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备物联与扩展 · requestSynchronizeStatusFaceExtraction

        接口：POST /cloud/device/face-sync/update-status（iot-005）
        源码方法：requestSynchronizeStatusFaceExtraction
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：schoolId、deviceNo

        JSON 请求体（application/json）：
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            deviceNo: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            status: int（可选，默认 1）
                状态筛选；取值随接口（如 not_start/0/1）
            body: IotRequestSynchronizeStatusFaceExtractionBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.iot_request_synchronize_status_face_extraction(
                schoolId=client.context["school_id"],
                deviceNo=client.context["mac"]
            )
        """
        return self._invoke(
            "iot-005",
            fields={
                "schoolId": schoolId,
                "deviceNo": deviceNo,
                "status": status,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def iot_request_face_config(
        self,
        *,
        schoolId: str | None = None,
        deviceNo: str | None = None,
        type: int = 1,
        body: IotRequestFaceConfigBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备物联与扩展 · requestFaceConfig

        接口：POST /cloud/device/shared-config/get（iot-006）
        源码方法：requestFaceConfig
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：schoolId、deviceNo

        JSON 请求体（application/json）：
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            deviceNo: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            type: int（可选，默认 1）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            body: IotRequestFaceConfigBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.iot_request_face_config(
                schoolId=client.context["school_id"],
                deviceNo=client.context["mac"]
            )
        """
        return self._invoke(
            "iot-006",
            fields={
                "schoolId": schoolId,
                "deviceNo": deviceNo,
                "type": type,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def iot_request_site_info(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备物联与扩展 · requestSiteInfo

        接口：POST /cloud/sks/site/get（iot-007）
        源码方法：requestSiteInfo
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.iot_request_site_info()
        """
        return self._invoke(
            "iot-007",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def iot_request_sensor_info_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备物联与扩展 · requestSensorInfoList

        接口：POST /cloud/sks/site/getSiteEnvIndicators（iot-008）
        源码方法：requestSensorInfoList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.iot_request_sensor_info_list()
        """
        return self._invoke(
            "iot-008",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def iot_request_warning_info_list(
        self,
        *,
        body: Dict[str, Any] | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """设备物联与扩展 · requestWarningInfoList

        接口：POST /cloud/sks/site/getSiteImages（iot-009）
        源码方法：requestWarningInfoList
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无

        JSON 请求体：
            模板为 {}，反编译源码中由 RequestBody 动态组装。可用 body={...} 传入完整 JSON，或用 **extra 追加字段。
            body: Dict[str, Any] | None
                完整 JSON 请求体；覆盖模板中的 {}。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.iot_request_warning_info_list()
        """
        return self._invoke(
            "iot-009",
            fields={},
            body=body,
            extra=extra,
            full=full,
        )

    def ttlock_oauth2_token(
        self,
        *,
        client_id: str | None = None,
        client_secret: str | None = None,
        grant_type: str = 'password',
        username: str | None = None,
        password: str | None = None,
        redirect_uri: str = 'http://www.1yide.com/',
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · OAuth 登录，获取 access_token

        接口：POST /oauth2/token（ttlock-001）
        源码方法：demo/retrofit/ApiService.auth
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        必填：无
        自动：client_id、client_secret、username、password

        Form 请求体（application/x-www-form-urlencoded）：
            client_id: str | None（自动）
                OAuth 客户端 ID（默认 yide-cloud）；占位符 {ttlock_client_id} 取 TTLock 凭据
            client_secret: str | None（自动）
                OAuth 客户端密钥；占位符 {ttlock_client_secret} 自动从
                context['ttlock_client_secret'] 读取
            grant_type: str（可选，默认 "password"）
                授权类型：brand（班牌）/ password（TTLock）
            username: str | None（自动）
                登录账号；占位符 {ttlock_username} 自动从 context['ttlock_username'] 读取
            password: str | None（自动）
                密码；登录接口为账号密码，门禁接口为门禁密码；占位符 {ttlock_password_md5} 自动从
                context['ttlock_password_md5'] 读取
            redirect_uri: str（可选，默认 "http://www.1yide.com/"）
                OAuth 回调地址，固定 http://www.1yide.com/

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_oauth2_token()
        """
        return self._invoke(
            "ttlock-001",
            fields={
                "client_id": client_id,
                "client_secret": client_secret,
                "grant_type": grant_type,
                "username": username,
                "password": password,
                "redirect_uri": redirect_uri,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_fingerprint_add(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        fingerprint: str | None = None,
        startDate: str | None = None,
        endDate: str | None = None,
        name: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 添加指纹

        接口：POST /v3/fingerprint/add（ttlock-002）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId、fingerprint、startDate、endDate、name
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            fingerprint: str | None（必填）
                指纹数据（base64）；占位符 {fingerprint} 需传参或写入 context['fingerprint']
            startDate: str | None（必填）
                开始日期，yyyy-MM-dd；占位符 {start_date} 需传参或写入 context['start_date']
            endDate: str | None（必填）
                结束日期，yyyy-MM-dd；占位符 {end_date} 需传参或写入 context['end_date']
            name: str | None（必填）
                指纹/卡/键盘名称；占位符 {fingerprint_name} 需传参或写入 context['fingerprint_name']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_fingerprint_add(lockId="<lock_id>", fingerprint="<fingerprint>")
        """
        return self._invoke(
            "ttlock-002",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "fingerprint": fingerprint,
                "startDate": startDate,
                "endDate": endDate,
                "name": name,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_identitycard_add(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        identityCard: str | None = None,
        startDate: str | None = None,
        endDate: str | None = None,
        name: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 添加 IC 卡

        接口：POST /v3/identityCard/add（ttlock-003）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId、identityCard、startDate、endDate、name
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            identityCard: str | None（必填）
                IC 卡号（TTLock）；占位符 {identity_card} 需传参或写入 context['identity_card']
            startDate: str | None（必填）
                开始日期，yyyy-MM-dd；占位符 {start_date} 需传参或写入 context['start_date']
            endDate: str | None（必填）
                结束日期，yyyy-MM-dd；占位符 {end_date} 需传参或写入 context['end_date']
            name: str | None（必填）
                指纹/卡/键盘名称；占位符 {card_name} 需传参或写入 context['card_name']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_identitycard_add(lockId="<lock_id>", identityCard="<identity_card>")
        """
        return self._invoke(
            "ttlock-003",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "identityCard": identityCard,
                "startDate": startDate,
                "endDate": endDate,
                "name": name,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_wirelesskeyboard_add(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        keyboardPwd: str | None = None,
        startDate: str | None = None,
        endDate: str | None = None,
        name: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 添加无线键盘

        接口：POST /v3/wirelessKeyboard/add（ttlock-004）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId、keyboardPwd、startDate、endDate、name
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            keyboardPwd: str | None（必填）
                键盘密码；占位符 {keyboard_pwd} 需传参或写入 context['keyboard_pwd']
            startDate: str | None（必填）
                开始日期，yyyy-MM-dd；占位符 {start_date} 需传参或写入 context['start_date']
            endDate: str | None（必填）
                结束日期，yyyy-MM-dd；占位符 {end_date} 需传参或写入 context['end_date']
            name: str | None（必填）
                指纹/卡/键盘名称；占位符 {keyboard_name} 需传参或写入 context['keyboard_name']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_wirelesskeyboard_add(lockId="<lock_id>", keyboardPwd="<keyboard_pwd>")
        """
        return self._invoke(
            "ttlock-004",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "keyboardPwd": keyboardPwd,
                "startDate": startDate,
                "endDate": endDate,
                "name": name,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_lock_changeadminkeyboardpwd(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        keyboardPwd: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 修改管理员键盘密码

        接口：POST /v3/lock/changeAdminKeyboardPwd（ttlock-005）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId、keyboardPwd
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            keyboardPwd: str | None（必填）
                键盘密码；占位符 {new_keyboard_pwd} 需传参或写入 context['new_keyboard_pwd']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_lock_changeadminkeyboardpwd(
                lockId="<lock_id>",
                keyboardPwd="<new_keyboard_pwd>"
            )
        """
        return self._invoke(
            "ttlock-005",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "keyboardPwd": keyboardPwd,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_fingerprint_clear(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 清空指纹

        接口：POST /v3/fingerprint/clear（ttlock-006）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_fingerprint_clear(lockId="<lock_id>")
        """
        return self._invoke(
            "ttlock-006",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_identitycard_clear(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 清空 IC 卡

        接口：POST /v3/identityCard/clear（ttlock-007）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_identitycard_clear(lockId="<lock_id>")
        """
        return self._invoke(
            "ttlock-007",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_fingerprint_delete(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        fingerprintId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 删除指纹

        接口：POST /v3/fingerprint/delete（ttlock-008）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId、fingerprintId
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            fingerprintId: str | None（必填）
                指纹记录 ID；占位符 {fingerprint_id} 需传参或写入 context['fingerprint_id']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_fingerprint_delete(lockId="<lock_id>", fingerprintId="<fingerprint_id>")
        """
        return self._invoke(
            "ttlock-008",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "fingerprintId": fingerprintId,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_identitycard_delete(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        identityCardId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 删除 IC 卡

        接口：POST /v3/identityCard/delete（ttlock-009）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId、identityCardId
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            identityCardId: str | None（必填）
                IC 卡记录 ID；占位符 {identity_card_id} 需传参或写入 context['identity_card_id']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_identitycard_delete(lockId="<lock_id>", identityCardId="<identity_card_id>")
        """
        return self._invoke(
            "ttlock-009",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "identityCardId": identityCardId,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_lock_delete(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 删除锁

        接口：POST /v3/lock/delete（ttlock-010）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_lock_delete(lockId="<lock_id>")
        """
        return self._invoke(
            "ttlock-010",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_gateway_isinitsuccess(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        gatewayNetMac: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 网关初始化状态

        接口：POST /v3/gateway/isInitSuccess（ttlock-011）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：gatewayNetMac
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            gatewayNetMac: str | None（必填）
                网关 MAC；占位符 {gateway_net_mac} 需传参或写入 context['gateway_net_mac']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_gateway_isinitsuccess(gatewayNetMac="<gateway_net_mac>")
        """
        return self._invoke(
            "ttlock-011",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "gatewayNetMac": gatewayNetMac,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_gateway_upgradecheck(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        gatewayId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 网关升级检查

        接口：POST /v3/gateway/upgradeCheck（ttlock-012）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：gatewayId
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            gatewayId: str | None（必填）
                网关 ID；占位符 {gateway_id} 需传参或写入 context['gateway_id']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_gateway_upgradecheck(gatewayId="<gateway_id>")
        """
        return self._invoke(
            "ttlock-012",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "gatewayId": gatewayId,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_gateway_list(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        pageNo: int = 1,
        pageSize: int = 100,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 网关列表

        接口：POST /v3/gateway/list（ttlock-013）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：无
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 100）
                每页条数；服务端混用 str/int，按模板类型传

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_gateway_list()
        """
        return self._invoke(
            "ttlock-013",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "pageNo": pageNo,
                "pageSize": pageSize,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_lock_list(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        pageNo: int = 1,
        pageSize: int = 100,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 锁列表

        接口：POST /v3/lock/list（ttlock-014）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：无
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 100）
                每页条数；服务端混用 str/int，按模板类型传

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_lock_list()
        """
        return self._invoke(
            "ttlock-014",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "pageNo": pageNo,
                "pageSize": pageSize,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_fingerprint_list(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        pageNo: int = 1,
        pageSize: int = 100,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 指纹列表

        接口：GET /v3/fingerprint/list（ttlock-015）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId
        自动：clientId、accessToken、date

        Query 参数：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 100）
                每页条数；服务端混用 str/int，按模板类型传

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_fingerprint_list(lockId="<lock_id>")
        """
        return self._invoke(
            "ttlock-015",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "pageNo": pageNo,
                "pageSize": pageSize,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_identitycard_list(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        pageNo: int = 1,
        pageSize: int = 100,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · IC 卡列表

        接口：GET /v3/identityCard/list（ttlock-016）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId
        自动：clientId、accessToken、date

        Query 参数：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 100）
                每页条数；服务端混用 str/int，按模板类型传

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_identitycard_list(lockId="<lock_id>")
        """
        return self._invoke(
            "ttlock-016",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "pageNo": pageNo,
                "pageSize": pageSize,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_key_list(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        pageNo: int = 1,
        pageSize: int = 100,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 钥匙列表

        接口：GET /v3/key/list（ttlock-017）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId
        自动：clientId、accessToken、date

        Query 参数：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 100）
                每页条数；服务端混用 str/int，按模板类型传

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_key_list(lockId="<lock_id>")
        """
        return self._invoke(
            "ttlock-017",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "pageNo": pageNo,
                "pageSize": pageSize,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_lock_initialize(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockData: str | None = None,
        lockAlias: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 初始化锁

        接口：POST /v3/lock/initialize（ttlock-018）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockData、lockAlias
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockData: str | None（必填）
                锁数据（初始化时由锁读取）；占位符 {lock_data} 需传参或写入 context['lock_data']
            lockAlias: str | None（必填）
                锁别名；占位符 {lock_alias} 需传参或写入 context['lock_alias']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_lock_initialize(lockData="<lock_data>", lockAlias="<lock_alias>")
        """
        return self._invoke(
            "ttlock-018",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockData": lockData,
                "lockAlias": lockAlias,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_lock_upgradecheck(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 锁升级检查

        接口：POST /v3/lock/upgradeCheck（ttlock-019）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_lock_upgradecheck(lockId="<lock_id>")
        """
        return self._invoke(
            "ttlock-019",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_lock_upgraderecheck(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        firmwareInfo: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 锁升级复查

        接口：POST /v3/lock/upgradeRecheck（ttlock-020）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId、firmwareInfo
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            firmwareInfo: str | None（必填）
                固件信息（JSON）；占位符 {firmware_info} 需传参或写入 context['firmware_info']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_lock_upgraderecheck(lockId="<lock_id>", firmwareInfo="<firmware_info>")
        """
        return self._invoke(
            "ttlock-020",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "firmwareInfo": firmwareInfo,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_identitycard_changeperiod(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        identityCardId: str | None = None,
        startDate: str | None = None,
        endDate: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 修改 IC 卡有效期

        接口：POST /v3/identityCard/changePeriod（ttlock-021）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId、identityCardId、startDate、endDate
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            identityCardId: str | None（必填）
                IC 卡记录 ID；占位符 {identity_card_id} 需传参或写入 context['identity_card_id']
            startDate: str | None（必填）
                开始日期，yyyy-MM-dd；占位符 {start_date} 需传参或写入 context['start_date']
            endDate: str | None（必填）
                结束日期，yyyy-MM-dd；占位符 {end_date} 需传参或写入 context['end_date']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_identitycard_changeperiod(
                lockId="<lock_id>",
                identityCardId="<identity_card_id>"
            )
        """
        return self._invoke(
            "ttlock-021",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "identityCardId": identityCardId,
                "startDate": startDate,
                "endDate": endDate,
            },
            extra=extra,
            full=full,
        )

    def ttlock_room_registernb(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        nbNodeId: str | None = None,
        nbCardNumber: str | None = None,
        nbRssi: str | None = None,
        nbOperator: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 注册 NB 物联网模块

        接口：POST /room/registerNb（ttlock-022）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId、nbNodeId、nbCardNumber、nbRssi、nbOperator
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            nbNodeId: str | None（必填）
                NB 节点 ID；占位符 {nb_node_id} 需传参或写入 context['nb_node_id']
            nbCardNumber: str | None（必填）
                NB 卡号；占位符 {nb_card_number} 需传参或写入 context['nb_card_number']
            nbRssi: str | None（必填）
                NB 信号强度；占位符 {nb_rssi} 需传参或写入 context['nb_rssi']
            nbOperator: str | None（必填）
                NB 运营商；占位符 {nb_operator} 需传参或写入 context['nb_operator']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_room_registernb(lockId="<lock_id>", nbNodeId="<nb_node_id>")
        """
        return self._invoke(
            "ttlock-022",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "nbNodeId": nbNodeId,
                "nbCardNumber": nbCardNumber,
                "nbRssi": nbRssi,
                "nbOperator": nbOperator,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_lock_resetkeyboardpwd(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        pwdInfo: str | None = None,
        timestamp: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 重置键盘密码

        接口：POST /v3/lock/resetKeyboardPwd（ttlock-023）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId、pwdInfo、timestamp
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            pwdInfo: str | None（必填）
                键盘密码信息（云端生成）；占位符 {pwd_info} 需传参或写入 context['pwd_info']
            timestamp: str | None（必填）
                毫秒时间戳（密码重置用）；占位符 {pwd_timestamp} 需传参或写入 context['pwd_timestamp']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_lock_resetkeyboardpwd(lockId="<lock_id>", pwdInfo="<pwd_info>")
        """
        return self._invoke(
            "ttlock-023",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "pwdInfo": pwdInfo,
                "timestamp": timestamp,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_lock_resetkey(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 重置 eKey

        接口：POST /v3/lock/resetKey（ttlock-024）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_lock_resetkey(lockId="<lock_id>")
        """
        return self._invoke(
            "ttlock-024",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
            },
            extra=extra,
            full=full,
        )

    def ttlock_v3_gateway_uploaddetail(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        gatewayId: str | None = None,
        modelNum: str | None = None,
        hardwareRevision: str | None = None,
        firmwareRevision: str | None = None,
        networkName: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 上传网关详情

        接口：POST /v3/gateway/uploadDetail（ttlock-025）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：gatewayId、modelNum、hardwareRevision、firmwareRevision、networkName
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            gatewayId: str | None（必填）
                网关 ID；占位符 {gateway_id} 需传参或写入 context['gateway_id']
            modelNum: str | None（必填）
                设备型号；占位符 {model_num} 需传参或写入 context['model_num']
            hardwareRevision: str | None（必填）
                硬件版本；占位符 {hardware_revision} 需传参或写入 context['hardware_revision']
            firmwareRevision: str | None（必填）
                固件版本；占位符 {firmware_revision} 需传参或写入 context['firmware_revision']
            networkName: str | None（必填）
                Wi-Fi 名称；占位符 {network_name} 需传参或写入 context['network_name']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_v3_gateway_uploaddetail(gatewayId="<gateway_id>", modelNum="<model_num>")
        """
        return self._invoke(
            "ttlock-025",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "gatewayId": gatewayId,
                "modelNum": modelNum,
                "hardwareRevision": hardwareRevision,
                "firmwareRevision": firmwareRevision,
                "networkName": networkName,
            },
            extra=extra,
            full=full,
        )

    def ttlock_lockrecords_fromlock(
        self,
        *,
        clientId: str | None = None,
        accessToken: str | None = None,
        date: str | None = None,
        lockId: str | None = None,
        records: str | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """TTLock 通通锁 · 上传锁记录

        接口：POST /lockRecords/fromLock（ttlock-026）
        源码方法：demo/retrofit/ApiService
        鉴权：TTLock form 参数（clientId/accessToken/date），不使用 Bearer
        说明：首次调用会自动登录 TTLock，并填充 form 的 clientId/accessToken/date。
        必填：lockId、records
        自动：clientId、accessToken、date

        Form 请求体（application/x-www-form-urlencoded）：
            clientId: str | None（自动）
                TTLock 客户端 ID（自动填入）；占位符 {ttlock_client_id} 取 TTLock 凭据
            accessToken: str | None（自动）
                TTLock access_token；首次调用会自动登录并填入；占位符 {ttlock_access_token} TTLock
                自动登录后写入 context
            date: str | None（自动）
                毫秒时间戳；TTLock 接口自动填当前时间；占位符 {timestamp_ms} 发送前自动填当前毫秒时间戳
            lockId: str | None（必填）
                锁 ID；占位符 {lock_id} 需传参或写入 context['lock_id']
            records: str | None（必填）
                锁记录列表（JSON）；占位符 {lock_records} 需传参或写入 context['lock_records']

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.ttlock_lockrecords_fromlock(lockId="<lock_id>", records="<lock_records>")
        """
        return self._invoke(
            "ttlock-026",
            fields={
                "clientId": clientId,
                "accessToken": accessToken,
                "date": date,
                "lockId": lockId,
                "records": records,
            },
            extra=extra,
            full=full,
        )

    def face_cloud_device_face_sync_sync_page(
        self,
        *,
        schoolId: str | None = None,
        deviceNo: str | None = None,
        pageNo: int = 1,
        pageSize: int = 100,
        body: FaceCloudDeviceFaceSyncSyncPageBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """人脸同步（FacePass） · 分页拉取人脸

        接口：POST /cloud/device/face-sync/sync-page（face-001）
        源码方法：com/yyide/facepass/network/INetworkService
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：schoolId、deviceNo

        JSON 请求体（application/json）：
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            deviceNo: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 100）
                每页条数；服务端混用 str/int，按模板类型传
            body: FaceCloudDeviceFaceSyncSyncPageBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.face_cloud_device_face_sync_sync_page(
                schoolId=client.context["school_id"],
                deviceNo=client.context["mac"]
            )
        """
        return self._invoke(
            "face-001",
            fields={
                "schoolId": schoolId,
                "deviceNo": deviceNo,
                "pageNo": pageNo,
                "pageSize": pageSize,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def face_cloud_device_face_sync_sync_all(
        self,
        *,
        schoolId: str | None = None,
        deviceNo: str | None = None,
        body: FaceCloudDeviceFaceSyncSyncAllBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """人脸同步（FacePass） · 全量同步人脸

        接口：POST /cloud/device/face-sync/sync-all（face-002）
        源码方法：com/yyide/facepass/network/INetworkService
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：schoolId、deviceNo

        JSON 请求体（application/json）：
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            deviceNo: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            body: FaceCloudDeviceFaceSyncSyncAllBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.face_cloud_device_face_sync_sync_all(
                schoolId=client.context["school_id"],
                deviceNo=client.context["mac"]
            )
        """
        return self._invoke(
            "face-002",
            fields={"schoolId": schoolId, "deviceNo": deviceNo},
            body=body,
            extra=extra,
            full=full,
        )

    def face_cloud_device_face_sync_batch_update_status(
        self,
        *,
        schoolId: str | None = None,
        deviceNo: str | None = None,
        list: List[Any] | None = None,
        body: FaceCloudDeviceFaceSyncBatchUpdateStatusBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """人脸同步（FacePass） · 批量更新同步状态

        接口：POST /cloud/device/face-sync/batch-update-status（face-003）
        源码方法：com/yyide/facepass/network/INetworkService
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：schoolId、deviceNo

        JSON 请求体（application/json）：
            schoolId: str | None（自动）
                学校 ID；占位符 {school_id} 取学校配置或 /brand/obtain
            deviceNo: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            list: List[Any] | None（可选，默认 []）
                人脸同步状态列表
            body: FaceCloudDeviceFaceSyncBatchUpdateStatusBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.face_cloud_device_face_sync_batch_update_status(
                schoolId=client.context["school_id"],
                deviceNo=client.context["mac"]
            )
        """
        return self._invoke(
            "face-003",
            fields={
                "schoolId": schoolId,
                "deviceNo": deviceNo,
                "list": list,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def face_cloud_v2_machine_updateapkversion(
        self,
        *,
        deviceNo: str | None = None,
        version: str = '3.0.14',
        body: FaceCloudV2MachineUpdateapkversionBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """人脸同步（FacePass） · 上报 APK 版本

        接口：POST /cloud/v2/machine/updateApkVersion（face-004）
        源码方法：com/yyide/facepass/network/INetworkService
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：deviceNo

        JSON 请求体（application/json）：
            deviceNo: str | None（自动）
                设备 MAC（12 位，去冒号、小写）；占位符 {mac} 取 --mac / YIDE_MAC / adb
            version: str（可选，默认 "3.0.14"）
                版本号，如 3.0.14
            body: FaceCloudV2MachineUpdateapkversionBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.face_cloud_v2_machine_updateapkversion(deviceNo=client.context["mac"])
        """
        return self._invoke(
            "face-004",
            fields={"deviceNo": deviceNo, "version": version},
            body=body,
            extra=extra,
            full=full,
        )

    def external_ai_chat_completion_stream(
        self,
        *,
        sessionId: str | None = None,
        prompt: str | None = None,
        body: ExternalAiChatCompletionStreamBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """外部/手工接口 · AI 流式对话（text/event-stream）

        接口：POST /ai/chat/completion/stream（external-001）
        源码方法：network/base/SSEClient
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        说明：SSE 流式响应，返回 requests.Response，用 iter_lines() 读取。
        必填：sessionId、prompt

        JSON 请求体（application/json）：
            sessionId: str | None（必填）
                AI 会话 ID；占位符 {session_id} 需传参或写入 context['session_id']
            prompt: str | None（必填）
                用户提问内容；占位符 {prompt} 需传参或写入 context['prompt']
            body: ExternalAiChatCompletionStreamBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            requests.Response（SSE 流），用 iter_lines() 逐行读取。

        示例：
            client.external_ai_chat_completion_stream(sessionId="<session_id>", prompt="<prompt>")
        """
        return self._invoke(
            "external-001",
            fields={"sessionId": sessionId, "prompt": prompt},
            body=body,
            extra=extra,
            full=full,
        )

    def external_brand_brand_album_list(
        self,
        *,
        classesId: str | None = None,
        kind: str = '1',
        type: str = '1',
        limitNum: int = 10,
        body: ExternalBrandBrandAlbumListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """外部/手工接口 · 旧相册列表（HttpUtils.post）

        接口：POST /brand/brand/album/list（external-002）
        源码方法：net/MachineIpService
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        JSON 请求体（application/json）：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            kind: str（可选，默认 "1"）
                类型；相册接口 1=班级相册
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            limitNum: int（可选，默认 10）
                返回条数上限
            body: ExternalBrandBrandAlbumListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.external_brand_brand_album_list(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "external-002",
            fields={
                "classesId": classesId,
                "kind": kind,
                "type": type,
                "limitNum": limitNum,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def external_brand_brand_album_listdetail(
        self,
        *,
        classesId: str | None = None,
        kind: str = '1',
        type: str = '1',
        body: ExternalBrandBrandAlbumListdetailBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """外部/手工接口 · 旧相册详情（HttpUtils.post）

        接口：POST /brand/brand/album/listDetail（external-003）
        源码方法：net/MachineIpService
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        JSON 请求体（application/json）：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            kind: str（可选，默认 "1"）
                类型；相册接口 1=班级相册
            type: str（可选，默认 "1"）
                类型；取值随接口（如 1 图片/2 视频、1 教师/2 学生）
            body: ExternalBrandBrandAlbumListdetailBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.external_brand_brand_album_listdetail(classesId=client.context["classes_id"])
        """
        return self._invoke(
            "external-003",
            fields={
                "classesId": classesId,
                "kind": kind,
                "type": type,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def external_brand_class_brand_management_android_videoalbum_list(
        self,
        *,
        classesId: str | None = None,
        pageNo: int = 1,
        pageSize: int = 20,
        body: ExternalBrandClassBrandManagementAndroidVideoalbumListBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """外部/手工接口 · 旧视频列表（HttpUtils2.post）

        接口：POST /brand/class-brand-management/android/videoalbum/list（external-004）
        源码方法：net/MachineIpService2
        鉴权：需要 Bearer token（BrandClient 登录后自动注入）
        必填：无
        自动：classesId

        JSON 请求体（application/json）：
            classesId: str | None（自动）
                班级 ID；占位符 {classes_id} /brand/obtain 后写入 context
            pageNo: int（可选，默认 1）
                页码，从 1 开始
            pageSize: int（可选，默认 20）
                每页条数；服务端混用 str/int，按模板类型传
            body: ExternalBrandClassBrandManagementAndroidVideoalbumListBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.external_brand_class_brand_management_android_videoalbum_list(
                classesId=client.context["classes_id"]
            )
        """
        return self._invoke(
            "external-004",
            fields={
                "classesId": classesId,
                "pageNo": pageNo,
                "pageSize": pageSize,
            },
            body=body,
            extra=extra,
            full=full,
        )

    def external_v4_openim_get_c2c_unread_msg_num(
        self,
        *,
        sdkappid: str | None = None,
        identifier: str | None = None,
        usersig: str | None = None,
        random: str | None = None,
        contenttype: str = 'json',
        To_Account: str | None = None,
        body: ExternalV4OpenimGetC2cUnreadMsgNumBody | None = None,
        full: bool = False,
        **extra: Any,
    ) -> Any:
        """外部/手工接口 · 腾讯云 IM：查询单聊未读数（需要管理员 UserSig）

        接口：POST /v4/openim/get_c2c_unread_msg_num（external-005）
        源码方法：MainActivity.getStudentMsg
        鉴权：无需 Bearer token
        注意：源码需要额外签名/UserSig，runner 默认不执行，仅用于预览或伪造。
        必填：sdkappid、identifier、usersig
        自动：random、To_Account

        Query 参数：
            sdkappid: str | None（必填）
                腾讯云 IM SDKAppID；占位符 {tim_sdkappid} 需传参或写入 context['tim_sdkappid']
            identifier: str | None（必填）
                标识；公告接口固定 announcement，IM 接口为用户 ID；占位符 {tim_admin_identifier} 需传参或写入
                context['tim_admin_identifier']
            usersig: str | None（必填）
                腾讯云 IM UserSig（管理员签名）；占位符 {tim_admin_usersig} 需传参或写入
                context['tim_admin_usersig']
            random: str | None（自动）
                16 位随机串，自动生成；占位符 {random} 自动生成 16 位随机串
            contenttype: str（可选，默认 "json"）
                IM 请求内容类型，固定 json

        JSON 请求体（application/json）：
            To_Account: str | None（自动）
                腾讯云 IM 目标账号（学生 userId）；占位符 {student_id} 自动发现或由参数写入 context
            body: ExternalV4OpenimGetC2cUnreadMsgNumBody | None
                完整 JSON 请求体（TypedDict，IDE 可补全字段）；与上面的字段合并，显式字段优先。

        其它参数：
            full（bool）：True 时返回完整响应外壳 {"code":0,"data":...}；
                默认只返回 data 字段。
            **extra：透传未列出的字段，按 path/query/JSON/form 自动归类；
                也兼容 params/json_body/form_body/files 覆盖。

        返回：
            data 字段（dict/list/str/None）；失败抛 ApiError。

        示例：
            client.external_v4_openim_get_c2c_unread_msg_num(
                sdkappid="<tim_sdkappid>",
                identifier="<tim_admin_identifier>"
            )
        """
        return self._invoke(
            "external-005",
            fields={
                "sdkappid": sdkappid,
                "identifier": identifier,
                "usersig": usersig,
                "random": random,
                "contenttype": contenttype,
                "To_Account": To_Account,
            },
            body=body,
            extra=extra,
            full=full,
        )
    # </generated: methods>
