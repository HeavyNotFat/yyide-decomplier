package com.yd.android_brand_mvp.model.custom;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.C$r8$backportedMethods$utility$Long$1$hashCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomJsonGroupBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0018HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/model/custom/ImageContentBean;", "Landroid/os/Parcelable;", "images", "", "", "intervalTime", "", "isLoop", "", "url", "(Ljava/util/List;JZLjava/lang/String;)V", "getImages", "()Ljava/util/List;", "getIntervalTime", "()J", "()Z", "getUrl", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ImageContentBean implements Parcelable {
    public static final Parcelable.Creator<ImageContentBean> CREATOR = new Creator();
    private final List<String> images;
    private final long intervalTime;
    private final boolean isLoop;
    private final String url;

    /* JADX INFO: compiled from: CustomJsonGroupBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ImageContentBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ImageContentBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ImageContentBean(parcel.createStringArrayList(), parcel.readLong(), parcel.readInt() != 0, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ImageContentBean[] newArray(int i) {
            return new ImageContentBean[i];
        }
    }

    public ImageContentBean() {
        this(null, 0L, false, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ImageContentBean copy$default(ImageContentBean imageContentBean, List list, long j, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = imageContentBean.images;
        }
        if ((i & 2) != 0) {
            j = imageContentBean.intervalTime;
        }
        long j2 = j;
        if ((i & 4) != 0) {
            z = imageContentBean.isLoop;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str = imageContentBean.url;
        }
        return imageContentBean.copy(list, j2, z2, str);
    }

    public final List<String> component1() {
        return this.images;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getIntervalTime() {
        return this.intervalTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsLoop() {
        return this.isLoop;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final ImageContentBean copy(List<String> images, long intervalTime, boolean isLoop, String url) {
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(url, "url");
        return new ImageContentBean(images, intervalTime, isLoop, url);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageContentBean)) {
            return false;
        }
        ImageContentBean imageContentBean = (ImageContentBean) other;
        return Intrinsics.areEqual(this.images, imageContentBean.images) && this.intervalTime == imageContentBean.intervalTime && this.isLoop == imageContentBean.isLoop && Intrinsics.areEqual(this.url, imageContentBean.url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = ((this.images.hashCode() * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.intervalTime)) * 31;
        boolean z = this.isLoop;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((iHashCode + r1) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "ImageContentBean(images=" + this.images + ", intervalTime=" + this.intervalTime + ", isLoop=" + this.isLoop + ", url=" + this.url + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.images);
        parcel.writeLong(this.intervalTime);
        parcel.writeInt(this.isLoop ? 1 : 0);
        parcel.writeString(this.url);
    }

    public ImageContentBean(List<String> images, long j, boolean z, String url) {
        Intrinsics.checkNotNullParameter(images, "images");
        Intrinsics.checkNotNullParameter(url, "url");
        this.images = images;
        this.intervalTime = j;
        this.isLoop = z;
        this.url = url;
    }

    public /* synthetic */ ImageContentBean(List list, long j, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? true : z, (i & 8) != 0 ? "" : str);
    }

    public final List<String> getImages() {
        return this.images;
    }

    public final long getIntervalTime() {
        return this.intervalTime;
    }

    public final boolean isLoop() {
        return this.isLoop;
    }

    public final String getUrl() {
        return this.url;
    }
}
