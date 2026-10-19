package com.yd.android_brand_mvp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VerifyPeopleBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/model/VerifyPeopleBean;", "", "identityUserId", "", "userName", "userId", "schoolId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getIdentityUserId", "()Ljava/lang/String;", "getSchoolId", "getUserId", "getUserName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VerifyPeopleBean {
    private final String identityUserId;
    private final String schoolId;
    private final String userId;
    private final String userName;

    public VerifyPeopleBean() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ VerifyPeopleBean copy$default(VerifyPeopleBean verifyPeopleBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verifyPeopleBean.identityUserId;
        }
        if ((i & 2) != 0) {
            str2 = verifyPeopleBean.userName;
        }
        if ((i & 4) != 0) {
            str3 = verifyPeopleBean.userId;
        }
        if ((i & 8) != 0) {
            str4 = verifyPeopleBean.schoolId;
        }
        return verifyPeopleBean.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getIdentityUserId() {
        return this.identityUserId;
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
    public final String getSchoolId() {
        return this.schoolId;
    }

    public final VerifyPeopleBean copy(String identityUserId, String userName, String userId, String schoolId) {
        Intrinsics.checkNotNullParameter(identityUserId, "identityUserId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        return new VerifyPeopleBean(identityUserId, userName, userId, schoolId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VerifyPeopleBean)) {
            return false;
        }
        VerifyPeopleBean verifyPeopleBean = (VerifyPeopleBean) other;
        return Intrinsics.areEqual(this.identityUserId, verifyPeopleBean.identityUserId) && Intrinsics.areEqual(this.userName, verifyPeopleBean.userName) && Intrinsics.areEqual(this.userId, verifyPeopleBean.userId) && Intrinsics.areEqual(this.schoolId, verifyPeopleBean.schoolId);
    }

    public int hashCode() {
        return (((((this.identityUserId.hashCode() * 31) + this.userName.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.schoolId.hashCode();
    }

    public String toString() {
        return "VerifyPeopleBean(identityUserId=" + this.identityUserId + ", userName=" + this.userName + ", userId=" + this.userId + ", schoolId=" + this.schoolId + ')';
    }

    public VerifyPeopleBean(String identityUserId, String userName, String userId, String schoolId) {
        Intrinsics.checkNotNullParameter(identityUserId, "identityUserId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        this.identityUserId = identityUserId;
        this.userName = userName;
        this.userId = userId;
        this.schoolId = schoolId;
    }

    public /* synthetic */ VerifyPeopleBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getIdentityUserId() {
        return this.identityUserId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }
}
