package com.yd.android_brand_mvp.network.base;

import android.content.Context;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.gson.GsonBuilder;
import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.network.exception.GlobalException;
import com.yd.android_brand_mvp.network.exception.NetworkException;
import com.yd.android_brand_mvp.network.interceptor.CommonRequestInterceptor;
import com.yd.android_brand_mvp.network.interceptor.CommonResponseInterceptor;
import com.yd.android_brand_mvp.network.interceptor.GsonTypeAdapterFactory;
import com.yd.android_brand_mvp.utils.SpData;
import com.yd.android_brand_mvp.utils.ToastUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* JADX INFO: compiled from: BaseNetworkApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \"*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\"B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0011H\u0002JL\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0016\"\u0004\b\u0001\u0010\u00172\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u001b0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u0019H\u0084@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0013H\u0014J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00028\u00008DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00028\u00008DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\b\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "I", "Lcom/yd/android_brand_mvp/network/base/IService;", "baseUrl", "", "(Ljava/lang/String;)V", "noInterceptorService", "getNoInterceptorService", "()Ljava/lang/Object;", "noInterceptorService$delegate", "Lkotlin/Lazy;", "service", "getService", "service$delegate", "getCustomInterceptor", "Lokhttp3/Interceptor;", "getCustomOkHttpClient", "Lokhttp3/OkHttpClient;", "getNoInterceptorRetrofit", "Lretrofit2/Retrofit;", "getOkHttpClient", "getResult", "Lkotlin/Result;", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "", "getResult-gIAlu-s", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRetrofit", "getServiceClass", "Ljava/lang/Class;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseNetworkApi<I> implements IService<I> {
    private static final int RETRY_COUNT = 2;
    public static final String TAG = "BaseNetworkApi";
    private final String baseUrl;

    /* JADX INFO: renamed from: noInterceptorService$delegate, reason: from kotlin metadata */
    private final Lazy noInterceptorService;

    /* JADX INFO: renamed from: service$delegate, reason: from kotlin metadata */
    private final Lazy service;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<OkHttpClient> defaultOkHttpClient$delegate = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.yd.android_brand_mvp.network.base.BaseNetworkApi$Companion$defaultOkHttpClient$2
        @Override // kotlin.jvm.functions.Function0
        public final OkHttpClient invoke() {
            OkHttpClient.Builder builderRetryOnConnectionFailure = new OkHttpClient.Builder().callTimeout(30L, TimeUnit.SECONDS).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).retryOnConnectionFailure(true);
            builderRetryOnConnectionFailure.addInterceptor(new CommonRequestInterceptor());
            builderRetryOnConnectionFailure.addInterceptor(new CommonResponseInterceptor());
            builderRetryOnConnectionFailure.addInterceptor(BaseNetworkApi.REWRITE_CACHE_CONTROL_INTERCEPTOR);
            return builderRetryOnConnectionFailure.build();
        }
    });
    private static final Lazy<OkHttpClient> noInterceptorOkHttpClient$delegate = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.yd.android_brand_mvp.network.base.BaseNetworkApi$Companion$noInterceptorOkHttpClient$2
        @Override // kotlin.jvm.functions.Function0
        public final OkHttpClient invoke() {
            OkHttpClient.Builder builderRetryOnConnectionFailure = new OkHttpClient.Builder().callTimeout(30L, TimeUnit.SECONDS).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).retryOnConnectionFailure(true);
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: com.yd.android_brand_mvp.network.base.BaseNetworkApi$Companion$noInterceptorOkHttpClient$2$loggingInterceptor$1
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    LogUtils.i(new Object[]{message});
                }
            });
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builderRetryOnConnectionFailure.addInterceptor(httpLoggingInterceptor);
            return builderRetryOnConnectionFailure.build();
        }
    });
    private static Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() { // from class: com.yd.android_brand_mvp.network.base.-$$Lambda$BaseNetworkApi$65wtRVK3JIYcqzHqX2TB3aJTp5Y
        @Override // okhttp3.Interceptor
        public final Response intercept(Interceptor.Chain chain) {
            return BaseNetworkApi.REWRITE_CACHE_CONTROL_INTERCEPTOR$lambda$0(chain);
        }
    };

    protected Interceptor getCustomInterceptor() {
        return null;
    }

    protected OkHttpClient getCustomOkHttpClient() {
        return null;
    }

    public BaseNetworkApi(String baseUrl) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        this.baseUrl = baseUrl;
        this.service = LazyKt.lazy(new Function0<I>(this) { // from class: com.yd.android_brand_mvp.network.base.BaseNetworkApi$service$2
            final /* synthetic */ BaseNetworkApi<I> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final I invoke() {
                return (I) this.this$0.getRetrofit().create(this.this$0.getServiceClass());
            }
        });
        this.noInterceptorService = LazyKt.lazy(new Function0<I>(this) { // from class: com.yd.android_brand_mvp.network.base.BaseNetworkApi$noInterceptorService$2
            final /* synthetic */ BaseNetworkApi<I> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final I invoke() {
                return (I) this.this$0.getNoInterceptorRetrofit().create(this.this$0.getServiceClass());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final I getService() {
        return (I) this.service.getValue();
    }

    protected final I getNoInterceptorService() {
        return (I) this.noInterceptorService.getValue();
    }

    protected Retrofit getRetrofit() {
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(this.baseUrl).client(getOkHttpClient()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().registerTypeAdapterFactory(new GsonTypeAdapterFactory()).create())).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder().baseUrl(baseUr…ory.create(gson)).build()");
        return retrofitBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Retrofit getNoInterceptorRetrofit() {
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(this.baseUrl).client(INSTANCE.getNoInterceptorOkHttpClient()).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().registerTypeAdapterFactory(new GsonTypeAdapterFactory()).create())).build();
        Intrinsics.checkNotNullExpressionValue(retrofitBuild, "Builder().baseUrl(baseUr…on))\n            .build()");
        return retrofitBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<I> getServiceClass() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<I of com.yd.android_brand_mvp.network.base.BaseNetworkApi>");
        return (Class) type;
    }

    private final OkHttpClient getOkHttpClient() {
        OkHttpClient customOkHttpClient = getCustomOkHttpClient();
        return customOkHttpClient != null ? customOkHttpClient : INSTANCE.getDefaultOkHttpClient();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getResult-gIAlu-s, reason: not valid java name */
    protected final <T> Object m485getResultgIAlus(Function1<? super Continuation<? super BaseResponse<T>>, ? extends Object> function1, Continuation<? super Result<? extends T>> continuation) {
        BaseNetworkApi$getResult$1 baseNetworkApi$getResult$1;
        if (continuation instanceof BaseNetworkApi$getResult$1) {
            baseNetworkApi$getResult$1 = (BaseNetworkApi$getResult$1) continuation;
            if ((baseNetworkApi$getResult$1.label & Integer.MIN_VALUE) != 0) {
                baseNetworkApi$getResult$1.label -= Integer.MIN_VALUE;
            } else {
                baseNetworkApi$getResult$1 = new BaseNetworkApi$getResult$1(this, continuation);
            }
        } else {
            baseNetworkApi$getResult$1 = new BaseNetworkApi$getResult$1(this, continuation);
        }
        Object objInvoke = baseNetworkApi$getResult$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = baseNetworkApi$getResult$1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objInvoke);
                baseNetworkApi$getResult$1.label = 1;
                objInvoke = function1.invoke(baseNetworkApi$getResult$1);
                if (objInvoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objInvoke);
            }
            BaseResponse baseResponse = (BaseResponse) objInvoke;
            if (baseResponse.getCode() != 0) {
                Context applicationContext = BaseApplication.getInstance().getApplicationContext();
                String message = baseResponse.getMessage();
                if (message == null) {
                    message = "服务异常";
                }
                ToastUtil.showBottomView(applicationContext, message);
                throw GlobalException.INSTANCE.of(baseResponse.getCode(), String.valueOf(baseResponse.getMessage()));
            }
            if (baseResponse.getData() == null) {
                throw GlobalException.INSTANCE.of(601, "response value is null");
            }
            Result.Companion companion = Result.INSTANCE;
            return Result.m591constructorimpl(baseResponse.getData());
        } catch (Throwable th) {
            if (th instanceof NetworkException ? true : th instanceof ConnectException ? true : th instanceof SocketTimeoutException ? true : th instanceof SocketException) {
                ToastUtils.showLong("网络异常", new Object[0]);
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m591constructorimpl(ResultKt.createFailure(GlobalException.INSTANCE.of(602, "网络异常")));
            }
            if (th instanceof GlobalException) {
                Result.Companion companion3 = Result.INSTANCE;
                return Result.m591constructorimpl(ResultKt.createFailure(th));
            }
            th.printStackTrace();
            LogUtils.e("Http Request Error " + th.getMessage());
            Result.Companion companion4 = Result.INSTANCE;
            return Result.m591constructorimpl(ResultKt.createFailure(GlobalException.INSTANCE.of(601, "请求异常")));
        }
    }

    /* JADX INFO: compiled from: BaseNetworkApi.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi$Companion;", "", "()V", "RETRY_COUNT", "", "REWRITE_CACHE_CONTROL_INTERCEPTOR", "Lokhttp3/Interceptor;", "TAG", "", "defaultOkHttpClient", "Lokhttp3/OkHttpClient;", "getDefaultOkHttpClient", "()Lokhttp3/OkHttpClient;", "defaultOkHttpClient$delegate", "Lkotlin/Lazy;", "noInterceptorOkHttpClient", "getNoInterceptorOkHttpClient", "noInterceptorOkHttpClient$delegate", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final OkHttpClient getDefaultOkHttpClient() {
            return (OkHttpClient) BaseNetworkApi.defaultOkHttpClient$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final OkHttpClient getNoInterceptorOkHttpClient() {
            return (OkHttpClient) BaseNetworkApi.noInterceptorOkHttpClient$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response REWRITE_CACHE_CONTROL_INTERCEPTOR$lambda$0(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        CacheControl.Builder builder = new CacheControl.Builder();
        builder.maxAge(0, TimeUnit.SECONDS);
        builder.maxStale(365, TimeUnit.DAYS);
        builder.build();
        Request request = chain.request();
        String token = SpData.getToken();
        Log.i("TAG", "intercept: " + token);
        Log.i("TAG", "request.url: " + request.url());
        if (StringsKt.contains$default((CharSequence) request.url().getUrl(), (CharSequence) "/ai/chat/session/create", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) request.url().getUrl(), (CharSequence) "/ai/assistant/get", false, 2, (Object) null)) {
            token = "";
        }
        Request.Builder builderNewBuilder = request.newBuilder();
        Intrinsics.checkNotNullExpressionValue(token, "token");
        return chain.proceed(builderNewBuilder.addHeader("Authorization", token).cacheControl(new CacheControl.Builder().noCache().build()).build()).newBuilder().removeHeader("Pragma").header("Cache-Control", "public ,max-age=0").build();
    }
}
