package com.yd.android_brand_mvp.network.patrol;

import com.yd.android_brand_mvp.model.VerifyPeopleBean;
import com.yd.android_brand_mvp.model.patrol.PatrolDetailBean;
import com.yd.android_brand_mvp.model.patrol.PatrolListBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* JADX INFO: compiled from: IPatrolService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J-\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\u00032\b\b\u0001\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/network/patrol/IPatrolService;", "", "requestPatrolDetail", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "Lcom/yd/android_brand_mvp/model/patrol/PatrolDetailBean;", "taskId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestPatrolList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/patrol/PatrolListBean;", "requestBody", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestPatrolPunch", "", "requestScanQrCodeStatus", "Lcom/yd/android_brand_mvp/model/VerifyPeopleBean;", "siteId", "requestSubmitPatrol", "requestUpdatePatrolPunch", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IPatrolService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/app/patrolDayTaskSite/get")
    Object requestPatrolDetail(@Query("id") String str, Continuation<? super BaseResponse<PatrolDetailBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/patrolDayTaskSite/page")
    Object requestPatrolList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<PatrolListBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/patrolDayTaskSite/updateNowClock")
    Object requestPatrolPunch(@Body RequestBody requestBody, Continuation<? super BaseResponse<Boolean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/app/patrolQrCode/getSiteQrCodeStatus")
    Object requestScanQrCodeStatus(@Query("siteId") String str, Continuation<? super BaseResponse<VerifyPeopleBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/patrolDayTaskSite/finishSiteTask")
    Object requestSubmitPatrol(@Body RequestBody requestBody, Continuation<? super BaseResponse<Boolean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/app/patrolDayTaskSite/updateClockIn")
    Object requestUpdatePatrolPunch(@Body RequestBody requestBody, Continuation<? super BaseResponse<Boolean>> continuation);
}
