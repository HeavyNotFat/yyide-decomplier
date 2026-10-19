package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.getNewestVersionRsp;
import com.yd.android_brand_mvp.model.insetVersionUpdatedSchoolRsp;
import com.yd.android_brand_mvp.model.queryClassificListRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.SettingView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class SettingPresenter extends BasePresenter<SettingView> {
    public SettingPresenter(SettingView settingView) {
        attachView(settingView);
    }

    public void getNewestVersion(String str) {
        ((SettingView) this.mvpView).showLoading();
        HashMap map = new HashMap();
        map.put("schoolId", str);
        map.put("deviceType", "2");
        map.put("versionType", Integer.valueOf(BaseConstant.isCustomMade ? 1 : 2));
        addSubscription(this.dingApiStores.getNewestVersion(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<getNewestVersionRsp>() { // from class: com.yd.android_brand_mvp.presenter.SettingPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(getNewestVersionRsp getnewestversionrsp) {
                ((SettingView) SettingPresenter.this.mvpView).NewestVersionSuccess(getnewestversionrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((SettingView) SettingPresenter.this.mvpView).NewestVersionFail(str2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
                ((SettingView) SettingPresenter.this.mvpView).hideLoading();
            }
        });
    }

    public void insetVersionUpdatedSchool(Object obj, Object obj2) {
        ((SettingView) this.mvpView).showLoading();
        HashMap map = new HashMap();
        map.put("versionSchoolId", obj);
        map.put("brandApplicationId", obj2);
        addSubscription(this.dingApiStores.insetVersionUpdatedSchool(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<insetVersionUpdatedSchoolRsp>() { // from class: com.yd.android_brand_mvp.presenter.SettingPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(insetVersionUpdatedSchoolRsp insetversionupdatedschoolrsp) {
                ((SettingView) SettingPresenter.this.mvpView).insetVersionUpdatedSchoolRsp(insetversionupdatedschoolrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((SettingView) SettingPresenter.this.mvpView).insetVersionUpdatedSchoolFail(str);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
                ((SettingView) SettingPresenter.this.mvpView).hideLoading();
            }
        });
    }

    public void queryClassificList(Object obj) {
        ((SettingView) this.mvpView).showLoading();
        HashMap map = new HashMap();
        map.put("brandApplicationId", obj);
        addSubscription(this.dingApiStores.queryClassificList(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<queryClassificListRsp>() { // from class: com.yd.android_brand_mvp.presenter.SettingPresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(queryClassificListRsp queryclassificlistrsp) {
                ((SettingView) SettingPresenter.this.mvpView).queryClassificListRsp(queryclassificlistrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((SettingView) SettingPresenter.this.mvpView).queryClassificListFail(str);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
                ((SettingView) SettingPresenter.this.mvpView).hideLoading();
            }
        });
    }
}
