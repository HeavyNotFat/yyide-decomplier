package com.yd.android_brand_mvp.mina;

import android.util.Log;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

/* JADX INFO: loaded from: classes4.dex */
public class HeartBeatMessageFactory implements KeepAliveMessageFactory {
    private static final String PING = "ping";
    private static final String PONG = "pong";

    @Override // org.apache.mina.filter.keepalive.KeepAliveMessageFactory
    public boolean isRequest(IoSession ioSession, Object obj) {
        Log.i("HeartBeatMessageFactory", "isRequest:" + obj + "\tioSessionId:" + ioSession.getId());
        return obj.equals("ping");
    }

    @Override // org.apache.mina.filter.keepalive.KeepAliveMessageFactory
    public boolean isResponse(IoSession ioSession, Object obj) {
        Log.i("HeartBeatMessageFactory", "isResponse:" + obj);
        return obj.equals("pong");
    }

    @Override // org.apache.mina.filter.keepalive.KeepAliveMessageFactory
    public Object getRequest(IoSession ioSession) {
        Log.i("HeartBeatMessageFactory", "ping");
        return "ping";
    }

    @Override // org.apache.mina.filter.keepalive.KeepAliveMessageFactory
    public Object getResponse(IoSession ioSession, Object obj) {
        Log.i("HeartBeatMessageFactory", "pong");
        return "pong";
    }
}
