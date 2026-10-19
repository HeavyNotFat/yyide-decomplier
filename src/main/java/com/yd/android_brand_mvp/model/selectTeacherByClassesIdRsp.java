package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class selectTeacherByClassesIdRsp {
    public Integer code;
    public List<DataDTO> data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public String address;
        public String cardNo;
        public String cardNumber;
        public String createdBy;
        public String createdDateTime;
        public Integer current;
        public String delInd;
        public String icCardNo;
        public String id;
        public String name;
        public String position;
        public String remarks;
        public String schoolId;
        public Integer size;
        public Integer total;
        public Object updatedBy;
        public String updatedDateTime;
        public String userId;
        public String userName;
        public Integer versionStamp;
    }
}
