"""Real-environment HTTP client and request-spec builder.

This module only talks to the production / vendor endpoints from
本地凭据:

    https://api.yyide.com
    https://api.ttlock.com.cn
    https://open-lcs.libsaas.com.cn
    https://zhwnlapi.etouch.cn

The browser User-Agent is applied to every request.

Pipeline::

    Endpoint (apis/*.py template)
        -> prepare() renders {placeholders} from ApiClient.context
        -> RequestSpec (URL / query / JSON / form / files / headers)
        -> execute() sends the request with requests.Session

Unresolved placeholder names are collected in RequestSpec.unresolved; execute()
refuses to send such a request.
"""
from __future__ import annotations

import hashlib
import json
import os
import random
import re
import string
import time
from dataclasses import dataclass, field
from typing import Any, Dict, Iterable, List, Optional, Tuple
from urllib.parse import quote

import requests

from .credentials import Settings

PLACEHOLDER = re.compile(r"\{([a-zA-Z_][\w]*)\}")
SENSITIVE_QUERY = {
    "password", "client_secret", "secret", "secretkey", "access_token",
    "refreshtoken", "refresh_token", "usersig", "user_sig", "token",
    "authorization", "client_secret_key", "door_password",
}

# Java-style names used by the APK -> snake_case context keys.  Keeping the
# table in one place ensures _set_context() and _sync_aliases() agree.
CONTEXT_ALIASES = {
    "ctrlNo": "ctrl_no",
    "topType": "top_type",
    "classId": "classes_id",
    "classesId": "classes_id",
    "schoolId": "school_id",
    "studentId": "student_id",
    "brandId": "brand_id",
    "siteId": "site_id",
    "libraryId": "library_id",
    "itemTypeId": "item_type_id",
    "employeeId": "teacher_id",
    "deviceNo": "mac",
}


def redact_value(value: Any) -> Any:
    """Deep-copy JSON-like data, replacing sensitive keys with ***."""
    if isinstance(value, dict):
        return {
            key: ("***" if str(key).lower() in SENSITIVE_QUERY else redact_value(val))
            for key, val in value.items()
        }
    if isinstance(value, list):
        return [redact_value(item) for item in value]
    return value


class Endpoint:
    """One request template from apis/*.py.

    Attributes:
        id: stable endpoint id, e.g. home-002.
        method: HTTP method.
        path: URL path or absolute URL; {name} is rendered from context.
        params: query parameters (path keys are removed by prepare()).
        json_body: JSON body template (dict / list / None).
        form_body: form body template used by TTLock.
        files: multipart map: field name -> local file path.
        auth: send Authorization: Bearer ...
        base: optional base-URL override.
        client: yide / ttlock / book / weather / external.
        description: human-readable label.
        source: original Retrofit method (or source location).
        headers: extra headers.
        stream: response is text/event-stream.
        executable: False for templates that need extra signing/UserSig.
    """

    __slots__ = (
        "id", "method", "path", "params", "json_body", "form_body", "files",
        "auth", "base", "client", "description", "source", "headers",
        "stream", "executable",
    )

    def __init__(
        self,
        id: str,
        method: str,
        path: str,
        params: Optional[Dict[str, Any]] = None,
        json_body: Any = None,
        form_body: Optional[Dict[str, Any]] = None,
        files: Optional[Dict[str, str]] = None,
        auth: bool = True,
        base: Optional[str] = None,
        client: str = "yide",
        description: str = "",
        source: str = "",
        headers: Optional[Dict[str, str]] = None,
        stream: bool = False,
        executable: bool = True,
    ) -> None:
        self.id = id
        self.method = method.upper()
        self.path = path
        self.params = params or {}
        self.json_body = json_body
        self.form_body = form_body
        self.files = files
        self.auth = auth
        self.base = base
        self.client = client
        self.description = description
        self.source = source
        self.headers = headers or {}
        self.stream = stream
        self.executable = executable

    def __repr__(self) -> str:
        return f"Endpoint({self.id!r}, {self.method!r}, {self.path!r})"


@dataclass
class RequestSpec:
    """Fully rendered request, ready for requests.

    unresolved lists placeholder names that were not present in the context;
    execute() refuses to send while it is non-empty.  The redacted_* helpers
    keep secrets out of runner output and logs.
    """

    endpoint: Endpoint
    method: str
    url: str
    params: Dict[str, Any] = field(default_factory=dict)
    json_body: Any = None
    form_body: Optional[Dict[str, Any]] = None
    files: Optional[Dict[str, str]] = None
    headers: Dict[str, str] = field(default_factory=dict)
    stream: bool = False
    unresolved: List[str] = field(default_factory=list)

    @property
    def ok_to_send(self) -> bool:
        return not self.unresolved

    def redacted_headers(self) -> Dict[str, str]:
        out = dict(self.headers)
        for key in list(out):
            if key.lower() in ("authorization", "cookie"):
                out[key] = "***"
        return out

    def redacted_params(self) -> Dict[str, Any]:
        return redact_value(self.params)

    def redacted_json_body(self) -> Any:
        return redact_value(self.json_body)

    def redacted_form_body(self) -> Any:
        return redact_value(self.form_body)

    def curl(self) -> str:
        """Return a copy-pasteable curl command with secrets redacted."""
        from urllib.parse import urlencode

        url = self.url
        params = self.redacted_params()
        if params:
            url += ("&" if "?" in url else "?") + urlencode(params, doseq=True)
        parts = ["curl", "-X", self.method, quote_shell(url)]
        header_names = {key.lower() for key in self.headers}
        if self.endpoint.auth and "authorization" not in header_names:
            parts += ["-H", quote_shell("Authorization: Bearer {access_token}")]
        for key, value in self.redacted_headers().items():
            parts += ["-H", quote_shell(f"{key}: {value}")]
        form = self.redacted_form_body()
        body = self.redacted_json_body()
        if form is not None:
            for key, value in form.items():
                parts += ["--data-urlencode", quote_shell(f"{key}={value}")]
        elif body is not None:
            if "content-type" not in header_names:
                parts += ["-H", "Content-Type: application/json"]
            parts += ["--data-raw", quote_shell(json.dumps(body, ensure_ascii=False))]
        if self.files:
            for key, path in self.files.items():
                parts += ["-F", quote_shell(f"{key}=@{path}")]
        return " ".join(parts)


def quote_shell(value: str) -> str:
    return "'" + str(value).replace("'", "'\"'\"'") + "'"


def random_string(length: int = 16) -> str:
    alphabet = string.ascii_letters + string.digits
    return "".join(random.choice(alphabet) for _ in range(length))


def _md5(text: str) -> str:
    return hashlib.md5(text.encode("utf-8")).hexdigest()


def render(value: Any, context: Dict[str, Any]) -> Tuple[Any, List[str]]:
    """Replace {name} placeholders recursively; collect unresolved names.

    A placeholder resolves when its key exists in context and the value is not
    None or an empty string.  The original {name} token is kept when it is
    missing, so previews show exactly which value still has to be supplied.
    """
    missing: List[str] = []

    if isinstance(value, str):
        def repl(match: re.Match[str]) -> str:
            key = match.group(1)
            if key in context and context[key] not in (None, ""):
                return str(context[key])
            missing.append(key)
            return match.group(0)

        return PLACEHOLDER.sub(repl, value), missing
    if isinstance(value, dict):
        out: Dict[str, Any] = {}
        for key, val in value.items():
            rendered, miss = render(val, context)
            out[key] = rendered
            missing.extend(miss)
        return out, missing
    if isinstance(value, (list, tuple)):
        out_list = []
        for val in value:
            rendered, miss = render(val, context)
            out_list.append(rendered)
            missing.extend(miss)
        return out_list, missing
    return value, missing


def join_url(base: str, path: str) -> str:
    """Join a base URL and path, keeping absolute paths untouched."""
    if path.startswith("http://") or path.startswith("https://"):
        return path
    return base.rstrip("/") + "/" + path.lstrip("/")


class ApiError(RuntimeError):
    """HTTP or business-code failure, carrying status and response body."""

    def __init__(self, message: str, status: Optional[int] = None, body: Any = None):
        super().__init__(message)
        self.status = status
        self.body = body


class ApiClient:
    """Session wrapper that renders endpoint templates and sends requests.

    context is a flat dict of runtime values (account, MAC, brand/classes ids,
    tokens).  _set_context keeps Java-style and snake_case spellings in sync,
    so classesId and classes_id both work in templates.
    """

    def __init__(self, settings: Settings, context: Optional[Dict[str, Any]] = None):
        self.settings = settings
        self.session = requests.Session()
        self.session.headers.update({
            "User-Agent": settings.user_agent,
            "Accept-Language": "zh-CN,zh;q=0.9,en;q=0.8",
        })
        self.token = ""
        self.context: Dict[str, Any] = settings.as_context()
        self.context.setdefault("random", random_string(16))
        if settings.ttlock_password:
            self.context.setdefault("ttlock_password_md5", _md5(settings.ttlock_password))
        if context:
            self.context.update(context)
        self._sync_aliases()

    @staticmethod
    def _snake(name: str) -> str:
        value = re.sub(r"(?<!^)(?=[A-Z])", "_", name)
        return re.sub(r"[^0-9a-zA-Z_]+", "_", value).strip("_").lower()

    def _set_context(self, key: str, value: Any) -> None:
        """Store a value under its Java-style and snake_case names.

        The alias table keeps classId/classes_id, deviceNo/mac and
        employeeId/teacher_id in sync, so generated methods can be called with
        either spelling and later placeholders still resolve.
        """
        self.context[key] = value
        snake = self._snake(key)
        if snake:
            self.context[snake] = value
        for alias, target in CONTEXT_ALIASES.items():
            if target == snake:
                self.context[alias] = value
            if alias == key:
                self.context[target] = value

    def _sync_aliases(self) -> None:
        """Fill Java-style aliases from snake_case context values."""
        for alias, key in CONTEXT_ALIASES.items():
            if alias not in self.context and self.context.get(key):
                self.context[alias] = self.context[key]

    # ------------------------------------------------------------------ auth
    def set_token(self, token: str) -> None:
        """Set a Bearer token and keep the raw token in context."""
        if not token.lower().startswith("bearer "):
            token = "Bearer " + token
        self.token = token
        self.session.headers["Authorization"] = token
        self.context["access_token"] = token[7:]

    def login_yide(self) -> Dict[str, Any]:
        """OAuth password login; stores accessToken/refreshToken in context."""
        username = str(self.context.get("username") or "")
        password = str(self.context.get("password") or "")
        if not username or not password:
            raise ApiError("YIDE_USERNAME / YIDE_PASSWORD 未配置，无法登录真实环境")
        if not self.settings.yide_client_secret:
            raise ApiError("YIDE_CLIENT_SECRET 未配置（见 本地凭据 / YIDE_CLIENT_SECRET）")

        random_value = random_string(16)
        self.context["random"] = random_value
        params = {
            "username": username,
            "password": password,
            "client_id": self.settings.yide_client_id,
            "grant_type": "brand",
            "client_secret": self.settings.yide_client_secret,
            "random": random_value,
        }
        resp = self.session.post(
            join_url(self.settings.yide_base_url, "/auth/oauth/token"),
            params=params,
            timeout=self.settings.timeout,
            verify=self.settings.verify_tls,
        )
        body = self._json(resp, "OAuth 登录")
        data = body.get("data") or {}
        access = data.get("accessToken") or data.get("access_token") or data.get("token")
        if not access:
            raise ApiError(f"OAuth 响应没有 accessToken: {body}", resp.status_code, body)
        token_head = data.get("tokenHead") or "Bearer "
        self.token = str(token_head) + str(access)
        self.session.headers["Authorization"] = self.token
        self.context["access_token"] = access
        self.context["refresh_token"] = data.get("refreshToken") or data.get("refresh_token") or ""
        return body

    def obtain(self, mac: Optional[str] = None, android_id: Optional[str] = None) -> Dict[str, Any]:
        """Call /brand/obtain and fill brand/classes/site/school ids."""
        mac = mac or str(self.context.get("mac") or "")
        android_id = android_id or str(self.context.get("android_id") or "")
        if not mac:
            raise ApiError("设备 MAC 未配置（--mac / YIDE_MAC）")
        if not self.token:
            self.login_yide()
        body = {
            "loginName": self.context.get("username"),
            "no": mac,
            "wlanMac": "",
            "seriaNo": android_id,
            "direction": "0",
        }
        resp = self.session.post(
            join_url(self.settings.yide_base_url, "/brand/obtain"),
            json=body,
            timeout=self.settings.timeout,
            verify=self.settings.verify_tls,
        )
        payload = self._json(resp, "/brand/obtain")
        data = payload.get("data") or {}
        for key in ("id", "schoolId", "classesId", "siteId", "brandName"):
            if data.get(key):
                mapped = {
                    "id": "brand_id",
                    "schoolId": "school_id",
                    "classesId": "classes_id",
                    "siteId": "site_id",
                    "brandName": "brand_name",
                }[key]
                self.context[mapped] = data[key]
        self.context["mac"] = mac
        self.context["android_id"] = android_id
        self.context["obtain"] = data
        return payload

    def discover_student(self) -> Optional[str]:
        """Fetch the first student of the current class and store student_id."""
        classes_id = self.context.get("classes_id")
        if not classes_id or not self.token:
            return None
        resp = self.session.post(
            join_url(self.settings.yide_base_url, "/cloud/student/allStudents"),
            json={"pageNo": 1, "pageSize": 100, "id": classes_id, "type": 4, "key": "classes"},
            timeout=self.settings.timeout,
            verify=self.settings.verify_tls,
        )
        payload = self._json(resp, "/cloud/student/allStudents")
        data = payload.get("data")
        rows: Iterable[Any] = []
        if isinstance(data, dict):
            rows = data.get("list") or data.get("records") or []
        elif isinstance(data, list):
            rows = data
        for row in rows:
            if isinstance(row, dict):
                sid = row.get("id") or row.get("userId") or row.get("studentId")
                if sid:
                    self.context["student_id"] = str(sid)
                    self.context["student_name"] = str(row.get("name") or row.get("userName") or "")
                    return str(sid)
        return None

    def login_ttlock(self) -> Dict[str, Any]:
        """TTLock OAuth login; stores ttlock_access_token for form requests."""
        username = str(self.context.get("ttlock_username") or "")
        password = str(self.context.get("ttlock_password") or "")
        if not username or not password:
            raise ApiError("TTLOCK_USERNAME / TTLOCK_PASSWORD 未配置")
        if not self.settings.ttlock_client_secret:
            raise ApiError("TTLOCK_CLIENT_SECRET 未配置")
        password_md5 = _md5(password)
        self.context["ttlock_password_md5"] = password_md5
        form = {
            "client_id": self.settings.ttlock_client_id,
            "client_secret": self.settings.ttlock_client_secret,
            "grant_type": "password",
            "username": username,
            "password": password_md5,
            "redirect_uri": "http://www.1yide.com/",
        }
        resp = self.session.post(
            join_url(self.settings.ttlock_base_url, "/oauth2/token"),
            data=form,
            timeout=self.settings.timeout,
            verify=self.settings.verify_tls,
        )
        payload = self._json(resp, "TTLock 登录")
        token = payload.get("access_token") or payload.get("accessToken") or payload.get("token")
        if not token:
            raise ApiError(f"TTLock 响应没有 access_token: {payload}", resp.status_code, payload)
        self.context["ttlock_access_token"] = token
        return payload

    # --------------------------------------------------------------- prepare
    def prepare(self, endpoint: Endpoint) -> RequestSpec:
        """Render one endpoint template into a concrete RequestSpec.

        Steps: sync context aliases -> render path/query/JSON/files -> build
        headers (Content-Type, Accept, Authorization) -> collect unresolved
        placeholder names for the caller.
        """
        self._sync_aliases()
        if endpoint.client == "ttlock":
            return self._prepare_ttlock(endpoint)

        base = endpoint.base
        if not base:
            base = {
                "yide": self.settings.yide_base_url,
                "book": self.settings.book_base_url,
                "weather": self.settings.weather_base_url,
            }.get(endpoint.client, self.settings.yide_base_url)

        path, missing = render(endpoint.path, self.context)
        path_keys = set(re.findall(r"\{([a-zA-Z_][\w]*)\}", endpoint.path))
        params, miss = render(endpoint.params, self.context)
        missing.extend(miss)
        if path_keys:
            params = {k: v for k, v in params.items() if k not in path_keys}

        json_body = None
        if endpoint.json_body is not None:
            json_body, miss = render(endpoint.json_body, self.context)
            missing.extend(miss)

        files = None
        if endpoint.files:
            files, miss = render(endpoint.files, self.context)
            missing.extend(miss)

        headers = {
            "User-Agent": self.settings.user_agent,
            "Accept-Language": "zh-CN,zh;q=0.9,en;q=0.8",
        }
        if endpoint.stream:
            headers["Accept"] = "text/event-stream"
        else:
            headers["Accept"] = "application/json, text/plain, */*"
        if json_body is not None and not files:
            headers["Content-Type"] = "application/json"
        elif endpoint.form_body is not None:
            headers["Content-Type"] = "application/x-www-form-urlencoded"
        if endpoint.auth:
            if self.token:
                headers["Authorization"] = self.token
            else:
                missing.append("token")

        headers.update(endpoint.headers)
        return RequestSpec(
            endpoint=endpoint,
            method=endpoint.method,
            url=join_url(base, path),
            params=params,
            json_body=json_body,
            files=files,
            headers=headers,
            stream=endpoint.stream,
            unresolved=sorted(set(missing)),
        )

    def _prepare_ttlock(self, endpoint: Endpoint) -> RequestSpec:
        """Render a TTLock request (clientId/accessToken/date in form/query)."""
        form, missing = render(endpoint.form_body or {}, self.context)
        params, miss = render(endpoint.params, self.context)
        missing.extend(miss)
        if endpoint.path != "/oauth2/token":
            now_ms = str(int(time.time() * 1000))
            for target in (form, params):
                target.setdefault("clientId", self.settings.ttlock_client_id)
                target.setdefault("accessToken", self.context.get("ttlock_access_token", "{ttlock_access_token}"))
                target["date"] = now_ms
            missing = [item for item in missing if item != "timestamp_ms"]
            if not self.context.get("ttlock_access_token"):
                missing.append("ttlock_access_token")
        headers = {
            "User-Agent": self.settings.user_agent,
            "Accept": "application/json, text/plain, */*",
            "Content-Type": "application/x-www-form-urlencoded",
        }
        return RequestSpec(
            endpoint=endpoint,
            method=endpoint.method,
            url=join_url(self.settings.ttlock_base_url, endpoint.path),
            params=params if endpoint.method == "GET" else {},
            form_body=form if endpoint.method != "GET" else None,
            headers=headers,
            unresolved=sorted(set(missing)),
        )

    # ---------------------------------------------------------------- execute
    def execute(self, spec: RequestSpec) -> requests.Response:
        """Send a prepared request; refuse to send unresolved placeholders."""
        if spec.unresolved:
            raise ApiError("未解析的占位符: " + ", ".join(spec.unresolved))
        if spec.files:
            handles = {}
            try:
                for key, path in spec.files.items():
                    if not os.path.isfile(path):
                        raise ApiError(f"文件不存在: {path}")
                    handles[key] = open(path, "rb")
                return self.session.request(
                    spec.method, spec.url, params=spec.params, data=spec.form_body,
                    files=handles, headers=spec.headers, timeout=self.settings.timeout,
                    verify=self.settings.verify_tls, stream=spec.stream,
                )
            finally:
                for handle in handles.values():
                    handle.close()
        if spec.form_body is not None:
            return self.session.request(
                spec.method, spec.url, params=spec.params, data=spec.form_body,
                headers=spec.headers, timeout=self.settings.timeout,
                verify=self.settings.verify_tls, stream=spec.stream,
            )
        return self.session.request(
            spec.method, spec.url, params=spec.params, json=spec.json_body,
            headers=spec.headers, timeout=self.settings.timeout,
            verify=self.settings.verify_tls, stream=spec.stream,
        )

    # ------------------------------------------------------------------ utils
    @staticmethod
    def _json(resp: requests.Response, label: str) -> Dict[str, Any]:
        """Parse a response envelope and raise ApiError for HTTP/code errors."""
        try:
            body = resp.json()
        except ValueError:
            raise ApiError(f"{label}: HTTP {resp.status_code}, 非 JSON 响应: {resp.text[:300]}",
                           resp.status_code, resp.text[:300])
        if not resp.ok:
            raise ApiError(f"{label}: HTTP {resp.status_code}: {body}", resp.status_code, body)
        if isinstance(body, dict) and body.get("code") not in (None, 0):
            raise ApiError(
                f"{label}: code={body.get('code')} message={body.get('message')} detail={body.get('detailMessage')}",
                resp.status_code, body,
            )
        return body

    @staticmethod
    def redact_mapping(data: Dict[str, Any]) -> Dict[str, Any]:
        """Shallow-copy a mapping with sensitive values replaced by ***."""
        out = {}
        for key, value in data.items():
            if key.lower() in SENSITIVE_QUERY:
                out[key] = "***"
            else:
                out[key] = value
        return out
