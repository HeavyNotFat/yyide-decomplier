package com.yd.android_brand_mvp.network.reservation;

import com.yd.android_brand_mvp.model.consult.ConsultTeacherBean;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
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

/* JADX INFO: compiled from: IReservationService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ-\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00120\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/network/reservation/IReservationService;", "", "requestConsultList", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "", "Lcom/yd/android_brand_mvp/model/consult/ConsultTeacherBean;", "requestBody", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestEmployeeDetails", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestReservationOfflineSign", "", "requestReservationRecordDetail", "Lcom/yd/android_brand_mvp/model/reservation/ReservationDetailBean;", "requestReservationRecordList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "requestReservationSign", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IReservationService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/employee/getEmployeeListByLabel")
    Object requestConsultList(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<ConsultTeacherBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/employee/get")
    Object requestEmployeeDetails(@Query("id") String str, Continuation<? super BaseResponse<ConsultTeacherBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/siteBooking/siteBookingBatchSign")
    Object requestReservationOfflineSign(@Body RequestBody requestBody, Continuation<? super BaseResponse<Integer>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/cloud/siteBooking/get")
    Object requestReservationRecordDetail(@Query("id") String str, Continuation<? super BaseResponse<ReservationDetailBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/siteBooking/bookingRecordPage")
    Object requestReservationRecordList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<ReservationRecordBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/siteBooking/siteBookingSign")
    Object requestReservationSign(@Body RequestBody requestBody, Continuation<? super BaseResponse<Boolean>> continuation);
}
