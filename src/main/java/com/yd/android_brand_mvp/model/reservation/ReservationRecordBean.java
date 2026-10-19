package com.yd.android_brand_mvp.model.reservation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReservationRecordBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\u0002\u0010\"J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0012HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0005HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0005HÆ\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020!0 HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\u009d\u0002\u0010]\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00052\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 HÆ\u0001J\t\u0010^\u001a\u00020\u0005HÖ\u0001J\u0013\u0010_\u001a\u00020\u00122\b\u0010`\u001a\u0004\u0018\u00010aHÖ\u0003J\t\u0010b\u001a\u00020\u0005HÖ\u0001J\t\u0010c\u001a\u00020\u0003HÖ\u0001J\u0019\u0010d\u001a\u00020e2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 ¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u00106R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010$R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010$R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010$¨\u0006i"}, d2 = {"Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "Landroid/os/Parcelable;", "bookingTime", "", "sponsorType", "", "siteBookingTypeId", "siteTypeName", "approverId", "sponsorId", "sponsorName", "siteName", "siteBookingTypeName", "buildingName", "schedule", "roomNum", "schoolId", "signIn", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "peppleNum", "siteId", "startTimeStr", "describe", "endTimeStr", "id", "floor", "refuseReason", "status", "week", "siteBookingTypeCode", "signList", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationSignListItemBean;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;)V", "getApproverId", "()Ljava/lang/String;", "getBookingTime", "getBuildingName", "getDescribe", "getEndTimeStr", "getFloor", "getId", "getName", "getPeppleNum", "getRefuseReason", "getRoomNum", "getSchedule", "getSchoolId", "getSignIn", "()Z", "getSignList", "()Ljava/util/List;", "getSiteBookingTypeCode", "()I", "getSiteBookingTypeId", "getSiteBookingTypeName", "getSiteId", "getSiteName", "getSiteTypeName", "getSponsorId", "getSponsorName", "getSponsorType", "getStartTimeStr", "getStatus", "getWeek", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ReservationRecordBean implements Parcelable {
    public static final Parcelable.Creator<ReservationRecordBean> CREATOR = new Creator();
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
    private final String schedule;
    private final String schoolId;
    private final boolean signIn;
    private final List<ReservationSignListItemBean> signList;
    private final int siteBookingTypeCode;
    private final String siteBookingTypeId;
    private final String siteBookingTypeName;
    private final String siteId;
    private final String siteName;
    private final String siteTypeName;
    private final String sponsorId;
    private final String sponsorName;
    private final int sponsorType;
    private final String startTimeStr;
    private final String status;
    private final String week;

    /* JADX INFO: compiled from: ReservationRecordBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ReservationRecordBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ReservationRecordBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            int i = parcel.readInt();
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            String string4 = parcel.readString();
            String string5 = parcel.readString();
            String string6 = parcel.readString();
            String string7 = parcel.readString();
            String string8 = parcel.readString();
            String string9 = parcel.readString();
            String string10 = parcel.readString();
            String string11 = parcel.readString();
            String string12 = parcel.readString();
            boolean z = parcel.readInt() != 0;
            String string13 = parcel.readString();
            String string14 = parcel.readString();
            String string15 = parcel.readString();
            String string16 = parcel.readString();
            String string17 = parcel.readString();
            String string18 = parcel.readString();
            String string19 = parcel.readString();
            String string20 = parcel.readString();
            String string21 = parcel.readString();
            String string22 = parcel.readString();
            String string23 = parcel.readString();
            int i2 = parcel.readInt();
            int i3 = parcel.readInt();
            ArrayList arrayList = new ArrayList(i3);
            int i4 = 0;
            while (i4 != i3) {
                arrayList.add(ReservationSignListItemBean.CREATOR.createFromParcel(parcel));
                i4++;
                i3 = i3;
            }
            return new ReservationRecordBean(string, i, string2, string3, string4, string5, string6, string7, string8, string9, string10, string11, string12, z, string13, string14, string15, string16, string17, string18, string19, string20, string21, string22, string23, i2, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ReservationRecordBean[] newArray(int i) {
            return new ReservationRecordBean[i];
        }
    }

    public ReservationRecordBean() {
        this(null, 0, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, 0, null, 134217727, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getBookingTime() {
        return this.bookingTime;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getBuildingName() {
        return this.buildingName;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getSchedule() {
        return this.schedule;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getRoomNum() {
        return this.roomNum;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final boolean getSignIn() {
        return this.signIn;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getPeppleNum() {
        return this.peppleNum;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getSiteId() {
        return this.siteId;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getStartTimeStr() {
        return this.startTimeStr;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getDescribe() {
        return this.describe;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getSponsorType() {
        return this.sponsorType;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getEndTimeStr() {
        return this.endTimeStr;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getFloor() {
        return this.floor;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getRefuseReason() {
        return this.refuseReason;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final String getWeek() {
        return this.week;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final int getSiteBookingTypeCode() {
        return this.siteBookingTypeCode;
    }

    public final List<ReservationSignListItemBean> component27() {
        return this.signList;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSiteBookingTypeId() {
        return this.siteBookingTypeId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSiteTypeName() {
        return this.siteTypeName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getApproverId() {
        return this.approverId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSponsorId() {
        return this.sponsorId;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getSponsorName() {
        return this.sponsorName;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getSiteName() {
        return this.siteName;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getSiteBookingTypeName() {
        return this.siteBookingTypeName;
    }

    public final ReservationRecordBean copy(String bookingTime, int sponsorType, String siteBookingTypeId, String siteTypeName, String approverId, String sponsorId, String sponsorName, String siteName, String siteBookingTypeName, String buildingName, String schedule, String roomNum, String schoolId, boolean signIn, String name, String peppleNum, String siteId, String startTimeStr, String describe, String endTimeStr, String id, String floor, String refuseReason, String status, String week, int siteBookingTypeCode, List<ReservationSignListItemBean> signList) {
        Intrinsics.checkNotNullParameter(bookingTime, "bookingTime");
        Intrinsics.checkNotNullParameter(siteBookingTypeId, "siteBookingTypeId");
        Intrinsics.checkNotNullParameter(siteTypeName, "siteTypeName");
        Intrinsics.checkNotNullParameter(approverId, "approverId");
        Intrinsics.checkNotNullParameter(sponsorId, "sponsorId");
        Intrinsics.checkNotNullParameter(sponsorName, "sponsorName");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(siteBookingTypeName, "siteBookingTypeName");
        Intrinsics.checkNotNullParameter(buildingName, "buildingName");
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        Intrinsics.checkNotNullParameter(roomNum, "roomNum");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(peppleNum, "peppleNum");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(startTimeStr, "startTimeStr");
        Intrinsics.checkNotNullParameter(describe, "describe");
        Intrinsics.checkNotNullParameter(endTimeStr, "endTimeStr");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(floor, "floor");
        Intrinsics.checkNotNullParameter(refuseReason, "refuseReason");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(week, "week");
        Intrinsics.checkNotNullParameter(signList, "signList");
        return new ReservationRecordBean(bookingTime, sponsorType, siteBookingTypeId, siteTypeName, approverId, sponsorId, sponsorName, siteName, siteBookingTypeName, buildingName, schedule, roomNum, schoolId, signIn, name, peppleNum, siteId, startTimeStr, describe, endTimeStr, id, floor, refuseReason, status, week, siteBookingTypeCode, signList);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReservationRecordBean)) {
            return false;
        }
        ReservationRecordBean reservationRecordBean = (ReservationRecordBean) other;
        return Intrinsics.areEqual(this.bookingTime, reservationRecordBean.bookingTime) && this.sponsorType == reservationRecordBean.sponsorType && Intrinsics.areEqual(this.siteBookingTypeId, reservationRecordBean.siteBookingTypeId) && Intrinsics.areEqual(this.siteTypeName, reservationRecordBean.siteTypeName) && Intrinsics.areEqual(this.approverId, reservationRecordBean.approverId) && Intrinsics.areEqual(this.sponsorId, reservationRecordBean.sponsorId) && Intrinsics.areEqual(this.sponsorName, reservationRecordBean.sponsorName) && Intrinsics.areEqual(this.siteName, reservationRecordBean.siteName) && Intrinsics.areEqual(this.siteBookingTypeName, reservationRecordBean.siteBookingTypeName) && Intrinsics.areEqual(this.buildingName, reservationRecordBean.buildingName) && Intrinsics.areEqual(this.schedule, reservationRecordBean.schedule) && Intrinsics.areEqual(this.roomNum, reservationRecordBean.roomNum) && Intrinsics.areEqual(this.schoolId, reservationRecordBean.schoolId) && this.signIn == reservationRecordBean.signIn && Intrinsics.areEqual(this.name, reservationRecordBean.name) && Intrinsics.areEqual(this.peppleNum, reservationRecordBean.peppleNum) && Intrinsics.areEqual(this.siteId, reservationRecordBean.siteId) && Intrinsics.areEqual(this.startTimeStr, reservationRecordBean.startTimeStr) && Intrinsics.areEqual(this.describe, reservationRecordBean.describe) && Intrinsics.areEqual(this.endTimeStr, reservationRecordBean.endTimeStr) && Intrinsics.areEqual(this.id, reservationRecordBean.id) && Intrinsics.areEqual(this.floor, reservationRecordBean.floor) && Intrinsics.areEqual(this.refuseReason, reservationRecordBean.refuseReason) && Intrinsics.areEqual(this.status, reservationRecordBean.status) && Intrinsics.areEqual(this.week, reservationRecordBean.week) && this.siteBookingTypeCode == reservationRecordBean.siteBookingTypeCode && Intrinsics.areEqual(this.signList, reservationRecordBean.signList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v27, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v50 */
    /* JADX WARN: Type inference failed for: r1v51 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((this.bookingTime.hashCode() * 31) + this.sponsorType) * 31) + this.siteBookingTypeId.hashCode()) * 31) + this.siteTypeName.hashCode()) * 31) + this.approverId.hashCode()) * 31) + this.sponsorId.hashCode()) * 31) + this.sponsorName.hashCode()) * 31) + this.siteName.hashCode()) * 31) + this.siteBookingTypeName.hashCode()) * 31) + this.buildingName.hashCode()) * 31) + this.schedule.hashCode()) * 31) + this.roomNum.hashCode()) * 31) + this.schoolId.hashCode()) * 31;
        boolean z = this.signIn;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((((((((((((((((((((((iHashCode + r1) * 31) + this.name.hashCode()) * 31) + this.peppleNum.hashCode()) * 31) + this.siteId.hashCode()) * 31) + this.startTimeStr.hashCode()) * 31) + this.describe.hashCode()) * 31) + this.endTimeStr.hashCode()) * 31) + this.id.hashCode()) * 31) + this.floor.hashCode()) * 31) + this.refuseReason.hashCode()) * 31) + this.status.hashCode()) * 31) + this.week.hashCode()) * 31) + this.siteBookingTypeCode) * 31) + this.signList.hashCode();
    }

    public String toString() {
        return "ReservationRecordBean(bookingTime=" + this.bookingTime + ", sponsorType=" + this.sponsorType + ", siteBookingTypeId=" + this.siteBookingTypeId + ", siteTypeName=" + this.siteTypeName + ", approverId=" + this.approverId + ", sponsorId=" + this.sponsorId + ", sponsorName=" + this.sponsorName + ", siteName=" + this.siteName + ", siteBookingTypeName=" + this.siteBookingTypeName + ", buildingName=" + this.buildingName + ", schedule=" + this.schedule + ", roomNum=" + this.roomNum + ", schoolId=" + this.schoolId + ", signIn=" + this.signIn + ", name=" + this.name + ", peppleNum=" + this.peppleNum + ", siteId=" + this.siteId + ", startTimeStr=" + this.startTimeStr + ", describe=" + this.describe + ", endTimeStr=" + this.endTimeStr + ", id=" + this.id + ", floor=" + this.floor + ", refuseReason=" + this.refuseReason + ", status=" + this.status + ", week=" + this.week + ", siteBookingTypeCode=" + this.siteBookingTypeCode + ", signList=" + this.signList + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.bookingTime);
        parcel.writeInt(this.sponsorType);
        parcel.writeString(this.siteBookingTypeId);
        parcel.writeString(this.siteTypeName);
        parcel.writeString(this.approverId);
        parcel.writeString(this.sponsorId);
        parcel.writeString(this.sponsorName);
        parcel.writeString(this.siteName);
        parcel.writeString(this.siteBookingTypeName);
        parcel.writeString(this.buildingName);
        parcel.writeString(this.schedule);
        parcel.writeString(this.roomNum);
        parcel.writeString(this.schoolId);
        parcel.writeInt(this.signIn ? 1 : 0);
        parcel.writeString(this.name);
        parcel.writeString(this.peppleNum);
        parcel.writeString(this.siteId);
        parcel.writeString(this.startTimeStr);
        parcel.writeString(this.describe);
        parcel.writeString(this.endTimeStr);
        parcel.writeString(this.id);
        parcel.writeString(this.floor);
        parcel.writeString(this.refuseReason);
        parcel.writeString(this.status);
        parcel.writeString(this.week);
        parcel.writeInt(this.siteBookingTypeCode);
        List<ReservationSignListItemBean> list = this.signList;
        parcel.writeInt(list.size());
        Iterator<ReservationSignListItemBean> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().writeToParcel(parcel, flags);
        }
    }

    public ReservationRecordBean(String bookingTime, int i, String siteBookingTypeId, String siteTypeName, String approverId, String sponsorId, String sponsorName, String siteName, String siteBookingTypeName, String buildingName, String schedule, String roomNum, String schoolId, boolean z, String name, String peppleNum, String siteId, String startTimeStr, String describe, String endTimeStr, String id, String floor, String refuseReason, String status, String week, int i2, List<ReservationSignListItemBean> signList) {
        Intrinsics.checkNotNullParameter(bookingTime, "bookingTime");
        Intrinsics.checkNotNullParameter(siteBookingTypeId, "siteBookingTypeId");
        Intrinsics.checkNotNullParameter(siteTypeName, "siteTypeName");
        Intrinsics.checkNotNullParameter(approverId, "approverId");
        Intrinsics.checkNotNullParameter(sponsorId, "sponsorId");
        Intrinsics.checkNotNullParameter(sponsorName, "sponsorName");
        Intrinsics.checkNotNullParameter(siteName, "siteName");
        Intrinsics.checkNotNullParameter(siteBookingTypeName, "siteBookingTypeName");
        Intrinsics.checkNotNullParameter(buildingName, "buildingName");
        Intrinsics.checkNotNullParameter(schedule, "schedule");
        Intrinsics.checkNotNullParameter(roomNum, "roomNum");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(peppleNum, "peppleNum");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(startTimeStr, "startTimeStr");
        Intrinsics.checkNotNullParameter(describe, "describe");
        Intrinsics.checkNotNullParameter(endTimeStr, "endTimeStr");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(floor, "floor");
        Intrinsics.checkNotNullParameter(refuseReason, "refuseReason");
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(week, "week");
        Intrinsics.checkNotNullParameter(signList, "signList");
        this.bookingTime = bookingTime;
        this.sponsorType = i;
        this.siteBookingTypeId = siteBookingTypeId;
        this.siteTypeName = siteTypeName;
        this.approverId = approverId;
        this.sponsorId = sponsorId;
        this.sponsorName = sponsorName;
        this.siteName = siteName;
        this.siteBookingTypeName = siteBookingTypeName;
        this.buildingName = buildingName;
        this.schedule = schedule;
        this.roomNum = roomNum;
        this.schoolId = schoolId;
        this.signIn = z;
        this.name = name;
        this.peppleNum = peppleNum;
        this.siteId = siteId;
        this.startTimeStr = startTimeStr;
        this.describe = describe;
        this.endTimeStr = endTimeStr;
        this.id = id;
        this.floor = floor;
        this.refuseReason = refuseReason;
        this.status = status;
        this.week = week;
        this.siteBookingTypeCode = i2;
        this.signList = signList;
    }

    public final String getBookingTime() {
        return this.bookingTime;
    }

    public final int getSponsorType() {
        return this.sponsorType;
    }

    public final String getSiteBookingTypeId() {
        return this.siteBookingTypeId;
    }

    public final String getSiteTypeName() {
        return this.siteTypeName;
    }

    public final String getApproverId() {
        return this.approverId;
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

    public final String getBuildingName() {
        return this.buildingName;
    }

    public final String getSchedule() {
        return this.schedule;
    }

    public final String getRoomNum() {
        return this.roomNum;
    }

    public final String getSchoolId() {
        return this.schoolId;
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

    public final String getStartTimeStr() {
        return this.startTimeStr;
    }

    public final String getDescribe() {
        return this.describe;
    }

    public final String getEndTimeStr() {
        return this.endTimeStr;
    }

    public final String getId() {
        return this.id;
    }

    public final String getFloor() {
        return this.floor;
    }

    public final String getRefuseReason() {
        return this.refuseReason;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getWeek() {
        return this.week;
    }

    public final int getSiteBookingTypeCode() {
        return this.siteBookingTypeCode;
    }

    public /* synthetic */ ReservationRecordBean(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, boolean z, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i2, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? "" : str2, (i3 & 8) != 0 ? "" : str3, (i3 & 16) != 0 ? "" : str4, (i3 & 32) != 0 ? "" : str5, (i3 & 64) != 0 ? "" : str6, (i3 & 128) != 0 ? "" : str7, (i3 & 256) != 0 ? "" : str8, (i3 & 512) != 0 ? "" : str9, (i3 & 1024) != 0 ? "" : str10, (i3 & 2048) != 0 ? "" : str11, (i3 & 4096) != 0 ? "" : str12, (i3 & 8192) != 0 ? false : z, (i3 & 16384) != 0 ? "" : str13, (i3 & 32768) != 0 ? "" : str14, (i3 & 65536) != 0 ? "" : str15, (i3 & 131072) != 0 ? "" : str16, (i3 & 262144) != 0 ? "" : str17, (i3 & 524288) != 0 ? "" : str18, (i3 & 1048576) != 0 ? "" : str19, (i3 & 2097152) != 0 ? "" : str20, (i3 & 4194304) != 0 ? "" : str21, (i3 & 8388608) != 0 ? "" : str22, (i3 & 16777216) != 0 ? "" : str23, (i3 & 33554432) != 0 ? 0 : i2, (i3 & 67108864) != 0 ? new ArrayList() : list);
    }

    public final List<ReservationSignListItemBean> getSignList() {
        return this.signList;
    }
}
