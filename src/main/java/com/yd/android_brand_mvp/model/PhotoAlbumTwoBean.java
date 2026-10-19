package com.yd.android_brand_mvp.model;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumTwoBean {
    public int code;
    public List<DataBean> data;
    public String msg;

    public static class DataBean {
        public List<Bean> albumDTOList;
        public long id;
        public Boolean isShow;
        public String name;
        public String sort;

        public static class Bean {
            public long id;
            public String name;
            public String url;
        }
    }
}
