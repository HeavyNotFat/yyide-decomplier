package com.yd.android_brand_mvp.model.collect;

import com.heytap.mcssdk.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OptionListItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/OptionListItem;", "", a.j, "", a.h, "id", "", "sort", "(Ljava/lang/String;Ljava/lang/String;II)V", "getCode", "()Ljava/lang/String;", "getDescription", "getId", "()I", "getSort", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class OptionListItem {
    private final String code;
    private final String description;
    private final int id;
    private final int sort;

    public OptionListItem() {
        this(null, null, 0, 0, 15, null);
    }

    public static /* synthetic */ OptionListItem copy$default(OptionListItem optionListItem, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = optionListItem.code;
        }
        if ((i3 & 2) != 0) {
            str2 = optionListItem.description;
        }
        if ((i3 & 4) != 0) {
            i = optionListItem.id;
        }
        if ((i3 & 8) != 0) {
            i2 = optionListItem.sort;
        }
        return optionListItem.copy(str, str2, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSort() {
        return this.sort;
    }

    public final OptionListItem copy(String code, String description, int id, int sort) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(description, "description");
        return new OptionListItem(code, description, id, sort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OptionListItem)) {
            return false;
        }
        OptionListItem optionListItem = (OptionListItem) other;
        return Intrinsics.areEqual(this.code, optionListItem.code) && Intrinsics.areEqual(this.description, optionListItem.description) && this.id == optionListItem.id && this.sort == optionListItem.sort;
    }

    public int hashCode() {
        return (((((this.code.hashCode() * 31) + this.description.hashCode()) * 31) + this.id) * 31) + this.sort;
    }

    public String toString() {
        return "OptionListItem(code=" + this.code + ", description=" + this.description + ", id=" + this.id + ", sort=" + this.sort + ')';
    }

    public OptionListItem(String code, String description, int i, int i2) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(description, "description");
        this.code = code;
        this.description = description;
        this.id = i;
        this.sort = i2;
    }

    public /* synthetic */ OptionListItem(String str, String str2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final String getCode() {
        return this.code;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getId() {
        return this.id;
    }

    public final int getSort() {
        return this.sort;
    }
}
