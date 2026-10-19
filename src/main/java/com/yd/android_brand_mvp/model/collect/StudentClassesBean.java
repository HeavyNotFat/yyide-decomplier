package com.yd.android_brand_mvp.model.collect;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StudentClassesBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/StudentClassesBean;", "Landroid/os/Parcelable;", "id", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class StudentClassesBean implements Parcelable {
    public static final Parcelable.Creator<StudentClassesBean> CREATOR = new Creator();
    private final String id;
    private final String name;

    /* JADX INFO: compiled from: StudentClassesBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<StudentClassesBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StudentClassesBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new StudentClassesBean(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final StudentClassesBean[] newArray(int i) {
            return new StudentClassesBean[i];
        }
    }

    public static /* synthetic */ StudentClassesBean copy$default(StudentClassesBean studentClassesBean, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = studentClassesBean.id;
        }
        if ((i & 2) != 0) {
            str2 = studentClassesBean.name;
        }
        return studentClassesBean.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final StudentClassesBean copy(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        return new StudentClassesBean(id, name);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StudentClassesBean)) {
            return false;
        }
        StudentClassesBean studentClassesBean = (StudentClassesBean) other;
        return Intrinsics.areEqual(this.id, studentClassesBean.id) && Intrinsics.areEqual(this.name, studentClassesBean.name);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "StudentClassesBean(id=" + this.id + ", name=" + this.name + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
    }

    public StudentClassesBean(String id, String name) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        this.id = id;
        this.name = name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }
}
