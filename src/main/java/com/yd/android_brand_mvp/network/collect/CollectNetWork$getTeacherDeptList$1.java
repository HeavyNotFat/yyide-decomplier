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
@DebugMetadata(c = "com.yd.android_brand_mvp.network.collect.CollectNetWork", f = "CollectNetWork.kt", i = {}, l = {35}, m = "getTeacherDeptList-0E7RQCE", n = {}, s = {})
final class CollectNetWork$getTeacherDeptList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CollectNetWork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CollectNetWork$getTeacherDeptList$1(CollectNetWork collectNetWork, Continuation<? super CollectNetWork$getTeacherDeptList$1> continuation) {
        super(continuation);
        this.this$0 = collectNetWork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM491getTeacherDeptList0E7RQCE = this.this$0.m491getTeacherDeptList0E7RQCE(null, null, this);
        return objM491getTeacherDeptList0E7RQCE == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM491getTeacherDeptList0E7RQCE : Result.m590boximpl(objM491getTeacherDeptList0E7RQCE);
    }
}
