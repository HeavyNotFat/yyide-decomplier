package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.listSwkRsp;
import com.yd.android_brand_mvp.model.saveSwkRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.LockView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class LockPresenter extends BasePresenter<LockView> {
    public LockPresenter(LockView lockView) {
        attachView(lockView);
    }

    public void saveLock(String str, String str2, String str3, String str4, String str5) {
        HashMap map = new HashMap();
        map.put("id", str);
        map.put("officeId", str2);
        map.put("lockId", str3);
        map.put("loginName", str4);
        map.put("lockAlias", str5);
        addSubscription(this.localApiStores.saveSwk(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<saveSwkRsp>() { // from class: com.yd.android_brand_mvp.presenter.LockPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(saveSwkRsp saveswkrsp) {
                ((LockView) LockPresenter.this.mvpView).saveLockSuccues(saveswkrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str6) {
                ((LockView) LockPresenter.this.mvpView).saveLockFail(str6);
            }
        });
    }

    public void listSwk(String str, String str2) {
        HashMap map = new HashMap();
        map.put("officeId", str2);
        map.put("loginName", str);
        addSubscription(this.localApiStores.listSwk(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<listSwkRsp>() { // from class: com.yd.android_brand_mvp.presenter.LockPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(listSwkRsp listswkrsp) {
                ((LockView) LockPresenter.this.mvpView).listLockSuccues(listswkrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str3) {
                ((LockView) LockPresenter.this.mvpView).saveLockFail(str3);
            }
        });
    }
}
