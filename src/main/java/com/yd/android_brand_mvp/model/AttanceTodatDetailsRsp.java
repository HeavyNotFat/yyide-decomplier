package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AttanceTodatDetailsRsp {
    public int code;
    public DataDTO data;
    public String message;

    public static class DataDTO {
        public List<String> absenteeismList;
        public List<String> beLateList;
        public List<String> leaveEarlyList;
        public List<String> leaveList;
    }
}
