package com.yd.android_brand_mvp.websocket;

import android.os.Message;
import android.text.TextUtils;
import com.blankj.utilcode.util.LogUtils;
import com.google.gson.Gson;
import com.yd.android_brand_mvp.base.BaseConstant;

/* JADX INFO: loaded from: classes4.dex */
public class WebSocketIOService implements WsStatueListener {
    private static final String TAG = "SocketIO";
    private static WebSocketIOService socketIOService;
    private MainIOThread mainThread;

    public static WebSocketIOService getInstance() {
        if (socketIOService == null) {
            synchronized (WebSocketIOService.class) {
                if (socketIOService == null) {
                    socketIOService = new WebSocketIOService();
                }
            }
        }
        return socketIOService;
    }

    public void create() {
        if (this.mainThread == null) {
            MainIOThread mainIOThread = new MainIOThread(0, BaseConstant.WS_HOST);
            this.mainThread = mainIOThread;
            mainIOThread.setSocketListener(this);
            this.mainThread.start();
        }
    }

    public void joinMessage(String str) {
        Message message = new Message();
        message.what = 1;
        message.obj = str;
        this.mainThread.getHandler().sendMessage(message);
    }

    @Override // com.yd.android_brand_mvp.websocket.WsStatueListener
    public void onConnected(int i) {
        LogUtils.e("Socket IO 连接成功 任务：" + i);
    }

    @Override // com.yd.android_brand_mvp.websocket.WsStatueListener
    public void onConnectError(int i, Throwable th) {
        LogUtils.e("Socket IO 连接出错 任务：" + i);
    }

    @Override // com.yd.android_brand_mvp.websocket.WsStatueListener
    public void onSendError(int i, Throwable th) {
        LogUtils.e("Socket IO 发送失败 任务：" + i);
    }

    @Override // com.yd.android_brand_mvp.websocket.WsStatueListener
    public void onMessageResponse(int i, String str, Object... objArr) {
        LogUtils.i(objArr);
        if (TextUtils.equals(str, "SEND")) {
            EventBusUtils.postSuccessEvent("SEND", (WebSocketEventBean) new Gson().fromJson(objArr[0].toString(), WebSocketEventBean.class));
        }
    }
}
