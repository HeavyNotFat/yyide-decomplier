package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.getSchoolCalendarRsp;
import com.yd.android_brand_mvp.model.selectSchoolCalendarRsp;

/* JADX INFO: loaded from: classes4.dex */
public interface NcalendarView extends BaseView {
    void getSchoolCalendarFail(String str);

    void getSchoolCalendarSuccess(getSchoolCalendarRsp getschoolcalendarrsp);

    void getselectSchoolCalendarFail(String str);

    void getselectSchoolCalendarSuccess(selectSchoolCalendarRsp selectschoolcalendarrsp);
}
