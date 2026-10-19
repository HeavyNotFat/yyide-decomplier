package com.yd.android_brand_mvp.websocket;

/* JADX INFO: loaded from: classes4.dex */
public class EventBean {
    private int code;
    private String message;
    private Object object;
    private String origin;
    private String request;
    private boolean success;

    public int getCode() {
        return this.code;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String str) {
        this.origin = str;
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object obj) {
        this.object = obj;
    }

    public String getRequest() {
        return this.request;
    }

    public void setRequest(String str) {
        this.request = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
