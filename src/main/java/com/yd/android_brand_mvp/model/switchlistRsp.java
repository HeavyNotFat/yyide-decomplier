package com.yd.android_brand_mvp.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class switchlistRsp {
    public Integer code;
    public DataDTO data;
    public String msg;

    public static class DataDTO {
        public int openType;
        public List<ItemDataDTO> switchList = new ArrayList();

        public static class ItemDataDTO {
            public String closeTime;
            public String day;
            public boolean isthisweek;
            public String nextday;
            public boolean openStatus;
            public String openTime;
            public Integer week;
        }
    }
}
