package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TimelistRsp {
    public int code;
    public List<DataBean> data;
    public String msg;

    public static class DataBean {
        public String activityTheme;
        public String activityTime;
        public String classesId;
        public int countDown;
        public String createdBy;
        public String createdDateTime;
        public int current;
        public String delInd;
        public String id;
        public String kind;
        public String schoolId;
        public int size;
        public String templateUrl;
        public int total;
        public Object updatedBy;
        public String updatedDateTime;
        public int versionStamp;
    }
}
