package com.yd.android_brand_mvp.model.custom;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomJsonGroupBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J=\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\t\u0010\u0016\u001a\u00020\bHÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\""}, d2 = {"Lcom/yd/android_brand_mvp/model/custom/ListContentBean;", "Landroid/os/Parcelable;", "content", "", "Lcom/yd/android_brand_mvp/model/custom/ListContentItemBean;", "images", "", FirebaseAnalytics.Param.LEVEL, "", "symbol", "(Ljava/util/List;Ljava/util/List;II)V", "getContent", "()Ljava/util/List;", "getImages", "getLevel", "()I", "getSymbol", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ListContentBean implements Parcelable {
    public static final Parcelable.Creator<ListContentBean> CREATOR = new Creator();
    private final List<ListContentItemBean> content;
    private final List<String> images;
    private final int level;
    private final int symbol;

    /* JADX INFO: compiled from: CustomJsonGroupBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ListContentBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ListContentBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(ListContentItemBean.CREATOR.createFromParcel(parcel));
            }
            return new ListContentBean(arrayList, parcel.createStringArrayList(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ListContentBean[] newArray(int i) {
            return new ListContentBean[i];
        }
    }

    public ListContentBean() {
        this(null, null, 0, 0, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListContentBean copy$default(ListContentBean listContentBean, List list, List list2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = listContentBean.content;
        }
        if ((i3 & 2) != 0) {
            list2 = listContentBean.images;
        }
        if ((i3 & 4) != 0) {
            i = listContentBean.level;
        }
        if ((i3 & 8) != 0) {
            i2 = listContentBean.symbol;
        }
        return listContentBean.copy(list, list2, i, i2);
    }

    public final List<ListContentItemBean> component1() {
        return this.content;
    }

    public final List<String> component2() {
        return this.images;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getLevel() {
        return this.level;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSymbol() {
        return this.symbol;
    }

    public final ListContentBean copy(List<ListContentItemBean> content, List<String> images, int level, int symbol) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(images, "images");
        return new ListContentBean(content, images, level, symbol);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListContentBean)) {
            return false;
        }
        ListContentBean listContentBean = (ListContentBean) other;
        return Intrinsics.areEqual(this.content, listContentBean.content) && Intrinsics.areEqual(this.images, listContentBean.images) && this.level == listContentBean.level && this.symbol == listContentBean.symbol;
    }

    public int hashCode() {
        return (((((this.content.hashCode() * 31) + this.images.hashCode()) * 31) + this.level) * 31) + this.symbol;
    }

    public String toString() {
        return "ListContentBean(content=" + this.content + ", images=" + this.images + ", level=" + this.level + ", symbol=" + this.symbol + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<ListContentItemBean> list = this.content;
        parcel.writeInt(list.size());
        Iterator<ListContentItemBean> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeStringList(this.images);
        parcel.writeInt(this.level);
        parcel.writeInt(this.symbol);
    }

    public ListContentBean(List<ListContentItemBean> content, List<String> images, int i, int i2) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(images, "images");
        this.content = content;
        this.images = images;
        this.level = i;
        this.symbol = i2;
    }

    public /* synthetic */ ListContentBean(List list, List list2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CollectionsKt.emptyList() : list, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 4) != 0 ? 1 : i, (i3 & 8) != 0 ? 1 : i2);
    }

    public final List<ListContentItemBean> getContent() {
        return this.content;
    }

    public final List<String> getImages() {
        return this.images;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getSymbol() {
        return this.symbol;
    }
}
