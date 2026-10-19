package com.yd.android_brand_mvp.websocket;

import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.google.android.exoplayer2.C;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.brand.BroCast;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import java.net.URI;
import java.util.HashMap;
import javax.net.ssl.SSLParameters;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class JWebSocketClientService extends Service {
    private static final int CLOSE_RECON_TIME = 5000;
    private static final int GRAY_SERVICE_ID = 1001;
    private static final long HEART_BEAT_RATE = 5000;
    public JWebSocketClient client;
    PowerManager.WakeLock wakeLock;
    private JWebSocketClientBinder mBinder = new JWebSocketClientBinder();
    private boolean isStop = false;
    private long time = 0;
    private Handler mHandler = new Handler();
    private Runnable heartBeatRunnable = new Runnable() { // from class: com.yd.android_brand_mvp.websocket.JWebSocketClientService.3
        @Override // java.lang.Runnable
        public void run() {
            if (JWebSocketClientService.this.isStop) {
                return;
            }
            if (JWebSocketClientService.this.client != null) {
                if (JWebSocketClientService.this.client.isClosed()) {
                    Log.e("JWebSocketClientService", BaseConstant.WS_HOST);
                    Log.i("JWebSocketClientService", "reconnectWs 重连");
                    JWebSocketClientService.this.reconnectWs();
                } else if (System.currentTimeMillis() - JWebSocketClientService.this.time >= C.DEFAULT_SEEK_FORWARD_INCREMENT_MS) {
                    Log.e("JWebSocketClientService", "close 关闭连接");
                    Log.e("JWebSocketClientService", BaseConstant.WS_HOST);
                    JWebSocketClientService.this.client.close();
                } else {
                    HashMap map = new HashMap();
                    map.put("type", "ping");
                    JWebSocketClientService.this.sendMsg(JSON.toJSONString(map));
                }
            } else {
                JWebSocketClientService.this.client = null;
                JWebSocketClientService.this.initSocketClient();
            }
            JWebSocketClientService.this.mHandler.postDelayed(this, 5000L);
        }
    };

    public static class GrayInnerService extends Service {
        @Override // android.app.Service
        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override // android.app.Service
        public int onStartCommand(Intent intent, int i, int i2) {
            startForeground(1001, new Notification());
            stopForeground(true);
            stopSelf();
            return super.onStartCommand(intent, i, i2);
        }
    }

    private void acquireWakeLock() {
        if (this.wakeLock == null) {
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(536870913, "PostLocationService");
            this.wakeLock = wakeLockNewWakeLock;
            if (wakeLockNewWakeLock != null) {
                wakeLockNewWakeLock.acquire(600000L);
            }
        }
    }

    public class JWebSocketClientBinder extends Binder {
        public JWebSocketClientBinder() {
        }

        public JWebSocketClientService getService() {
            return JWebSocketClientService.this;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        LogUtils.i("onStartCommand: onStartCommand");
        initSocketClient();
        if (Build.VERSION.SDK_INT < 26) {
            startService(new Intent(this, (Class<?>) GrayInnerService.class));
            startForeground(1001, new Notification());
        } else {
            NotificationChannel notificationChannel = new NotificationChannel("channel_id", "channel_name", 1);
            NotificationManager notificationManager = (NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(notificationChannel);
                startForeground(1001, new Notification.Builder(getApplicationContext(), "channel_id_tai_bang").setChannelId("channel_id").build());
            }
        }
        acquireWakeLock();
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        closeConnect();
        LogUtils.i("close WebSocket");
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSocketClient() {
        LogUtils.i("DevicesMac：" + BaseApplication.getInstance().getMac());
        JWebSocketClient jWebSocketClient = new JWebSocketClient(URI.create(BaseConstant.WS_HOST)) { // from class: com.yd.android_brand_mvp.websocket.JWebSocketClientService.1
            /* JADX WARN: Code duplicated, block: B:22:0x009e  */
            /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
            @Override // com.yd.android_brand_mvp.websocket.JWebSocketClient, org.java_websocket.client.WebSocketClient
            public void onMessage(String str) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String strOptString = jSONObject.optString("type");
                    String strOptString2 = jSONObject.optString("data");
                    if (TextUtils.isEmpty(strOptString2)) {
                        JWebSocketClientService.this.time = System.currentTimeMillis();
                        return;
                    }
                    String strOptString3 = new JSONObject(strOptString2).optString("eventCode");
                    byte b = 0;
                    LogUtils.i("brand webSocket code :" + strOptString3);
                    Log.e("JWebSocketClientService", "type：" + strOptString);
                    if ("1306".equals(strOptString3) || WebSocketEventBean.CODE_CAMPUSSTYLE_CHANGE.equals(strOptString3)) {
                        MinaEventManager.getInstance().notifyObserver(MinaConstants.photoAndvideo);
                    } else {
                        MinaEventManager.getInstance().notifyObserver(Integer.parseInt(strOptString3));
                    }
                    switch (strOptString3.hashCode()) {
                        case 1510306:
                            if (!strOptString3.equals(WebSocketEventBean.CODE_TURN_OFF)) {
                                b = -1;
                            }
                            break;
                        case 1510307:
                            if (!strOptString3.equals(WebSocketEventBean.CODE_RESTART)) {
                                b = -1;
                            } else {
                                b = 1;
                            }
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b == 0) {
                        BroCast.shutdown(JWebSocketClientService.this.getApplicationContext());
                    } else {
                        if (b != 1) {
                            return;
                        }
                        BroCast.reboot(JWebSocketClientService.this.getApplicationContext());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.yd.android_brand_mvp.websocket.JWebSocketClient, org.java_websocket.client.WebSocketClient
            public void onOpen(ServerHandshake serverHandshake) {
                super.onOpen(serverHandshake);
                LogUtils.i("websocket open");
                JWebSocketClientService.this.time = System.currentTimeMillis();
                JWebSocketClientService.this.mHandler.removeCallbacks(JWebSocketClientService.this.heartBeatRunnable);
                JWebSocketClientService.this.mHandler.postDelayed(JWebSocketClientService.this.heartBeatRunnable, 5000L);
            }

            @Override // org.java_websocket.client.WebSocketClient
            protected void onSetSSLParameters(SSLParameters sSLParameters) {
                try {
                    if (Build.VERSION.SDK_INT >= 24) {
                        super.onSetSSLParameters(sSLParameters);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override // com.yd.android_brand_mvp.websocket.JWebSocketClient, org.java_websocket.client.WebSocketClient
            public void onClose(int i, String str, boolean z) {
                Log.i("JWebSocketClientService", "onClose() 连接断开_reason：" + str);
                JWebSocketClientService.this.mHandler.removeCallbacks(JWebSocketClientService.this.heartBeatRunnable);
                JWebSocketClientService.this.mHandler.postDelayed(JWebSocketClientService.this.heartBeatRunnable, 5000L);
            }

            @Override // com.yd.android_brand_mvp.websocket.JWebSocketClient, org.java_websocket.client.WebSocketClient
            public void onError(Exception exc) {
                Log.i("JWebSocketClientService", "onError() 连接出错：" + exc.getMessage());
                JWebSocketClientService.this.mHandler.removeCallbacks(JWebSocketClientService.this.heartBeatRunnable);
                JWebSocketClientService.this.mHandler.postDelayed(JWebSocketClientService.this.heartBeatRunnable, 5000L);
            }
        };
        this.client = jWebSocketClient;
        jWebSocketClient.setConnectionLostTimeout(5);
        this.client.addHeader("deviceNo", BaseApplication.getInstance().getMac());
        connect();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.yd.android_brand_mvp.websocket.JWebSocketClientService$2] */
    private void connect() {
        new Thread() { // from class: com.yd.android_brand_mvp.websocket.JWebSocketClientService.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    JWebSocketClientService.this.client.connectBlocking();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    public void sendMsg(String str) {
        if (this.client != null) {
            Log.e("JWebSocketClientService", "发送的消息：" + str);
            try {
                this.client.send(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void closeConnect() {
        this.isStop = true;
        this.mHandler.removeCallbacks(this.heartBeatRunnable);
        try {
            try {
                if (this.client != null) {
                    this.client.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.client = null;
        }
    }

    private void checkLockAndShowNotification(String str) {
        if (((KeyguardManager) getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            PowerManager powerManager = (PowerManager) getSystemService("power");
            if (powerManager.isScreenOn()) {
                return;
            }
            PowerManager.WakeLock wakeLockNewWakeLock = powerManager.newWakeLock(268435466, "bright");
            wakeLockNewWakeLock.acquire(600000L);
            wakeLockNewWakeLock.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.yd.android_brand_mvp.websocket.JWebSocketClientService$4] */
    public void reconnectWs() {
        this.mHandler.removeCallbacks(this.heartBeatRunnable);
        new Thread() { // from class: com.yd.android_brand_mvp.websocket.JWebSocketClientService.4
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    Log.i("JWebSocketClientService", "开启重连");
                    JWebSocketClientService.this.client.reconnectBlocking();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
