package com.yd.android_brand_mvp.network.active;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ActiveApplyNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.active.ActiveApplyNetwork", f = "ActiveApplyNetwork.kt", i = {}, l = {30}, m = "requestActiveRegistration-gIAlu-s", n = {}, s = {})
final class ActiveApplyNetwork$requestActiveRegistration$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ActiveApplyNetwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActiveApplyNetwork$requestActiveRegistration$1(ActiveApplyNetwork activeApplyNetwork, Continuation<? super ActiveApplyNetwork$requestActiveRegistration$1> continuation) {
        super(continuation);
        this.this$0 = activeApplyNetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM478requestActiveRegistrationgIAlus = this.this$0.m478requestActiveRegistrationgIAlus(null, this);
        return objM478requestActiveRegistrationgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM478requestActiveRegistrationgIAlus : Result.m590boximpl(objM478requestActiveRegistrationgIAlus);
    }
}
