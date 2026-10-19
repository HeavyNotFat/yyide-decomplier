package com.yd.android_brand_mvp.mina;

import org.apache.mina.core.session.IoSession;

/* JADX INFO: loaded from: classes4.dex */
public class SessionManager {
    private static SessionManager mInstance;
    private IoSession mSession;

    public static SessionManager getInstance() {
        if (mInstance == null) {
            synchronized (SessionManager.class) {
                if (mInstance == null) {
                    mInstance = new SessionManager();
                }
            }
        }
        return mInstance;
    }

    private SessionManager() {
    }

    public void setSeesion(IoSession ioSession) {
        this.mSession = ioSession;
    }

    public void writeToServer(Object obj) {
        IoSession ioSession = this.mSession;
        if (ioSession == null || !ioSession.isConnected()) {
            return;
        }
        try {
            this.mSession.write(obj);
        } catch (Exception unused) {
        }
    }

    public void closeSession() {
        IoSession ioSession = this.mSession;
        if (ioSession != null) {
            ioSession.closeOnFlush();
        }
    }

    public void removeSession() {
        this.mSession = null;
    }
}
