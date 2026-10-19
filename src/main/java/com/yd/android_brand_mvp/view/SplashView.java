package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.LoginRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface SplashView extends BaseView {
    void getDataSuccess(LoginRsp loginRsp);

    void getFail(String str);
}
