package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AllstudentRsp {
    public Integer code;
    public List<DataDTO> data;
    public String message;

    public static class DataDTO {
        public Integer accommodation;
        public String avatar;
        public Integer bloodType;
        public String classesId;
        public Integer gender;
        public Integer healthStatus;
        public Integer householdType;
        public String icCardNo;
        public long id;
        public String idCard;
        public Integer idType;
        public Integer isChild;
        public Integer isFlow;
        public String name;
        public Integer nation;
        public String nativePlace;
        public Integer politicalStatus;
        public String schoolId;
        public Integer status;
        public String studentCode;
        public String studentNo;
        public String userId;
    }
}
