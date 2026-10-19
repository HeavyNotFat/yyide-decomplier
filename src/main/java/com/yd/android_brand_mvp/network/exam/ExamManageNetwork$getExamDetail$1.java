package com.yd.android_brand_mvp.network.exam;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ExamManageNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.exam.ExamManageNetwork", f = "ExamManageNetwork.kt", i = {}, l = {28}, m = "getExamDetail-gIAlu-s", n = {}, s = {})
final class ExamManageNetwork$getExamDetail$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExamManageNetwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExamManageNetwork$getExamDetail$1(ExamManageNetwork examManageNetwork, Continuation<? super ExamManageNetwork$getExamDetail$1> continuation) {
        super(continuation);
        this.this$0 = examManageNetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM506getExamDetailgIAlus = this.this$0.m506getExamDetailgIAlus(null, this);
        return objM506getExamDetailgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM506getExamDetailgIAlus : Result.m590boximpl(objM506getExamDetailgIAlus);
    }
}
