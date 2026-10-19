package com.yd.android_brand_mvp.network.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: TaskSignNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.task.TaskSignNetwork", f = "TaskSignNetwork.kt", i = {}, l = {39}, m = "updateTask-gIAlu-s", n = {}, s = {})
final class TaskSignNetwork$updateTask$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskSignNetwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TaskSignNetwork$updateTask$1(TaskSignNetwork taskSignNetwork, Continuation<? super TaskSignNetwork$updateTask$1> continuation) {
        super(continuation);
        this.this$0 = taskSignNetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM540updateTaskgIAlus = this.this$0.m540updateTaskgIAlus(null, this);
        return objM540updateTaskgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM540updateTaskgIAlus : Result.m590boximpl(objM540updateTaskgIAlus);
    }
}
