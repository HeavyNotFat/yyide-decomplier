package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class FaceStudentRsp {
    public Integer code;
    public List<DataDTO> data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public Integer classId;
        public String createdBy;
        public String createdDateTime;
        public Integer current;
        public String delInd;
        public Integer id;
        public String name;
        public String path;
        public Integer peopleId;
        public long schoolId;
        public Integer size;
        public Integer total;
        public String updatedDateTime;
        public Integer versionStamp;
    }
}
