package com.yd.android_brand_mvp.db;

import androidx.room.RoomDatabase;
import com.yd.android_brand_mvp.db.reservation.ReservationDao;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AppDatabase extends RoomDatabase {
    public abstract AttendanceDao AttendanceDao();

    public abstract ImUserDao ImUserDao();

    public abstract ReservationDao reservationDao();

    public abstract UserDao userDao();
}
