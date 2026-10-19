package com.yd.android_brand_mvp.model.honor;

import com.alibaba.fastjson.annotation.JSONField;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HonorCommentResultBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\u000e\b\u0003\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0003\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006!"}, d2 = {"Lcom/yd/android_brand_mvp/model/honor/ResultList;", "", TUIKitConstants.Selection.LIST, "", "Lcom/yd/android_brand_mvp/model/honor/HonorResultBean;", "pageNo", "", "pageSize", "total", "(Ljava/util/List;III)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getPageNo", "()I", "setPageNo", "(I)V", "getPageSize", "setPageSize", "getTotal", "setTotal", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ResultList {
    private List<HonorResultBean> list;
    private int pageNo;
    private int pageSize;
    private int total;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ResultList copy$default(ResultList resultList, List list, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = resultList.list;
        }
        if ((i4 & 2) != 0) {
            i = resultList.pageNo;
        }
        if ((i4 & 4) != 0) {
            i2 = resultList.pageSize;
        }
        if ((i4 & 8) != 0) {
            i3 = resultList.total;
        }
        return resultList.copy(list, i, i2, i3);
    }

    public final List<HonorResultBean> component1() {
        return this.list;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPageNo() {
        return this.pageNo;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getPageSize() {
        return this.pageSize;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTotal() {
        return this.total;
    }

    public final ResultList copy(@JSONField(name = TUIKitConstants.Selection.LIST) List<HonorResultBean> list, @JSONField(name = "pageNo") int pageNo, @JSONField(name = "pageSize") int pageSize, @JSONField(name = "total") int total) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new ResultList(list, pageNo, pageSize, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ResultList)) {
            return false;
        }
        ResultList resultList = (ResultList) other;
        return Intrinsics.areEqual(this.list, resultList.list) && this.pageNo == resultList.pageNo && this.pageSize == resultList.pageSize && this.total == resultList.total;
    }

    public int hashCode() {
        return (((((this.list.hashCode() * 31) + this.pageNo) * 31) + this.pageSize) * 31) + this.total;
    }

    public String toString() {
        return "ResultList(list=" + this.list + ", pageNo=" + this.pageNo + ", pageSize=" + this.pageSize + ", total=" + this.total + ')';
    }

    public ResultList(@JSONField(name = TUIKitConstants.Selection.LIST) List<HonorResultBean> list, @JSONField(name = "pageNo") int i, @JSONField(name = "pageSize") int i2, @JSONField(name = "total") int i3) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.pageNo = i;
        this.pageSize = i2;
        this.total = i3;
    }

    public final List<HonorResultBean> getList() {
        return this.list;
    }

    public final void setList(List<HonorResultBean> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.list = list;
    }

    public final int getPageNo() {
        return this.pageNo;
    }

    public final void setPageNo(int i) {
        this.pageNo = i;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
    }

    public final int getTotal() {
        return this.total;
    }

    public final void setTotal(int i) {
        this.total = i;
    }
}
