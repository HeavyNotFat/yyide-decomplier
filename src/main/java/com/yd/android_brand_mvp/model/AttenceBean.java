package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceBean {
    public int code;
    public List<DataBean> data;
    public String msg;
    public boolean success;

    public static class DataBean {
        public int absenceA;
        public List<?> absencePeopleA;
        public int applyNumA;
        public String identityType;
        public int lateA;
        public List<?> latePeopleA;
        public int leaveA;
        public int leaveEarlyA;
        public List<?> leaveEarlyPeopleA;
        public List<?> leavePeopleA;
        public int number;
        public int numberA;
        public List<?> peopleA;
        public StudentsBean students;

        public static class StudentsBean {
            public int absence;
            public List<PeopleBean> absencePeople;
            public int applyNum;
            public List<PeopleBean> applyPeople;
            public String attendanceType;
            public String endTime;
            public boolean isExitTeacherInd;
            public int late;
            public List<PeopleBean> latePeople;
            public int leave;
            public int leaveEarly;
            public List<PeopleBean> leaveEarlyPeople;
            public List<PeopleBean> leavePeople;
            public String name;
            public int number;
            public List<PeopleBean> people;
            public String peopleType;
            public String rate;
            public String requiredTime;
            public int section;
            public String startTime;
            public List<?> studentIds;
            public String subjectName;
            public String thingName;

            public static class PeopleBean {
                public String name;
                public String path;
                public int section;
                public int specialCount;
                public String status;
                public String time;
            }
        }
    }
}
