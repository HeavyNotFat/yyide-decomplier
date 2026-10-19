package com.yd.android_brand_mvp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public class BootBroadcastReceiver extends BroadcastReceiver {
    private final String Action = "android.intent.action.BOOT_COMPLETED";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Log.d("BootBroadcastReceiver", "应用开机启动");
            Intent intent2 = new Intent(context, (Class<?>) WelcomeActivity.class);
            intent2.addFlags(268435456);
            context.startActivity(intent2);
        }
    }
}
