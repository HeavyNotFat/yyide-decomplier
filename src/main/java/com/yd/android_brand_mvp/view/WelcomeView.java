package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.NewLoginRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface WelcomeView extends BaseView {
    void getBrandFail(String str);

    void getNewBrandSuccess(NewBrandLoginRsp newBrandLoginRsp);

    void getdataFail(String str);

    void getdataSuccess(NewLoginRsp newLoginRsp);
}
