package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class selectClassesInfoRsp {
    public int code;
    public DataBean data;
    public String msg;

    public static class DataBean {
        public String classAlias;
        public String classIcon;
        public String classId;
        public String classesName;
        public String headTeacher;
        public int peopleNum;
        public List<WatchwordsBean> watchwords;

        public static class WatchwordsBean {
            public String classesId;
            public String createdBy;
            public String createdDateTime;
            public int current;
            public String delInd;
            public String fixedFlag;
            public String id;
            public String project;
            public String projectValue;
            public String schoolId;
            public int size;
            public int total;
            public String updatedBy;
            public String updatedDateTime;
            public int versionStamp;
        }
    }
}
