#!/usr/bin/env python3
"""Run the real-environment endpoint table.

Default is a preview: it prints the real URL / headers / body that would be
sent, but does not open a network connection.  Add ``--execute --yes`` to send
requests to the production endpoints.

Examples:
    python -m scripts.endpoints.runner --list
    python -m scripts.endpoints.runner --group auth
    python -m scripts.endpoints.runner --group auth --execute --yes \
        --username <账号> --password <密码> --mac <real-board-mac>
    python -m scripts.endpoints.runner --id home-003 --execute --yes

Environment variables are documented in README.md.  Values from 本地凭据
are read automatically; command-line values win.
"""
from __future__ import annotations

import argparse
import json
import os
import sys
import time
from datetime import datetime
from typing import Dict, Iterable, List, Optional

from .apis import all_endpoints, all_groups
from .common import ApiClient, ApiError, Endpoint, RequestSpec
from .credentials import load_settings

HERE = os.path.dirname(os.path.abspath(__file__))


def _split(value: Optional[str]) -> List[str]:
    if not value:
        return []
    return [part.strip() for part in value.split(",") if part.strip()]


def _select(groups: List[str], ids: List[str], methods: List[str],
            limit: Optional[int]) -> List[Endpoint]:
    selected: List[Endpoint] = []
    for group_name, group in all_groups().items():
        if groups and group_name not in groups:
            continue
        for ep in group["endpoints"]:
            if ids and ep.id not in ids:
                continue
            if methods and ep.method.upper() not in methods:
                continue
            selected.append(ep)
    if limit is not None:
        selected = selected[:limit]
    return selected


def _redact_url_params(spec: RequestSpec) -> Dict[str, object]:
    return spec.redacted_params()


def _log_line(log_fh, record: Dict[str, object]) -> None:
    if log_fh is None:
        return
    log_fh.write(json.dumps(record, ensure_ascii=False) + "\n")
    log_fh.flush()


def main(argv: Optional[List[str]] = None) -> int:
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument("--group", help="分组，逗号分隔，例如 auth,device（默认全部）")
    parser.add_argument("--id", help="请求 ID，逗号分隔，例如 auth-001,home-003")
    parser.add_argument("--method", help="只跑指定方法，例如 GET")
    parser.add_argument("--limit", type=int, help="最多跑前 N 个")
    parser.add_argument("--list", action="store_true", help="列出分组和数量后退出")
    parser.add_argument("--execute", action="store_true", help="真正发送请求（默认只预览）")
    parser.add_argument("--resolve-token", action="store_true",
                        help="预览前用账号密码登录，把所有请求的 Authorization 填成真实 token")
    parser.add_argument("--forge", action="store_true",
                        help="登录后伪造全部/选中请求并写入 output/forged-requests.json（不发送）")
    parser.add_argument("--token", help="直接使用已有 accessToken（可配合 --forge/--resolve-token）")
    parser.add_argument("--yes", action="store_true", help="确认发送到真实环境（--execute 必填）")
    parser.add_argument("--dry-run", action="store_true", help="兼容参数：显式预览")
    parser.add_argument("--no-obtain", action="store_true", help="不调用 /brand/obtain")
    parser.add_argument("--no-discover-student", action="store_true", help="不自动查班级学生 ID")
    parser.add_argument("--stop-on-error", action="store_true", help="遇到第一个错误就退出")
    parser.add_argument("--show-curl", action="store_true", default=True,
                        help="预览时打印 curl（默认开启）")
    parser.add_argument("--quiet", action="store_true", help="只输出结果，不打印请求详情")
    parser.add_argument("--rate", type=float, default=0.5, help="每个真实请求之间的间隔秒数，默认 0.5")
    parser.add_argument("--timeout", type=float, help="HTTP 超时秒数")
    parser.add_argument("--output", help="运行日志 JSONL 路径（默认 output/run-<time>.jsonl）")
    parser.add_argument("--permission", help="本地凭据 路径")
    parser.add_argument("--base-url", help="覆盖 Yide base URL")
    parser.add_argument("--username", help="Yide 账号（覆盖 本地凭据 / 环境变量）")
    parser.add_argument("--password", help="Yide 密码（覆盖 本地凭据 / 环境变量）")
    parser.add_argument("--mac", help="真实班牌 MAC（12 位，去冒号）；auto=通过 adb 读取")
    parser.add_argument("--android-id", help="真实设备 Android ID；auto=通过 adb 读取")
    parser.add_argument("--adb-serial", help="adb 设备序列号（多设备时指定）")
    parser.add_argument("--school-id", help="真实 schoolId")
    parser.add_argument("--classes-id", help="真实 classesId")
    parser.add_argument("--student-id", help="真实 studentId")
    parser.add_argument("--brand-id", help="真实 brandId / 设备 ID")
    parser.add_argument("--site-id", help="真实 siteId")
    parser.add_argument("--file", help="上传文件路径（/app/file/upload 等）")
    parser.add_argument("--context", action="append", default=[],
                        help="额外真实上下文 key=value，可重复，例如 --context city=重庆 --context lock_id=123")
    args = parser.parse_args(argv)

    if args.list:
        groups = all_groups()
        total = 0
        for name, group in groups.items():
            print(f"{name:12s} {len(group['endpoints']):3d}  {group['title']}")
            total += len(group["endpoints"])
        print(f"{'total':12s} {total:3d}")
        return 0

    groups = _split(args.group)
    ids = _split(args.id)
    methods = [m.upper() for m in _split(args.method)]
    selected = _select(groups, ids, methods, args.limit)
    if not selected:
        print("没有匹配的请求", file=sys.stderr)
        return 2

    settings = load_settings(args.permission)
    if args.base_url:
        settings.yide_base_url = args.base_url.rstrip("/")
    if args.timeout:
        settings.timeout = args.timeout
    if args.username:
        settings.yide_username = args.username
    if args.password:
        settings.yide_password = args.password
    if args.mac:
        settings.yide_mac = args.mac
    if args.android_id:
        settings.yide_android_id = args.android_id
    if args.mac == "auto" or args.android_id == "auto":
        from .device_info import get_android_id, get_mac

        try:
            if args.mac == "auto":
                settings.yide_mac = get_mac(serial=args.adb_serial)
                print(f"[device] mac={settings.yide_mac}")
            if args.android_id == "auto":
                settings.yide_android_id = get_android_id(serial=args.adb_serial)
                print(f"[device] android_id={settings.yide_android_id}")
        except Exception as exc:
            print(f"[device] adb 读取失败: {exc}", file=sys.stderr)
            return 3
    if args.school_id:
        settings.yide_school_id = args.school_id

    context: Dict[str, object] = {}
    for flag, key in [
        (args.school_id, "school_id"), (args.classes_id, "classes_id"),
        (args.student_id, "student_id"), (args.brand_id, "brand_id"),
        (args.site_id, "site_id"), (args.file, "file"),
    ]:
        if flag:
            context[key] = flag
    for item in args.context:
        if "=" not in item:
            parser.error(f"--context 需要 key=value: {item}")
        key, value = item.split("=", 1)
        context[key.strip()] = value.strip()

    client = ApiClient(settings, context)
    if args.token:
        client.set_token(args.token)
    # Make sure context has the command-line overrides that also live in
    # settings (as_context() already includes most of them, but be explicit).
    client.context.update(context)
    if settings.yide_mac:
        client.context["mac"] = settings.yide_mac
    if settings.yide_android_id:
        client.context["android_id"] = settings.yide_android_id

    execute = bool(args.execute and not args.dry_run)
    if execute and not args.yes:
        print("拒绝执行：--execute 会向真实生产环境发送请求，请同时加 --yes", file=sys.stderr)
        return 2

    if args.forge:
        try:
            if not client.token and any(ep.client == "yide" for ep in selected):
                client.login_yide()
            if args.mac and not args.no_obtain:
                client.obtain()
            if any(ep.client == "ttlock" for ep in selected) and not client.context.get("ttlock_access_token"):
                client.login_ttlock()
        except Exception as exc:
            print(f"[forge] 登录/上下文失败: {exc}", file=sys.stderr)
            return 3
        forged = []
        for ep in selected:
            spec = client.prepare(ep)
            forged.append({
                "id": ep.id,
                "method": ep.method,
                "url": spec.url,
                "params": spec.params,
                "json": spec.json_body,
                "form": spec.form_body,
                "files": spec.files,
                "headers": spec.headers,
                "unresolved": spec.unresolved,
                "source": ep.source,
                "description": ep.description,
            })
        os.makedirs(os.path.join(HERE, "output"), exist_ok=True)
        forge_path = os.path.join(HERE, "output", "forged-requests.json")
        with open(forge_path, "w", encoding="utf-8") as fh:
            json.dump({
                "environment": "production",
                "count": len(forged),
                "requests": forged,
            }, fh, ensure_ascii=False, indent=2)
        print(f"forged {len(forged)} requests -> {forge_path}")
        print("WARNING: forged headers contain the real Authorization token; do not publish")
        return 0

    if args.resolve_token and not execute:
        try:
            client.login_yide()
            print(f"[auth] preview token resolved for {settings.yide_username}")
        except Exception as exc:
            print(f"[auth] 预览登录失败: {exc}", file=sys.stderr)
            return 3

    if execute:
        need_yide = any(ep.client in ("yide",) for ep in selected)
        need_ttlock = any(ep.client == "ttlock" for ep in selected)
        if need_yide:
            try:
                client.login_yide()
                print(f"[auth] Yide 登录成功: {settings.yide_username}")
            except Exception as exc:
                print(f"[auth] Yide 登录失败: {exc}", file=sys.stderr)
                return 3
            needs_context = any(
                ep.path not in ("/auth/oauth/token", "/auth/qrcode/gene", "/auth/qrcode/check")
                for ep in selected
            )
            if needs_context and not args.no_obtain:
                if not settings.yide_mac:
                    print("缺少 --mac / YIDE_MAC，无法调用 /brand/obtain", file=sys.stderr)
                    return 3
                try:
                    client.obtain()
                    print("[auth] /brand/obtain 成功，已填充 brand/classes/site/school")
                except Exception as exc:
                    print(f"[auth] /brand/obtain 失败: {exc}", file=sys.stderr)
                    return 3
                if not args.no_discover_student and not args.student_id:
                    sid = client.discover_student()
                    if sid:
                        print(f"[auth] 自动发现 studentId={sid}")
        if need_ttlock:
            try:
                client.login_ttlock()
                print("[auth] TTLock 登录成功")
            except Exception as exc:
                print(f"[auth] TTLock 登录失败: {exc}", file=sys.stderr)
                return 3

    out_path = args.output
    log_fh = None
    if execute:
        if not out_path:
            os.makedirs(os.path.join(HERE, "output"), exist_ok=True)
            out_path = os.path.join(HERE, "output", f"run-{datetime.now():%Y%m%d-%H%M%S}.jsonl")
        os.makedirs(os.path.dirname(os.path.abspath(out_path)), exist_ok=True)
        log_fh = open(out_path, "a", encoding="utf-8")

    print(f"mode={'execute' if execute else 'preview'} requests={len(selected)} groups={groups or ['all']}")
    errors = 0
    for index, endpoint in enumerate(selected, 1):
        spec = client.prepare(endpoint)
        label = f"[{index:03d}/{len(selected):03d}] {endpoint.id} {endpoint.method} {endpoint.path}"
        if not endpoint.executable:
            print(f"{label}  SKIP（模板，需要额外签名/参数）")
            continue
        if not execute:
            if not args.quiet:
                print("\n" + label)
                print(f"  URL    {spec.url}")
                print(f"  Query  {json.dumps(spec.redacted_params(), ensure_ascii=False)}")
                if spec.redacted_json_body() is not None:
                    print(f"  JSON   {json.dumps(spec.redacted_json_body(), ensure_ascii=False)}")
                if spec.redacted_form_body() is not None:
                    print(f"  Form   {json.dumps(spec.redacted_form_body(), ensure_ascii=False)}")
                if spec.files:
                    print(f"  Files  {json.dumps(spec.files, ensure_ascii=False)}")
                auth_header = spec.headers.get("Authorization")
                if not auth_header and endpoint.auth:
                    auth_header = "Bearer <token after login>"
                print(f"  Auth   {auth_header or 'none'}")
                display_unresolved = [x for x in spec.unresolved if x not in ("token", "access_token")]
                if display_unresolved:
                    print(f"  unresolved: {', '.join(display_unresolved)}")
                if args.show_curl:
                    print(f"  curl   {spec.curl()}")
            continue

        if spec.unresolved:
            print(f"{label}  SKIP unresolved: {', '.join(spec.unresolved)}")
            _log_line(log_fh, {"ts": datetime.now().isoformat(timespec="seconds"),
                               "id": endpoint.id, "method": endpoint.method,
                               "url": spec.url, "unresolved": spec.unresolved})
            errors += 1
            if args.stop_on_error:
                break
            continue

        started = time.time()
        try:
            response = client.execute(spec)
            elapsed = time.time() - started
            if spec.stream:
                print(f"{label}  HTTP {response.status_code}  stream")
                for n, line in enumerate(response.iter_lines(decode_unicode=True)):
                    if line:
                        print(f"    {line[:300]}")
                    if n >= 20:
                        break
                response.close()
            else:
                text = response.text
                print(f"{label}  HTTP {response.status_code}  {elapsed:.2f}s  {text[:300]}")
            _log_line(log_fh, {
                "ts": datetime.now().isoformat(timespec="seconds"),
                "id": endpoint.id, "method": endpoint.method, "url": spec.url,
                "params": spec.redacted_params(),
                "json": spec.redacted_json_body(),
                "form": spec.redacted_form_body(),
                "status": response.status_code,
                "elapsed": round(elapsed, 3),
                "body": response.text[:1000] if not spec.stream else "<stream>",
            })
        except Exception as exc:
            elapsed = time.time() - started
            print(f"{label}  ERROR {exc}", file=sys.stderr)
            _log_line(log_fh, {
                "ts": datetime.now().isoformat(timespec="seconds"),
                "id": endpoint.id, "method": endpoint.method, "url": spec.url,
                "error": str(exc), "elapsed": round(elapsed, 3),
            })
            errors += 1
            if args.stop_on_error:
                break
        time.sleep(max(0.0, args.rate))

    if log_fh is not None:
        log_fh.close()
        print(f"\nlog: {out_path}")
    print(f"errors: {errors}")
    return 0 if errors == 0 else 1


if __name__ == "__main__":
    raise SystemExit(main())
