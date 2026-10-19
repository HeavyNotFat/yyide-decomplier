package com.yd.android_brand_mvp.model.collect;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemSelectBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/ItemSelectBean;", "", "isSelect", "", "content", "", "id", "(ZLjava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getId", "()Z", "setSelect", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ItemSelectBean {
    private final String content;
    private final String id;
    private boolean isSelect;

    public ItemSelectBean() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ ItemSelectBean copy$default(ItemSelectBean itemSelectBean, boolean z, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = itemSelectBean.isSelect;
        }
        if ((i & 2) != 0) {
            str = itemSelectBean.content;
        }
        if ((i & 4) != 0) {
            str2 = itemSelectBean.id;
        }
        return itemSelectBean.copy(z, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final ItemSelectBean copy(boolean isSelect, String content, String id) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(id, "id");
        return new ItemSelectBean(isSelect, content, id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemSelectBean)) {
            return false;
        }
        ItemSelectBean itemSelectBean = (ItemSelectBean) other;
        return this.isSelect == itemSelectBean.isSelect && Intrinsics.areEqual(this.content, itemSelectBean.content) && Intrinsics.areEqual(this.id, itemSelectBean.id);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z = this.isSelect;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((r0 * 31) + this.content.hashCode()) * 31) + this.id.hashCode();
    }

    public String toString() {
        return "ItemSelectBean(isSelect=" + this.isSelect + ", content=" + this.content + ", id=" + this.id + ')';
    }

    public ItemSelectBean(boolean z, String content, String id) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(id, "id");
        this.isSelect = z;
        this.content = content;
        this.id = id;
    }

    public /* synthetic */ ItemSelectBean(boolean z, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getId() {
        return this.id;
    }
}
