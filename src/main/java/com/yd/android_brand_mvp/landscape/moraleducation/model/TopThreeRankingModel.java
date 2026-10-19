package com.yd.android_brand_mvp.landscape.moraleducation.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TopThreeRankingModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/landscape/moraleducation/model/TopThreeRankingModel;", "", "mAvatar", "", "mClassName", "mScore", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getMAvatar", "()Ljava/lang/String;", "getMClassName", "getMScore", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TopThreeRankingModel {
    private final String mAvatar;
    private final String mClassName;
    private final String mScore;

    public static /* synthetic */ TopThreeRankingModel copy$default(TopThreeRankingModel topThreeRankingModel, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = topThreeRankingModel.mAvatar;
        }
        if ((i & 2) != 0) {
            str2 = topThreeRankingModel.mClassName;
        }
        if ((i & 4) != 0) {
            str3 = topThreeRankingModel.mScore;
        }
        return topThreeRankingModel.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getMAvatar() {
        return this.mAvatar;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getMClassName() {
        return this.mClassName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMScore() {
        return this.mScore;
    }

    public final TopThreeRankingModel copy(String mAvatar, String mClassName, String mScore) {
        Intrinsics.checkNotNullParameter(mAvatar, "mAvatar");
        Intrinsics.checkNotNullParameter(mClassName, "mClassName");
        Intrinsics.checkNotNullParameter(mScore, "mScore");
        return new TopThreeRankingModel(mAvatar, mClassName, mScore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TopThreeRankingModel)) {
            return false;
        }
        TopThreeRankingModel topThreeRankingModel = (TopThreeRankingModel) other;
        return Intrinsics.areEqual(this.mAvatar, topThreeRankingModel.mAvatar) && Intrinsics.areEqual(this.mClassName, topThreeRankingModel.mClassName) && Intrinsics.areEqual(this.mScore, topThreeRankingModel.mScore);
    }

    public int hashCode() {
        return (((this.mAvatar.hashCode() * 31) + this.mClassName.hashCode()) * 31) + this.mScore.hashCode();
    }

    public String toString() {
        return "TopThreeRankingModel(mAvatar=" + this.mAvatar + ", mClassName=" + this.mClassName + ", mScore=" + this.mScore + ')';
    }

    public TopThreeRankingModel(String mAvatar, String mClassName, String mScore) {
        Intrinsics.checkNotNullParameter(mAvatar, "mAvatar");
        Intrinsics.checkNotNullParameter(mClassName, "mClassName");
        Intrinsics.checkNotNullParameter(mScore, "mScore");
        this.mAvatar = mAvatar;
        this.mClassName = mClassName;
        this.mScore = mScore;
    }

    public final String getMAvatar() {
        return this.mAvatar;
    }

    public final String getMClassName() {
        return this.mClassName;
    }

    public final String getMScore() {
        return this.mScore;
    }
}
