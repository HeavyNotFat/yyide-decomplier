package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttencelistRsp {
    public Integer code;
    public DataDTO data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public List<AttendanceListDTO> attendanceList;
        public List<CourseListDTO> courseList;

        public static class AttendanceListDTO {
            public Object createdBy;
            public String createdDateTime;
            public Integer current;
            public String delInd;
            public String endDate;
            public String frequency;
            public long id;
            public String identityType;
            public String name;
            public String number;
            public List<PeoplesDTO> peopleList;
            public String remarks;
            public Object schoolId;
            public Integer section;
            public Integer size;
            public String startDate;
            public String subjectName;
            public List<TimesDTO> times;
            public Integer total;
            public String type;
            public Object updatedBy;
            public String updatedDateTime;
            public Integer versionStamp;
            public List<WeeksDTO> weeks;

            public static class PeoplesDTO {
                public String attendanceId;
                public String classesId;
                public String createdBy;
                public String createdDateTime;
                public Integer current;
                public String delInd;
                public String icCardNo;
                public long id;
                public long peopleId;
                public String peopleName;
                public long schoolId;
                public Integer size;
                public Integer total;
                public String type;
                public Object updatedBy;
                public String updatedDateTime;
                public Integer versionStamp;
            }

            public static class TimesDTO {
                public String attendanceId;
                public String createdBy;
                public String createdDateTime;
                public Integer current;
                public String delInd;
                public String endTime;
                public long id;
                public String requiredTime;
                public Integer size;
                public String startTime;
                public String status;
                public Integer total;
                public Object updatedBy;
                public String updatedDateTime;
                public Integer versionStamp;
            }

            public static class WeeksDTO {
                public String attendanceId;
                public String createdBy;
                public String createdDateTime;
                public Integer current;
                public String delInd;
                public long id;
                public Integer size;
                public Integer total;
                public Object updatedBy;
                public String updatedDateTime;
                public Integer versionStamp;
                public String week;
            }
        }

        public static class CourseListDTO {
            public String afterTime;
            public String beforeTime;
            public String createdBy;
            public String createdDateTime;
            public Integer current;
            public String delInd;
            public int firstBeforeTime;
            public long id;
            public long schoolId;
            public int secendBeforeTime;
            public Integer size;
            public Integer total;
            public String type;
            public Object updatedBy;
            public String updatedDateTime;
            public Integer versionStamp;
        }
    }
}
