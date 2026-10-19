package com.yd.android_brand_mvp.db.reservation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReservationSignBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/db/reservation/ReservationSignBean;", "", "userId", "", "signInTime", "siteBookingId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "id", "", "getId", "()J", "setId", "(J)V", "getSignInTime", "()Ljava/lang/String;", "getSiteBookingId", "getUserId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ReservationSignBean {
    private long id;
    private final String signInTime;
    private final String siteBookingId;
    private final String userId;

    public static /* synthetic */ ReservationSignBean copy$default(ReservationSignBean reservationSignBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reservationSignBean.userId;
        }
        if ((i & 2) != 0) {
            str2 = reservationSignBean.signInTime;
        }
        if ((i & 4) != 0) {
            str3 = reservationSignBean.siteBookingId;
        }
        return reservationSignBean.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSignInTime() {
        return this.signInTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSiteBookingId() {
        return this.siteBookingId;
    }

    public final ReservationSignBean copy(String userId, String signInTime, String siteBookingId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(signInTime, "signInTime");
        Intrinsics.checkNotNullParameter(siteBookingId, "siteBookingId");
        return new ReservationSignBean(userId, signInTime, siteBookingId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReservationSignBean)) {
            return false;
        }
        ReservationSignBean reservationSignBean = (ReservationSignBean) other;
        return Intrinsics.areEqual(this.userId, reservationSignBean.userId) && Intrinsics.areEqual(this.signInTime, reservationSignBean.signInTime) && Intrinsics.areEqual(this.siteBookingId, reservationSignBean.siteBookingId);
    }

    public int hashCode() {
        return (((this.userId.hashCode() * 31) + this.signInTime.hashCode()) * 31) + this.siteBookingId.hashCode();
    }

    public String toString() {
        return "ReservationSignBean(userId=" + this.userId + ", signInTime=" + this.signInTime + ", siteBookingId=" + this.siteBookingId + ')';
    }

    public ReservationSignBean(String userId, String signInTime, String siteBookingId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(signInTime, "signInTime");
        Intrinsics.checkNotNullParameter(siteBookingId, "siteBookingId");
        this.userId = userId;
        this.signInTime = signInTime;
        this.siteBookingId = siteBookingId;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getSignInTime() {
        return this.signInTime;
    }

    public final String getSiteBookingId() {
        return this.siteBookingId;
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }
}
