package com.yd.android_brand_mvp.view;

import com.yd.android_brand_mvp.base.BaseView;
import com.yd.android_brand_mvp.model.NewWeatherBean;
import com.yd.android_brand_mvp.network.base.BaseResponse;

/* JADX INFO: loaded from: classes4.dex */
public interface WeatherView extends BaseView {
    void getWeatherFail(String str);

    void getWeatherSuccess(BaseResponse<NewWeatherBean> baseResponse);
}
