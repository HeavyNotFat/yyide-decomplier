package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class getNewestVersionRsp {
    public int code;
    public DataDTO data;
    public String message;
    public boolean success;

    public static class DataDTO {
        public String filePath;
        public String isCompulsory;
        public String versionCode;
    }
}
