package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: classes4.dex */
public class PhoneInfoUtils {
    private static String TAG = "PhoneInfoUtils";
    private String NetworkOperator;
    private Context context;
    private TelephonyManager telephonyManager;

    public PhoneInfoUtils(Context context) {
        this.context = context;
        this.telephonyManager = (TelephonyManager) context.getSystemService("phone");
    }

    public String getIccid() {
        return this.telephonyManager.getSimSerialNumber();
    }

    public String getNativePhoneNumber() {
        return this.telephonyManager.getLine1Number();
    }

    public String getProvidersName() {
        String networkOperator = this.telephonyManager.getNetworkOperator();
        this.NetworkOperator = networkOperator;
        if (networkOperator.equals("46000") || this.NetworkOperator.equals("46002")) {
            return "中国移动";
        }
        if (this.NetworkOperator.equals("46001")) {
            return "中国联通";
        }
        return this.NetworkOperator.equals("46003") ? "中国电信" : "N/A";
    }

    public String getPhoneInfo() {
        TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService("phone");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nLine1Number = " + telephonyManager.getLine1Number());
        stringBuffer.append("\nNetworkOperator = " + telephonyManager.getNetworkOperator());
        stringBuffer.append("\nNetworkOperatorName = " + telephonyManager.getNetworkOperatorName());
        stringBuffer.append("\nSimCountryIso = " + telephonyManager.getSimCountryIso());
        stringBuffer.append("\nSimOperator = " + telephonyManager.getSimOperator());
        stringBuffer.append("\nSimOperatorName = " + telephonyManager.getSimOperatorName());
        stringBuffer.append("\nSimSerialNumber = " + telephonyManager.getSimSerialNumber());
        stringBuffer.append("\nSubscriberId(IMSI) = " + telephonyManager.getSubscriberId());
        return stringBuffer.toString();
    }
}
