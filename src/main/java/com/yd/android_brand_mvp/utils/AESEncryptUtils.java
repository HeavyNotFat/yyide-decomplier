package com.yd.android_brand_mvp.utils;

import android.text.TextUtils;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes4.dex */
public class AESEncryptUtils {
    public static final String AES_DATA_SECURITY_KEY = "fAY&d#%kzkKj1_nSciE%Bh3XPi6x$c$M";
    private static final String AES_PERSON_KEY_SECURITY_KEY = "pisnyMyZYXuCNcRd";
    private static final String AES_PKCS5P = "AES/ECB/PKCS5Padding";

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            throw new RuntimeException("key不能为空");
        }
        if (str == null) {
            return null;
        }
        try {
            if (str2.length() != 32) {
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance(AES_PKCS5P);
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            throw new RuntimeException("key不能为空");
        }
        if (str == null) {
            return null;
        }
        try {
            if (str2.length() != 32) {
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("UTF-8"), "AES");
            Cipher cipher = Cipher.getInstance(AES_PKCS5P);
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(Base64.decode(str, 0)), "UTF-8");
        } catch (Exception unused) {
            return null;
        }
    }

    public static String encrypt(String str) {
        return encrypt(str, AES_DATA_SECURITY_KEY);
    }

    public static String decrypt(String str) {
        return decrypt(str, AES_DATA_SECURITY_KEY);
    }

    public static String encryptPersonKey(String str) {
        return encrypt(str, AES_PERSON_KEY_SECURITY_KEY);
    }

    public static String decryptPersonKey(String str) {
        return decrypt(str, AES_PERSON_KEY_SECURITY_KEY);
    }
}
