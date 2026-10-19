package com.yd.android_brand_mvp.network.reservation;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ReservationNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.network.reservation.ReservationNetwork", f = "ReservationNetwork.kt", i = {}, l = {31}, m = "getConsultTeacherList-gIAlu-s", n = {}, s = {})
final class ReservationNetwork$getConsultTeacherList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReservationNetwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReservationNetwork$getConsultTeacherList$1(ReservationNetwork reservationNetwork, Continuation<? super ReservationNetwork$getConsultTeacherList$1> continuation) {
        super(continuation);
        this.this$0 = reservationNetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM527getConsultTeacherListgIAlus = this.this$0.m527getConsultTeacherListgIAlus(null, this);
        return objM527getConsultTeacherListgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM527getConsultTeacherListgIAlus : Result.m590boximpl(objM527getConsultTeacherListgIAlus);
    }
}
