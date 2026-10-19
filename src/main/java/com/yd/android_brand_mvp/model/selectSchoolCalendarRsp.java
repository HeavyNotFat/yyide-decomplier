package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class selectSchoolCalendarRsp {
    public Integer code;
    public List<DataDTO> data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public String endTime;
        public String remark;
        public String schoolId;
        public String semesterId;
        public String startTime;
    }
}
