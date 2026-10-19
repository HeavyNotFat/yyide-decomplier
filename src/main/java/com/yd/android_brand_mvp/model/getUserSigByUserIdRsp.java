package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class getUserSigByUserIdRsp {
    public Integer code;
    public DataBean data;
    public String msg;
    public Boolean success;

    public class DataBean {
        public String contentType;
        public String identifier;
        public String random;
        public String sdkAppId;
        public String userSig;

        public DataBean() {
        }
    }
}
