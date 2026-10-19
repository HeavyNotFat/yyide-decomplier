package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NewRemindRsp {
    public int code;
    public List<DataDTO> data;
    public String message;

    public static class DataDTO {
        public int duration;
        public String id;
        public String musicName;
        public String musicUrl;
        public int number;
        public String remindMode;
        public String remindTime;
        public String remindWeek;
        public String scope;
        public int time;
        public String type;
    }
}
