package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StudentInfoBean {
    public int code;
    public DataBean data;
    public String message;
    public boolean success;

    public static class DataBean {
        public int classesId;
        public int commentCount;
        public String createdDateTime;
        public int id;
        public boolean isFine;
        public boolean isLike;
        public int likeCount;
        public int schoolId;
        public String studentId;
        public Object studentName;
        public List<StudentWorkListBean.DataBean.RecordsBean.WorkCommentVosBean> workCommentVos;
        public Object workDesc;
        public String workName;
        public List<String> worksUrl;
    }
}
