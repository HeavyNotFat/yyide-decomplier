package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import com.yd.android_brand_mvp.R;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherUtils {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:116:0x01b3  */
    public static int imgCode(String str) {
        switch (str) {
            case "晴":
                return R.drawable.w1;
            case "多云":
                return R.drawable.w2;
            case "阴":
                return R.drawable.w3;
            case "阵雨":
                return R.drawable.w4;
            case "雷阵雨":
                return R.drawable.w5;
            case "雷阵雨并伴有冰雹":
                return R.drawable.w6;
            case "雨夹雪":
                return R.drawable.w7;
            case "小雨":
                return R.drawable.w8;
            case "中雨":
                return R.drawable.w9;
            case "大雨":
                return R.drawable.w10;
            case "暴雨":
                return R.drawable.w11;
            case "大暴雨":
                return R.drawable.w12;
            case "特大暴雨":
                return R.drawable.w13;
            case "阵雪":
                return R.drawable.w14;
            case "小雪":
                return R.drawable.w15;
            case "中雪":
                return R.drawable.w16_2;
            case "大雪":
                return R.drawable.w17;
            case "暴雪":
                return R.drawable.w18;
            case "雾":
                return R.drawable.w19;
            case "冻雨":
                return R.drawable.w20;
            case "沙尘暴":
                return R.drawable.w21;
            case "小到中雨":
                return R.drawable.w22;
            case "中到大雨":
                return R.drawable.w23;
            case "大到暴雨":
                return R.drawable.w24;
            case "暴雨到大暴雨":
                return R.drawable.w25;
            case "大暴雨到特大暴雨":
                return R.drawable.w26;
            case "小到中雪":
                return R.drawable.w27;
            case "中到大雪":
                return R.drawable.w28;
            case "大到暴雪":
                return R.drawable.w29;
            case "浮尘":
                return R.drawable.w30;
            case "扬沙":
                return R.drawable.w31;
            case "强沙尘暴":
                return R.drawable.w32;
            case "飑":
            case "龙卷风":
            case "弱高吹雪":
                return R.drawable.weather_icon;
            case "轻霾":
            case "霾":
                return R.drawable.w37;
            default:
                return R.drawable.wea;
        }
    }

    public static Drawable imgCode_y(Context context, String str) {
        if (str.contains("晴")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y34);
        }
        if (str.contains("多云")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y33);
        }
        if (str.contains("阴")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y32);
        }
        if (str.contains("阵雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y31);
        }
        if (str.contains("雷阵雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y30);
        }
        if (str.contains("雷阵雨并伴有冰雹")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y29);
        }
        if (str.contains("雨夹雪")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y28);
        }
        if (str.contains("小雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y27);
        }
        if (str.contains("中雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y26);
        }
        if (str.contains("大雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y25);
        }
        if (str.contains("暴雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y24);
        }
        if (str.contains("大暴雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y23);
        }
        if (str.contains("特大暴雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y22);
        }
        if (str.contains("阵雪")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y21);
        }
        if (str.contains("小雪")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y20);
        }
        if (str.contains("中雪")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y19);
        }
        if (str.contains("大雪")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y18);
        }
        if (str.contains("暴雪")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y17);
        }
        if (str.contains("雾")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y16);
        }
        if (str.contains("冻雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y15);
        }
        if (str.contains("沙尘暴")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y14);
        }
        if (str.contains("小到中雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y13);
        }
        if (str.contains("中到大雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y12);
        }
        if (str.contains("大到暴雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y11);
        }
        if (str.contains("暴雨到大暴雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y10);
        }
        if (str.contains("大暴雨到特大暴雨")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y9);
        }
        if (str.contains("小到中雪")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y8);
        }
        if (str.contains("中到大雪")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y7);
        }
        if (str.contains("大到暴雪")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y6);
        }
        if (str.contains("浮尘")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y5);
        }
        if (str.contains("扬沙")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y4);
        }
        if (str.contains("强沙尘暴")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y3);
        }
        if (str.contains("飑")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y1);
        }
        if (str.contains("龙卷风")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y1);
        }
        if (str.contains("弱高吹雪")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y1);
        }
        if (str.contains("轻霾")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y1);
        }
        if (str.contains("霾")) {
            return SkinCompatResources.getDrawable(context, R.drawable.y2);
        }
        return SkinCompatResources.getDrawable(context, R.drawable.y34);
    }

    public static int imgCodeP(String str) {
        if (!com.blankj.utilcode.util.StringUtils.isEmpty(str) && str.lastIndexOf("转") != -1) {
            String[] strArrSplit = str.split("转");
            str = strArrSplit[strArrSplit.length - 1];
        }
        Log.i("imgCodeP", str + "");
        if (str.contains("多云")) {
            return R.drawable.y33p;
        }
        if (str.contains("阴")) {
            return R.drawable.y32p;
        }
        if (str.contains("阵雨")) {
            return R.drawable.s_31p;
        }
        if (str.contains("雷阵雨")) {
            return R.drawable.y30p;
        }
        if (str.contains("雷阵雨并伴有冰雹")) {
            return R.drawable.y29p;
        }
        if (str.contains("雨夹雪")) {
            return R.drawable.y28p;
        }
        if (str.contains("小雨")) {
            return R.drawable.y27p;
        }
        if (str.contains("中雨")) {
            return R.drawable.y26p;
        }
        if (str.contains("大雨")) {
            return R.drawable.y25p;
        }
        if (str.contains("暴雨")) {
            return R.drawable.y24p;
        }
        if (str.contains("大暴雨")) {
            return R.drawable.y23p;
        }
        if (str.contains("特大暴雨")) {
            return R.drawable.y22p;
        }
        if (str.contains("阵雪")) {
            return R.drawable.y21p;
        }
        if (str.contains("小雪")) {
            return R.drawable.y20p;
        }
        if (str.contains("中雪")) {
            return R.drawable.y19p;
        }
        if (str.contains("大雪")) {
            return R.drawable.y18p;
        }
        if (str.contains("暴雪")) {
            return R.drawable.y17p;
        }
        if (str.contains("雾")) {
            return R.drawable.y16p;
        }
        if (str.contains("冻雨")) {
            return R.drawable.y15p;
        }
        if (str.contains("沙尘暴")) {
            return R.drawable.y14p;
        }
        if (str.contains("小雨-中雨")) {
            return R.drawable.y13p;
        }
        if (str.contains("中雨-大雨")) {
            return R.drawable.y12p;
        }
        if (str.contains("大雨-暴雨")) {
            return R.drawable.y11p;
        }
        if (str.contains("暴雨-大暴雨")) {
            return R.drawable.y10p;
        }
        if (str.contains("大暴雨-特大暴雨")) {
            return R.drawable.y9p;
        }
        if (str.contains("小雪-中雪")) {
            return R.drawable.y8p;
        }
        if (str.contains("中雪-大雪")) {
            return R.drawable.y7p;
        }
        if (str.contains("大雪-暴雪")) {
            return R.drawable.y6p;
        }
        if (str.contains("浮尘")) {
            return R.drawable.y5p;
        }
        if (str.contains("扬沙")) {
            return R.drawable.y4p;
        }
        if (str.contains("强沙尘暴")) {
            return R.drawable.y3p;
        }
        if (str.contains("飑")) {
            return R.drawable.y2p;
        }
        if (str.contains("龙卷风")) {
            return R.drawable.y1p;
        }
        return str.contains("晴") ? R.drawable.y34p : R.drawable.f12_bg;
    }

    public static String getTemperature(String str) {
        return (TextUtils.isEmpty(str) || str.length() <= 4) ? str : str.substring(2);
    }
}
