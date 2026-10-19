package com.yd.android_brand_mvp.net;

import com.yd.android_brand_mvp.utils.SpData;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public class HttpUtils {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    public static Response post(String str, String str2) throws IOException {
        return client.newCall(new Request.Builder().addHeader("Authorization", SpData.getToken()).addHeader("Content-Type", "application/json").url(str).post(RequestBody.create(JSON, str2)).build()).execute();
    }

    public static Response get(String str) throws IOException {
        return client.newCall(new Request.Builder().url(str).build()).execute();
    }
}
