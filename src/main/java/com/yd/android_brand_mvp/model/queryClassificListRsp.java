package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class queryClassificListRsp {
    public Integer code;
    public DataDTO data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public Integer code;
        public List<DataDTO2> data;
        public String message;

        public static class DataDTO2 {
            public String brandApplicationId;
            public String createdBy;
            public String createdDateTime;
            public Integer current;
            public String delInd;
            public long id;
            public Integer size;
            public Integer total;
            public String updatedBy;
            public String updatedDateTime;
            public String versionName;
            public Object versionNames;
            public Integer versionStamp;
        }
    }
}
