#!/usr/bin/env python3
"""Repack an APK replacing selected entries (used by build-cloud-apk.ps1)."""
from __future__ import annotations

import sys
import zipfile
from pathlib import Path


def is_signature(name: str) -> bool:
    upper = name.upper()
    return upper == "META-INF/MANIFEST.MF" or (
        upper.startswith("META-INF/") and upper.endswith((".SF", ".RSA", ".DSA"))
    )


def main() -> int:
    if len(sys.argv) < 4:
        print("usage: repack_cloud.py <base.apk> <out.apk> <entry=file> [...]")
        return 2
    base, out = Path(sys.argv[1]), Path(sys.argv[2])
    replacements = {}
    for item in sys.argv[3:]:
        name, _, path = item.partition("=")
        replacements[name] = Path(path)
    with zipfile.ZipFile(base) as source, zipfile.ZipFile(out, "w", zipfile.ZIP_DEFLATED, compresslevel=6) as target:
        for info in source.infolist():
            if is_signature(info.filename):
                continue
            data = replacements[info.filename].read_bytes() if info.filename in replacements else source.read(info)
            target.writestr(info, data)
    print(f"wrote {out} ({out.stat().st_size} bytes, {len(replacements)} replaced)")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
