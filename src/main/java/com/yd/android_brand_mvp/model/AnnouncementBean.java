package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AnnouncementBean {
    public int code;
    public List<DataBean> data;
    public String msg;
    public boolean success;

    public static class DataBean {
        public String content;
        public Object createdBy;
        public String createdDateTime;
        public int current;
        public String delInd;
        public String id;
        public String productionTarget;
        public String productionTime;
        public Object readNumber;
        public Object sendObject;
        public String signId;
        public int size;
        public String status;
        public Object timingTime;
        public String title;
        public int total;
        public Object totalNumber;
        public String type;
        public Object updatedBy;
        public String updatedDateTime;
        public int versionStamp;
    }
}
