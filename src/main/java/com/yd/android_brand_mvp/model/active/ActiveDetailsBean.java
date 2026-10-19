package com.yd.android_brand_mvp.model.active;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActiveDetailsBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0010\u0012\u0006\u0010\u001b\u001a\u00020\u0010\u0012\u0006\u0010\u001c\u001a\u00020\u0010\u0012\u0006\u0010\u001d\u001a\u00020\u0003¢\u0006\u0002\u0010\u001eJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003J\t\u0010;\u001a\u00020\u0010HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00130\rHÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0010HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0010HÆ\u0003J\t\u0010F\u001a\u00020\u0010HÆ\u0003J\t\u0010G\u001a\u00020\u0010HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003Jû\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00102\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00102\b\b\u0002\u0010\u001b\u001a\u00020\u00102\b\b\u0002\u0010\u001c\u001a\u00020\u00102\b\b\u0002\u0010\u001d\u001a\u00020\u0003HÆ\u0001J\t\u0010Q\u001a\u00020\u0010HÖ\u0001J\u0013\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010UHÖ\u0003J\t\u0010V\u001a\u00020\u0010HÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001J\u0019\u0010X\u001a\u00020Y2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\r¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0011\u0010\u0018\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b3\u0010,R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010 R\u0011\u0010\u001a\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b5\u0010,R\u0011\u0010\u001b\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b6\u0010,R\u0011\u0010\u001c\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b7\u0010,R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010 ¨\u0006]"}, d2 = {"Lcom/yd/android_brand_mvp/model/active/ActiveDetailsBean;", "Landroid/os/Parcelable;", "activityEndTime", "", "activityIntroduction", "activityName", "activityRemarks", "activityStartTime", "coverImg", "createBy", "createId", "createTime", "enrollSubList", "", "Lcom/yd/android_brand_mvp/model/active/ActiveEnrollSubBean;", "enrollType", "", "id", "rangeList", "Lcom/yd/android_brand_mvp/model/active/ActiveRangeBean;", "registerEndTime", "registerStartTime", "schoolId", "selectedNodesInfo", "status", "statusName", "subType", "total", "userCount", "userEnrollStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIILjava/lang/String;)V", "getActivityEndTime", "()Ljava/lang/String;", "getActivityIntroduction", "getActivityName", "getActivityRemarks", "getActivityStartTime", "getCoverImg", "getCreateBy", "getCreateId", "getCreateTime", "getEnrollSubList", "()Ljava/util/List;", "getEnrollType", "()I", "getId", "getRangeList", "getRegisterEndTime", "getRegisterStartTime", "getSchoolId", "getSelectedNodesInfo", "getStatus", "getStatusName", "getSubType", "getTotal", "getUserCount", "getUserEnrollStatus", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ActiveDetailsBean implements Parcelable {
    public static final Parcelable.Creator<ActiveDetailsBean> CREATOR = new Creator();
    private final String activityEndTime;
    private final String activityIntroduction;
    private final String activityName;
    private final String activityRemarks;
    private final String activityStartTime;
    private final String coverImg;
    private final String createBy;
    private final String createId;
    private final String createTime;
    private final List<ActiveEnrollSubBean> enrollSubList;
    private final int enrollType;
    private final String id;
    private final List<ActiveRangeBean> rangeList;
    private final String registerEndTime;
    private final String registerStartTime;
    private final String schoolId;
    private final String selectedNodesInfo;
    private final int status;
    private final String statusName;
    private final int subType;
    private final int total;
    private final int userCount;
    private final String userEnrollStatus;

    /* JADX INFO: compiled from: ActiveDetailsBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ActiveDetailsBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActiveDetailsBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            int i2 = 0;
            for (int i3 = 0; i3 != i; i3++) {
                arrayList.add(ActiveEnrollSubBean.CREATOR.createFromParcel(parcel));
            }
            ArrayList arrayList2 = arrayList;
            int i4 = parcel.readInt();
            String string10 = parcel.readString();
            int i5 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(i5);
            while (i2 != i5) {
                arrayList3.add(ActiveRangeBean.CREATOR.createFromParcel(parcel));
                i2++;
                i5 = i5;
            }
            return new ActiveDetailsBean(string, string2, string3, string4, string5, string6, string7, string8, string9, arrayList2, i4, string10, arrayList3, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ActiveDetailsBean[] newArray(int i) {
            return new ActiveDetailsBean[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getActivityEndTime() {
        return this.activityEndTime;
    }

    public final List<ActiveEnrollSubBean> component10() {
        return this.enrollSubList;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getEnrollType() {
        return this.enrollType;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final List<ActiveRangeBean> component13() {
        return this.rangeList;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getRegisterEndTime() {
        return this.registerEndTime;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getRegisterStartTime() {
        return this.registerStartTime;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getSelectedNodesInfo() {
        return this.selectedNodesInfo;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getStatusName() {
        return this.statusName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActivityIntroduction() {
        return this.activityIntroduction;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final int getSubType() {
        return this.subType;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final int getUserCount() {
        return this.userCount;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getUserEnrollStatus() {
        return this.userEnrollStatus;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getActivityRemarks() {
        return this.activityRemarks;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getActivityStartTime() {
        return this.activityStartTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCoverImg() {
        return this.coverImg;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCreateBy() {
        return this.createBy;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCreateId() {
        return this.createId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getCreateTime() {
        return this.createTime;
    }

    public final ActiveDetailsBean copy(String activityEndTime, String activityIntroduction, String activityName, String activityRemarks, String activityStartTime, String coverImg, String createBy, String createId, String createTime, List<ActiveEnrollSubBean> enrollSubList, int enrollType, String id, List<ActiveRangeBean> rangeList, String registerEndTime, String registerStartTime, String schoolId, String selectedNodesInfo, int status, String statusName, int subType, int total, int userCount, String userEnrollStatus) {
        Intrinsics.checkNotNullParameter(activityEndTime, "activityEndTime");
        Intrinsics.checkNotNullParameter(activityIntroduction, "activityIntroduction");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(activityRemarks, "activityRemarks");
        Intrinsics.checkNotNullParameter(activityStartTime, "activityStartTime");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(createId, "createId");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(enrollSubList, "enrollSubList");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(rangeList, "rangeList");
        Intrinsics.checkNotNullParameter(registerEndTime, "registerEndTime");
        Intrinsics.checkNotNullParameter(registerStartTime, "registerStartTime");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(selectedNodesInfo, "selectedNodesInfo");
        Intrinsics.checkNotNullParameter(statusName, "statusName");
        Intrinsics.checkNotNullParameter(userEnrollStatus, "userEnrollStatus");
        return new ActiveDetailsBean(activityEndTime, activityIntroduction, activityName, activityRemarks, activityStartTime, coverImg, createBy, createId, createTime, enrollSubList, enrollType, id, rangeList, registerEndTime, registerStartTime, schoolId, selectedNodesInfo, status, statusName, subType, total, userCount, userEnrollStatus);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveDetailsBean)) {
            return false;
        }
        ActiveDetailsBean activeDetailsBean = (ActiveDetailsBean) other;
        return Intrinsics.areEqual(this.activityEndTime, activeDetailsBean.activityEndTime) && Intrinsics.areEqual(this.activityIntroduction, activeDetailsBean.activityIntroduction) && Intrinsics.areEqual(this.activityName, activeDetailsBean.activityName) && Intrinsics.areEqual(this.activityRemarks, activeDetailsBean.activityRemarks) && Intrinsics.areEqual(this.activityStartTime, activeDetailsBean.activityStartTime) && Intrinsics.areEqual(this.coverImg, activeDetailsBean.coverImg) && Intrinsics.areEqual(this.createBy, activeDetailsBean.createBy) && Intrinsics.areEqual(this.createId, activeDetailsBean.createId) && Intrinsics.areEqual(this.createTime, activeDetailsBean.createTime) && Intrinsics.areEqual(this.enrollSubList, activeDetailsBean.enrollSubList) && this.enrollType == activeDetailsBean.enrollType && Intrinsics.areEqual(this.id, activeDetailsBean.id) && Intrinsics.areEqual(this.rangeList, activeDetailsBean.rangeList) && Intrinsics.areEqual(this.registerEndTime, activeDetailsBean.registerEndTime) && Intrinsics.areEqual(this.registerStartTime, activeDetailsBean.registerStartTime) && Intrinsics.areEqual(this.schoolId, activeDetailsBean.schoolId) && Intrinsics.areEqual(this.selectedNodesInfo, activeDetailsBean.selectedNodesInfo) && this.status == activeDetailsBean.status && Intrinsics.areEqual(this.statusName, activeDetailsBean.statusName) && this.subType == activeDetailsBean.subType && this.total == activeDetailsBean.total && this.userCount == activeDetailsBean.userCount && Intrinsics.areEqual(this.userEnrollStatus, activeDetailsBean.userEnrollStatus);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((this.activityEndTime.hashCode() * 31) + this.activityIntroduction.hashCode()) * 31) + this.activityName.hashCode()) * 31) + this.activityRemarks.hashCode()) * 31) + this.activityStartTime.hashCode()) * 31) + this.coverImg.hashCode()) * 31) + this.createBy.hashCode()) * 31) + this.createId.hashCode()) * 31) + this.createTime.hashCode()) * 31) + this.enrollSubList.hashCode()) * 31) + this.enrollType) * 31) + this.id.hashCode()) * 31) + this.rangeList.hashCode()) * 31) + this.registerEndTime.hashCode()) * 31) + this.registerStartTime.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.selectedNodesInfo.hashCode()) * 31) + this.status) * 31) + this.statusName.hashCode()) * 31) + this.subType) * 31) + this.total) * 31) + this.userCount) * 31) + this.userEnrollStatus.hashCode();
    }

    public String toString() {
        return "ActiveDetailsBean(activityEndTime=" + this.activityEndTime + ", activityIntroduction=" + this.activityIntroduction + ", activityName=" + this.activityName + ", activityRemarks=" + this.activityRemarks + ", activityStartTime=" + this.activityStartTime + ", coverImg=" + this.coverImg + ", createBy=" + this.createBy + ", createId=" + this.createId + ", createTime=" + this.createTime + ", enrollSubList=" + this.enrollSubList + ", enrollType=" + this.enrollType + ", id=" + this.id + ", rangeList=" + this.rangeList + ", registerEndTime=" + this.registerEndTime + ", registerStartTime=" + this.registerStartTime + ", schoolId=" + this.schoolId + ", selectedNodesInfo=" + this.selectedNodesInfo + ", status=" + this.status + ", statusName=" + this.statusName + ", subType=" + this.subType + ", total=" + this.total + ", userCount=" + this.userCount + ", userEnrollStatus=" + this.userEnrollStatus + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.activityEndTime);
        parcel.writeString(this.activityIntroduction);
        parcel.writeString(this.activityName);
        parcel.writeString(this.activityRemarks);
        parcel.writeString(this.activityStartTime);
        parcel.writeString(this.coverImg);
        parcel.writeString(this.createBy);
        parcel.writeString(this.createId);
        parcel.writeString(this.createTime);
        List<ActiveEnrollSubBean> list = this.enrollSubList;
        parcel.writeInt(list.size());
        Iterator<ActiveEnrollSubBean> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.enrollType);
        parcel.writeString(this.id);
        List<ActiveRangeBean> list2 = this.rangeList;
        parcel.writeInt(list2.size());
        Iterator<ActiveRangeBean> it3 = list2.iterator();
        while (it3.hasNext()) {
            it3.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.registerEndTime);
        parcel.writeString(this.registerStartTime);
        parcel.writeString(this.schoolId);
        parcel.writeString(this.selectedNodesInfo);
        parcel.writeInt(this.status);
        parcel.writeString(this.statusName);
        parcel.writeInt(this.subType);
        parcel.writeInt(this.total);
        parcel.writeInt(this.userCount);
        parcel.writeString(this.userEnrollStatus);
    }

    public ActiveDetailsBean(String activityEndTime, String activityIntroduction, String activityName, String activityRemarks, String activityStartTime, String coverImg, String createBy, String createId, String createTime, List<ActiveEnrollSubBean> enrollSubList, int i, String id, List<ActiveRangeBean> rangeList, String registerEndTime, String registerStartTime, String schoolId, String selectedNodesInfo, int i2, String statusName, int i3, int i4, int i5, String userEnrollStatus) {
        Intrinsics.checkNotNullParameter(activityEndTime, "activityEndTime");
        Intrinsics.checkNotNullParameter(activityIntroduction, "activityIntroduction");
        Intrinsics.checkNotNullParameter(activityName, "activityName");
        Intrinsics.checkNotNullParameter(activityRemarks, "activityRemarks");
        Intrinsics.checkNotNullParameter(activityStartTime, "activityStartTime");
        Intrinsics.checkNotNullParameter(coverImg, "coverImg");
        Intrinsics.checkNotNullParameter(createBy, "createBy");
        Intrinsics.checkNotNullParameter(createId, "createId");
        Intrinsics.checkNotNullParameter(createTime, "createTime");
        Intrinsics.checkNotNullParameter(enrollSubList, "enrollSubList");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(rangeList, "rangeList");
        Intrinsics.checkNotNullParameter(registerEndTime, "registerEndTime");
        Intrinsics.checkNotNullParameter(registerStartTime, "registerStartTime");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(selectedNodesInfo, "selectedNodesInfo");
        Intrinsics.checkNotNullParameter(statusName, "statusName");
        Intrinsics.checkNotNullParameter(userEnrollStatus, "userEnrollStatus");
        this.activityEndTime = activityEndTime;
        this.activityIntroduction = activityIntroduction;
        this.activityName = activityName;
        this.activityRemarks = activityRemarks;
        this.activityStartTime = activityStartTime;
        this.coverImg = coverImg;
        this.createBy = createBy;
        this.createId = createId;
        this.createTime = createTime;
        this.enrollSubList = enrollSubList;
        this.enrollType = i;
        this.id = id;
        this.rangeList = rangeList;
        this.registerEndTime = registerEndTime;
        this.registerStartTime = registerStartTime;
        this.schoolId = schoolId;
        this.selectedNodesInfo = selectedNodesInfo;
        this.status = i2;
        this.statusName = statusName;
        this.subType = i3;
        this.total = i4;
        this.userCount = i5;
        this.userEnrollStatus = userEnrollStatus;
    }

    public final String getActivityEndTime() {
        return this.activityEndTime;
    }

    public final String getActivityIntroduction() {
        return this.activityIntroduction;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final String getActivityRemarks() {
        return this.activityRemarks;
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

    public final String getCreateId() {
        return this.createId;
    }

    public final String getCreateTime() {
        return this.createTime;
    }

    public final List<ActiveEnrollSubBean> getEnrollSubList() {
        return this.enrollSubList;
    }

    public final int getEnrollType() {
        return this.enrollType;
    }

    public final String getId() {
        return this.id;
    }

    public final List<ActiveRangeBean> getRangeList() {
        return this.rangeList;
    }

    public final String getRegisterEndTime() {
        return this.registerEndTime;
    }

    public final String getRegisterStartTime() {
        return this.registerStartTime;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getSelectedNodesInfo() {
        return this.selectedNodesInfo;
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

    public final int getUserCount() {
        return this.userCount;
    }

    public final String getUserEnrollStatus() {
        return this.userEnrollStatus;
    }
}
