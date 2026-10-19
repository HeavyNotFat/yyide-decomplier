package com.yd.android_brand_mvp.utils;

import android.util.Base64;
import com.yyide.facepass.AppExtKt;
import java.nio.charset.Charset;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: DesCipherUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001b\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0007¢\u0006\u0002\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/yd/android_brand_mvp/utils/DesCipherUtils;", "", "()V", "PASSWORD_ENC_SECRET", "", "decryptPassword", "encryptedPwd", "encryptPassword", "clearText", "main", "", "args", "", "([Ljava/lang/String;)V", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DesCipherUtils {
    public static final DesCipherUtils INSTANCE = new DesCipherUtils();
    public static final String PASSWORD_ENC_SECRET = "yide_des_cipher";

    private DesCipherUtils() {
    }

    @JvmStatic
    public static final void main(String[] args) {
        Intrinsics.checkNotNullParameter(args, "args");
        String strEncryptPassword = INSTANCE.encryptPassword("yide:1234");
        AppExtKt.logd(INSTANCE, "加密：" + strEncryptPassword);
        String strDecryptPassword = INSTANCE.decryptPassword("yide:1234");
        AppExtKt.logd(INSTANCE, "解密：" + strDecryptPassword);
    }

    public final String encryptPassword(String clearText) {
        Intrinsics.checkNotNullParameter(clearText, "clearText");
        try {
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
            byte[] bytes = PASSWORD_ENC_SECRET.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bytes));
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(1, secretKeyGenerateSecret);
            Charset charsetForName2 = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName2, "forName(charsetName)");
            byte[] bytes2 = clearText.getBytes(charsetForName2);
            Intrinsics.checkNotNullExpressionValue(bytes2, "this as java.lang.String).getBytes(charset)");
            return Base64.encodeToString(cipher.doFinal(bytes2), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return clearText;
        }
    }

    public final String decryptPassword(String encryptedPwd) {
        Intrinsics.checkNotNullParameter(encryptedPwd, "encryptedPwd");
        try {
            Charset charsetForName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(charsetName)");
            byte[] bytes = PASSWORD_ENC_SECRET.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bytes));
            byte[] bArrDecode = Base64.decode(encryptedPwd, 2);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(2, secretKeyGenerateSecret);
            byte[] plainTextPwdBytes = cipher.doFinal(bArrDecode);
            Intrinsics.checkNotNullExpressionValue(plainTextPwdBytes, "plainTextPwdBytes");
            return new String(plainTextPwdBytes, Charsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return encryptedPwd;
        }
    }
}
