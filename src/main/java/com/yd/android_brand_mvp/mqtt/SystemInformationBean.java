package com.yd.android_brand_mvp.mqtt;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemInformationBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003JO\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\r\"\u0004\b\u001d\u0010\u000f¨\u0006+"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/SystemInformationBean;", "", "cpu", "", "cpuName", "", "internalMemory", "memoryTotal", "runMemoryTotal", "runMemory", "appMemory", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppMemory", "()Ljava/lang/String;", "setAppMemory", "(Ljava/lang/String;)V", "getCpu", "()I", "setCpu", "(I)V", "getCpuName", "setCpuName", "getInternalMemory", "setInternalMemory", "getMemoryTotal", "setMemoryTotal", "getRunMemory", "setRunMemory", "getRunMemoryTotal", "setRunMemoryTotal", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SystemInformationBean {
    private String appMemory;
    private int cpu;
    private String cpuName;
    private String internalMemory;
    private String memoryTotal;
    private String runMemory;
    private String runMemoryTotal;

    public SystemInformationBean() {
        this(0, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ SystemInformationBean copy$default(SystemInformationBean systemInformationBean, int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = systemInformationBean.cpu;
        }
        if ((i2 & 2) != 0) {
            str = systemInformationBean.cpuName;
        }
        String str7 = str;
        if ((i2 & 4) != 0) {
            str2 = systemInformationBean.internalMemory;
        }
        String str8 = str2;
        if ((i2 & 8) != 0) {
            str3 = systemInformationBean.memoryTotal;
        }
        String str9 = str3;
        if ((i2 & 16) != 0) {
            str4 = systemInformationBean.runMemoryTotal;
        }
        String str10 = str4;
        if ((i2 & 32) != 0) {
            str5 = systemInformationBean.runMemory;
        }
        String str11 = str5;
        if ((i2 & 64) != 0) {
            str6 = systemInformationBean.appMemory;
        }
        return systemInformationBean.copy(i, str7, str8, str9, str10, str11, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCpu() {
        return this.cpu;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCpuName() {
        return this.cpuName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getInternalMemory() {
        return this.internalMemory;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMemoryTotal() {
        return this.memoryTotal;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRunMemoryTotal() {
        return this.runMemoryTotal;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRunMemory() {
        return this.runMemory;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getAppMemory() {
        return this.appMemory;
    }

    public final SystemInformationBean copy(int cpu, String cpuName, String internalMemory, String memoryTotal, String runMemoryTotal, String runMemory, String appMemory) {
        Intrinsics.checkNotNullParameter(cpuName, "cpuName");
        Intrinsics.checkNotNullParameter(internalMemory, "internalMemory");
        Intrinsics.checkNotNullParameter(memoryTotal, "memoryTotal");
        Intrinsics.checkNotNullParameter(runMemoryTotal, "runMemoryTotal");
        Intrinsics.checkNotNullParameter(runMemory, "runMemory");
        Intrinsics.checkNotNullParameter(appMemory, "appMemory");
        return new SystemInformationBean(cpu, cpuName, internalMemory, memoryTotal, runMemoryTotal, runMemory, appMemory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SystemInformationBean)) {
            return false;
        }
        SystemInformationBean systemInformationBean = (SystemInformationBean) other;
        return this.cpu == systemInformationBean.cpu && Intrinsics.areEqual(this.cpuName, systemInformationBean.cpuName) && Intrinsics.areEqual(this.internalMemory, systemInformationBean.internalMemory) && Intrinsics.areEqual(this.memoryTotal, systemInformationBean.memoryTotal) && Intrinsics.areEqual(this.runMemoryTotal, systemInformationBean.runMemoryTotal) && Intrinsics.areEqual(this.runMemory, systemInformationBean.runMemory) && Intrinsics.areEqual(this.appMemory, systemInformationBean.appMemory);
    }

    public int hashCode() {
        return (((((((((((this.cpu * 31) + this.cpuName.hashCode()) * 31) + this.internalMemory.hashCode()) * 31) + this.memoryTotal.hashCode()) * 31) + this.runMemoryTotal.hashCode()) * 31) + this.runMemory.hashCode()) * 31) + this.appMemory.hashCode();
    }

    public String toString() {
        return "SystemInformationBean(cpu=" + this.cpu + ", cpuName=" + this.cpuName + ", internalMemory=" + this.internalMemory + ", memoryTotal=" + this.memoryTotal + ", runMemoryTotal=" + this.runMemoryTotal + ", runMemory=" + this.runMemory + ", appMemory=" + this.appMemory + ')';
    }

    public SystemInformationBean(int i, String cpuName, String internalMemory, String memoryTotal, String runMemoryTotal, String runMemory, String appMemory) {
        Intrinsics.checkNotNullParameter(cpuName, "cpuName");
        Intrinsics.checkNotNullParameter(internalMemory, "internalMemory");
        Intrinsics.checkNotNullParameter(memoryTotal, "memoryTotal");
        Intrinsics.checkNotNullParameter(runMemoryTotal, "runMemoryTotal");
        Intrinsics.checkNotNullParameter(runMemory, "runMemory");
        Intrinsics.checkNotNullParameter(appMemory, "appMemory");
        this.cpu = i;
        this.cpuName = cpuName;
        this.internalMemory = internalMemory;
        this.memoryTotal = memoryTotal;
        this.runMemoryTotal = runMemoryTotal;
        this.runMemory = runMemory;
        this.appMemory = appMemory;
    }

    public /* synthetic */ SystemInformationBean(int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, (i2 & 64) == 0 ? str6 : "");
    }

    public final int getCpu() {
        return this.cpu;
    }

    public final void setCpu(int i) {
        this.cpu = i;
    }

    public final String getCpuName() {
        return this.cpuName;
    }

    public final void setCpuName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cpuName = str;
    }

    public final String getInternalMemory() {
        return this.internalMemory;
    }

    public final void setInternalMemory(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.internalMemory = str;
    }

    public final String getMemoryTotal() {
        return this.memoryTotal;
    }

    public final void setMemoryTotal(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.memoryTotal = str;
    }

    public final String getRunMemoryTotal() {
        return this.runMemoryTotal;
    }

    public final void setRunMemoryTotal(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.runMemoryTotal = str;
    }

    public final String getRunMemory() {
        return this.runMemory;
    }

    public final void setRunMemory(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.runMemory = str;
    }

    public final String getAppMemory() {
        return this.appMemory;
    }

    public final void setAppMemory(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.appMemory = str;
    }
}
