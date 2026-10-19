package com.yd.android_brand_mvp.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class AdbShellBean {
    private boolean isReboot = true;

    @SerializedName("shellargs")
    private String shellargs;

    public boolean isReboot() {
        return this.isReboot;
    }

    public void setReboot(boolean z) {
        this.isReboot = z;
    }

    public String getShellargs() {
        return this.shellargs;
    }

    public void setShellargs(String str) {
        this.shellargs = str;
    }
}
