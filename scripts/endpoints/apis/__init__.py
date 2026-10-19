"""All endpoint groups.  One module per business area (分文件)."""
from __future__ import annotations

from typing import Dict, List, Type

from ..common import Endpoint
from . import (
    activity, ai, attendance, auth, card, device, dormitory, exam, external,
    face, home, honor, iot, library, messages, patrol, reservation, school,
    timetable, ttlock, upload, userspace, vote,
)

MODULES = [
    auth, device, school, home, messages, timetable, attendance, card,
    userspace, activity, honor, exam, library, reservation, patrol, vote,
    dormitory, ai, upload, iot, ttlock, face, external,
]


def all_groups() -> Dict[str, dict]:
    return {m.GROUP: {"title": m.TITLE, "endpoints": m.ENDPOINTS} for m in MODULES}


def all_endpoints() -> List[Endpoint]:
    out: List[Endpoint] = []
    for module in MODULES:
        out.extend(module.ENDPOINTS)
    return out


def group_names() -> List[str]:
    return [m.GROUP for m in MODULES]
