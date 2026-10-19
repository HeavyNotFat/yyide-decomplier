package com.yd.android_brand_mvp.network.interceptor;

import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: compiled from: CommonResponseInterceptor.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/network/interceptor/CommonResponseInterceptor;", "Lokhttp3/Interceptor;", "()V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "isTokenExpired", "", "response", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonResponseInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        System.currentTimeMillis();
        Response responseProceed = chain.proceed(chain.request());
        isTokenExpired(responseProceed);
        return responseProceed;
    }

    private final boolean isTokenExpired(Response response) throws IOException {
        String string;
        if (response.code() == 401) {
            return true;
        }
        if (response.code() != 200) {
            return false;
        }
        ResponseBody responseBodyBody = response.body();
        if (responseBodyBody != null) {
            BufferedSource source = responseBodyBody.getSource();
            source.request(Long.MAX_VALUE);
            Buffer buffer = source.getBuffer();
            Charset utf8Format = Charset.forName("UTF-8");
            Buffer bufferClone = buffer.clone();
            Intrinsics.checkNotNullExpressionValue(utf8Format, "utf8Format");
            string = bufferClone.readString(utf8Format);
        } else {
            string = "";
        }
        string.length();
        return false;
    }
}
