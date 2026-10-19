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
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ImUserDao_Impl implements ImUserDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<ImUser> __deletionAdapterOfImUser;
    private final EntityInsertionAdapter<ImUser> __insertionAdapterOfImUser;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final EntityDeletionOrUpdateAdapter<ImUser> __updateAdapterOfImUser;

    public ImUserDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfImUser = new EntityInsertionAdapter<ImUser>(roomDatabase) { // from class: com.yd.android_brand_mvp.db.ImUserDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `ImUser` (`id`,`userId`,`name`,`time`,`count`,`videotime`,`videocount`) VALUES (?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ImUser imUser) {
                if (imUser.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, imUser.id.intValue());
                }
                if (imUser.userId == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, imUser.userId);
                }
                if (imUser.name == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, imUser.name);
                }
                if (imUser.time == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, imUser.time);
                }
                if (imUser.count == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, imUser.count.intValue());
                }
                if (imUser.videotime == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, imUser.videotime);
                }
                if (imUser.videocount == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, imUser.videocount.intValue());
                }
            }
        };
        this.__deletionAdapterOfImUser = new EntityDeletionOrUpdateAdapter<ImUser>(roomDatabase) { // from class: com.yd.android_brand_mvp.db.ImUserDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `ImUser` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ImUser imUser) {
                if (imUser.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, imUser.id.intValue());
                }
            }
        };
        this.__updateAdapterOfImUser = new EntityDeletionOrUpdateAdapter<ImUser>(roomDatabase) { // from class: com.yd.android_brand_mvp.db.ImUserDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `ImUser` SET `id` = ?,`userId` = ?,`name` = ?,`time` = ?,`count` = ?,`videotime` = ?,`videocount` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, ImUser imUser) {
                if (imUser.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, imUser.id.intValue());
                }
                if (imUser.userId == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, imUser.userId);
                }
                if (imUser.name == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, imUser.name);
                }
                if (imUser.time == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, imUser.time);
                }
                if (imUser.count == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindLong(5, imUser.count.intValue());
                }
                if (imUser.videotime == null) {
                    supportSQLiteStatement.bindNull(6);
                } else {
                    supportSQLiteStatement.bindString(6, imUser.videotime);
                }
                if (imUser.videocount == null) {
                    supportSQLiteStatement.bindNull(7);
                } else {
                    supportSQLiteStatement.bindLong(7, imUser.videocount.intValue());
                }
                if (imUser.id == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindLong(8, imUser.id.intValue());
                }
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: com.yd.android_brand_mvp.db.ImUserDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM ImUser";
            }
        };
    }

    @Override // com.yd.android_brand_mvp.db.ImUserDao
    public void insertAll(ImUser... imUserArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfImUser.insert(imUserArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.yd.android_brand_mvp.db.ImUserDao
    public void delete(ImUser imUser) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfImUser.handle(imUser);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.yd.android_brand_mvp.db.ImUserDao
    public void update(ImUser imUser) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfImUser.handle(imUser);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.yd.android_brand_mvp.db.ImUserDao
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

    @Override // com.yd.android_brand_mvp.db.ImUserDao
    public List<ImUser> getAll() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ImUser", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, AppMeasurementSdk.ConditionalUserProperty.NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "count");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videocount");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                ImUser imUser = new ImUser();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    imUser.id = null;
                } else {
                    imUser.id = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow));
                }
                if (cursorQuery.isNull(columnIndexOrThrow2)) {
                    imUser.userId = null;
                } else {
                    imUser.userId = cursorQuery.getString(columnIndexOrThrow2);
                }
                if (cursorQuery.isNull(columnIndexOrThrow3)) {
                    imUser.name = null;
                } else {
                    imUser.name = cursorQuery.getString(columnIndexOrThrow3);
                }
                if (cursorQuery.isNull(columnIndexOrThrow4)) {
                    imUser.time = null;
                } else {
                    imUser.time = cursorQuery.getString(columnIndexOrThrow4);
                }
                if (cursorQuery.isNull(columnIndexOrThrow5)) {
                    imUser.count = null;
                } else {
                    imUser.count = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5));
                }
                if (cursorQuery.isNull(columnIndexOrThrow6)) {
                    imUser.videotime = null;
                } else {
                    imUser.videotime = cursorQuery.getString(columnIndexOrThrow6);
                }
                if (cursorQuery.isNull(columnIndexOrThrow7)) {
                    imUser.videocount = null;
                } else {
                    imUser.videocount = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow7));
                }
                arrayList.add(imUser);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    @Override // com.yd.android_brand_mvp.db.ImUserDao
    public List<ImUser> findById(String str) {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM ImUser WHERE userId = ?", 1);
        if (str == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, AppMeasurementSdk.ConditionalUserProperty.NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "count");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videotime");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "videocount");
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                ImUser imUser = new ImUser();
                if (cursorQuery.isNull(columnIndexOrThrow)) {
                    imUser.id = null;
                } else {
                    imUser.id = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow));
                }
                if (cursorQuery.isNull(columnIndexOrThrow2)) {
                    imUser.userId = null;
                } else {
                    imUser.userId = cursorQuery.getString(columnIndexOrThrow2);
                }
                if (cursorQuery.isNull(columnIndexOrThrow3)) {
                    imUser.name = null;
                } else {
                    imUser.name = cursorQuery.getString(columnIndexOrThrow3);
                }
                if (cursorQuery.isNull(columnIndexOrThrow4)) {
                    imUser.time = null;
                } else {
                    imUser.time = cursorQuery.getString(columnIndexOrThrow4);
                }
                if (cursorQuery.isNull(columnIndexOrThrow5)) {
                    imUser.count = null;
                } else {
                    imUser.count = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow5));
                }
                if (cursorQuery.isNull(columnIndexOrThrow6)) {
                    imUser.videotime = null;
                } else {
                    imUser.videotime = cursorQuery.getString(columnIndexOrThrow6);
                }
                if (cursorQuery.isNull(columnIndexOrThrow7)) {
                    imUser.videocount = null;
                } else {
                    imUser.videocount = Integer.valueOf(cursorQuery.getInt(columnIndexOrThrow7));
                }
                arrayList.add(imUser);
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }
}
