package com.yd.android_brand_mvp.utils;

import com.seewo.udsservice.client.config.NfcWeigandType;
import com.yd.android_brand_mvp.mqtt.MQTTConstant;
import kotlin.Metadata;

/* JADX INFO: compiled from: ColorsUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, d2 = {"Lcom/yd/android_brand_mvp/utils/ColorsUtils;", "", "()V", "getColorsTransparency", "", "value", "", "getColorsTransparencyValue", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ColorsUtils {
    public static final ColorsUtils INSTANCE = new ColorsUtils();

    public final String getColorsTransparency(int value) {
        switch (value) {
            case 0:
                return "00";
            case 5:
                return "0D";
            case 10:
                return "1A";
            case 15:
                return NfcWeigandType.NFC_WEIGAND_TYPE_26;
            case 20:
                return "33";
            case 25:
                return "40";
            case 30:
                return "4D";
            case 35:
                return "59";
            case 40:
                return "66";
            case 45:
                return "73";
            case 50:
                return "80";
            case 55:
                return "8C";
            case 60:
                return MQTTConstant.StudentMsg;
            case 65:
                return "A6";
            case 70:
                return "B3";
            case 75:
                return "BF";
            case 80:
                return "CC";
            case 85:
                return "D9";
            case 90:
                return "E6";
            case 95:
                return "F2";
            default:
                return "FF";
        }
    }

    public final int getColorsTransparencyValue(int value) {
        if (value == 0) {
            return 0;
        }
        return value * 255;
    }

    private ColorsUtils() {
    }
}
