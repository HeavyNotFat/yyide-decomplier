package com.yd.android_brand_mvp.mqtt;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemInformationBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/DeviceInfoBean;", "", "msgId", "", "semaphore", "schoolId", "deviceNo", "deviceType", "messageContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceNo", "()Ljava/lang/String;", "setDeviceNo", "(Ljava/lang/String;)V", "getDeviceType", "setDeviceType", "getMessageContent", "setMessageContent", "getMsgId", "setMsgId", "getSchoolId", "setSchoolId", "getSemaphore", "setSemaphore", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DeviceInfoBean {
    private String deviceNo;
    private String deviceType;
    private String messageContent;
    private String msgId;
    private String schoolId;
    private String semaphore;

    public DeviceInfoBean() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ DeviceInfoBean copy$default(DeviceInfoBean deviceInfoBean, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceInfoBean.msgId;
        }
        if ((i & 2) != 0) {
            str2 = deviceInfoBean.semaphore;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = deviceInfoBean.schoolId;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = deviceInfoBean.deviceNo;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = deviceInfoBean.deviceType;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = deviceInfoBean.messageContent;
        }
        return deviceInfoBean.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMsgId() {
        return this.msgId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSemaphore() {
        return this.semaphore;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDeviceNo() {
        return this.deviceNo;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMessageContent() {
        return this.messageContent;
    }

    public final DeviceInfoBean copy(String msgId, String semaphore, String schoolId, String deviceNo, String deviceType, String messageContent) {
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(semaphore, "semaphore");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(deviceNo, "deviceNo");
        return new DeviceInfoBean(msgId, semaphore, schoolId, deviceNo, deviceType, messageContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceInfoBean)) {
            return false;
        }
        DeviceInfoBean deviceInfoBean = (DeviceInfoBean) other;
        return Intrinsics.areEqual(this.msgId, deviceInfoBean.msgId) && Intrinsics.areEqual(this.semaphore, deviceInfoBean.semaphore) && Intrinsics.areEqual(this.schoolId, deviceInfoBean.schoolId) && Intrinsics.areEqual(this.deviceNo, deviceInfoBean.deviceNo) && Intrinsics.areEqual(this.deviceType, deviceInfoBean.deviceType) && Intrinsics.areEqual(this.messageContent, deviceInfoBean.messageContent);
    }

    public int hashCode() {
        int iHashCode = ((((((this.msgId.hashCode() * 31) + this.semaphore.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.deviceNo.hashCode()) * 31;
        String str = this.deviceType;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.messageContent;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "DeviceInfoBean(msgId=" + this.msgId + ", semaphore=" + this.semaphore + ", schoolId=" + this.schoolId + ", deviceNo=" + this.deviceNo + ", deviceType=" + this.deviceType + ", messageContent=" + this.messageContent + ')';
    }

    public DeviceInfoBean(String msgId, String semaphore, String schoolId, String deviceNo, String str, String str2) {
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(semaphore, "semaphore");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(deviceNo, "deviceNo");
        this.msgId = msgId;
        this.semaphore = semaphore;
        this.schoolId = schoolId;
        this.deviceNo = deviceNo;
        this.deviceType = str;
        this.messageContent = str2;
    }

    public /* synthetic */ DeviceInfoBean(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) == 0 ? str5 : "", (i & 32) != 0 ? null : str6);
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final void setMsgId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.msgId = str;
    }

    public final String getSemaphore() {
        return this.semaphore;
    }

    public final void setSemaphore(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.semaphore = str;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final void setSchoolId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schoolId = str;
    }

    public final String getDeviceNo() {
        return this.deviceNo;
    }

    public final void setDeviceNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.deviceNo = str;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final void setDeviceType(String str) {
        this.deviceType = str;
    }

    public final String getMessageContent() {
        return this.messageContent;
    }

    public final void setMessageContent(String str) {
        this.messageContent = str;
    }
}
