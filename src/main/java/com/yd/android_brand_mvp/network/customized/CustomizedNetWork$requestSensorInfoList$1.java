package com.yd.android_brand_mvp.network.customized;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: CustomizedNetWork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.customized.CustomizedNetWork", f = "CustomizedNetWork.kt", i = {}, l = {23}, m = "requestSensorInfoList-gIAlu-s", n = {}, s = {})
final class CustomizedNetWork$requestSensorInfoList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CustomizedNetWork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomizedNetWork$requestSensorInfoList$1(CustomizedNetWork customizedNetWork, Continuation<? super CustomizedNetWork$requestSensorInfoList$1> continuation) {
        super(continuation);
        this.this$0 = customizedNetWork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM493requestSensorInfoListgIAlus = this.this$0.m493requestSensorInfoListgIAlus(null, this);
        return objM493requestSensorInfoListgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM493requestSensorInfoListgIAlus : Result.m590boximpl(objM493requestSensorInfoListgIAlus);
    }
}
