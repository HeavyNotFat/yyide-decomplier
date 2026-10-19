package com.yd.android_brand_mvp.network.vote;

import com.yd.android_brand_mvp.model.vote.VoteDetailBean;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: VoteNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J6\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u00052\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJ*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000e\u0010\fJ*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\f\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/yd/android_brand_mvp/network/vote/VoteNetWork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/vote/IVoteService;", "()V", "getHomeVoteList", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/vote/VoteDetailBean;", "requestBody", "Lokhttp3/RequestBody;", "getHomeVoteList-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVoteDetail", "getVoteDetail-gIAlu-s", "submitVote", "", "submitVote-gIAlu-s", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VoteNetWork extends BaseNetworkApi<IVoteService> {
    public static final VoteNetWork INSTANCE = new VoteNetWork();

    private VoteNetWork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: submitVote-gIAlu-s, reason: not valid java name */
    public final Object m556submitVotegIAlus(RequestBody requestBody, Continuation<? super Result<Boolean>> continuation) {
        VoteNetWork$submitVote$1 voteNetWork$submitVote$1;
        if (continuation instanceof VoteNetWork$submitVote$1) {
            voteNetWork$submitVote$1 = (VoteNetWork$submitVote$1) continuation;
            if ((voteNetWork$submitVote$1.label & Integer.MIN_VALUE) != 0) {
                voteNetWork$submitVote$1.label -= Integer.MIN_VALUE;
            } else {
                voteNetWork$submitVote$1 = new VoteNetWork$submitVote$1(this, continuation);
            }
        } else {
            voteNetWork$submitVote$1 = new VoteNetWork$submitVote$1(this, continuation);
        }
        Object obj = voteNetWork$submitVote$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = voteNetWork$submitVote$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        VoteNetWork$submitVote$2 voteNetWork$submitVote$2 = new VoteNetWork$submitVote$2(requestBody, null);
        voteNetWork$submitVote$1.label = 1;
        Object obj2 = m485getResultgIAlus(voteNetWork$submitVote$2, voteNetWork$submitVote$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getVoteDetail-gIAlu-s, reason: not valid java name */
    public final Object m555getVoteDetailgIAlus(RequestBody requestBody, Continuation<? super Result<VoteDetailBean>> continuation) {
        VoteNetWork$getVoteDetail$1 voteNetWork$getVoteDetail$1;
        if (continuation instanceof VoteNetWork$getVoteDetail$1) {
            voteNetWork$getVoteDetail$1 = (VoteNetWork$getVoteDetail$1) continuation;
            if ((voteNetWork$getVoteDetail$1.label & Integer.MIN_VALUE) != 0) {
                voteNetWork$getVoteDetail$1.label -= Integer.MIN_VALUE;
            } else {
                voteNetWork$getVoteDetail$1 = new VoteNetWork$getVoteDetail$1(this, continuation);
            }
        } else {
            voteNetWork$getVoteDetail$1 = new VoteNetWork$getVoteDetail$1(this, continuation);
        }
        Object obj = voteNetWork$getVoteDetail$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = voteNetWork$getVoteDetail$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        VoteNetWork$getVoteDetail$2 voteNetWork$getVoteDetail$2 = new VoteNetWork$getVoteDetail$2(requestBody, null);
        voteNetWork$getVoteDetail$1.label = 1;
        Object obj2 = m485getResultgIAlus(voteNetWork$getVoteDetail$2, voteNetWork$getVoteDetail$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getHomeVoteList-gIAlu-s, reason: not valid java name */
    public final Object m554getHomeVoteListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<VoteDetailBean>>>> continuation) {
        VoteNetWork$getHomeVoteList$1 voteNetWork$getHomeVoteList$1;
        if (continuation instanceof VoteNetWork$getHomeVoteList$1) {
            voteNetWork$getHomeVoteList$1 = (VoteNetWork$getHomeVoteList$1) continuation;
            if ((voteNetWork$getHomeVoteList$1.label & Integer.MIN_VALUE) != 0) {
                voteNetWork$getHomeVoteList$1.label -= Integer.MIN_VALUE;
            } else {
                voteNetWork$getHomeVoteList$1 = new VoteNetWork$getHomeVoteList$1(this, continuation);
            }
        } else {
            voteNetWork$getHomeVoteList$1 = new VoteNetWork$getHomeVoteList$1(this, continuation);
        }
        Object obj = voteNetWork$getHomeVoteList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = voteNetWork$getHomeVoteList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        VoteNetWork$getHomeVoteList$2 voteNetWork$getHomeVoteList$2 = new VoteNetWork$getHomeVoteList$2(requestBody, null);
        voteNetWork$getHomeVoteList$1.label = 1;
        Object obj2 = m485getResultgIAlus(voteNetWork$getHomeVoteList$2, voteNetWork$getHomeVoteList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
