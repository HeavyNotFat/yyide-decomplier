package com.yd.android_brand_mvp.model.library;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.mcssdk.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LibraryItemBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\u0081\u0001\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100HÖ\u0003J\t\u00101\u001a\u00020\u0005HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u0019\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012¨\u00068"}, d2 = {"Lcom/yd/android_brand_mvp/model/library/LibraryItemBean;", "Landroid/os/Parcelable;", "bookIsbn", "", "borrowableCount", "", "callNumber", "categoryCode", a.h, "firstAuthor", "id", "itemCount", "publicationTime", "publisherName", "title", "url", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBookIsbn", "()Ljava/lang/String;", "getBorrowableCount", "()I", "getCallNumber", "getCategoryCode", "getDescription", "getFirstAuthor", "getId", "getItemCount", "getPublicationTime", "getPublisherName", "getTitle", "getUrl", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LibraryItemBean implements Parcelable {
    public static final Parcelable.Creator<LibraryItemBean> CREATOR = new Creator();
    private final String bookIsbn;
    private final int borrowableCount;
    private final String callNumber;
    private final String categoryCode;
    private final String description;
    private final String firstAuthor;
    private final String id;
    private final int itemCount;
    private final String publicationTime;
    private final String publisherName;
    private final String title;
    private final String url;

    /* JADX INFO: compiled from: LibraryItemBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LibraryItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LibraryItemBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LibraryItemBean(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final LibraryItemBean[] newArray(int i) {
            return new LibraryItemBean[i];
        }
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBookIsbn() {
        return this.bookIsbn;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPublisherName() {
        return this.publisherName;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBorrowableCount() {
        return this.borrowableCount;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCallNumber() {
        return this.callNumber;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCategoryCode() {
        return this.categoryCode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getFirstAuthor() {
        return this.firstAuthor;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getItemCount() {
        return this.itemCount;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getPublicationTime() {
        return this.publicationTime;
    }

    public final LibraryItemBean copy(String bookIsbn, int borrowableCount, String callNumber, String categoryCode, String description, String firstAuthor, String id, int itemCount, String publicationTime, String publisherName, String title, String url) {
        Intrinsics.checkNotNullParameter(bookIsbn, "bookIsbn");
        Intrinsics.checkNotNullParameter(callNumber, "callNumber");
        Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(firstAuthor, "firstAuthor");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(publicationTime, "publicationTime");
        Intrinsics.checkNotNullParameter(publisherName, "publisherName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(url, "url");
        return new LibraryItemBean(bookIsbn, borrowableCount, callNumber, categoryCode, description, firstAuthor, id, itemCount, publicationTime, publisherName, title, url);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LibraryItemBean)) {
            return false;
        }
        LibraryItemBean libraryItemBean = (LibraryItemBean) other;
        return Intrinsics.areEqual(this.bookIsbn, libraryItemBean.bookIsbn) && this.borrowableCount == libraryItemBean.borrowableCount && Intrinsics.areEqual(this.callNumber, libraryItemBean.callNumber) && Intrinsics.areEqual(this.categoryCode, libraryItemBean.categoryCode) && Intrinsics.areEqual(this.description, libraryItemBean.description) && Intrinsics.areEqual(this.firstAuthor, libraryItemBean.firstAuthor) && Intrinsics.areEqual(this.id, libraryItemBean.id) && this.itemCount == libraryItemBean.itemCount && Intrinsics.areEqual(this.publicationTime, libraryItemBean.publicationTime) && Intrinsics.areEqual(this.publisherName, libraryItemBean.publisherName) && Intrinsics.areEqual(this.title, libraryItemBean.title) && Intrinsics.areEqual(this.url, libraryItemBean.url);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.bookIsbn.hashCode() * 31) + this.borrowableCount) * 31) + this.callNumber.hashCode()) * 31) + this.categoryCode.hashCode()) * 31) + this.description.hashCode()) * 31) + this.firstAuthor.hashCode()) * 31) + this.id.hashCode()) * 31) + this.itemCount) * 31) + this.publicationTime.hashCode()) * 31) + this.publisherName.hashCode()) * 31) + this.title.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "LibraryItemBean(bookIsbn=" + this.bookIsbn + ", borrowableCount=" + this.borrowableCount + ", callNumber=" + this.callNumber + ", categoryCode=" + this.categoryCode + ", description=" + this.description + ", firstAuthor=" + this.firstAuthor + ", id=" + this.id + ", itemCount=" + this.itemCount + ", publicationTime=" + this.publicationTime + ", publisherName=" + this.publisherName + ", title=" + this.title + ", url=" + this.url + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.bookIsbn);
        parcel.writeInt(this.borrowableCount);
        parcel.writeString(this.callNumber);
        parcel.writeString(this.categoryCode);
        parcel.writeString(this.description);
        parcel.writeString(this.firstAuthor);
        parcel.writeString(this.id);
        parcel.writeInt(this.itemCount);
        parcel.writeString(this.publicationTime);
        parcel.writeString(this.publisherName);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
    }

    public LibraryItemBean(String bookIsbn, int i, String callNumber, String categoryCode, String description, String firstAuthor, String id, int i2, String publicationTime, String publisherName, String title, String url) {
        Intrinsics.checkNotNullParameter(bookIsbn, "bookIsbn");
        Intrinsics.checkNotNullParameter(callNumber, "callNumber");
        Intrinsics.checkNotNullParameter(categoryCode, "categoryCode");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(firstAuthor, "firstAuthor");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(publicationTime, "publicationTime");
        Intrinsics.checkNotNullParameter(publisherName, "publisherName");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(url, "url");
        this.bookIsbn = bookIsbn;
        this.borrowableCount = i;
        this.callNumber = callNumber;
        this.categoryCode = categoryCode;
        this.description = description;
        this.firstAuthor = firstAuthor;
        this.id = id;
        this.itemCount = i2;
        this.publicationTime = publicationTime;
        this.publisherName = publisherName;
        this.title = title;
        this.url = url;
    }

    public final String getBookIsbn() {
        return this.bookIsbn;
    }

    public final int getBorrowableCount() {
        return this.borrowableCount;
    }

    public final String getCallNumber() {
        return this.callNumber;
    }

    public final String getCategoryCode() {
        return this.categoryCode;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getFirstAuthor() {
        return this.firstAuthor;
    }

    public final String getId() {
        return this.id;
    }

    public final int getItemCount() {
        return this.itemCount;
    }

    public final String getPublicationTime() {
        return this.publicationTime;
    }

    public final String getPublisherName() {
        return this.publisherName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }
}
