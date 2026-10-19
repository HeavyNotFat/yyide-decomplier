package com.yd.android_brand_mvp;

import android.content.Context;
import android.util.Log;
import com.example.mtreader.MT3NativeFunc;
import com.example.util.RootCmd;
import com.example.util.SystemUtil;
import com.example.util.UsbDevPermission;

/* JADX INFO: loaded from: classes4.dex */
public class mtread {
    public static mtread mtread;
    private static UsbDevPermission usbPermission;
    Context context;
    private int st = 0;

    public int getDeviceIndex() {
        return 0;
    }

    public static mtread getInstance() {
        if (mtread == null) {
            synchronized (mtread.class) {
                if (mtread == null) {
                    mtread = new mtread();
                }
            }
        }
        return mtread;
    }

    public String ReadMtskCard() {
        byte[] bArr = new byte[10];
        byte[] bArr2 = new byte[200];
        byte[] bArr3 = new byte[400];
        int[] iArr = new int[10];
        int iOpenCard = MT3NativeFunc.OpenCard(bArr, bArr2, iArr);
        this.st = iOpenCard;
        if (iOpenCard != 0) {
            return "";
        }
        MT3NativeFunc.hex2asc(bArr2, bArr3, iArr[0]);
        new String(bArr3);
        return new String(bArr).trim();
    }

    public int ConnectDevice(Context context) {
        String sELinuxMode;
        int iOpendevicefdpath;
        this.context = context;
        usbPermission = new UsbDevPermission(context);
        if (getDeviceIndex() != 0) {
            return -1;
        }
        int usbFileDescriptor = usbPermission.getUsbFileDescriptor(9124, 524);
        if (usbFileDescriptor < 0 && (usbFileDescriptor = usbPermission.getUsbFileDescriptor(9124, 524)) < 0) {
            return -1;
        }
        try {
            sELinuxMode = RootCmd.getSELinuxMode();
        } catch (Exception e) {
            e.getLocalizedMessage();
            sELinuxMode = "Enforcing";
        }
        String systemVersion = SystemUtil.getSystemVersion();
        if ("Enforcing".equals(sELinuxMode.trim()) || "".equals(sELinuxMode.trim()) || systemVersion.charAt(0) >= '8') {
            iOpendevicefdpath = MT3NativeFunc.opendevicefdpath(usbPermission.getUsbDevPath(), usbFileDescriptor);
        } else {
            iOpendevicefdpath = MT3NativeFunc.opendevicefd(usbFileDescriptor);
        }
        if (iOpendevicefdpath > 0) {
            MT3NativeFunc.getversion();
            int i = MT3NativeFunc.getsnr(20, new byte[50]);
            Log.i("TAG", "打开端口成功: " + i);
            return i;
        }
        Log.i("TAG", "打开端口失败: " + iOpendevicefdpath);
        if (MT3NativeFunc.serialopen("", 115200) > 0) {
            Log.i("TAG", "打开串口成功: " + iOpendevicefdpath);
            return -1;
        }
        Log.i("TAG", "打开串口失败: " + iOpendevicefdpath);
        return -1;
    }

    public void unUsbDevPermission() {
        UsbDevPermission usbDevPermission = usbPermission;
        if (usbDevPermission != null) {
            usbDevPermission.unUsbDevPermission();
        }
    }
}
