package com.yd.android_brand_mvp.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JumpParameterBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/yd/android_brand_mvp/model/JumpParameterBean;", "Ljava/io/Serializable;", "url", "", "title", "cardNo", "userId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCardNo", "()Ljava/lang/String;", "setCardNo", "(Ljava/lang/String;)V", "getTitle", "setTitle", "getUrl", "setUrl", "getUserId", "setUserId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class JumpParameterBean implements Serializable {
    private String cardNo;
    private String title;
    private String url;
    private String userId;

    public JumpParameterBean() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ JumpParameterBean copy$default(JumpParameterBean jumpParameterBean, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = jumpParameterBean.url;
        }
        if ((i & 2) != 0) {
            str2 = jumpParameterBean.title;
        }
        if ((i & 4) != 0) {
            str3 = jumpParameterBean.cardNo;
        }
        if ((i & 8) != 0) {
            str4 = jumpParameterBean.userId;
        }
        return jumpParameterBean.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCardNo() {
        return this.cardNo;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final JumpParameterBean copy(String url, String title, String cardNo, String userId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new JumpParameterBean(url, title, cardNo, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JumpParameterBean)) {
            return false;
        }
        JumpParameterBean jumpParameterBean = (JumpParameterBean) other;
        return Intrinsics.areEqual(this.url, jumpParameterBean.url) && Intrinsics.areEqual(this.title, jumpParameterBean.title) && Intrinsics.areEqual(this.cardNo, jumpParameterBean.cardNo) && Intrinsics.areEqual(this.userId, jumpParameterBean.userId);
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + this.title.hashCode()) * 31) + this.cardNo.hashCode()) * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "JumpParameterBean(url=" + this.url + ", title=" + this.title + ", cardNo=" + this.cardNo + ", userId=" + this.userId + ')';
    }

    public JumpParameterBean(String url, String title, String cardNo, String userId) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(cardNo, "cardNo");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.url = url;
        this.title = title;
        this.cardNo = cardNo;
        this.userId = userId;
    }

    public /* synthetic */ JumpParameterBean(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4);
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getCardNo() {
        return this.cardNo;
    }

    public final void setCardNo(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cardNo = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }
}
