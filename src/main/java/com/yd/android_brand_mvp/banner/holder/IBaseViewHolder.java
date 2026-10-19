package com.yd.android_brand_mvp.banner.holder;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public interface IBaseViewHolder<T, VH> {
    void onBindView(VH vh, T t, int i, int i2, int i3);

    VH onCreateHolder(ViewGroup viewGroup, int i);
}
