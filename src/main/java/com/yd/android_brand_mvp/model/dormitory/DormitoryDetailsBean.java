package com.yd.android_brand_mvp.model.dormitory;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DormitoryDetailsBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0001\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0003¢\u0006\u0002\u0010\u0012J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u000fHÆ\u0003J\t\u0010%\u001a\u00020\u000fHÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010)\u001a\u00020\u0001HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0087\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0003HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\u000fHÖ\u0001J\t\u00104\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014¨\u00065"}, d2 = {"Lcom/yd/android_brand_mvp/model/dormitory/DormitoryDetailsBean;", "", "buildingAdministrator", "", "buildingAdministratorPhone", "eachStudent", "", "Lcom/yd/android_brand_mvp/model/dormitory/DormitoryEachStudent;", "educationBusiness", "roomAdministrator", "roomName", "roomNo", "roomType", "schoolId", "roomTypeInt", "", "residentsCount", "siteId", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getBuildingAdministrator", "()Ljava/lang/String;", "getBuildingAdministratorPhone", "getEachStudent", "()Ljava/util/List;", "getEducationBusiness", "()Ljava/lang/Object;", "getResidentsCount", "()I", "getRoomAdministrator", "getRoomName", "getRoomNo", "getRoomType", "getRoomTypeInt", "getSchoolId", "getSiteId", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class DormitoryDetailsBean {
    private final String buildingAdministrator;
    private final String buildingAdministratorPhone;
    private final List<DormitoryEachStudent> eachStudent;
    private final Object educationBusiness;
    private final int residentsCount;
    private final String roomAdministrator;
    private final String roomName;
    private final String roomNo;
    private final String roomType;
    private final int roomTypeInt;
    private final String schoolId;
    private final String siteId;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBuildingAdministrator() {
        return this.buildingAdministrator;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final int getRoomTypeInt() {
        return this.roomTypeInt;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getResidentsCount() {
        return this.residentsCount;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getSiteId() {
        return this.siteId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getBuildingAdministratorPhone() {
        return this.buildingAdministratorPhone;
    }

    public final List<DormitoryEachStudent> component3() {
        return this.eachStudent;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Object getEducationBusiness() {
        return this.educationBusiness;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRoomAdministrator() {
        return this.roomAdministrator;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRoomName() {
        return this.roomName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getRoomNo() {
        return this.roomNo;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getRoomType() {
        return this.roomType;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    public final DormitoryDetailsBean copy(String buildingAdministrator, String buildingAdministratorPhone, List<DormitoryEachStudent> eachStudent, Object educationBusiness, String roomAdministrator, String roomName, String roomNo, String roomType, String schoolId, int roomTypeInt, int residentsCount, String siteId) {
        Intrinsics.checkNotNullParameter(buildingAdministrator, "buildingAdministrator");
        Intrinsics.checkNotNullParameter(buildingAdministratorPhone, "buildingAdministratorPhone");
        Intrinsics.checkNotNullParameter(eachStudent, "eachStudent");
        Intrinsics.checkNotNullParameter(educationBusiness, "educationBusiness");
        Intrinsics.checkNotNullParameter(roomAdministrator, "roomAdministrator");
        Intrinsics.checkNotNullParameter(roomName, "roomName");
        Intrinsics.checkNotNullParameter(roomNo, "roomNo");
        Intrinsics.checkNotNullParameter(roomType, "roomType");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        return new DormitoryDetailsBean(buildingAdministrator, buildingAdministratorPhone, eachStudent, educationBusiness, roomAdministrator, roomName, roomNo, roomType, schoolId, roomTypeInt, residentsCount, siteId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DormitoryDetailsBean)) {
            return false;
        }
        DormitoryDetailsBean dormitoryDetailsBean = (DormitoryDetailsBean) other;
        return Intrinsics.areEqual(this.buildingAdministrator, dormitoryDetailsBean.buildingAdministrator) && Intrinsics.areEqual(this.buildingAdministratorPhone, dormitoryDetailsBean.buildingAdministratorPhone) && Intrinsics.areEqual(this.eachStudent, dormitoryDetailsBean.eachStudent) && Intrinsics.areEqual(this.educationBusiness, dormitoryDetailsBean.educationBusiness) && Intrinsics.areEqual(this.roomAdministrator, dormitoryDetailsBean.roomAdministrator) && Intrinsics.areEqual(this.roomName, dormitoryDetailsBean.roomName) && Intrinsics.areEqual(this.roomNo, dormitoryDetailsBean.roomNo) && Intrinsics.areEqual(this.roomType, dormitoryDetailsBean.roomType) && Intrinsics.areEqual(this.schoolId, dormitoryDetailsBean.schoolId) && this.roomTypeInt == dormitoryDetailsBean.roomTypeInt && this.residentsCount == dormitoryDetailsBean.residentsCount && Intrinsics.areEqual(this.siteId, dormitoryDetailsBean.siteId);
    }

    public int hashCode() {
        return (((((((((((((((((((((this.buildingAdministrator.hashCode() * 31) + this.buildingAdministratorPhone.hashCode()) * 31) + this.eachStudent.hashCode()) * 31) + this.educationBusiness.hashCode()) * 31) + this.roomAdministrator.hashCode()) * 31) + this.roomName.hashCode()) * 31) + this.roomNo.hashCode()) * 31) + this.roomType.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.roomTypeInt) * 31) + this.residentsCount) * 31) + this.siteId.hashCode();
    }

    public String toString() {
        return "DormitoryDetailsBean(buildingAdministrator=" + this.buildingAdministrator + ", buildingAdministratorPhone=" + this.buildingAdministratorPhone + ", eachStudent=" + this.eachStudent + ", educationBusiness=" + this.educationBusiness + ", roomAdministrator=" + this.roomAdministrator + ", roomName=" + this.roomName + ", roomNo=" + this.roomNo + ", roomType=" + this.roomType + ", schoolId=" + this.schoolId + ", roomTypeInt=" + this.roomTypeInt + ", residentsCount=" + this.residentsCount + ", siteId=" + this.siteId + ')';
    }

    public DormitoryDetailsBean(String buildingAdministrator, String buildingAdministratorPhone, List<DormitoryEachStudent> eachStudent, Object educationBusiness, String roomAdministrator, String roomName, String roomNo, String roomType, String schoolId, int i, int i2, String siteId) {
        Intrinsics.checkNotNullParameter(buildingAdministrator, "buildingAdministrator");
        Intrinsics.checkNotNullParameter(buildingAdministratorPhone, "buildingAdministratorPhone");
        Intrinsics.checkNotNullParameter(eachStudent, "eachStudent");
        Intrinsics.checkNotNullParameter(educationBusiness, "educationBusiness");
        Intrinsics.checkNotNullParameter(roomAdministrator, "roomAdministrator");
        Intrinsics.checkNotNullParameter(roomName, "roomName");
        Intrinsics.checkNotNullParameter(roomNo, "roomNo");
        Intrinsics.checkNotNullParameter(roomType, "roomType");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        this.buildingAdministrator = buildingAdministrator;
        this.buildingAdministratorPhone = buildingAdministratorPhone;
        this.eachStudent = eachStudent;
        this.educationBusiness = educationBusiness;
        this.roomAdministrator = roomAdministrator;
        this.roomName = roomName;
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.schoolId = schoolId;
        this.roomTypeInt = i;
        this.residentsCount = i2;
        this.siteId = siteId;
    }

    public final String getBuildingAdministrator() {
        return this.buildingAdministrator;
    }

    public final String getBuildingAdministratorPhone() {
        return this.buildingAdministratorPhone;
    }

    public final List<DormitoryEachStudent> getEachStudent() {
        return this.eachStudent;
    }

    public final Object getEducationBusiness() {
        return this.educationBusiness;
    }

    public final String getRoomAdministrator() {
        return this.roomAdministrator;
    }

    public final String getRoomName() {
        return this.roomName;
    }

    public final String getRoomNo() {
        return this.roomNo;
    }

    public final String getRoomType() {
        return this.roomType;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final int getRoomTypeInt() {
        return this.roomTypeInt;
    }

    public final int getResidentsCount() {
        return this.residentsCount;
    }

    public final String getSiteId() {
        return this.siteId;
    }
}
