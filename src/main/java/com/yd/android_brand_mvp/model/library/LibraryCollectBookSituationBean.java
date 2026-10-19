package com.yd.android_brand_mvp.model.library;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryCollectBookSituationBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006&"}, d2 = {"Lcom/yd/android_brand_mvp/model/library/LibraryCollectBookSituationBean;", "Landroid/os/Parcelable;", "availability", "", "barCode", "", "bookId", "id", "locationName", "shelfName", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvailability", "()I", "getBarCode", "()Ljava/lang/String;", "getBookId", "getId", "getLocationName", "getShelfName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LibraryCollectBookSituationBean implements Parcelable {
    public static final Parcelable.Creator<LibraryCollectBookSituationBean> CREATOR = new Creator();
    private final int availability;
    private final String barCode;
    private final String bookId;
    private final String id;
    private final String locationName;
    private final String shelfName;

    /* JADX INFO: compiled from: LibraryCollectBookSituationBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LibraryCollectBookSituationBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LibraryCollectBookSituationBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LibraryCollectBookSituationBean(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LibraryCollectBookSituationBean[] newArray(int i) {
            return new LibraryCollectBookSituationBean[i];
        }
    }

    public static /* synthetic */ LibraryCollectBookSituationBean copy$default(LibraryCollectBookSituationBean libraryCollectBookSituationBean, int i, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = libraryCollectBookSituationBean.availability;
        }
        if ((i2 & 2) != 0) {
            str = libraryCollectBookSituationBean.barCode;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = libraryCollectBookSituationBean.bookId;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = libraryCollectBookSituationBean.id;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = libraryCollectBookSituationBean.locationName;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = libraryCollectBookSituationBean.shelfName;
        }
        return libraryCollectBookSituationBean.copy(i, str6, str7, str8, str9, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getAvailability() {
        return this.availability;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBarCode() {
        return this.barCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getBookId() {
        return this.bookId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getLocationName() {
        return this.locationName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getShelfName() {
        return this.shelfName;
    }

    public final LibraryCollectBookSituationBean copy(int availability, String barCode, String bookId, String id, String locationName, String shelfName) {
        Intrinsics.checkNotNullParameter(barCode, "barCode");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(locationName, "locationName");
        Intrinsics.checkNotNullParameter(shelfName, "shelfName");
        return new LibraryCollectBookSituationBean(availability, barCode, bookId, id, locationName, shelfName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryCollectBookSituationBean)) {
            return false;
        }
        LibraryCollectBookSituationBean libraryCollectBookSituationBean = (LibraryCollectBookSituationBean) other;
        return this.availability == libraryCollectBookSituationBean.availability && Intrinsics.areEqual(this.barCode, libraryCollectBookSituationBean.barCode) && Intrinsics.areEqual(this.bookId, libraryCollectBookSituationBean.bookId) && Intrinsics.areEqual(this.id, libraryCollectBookSituationBean.id) && Intrinsics.areEqual(this.locationName, libraryCollectBookSituationBean.locationName) && Intrinsics.areEqual(this.shelfName, libraryCollectBookSituationBean.shelfName);
    }

    public int hashCode() {
        return (((((((((this.availability * 31) + this.barCode.hashCode()) * 31) + this.bookId.hashCode()) * 31) + this.id.hashCode()) * 31) + this.locationName.hashCode()) * 31) + this.shelfName.hashCode();
    }

    public String toString() {
        return "LibraryCollectBookSituationBean(availability=" + this.availability + ", barCode=" + this.barCode + ", bookId=" + this.bookId + ", id=" + this.id + ", locationName=" + this.locationName + ", shelfName=" + this.shelfName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.availability);
        parcel.writeString(this.barCode);
        parcel.writeString(this.bookId);
        parcel.writeString(this.id);
        parcel.writeString(this.locationName);
        parcel.writeString(this.shelfName);
    }

    public LibraryCollectBookSituationBean(int i, String barCode, String bookId, String id, String locationName, String shelfName) {
        Intrinsics.checkNotNullParameter(barCode, "barCode");
        Intrinsics.checkNotNullParameter(bookId, "bookId");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(locationName, "locationName");
        Intrinsics.checkNotNullParameter(shelfName, "shelfName");
        this.availability = i;
        this.barCode = barCode;
        this.bookId = bookId;
        this.id = id;
        this.locationName = locationName;
        this.shelfName = shelfName;
    }

    public final int getAvailability() {
        return this.availability;
    }

    public final String getBarCode() {
        return this.barCode;
    }

    public final String getBookId() {
        return this.bookId;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLocationName() {
        return this.locationName;
    }

    public final String getShelfName() {
        return this.shelfName;
    }
}
