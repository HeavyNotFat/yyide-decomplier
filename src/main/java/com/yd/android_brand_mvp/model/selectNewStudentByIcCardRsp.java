package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class selectNewStudentByIcCardRsp {
    public int code;
    public DataBean data = new DataBean();
    public boolean error;
    public String message;
    public boolean success;

    public static class DataBean {
        public String identityId;
        public String userId = "";
        public String userName = "";
        public String name = "";
        public boolean isStudent = true;
        public String icCardNo = "";
        public String schoolId = "";
        public String id = "";
        public String classesId = "";
        public String avatar = "";
        public String className = "";
        public String teacherName = "";
    }
}
