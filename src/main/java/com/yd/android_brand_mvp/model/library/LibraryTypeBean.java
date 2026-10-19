package com.yd.android_brand_mvp.model.library;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.heytap.mcssdk.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryTypeBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006 "}, d2 = {"Lcom/yd/android_brand_mvp/model/library/LibraryTypeBean;", "Landroid/os/Parcelable;", "builtinType", "", a.j, "", "id", AppMeasurementSdk.ConditionalUserProperty.NAME, "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuiltinType", "()I", "getCode", "()Ljava/lang/String;", "getId", "getName", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LibraryTypeBean implements Parcelable {
    public static final Parcelable.Creator<LibraryTypeBean> CREATOR = new Creator();
    private final int builtinType;
    private final String code;
    private final String id;
    private final String name;

    /* JADX INFO: compiled from: LibraryTypeBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LibraryTypeBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LibraryTypeBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LibraryTypeBean(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LibraryTypeBean[] newArray(int i) {
            return new LibraryTypeBean[i];
        }
    }

    public static /* synthetic */ LibraryTypeBean copy$default(LibraryTypeBean libraryTypeBean, int i, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = libraryTypeBean.builtinType;
        }
        if ((i2 & 2) != 0) {
            str = libraryTypeBean.code;
        }
        if ((i2 & 4) != 0) {
            str2 = libraryTypeBean.id;
        }
        if ((i2 & 8) != 0) {
            str3 = libraryTypeBean.name;
        }
        return libraryTypeBean.copy(i, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getBuiltinType() {
        return this.builtinType;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final LibraryTypeBean copy(int builtinType, String code, String id, String name) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new LibraryTypeBean(builtinType, code, id, name);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryTypeBean)) {
            return false;
        }
        LibraryTypeBean libraryTypeBean = (LibraryTypeBean) other;
        return this.builtinType == libraryTypeBean.builtinType && Intrinsics.areEqual(this.code, libraryTypeBean.code) && Intrinsics.areEqual(this.id, libraryTypeBean.id) && Intrinsics.areEqual(this.name, libraryTypeBean.name);
    }

    public int hashCode() {
        return (((((this.builtinType * 31) + this.code.hashCode()) * 31) + this.id.hashCode()) * 31) + this.name.hashCode();
    }

    public String toString() {
        return "LibraryTypeBean(builtinType=" + this.builtinType + ", code=" + this.code + ", id=" + this.id + ", name=" + this.name + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.builtinType);
        parcel.writeString(this.code);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
    }

    public LibraryTypeBean(int i, String code, String id, String name) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.builtinType = i;
        this.code = code;
        this.id = id;
        this.name = name;
    }

    public final int getBuiltinType() {
        return this.builtinType;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}
