package com.yd.android_brand_mvp.landscape.moraleducation.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppraisalScoreParamModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u001a\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rHÆ\u0003J{\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u001c\b\u0002\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\rHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R%\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006("}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/model/AppraisalScoreParamModel;", "", "schoolId", "", "activityId", "cycleId", "fromGroupId", "fromPersonId", "toObjId", "toObjName", "detailList", "Ljava/util/ArrayList;", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/SubAppraisalScoreParamModel;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V", "getActivityId", "()Ljava/lang/String;", "getCycleId", "getDetailList", "()Ljava/util/ArrayList;", "getFromGroupId", "getFromPersonId", "getSchoolId", "getToObjId", "getToObjName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AppraisalScoreParamModel {
    private final String activityId;
    private final String cycleId;
    private final ArrayList<SubAppraisalScoreParamModel> detailList;
    private final String fromGroupId;
    private final String fromPersonId;
    private final String schoolId;
    private final String toObjId;
    private final String toObjName;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCycleId() {
        return this.cycleId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFromGroupId() {
        return this.fromGroupId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getFromPersonId() {
        return this.fromPersonId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getToObjId() {
        return this.toObjId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getToObjName() {
        return this.toObjName;
    }

    public final ArrayList<SubAppraisalScoreParamModel> component8() {
        return this.detailList;
    }

    public final AppraisalScoreParamModel copy(String schoolId, String activityId, String cycleId, String fromGroupId, String fromPersonId, String toObjId, String toObjName, ArrayList<SubAppraisalScoreParamModel> detailList) {
        return new AppraisalScoreParamModel(schoolId, activityId, cycleId, fromGroupId, fromPersonId, toObjId, toObjName, detailList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppraisalScoreParamModel)) {
            return false;
        }
        AppraisalScoreParamModel appraisalScoreParamModel = (AppraisalScoreParamModel) other;
        return Intrinsics.areEqual(this.schoolId, appraisalScoreParamModel.schoolId) && Intrinsics.areEqual(this.activityId, appraisalScoreParamModel.activityId) && Intrinsics.areEqual(this.cycleId, appraisalScoreParamModel.cycleId) && Intrinsics.areEqual(this.fromGroupId, appraisalScoreParamModel.fromGroupId) && Intrinsics.areEqual(this.fromPersonId, appraisalScoreParamModel.fromPersonId) && Intrinsics.areEqual(this.toObjId, appraisalScoreParamModel.toObjId) && Intrinsics.areEqual(this.toObjName, appraisalScoreParamModel.toObjName) && Intrinsics.areEqual(this.detailList, appraisalScoreParamModel.detailList);
    }

    public int hashCode() {
        String str = this.schoolId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.activityId;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cycleId;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.fromGroupId;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.fromPersonId;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.toObjId;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.toObjName;
        int iHashCode7 = (iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        ArrayList<SubAppraisalScoreParamModel> arrayList = this.detailList;
        return iHashCode7 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public String toString() {
        return "AppraisalScoreParamModel(schoolId=" + this.schoolId + ", activityId=" + this.activityId + ", cycleId=" + this.cycleId + ", fromGroupId=" + this.fromGroupId + ", fromPersonId=" + this.fromPersonId + ", toObjId=" + this.toObjId + ", toObjName=" + this.toObjName + ", detailList=" + this.detailList + ')';
    }

    public AppraisalScoreParamModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, ArrayList<SubAppraisalScoreParamModel> arrayList) {
        this.schoolId = str;
        this.activityId = str2;
        this.cycleId = str3;
        this.fromGroupId = str4;
        this.fromPersonId = str5;
        this.toObjId = str6;
        this.toObjName = str7;
        this.detailList = arrayList;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final String getCycleId() {
        return this.cycleId;
    }

    public final String getFromGroupId() {
        return this.fromGroupId;
    }

    public final String getFromPersonId() {
        return this.fromPersonId;
    }

    public final String getToObjId() {
        return this.toObjId;
    }

    public final String getToObjName() {
        return this.toObjName;
    }

    public final ArrayList<SubAppraisalScoreParamModel> getDetailList() {
        return this.detailList;
    }
}
