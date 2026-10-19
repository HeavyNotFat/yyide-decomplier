package com.yd.android_brand_mvp.mina;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.SPUtils;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.base.BaseConstant;
import io.socket.engineio.client.Socket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.keepalive.KeepAliveFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/* JADX INFO: loaded from: classes4.dex */
public class MinaThread extends Thread {
    private IoConnector connector;
    private IoListener ioListener;
    private boolean isExit;
    private IoSession session = null;
    private MinaThread thread = this;

    public MinaThread(final Context context) {
        this.connector = null;
        this.ioListener = null;
        NioSocketConnector nioSocketConnector = new NioSocketConnector();
        this.connector = nioSocketConnector;
        nioSocketConnector.setConnectTimeoutMillis(5000L);
        this.connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(StandardCharsets.UTF_8)));
        this.connector.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 5);
        KeepAliveFilter keepAliveFilter = new KeepAliveFilter(new HeartBeatMessageFactory(), IdleStatus.BOTH_IDLE);
        keepAliveFilter.setRequestInterval(5);
        keepAliveFilter.setRequestTimeout(15);
        keepAliveFilter.setForwardEvent(true);
        this.connector.getFilterChain().addLast(Socket.EVENT_HEARTBEAT, keepAliveFilter);
        this.connector.setHandler(new MinaClientHandler(context));
        this.connector.setDefaultRemoteAddress(new InetSocketAddress(BaseConstant.WS_HOST, 60000));
        IoListener ioListener = new IoListener() { // from class: com.yd.android_brand_mvp.mina.MinaThread.1
            @Override // com.yd.android_brand_mvp.mina.IoListener, org.apache.mina.core.service.IoServiceListener
            public void sessionDestroyed(IoSession ioSession) throws Exception {
                super.sessionDestroyed(ioSession);
                try {
                    MinaThread.this.connector.dispose();
                } catch (Exception unused) {
                }
                Log.i("TAG", "sessionDestroyed: " + ioSession);
                MinaThread.this.thread = new MinaThread(context);
                MinaThread.this.thread.start();
            }
        };
        this.ioListener = ioListener;
        this.connector.addListener(ioListener);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        do {
            try {
                ConnectFuture connectFutureConnect = this.connector.connect();
                connectFutureConnect.awaitUninterruptibly();
                IoSession session = connectFutureConnect.getSession();
                this.session = session;
                if (session != null && session.isConnected()) {
                    Log.i("TAG", "MINA注册: " + MinaMsg(BaseConstant.MINA_REG));
                    WriteFuture writeFutureWrite = this.session.write(MinaMsg(BaseConstant.MINA_REG));
                    String mac = BaseApplication.getInstance().getMac();
                    Log.i("HeartBeatMessageFactory", "mac:" + mac);
                    this.session.write("no_type_" + mac);
                    writeFutureWrite.awaitUninterruptibly();
                    if (writeFutureWrite.isWritten()) {
                        SessionManager.getInstance().setSeesion(this.session);
                    } else {
                        this.session.closeNow().awaitUninterruptibly();
                        this.session = null;
                    }
                } else {
                    this.session = null;
                }
            } catch (Exception unused) {
                IoSession ioSession = this.session;
                if (ioSession != null && ioSession.isConnected()) {
                    this.session.closeNow().awaitUninterruptibly();
                }
                this.session = null;
            }
            if (this.session == null) {
                try {
                    Thread.sleep(500L);
                } catch (Exception unused2) {
                }
            }
        } while (this.session == null);
    }

    public static String MinaMsg(String str) {
        RegMina regMina = new RegMina();
        regMina.msgType = str;
        regMina.alias = SPUtils.getInstance().getString(BaseConstant.LOGINNAME, null);
        regMina.androidId = DeviceUtils.getAndroidID();
        regMina.incremental = Build.VERSION.INCREMENTAL;
        regMina.versionCode = AppUtils.getAppVersionCode();
        regMina.versionName = AppUtils.getAppVersionName();
        regMina.prot = "9902";
        return JSON.toJSONString(regMina);
    }

    public MinaThread getCurrentThread() {
        return this.thread;
    }

    public void exitMina() {
        this.isExit = true;
        Log.e("TAG", "exitMina: ");
        this.connector.removeListener(this.ioListener);
        SessionManager.getInstance().writeToServer(MinaMsg(BaseConstant.MINA_EXIT));
        SessionManager.getInstance().closeSession();
        SessionManager.getInstance().removeSession();
        IoConnector ioConnector = this.connector;
        if (ioConnector != null) {
            ioConnector.dispose();
        }
        if (this.session != null) {
            this.session = null;
        }
    }
}
