package com.yd.android_brand_mvp.model.collect;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserVerifyBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/model/collect/UserVerifyBean;", "Landroid/os/Parcelable;", "isStudent", "", "userName", "", "userId", "identityUserId", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIdentityUserId", "()Ljava/lang/String;", "()Z", "getUserId", "getUserName", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserVerifyBean implements Parcelable {
    public static final Parcelable.Creator<UserVerifyBean> CREATOR = new Creator();
    private final String identityUserId;
    private final boolean isStudent;
    private final String userId;
    private final String userName;

    /* JADX INFO: compiled from: UserVerifyBean.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<UserVerifyBean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserVerifyBean createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserVerifyBean(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UserVerifyBean[] newArray(int i) {
            return new UserVerifyBean[i];
        }
    }

    public UserVerifyBean() {
        this(false, null, null, null, 15, null);
    }

    public static /* synthetic */ UserVerifyBean copy$default(UserVerifyBean userVerifyBean, boolean z, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = userVerifyBean.isStudent;
        }
        if ((i & 2) != 0) {
            str = userVerifyBean.userName;
        }
        if ((i & 4) != 0) {
            str2 = userVerifyBean.userId;
        }
        if ((i & 8) != 0) {
            str3 = userVerifyBean.identityUserId;
        }
        return userVerifyBean.copy(z, str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsStudent() {
        return this.isStudent;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getIdentityUserId() {
        return this.identityUserId;
    }

    public final UserVerifyBean copy(boolean isStudent, String userName, String userId, String identityUserId) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(identityUserId, "identityUserId");
        return new UserVerifyBean(isStudent, userName, userId, identityUserId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserVerifyBean)) {
            return false;
        }
        UserVerifyBean userVerifyBean = (UserVerifyBean) other;
        return this.isStudent == userVerifyBean.isStudent && Intrinsics.areEqual(this.userName, userVerifyBean.userName) && Intrinsics.areEqual(this.userId, userVerifyBean.userId) && Intrinsics.areEqual(this.identityUserId, userVerifyBean.identityUserId);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.isStudent;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (((((r0 * 31) + this.userName.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.identityUserId.hashCode();
    }

    public String toString() {
        return "UserVerifyBean(isStudent=" + this.isStudent + ", userName=" + this.userName + ", userId=" + this.userId + ", identityUserId=" + this.identityUserId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.isStudent ? 1 : 0);
        parcel.writeString(this.userName);
        parcel.writeString(this.userId);
        parcel.writeString(this.identityUserId);
    }

    public UserVerifyBean(boolean z, String userName, String userId, String identityUserId) {
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(identityUserId, "identityUserId");
        this.isStudent = z;
        this.userName = userName;
        this.userId = userId;
        this.identityUserId = identityUserId;
    }

    public /* synthetic */ UserVerifyBean(boolean z, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3);
    }

    public final boolean isStudent() {
        return this.isStudent;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getIdentityUserId() {
        return this.identityUserId;
    }
}
