package com.yd.android_brand_mvp.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import skin.support.content.res.SkinCompatResources;

/* JADX INFO: loaded from: classes4.dex */
public class StatusBarUtils {
    private static final String TAG = "StatusBarUtils";

    public static void setWindowStatusBarColor(Activity activity, int i, boolean z) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(SkinCompatResources.getInstance().getColor(i));
            }
            setAndroidNativeLightStatusBar(activity, z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setAndroidNativeLightStatusBar(Activity activity, boolean z) {
        View decorView = activity.getWindow().getDecorView();
        if (z) {
            decorView.setSystemUiVisibility(9216);
        } else {
            decorView.setSystemUiVisibility(1280);
        }
    }

    public static int getStatusBarHeight(Activity activity) {
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return activity.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static void setWindowStatusBarColor(Dialog dialog, int i) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = dialog.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(SkinCompatResources.getInstance().getColor(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int px2Dip(Context context, float f) {
        return (int) (((double) (f / context.getResources().getDisplayMetrics().density)) + 0.5d);
    }

    public static int dip2px(Context context, float f) {
        float f2 = context.getResources().getDisplayMetrics().density;
        Log.e(TAG, "dip2px: " + f2);
        return (int) (((double) (f * f2)) + 0.5d);
    }

    protected int dp2px(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }
}
