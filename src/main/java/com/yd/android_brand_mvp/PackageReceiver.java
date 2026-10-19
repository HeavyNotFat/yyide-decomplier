package com.yd.android_brand_mvp;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.blankj.utilcode.util.ActivityUtils;

/* JADX INFO: loaded from: classes4.dex */
public class PackageReceiver extends BroadcastReceiver {
    private final String Action = "android.intent.action.BOOT_COMPLETED";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String dataString = intent.getDataString();
        intent.getAction().equals("android.intent.action.PACKAGE_ADDED");
        if (intent.getAction().equals("android.intent.action.PACKAGE_REPLACED")) {
            Intent intent2 = new Intent("android.intent.action.MAIN");
            intent2.addCategory("android.intent.category.LAUNCHER");
            intent2.setComponent(new ComponentName(dataString, "WelcomeActivity"));
            ActivityUtils.startActivity(intent2);
        }
        intent.getAction().equals("android.intent.action.PACKAGE_REMOVED");
    }
}
