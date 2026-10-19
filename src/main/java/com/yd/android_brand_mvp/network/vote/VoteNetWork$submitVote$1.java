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
@DebugMetadata(c = "com.yd.android_brand_mvp.network.vote.VoteNetWork", f = "VoteNetWork.kt", i = {}, l = {15}, m = "submitVote-gIAlu-s", n = {}, s = {})
final class VoteNetWork$submitVote$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VoteNetWork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    VoteNetWork$submitVote$1(VoteNetWork voteNetWork, Continuation<? super VoteNetWork$submitVote$1> continuation) {
        super(continuation);
        this.this$0 = voteNetWork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM556submitVotegIAlus = this.this$0.m556submitVotegIAlus(null, this);
        return objM556submitVotegIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM556submitVotegIAlus : Result.m590boximpl(objM556submitVotegIAlus);
    }
}
