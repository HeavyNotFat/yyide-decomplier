package com.yd.android_brand_mvp.activity.home.viewmodel;

import com.yd.android_brand_mvp.db.reservation.ReservationSignBean;
import com.yd.android_brand_mvp.repository.ReservationDaoRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HomeViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/yd/android_brand_mvp/db/reservation/ReservationSignBean;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.yd.android_brand_mvp.activity.home.viewmodel.HomeViewModel$getNotUploadReservationSignData$1$uploadSignList$1", f = "HomeViewModel.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
final class HomeViewModel$getNotUploadReservationSignData$1$uploadSignList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends ReservationSignBean>>, Object> {
    int label;

    HomeViewModel$getNotUploadReservationSignData$1$uploadSignList$1(Continuation<? super HomeViewModel$getNotUploadReservationSignData$1$uploadSignList$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HomeViewModel$getNotUploadReservationSignData$1$uploadSignList$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends ReservationSignBean>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super List<ReservationSignBean>>) continuation);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super List<ReservationSignBean>> continuation) {
        return ((HomeViewModel$getNotUploadReservationSignData$1$uploadSignList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ReservationDaoRepository.INSTANCE.getAllSignData(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
