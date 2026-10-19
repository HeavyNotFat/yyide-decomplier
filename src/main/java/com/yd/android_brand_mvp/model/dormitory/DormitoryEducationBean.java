package com.yd.android_brand_mvp.model.dormitory;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DormitoryEducationBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/dormitory/DormitoryEducationBean;", "", "ownList", "", "Lcom/yd/android_brand_mvp/model/dormitory/DormitoryEducationItemBean;", "rankList", "title", "", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getOwnList", "()Ljava/util/List;", "getRankList", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DormitoryEducationBean {
    private final List<DormitoryEducationItemBean> ownList;
    private final List<DormitoryEducationItemBean> rankList;
    private final String title;

    public DormitoryEducationBean() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DormitoryEducationBean copy$default(DormitoryEducationBean dormitoryEducationBean, List list, List list2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = dormitoryEducationBean.ownList;
        }
        if ((i & 2) != 0) {
            list2 = dormitoryEducationBean.rankList;
        }
        if ((i & 4) != 0) {
            str = dormitoryEducationBean.title;
        }
        return dormitoryEducationBean.copy(list, list2, str);
    }

    public final List<DormitoryEducationItemBean> component1() {
        return this.ownList;
    }

    public final List<DormitoryEducationItemBean> component2() {
        return this.rankList;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public final DormitoryEducationBean copy(List<DormitoryEducationItemBean> ownList, List<DormitoryEducationItemBean> rankList, String title) {
        Intrinsics.checkNotNullParameter(ownList, "ownList");
        Intrinsics.checkNotNullParameter(rankList, "rankList");
        Intrinsics.checkNotNullParameter(title, "title");
        return new DormitoryEducationBean(ownList, rankList, title);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DormitoryEducationBean)) {
            return false;
        }
        DormitoryEducationBean dormitoryEducationBean = (DormitoryEducationBean) other;
        return Intrinsics.areEqual(this.ownList, dormitoryEducationBean.ownList) && Intrinsics.areEqual(this.rankList, dormitoryEducationBean.rankList) && Intrinsics.areEqual(this.title, dormitoryEducationBean.title);
    }

    public int hashCode() {
        return (((this.ownList.hashCode() * 31) + this.rankList.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        return "DormitoryEducationBean(ownList=" + this.ownList + ", rankList=" + this.rankList + ", title=" + this.title + ')';
    }

    public DormitoryEducationBean(List<DormitoryEducationItemBean> ownList, List<DormitoryEducationItemBean> rankList, String title) {
        Intrinsics.checkNotNullParameter(ownList, "ownList");
        Intrinsics.checkNotNullParameter(rankList, "rankList");
        Intrinsics.checkNotNullParameter(title, "title");
        this.ownList = ownList;
        this.rankList = rankList;
        this.title = title;
    }

    public /* synthetic */ DormitoryEducationBean(ArrayList arrayList, ArrayList arrayList2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? new ArrayList() : arrayList2, (i & 4) != 0 ? "" : str);
    }

    public final List<DormitoryEducationItemBean> getOwnList() {
        return this.ownList;
    }

    public final List<DormitoryEducationItemBean> getRankList() {
        return this.rankList;
    }

    public final String getTitle() {
        return this.title;
    }
}
