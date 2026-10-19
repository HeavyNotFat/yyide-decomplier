package com.yd.android_brand_mvp.model.active;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActiveRangeBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0007HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006,"}, d2 = {"Lcom/yd/android_brand_mvp/model/active/ActiveRangeBean;", "Landroid/os/Parcelable;", "activityId", "", "dataId", "dataPid", "dataType", "", "id", "rangeKey", "rangeName", "schoolId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getActivityId", "()Ljava/lang/String;", "getDataId", "getDataPid", "getDataType", "()I", "getId", "getRangeKey", "getRangeName", "getSchoolId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ActiveRangeBean implements Parcelable {
    public static final Parcelable.Creator<ActiveRangeBean> CREATOR = new Creator();
    private final String activityId;
    private final String dataId;
    private final String dataPid;
    private final int dataType;
    private final String id;
    private final String rangeKey;
    private final String rangeName;
    private final String schoolId;

    /* JADX INFO: compiled from: ActiveRangeBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ActiveRangeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActiveRangeBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ActiveRangeBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActiveRangeBean[] newArray(int i) {
            return new ActiveRangeBean[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDataId() {
        return this.dataId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDataPid() {
        return this.dataPid;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDataType() {
        return this.dataType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRangeKey() {
        return this.rangeKey;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRangeName() {
        return this.rangeName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    public final ActiveRangeBean copy(String activityId, String dataId, String dataPid, int dataType, String id, String rangeKey, String rangeName, String schoolId) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(dataId, "dataId");
        Intrinsics.checkNotNullParameter(dataPid, "dataPid");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(rangeKey, "rangeKey");
        Intrinsics.checkNotNullParameter(rangeName, "rangeName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        return new ActiveRangeBean(activityId, dataId, dataPid, dataType, id, rangeKey, rangeName, schoolId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveRangeBean)) {
            return false;
        }
        ActiveRangeBean activeRangeBean = (ActiveRangeBean) other;
        return Intrinsics.areEqual(this.activityId, activeRangeBean.activityId) && Intrinsics.areEqual(this.dataId, activeRangeBean.dataId) && Intrinsics.areEqual(this.dataPid, activeRangeBean.dataPid) && this.dataType == activeRangeBean.dataType && Intrinsics.areEqual(this.id, activeRangeBean.id) && Intrinsics.areEqual(this.rangeKey, activeRangeBean.rangeKey) && Intrinsics.areEqual(this.rangeName, activeRangeBean.rangeName) && Intrinsics.areEqual(this.schoolId, activeRangeBean.schoolId);
    }

    public int hashCode() {
        return (((((((((((((this.activityId.hashCode() * 31) + this.dataId.hashCode()) * 31) + this.dataPid.hashCode()) * 31) + this.dataType) * 31) + this.id.hashCode()) * 31) + this.rangeKey.hashCode()) * 31) + this.rangeName.hashCode()) * 31) + this.schoolId.hashCode();
    }

    public String toString() {
        return "ActiveRangeBean(activityId=" + this.activityId + ", dataId=" + this.dataId + ", dataPid=" + this.dataPid + ", dataType=" + this.dataType + ", id=" + this.id + ", rangeKey=" + this.rangeKey + ", rangeName=" + this.rangeName + ", schoolId=" + this.schoolId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.activityId);
        parcel.writeString(this.dataId);
        parcel.writeString(this.dataPid);
        parcel.writeInt(this.dataType);
        parcel.writeString(this.id);
        parcel.writeString(this.rangeKey);
        parcel.writeString(this.rangeName);
        parcel.writeString(this.schoolId);
    }

    public ActiveRangeBean(String activityId, String dataId, String dataPid, int i, String id, String rangeKey, String rangeName, String schoolId) {
        Intrinsics.checkNotNullParameter(activityId, "activityId");
        Intrinsics.checkNotNullParameter(dataId, "dataId");
        Intrinsics.checkNotNullParameter(dataPid, "dataPid");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(rangeKey, "rangeKey");
        Intrinsics.checkNotNullParameter(rangeName, "rangeName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        this.activityId = activityId;
        this.dataId = dataId;
        this.dataPid = dataPid;
        this.dataType = i;
        this.id = id;
        this.rangeKey = rangeKey;
        this.rangeName = rangeName;
        this.schoolId = schoolId;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final String getDataId() {
        return this.dataId;
    }

    public final String getDataPid() {
        return this.dataPid;
    }

    public final int getDataType() {
        return this.dataType;
    }

    public final String getId() {
        return this.id;
    }

    public final String getRangeKey() {
        return this.rangeKey;
    }

    public final String getRangeName() {
        return this.rangeName;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }
}
