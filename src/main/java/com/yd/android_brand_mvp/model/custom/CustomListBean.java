package com.yd.android_brand_mvp.model.custom;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomListBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000b\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/custom/CustomListBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "content", "", "type", "", "(Ljava/lang/String;I)V", "getContent", "()Ljava/lang/String;", "itemType", "getItemType", "()I", "getType", "setType", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomListBean implements MultiItemEntity {
    private final String content;
    private int type;

    public CustomListBean() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CustomListBean copy$default(CustomListBean customListBean, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = customListBean.content;
        }
        if ((i2 & 2) != 0) {
            i = customListBean.type;
        }
        return customListBean.copy(str, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public final CustomListBean copy(String content, int type) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new CustomListBean(content, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomListBean)) {
            return false;
        }
        CustomListBean customListBean = (CustomListBean) other;
        return Intrinsics.areEqual(this.content, customListBean.content) && this.type == customListBean.type;
    }

    public int hashCode() {
        return (this.content.hashCode() * 31) + this.type;
    }

    public String toString() {
        return "CustomListBean(content=" + this.content + ", type=" + this.type + ')';
    }

    public CustomListBean(String content, int i) {
        Intrinsics.checkNotNullParameter(content, "content");
        this.content = content;
        this.type = i;
    }

    public /* synthetic */ CustomListBean(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : i);
    }

    public final String getContent() {
        return this.content;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }
}
