package com.yd.android_brand_mvp.model.task;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignTaskRecordListItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/model/task/SignTaskRecordListItem;", "Landroid/os/Parcelable;", "signTime", "", "fileUrlList", "", "(Ljava/lang/String;Ljava/util/List;)V", "getFileUrlList", "()Ljava/util/List;", "getSignTime", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SignTaskRecordListItem implements Parcelable {
    public static final Parcelable.Creator<SignTaskRecordListItem> CREATOR = new Creator();
    private final List<String> fileUrlList;
    private final String signTime;

    /* JADX INFO: compiled from: SignTaskRecordListItem.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SignTaskRecordListItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SignTaskRecordListItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SignTaskRecordListItem(parcel.readString(), parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SignTaskRecordListItem[] newArray(int i) {
            return new SignTaskRecordListItem[i];
        }
    }

    public SignTaskRecordListItem() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SignTaskRecordListItem copy$default(SignTaskRecordListItem signTaskRecordListItem, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signTaskRecordListItem.signTime;
        }
        if ((i & 2) != 0) {
            list = signTaskRecordListItem.fileUrlList;
        }
        return signTaskRecordListItem.copy(str, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSignTime() {
        return this.signTime;
    }

    public final List<String> component2() {
        return this.fileUrlList;
    }

    public final SignTaskRecordListItem copy(String signTime, List<String> fileUrlList) {
        Intrinsics.checkNotNullParameter(signTime, "signTime");
        Intrinsics.checkNotNullParameter(fileUrlList, "fileUrlList");
        return new SignTaskRecordListItem(signTime, fileUrlList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignTaskRecordListItem)) {
            return false;
        }
        SignTaskRecordListItem signTaskRecordListItem = (SignTaskRecordListItem) other;
        return Intrinsics.areEqual(this.signTime, signTaskRecordListItem.signTime) && Intrinsics.areEqual(this.fileUrlList, signTaskRecordListItem.fileUrlList);
    }

    public int hashCode() {
        return (this.signTime.hashCode() * 31) + this.fileUrlList.hashCode();
    }

    public String toString() {
        return "SignTaskRecordListItem(signTime=" + this.signTime + ", fileUrlList=" + this.fileUrlList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.signTime);
        parcel.writeStringList(this.fileUrlList);
    }

    public SignTaskRecordListItem(String signTime, List<String> fileUrlList) {
        Intrinsics.checkNotNullParameter(signTime, "signTime");
        Intrinsics.checkNotNullParameter(fileUrlList, "fileUrlList");
        this.signTime = signTime;
        this.fileUrlList = fileUrlList;
    }

    public final String getSignTime() {
        return this.signTime;
    }

    public /* synthetic */ SignTaskRecordListItem(String str, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new ArrayList() : arrayList);
    }

    public final List<String> getFileUrlList() {
        return this.fileUrlList;
    }
}
