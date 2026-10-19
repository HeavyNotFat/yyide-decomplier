package com.yd.android_brand_mvp.observer;

/* JADX INFO: loaded from: classes4.dex */
public interface NetWorkListener {
    void add(NetWorkStaus netWorkStaus);

    void notifyObserver(boolean z);

    void remove(NetWorkStaus netWorkStaus);
}
