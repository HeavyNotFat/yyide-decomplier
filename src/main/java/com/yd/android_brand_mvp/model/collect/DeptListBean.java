package com.yd.android_brand_mvp.model.collect;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeptListBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/DeptListBean;", "", "deptId", "", "deptName", "userId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeptId", "()Ljava/lang/String;", "getDeptName", "getUserId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DeptListBean {
    private final String deptId;
    private final String deptName;
    private final String userId;

    public DeptListBean() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DeptListBean copy$default(DeptListBean deptListBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = deptListBean.deptId;
        }
        if ((i & 2) != 0) {
            str2 = deptListBean.deptName;
        }
        if ((i & 4) != 0) {
            str3 = deptListBean.userId;
        }
        return deptListBean.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDeptId() {
        return this.deptId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeptName() {
        return this.deptName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final DeptListBean copy(String deptId, String deptName, String userId) {
        Intrinsics.checkNotNullParameter(deptId, "deptId");
        Intrinsics.checkNotNullParameter(deptName, "deptName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new DeptListBean(deptId, deptName, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeptListBean)) {
            return false;
        }
        DeptListBean deptListBean = (DeptListBean) other;
        return Intrinsics.areEqual(this.deptId, deptListBean.deptId) && Intrinsics.areEqual(this.deptName, deptListBean.deptName) && Intrinsics.areEqual(this.userId, deptListBean.userId);
    }

    public int hashCode() {
        return (((this.deptId.hashCode() * 31) + this.deptName.hashCode()) * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "DeptListBean(deptId=" + this.deptId + ", deptName=" + this.deptName + ", userId=" + this.userId + ')';
    }

    public DeptListBean(String deptId, String deptName, String userId) {
        Intrinsics.checkNotNullParameter(deptId, "deptId");
        Intrinsics.checkNotNullParameter(deptName, "deptName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.deptId = deptId;
        this.deptName = deptName;
        this.userId = userId;
    }

    public /* synthetic */ DeptListBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getDeptId() {
        return this.deptId;
    }

    public final String getDeptName() {
        return this.deptName;
    }

    public final String getUserId() {
        return this.userId;
    }
}
