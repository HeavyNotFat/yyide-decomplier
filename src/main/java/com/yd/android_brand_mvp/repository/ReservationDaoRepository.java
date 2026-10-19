package com.yd.android_brand_mvp.repository;

import com.yd.android_brand_mvp.BaseApplication;
import com.yd.android_brand_mvp.db.DataBaseInstance;
import com.yd.android_brand_mvp.db.reservation.ReservationDao;
import com.yd.android_brand_mvp.db.reservation.ReservationSignBean;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ReservationDaoRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0011\u001a\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/yd/android_brand_mvp/repository/ReservationDaoRepository;", "", "()V", "reservationDaoData", "Lcom/yd/android_brand_mvp/db/reservation/ReservationDao;", "kotlin.jvm.PlatformType", "getReservationDaoData", "()Lcom/yd/android_brand_mvp/db/reservation/ReservationDao;", "reservationDaoData$delegate", "Lkotlin/Lazy;", "addSignData", "", "item", "Lcom/yd/android_brand_mvp/db/reservation/ReservationSignBean;", "(Lcom/yd/android_brand_mvp/db/reservation/ReservationSignBean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delAllSignData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delSignListData", "dataList", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSignData", "getUserIdSignData", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ReservationDaoRepository {
    public static final ReservationDaoRepository INSTANCE = new ReservationDaoRepository();

    /* JADX INFO: renamed from: reservationDaoData$delegate, reason: from kotlin metadata */
    private static final Lazy reservationDaoData = LazyKt.lazy(new Function0<ReservationDao>() { // from class: com.yd.android_brand_mvp.repository.ReservationDaoRepository$reservationDaoData$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ReservationDao invoke() {
            return DataBaseInstance.getInstance(BaseApplication.getInstance().getApplicationContext()).reservationDao();
        }
    });

    private ReservationDaoRepository() {
    }

    private final ReservationDao getReservationDaoData() {
        return (ReservationDao) reservationDaoData.getValue();
    }

    public final Object addSignData(ReservationSignBean reservationSignBean, Continuation<? super Unit> continuation) {
        Object objInsertReservationSignData = getReservationDaoData().insertReservationSignData(reservationSignBean, continuation);
        return objInsertReservationSignData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objInsertReservationSignData : Unit.INSTANCE;
    }

    public final Object getUserIdSignData(String str, Continuation<? super List<ReservationSignBean>> continuation) {
        return getReservationDaoData().queryUserReservationSignData(str, continuation);
    }

    public final Object getAllSignData(Continuation<? super List<ReservationSignBean>> continuation) {
        return getReservationDaoData().queryAllSignData(continuation);
    }

    public final Object delSignListData(List<ReservationSignBean> list, Continuation<? super Unit> continuation) {
        Object objDelReservationSignDataList = getReservationDaoData().delReservationSignDataList(list, (Continuation<? super Integer>) continuation);
        return objDelReservationSignDataList == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelReservationSignDataList : Unit.INSTANCE;
    }

    public final Object delAllSignData(Continuation<? super Unit> continuation) {
        Object objDelAllSignData = getReservationDaoData().delAllSignData(continuation);
        return objDelAllSignData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelAllSignData : Unit.INSTANCE;
    }
}
