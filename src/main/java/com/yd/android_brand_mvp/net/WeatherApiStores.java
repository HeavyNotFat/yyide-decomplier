package com.yd.android_brand_mvp.net;

import com.yd.android_brand_mvp.model.WeatherRsp;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes4.dex */
public interface WeatherApiStores {
    public static final String API_SERVER_URL = "https://zhwnlapi.etouch.cn";

    @GET("/Ecalender/weather_mini")
    Observable<WeatherRsp> getWeather(@Query("city") String str);
}
