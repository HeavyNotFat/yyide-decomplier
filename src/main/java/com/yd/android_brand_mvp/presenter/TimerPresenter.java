package com.yd.android_brand_mvp.presenter;

import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.TimelistRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.view.TimelistView;

/* JADX INFO: loaded from: classes4.dex */
public class TimerPresenter extends BasePresenter<TimelistView> {
    public TimerPresenter(TimelistView timelistView) {
        attachView(timelistView);
    }

    public void getTimelist() {
        addSubscription(this.dingApiStores.getNewCountdownList(SpData.getClassesId()), new ApiCallback<TimelistRsp>() { // from class: com.yd.android_brand_mvp.presenter.TimerPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(TimelistRsp timelistRsp) {
                ((TimelistView) TimerPresenter.this.mvpView).getDataSuccess(timelistRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((TimelistView) TimerPresenter.this.mvpView).getFail(str);
            }
        });
    }
}
