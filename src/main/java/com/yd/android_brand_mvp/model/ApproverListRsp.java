package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ApproverListRsp {
    public int code;
    public DataDTO data;
    public String message;

    public static class DataDTO {
        public List<ApproverDTO> approver;
        public List<CcListDTO> ccList;
        public float hours;
        public boolean isBack;
        public String procId;
        public String sponsorType;

        public static class ApproverDTO {
            public int apprType;
            public List<BranapprListDTO> branapprList;
            public String id;
            public boolean isBack;
            public boolean isCcTeacher;
            public String name;
            public String pid;
            public int sort;
            public int userType;

            public static class BranapprListDTO {
                public String approverId;
                public String avatar;
                public String id;
                public boolean isChecked;
                public String name;
                public String userId;
                public List<String> userInfo;
            }
        }

        public static class CcListDTO {
            public String avatar;
            public String id;
            public boolean isChecked;
            public String name;
            public String userId;
            public List<String> userInfo;
        }
    }
}
