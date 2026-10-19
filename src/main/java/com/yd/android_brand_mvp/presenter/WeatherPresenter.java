package com.yd.android_brand_mvp.presenter;

import com.alibaba.fastjson.JSON;
import com.yd.android_brand_mvp.base.BasePresenter;
import com.yd.android_brand_mvp.model.NewWeatherBean;
import com.yd.android_brand_mvp.net.ApiCallback;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import com.yd.android_brand_mvp.view.WeatherView;
import java.util.HashMap;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes4.dex */
public class WeatherPresenter extends BasePresenter<WeatherView> {
    public WeatherPresenter(WeatherView weatherView) {
        attachView(weatherView);
    }

    public void getNewWeather() {
        addSubscription(this.dingApiStores.getNewWeather(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JSON.toJSONString((Object) new HashMap(), true))), new ApiCallback<BaseResponse<NewWeatherBean>>() { // from class: com.yd.android_brand_mvp.presenter.WeatherPresenter.1
            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFinish() {
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onSuccess(BaseResponse<NewWeatherBean> baseResponse) {
                ((WeatherView) WeatherPresenter.this.mvpView).getWeatherSuccess(baseResponse);
            }

            @Override // com.yd.android_brand_mvp.net.ApiCallback
            public void onFailure(String str) {
                ((WeatherView) WeatherPresenter.this.mvpView).getWeatherFail(str);
            }
        });
    }
}
