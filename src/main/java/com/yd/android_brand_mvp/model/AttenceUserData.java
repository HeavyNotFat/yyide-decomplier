package com.yd.android_brand_mvp.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceUserData {
    public List<StudentListDTO> studentList = new ArrayList();

    public class StudentListDTO {
        public String icCardNo = "";
        public String studentId;
        public String studentName;

        public StudentListDTO() {
        }
    }
}
