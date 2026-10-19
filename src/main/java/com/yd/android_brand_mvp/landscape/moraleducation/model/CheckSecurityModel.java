package com.yd.android_brand_mvp.landscape.moraleducation.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CheckSecurityModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020\u00052\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/model/CheckSecurityModel;", "", "mActivityId", "", "mCanScore", "", "mCycleId", "mFromGroupId", "mFromPersonId", "mSchoolId", "mToObjId", "mToObjName", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMActivityId", "()Ljava/lang/String;", "getMCanScore", "()Z", "getMCycleId", "getMFromGroupId", "getMFromPersonId", "getMSchoolId", "getMToObjId", "getMToObjName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CheckSecurityModel {

    @SerializedName("activityId")
    private final String mActivityId;

    @SerializedName("canScore")
    private final boolean mCanScore;

    @SerializedName("cycleId")
    private final String mCycleId;

    @SerializedName("fromGroupId")
    private final String mFromGroupId;

    @SerializedName("fromPersonId")
    private final String mFromPersonId;

    @SerializedName("schoolId")
    private final String mSchoolId;

    @SerializedName("toObjId")
    private final String mToObjId;

    @SerializedName("toObjName")
    private final String mToObjName;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMActivityId() {
        return this.mActivityId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getMCanScore() {
        return this.mCanScore;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMCycleId() {
        return this.mCycleId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMFromGroupId() {
        return this.mFromGroupId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMFromPersonId() {
        return this.mFromPersonId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMSchoolId() {
        return this.mSchoolId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMToObjId() {
        return this.mToObjId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMToObjName() {
        return this.mToObjName;
    }

    public final CheckSecurityModel copy(String mActivityId, boolean mCanScore, String mCycleId, String mFromGroupId, String mFromPersonId, String mSchoolId, String mToObjId, String mToObjName) {
        Intrinsics.checkNotNullParameter(mActivityId, "mActivityId");
        Intrinsics.checkNotNullParameter(mCycleId, "mCycleId");
        Intrinsics.checkNotNullParameter(mFromGroupId, "mFromGroupId");
        Intrinsics.checkNotNullParameter(mFromPersonId, "mFromPersonId");
        Intrinsics.checkNotNullParameter(mSchoolId, "mSchoolId");
        Intrinsics.checkNotNullParameter(mToObjId, "mToObjId");
        Intrinsics.checkNotNullParameter(mToObjName, "mToObjName");
        return new CheckSecurityModel(mActivityId, mCanScore, mCycleId, mFromGroupId, mFromPersonId, mSchoolId, mToObjId, mToObjName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckSecurityModel)) {
            return false;
        }
        CheckSecurityModel checkSecurityModel = (CheckSecurityModel) other;
        return Intrinsics.areEqual(this.mActivityId, checkSecurityModel.mActivityId) && this.mCanScore == checkSecurityModel.mCanScore && Intrinsics.areEqual(this.mCycleId, checkSecurityModel.mCycleId) && Intrinsics.areEqual(this.mFromGroupId, checkSecurityModel.mFromGroupId) && Intrinsics.areEqual(this.mFromPersonId, checkSecurityModel.mFromPersonId) && Intrinsics.areEqual(this.mSchoolId, checkSecurityModel.mSchoolId) && Intrinsics.areEqual(this.mToObjId, checkSecurityModel.mToObjId) && Intrinsics.areEqual(this.mToObjName, checkSecurityModel.mToObjName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    public int hashCode() {
        int iHashCode = this.mActivityId.hashCode() * 31;
        boolean z = this.mCanScore;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((((((((iHashCode + r1) * 31) + this.mCycleId.hashCode()) * 31) + this.mFromGroupId.hashCode()) * 31) + this.mFromPersonId.hashCode()) * 31) + this.mSchoolId.hashCode()) * 31) + this.mToObjId.hashCode()) * 31) + this.mToObjName.hashCode();
    }

    public String toString() {
        return "CheckSecurityModel(mActivityId=" + this.mActivityId + ", mCanScore=" + this.mCanScore + ", mCycleId=" + this.mCycleId + ", mFromGroupId=" + this.mFromGroupId + ", mFromPersonId=" + this.mFromPersonId + ", mSchoolId=" + this.mSchoolId + ", mToObjId=" + this.mToObjId + ", mToObjName=" + this.mToObjName + ')';
    }

    public CheckSecurityModel(String mActivityId, boolean z, String mCycleId, String mFromGroupId, String mFromPersonId, String mSchoolId, String mToObjId, String mToObjName) {
        Intrinsics.checkNotNullParameter(mActivityId, "mActivityId");
        Intrinsics.checkNotNullParameter(mCycleId, "mCycleId");
        Intrinsics.checkNotNullParameter(mFromGroupId, "mFromGroupId");
        Intrinsics.checkNotNullParameter(mFromPersonId, "mFromPersonId");
        Intrinsics.checkNotNullParameter(mSchoolId, "mSchoolId");
        Intrinsics.checkNotNullParameter(mToObjId, "mToObjId");
        Intrinsics.checkNotNullParameter(mToObjName, "mToObjName");
        this.mActivityId = mActivityId;
        this.mCanScore = z;
        this.mCycleId = mCycleId;
        this.mFromGroupId = mFromGroupId;
        this.mFromPersonId = mFromPersonId;
        this.mSchoolId = mSchoolId;
        this.mToObjId = mToObjId;
        this.mToObjName = mToObjName;
    }

    public final String getMActivityId() {
        return this.mActivityId;
    }

    public final boolean getMCanScore() {
        return this.mCanScore;
    }

    public final String getMCycleId() {
        return this.mCycleId;
    }

    public final String getMFromGroupId() {
        return this.mFromGroupId;
    }

    public final String getMFromPersonId() {
        return this.mFromPersonId;
    }

    public final String getMSchoolId() {
        return this.mSchoolId;
    }

    public final String getMToObjId() {
        return this.mToObjId;
    }

    public final String getMToObjName() {
        return this.mToObjName;
    }
}
