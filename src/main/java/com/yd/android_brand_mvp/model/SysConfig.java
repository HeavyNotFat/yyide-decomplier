package com.yd.android_brand_mvp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/model/SysConfig;", "", "networkType", "", "deviceNo", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceNo", "()Ljava/lang/String;", "getNetworkType", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SysConfig {
    private final String deviceNo;
    private final String networkType;

    public static /* synthetic */ SysConfig copy$default(SysConfig sysConfig, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sysConfig.networkType;
        }
        if ((i & 2) != 0) {
            str2 = sysConfig.deviceNo;
        }
        return sysConfig.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNetworkType() {
        return this.networkType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceNo() {
        return this.deviceNo;
    }

    public final SysConfig copy(String networkType, String deviceNo) {
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        Intrinsics.checkNotNullParameter(deviceNo, "deviceNo");
        return new SysConfig(networkType, deviceNo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SysConfig)) {
            return false;
        }
        SysConfig sysConfig = (SysConfig) other;
        return Intrinsics.areEqual(this.networkType, sysConfig.networkType) && Intrinsics.areEqual(this.deviceNo, sysConfig.deviceNo);
    }

    public int hashCode() {
        return (this.networkType.hashCode() * 31) + this.deviceNo.hashCode();
    }

    public String toString() {
        return "SysConfig(networkType=" + this.networkType + ", deviceNo=" + this.deviceNo + ')';
    }

    public SysConfig(String networkType, String deviceNo) {
        Intrinsics.checkNotNullParameter(networkType, "networkType");
        Intrinsics.checkNotNullParameter(deviceNo, "deviceNo");
        this.networkType = networkType;
        this.deviceNo = deviceNo;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public final String getDeviceNo() {
        return this.deviceNo;
    }
}
