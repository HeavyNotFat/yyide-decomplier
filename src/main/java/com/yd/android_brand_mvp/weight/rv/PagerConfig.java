package com.yd.android_brand_mvp.weight.rv;

import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class PagerConfig {
    private static final String TAG = "PagerGrid";
    private static int sFlingThreshold = 1000;
    private static float sMillisecondsPreInch = 60.0f;
    private static boolean sShowLog = false;

    public static boolean isShowLog() {
        return sShowLog;
    }

    public static void setShowLog(boolean z) {
        sShowLog = z;
    }

    public static int getFlingThreshold() {
        return sFlingThreshold;
    }

    public static void setFlingThreshold(int i) {
        sFlingThreshold = i;
    }

    public static float getMillisecondsPreInch() {
        return sMillisecondsPreInch;
    }

    public static void setMillisecondsPreInch(float f) {
        sMillisecondsPreInch = f;
    }

    public static void Logi(String str) {
        if (isShowLog()) {
            Log.i(TAG, str);
        }
    }

    public static void Loge(String str) {
        if (isShowLog()) {
            Log.e(TAG, str);
        }
    }
}
