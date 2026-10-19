package com.yd.android_brand_mvp.model;

import com.yd.android_brand_mvp.landscape.attence.AbsenteeismListDTO;
import com.yd.android_brand_mvp.landscape.attence.TeacherInfoBean;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceListBean {
    public int code;
    public DataDTO data;
    public String msg;
    public boolean success;

    public static class DataDTO {
        public List<CourseListDTO> studentCourseList;
        public List<EventListDTO> studentEventList;
        public List<CourseListDTO> teacherCourseList;
        public List<EventListDTO> teacherEventList;

        public static class CourseListDTO {
            public int absenteeism;
            public List<AbsenteeismListDTO> absenteeismList;
            public String courseEndTime;
            public String courseId;
            public String courseName;
            public String courseStartTime;
            public String courseTimeInfo;
            public int early;
            public List<AbsenteeismListDTO> earlyList;
            public int late;
            public List<AbsenteeismListDTO> lateList;
            public int leave;
            public List<AbsenteeismListDTO> leaveList;
            public int normal;
            public List<AbsenteeismListDTO> normalList;
            public String peopleType;
            public String section;
            public String sectionInfo;
            public String signInOutRate;
            public List<TeacherInfoBean> teacherInfo;
            public String theme;
            public String timeFrame;
            public int totalNumber;
        }

        public static class EventListDTO {
            public int absenteeism;
            public List<AbsenteeismListDTO> absenteeismList;
            public String attendanceSignOut;
            public int early;
            public List<AbsenteeismListDTO> earlyList;
            public String eventEndTime;
            public String eventName;
            public String eventStartTime;
            public int late;
            public List<AbsenteeismListDTO> lateList;
            public int leave;
            public List<AbsenteeismListDTO> leaveList;
            public int normal;
            public List<AbsenteeismListDTO> normalList;
            public String peopleType;
            public String requiredTime;
            public String serverId;
            public String signInOutRate;
            public int totalNumber;
        }
    }
}
