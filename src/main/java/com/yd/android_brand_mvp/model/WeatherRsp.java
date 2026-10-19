package com.yd.android_brand_mvp.model;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherRsp {
    public int code;
    public DataBean data = new DataBean();
    public String msg;

    public static class DataBean {
        public String city;
        public int code;
        public List<WeatherBean> forecast = new ArrayList();
        public String msg;
        public String wendu;

        public static class WeatherBean {
            public String date;
            public String fengli;
            public String fengxiang;
            public String high;
            public String low;
            public String realwendu;
            public String type;
        }
    }
}
