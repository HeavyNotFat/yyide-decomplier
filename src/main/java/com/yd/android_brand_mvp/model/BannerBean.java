package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class BannerBean {
    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_VIDEO = 2;
    private String name;
    private int type;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }
}
