package com.yd.android_brand_mvp.db;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface AttendanceDao {
    void delete(Attendance attendance);

    void deleteAll();

    List<Attendance> findById(long j);

    List<Attendance> getAll();

    void insertAll(Attendance... attendanceArr);

    int update(Attendance attendance);
}
