package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.TimelistRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface TimelistView extends BaseView {
    void getDataSuccess(TimelistRsp timelistRsp);

    void getFail(String str);
}
