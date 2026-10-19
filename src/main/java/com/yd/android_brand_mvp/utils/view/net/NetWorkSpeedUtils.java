package com.yd.android_brand_mvp.utils.view.net;

import android.content.Context;
import android.net.TrafficStats;
import android.os.Handler;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: classes4.dex */
public class NetWorkSpeedUtils {
    private Context context;
    private Handler mHandler;
    private long lastTotalRxBytes = 0;
    private long lastTimeStamp = 0;
    TimerTask task = new TimerTask() { // from class: com.yd.android_brand_mvp.utils.view.net.NetWorkSpeedUtils.1
        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            NetWorkSpeedUtils.this.showNetSpeed();
        }
    };

    public NetWorkSpeedUtils(Context context, Handler handler) {
        this.context = context;
        this.mHandler = handler;
    }

    public void startShowNetSpeed() {
        this.lastTotalRxBytes = getTotalRxBytes();
        this.lastTimeStamp = System.currentTimeMillis();
        new Timer().schedule(this.task, 1000L, 1000L);
    }

    private long getTotalRxBytes() {
        if (TrafficStats.getUidRxBytes(this.context.getApplicationInfo().uid) == -1) {
            return 0L;
        }
        return TrafficStats.getTotalRxBytes() / 1024;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNetSpeed() {
        long totalRxBytes = getTotalRxBytes();
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.lastTotalRxBytes;
        long j2 = this.lastTimeStamp;
        long j3 = ((totalRxBytes - j) * 1000) / (jCurrentTimeMillis - j2);
        long j4 = ((totalRxBytes - j) * 1000) % (jCurrentTimeMillis - j2);
        this.lastTimeStamp = jCurrentTimeMillis;
        this.lastTotalRxBytes = totalRxBytes;
        Message messageObtainMessage = this.mHandler.obtainMessage();
        messageObtainMessage.what = 100;
        messageObtainMessage.obj = String.valueOf(j3) + "." + String.valueOf(j4) + " kb/s";
        this.mHandler.sendMessage(messageObtainMessage);
    }
}
