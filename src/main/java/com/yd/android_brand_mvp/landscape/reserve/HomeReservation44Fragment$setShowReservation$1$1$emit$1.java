package com.yd.android_brand_mvp.landscape.reserve;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.smtt.sdk.TbsListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: HomeReservation44Fragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.landscape.reserve.HomeReservation44Fragment$setShowReservation$1$1", f = "HomeReservation44Fragment.kt", i = {0, 0}, l = {TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID}, m = "emit", n = {"this", FirebaseAnalytics.Param.INDEX}, s = {"L$0", "I$0"})
final class HomeReservation44Fragment$setShowReservation$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HomeReservation44Fragment.C05051.C01821<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    HomeReservation44Fragment$setShowReservation$1$1$emit$1(HomeReservation44Fragment.C05051.C01821<? super T> c01821, Continuation<? super HomeReservation44Fragment$setShowReservation$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c01821;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((String) null, (Continuation<? super Unit>) this);
    }
}
