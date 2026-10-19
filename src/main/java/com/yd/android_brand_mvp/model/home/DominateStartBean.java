package com.yd.android_brand_mvp.model.home;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DominateStartBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/model/home/DominateStartBean;", "", "type", "", "listIndex", "", "itemDataIndex", "(Ljava/lang/String;II)V", "getItemDataIndex", "()I", "setItemDataIndex", "(I)V", "getListIndex", "setListIndex", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DominateStartBean {
    private int itemDataIndex;
    private int listIndex;
    private String type;

    public DominateStartBean() {
        this(null, 0, 0, 7, null);
    }

    public static /* synthetic */ DominateStartBean copy$default(DominateStartBean dominateStartBean, String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = dominateStartBean.type;
        }
        if ((i3 & 2) != 0) {
            i = dominateStartBean.listIndex;
        }
        if ((i3 & 4) != 0) {
            i2 = dominateStartBean.itemDataIndex;
        }
        return dominateStartBean.copy(str, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getListIndex() {
        return this.listIndex;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getItemDataIndex() {
        return this.itemDataIndex;
    }

    public final DominateStartBean copy(String type, int listIndex, int itemDataIndex) {
        Intrinsics.checkNotNullParameter(type, "type");
        return new DominateStartBean(type, listIndex, itemDataIndex);
    }

    public String toString() {
        return "DominateStartBean(type=" + this.type + ", listIndex=" + this.listIndex + ", itemDataIndex=" + this.itemDataIndex + ')';
    }

    public DominateStartBean(String type, int i, int i2) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.listIndex = i;
        this.itemDataIndex = i2;
    }

    public /* synthetic */ DominateStartBean(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? -1 : i, (i3 & 4) != 0 ? -1 : i2);
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final int getListIndex() {
        return this.listIndex;
    }

    public final void setListIndex(int i) {
        this.listIndex = i;
    }

    public final int getItemDataIndex() {
        return this.itemDataIndex;
    }

    public final void setItemDataIndex(int i) {
        this.itemDataIndex = i;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(getClass(), other.getClass())) {
            return false;
        }
        DominateStartBean dominateStartBean = (DominateStartBean) other;
        return Intrinsics.areEqual(this.type, dominateStartBean.type) && this.listIndex == dominateStartBean.listIndex && this.itemDataIndex == dominateStartBean.itemDataIndex;
    }

    public int hashCode() {
        return (((this.type.hashCode() * 31) + this.listIndex) * 31) + this.itemDataIndex;
    }
}
