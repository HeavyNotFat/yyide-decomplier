package com.yd.android_brand_mvp.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttencelistRsp2 {
    public int code;
    public DataDTO data;
    public String message;

    public static class DataDTO {
        public List<AttendanceListDTO> attendanceList = new ArrayList();
        public EventTimetableRuleDTO eventTimetableRule;

        public static class AttendanceListDTO {
            public List<?> deviceList;
            public String endDate;
            public String id;
            public int mode;
            public String name;
            public String remarks;
            public String startDate;
            public List<TimeListDTO> timeList;
            public int type;

            public static class TimeListDTO {
                public String attendanceId;
                public String endTime;
                public String id;
                public String requiredTime;
                public String sort;
                public String startTime;
                public int status;
            }
        }

        public static class EventTimetableRuleDTO {
            public String amMinute;
            public String id;
            public boolean isStudent = false;
            public boolean isTeacher;
            public String otherMinute;
            public String pmMinute;
            public String schoolId;
        }
    }
}
