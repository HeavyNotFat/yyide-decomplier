package com.yd.android_brand_mvp.utils.view.net;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class NetWorkUtil {
    public static int NET_ETHERNET = 1;
    public static int NET_NOCONNECT = 0;
    public static int NET_WIFI = 2;
    public static final int TYPE_ETHERNET = 3;
    public static final int TYPE_MOBILE = 2;
    public static final int TYPE_NOT_CONNECTED = 0;
    public static final int TYPE_WIFI = 1;

    public static int getConnectivityStatus(Context context, Intent intent) {
        NetworkInfo activeNetworkInfo;
        String action = intent.getAction();
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE") || action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            int iIsNetworkAvailable = isNetworkAvailable(context);
            if (iIsNetworkAvailable == 0) {
                System.out.println("-----------networktest---------无网络");
                return 0;
            }
            if (iIsNetworkAvailable == 1) {
                return 3;
            }
            if (iIsNetworkAvailable == 2 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.getType() == 1) {
                    return 1;
                }
                if (activeNetworkInfo.getType() == 0) {
                    return 2;
                }
            }
            return 0;
        }
        return 0;
    }

    public static String getMacAddressByWifiInfo() {
        try {
            WifiManager wifiManager = (WifiManager) Utils.getApp().getApplicationContext().getSystemService("wifi");
            return (wifiManager == null || !wifiManager.isWifiEnabled()) ? "" : DeviceUtils.getMacAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(9);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isConnected()) {
            return NET_ETHERNET;
        }
        if (networkInfo2 != null && networkInfo2.isConnected()) {
            return NET_WIFI;
        }
        return NET_NOCONNECT;
    }
}
