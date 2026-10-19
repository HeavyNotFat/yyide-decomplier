package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GetAskLeaveRecordBandRsp {
    public Integer code;
    public DataDTO data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public List<RecordBean> list;
        public String pageNo;
        public String pageSize;
        public String total;
    }

    public static class RecordBean {
        public String createTime;
        public String dept;
        public String endTime;
        public String id;
        public String identity;
        public String jsonData;
        public String name;
        public String procInstId;
        public String schoolId;
        public String startTime;
        public int status;
        public String title;
        public String type;
    }
}
