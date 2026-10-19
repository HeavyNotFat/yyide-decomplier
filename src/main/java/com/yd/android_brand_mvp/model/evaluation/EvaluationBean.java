package com.yd.android_brand_mvp.model.evaluation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/yd/android_brand_mvp/model/evaluation/EvaluationBean;", "", "classId", "", "countMedal", "", "countScoreCard", "parentId", "parentName", "sort", "totalScore", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getClassId", "()Ljava/lang/String;", "getCountMedal", "()I", "getCountScoreCard", "getParentId", "getParentName", "getSort", "getTotalScore", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EvaluationBean {
    private final String classId;
    private final int countMedal;
    private final int countScoreCard;
    private final String parentId;
    private final String parentName;
    private final int sort;
    private final String totalScore;

    public static /* synthetic */ EvaluationBean copy$default(EvaluationBean evaluationBean, String str, int i, int i2, String str2, String str3, int i3, String str4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = evaluationBean.classId;
        }
        if ((i4 & 2) != 0) {
            i = evaluationBean.countMedal;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = evaluationBean.countScoreCard;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            str2 = evaluationBean.parentId;
        }
        String str5 = str2;
        if ((i4 & 16) != 0) {
            str3 = evaluationBean.parentName;
        }
        String str6 = str3;
        if ((i4 & 32) != 0) {
            i3 = evaluationBean.sort;
        }
        int i7 = i3;
        if ((i4 & 64) != 0) {
            str4 = evaluationBean.totalScore;
        }
        return evaluationBean.copy(str, i5, i6, str5, str6, i7, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClassId() {
        return this.classId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getCountMedal() {
        return this.countMedal;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCountScoreCard() {
        return this.countScoreCard;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getParentId() {
        return this.parentId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getParentName() {
        return this.parentName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTotalScore() {
        return this.totalScore;
    }

    public final EvaluationBean copy(String classId, int countMedal, int countScoreCard, String parentId, String parentName, int sort, String totalScore) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(totalScore, "totalScore");
        return new EvaluationBean(classId, countMedal, countScoreCard, parentId, parentName, sort, totalScore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvaluationBean)) {
            return false;
        }
        EvaluationBean evaluationBean = (EvaluationBean) other;
        return Intrinsics.areEqual(this.classId, evaluationBean.classId) && this.countMedal == evaluationBean.countMedal && this.countScoreCard == evaluationBean.countScoreCard && Intrinsics.areEqual(this.parentId, evaluationBean.parentId) && Intrinsics.areEqual(this.parentName, evaluationBean.parentName) && this.sort == evaluationBean.sort && Intrinsics.areEqual(this.totalScore, evaluationBean.totalScore);
    }

    public int hashCode() {
        return (((((((((((this.classId.hashCode() * 31) + this.countMedal) * 31) + this.countScoreCard) * 31) + this.parentId.hashCode()) * 31) + this.parentName.hashCode()) * 31) + this.sort) * 31) + this.totalScore.hashCode();
    }

    public String toString() {
        return "EvaluationBean(classId=" + this.classId + ", countMedal=" + this.countMedal + ", countScoreCard=" + this.countScoreCard + ", parentId=" + this.parentId + ", parentName=" + this.parentName + ", sort=" + this.sort + ", totalScore=" + this.totalScore + ')';
    }

    public EvaluationBean(String classId, int i, int i2, String parentId, String parentName, int i3, String totalScore) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(parentId, "parentId");
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(totalScore, "totalScore");
        this.classId = classId;
        this.countMedal = i;
        this.countScoreCard = i2;
        this.parentId = parentId;
        this.parentName = parentName;
        this.sort = i3;
        this.totalScore = totalScore;
    }

    public final String getClassId() {
        return this.classId;
    }

    public final int getCountMedal() {
        return this.countMedal;
    }

    public final int getCountScoreCard() {
        return this.countScoreCard;
    }

    public final String getParentId() {
        return this.parentId;
    }

    public final String getParentName() {
        return this.parentName;
    }

    public final int getSort() {
        return this.sort;
    }

    public final String getTotalScore() {
        return this.totalScore;
    }
}
