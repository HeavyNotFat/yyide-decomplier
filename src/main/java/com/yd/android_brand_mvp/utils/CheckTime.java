package com.yd.android_brand_mvp.utils;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.google.android.exoplayer2.PlaybackException;
import com.q_zheng.wifi.AccessPoint;

/* JADX INFO: loaded from: classes4.dex */
public class CheckTime {
    public boolean forTime(String str, String str2) {
        long j = TimeUtil.gettime99(str);
        long j2 = TimeUtil.gettime99(str2);
        long j3 = TimeUtil.gettime99(TimeUtil.stampToDate2(System.currentTimeMillis()));
        Log.e("TAG", "start: " + JSON.toJSONString(Long.valueOf(j)));
        Log.e("TAG", "end: " + JSON.toJSONString(Long.valueOf(j2)));
        Log.e("TAG", "now: " + JSON.toJSONString(Long.valueOf(j3)));
        return j < j3 && j3 < j2;
    }

    public boolean isnextTime(String str) {
        return TimeUtil.gettime99(TimeUtil.stampToDate2(System.currentTimeMillis())) < TimeUtil.gettime99(str);
    }

    public boolean forTime2(String str, String str2, int i, int i2) {
        long j = TimeUtil.gettime99(str) - ((long) ((i2 * AccessPoint.HIGHER_FREQ_5GHZ) * 10));
        long j2 = TimeUtil.gettime99(str2) - 1000;
        long j3 = TimeUtil.gettime99(TimeUtil.stampToDate2(System.currentTimeMillis()));
        return j < j3 && j3 < j2;
    }

    public boolean forTime222(String str, String str2, int i, int i2) {
        long j = TimeUtil.gettime99(str);
        long j2 = i * PlaybackException.ERROR_CODE_DRM_UNSPECIFIED * 10;
        long j3 = j - j2;
        long j4 = (TimeUtil.gettime99(str) - j2) + ((long) (i2 * PlaybackException.ERROR_CODE_DRM_UNSPECIFIED * 10));
        long j5 = TimeUtil.gettime99(TimeUtil.stampToDate2(System.currentTimeMillis()));
        return j3 <= j5 && j5 <= j4;
    }

    public boolean forTime333(String str, String str2, int i, int i2) {
        long j = TimeUtil.gettime99(str2);
        long j2 = i * PlaybackException.ERROR_CODE_DRM_UNSPECIFIED * 10;
        long j3 = j + j2;
        long j4 = TimeUtil.gettime99(str2) + j2 + ((long) (i2 * PlaybackException.ERROR_CODE_DRM_UNSPECIFIED * 10));
        long j5 = TimeUtil.gettime99(TimeUtil.stampToDate2(System.currentTimeMillis()));
        return j3 <= j5 && j5 <= j4;
    }
}
