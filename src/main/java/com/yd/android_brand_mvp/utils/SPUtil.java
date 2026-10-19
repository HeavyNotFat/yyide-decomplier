package com.yd.android_brand_mvp.utils;

import android.content.SharedPreferences;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.base.BaseConstant;

/* JADX INFO: loaded from: classes4.dex */
public class SPUtil {
    private static SharedPreferences spf = BaseApplication.getInstance().getSharedPreferences(BaseConstant.SP_NAME, 0);

    private SPUtil() {
    }

    public static void put(String str, Object obj) {
        SharedPreferences.Editor editorEdit = spf.edit();
        if (obj instanceof String) {
            editorEdit.putString(str, (String) obj);
        } else if (obj instanceof Long) {
            editorEdit.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            editorEdit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            editorEdit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            editorEdit.putFloat(str, ((Float) obj).floatValue());
        }
        editorEdit.apply();
    }

    public static Object get(String str, Object obj) {
        boolean z = obj instanceof String;
        if (z) {
            return spf.getString(str, (String) obj);
        }
        if (z) {
            return Long.valueOf(spf.getLong(str, ((Long) obj).longValue()));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(spf.getInt(str, ((Integer) obj).intValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(spf.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Float) {
            return Float.valueOf(spf.getFloat(str, ((Float) obj).floatValue()));
        }
        return null;
    }

    public static void clearSpf() {
        spf.edit().clear().commit();
    }

    public static void remove(String str) {
        spf.edit().remove(str).commit();
    }

    public static String getString(String str, String str2) {
        return spf.getString(str, str2);
    }

    public static int getInt(String str, int i) {
        return spf.getInt(str, i);
    }

    public static long getLong(String str, long j) {
        return spf.getLong(str, j);
    }

    public static float getFloat(String str, float f) {
        return spf.getFloat(str, f);
    }

    public static boolean getBoolean(String str, boolean z) {
        return spf.getBoolean(str, z);
    }
}
