package com.yd.android_brand_mvp.observer;

/* JADX INFO: loaded from: classes4.dex */
public interface EventListener {
    void add(MinaListener minaListener);

    void notifyObserver(int i);

    void remove(MinaListener minaListener);
}
