package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.SchoolStytleRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface SchoolSytleView extends BaseView {
    void SchoolSytlFail(String str);

    void SchoolSytlSuccess(SchoolStytleRsp schoolStytleRsp);
}
