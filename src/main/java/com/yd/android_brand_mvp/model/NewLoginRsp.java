package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class NewLoginRsp {
    public int code;
    public dataBean data;
    public String message;

    public class dataBean {
        public String accessToken;
        public String expiresIn;
        public String refreshToken;
        public String tokenHead;

        public dataBean() {
        }
    }
}
