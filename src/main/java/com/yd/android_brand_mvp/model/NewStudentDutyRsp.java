package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NewStudentDutyRsp {
    public int code;
    public List<List<DataDTO>> data;
    public boolean success;

    public static class DataDTO {
        public String icon;
        public String id;
        public String projectId;
        public String projectName;
        public String schoolId;
        public List<StudentDutyInfoDTO> studentDutyInfo;
        public String week;

        public static class StudentDutyInfoDTO {
            public String studentId;
            public String studentName;
        }
    }
}
