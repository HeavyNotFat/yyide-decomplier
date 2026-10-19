package com.yd.android_brand_mvp.model.active;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActiveEnrollSubBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\t\u0010#\u001a\u00020\bHÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\bHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/model/active/ActiveEnrollSubBean;", "Landroid/os/Parcelable;", "activityId", "", "createBy", "createTime", "id", "numQuantity", "", "schoolId", "subEnrollCount", "subName", "subUserEnrollStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "getCreateBy", "getCreateTime", "getId", "getNumQuantity", "()I", "getSchoolId", "getSubEnrollCount", "getSubName", "getSubUserEnrollStatus", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ActiveEnrollSubBean implements Parcelable {
    public static final Parcelable.Creator<ActiveEnrollSubBean> CREATOR = new Creator();
    private final String activityId;
    private final String createBy;
    private final String createTime;
    private final String id;
    private final int numQuantity;
    private final String schoolId;
    private final int subEnrollCount;
    private final String subName;
    private final String subUserEnrollStatus;

    /* JADX INFO: compiled from: ActiveEnrollSubBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ActiveEnrollSubBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActiveEnrollSubBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ActiveEnrollSubBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActiveEnrollSubBean[] newArray(int i) {
            return new ActiveEnrollSubBean[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreateBy() {
        return this.createBy;
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
    public final int getNumQuantity() {
        return this.numQuantity;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getSubEnrollCount() {
        return this.subEnrollCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSubName() {
        return this.subName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSubUserEnrollStatus() {
        return this.subUserEnrollStatus;
    }

    public final ActiveEnrollSubBean copy(String activityId, String createBy, String createTime, String id, int numQuantity, String schoolId, int subEnrollCount, String subName, String subUserEnrollStatus) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(subName, "subName");
        Intrinsics.checkNotNullParameter(subUserEnrollStatus, "subUserEnrollStatus");
        return new ActiveEnrollSubBean(activityId, createBy, createTime, id, numQuantity, schoolId, subEnrollCount, subName, subUserEnrollStatus);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveEnrollSubBean)) {
            return false;
        }
        ActiveEnrollSubBean activeEnrollSubBean = (ActiveEnrollSubBean) other;
        return Intrinsics.areEqual(this.activityId, activeEnrollSubBean.activityId) && Intrinsics.areEqual(this.createBy, activeEnrollSubBean.createBy) && Intrinsics.areEqual(this.createTime, activeEnrollSubBean.createTime) && Intrinsics.areEqual(this.id, activeEnrollSubBean.id) && this.numQuantity == activeEnrollSubBean.numQuantity && Intrinsics.areEqual(this.schoolId, activeEnrollSubBean.schoolId) && this.subEnrollCount == activeEnrollSubBean.subEnrollCount && Intrinsics.areEqual(this.subName, activeEnrollSubBean.subName) && Intrinsics.areEqual(this.subUserEnrollStatus, activeEnrollSubBean.subUserEnrollStatus);
    }

    public int hashCode() {
        return (((((((((((((((this.activityId.hashCode() * 31) + this.createBy.hashCode()) * 31) + this.createTime.hashCode()) * 31) + this.id.hashCode()) * 31) + this.numQuantity) * 31) + this.schoolId.hashCode()) * 31) + this.subEnrollCount) * 31) + this.subName.hashCode()) * 31) + this.subUserEnrollStatus.hashCode();
    }

    public String toString() {
        return "ActiveEnrollSubBean(activityId=" + this.activityId + ", createBy=" + this.createBy + ", createTime=" + this.createTime + ", id=" + this.id + ", numQuantity=" + this.numQuantity + ", schoolId=" + this.schoolId + ", subEnrollCount=" + this.subEnrollCount + ", subName=" + this.subName + ", subUserEnrollStatus=" + this.subUserEnrollStatus + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.activityId);
        parcel.writeString(this.createBy);
        parcel.writeString(this.createTime);
        parcel.writeString(this.id);
        parcel.writeInt(this.numQuantity);
        parcel.writeString(this.schoolId);
        parcel.writeInt(this.subEnrollCount);
        parcel.writeString(this.subName);
        parcel.writeString(this.subUserEnrollStatus);
    }

    public ActiveEnrollSubBean(String activityId, String createBy, String createTime, String id, int i, String schoolId, int i2, String subName, String subUserEnrollStatus) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(subName, "subName");
        Intrinsics.checkNotNullParameter(subUserEnrollStatus, "subUserEnrollStatus");
        this.activityId = activityId;
        this.createBy = createBy;
        this.createTime = createTime;
        this.id = id;
        this.numQuantity = i;
        this.schoolId = schoolId;
        this.subEnrollCount = i2;
        this.subName = subName;
        this.subUserEnrollStatus = subUserEnrollStatus;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final String getCreateBy() {
        return this.createBy;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final String getId() {
        return this.id;
    }

    public final int getNumQuantity() {
        return this.numQuantity;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final int getSubEnrollCount() {
        return this.subEnrollCount;
    }

    public final String getSubName() {
        return this.subName;
    }

    public final String getSubUserEnrollStatus() {
        return this.subUserEnrollStatus;
    }
}
