package com.yd.android_brand_mvp.model.custom;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomJsonGroupBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/model/custom/FormContentItemBean;", "Landroid/os/Parcelable;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getValue", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FormContentItemBean implements Parcelable {
    public static final Parcelable.Creator<FormContentItemBean> CREATOR = new Creator();
    private final String name;
    private final String value;

    /* JADX INFO: compiled from: CustomJsonGroupBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FormContentItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FormContentItemBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FormContentItemBean(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FormContentItemBean[] newArray(int i) {
            return new FormContentItemBean[i];
        }
    }

    public FormContentItemBean() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FormContentItemBean copy$default(FormContentItemBean formContentItemBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = formContentItemBean.name;
        }
        if ((i & 2) != 0) {
            str2 = formContentItemBean.value;
        }
        return formContentItemBean.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final FormContentItemBean copy(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return new FormContentItemBean(name, value);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FormContentItemBean)) {
            return false;
        }
        FormContentItemBean formContentItemBean = (FormContentItemBean) other;
        return Intrinsics.areEqual(this.name, formContentItemBean.name) && Intrinsics.areEqual(this.value, formContentItemBean.value);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.value.hashCode();
    }

    public String toString() {
        return "FormContentItemBean(name=" + this.name + ", value=" + this.value + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.value);
    }

    public FormContentItemBean(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.name = name;
        this.value = value;
    }

    public /* synthetic */ FormContentItemBean(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2);
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }
}
