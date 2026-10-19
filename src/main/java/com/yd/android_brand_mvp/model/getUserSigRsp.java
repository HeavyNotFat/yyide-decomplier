package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class getUserSigRsp {
    private int code;
    private DataBean data;
    private String message;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public DataBean getData() {
        return this.data;
    }

    public void setData(DataBean dataBean) {
        this.data = dataBean;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public static class DataBean {
        private String contentType;
        private String identifier;
        private String random;
        private String sdkAppId;
        private String userSig;

        public String getContentType() {
            return this.contentType;
        }

        public void setContentType(String str) {
            this.contentType = str;
        }

        public String getIdentifier() {
            return this.identifier;
        }

        public void setIdentifier(String str) {
            this.identifier = str;
        }

        public String getRandom() {
            return this.random;
        }

        public void setRandom(String str) {
            this.random = str;
        }

        public String getSdkAppId() {
            return this.sdkAppId;
        }

        public void setSdkAppId(String str) {
            this.sdkAppId = str;
        }

        public String getUserSig() {
            return this.userSig;
        }

        public void setUserSig(String str) {
            this.userSig = str;
        }
    }
}
