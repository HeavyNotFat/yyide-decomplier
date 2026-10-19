package com.yd.android_brand_mvp.model.vote;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VoteSubmitInfoBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/yd/android_brand_mvp/model/vote/VoteSubmitInfoBean;", "", "optionId", "", "nums", "", "(Ljava/lang/String;I)V", "getNums", "()I", "getOptionId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VoteSubmitInfoBean {
    private final int nums;
    private final String optionId;

    public VoteSubmitInfoBean() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ VoteSubmitInfoBean copy$default(VoteSubmitInfoBean voteSubmitInfoBean, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = voteSubmitInfoBean.optionId;
        }
        if ((i2 & 2) != 0) {
            i = voteSubmitInfoBean.nums;
        }
        return voteSubmitInfoBean.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOptionId() {
        return this.optionId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getNums() {
        return this.nums;
    }

    public final VoteSubmitInfoBean copy(String optionId, int nums) {
        Intrinsics.checkNotNullParameter(optionId, "optionId");
        return new VoteSubmitInfoBean(optionId, nums);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoteSubmitInfoBean)) {
            return false;
        }
        VoteSubmitInfoBean voteSubmitInfoBean = (VoteSubmitInfoBean) other;
        return Intrinsics.areEqual(this.optionId, voteSubmitInfoBean.optionId) && this.nums == voteSubmitInfoBean.nums;
    }

    public int hashCode() {
        return (this.optionId.hashCode() * 31) + this.nums;
    }

    public String toString() {
        return "VoteSubmitInfoBean(optionId=" + this.optionId + ", nums=" + this.nums + ')';
    }

    public VoteSubmitInfoBean(String optionId, int i) {
        Intrinsics.checkNotNullParameter(optionId, "optionId");
        this.optionId = optionId;
        this.nums = i;
    }

    public /* synthetic */ VoteSubmitInfoBean(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }

    public final int getNums() {
        return this.nums;
    }

    public final String getOptionId() {
        return this.optionId;
    }
}
