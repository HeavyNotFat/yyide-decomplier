package com.yd.android_brand_mvp.model.active;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActiveMyRegistrationBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/model/active/ActiveMyRegistrationBean;", "Landroid/os/Parcelable;", "activityId", "", "activityName", "createTime", "id", "remarks", "status", "", "subName", "subType", "userName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "getActivityName", "getCreateTime", "getId", "getRemarks", "getStatus", "()I", "getSubName", "getSubType", "getUserName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ActiveMyRegistrationBean implements Parcelable {
    public static final Parcelable.Creator<ActiveMyRegistrationBean> CREATOR = new Creator();
    private final String activityId;
    private final String activityName;
    private final String createTime;
    private final String id;
    private final String remarks;
    private final int status;
    private final String subName;
    private final int subType;
    private final String userName;

    /* JADX INFO: compiled from: ActiveMyRegistrationBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ActiveMyRegistrationBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActiveMyRegistrationBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ActiveMyRegistrationBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActiveMyRegistrationBean[] newArray(int i) {
            return new ActiveMyRegistrationBean[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRemarks() {
        return this.remarks;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSubName() {
        return this.subName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getSubType() {
        return this.subType;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    public final ActiveMyRegistrationBean copy(String activityId, String activityName, String createTime, String id, String remarks, int status, String subName, int subType, String userName) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        Intrinsics.checkNotNullParameter(subName, "subName");
        Intrinsics.checkNotNullParameter(userName, "userName");
        return new ActiveMyRegistrationBean(activityId, activityName, createTime, id, remarks, status, subName, subType, userName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveMyRegistrationBean)) {
            return false;
        }
        ActiveMyRegistrationBean activeMyRegistrationBean = (ActiveMyRegistrationBean) other;
        return Intrinsics.areEqual(this.activityId, activeMyRegistrationBean.activityId) && Intrinsics.areEqual(this.activityName, activeMyRegistrationBean.activityName) && Intrinsics.areEqual(this.createTime, activeMyRegistrationBean.createTime) && Intrinsics.areEqual(this.id, activeMyRegistrationBean.id) && Intrinsics.areEqual(this.remarks, activeMyRegistrationBean.remarks) && this.status == activeMyRegistrationBean.status && Intrinsics.areEqual(this.subName, activeMyRegistrationBean.subName) && this.subType == activeMyRegistrationBean.subType && Intrinsics.areEqual(this.userName, activeMyRegistrationBean.userName);
    }

    public int hashCode() {
        return (((((((((((((((this.activityId.hashCode() * 31) + this.activityName.hashCode()) * 31) + this.createTime.hashCode()) * 31) + this.id.hashCode()) * 31) + this.remarks.hashCode()) * 31) + this.status) * 31) + this.subName.hashCode()) * 31) + this.subType) * 31) + this.userName.hashCode();
    }

    public String toString() {
        return "ActiveMyRegistrationBean(activityId=" + this.activityId + ", activityName=" + this.activityName + ", createTime=" + this.createTime + ", id=" + this.id + ", remarks=" + this.remarks + ", status=" + this.status + ", subName=" + this.subName + ", subType=" + this.subType + ", userName=" + this.userName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.activityId);
        parcel.writeString(this.activityName);
        parcel.writeString(this.createTime);
        parcel.writeString(this.id);
        parcel.writeString(this.remarks);
        parcel.writeInt(this.status);
        parcel.writeString(this.subName);
        parcel.writeInt(this.subType);
        parcel.writeString(this.userName);
    }

    public ActiveMyRegistrationBean(String activityId, String activityName, String createTime, String id, String remarks, int i, String subName, int i2, String userName) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(remarks, "remarks");
        Intrinsics.checkNotNullParameter(subName, "subName");
        Intrinsics.checkNotNullParameter(userName, "userName");
        this.activityId = activityId;
        this.activityName = activityName;
        this.createTime = createTime;
        this.id = id;
        this.remarks = remarks;
        this.status = i;
        this.subName = subName;
        this.subType = i2;
        this.userName = userName;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getId() {
        return this.id;
    }

    public final String getRemarks() {
        return this.remarks;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getSubName() {
        return this.subName;
    }

    public final int getSubType() {
        return this.subType;
    }

    public final String getUserName() {
        return this.userName;
    }
}
