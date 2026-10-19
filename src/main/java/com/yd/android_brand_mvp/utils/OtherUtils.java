package com.yd.android_brand_mvp.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.WindowManager;
import com.tencent.smtt.sdk.WebView;

/* JADX INFO: loaded from: classes4.dex */
public class OtherUtils {
    public static void startcall(String str, Context context) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(WebView.SCHEME_TEL + str));
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void darkenBackground(Float f, Activity activity) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.alpha = f.floatValue();
        activity.getWindow().addFlags(2);
        activity.getWindow().setAttributes(attributes);
    }
}
