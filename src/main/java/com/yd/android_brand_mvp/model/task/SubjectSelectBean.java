package com.yd.android_brand_mvp.model.task;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubjectSelectBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006!"}, d2 = {"Lcom/yd/android_brand_mvp/model/task/SubjectSelectBean;", "Landroid/os/Parcelable;", "subjectId", "", "subjectName", "isSelect", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "()Z", "setSelect", "(Z)V", "getSubjectId", "()Ljava/lang/String;", "setSubjectId", "(Ljava/lang/String;)V", "getSubjectName", "setSubjectName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SubjectSelectBean implements Parcelable {
    public static final Parcelable.Creator<SubjectSelectBean> CREATOR = new Creator();
    private boolean isSelect;

    @SerializedName("id")
    private String subjectId;

    @SerializedName(AppMeasurementSdk.ConditionalUserProperty.NAME)
    private String subjectName;

    /* JADX INFO: compiled from: SubjectSelectBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SubjectSelectBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SubjectSelectBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SubjectSelectBean(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SubjectSelectBean[] newArray(int i) {
            return new SubjectSelectBean[i];
        }
    }

    public SubjectSelectBean() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ SubjectSelectBean copy$default(SubjectSelectBean subjectSelectBean, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subjectSelectBean.subjectId;
        }
        if ((i & 2) != 0) {
            str2 = subjectSelectBean.subjectName;
        }
        if ((i & 4) != 0) {
            z = subjectSelectBean.isSelect;
        }
        return subjectSelectBean.copy(str, str2, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSubjectId() {
        return this.subjectId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSubjectName() {
        return this.subjectName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final SubjectSelectBean copy(String subjectId, String subjectName, boolean isSelect) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        return new SubjectSelectBean(subjectId, subjectName, isSelect);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubjectSelectBean)) {
            return false;
        }
        SubjectSelectBean subjectSelectBean = (SubjectSelectBean) other;
        return Intrinsics.areEqual(this.subjectId, subjectSelectBean.subjectId) && Intrinsics.areEqual(this.subjectName, subjectSelectBean.subjectName) && this.isSelect == subjectSelectBean.isSelect;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((this.subjectId.hashCode() * 31) + this.subjectName.hashCode()) * 31;
        boolean z = this.isSelect;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "SubjectSelectBean(subjectId=" + this.subjectId + ", subjectName=" + this.subjectName + ", isSelect=" + this.isSelect + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.subjectId);
        parcel.writeString(this.subjectName);
        parcel.writeInt(this.isSelect ? 1 : 0);
    }

    public SubjectSelectBean(String subjectId, String subjectName, boolean z) {
        Intrinsics.checkNotNullParameter(subjectId, "subjectId");
        Intrinsics.checkNotNullParameter(subjectName, "subjectName");
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.isSelect = z;
    }

    public /* synthetic */ SubjectSelectBean(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z);
    }

    public final String getSubjectId() {
        return this.subjectId;
    }

    public final void setSubjectId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subjectId = str;
    }

    public final String getSubjectName() {
        return this.subjectName;
    }

    public final void setSubjectName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subjectName = str;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }
}
