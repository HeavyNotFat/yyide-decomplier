package com.yd.android_brand_mvp.utils;

import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class ClickUtils {
    private static final int MIN_CLICK_DELAY_TIME = 1500;
    private static long lastClickTime;
    private static HashMap<Integer, Long> sLastClickTimeMap = new HashMap<>();

    public static boolean isFastClick(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - getLastClickTime(i).longValue() < 1500;
        sLastClickTimeMap.put(Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis));
        return z;
    }

    public static void clear() {
        sLastClickTimeMap.clear();
    }

    private static Long getLastClickTime(int i) {
        Long l = sLastClickTimeMap.get(Integer.valueOf(i));
        if (l == null) {
            return 0L;
        }
        return l;
    }

    public static synchronized boolean isFastClick() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - lastClickTime > 1000) {
            return true;
        }
        lastClickTime = jCurrentTimeMillis;
        return false;
    }
}
