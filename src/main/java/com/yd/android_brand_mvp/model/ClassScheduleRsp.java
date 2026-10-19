package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleRsp {
    public int code;
    public DataBean data;
    public String msg;

    public static class DataBean {
        public int classId;
        public Object className;
        public String createdBy;
        public String createdDateTime;
        public int current;
        public int curriculumId;
        public String delInd;
        public Object displaySectionInd;
        public Object displayTeacherInd;
        public Object fromDateTime;
        public Object gradesId;
        public Object gradesName;
        public int id;
        public int schoolId;
        public String secTimeName;
        public int size;
        public Object status;
        public int statusCount;
        public List<SubListBean> subList;
        public String timetableStructure;
        public String timetableType;
        public Object toDateTime;
        public int total;
        public Object updatedBy;
        public String updatedDateTime;
        public int versionStamp;
        public String weekCount;

        public static class SubListBean {
            public String classesTeacher;
            public String createdBy;
            public String createdDateTime;
            public int current;
            public int curriculumScheduleId;
            public Object curriculumScheduleOtherId;
            public String delInd;
            public Object fromDate;
            public String fromDateTime;
            public int id;
            public Object margeId;
            public String margeInd;
            public Object margeOtherId;
            public Object otherClassesTeacher;
            public Object otherSubjectName;
            public int schoolId;
            public String section;
            public int sectionTimeId;
            public int sectionTimeSubId;
            public int size;
            public String subjectName;
            public int timetableSchedulId;
            public Object timetableScheduleType;
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
