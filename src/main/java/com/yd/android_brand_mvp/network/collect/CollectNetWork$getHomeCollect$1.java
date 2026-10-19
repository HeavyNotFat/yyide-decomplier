package com.yd.android_brand_mvp.network.collect;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CollectNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.collect.CollectNetWork", f = "CollectNetWork.kt", i = {}, l = {15}, m = "getHomeCollect-gIAlu-s", n = {}, s = {})
final class CollectNetWork$getHomeCollect$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectNetWork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectNetWork$getHomeCollect$1(CollectNetWork collectNetWork, Continuation<? super CollectNetWork$getHomeCollect$1> continuation) {
        super(continuation);
        this.this$0 = collectNetWork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM489getHomeCollectgIAlus = this.this$0.m489getHomeCollectgIAlus(null, this);
        return objM489getHomeCollectgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM489getHomeCollectgIAlus : Result.m590boximpl(objM489getHomeCollectgIAlus);
    }
}
