package com.yd.android_brand_mvp.network.active;

import com.yd.android_brand_mvp.model.active.ActiveDetailsBean;
import com.yd.android_brand_mvp.model.active.ActiveMyRegistrationBean;
import com.yd.android_brand_mvp.model.active.ActiveRegistrationBean;
import com.yd.android_brand_mvp.model.active.ActiveSuccessBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* JADX INFO: compiled from: IActiveService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J-\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J-\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\n0\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/yd/android_brand_mvp/network/active/IActiveService;", "", "requestActiveDetails", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "Lcom/yd/android_brand_mvp/model/active/ActiveDetailsBean;", "requestBody", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestActiveList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/active/ActiveRegistrationBean;", "requestActiveRegistration", "Lcom/yd/android_brand_mvp/model/active/ActiveSuccessBean;", "requestLoginActiveDetails", "requestMyRegistrationList", "Lcom/yd/android_brand_mvp/model/active/ActiveMyRegistrationBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IActiveService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/activity/enroll/detail")
    Object requestActiveDetails(@Body RequestBody requestBody, Continuation<? super BaseResponse<ActiveDetailsBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/activity/enroll/page")
    Object requestActiveList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<ActiveRegistrationBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/activity/enroll/userActivityEnroll")
    Object requestActiveRegistration(@Body RequestBody requestBody, Continuation<? super BaseResponse<ActiveSuccessBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/activity/enroll/activityEnrollInfo")
    Object requestLoginActiveDetails(@Body RequestBody requestBody, Continuation<? super BaseResponse<ActiveDetailsBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/activity/enroll/userEnrollPage")
    Object requestMyRegistrationList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<ActiveMyRegistrationBean>>>> continuation);
}
