package com.yd.android_brand_mvp.presenter;

import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.SchoolStytleRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.SchoolSytleView;

/* JADX INFO: loaded from: classes4.dex */
public class SchoolPresenter extends BasePresenter<SchoolSytleView> {
    public SchoolPresenter(SchoolSytleView schoolSytleView) {
        attachView(schoolSytleView);
    }

    public void SchoolStyle() {
        addSubscription(this.dingApiStores.SchoolStyle(), new ApiCallback<SchoolStytleRsp>() { // from class: com.yd.android_brand_mvp.presenter.SchoolPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(SchoolStytleRsp schoolStytleRsp) {
                ((SchoolSytleView) SchoolPresenter.this.mvpView).SchoolSytlSuccess(schoolStytleRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((SchoolSytleView) SchoolPresenter.this.mvpView).SchoolSytlFail(str);
            }
        });
    }
}
