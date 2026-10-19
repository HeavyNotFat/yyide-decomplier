package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.listSwkRsp;
import com.yd.android_brand_mvp.model.saveSwkRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface LockView extends BaseView {
    void listLockFail(String str);

    void listLockSuccues(listSwkRsp listswkrsp);

    void saveLockFail(String str);

    void saveLockSuccues(saveSwkRsp saveswkrsp);
}
