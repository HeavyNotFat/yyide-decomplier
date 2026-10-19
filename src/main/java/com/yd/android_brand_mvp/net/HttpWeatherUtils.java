package com.yd.android_brand_mvp.net;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public class HttpWeatherUtils {
    private static OkHttpClient client = new OkHttpClient();

    public static Response post(String str, String str2) throws IOException {
        Request requestBuild = new Request.Builder().url(str).build();
        Response responseExecute = client.newCall(requestBuild).execute();
        client.newCall(requestBuild).enqueue(new Callback() { // from class: com.yd.android_brand_mvp.net.HttpWeatherUtils.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
            }
        });
        return responseExecute;
    }
}
