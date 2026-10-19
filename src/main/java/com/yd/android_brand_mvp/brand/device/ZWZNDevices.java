package com.yd.android_brand_mvp.brand.device;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ZWZNDevices.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJH\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¨\u0006\u0013"}, d2 = {"Lcom/yd/android_brand_mvp/brand/device/ZWZNDevices;", "", "()V", "installApk", "", "mContext", "Landroid/content/Context;", "apkPath", "", "setAlarmPower", "year", "", "month", "day", "hour", "minute", "second", AdvanceSetting.NETWORK_TYPE, "Landroid/content/Intent;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ZWZNDevices {
    public static final ZWZNDevices INSTANCE = new ZWZNDevices();

    private ZWZNDevices() {
    }

    public final void installApk(Context mContext, String apkPath) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Uri uriFromFile = Uri.fromFile(new File(apkPath));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uriFromFile, "application/vnd.android.package-archive");
        mContext.startActivity(intent);
    }

    public final void setAlarmPower(Context mContext, int year, int month, int day, int hour, int minute, int second, Intent it2) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Log.i("AlarmPower", "==========================");
        long jCurrentTimeMillis = System.currentTimeMillis() + ((long) 300000);
        Log.i("AlarmPower", "ON..." + year + '/' + (month + 1) + '/' + day + "..." + hour + ':' + minute + ':' + second + "...TimeInMillis = " + jCurrentTimeMillis);
        Log.i("AlarmPower", "==========================");
        Object systemService = mContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        Intrinsics.checkNotNull(it2);
        ((AlarmManager) systemService).set(0, jCurrentTimeMillis, PendingIntent.getBroadcast(mContext, 0, it2, 335544320));
    }
}
