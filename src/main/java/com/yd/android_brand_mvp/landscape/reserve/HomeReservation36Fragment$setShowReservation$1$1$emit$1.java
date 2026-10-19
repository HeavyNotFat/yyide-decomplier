package com.yd.android_brand_mvp.landscape.reserve;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: HomeReservation36Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.HomeReservation36Fragment$setShowReservation$1$1", f = "HomeReservation36Fragment.kt", i = {0, 0}, l = {152}, m = "emit", n = {"this", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "I$0"})
final class HomeReservation36Fragment$setShowReservation$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomeReservation36Fragment.C05041.C01811<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HomeReservation36Fragment$setShowReservation$1$1$emit$1(HomeReservation36Fragment.C05041.C01811<? super T> c01811, Continuation<? super HomeReservation36Fragment$setShowReservation$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c01811;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((String) null, (Continuation<? super Unit>) this);
    }
}
