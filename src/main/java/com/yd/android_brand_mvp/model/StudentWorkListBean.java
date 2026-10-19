package com.yd.android_brand_mvp.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StudentWorkListBean implements Serializable {
    public int code;
    public DataBean data;
    public String msg;
    public boolean success;

    public static class DataBean implements Serializable {
        public List<RecordsBean> list;
        public int pageNo;
        public int pageSize;
        public int total;

        public static class RecordsBean implements Serializable {
            public String avatar;
            public String classesId;
            public int commentCount;
            public String createdDateTime;
            public String id;
            public boolean isFine;
            public boolean isLike;
            public int likeCount;
            public String schoolId;
            public String studentId;
            public String studentName;
            public String userImg;
            public List<WorkCommentVosBean> workCommentVos;
            public String workDesc;
            public String workName;
            public List<String> worksUrl;

            public static class WorkCommentVosBean implements Serializable {
                public String comment;
                public String createTime;
                public String id;
                public String name;
                public String userImg;
            }
        }
    }
}
