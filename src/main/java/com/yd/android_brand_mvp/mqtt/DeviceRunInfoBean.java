package com.yd.android_brand_mvp.mqtt;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemInformationBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J=\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006$"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/DeviceRunInfoBean;", "", "msgId", "", "semaphore", "schoolId", "deviceNo", "messageContent", "Lcom/yd/android_brand_mvp/mqtt/SystemInformationBean;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/yd/android_brand_mvp/mqtt/SystemInformationBean;)V", "getDeviceNo", "()Ljava/lang/String;", "setDeviceNo", "(Ljava/lang/String;)V", "getMessageContent", "()Lcom/yd/android_brand_mvp/mqtt/SystemInformationBean;", "setMessageContent", "(Lcom/yd/android_brand_mvp/mqtt/SystemInformationBean;)V", "getMsgId", "setMsgId", "getSchoolId", "setSchoolId", "getSemaphore", "setSemaphore", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DeviceRunInfoBean {
    private String deviceNo;
    private SystemInformationBean messageContent;
    private String msgId;
    private String schoolId;
    private String semaphore;

    public DeviceRunInfoBean() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ DeviceRunInfoBean copy$default(DeviceRunInfoBean deviceRunInfoBean, String str, String str2, String str3, String str4, SystemInformationBean systemInformationBean, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deviceRunInfoBean.msgId;
        }
        if ((i & 2) != 0) {
            str2 = deviceRunInfoBean.semaphore;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = deviceRunInfoBean.schoolId;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = deviceRunInfoBean.deviceNo;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            systemInformationBean = deviceRunInfoBean.messageContent;
        }
        return deviceRunInfoBean.copy(str, str5, str6, str7, systemInformationBean);
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
    public final SystemInformationBean getMessageContent() {
        return this.messageContent;
    }

    public final DeviceRunInfoBean copy(String msgId, String semaphore, String schoolId, String deviceNo, SystemInformationBean messageContent) {
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(semaphore, "semaphore");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(deviceNo, "deviceNo");
        return new DeviceRunInfoBean(msgId, semaphore, schoolId, deviceNo, messageContent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceRunInfoBean)) {
            return false;
        }
        DeviceRunInfoBean deviceRunInfoBean = (DeviceRunInfoBean) other;
        return Intrinsics.areEqual(this.msgId, deviceRunInfoBean.msgId) && Intrinsics.areEqual(this.semaphore, deviceRunInfoBean.semaphore) && Intrinsics.areEqual(this.schoolId, deviceRunInfoBean.schoolId) && Intrinsics.areEqual(this.deviceNo, deviceRunInfoBean.deviceNo) && Intrinsics.areEqual(this.messageContent, deviceRunInfoBean.messageContent);
    }

    public int hashCode() {
        int iHashCode = ((((((this.msgId.hashCode() * 31) + this.semaphore.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.deviceNo.hashCode()) * 31;
        SystemInformationBean systemInformationBean = this.messageContent;
        return iHashCode + (systemInformationBean == null ? 0 : systemInformationBean.hashCode());
    }

    public String toString() {
        return "DeviceRunInfoBean(msgId=" + this.msgId + ", semaphore=" + this.semaphore + ", schoolId=" + this.schoolId + ", deviceNo=" + this.deviceNo + ", messageContent=" + this.messageContent + ')';
    }

    public DeviceRunInfoBean(String msgId, String semaphore, String schoolId, String deviceNo, SystemInformationBean systemInformationBean) {
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(semaphore, "semaphore");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(deviceNo, "deviceNo");
        this.msgId = msgId;
        this.semaphore = semaphore;
        this.schoolId = schoolId;
        this.deviceNo = deviceNo;
        this.messageContent = systemInformationBean;
    }

    public /* synthetic */ DeviceRunInfoBean(String str, String str2, String str3, String str4, SystemInformationBean systemInformationBean, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? null : systemInformationBean);
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

    public final SystemInformationBean getMessageContent() {
        return this.messageContent;
    }

    public final void setMessageContent(SystemInformationBean systemInformationBean) {
        this.messageContent = systemInformationBean;
    }
}
