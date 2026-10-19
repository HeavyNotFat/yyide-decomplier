package com.yd.android_brand_mvp.model.task;

import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MyTaskListBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/model/task/MyTaskListBean;", "", "total", "", "pageNo", "pageSize", TUIKitConstants.Selection.LIST, "", "Lcom/yd/android_brand_mvp/model/task/MyTaskListItem;", "(IIILjava/util/List;)V", "getList", "()Ljava/util/List;", "getPageNo", "()I", "getPageSize", "getTotal", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class MyTaskListBean {
    private final List<MyTaskListItem> list;
    private final int pageNo;
    private final int pageSize;
    private final int total;

    public MyTaskListBean() {
        this(0, 0, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyTaskListBean copy$default(MyTaskListBean myTaskListBean, int i, int i2, int i3, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = myTaskListBean.total;
        }
        if ((i4 & 2) != 0) {
            i2 = myTaskListBean.pageNo;
        }
        if ((i4 & 4) != 0) {
            i3 = myTaskListBean.pageSize;
        }
        if ((i4 & 8) != 0) {
            list = myTaskListBean.list;
        }
        return myTaskListBean.copy(i, i2, i3, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPageNo() {
        return this.pageNo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    public final List<MyTaskListItem> component4() {
        return this.list;
    }

    public final MyTaskListBean copy(int total, int pageNo, int pageSize, List<MyTaskListItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new MyTaskListBean(total, pageNo, pageSize, list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MyTaskListBean)) {
            return false;
        }
        MyTaskListBean myTaskListBean = (MyTaskListBean) other;
        return this.total == myTaskListBean.total && this.pageNo == myTaskListBean.pageNo && this.pageSize == myTaskListBean.pageSize && Intrinsics.areEqual(this.list, myTaskListBean.list);
    }

    public int hashCode() {
        return (((((this.total * 31) + this.pageNo) * 31) + this.pageSize) * 31) + this.list.hashCode();
    }

    public String toString() {
        return "MyTaskListBean(total=" + this.total + ", pageNo=" + this.pageNo + ", pageSize=" + this.pageSize + ", list=" + this.list + ')';
    }

    public MyTaskListBean(int i, int i2, int i3, List<MyTaskListItem> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.total = i;
        this.pageNo = i2;
        this.pageSize = i3;
        this.list = list;
    }

    public final int getTotal() {
        return this.total;
    }

    public final int getPageNo() {
        return this.pageNo;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public /* synthetic */ MyTaskListBean(int i, int i2, int i3, ArrayList arrayList, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3, (i4 & 8) != 0 ? new ArrayList() : arrayList);
    }

    public final List<MyTaskListItem> getList() {
        return this.list;
    }
}
