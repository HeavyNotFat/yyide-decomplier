package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.TeachersRsp;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.TeachersView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class TeachersPresenter extends BasePresenter<TeachersView> {
    public TeachersPresenter(TeachersView teachersView) {
        attachView(teachersView);
    }

    public void Teachers(int i) {
        HashMap map = new HashMap();
        map.put("pageNo", Integer.valueOf(i));
        if (ScreenUtils.isLandscape()) {
            map.put("pageSize", 21);
        } else {
            map.put("pageSize", 20);
        }
        addSubscription(this.dingApiStores.Teachers(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<TeachersRsp>() { // from class: com.yd.android_brand_mvp.presenter.TeachersPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(TeachersRsp teachersRsp) {
                ((TeachersView) TeachersPresenter.this.mvpView).teachersSuccess(teachersRsp);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((TeachersView) TeachersPresenter.this.mvpView).teachersFail(str);
            }
        });
    }
}
