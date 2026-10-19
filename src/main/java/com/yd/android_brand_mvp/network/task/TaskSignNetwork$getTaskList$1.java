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
@DebugMetadata(c = "com.yd.android_brand_mvp.network.task.TaskSignNetwork", f = "TaskSignNetwork.kt", i = {}, l = {49}, m = "getTaskList-gIAlu-s", n = {}, s = {})
final class TaskSignNetwork$getTaskList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskSignNetwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TaskSignNetwork$getTaskList$1(TaskSignNetwork taskSignNetwork, Continuation<? super TaskSignNetwork$getTaskList$1> continuation) {
        super(continuation);
        this.this$0 = taskSignNetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM538getTaskListgIAlus = this.this$0.m538getTaskListgIAlus(null, this);
        return objM538getTaskListgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM538getTaskListgIAlus : Result.m590boximpl(objM538getTaskListgIAlus);
    }
}
