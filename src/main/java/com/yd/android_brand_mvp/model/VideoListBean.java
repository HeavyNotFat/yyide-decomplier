package com.yd.android_brand_mvp.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class VideoListBean {
    public int code;
    public List<DataBean> data;
    public String msg;

    public static class DataBean implements Serializable {
        public String type;
        public String url;
    }
}
