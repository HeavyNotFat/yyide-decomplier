package com.yd.android_brand_mvp.network.base;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: BaseNetworkApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.base.BaseNetworkApi", f = "BaseNetworkApi.kt", i = {}, l = {76}, m = "getResult-gIAlu-s", n = {}, s = {})
final class BaseNetworkApi$getResult$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BaseNetworkApi<I> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseNetworkApi$getResult$1(BaseNetworkApi<I> baseNetworkApi, Continuation<? super BaseNetworkApi$getResult$1> continuation) {
        super(continuation);
        this.this$0 = baseNetworkApi;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM485getResultgIAlus = this.this$0.m485getResultgIAlus(null, this);
        return objM485getResultgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM485getResultgIAlus : Result.m590boximpl(objM485getResultgIAlus);
    }
}
