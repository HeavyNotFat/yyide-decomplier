package com.yd.android_brand_mvp.network.evaluation;

import com.yd.android_brand_mvp.model.evaluation.EvaluationBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationMedalBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationMedalTypeBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointCardBean;
import com.yd.android_brand_mvp.model.evaluation.EvaluationPointCardCancelBean;
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

/* JADX INFO: compiled from: IEvaluationService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ-\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\f0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ-\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00040\f0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\u0018\u001a\u00020\u0017H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J-\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00040\f0\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/yd/android_brand_mvp/network/evaluation/IEvaluationService;", "", "requestEvaluationList", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationBean;", "requestBody", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestEvaluationMedalDetails", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationMedalBean;", "requestEvaluationMedalPageList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "requestEvaluationMedalTypeList", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationMedalTypeBean;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestEvaluationPointCardDetails", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointCardCancelBean;", "requestEvaluationPointCardPageList", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointCardBean;", "requestEvaluationPointDetails", "Lcom/yd/android_brand_mvp/model/evaluation/EvaluationPointBean;", "personId", "", "identity", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestEvaluationPointPageList", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IEvaluationService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/evalDataCountStatistic/rankListByClass")
    Object requestEvaluationList(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<EvaluationBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/appEvalMedal/getUserMedalInfo")
    Object requestEvaluationMedalDetails(@Body RequestBody requestBody, Continuation<? super BaseResponse<EvaluationMedalBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/appEvalMedal/pageEvalUserMedal")
    Object requestEvaluationMedalPageList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<EvaluationMedalBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/brand/appEvalMedal/listEvalMedalType")
    Object requestEvaluationMedalTypeList(Continuation<? super BaseResponse<List<EvaluationMedalTypeBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/evalScoreCard/getUserScoreCardInfo")
    Object requestEvaluationPointCardDetails(@Body RequestBody requestBody, Continuation<? super BaseResponse<EvaluationPointCardCancelBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/evalScoreCard/pageUserScoreCard")
    Object requestEvaluationPointCardPageList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<EvaluationPointCardBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @GET("/brand/evalPersonScore/getEvalPersonScoreInfo")
    Object requestEvaluationPointDetails(@Query("personId") String str, @Query("identity") String str2, Continuation<? super BaseResponse<EvaluationPointBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/brand/evalScoreRecord/page")
    Object requestEvaluationPointPageList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<EvaluationPointBean>>>> continuation);
}
