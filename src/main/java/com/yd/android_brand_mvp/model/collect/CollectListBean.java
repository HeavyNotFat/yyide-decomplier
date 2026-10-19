package com.yd.android_brand_mvp.model.collect;

import android.os.Parcel;
import android.os.Parcelable;
import com.heytap.mcssdk.a.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CollectListBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0006HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001J\u0019\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006,"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/CollectListBean;", "Landroid/os/Parcelable;", "formId", "", "creator", "alreadyDidPersonCount", "", "creatorId", a.h, "id", "title", "gonnaDoPersonCount", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAlreadyDidPersonCount", "()I", "getCreator", "()Ljava/lang/String;", "getCreatorId", "getDescription", "getFormId", "getGonnaDoPersonCount", "getId", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CollectListBean implements Parcelable {
    public static final Parcelable.Creator<CollectListBean> CREATOR = new Creator();
    private final int alreadyDidPersonCount;
    private final String creator;
    private final String creatorId;
    private final String description;
    private final String formId;
    private final int gonnaDoPersonCount;
    private final String id;
    private final String title;

    /* JADX INFO: compiled from: CollectListBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CollectListBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CollectListBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CollectListBean(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CollectListBean[] newArray(int i) {
            return new CollectListBean[i];
        }
    }

    public CollectListBean() {
        this(null, null, 0, null, null, null, null, 0, 255, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFormId() {
        return this.formId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCreator() {
        return this.creator;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getAlreadyDidPersonCount() {
        return this.alreadyDidPersonCount;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCreatorId() {
        return this.creatorId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getGonnaDoPersonCount() {
        return this.gonnaDoPersonCount;
    }

    public final CollectListBean copy(String formId, String creator, int alreadyDidPersonCount, String creatorId, String description, String id, String title, int gonnaDoPersonCount) {
        Intrinsics.checkNotNullParameter(formId, "formId");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(creatorId, "creatorId");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        return new CollectListBean(formId, creator, alreadyDidPersonCount, creatorId, description, id, title, gonnaDoPersonCount);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CollectListBean)) {
            return false;
        }
        CollectListBean collectListBean = (CollectListBean) other;
        return Intrinsics.areEqual(this.formId, collectListBean.formId) && Intrinsics.areEqual(this.creator, collectListBean.creator) && this.alreadyDidPersonCount == collectListBean.alreadyDidPersonCount && Intrinsics.areEqual(this.creatorId, collectListBean.creatorId) && Intrinsics.areEqual(this.description, collectListBean.description) && Intrinsics.areEqual(this.id, collectListBean.id) && Intrinsics.areEqual(this.title, collectListBean.title) && this.gonnaDoPersonCount == collectListBean.gonnaDoPersonCount;
    }

    public int hashCode() {
        return (((((((((((((this.formId.hashCode() * 31) + this.creator.hashCode()) * 31) + this.alreadyDidPersonCount) * 31) + this.creatorId.hashCode()) * 31) + this.description.hashCode()) * 31) + this.id.hashCode()) * 31) + this.title.hashCode()) * 31) + this.gonnaDoPersonCount;
    }

    public String toString() {
        return "CollectListBean(formId=" + this.formId + ", creator=" + this.creator + ", alreadyDidPersonCount=" + this.alreadyDidPersonCount + ", creatorId=" + this.creatorId + ", description=" + this.description + ", id=" + this.id + ", title=" + this.title + ", gonnaDoPersonCount=" + this.gonnaDoPersonCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.formId);
        parcel.writeString(this.creator);
        parcel.writeInt(this.alreadyDidPersonCount);
        parcel.writeString(this.creatorId);
        parcel.writeString(this.description);
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeInt(this.gonnaDoPersonCount);
    }

    public CollectListBean(String formId, String creator, int i, String creatorId, String description, String id, String title, int i2) {
        Intrinsics.checkNotNullParameter(formId, "formId");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Intrinsics.checkNotNullParameter(creatorId, "creatorId");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        this.formId = formId;
        this.creator = creator;
        this.alreadyDidPersonCount = i;
        this.creatorId = creatorId;
        this.description = description;
        this.id = id;
        this.title = title;
        this.gonnaDoPersonCount = i2;
    }

    public /* synthetic */ CollectListBean(String str, String str2, int i, String str3, String str4, String str5, String str6, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "0" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) == 0 ? str5 : "0", (i3 & 64) == 0 ? str6 : "", (i3 & 128) == 0 ? i2 : 0);
    }

    public final String getFormId() {
        return this.formId;
    }

    public final String getCreator() {
        return this.creator;
    }

    public final int getAlreadyDidPersonCount() {
        return this.alreadyDidPersonCount;
    }

    public final String getCreatorId() {
        return this.creatorId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getGonnaDoPersonCount() {
        return this.gonnaDoPersonCount;
    }
}
