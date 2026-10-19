package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.model.GetAskLeaveRecordBandRsp;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.model.UserTableRsp;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.UserTableView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class UserCenterPresenter extends BasePresenter<UserTableView> {
    public void getUserSigByUserId(long j) {
    }

    public UserCenterPresenter(UserTableView userTableView) {
        attachView(userTableView);
    }

    public void UserTable(String str) {
        HashMap map = new HashMap();
        map.put(CommentsHomeFragment.TYPE_CLASSESID, str);
        map.put("weekCount", "-1");
        addSubscription(this.dingApiStores.UserTable(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<UserTableRsp>() { // from class: com.yd.android_brand_mvp.presenter.UserCenterPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(UserTableRsp userTableRsp) {
                ((UserTableView) UserCenterPresenter.this.mvpView).UserTableData(userTableRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((UserTableView) UserCenterPresenter.this.mvpView).UserTableDataFail(str2);
            }
        });
    }

    public void UserTable2(long j) {
        HashMap map = new HashMap();
        map.put(CommentsHomeFragment.TYPE_CLASSESID, j + "");
        map.put("weekCount", "-1");
        map.put("gradesId", "");
        addSubscription(this.dingApiStores.UserTable(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<UserTableRsp>() { // from class: com.yd.android_brand_mvp.presenter.UserCenterPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(UserTableRsp userTableRsp) {
                ((UserTableView) UserCenterPresenter.this.mvpView).UserTableData(userTableRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((UserTableView) UserCenterPresenter.this.mvpView).UserTableDataFail(str);
            }
        });
    }

    public void UserTable2(long j, int i) {
        HashMap map = new HashMap();
        map.put(CommentsHomeFragment.TYPE_CLASSESID, j + "");
        map.put("weekCount", i + "");
        addSubscription(this.dingApiStores.UserTable(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<UserTableRsp>() { // from class: com.yd.android_brand_mvp.presenter.UserCenterPresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(UserTableRsp userTableRsp) {
                ((UserTableView) UserCenterPresenter.this.mvpView).UserTableData(userTableRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((UserTableView) UserCenterPresenter.this.mvpView).UserTableDataFail(str);
            }
        });
    }

    public void UserTable(String str, int i) {
        HashMap map = new HashMap();
        map.put(CommentsHomeFragment.TYPE_CLASSESID, str + "");
        map.put("weekCount", i + "");
        addSubscription(this.dingApiStores.UserTable(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<UserTableRsp>() { // from class: com.yd.android_brand_mvp.presenter.UserCenterPresenter.4
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(UserTableRsp userTableRsp) {
                ((UserTableView) UserCenterPresenter.this.mvpView).UserTableData(userTableRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((UserTableView) UserCenterPresenter.this.mvpView).UserTableDataFail(str2);
            }
        });
    }

    public void getUserSig(String str) {
        addSubscription(this.dingApiStores.getUserSig(str), new ApiCallback<getUserSigByUserIdRsp>() { // from class: com.yd.android_brand_mvp.presenter.UserCenterPresenter.5
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(getUserSigByUserIdRsp getusersigbyuseridrsp) {
                ((UserTableView) UserCenterPresenter.this.mvpView).getUserSigByUserId(getusersigbyuseridrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str2) {
                ((UserTableView) UserCenterPresenter.this.mvpView).getUserSigByUserIdFail(str2);
            }
        });
    }

    public void getAskLeaveRecordBand(long j) {
        HashMap map = new HashMap();
        map.put("pageNo", "1");
        map.put("pageSize", "20");
        map.put("userId", String.valueOf(j));
        addSubscription(this.dingApiStores.askForLeaveRecordBandList(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<GetAskLeaveRecordBandRsp>() { // from class: com.yd.android_brand_mvp.presenter.UserCenterPresenter.6
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(GetAskLeaveRecordBandRsp getAskLeaveRecordBandRsp) {
                ((UserTableView) UserCenterPresenter.this.mvpView).GetAskLeaveRecordBandRsp(getAskLeaveRecordBandRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((UserTableView) UserCenterPresenter.this.mvpView).GetAskLeaveRecordBandRspFail(str);
            }
        });
    }

    public void getClassKB(String str, int i, String str2) {
        String str3 = "";
        if (i != -1) {
            str3 = i + "";
        }
        HashMap map = new HashMap();
        map.put("type", str2);
        map.put("typeId", String.valueOf(str));
        map.put("weekTime", str3);
        addSubscription(this.dingApiStores.getCDKB(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<KBRsp2>() { // from class: com.yd.android_brand_mvp.presenter.UserCenterPresenter.7
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(KBRsp2 kBRsp2) {
                ((UserTableView) UserCenterPresenter.this.mvpView).getCDKBData(kBRsp2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str4) {
                ((UserTableView) UserCenterPresenter.this.mvpView).UserTableDataFail(str4);
            }
        });
    }
}
