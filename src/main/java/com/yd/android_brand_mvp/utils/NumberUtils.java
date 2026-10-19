package com.yd.android_brand_mvp.utils;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class NumberUtils {
    private static NumberUtils instance;
    static String[] units = {"", "十", "百", "千", "万", "十万", "百万", "千万", "亿", "十亿", "百亿", "千亿", "万亿"};
    static char[] numArray = {38646, 19968, 20108, 19977, 22235, 20116, 20845, 19971, 20843, 20061};

    private NumberUtils() {
    }

    public static NumberUtils getInstance() {
        if (instance == null) {
            instance = new NumberUtils();
        }
        return instance;
    }

    public String formatInteger(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        int length = charArray.length;
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            int iIntValue = Integer.valueOf(charArray[i2] + "").intValue();
            boolean z = iIntValue == 0;
            String str = units[(length - 1) - i2];
            if (z) {
                if ('0' != charArray[i2 - 1]) {
                    sb.append(numArray[iIntValue]);
                }
            } else {
                sb.append(numArray[iIntValue]);
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public String formatDecimal(double d) {
        String strValueOf = String.valueOf(d);
        int iIndexOf = strValueOf.indexOf(".");
        return formatInteger(Integer.valueOf(strValueOf.substring(0, iIndexOf)).intValue()) + "." + formatFractionalPart(Integer.valueOf(strValueOf.substring(iIndexOf + 1)).intValue());
    }

    private String formatFractionalPart(int i) {
        char[] charArray = String.valueOf(i).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            sb.append(numArray[Integer.valueOf(c + "").intValue()]);
        }
        return sb.toString();
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}
