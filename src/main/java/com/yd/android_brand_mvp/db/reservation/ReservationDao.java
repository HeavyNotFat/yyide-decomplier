package com.yd.android_brand_mvp.db.reservation;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ReservationDao.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ%\u0010\t\u001a\u00020\u00032\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\n\"\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001f\u0010\t\u001a\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\fH§@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\n\"\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\fH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u0014\u001a\u00020\u0015H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/yd/android_brand_mvp/db/reservation/ReservationDao;", "", "delAllSignData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delReservationSignData", "signData", "Lcom/yd/android_brand_mvp/db/reservation/ReservationSignBean;", "(Lcom/yd/android_brand_mvp/db/reservation/ReservationSignBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delReservationSignDataList", "", "([Lcom/yd/android_brand_mvp/db/reservation/ReservationSignBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertReservationSignData", "", "insertReservationSignDataList", "songs", "queryAllSignData", "queryUserReservationSignData", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ReservationDao {
    Object delAllSignData(Continuation<? super Integer> continuation);

    Object delReservationSignData(ReservationSignBean reservationSignBean, Continuation<? super Integer> continuation);

    Object delReservationSignDataList(List<ReservationSignBean> list, Continuation<? super Integer> continuation);

    Object delReservationSignDataList(ReservationSignBean[] reservationSignBeanArr, Continuation<? super Integer> continuation);

    Object insertReservationSignData(ReservationSignBean reservationSignBean, Continuation<? super Long> continuation);

    Object insertReservationSignDataList(ReservationSignBean[] reservationSignBeanArr, Continuation<? super List<Long>> continuation);

    Object queryAllSignData(Continuation<? super List<ReservationSignBean>> continuation);

    Object queryUserReservationSignData(String str, Continuation<? super List<ReservationSignBean>> continuation);
}
