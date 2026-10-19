"""Real-environment endpoint runner for 智慧班牌.

See README.md in this directory.
"""
from __future__ import annotations

from .client import BrandClient

__all__ = ["BrandClient", "common", "credentials", "permission_loader", "runner"]
