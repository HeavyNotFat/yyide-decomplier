package com.yd.android_brand_mvp.utils.view.net;

import android.util.Base64;
import cn.finalteam.toolsfinal.coder.RSACoder;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes4.dex */
public class RsaUtil {
    private static final int MAX_DECRYPT_BLOCK = 128;
    private static final int MAX_ENCRYPT_BLOCK = 117;
    private static String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMVHPiXWLxpMjeKcoYlaGGBawma/58yUJrOll0Azt54oRZ/vKrirdekJkrKSQ4dk0lTb0vp54/J61ORQuENFfuHcbvpCcjCAqCC4cUpNw5dPdaBMLNcclcuojzcGXqsdpY7K3C/EHalWN3I1+r2fFy4PTCYZPNt3qGAqRZneEB2zAgMBAAECgYEAg0DCHYRiNFoosFPLucminEDmRFx7yYXsNev/NKz0Bpr+r8j9IH6bZV+EJaDgou02b1UOCq4cNdD5Yao+3isXndyfyc7qq7fLYwgAUHzhpsTggHkiiTeKKFSvZp+PMxb0vKCF8OjDSopO0PaPkNEZWW0PKUqWpgjfRJfg5N2SV6ECQQDrj75bVtHnqtHe6MQiPn6648LNUqjdxZkXVClj03wpvKD669ir3HbfiE4Fu3zyIlqsRdgoY/fXYATbfy/MUC3jAkEA1mUojBtoKjS+llj+hYwht/ikw8GPkjF3ObwC6hi0LJvQU2cEaDl5isvwEulkARtNXRFdGIHZ+4xIgGUsAKtZ8QJAYGr4xpg12LZxquTpiv67jrG1RaeE2SmNLSBUxLiGxOqhlbM9f7MAsSQwk2YXkWCAbq0z+exZQL3bnyBjJyTWcwJAeKGkhejp3E2fKyNZ2rS1SDl8I7UmXkC879xM24EY57yoJDVjsm0caS9Enq95mHHPPt2FP0PY7gPJy4yhjKLdUQJBAOFae/uCuLY7KtgwKd+sCwKbwXJHlyrlHDT/uUrdPwXaRk6v/8Uz1KFYIPSXSmqWC+wHQ8J43oL4g3A5zLA0anU=";
    public static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDFRz4l1i8aTI3inKGJWhhgWsJmv+fMlCazpZdAM7eeKEWf7yq4q3XpCZKykkOHZNJU29L6eePyetTkULhDRX7h3G76QnIwgKgguHFKTcOXT3WgTCzXHJXLqI83Bl6rHaWOytwvxB2pVjdyNfq9nxcuD0wmGTzbd6hgKkWZ3hAdswIDAQAB";

    public static void main(String[] strArr) {
        HashMap map = new HashMap();
        map.put("no", "1234567890");
        map.put("deviceType", "2");
        map.put("schoolId", "1515936924438110209");
        String strEncrypt = encrypt(GsonUtils.toGson(map));
        System.out.println("RSA:" + strEncrypt);
    }

    public static PublicKey getPublicKey() throws Exception {
        return KeyFactory.getInstance(RSACoder.KEY_ALGORITHM).generatePublic(new X509EncodedKeySpec(Base64.decode(publicKey.getBytes(), 0)));
    }

    public static String encrypt(String str) {
        byte[] bArrDoFinal;
        byte[] byteArray = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, getPublicKey());
            int length = str.getBytes().length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = length - i;
                if (i3 <= 0) {
                    break;
                }
                if (i3 > 117) {
                    bArrDoFinal = cipher.doFinal(str.getBytes(), i, 117);
                } else {
                    bArrDoFinal = cipher.doFinal(str.getBytes(), i, i3);
                }
                byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
                i2++;
                i = i2 * 117;
            }
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(Base64.encode(byteArray, 0));
    }
}
