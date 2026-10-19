package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface UserSigView extends BaseView {
    void getDataSuccess(getUserSigByUserIdRsp getusersigbyuseridrsp);

    void getFail(String str);
}
