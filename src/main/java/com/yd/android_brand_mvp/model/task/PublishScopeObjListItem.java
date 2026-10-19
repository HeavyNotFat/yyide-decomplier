package com.yd.android_brand_mvp.model.task;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PublishScopeObjListItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/model/task/PublishScopeObjListItem;", "Landroid/os/Parcelable;", "objLevel", "", "id", AppMeasurementSdk.ConditionalUserProperty.NAME, "objType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getObjLevel", "getObjType", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PublishScopeObjListItem implements Parcelable {
    public static final Parcelable.Creator<PublishScopeObjListItem> CREATOR = new Creator();
    private final String id;
    private final String name;
    private final String objLevel;
    private final String objType;

    /* JADX INFO: compiled from: PublishScopeObjListItem.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PublishScopeObjListItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PublishScopeObjListItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PublishScopeObjListItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PublishScopeObjListItem[] newArray(int i) {
            return new PublishScopeObjListItem[i];
        }
    }

    public PublishScopeObjListItem() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ PublishScopeObjListItem copy$default(PublishScopeObjListItem publishScopeObjListItem, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = publishScopeObjListItem.objLevel;
        }
        if ((i & 2) != 0) {
            str2 = publishScopeObjListItem.id;
        }
        if ((i & 4) != 0) {
            str3 = publishScopeObjListItem.name;
        }
        if ((i & 8) != 0) {
            str4 = publishScopeObjListItem.objType;
        }
        return publishScopeObjListItem.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getObjLevel() {
        return this.objLevel;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getObjType() {
        return this.objType;
    }

    public final PublishScopeObjListItem copy(String objLevel, String id, String name, String objType) {
        Intrinsics.checkNotNullParameter(objLevel, "objLevel");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(objType, "objType");
        return new PublishScopeObjListItem(objLevel, id, name, objType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PublishScopeObjListItem)) {
            return false;
        }
        PublishScopeObjListItem publishScopeObjListItem = (PublishScopeObjListItem) other;
        return Intrinsics.areEqual(this.objLevel, publishScopeObjListItem.objLevel) && Intrinsics.areEqual(this.id, publishScopeObjListItem.id) && Intrinsics.areEqual(this.name, publishScopeObjListItem.name) && Intrinsics.areEqual(this.objType, publishScopeObjListItem.objType);
    }

    public int hashCode() {
        return (((((this.objLevel.hashCode() * 31) + this.id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.objType.hashCode();
    }

    public String toString() {
        return "PublishScopeObjListItem(objLevel=" + this.objLevel + ", id=" + this.id + ", name=" + this.name + ", objType=" + this.objType + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.objLevel);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.objType);
    }

    public PublishScopeObjListItem(String objLevel, String id, String name, String objType) {
        Intrinsics.checkNotNullParameter(objLevel, "objLevel");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(objType, "objType");
        this.objLevel = objLevel;
        this.id = id;
        this.name = name;
        this.objType = objType;
    }

    public /* synthetic */ PublishScopeObjListItem(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "0" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getObjLevel() {
        return this.objLevel;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getObjType() {
        return this.objType;
    }
}
