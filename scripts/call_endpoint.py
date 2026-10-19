"""最小 BrandClient 调用示例。

运行前设置环境变量（不要把真实值写进文件）：

    YIDE_USERNAME
    YIDE_PASSWORD
    YIDE_MAC
    YIDE_ANDROID_ID

然后：

    python scripts/call_endpoint.py
"""

import os
import sys

from endpoints import BrandClient


def require(name: str) -> str:
    value = os.environ.get(name, "").strip()
    if not value:
        sys.exit(f"缺少环境变量: {name}")
    return value


def main() -> None:
    client = BrandClient(
        require("YIDE_USERNAME"),
        require("YIDE_PASSWORD"),
        mac=require("YIDE_MAC"),
        android_id=require("YIDE_ANDROID_ID"),
        auto_obtain=True,
    )

    print("brand_id  :", client.context.get("brand_id"))
    print("classes_id:", client.context.get("classes_id"))

    layout = client.school_get_new_layout_list(id=client.context["brand_id"])
    for page in layout or []:
        for module in page.get("layoutClassSignDetailsEntityList", []):
            print(
                module.get("tag"),
                module.get("x"),
                module.get("y"),
                module.get("width"),
                module.get("height"),
            )


if __name__ == "__main__":
    main()
