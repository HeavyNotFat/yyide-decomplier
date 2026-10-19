package com.yd.android_brand_mvp.model.exam;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamGroupItem.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\t\u0010#\u001a\u00020\u0007HÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\u0007HÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/model/exam/ExamGroupItem;", "Landroid/os/Parcelable;", "schoolId", "", "objectName", "id", "type", "", "examinationId", "objectId", "sitId", "arrangeType", "examinationArrange", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getArrangeType", "()I", "getExaminationArrange", "getExaminationId", "()Ljava/lang/String;", "getId", "getObjectId", "getObjectName", "getSchoolId", "getSitId", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExamGroupItem implements Parcelable {
    public static final Parcelable.Creator<ExamGroupItem> CREATOR = new Creator();
    private final int arrangeType;
    private final int examinationArrange;
    private final String examinationId;
    private final String id;
    private final String objectId;
    private final String objectName;
    private final String schoolId;
    private final String sitId;
    private final int type;

    /* JADX INFO: compiled from: ExamGroupItem.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExamGroupItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExamGroupItem createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExamGroupItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExamGroupItem[] newArray(int i) {
            return new ExamGroupItem[i];
        }
    }

    public ExamGroupItem() {
        this(null, null, null, 0, null, null, null, 0, 0, 511, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getObjectName() {
        return this.objectName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getExaminationId() {
        return this.examinationId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getObjectId() {
        return this.objectId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSitId() {
        return this.sitId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getArrangeType() {
        return this.arrangeType;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getExaminationArrange() {
        return this.examinationArrange;
    }

    public final ExamGroupItem copy(String schoolId, String objectName, String id, int type, String examinationId, String objectId, String sitId, int arrangeType, int examinationArrange) {
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(objectName, "objectName");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(examinationId, "examinationId");
        Intrinsics.checkNotNullParameter(objectId, "objectId");
        Intrinsics.checkNotNullParameter(sitId, "sitId");
        return new ExamGroupItem(schoolId, objectName, id, type, examinationId, objectId, sitId, arrangeType, examinationArrange);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamGroupItem)) {
            return false;
        }
        ExamGroupItem examGroupItem = (ExamGroupItem) other;
        return Intrinsics.areEqual(this.schoolId, examGroupItem.schoolId) && Intrinsics.areEqual(this.objectName, examGroupItem.objectName) && Intrinsics.areEqual(this.id, examGroupItem.id) && this.type == examGroupItem.type && Intrinsics.areEqual(this.examinationId, examGroupItem.examinationId) && Intrinsics.areEqual(this.objectId, examGroupItem.objectId) && Intrinsics.areEqual(this.sitId, examGroupItem.sitId) && this.arrangeType == examGroupItem.arrangeType && this.examinationArrange == examGroupItem.examinationArrange;
    }

    public int hashCode() {
        return (((((((((((((((this.schoolId.hashCode() * 31) + this.objectName.hashCode()) * 31) + this.id.hashCode()) * 31) + this.type) * 31) + this.examinationId.hashCode()) * 31) + this.objectId.hashCode()) * 31) + this.sitId.hashCode()) * 31) + this.arrangeType) * 31) + this.examinationArrange;
    }

    public String toString() {
        return "ExamGroupItem(schoolId=" + this.schoolId + ", objectName=" + this.objectName + ", id=" + this.id + ", type=" + this.type + ", examinationId=" + this.examinationId + ", objectId=" + this.objectId + ", sitId=" + this.sitId + ", arrangeType=" + this.arrangeType + ", examinationArrange=" + this.examinationArrange + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.schoolId);
        parcel.writeString(this.objectName);
        parcel.writeString(this.id);
        parcel.writeInt(this.type);
        parcel.writeString(this.examinationId);
        parcel.writeString(this.objectId);
        parcel.writeString(this.sitId);
        parcel.writeInt(this.arrangeType);
        parcel.writeInt(this.examinationArrange);
    }

    public ExamGroupItem(String schoolId, String objectName, String id, int i, String examinationId, String objectId, String sitId, int i2, int i3) {
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(objectName, "objectName");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(examinationId, "examinationId");
        Intrinsics.checkNotNullParameter(objectId, "objectId");
        Intrinsics.checkNotNullParameter(sitId, "sitId");
        this.schoolId = schoolId;
        this.objectName = objectName;
        this.id = id;
        this.type = i;
        this.examinationId = examinationId;
        this.objectId = objectId;
        this.sitId = sitId;
        this.arrangeType = i2;
        this.examinationArrange = i3;
    }

    public /* synthetic */ ExamGroupItem(String str, String str2, String str3, int i, String str4, String str5, String str6, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3, (i4 & 8) != 0 ? 0 : i, (i4 & 16) != 0 ? "" : str4, (i4 & 32) != 0 ? "" : str5, (i4 & 64) == 0 ? str6 : "", (i4 & 128) == 0 ? i2 : 0, (i4 & 256) != 0 ? 1 : i3);
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getObjectName() {
        return this.objectName;
    }

    public final String getId() {
        return this.id;
    }

    public final int getType() {
        return this.type;
    }

    public final String getExaminationId() {
        return this.examinationId;
    }

    public final String getObjectId() {
        return this.objectId;
    }

    public final String getSitId() {
        return this.sitId;
    }

    public final int getArrangeType() {
        return this.arrangeType;
    }

    public final int getExaminationArrange() {
        return this.examinationArrange;
    }
}
