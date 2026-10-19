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
@DebugMetadata(c = "com.yd.android_brand_mvp.network.NetworkApi", f = "NetworkApi.kt", i = {}, l = {89}, m = "getBrandInfo-gIAlu-s", n = {}, s = {})
final class NetworkApi$getBrandInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetworkApi$getBrandInfo$1(NetworkApi networkApi, Continuation<? super NetworkApi$getBrandInfo$1> continuation) {
        super(continuation);
        this.this$0 = networkApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM421getBrandInfogIAlus = this.this$0.m421getBrandInfogIAlus(null, this);
        return objM421getBrandInfogIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM421getBrandInfogIAlus : Result.m590boximpl(objM421getBrandInfogIAlus);
    }
}
