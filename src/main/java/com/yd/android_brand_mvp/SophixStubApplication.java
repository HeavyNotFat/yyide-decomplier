package com.yd.android_brand_mvp;

import android.content.Context;
import com.taobao.sophix.SophixApplication;
import com.taobao.sophix.SophixEntry;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;

/* JADX INFO: loaded from: classes4.dex */
public class SophixStubApplication extends SophixApplication {
    private final String TAG = "SophixStubApplication";
    private final String hotfixId = "333916551";
    private final String hotfixappKey = "74daf5f78de3456ca7f719d796cd80f9";
    private final String hotfixRSA = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCDvs1USabdM5dzCkVneOGAm30qqMyBtaqLRNMKONdaUrNWn3JDmnpcAekmfoxCIolUgS86uMJXuSmYE\n            VjVnvB2sTAKDv1mwun8z9I+hT/SwZQeWn+GTWjT7SiASr9uA8+I8fBVDaOIFNumoMRVzv+2TJgvA8OdPHsrhOzbHEIQWGwn1vDtKhImPW+r9lvs10nBNX4L5jmlZpy8xMmGNTyqDqAlJK6yY\n            NRik83TxfiNP4TgMCUGwsLxeHsxdcYp+40biLUYaQxRrgGy6CBHdRTejCLvmvLyizgTur1zXua2ua19CyzmgyQZJAVJe8mniSRNGlUtnKEDPTBD+ms7n2ZfAgMBAAECggEAX5AdfJBYO4fay\n            ZWftmiWmiUva6w5e7T82jy4IGgOvfPTJnhN9/+r1eWE62lL8AUBPIzgZ2XxgpRLOYULvRinMFFimUk6QjoMZFeTF8qr+wJzoHjgm9i2u1MB191gcjrNZXapb+iOwHzwvzNKdzvJfMCeeyvtz\n            rY6Wdz3uhALU7LhyMSltMTkjBmcxN+dIX7Lm/UDMABhDINUPsa8MFAE4pX7TID4tFPErFwkgbkcsRjJ7zAo6TP7os7bFyUkHDtcmhfjLtymII/sE87y6KDusJLxkqkP/b7bqHNdcMXFfwaBX\n            QnFmH1tREA9XcKc5a+mDZKDHBKIKudsn7uxsFEPYQKBgQDZDy7Wms/xjv830Umg6r5fjePPoRsYT9Ep7KPkdvPIiZCqI4c1CRSxrSpjnK3x+zIm+dqZ+5HDBz5+C6c7BlMfdXB4erksZVWKB\n            1vgqVO8XokU7sZoEJOMwvOrwe1OiDeElUMeuattNiTJPLg6WxsJd2hzy4YmkwPWEXIXiFX+JwKBgQCbYW3wwxp6c/2qulnUzBLgpKQh/7eZEvTb2D55xUtxKW0++8Pwuymvydw40rzqzbC5w\n            pC8gSduXEVaI4LwlqJRKgoT46mqaOH1Q68bs29Q2FHhyEsZS19C7ubwaX3LuWRQJ6o6mfOL1uTRJ4G6W1KRBZOiNkap13W4+xiOOewxCQKBgBuomqBQA9VVEmJrccVmhDGq4++OKOS1LwL3m\n            36+RZw1I1D6y/zPFmr5lOAyk9u01ZQv3FIow08luinXlEyqJqdokJdZlAT7OKYo/+Ulzny/Uxpuvqt+CT8zjFdDk9ig9OoZFv9wS07USmW2LgeJmm1fYNj4gzShISkC+hXTkpmbAoGBAIycw\n            w1awp+GUE0sjxbQB1VcKVzLOa9BRG2faApyzS7/OmoBFPTJq5P1rWGO9H/Y3NF+jdTJXJG21twXvutSplmlHbGaGXSprbJzKgh7fYU//fnBdJTTbMX5xOxTyw+OGoWfH6IgqBIoyrGseu3Wr\n            wWmclAdph0VaueX9EThjilhAoGBAKkyJxxoFPoK13W90FcCYXWGaKTHutqbWgrENbt3y7KNjNPwq9rmtMarg0s5sX+M5VYxJm1hlXwUbYju17mJQiWnO0trpdyyy+c2qLvf/kjI1ZXrKlrwB\n            V9ekrBlaOoIuzrQWY7PDmvtCAFmP3+xjgWoX9Ppo9UABf+WH9Km30FR";

    @SophixEntry(BaseApplication.class)
    static class RealApplicationStub {
        RealApplicationStub() {
        }
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        initSophix();
    }

    @Override // com.taobao.sophix.SophixApplication, android.app.Application
    public void onCreate() {
        super.onCreate();
        SophixManager.getInstance().queryAndLoadNewPatch();
    }

    private void initSophix() {
        String str;
        try {
            str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception unused) {
            str = "0.0.0";
        }
        SophixManager.getInstance().setContext(this).setUsingEnhance(true).setAppVersion(str).setSecretMetaData("333916551", "74daf5f78de3456ca7f719d796cd80f9", "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCDvs1USabdM5dzCkVneOGAm30qqMyBtaqLRNMKONdaUrNWn3JDmnpcAekmfoxCIolUgS86uMJXuSmYE\n            VjVnvB2sTAKDv1mwun8z9I+hT/SwZQeWn+GTWjT7SiASr9uA8+I8fBVDaOIFNumoMRVzv+2TJgvA8OdPHsrhOzbHEIQWGwn1vDtKhImPW+r9lvs10nBNX4L5jmlZpy8xMmGNTyqDqAlJK6yY\n            NRik83TxfiNP4TgMCUGwsLxeHsxdcYp+40biLUYaQxRrgGy6CBHdRTejCLvmvLyizgTur1zXua2ua19CyzmgyQZJAVJe8mniSRNGlUtnKEDPTBD+ms7n2ZfAgMBAAECggEAX5AdfJBYO4fay\n            ZWftmiWmiUva6w5e7T82jy4IGgOvfPTJnhN9/+r1eWE62lL8AUBPIzgZ2XxgpRLOYULvRinMFFimUk6QjoMZFeTF8qr+wJzoHjgm9i2u1MB191gcjrNZXapb+iOwHzwvzNKdzvJfMCeeyvtz\n            rY6Wdz3uhALU7LhyMSltMTkjBmcxN+dIX7Lm/UDMABhDINUPsa8MFAE4pX7TID4tFPErFwkgbkcsRjJ7zAo6TP7os7bFyUkHDtcmhfjLtymII/sE87y6KDusJLxkqkP/b7bqHNdcMXFfwaBX\n            QnFmH1tREA9XcKc5a+mDZKDHBKIKudsn7uxsFEPYQKBgQDZDy7Wms/xjv830Umg6r5fjePPoRsYT9Ep7KPkdvPIiZCqI4c1CRSxrSpjnK3x+zIm+dqZ+5HDBz5+C6c7BlMfdXB4erksZVWKB\n            1vgqVO8XokU7sZoEJOMwvOrwe1OiDeElUMeuattNiTJPLg6WxsJd2hzy4YmkwPWEXIXiFX+JwKBgQCbYW3wwxp6c/2qulnUzBLgpKQh/7eZEvTb2D55xUtxKW0++8Pwuymvydw40rzqzbC5w\n            pC8gSduXEVaI4LwlqJRKgoT46mqaOH1Q68bs29Q2FHhyEsZS19C7ubwaX3LuWRQJ6o6mfOL1uTRJ4G6W1KRBZOiNkap13W4+xiOOewxCQKBgBuomqBQA9VVEmJrccVmhDGq4++OKOS1LwL3m\n            36+RZw1I1D6y/zPFmr5lOAyk9u01ZQv3FIow08luinXlEyqJqdokJdZlAT7OKYo/+Ulzny/Uxpuvqt+CT8zjFdDk9ig9OoZFv9wS07USmW2LgeJmm1fYNj4gzShISkC+hXTkpmbAoGBAIycw\n            w1awp+GUE0sjxbQB1VcKVzLOa9BRG2faApyzS7/OmoBFPTJq5P1rWGO9H/Y3NF+jdTJXJG21twXvutSplmlHbGaGXSprbJzKgh7fYU//fnBdJTTbMX5xOxTyw+OGoWfH6IgqBIoyrGseu3Wr\n            wWmclAdph0VaueX9EThjilhAoGBAKkyJxxoFPoK13W90FcCYXWGaKTHutqbWgrENbt3y7KNjNPwq9rmtMarg0s5sX+M5VYxJm1hlXwUbYju17mJQiWnO0trpdyyy+c2qLvf/kjI1ZXrKlrwB\n            V9ekrBlaOoIuzrQWY7PDmvtCAFmP3+xjgWoX9Ppo9UABf+WH9Km30FR").setEnableDebug(true).setEnableFullLog().setPatchLoadStatusStub(new PatchLoadStatusListener() { // from class: com.yd.android_brand_mvp.SophixStubApplication.1
            @Override // com.taobao.sophix.listener.PatchLoadStatusListener
            public void onLoad(int i, int i2, String str2, int i3) {
                if (i2 == 1 || i2 == 12 || i2 != 13) {
                    return;
                }
                SophixManager.getInstance().cleanPatches();
            }
        }).initialize();
    }
}
