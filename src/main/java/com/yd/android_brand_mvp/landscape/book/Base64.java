package com.yd.android_brand_mvp.landscape.book;

import com.google.android.exoplayer2.C;
import com.huawei.hms.framework.common.ContainerUtils;
import com.seewo.sdk.model.SDKKeyboardCode;
import java.io.UnsupportedEncodingException;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes4.dex */
public class Base64 {
    private static char[] base64EncodeChars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', Matrix.MATRIX_TYPE_RANDOM_LT, 'M', 'N', 'O', 'P', 'Q', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'S', 'T', Matrix.MATRIX_TYPE_RANDOM_UT, 'V', 'W', 'X', 'Y', Matrix.MATRIX_TYPE_ZERO, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static byte[] base64DecodeChars = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, SDKKeyboardCode.FUNCTION_KEY_BOARD_LEFT_SLASH, SDKKeyboardCode.FUNCTION_KEY_BOARD_CAPS_LOCK, SDKKeyboardCode.FUNCTION_KEY_BOARD_F1, SDKKeyboardCode.FUNCTION_KEY_BOARD_F2, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, SDKKeyboardCode.FUNCTION_KEY_BOARD_MINUS, SDKKeyboardCode.FUNCTION_KEY_BOARD_PLUS, SDKKeyboardCode.FUNCTION_KEY_BOARD_LEFT_SQUARE_BRACKET, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String encode(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                stringBuffer.append(base64EncodeChars[i3 >>> 2]);
                stringBuffer.append(base64EncodeChars[(i3 & 3) << 4]);
                stringBuffer.append("==");
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            if (i4 == length) {
                stringBuffer.append(base64EncodeChars[i3 >>> 2]);
                stringBuffer.append(base64EncodeChars[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                stringBuffer.append(base64EncodeChars[(i5 & 15) << 2]);
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                break;
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4] & 255;
            stringBuffer.append(base64EncodeChars[i3 >>> 2]);
            stringBuffer.append(base64EncodeChars[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
            stringBuffer.append(base64EncodeChars[((i5 & 15) << 2) | ((i7 & 192) >>> 6)]);
            stringBuffer.append(base64EncodeChars[i7 & 63]);
            i = i6;
        }
        return stringBuffer.toString();
    }

    public static byte[] decode(String str) throws UnsupportedEncodingException {
        int i;
        byte b;
        int i2;
        byte b2;
        int i3;
        byte b3;
        int i4;
        byte b4;
        int length = str.length() % 4;
        if (length == 2) {
            str = str + "==";
        } else if (length == 3) {
            str = str + ContainerUtils.KEY_VALUE_DELIMITER;
        }
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bytes = str.getBytes(C.ASCII_NAME);
        int length2 = bytes.length;
        int i5 = 0;
        while (i5 < length2) {
            while (true) {
                i = i5 + 1;
                b = base64DecodeChars[bytes[i5]];
                if (i >= length2 || b != -1) {
                    break;
                }
                i5 = i;
            }
            if (b == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b2 = base64DecodeChars[bytes[i]];
                if (i2 >= length2 || b2 != -1) {
                    break;
                }
                i = i2;
            }
            if (b2 == -1) {
                break;
            }
            stringBuffer.append((char) ((b << 2) | ((b2 & 48) >>> 4)));
            while (true) {
                i3 = i2 + 1;
                byte b5 = bytes[i2];
                if (b5 == 61) {
                    return stringBuffer.toString().getBytes("iso8859-1");
                }
                b3 = base64DecodeChars[b5];
                if (i3 >= length2 || b3 != -1) {
                    break;
                }
                i2 = i3;
            }
            if (b3 == -1) {
                break;
            }
            stringBuffer.append((char) (((b2 & 15) << 4) | ((b3 & 60) >>> 2)));
            while (true) {
                i4 = i3 + 1;
                byte b6 = bytes[i3];
                if (b6 == 61) {
                    return stringBuffer.toString().getBytes("iso8859-1");
                }
                b4 = base64DecodeChars[b6];
                if (i4 >= length2 || b4 != -1) {
                    break;
                }
                i3 = i4;
            }
            if (b4 == -1) {
                break;
            }
            stringBuffer.append((char) (b4 | ((b3 & 3) << 6)));
            i5 = i4;
        }
        return stringBuffer.toString().getBytes("iso8859-1");
    }
}
