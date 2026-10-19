package com.yd.android_brand_mvp.model.message;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\b\"\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/model/message/DocumentBean;", "Landroid/os/Parcelable;", "attachment", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "suffix", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAttachment", "()Ljava/lang/String;", "getName", "getSuffix", "setSuffix", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DocumentBean implements Parcelable {
    public static final Parcelable.Creator<DocumentBean> CREATOR = new Creator();
    private final String attachment;
    private final String name;
    private String suffix;

    /* JADX INFO: compiled from: DocumentBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DocumentBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DocumentBean(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final DocumentBean[] newArray(int i) {
            return new DocumentBean[i];
        }
    }

    public DocumentBean() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ DocumentBean copy$default(DocumentBean documentBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = documentBean.attachment;
        }
        if ((i & 2) != 0) {
            str2 = documentBean.name;
        }
        if ((i & 4) != 0) {
            str3 = documentBean.suffix;
        }
        return documentBean.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAttachment() {
        return this.attachment;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSuffix() {
        return this.suffix;
    }

    public final DocumentBean copy(String attachment, String name, String suffix) {
        Intrinsics.checkNotNullParameter(attachment, "attachment");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return new DocumentBean(attachment, name, suffix);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DocumentBean)) {
            return false;
        }
        DocumentBean documentBean = (DocumentBean) other;
        return Intrinsics.areEqual(this.attachment, documentBean.attachment) && Intrinsics.areEqual(this.name, documentBean.name) && Intrinsics.areEqual(this.suffix, documentBean.suffix);
    }

    public int hashCode() {
        return (((this.attachment.hashCode() * 31) + this.name.hashCode()) * 31) + this.suffix.hashCode();
    }

    public String toString() {
        return "DocumentBean(attachment=" + this.attachment + ", name=" + this.name + ", suffix=" + this.suffix + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.attachment);
        parcel.writeString(this.name);
        parcel.writeString(this.suffix);
    }

    public DocumentBean(String attachment, String name, String suffix) {
        Intrinsics.checkNotNullParameter(attachment, "attachment");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        this.attachment = attachment;
        this.name = name;
        this.suffix = suffix;
    }

    public /* synthetic */ DocumentBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getAttachment() {
        return this.attachment;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSuffix() {
        return this.suffix;
    }

    public final void setSuffix(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.suffix = str;
    }
}
