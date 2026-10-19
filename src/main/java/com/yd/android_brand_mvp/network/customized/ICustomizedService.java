package com.yd.android_brand_mvp.network.customized;

import com.yd.android_brand_mvp.model.customized.CustomSensorBean;
import com.yd.android_brand_mvp.model.customized.CustomSiteInfoBean;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* JADX INFO: compiled from: ICustomizedService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/network/customized/ICustomizedService;", "", "requestSensorInfoList", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "Lcom/yd/android_brand_mvp/model/customized/CustomSensorBean;", "requestBody", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestSiteInfo", "Lcom/yd/android_brand_mvp/model/customized/CustomSiteInfoBean;", "requestWarningInfoList", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ICustomizedService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/sks/site/getSiteEnvIndicators")
    Object requestSensorInfoList(@Body RequestBody requestBody, Continuation<? super BaseResponse<CustomSensorBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/sks/site/get")
    Object requestSiteInfo(@Body RequestBody requestBody, Continuation<? super BaseResponse<CustomSiteInfoBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/sks/site/getSiteImages")
    Object requestWarningInfoList(@Body RequestBody requestBody, Continuation<? super BaseResponse<CustomSiteInfoBean>> continuation);
}
