package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.SelectMsgView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class SelectMsgPresenter extends BasePresenter<SelectMsgView> {
    public SelectMsgPresenter(SelectMsgView selectMsgView) {
        attachView(selectMsgView);
    }

    public void selectUserInfoByIcCard(String str) {
        ((SelectMsgView) this.mvpView).showLoading();
        HashMap map = new HashMap();
        map.put("icCardNo", str);
        addSubscription(this.dingApiStores.selectNewUserInfoByIcCard(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<UserIcCardBean>() { // from class: com.yd.android_brand_mvp.presenter.SelectMsgPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(UserIcCardBean userIcCardBean) {
                ((SelectMsgView) SelectMsgPresenter.this.mvpView).selectUserInfoByIcCard(userIcCardBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((SelectMsgView) SelectMsgPresenter.this.mvpView).selectUserInfoByIcCardFail(str2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
                ((SelectMsgView) SelectMsgPresenter.this.mvpView).hideLoading();
            }
        });
    }
}
