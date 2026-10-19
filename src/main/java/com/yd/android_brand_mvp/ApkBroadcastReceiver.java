package com.yd.android_brand_mvp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class ApkBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.d("ApkBroadcastReceiver", "onReceive: " + intent.getAction());
        intent.getAction();
        context.getPackageName();
        intent.getData().getSchemeSpecificPart();
        Intent intent2 = new Intent(context, (Class<?>) WelcomeActivity.class);
        intent2.setFlags(268435456);
        context.startActivity(intent2);
    }
}
