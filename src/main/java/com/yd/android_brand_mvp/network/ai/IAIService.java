package com.yd.android_brand_mvp.network.ai;

import com.yd.android_brand_mvp.model.ai.AICreateSessionBean;
import com.yd.android_brand_mvp.model.ai.AIIntellectHomeBean;
import com.yd.android_brand_mvp.model.ai.AIModelBean;
import com.yd.android_brand_mvp.model.ai.AIProblemBean;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* JADX INFO: compiled from: IAIService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J'\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J'\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u000b0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/yd/android_brand_mvp/network/ai/IAIService;", "", "requestAICreateSession", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "Lcom/yd/android_brand_mvp/model/ai/AICreateSessionBean;", "requestBody", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestAIGetInfo", "Lcom/yd/android_brand_mvp/model/ai/AIProblemBean;", "requestAIHomeList", "", "Lcom/yd/android_brand_mvp/model/ai/AIIntellectHomeBean;", "requestAIModelList", "Lcom/yd/android_brand_mvp/model/ai/AIModelBean;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IAIService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/ai/chat/session/create")
    Object requestAICreateSession(@Body RequestBody requestBody, Continuation<? super BaseResponse<AICreateSessionBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/ai/assistant/get")
    Object requestAIGetInfo(@Body RequestBody requestBody, Continuation<? super BaseResponse<AIProblemBean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/ai/assistant/public/list")
    Object requestAIHomeList(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<AIIntellectHomeBean>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/ai/chat/models")
    Object requestAIModelList(@Body RequestBody requestBody, Continuation<? super BaseResponse<List<AIModelBean>>> continuation);
}
