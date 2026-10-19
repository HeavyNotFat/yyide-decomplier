package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.TeachersRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface TeachersView extends BaseView {
    void teachersFail(String str);

    void teachersSuccess(TeachersRsp teachersRsp);
}
