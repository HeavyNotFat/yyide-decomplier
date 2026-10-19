#!/usr/bin/env python3
"""发布前脱敏 / 本地恢复 / 泄漏检查。

设计目标：
  * 仓库里只保留占位符，真实值放在本地 _private/（已 gitignore）；
  * 备份是“可逆”的：scrub 后仍可用 restore 恢复源码、凭据和证书；
  * 不把真实值打印到终端，也不写入公开文件。

用法：
    python scripts/secrets.py status
    python scripts/secrets.py check
    python scripts/secrets.py scrub --dry-run
    python scripts/secrets.py scrub
    python scripts/secrets.py restore
"""

from __future__ import annotations

import argparse
import hashlib
import json
import os
import re
import shutil
import sys
from pathlib import Path
from typing import Dict, Iterable, List, Tuple

ROOT = Path(__file__).resolve().parents[1]
PRIVATE = ROOT / "_private"
BACKUP = PRIVATE / "backup"
VAULT = PRIVATE / "secrets.json"
EXTRA = PRIVATE / "extra-secrets.txt"
REPORT = PRIVATE / "scrub-report.json"

TEXT_SUFFIXES = {
    ".md", ".py", ".java", ".kt", ".xml", ".json", ".properties", ".gradle",
    ".ps1", ".bat", ".sh", ".txt", ".yml", ".yaml", ".pro", ".cfg", ".ini",
    ".html", ".js", ".css", ".csv",
}
SKIP_DIRS = {
    ".git", ".gradle", ".idea", "build", "dist", "libs", "vendor-src",
    "src/main/lib", "src/main/assets", "_private", "__pycache__", "node_modules",
}
SKIP_SUFFIXES = {
    ".apk", ".aab", ".dex", ".jar", ".so", ".png", ".jpg", ".jpeg", ".webp",
    ".gif", ".mp4", ".mp3", ".wav", ".ttf", ".otf", ".zip", ".7z", ".rar",
    ".class", ".pyc", ".bin",
}

# 整段替换：JWT、云 API Key、Firebase App ID、私钥块。
FULL_RULES: List[Tuple[str, re.Pattern]] = [
    ("JWT", re.compile(r"\beyJ[A-Za-z0-9_-]{8,}\.[A-Za-z0-9_-]{8,}\.[A-Za-z0-9_-]{8,}\b")),
    ("GOOGLE_API_KEY", re.compile(r"\bAIza[0-9A-Za-z_-]{30,}\b")),
    ("FIREBASE_APP_ID", re.compile(r"\b1:\d{6,}:android:[0-9a-f]{16,}\b")),
    ("PRIVATE_KEY", re.compile(
        r"-----BEGIN (?:RSA |EC |OPENSSH )?PRIVATE KEY-----.*?"
        r"-----END (?:RSA |EC |OPENSSH )?PRIVATE KEY-----",
        re.S,
    )),
]

# 键值替换：保留 key 和引号，只替换值。
KV_RULES: List[Tuple[str, re.Pattern]] = [
    ("CLIENT_SECRET", re.compile(r"(?i)(client_secret\s*[=:]\s*[\"']?)([A-Za-z0-9_\-\.]{6,})([\"']?)")),
    ("APP_SECRET", re.compile(r"(?i)((?:app_?secret|appsecret|secret_?key|secretkey)\s*[=:]\s*[\"']?)([A-Za-z0-9_\-\.]{6,})([\"']?)")),
    ("PASSWORD", re.compile(r"(?i)((?:password|passwd|pwd)\s*[=:]\s*[\"']?)([^\"'\s,}&]{6,})([\"']?)")),
    ("API_KEY", re.compile(r"(?i)((?:api_?key|app_?key|appkey|app_?id|appid|sdkappid|client_?id)\s*[=:]\s*[\"']?)([A-Za-z0-9_\-\.]{6,})([\"']?)")),
    ("DEVICE_MAC", re.compile(r"(?i)((?:mac|no|deviceno|wlanmac)\s*[=:]\s*[\"']?)([0-9a-f]{12})([\"']?)")),
    ("ANDROID_ID", re.compile(r"(?i)((?:seriano|android_?id)\s*[=:]\s*[\"']?)([0-9a-f]{16})([\"']?)")),
    ("MAC_LITERAL", re.compile(r"(?i)(return\s+[\"'])([0-9a-f]{12})([\"']\s*;)")),
    ("MAC_PUT", re.compile(r"(?i)([\"'](?:no|mac)[\"']\s*,\s*[\"'])([0-9a-f]{12})([\"'])")),
    ("ANDROID_ID_PUT", re.compile(r"(?i)([\"']seriaNo[\"']\s*,\s*[\"'])([0-9a-f]{16})([\"'])")),
    ("ACCOUNT", re.compile(r"(\b)(bp\d{5})(\b)")),
]

# Markdown 表格：如果整行包含敏感字段，替换该行反引号里的值。
TABLE_LINE = re.compile(r"(?i)client[_ ]?secret|app[_ ]?secret|secret|password|passwd|sdkappid|appid|app[_ ]?id|client[_ ]?id|api[_ ]?key|appkey|url_key|token|账号|密码")
TABLE_VALUE = re.compile(r"`([^`]{6,})`")

# 整个文件都属于敏感内容，scrub 时移到 _private/backup/。
SENSITIVE_GLOBS = [
    "PERMISSION.md",
    "mock-server/requests.log",
    "src/main/res/raw/server.key",
    "src/main/assets/**/*.cert",
    "*.jks",
    "*.keystore",
]

PLACEHOLDER_RE = re.compile(r"^__SEC_[A-Z0-9_]+_[0-9A-F]{8}__$")
SAFE_VALUES = {
    "123456", "admin", "password", "test", "example", "changeme", "release",
    "yide-cloud", "brand", "android", "null", "true", "false",
}


def is_text_file(path: Path) -> bool:
    return path.suffix.lower() in TEXT_SUFFIXES and path.suffix.lower() not in SKIP_SUFFIXES


def iter_text_files(include_vendor: bool = False) -> Iterable[Path]:
    skip = set(SKIP_DIRS)
    if include_vendor:
        skip.discard("vendor-src")
    for dirpath, dirnames, filenames in os.walk(ROOT):
        dirpath_p = Path(dirpath)
        rel_dir = dirpath_p.relative_to(ROOT).as_posix()
        dirnames[:] = [
            d for d in dirnames
            if d not in skip
            and f"{rel_dir}/{d}".lstrip("./") not in skip
        ]
        for name in filenames:
            path = Path(dirpath) / name
            if is_text_file(path):
                yield path


def rel(path: Path) -> str:
    return path.relative_to(ROOT).as_posix()


def mask(value: str) -> str:
    value = value.strip()
    if len(value) <= 6:
        return "***"
    return value[:3] + "…" + value[-2:]


def looks_safe(value: str) -> bool:
    value = value.strip()
    if not value or PLACEHOLDER_RE.match(value):
        return True
    if value.lower() in SAFE_VALUES:
        return True
    if value.startswith(("http://", "https://", "{", "<", "$", "%")):
        return True
    if value.endswith((".java", ".py", ".kt", ".xml", ".json", ".md")):
        return True
    if "/" in value or "\\" in value:
        return True
    if re.fullmatch(r"[\u4e00-\u9fff\s]+", value):
        return True
    return False


def looks_like_secret(value: str) -> bool:
    """避免把普通表格内容（client_id、grant_type、Authorization）误判为密钥。"""
    value = value.strip()
    if looks_safe(value):
        return False
    if len(value) < 6:
        return False
    if value.isdigit():
        return True
    if re.fullmatch(r"[0-9a-fA-F]{16,}", value):
        return True
    if re.fullmatch(r"[A-Za-z0-9_\-\.+/=]{6,}", value):
        has_alpha = bool(re.search(r"[A-Za-z]", value))
        has_digit = bool(re.search(r"\d", value))
        if has_alpha and has_digit:
            return True
        if len(value) >= 24 and re.search(r"[A-Z]", value) and re.search(r"[a-z]", value):
            return True
    return False


def placeholder_for(category: str, value: str, vault: Dict[str, str]) -> str:
    digest = hashlib.sha1(value.encode("utf-8")).hexdigest()[:8].upper()
    placeholder = f"__SEC_{category}_{digest}__"
    vault[placeholder] = value
    return placeholder


def backup(path: Path) -> None:
    target = BACKUP / rel(path)
    if target.exists():
        return
    target.parent.mkdir(parents=True, exist_ok=True)
    shutil.copy2(path, target)


def scrub_text(path: Path, vault: Dict[str, str], dry_run: bool, findings: List[Dict[str, str]]) -> bool:
    try:
        text = path.read_text("utf-8")
    except (UnicodeDecodeError, OSError):
        return False

    original = text
    for category, pattern in FULL_RULES:
        def repl(match: re.Match) -> str:
            value = match.group(0)
            if looks_safe(value):
                return value
            findings.append({"file": rel(path), "kind": category, "masked": mask(value)})
            return placeholder_for(category, value, vault)
        text = pattern.sub(repl, text)

    always_secret = {"DEVICE_MAC", "ANDROID_ID", "MAC_LITERAL", "MAC_PUT", "ANDROID_ID_PUT", "ACCOUNT"}
    for category, pattern in KV_RULES:
        def repl_kv(match: re.Match) -> str:
            value = match.group(2)
            if category not in always_secret and not looks_like_secret(value):
                return match.group(0)
            if category in always_secret and looks_safe(value):
                return match.group(0)
            findings.append({"file": rel(path), "kind": category, "masked": mask(value)})
            return match.group(1) + placeholder_for(category, value, vault) + match.group(3)
        text = pattern.sub(repl_kv, text)

    # Markdown 表格里的反引号值
    lines = text.splitlines(keepends=True)
    changed_lines = []
    for line in lines:
        if "|" in line and TABLE_LINE.search(line):
            def repl_table(match: re.Match) -> str:
                value = match.group(1).strip()
                if not looks_like_secret(value):
                    return match.group(0)
                category = "TABLE_SECRET"
                findings.append({"file": rel(path), "kind": category, "masked": mask(value)})
                return "`" + placeholder_for(category, value, vault) + "`"
            line = TABLE_VALUE.sub(repl_table, line)
        changed_lines.append(line)
    text = "".join(changed_lines)

    # 已知真实值的全局兜底：处理没有被 key 上下文命中的遗留出现。
    for placeholder, value in sorted(vault.items(), key=lambda kv: len(kv[1]), reverse=True):
        if len(value) >= 6 and value in text:
            findings.append({"file": rel(path), "kind": "VAULT_LITERAL", "masked": mask(value)})
            text = text.replace(value, placeholder)

    # 用户追加的字面量（_private/extra-secrets.txt）
    if EXTRA.exists():
        literals = [
            line.strip() for line in EXTRA.read_text("utf-8").splitlines()
            if line.strip() and not line.startswith("#")
        ]
        for value in sorted(literals, key=len, reverse=True):
            if len(value) >= 6 and value in text:
                findings.append({"file": rel(path), "kind": "EXTRA_LITERAL", "masked": mask(value)})
                text = text.replace(value, placeholder_for("EXTRA", value, vault))

    if text == original:
        return False
    if not dry_run:
        backup(path)
        path.write_text(text, "utf-8")
    return True


def scrub_known_values(path: Path, vault: Dict[str, str], dry_run: bool) -> bool:
    """只替换 vault 中已知真实值；用于 vendor-src 这类大目录。"""
    try:
        text = path.read_text("utf-8")
    except (UnicodeDecodeError, OSError):
        return False
    original = text
    for placeholder, value in sorted(vault.items(), key=lambda kv: len(kv[1]), reverse=True):
        if len(value) >= 6 and value in text:
            text = text.replace(value, placeholder)
    if text == original:
        return False
    if not dry_run:
        backup(path)
        path.write_text(text, "utf-8")
    return True


def move_sensitive(dry_run: bool) -> List[str]:
    moved: List[str] = []
    for pattern in SENSITIVE_GLOBS:
        for path in ROOT.glob(pattern):
            if not path.is_file():
                continue
            moved.append(rel(path))
            if not dry_run:
                backup(path)
                path.unlink()
    return moved


def load_vault() -> Dict[str, str]:
    if not VAULT.exists():
        return {}
    try:
        data = json.loads(VAULT.read_text("utf-8"))
        return {str(k): str(v) for k, v in data.get("values", {}).items()}
    except Exception:
        return {}


def save_vault(vault: Dict[str, str]) -> None:
    PRIVATE.mkdir(parents=True, exist_ok=True)
    VAULT.write_text(
        json.dumps({"version": 1, "values": vault}, ensure_ascii=False, indent=2),
        "utf-8",
    )


def cmd_status(_: argparse.Namespace) -> int:
    vault = load_vault()
    backups = list(BACKUP.rglob("*")) if BACKUP.exists() else []
    print(f"root     : {ROOT}")
    print(f"private  : {PRIVATE} ({'exists' if PRIVATE.exists() else 'missing'})")
    print(f"vault    : {len(vault)} placeholder(s)")
    print(f"backup   : {len([p for p in backups if p.is_file()])} file(s)")
    print(f"extra    : {EXTRA} ({'exists' if EXTRA.exists() else 'missing'})")
    return 0


def cmd_scrub(args: argparse.Namespace) -> int:
    PRIVATE.mkdir(parents=True, exist_ok=True)
    vault = load_vault()
    findings: List[Dict[str, str]] = []

    moved = move_sensitive(args.dry_run)
    changed_files = set()
    # 两轮：第一轮发现并替换，第二轮用已收集的 vault 做全局兜底。
    for _pass in range(1 if args.dry_run else 2):
        for path in iter_text_files():
            if args.dry_run:
                scratch: Dict[str, str] = {}
                before = len(findings)
                scrub_text(path, scratch, True, findings)
                if len(findings) > before:
                    changed_files.add(rel(path))
                vault.update(scratch)
            else:
                if scrub_text(path, vault, False, findings):
                    changed_files.add(rel(path))

    # vendor-src 很大，只做“已知真实值”兜底，不做通用正则。
    if not args.dry_run:
        for path in iter_text_files(include_vendor=True):
            if not rel(path).startswith("vendor-src/"):
                continue
            if scrub_known_values(path, vault, False):
                changed_files.add(rel(path))

    changed = len(changed_files)

    if not args.dry_run:
        save_vault(vault)
        REPORT.write_text(
            json.dumps({"moved": moved, "changes": findings}, ensure_ascii=False, indent=2),
            "utf-8",
        )

    print(f"mode    : {'dry-run' if args.dry_run else 'scrub'}")
    print(f"moved   : {len(moved)} sensitive file(s)")
    for item in moved:
        print(f"  - {item}")
    print(f"changed : {changed} text file(s)")
    print(f"findings: {len(findings)} secret occurrence(s)")
    for item in findings[:30]:
        print(f"  - {item['file']}  [{item['kind']}]  {item['masked']}")
    if len(findings) > 30:
        print(f"  ... {len(findings) - 30} more (see report)")
    if args.dry_run:
        print("dry-run: nothing written. Re-run without --dry-run to apply.")
    else:
        print(f"vault   : {VAULT}")
        print(f"report  : {REPORT}")
        print("next    : python scripts/secrets.py check")
    return 0


def cmd_restore(_: argparse.Namespace) -> int:
    vault = load_vault()
    if not vault and not BACKUP.exists():
        print("nothing to restore: _private/secrets.json and _private/backup are missing")
        return 1

    # 1) 把文本里的占位符换回真实值
    replaced = 0
    reverse = sorted(vault.items(), key=lambda kv: len(kv[0]), reverse=True)
    for path in iter_text_files(include_vendor=True):
        try:
            text = path.read_text("utf-8")
        except (UnicodeDecodeError, OSError):
            continue
        original = text
        for placeholder, value in reverse:
            if placeholder in text:
                text = text.replace(placeholder, value)
        if text != original:
            path.write_text(text, "utf-8")
            replaced += 1

    # 2) 把整体移走的敏感文件搬回来
    restored = 0
    if BACKUP.exists():
        for src in BACKUP.rglob("*"):
            if not src.is_file():
                continue
            dst = ROOT / src.relative_to(BACKUP)
            dst.parent.mkdir(parents=True, exist_ok=True)
            shutil.copy2(src, dst)
            restored += 1

    print(f"restored: {replaced} text file(s), {restored} private file(s)")
    return 0


def cmd_check(_: argparse.Namespace) -> int:
    findings: List[Dict[str, str]] = []
    vault = load_vault()

    for path in iter_text_files():
        try:
            text = path.read_text("utf-8")
        except (UnicodeDecodeError, OSError):
            continue
        for category, pattern in FULL_RULES:
            for match in pattern.finditer(text):
                value = match.group(0)
                if not looks_safe(value) and not PLACEHOLDER_RE.match(value):
                    findings.append({"file": rel(path), "kind": category, "masked": mask(value)})
        for category, pattern in KV_RULES:
            for match in pattern.finditer(text):
                value = match.group(2)
                if not looks_like_secret(value) and category not in {"ACCOUNT"}:
                    continue
                if not looks_safe(value) and not PLACEHOLDER_RE.match(value):
                    findings.append({"file": rel(path), "kind": category, "masked": mask(value)})
        for value in vault.values():
            if len(value) >= 8 and value in text:
                findings.append({"file": rel(path), "kind": "KNOWN_SECRET", "masked": mask(value)})

    # vendor-src 不在通用正则扫描范围；单独检查已知真实值。
    for path in iter_text_files(include_vendor=True):
        if not rel(path).startswith("vendor-src/"):
            continue
        try:
            text = path.read_text("utf-8")
        except (UnicodeDecodeError, OSError):
            continue
        for value in vault.values():
            if len(value) >= 8 and value in text:
                findings.append({"file": rel(path), "kind": "KNOWN_SECRET", "masked": mask(value)})

    present = [p for pattern in SENSITIVE_GLOBS for p in ROOT.glob(pattern) if p.is_file()]
    for path in present:
        findings.append({"file": rel(path), "kind": "SENSITIVE_FILE", "masked": "***"})

    if not findings:
        print("check: clean (no known secrets or sensitive files found)")
        return 0

    print(f"check: {len(findings)} finding(s)")
    shown = set()
    for item in findings:
        key = (item["file"], item["kind"], item["masked"])
        if key in shown:
            continue
        shown.add(key)
        print(f"  - {item['file']}  [{item['kind']}]  {item['masked']}")
    print("run: python scripts/secrets.py scrub --dry-run")
    return 1


def main() -> int:
    parser = argparse.ArgumentParser(description="发布前脱敏 / 恢复 / 泄漏检查")
    sub = parser.add_subparsers(dest="command", required=True)

    sub.add_parser("status", help="查看 vault / backup 状态").set_defaults(func=cmd_status)
    sub.add_parser("check", help="扫描已知泄漏，命中时退出码 1").set_defaults(func=cmd_check)
    sub.add_parser("restore", help="用 _private 恢复真实值和敏感文件").set_defaults(func=cmd_restore)

    scrub = sub.add_parser("scrub", help="脱敏并备份到 _private")
    scrub.add_argument("--dry-run", action="store_true", help="只预览，不写入")
    scrub.set_defaults(func=cmd_scrub)

    args = parser.parse_args()
    return args.func(args)


if __name__ == "__main__":
    raise SystemExit(main())
