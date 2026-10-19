package com.yd.android_brand_mvp.model.reservation;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import defpackage.C$r8$backportedMethods$utility$Long$1$hashCode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReservationDetailBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bI\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\u0010¢\u0006\u0002\u0010#J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0010HÆ\u0003J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0005HÆ\u0003J\t\u0010J\u001a\u00020\u0014HÆ\u0003J\t\u0010K\u001a\u00020\u0005HÆ\u0003J\t\u0010L\u001a\u00020\u0017HÆ\u0003J\u000f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0003J\t\u0010N\u001a\u00020\u0017HÆ\u0003J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\t\u0010R\u001a\u00020\u0005HÆ\u0003J\t\u0010S\u001a\u00020\u0005HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\t\u0010U\u001a\u00020\u0005HÆ\u0003J\t\u0010V\u001a\u00020\u0010HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0005HÆ\u0003J\t\u0010Z\u001a\u00020\u0005HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\t\u0010\\\u001a\u00020\u0005HÆ\u0003J\t\u0010]\u001a\u00020\u0005HÆ\u0003J\u0093\u0002\u0010^\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u00172\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u0010HÆ\u0001J\u0013\u0010_\u001a\u00020\u00172\b\u0010`\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010a\u001a\u00020\u0010HÖ\u0001J\t\u0010b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\u001f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010%R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u001d\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010!\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0011\u0010\u001b\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010%R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b<\u0010%R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b=\u0010%R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010%R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010%R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010%R\u0011\u0010\"\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\bC\u0010A¨\u0006c"}, d2 = {"Lcom/yd/android_brand_mvp/model/reservation/ReservationDetailBean;", "", "siteBookingTypeId", "", "sponsorId", "", "sponsorName", "siteName", "siteBookingTypeName", "roomNum", "schoolId", "startTimeStr", "id", "floor", "bookingTime", "sponsorType", "", "siteTypeName", "approverId", "siteInfo", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSiteInfo;", "buildingName", "schedule", "", "signList", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSignListItemBean;", "signIn", AppMeasurementSdk.ConditionalUserProperty.NAME, "peppleNum", "siteId", "describe", "endTimeStr", "refuseReason", "status", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/yd/android_brand_mvp/model/reservation/ReservationSiteInfo;Ljava/lang/String;ZLjava/util/List;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getApproverId", "()Ljava/lang/String;", "getBookingTime", "getBuildingName", "getDescribe", "getEndTimeStr", "getFloor", "getId", "getName", "getPeppleNum", "getRefuseReason", "getRoomNum", "getSchedule", "()Z", "getSchoolId", "getSignIn", "getSignList", "()Ljava/util/List;", "getSiteBookingTypeId", "()J", "getSiteBookingTypeName", "getSiteId", "getSiteInfo", "()Lcom/yd/android_brand_mvp/model/reservation/ReservationSiteInfo;", "getSiteName", "getSiteTypeName", "getSponsorId", "getSponsorName", "getSponsorType", "()I", "getStartTimeStr", "getStatus", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ReservationDetailBean {
    private final String approverId;
    private final String bookingTime;
    private final String buildingName;
    private final String describe;
    private final String endTimeStr;
    private final String floor;
    private final String id;
    private final String name;
    private final String peppleNum;
    private final String refuseReason;
    private final String roomNum;
    private final boolean schedule;
    private final String schoolId;
    private final boolean signIn;
    private final List<ReservationSignListItemBean> signList;
    private final long siteBookingTypeId;
    private final String siteBookingTypeName;
    private final String siteId;
    private final ReservationSiteInfo siteInfo;
    private final String siteName;
    private final String siteTypeName;
    private final String sponsorId;
    private final String sponsorName;
    private final int sponsorType;
    private final String startTimeStr;
    private final int status;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSiteBookingTypeId() {
        return this.siteBookingTypeId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getFloor() {
        return this.floor;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getBookingTime() {
        return this.bookingTime;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final int getSponsorType() {
        return this.sponsorType;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSiteTypeName() {
        return this.siteTypeName;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getApproverId() {
        return this.approverId;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final ReservationSiteInfo getSiteInfo() {
        return this.siteInfo;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getBuildingName() {
        return this.buildingName;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final boolean getSchedule() {
        return this.schedule;
    }

    public final List<ReservationSignListItemBean> component18() {
        return this.signList;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final boolean getSignIn() {
        return this.signIn;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSponsorId() {
        return this.sponsorId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getPeppleNum() {
        return this.peppleNum;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getSiteId() {
        return this.siteId;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getDescribe() {
        return this.describe;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getEndTimeStr() {
        return this.endTimeStr;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getRefuseReason() {
        return this.refuseReason;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSponsorName() {
        return this.sponsorName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSiteName() {
        return this.siteName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSiteBookingTypeName() {
        return this.siteBookingTypeName;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRoomNum() {
        return this.roomNum;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getStartTimeStr() {
        return this.startTimeStr;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final ReservationDetailBean copy(long siteBookingTypeId, String sponsorId, String sponsorName, String siteName, String siteBookingTypeName, String roomNum, String schoolId, String startTimeStr, String id, String floor, String bookingTime, int sponsorType, String siteTypeName, String approverId, ReservationSiteInfo siteInfo, String buildingName, boolean schedule, List<ReservationSignListItemBean> signList, boolean signIn, String name, String peppleNum, String siteId, String describe, String endTimeStr, String refuseReason, int status) {
        Intrinsics.checkNotNullParameter(sponsorId, "sponsorId");
        Intrinsics.checkNotNullParameter(sponsorName, "sponsorName");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(siteBookingTypeName, "siteBookingTypeName");
        Intrinsics.checkNotNullParameter(roomNum, "roomNum");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(startTimeStr, "startTimeStr");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(floor, "floor");
        Intrinsics.checkNotNullParameter(bookingTime, "bookingTime");
        Intrinsics.checkNotNullParameter(siteTypeName, "siteTypeName");
        Intrinsics.checkNotNullParameter(approverId, "approverId");
        Intrinsics.checkNotNullParameter(siteInfo, "siteInfo");
        Intrinsics.checkNotNullParameter(buildingName, "buildingName");
        Intrinsics.checkNotNullParameter(signList, "signList");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(peppleNum, "peppleNum");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(describe, "describe");
        Intrinsics.checkNotNullParameter(endTimeStr, "endTimeStr");
        Intrinsics.checkNotNullParameter(refuseReason, "refuseReason");
        return new ReservationDetailBean(siteBookingTypeId, sponsorId, sponsorName, siteName, siteBookingTypeName, roomNum, schoolId, startTimeStr, id, floor, bookingTime, sponsorType, siteTypeName, approverId, siteInfo, buildingName, schedule, signList, signIn, name, peppleNum, siteId, describe, endTimeStr, refuseReason, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReservationDetailBean)) {
            return false;
        }
        ReservationDetailBean reservationDetailBean = (ReservationDetailBean) other;
        return this.siteBookingTypeId == reservationDetailBean.siteBookingTypeId && Intrinsics.areEqual(this.sponsorId, reservationDetailBean.sponsorId) && Intrinsics.areEqual(this.sponsorName, reservationDetailBean.sponsorName) && Intrinsics.areEqual(this.siteName, reservationDetailBean.siteName) && Intrinsics.areEqual(this.siteBookingTypeName, reservationDetailBean.siteBookingTypeName) && Intrinsics.areEqual(this.roomNum, reservationDetailBean.roomNum) && Intrinsics.areEqual(this.schoolId, reservationDetailBean.schoolId) && Intrinsics.areEqual(this.startTimeStr, reservationDetailBean.startTimeStr) && Intrinsics.areEqual(this.id, reservationDetailBean.id) && Intrinsics.areEqual(this.floor, reservationDetailBean.floor) && Intrinsics.areEqual(this.bookingTime, reservationDetailBean.bookingTime) && this.sponsorType == reservationDetailBean.sponsorType && Intrinsics.areEqual(this.siteTypeName, reservationDetailBean.siteTypeName) && Intrinsics.areEqual(this.approverId, reservationDetailBean.approverId) && Intrinsics.areEqual(this.siteInfo, reservationDetailBean.siteInfo) && Intrinsics.areEqual(this.buildingName, reservationDetailBean.buildingName) && this.schedule == reservationDetailBean.schedule && Intrinsics.areEqual(this.signList, reservationDetailBean.signList) && this.signIn == reservationDetailBean.signIn && Intrinsics.areEqual(this.name, reservationDetailBean.name) && Intrinsics.areEqual(this.peppleNum, reservationDetailBean.peppleNum) && Intrinsics.areEqual(this.siteId, reservationDetailBean.siteId) && Intrinsics.areEqual(this.describe, reservationDetailBean.describe) && Intrinsics.areEqual(this.endTimeStr, reservationDetailBean.endTimeStr) && Intrinsics.areEqual(this.refuseReason, reservationDetailBean.refuseReason) && this.status == reservationDetailBean.status;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v33, types: [int] */
    /* JADX WARN: Type inference failed for: r0v37, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30, types: [int] */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v48 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.siteBookingTypeId) * 31) + this.sponsorId.hashCode()) * 31) + this.sponsorName.hashCode()) * 31) + this.siteName.hashCode()) * 31) + this.siteBookingTypeName.hashCode()) * 31) + this.roomNum.hashCode()) * 31) + this.schoolId.hashCode()) * 31) + this.startTimeStr.hashCode()) * 31) + this.id.hashCode()) * 31) + this.floor.hashCode()) * 31) + this.bookingTime.hashCode()) * 31) + this.sponsorType) * 31) + this.siteTypeName.hashCode()) * 31) + this.approverId.hashCode()) * 31) + this.siteInfo.hashCode()) * 31) + this.buildingName.hashCode()) * 31;
        boolean z = this.schedule;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + this.signList.hashCode()) * 31;
        boolean z2 = this.signIn;
        return ((((((((((((((iHashCode2 + (z2 ? 1 : z2)) * 31) + this.name.hashCode()) * 31) + this.peppleNum.hashCode()) * 31) + this.siteId.hashCode()) * 31) + this.describe.hashCode()) * 31) + this.endTimeStr.hashCode()) * 31) + this.refuseReason.hashCode()) * 31) + this.status;
    }

    public String toString() {
        return "ReservationDetailBean(siteBookingTypeId=" + this.siteBookingTypeId + ", sponsorId=" + this.sponsorId + ", sponsorName=" + this.sponsorName + ", siteName=" + this.siteName + ", siteBookingTypeName=" + this.siteBookingTypeName + ", roomNum=" + this.roomNum + ", schoolId=" + this.schoolId + ", startTimeStr=" + this.startTimeStr + ", id=" + this.id + ", floor=" + this.floor + ", bookingTime=" + this.bookingTime + ", sponsorType=" + this.sponsorType + ", siteTypeName=" + this.siteTypeName + ", approverId=" + this.approverId + ", siteInfo=" + this.siteInfo + ", buildingName=" + this.buildingName + ", schedule=" + this.schedule + ", signList=" + this.signList + ", signIn=" + this.signIn + ", name=" + this.name + ", peppleNum=" + this.peppleNum + ", siteId=" + this.siteId + ", describe=" + this.describe + ", endTimeStr=" + this.endTimeStr + ", refuseReason=" + this.refuseReason + ", status=" + this.status + ')';
    }

    public ReservationDetailBean(long j, String sponsorId, String sponsorName, String siteName, String siteBookingTypeName, String roomNum, String schoolId, String startTimeStr, String id, String floor, String bookingTime, int i, String siteTypeName, String approverId, ReservationSiteInfo siteInfo, String buildingName, boolean z, List<ReservationSignListItemBean> signList, boolean z2, String name, String peppleNum, String siteId, String describe, String endTimeStr, String refuseReason, int i2) {
        Intrinsics.checkNotNullParameter(sponsorId, "sponsorId");
        Intrinsics.checkNotNullParameter(sponsorName, "sponsorName");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(siteBookingTypeName, "siteBookingTypeName");
        Intrinsics.checkNotNullParameter(roomNum, "roomNum");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(startTimeStr, "startTimeStr");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(floor, "floor");
        Intrinsics.checkNotNullParameter(bookingTime, "bookingTime");
        Intrinsics.checkNotNullParameter(siteTypeName, "siteTypeName");
        Intrinsics.checkNotNullParameter(approverId, "approverId");
        Intrinsics.checkNotNullParameter(siteInfo, "siteInfo");
        Intrinsics.checkNotNullParameter(buildingName, "buildingName");
        Intrinsics.checkNotNullParameter(signList, "signList");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(peppleNum, "peppleNum");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(describe, "describe");
        Intrinsics.checkNotNullParameter(endTimeStr, "endTimeStr");
        Intrinsics.checkNotNullParameter(refuseReason, "refuseReason");
        this.siteBookingTypeId = j;
        this.sponsorId = sponsorId;
        this.sponsorName = sponsorName;
        this.siteName = siteName;
        this.siteBookingTypeName = siteBookingTypeName;
        this.roomNum = roomNum;
        this.schoolId = schoolId;
        this.startTimeStr = startTimeStr;
        this.id = id;
        this.floor = floor;
        this.bookingTime = bookingTime;
        this.sponsorType = i;
        this.siteTypeName = siteTypeName;
        this.approverId = approverId;
        this.siteInfo = siteInfo;
        this.buildingName = buildingName;
        this.schedule = z;
        this.signList = signList;
        this.signIn = z2;
        this.name = name;
        this.peppleNum = peppleNum;
        this.siteId = siteId;
        this.describe = describe;
        this.endTimeStr = endTimeStr;
        this.refuseReason = refuseReason;
        this.status = i2;
    }

    public final long getSiteBookingTypeId() {
        return this.siteBookingTypeId;
    }

    public final String getSponsorId() {
        return this.sponsorId;
    }

    public final String getSponsorName() {
        return this.sponsorName;
    }

    public final String getSiteName() {
        return this.siteName;
    }

    public final String getSiteBookingTypeName() {
        return this.siteBookingTypeName;
    }

    public final String getRoomNum() {
        return this.roomNum;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getStartTimeStr() {
        return this.startTimeStr;
    }

    public final String getId() {
        return this.id;
    }

    public final String getFloor() {
        return this.floor;
    }

    public final String getBookingTime() {
        return this.bookingTime;
    }

    public final int getSponsorType() {
        return this.sponsorType;
    }

    public final String getSiteTypeName() {
        return this.siteTypeName;
    }

    public final String getApproverId() {
        return this.approverId;
    }

    public final ReservationSiteInfo getSiteInfo() {
        return this.siteInfo;
    }

    public final String getBuildingName() {
        return this.buildingName;
    }

    public final boolean getSchedule() {
        return this.schedule;
    }

    public /* synthetic */ ReservationDetailBean(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, String str11, String str12, ReservationSiteInfo reservationSiteInfo, String str13, boolean z, List list, boolean z2, String str14, String str15, String str16, String str17, String str18, String str19, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? "" : str5, (i3 & 64) != 0 ? "" : str6, (i3 & 128) != 0 ? "" : str7, (i3 & 256) != 0 ? "" : str8, (i3 & 512) != 0 ? "" : str9, (i3 & 1024) != 0 ? "" : str10, (i3 & 2048) != 0 ? 0 : i, (i3 & 4096) != 0 ? "" : str11, (i3 & 8192) != 0 ? "" : str12, reservationSiteInfo, (32768 & i3) != 0 ? "" : str13, (65536 & i3) != 0 ? false : z, (131072 & i3) != 0 ? new ArrayList() : list, (262144 & i3) != 0 ? false : z2, (524288 & i3) != 0 ? "" : str14, (1048576 & i3) != 0 ? "" : str15, (2097152 & i3) != 0 ? "" : str16, (4194304 & i3) != 0 ? "" : str17, (8388608 & i3) != 0 ? "" : str18, (16777216 & i3) != 0 ? "" : str19, (i3 & 33554432) != 0 ? 0 : i2);
    }

    public final List<ReservationSignListItemBean> getSignList() {
        return this.signList;
    }

    public final boolean getSignIn() {
        return this.signIn;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPeppleNum() {
        return this.peppleNum;
    }

    public final String getSiteId() {
        return this.siteId;
    }

    public final String getDescribe() {
        return this.describe;
    }

    public final String getEndTimeStr() {
        return this.endTimeStr;
    }

    public final String getRefuseReason() {
        return this.refuseReason;
    }

    public final int getStatus() {
        return this.status;
    }
}
