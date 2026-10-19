package com.yd.android_brand_mvp.model.custom;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomJsonGroupBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/model/custom/ListContentItemBean;", "Landroid/os/Parcelable;", "firstTitle", "", "secondTitle", "secondTitles", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getFirstTitle", "()Ljava/lang/String;", "getSecondTitle", "getSecondTitles", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ListContentItemBean implements Parcelable {
    public static final Parcelable.Creator<ListContentItemBean> CREATOR = new Creator();
    private final String firstTitle;
    private final String secondTitle;
    private final List<String> secondTitles;

    /* JADX INFO: compiled from: CustomJsonGroupBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ListContentItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ListContentItemBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ListContentItemBean(parcel.readString(), parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ListContentItemBean[] newArray(int i) {
            return new ListContentItemBean[i];
        }
    }

    public ListContentItemBean() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListContentItemBean copy$default(ListContentItemBean listContentItemBean, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = listContentItemBean.firstTitle;
        }
        if ((i & 2) != 0) {
            str2 = listContentItemBean.secondTitle;
        }
        if ((i & 4) != 0) {
            list = listContentItemBean.secondTitles;
        }
        return listContentItemBean.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFirstTitle() {
        return this.firstTitle;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSecondTitle() {
        return this.secondTitle;
    }

    public final List<String> component3() {
        return this.secondTitles;
    }

    public final ListContentItemBean copy(String firstTitle, String secondTitle, List<String> secondTitles) {
        Intrinsics.checkNotNullParameter(firstTitle, "firstTitle");
        Intrinsics.checkNotNullParameter(secondTitle, "secondTitle");
        Intrinsics.checkNotNullParameter(secondTitles, "secondTitles");
        return new ListContentItemBean(firstTitle, secondTitle, secondTitles);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListContentItemBean)) {
            return false;
        }
        ListContentItemBean listContentItemBean = (ListContentItemBean) other;
        return Intrinsics.areEqual(this.firstTitle, listContentItemBean.firstTitle) && Intrinsics.areEqual(this.secondTitle, listContentItemBean.secondTitle) && Intrinsics.areEqual(this.secondTitles, listContentItemBean.secondTitles);
    }

    public int hashCode() {
        return (((this.firstTitle.hashCode() * 31) + this.secondTitle.hashCode()) * 31) + this.secondTitles.hashCode();
    }

    public String toString() {
        return "ListContentItemBean(firstTitle=" + this.firstTitle + ", secondTitle=" + this.secondTitle + ", secondTitles=" + this.secondTitles + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.firstTitle);
        parcel.writeString(this.secondTitle);
        parcel.writeStringList(this.secondTitles);
    }

    public ListContentItemBean(String firstTitle, String secondTitle, List<String> secondTitles) {
        Intrinsics.checkNotNullParameter(firstTitle, "firstTitle");
        Intrinsics.checkNotNullParameter(secondTitle, "secondTitle");
        Intrinsics.checkNotNullParameter(secondTitles, "secondTitles");
        this.firstTitle = firstTitle;
        this.secondTitle = secondTitle;
        this.secondTitles = secondTitles;
    }

    public final String getFirstTitle() {
        return this.firstTitle;
    }

    public final String getSecondTitle() {
        return this.secondTitle;
    }

    public /* synthetic */ ListContentItemBean(String str, String str2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<String> getSecondTitles() {
        return this.secondTitles;
    }
}
