package com.yd.android_brand_mvp.websocket;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import io.socket.engineio.client.transports.WebSocket;

/* JADX INFO: loaded from: classes4.dex */
public class MainIOThread extends Thread {
    private static final String TAG = "SocketIO";
    private static Object argsObj;
    private String connectUrl;
    private WebSocketHandler mHandler = new WebSocketHandler();
    private Socket mSocket;
    private WsStatueListener mWsStatueListener;
    private int type;

    public MainIOThread(int i, String str) {
        this.type = i;
        this.connectUrl = str;
    }

    public Handler getHandler() {
        return this.mHandler;
    }

    public void setSocketListener(WsStatueListener wsStatueListener) {
        this.mWsStatueListener = wsStatueListener;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        initConnect();
    }

    public void initConnect() {
        Log.e(TAG, "initConnect = " + this.connectUrl);
        IO.Options options = new IO.Options();
        options.transports = new String[]{WebSocket.NAME};
        try {
            this.mSocket = IO.socket(this.connectUrl, options);
            this.mSocket.on("connect", new Emitter.Listener() { // from class: com.yd.android_brand_mvp.websocket.-$$Lambda$MainIOThread$z6kV433ZVzxvVa0OcQG8MFpRIrk
                @Override // io.socket.emitter.Emitter.Listener
                public final void call(Object[] objArr) {
                    this.f$0.lambda$initConnect$0$MainIOThread(objArr);
                }
            });
            this.mSocket.on(ConstantIO.message, new Emitter.Listener() { // from class: com.yd.android_brand_mvp.websocket.-$$Lambda$MainIOThread$626ikAaJ8tx6EoHjwrHeF3L6jP4
                @Override // io.socket.emitter.Emitter.Listener
                public final void call(Object[] objArr) {
                    Log.i(MainIOThread.TAG, "KEY[MESSAGE]socket receive :" + objArr[0].toString());
                }
            });
            this.mSocket.connect();
        } catch (Exception e) {
            e.printStackTrace();
            this.mWsStatueListener.onConnectError(this.type, e);
        }
    }

    public /* synthetic */ void lambda$initConnect$0$MainIOThread(Object[] objArr) {
        argsObj = objArr;
        this.mWsStatueListener.onConnected(this.type);
        Log.v(TAG, "socket receive connect::" + objArr.toString());
        Log.v(TAG, "socket receive send::SEND");
        this.mSocket.emit("SEND", objArr);
        this.mSocket.emit("SEND", objArr);
    }

    private class WebSocketHandler extends Handler {
        private WebSocketHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                MainIOThread.this.mSocket.emit("SEND", (String) message.obj, TtmlNode.CENTER, "argsObj");
            }
        }
    }
}
