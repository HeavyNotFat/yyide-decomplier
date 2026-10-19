package com.yd.android_brand_mvp.landscape.moraleducation.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IndexClassMEModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e¢\u0006\u0002\u0010\u0015J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0011\u00106\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eHÆ\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eHÆ\u0003JÈ\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e2\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\f\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001cR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0017R\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\"¨\u0006@"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/model/IndexClassMEModel;", "", "mActivityId", "", "mCurrentObj", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "mPromotionalImage", "mCycle", "mCycleId", "", "mLastCycleCurrentObj", "Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CycleCurrentMEModel;", "mLastCycleId", "mLastCycleResultList", "", "mResultList", "mSchoolId", "mLastTimeRange", "mTimeRange", "mTitle", "mWinPrizeList", "(Ljava/lang/String;Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CycleCurrentMEModel;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getMActivityId", "()Ljava/lang/String;", "getMCurrentObj", "()Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;", "getMCycle", "getMCycleId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMLastCycleCurrentObj", "()Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CycleCurrentMEModel;", "getMLastCycleId", "getMLastCycleResultList", "()Ljava/util/List;", "getMLastTimeRange", "getMPromotionalImage", "getMResultList", "getMSchoolId", "getMTimeRange", "getMTitle", "getMWinPrizeList", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CurrentMEModel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CycleCurrentMEModel;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/yd/android_brand_mvp/landscape/moraleducation/model/IndexClassMEModel;", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class IndexClassMEModel {

    @SerializedName("activityId")
    private final String mActivityId;

    @SerializedName("currentObj")
    private final CurrentMEModel mCurrentObj;

    @SerializedName("cycle")
    private final String mCycle;

    @SerializedName("cycleId")
    private final Long mCycleId;

    @SerializedName("lastCycleCurrentObj")
    private final CycleCurrentMEModel mLastCycleCurrentObj;

    @SerializedName("lastCycleId")
    private final Long mLastCycleId;

    @SerializedName("lastCycleResultList")
    private final List<CycleCurrentMEModel> mLastCycleResultList;

    @SerializedName("lastTimeRange")
    private final String mLastTimeRange;

    @SerializedName("promotionalImage")
    private final String mPromotionalImage;

    @SerializedName("resultList")
    private final List<CycleCurrentMEModel> mResultList;

    @SerializedName("schoolId")
    private final String mSchoolId;

    @SerializedName("timeRange")
    private final String mTimeRange;

    @SerializedName("title")
    private final String mTitle;

    @SerializedName("winPrizeList")
    private final List<CurrentMEModel> mWinPrizeList;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMActivityId() {
        return this.mActivityId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getMSchoolId() {
        return this.mSchoolId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getMLastTimeRange() {
        return this.mLastTimeRange;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getMTimeRange() {
        return this.mTimeRange;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getMTitle() {
        return this.mTitle;
    }

    public final List<CurrentMEModel> component14() {
        return this.mWinPrizeList;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final CurrentMEModel getMCurrentObj() {
        return this.mCurrentObj;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMPromotionalImage() {
        return this.mPromotionalImage;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMCycle() {
        return this.mCycle;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Long getMCycleId() {
        return this.mCycleId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final CycleCurrentMEModel getMLastCycleCurrentObj() {
        return this.mLastCycleCurrentObj;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Long getMLastCycleId() {
        return this.mLastCycleId;
    }

    public final List<CycleCurrentMEModel> component8() {
        return this.mLastCycleResultList;
    }

    public final List<CycleCurrentMEModel> component9() {
        return this.mResultList;
    }

    public final IndexClassMEModel copy(String mActivityId, CurrentMEModel mCurrentObj, String mPromotionalImage, String mCycle, Long mCycleId, CycleCurrentMEModel mLastCycleCurrentObj, Long mLastCycleId, List<CycleCurrentMEModel> mLastCycleResultList, List<CycleCurrentMEModel> mResultList, String mSchoolId, String mLastTimeRange, String mTimeRange, String mTitle, List<CurrentMEModel> mWinPrizeList) {
        return new IndexClassMEModel(mActivityId, mCurrentObj, mPromotionalImage, mCycle, mCycleId, mLastCycleCurrentObj, mLastCycleId, mLastCycleResultList, mResultList, mSchoolId, mLastTimeRange, mTimeRange, mTitle, mWinPrizeList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IndexClassMEModel)) {
            return false;
        }
        IndexClassMEModel indexClassMEModel = (IndexClassMEModel) other;
        return Intrinsics.areEqual(this.mActivityId, indexClassMEModel.mActivityId) && Intrinsics.areEqual(this.mCurrentObj, indexClassMEModel.mCurrentObj) && Intrinsics.areEqual(this.mPromotionalImage, indexClassMEModel.mPromotionalImage) && Intrinsics.areEqual(this.mCycle, indexClassMEModel.mCycle) && Intrinsics.areEqual(this.mCycleId, indexClassMEModel.mCycleId) && Intrinsics.areEqual(this.mLastCycleCurrentObj, indexClassMEModel.mLastCycleCurrentObj) && Intrinsics.areEqual(this.mLastCycleId, indexClassMEModel.mLastCycleId) && Intrinsics.areEqual(this.mLastCycleResultList, indexClassMEModel.mLastCycleResultList) && Intrinsics.areEqual(this.mResultList, indexClassMEModel.mResultList) && Intrinsics.areEqual(this.mSchoolId, indexClassMEModel.mSchoolId) && Intrinsics.areEqual(this.mLastTimeRange, indexClassMEModel.mLastTimeRange) && Intrinsics.areEqual(this.mTimeRange, indexClassMEModel.mTimeRange) && Intrinsics.areEqual(this.mTitle, indexClassMEModel.mTitle) && Intrinsics.areEqual(this.mWinPrizeList, indexClassMEModel.mWinPrizeList);
    }

    public int hashCode() {
        String str = this.mActivityId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        CurrentMEModel currentMEModel = this.mCurrentObj;
        int iHashCode2 = (iHashCode + (currentMEModel == null ? 0 : currentMEModel.hashCode())) * 31;
        String str2 = this.mPromotionalImage;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mCycle;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Long l = this.mCycleId;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        CycleCurrentMEModel cycleCurrentMEModel = this.mLastCycleCurrentObj;
        int iHashCode6 = (iHashCode5 + (cycleCurrentMEModel == null ? 0 : cycleCurrentMEModel.hashCode())) * 31;
        Long l2 = this.mLastCycleId;
        int iHashCode7 = (iHashCode6 + (l2 == null ? 0 : l2.hashCode())) * 31;
        List<CycleCurrentMEModel> list = this.mLastCycleResultList;
        int iHashCode8 = (iHashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        List<CycleCurrentMEModel> list2 = this.mResultList;
        int iHashCode9 = (iHashCode8 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str4 = this.mSchoolId;
        int iHashCode10 = (iHashCode9 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mLastTimeRange;
        int iHashCode11 = (iHashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.mTimeRange;
        int iHashCode12 = (iHashCode11 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.mTitle;
        int iHashCode13 = (iHashCode12 + (str7 == null ? 0 : str7.hashCode())) * 31;
        List<CurrentMEModel> list3 = this.mWinPrizeList;
        return iHashCode13 + (list3 != null ? list3.hashCode() : 0);
    }

    public String toString() {
        return "IndexClassMEModel(mActivityId=" + this.mActivityId + ", mCurrentObj=" + this.mCurrentObj + ", mPromotionalImage=" + this.mPromotionalImage + ", mCycle=" + this.mCycle + ", mCycleId=" + this.mCycleId + ", mLastCycleCurrentObj=" + this.mLastCycleCurrentObj + ", mLastCycleId=" + this.mLastCycleId + ", mLastCycleResultList=" + this.mLastCycleResultList + ", mResultList=" + this.mResultList + ", mSchoolId=" + this.mSchoolId + ", mLastTimeRange=" + this.mLastTimeRange + ", mTimeRange=" + this.mTimeRange + ", mTitle=" + this.mTitle + ", mWinPrizeList=" + this.mWinPrizeList + ')';
    }

    public IndexClassMEModel(String str, CurrentMEModel currentMEModel, String str2, String str3, Long l, CycleCurrentMEModel cycleCurrentMEModel, Long l2, List<CycleCurrentMEModel> list, List<CycleCurrentMEModel> list2, String str4, String str5, String str6, String str7, List<CurrentMEModel> list3) {
        this.mActivityId = str;
        this.mCurrentObj = currentMEModel;
        this.mPromotionalImage = str2;
        this.mCycle = str3;
        this.mCycleId = l;
        this.mLastCycleCurrentObj = cycleCurrentMEModel;
        this.mLastCycleId = l2;
        this.mLastCycleResultList = list;
        this.mResultList = list2;
        this.mSchoolId = str4;
        this.mLastTimeRange = str5;
        this.mTimeRange = str6;
        this.mTitle = str7;
        this.mWinPrizeList = list3;
    }

    public final String getMActivityId() {
        return this.mActivityId;
    }

    public final CurrentMEModel getMCurrentObj() {
        return this.mCurrentObj;
    }

    public final String getMPromotionalImage() {
        return this.mPromotionalImage;
    }

    public final String getMCycle() {
        return this.mCycle;
    }

    public final Long getMCycleId() {
        return this.mCycleId;
    }

    public final CycleCurrentMEModel getMLastCycleCurrentObj() {
        return this.mLastCycleCurrentObj;
    }

    public final Long getMLastCycleId() {
        return this.mLastCycleId;
    }

    public final List<CycleCurrentMEModel> getMLastCycleResultList() {
        return this.mLastCycleResultList;
    }

    public final List<CycleCurrentMEModel> getMResultList() {
        return this.mResultList;
    }

    public final String getMSchoolId() {
        return this.mSchoolId;
    }

    public final String getMLastTimeRange() {
        return this.mLastTimeRange;
    }

    public final String getMTimeRange() {
        return this.mTimeRange;
    }

    public final String getMTitle() {
        return this.mTitle;
    }

    public final List<CurrentMEModel> getMWinPrizeList() {
        return this.mWinPrizeList;
    }
}
