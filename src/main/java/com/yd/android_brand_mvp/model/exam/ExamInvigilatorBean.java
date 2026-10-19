package com.yd.android_brand_mvp.model.exam;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExamInvigilatorBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/yd/android_brand_mvp/model/exam/ExamInvigilatorBean;", "Landroid/os/Parcelable;", "personId", "", "personType", "", "personName", "(Ljava/lang/String;ILjava/lang/String;)V", "getPersonId", "()Ljava/lang/String;", "getPersonName", "getPersonType", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ExamInvigilatorBean implements Parcelable {
    public static final Parcelable.Creator<ExamInvigilatorBean> CREATOR = new Creator();
    private final String personId;
    private final String personName;
    private final int personType;

    /* JADX INFO: compiled from: ExamInvigilatorBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ExamInvigilatorBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExamInvigilatorBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExamInvigilatorBean(parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ExamInvigilatorBean[] newArray(int i) {
            return new ExamInvigilatorBean[i];
        }
    }

    public ExamInvigilatorBean() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ ExamInvigilatorBean copy$default(ExamInvigilatorBean examInvigilatorBean, String str, int i, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = examInvigilatorBean.personId;
        }
        if ((i2 & 2) != 0) {
            i = examInvigilatorBean.personType;
        }
        if ((i2 & 4) != 0) {
            str2 = examInvigilatorBean.personName;
        }
        return examInvigilatorBean.copy(str, i, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPersonId() {
        return this.personId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getPersonType() {
        return this.personType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getPersonName() {
        return this.personName;
    }

    public final ExamInvigilatorBean copy(String personId, int personType, String personName) {
        Intrinsics.checkNotNullParameter(personId, "personId");
        Intrinsics.checkNotNullParameter(personName, "personName");
        return new ExamInvigilatorBean(personId, personType, personName);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExamInvigilatorBean)) {
            return false;
        }
        ExamInvigilatorBean examInvigilatorBean = (ExamInvigilatorBean) other;
        return Intrinsics.areEqual(this.personId, examInvigilatorBean.personId) && this.personType == examInvigilatorBean.personType && Intrinsics.areEqual(this.personName, examInvigilatorBean.personName);
    }

    public int hashCode() {
        return (((this.personId.hashCode() * 31) + this.personType) * 31) + this.personName.hashCode();
    }

    public String toString() {
        return "ExamInvigilatorBean(personId=" + this.personId + ", personType=" + this.personType + ", personName=" + this.personName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.personId);
        parcel.writeInt(this.personType);
        parcel.writeString(this.personName);
    }

    public ExamInvigilatorBean(String personId, int i, String personName) {
        Intrinsics.checkNotNullParameter(personId, "personId");
        Intrinsics.checkNotNullParameter(personName, "personName");
        this.personId = personId;
        this.personType = i;
        this.personName = personName;
    }

    public /* synthetic */ ExamInvigilatorBean(String str, int i, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 1 : i, (i2 & 4) != 0 ? "" : str2);
    }

    public final String getPersonId() {
        return this.personId;
    }

    public final int getPersonType() {
        return this.personType;
    }

    public final String getPersonName() {
        return this.personName;
    }
}
