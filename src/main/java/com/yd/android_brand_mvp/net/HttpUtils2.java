package com.yd.android_brand_mvp.net;

import android.os.Handler;
import android.os.Message;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.utils.SpData;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public class HttpUtils2 {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();

    public static void post(String str, String str2, final Handler handler) throws IOException {
        client.newCall(new Request.Builder().addHeader("Authorization", SpData.getToken()).addHeader("Content-Type", "application/json").url(str).post(RequestBody.create(JSON, str2)).build()).enqueue(new Callback() { // from class: com.yd.android_brand_mvp.net.HttpUtils2.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Message message = new Message();
                message.what = 2;
                handler.sendMessage(message);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                if (response.code() == BaseConstant.REQUEST_SUCCES2) {
                    String strString = response.body().string();
                    Message message = new Message();
                    message.what = 1;
                    message.obj = strString;
                    handler.sendMessage(message);
                }
            }
        });
    }

    public static Response get(String str) throws IOException {
        return client.newCall(new Request.Builder().url(str).build()).execute();
    }
}
