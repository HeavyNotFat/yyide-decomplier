package com.yd.android_brand_mvp.observer.observer2;

/* JADX INFO: loaded from: classes4.dex */
public interface TimeListener {
    void add(TimeNoiceListener timeNoiceListener);

    void notifyObserver(long j);

    void remove(TimeNoiceListener timeNoiceListener);
}
