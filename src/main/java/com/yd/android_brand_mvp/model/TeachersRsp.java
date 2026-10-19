package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TeachersRsp {
    public Integer code;
    public DataDTO data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public Object countId;
        public Integer current;
        public Boolean hitCount;
        public List<RecordsDTO> list;
        public Object maxLimit;
        public Boolean optimizeCountSql;
        public List<?> orders;
        public Integer pageSize;
        public Integer pages;
        public Boolean searchCount;
        public Integer size;
        public Integer total;

        public static class RecordsDTO {
            public String avatar;
            public String jobTitle = "";
            public String name;
        }
    }
}
