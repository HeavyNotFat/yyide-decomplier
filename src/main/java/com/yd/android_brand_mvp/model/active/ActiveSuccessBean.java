package com.yd.android_brand_mvp.model.active;

import kotlin.Metadata;

/* JADX INFO: compiled from: ActiveSuccessBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/model/active/ActiveSuccessBean;", "", "failCount", "", "subType", "successCount", "(III)V", "getFailCount", "()I", "getSubType", "getSuccessCount", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ActiveSuccessBean {
    private final int failCount;
    private final int subType;
    private final int successCount;

    public static /* synthetic */ ActiveSuccessBean copy$default(ActiveSuccessBean activeSuccessBean, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = activeSuccessBean.failCount;
        }
        if ((i4 & 2) != 0) {
            i2 = activeSuccessBean.subType;
        }
        if ((i4 & 4) != 0) {
            i3 = activeSuccessBean.successCount;
        }
        return activeSuccessBean.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getFailCount() {
        return this.failCount;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSubType() {
        return this.subType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getSuccessCount() {
        return this.successCount;
    }

    public final ActiveSuccessBean copy(int failCount, int subType, int successCount) {
        return new ActiveSuccessBean(failCount, subType, successCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActiveSuccessBean)) {
            return false;
        }
        ActiveSuccessBean activeSuccessBean = (ActiveSuccessBean) other;
        return this.failCount == activeSuccessBean.failCount && this.subType == activeSuccessBean.subType && this.successCount == activeSuccessBean.successCount;
    }

    public int hashCode() {
        return (((this.failCount * 31) + this.subType) * 31) + this.successCount;
    }

    public String toString() {
        return "ActiveSuccessBean(failCount=" + this.failCount + ", subType=" + this.subType + ", successCount=" + this.successCount + ')';
    }

    public ActiveSuccessBean(int i, int i2, int i3) {
        this.failCount = i;
        this.subType = i2;
        this.successCount = i3;
    }

    public final int getFailCount() {
        return this.failCount;
    }

    public final int getSubType() {
        return this.subType;
    }

    public final int getSuccessCount() {
        return this.successCount;
    }
}
