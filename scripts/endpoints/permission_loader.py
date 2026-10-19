"""Read real credential values from the repository's 本地凭据.

The file is Markdown; we only understand the simple tables used there:

    | 项目 | 值 |
    | --- | --- |
    | `client_id` | `yide-cloud` |
    | 生产密码 | `...` |

No network access, no defaults for secrets: everything comes from the file or
from environment variables (see credentials.py).
"""
from __future__ import annotations

import os
import re
from typing import Dict, Optional

DEFAULT_本地凭据 = os.path.join(
    os.path.dirname(os.path.dirname(os.path.dirname(os.path.abspath(__file__)))),
    "本地凭据",
)


def _clean(cell: str) -> str:
    return cell.strip().strip("`").strip()


def _table_pairs(text: str) -> Dict[str, str]:
    """Return {label: first backticked value} for simple Markdown table rows."""
    pairs: Dict[str, str] = {}
    for raw in text.splitlines():
        line = raw.strip()
        if not line.startswith("|"):
            continue
        cells = [c.strip() for c in line.strip("|").split("|")]
        if len(cells) < 2:
            continue
        for i in range(len(cells) - 1):
            label = _clean(cells[i])
            value_cell = cells[i + 1]
            m = re.search(r"`([^`]+)`", value_cell)
            if not label or not m:
                continue
            value = m.group(1).strip()
            # summary table has a leading "#" and platform columns; the label is
            # still the cell immediately before the value, so this works.
            pairs.setdefault(label, value)
    return pairs


def _find(pairs: Dict[str, str], *needles: str) -> Optional[str]:
    for needle in needles:
        if needle in pairs:
            return pairs[needle]
    for key, value in pairs.items():
        if any(n in key for n in needles):
            return value
    return None


def load_permission(path: str = DEFAULT_本地凭据) -> Dict[str, Optional[str]]:
    """Extract the values used by scripts/endpoints.

    Missing values are returned as None.  The caller decides whether they are
    required.
    """
    if not os.path.isfile(path):
        return {}
    text = open(path, encoding="utf-8").read()
    pairs = _table_pairs(text)

    # OAuth accounts: 本地凭据 has a "典型账号" row like
    # `<账号>` / `<密码>`、`<账号2>` / `<密码2>`.
    account = None
    password = None
    m = re.search(r"`(bp\d+)`\s*/\s*`(\d{4,})`", text)
    if m:
        account, password = m.group(1), m.group(2)

    return {
        "yide_client_id": _find(pairs, "client_id") or "yide-cloud",
        "yide_client_secret": _find(pairs, "client_secret"),
        "yide_username": account,
        "yide_password": password,
        "ttlock_client_id": _find(pairs, "Client ID"),
        "ttlock_client_secret": _find(pairs, "Client Secret"),
        "ttlock_username": _find(pairs, "厂商账号"),
        "ttlock_password": _find(pairs, "厂商密码（明文）", "厂商密码"),
        "mqtt_username": _find(pairs, "用户名"),
        "mqtt_password": _find(pairs, "生产密码"),
        "mqtt_uat_password": _find(pairs, "UAT 密码"),
        "book_url_key": _find(pairs, "URL_KEY"),
        "book_host": _find(pairs, "生产主机"),
        "tim_sdkappid": _find(pairs, "SDKAppID"),
        "tim_secret_key": _find(pairs, "SecretKey"),
    }


if __name__ == "__main__":
    import json

    print(json.dumps(load_permission(), ensure_ascii=False, indent=2))
