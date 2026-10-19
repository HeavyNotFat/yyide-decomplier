package com.yd.android_brand_mvp.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceUser {
    public Integer code;
    public DataDTO data;
    public String message;

    public static class DataDTO {
        public String attendanceId;
        public List<StudentListDTO> studentList = new ArrayList();

        public static class StudentListDTO {
            public String icCardNo;
            public String studentId;
            public String studentName;
            public String userId;
            public String userName;
            public String userType;
        }
    }
}
