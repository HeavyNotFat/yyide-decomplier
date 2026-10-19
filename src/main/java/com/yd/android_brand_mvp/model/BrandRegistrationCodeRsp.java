package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class BrandRegistrationCodeRsp {
    public int code;
    public BrandCodeBean data;
    public String message;

    public class BrandCodeBean {
        public String authorizeCode;
        public String authorizeCodeId;

        public BrandCodeBean() {
        }
    }
}
