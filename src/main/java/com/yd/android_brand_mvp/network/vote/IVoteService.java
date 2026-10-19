package com.yd.android_brand_mvp.network.vote;

import com.yd.android_brand_mvp.model.vote.VoteDetailBean;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import com.yd.android_brand_mvp.network.base.BaseResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/* JADX INFO: compiled from: IVoteService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/yd/android_brand_mvp/network/vote/IVoteService;", "", "requestHomeVoteList", "Lcom/yd/android_brand_mvp/network/base/BaseResponse;", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/vote/VoteDetailBean;", "requestBody", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestSubmitVote", "", "requestVoteDetail", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IVoteService {
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/vote/page")
    Object requestHomeVoteList(@Body RequestBody requestBody, Continuation<? super BaseResponse<BasePageResponse<List<VoteDetailBean>>>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/vote/clickVote")
    Object requestSubmitVote(@Body RequestBody requestBody, Continuation<? super BaseResponse<Boolean>> continuation);

    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @POST("/cloud/vote/get")
    Object requestVoteDetail(@Body RequestBody requestBody, Continuation<? super BaseResponse<VoteDetailBean>> continuation);
}
