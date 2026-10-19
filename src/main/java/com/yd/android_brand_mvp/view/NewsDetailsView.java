package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.NewsDetailsEntity;

/* JADX INFO: loaded from: classes4.dex */
public interface NewsDetailsView extends BaseView {
    void getNewsDetailsFail(String str);

    void getNewsDetailsSuccess(NewsDetailsEntity newsDetailsEntity);
}
