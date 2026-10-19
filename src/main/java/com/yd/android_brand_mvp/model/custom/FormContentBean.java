package com.yd.android_brand_mvp.model.custom;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomJsonGroupBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/model/custom/FormContentBean;", "Landroid/os/Parcelable;", "formContents", "", "Lcom/yd/android_brand_mvp/model/custom/FormContentItemBean;", "images", "", "(Ljava/util/List;Ljava/util/List;)V", "getFormContents", "()Ljava/util/List;", "getImages", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FormContentBean implements Parcelable {
    public static final Parcelable.Creator<FormContentBean> CREATOR = new Creator();
    private final List<FormContentItemBean> formContents;
    private final List<String> images;

    /* JADX INFO: compiled from: CustomJsonGroupBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FormContentBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FormContentBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 != i; i2++) {
                arrayList.add(FormContentItemBean.CREATOR.createFromParcel(parcel));
            }
            return new FormContentBean(arrayList, parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FormContentBean[] newArray(int i) {
            return new FormContentBean[i];
        }
    }

    public FormContentBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FormContentBean copy$default(FormContentBean formContentBean, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = formContentBean.formContents;
        }
        if ((i & 2) != 0) {
            list2 = formContentBean.images;
        }
        return formContentBean.copy(list, list2);
    }

    public final List<FormContentItemBean> component1() {
        return this.formContents;
    }

    public final List<String> component2() {
        return this.images;
    }

    public final FormContentBean copy(List<FormContentItemBean> formContents, List<String> images) {
        Intrinsics.checkNotNullParameter(formContents, "formContents");
        Intrinsics.checkNotNullParameter(images, "images");
        return new FormContentBean(formContents, images);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormContentBean)) {
            return false;
        }
        FormContentBean formContentBean = (FormContentBean) other;
        return Intrinsics.areEqual(this.formContents, formContentBean.formContents) && Intrinsics.areEqual(this.images, formContentBean.images);
    }

    public int hashCode() {
        return (this.formContents.hashCode() * 31) + this.images.hashCode();
    }

    public String toString() {
        return "FormContentBean(formContents=" + this.formContents + ", images=" + this.images + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        List<FormContentItemBean> list = this.formContents;
        parcel.writeInt(list.size());
        Iterator<FormContentItemBean> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
        parcel.writeStringList(this.images);
    }

    public FormContentBean(List<FormContentItemBean> formContents, List<String> images) {
        Intrinsics.checkNotNullParameter(formContents, "formContents");
        Intrinsics.checkNotNullParameter(images, "images");
        this.formContents = formContents;
        this.images = images;
    }

    public /* synthetic */ FormContentBean(List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public final List<FormContentItemBean> getFormContents() {
        return this.formContents;
    }

    public final List<String> getImages() {
        return this.images;
    }
}
