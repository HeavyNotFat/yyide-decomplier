#!/usr/bin/env python3
"""Replace URL literals inside a baksmali output tree."""
from __future__ import annotations

import sys
from pathlib import Path


def main() -> int:
    if len(sys.argv) < 4:
        print("usage: patch_smali_urls.py <smali-dir> <old-url> <new-url> [...]")
        return 2
    root = Path(sys.argv[1])
    pairs = [(sys.argv[i], sys.argv[i + 1]) for i in range(2, len(sys.argv) - 1, 2)]
    changed = 0
    for path in root.rglob("*.smali"):
        text = path.read_text(encoding="utf-8", errors="surrogateescape")
        original = text
        for old, new in pairs:
            text = text.replace(old, new)
        if text != original:
            path.write_text(text, encoding="utf-8", errors="surrogateescape")
            changed += 1
    print(f"patched {changed} smali files")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
