package com.yd.android_brand_mvp.network.patrol;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: PatrolNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.patrol.PatrolNetWork", f = "PatrolNetWork.kt", i = {}, l = {38}, m = "getPatrolDetail-gIAlu-s", n = {}, s = {})
final class PatrolNetWork$getPatrolDetail$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PatrolNetWork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PatrolNetWork$getPatrolDetail$1(PatrolNetWork patrolNetWork, Continuation<? super PatrolNetWork$getPatrolDetail$1> continuation) {
        super(continuation);
        this.this$0 = patrolNetWork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM520getPatrolDetailgIAlus = this.this$0.m520getPatrolDetailgIAlus(null, this);
        return objM520getPatrolDetailgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM520getPatrolDetailgIAlus : Result.m590boximpl(objM520getPatrolDetailgIAlus);
    }
}
