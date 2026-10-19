package com.yd.android_brand_mvp.network.base;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yd.android_brand_mvp.base.BaseConstant;
import com.yd.android_brand_mvp.utils.view.net.GsonUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

/* JADX INFO: compiled from: SSEClient.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000eR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/network/base/SSEClient;", "", "()V", "SEE_SESSION_URL", "", "getSEE_SESSION_URL", "()Ljava/lang/String;", "setSEE_SESSION_URL", "(Ljava/lang/String;)V", "client", "Lokhttp3/OkHttpClient;", "currentCall", "Lokhttp3/Call;", "connect", "", "url", "sessionId", "prompt", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/yd/android_brand_mvp/network/base/SSEClient$SSEListener;", "disconnect", "SSEListener", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SSEClient {
    public static final SSEClient INSTANCE = new SSEClient();
    private static String SEE_SESSION_URL = "https://api.yyide.com/ai/chat/completion/stream";
    private static OkHttpClient client = new OkHttpClient.Builder().readTimeout(0, TimeUnit.SECONDS).connectTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS).build();
    private static Call currentCall;

    /* JADX INFO: compiled from: SSEClient.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/network/base/SSEClient$SSEListener;", "", "onError", "", "e", "Ljava/io/IOException;", "onMessage", "message", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface SSEListener {
        void onError(IOException e);

        void onMessage(String message);
    }

    private SSEClient() {
    }

    public final String getSEE_SESSION_URL() {
        return SEE_SESSION_URL;
    }

    public final void setSEE_SESSION_URL(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        SEE_SESSION_URL = str;
    }

    public final void connect(String url, String sessionId, String prompt, final SSEListener listener) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(prompt, "prompt");
        Intrinsics.checkNotNullParameter(listener, "listener");
        disconnect();
        RequestBody.Companion companion = RequestBody.INSTANCE;
        MediaType mediaType = BaseConstant.JSON;
        String json = GsonUtils.toJson(MapsKt.mapOf(TuplesKt.to("sessionId", sessionId), TuplesKt.to("prompt", prompt)));
        Intrinsics.checkNotNullExpressionValue(json, "toJson(mapOf(\n          …mpt\" to prompt\n        ))");
        Request requestBuild = new Request.Builder().header("Accept", "text/event-stream").post(companion.create(mediaType, json)).url(url).build();
        OkHttpClient okHttpClient = client;
        Intrinsics.checkNotNull(okHttpClient);
        Call callNewCall = okHttpClient.newCall(requestBuild);
        callNewCall.enqueue(new Callback() { // from class: com.yd.android_brand_mvp.network.base.SSEClient$connect$1$1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                if (call.getCanceled()) {
                    return;
                }
                listener.onError(e);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                BufferedSource source;
                boolean z;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (!response.isSuccessful()) {
                    listener.onError(new IOException("HTTP " + response.code()));
                    return;
                }
                ResponseBody responseBodyBody = response.body();
                SSEClient.SSEListener sSEListener = listener;
                try {
                    ResponseBody responseBody = responseBodyBody;
                    if (responseBody != null && (source = responseBody.getSource()) != null) {
                        BufferedSource bufferedSource = source;
                        try {
                            BufferedSource bufferedSource2 = bufferedSource;
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String utf8Line = bufferedSource2.readUtf8Line();
                                z = true;
                                if (utf8Line == null) {
                                    break;
                                }
                                if (StringsKt.startsWith$default(utf8Line, "data:", false, 2, (Object) null)) {
                                    String strSubstring = utf8Line.substring(5);
                                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String).substring(startIndex)");
                                    sb.append(StringsKt.trim((CharSequence) strSubstring).toString());
                                    sb.append("\n");
                                } else {
                                    if (utf8Line.length() == 0) {
                                        if (sb.length() <= 0) {
                                            z = false;
                                        }
                                        if (z) {
                                            String string = sb.toString();
                                            Intrinsics.checkNotNullExpressionValue(string, "buffer.toString()");
                                            sSEListener.onMessage(StringsKt.trimEnd((CharSequence) string).toString());
                                            StringsKt.clear(sb);
                                        }
                                    }
                                }
                                try {
                                    throw th;
                                } catch (Throwable th) {
                                    CloseableKt.closeFinally(responseBodyBody, th);
                                    throw th;
                                }
                            }
                            if (sb.length() <= 0) {
                                z = false;
                            }
                            if (z) {
                                String string2 = sb.toString();
                                Intrinsics.checkNotNullExpressionValue(string2, "buffer.toString()");
                                sSEListener.onMessage(StringsKt.trimEnd((CharSequence) string2).toString());
                            }
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(bufferedSource, null);
                            Unit unit2 = Unit.INSTANCE;
                        } catch (Throwable th2) {
                            try {
                                throw th2;
                            } catch (Throwable th3) {
                                CloseableKt.closeFinally(bufferedSource, th2);
                                throw th3;
                            }
                        }
                    }
                    CloseableKt.closeFinally(responseBodyBody, null);
                } catch (Throwable th4) {
                    throw th4;
                }
            }
        });
        currentCall = callNewCall;
    }

    public final void disconnect() {
        Call call = currentCall;
        if (call != null) {
            call.cancel();
        }
        currentCall = null;
    }
}
