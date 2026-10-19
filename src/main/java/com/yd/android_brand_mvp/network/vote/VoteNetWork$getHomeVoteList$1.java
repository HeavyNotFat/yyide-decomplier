package com.yd.android_brand_mvp.network.vote;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: VoteNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.vote.VoteNetWork", f = "VoteNetWork.kt", i = {}, l = {23}, m = "getHomeVoteList-gIAlu-s", n = {}, s = {})
final class VoteNetWork$getHomeVoteList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoteNetWork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VoteNetWork$getHomeVoteList$1(VoteNetWork voteNetWork, Continuation<? super VoteNetWork$getHomeVoteList$1> continuation) {
        super(continuation);
        this.this$0 = voteNetWork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM554getHomeVoteListgIAlus = this.this$0.m554getHomeVoteListgIAlus(null, this);
        return objM554getHomeVoteListgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM554getHomeVoteListgIAlus : Result.m590boximpl(objM554getHomeVoteListgIAlus);
    }
}
