package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.NewBrandLoginRsp;
import com.yd.android_brand_mvp.model.NewLoginRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.WelcomeView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class WelcomePresenter extends BasePresenter<WelcomeView> {
    public WelcomePresenter(WelcomeView welcomeView) {
        attachView(welcomeView);
    }

    public void getNewToken(String str, String str2) {
        addSubscription(this.dingApiStores.newLogin(str, str2, "yide-cloud", "brand", "yide1234567", ""), new ApiCallback<NewLoginRsp>() { // from class: com.yd.android_brand_mvp.presenter.WelcomePresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(NewLoginRsp newLoginRsp) {
                ((WelcomeView) WelcomePresenter.this.mvpView).getdataSuccess(newLoginRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str3) {
                ((WelcomeView) WelcomePresenter.this.mvpView).getdataFail(str3);
            }
        });
    }

    public void NewBrandLogin(String str, String str2, String str3) {
        HashMap map = new HashMap();
        map.put("loginName", str);
        map.put("no", str2);
        map.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, str3);
        addSubscription(this.dingApiStores.getBrandObtain(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<NewBrandLoginRsp>() { // from class: com.yd.android_brand_mvp.presenter.WelcomePresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(NewBrandLoginRsp newBrandLoginRsp) {
                ((WelcomeView) WelcomePresenter.this.mvpView).getNewBrandSuccess(newBrandLoginRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str4) {
                ((WelcomeView) WelcomePresenter.this.mvpView).getBrandFail(str4);
            }
        });
    }
}
