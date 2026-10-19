package com.yd.android_brand_mvp.model.collect;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectSituationBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/CollectSituationBean;", "", "gonnaDoStudentList", "", "Lcom/yd/android_brand_mvp/model/collect/FormStudentListItem;", "alreadyDidStudentList", "(Ljava/util/List;Ljava/util/List;)V", "getAlreadyDidStudentList", "()Ljava/util/List;", "getGonnaDoStudentList", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CollectSituationBean {
    private final List<FormStudentListItem> alreadyDidStudentList;
    private final List<FormStudentListItem> gonnaDoStudentList;

    public CollectSituationBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CollectSituationBean copy$default(CollectSituationBean collectSituationBean, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = collectSituationBean.gonnaDoStudentList;
        }
        if ((i & 2) != 0) {
            list2 = collectSituationBean.alreadyDidStudentList;
        }
        return collectSituationBean.copy(list, list2);
    }

    public final List<FormStudentListItem> component1() {
        return this.gonnaDoStudentList;
    }

    public final List<FormStudentListItem> component2() {
        return this.alreadyDidStudentList;
    }

    public final CollectSituationBean copy(List<FormStudentListItem> gonnaDoStudentList, List<FormStudentListItem> alreadyDidStudentList) {
        Intrinsics.checkNotNullParameter(gonnaDoStudentList, "gonnaDoStudentList");
        Intrinsics.checkNotNullParameter(alreadyDidStudentList, "alreadyDidStudentList");
        return new CollectSituationBean(gonnaDoStudentList, alreadyDidStudentList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectSituationBean)) {
            return false;
        }
        CollectSituationBean collectSituationBean = (CollectSituationBean) other;
        return Intrinsics.areEqual(this.gonnaDoStudentList, collectSituationBean.gonnaDoStudentList) && Intrinsics.areEqual(this.alreadyDidStudentList, collectSituationBean.alreadyDidStudentList);
    }

    public int hashCode() {
        return (this.gonnaDoStudentList.hashCode() * 31) + this.alreadyDidStudentList.hashCode();
    }

    public String toString() {
        return "CollectSituationBean(gonnaDoStudentList=" + this.gonnaDoStudentList + ", alreadyDidStudentList=" + this.alreadyDidStudentList + ')';
    }

    public CollectSituationBean(List<FormStudentListItem> gonnaDoStudentList, List<FormStudentListItem> alreadyDidStudentList) {
        Intrinsics.checkNotNullParameter(gonnaDoStudentList, "gonnaDoStudentList");
        Intrinsics.checkNotNullParameter(alreadyDidStudentList, "alreadyDidStudentList");
        this.gonnaDoStudentList = gonnaDoStudentList;
        this.alreadyDidStudentList = alreadyDidStudentList;
    }

    public /* synthetic */ CollectSituationBean(ArrayList arrayList, ArrayList arrayList2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList, (i & 2) != 0 ? new ArrayList() : arrayList2);
    }

    public final List<FormStudentListItem> getGonnaDoStudentList() {
        return this.gonnaDoStudentList;
    }

    public final List<FormStudentListItem> getAlreadyDidStudentList() {
        return this.alreadyDidStudentList;
    }
}
