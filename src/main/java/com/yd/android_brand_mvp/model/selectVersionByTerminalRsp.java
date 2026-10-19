package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class selectVersionByTerminalRsp {
    public Integer code;
    public DataDTO data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public String appName;
        public Object createdBy;
        public String createdDateTime;
        public Integer current;
        public String delInd;
        public String filePath;
        public String id;
        public Integer isCompulsory;
        public Integer size;
        public String terminal;
        public Integer total;
        public Object updatedBy;
        public Object updatedDateTime;
        public String versionCode;
        public String versionDesc;
        public String versionName;
        public Object versionStamp;
    }
}
