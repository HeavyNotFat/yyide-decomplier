#!/usr/bin/env python3
"""Build the complete real-environment request table.

Outputs:
    output/requests.csv    （Excel 可直接打开，UTF-8 BOM）
    output/requests.json
    output/requests.md

The table contains placeholders such as {mac}, {classes_id}; it never prints
the real secret values from 本地凭据.
"""
from __future__ import annotations

import argparse
import csv
import json
import os
import re
from typing import Any, Dict, List

from .apis import all_groups
from .common import ApiClient, Endpoint, join_url
from .credentials import (
    BOOK_BASE_URL,
    TTLOCK_BASE_URL,
    WEATHER_BASE_URL,
    YIDE_BASE_URL,
    load_settings,
)

HERE = os.path.dirname(os.path.abspath(__file__))
DEFAULT_OUT = os.path.join(HERE, "output")

FIELDS = [
    "group", "group_title", "id", "method", "base_url", "path", "url",
    "query", "json_body", "form_body", "files", "auth", "auth_header",
    "content_type", "user_agent", "executable", "source", "description",
]


def _json(value: Any) -> str:
    if value is None:
        return ""
    return json.dumps(value, ensure_ascii=False, separators=(",", ":"))


def _base_for(endpoint: Endpoint) -> str:
    if endpoint.base:
        return endpoint.base
    if endpoint.client == "ttlock":
        return TTLOCK_BASE_URL
    if endpoint.client == "book":
        return BOOK_BASE_URL
    if endpoint.client == "weather":
        return WEATHER_BASE_URL
    if endpoint.client == "external":
        return ""
    return YIDE_BASE_URL


PATH_ALIASES = {
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


def _display_path(path: str) -> str:
    def repl(match: re.Match[str]) -> str:
        name = match.group(1)
        return "{" + PATH_ALIASES.get(name, name) + "}"

    return re.sub(r"\{([a-zA-Z_][\w]*)\}", repl, path)


def _row(group: str, title: str, ep: Endpoint, user_agent: str = "", access_token: str = "") -> Dict[str, str]:
    base = _base_for(ep)
    path_keys = set(re.findall(r"\{([a-zA-Z_][\w]*)\}", ep.path))
    query = {key: value for key, value in ep.params.items() if key not in path_keys}
    display_path = _display_path(ep.path)
    if ep.files:
        content_type = "multipart/form-data"
    elif ep.form_body is not None:
        content_type = "application/x-www-form-urlencoded"
    elif ep.json_body is not None:
        content_type = "application/json"
    else:
        content_type = ""
    return {
        "group": group,
        "group_title": title,
        "id": ep.id,
        "method": ep.method,
        "base_url": base,
        "path": display_path,
        "url": join_url(base, display_path) if base else display_path,
        "query": _json(query) if query else "",
        "json_body": _json(ep.json_body),
        "form_body": _json(ep.form_body),
        "files": _json(ep.files),
        "auth": "yes" if ep.auth else "no",
        "auth_header": (f"Bearer {access_token}" if access_token else "Bearer {access_token}") if ep.auth else "",
        "content_type": content_type,
        "user_agent": user_agent,
        "executable": "yes" if ep.executable else "no",
        "source": ep.source,
        "description": ep.description,
    }


def _md_escape(value: str) -> str:
    return str(value).replace("|", "\\|").replace("\n", " ")


def _markdown(groups: Dict[str, dict], access_token: str = "") -> str:
    lines = [
        "# 智慧班牌完整请求表（真实环境）",
        "",
        "> 由 `scripts/endpoints/build_request_table.py` 生成。",
        "> 所有 host 均为真实生产/厂商地址；`{...}` 是需要在运行时提供的真实上下文（MAC、班级 ID、锁 ID 等）。",
        "> 凭据由 `credentials.py` 从环境变量/本地凭据读取，本表不打印任何密钥。",
        "",
        "**统一 User-Agent：**",
        "",
        "```text",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/154.0.0.0 Safari/537.36 Edg/154.0.0.0",
        "```",
        "",
        "**鉴权头：** `Authorization: Bearer {access_token}`（TTLock 用 form 中的 `accessToken`，不走 Bearer）。" if not access_token else "**鉴权头：** 已注入真实登录 token（不要外传本表）。",
        "> `{access_token}` 是运行时变量：用 `build_request_table --resolve`、`runner --resolve-token`、`runner --forge` 或 `BrandClient` 注入真实 token。" if not access_token else "",
        "",
        f"- 分组数：{len(groups)}",
        f"- 请求数：{sum(len(g['endpoints']) for g in groups.values())}",
        "",
        "## 分组索引",
        "",
        "| 分组 | 名称 | 请求数 |",
        "| --- | --- | ---: |",
    ]
    for name, group in groups.items():
        lines.append(f"| `{name}` | {group['title']} | {len(group['endpoints'])} |")
    lines.append("")
    for name, group in groups.items():
        lines += [f"## {group['title']}（`{name}`，{len(group['endpoints'])} 个）", ""]
        lines += [
            "| ID | 方法 | 真实 URL | Query | JSON Body | Form | Auth Header | Content-Type | 可执行 | 说明 |",
            "| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |",
        ]
        for ep in group["endpoints"]:
            row = _row(name, group["title"], ep, access_token=access_token)
            lines.append(
                "| {id} | {method} | `{url}` | {query} | {json_body} | {form_body} | "
                "{auth_header} | {content_type} | {executable} | {description} |".format(
                    id=row["id"],
                    method=row["method"],
                    url=_md_escape(row["url"]),
                    query=_md_escape(row["query"]) or "—",
                    json_body=_md_escape(row["json_body"]) or "—",
                    form_body=_md_escape(row["form_body"]) or "—",
                    auth_header=row["auth_header"] or "—",
                    content_type=row["content_type"] or "—",
                    executable=row["executable"],
                    description=_md_escape(row["description"]),
                )
            )
        lines.append("")
    return "\n".join(lines) + "\n"


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--out-dir", default=DEFAULT_OUT)
    parser.add_argument("--split", action="store_true", help="同时按分组输出独立的 CSV/Markdown")
    parser.add_argument("--resolve", action="store_true",
                        help="用账号密码真实登录，生成带真实 Authorization 的 requests.resolved.*")
    parser.add_argument("--token", help="直接传入 accessToken（不带 Bearer 也可以）")
    args = parser.parse_args()
    os.makedirs(args.out_dir, exist_ok=True)

    settings = load_settings()
    access_token = ""
    if args.token:
        access_token = args.token.strip()
    elif args.resolve:
        client = ApiClient(settings)
        client.login_yide()
        access_token = client.token
    if access_token.lower().startswith("bearer "):
        access_token = access_token[7:]
    prefix = "requests.resolved" if access_token else "requests"

    groups = all_groups()
    rows: List[Dict[str, str]] = []
    for name, group in groups.items():
        for ep in group["endpoints"]:
            rows.append(_row(name, group["title"], ep, settings.user_agent, access_token))

    csv_path = os.path.join(args.out_dir, f"{prefix}.csv")
    with open(csv_path, "w", encoding="utf-8-sig", newline="") as fh:
        writer = csv.DictWriter(fh, fieldnames=FIELDS)
        writer.writeheader()
        writer.writerows(rows)

    json_path = os.path.join(args.out_dir, f"{prefix}.json")
    with open(json_path, "w", encoding="utf-8") as fh:
        json.dump({
            "environment": "production",
            "user_agent": settings.user_agent,
            "authorization_template": "Bearer {access_token}",
            "authorization_resolved": bool(access_token),
            "ttlock_form_template": "clientId/accessToken/date in form body",
            "base_urls": {
                "yide": settings.yide_base_url,
                "ttlock": settings.ttlock_base_url,
                "book": settings.book_base_url,
                "weather": settings.weather_base_url,
            },
            "groups": {
                name: {"title": group["title"], "count": len(group["endpoints"])}
                for name, group in groups.items()
            },
            "requests": rows,
        }, fh, ensure_ascii=False, indent=2)

    md_path = os.path.join(args.out_dir, f"{prefix}.md")
    with open(md_path, "w", encoding="utf-8") as fh:
        fh.write(_markdown(groups, access_token))

    if args.split:
        split_dir = os.path.join(args.out_dir, "groups-resolved" if access_token else "groups")
        os.makedirs(split_dir, exist_ok=True)
        for name, group in groups.items():
            group_rows = [_row(name, group["title"], ep, settings.user_agent, access_token)
                          for ep in group["endpoints"]]
            with open(os.path.join(split_dir, f"{name}.csv"), "w",
                      encoding="utf-8-sig", newline="") as fh:
                writer = csv.DictWriter(fh, fieldnames=FIELDS)
                writer.writeheader()
                writer.writerows(group_rows)
            with open(os.path.join(split_dir, f"{name}.md"), "w", encoding="utf-8") as fh:
                fh.write(_markdown({name: group}, access_token))

    if access_token:
        print("WARNING: resolved table contains a real access token; do not publish it")
    print(f"groups: {len(groups)}")
    print(f"requests: {len(rows)}")
    print(csv_path)
    print(json_path)
    print(md_path)


if __name__ == "__main__":
    main()
