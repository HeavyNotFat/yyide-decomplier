package com.yd.android_brand_mvp.model.log;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b/\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010(J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0086\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0016\"\u0004\b$\u0010\u0018R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001e\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018¨\u0006@"}, d2 = {"Lcom/yd/android_brand_mvp/model/log/LogModel;", "", "device", "Lcom/yd/android_brand_mvp/model/log/Device;", "logContent", "Lcom/yd/android_brand_mvp/model/log/LogContent;", "logId", "", "schoolId", "schoolName", "time", "", "deviceNo", "deviceType", "logLevel", "traceId", "(Lcom/yd/android_brand_mvp/model/log/Device;Lcom/yd/android_brand_mvp/model/log/LogContent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDevice", "()Lcom/yd/android_brand_mvp/model/log/Device;", "setDevice", "(Lcom/yd/android_brand_mvp/model/log/Device;)V", "getDeviceNo", "()Ljava/lang/String;", "setDeviceNo", "(Ljava/lang/String;)V", "getDeviceType", "setDeviceType", "getLogContent", "()Lcom/yd/android_brand_mvp/model/log/LogContent;", "setLogContent", "(Lcom/yd/android_brand_mvp/model/log/LogContent;)V", "getLogId", "setLogId", "getLogLevel", "setLogLevel", "getSchoolId", "setSchoolId", "getSchoolName", "setSchoolName", "getTime", "()Ljava/lang/Long;", "setTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getTraceId", "setTraceId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/yd/android_brand_mvp/model/log/Device;Lcom/yd/android_brand_mvp/model/log/LogContent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/yd/android_brand_mvp/model/log/LogModel;", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LogModel {
    private Device device;
    private String deviceNo;
    private String deviceType;
    private LogContent logContent;
    private String logId;
    private String logLevel;
    private String schoolId;
    private String schoolName;
    private Long time;
    private String traceId;

    public LogModel() {
        this(null, null, null, null, null, null, null, null, null, null, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Device getDevice() {
        return this.device;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final LogContent getLogContent() {
        return this.logContent;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLogId() {
        return this.logId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSchoolName() {
        return this.schoolName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getTime() {
        return this.time;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getDeviceNo() {
        return this.deviceNo;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getLogLevel() {
        return this.logLevel;
    }

    public final LogModel copy(Device device, LogContent logContent, String logId, String schoolId, String schoolName, Long time, String deviceNo, String deviceType, String logLevel, String traceId) {
        return new LogModel(device, logContent, logId, schoolId, schoolName, time, deviceNo, deviceType, logLevel, traceId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LogModel)) {
            return false;
        }
        LogModel logModel = (LogModel) other;
        return Intrinsics.areEqual(this.device, logModel.device) && Intrinsics.areEqual(this.logContent, logModel.logContent) && Intrinsics.areEqual(this.logId, logModel.logId) && Intrinsics.areEqual(this.schoolId, logModel.schoolId) && Intrinsics.areEqual(this.schoolName, logModel.schoolName) && Intrinsics.areEqual(this.time, logModel.time) && Intrinsics.areEqual(this.deviceNo, logModel.deviceNo) && Intrinsics.areEqual(this.deviceType, logModel.deviceType) && Intrinsics.areEqual(this.logLevel, logModel.logLevel) && Intrinsics.areEqual(this.traceId, logModel.traceId);
    }

    public int hashCode() {
        Device device = this.device;
        int iHashCode = (device == null ? 0 : device.hashCode()) * 31;
        LogContent logContent = this.logContent;
        int iHashCode2 = (iHashCode + (logContent == null ? 0 : logContent.hashCode())) * 31;
        String str = this.logId;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.schoolId;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.schoolName;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.time;
        int iHashCode6 = (iHashCode5 + (l == null ? 0 : l.hashCode())) * 31;
        String str4 = this.deviceNo;
        int iHashCode7 = (iHashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.deviceType;
        int iHashCode8 = (iHashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.logLevel;
        int iHashCode9 = (iHashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.traceId;
        return iHashCode9 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "LogModel(device=" + this.device + ", logContent=" + this.logContent + ", logId=" + this.logId + ", schoolId=" + this.schoolId + ", schoolName=" + this.schoolName + ", time=" + this.time + ", deviceNo=" + this.deviceNo + ", deviceType=" + this.deviceType + ", logLevel=" + this.logLevel + ", traceId=" + this.traceId + ')';
    }

    public LogModel(Device device, LogContent logContent, String str, String str2, String str3, Long l, String str4, String str5, String str6, String str7) {
        this.device = device;
        this.logContent = logContent;
        this.logId = str;
        this.schoolId = str2;
        this.schoolName = str3;
        this.time = l;
        this.deviceNo = str4;
        this.deviceType = str5;
        this.logLevel = str6;
        this.traceId = str7;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final void setDevice(Device device) {
        this.device = device;
    }

    public final LogContent getLogContent() {
        return this.logContent;
    }

    public final void setLogContent(LogContent logContent) {
        this.logContent = logContent;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final void setLogId(String str) {
        this.logId = str;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final void setSchoolId(String str) {
        this.schoolId = str;
    }

    public final String getSchoolName() {
        return this.schoolName;
    }

    public final void setSchoolName(String str) {
        this.schoolName = str;
    }

    public /* synthetic */ LogModel(Device device, LogContent logContent, String str, String str2, String str3, Long l, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : device, (i & 2) == 0 ? logContent : null, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3, (i & 32) != 0 ? 0L : l, (i & 64) != 0 ? "" : str4, (i & 128) != 0 ? "" : str5, (i & 256) != 0 ? "" : str6, (i & 512) == 0 ? str7 : "");
    }

    public final Long getTime() {
        return this.time;
    }

    public final void setTime(Long l) {
        this.time = l;
    }

    public final String getDeviceNo() {
        return this.deviceNo;
    }

    public final void setDeviceNo(String str) {
        this.deviceNo = str;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final void setDeviceType(String str) {
        this.deviceType = str;
    }

    public final String getLogLevel() {
        return this.logLevel;
    }

    public final void setLogLevel(String str) {
        this.logLevel = str;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final void setTraceId(String str) {
        this.traceId = str;
    }
}
