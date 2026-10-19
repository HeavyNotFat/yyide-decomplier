package com.yd.android_brand_mvp.presenter;

import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.ClassScheduleRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.ClassScheduleView;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class ClassSchedulePresenter extends BasePresenter<ClassScheduleView> {
    public ClassSchedulePresenter(ClassScheduleView classScheduleView) {
        attachView(classScheduleView);
    }

    public void getClassSchedule(RequestBody requestBody) {
        addSubscription(this.dingApiStores.getClassSchedule(requestBody), new ApiCallback<ClassScheduleRsp>() { // from class: com.yd.android_brand_mvp.presenter.ClassSchedulePresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(ClassScheduleRsp classScheduleRsp) {
                ((ClassScheduleView) ClassSchedulePresenter.this.mvpView).getClassScheduleData(classScheduleRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((ClassScheduleView) ClassSchedulePresenter.this.mvpView).getClassScheduleFail(str);
            }
        });
    }
}
