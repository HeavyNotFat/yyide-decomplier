package com.yd.android_brand_mvp.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BrandConfigBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b0\b\u0086\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0017HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0005HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0005HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003JÇ\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0017HÆ\u0001J\u0013\u0010C\u001a\u00020\u00172\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\u0003HÖ\u0001J\t\u0010F\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001dR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001aR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001aR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001d¨\u0006G"}, d2 = {"Lcom/yd/android_brand_mvp/model/BrandConfigBean;", "", "cardReaderBrand", "", "cardReaderBrandCode", "", "CardReaderFrequency", "cardReaderFrequencyCode", "cardReaderModel", "cardReaderModelCode", "cardReaderSerialPort", "cardReaderSerialPortCode", "cameraAngle", "cameraAngleCode", "cameraPreview", "cameraPreviewCode", "motherboardBrand", "motherboardBrandCode", "motherboardModel", "motherboardModelCode", "theme", "themeCode", "faceStatus", "", "(ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Z)V", "getCardReaderFrequency", "()I", "getCameraAngle", "getCameraAngleCode", "()Ljava/lang/String;", "getCameraPreview", "getCameraPreviewCode", "getCardReaderBrand", "getCardReaderBrandCode", "getCardReaderFrequencyCode", "getCardReaderModel", "getCardReaderModelCode", "getCardReaderSerialPort", "getCardReaderSerialPortCode", "getFaceStatus", "()Z", "getMotherboardBrand", "getMotherboardBrandCode", "getMotherboardModel", "getMotherboardModelCode", "getTheme", "getThemeCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BrandConfigBean {
    private final int CardReaderFrequency;
    private final int cameraAngle;
    private final String cameraAngleCode;
    private final int cameraPreview;
    private final String cameraPreviewCode;
    private final int cardReaderBrand;
    private final String cardReaderBrandCode;
    private final String cardReaderFrequencyCode;
    private final String cardReaderModel;
    private final String cardReaderModelCode;
    private final int cardReaderSerialPort;
    private final String cardReaderSerialPortCode;
    private final boolean faceStatus;
    private final int motherboardBrand;
    private final String motherboardBrandCode;
    private final int motherboardModel;
    private final String motherboardModelCode;
    private final int theme;
    private final String themeCode;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getCardReaderBrand() {
        return this.cardReaderBrand;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getCameraAngleCode() {
        return this.cameraAngleCode;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getCameraPreview() {
        return this.cameraPreview;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getCameraPreviewCode() {
        return this.cameraPreviewCode;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final int getMotherboardBrand() {
        return this.motherboardBrand;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getMotherboardBrandCode() {
        return this.motherboardBrandCode;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final int getMotherboardModel() {
        return this.motherboardModel;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getMotherboardModelCode() {
        return this.motherboardModelCode;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final int getTheme() {
        return this.theme;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getThemeCode() {
        return this.themeCode;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final boolean getFaceStatus() {
        return this.faceStatus;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCardReaderBrandCode() {
        return this.cardReaderBrandCode;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getCardReaderFrequency() {
        return this.CardReaderFrequency;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCardReaderFrequencyCode() {
        return this.cardReaderFrequencyCode;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCardReaderModel() {
        return this.cardReaderModel;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCardReaderModelCode() {
        return this.cardReaderModelCode;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getCardReaderSerialPort() {
        return this.cardReaderSerialPort;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getCardReaderSerialPortCode() {
        return this.cardReaderSerialPortCode;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getCameraAngle() {
        return this.cameraAngle;
    }

    public final BrandConfigBean copy(int cardReaderBrand, String cardReaderBrandCode, int CardReaderFrequency, String cardReaderFrequencyCode, String cardReaderModel, String cardReaderModelCode, int cardReaderSerialPort, String cardReaderSerialPortCode, int cameraAngle, String cameraAngleCode, int cameraPreview, String cameraPreviewCode, int motherboardBrand, String motherboardBrandCode, int motherboardModel, String motherboardModelCode, int theme, String themeCode, boolean faceStatus) {
        Intrinsics.checkNotNullParameter(cardReaderBrandCode, "cardReaderBrandCode");
        Intrinsics.checkNotNullParameter(cardReaderFrequencyCode, "cardReaderFrequencyCode");
        Intrinsics.checkNotNullParameter(cardReaderModel, "cardReaderModel");
        Intrinsics.checkNotNullParameter(cardReaderModelCode, "cardReaderModelCode");
        Intrinsics.checkNotNullParameter(cardReaderSerialPortCode, "cardReaderSerialPortCode");
        Intrinsics.checkNotNullParameter(cameraAngleCode, "cameraAngleCode");
        Intrinsics.checkNotNullParameter(cameraPreviewCode, "cameraPreviewCode");
        Intrinsics.checkNotNullParameter(motherboardBrandCode, "motherboardBrandCode");
        Intrinsics.checkNotNullParameter(motherboardModelCode, "motherboardModelCode");
        Intrinsics.checkNotNullParameter(themeCode, "themeCode");
        return new BrandConfigBean(cardReaderBrand, cardReaderBrandCode, CardReaderFrequency, cardReaderFrequencyCode, cardReaderModel, cardReaderModelCode, cardReaderSerialPort, cardReaderSerialPortCode, cameraAngle, cameraAngleCode, cameraPreview, cameraPreviewCode, motherboardBrand, motherboardBrandCode, motherboardModel, motherboardModelCode, theme, themeCode, faceStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BrandConfigBean)) {
            return false;
        }
        BrandConfigBean brandConfigBean = (BrandConfigBean) other;
        return this.cardReaderBrand == brandConfigBean.cardReaderBrand && Intrinsics.areEqual(this.cardReaderBrandCode, brandConfigBean.cardReaderBrandCode) && this.CardReaderFrequency == brandConfigBean.CardReaderFrequency && Intrinsics.areEqual(this.cardReaderFrequencyCode, brandConfigBean.cardReaderFrequencyCode) && Intrinsics.areEqual(this.cardReaderModel, brandConfigBean.cardReaderModel) && Intrinsics.areEqual(this.cardReaderModelCode, brandConfigBean.cardReaderModelCode) && this.cardReaderSerialPort == brandConfigBean.cardReaderSerialPort && Intrinsics.areEqual(this.cardReaderSerialPortCode, brandConfigBean.cardReaderSerialPortCode) && this.cameraAngle == brandConfigBean.cameraAngle && Intrinsics.areEqual(this.cameraAngleCode, brandConfigBean.cameraAngleCode) && this.cameraPreview == brandConfigBean.cameraPreview && Intrinsics.areEqual(this.cameraPreviewCode, brandConfigBean.cameraPreviewCode) && this.motherboardBrand == brandConfigBean.motherboardBrand && Intrinsics.areEqual(this.motherboardBrandCode, brandConfigBean.motherboardBrandCode) && this.motherboardModel == brandConfigBean.motherboardModel && Intrinsics.areEqual(this.motherboardModelCode, brandConfigBean.motherboardModelCode) && this.theme == brandConfigBean.theme && Intrinsics.areEqual(this.themeCode, brandConfigBean.themeCode) && this.faceStatus == brandConfigBean.faceStatus;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v36, types: [int] */
    /* JADX WARN: Type inference failed for: r1v28, types: [int] */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v30 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((((((((((((((((((((this.cardReaderBrand * 31) + this.cardReaderBrandCode.hashCode()) * 31) + this.CardReaderFrequency) * 31) + this.cardReaderFrequencyCode.hashCode()) * 31) + this.cardReaderModel.hashCode()) * 31) + this.cardReaderModelCode.hashCode()) * 31) + this.cardReaderSerialPort) * 31) + this.cardReaderSerialPortCode.hashCode()) * 31) + this.cameraAngle) * 31) + this.cameraAngleCode.hashCode()) * 31) + this.cameraPreview) * 31) + this.cameraPreviewCode.hashCode()) * 31) + this.motherboardBrand) * 31) + this.motherboardBrandCode.hashCode()) * 31) + this.motherboardModel) * 31) + this.motherboardModelCode.hashCode()) * 31) + this.theme) * 31) + this.themeCode.hashCode()) * 31;
        boolean z = this.faceStatus;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "BrandConfigBean(cardReaderBrand=" + this.cardReaderBrand + ", cardReaderBrandCode=" + this.cardReaderBrandCode + ", CardReaderFrequency=" + this.CardReaderFrequency + ", cardReaderFrequencyCode=" + this.cardReaderFrequencyCode + ", cardReaderModel=" + this.cardReaderModel + ", cardReaderModelCode=" + this.cardReaderModelCode + ", cardReaderSerialPort=" + this.cardReaderSerialPort + ", cardReaderSerialPortCode=" + this.cardReaderSerialPortCode + ", cameraAngle=" + this.cameraAngle + ", cameraAngleCode=" + this.cameraAngleCode + ", cameraPreview=" + this.cameraPreview + ", cameraPreviewCode=" + this.cameraPreviewCode + ", motherboardBrand=" + this.motherboardBrand + ", motherboardBrandCode=" + this.motherboardBrandCode + ", motherboardModel=" + this.motherboardModel + ", motherboardModelCode=" + this.motherboardModelCode + ", theme=" + this.theme + ", themeCode=" + this.themeCode + ", faceStatus=" + this.faceStatus + ')';
    }

    public BrandConfigBean(int i, String cardReaderBrandCode, int i2, String cardReaderFrequencyCode, String cardReaderModel, String cardReaderModelCode, int i3, String cardReaderSerialPortCode, int i4, String cameraAngleCode, int i5, String cameraPreviewCode, int i6, String motherboardBrandCode, int i7, String motherboardModelCode, int i8, String themeCode, boolean z) {
        Intrinsics.checkNotNullParameter(cardReaderBrandCode, "cardReaderBrandCode");
        Intrinsics.checkNotNullParameter(cardReaderFrequencyCode, "cardReaderFrequencyCode");
        Intrinsics.checkNotNullParameter(cardReaderModel, "cardReaderModel");
        Intrinsics.checkNotNullParameter(cardReaderModelCode, "cardReaderModelCode");
        Intrinsics.checkNotNullParameter(cardReaderSerialPortCode, "cardReaderSerialPortCode");
        Intrinsics.checkNotNullParameter(cameraAngleCode, "cameraAngleCode");
        Intrinsics.checkNotNullParameter(cameraPreviewCode, "cameraPreviewCode");
        Intrinsics.checkNotNullParameter(motherboardBrandCode, "motherboardBrandCode");
        Intrinsics.checkNotNullParameter(motherboardModelCode, "motherboardModelCode");
        Intrinsics.checkNotNullParameter(themeCode, "themeCode");
        this.cardReaderBrand = i;
        this.cardReaderBrandCode = cardReaderBrandCode;
        this.CardReaderFrequency = i2;
        this.cardReaderFrequencyCode = cardReaderFrequencyCode;
        this.cardReaderModel = cardReaderModel;
        this.cardReaderModelCode = cardReaderModelCode;
        this.cardReaderSerialPort = i3;
        this.cardReaderSerialPortCode = cardReaderSerialPortCode;
        this.cameraAngle = i4;
        this.cameraAngleCode = cameraAngleCode;
        this.cameraPreview = i5;
        this.cameraPreviewCode = cameraPreviewCode;
        this.motherboardBrand = i6;
        this.motherboardBrandCode = motherboardBrandCode;
        this.motherboardModel = i7;
        this.motherboardModelCode = motherboardModelCode;
        this.theme = i8;
        this.themeCode = themeCode;
        this.faceStatus = z;
    }

    public /* synthetic */ BrandConfigBean(int i, String str, int i2, String str2, String str3, String str4, int i3, String str5, int i4, String str6, int i5, String str7, int i6, String str8, int i7, String str9, int i8, String str10, boolean z, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, i2, str2, str3, str4, i3, str5, i4, str6, i5, str7, i6, str8, i7, str9, i8, str10, (i9 & 262144) != 0 ? false : z);
    }

    public final int getCardReaderBrand() {
        return this.cardReaderBrand;
    }

    public final String getCardReaderBrandCode() {
        return this.cardReaderBrandCode;
    }

    public final int getCardReaderFrequency() {
        return this.CardReaderFrequency;
    }

    public final String getCardReaderFrequencyCode() {
        return this.cardReaderFrequencyCode;
    }

    public final String getCardReaderModel() {
        return this.cardReaderModel;
    }

    public final String getCardReaderModelCode() {
        return this.cardReaderModelCode;
    }

    public final int getCardReaderSerialPort() {
        return this.cardReaderSerialPort;
    }

    public final String getCardReaderSerialPortCode() {
        return this.cardReaderSerialPortCode;
    }

    public final int getCameraAngle() {
        return this.cameraAngle;
    }

    public final String getCameraAngleCode() {
        return this.cameraAngleCode;
    }

    public final int getCameraPreview() {
        return this.cameraPreview;
    }

    public final String getCameraPreviewCode() {
        return this.cameraPreviewCode;
    }

    public final int getMotherboardBrand() {
        return this.motherboardBrand;
    }

    public final String getMotherboardBrandCode() {
        return this.motherboardBrandCode;
    }

    public final int getMotherboardModel() {
        return this.motherboardModel;
    }

    public final String getMotherboardModelCode() {
        return this.motherboardModelCode;
    }

    public final int getTheme() {
        return this.theme;
    }

    public final String getThemeCode() {
        return this.themeCode;
    }

    public final boolean getFaceStatus() {
        return this.faceStatus;
    }
}
