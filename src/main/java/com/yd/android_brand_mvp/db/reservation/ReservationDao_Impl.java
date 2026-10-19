package com.yd.android_brand_mvp.db.reservation;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
public final class ReservationDao_Impl implements ReservationDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ReservationSignBean> __deletionAdapterOfReservationSignBean;
    private final EntityInsertionAdapter<ReservationSignBean> __insertionAdapterOfReservationSignBean;
    private final SharedSQLiteStatement __preparedStmtOfDelAllSignData;

    public ReservationDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfReservationSignBean = new EntityInsertionAdapter<ReservationSignBean>(roomDatabase) { // from class: com.yd.android_brand_mvp.db.reservation.ReservationDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `reservation_sign` (`userId`,`signInTime`,`siteBookingId`,`id`) VALUES (?,?,?,nullif(?, 0))";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ReservationSignBean reservationSignBean) {
                if (reservationSignBean.getUserId() == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindString(1, reservationSignBean.getUserId());
                }
                if (reservationSignBean.getSignInTime() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, reservationSignBean.getSignInTime());
                }
                if (reservationSignBean.getSiteBookingId() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, reservationSignBean.getSiteBookingId());
                }
                supportSQLiteStatement.bindLong(4, reservationSignBean.getId());
            }
        };
        this.__deletionAdapterOfReservationSignBean = new EntityDeletionOrUpdateAdapter<ReservationSignBean>(roomDatabase) { // from class: com.yd.android_brand_mvp.db.reservation.ReservationDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `reservation_sign` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ReservationSignBean reservationSignBean) {
                supportSQLiteStatement.bindLong(1, reservationSignBean.getId());
            }
        };
        this.__preparedStmtOfDelAllSignData = new SharedSQLiteStatement(roomDatabase) { // from class: com.yd.android_brand_mvp.db.reservation.ReservationDao_Impl.3
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "delete from reservation_sign";
            }
        };
    }

    @Override // com.yd.android_brand_mvp.db.reservation.ReservationDao
    public Object insertReservationSignData(final ReservationSignBean reservationSignBean, Continuation<? super Long> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Long>() { // from class: com.yd.android_brand_mvp.db.reservation.ReservationDao_Impl.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Long call() throws Exception {
                ReservationDao_Impl.this.__db.beginTransaction();
                try {
                    long jInsertAndReturnId = ReservationDao_Impl.this.__insertionAdapterOfReservationSignBean.insertAndReturnId(reservationSignBean);
                    ReservationDao_Impl.this.__db.setTransactionSuccessful();
                    return Long.valueOf(jInsertAndReturnId);
                } finally {
                    ReservationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.yd.android_brand_mvp.db.reservation.ReservationDao
    public Object insertReservationSignDataList(final ReservationSignBean[] reservationSignBeanArr, Continuation<? super List<Long>> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<List<Long>>() { // from class: com.yd.android_brand_mvp.db.reservation.ReservationDao_Impl.5
            @Override // java.util.concurrent.Callable
            public List<Long> call() throws Exception {
                ReservationDao_Impl.this.__db.beginTransaction();
                try {
                    List<Long> listInsertAndReturnIdsList = ReservationDao_Impl.this.__insertionAdapterOfReservationSignBean.insertAndReturnIdsList(reservationSignBeanArr);
                    ReservationDao_Impl.this.__db.setTransactionSuccessful();
                    return listInsertAndReturnIdsList;
                } finally {
                    ReservationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.yd.android_brand_mvp.db.reservation.ReservationDao
    public Object delReservationSignData(final ReservationSignBean reservationSignBean, Continuation<? super Integer> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Integer>() { // from class: com.yd.android_brand_mvp.db.reservation.ReservationDao_Impl.6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                ReservationDao_Impl.this.__db.beginTransaction();
                try {
                    int iHandle = ReservationDao_Impl.this.__deletionAdapterOfReservationSignBean.handle(reservationSignBean) + 0;
                    ReservationDao_Impl.this.__db.setTransactionSuccessful();
                    return Integer.valueOf(iHandle);
                } finally {
                    ReservationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.yd.android_brand_mvp.db.reservation.ReservationDao
    public Object delReservationSignDataList(final ReservationSignBean[] reservationSignBeanArr, Continuation<? super Integer> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Integer>() { // from class: com.yd.android_brand_mvp.db.reservation.ReservationDao_Impl.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                ReservationDao_Impl.this.__db.beginTransaction();
                try {
                    int iHandleMultiple = ReservationDao_Impl.this.__deletionAdapterOfReservationSignBean.handleMultiple(reservationSignBeanArr) + 0;
                    ReservationDao_Impl.this.__db.setTransactionSuccessful();
                    return Integer.valueOf(iHandleMultiple);
                } finally {
                    ReservationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.yd.android_brand_mvp.db.reservation.ReservationDao
    public Object delReservationSignDataList(final List<ReservationSignBean> list, Continuation<? super Integer> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Integer>() { // from class: com.yd.android_brand_mvp.db.reservation.ReservationDao_Impl.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                ReservationDao_Impl.this.__db.beginTransaction();
                try {
                    int iHandleMultiple = ReservationDao_Impl.this.__deletionAdapterOfReservationSignBean.handleMultiple(list) + 0;
                    ReservationDao_Impl.this.__db.setTransactionSuccessful();
                    return Integer.valueOf(iHandleMultiple);
                } finally {
                    ReservationDao_Impl.this.__db.endTransaction();
                }
            }
        }, continuation);
    }

    @Override // com.yd.android_brand_mvp.db.reservation.ReservationDao
    public Object delAllSignData(Continuation<? super Integer> continuation) {
        return CoroutinesRoom.execute(this.__db, true, new Callable<Integer>() { // from class: com.yd.android_brand_mvp.db.reservation.ReservationDao_Impl.9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                SupportSQLiteStatement supportSQLiteStatementAcquire = ReservationDao_Impl.this.__preparedStmtOfDelAllSignData.acquire();
                ReservationDao_Impl.this.__db.beginTransaction();
                try {
                    Integer numValueOf = Integer.valueOf(supportSQLiteStatementAcquire.executeUpdateDelete());
                    ReservationDao_Impl.this.__db.setTransactionSuccessful();
                    return numValueOf;
                } finally {
                    ReservationDao_Impl.this.__db.endTransaction();
                    ReservationDao_Impl.this.__preparedStmtOfDelAllSignData.release(supportSQLiteStatementAcquire);
                }
            }
        }, continuation);
    }

    @Override // com.yd.android_brand_mvp.db.reservation.ReservationDao
    public Object queryUserReservationSignData(String str, Continuation<? super List<ReservationSignBean>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from reservation_sign where userId = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<ReservationSignBean>>() { // from class: com.yd.android_brand_mvp.db.reservation.ReservationDao_Impl.10
            @Override // java.util.concurrent.Callable
            public List<ReservationSignBean> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ReservationDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signInTime");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteBookingId");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        ReservationSignBean reservationSignBean = new ReservationSignBean(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        reservationSignBean.setId(cursorQuery.getLong(columnIndexOrThrow4));
                        arrayList.add(reservationSignBean);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, continuation);
    }

    @Override // com.yd.android_brand_mvp.db.reservation.ReservationDao
    public Object queryAllSignData(Continuation<? super List<ReservationSignBean>> continuation) {
        final RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("select * from reservation_sign", 0);
        return CoroutinesRoom.execute(this.__db, false, DBUtil.createCancellationSignal(), new Callable<List<ReservationSignBean>>() { // from class: com.yd.android_brand_mvp.db.reservation.ReservationDao_Impl.11
            @Override // java.util.concurrent.Callable
            public List<ReservationSignBean> call() throws Exception {
                Cursor cursorQuery = DBUtil.query(ReservationDao_Impl.this.__db, roomSQLiteQueryAcquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "signInTime");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteBookingId");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
                    ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                    while (cursorQuery.moveToNext()) {
                        ReservationSignBean reservationSignBean = new ReservationSignBean(cursorQuery.isNull(columnIndexOrThrow) ? null : cursorQuery.getString(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.isNull(columnIndexOrThrow3) ? null : cursorQuery.getString(columnIndexOrThrow3));
                        reservationSignBean.setId(cursorQuery.getLong(columnIndexOrThrow4));
                        arrayList.add(reservationSignBean);
                    }
                    return arrayList;
                } finally {
                    cursorQuery.close();
                    roomSQLiteQueryAcquire.release();
                }
            }
        }, continuation);
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
