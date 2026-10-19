package com.yd.android_brand_mvp.db;

import android.database.Cursor;
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

/* JADX INFO: loaded from: classes4.dex */
public final class AttendanceDao_Impl implements AttendanceDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<Attendance> __deletionAdapterOfAttendance;
    private final EntityInsertionAdapter<Attendance> __insertionAdapterOfAttendance;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final EntityDeletionOrUpdateAdapter<Attendance> __updateAdapterOfAttendance;

    public AttendanceDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfAttendance = new EntityInsertionAdapter<Attendance>(roomDatabase) { // from class: com.yd.android_brand_mvp.db.AttendanceDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `Attendance` (`id`,`type`,`peopleId`,`schoolId`,`attendanceId`,`attendanceTimeId`,`attendanceName`,`no`,`peopleName`,`attendanceType`,`createdDateTime`,`createdBy`,`deviceName`,`path`,`cardNo`,`iscard`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Attendance attendance) {
                if (attendance.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, attendance.id.longValue());
                }
                if (attendance.type == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, attendance.type);
                }
                if (attendance.peopleId == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, attendance.peopleId);
                }
                if (attendance.schoolId == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, attendance.schoolId);
                }
                if (attendance.attendanceId == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, attendance.attendanceId);
                }
                if (attendance.attendanceTimeId == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, attendance.attendanceTimeId);
                }
                if (attendance.attendanceName == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, attendance.attendanceName);
                }
                if (attendance.f2013no == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, attendance.f2013no);
                }
                if (attendance.peopleName == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, attendance.peopleName);
                }
                if (attendance.attendanceType == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, attendance.attendanceType);
                }
                supportSQLiteStatement.bindLong(11, attendance.createdDateTime);
                if (attendance.createdBy == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, attendance.createdBy);
                }
                if (attendance.deviceName == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, attendance.deviceName);
                }
                if (attendance.path == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, attendance.path);
                }
                if (attendance.cardNo == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, attendance.cardNo);
                }
                if (attendance.iscard == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, attendance.iscard);
                }
            }
        };
        this.__deletionAdapterOfAttendance = new EntityDeletionOrUpdateAdapter<Attendance>(roomDatabase) { // from class: com.yd.android_brand_mvp.db.AttendanceDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `Attendance` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Attendance attendance) {
                if (attendance.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, attendance.id.longValue());
                }
            }
        };
        this.__updateAdapterOfAttendance = new EntityDeletionOrUpdateAdapter<Attendance>(roomDatabase) { // from class: com.yd.android_brand_mvp.db.AttendanceDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `Attendance` SET `id` = ?,`type` = ?,`peopleId` = ?,`schoolId` = ?,`attendanceId` = ?,`attendanceTimeId` = ?,`attendanceName` = ?,`no` = ?,`peopleName` = ?,`attendanceType` = ?,`createdDateTime` = ?,`createdBy` = ?,`deviceName` = ?,`path` = ?,`cardNo` = ?,`iscard` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, Attendance attendance) {
                if (attendance.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, attendance.id.longValue());
                }
                if (attendance.type == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, attendance.type);
                }
                if (attendance.peopleId == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, attendance.peopleId);
                }
                if (attendance.schoolId == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, attendance.schoolId);
                }
                if (attendance.attendanceId == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, attendance.attendanceId);
                }
                if (attendance.attendanceTimeId == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, attendance.attendanceTimeId);
                }
                if (attendance.attendanceName == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindString(7, attendance.attendanceName);
                }
                if (attendance.f2013no == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, attendance.f2013no);
                }
                if (attendance.peopleName == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, attendance.peopleName);
                }
                if (attendance.attendanceType == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, attendance.attendanceType);
                }
                supportSQLiteStatement.bindLong(11, attendance.createdDateTime);
                if (attendance.createdBy == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, attendance.createdBy);
                }
                if (attendance.deviceName == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, attendance.deviceName);
                }
                if (attendance.path == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, attendance.path);
                }
                if (attendance.cardNo == null) {
                    supportSQLiteStatement.bindNull(15);
                } else {
                    supportSQLiteStatement.bindString(15, attendance.cardNo);
                }
                if (attendance.iscard == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, attendance.iscard);
                }
                if (attendance.id == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindLong(17, attendance.id.longValue());
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: com.yd.android_brand_mvp.db.AttendanceDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM Attendance";
            }
        };
    }

    @Override // com.yd.android_brand_mvp.db.AttendanceDao
    public void insertAll(Attendance... attendanceArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAttendance.insert(attendanceArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.yd.android_brand_mvp.db.AttendanceDao
    public void delete(Attendance attendance) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfAttendance.handle(attendance);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.yd.android_brand_mvp.db.AttendanceDao
    public int update(Attendance attendance) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            int iHandle = this.__updateAdapterOfAttendance.handle(attendance) + 0;
            this.__db.setTransactionSuccessful();
            return iHandle;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.yd.android_brand_mvp.db.AttendanceDao
    public void deleteAll() {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteAll.acquire();
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAll.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.yd.android_brand_mvp.db.AttendanceDao
    public List<Attendance> getAll() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM Attendance", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "peopleId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schoolId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "attendanceId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "attendanceTimeId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "attendanceName");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "no");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "peopleName");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "attendanceType");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdDateTime");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdBy");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceName");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cardNo");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscard");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    Attendance attendance = new Attendance();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        attendance.id = null;
                    } else {
                        attendance.id = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow));
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow2)) {
                        attendance.type = null;
                    } else {
                        attendance.type = cursorQuery.getString(columnIndexOrThrow2);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow3)) {
                        attendance.peopleId = null;
                    } else {
                        attendance.peopleId = cursorQuery.getString(columnIndexOrThrow3);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow4)) {
                        attendance.schoolId = null;
                    } else {
                        attendance.schoolId = cursorQuery.getString(columnIndexOrThrow4);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow5)) {
                        attendance.attendanceId = null;
                    } else {
                        attendance.attendanceId = cursorQuery.getString(columnIndexOrThrow5);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow6)) {
                        attendance.attendanceTimeId = null;
                    } else {
                        attendance.attendanceTimeId = cursorQuery.getString(columnIndexOrThrow6);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow7)) {
                        attendance.attendanceName = null;
                    } else {
                        attendance.attendanceName = cursorQuery.getString(columnIndexOrThrow7);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow8)) {
                        attendance.f2013no = null;
                    } else {
                        attendance.f2013no = cursorQuery.getString(columnIndexOrThrow8);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow9)) {
                        attendance.peopleName = null;
                    } else {
                        attendance.peopleName = cursorQuery.getString(columnIndexOrThrow9);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow10)) {
                        attendance.attendanceType = null;
                    } else {
                        attendance.attendanceType = cursorQuery.getString(columnIndexOrThrow10);
                    }
                    int i2 = columnIndexOrThrow2;
                    int i3 = columnIndexOrThrow3;
                    attendance.createdDateTime = cursorQuery.getLong(columnIndexOrThrow11);
                    if (cursorQuery.isNull(columnIndexOrThrow12)) {
                        attendance.createdBy = null;
                    } else {
                        attendance.createdBy = cursorQuery.getString(columnIndexOrThrow12);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow13)) {
                        attendance.deviceName = null;
                    } else {
                        attendance.deviceName = cursorQuery.getString(columnIndexOrThrow13);
                    }
                    int i4 = i;
                    if (cursorQuery.isNull(i4)) {
                        attendance.path = null;
                    } else {
                        attendance.path = cursorQuery.getString(i4);
                    }
                    int i5 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i5)) {
                        attendance.cardNo = null;
                    } else {
                        attendance.cardNo = cursorQuery.getString(i5);
                    }
                    int i6 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i6)) {
                        attendance.iscard = null;
                    } else {
                        attendance.iscard = cursorQuery.getString(i6);
                    }
                    arrayList = arrayList;
                    arrayList.add(attendance);
                    i = i4;
                    columnIndexOrThrow2 = i2;
                    columnIndexOrThrow16 = i6;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow3 = i3;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    @Override // com.yd.android_brand_mvp.db.AttendanceDao
    public List<Attendance> findById(long j) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM Attendance WHERE createdDateTime > ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "peopleId");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "schoolId");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "attendanceId");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "attendanceTimeId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "attendanceName");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "no");
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "peopleName");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "attendanceType");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdDateTime");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "createdBy");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "deviceName");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "path");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "cardNo");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "iscard");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    Attendance attendance = new Attendance();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        attendance.id = null;
                    } else {
                        attendance.id = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow));
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow2)) {
                        attendance.type = null;
                    } else {
                        attendance.type = cursorQuery.getString(columnIndexOrThrow2);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow3)) {
                        attendance.peopleId = null;
                    } else {
                        attendance.peopleId = cursorQuery.getString(columnIndexOrThrow3);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow4)) {
                        attendance.schoolId = null;
                    } else {
                        attendance.schoolId = cursorQuery.getString(columnIndexOrThrow4);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow5)) {
                        attendance.attendanceId = null;
                    } else {
                        attendance.attendanceId = cursorQuery.getString(columnIndexOrThrow5);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow6)) {
                        attendance.attendanceTimeId = null;
                    } else {
                        attendance.attendanceTimeId = cursorQuery.getString(columnIndexOrThrow6);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow7)) {
                        attendance.attendanceName = null;
                    } else {
                        attendance.attendanceName = cursorQuery.getString(columnIndexOrThrow7);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow8)) {
                        attendance.f2013no = null;
                    } else {
                        attendance.f2013no = cursorQuery.getString(columnIndexOrThrow8);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow9)) {
                        attendance.peopleName = null;
                    } else {
                        attendance.peopleName = cursorQuery.getString(columnIndexOrThrow9);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow10)) {
                        attendance.attendanceType = null;
                    } else {
                        attendance.attendanceType = cursorQuery.getString(columnIndexOrThrow10);
                    }
                    int i2 = columnIndexOrThrow2;
                    int i3 = columnIndexOrThrow3;
                    attendance.createdDateTime = cursorQuery.getLong(columnIndexOrThrow11);
                    if (cursorQuery.isNull(columnIndexOrThrow12)) {
                        attendance.createdBy = null;
                    } else {
                        attendance.createdBy = cursorQuery.getString(columnIndexOrThrow12);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow13)) {
                        attendance.deviceName = null;
                    } else {
                        attendance.deviceName = cursorQuery.getString(columnIndexOrThrow13);
                    }
                    int i4 = i;
                    if (cursorQuery.isNull(i4)) {
                        attendance.path = null;
                    } else {
                        attendance.path = cursorQuery.getString(i4);
                    }
                    int i5 = columnIndexOrThrow15;
                    if (cursorQuery.isNull(i5)) {
                        attendance.cardNo = null;
                    } else {
                        attendance.cardNo = cursorQuery.getString(i5);
                    }
                    int i6 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i6)) {
                        attendance.iscard = null;
                    } else {
                        attendance.iscard = cursorQuery.getString(i6);
                    }
                    arrayList = arrayList;
                    arrayList.add(attendance);
                    i = i4;
                    columnIndexOrThrow2 = i2;
                    columnIndexOrThrow16 = i6;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow15 = i5;
                    columnIndexOrThrow3 = i3;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursorQuery.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            roomSQLiteQuery = roomSQLiteQueryAcquire;
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
