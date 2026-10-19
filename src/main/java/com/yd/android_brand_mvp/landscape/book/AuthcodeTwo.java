package com.yd.android_brand_mvp.landscape.book;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public class AuthcodeTwo {

    public enum DiscuzAuthcodeMode {
        Encode,
        Decode
    }

    public static String CutString(String str, int i, int i2) {
        int i3 = 0;
        if (i >= 0) {
            if (i2 < 0) {
                i2 *= -1;
                int i4 = i - i2;
                if (i4 < 0) {
                    i2 = i;
                    i = 0;
                } else {
                    i = i4;
                }
            }
            if (i > str.length()) {
                return "";
            }
            i3 = i;
        } else if (i2 < 0 || (i2 = i2 + i) <= 0) {
            return "";
        }
        if (str.length() - i3 < i2) {
            i2 = str.length() - i3;
        }
        return str.substring(i3, i2 + i3);
    }

    public static String CutString(String str, int i) {
        return CutString(str, i, str.length());
    }

    public static boolean FileExists(String str) {
        return new File(str).exists();
    }

    public static boolean StrIsNullOrEmpty(String str) {
        return str == null || str.trim().equals("");
    }

    private static byte[] GetKey(byte[] bArr, int i) {
        byte[] bArr2 = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr2[i2] = (byte) i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = ((i3 + ((bArr2[i4] + 256) % 256)) + bArr[i4 % bArr.length]) % i;
            byte b = bArr2[i4];
            bArr2[i4] = bArr2[i3];
            bArr2[i3] = b;
        }
        return bArr2;
    }

    public static String RandomString(int i) {
        char[] cArr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            str = str + cArr[Math.abs(random.nextInt(35))];
        }
        return str;
    }

    public static String authcodeEncode(String str, String str2, int i) {
        return authcode(str, str2, DiscuzAuthcodeMode.Encode, i);
    }

    public static String authcodeEncode(String str, String str2) {
        return authcode(str, str2, DiscuzAuthcodeMode.Encode, 0);
    }

    public static String authcodeEncodeFace(String str, String str2) {
        try {
            return authcode(URLEncoder.encode(str, "UTF-8"), str2, DiscuzAuthcodeMode.Encode, 0);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String authcodeDecode(String str, String str2) {
        return authcode(str, str2, DiscuzAuthcodeMode.Decode, 0);
    }

    private static String authcode(String str, String str2, DiscuzAuthcodeMode discuzAuthcodeMode, int i) {
        if (str != null && str2 != null) {
            try {
                String strMD52 = MD52(str2);
                String strMD53 = MD52(CutString(strMD52, 0, 16));
                String strMD54 = MD52(CutString(strMD52, 16, 16));
                StringBuilder sb = new StringBuilder();
                sb.append(strMD53);
                sb.append(MD52(strMD53 + ""));
                String string = sb.toString();
                if (discuzAuthcodeMode == DiscuzAuthcodeMode.Decode) {
                    String str3 = new String(RC4(Base64.decode(CutString(str, 0)), string));
                    if (CutString(str3, 10, 16).equals(CutString(MD52(CutString(str3, 26) + strMD54), 0, 16))) {
                        return CutString(str3, 26);
                    }
                    String str4 = new String(RC4(Base64.decode(CutString(str + ContainerUtils.KEY_VALUE_DELIMITER, 0)), string));
                    if (CutString(str4, 10, 16).equals(CutString(MD52(CutString(str4, 26) + strMD54), 0, 16))) {
                        return CutString(str4, 26);
                    }
                    String str5 = new String(RC4(Base64.decode(CutString(str + "==", 0)), string));
                    String strCutString = CutString(str5, 10, 16);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(CutString(str5, 26));
                    sb2.append(strMD54);
                    return strCutString.equals(CutString(MD52(sb2.toString()), 0, 16)) ? CutString(str5, 26) : "2";
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("0000000000");
                sb3.append(CutString(MD52(str + strMD54), 0, 16));
                sb3.append(str);
                return "" + Base64.encode(RC4(sb3.toString().getBytes("GBK"), string));
            } catch (Exception unused) {
            }
        }
        return "";
    }

    private static byte[] RC4(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        byte[] bArrGetKey = GetKey(str.getBytes(), 256);
        int length = 0;
        int length2 = 0;
        for (int i = 0; i < bArr.length; i++) {
            length = (length + 1) % bArrGetKey.length;
            length2 = (length2 + ((bArrGetKey[length] + 256) % 256)) % bArrGetKey.length;
            byte b = bArrGetKey[length];
            bArrGetKey[length] = bArrGetKey[length2];
            bArrGetKey[length2] = b;
            bArr2[i] = (byte) (bArr[i] ^ toInt(bArrGetKey[(toInt(bArrGetKey[length]) + toInt(bArrGetKey[length2])) % bArrGetKey.length]));
        }
        return bArr2;
    }

    public static String MD52(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            for (byte b : MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
        } catch (NoSuchAlgorithmException unused) {
        }
        return stringBuffer.toString();
    }

    public static int toInt(byte b) {
        return (b + 256) % 256;
    }

    public long getUnixTimestamp() {
        return Calendar.getInstance().getTimeInMillis() / 1000;
    }
}
