package com.yd.android_brand_mvp.socket;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SocketClient.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u00010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u0004J\u0006\u0010%\u001a\u00020&J)\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\b2\u0006\u0010*\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\u000e\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u000b*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/yd/android_brand_mvp/socket/SocketClient;", "", "()V", "END_START", "", "IMAGE_START", "SEPARATOR", "SOCKET_PORT", "", "SUBJECT_START", "TAG", "kotlin.jvm.PlatformType", "TIME_START", "connectThread", "Ljava/lang/Thread;", "inputStreamReader", "Ljava/io/InputStreamReader;", "ip", "isConnect", "", "()Z", "setConnect", "(Z)V", "isReConnect", "mCallback", "Lcom/yd/android_brand_mvp/socket/ClientCallback;", "outputStream", "Ljava/io/OutputStream;", "socket", "Ljava/net/Socket;", "task", "Ljava/util/TimerTask;", "timer", "Ljava/util/Timer;", "base642Bitmap", "Landroid/graphics/Bitmap;", "base64String", "closeConnect", "", "connectServer", "ipAddress", "post", "callback", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/yd/android_brand_mvp/socket/ClientCallback;)V", "releaseSocket", "sendBeatData", "sendToServer", "msg", "ClientThread", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SocketClient {
    public static final String END_START = "end";
    public static final String IMAGE_START = "image:";
    public static final String SEPARATOR = "#";
    public static final int SOCKET_PORT = 9393;
    public static final String SUBJECT_START = "subject:";
    public static final String TIME_START = "time:";
    private static Thread connectThread;
    private static InputStreamReader inputStreamReader;
    private static String ip;
    private static boolean isConnect;
    private static ClientCallback mCallback;
    private static OutputStream outputStream;
    private static Socket socket;
    private static TimerTask task;
    public static final SocketClient INSTANCE = new SocketClient();
    private static final String TAG = SocketClient.class.getSimpleName();
    private static Timer timer = new Timer();
    private static boolean isReConnect = true;

    private SocketClient() {
    }

    public final boolean isConnect() {
        return isConnect;
    }

    public final void setConnect(boolean z) {
        isConnect = z;
    }

    @JvmStatic
    public static final void connectServer(final String ipAddress, final Integer post, ClientCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        mCallback = callback;
        ip = ipAddress;
        if (socket == null) {
            Thread thread = new Thread(new Runnable() { // from class: com.yd.android_brand_mvp.socket.-$$Lambda$SocketClient$A8aftHfDHFynYf_-xrrt82bPX4U
                @Override // java.lang.Runnable
                public final void run() {
                    SocketClient.connectServer$lambda$0(ipAddress, post);
                }
            });
            connectThread = thread;
            if (thread != null) {
                thread.start();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectServer$lambda$0(String str, Integer num) {
        try {
            Intrinsics.checkNotNull(num);
            socket = new Socket(str, num.intValue());
            Socket socket2 = socket;
            Intrinsics.checkNotNull(socket2);
            ClientCallback clientCallback = mCallback;
            if (clientCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                clientCallback = null;
            }
            new ClientThread(socket2, clientCallback).start();
            INSTANCE.sendBeatData();
        } catch (IOException e) {
            e.printStackTrace();
            INSTANCE.sendBeatData();
        }
    }

    public final void closeConnect() {
        InputStreamReader inputStreamReader2 = inputStreamReader;
        if (inputStreamReader2 != null) {
            inputStreamReader2.close();
        }
        OutputStream outputStream2 = outputStream;
        if (outputStream2 != null) {
            outputStream2.close();
        }
        isReConnect = false;
        releaseSocket();
        Log.d(TAG, "关闭连接");
    }

    public final void sendToServer(final String msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        new Thread(new Runnable() { // from class: com.yd.android_brand_mvp.socket.-$$Lambda$SocketClient$EE6HX1OUbux9PNwi3e_Zw6W3bGA
            @Override // java.lang.Runnable
            public final void run() {
                SocketClient.sendToServer$lambda$1(msg);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendToServer$lambda$1(String msg) {
        Intrinsics.checkNotNullParameter(msg, "$msg");
        Socket socket2 = socket;
        Intrinsics.checkNotNull(socket2);
        if (socket2.isClosed()) {
            Log.e(TAG, "sendToServer: Socket is closed");
            return;
        }
        Socket socket3 = socket;
        ClientCallback clientCallback = null;
        OutputStream outputStream2 = socket3 != null ? socket3.getOutputStream() : null;
        outputStream = outputStream2;
        if (outputStream2 != null) {
            try {
                byte[] bytes = msg.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                outputStream2.write(bytes);
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(TAG, "向服务端发送消息失败");
                return;
            }
        }
        OutputStream outputStream3 = outputStream;
        if (outputStream3 != null) {
            outputStream3.flush();
        }
        ClientCallback clientCallback2 = mCallback;
        if (clientCallback2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCallback");
        } else {
            clientCallback = clientCallback2;
        }
        clientCallback.otherMsg("toServer: " + msg);
    }

    /* JADX INFO: compiled from: SocketClient.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/socket/SocketClient$ClientThread;", "Ljava/lang/Thread;", "socket", "Ljava/net/Socket;", "callback", "Lcom/yd/android_brand_mvp/socket/ClientCallback;", "(Ljava/net/Socket;Lcom/yd/android_brand_mvp/socket/ClientCallback;)V", "run", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ClientThread extends Thread {
        private final ClientCallback callback;
        private final Socket socket;

        public ClientThread(Socket socket, ClientCallback callback) {
            Intrinsics.checkNotNullParameter(socket, "socket");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.socket = socket;
            this.callback = callback;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                InputStream inputStream = this.socket.getInputStream();
                byte[] bArr = new byte[1024];
                if (inputStream.available() == 0) {
                    Log.e(SocketClient.TAG, "inputStream.available() == 0");
                }
                SocketClient.INSTANCE.setConnect(true);
                Log.e(SocketClient.TAG, "socket connect Success");
                while (true) {
                    String str = "";
                    do {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            return;
                        }
                        str = str + new String(bArr, 0, i, Charsets.UTF_8);
                    } while (!StringsKt.endsWith$default(str, "end", false, 2, (Object) null));
                    this.callback.receiveServerMsg(str);
                }
            } catch (IOException e) {
                if (Intrinsics.areEqual(e.getMessage(), "Connection reset")) {
                    SocketClient.INSTANCE.setConnect(false);
                }
                e.printStackTrace();
                String message = e.getMessage();
                if (message != null) {
                    Log.e(SocketClient.TAG, message);
                }
                this.callback.receiveServerMsg("");
            }
        }
    }

    private final void sendBeatData() {
        if (timer == null) {
            timer = new Timer();
        }
        if (task == null) {
            task = new TimerTask() { // from class: com.yd.android_brand_mvp.socket.SocketClient.sendBeatData.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        SocketClient socketClient = SocketClient.INSTANCE;
                        Socket socket2 = SocketClient.socket;
                        Intrinsics.checkNotNull(socket2);
                        SocketClient.outputStream = socket2.getOutputStream();
                        OutputStream outputStream2 = SocketClient.outputStream;
                        if (outputStream2 != null) {
                            Charset charsetForName = Charset.forName("gbk");
                            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
                            byte[] bytes = "test".getBytes(charsetForName);
                            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                            outputStream2.write(bytes);
                        }
                        OutputStream outputStream3 = SocketClient.outputStream;
                        if (outputStream3 != null) {
                            outputStream3.flush();
                        }
                    } catch (Exception e) {
                        Log.e("sendBeatData", "连接断开，正在重连");
                        SocketClient.INSTANCE.releaseSocket();
                        e.printStackTrace();
                    }
                }
            };
        }
        Timer timer2 = timer;
        Intrinsics.checkNotNull(timer2);
        timer2.schedule(task, 0L, 5000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void releaseSocket() {
        TimerTask timerTask = task;
        ClientCallback clientCallback = null;
        if (timerTask != null) {
            Intrinsics.checkNotNull(timerTask);
            timerTask.cancel();
            task = null;
        }
        Timer timer2 = timer;
        if (timer2 != null) {
            Intrinsics.checkNotNull(timer2);
            timer2.purge();
            Timer timer3 = timer;
            Intrinsics.checkNotNull(timer3);
            timer3.cancel();
            timer = null;
        }
        OutputStream outputStream2 = outputStream;
        if (outputStream2 != null) {
            try {
                Intrinsics.checkNotNull(outputStream2);
                outputStream2.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            outputStream = null;
        }
        Socket socket2 = socket;
        if (socket2 != null) {
            try {
                Intrinsics.checkNotNull(socket2);
                socket2.close();
            } catch (IOException unused) {
            }
            socket = null;
        }
        if (connectThread != null) {
            connectThread = null;
        }
        if (isReConnect) {
            String str = ip;
            Integer numValueOf = Integer.valueOf(SOCKET_PORT);
            ClientCallback clientCallback2 = mCallback;
            if (clientCallback2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCallback");
            } else {
                clientCallback = clientCallback2;
            }
            connectServer(str, numValueOf, clientCallback);
        }
    }

    public final Bitmap base642Bitmap(String base64String) {
        if (base64String == null) {
            throw null;
        }
        try {
            byte[] bArrDecode = Base64.decode(base64String, 0);
            Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(base64String, Base64.DEFAULT)");
            return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
