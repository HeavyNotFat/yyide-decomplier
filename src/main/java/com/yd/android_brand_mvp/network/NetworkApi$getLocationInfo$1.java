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
@DebugMetadata(c = "com.yd.android_brand_mvp.network.NetworkApi", f = "NetworkApi.kt", i = {}, l = {352}, m = "getLocationInfo-IoAF18A", n = {}, s = {})
final class NetworkApi$getLocationInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NetworkApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NetworkApi$getLocationInfo$1(NetworkApi networkApi, Continuation<? super NetworkApi$getLocationInfo$1> continuation) {
        super(continuation);
        this.this$0 = networkApi;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM432getLocationInfoIoAF18A = this.this$0.m432getLocationInfoIoAF18A(this);
        return objM432getLocationInfoIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM432getLocationInfoIoAF18A : Result.m590boximpl(objM432getLocationInfoIoAF18A);
    }
}
