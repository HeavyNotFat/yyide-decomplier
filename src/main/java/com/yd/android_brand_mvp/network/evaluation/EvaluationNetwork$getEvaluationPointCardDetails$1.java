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
@DebugMetadata(c = "com.yd.android_brand_mvp.network.evaluation.EvaluationNetwork", f = "EvaluationNetwork.kt", i = {}, l = {32}, m = "getEvaluationPointCardDetails-gIAlu-s", n = {}, s = {})
final class EvaluationNetwork$getEvaluationPointCardDetails$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EvaluationNetwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EvaluationNetwork$getEvaluationPointCardDetails$1(EvaluationNetwork evaluationNetwork, Continuation<? super EvaluationNetwork$getEvaluationPointCardDetails$1> continuation) {
        super(continuation);
        this.this$0 = evaluationNetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM502getEvaluationPointCardDetailsgIAlus = this.this$0.m502getEvaluationPointCardDetailsgIAlus(null, this);
        return objM502getEvaluationPointCardDetailsgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM502getEvaluationPointCardDetailsgIAlus : Result.m590boximpl(objM502getEvaluationPointCardDetailsgIAlus);
    }
}
