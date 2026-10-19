package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.AttenceBean;
import com.yd.android_brand_mvp.model.AttencelistRsp;
import com.yd.android_brand_mvp.model.GeneralBean;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.AttenceView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class AttcencePresenter extends BasePresenter<AttenceView> {
    public AttcencePresenter(AttenceView attenceView) {
        attachView(attenceView);
    }

    public void Attencelist() {
        addSubscription(this.dingApiStores.Attendlist(BaseApplication.getInstance().getMac()), new ApiCallback<AttencelistRsp>() { // from class: com.yd.android_brand_mvp.presenter.AttcencePresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(AttencelistRsp attencelistRsp) {
                ((AttenceView) AttcencePresenter.this.mvpView).getDataAttenceSuccess(attencelistRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((AttenceView) AttcencePresenter.this.mvpView).getDataAttenceSuccessFail(str);
            }
        });
    }

    public void attendance(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap map = new HashMap();
        map.put("classId", str);
        map.put("peopleId", str2);
        map.put("createdDateTime", str3);
        map.put("no", str4);
        map.put("deviceName", "班牌考勤");
        map.put("peopleName", str5);
        map.put("peopleType", str6);
        addSubscription(this.dingApiStores.attendance(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<GeneralBean>() { // from class: com.yd.android_brand_mvp.presenter.AttcencePresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(GeneralBean generalBean) {
                ((AttenceView) AttcencePresenter.this.mvpView).getAttendanceSuccess(generalBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str7) {
                ((AttenceView) AttcencePresenter.this.mvpView).getAttendanceSuccessFail(str7);
            }
        });
    }

    public void getAttencelist(String str) {
        HashMap map = new HashMap();
        map.put("classId", str);
        map.put("deviceName", BaseApplication.getInstance().getMac());
        addSubscription(this.dingApiStores.getAttencelist(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<AttenceBean>() { // from class: com.yd.android_brand_mvp.presenter.AttcencePresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(AttenceBean attenceBean) {
                ((AttenceView) AttcencePresenter.this.mvpView).getAttenceSuccess(attenceBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((AttenceView) AttcencePresenter.this.mvpView).getAttenceSuccessFail(str2);
            }
        });
    }
}
