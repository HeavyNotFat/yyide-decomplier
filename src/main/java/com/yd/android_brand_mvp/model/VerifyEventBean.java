package com.yd.android_brand_mvp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VerifyEventBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006\""}, d2 = {"Lcom/yd/android_brand_mvp/model/VerifyEventBean;", "", "id", "", "userId", "isStudent", "", "schoolId", "userName", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "()Z", "setStudent", "(Z)V", "getSchoolId", "setSchoolId", "getUserId", "setUserId", "getUserName", "setUserName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VerifyEventBean {
    private String id;
    private boolean isStudent;
    private String schoolId;
    private String userId;
    private String userName;

    public VerifyEventBean() {
        this(null, null, false, null, null, 31, null);
    }

    public static /* synthetic */ VerifyEventBean copy$default(VerifyEventBean verifyEventBean, String str, String str2, boolean z, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verifyEventBean.id;
        }
        if ((i & 2) != 0) {
            str2 = verifyEventBean.userId;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            z = verifyEventBean.isStudent;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            str3 = verifyEventBean.schoolId;
        }
        String str6 = str3;
        if ((i & 16) != 0) {
            str4 = verifyEventBean.userName;
        }
        return verifyEventBean.copy(str, str5, z2, str6, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsStudent() {
        return this.isStudent;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    public final VerifyEventBean copy(String id, String userId, boolean isStudent, String schoolId, String userName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        return new VerifyEventBean(id, userId, isStudent, schoolId, userName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VerifyEventBean)) {
            return false;
        }
        VerifyEventBean verifyEventBean = (VerifyEventBean) other;
        return Intrinsics.areEqual(this.id, verifyEventBean.id) && Intrinsics.areEqual(this.userId, verifyEventBean.userId) && this.isStudent == verifyEventBean.isStudent && Intrinsics.areEqual(this.schoolId, verifyEventBean.schoolId) && Intrinsics.areEqual(this.userName, verifyEventBean.userName);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public int hashCode() {
        int iHashCode = ((this.id.hashCode() * 31) + this.userId.hashCode()) * 31;
        boolean z = this.isStudent;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((iHashCode + r1) * 31) + this.schoolId.hashCode()) * 31) + this.userName.hashCode();
    }

    public String toString() {
        return "VerifyEventBean(id=" + this.id + ", userId=" + this.userId + ", isStudent=" + this.isStudent + ", schoolId=" + this.schoolId + ", userName=" + this.userName + ')';
    }

    public VerifyEventBean(String id, String userId, boolean z, String schoolId, String userName) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        this.id = id;
        this.userId = userId;
        this.isStudent = z;
        this.schoolId = schoolId;
        this.userName = userName;
    }

    public /* synthetic */ VerifyEventBean(String str, String str2, boolean z, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final boolean isStudent() {
        return this.isStudent;
    }

    public final void setStudent(boolean z) {
        this.isStudent = z;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }

    public final void setSchoolId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schoolId = str;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final void setUserName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userName = str;
    }
}
