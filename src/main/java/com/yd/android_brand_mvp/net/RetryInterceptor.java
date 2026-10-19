package com.yd.android_brand_mvp.net;

import com.blankj.utilcode.util.NetworkUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes4.dex */
public class RetryInterceptor implements Interceptor {
    private int maxRetries;
    private long retryDelay;

    public RetryInterceptor(int i, long j) {
        this.maxRetries = i;
        this.retryDelay = TimeUnit.SECONDS.toMillis(j);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Response responseProceed = null;
        int i = 0;
        while (i < this.maxRetries) {
            if (!NetworkUtils.isConnected()) {
                try {
                    Thread.sleep(this.retryDelay);
                } catch (InterruptedException unused) {
                }
            } else {
                try {
                    responseProceed = chain.proceed(request);
                    if (isResponseSuccessful(responseProceed)) {
                        return responseProceed;
                    }
                } catch (IOException unused2) {
                }
                i++;
                if (i < this.maxRetries) {
                    Thread.sleep(this.retryDelay);
                }
            }
        }
        return responseProceed;
    }

    private boolean isResponseSuccessful(Response response) {
        int iCode = response.code();
        return iCode >= 200 && iCode < 300;
    }
}
