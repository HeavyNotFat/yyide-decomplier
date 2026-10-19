package com.yd.android_brand_mvp.brand;

import kotlin.Metadata;

/* JADX INFO: compiled from: BrandCardEnum.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/brand/BrandCardEnum;", "", "type", "", "cardName", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCardName", "()Ljava/lang/String;", "getType", "()I", "CARD_1_HS_RK3568_LN", "CARD_2_NEW_LG_RRKJ", "CARD_3_PXZX_JW", "CARD_4_ZC", "CARD_5_LK_XXY", "CARD_6_HRA", "CARD_7_XH", "CARD_8_YXS", "CARD_9_YS", "CARD_10_LG_ZYH", "HXW523U", "HH3568D_NFC", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public enum BrandCardEnum {
    CARD_1_HS_RK3568_LN(1, "安卓1"),
    CARD_2_NEW_LG_RRKJ(2, "安卓2"),
    CARD_3_PXZX_JW(3, "安卓3"),
    CARD_4_ZC(4, "安卓4"),
    CARD_5_LK_XXY(5, "安卓5"),
    CARD_6_HRA(6, "安卓6"),
    CARD_7_XH(7, "安卓7"),
    CARD_8_YXS(8, "安卓8"),
    CARD_9_YS(9, "安卓9"),
    CARD_10_LG_ZYH(10, "安卓10"),
    HXW523U(11, "HXW523U"),
    HH3568D_NFC(12, "3568D_NFC");

    private final String cardName;
    private final int type;

    BrandCardEnum(int i, String str) {
        this.type = i;
        this.cardName = str;
    }

    public final String getCardName() {
        return this.cardName;
    }

    public final int getType() {
        return this.type;
    }
}
