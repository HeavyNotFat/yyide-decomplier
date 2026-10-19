package com.yd.android_brand_mvp.model.home;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DominateScreenBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/model/home/DominateScreenBean;", "", "type", "", "sort", "", "isForceExit", "", "(Ljava/lang/String;IZ)V", "()Z", "getSort", "()I", "getType", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DominateScreenBean {
    private final boolean isForceExit;
    private final int sort;
    private final String type;

    public static /* synthetic */ DominateScreenBean copy$default(DominateScreenBean dominateScreenBean, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = dominateScreenBean.type;
        }
        if ((i2 & 2) != 0) {
            i = dominateScreenBean.sort;
        }
        if ((i2 & 4) != 0) {
            z = dominateScreenBean.isForceExit;
        }
        return dominateScreenBean.copy(str, i, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsForceExit() {
        return this.isForceExit;
    }

    public final DominateScreenBean copy(String type, int sort, boolean isForceExit) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new DominateScreenBean(type, sort, isForceExit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DominateScreenBean)) {
            return false;
        }
        DominateScreenBean dominateScreenBean = (DominateScreenBean) other;
        return Intrinsics.areEqual(this.type, dominateScreenBean.type) && this.sort == dominateScreenBean.sort && this.isForceExit == dominateScreenBean.isForceExit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    public int hashCode() {
        int iHashCode = ((this.type.hashCode() * 31) + this.sort) * 31;
        boolean z = this.isForceExit;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "DominateScreenBean(type=" + this.type + ", sort=" + this.sort + ", isForceExit=" + this.isForceExit + ')';
    }

    public DominateScreenBean(String type, int i, boolean z) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.sort = i;
        this.isForceExit = z;
    }

    public /* synthetic */ DominateScreenBean(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? -1 : i, (i2 & 4) != 0 ? false : z);
    }

    public final String getType() {
        return this.type;
    }

    public final int getSort() {
        return this.sort;
    }

    public final boolean isForceExit() {
        return this.isForceExit;
    }
}
