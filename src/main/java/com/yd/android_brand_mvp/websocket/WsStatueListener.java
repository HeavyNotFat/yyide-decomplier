package com.yd.android_brand_mvp.websocket;

/* JADX INFO: loaded from: classes4.dex */
public interface WsStatueListener {
    void onConnectError(int i, Throwable th);

    void onConnected(int i);

    void onMessageResponse(int i, String str, Object... objArr);

    void onSendError(int i, Throwable th);
}
