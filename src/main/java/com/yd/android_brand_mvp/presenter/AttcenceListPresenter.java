package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.AttenceBean;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.AttenceListView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class AttcenceListPresenter extends BasePresenter<AttenceListView> {
    public AttcenceListPresenter(AttenceListView attenceListView) {
        attachView(attenceListView);
    }

    public void getAttencelist(String str) {
        HashMap map = new HashMap();
        map.put("classId", str);
        map.put("deviceName", BaseApplication.getInstance().getMac());
        addSubscription(this.dingApiStores.getAttencelist(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<AttenceBean>() { // from class: com.yd.android_brand_mvp.presenter.AttcenceListPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(AttenceBean attenceBean) {
                ((AttenceListView) AttcenceListPresenter.this.mvpView).getAttenceSuccess(attenceBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((AttenceListView) AttcenceListPresenter.this.mvpView).getAttenceSuccessFail(str2);
            }
        });
    }

    public void getAttencelist2(String str) {
        String[] strArr = {str};
        HashMap map = new HashMap();
        map.put("classId", strArr);
        map.put("no", BaseApplication.getInstance().getMac());
        addSubscription(this.dingApiStores.queryBrandAttendanceByClassIds(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<AttenceBean>() { // from class: com.yd.android_brand_mvp.presenter.AttcenceListPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(AttenceBean attenceBean) {
                ((AttenceListView) AttcenceListPresenter.this.mvpView).getAttenceSuccess(attenceBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((AttenceListView) AttcenceListPresenter.this.mvpView).getAttenceSuccessFail(str2);
            }
        });
    }
}
