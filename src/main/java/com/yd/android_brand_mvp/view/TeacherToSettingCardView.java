package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.selectTeacherByClassesIdRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface TeacherToSettingCardView extends BaseView {
    void selectTeacherByClassesIdRspFail(String str);

    void selectTeacherByClassesIdRspSuccess(selectTeacherByClassesIdRsp selectteacherbyclassesidrsp);
}
