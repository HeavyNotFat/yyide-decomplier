package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class manageListRsp {
    public Integer code;
    public List<DataDTO> data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public String createdBy;
        public Object createdDateTime;
        public Integer current;
        public String delInd;
        public Object icon;
        public Integer id;
        public String name;
        public Integer size;
        public Integer total;
        public Object updatedBy;
        public Object updatedDateTime;
        public Integer versionStamp;
    }
}
