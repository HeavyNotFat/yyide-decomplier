package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StudentCommentBean {
    public int classesId;
    public int commentCount;
    public String createdDateTime;
    public int id;
    public boolean isFine;
    public boolean isLike;
    public int likeCount;
    public int schoolId;
    public int studentId;
    public String studentName;
    public List<WorkCommentVosBean> workCommentVos;
    public Object workDesc;
    public String workName;
    public List<String> worksUrl;

    public static class WorkCommentVosBean {
        public String comment;
        public String createdDateTime;
        public int id;
        public String name;
    }
}
