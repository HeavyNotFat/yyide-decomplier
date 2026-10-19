package com.yd.android_brand_mvp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginQrCodeBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010¨\u0006%"}, d2 = {"Lcom/yd/android_brand_mvp/model/LoginQrCodeBean;", "", "expiresIn", "", "qrcode", "", "random", "schoolId", "status", "ticket", "type", "userId", "(ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;)V", "getExpiresIn", "()I", "getQrcode", "()Ljava/lang/String;", "getRandom", "getSchoolId", "getStatus", "getTicket", "getType", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class LoginQrCodeBean {
    private final int expiresIn;
    private final String qrcode;
    private final String random;
    private final int schoolId;
    private final int status;
    private final String ticket;
    private final int type;
    private final String userId;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getExpiresIn() {
        return this.expiresIn;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getQrcode() {
        return this.qrcode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getRandom() {
        return this.random;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSchoolId() {
        return this.schoolId;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTicket() {
        return this.ticket;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    public final LoginQrCodeBean copy(int expiresIn, String qrcode, String random, int schoolId, int status, String ticket, int type, String userId) {
        Intrinsics.checkNotNullParameter(qrcode, "qrcode");
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new LoginQrCodeBean(expiresIn, qrcode, random, schoolId, status, ticket, type, userId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoginQrCodeBean)) {
            return false;
        }
        LoginQrCodeBean loginQrCodeBean = (LoginQrCodeBean) other;
        return this.expiresIn == loginQrCodeBean.expiresIn && Intrinsics.areEqual(this.qrcode, loginQrCodeBean.qrcode) && Intrinsics.areEqual(this.random, loginQrCodeBean.random) && this.schoolId == loginQrCodeBean.schoolId && this.status == loginQrCodeBean.status && Intrinsics.areEqual(this.ticket, loginQrCodeBean.ticket) && this.type == loginQrCodeBean.type && Intrinsics.areEqual(this.userId, loginQrCodeBean.userId);
    }

    public int hashCode() {
        return (((((((((((((this.expiresIn * 31) + this.qrcode.hashCode()) * 31) + this.random.hashCode()) * 31) + this.schoolId) * 31) + this.status) * 31) + this.ticket.hashCode()) * 31) + this.type) * 31) + this.userId.hashCode();
    }

    public String toString() {
        return "LoginQrCodeBean(expiresIn=" + this.expiresIn + ", qrcode=" + this.qrcode + ", random=" + this.random + ", schoolId=" + this.schoolId + ", status=" + this.status + ", ticket=" + this.ticket + ", type=" + this.type + ", userId=" + this.userId + ')';
    }

    public LoginQrCodeBean(int i, String qrcode, String random, int i2, int i3, String ticket, int i4, String userId) {
        Intrinsics.checkNotNullParameter(qrcode, "qrcode");
        Intrinsics.checkNotNullParameter(random, "random");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(userId, "userId");
        this.expiresIn = i;
        this.qrcode = qrcode;
        this.random = random;
        this.schoolId = i2;
        this.status = i3;
        this.ticket = ticket;
        this.type = i4;
        this.userId = userId;
    }

    public final int getExpiresIn() {
        return this.expiresIn;
    }

    public final String getQrcode() {
        return this.qrcode;
    }

    public final String getRandom() {
        return this.random;
    }

    public final int getSchoolId() {
        return this.schoolId;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }
}
