package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StudenDutyBean {
    private int code;
    private List<List<DataBean>> data;
    private String msg;
    private boolean success;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public List<List<DataBean>> getData() {
        return this.data;
    }

    public void setData(List<List<DataBean>> list) {
        this.data = list;
    }

    public static class DataBean {
        private String classId;
        private String icon;
        private String id;
        private String projectId;
        private String projectName;
        private String schoolId;
        private List<StudentDutyInfoBean> studentDutyInfo;
        private String week;

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String str) {
            this.icon = str;
        }

        public String getSchoolId() {
            return this.schoolId;
        }

        public void setSchoolId(String str) {
            this.schoolId = str;
        }

        public String getClassId() {
            return this.classId;
        }

        public void setClassId(String str) {
            this.classId = str;
        }

        public String getProjectId() {
            return this.projectId;
        }

        public void setProjectId(String str) {
            this.projectId = str;
        }

        public List<StudentDutyInfoBean> getStudentDutyInfo() {
            return this.studentDutyInfo;
        }

        public void setStudentDutyInfo(List<StudentDutyInfoBean> list) {
            this.studentDutyInfo = list;
        }

        public String getProjectName() {
            return this.projectName;
        }

        public void setProjectName(String str) {
            this.projectName = str;
        }

        public String getWeek() {
            return this.week;
        }

        public void setWeek(String str) {
            this.week = str;
        }

        public static class StudentDutyInfoBean {
            public String dutyId;
            private String studentId;
            private String studentName;

            public String getStudentName() {
                return this.studentName;
            }

            public void setStudentName(String str) {
                this.studentName = str;
            }

            public String getStudentId() {
                return this.studentId;
            }

            public void setStudentId(String str) {
                this.studentId = str;
            }
        }
    }
}
