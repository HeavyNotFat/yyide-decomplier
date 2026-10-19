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
@DebugMetadata(c = "com.yd.android_brand_mvp.network.ai.AINetwork", f = "AINetwork.kt", i = {}, l = {26}, m = "requestAIGetInfo-gIAlu-s", n = {}, s = {})
final class AINetwork$requestAIGetInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AINetwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AINetwork$requestAIGetInfo$1(AINetwork aINetwork, Continuation<? super AINetwork$requestAIGetInfo$1> continuation) {
        super(continuation);
        this.this$0 = aINetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM482requestAIGetInfogIAlus = this.this$0.m482requestAIGetInfogIAlus(null, this);
        return objM482requestAIGetInfogIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM482requestAIGetInfogIAlus : Result.m590boximpl(objM482requestAIGetInfogIAlus);
    }
}
