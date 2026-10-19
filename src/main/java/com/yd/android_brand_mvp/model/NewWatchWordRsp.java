package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class NewWatchWordRsp {
    public int code;
    public List<DataDTO> data;
    public String message;

    public static class DataDTO {
        public long classesId;
        public String id;
        public String project;
        public String projectValue;
        public int sort;
    }
}
