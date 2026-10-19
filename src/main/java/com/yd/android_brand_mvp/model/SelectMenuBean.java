package com.yd.android_brand_mvp.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SelectMenuBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/model/SelectMenuBean;", "Landroid/os/Parcelable;", AppMeasurementSdk.ConditionalUserProperty.NAME, "", "id", "isSelect", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "setSelect", "(Z)V", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SelectMenuBean implements Parcelable {
    public static final Parcelable.Creator<SelectMenuBean> CREATOR = new Creator();
    private final String id;
    private boolean isSelect;
    private final String name;

    /* JADX INFO: compiled from: SelectMenuBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SelectMenuBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SelectMenuBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SelectMenuBean(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SelectMenuBean[] newArray(int i) {
            return new SelectMenuBean[i];
        }
    }

    public SelectMenuBean() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ SelectMenuBean copy$default(SelectMenuBean selectMenuBean, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = selectMenuBean.name;
        }
        if ((i & 2) != 0) {
            str2 = selectMenuBean.id;
        }
        if ((i & 4) != 0) {
            z = selectMenuBean.isSelect;
        }
        return selectMenuBean.copy(str, str2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final SelectMenuBean copy(String name, String id, boolean isSelect) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        return new SelectMenuBean(name, id, isSelect);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectMenuBean)) {
            return false;
        }
        SelectMenuBean selectMenuBean = (SelectMenuBean) other;
        return Intrinsics.areEqual(this.name, selectMenuBean.name) && Intrinsics.areEqual(this.id, selectMenuBean.id) && this.isSelect == selectMenuBean.isSelect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((this.name.hashCode() * 31) + this.id.hashCode()) * 31;
        boolean z = this.isSelect;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "SelectMenuBean(name=" + this.name + ", id=" + this.id + ", isSelect=" + this.isSelect + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeString(this.id);
        parcel.writeInt(this.isSelect ? 1 : 0);
    }

    public SelectMenuBean(String name, String id, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(id, "id");
        this.name = name;
        this.id = id;
        this.isSelect = z;
    }

    public /* synthetic */ SelectMenuBean(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z);
    }

    public final String getName() {
        return this.name;
    }

    public final String getId() {
        return this.id;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }
}
