package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.yd.android_brand_mvp.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public class StringUtils {
    public static final String htmlHeart = "<head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> <style>img{max-width: 100%; height:auto;}*{margin:0px;}</style></head>";

    public static String subString(String str, int i) {
        return (TextUtils.isEmpty(str) || str.length() <= i) ? str : str.substring(str.length() - i, str.length());
    }

    public static String subZeroAndDot(String str) {
        return str.indexOf(".") > 0 ? str.replaceAll("0+?$", "").replaceAll("[.]$", "") : str;
    }

    public static String firstLineRetractText(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        Log.e("firstLineRetractText:", com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + str.charAt(0));
        int i = 0;
        while (true) {
            if ((i >= length || str.charAt(i) != ' ') && str.charAt(i) != 12288) {
                return String.format(context.getString(R.string.retract), str.substring(i).trim());
            }
            i++;
        }
    }

    public static String removeImageHtmlStr(String str) {
        boolean z;
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str) || !str.contains("<img")) {
            z = false;
        } else {
            z = true;
            Matcher matcher = Pattern.compile("<img.*src\\s*=\\s*(.*?)[^>]*?>", 2).matcher(str);
            while (matcher.find()) {
                str = str.replace(matcher.group(), "");
            }
        }
        sb.append(Html.fromHtml(str).toString().trim());
        if (z && sb.toString().isEmpty()) {
            sb.append("[图片]");
        }
        return sb.toString();
    }

    public static String formatHtmlData(String str) {
        return "<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> <style>img{max-width: 100%; height:auto;}*{margin:0px;}</style></head><body>" + str + "<b color='#ffffff'>.</b></body></html>";
    }

    public static boolean isMobileNumber(String str) {
        return Pattern.compile("^(0|86|17951)?(13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$").matcher(str).matches();
    }

    public static boolean isIdCardNum(String str) {
        if (str.matches("^\\d{15}$|^\\d{17}[0-9Xx]$")) {
            return true;
        }
        System.out.println("Format Error!");
        return false;
    }

    public static boolean isNumeric(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }
}
