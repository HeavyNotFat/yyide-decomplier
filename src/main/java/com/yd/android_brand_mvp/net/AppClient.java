package com.yd.android_brand_mvp.net;

import com.yd.android_brand_mvp.utils.SpData;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: loaded from: classes4.dex */
public class AppClient {
    public static Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() { // from class: com.yd.android_brand_mvp.net.AppClient.1
        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            return chain.proceed(chain.request().newBuilder().addHeader("Authorization", SpData.getToken()).addHeader("Connection", "close").cacheControl(new CacheControl.Builder().noCache().build()).build());
        }
    };
    private static final int TIMEOUT = 30;
    public static Retrofit mDingRetrofit;
    public static Retrofit mWeatherRetrofit;
    public static Retrofit mbookRetrofit;
    public static Retrofit mlocalRetrofit;
    private static OkHttpClient okHttpClient;
    private static OkHttpClient okHttpClient2;
    private static OkHttpClient okHttpClient3;
    public int code;

    public int getCode() {
        return this.code;
    }

    public static Retrofit getDingRetrofit() {
        if (mDingRetrofit == null) {
            mDingRetrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).client(getOkHttpClient()).baseUrl("https://api.yyide.com").build();
        }
        return mDingRetrofit;
    }

    public static Retrofit getWeatherRetrofit() {
        if (mWeatherRetrofit == null) {
            mWeatherRetrofit = new Retrofit.Builder().baseUrl(WeatherApiStores.API_SERVER_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).client(getOkHttpClient3()).build();
        }
        return mWeatherRetrofit;
    }

    public static Retrofit getLocalRetrofit() {
        if (mlocalRetrofit == null) {
            mlocalRetrofit = new Retrofit.Builder().baseUrl("https://api.yyide.com").addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).client(getOkHttpClient2()).build();
        }
        return mlocalRetrofit;
    }

    public static Retrofit getBookRetrofit() {
        if (mbookRetrofit == null) {
            mbookRetrofit = new Retrofit.Builder().baseUrl(BookApiStores.API_SERVER_URL).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJava3CallAdapterFactory.create()).client(getOkHttpClient2()).build();
        }
        return mbookRetrofit;
    }

    public static OkHttpClient getOkHttpClient() {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(30L, TimeUnit.SECONDS);
            builder.connectTimeout(30L, TimeUnit.SECONDS);
            builder.writeTimeout(30L, TimeUnit.SECONDS);
            builder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
            builder.retryOnConnectionFailure(false);
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }

    public static OkHttpClient getOkHttpClient2() {
        if (okHttpClient2 == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(30L, TimeUnit.SECONDS);
            builder.connectTimeout(30L, TimeUnit.SECONDS);
            builder.writeTimeout(30L, TimeUnit.SECONDS);
            builder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
            okHttpClient2 = builder.build();
        }
        return okHttpClient2;
    }

    public static OkHttpClient getOkHttpClient3() {
        if (okHttpClient3 == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.readTimeout(30L, TimeUnit.SECONDS);
            builder.connectTimeout(30L, TimeUnit.SECONDS);
            builder.writeTimeout(30L, TimeUnit.SECONDS);
            builder.addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR);
            okHttpClient3 = builder.build();
        }
        return okHttpClient3;
    }
}
