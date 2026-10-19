package com.yd.android_brand_mvp.model.dormitory;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DormitoryDetailsBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003Jm\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u000f¨\u0006-"}, d2 = {"Lcom/yd/android_brand_mvp/model/dormitory/DormitoryEachStudent;", "", "bedNo", "", "checkInStatus", "checkInTime", "classesName", "eltern", "gender", "id", "master", AppMeasurementSdk.ConditionalUserProperty.NAME, "phone", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBedNo", "()Ljava/lang/String;", "getCheckInStatus", "getCheckInTime", "getClassesName", "setClassesName", "(Ljava/lang/String;)V", "getEltern", "getGender", "getId", "getMaster", "getName", "setName", "getPhone", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DormitoryEachStudent {
    private final String bedNo;
    private final String checkInStatus;
    private final String checkInTime;
    private String classesName;
    private final String eltern;
    private final String gender;
    private final String id;
    private final String master;
    private String name;
    private final String phone;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBedNo() {
        return this.bedNo;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCheckInStatus() {
        return this.checkInStatus;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCheckInTime() {
        return this.checkInTime;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getClassesName() {
        return this.classesName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEltern() {
        return this.eltern;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getGender() {
        return this.gender;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getMaster() {
        return this.master;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public final DormitoryEachStudent copy(String bedNo, String checkInStatus, String checkInTime, String classesName, String eltern, String gender, String id, String master2, String name, String phone) {
        Intrinsics.checkNotNullParameter(bedNo, "bedNo");
        Intrinsics.checkNotNullParameter(checkInStatus, "checkInStatus");
        Intrinsics.checkNotNullParameter(checkInTime, "checkInTime");
        Intrinsics.checkNotNullParameter(classesName, "classesName");
        Intrinsics.checkNotNullParameter(eltern, "eltern");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(master2, "master");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phone, "phone");
        return new DormitoryEachStudent(bedNo, checkInStatus, checkInTime, classesName, eltern, gender, id, master2, name, phone);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DormitoryEachStudent)) {
            return false;
        }
        DormitoryEachStudent dormitoryEachStudent = (DormitoryEachStudent) other;
        return Intrinsics.areEqual(this.bedNo, dormitoryEachStudent.bedNo) && Intrinsics.areEqual(this.checkInStatus, dormitoryEachStudent.checkInStatus) && Intrinsics.areEqual(this.checkInTime, dormitoryEachStudent.checkInTime) && Intrinsics.areEqual(this.classesName, dormitoryEachStudent.classesName) && Intrinsics.areEqual(this.eltern, dormitoryEachStudent.eltern) && Intrinsics.areEqual(this.gender, dormitoryEachStudent.gender) && Intrinsics.areEqual(this.id, dormitoryEachStudent.id) && Intrinsics.areEqual(this.master, dormitoryEachStudent.master) && Intrinsics.areEqual(this.name, dormitoryEachStudent.name) && Intrinsics.areEqual(this.phone, dormitoryEachStudent.phone);
    }

    public int hashCode() {
        return (((((((((((((((((this.bedNo.hashCode() * 31) + this.checkInStatus.hashCode()) * 31) + this.checkInTime.hashCode()) * 31) + this.classesName.hashCode()) * 31) + this.eltern.hashCode()) * 31) + this.gender.hashCode()) * 31) + this.id.hashCode()) * 31) + this.master.hashCode()) * 31) + this.name.hashCode()) * 31) + this.phone.hashCode();
    }

    public String toString() {
        return "DormitoryEachStudent(bedNo=" + this.bedNo + ", checkInStatus=" + this.checkInStatus + ", checkInTime=" + this.checkInTime + ", classesName=" + this.classesName + ", eltern=" + this.eltern + ", gender=" + this.gender + ", id=" + this.id + ", master=" + this.master + ", name=" + this.name + ", phone=" + this.phone + ')';
    }

    public DormitoryEachStudent(String bedNo, String checkInStatus, String checkInTime, String classesName, String eltern, String gender, String id, String master2, String name, String phone) {
        Intrinsics.checkNotNullParameter(bedNo, "bedNo");
        Intrinsics.checkNotNullParameter(checkInStatus, "checkInStatus");
        Intrinsics.checkNotNullParameter(checkInTime, "checkInTime");
        Intrinsics.checkNotNullParameter(classesName, "classesName");
        Intrinsics.checkNotNullParameter(eltern, "eltern");
        Intrinsics.checkNotNullParameter(gender, "gender");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(master2, "master");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phone, "phone");
        this.bedNo = bedNo;
        this.checkInStatus = checkInStatus;
        this.checkInTime = checkInTime;
        this.classesName = classesName;
        this.eltern = eltern;
        this.gender = gender;
        this.id = id;
        this.master = master2;
        this.name = name;
        this.phone = phone;
    }

    public final String getBedNo() {
        return this.bedNo;
    }

    public final String getCheckInStatus() {
        return this.checkInStatus;
    }

    public final String getCheckInTime() {
        return this.checkInTime;
    }

    public final String getClassesName() {
        return this.classesName;
    }

    public final void setClassesName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.classesName = str;
    }

    public final String getEltern() {
        return this.eltern;
    }

    public final String getGender() {
        return this.gender;
    }

    public final String getId() {
        return this.id;
    }

    public final String getMaster() {
        return this.master;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getPhone() {
        return this.phone;
    }
}
