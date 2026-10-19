package com.yd.android_brand_mvp.observer;

/* JADX INFO: loaded from: classes4.dex */
public interface IdSubjectListener {
    void add(IdListener idListener);

    void notifyObserver(String str);

    void remove(IdListener idListener);
}
