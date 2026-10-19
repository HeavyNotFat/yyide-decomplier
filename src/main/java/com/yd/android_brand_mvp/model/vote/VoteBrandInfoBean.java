package com.yd.android_brand_mvp.model.vote;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VoteBrandInfoBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/model/vote/VoteBrandInfoBean;", "", "userId", "", "userName", "schoolId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSchoolId", "()Ljava/lang/String;", "getUserId", "getUserName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VoteBrandInfoBean {
    private final String schoolId;
    private final String userId;
    private final String userName;

    public VoteBrandInfoBean() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ VoteBrandInfoBean copy$default(VoteBrandInfoBean voteBrandInfoBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = voteBrandInfoBean.userId;
        }
        if ((i & 2) != 0) {
            str2 = voteBrandInfoBean.userName;
        }
        if ((i & 4) != 0) {
            str3 = voteBrandInfoBean.schoolId;
        }
        return voteBrandInfoBean.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSchoolId() {
        return this.schoolId;
    }

    public final VoteBrandInfoBean copy(String userId, String userName, String schoolId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        return new VoteBrandInfoBean(userId, userName, schoolId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoteBrandInfoBean)) {
            return false;
        }
        VoteBrandInfoBean voteBrandInfoBean = (VoteBrandInfoBean) other;
        return Intrinsics.areEqual(this.userId, voteBrandInfoBean.userId) && Intrinsics.areEqual(this.userName, voteBrandInfoBean.userName) && Intrinsics.areEqual(this.schoolId, voteBrandInfoBean.schoolId);
    }

    public int hashCode() {
        return (((this.userId.hashCode() * 31) + this.userName.hashCode()) * 31) + this.schoolId.hashCode();
    }

    public String toString() {
        return "VoteBrandInfoBean(userId=" + this.userId + ", userName=" + this.userName + ", schoolId=" + this.schoolId + ')';
    }

    public VoteBrandInfoBean(String userId, String userName, String schoolId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(userName, "userName");
        Intrinsics.checkNotNullParameter(schoolId, "schoolId");
        this.userId = userId;
        this.userName = userName;
        this.schoolId = schoolId;
    }

    public /* synthetic */ VoteBrandInfoBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserName() {
        return this.userName;
    }

    public final String getSchoolId() {
        return this.schoolId;
    }
}
