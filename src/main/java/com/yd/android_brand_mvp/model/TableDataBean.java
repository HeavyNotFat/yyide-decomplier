package com.yd.android_brand_mvp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TableDataBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/TableDataBean;", "", "type", "", "data", "Lcom/yd/android_brand_mvp/model/KBRsp2;", "(ILcom/yd/android_brand_mvp/model/KBRsp2;)V", "getData", "()Lcom/yd/android_brand_mvp/model/KBRsp2;", "setData", "(Lcom/yd/android_brand_mvp/model/KBRsp2;)V", "getType", "()I", "setType", "(I)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TableDataBean {
    private KBRsp2 data;
    private int type;

    public TableDataBean() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TableDataBean copy$default(TableDataBean tableDataBean, int i, KBRsp2 kBRsp2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = tableDataBean.type;
        }
        if ((i2 & 2) != 0) {
            kBRsp2 = tableDataBean.data;
        }
        return tableDataBean.copy(i, kBRsp2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final KBRsp2 getData() {
        return this.data;
    }

    public final TableDataBean copy(int type, KBRsp2 data) {
        return new TableDataBean(type, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TableDataBean)) {
            return false;
        }
        TableDataBean tableDataBean = (TableDataBean) other;
        return this.type == tableDataBean.type && Intrinsics.areEqual(this.data, tableDataBean.data);
    }

    public int hashCode() {
        int i = this.type * 31;
        KBRsp2 kBRsp2 = this.data;
        return i + (kBRsp2 == null ? 0 : kBRsp2.hashCode());
    }

    public String toString() {
        return "TableDataBean(type=" + this.type + ", data=" + this.data + ')';
    }

    public TableDataBean(int i, KBRsp2 kBRsp2) {
        this.type = i;
        this.data = kBRsp2;
    }

    public /* synthetic */ TableDataBean(int i, KBRsp2 kBRsp2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1 : i, (i2 & 2) != 0 ? null : kBRsp2);
    }

    public final KBRsp2 getData() {
        return this.data;
    }

    public final int getType() {
        return this.type;
    }

    public final void setData(KBRsp2 kBRsp2) {
        this.data = kBRsp2;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
