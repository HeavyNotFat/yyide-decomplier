package com.yd.android_brand_mvp.landscape.reserve;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: HomeReservationFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.HomeReservationFragment$setShowReservation$1$1", f = "HomeReservationFragment.kt", i = {0, 0}, l = {196}, m = "emit", n = {"this", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "I$0"})
final class HomeReservationFragment$setShowReservation$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomeReservationFragment.C05061.C01831<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HomeReservationFragment$setShowReservation$1$1$emit$1(HomeReservationFragment.C05061.C01831<? super T> c01831, Continuation<? super HomeReservationFragment$setShowReservation$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c01831;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((String) null, (Continuation<? super Unit>) this);
    }
}
