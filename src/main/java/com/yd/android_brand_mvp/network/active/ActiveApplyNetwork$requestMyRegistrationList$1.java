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
@DebugMetadata(c = "com.yd.android_brand_mvp.network.active.ActiveApplyNetwork", f = "ActiveApplyNetwork.kt", i = {}, l = {22}, m = "requestMyRegistrationList-gIAlu-s", n = {}, s = {})
final class ActiveApplyNetwork$requestMyRegistrationList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ActiveApplyNetwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActiveApplyNetwork$requestMyRegistrationList$1(ActiveApplyNetwork activeApplyNetwork, Continuation<? super ActiveApplyNetwork$requestMyRegistrationList$1> continuation) {
        super(continuation);
        this.this$0 = activeApplyNetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM480requestMyRegistrationListgIAlus = this.this$0.m480requestMyRegistrationListgIAlus(null, this);
        return objM480requestMyRegistrationListgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM480requestMyRegistrationListgIAlus : Result.m590boximpl(objM480requestMyRegistrationListgIAlus);
    }
}
