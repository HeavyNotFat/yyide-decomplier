package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.KBRsp2;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.view.KBView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class KBPresenter extends BasePresenter<KBView> {
    public KBPresenter(KBView kBView) {
        attachView(kBView);
    }

    public void getKB(String str, int i) {
        String str2 = "";
        if (i != -1) {
            str2 = i + "";
        }
        HashMap map = new HashMap();
        map.put("type", "1");
        map.put("typeId", str);
        map.put("weekTime", str2);
        addSubscription(this.dingApiStores.getCDKB(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<KBRsp2>() { // from class: com.yd.android_brand_mvp.presenter.KBPresenter.2
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(KBRsp2 kBRsp2) {
                ((KBView) KBPresenter.this.mvpView).getClassKBData(kBRsp2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str3) {
                ((KBView) KBPresenter.this.mvpView).KBDataFail(str3);
            }
        });
    }

    public void getCDKB(String str, int i) {
        String str2 = "";
        if (i != -1) {
            str2 = i + "";
        }
        HashMap map = new HashMap();
        map.put("type", "2");
        map.put("typeId", str);
        map.put("weekTime", str2);
        addSubscription(this.dingApiStores.getCDKB(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) map, true))), new ApiCallback<KBRsp2>() { // from class: com.yd.android_brand_mvp.presenter.KBPresenter.3
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(KBRsp2 kBRsp2) {
                ((KBView) KBPresenter.this.mvpView).getCDKBData(kBRsp2);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str3) {
                ((KBView) KBPresenter.this.mvpView).KBDataFail(str3);
            }
        });
    }
}
