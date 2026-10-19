package com.yd.android_brand_mvp.model.reservation;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReservationSiteManageBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/model/reservation/ReservationSiteManageBean;", "", "peopleId", "", "schoolId", AppMeasurementSdk.ConditionalUserProperty.NAME, "siteId", "id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getPeopleId", "getSchoolId", "getSiteId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ReservationSiteManageBean {
    private final String id;
    private final String name;
    private final String peopleId;
    private final String schoolId;
    private final String siteId;

    public ReservationSiteManageBean() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ReservationSiteManageBean copy$default(ReservationSiteManageBean reservationSiteManageBean, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reservationSiteManageBean.peopleId;
        }
        if ((i & 2) != 0) {
            str2 = reservationSiteManageBean.schoolId;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = reservationSiteManageBean.name;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = reservationSiteManageBean.siteId;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = reservationSiteManageBean.id;
        }
        return reservationSiteManageBean.copy(str, str6, str7, str8, str5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getPeopleId() {
        return this.peopleId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSiteId() {
        return this.siteId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final ReservationSiteManageBean copy(String peopleId, String schoolId, String name, String siteId, String id) {
        Intrinsics.checkNotNullParameter(peopleId, "peopleId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(id, "id");
        return new ReservationSiteManageBean(peopleId, schoolId, name, siteId, id);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReservationSiteManageBean)) {
            return false;
        }
        ReservationSiteManageBean reservationSiteManageBean = (ReservationSiteManageBean) other;
        return Intrinsics.areEqual(this.peopleId, reservationSiteManageBean.peopleId) && Intrinsics.areEqual(this.schoolId, reservationSiteManageBean.schoolId) && Intrinsics.areEqual(this.name, reservationSiteManageBean.name) && Intrinsics.areEqual(this.siteId, reservationSiteManageBean.siteId) && Intrinsics.areEqual(this.id, reservationSiteManageBean.id);
    }

    public int hashCode() {
        return (((((((this.peopleId.hashCode() * 31) + this.schoolId.hashCode()) * 31) + this.name.hashCode()) * 31) + this.siteId.hashCode()) * 31) + this.id.hashCode();
    }

    public String toString() {
        return "ReservationSiteManageBean(peopleId=" + this.peopleId + ", schoolId=" + this.schoolId + ", name=" + this.name + ", siteId=" + this.siteId + ", id=" + this.id + ')';
    }

    public ReservationSiteManageBean(String peopleId, String schoolId, String name, String siteId, String id) {
        Intrinsics.checkNotNullParameter(peopleId, "peopleId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(siteId, "siteId");
        Intrinsics.checkNotNullParameter(id, "id");
        this.peopleId = peopleId;
        this.schoolId = schoolId;
        this.name = name;
        this.siteId = siteId;
        this.id = id;
    }

    public /* synthetic */ ReservationSiteManageBean(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5);
    }

    public final String getPeopleId() {
        return this.peopleId;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSiteId() {
        return this.siteId;
    }

    public final String getId() {
        return this.id;
    }
}
