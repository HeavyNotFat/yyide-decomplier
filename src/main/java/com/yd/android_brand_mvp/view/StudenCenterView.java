package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.StudentCenterRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface StudenCenterView extends BaseView {
    void getDataSuccess(StudentCenterRsp studentCenterRsp);

    void getFail(String str);
}
