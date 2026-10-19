package com.yd.android_brand_mvp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class KBRsp2 implements Serializable {
    public Integer code;
    public DataDTO data;
    public String message;

    public static class DataDTO implements Serializable {
        public SectionListDTO sectionList;
        public String siteClassesName;
        public Integer thisWeek;
        public List<TimetableListDTO> timetableList;
        public WeekListDTO weekList;
        public Integer weekTotal;

        public static class SectionListDTO implements Serializable {
            public List<ZX> afternoonList;
            public List<ZX> earlySelfStudyList;
            public List<ZX> lateSelfStudyList;
            public List<ZX> morningList;
            public List<ZX> nightList;

            public static class ZX implements Serializable {
                public String endTime;
                public String id;
                public String name;
                public Integer periodType;
                public Integer sequence;
                public String startTime;
            }
        }

        public static class WeekListDTO implements Serializable {
            public String friday;
            public String monday;
            public String saturday;
            public String sunday;
            public String thursday;
            public String tuesday;
            public String wednesday;

            public static class WeekBean implements Serializable {
                public String time;
                public String week;
            }

            public List<KBRsp.DataDTO.WeekTimeBean.WeekBean> getList() {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < 7; i++) {
                    KBRsp.DataDTO.WeekTimeBean.WeekBean weekBean = new KBRsp.DataDTO.WeekTimeBean.WeekBean();
                    switch (i) {
                        case 0:
                            weekBean.week = "星期一";
                            weekBean.time = this.monday;
                            break;
                        case 1:
                            weekBean.week = "星期二";
                            weekBean.time = this.tuesday;
                            break;
                        case 2:
                            weekBean.week = "星期三";
                            weekBean.time = this.wednesday;
                            break;
                        case 3:
                            weekBean.week = "星期四";
                            weekBean.time = this.thursday;
                            break;
                        case 4:
                            weekBean.week = "星期五";
                            weekBean.time = this.friday;
                            break;
                        case 5:
                            weekBean.week = "星期六";
                            weekBean.time = this.saturday;
                            break;
                        case 6:
                            weekBean.week = "星期日";
                            weekBean.time = this.sunday;
                            break;
                    }
                    arrayList.add(weekBean);
                }
                return arrayList;
            }
        }

        public static class TimetableListDTO implements Serializable {
            public String courseType;
            public String date;
            public String endTime;
            public String id;
            public boolean isStudent;
            public int section;
            public String sectionName;
            public String sectionType;
            public int sectionTypeNum;
            public String startTime;
            public String subjectName;
            public List<TeacherListDTO> teacherList = new ArrayList();
            public int week;

            public static class TeacherListDTO implements Serializable {
                public String cardNumber;
                public String id;
                public String name;
            }

            public String toString() {
                return "TimetableListDTO{date='" + this.date + "', endTime='" + this.endTime + "', id='" + this.id + "', isStudent=" + this.isStudent + ", section=" + this.section + ", startTime='" + this.startTime + "', subjectName='" + this.subjectName + "', sectionName='" + this.sectionName + "', sectionType='" + this.sectionType + "', sectionTypeNum=" + this.sectionTypeNum + ", week=" + this.week + ", teacherList=" + this.teacherList + '}';
            }
        }
    }
}
