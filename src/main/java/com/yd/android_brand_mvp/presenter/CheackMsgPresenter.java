package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.UserIcCardBean;
import com.yd.android_brand_mvp.model.selectNewStudentByIcCardRsp;
import com.yd.android_brand_mvp.model.selectTeacherByIcCardRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.CheackMsgView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class CheackMsgPresenter extends BasePresenter<CheackMsgView> {
    public CheackMsgPresenter(CheackMsgView cheackMsgView) {
        attachView(cheackMsgView);
    }

    public void selectUserInfoByIcCard(String str) {
        ((CheackMsgView) this.mvpView).showLoading();
        HashMap map = new HashMap();
        map.put("icCardNo", str);
        addSubscription(this.dingApiStores.selectNewUserInfoByIcCard(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<UserIcCardBean>() { // from class: com.yd.android_brand_mvp.presenter.CheackMsgPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(UserIcCardBean userIcCardBean) {
                ((CheackMsgView) CheackMsgPresenter.this.mvpView).selectUserInfoByIcCard(userIcCardBean);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((CheackMsgView) CheackMsgPresenter.this.mvpView).selectUserInfoByIcCardFail(str2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
                ((CheackMsgView) CheackMsgPresenter.this.mvpView).hideLoading();
            }
        });
    }

    public void selectUserInfoByFace(String str, String str2) {
        ((CheackMsgView) this.mvpView).showLoading();
        HashMap map = new HashMap();
        map.put("userId", str2);
        map.put("type", str);
        addSubscription(this.dingApiStores.selectNewStudentByIcCard(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<selectNewStudentByIcCardRsp>() { // from class: com.yd.android_brand_mvp.presenter.CheackMsgPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(selectNewStudentByIcCardRsp selectnewstudentbyiccardrsp) {
                ((CheackMsgView) CheackMsgPresenter.this.mvpView).selectUserInfoByIcFace(selectnewstudentbyiccardrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str3) {
                ((CheackMsgView) CheackMsgPresenter.this.mvpView).selectUserInfoByIcCardFail(str3);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
                ((CheackMsgView) CheackMsgPresenter.this.mvpView).hideLoading();
            }
        });
    }

    public void selectTeacherByFace(String str, String str2) {
        ((CheackMsgView) this.mvpView).showLoading();
        HashMap map = new HashMap();
        map.put("userId", str2);
        map.put("type", str);
        addSubscription(this.dingApiStores.selectNewTeacherByIcCard(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<selectTeacherByIcCardRsp>() { // from class: com.yd.android_brand_mvp.presenter.CheackMsgPresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(selectTeacherByIcCardRsp selectteacherbyiccardrsp) {
                ((CheackMsgView) CheackMsgPresenter.this.mvpView).selectUserInfoByIcFace(selectteacherbyiccardrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str3) {
                ((CheackMsgView) CheackMsgPresenter.this.mvpView).selectUserInfoByIcCardFail(str3);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
                ((CheackMsgView) CheackMsgPresenter.this.mvpView).hideLoading();
            }
        });
    }
}
