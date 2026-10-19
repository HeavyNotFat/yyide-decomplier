package com.yd.android_brand_mvp.network.evaluation;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: EvaluationNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.evaluation.EvaluationNetwork", f = "EvaluationNetwork.kt", i = {}, l = {20}, m = "getEvaluationMedalList-gIAlu-s", n = {}, s = {})
final class EvaluationNetwork$getEvaluationMedalList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EvaluationNetwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EvaluationNetwork$getEvaluationMedalList$1(EvaluationNetwork evaluationNetwork, Continuation<? super EvaluationNetwork$getEvaluationMedalList$1> continuation) {
        super(continuation);
        this.this$0 = evaluationNetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM500getEvaluationMedalListgIAlus = this.this$0.m500getEvaluationMedalListgIAlus(null, this);
        return objM500getEvaluationMedalListgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM500getEvaluationMedalListgIAlus : Result.m590boximpl(objM500getEvaluationMedalListgIAlus);
    }
}
