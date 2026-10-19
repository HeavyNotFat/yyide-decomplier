package com.yd.android_brand_mvp.mqtt;

import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.a.a;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.yd.android_brand_mvp.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MQTTEventBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\bR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR \u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR \u0010\u0016\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR \u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\f¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/MQTTEventBean;", "", "()V", "currentDevice", "", "getCurrentDevice", "()Z", a.h, "", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "deviceNo", "getDeviceNo", "setDeviceNo", "eventCode", "getEventCode", "setEventCode", "id", "getId", "setId", RemoteMessageConst.MessageBody.PARAM, "getParam", "setParam", "schoolId", "getSchoolId", "setSchoolId", "setData", "", "data", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MQTTEventBean {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SerializedName(a.h)
    private String description;

    @SerializedName("deviceNo")
    private String deviceNo;

    @SerializedName("eventCode")
    private String eventCode;

    @SerializedName("id")
    private String id;

    @SerializedName(RemoteMessageConst.MessageBody.PARAM)
    private String param;

    @SerializedName("schoolId")
    private String schoolId;

    public final String getEventCode() {
        return this.eventCode;
    }

    public final void setEventCode(String str) {
        this.eventCode = str;
    }

    public final String getParam() {
        return this.param;
    }

    public final void setParam(String str) {
        this.param = str;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final String getDeviceNo() {
        return this.deviceNo;
    }

    public final void setDeviceNo(String str) {
        this.deviceNo = str;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final void setSchoolId(String str) {
        this.schoolId = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final boolean getCurrentDevice() {
        return Intrinsics.areEqual(BaseApplication.getInstance().getMac(), this.deviceNo);
    }

    public final void setData(String data) {
        this.param = data;
    }

    /* JADX INFO: compiled from: MQTTEventBean.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/MQTTEventBean$Companion;", "", "()V", "filterCode", "", a.j, "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean filterCode(String code) {
            return false;
        }

        private Companion() {
        }
    }
}
