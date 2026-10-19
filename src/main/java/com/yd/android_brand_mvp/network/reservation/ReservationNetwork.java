package com.yd.android_brand_mvp.network.reservation;

import com.yd.android_brand_mvp.model.consult.ConsultTeacherBean;
import com.yd.android_brand_mvp.model.reservation.ReservationDetailBean;
import com.yd.android_brand_mvp.model.reservation.ReservationRecordBean;
import com.yd.android_brand_mvp.network.base.BaseNetworkApi;
import com.yd.android_brand_mvp.network.base.BasePageResponse;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: ReservationNetwork.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ0\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\f0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u000f\u0010\u0010J*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\nJ6\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00150\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0018\u0010\u0010J*\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\u0010J*\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0086@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u001e\u0010\u0010\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/yd/android_brand_mvp/network/reservation/ReservationNetwork;", "Lcom/yd/android_brand_mvp/network/base/BaseNetworkApi;", "Lcom/yd/android_brand_mvp/network/reservation/IReservationService;", "()V", "getConsultTeacherDetails", "Lkotlin/Result;", "Lcom/yd/android_brand_mvp/model/consult/ConsultTeacherBean;", "id", "", "getConsultTeacherDetails-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConsultTeacherList", "", "requestBody", "Lokhttp3/RequestBody;", "getConsultTeacherList-gIAlu-s", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getReservationDetail", "Lcom/yd/android_brand_mvp/model/reservation/ReservationDetailBean;", "getReservationDetail-gIAlu-s", "getReservationRecordList", "Lcom/yd/android_brand_mvp/network/base/BasePageResponse;", "", "Lcom/yd/android_brand_mvp/model/reservation/ReservationRecordBean;", "getReservationRecordList-gIAlu-s", "offlineSignInReservation", "", "offlineSignInReservation-gIAlu-s", "signInReservation", "", "signInReservation-gIAlu-s", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReservationNetwork extends BaseNetworkApi<IReservationService> {
    public static final ReservationNetwork INSTANCE = new ReservationNetwork();

    private ReservationNetwork() {
        super("https://api.yyide.com");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getReservationRecordList-gIAlu-s, reason: not valid java name */
    public final Object m529getReservationRecordListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends BasePageResponse<List<ReservationRecordBean>>>> continuation) {
        ReservationNetwork$getReservationRecordList$1 reservationNetwork$getReservationRecordList$1;
        if (continuation instanceof ReservationNetwork$getReservationRecordList$1) {
            reservationNetwork$getReservationRecordList$1 = (ReservationNetwork$getReservationRecordList$1) continuation;
            if ((reservationNetwork$getReservationRecordList$1.label & Integer.MIN_VALUE) != 0) {
                reservationNetwork$getReservationRecordList$1.label -= Integer.MIN_VALUE;
            } else {
                reservationNetwork$getReservationRecordList$1 = new ReservationNetwork$getReservationRecordList$1(this, continuation);
            }
        } else {
            reservationNetwork$getReservationRecordList$1 = new ReservationNetwork$getReservationRecordList$1(this, continuation);
        }
        Object obj = reservationNetwork$getReservationRecordList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = reservationNetwork$getReservationRecordList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ReservationNetwork$getReservationRecordList$2 reservationNetwork$getReservationRecordList$2 = new ReservationNetwork$getReservationRecordList$2(requestBody, null);
        reservationNetwork$getReservationRecordList$1.label = 1;
        Object obj2 = m485getResultgIAlus(reservationNetwork$getReservationRecordList$2, reservationNetwork$getReservationRecordList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getReservationDetail-gIAlu-s, reason: not valid java name */
    public final Object m528getReservationDetailgIAlus(String str, Continuation<? super Result<ReservationDetailBean>> continuation) {
        ReservationNetwork$getReservationDetail$1 reservationNetwork$getReservationDetail$1;
        if (continuation instanceof ReservationNetwork$getReservationDetail$1) {
            reservationNetwork$getReservationDetail$1 = (ReservationNetwork$getReservationDetail$1) continuation;
            if ((reservationNetwork$getReservationDetail$1.label & Integer.MIN_VALUE) != 0) {
                reservationNetwork$getReservationDetail$1.label -= Integer.MIN_VALUE;
            } else {
                reservationNetwork$getReservationDetail$1 = new ReservationNetwork$getReservationDetail$1(this, continuation);
            }
        } else {
            reservationNetwork$getReservationDetail$1 = new ReservationNetwork$getReservationDetail$1(this, continuation);
        }
        Object obj = reservationNetwork$getReservationDetail$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = reservationNetwork$getReservationDetail$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ReservationNetwork$getReservationDetail$2 reservationNetwork$getReservationDetail$2 = new ReservationNetwork$getReservationDetail$2(str, null);
        reservationNetwork$getReservationDetail$1.label = 1;
        Object obj2 = m485getResultgIAlus(reservationNetwork$getReservationDetail$2, reservationNetwork$getReservationDetail$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: signInReservation-gIAlu-s, reason: not valid java name */
    public final Object m531signInReservationgIAlus(RequestBody requestBody, Continuation<? super Result<Boolean>> continuation) {
        ReservationNetwork$signInReservation$1 reservationNetwork$signInReservation$1;
        if (continuation instanceof ReservationNetwork$signInReservation$1) {
            reservationNetwork$signInReservation$1 = (ReservationNetwork$signInReservation$1) continuation;
            if ((reservationNetwork$signInReservation$1.label & Integer.MIN_VALUE) != 0) {
                reservationNetwork$signInReservation$1.label -= Integer.MIN_VALUE;
            } else {
                reservationNetwork$signInReservation$1 = new ReservationNetwork$signInReservation$1(this, continuation);
            }
        } else {
            reservationNetwork$signInReservation$1 = new ReservationNetwork$signInReservation$1(this, continuation);
        }
        Object obj = reservationNetwork$signInReservation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = reservationNetwork$signInReservation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ReservationNetwork$signInReservation$2 reservationNetwork$signInReservation$2 = new ReservationNetwork$signInReservation$2(requestBody, null);
        reservationNetwork$signInReservation$1.label = 1;
        Object obj2 = m485getResultgIAlus(reservationNetwork$signInReservation$2, reservationNetwork$signInReservation$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: offlineSignInReservation-gIAlu-s, reason: not valid java name */
    public final Object m530offlineSignInReservationgIAlus(RequestBody requestBody, Continuation<? super Result<Integer>> continuation) {
        ReservationNetwork$offlineSignInReservation$1 reservationNetwork$offlineSignInReservation$1;
        if (continuation instanceof ReservationNetwork$offlineSignInReservation$1) {
            reservationNetwork$offlineSignInReservation$1 = (ReservationNetwork$offlineSignInReservation$1) continuation;
            if ((reservationNetwork$offlineSignInReservation$1.label & Integer.MIN_VALUE) != 0) {
                reservationNetwork$offlineSignInReservation$1.label -= Integer.MIN_VALUE;
            } else {
                reservationNetwork$offlineSignInReservation$1 = new ReservationNetwork$offlineSignInReservation$1(this, continuation);
            }
        } else {
            reservationNetwork$offlineSignInReservation$1 = new ReservationNetwork$offlineSignInReservation$1(this, continuation);
        }
        Object obj = reservationNetwork$offlineSignInReservation$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = reservationNetwork$offlineSignInReservation$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ReservationNetwork$offlineSignInReservation$2 reservationNetwork$offlineSignInReservation$2 = new ReservationNetwork$offlineSignInReservation$2(requestBody, null);
        reservationNetwork$offlineSignInReservation$1.label = 1;
        Object obj2 = m485getResultgIAlus(reservationNetwork$offlineSignInReservation$2, reservationNetwork$offlineSignInReservation$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getConsultTeacherList-gIAlu-s, reason: not valid java name */
    public final Object m527getConsultTeacherListgIAlus(RequestBody requestBody, Continuation<? super Result<? extends List<ConsultTeacherBean>>> continuation) {
        ReservationNetwork$getConsultTeacherList$1 reservationNetwork$getConsultTeacherList$1;
        if (continuation instanceof ReservationNetwork$getConsultTeacherList$1) {
            reservationNetwork$getConsultTeacherList$1 = (ReservationNetwork$getConsultTeacherList$1) continuation;
            if ((reservationNetwork$getConsultTeacherList$1.label & Integer.MIN_VALUE) != 0) {
                reservationNetwork$getConsultTeacherList$1.label -= Integer.MIN_VALUE;
            } else {
                reservationNetwork$getConsultTeacherList$1 = new ReservationNetwork$getConsultTeacherList$1(this, continuation);
            }
        } else {
            reservationNetwork$getConsultTeacherList$1 = new ReservationNetwork$getConsultTeacherList$1(this, continuation);
        }
        Object obj = reservationNetwork$getConsultTeacherList$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = reservationNetwork$getConsultTeacherList$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ReservationNetwork$getConsultTeacherList$2 reservationNetwork$getConsultTeacherList$2 = new ReservationNetwork$getConsultTeacherList$2(requestBody, null);
        reservationNetwork$getConsultTeacherList$1.label = 1;
        Object obj2 = m485getResultgIAlus(reservationNetwork$getConsultTeacherList$2, reservationNetwork$getConsultTeacherList$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX INFO: renamed from: getConsultTeacherDetails-gIAlu-s, reason: not valid java name */
    public final Object m526getConsultTeacherDetailsgIAlus(String str, Continuation<? super Result<ConsultTeacherBean>> continuation) {
        ReservationNetwork$getConsultTeacherDetails$1 reservationNetwork$getConsultTeacherDetails$1;
        if (continuation instanceof ReservationNetwork$getConsultTeacherDetails$1) {
            reservationNetwork$getConsultTeacherDetails$1 = (ReservationNetwork$getConsultTeacherDetails$1) continuation;
            if ((reservationNetwork$getConsultTeacherDetails$1.label & Integer.MIN_VALUE) != 0) {
                reservationNetwork$getConsultTeacherDetails$1.label -= Integer.MIN_VALUE;
            } else {
                reservationNetwork$getConsultTeacherDetails$1 = new ReservationNetwork$getConsultTeacherDetails$1(this, continuation);
            }
        } else {
            reservationNetwork$getConsultTeacherDetails$1 = new ReservationNetwork$getConsultTeacherDetails$1(this, continuation);
        }
        Object obj = reservationNetwork$getConsultTeacherDetails$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = reservationNetwork$getConsultTeacherDetails$1.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((Result) obj).getValue();
        }
        ResultKt.throwOnFailure(obj);
        ReservationNetwork$getConsultTeacherDetails$2 reservationNetwork$getConsultTeacherDetails$2 = new ReservationNetwork$getConsultTeacherDetails$2(str, null);
        reservationNetwork$getConsultTeacherDetails$1.label = 1;
        Object obj2 = m485getResultgIAlus(reservationNetwork$getConsultTeacherDetails$2, reservationNetwork$getConsultTeacherDetails$1);
        return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
    }
}
