package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ClassPhotoListRsp {
    public int code;
    public List<DataBean> data;
    public String msg;

    public static class DataBean {
        public int classifyId;
        public String name;
        public String type;
        public String url;
    }
}
