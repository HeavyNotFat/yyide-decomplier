package com.yd.android_brand_mvp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class StudentMsgBean implements Serializable {
    public List<Data0> data = new ArrayList();
    public String msg;

    public static class Data0 implements Serializable {
        public long id;
        public String image;
        public int msgNum;
        public String name;
    }
}
