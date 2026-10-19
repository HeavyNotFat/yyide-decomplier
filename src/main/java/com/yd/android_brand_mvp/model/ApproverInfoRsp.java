package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ApproverInfoRsp {
    public int code;
    public DataDTO data;
    public String message;

    public static class DataDTO {
        public ApprJsonDTO apprJson;
        public List<CcListDTO> ccList;
        public String createTime;
        public String dept;
        public List<HiApprNodeListDTO> hiApprNodeList;
        public String id;
        public int identity;
        public boolean isBack;
        public boolean isWithdraw;
        public String name;
        public String procInstId;
        public int status;
        public String taskId;
        public String title;

        public static class ApprJsonDTO {
            public String dept;
            public String endTime;
            public double hours;
            public String reason;
            public String startTime;
            public String student;
            public String studentId;
        }

        public static class CcListDTO {
            public String avatar;
            public String name;
            public String userId;
            public List<String> userInfo;
        }

        public static class HiApprNodeListDTO {
            public String apprTime;
            public String avatar;
            public String comment;
            public String id;
            public boolean isCc;
            public List<CcListDTO> isCcList;
            public String nodeName;
            public String status;
            public String userId;
            public String userName;
        }
    }
}
