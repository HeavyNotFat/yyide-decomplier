package com.yd.android_brand_mvp.model.log;

import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LogBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/model/log/BusinessParam;", "", TUIKitConstants.Selection.LIST, "", "Lcom/yd/android_brand_mvp/model/log/LogBean;", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BusinessParam {
    private List<LogBean> list;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BusinessParam copy$default(BusinessParam businessParam, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = businessParam.list;
        }
        return businessParam.copy(list);
    }

    public final List<LogBean> component1() {
        return this.list;
    }

    public final BusinessParam copy(List<LogBean> list) {
        return new BusinessParam(list);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BusinessParam) && Intrinsics.areEqual(this.list, ((BusinessParam) other).list);
    }

    public int hashCode() {
        List<LogBean> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public String toString() {
        return "BusinessParam(list=" + this.list + ')';
    }

    public BusinessParam(List<LogBean> list) {
        this.list = list;
    }

    public final List<LogBean> getList() {
        return this.list;
    }

    public final void setList(List<LogBean> list) {
        this.list = list;
    }
}
