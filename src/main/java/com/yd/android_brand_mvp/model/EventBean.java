package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class EventBean {
    public static final int BLOCK_DATA = 10003;
    public static final int CARD_EVENT = 10000;
    public static final int FACE_EVENT = 10001;
    public static final int LEAVE_SUCCESS_EVENT = 10002;
    public static final int LIBRARY_UPDATE_CODE = 10006;
    public static final int MORALEDUCATION_UPDATE_CODE = 10005;
    public static final int REOPEN = 10004;
    public int Event;
    public String id;
    public String identityId;
    public boolean isStudent;
    public String name;
    public String productionId;
    public int type;

    public EventBean(int i, String str, String str2) {
        this.identityId = "";
        this.id = str;
        this.name = str2;
        this.Event = i;
    }

    public EventBean(int i, String str, String str2, int i2, String str3, boolean z) {
        this.identityId = "";
        this.id = str;
        this.name = str2;
        this.Event = i;
        this.type = i2;
        this.productionId = str3;
        this.isStudent = z;
    }

    public EventBean(int i, String str, String str2, int i2, String str3, boolean z, String str4) {
        this.identityId = "";
        this.id = str;
        this.name = str2;
        this.Event = i;
        this.type = i2;
        this.productionId = str3;
        this.isStudent = z;
        this.identityId = str4;
    }
}
