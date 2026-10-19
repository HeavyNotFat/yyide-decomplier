package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorCommentResultBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/HonorCommentResultBean;", "", "resultList", "Lcom/yd/android_brand_mvp/model/honor/ResultList;", "scoringMethod", "", "(Lcom/yd/android_brand_mvp/model/honor/ResultList;I)V", "getResultList", "()Lcom/yd/android_brand_mvp/model/honor/ResultList;", "setResultList", "(Lcom/yd/android_brand_mvp/model/honor/ResultList;)V", "getScoringMethod", "()I", "setScoringMethod", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HonorCommentResultBean {
    private ResultList resultList;
    private int scoringMethod;

    public static /* synthetic */ HonorCommentResultBean copy$default(HonorCommentResultBean honorCommentResultBean, ResultList resultList, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            resultList = honorCommentResultBean.resultList;
        }
        if ((i2 & 2) != 0) {
            i = honorCommentResultBean.scoringMethod;
        }
        return honorCommentResultBean.copy(resultList, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ResultList getResultList() {
        return this.resultList;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getScoringMethod() {
        return this.scoringMethod;
    }

    public final HonorCommentResultBean copy(@JSONField(name = "resultList") ResultList resultList, @JSONField(name = "scoringMethod") int scoringMethod) {
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        return new HonorCommentResultBean(resultList, scoringMethod);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HonorCommentResultBean)) {
            return false;
        }
        HonorCommentResultBean honorCommentResultBean = (HonorCommentResultBean) other;
        return Intrinsics.areEqual(this.resultList, honorCommentResultBean.resultList) && this.scoringMethod == honorCommentResultBean.scoringMethod;
    }

    public int hashCode() {
        return (this.resultList.hashCode() * 31) + this.scoringMethod;
    }

    public String toString() {
        return "HonorCommentResultBean(resultList=" + this.resultList + ", scoringMethod=" + this.scoringMethod + ')';
    }

    public HonorCommentResultBean(@JSONField(name = "resultList") ResultList resultList, @JSONField(name = "scoringMethod") int i) {
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        this.resultList = resultList;
        this.scoringMethod = i;
    }

    public final ResultList getResultList() {
        return this.resultList;
    }

    public final void setResultList(ResultList resultList) {
        Intrinsics.checkNotNullParameter(resultList, "<set-?>");
        this.resultList = resultList;
    }

    public final int getScoringMethod() {
        return this.scoringMethod;
    }

    public final void setScoringMethod(int i) {
        this.scoringMethod = i;
    }
}
