package com.yd.android_brand_mvp.model;

/* JADX INFO: loaded from: classes4.dex */
public class BaseEventBean {
    public static final int EVENT_CARD_TYPE = 1000;
    public int code;
    public String value;

    public BaseEventBean(int i, String str) {
        this.code = i;
        this.value = str;
    }
}
