package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class studentListRsp {
    public Integer code;
    public List<DataDTO> data;
    public String msg;
    public Boolean success;

    public static class DataDTO {
        public String faceInformation;
        public String icCardNo;
        public long id;
        public String name;
        public long userId;
    }
}
