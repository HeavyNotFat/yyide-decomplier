package com.yd.android_brand_mvp.model.active;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActiveRegistrationBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\n¢\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\nHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\nHÆ\u0003J\t\u0010+\u001a\u00020\nHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\nHÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u009f\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\nHÆ\u0001J\t\u00105\u001a\u00020\nHÖ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\nHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\u0019\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001c¨\u0006A"}, d2 = {"Lcom/yd/android_brand_mvp/model/active/ActiveRegistrationBean;", "Landroid/os/Parcelable;", "activityEndTime", "", "activityName", "activityStartTime", "coverImg", "createBy", "createTime", "enrollCount", "", "id", "rangeNames", "registerEndTime", "registerStartTime", "status", "statusName", "subType", "total", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;II)V", "getActivityEndTime", "()Ljava/lang/String;", "getActivityName", "getActivityStartTime", "getCoverImg", "getCreateBy", "getCreateTime", "getEnrollCount", "()I", "getId", "getRangeNames", "getRegisterEndTime", "getRegisterStartTime", "getStatus", "getStatusName", "getSubType", "getTotal", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ActiveRegistrationBean implements Parcelable {
    public static final Parcelable.Creator<ActiveRegistrationBean> CREATOR = new Creator();
    private final String activityEndTime;
    private final String activityName;
    private final String activityStartTime;
    private final String coverImg;
    private final String createBy;
    private final String createTime;
    private final int enrollCount;
    private final String id;
    private final String rangeNames;
    private final String registerEndTime;
    private final String registerStartTime;
    private final int status;
    private final String statusName;
    private final int subType;
    private final int total;

    /* JADX INFO: compiled from: ActiveRegistrationBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ActiveRegistrationBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActiveRegistrationBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ActiveRegistrationBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActiveRegistrationBean[] newArray(int i) {
            return new ActiveRegistrationBean[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityEndTime() {
        return this.activityEndTime;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getRegisterEndTime() {
        return this.registerEndTime;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getRegisterStartTime() {
        return this.registerStartTime;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getStatusName() {
        return this.statusName;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final int getSubType() {
        return this.subType;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getActivityStartTime() {
        return this.activityStartTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCoverImg() {
        return this.coverImg;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCreateBy() {
        return this.createBy;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getEnrollCount() {
        return this.enrollCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getRangeNames() {
        return this.rangeNames;
    }

    public final ActiveRegistrationBean copy(String activityEndTime, String activityName, String activityStartTime, String coverImg, String createBy, String createTime, int enrollCount, String id, String rangeNames, String registerEndTime, String registerStartTime, int status, String statusName, int subType, int total) {
        Intrinsics.checkNotNullParameter(activityEndTime, "activityEndTime");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(activityStartTime, "activityStartTime");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(rangeNames, "rangeNames");
        Intrinsics.checkNotNullParameter(registerEndTime, "registerEndTime");
        Intrinsics.checkNotNullParameter(registerStartTime, "registerStartTime");
        Intrinsics.checkNotNullParameter(statusName, "statusName");
        return new ActiveRegistrationBean(activityEndTime, activityName, activityStartTime, coverImg, createBy, createTime, enrollCount, id, rangeNames, registerEndTime, registerStartTime, status, statusName, subType, total);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveRegistrationBean)) {
            return false;
        }
        ActiveRegistrationBean activeRegistrationBean = (ActiveRegistrationBean) other;
        return Intrinsics.areEqual(this.activityEndTime, activeRegistrationBean.activityEndTime) && Intrinsics.areEqual(this.activityName, activeRegistrationBean.activityName) && Intrinsics.areEqual(this.activityStartTime, activeRegistrationBean.activityStartTime) && Intrinsics.areEqual(this.coverImg, activeRegistrationBean.coverImg) && Intrinsics.areEqual(this.createBy, activeRegistrationBean.createBy) && Intrinsics.areEqual(this.createTime, activeRegistrationBean.createTime) && this.enrollCount == activeRegistrationBean.enrollCount && Intrinsics.areEqual(this.id, activeRegistrationBean.id) && Intrinsics.areEqual(this.rangeNames, activeRegistrationBean.rangeNames) && Intrinsics.areEqual(this.registerEndTime, activeRegistrationBean.registerEndTime) && Intrinsics.areEqual(this.registerStartTime, activeRegistrationBean.registerStartTime) && this.status == activeRegistrationBean.status && Intrinsics.areEqual(this.statusName, activeRegistrationBean.statusName) && this.subType == activeRegistrationBean.subType && this.total == activeRegistrationBean.total;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.activityEndTime.hashCode() * 31) + this.activityName.hashCode()) * 31) + this.activityStartTime.hashCode()) * 31) + this.coverImg.hashCode()) * 31) + this.createBy.hashCode()) * 31) + this.createTime.hashCode()) * 31) + this.enrollCount) * 31) + this.id.hashCode()) * 31) + this.rangeNames.hashCode()) * 31) + this.registerEndTime.hashCode()) * 31) + this.registerStartTime.hashCode()) * 31) + this.status) * 31) + this.statusName.hashCode()) * 31) + this.subType) * 31) + this.total;
    }

    public String toString() {
        return "ActiveRegistrationBean(activityEndTime=" + this.activityEndTime + ", activityName=" + this.activityName + ", activityStartTime=" + this.activityStartTime + ", coverImg=" + this.coverImg + ", createBy=" + this.createBy + ", createTime=" + this.createTime + ", enrollCount=" + this.enrollCount + ", id=" + this.id + ", rangeNames=" + this.rangeNames + ", registerEndTime=" + this.registerEndTime + ", registerStartTime=" + this.registerStartTime + ", status=" + this.status + ", statusName=" + this.statusName + ", subType=" + this.subType + ", total=" + this.total + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.activityEndTime);
        parcel.writeString(this.activityName);
        parcel.writeString(this.activityStartTime);
        parcel.writeString(this.coverImg);
        parcel.writeString(this.createBy);
        parcel.writeString(this.createTime);
        parcel.writeInt(this.enrollCount);
        parcel.writeString(this.id);
        parcel.writeString(this.rangeNames);
        parcel.writeString(this.registerEndTime);
        parcel.writeString(this.registerStartTime);
        parcel.writeInt(this.status);
        parcel.writeString(this.statusName);
        parcel.writeInt(this.subType);
        parcel.writeInt(this.total);
    }

    public ActiveRegistrationBean(String activityEndTime, String activityName, String activityStartTime, String coverImg, String createBy, String createTime, int i, String id, String rangeNames, String registerEndTime, String registerStartTime, int i2, String statusName, int i3, int i4) {
        Intrinsics.checkNotNullParameter(activityEndTime, "activityEndTime");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(activityStartTime, "activityStartTime");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(rangeNames, "rangeNames");
        Intrinsics.checkNotNullParameter(registerEndTime, "registerEndTime");
        Intrinsics.checkNotNullParameter(registerStartTime, "registerStartTime");
        Intrinsics.checkNotNullParameter(statusName, "statusName");
        this.activityEndTime = activityEndTime;
        this.activityName = activityName;
        this.activityStartTime = activityStartTime;
        this.coverImg = coverImg;
        this.createBy = createBy;
        this.createTime = createTime;
        this.enrollCount = i;
        this.id = id;
        this.rangeNames = rangeNames;
        this.registerEndTime = registerEndTime;
        this.registerStartTime = registerStartTime;
        this.status = i2;
        this.statusName = statusName;
        this.subType = i3;
        this.total = i4;
    }

    public final String getActivityEndTime() {
        return this.activityEndTime;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final String getActivityStartTime() {
        return this.activityStartTime;
    }

    public final String getCoverImg() {
        return this.coverImg;
    }

    public final String getCreateBy() {
        return this.createBy;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final int getEnrollCount() {
        return this.enrollCount;
    }

    public final String getId() {
        return this.id;
    }

    public final String getRangeNames() {
        return this.rangeNames;
    }

    public final String getRegisterEndTime() {
        return this.registerEndTime;
    }

    public final String getRegisterStartTime() {
        return this.registerStartTime;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getStatusName() {
        return this.statusName;
    }

    public final int getSubType() {
        return this.subType;
    }

    public final int getTotal() {
        return this.total;
    }
}
