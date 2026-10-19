package com.yd.android_brand_mvp.model.evaluation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationPointCardCancelBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointCardCancelBean;", "", "countWriteOffCard", "", "countWriteOffScore", "(Ljava/lang/String;Ljava/lang/String;)V", "getCountWriteOffCard", "()Ljava/lang/String;", "getCountWriteOffScore", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EvaluationPointCardCancelBean {
    private final String countWriteOffCard;
    private final String countWriteOffScore;

    public static /* synthetic */ EvaluationPointCardCancelBean copy$default(EvaluationPointCardCancelBean evaluationPointCardCancelBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = evaluationPointCardCancelBean.countWriteOffCard;
        }
        if ((i & 2) != 0) {
            str2 = evaluationPointCardCancelBean.countWriteOffScore;
        }
        return evaluationPointCardCancelBean.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCountWriteOffCard() {
        return this.countWriteOffCard;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCountWriteOffScore() {
        return this.countWriteOffScore;
    }

    public final EvaluationPointCardCancelBean copy(String countWriteOffCard, String countWriteOffScore) {
        Intrinsics.checkNotNullParameter(countWriteOffCard, "countWriteOffCard");
        Intrinsics.checkNotNullParameter(countWriteOffScore, "countWriteOffScore");
        return new EvaluationPointCardCancelBean(countWriteOffCard, countWriteOffScore);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvaluationPointCardCancelBean)) {
            return false;
        }
        EvaluationPointCardCancelBean evaluationPointCardCancelBean = (EvaluationPointCardCancelBean) other;
        return Intrinsics.areEqual(this.countWriteOffCard, evaluationPointCardCancelBean.countWriteOffCard) && Intrinsics.areEqual(this.countWriteOffScore, evaluationPointCardCancelBean.countWriteOffScore);
    }

    public int hashCode() {
        return (this.countWriteOffCard.hashCode() * 31) + this.countWriteOffScore.hashCode();
    }

    public String toString() {
        return "EvaluationPointCardCancelBean(countWriteOffCard=" + this.countWriteOffCard + ", countWriteOffScore=" + this.countWriteOffScore + ')';
    }

    public EvaluationPointCardCancelBean(String countWriteOffCard, String countWriteOffScore) {
        Intrinsics.checkNotNullParameter(countWriteOffCard, "countWriteOffCard");
        Intrinsics.checkNotNullParameter(countWriteOffScore, "countWriteOffScore");
        this.countWriteOffCard = countWriteOffCard;
        this.countWriteOffScore = countWriteOffScore;
    }

    public final String getCountWriteOffCard() {
        return this.countWriteOffCard;
    }

    public final String getCountWriteOffScore() {
        return this.countWriteOffScore;
    }
}
