package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GetUserSchoolRsp {
    public int code;
    public List<DataBean> data;
    public String message;

    public static class DataBean {
        public Object birthdayDate;
        public Object dataPerDepIds;
        public Object dataPerInd;
        public Object depId;
        public Object depIds;
        public Object depName;
        public Object email;
        public List<String> imgList;
        public String introduce;
        public String name;
        public int parentId;
        public String password;
        public String realname;
        public List<ScheduleBean> schedule;
        public int schoolId;
        public Object schoolType;
        public Object sex;
        public String status;
        public int teacherId;
        public int userId;
        public String username;

        public static class ScheduleBean {
            public Object classIds;
            public String classesId;
            public String classesName;
            public String classesTeacher;
            public String createdBy;
            public String createdDateTime;
            public int current;
            public String curriculumType;
            public String delInd;
            public int id;
            public int schoolId;
            public int size;
            public Object status;
            public String studentAttInd;
            public String subjectName;
            public String teacherAttInd;
            public int teacherId;
            public int total;
            public String updatedBy;
            public String updatedDateTime;
            public int versionStamp;
        }
    }
}
