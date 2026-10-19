package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.KBRsp;
import com.yd.android_brand_mvp.model.KBRsp2;

/* JADX INFO: loaded from: classes4.dex */
public interface KBView extends BaseView {
    void KBDataFail(String str);

    void getCDKBData(KBRsp2 kBRsp2);

    void getClassKBData(KBRsp2 kBRsp2);

    void getKBData(KBRsp kBRsp);
}
