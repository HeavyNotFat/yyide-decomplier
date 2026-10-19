package com.yd.android_brand_mvp.network.exam;

import com.yd.android_brand_mvp.model.BrandConfigBean;
import com.yd.android_brand_mvp.model.exam.ExamArrangementBean;
import com.yd.android_brand_mvp.model.exam.ExamPersonSeatBean;
import com.yd.android_brand_mvp.model.exam.ExamPlanItem;
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

/* JADX INFO: compiled from: IExamManageService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ'\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ'\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ'\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u000e0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\fJ'\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u000e0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/yd/android_brand_mvp/network/exam/IExamManageService;", "", "requestDeviceConfig", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "Lcom/yd/android_brand_mvp/model/BrandConfigBean;", "deviceNo", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestExamDetail", "Lcom/yd/android_brand_mvp/model/exam/ExamPlanItem;", "requestBody", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestExamPersonSeat", "", "Lcom/yd/android_brand_mvp/model/exam/ExamPersonSeatBean;", "requestSignExam", "", "requestTodayExam", "requestUserExamList", "requestWeekExam", "Lcom/yd/android_brand_mvp/model/exam/ExamArrangementBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IExamManageService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/manage/machineInfo/getMachineConfigByDeviceNo")
    Object requestDeviceConfig(@Query("deviceNo") String str, Continuation<? super BaseResponse<BrandConfigBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/exam/detail")
    Object requestExamDetail(@Body RequestBody requestBody, Continuation<? super BaseResponse<ExamPlanItem>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/exam/person")
    Object requestExamPersonSeat(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<ExamPersonSeatBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/exam/student/sing/in")
    Object requestSignExam(@Body RequestBody requestBody, Continuation<? super BaseResponse<Boolean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/exam/recent")
    Object requestTodayExam(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<ExamPlanItem>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/exam/by/student")
    Object requestUserExamList(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<ExamPlanItem>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/exam/plan/week")
    Object requestWeekExam(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<ExamArrangementBean>>> continuation);
}
