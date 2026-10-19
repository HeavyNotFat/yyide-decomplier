package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class getRegistrationCodeByNumberRsp {
    public Integer code;
    public DataDTO data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public Object classId;
        public String createdBy;
        public String createdDateTime;
        public Integer current;
        public String delInd;
        public Object equipmentSerialNumber;
        public String id;
        public Integer num;
        public String officeId;
        public String officeName;
        public String registrationCode;
        public Object registrationCodeEntityList;
        public String registrationCodeId;
        public String remarks;
        public Integer size;
        public String status;
        public Integer total;
        public String updatedBy;
        public String updatedDateTime;
        public Integer versionStamp;
    }
}
