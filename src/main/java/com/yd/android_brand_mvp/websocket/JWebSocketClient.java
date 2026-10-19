package com.yd.android_brand_mvp.websocket;

import android.util.Log;
import java.net.URI;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ServerHandshake;

/* JADX INFO: loaded from: classes4.dex */
public class JWebSocketClient extends WebSocketClient {
    public JWebSocketClient(URI uri) {
        super(uri, new Draft_6455());
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onOpen(ServerHandshake serverHandshake) {
        Log.e("JWebSocketClient", "onOpen()");
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onMessage(String str) {
        Log.e("JWebSocketClient", "onMessage()");
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onClose(int i, String str, boolean z) {
        Log.e("JWebSocketClient", "onClose()");
    }

    @Override // org.java_websocket.client.WebSocketClient
    public void onError(Exception exc) {
        Log.e("JWebSocketClient", "onError()");
    }
}
