package com.yd.android_brand_mvp.model.evaluation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EvaluationMedalTypeBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/model/evaluation/EvaluationMedalTypeBean;", "", "evalTypeId", "", "evalTypeName", "(Ljava/lang/String;Ljava/lang/String;)V", "getEvalTypeId", "()Ljava/lang/String;", "getEvalTypeName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class EvaluationMedalTypeBean {
    private final String evalTypeId;
    private final String evalTypeName;

    public static /* synthetic */ EvaluationMedalTypeBean copy$default(EvaluationMedalTypeBean evaluationMedalTypeBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = evaluationMedalTypeBean.evalTypeId;
        }
        if ((i & 2) != 0) {
            str2 = evaluationMedalTypeBean.evalTypeName;
        }
        return evaluationMedalTypeBean.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getEvalTypeId() {
        return this.evalTypeId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEvalTypeName() {
        return this.evalTypeName;
    }

    public final EvaluationMedalTypeBean copy(String evalTypeId, String evalTypeName) {
        Intrinsics.checkNotNullParameter(evalTypeId, "evalTypeId");
        Intrinsics.checkNotNullParameter(evalTypeName, "evalTypeName");
        return new EvaluationMedalTypeBean(evalTypeId, evalTypeName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvaluationMedalTypeBean)) {
            return false;
        }
        EvaluationMedalTypeBean evaluationMedalTypeBean = (EvaluationMedalTypeBean) other;
        return Intrinsics.areEqual(this.evalTypeId, evaluationMedalTypeBean.evalTypeId) && Intrinsics.areEqual(this.evalTypeName, evaluationMedalTypeBean.evalTypeName);
    }

    public int hashCode() {
        return (this.evalTypeId.hashCode() * 31) + this.evalTypeName.hashCode();
    }

    public String toString() {
        return "EvaluationMedalTypeBean(evalTypeId=" + this.evalTypeId + ", evalTypeName=" + this.evalTypeName + ')';
    }

    public EvaluationMedalTypeBean(String evalTypeId, String evalTypeName) {
        Intrinsics.checkNotNullParameter(evalTypeId, "evalTypeId");
        Intrinsics.checkNotNullParameter(evalTypeName, "evalTypeName");
        this.evalTypeId = evalTypeId;
        this.evalTypeName = evalTypeName;
    }

    public final String getEvalTypeId() {
        return this.evalTypeId;
    }

    public final String getEvalTypeName() {
        return this.evalTypeName;
    }
}
