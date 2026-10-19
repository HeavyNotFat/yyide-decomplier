package com.yd.android_brand_mvp.mina;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.vise.utils.assist.DateUtil;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.base.MinaConstants;
import com.yd.android_brand_mvp.brand.BroCast;
import com.yd.android_brand_mvp.observer.MinaEventManager;
import com.yd.android_brand_mvp.utils.ConversionUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class MinaClientHandler extends IoHandlerAdapter {
    private String TAG = MinaClientHandler.class.getSimpleName();
    Context context;

    public MinaClientHandler(Context context) {
        this.context = context;
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public void sessionIdle(IoSession ioSession, IdleStatus idleStatus) throws Exception {
        super.sessionIdle(ioSession, idleStatus);
        String mac = BaseApplication.getInstance().getMac();
        Log.i("HeartBeatMessageFactory", "mac:" + mac);
        SessionManager.getInstance().writeToServer("no_type_" + mac);
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public void exceptionCaught(IoSession ioSession, Throwable th) throws Exception {
        super.exceptionCaught(ioSession, th);
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public void messageReceived(IoSession ioSession, Object obj) throws Exception {
        String string = obj.toString();
        Received(string);
        Log.i("TAG", "messageReceived: " + string);
        super.messageReceived(ioSession, obj);
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public void messageSent(IoSession ioSession, Object obj) throws Exception {
        obj.toString();
        super.messageSent(ioSession, obj);
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public void sessionClosed(IoSession ioSession) throws Exception {
        Log.d(this.TAG, DateUtil.getStartTime() + " : 客户端调用sessionClosed");
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public void sessionCreated(IoSession ioSession) throws Exception {
        Log.d(this.TAG, DateUtil.getStartTime() + " : 客户端调用sessionCreated");
    }

    @Override // org.apache.mina.core.service.IoHandlerAdapter, org.apache.mina.core.service.IoHandler
    public void sessionOpened(IoSession ioSession) throws Exception {
        Log.d(this.TAG, DateUtil.getStartTime() + " : 客户端调用sessionOpened");
    }

    private void Received(String str) {
        try {
            Log.i("TAG", "Received: " + str);
            String string = new JSONObject(str).getString("type");
            int i = Integer.parseInt(string);
            if (!TextUtils.isEmpty(string) && i > 5) {
                if (i == MinaConstants.PhotoVideo) {
                    MinaEventManager.getInstance().notifyObserver(MinaConstants.photoAndvideo);
                } else {
                    MinaEventManager.getInstance().notifyObserver(Integer.parseInt(string));
                }
            }
            byte b = -1;
            int iHashCode = string.hashCode();
            if (iHashCode != 52) {
                if (iHashCode == 53 && string.equals(ConversionUtil.conditionWithSeriesName)) {
                    b = 1;
                }
            } else if (string.equals("4")) {
                b = 0;
            }
            if (b == 0) {
                BroCast.shutdown(this.context);
            } else {
                if (b != 1) {
                    return;
                }
                BroCast.reboot(this.context);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    protected void showToast(String str) {
        Toast.makeText(this.context, str, 0).show();
    }

    public static boolean isTimeOut(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).after(new Date());
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int getIternalTime(String str) {
        try {
            return (int) ((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime() - new Date(System.currentTimeMillis()).getTime()) / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
