package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.ClassScheduleRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface ClassScheduleView extends BaseView {
    void getClassScheduleData(ClassScheduleRsp classScheduleRsp);

    void getClassScheduleFail(String str);
}
