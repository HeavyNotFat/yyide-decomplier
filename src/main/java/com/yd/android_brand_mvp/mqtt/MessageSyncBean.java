package com.yd.android_brand_mvp.mqtt;

import com.yd.android_brand_mvp.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessageSyncBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/mqtt/MessageSyncBean;", "", "id", "", "status", "", "remark", "deviceNo", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getDeviceNo", "()Ljava/lang/String;", "getId", "getRemark", "getStatus", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MessageSyncBean {
    private final String deviceNo;
    private final String id;
    private final String remark;
    private final int status;

    public static /* synthetic */ MessageSyncBean copy$default(MessageSyncBean messageSyncBean, String str, int i, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = messageSyncBean.id;
        }
        if ((i2 & 2) != 0) {
            i = messageSyncBean.status;
        }
        if ((i2 & 4) != 0) {
            str2 = messageSyncBean.remark;
        }
        if ((i2 & 8) != 0) {
            str3 = messageSyncBean.deviceNo;
        }
        return messageSyncBean.copy(str, i, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRemark() {
        return this.remark;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDeviceNo() {
        return this.deviceNo;
    }

    public final MessageSyncBean copy(String id, int status, String remark, String deviceNo) {
        return new MessageSyncBean(id, status, remark, deviceNo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageSyncBean)) {
            return false;
        }
        MessageSyncBean messageSyncBean = (MessageSyncBean) other;
        return Intrinsics.areEqual(this.id, messageSyncBean.id) && this.status == messageSyncBean.status && Intrinsics.areEqual(this.remark, messageSyncBean.remark) && Intrinsics.areEqual(this.deviceNo, messageSyncBean.deviceNo);
    }

    public int hashCode() {
        String str = this.id;
        int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.status) * 31;
        String str2 = this.remark;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.deviceNo;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "MessageSyncBean(id=" + this.id + ", status=" + this.status + ", remark=" + this.remark + ", deviceNo=" + this.deviceNo + ')';
    }

    public MessageSyncBean(String str, int i, String str2, String str3) {
        this.id = str;
        this.status = i;
        this.remark = str2;
        this.deviceNo = str3;
    }

    public final String getId() {
        return this.id;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getRemark() {
        return this.remark;
    }

    public /* synthetic */ MessageSyncBean(String str, int i, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, i, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? BaseApplication.getInstance().getMac() : str3);
    }

    public final String getDeviceNo() {
        return this.deviceNo;
    }
}
