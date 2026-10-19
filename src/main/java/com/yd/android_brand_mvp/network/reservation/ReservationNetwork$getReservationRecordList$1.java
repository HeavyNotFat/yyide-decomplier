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
@DebugMetadata(c = "com.yd.android_brand_mvp.network.reservation.ReservationNetwork", f = "ReservationNetwork.kt", i = {}, l = {15}, m = "getReservationRecordList-gIAlu-s", n = {}, s = {})
final class ReservationNetwork$getReservationRecordList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReservationNetwork this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReservationNetwork$getReservationRecordList$1(ReservationNetwork reservationNetwork, Continuation<? super ReservationNetwork$getReservationRecordList$1> continuation) {
        super(continuation);
        this.this$0 = reservationNetwork;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM529getReservationRecordListgIAlus = this.this$0.m529getReservationRecordListgIAlus(null, this);
        return objM529getReservationRecordListgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM529getReservationRecordListgIAlus : Result.m590boximpl(objM529getReservationRecordListgIAlus);
    }
}
