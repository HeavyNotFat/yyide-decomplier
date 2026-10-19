package com.yd.android_brand_mvp.model.reservation;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.tencent.qcloud.tim.uikit.utils.TUIKitConstants;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReservationSiteInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bµ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003¢\u0006\u0002\u0010\u0017J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\fHÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J¹\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u0003HÆ\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\fHÖ\u0001J\t\u0010B\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006C"}, d2 = {"Lcom/yd/android_brand_mvp/model/reservation/ReservationSiteInfo;", "", "siteTypeName", "", TUIKitConstants.Selection.LIST, "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSiteManageBean;", "space", "buildingId", "classesName", "buildingName", "versionStamp", "", CommentsHomeFragment.TYPE_CLASSESID, "rollName", "roomNum", "schoolId", AppMeasurementSdk.ConditionalUserProperty.NAME, "peppleNum", "openNumber", "id", "floor", "siteTypeId", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBuildingId", "()Ljava/lang/String;", "getBuildingName", "getClassesId", "getClassesName", "getFloor", "getId", "getList", "()Ljava/util/List;", "getName", "getOpenNumber", "getPeppleNum", "getRollName", "getRoomNum", "getSchoolId", "getSiteTypeId", "getSiteTypeName", "getSpace", "getVersionStamp", "()I", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ReservationSiteInfo {
    private final String buildingId;
    private final String buildingName;
    private final String classesId;
    private final String classesName;
    private final String floor;
    private final String id;
    private final List<ReservationSiteManageBean> list;
    private final String name;
    private final String openNumber;
    private final String peppleNum;
    private final String rollName;
    private final String roomNum;
    private final String schoolId;
    private final String siteTypeId;
    private final String siteTypeName;
    private final String space;
    private final int versionStamp;

    public ReservationSiteInfo() {
        this(null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSiteTypeName() {
        return this.siteTypeName;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getRoomNum() {
        return this.roomNum;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getPeppleNum() {
        return this.peppleNum;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getOpenNumber() {
        return this.openNumber;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getFloor() {
        return this.floor;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getSiteTypeId() {
        return this.siteTypeId;
    }

    public final List<ReservationSiteManageBean> component2() {
        return this.list;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSpace() {
        return this.space;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getBuildingId() {
        return this.buildingId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getClassesName() {
        return this.classesName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getBuildingName() {
        return this.buildingName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getVersionStamp() {
        return this.versionStamp;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getClassesId() {
        return this.classesId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getRollName() {
        return this.rollName;
    }

    public final ReservationSiteInfo copy(String siteTypeName, List<ReservationSiteManageBean> list, String space, String buildingId, String classesName, String buildingName, int versionStamp, String classesId, String rollName, String roomNum, String schoolId, String name, String peppleNum, String openNumber, String id, String floor, String siteTypeId) {
        Intrinsics.checkNotNullParameter(siteTypeName, "siteTypeName");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(space, "space");
        Intrinsics.checkNotNullParameter(buildingId, "buildingId");
        Intrinsics.checkNotNullParameter(classesName, "classesName");
        Intrinsics.checkNotNullParameter(buildingName, "buildingName");
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        Intrinsics.checkNotNullParameter(rollName, "rollName");
        Intrinsics.checkNotNullParameter(roomNum, "roomNum");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(peppleNum, "peppleNum");
        Intrinsics.checkNotNullParameter(openNumber, "openNumber");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(floor, "floor");
        Intrinsics.checkNotNullParameter(siteTypeId, "siteTypeId");
        return new ReservationSiteInfo(siteTypeName, list, space, buildingId, classesName, buildingName, versionStamp, classesId, rollName, roomNum, schoolId, name, peppleNum, openNumber, id, floor, siteTypeId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReservationSiteInfo)) {
            return false;
        }
        ReservationSiteInfo reservationSiteInfo = (ReservationSiteInfo) other;
        return Intrinsics.areEqual(this.siteTypeName, reservationSiteInfo.siteTypeName) && Intrinsics.areEqual(this.list, reservationSiteInfo.list) && Intrinsics.areEqual(this.space, reservationSiteInfo.space) && Intrinsics.areEqual(this.buildingId, reservationSiteInfo.buildingId) && Intrinsics.areEqual(this.classesName, reservationSiteInfo.classesName) && Intrinsics.areEqual(this.buildingName, reservationSiteInfo.buildingName) && this.versionStamp == reservationSiteInfo.versionStamp && Intrinsics.areEqual(this.classesId, reservationSiteInfo.classesId) && Intrinsics.areEqual(this.rollName, reservationSiteInfo.rollName) && Intrinsics.areEqual(this.roomNum, reservationSiteInfo.roomNum) && Intrinsics.areEqual(this.schoolId, reservationSiteInfo.schoolId) && Intrinsics.areEqual(this.name, reservationSiteInfo.name) && Intrinsics.areEqual(this.peppleNum, reservationSiteInfo.peppleNum) && Intrinsics.areEqual(this.openNumber, reservationSiteInfo.openNumber) && Intrinsics.areEqual(this.id, reservationSiteInfo.id) && Intrinsics.areEqual(this.floor, reservationSiteInfo.floor) && Intrinsics.areEqual(this.siteTypeId, reservationSiteInfo.siteTypeId);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((this.siteTypeName.hashCode() * 31) + this.list.hashCode()) * 31) + this.space.hashCode()) * 31) + this.buildingId.hashCode()) * 31) + this.classesName.hashCode()) * 31) + this.buildingName.hashCode()) * 31) + this.versionStamp) * 31) + this.classesId.hashCode()) * 31) + this.rollName.hashCode()) * 31) + this.roomNum.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.name.hashCode()) * 31) + this.peppleNum.hashCode()) * 31) + this.openNumber.hashCode()) * 31) + this.id.hashCode()) * 31) + this.floor.hashCode()) * 31) + this.siteTypeId.hashCode();
    }

    public String toString() {
        return "ReservationSiteInfo(siteTypeName=" + this.siteTypeName + ", list=" + this.list + ", space=" + this.space + ", buildingId=" + this.buildingId + ", classesName=" + this.classesName + ", buildingName=" + this.buildingName + ", versionStamp=" + this.versionStamp + ", classesId=" + this.classesId + ", rollName=" + this.rollName + ", roomNum=" + this.roomNum + ", schoolId=" + this.schoolId + ", name=" + this.name + ", peppleNum=" + this.peppleNum + ", openNumber=" + this.openNumber + ", id=" + this.id + ", floor=" + this.floor + ", siteTypeId=" + this.siteTypeId + ')';
    }

    public ReservationSiteInfo(String siteTypeName, List<ReservationSiteManageBean> list, String space, String buildingId, String classesName, String buildingName, int i, String classesId, String rollName, String roomNum, String schoolId, String name, String peppleNum, String openNumber, String id, String floor, String siteTypeId) {
        Intrinsics.checkNotNullParameter(siteTypeName, "siteTypeName");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(space, "space");
        Intrinsics.checkNotNullParameter(buildingId, "buildingId");
        Intrinsics.checkNotNullParameter(classesName, "classesName");
        Intrinsics.checkNotNullParameter(buildingName, "buildingName");
        Intrinsics.checkNotNullParameter(classesId, "classesId");
        Intrinsics.checkNotNullParameter(rollName, "rollName");
        Intrinsics.checkNotNullParameter(roomNum, "roomNum");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(peppleNum, "peppleNum");
        Intrinsics.checkNotNullParameter(openNumber, "openNumber");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(floor, "floor");
        Intrinsics.checkNotNullParameter(siteTypeId, "siteTypeId");
        this.siteTypeName = siteTypeName;
        this.list = list;
        this.space = space;
        this.buildingId = buildingId;
        this.classesName = classesName;
        this.buildingName = buildingName;
        this.versionStamp = i;
        this.classesId = classesId;
        this.rollName = rollName;
        this.roomNum = roomNum;
        this.schoolId = schoolId;
        this.name = name;
        this.peppleNum = peppleNum;
        this.openNumber = openNumber;
        this.id = id;
        this.floor = floor;
        this.siteTypeId = siteTypeId;
    }

    public final String getSiteTypeName() {
        return this.siteTypeName;
    }

    public /* synthetic */ ReservationSiteInfo(String str, List list, String str2, String str3, String str4, String str5, int i, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? new ArrayList() : list, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? 0 : i, (i2 & 128) != 0 ? "" : str6, (i2 & 256) != 0 ? "" : str7, (i2 & 512) != 0 ? "" : str8, (i2 & 1024) != 0 ? "" : str9, (i2 & 2048) != 0 ? "" : str10, (i2 & 4096) != 0 ? "0" : str11, (i2 & 8192) != 0 ? "" : str12, (i2 & 16384) != 0 ? "" : str13, (i2 & 32768) != 0 ? "" : str14, (i2 & 65536) != 0 ? "" : str15);
    }

    public final List<ReservationSiteManageBean> getList() {
        return this.list;
    }

    public final String getSpace() {
        return this.space;
    }

    public final String getBuildingId() {
        return this.buildingId;
    }

    public final String getClassesName() {
        return this.classesName;
    }

    public final String getBuildingName() {
        return this.buildingName;
    }

    public final int getVersionStamp() {
        return this.versionStamp;
    }

    public final String getClassesId() {
        return this.classesId;
    }

    public final String getRollName() {
        return this.rollName;
    }

    public final String getRoomNum() {
        return this.roomNum;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPeppleNum() {
        return this.peppleNum;
    }

    public final String getOpenNumber() {
        return this.openNumber;
    }

    public final String getId() {
        return this.id;
    }

    public final String getFloor() {
        return this.floor;
    }

    public final String getSiteTypeId() {
        return this.siteTypeId;
    }
}
