package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class getSchoolCalendarRsp2 {
    public Integer code;
    public DataDTO data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public SchoolCalendarEventListDTO schoolCalendarEventList;
        public SemesterDTO semester;

        public static class SchoolCalendarEventListDTO {
            public List<MonthListDTO> monthList;

            public static class MonthListDTO {
                public String createdBy;
                public String createdDateTime;
                public Integer current;
                public Object currentMonth;
                public String delInd;
                public String endTime;
                public String id;
                public String promoter;
                public String remark;
                public List<?> remarkList;
                public String schoolId;
                public String semesterId;
                public Integer size;
                public String startTime;
                public Integer total;
                public Object updatedBy;
                public Object updatedDateTime;
                public Integer versionStamp;
            }
        }

        public static class SemesterDTO {
            public String createdBy;
            public String createdDateTime;
            public Integer current;
            public String delInd;
            public String endDate;
            public String id;
            public Integer isEnable;
            public String name;
            public String schoolId;
            public String schoolYear;
            public String schoolYearId;
            public Integer size;
            public String startDate;
            public Integer total;
            public String updatedBy;
            public String updatedDateTime;
            public Integer versionStamp;
        }
    }
}
