package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class UserTableRsp {
    public Integer code;
    public DataDTO data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public List<String> afternoonList;
        public String classId;
        public String className;
        public String createdBy;
        public String createdDateTime;
        public int current;
        public String delInd;
        public List<String> eveningStudyList;
        public String fromDateTime;
        public String gradesId;
        public String id;
        public List<String> morningList;
        public String schoolId;
        public String secTimeName;
        public int size;
        public String status;
        public int statusCount;
        public List<SubListDTO> subList;
        public String timetableType;
        public String toDateTime;
        public int total;
        public Object updatedBy;
        public String updatedDateTime;
        public int versionStamp;
        public String weekCount;

        public static class SubListDTO {
            public String classesTeacher;
            public String classesTeacherIcCardNo;
            public String classesTeacherId;
            public String createdBy;
            public String createdDateTime;
            public int current;
            public String delInd;
            public String fromDateTime;
            public String icCardNo;
            public String id;
            public String otherClassesTeacher;
            public String otherClassesTeacherIcCardNo;
            public String otherClassesTeacherId;
            public String otherSubjectName;
            public String peopleId;
            public Object schoolId;
            public String section;
            public String sectionName;
            public int size;
            public String subjectName;
            public String timeFrame;
            public Object toDate;
            public String toDateTime;
            public int total;
            public String updatedBy;
            public String updatedDateTime;
            public int versionStamp;
            public int weekCount;
            public int weekTime;
        }
    }
}
