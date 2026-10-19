package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StudentTaskBean {
    public int code;
    public DataBean data;
    public String msg;
    public boolean success;

    public static class DataBean {
        public List<WorkBean> list;

        public static class WorkBean {
            public int completed;
            public String content;
            public String createDay;
            public String createPeople;
            public String id;
            public Boolean isScheduled;
            public List<String> lessonsSubEntitys;
            public String publisherName;
            public int read;
            public String releaseTime;
            public String subName;
            public String subjectName;
            public String title;
            public String total;
            public int weekTime;
        }
    }
}
