package com.yd.android_brand_mvp.utils;

import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/* JADX INFO: loaded from: classes4.dex */
public class SocketUtil {
    public static void socketPictureReception(String str, int i) {
        try {
            Socket socket = new Socket(str, i);
            InputStream inputStream = socket.getInputStream();
            byte[] bArr = new byte[200];
            int i2 = Integer.parseInt(new String(bArr, 0, inputStream.read(bArr)));
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("1".getBytes());
            outputStream.flush();
            byte[] bArr2 = new byte[i2];
            int i3 = 0;
            while (i3 < i2) {
                i3 += inputStream.read(bArr2, i3, i2 - i3);
            }
            BitmapFactory.decodeByteArray(bArr2, 0, i3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
