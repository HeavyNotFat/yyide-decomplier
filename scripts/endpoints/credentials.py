"""Runtime settings for the real-environment endpoint runner.

Priority: command line (handled in runner.py) > environment > 本地凭据.

The defaults below are *real* production endpoints from the APK / 本地凭据:
    Yide    https://api.yyide.com
    TTLock  https://api.ttlock.com.cn
    Book    https://open-lcs.libsaas.com.cn
    Weather https://zhwnlapi.etouch.cn
All identifiers are supplied by the real device or resolved from /brand/obtain.
"""
from __future__ import annotations

import os
from dataclasses import dataclass, field
from typing import Dict, Optional

from .permission_loader import load_permission

USER_AGENT = (
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
    "AppleWebKit/537.36 (KHTML, like Gecko) "
    "Chrome/154.0.0.0 Safari/537.36 Edg/154.0.0.0"
)

YIDE_BASE_URL = "https://api.yyide.com"
TTLOCK_BASE_URL = "https://api.ttlock.com.cn"
BOOK_BASE_URL = "https://open-lcs.libsaas.com.cn"
WEATHER_BASE_URL = "https://zhwnlapi.etouch.cn"

# Real "兼善" schoolId from the original reverse-engineering notes.  Override
# with YIDE_SCHOOL_ID or --school-id when working with another school.
DEFAULT_SCHOOL_ID = "1959804909729640450"


def _env(*names: str, default: Optional[str] = None) -> Optional[str]:
    for name in names:
        value = os.environ.get(name)
        if value:
            return value
    return default


@dataclass
class Settings:
    # Yide cloud
    yide_base_url: str = YIDE_BASE_URL
    yide_client_id: str = "yide-cloud"
    yide_client_secret: str = ""
    yide_username: str = ""
    yide_password: str = ""
    yide_school_id: str = DEFAULT_SCHOOL_ID
    yide_mac: str = ""
    yide_android_id: str = ""
    yide_device_type: str = "2"

    # TTLock
    ttlock_base_url: str = TTLOCK_BASE_URL
    ttlock_client_id: str = ""
    ttlock_client_secret: str = ""
    ttlock_username: str = ""
    ttlock_password: str = ""

    # Book / weather
    book_base_url: str = BOOK_BASE_URL
    book_url_key: str = ""
    weather_base_url: str = WEATHER_BASE_URL

    # MQTT (not HTTP; exposed for completeness)
    mqtt_host: str = "tcp://116.63.71.76:1883"
    mqtt_username: str = ""
    mqtt_password: str = ""

    # Tencent IM
    tim_sdkappid: str = ""
    tim_secret_key: str = ""

    user_agent: str = USER_AGENT
    timeout: float = 30.0
    verify_tls: bool = True

    # Resolved at runtime from /brand/obtain or from real device values.
    context: Dict[str, str] = field(default_factory=dict)

    def __post_init__(self) -> None:
        # Do not fabricate device identifiers.  A real board MAC and Android ID
        # are required for --execute; the request-table builder keeps the
        # {mac}/{android_id} placeholders instead.
        pass

    def as_context(self) -> Dict[str, str]:
        return {
            "username": self.yide_username,
            "password": self.yide_password,
            "client_id": self.yide_client_id,
            "client_secret": self.yide_client_secret,
            "mac": self.yide_mac,
            "android_id": self.yide_android_id,
            "school_id": self.yide_school_id,
            "device_type": self.yide_device_type,
            "ttlock_username": self.ttlock_username,
            "ttlock_password": self.ttlock_password,
            "ttlock_client_id": self.ttlock_client_id,
            "ttlock_client_secret": self.ttlock_client_secret,
        }

    def redacted(self) -> Dict[str, str]:
        def mask(value: str) -> str:
            if not value:
                return ""
            if len(value) <= 8:
                return "***"
            return value[:4] + "..." + value[-4:]

        return {
            "yide_base_url": self.yide_base_url,
            "yide_client_id": self.yide_client_id,
            "yide_client_secret": mask(self.yide_client_secret),
            "yide_username": self.yide_username,
            "yide_password": mask(self.yide_password),
            "yide_school_id": self.yide_school_id,
            "yide_mac": self.yide_mac,
            "yide_android_id": self.yide_android_id,
            "ttlock_base_url": self.ttlock_base_url,
            "ttlock_client_id": self.ttlock_client_id,
            "ttlock_client_secret": mask(self.ttlock_client_secret),
            "ttlock_username": self.ttlock_username,
            "ttlock_password": mask(self.ttlock_password),
            "book_base_url": self.book_base_url,
            "weather_base_url": self.weather_base_url,
            "mqtt_host": self.mqtt_host,
            "mqtt_username": self.mqtt_username,
            "tim_sdkappid": self.tim_sdkappid,
        }


def load_settings(permission_path: Optional[str] = None) -> Settings:
    values = load_permission(permission_path) if permission_path else load_permission()
    return Settings(
        yide_base_url=_env("YIDE_BASE_URL", default=YIDE_BASE_URL) or YIDE_BASE_URL,
        yide_client_id=_env("YIDE_CLIENT_ID", default=values.get("yide_client_id")) or "yide-cloud",
        yide_client_secret=_env("YIDE_CLIENT_SECRET", default=values.get("yide_client_secret")) or "",
        yide_username=_env("YIDE_USERNAME", default=values.get("yide_username")) or "",
        yide_password=_env("YIDE_PASSWORD", default=values.get("yide_password")) or "",
        yide_school_id=_env("YIDE_SCHOOL_ID", default=DEFAULT_SCHOOL_ID) or DEFAULT_SCHOOL_ID,
        yide_mac=_env("YIDE_MAC", default="") or "",
        yide_android_id=_env("YIDE_ANDROID_ID", default="") or "",
        ttlock_base_url=_env("TTLOCK_BASE_URL", default=TTLOCK_BASE_URL) or TTLOCK_BASE_URL,
        ttlock_client_id=_env("TTLOCK_CLIENT_ID", default=values.get("ttlock_client_id")) or "",
        ttlock_client_secret=_env("TTLOCK_CLIENT_SECRET", default=values.get("ttlock_client_secret")) or "",
        ttlock_username=_env("TTLOCK_USERNAME", default=values.get("ttlock_username")) or "",
        ttlock_password=_env("TTLOCK_PASSWORD", default=values.get("ttlock_password")) or "",
        book_base_url=_env("BOOK_BASE_URL", default=BOOK_BASE_URL) or BOOK_BASE_URL,
        book_url_key=_env("BOOK_URL_KEY", default=values.get("book_url_key")) or "",
        weather_base_url=_env("WEATHER_BASE_URL", default=WEATHER_BASE_URL) or WEATHER_BASE_URL,
        mqtt_host=_env("MQTT_HOST", default="tcp://116.63.71.76:1883") or "",
        mqtt_username=_env("MQTT_USERNAME", default=values.get("mqtt_username")) or "",
        mqtt_password=_env("MQTT_PASSWORD", default=values.get("mqtt_password")) or "",
        tim_sdkappid=_env("TIM_SDKAPPID", default=values.get("tim_sdkappid")) or "",
        tim_secret_key=_env("TIM_SECRET_KEY", default=values.get("tim_secret_key")) or "",
        user_agent=_env("ENDPOINTS_USER_AGENT", default=USER_AGENT) or USER_AGENT,
        timeout=float(_env("ENDPOINTS_TIMEOUT", default="30") or 30),
        verify_tls=(_env("ENDPOINTS_VERIFY_TLS", default="1") or "1") not in ("0", "false", "False"),
    )
