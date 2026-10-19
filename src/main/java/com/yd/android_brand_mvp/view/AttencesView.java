package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.AttanceTodatDetailsRsp;
import com.yd.android_brand_mvp.model.AttenceListBean;
import com.yd.android_brand_mvp.model.AttenceNewListBean;
import com.yd.android_brand_mvp.model.KBRsp2;

/* JADX INFO: loaded from: classes4.dex */
public interface AttencesView extends BaseView {
    void getAttenceListSuccess(AttenceListBean attenceListBean);

    void getAttenceListSuccessFail(String str);

    void getAttenceNewListSuccess(AttenceNewListBean attenceNewListBean);

    void getToadyAttenceListFails(String str);

    void getToadyAttenceListSuccess(KBRsp2 kBRsp2);

    void getToadyListSuccess(AttanceTodatDetailsRsp attanceTodatDetailsRsp);
}
