package com.yd.android_brand_mvp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginHeaderBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/model/LoginHeaderBean;", "", "client_id", "", "client_secret", "grant_type", "random", "school_id", "username", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getClient_id", "()Ljava/lang/String;", "getClient_secret", "getGrant_type", "getRandom", "getSchool_id", "getUsername", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LoginHeaderBean {
    private final String client_id;
    private final String client_secret;
    private final String grant_type;
    private final String random;
    private final String school_id;
    private final String username;

    public static /* synthetic */ LoginHeaderBean copy$default(LoginHeaderBean loginHeaderBean, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loginHeaderBean.client_id;
        }
        if ((i & 2) != 0) {
            str2 = loginHeaderBean.client_secret;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = loginHeaderBean.grant_type;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = loginHeaderBean.random;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = loginHeaderBean.school_id;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = loginHeaderBean.username;
        }
        return loginHeaderBean.copy(str, str7, str8, str9, str10, str6);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClient_id() {
        return this.client_id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getClient_secret() {
        return this.client_secret;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getGrant_type() {
        return this.grant_type;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRandom() {
        return this.random;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getSchool_id() {
        return this.school_id;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    public final LoginHeaderBean copy(String client_id, String client_secret, String grant_type, String random, String school_id, String username) {
        Intrinsics.checkNotNullParameter(client_id, "client_id");
        Intrinsics.checkNotNullParameter(client_secret, "client_secret");
        Intrinsics.checkNotNullParameter(grant_type, "grant_type");
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(school_id, "school_id");
        Intrinsics.checkNotNullParameter(username, "username");
        return new LoginHeaderBean(client_id, client_secret, grant_type, random, school_id, username);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginHeaderBean)) {
            return false;
        }
        LoginHeaderBean loginHeaderBean = (LoginHeaderBean) other;
        return Intrinsics.areEqual(this.client_id, loginHeaderBean.client_id) && Intrinsics.areEqual(this.client_secret, loginHeaderBean.client_secret) && Intrinsics.areEqual(this.grant_type, loginHeaderBean.grant_type) && Intrinsics.areEqual(this.random, loginHeaderBean.random) && Intrinsics.areEqual(this.school_id, loginHeaderBean.school_id) && Intrinsics.areEqual(this.username, loginHeaderBean.username);
    }

    public int hashCode() {
        return (((((((((this.client_id.hashCode() * 31) + this.client_secret.hashCode()) * 31) + this.grant_type.hashCode()) * 31) + this.random.hashCode()) * 31) + this.school_id.hashCode()) * 31) + this.username.hashCode();
    }

    public String toString() {
        return "LoginHeaderBean(client_id=" + this.client_id + ", client_secret=" + this.client_secret + ", grant_type=" + this.grant_type + ", random=" + this.random + ", school_id=" + this.school_id + ", username=" + this.username + ')';
    }

    public LoginHeaderBean(String client_id, String client_secret, String grant_type, String random, String school_id, String username) {
        Intrinsics.checkNotNullParameter(client_id, "client_id");
        Intrinsics.checkNotNullParameter(client_secret, "client_secret");
        Intrinsics.checkNotNullParameter(grant_type, "grant_type");
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(school_id, "school_id");
        Intrinsics.checkNotNullParameter(username, "username");
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.grant_type = grant_type;
        this.random = random;
        this.school_id = school_id;
        this.username = username;
    }

    public final String getClient_id() {
        return this.client_id;
    }

    public final String getClient_secret() {
        return this.client_secret;
    }

    public final String getGrant_type() {
        return this.grant_type;
    }

    public final String getRandom() {
        return this.random;
    }

    public final String getSchool_id() {
        return this.school_id;
    }

    public final String getUsername() {
        return this.username;
    }
}
