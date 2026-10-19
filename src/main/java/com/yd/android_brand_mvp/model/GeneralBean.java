package com.yd.android_brand_mvp.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GeneralBean {
    public int code;
    public List<DataBean> data = new ArrayList();
    public String message;
    public boolean success;

    public static class DataBean {
        public String attendanceId;
        public String attendanceName;
        public String attendanceTimeId;
        public String attendanceType;
        public String createdBy;
        public String createdDateTime;
        public String deviceName;
        public String message;

        /* JADX INFO: renamed from: no, reason: collision with root package name */
        public String f2015no;
        public String path;
        public String peopleId;
        public String peopleName;
        public String schoolId;
        public String type;
    }
}
