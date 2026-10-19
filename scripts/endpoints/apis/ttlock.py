"""TTLock 通通锁开放平台（真实环境 https://api.ttlock.com.cn）。

The forms below are request templates.  TTLock requires a valid vendor account
and client credentials; both are read from 本地凭据 / environment by
credentials.py.  IDs such as {lock_id} are real values you obtain from
/v3/lock/list.
"""
from __future__ import annotations

from ..common import Endpoint

GROUP = "ttlock"
TITLE = "TTLock 通通锁"

_ACCESS = {
    "clientId": "{ttlock_client_id}",
    "accessToken": "{ttlock_access_token}",
    "date": "{timestamp_ms}",
}


def _post(ep_id: str, path: str, description: str, extra: dict | None = None) -> Endpoint:
    form = dict(_ACCESS)
    if extra:
        form.update(extra)
    return Endpoint(
        id=ep_id,
        method="POST",
        path=path,
        form_body=form,
        auth=False,
        client="ttlock",
        description=description,
        source="demo/retrofit/ApiService",
    )


def _get(ep_id: str, path: str, description: str, extra: dict | None = None) -> Endpoint:
    params = dict(_ACCESS)
    if extra:
        params.update(extra)
    return Endpoint(
        id=ep_id,
        method="GET",
        path=path,
        params=params,
        auth=False,
        client="ttlock",
        description=description,
        source="demo/retrofit/ApiService",
    )


ENDPOINTS = [
    Endpoint(
        id="ttlock-001",
        method="POST",
        path="/oauth2/token",
        form_body={
            "client_id": "{ttlock_client_id}",
            "client_secret": "{ttlock_client_secret}",
            "grant_type": "password",
            "username": "{ttlock_username}",
            "password": "{ttlock_password_md5}",
            "redirect_uri": "http://www.1yide.com/",
        },
        auth=False,
        client="ttlock",
        description="OAuth 登录，获取 access_token",
        source="demo/retrofit/ApiService.auth",
    ),
    _post("ttlock-002", "/v3/fingerprint/add", "添加指纹",
          {"lockId": "{lock_id}", "fingerprint": "{fingerprint}", "startDate": "{start_date}",
           "endDate": "{end_date}", "name": "{fingerprint_name}"}),
    _post("ttlock-003", "/v3/identityCard/add", "添加 IC 卡",
          {"lockId": "{lock_id}", "identityCard": "{identity_card}", "startDate": "{start_date}",
           "endDate": "{end_date}", "name": "{card_name}"}),
    _post("ttlock-004", "/v3/wirelessKeyboard/add", "添加无线键盘",
          {"lockId": "{lock_id}", "keyboardPwd": "{keyboard_pwd}", "startDate": "{start_date}",
           "endDate": "{end_date}", "name": "{keyboard_name}"}),
    _post("ttlock-005", "/v3/lock/changeAdminKeyboardPwd", "修改管理员键盘密码",
          {"lockId": "{lock_id}", "keyboardPwd": "{new_keyboard_pwd}"}),
    _post("ttlock-006", "/v3/fingerprint/clear", "清空指纹", {"lockId": "{lock_id}"}),
    _post("ttlock-007", "/v3/identityCard/clear", "清空 IC 卡", {"lockId": "{lock_id}"}),
    _post("ttlock-008", "/v3/fingerprint/delete", "删除指纹",
          {"lockId": "{lock_id}", "fingerprintId": "{fingerprint_id}"}),
    _post("ttlock-009", "/v3/identityCard/delete", "删除 IC 卡",
          {"lockId": "{lock_id}", "identityCardId": "{identity_card_id}"}),
    _post("ttlock-010", "/v3/lock/delete", "删除锁", {"lockId": "{lock_id}"}),
    _post("ttlock-011", "/v3/gateway/isInitSuccess", "网关初始化状态",
          {"gatewayNetMac": "{gateway_net_mac}"}),
    _post("ttlock-012", "/v3/gateway/upgradeCheck", "网关升级检查",
          {"gatewayId": "{gateway_id}"}),
    _post("ttlock-013", "/v3/gateway/list", "网关列表",
          {"pageNo": 1, "pageSize": 100}),
    _post("ttlock-014", "/v3/lock/list", "锁列表",
          {"pageNo": 1, "pageSize": 100}),
    _get("ttlock-015", "/v3/fingerprint/list", "指纹列表",
         {"lockId": "{lock_id}", "pageNo": 1, "pageSize": 100}),
    _get("ttlock-016", "/v3/identityCard/list", "IC 卡列表",
         {"lockId": "{lock_id}", "pageNo": 1, "pageSize": 100}),
    _get("ttlock-017", "/v3/key/list", "钥匙列表",
         {"lockId": "{lock_id}", "pageNo": 1, "pageSize": 100}),
    _post("ttlock-018", "/v3/lock/initialize", "初始化锁",
          {"lockData": "{lock_data}", "lockAlias": "{lock_alias}"}),
    _post("ttlock-019", "/v3/lock/upgradeCheck", "锁升级检查",
          {"lockId": "{lock_id}"}),
    _post("ttlock-020", "/v3/lock/upgradeRecheck", "锁升级复查",
          {"lockId": "{lock_id}", "firmwareInfo": "{firmware_info}"}),
    _post("ttlock-021", "/v3/identityCard/changePeriod", "修改 IC 卡有效期",
          {"lockId": "{lock_id}", "identityCardId": "{identity_card_id}",
           "startDate": "{start_date}", "endDate": "{end_date}"}),
    _post("ttlock-022", "/room/registerNb", "注册 NB 物联网模块",
          {"lockId": "{lock_id}", "nbNodeId": "{nb_node_id}",
           "nbCardNumber": "{nb_card_number}", "nbRssi": "{nb_rssi}",
           "nbOperator": "{nb_operator}"}),
    _post("ttlock-023", "/v3/lock/resetKeyboardPwd", "重置键盘密码",
          {"lockId": "{lock_id}", "pwdInfo": "{pwd_info}", "timestamp": "{pwd_timestamp}"}),
    _post("ttlock-024", "/v3/lock/resetKey", "重置 eKey", {"lockId": "{lock_id}"}),
    _post("ttlock-025", "/v3/gateway/uploadDetail", "上传网关详情",
          {"gatewayId": "{gateway_id}", "modelNum": "{model_num}",
           "hardwareRevision": "{hardware_revision}", "firmwareRevision": "{firmware_revision}",
           "networkName": "{network_name}"}),
    _post("ttlock-026", "/lockRecords/fromLock", "上传锁记录",
          {"lockId": "{lock_id}", "records": "{lock_records}"}),
]
