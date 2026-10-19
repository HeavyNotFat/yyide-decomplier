package com.yd.android_brand_mvp.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoggedInUser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/data/model/LoggedInUser;", "", "userId", "", "displayName", "(Ljava/lang/String;Ljava/lang/String;)V", "getDisplayName", "()Ljava/lang/String;", "getUserId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LoggedInUser {
    private final String displayName;
    private final String userId;

    public static /* synthetic */ LoggedInUser copy$default(LoggedInUser loggedInUser, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loggedInUser.userId;
        }
        if ((i & 2) != 0) {
            str2 = loggedInUser.displayName;
        }
        return loggedInUser.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    public final LoggedInUser copy(String userId, String displayName) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return new LoggedInUser(userId, displayName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoggedInUser)) {
            return false;
        }
        LoggedInUser loggedInUser = (LoggedInUser) other;
        return Intrinsics.areEqual(this.userId, loggedInUser.userId) && Intrinsics.areEqual(this.displayName, loggedInUser.displayName);
    }

    public int hashCode() {
        return (this.userId.hashCode() * 31) + this.displayName.hashCode();
    }

    public String toString() {
        return "LoggedInUser(userId=" + this.userId + ", displayName=" + this.displayName + ')';
    }

    public LoggedInUser(String userId, String displayName) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        this.userId = userId;
        this.displayName = displayName;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getDisplayName() {
        return this.displayName;
    }
}
