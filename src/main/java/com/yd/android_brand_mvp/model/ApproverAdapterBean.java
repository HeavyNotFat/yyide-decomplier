package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class ApproverAdapterBean {
    public String approverId;
    public String avatar;
    public String brandName;
    public String id;
    public boolean isBack;
    public boolean isCcTeacher;
    public int listSize;
    public String name;
    public String pid;
    public String sort;
    public String userId;
    public String userType;

    public ApproverAdapterBean(String str, String str2, String str3, String str4, String str5, int i) {
        this.name = str;
        this.avatar = str2;
        this.approverId = str3;
        this.brandName = str4;
        this.userId = str5;
        this.listSize = i;
    }

    public static class RequestParam {
        public String approverName;
        public String avatar;
        public String id;
        public String name;
        public String userId;

        public RequestParam(String str, String str2, String str3) {
            this.id = str;
            this.name = str2;
            this.userId = str3;
        }
    }
}
