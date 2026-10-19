#!/usr/bin/env python3
"""Read Android ID / MAC / serial from a real device through adb.

Android ID is the value used by the app for ``/brand/obtain.seriaNo``:

    Settings.Secure.getString(contentResolver, "android_id")

The app calls AndroidUtilCode's ``DeviceUtils.getAndroidID()``, which is exactly
the call above (vendor-src/java/com/blankj/utilcode/util/DeviceUtils.java:44).

Usage:
    python -m scripts.endpoints.device_info
    python -m scripts.endpoints.device_info --serial <adb-serial>
    python -m scripts.endpoints.device_info --json
"""
from __future__ import annotations

import argparse
import json
import os
import re
import shutil
import subprocess
from typing import Optional


def find_adb() -> str:
    candidates = [
        os.environ.get("ADB"),
        os.path.join("D:\\Android SDK", "platform-tools", "adb.exe"),
        shutil.which("adb"),
        "adb",
    ]
    for candidate in candidates:
        if not candidate:
            continue
        if os.path.isfile(candidate) or shutil.which(candidate):
            return candidate
    return "adb"


def _run(adb: str, serial: Optional[str], *args: str) -> str:
    cmd = [adb]
    if serial:
        cmd += ["-s", serial]
    cmd += list(args)
    proc = subprocess.run(cmd, capture_output=True, text=True, encoding="utf-8", errors="replace")
    if proc.returncode != 0:
        raise RuntimeError(proc.stderr.strip() or f"adb failed: {' '.join(cmd)}")
    return proc.stdout.strip()


def list_devices(adb: Optional[str] = None) -> list[dict]:
    adb = adb or find_adb()
    out = _run(adb, None, "devices", "-l")
    devices = []
    for line in out.splitlines()[1:]:
        line = line.strip()
        if not line:
            continue
        parts = line.split()
        if len(parts) >= 2:
            devices.append({"serial": parts[0], "state": parts[1], "extra": " ".join(parts[2:])})
    return devices


def pick_serial(adb: Optional[str] = None, serial: Optional[str] = None) -> str:
    if serial:
        return serial
    devices = [d for d in list_devices(adb) if d["state"] == "device"]
    if len(devices) == 1:
        return devices[0]["serial"]
    if not devices:
        raise RuntimeError("没有在线的 adb 设备")
    raise RuntimeError("有多个 adb 设备，请用 --serial 指定: " + ", ".join(d["serial"] for d in devices))


def get_android_id(serial: Optional[str] = None, adb: Optional[str] = None) -> str:
    adb = adb or find_adb()
    serial = pick_serial(adb, serial)
    return _run(adb, serial, "shell", "settings", "get", "secure", "android_id").strip()


def get_mac(serial: Optional[str] = None, adb: Optional[str] = None) -> str:
    adb = adb or find_adb()
    serial = pick_serial(adb, serial)
    for command in (
        ("shell", "cat", "/sys/class/net/eth0/address"),
        ("shell", "cat", "/sys/class/net/wlan0/address"),
    ):
        try:
            value = _run(adb, serial, *command)
            m = re.search(r"([0-9a-fA-F]{2}(?::[0-9a-fA-F]{2}){5})", value)
            if m:
                return m.group(1).replace(":", "").lower()
        except Exception:
            continue
    # fallback: ip link
    try:
        value = _run(adb, serial, "shell", "ip", "link", "show", "eth0")
        m = re.search(r"link/ether\s+([0-9a-fA-F:]{17})", value)
        if m:
            return m.group(1).replace(":", "").lower()
    except Exception:
        pass
    return ""


def get_prop(serial: Optional[str], prop: str, adb: Optional[str] = None) -> str:
    adb = adb or find_adb()
    return _run(adb, pick_serial(adb, serial), "shell", "getprop", prop).strip()


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument("--serial", help="adb 设备序列号；只有一个设备时可省略")
    parser.add_argument("--json", action="store_true", help="输出 JSON")
    parser.add_argument("--list", action="store_true", help="只列出 adb 设备")
    args = parser.parse_args()

    adb = find_adb()
    if args.list:
        print(json.dumps({"adb": adb, "devices": list_devices(adb)}, ensure_ascii=False, indent=2))
        return 0

    try:
        serial = pick_serial(adb, args.serial)
        data = {
            "adb": adb,
            "serial": serial,
            "android_id": get_android_id(serial, adb),
            "mac": get_mac(serial, adb),
            "ro_serialno": get_prop(serial, "ro.serialno", adb),
            "ro_product_model": get_prop(serial, "ro.product.model", adb),
            "ro_build_version_release": get_prop(serial, "ro.build.version.release", adb),
        }
    except Exception as exc:
        print(f"ERROR: {exc}")
        return 1

    if args.json:
        print(json.dumps(data, ensure_ascii=False, indent=2))
    else:
        print(f"adb:        {data['adb']}")
        print(f"serial:     {data['serial']}")
        print(f"android_id: {data['android_id']}")
        print(f"mac:        {data['mac']}")
        print(f"ro.serialno:{data['ro_serialno']}")
        print(f"model:      {data['ro_product_model']}  Android {data['ro_build_version_release']}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
