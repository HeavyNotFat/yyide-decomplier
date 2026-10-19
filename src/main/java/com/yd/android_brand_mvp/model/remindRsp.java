package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class remindRsp {
    public Integer code;
    public List<DataDTO> data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public String createdBy;
        public String createdDateTime;
        public int current;
        public Object delInd;
        public int duration;
        public String id;
        public Object musicName;
        public String musicUrl;
        public Object name;
        public int number = 0;
        public List<RemindDetailListDTO> remindDetailList;
        public String remindMode;
        public String remindTime;
        public String remindWeek;
        public Object schoolId;
        public String scope;
        public String sentence;
        public Object siteList;
        public int size;
        public int time;
        public int total;
        public String type;
        public Object updatedBy;
        public Object updatedDateTime;
        public Object versionStamp;

        public static class RemindDetailListDTO {
            public Object createdBy;
            public Object createdDateTime;
            public Integer current;
            public Object delInd;
            public Object id;
            public Object remindId;
            public String siteId;
            public Integer size;
            public Integer total;
            public Object updatedBy;
            public Object updatedDateTime;
            public Object versionStamp;
        }
    }
}
