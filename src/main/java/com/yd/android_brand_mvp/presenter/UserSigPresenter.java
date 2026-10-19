package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.getUserSigByUserIdRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.UserSigView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class UserSigPresenter extends BasePresenter<UserSigView> {
    public UserSigPresenter(UserSigView userSigView) {
        attachView(userSigView);
    }

    public void getUserSigByUserId(int i) {
        HashMap map = new HashMap();
        map.put("userId", Integer.valueOf(i));
        addSubscription(this.localApiStores.getUserSigByUserId(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString(map))), new ApiCallback<getUserSigByUserIdRsp>() { // from class: com.yd.android_brand_mvp.presenter.UserSigPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(getUserSigByUserIdRsp getusersigbyuseridrsp) {
                ((UserSigView) UserSigPresenter.this.mvpView).getDataSuccess(getusersigbyuseridrsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((UserSigView) UserSigPresenter.this.mvpView).getFail(str);
            }
        });
    }
}
