package com.yd.android_brand_mvp.landscape.book;

import com.yd.android_brand_mvp.landscape.book.network.GetData;
import java.net.URLDecoder;

/* JADX INFO: loaded from: classes4.dex */
public class DecryptUtils {
    public static void main(String[] strArr) {
        String strDecrypt = decrypt("wFV3jn6%2FlLI17OBrfXGHrhoDSTBm7bgkHQvgpOvDRyDId0mkFgBBiu9ixnxEbWw%2FbKRQE6pitKQaizV2sBFb1CX58Qs%3D");
        System.out.println("解密：" + strDecrypt);
    }

    public static final String decrypt(String str) {
        try {
            return URLDecoder.decode(AuthcodeTwo.authcodeDecode(str, GetData.URL_KEY), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static final String decryptIp(String str) {
        try {
            return AuthcodeTwo.authcodeDecode(str, GetData.URL_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
