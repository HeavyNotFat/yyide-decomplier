package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.ClassesInfoBean;
import com.yd.android_brand_mvp.model.NewClassInfoRsp;
import com.yd.android_brand_mvp.model.NewWatchWordRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface ClassInfoView extends BaseView {
    void getDataSuccess(NewClassInfoRsp newClassInfoRsp);

    void getDataSuccess1(ClassesInfoBean classesInfoBean);

    void getFail(String str);

    void getFail1(String str);

    void getWatchWordSuccess(NewWatchWordRsp newWatchWordRsp);
}
