package com.yd.android_brand_mvp.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: NetworkApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.NetworkApi", f = "NetworkApi.kt", i = {}, l = {216}, m = "requestActiveDetail-gIAlu-s", n = {}, s = {})
final class NetworkApi$requestActiveDetail$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetworkApi$requestActiveDetail$1(NetworkApi networkApi, Continuation<? super NetworkApi$requestActiveDetail$1> continuation) {
        super(continuation);
        this.this$0 = networkApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM441requestActiveDetailgIAlus = this.this$0.m441requestActiveDetailgIAlus(null, this);
        return objM441requestActiveDetailgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM441requestActiveDetailgIAlus : Result.m590boximpl(objM441requestActiveDetailgIAlus);
    }
}
