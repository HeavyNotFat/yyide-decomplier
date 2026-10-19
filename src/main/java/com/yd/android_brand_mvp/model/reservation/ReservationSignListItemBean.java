package com.yd.android_brand_mvp.model.reservation;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReservationSignListItemBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\t\u0010#\u001a\u00020\bHÖ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010(\u001a\u00020\bHÖ\u0001J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\u0019\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bHÖ\u0001R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006/"}, d2 = {"Lcom/yd/android_brand_mvp/model/reservation/ReservationSignListItemBean;", "Landroid/os/Parcelable;", "signInTime", "", "siteBookingId", "dept", "id", "userType", "", "userName", "userId", "avatar", "toSignInTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getDept", "getId", "getSignInTime", "getSiteBookingId", "getToSignInTime", "getUserId", "getUserName", "getUserType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class ReservationSignListItemBean implements Parcelable {
    public static final Parcelable.Creator<ReservationSignListItemBean> CREATOR = new Creator();
    private final String avatar;
    private final String dept;
    private final String id;
    private final String signInTime;
    private final String siteBookingId;
    private final String toSignInTime;
    private final String userId;
    private final String userName;
    private final int userType;

    /* JADX INFO: compiled from: ReservationSignListItemBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ReservationSignListItemBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ReservationSignListItemBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ReservationSignListItemBean(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ReservationSignListItemBean[] newArray(int i) {
            return new ReservationSignListItemBean[i];
        }
    }

    public ReservationSignListItemBean() {
        this(null, null, null, null, 0, null, null, null, null, 511, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getSignInTime() {
        return this.signInTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSiteBookingId() {
        return this.siteBookingId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDept() {
        return this.dept;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getUserType() {
        return this.userType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getToSignInTime() {
        return this.toSignInTime;
    }

    public final ReservationSignListItemBean copy(String signInTime, String siteBookingId, String dept, String id, int userType, String userName, String userId, String avatar, String toSignInTime) {
        Intrinsics.checkNotNullParameter(signInTime, "signInTime");
        Intrinsics.checkNotNullParameter(siteBookingId, "siteBookingId");
        Intrinsics.checkNotNullParameter(dept, "dept");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(toSignInTime, "toSignInTime");
        return new ReservationSignListItemBean(signInTime, siteBookingId, dept, id, userType, userName, userId, avatar, toSignInTime);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReservationSignListItemBean)) {
            return false;
        }
        ReservationSignListItemBean reservationSignListItemBean = (ReservationSignListItemBean) other;
        return Intrinsics.areEqual(this.signInTime, reservationSignListItemBean.signInTime) && Intrinsics.areEqual(this.siteBookingId, reservationSignListItemBean.siteBookingId) && Intrinsics.areEqual(this.dept, reservationSignListItemBean.dept) && Intrinsics.areEqual(this.id, reservationSignListItemBean.id) && this.userType == reservationSignListItemBean.userType && Intrinsics.areEqual(this.userName, reservationSignListItemBean.userName) && Intrinsics.areEqual(this.userId, reservationSignListItemBean.userId) && Intrinsics.areEqual(this.avatar, reservationSignListItemBean.avatar) && Intrinsics.areEqual(this.toSignInTime, reservationSignListItemBean.toSignInTime);
    }

    public int hashCode() {
        return (((((((((((((((this.signInTime.hashCode() * 31) + this.siteBookingId.hashCode()) * 31) + this.dept.hashCode()) * 31) + this.id.hashCode()) * 31) + this.userType) * 31) + this.userName.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.avatar.hashCode()) * 31) + this.toSignInTime.hashCode();
    }

    public String toString() {
        return "ReservationSignListItemBean(signInTime=" + this.signInTime + ", siteBookingId=" + this.siteBookingId + ", dept=" + this.dept + ", id=" + this.id + ", userType=" + this.userType + ", userName=" + this.userName + ", userId=" + this.userId + ", avatar=" + this.avatar + ", toSignInTime=" + this.toSignInTime + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.signInTime);
        parcel.writeString(this.siteBookingId);
        parcel.writeString(this.dept);
        parcel.writeString(this.id);
        parcel.writeInt(this.userType);
        parcel.writeString(this.userName);
        parcel.writeString(this.userId);
        parcel.writeString(this.avatar);
        parcel.writeString(this.toSignInTime);
    }

    public ReservationSignListItemBean(String signInTime, String siteBookingId, String dept, String id, int i, String userName, String userId, String avatar, String toSignInTime) {
        Intrinsics.checkNotNullParameter(signInTime, "signInTime");
        Intrinsics.checkNotNullParameter(siteBookingId, "siteBookingId");
        Intrinsics.checkNotNullParameter(dept, "dept");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(avatar, "avatar");
        Intrinsics.checkNotNullParameter(toSignInTime, "toSignInTime");
        this.signInTime = signInTime;
        this.siteBookingId = siteBookingId;
        this.dept = dept;
        this.id = id;
        this.userType = i;
        this.userName = userName;
        this.userId = userId;
        this.avatar = avatar;
        this.toSignInTime = toSignInTime;
    }

    public /* synthetic */ ReservationSignListItemBean(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? "" : str5, (i2 & 64) != 0 ? "" : str6, (i2 & 128) != 0 ? "" : str7, (i2 & 256) == 0 ? str8 : "");
    }

    public final String getSignInTime() {
        return this.signInTime;
    }

    public final String getSiteBookingId() {
        return this.siteBookingId;
    }

    public final String getDept() {
        return this.dept;
    }

    public final String getId() {
        return this.id;
    }

    public final int getUserType() {
        return this.userType;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getToSignInTime() {
        return this.toSignInTime;
    }
}
