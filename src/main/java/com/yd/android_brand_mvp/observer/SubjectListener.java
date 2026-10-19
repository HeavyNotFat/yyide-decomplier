package com.yd.android_brand_mvp.observer;

/* JADX INFO: loaded from: classes4.dex */
public interface SubjectListener {
    void add(ObserverListener observerListener);

    void notifyObserver(String str);

    void remove(ObserverListener observerListener);
}
