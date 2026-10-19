package com.yd.android_brand_mvp.model;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yyide.facepass.bean.FaceAddBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FaceBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J]\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u001e\u001a\u00020\u001fJ\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/model/FaceBean;", "", "userId", "", AppMeasurementSdk.ConditionalUserProperty.NAME, "id", "userType", "eigenValue", "icCardNo", "faceUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEigenValue", "()Ljava/lang/String;", "getFaceUrl", "getIcCardNo", "getId", "getName", "getUserId", "getUserType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "getFaceImageInfo", "Lcom/yyide/facepass/bean/FaceAddBean;", "hashCode", "", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class FaceBean {
    private final String eigenValue;
    private final String faceUrl;
    private final String icCardNo;
    private final String id;
    private final String name;
    private final String userId;
    private final String userType;

    public FaceBean() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ FaceBean copy$default(FaceBean faceBean, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = faceBean.userId;
        }
        if ((i & 2) != 0) {
            str2 = faceBean.name;
        }
        String str8 = str2;
        if ((i & 4) != 0) {
            str3 = faceBean.id;
        }
        String str9 = str3;
        if ((i & 8) != 0) {
            str4 = faceBean.userType;
        }
        String str10 = str4;
        if ((i & 16) != 0) {
            str5 = faceBean.eigenValue;
        }
        String str11 = str5;
        if ((i & 32) != 0) {
            str6 = faceBean.icCardNo;
        }
        String str12 = str6;
        if ((i & 64) != 0) {
            str7 = faceBean.faceUrl;
        }
        return faceBean.copy(str, str8, str9, str10, str11, str12, str7);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUserType() {
        return this.userType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEigenValue() {
        return this.eigenValue;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getIcCardNo() {
        return this.icCardNo;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFaceUrl() {
        return this.faceUrl;
    }

    public final FaceBean copy(String userId, String name, String id, String userType, String eigenValue, String icCardNo, String faceUrl) {
        return new FaceBean(userId, name, id, userType, eigenValue, icCardNo, faceUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FaceBean)) {
            return false;
        }
        FaceBean faceBean = (FaceBean) other;
        return Intrinsics.areEqual(this.userId, faceBean.userId) && Intrinsics.areEqual(this.name, faceBean.name) && Intrinsics.areEqual(this.id, faceBean.id) && Intrinsics.areEqual(this.userType, faceBean.userType) && Intrinsics.areEqual(this.eigenValue, faceBean.eigenValue) && Intrinsics.areEqual(this.icCardNo, faceBean.icCardNo) && Intrinsics.areEqual(this.faceUrl, faceBean.faceUrl);
    }

    public int hashCode() {
        String str = this.userId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.id;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.userType;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.eigenValue;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.icCardNo;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.faceUrl;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public String toString() {
        return "FaceBean(userId=" + this.userId + ", name=" + this.name + ", id=" + this.id + ", userType=" + this.userType + ", eigenValue=" + this.eigenValue + ", icCardNo=" + this.icCardNo + ", faceUrl=" + this.faceUrl + ')';
    }

    public FaceBean(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.userId = str;
        this.name = str2;
        this.id = str3;
        this.userType = str4;
        this.eigenValue = str5;
        this.icCardNo = str6;
        this.faceUrl = str7;
    }

    public /* synthetic */ FaceBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7);
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getId() {
        return this.id;
    }

    public final String getUserType() {
        return this.userType;
    }

    public final String getEigenValue() {
        return this.eigenValue;
    }

    public final String getIcCardNo() {
        return this.icCardNo;
    }

    public final String getFaceUrl() {
        return this.faceUrl;
    }

    public final FaceAddBean getFaceImageInfo() {
        return new FaceAddBean(this.name, this.userId, this.icCardNo, this.userType, "", this.eigenValue, this.faceUrl);
    }
}
