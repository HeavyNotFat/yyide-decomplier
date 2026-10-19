package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.AttenceBean;

/* JADX INFO: loaded from: classes4.dex */
public interface AttenceListView extends BaseView {
    void getAttenceSuccess(AttenceBean attenceBean);

    void getAttenceSuccessFail(String str);
}
