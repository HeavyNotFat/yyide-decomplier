package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.NewsEntity;

/* JADX INFO: loaded from: classes4.dex */
public interface NewsView extends BaseView {
    void getNewsFail(String str);

    void getNewsSuccess(NewsEntity newsEntity);
}
