package com.yd.android_brand_mvp.activity.common.viewmodel;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: VerifyViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.activity.common.viewmodel.VerifyViewModel$startRequestQrCodeResult$2$3", f = "VerifyViewModel.kt", i = {}, l = {105}, m = "emit", n = {}, s = {})
final class VerifyViewModel$startRequestQrCodeResult$2$3$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ VerifyViewModel.AnonymousClass2.AnonymousClass3<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    VerifyViewModel$startRequestQrCodeResult$2$3$emit$1(VerifyViewModel.AnonymousClass2.AnonymousClass3<? super T> anonymousClass3, Continuation<? super VerifyViewModel$startRequestQrCodeResult$2$3$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass3;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((String) null, (Continuation<? super Unit>) this);
    }
}
