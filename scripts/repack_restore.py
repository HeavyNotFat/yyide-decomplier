#!/usr/bin/env python3
"""Repackage the original 班牌 APK with a patched first dex.

The Android class loader resolves classes from classes.dex first, then
classes2.dex, classes3.dex...  We put the small patch dex (BaseApplication +
LoginPresenter) in classes.dex and shift every original dex up by one.  The
patched classes therefore shadow the originals while every other original
class, resource and native library stays untouched.
"""

from __future__ import annotations

import hashlib
import os
import sys
import zipfile

SIGNATURE_NAMES = {
    "META-INF/MANIFEST.MF",
    "META-INF/CERT.SF",
    "META-INF/CERT.RSA",
    "META-INF/CERT.DSA",
}


def is_signature(name: str) -> bool:
    upper = name.upper()
    return upper in SIGNATURE_NAMES or (
        upper.startswith("META-INF/") and upper.endswith((".SF", ".RSA", ".DSA"))
    )


def shifted_dex_name(name: str) -> str:
    assert name.startswith("classes") and name.endswith(".dex")
    base = name[: -len(".dex")]
    number = 1 if base == "classes" else int(base[len("classes") :])
    return f"classes{number + 1}.dex"


def main() -> int:
    if len(sys.argv) != 4:
        print("usage: repack_restore.py <base.apk> <patch-classes.dex> <out.apk>")
        return 2
    base_apk, patch_dex, out_apk = (os.path.abspath(p) for p in sys.argv[1:])
    if not os.path.isfile(base_apk):
        print("base APK not found:", base_apk)
        return 1
    if not os.path.isfile(patch_dex):
        print("patch dex not found:", patch_dex)
        return 1

    dex_count = 0
    with zipfile.ZipFile(base_apk) as source, zipfile.ZipFile(
        out_apk, "w", zipfile.ZIP_DEFLATED, compresslevel=6
    ) as target:
        # Patched classes must be in the first dex.
        target.write(patch_dex, "classes.dex")
        for info in source.infolist():
            name = info.filename
            if is_signature(name):
                continue
            if name.startswith("classes") and name.endswith(".dex"):
                name = shifted_dex_name(name)
                dex_count += 1
            target.writestr(name, source.read(info))

    digest = hashlib.sha256(open(out_apk, "rb").read()).hexdigest()
    print(f"wrote {out_apk} ({os.path.getsize(out_apk)} bytes, {dex_count + 1} dex)")
    print("sha256:", digest)
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
