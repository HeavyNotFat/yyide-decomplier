package com.yd.android_brand_mvp.landscape.moraleducation.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecondIndicatorModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jw\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006-"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/model/SecondIndicatorModel;", "", "mBasicScore", "", "mInitializeScore", "mMinScoreUnit", "mScoreRange", "mScoreRangeMax", "mScoreRangeMin", "mScoreStandard", "mScoreStandardId", "mSecondIndicatorId", "mSecondIndicatorName", "mSort", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMBasicScore", "()Ljava/lang/String;", "getMInitializeScore", "getMMinScoreUnit", "getMScoreRange", "getMScoreRangeMax", "getMScoreRangeMin", "getMScoreStandard", "getMScoreStandardId", "getMSecondIndicatorId", "getMSecondIndicatorName", "getMSort", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SecondIndicatorModel {

    @SerializedName("basicScore")
    private final String mBasicScore;

    @SerializedName("initializeScore")
    private final String mInitializeScore;

    @SerializedName("minScoreUnit")
    private final String mMinScoreUnit;

    @SerializedName("scoreRange")
    private final String mScoreRange;

    @SerializedName("scoreRangeMax")
    private final String mScoreRangeMax;

    @SerializedName("scoreRangeMin")
    private final String mScoreRangeMin;

    @SerializedName("scoreStandard")
    private final String mScoreStandard;

    @SerializedName("scoreStandardId")
    private final String mScoreStandardId;

    @SerializedName("secondIndicatorId")
    private final String mSecondIndicatorId;

    @SerializedName("secondIndicatorName")
    private final String mSecondIndicatorName;

    @SerializedName("sort")
    private final String mSort;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMBasicScore() {
        return this.mBasicScore;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getMSecondIndicatorName() {
        return this.mSecondIndicatorName;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getMSort() {
        return this.mSort;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMInitializeScore() {
        return this.mInitializeScore;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMMinScoreUnit() {
        return this.mMinScoreUnit;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getMScoreRange() {
        return this.mScoreRange;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getMScoreRangeMax() {
        return this.mScoreRangeMax;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMScoreRangeMin() {
        return this.mScoreRangeMin;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMScoreStandard() {
        return this.mScoreStandard;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMScoreStandardId() {
        return this.mScoreStandardId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getMSecondIndicatorId() {
        return this.mSecondIndicatorId;
    }

    public final SecondIndicatorModel copy(String mBasicScore, String mInitializeScore, String mMinScoreUnit, String mScoreRange, String mScoreRangeMax, String mScoreRangeMin, String mScoreStandard, String mScoreStandardId, String mSecondIndicatorId, String mSecondIndicatorName, String mSort) {
        Intrinsics.checkNotNullParameter(mBasicScore, "mBasicScore");
        Intrinsics.checkNotNullParameter(mInitializeScore, "mInitializeScore");
        Intrinsics.checkNotNullParameter(mMinScoreUnit, "mMinScoreUnit");
        Intrinsics.checkNotNullParameter(mScoreRange, "mScoreRange");
        Intrinsics.checkNotNullParameter(mScoreRangeMax, "mScoreRangeMax");
        Intrinsics.checkNotNullParameter(mScoreRangeMin, "mScoreRangeMin");
        Intrinsics.checkNotNullParameter(mScoreStandard, "mScoreStandard");
        Intrinsics.checkNotNullParameter(mScoreStandardId, "mScoreStandardId");
        Intrinsics.checkNotNullParameter(mSecondIndicatorId, "mSecondIndicatorId");
        Intrinsics.checkNotNullParameter(mSecondIndicatorName, "mSecondIndicatorName");
        Intrinsics.checkNotNullParameter(mSort, "mSort");
        return new SecondIndicatorModel(mBasicScore, mInitializeScore, mMinScoreUnit, mScoreRange, mScoreRangeMax, mScoreRangeMin, mScoreStandard, mScoreStandardId, mSecondIndicatorId, mSecondIndicatorName, mSort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SecondIndicatorModel)) {
            return false;
        }
        SecondIndicatorModel secondIndicatorModel = (SecondIndicatorModel) other;
        return Intrinsics.areEqual(this.mBasicScore, secondIndicatorModel.mBasicScore) && Intrinsics.areEqual(this.mInitializeScore, secondIndicatorModel.mInitializeScore) && Intrinsics.areEqual(this.mMinScoreUnit, secondIndicatorModel.mMinScoreUnit) && Intrinsics.areEqual(this.mScoreRange, secondIndicatorModel.mScoreRange) && Intrinsics.areEqual(this.mScoreRangeMax, secondIndicatorModel.mScoreRangeMax) && Intrinsics.areEqual(this.mScoreRangeMin, secondIndicatorModel.mScoreRangeMin) && Intrinsics.areEqual(this.mScoreStandard, secondIndicatorModel.mScoreStandard) && Intrinsics.areEqual(this.mScoreStandardId, secondIndicatorModel.mScoreStandardId) && Intrinsics.areEqual(this.mSecondIndicatorId, secondIndicatorModel.mSecondIndicatorId) && Intrinsics.areEqual(this.mSecondIndicatorName, secondIndicatorModel.mSecondIndicatorName) && Intrinsics.areEqual(this.mSort, secondIndicatorModel.mSort);
    }

    public int hashCode() {
        return (((((((((((((((((((this.mBasicScore.hashCode() * 31) + this.mInitializeScore.hashCode()) * 31) + this.mMinScoreUnit.hashCode()) * 31) + this.mScoreRange.hashCode()) * 31) + this.mScoreRangeMax.hashCode()) * 31) + this.mScoreRangeMin.hashCode()) * 31) + this.mScoreStandard.hashCode()) * 31) + this.mScoreStandardId.hashCode()) * 31) + this.mSecondIndicatorId.hashCode()) * 31) + this.mSecondIndicatorName.hashCode()) * 31) + this.mSort.hashCode();
    }

    public String toString() {
        return "SecondIndicatorModel(mBasicScore=" + this.mBasicScore + ", mInitializeScore=" + this.mInitializeScore + ", mMinScoreUnit=" + this.mMinScoreUnit + ", mScoreRange=" + this.mScoreRange + ", mScoreRangeMax=" + this.mScoreRangeMax + ", mScoreRangeMin=" + this.mScoreRangeMin + ", mScoreStandard=" + this.mScoreStandard + ", mScoreStandardId=" + this.mScoreStandardId + ", mSecondIndicatorId=" + this.mSecondIndicatorId + ", mSecondIndicatorName=" + this.mSecondIndicatorName + ", mSort=" + this.mSort + ')';
    }

    public SecondIndicatorModel(String mBasicScore, String mInitializeScore, String mMinScoreUnit, String mScoreRange, String mScoreRangeMax, String mScoreRangeMin, String mScoreStandard, String mScoreStandardId, String mSecondIndicatorId, String mSecondIndicatorName, String mSort) {
        Intrinsics.checkNotNullParameter(mBasicScore, "mBasicScore");
        Intrinsics.checkNotNullParameter(mInitializeScore, "mInitializeScore");
        Intrinsics.checkNotNullParameter(mMinScoreUnit, "mMinScoreUnit");
        Intrinsics.checkNotNullParameter(mScoreRange, "mScoreRange");
        Intrinsics.checkNotNullParameter(mScoreRangeMax, "mScoreRangeMax");
        Intrinsics.checkNotNullParameter(mScoreRangeMin, "mScoreRangeMin");
        Intrinsics.checkNotNullParameter(mScoreStandard, "mScoreStandard");
        Intrinsics.checkNotNullParameter(mScoreStandardId, "mScoreStandardId");
        Intrinsics.checkNotNullParameter(mSecondIndicatorId, "mSecondIndicatorId");
        Intrinsics.checkNotNullParameter(mSecondIndicatorName, "mSecondIndicatorName");
        Intrinsics.checkNotNullParameter(mSort, "mSort");
        this.mBasicScore = mBasicScore;
        this.mInitializeScore = mInitializeScore;
        this.mMinScoreUnit = mMinScoreUnit;
        this.mScoreRange = mScoreRange;
        this.mScoreRangeMax = mScoreRangeMax;
        this.mScoreRangeMin = mScoreRangeMin;
        this.mScoreStandard = mScoreStandard;
        this.mScoreStandardId = mScoreStandardId;
        this.mSecondIndicatorId = mSecondIndicatorId;
        this.mSecondIndicatorName = mSecondIndicatorName;
        this.mSort = mSort;
    }

    public final String getMBasicScore() {
        return this.mBasicScore;
    }

    public final String getMInitializeScore() {
        return this.mInitializeScore;
    }

    public final String getMMinScoreUnit() {
        return this.mMinScoreUnit;
    }

    public final String getMScoreRange() {
        return this.mScoreRange;
    }

    public final String getMScoreRangeMax() {
        return this.mScoreRangeMax;
    }

    public final String getMScoreRangeMin() {
        return this.mScoreRangeMin;
    }

    public final String getMScoreStandard() {
        return this.mScoreStandard;
    }

    public final String getMScoreStandardId() {
        return this.mScoreStandardId;
    }

    public final String getMSecondIndicatorId() {
        return this.mSecondIndicatorId;
    }

    public final String getMSecondIndicatorName() {
        return this.mSecondIndicatorName;
    }

    public final String getMSort() {
        return this.mSort;
    }
}
