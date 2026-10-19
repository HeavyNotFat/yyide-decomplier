package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceNewListBean {
    public int code;
    public List<DataDTO> data;
    public String message;

    public static class DataDTO {
        public int absenteeismNum;
        public String attendanceId;
        public String attendanceTimeId;
        public int beLateNum;
        public String endDate;
        public int leaveEarlyNum;
        public int leaveNum;
        public String name;
        public int normalNum;
        public String startDate;
        public int total;
        public int type;
    }
}
