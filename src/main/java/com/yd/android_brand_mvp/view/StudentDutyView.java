package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.StudenDutyBean;

/* JADX INFO: loaded from: classes4.dex */
public interface StudentDutyView extends BaseView {
    void getStudentDutySuccess(StudenDutyBean studenDutyBean);

    void getSuccessFail(String str);
}
