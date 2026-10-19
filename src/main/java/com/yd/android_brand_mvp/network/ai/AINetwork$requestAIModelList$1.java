package com.yd.android_brand_mvp.network.ai;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: AINetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.ai.AINetwork", f = "AINetwork.kt", i = {}, l = {18}, m = "requestAIModelList-gIAlu-s", n = {}, s = {})
final class AINetwork$requestAIModelList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AINetwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AINetwork$requestAIModelList$1(AINetwork aINetwork, Continuation<? super AINetwork$requestAIModelList$1> continuation) {
        super(continuation);
        this.this$0 = aINetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM484requestAIModelListgIAlus = this.this$0.m484requestAIModelListgIAlus(null, this);
        return objM484requestAIModelListgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM484requestAIModelListgIAlus : Result.m590boximpl(objM484requestAIModelListgIAlus);
    }
}
