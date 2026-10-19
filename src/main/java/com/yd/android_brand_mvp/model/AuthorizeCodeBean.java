package com.yd.android_brand_mvp.model;

import com.alibaba.sdk.android.tbrest.rest.RestUrlWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthorizeCodeBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/yd/android_brand_mvp/model/AuthorizeCodeBean;", "", "i", "", RestUrlWrapper.FIELD_T, "a", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getA", "()Ljava/lang/String;", "getI", "getT", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AuthorizeCodeBean {
    private final String a;
    private final String i;
    private final String t;

    public static /* synthetic */ AuthorizeCodeBean copy$default(AuthorizeCodeBean authorizeCodeBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = authorizeCodeBean.i;
        }
        if ((i & 2) != 0) {
            str2 = authorizeCodeBean.t;
        }
        if ((i & 4) != 0) {
            str3 = authorizeCodeBean.a;
        }
        return authorizeCodeBean.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getI() {
        return this.i;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getT() {
        return this.t;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getA() {
        return this.a;
    }

    public final AuthorizeCodeBean copy(String i, String t, String a2) {
        Intrinsics.checkNotNullParameter(i, "i");
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(a2, "a");
        return new AuthorizeCodeBean(i, t, a2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AuthorizeCodeBean)) {
            return false;
        }
        AuthorizeCodeBean authorizeCodeBean = (AuthorizeCodeBean) other;
        return Intrinsics.areEqual(this.i, authorizeCodeBean.i) && Intrinsics.areEqual(this.t, authorizeCodeBean.t) && Intrinsics.areEqual(this.a, authorizeCodeBean.a);
    }

    public int hashCode() {
        return (((this.i.hashCode() * 31) + this.t.hashCode()) * 31) + this.a.hashCode();
    }

    public String toString() {
        return "AuthorizeCodeBean(i=" + this.i + ", t=" + this.t + ", a=" + this.a + ')';
    }

    public AuthorizeCodeBean(String i, String t, String a2) {
        Intrinsics.checkNotNullParameter(i, "i");
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(a2, "a");
        this.i = i;
        this.t = t;
        this.a = a2;
    }

    public final String getA() {
        return this.a;
    }

    public final String getI() {
        return this.i;
    }

    public final String getT() {
        return this.t;
    }
}
