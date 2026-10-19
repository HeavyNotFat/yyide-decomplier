package com.yd.android_brand_mvp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes4.dex */
public class MD5 {
    public static String md5Password(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("md5").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
