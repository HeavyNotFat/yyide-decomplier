package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.getSchoolCalendarRsp;
import com.yd.android_brand_mvp.model.selectSchoolCalendarRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.NcalendarView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class NcalendarPresenter extends BasePresenter<NcalendarView> {
    public NcalendarPresenter(NcalendarView ncalendarView) {
        attachView(ncalendarView);
    }

    public void getSchoolCalendar() {
        addSubscription(this.dingApiStores.getSchoolCalendar(), new ApiCallback<getSchoolCalendarRsp>() { // from class: com.yd.android_brand_mvp.presenter.NcalendarPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(getSchoolCalendarRsp getschoolcalendarrsp) {
                ((NcalendarView) NcalendarPresenter.this.mvpView).getSchoolCalendarSuccess(getschoolcalendarrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((NcalendarView) NcalendarPresenter.this.mvpView).getSchoolCalendarFail(str);
            }
        });
    }

    public void selectSchoolCalendar(String str, String str2) {
        HashMap map = new HashMap();
        map.put("dayOfMonth", str);
        map.put("id", str2);
        addSubscription(this.dingApiStores.selectSchoolCalendar(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<selectSchoolCalendarRsp>() { // from class: com.yd.android_brand_mvp.presenter.NcalendarPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(selectSchoolCalendarRsp selectschoolcalendarrsp) {
                ((NcalendarView) NcalendarPresenter.this.mvpView).getselectSchoolCalendarSuccess(selectschoolcalendarrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str3) {
                ((NcalendarView) NcalendarPresenter.this.mvpView).getselectSchoolCalendarFail(str3);
            }
        });
    }
}
