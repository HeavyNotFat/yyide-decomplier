package com.yd.android_brand_mvp.model;

import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class FaceInitBean implements Serializable {
    public String eigenValue;
    public String name;
    public String userId;

    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getEigenValue() {
        return this.eigenValue;
    }

    public void setEigenValue(String str) {
        this.eigenValue = str;
    }
}
