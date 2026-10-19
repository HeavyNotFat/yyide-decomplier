package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.AttenceBean;
import com.yd.android_brand_mvp.model.AttencelistRsp;
import com.yd.android_brand_mvp.model.GeneralBean;

/* JADX INFO: loaded from: classes4.dex */
public interface AttenceView extends BaseView {
    void getAttenceSuccess(AttenceBean attenceBean);

    void getAttenceSuccessFail(String str);

    void getAttendanceSuccess(GeneralBean generalBean);

    void getAttendanceSuccessFail(String str);

    void getDataAttenceSuccess(AttencelistRsp attencelistRsp);

    void getDataAttenceSuccessFail(String str);
}
