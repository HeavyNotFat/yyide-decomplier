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
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class UserDao_Impl implements UserDao {
    private final RoomDatabase __db;
    private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;
    private final EntityInsertionAdapter<User> __insertionAdapterOfUser;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAll;
    private final SharedSQLiteStatement __preparedStmtOfDeleteUsersBefore;
    private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

    public UserDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(roomDatabase) { // from class: com.yd.android_brand_mvp.db.UserDao_Impl.1
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR ABORT INTO `User` (`id`,`userId`,`name`,`time`,`type`,`AttenceId`,`Timeid`,`classesId`,`identy`,`AttenceName`,`CardNo`,`photo`,`listAttenceId`,`siteTimetableId`,`ispost`,`isCard`,`listCouseId`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.EntityInsertionAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, User user) {
                if (user.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, user.id.longValue());
                }
                supportSQLiteStatement.bindLong(2, user.userId);
                if (user.name == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, user.name);
                }
                if (user.time == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, user.time);
                }
                supportSQLiteStatement.bindLong(5, user.type);
                supportSQLiteStatement.bindLong(6, user.AttenceId);
                supportSQLiteStatement.bindLong(7, user.Timeid);
                if (user.classesId == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, user.classesId);
                }
                if (user.identy == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, user.identy);
                }
                if (user.AttenceName == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, user.AttenceName);
                }
                if (user.CardNo == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, user.CardNo);
                }
                if (user.photo == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, user.photo);
                }
                if (user.listAttenceId == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, user.listAttenceId);
                }
                if (user.siteTimetableId == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, user.siteTimetableId);
                }
                supportSQLiteStatement.bindLong(15, user.ispost ? 1L : 0L);
                if (user.isCard == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, user.isCard);
                }
                if (user.listCouseId == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, user.listCouseId);
                }
            }
        };
        this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(roomDatabase) { // from class: com.yd.android_brand_mvp.db.UserDao_Impl.2
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM `User` WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, User user) {
                if (user.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, user.id.longValue());
                }
            }
        };
        this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(roomDatabase) { // from class: com.yd.android_brand_mvp.db.UserDao_Impl.3
            @Override // androidx.room.EntityDeletionOrUpdateAdapter, androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE OR ABORT `User` SET `id` = ?,`userId` = ?,`name` = ?,`time` = ?,`type` = ?,`AttenceId` = ?,`Timeid` = ?,`classesId` = ?,`identy` = ?,`AttenceName` = ?,`CardNo` = ?,`photo` = ?,`listAttenceId` = ?,`siteTimetableId` = ?,`ispost` = ?,`isCard` = ?,`listCouseId` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.EntityDeletionOrUpdateAdapter
            public void bind(SupportSQLiteStatement supportSQLiteStatement, User user) {
                if (user.id == null) {
                    supportSQLiteStatement.bindNull(1);
                } else {
                    supportSQLiteStatement.bindLong(1, user.id.longValue());
                }
                supportSQLiteStatement.bindLong(2, user.userId);
                if (user.name == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, user.name);
                }
                if (user.time == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, user.time);
                }
                supportSQLiteStatement.bindLong(5, user.type);
                supportSQLiteStatement.bindLong(6, user.AttenceId);
                supportSQLiteStatement.bindLong(7, user.Timeid);
                if (user.classesId == null) {
                    supportSQLiteStatement.bindNull(8);
                } else {
                    supportSQLiteStatement.bindString(8, user.classesId);
                }
                if (user.identy == null) {
                    supportSQLiteStatement.bindNull(9);
                } else {
                    supportSQLiteStatement.bindString(9, user.identy);
                }
                if (user.AttenceName == null) {
                    supportSQLiteStatement.bindNull(10);
                } else {
                    supportSQLiteStatement.bindString(10, user.AttenceName);
                }
                if (user.CardNo == null) {
                    supportSQLiteStatement.bindNull(11);
                } else {
                    supportSQLiteStatement.bindString(11, user.CardNo);
                }
                if (user.photo == null) {
                    supportSQLiteStatement.bindNull(12);
                } else {
                    supportSQLiteStatement.bindString(12, user.photo);
                }
                if (user.listAttenceId == null) {
                    supportSQLiteStatement.bindNull(13);
                } else {
                    supportSQLiteStatement.bindString(13, user.listAttenceId);
                }
                if (user.siteTimetableId == null) {
                    supportSQLiteStatement.bindNull(14);
                } else {
                    supportSQLiteStatement.bindString(14, user.siteTimetableId);
                }
                supportSQLiteStatement.bindLong(15, user.ispost ? 1L : 0L);
                if (user.isCard == null) {
                    supportSQLiteStatement.bindNull(16);
                } else {
                    supportSQLiteStatement.bindString(16, user.isCard);
                }
                if (user.listCouseId == null) {
                    supportSQLiteStatement.bindNull(17);
                } else {
                    supportSQLiteStatement.bindString(17, user.listCouseId);
                }
                if (user.id == null) {
                    supportSQLiteStatement.bindNull(18);
                } else {
                    supportSQLiteStatement.bindLong(18, user.id.longValue());
                }
            }
        };
        this.__preparedStmtOfDeleteUsersBefore = new SharedSQLiteStatement(roomDatabase) { // from class: com.yd.android_brand_mvp.db.UserDao_Impl.4
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM user WHERE time < ?";
            }
        };
        this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(roomDatabase) { // from class: com.yd.android_brand_mvp.db.UserDao_Impl.5
            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM User";
            }
        };
    }

    @Override // com.yd.android_brand_mvp.db.UserDao
    public void insertAll(User... userArr) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfUser.insert(userArr);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.yd.android_brand_mvp.db.UserDao
    public void deleteAll(List<User> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfUser.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.yd.android_brand_mvp.db.UserDao
    public void delete(User user) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfUser.handle(user);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.yd.android_brand_mvp.db.UserDao
    public void update(User user) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfUser.handle(user);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.yd.android_brand_mvp.db.UserDao
    public void deleteUsersBefore(String str) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement supportSQLiteStatementAcquire = this.__preparedStmtOfDeleteUsersBefore.acquire();
        if (str == null) {
            supportSQLiteStatementAcquire.bindNull(1);
        } else {
            supportSQLiteStatementAcquire.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            supportSQLiteStatementAcquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteUsersBefore.release(supportSQLiteStatementAcquire);
        }
    }

    @Override // com.yd.android_brand_mvp.db.UserDao
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

    @Override // com.yd.android_brand_mvp.db.UserDao
    public User getUserById(Long l) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        User user;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM user WHERE userId = ? LIMIT 1", 1);
        if (l == null) {
            roomSQLiteQueryAcquire.bindNull(1);
        } else {
            roomSQLiteQueryAcquire.bindLong(1, l.longValue());
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, AppMeasurementSdk.ConditionalUserProperty.NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "AttenceId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "Timeid");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, CommentsHomeFragment.TYPE_CLASSESID);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "identy");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "AttenceName");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "CardNo");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "photo");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "listAttenceId");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteTimetableId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ispost");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isCard");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "listCouseId");
                if (cursorQuery.moveToFirst()) {
                    User user2 = new User();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        user2.id = null;
                    } else {
                        user2.id = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow));
                    }
                    user2.userId = cursorQuery.getLong(columnIndexOrThrow2);
                    if (cursorQuery.isNull(columnIndexOrThrow3)) {
                        user2.name = null;
                    } else {
                        user2.name = cursorQuery.getString(columnIndexOrThrow3);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow4)) {
                        user2.time = null;
                    } else {
                        user2.time = cursorQuery.getString(columnIndexOrThrow4);
                    }
                    user2.type = cursorQuery.getInt(columnIndexOrThrow5);
                    user2.AttenceId = cursorQuery.getLong(columnIndexOrThrow6);
                    user2.Timeid = cursorQuery.getLong(columnIndexOrThrow7);
                    if (cursorQuery.isNull(columnIndexOrThrow8)) {
                        user2.classesId = null;
                    } else {
                        user2.classesId = cursorQuery.getString(columnIndexOrThrow8);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow9)) {
                        user2.identy = null;
                    } else {
                        user2.identy = cursorQuery.getString(columnIndexOrThrow9);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow10)) {
                        user2.AttenceName = null;
                    } else {
                        user2.AttenceName = cursorQuery.getString(columnIndexOrThrow10);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow11)) {
                        user2.CardNo = null;
                    } else {
                        user2.CardNo = cursorQuery.getString(columnIndexOrThrow11);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow12)) {
                        user2.photo = null;
                    } else {
                        user2.photo = cursorQuery.getString(columnIndexOrThrow12);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow13)) {
                        user2.listAttenceId = null;
                    } else {
                        user2.listAttenceId = cursorQuery.getString(columnIndexOrThrow13);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow14)) {
                        user2.siteTimetableId = null;
                    } else {
                        user2.siteTimetableId = cursorQuery.getString(columnIndexOrThrow14);
                    }
                    user2.ispost = cursorQuery.getInt(columnIndexOrThrow15) != 0;
                    if (cursorQuery.isNull(columnIndexOrThrow16)) {
                        user2.isCard = null;
                    } else {
                        user2.isCard = cursorQuery.getString(columnIndexOrThrow16);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow17)) {
                        user2.listCouseId = null;
                    } else {
                        user2.listCouseId = cursorQuery.getString(columnIndexOrThrow17);
                    }
                    user = user2;
                } else {
                    user = null;
                }
                cursorQuery.close();
                roomSQLiteQuery.release();
                return user;
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

    @Override // com.yd.android_brand_mvp.db.UserDao
    public List<User> getAll() throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM User", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, AppMeasurementSdk.ConditionalUserProperty.NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "AttenceId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "Timeid");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, CommentsHomeFragment.TYPE_CLASSESID);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "identy");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "AttenceName");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "CardNo");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "photo");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "listAttenceId");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteTimetableId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ispost");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isCard");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "listCouseId");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    User user = new User();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        user.id = null;
                    } else {
                        user.id = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow));
                    }
                    int i2 = columnIndexOrThrow13;
                    user.userId = cursorQuery.getLong(columnIndexOrThrow2);
                    if (cursorQuery.isNull(columnIndexOrThrow3)) {
                        user.name = null;
                    } else {
                        user.name = cursorQuery.getString(columnIndexOrThrow3);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow4)) {
                        user.time = null;
                    } else {
                        user.time = cursorQuery.getString(columnIndexOrThrow4);
                    }
                    user.type = cursorQuery.getInt(columnIndexOrThrow5);
                    user.AttenceId = cursorQuery.getLong(columnIndexOrThrow6);
                    user.Timeid = cursorQuery.getLong(columnIndexOrThrow7);
                    if (cursorQuery.isNull(columnIndexOrThrow8)) {
                        user.classesId = null;
                    } else {
                        user.classesId = cursorQuery.getString(columnIndexOrThrow8);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow9)) {
                        user.identy = null;
                    } else {
                        user.identy = cursorQuery.getString(columnIndexOrThrow9);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow10)) {
                        user.AttenceName = null;
                    } else {
                        user.AttenceName = cursorQuery.getString(columnIndexOrThrow10);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow11)) {
                        user.CardNo = null;
                    } else {
                        user.CardNo = cursorQuery.getString(columnIndexOrThrow11);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow12)) {
                        user.photo = null;
                    } else {
                        user.photo = cursorQuery.getString(columnIndexOrThrow12);
                    }
                    if (cursorQuery.isNull(i2)) {
                        user.listAttenceId = null;
                    } else {
                        user.listAttenceId = cursorQuery.getString(i2);
                    }
                    int i3 = i;
                    if (cursorQuery.isNull(i3)) {
                        user.siteTimetableId = null;
                    } else {
                        user.siteTimetableId = cursorQuery.getString(i3);
                    }
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    user.ispost = cursorQuery.getInt(columnIndexOrThrow15) != 0;
                    int i4 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i4)) {
                        user.isCard = null;
                    } else {
                        user.isCard = cursorQuery.getString(i4);
                    }
                    int i5 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i5)) {
                        user.listCouseId = null;
                    } else {
                        user.listCouseId = cursorQuery.getString(i5);
                    }
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(user);
                    arrayList = arrayList2;
                    columnIndexOrThrow = columnIndexOrThrow;
                    i = i3;
                    columnIndexOrThrow13 = i2;
                    columnIndexOrThrow17 = i5;
                    columnIndexOrThrow12 = columnIndexOrThrow12;
                    columnIndexOrThrow16 = i4;
                }
                ArrayList arrayList3 = arrayList;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList3;
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

    @Override // com.yd.android_brand_mvp.db.UserDao
    public List<User> findById(long j) throws Throwable {
        RoomSQLiteQuery roomSQLiteQuery;
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM User WHERE userId = ?", 1);
        roomSQLiteQueryAcquire.bindLong(1, j);
        this.__db.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.__db, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "userId");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, AppMeasurementSdk.ConditionalUserProperty.NAME);
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "time");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "type");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "AttenceId");
            int columnIndexOrThrow7 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "Timeid");
            int columnIndexOrThrow8 = CursorUtil.getColumnIndexOrThrow(cursorQuery, CommentsHomeFragment.TYPE_CLASSESID);
            int columnIndexOrThrow9 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "identy");
            int columnIndexOrThrow10 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "AttenceName");
            int columnIndexOrThrow11 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "CardNo");
            int columnIndexOrThrow12 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "photo");
            int columnIndexOrThrow13 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "listAttenceId");
            int columnIndexOrThrow14 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "siteTimetableId");
            roomSQLiteQuery = roomSQLiteQueryAcquire;
            try {
                int columnIndexOrThrow15 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "ispost");
                int columnIndexOrThrow16 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "isCard");
                int columnIndexOrThrow17 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "listCouseId");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    User user = new User();
                    if (cursorQuery.isNull(columnIndexOrThrow)) {
                        user.id = null;
                    } else {
                        user.id = Long.valueOf(cursorQuery.getLong(columnIndexOrThrow));
                    }
                    int i2 = columnIndexOrThrow12;
                    user.userId = cursorQuery.getLong(columnIndexOrThrow2);
                    if (cursorQuery.isNull(columnIndexOrThrow3)) {
                        user.name = null;
                    } else {
                        user.name = cursorQuery.getString(columnIndexOrThrow3);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow4)) {
                        user.time = null;
                    } else {
                        user.time = cursorQuery.getString(columnIndexOrThrow4);
                    }
                    user.type = cursorQuery.getInt(columnIndexOrThrow5);
                    user.AttenceId = cursorQuery.getLong(columnIndexOrThrow6);
                    user.Timeid = cursorQuery.getLong(columnIndexOrThrow7);
                    if (cursorQuery.isNull(columnIndexOrThrow8)) {
                        user.classesId = null;
                    } else {
                        user.classesId = cursorQuery.getString(columnIndexOrThrow8);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow9)) {
                        user.identy = null;
                    } else {
                        user.identy = cursorQuery.getString(columnIndexOrThrow9);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow10)) {
                        user.AttenceName = null;
                    } else {
                        user.AttenceName = cursorQuery.getString(columnIndexOrThrow10);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow11)) {
                        user.CardNo = null;
                    } else {
                        user.CardNo = cursorQuery.getString(columnIndexOrThrow11);
                    }
                    if (cursorQuery.isNull(i2)) {
                        user.photo = null;
                    } else {
                        user.photo = cursorQuery.getString(i2);
                    }
                    if (cursorQuery.isNull(columnIndexOrThrow13)) {
                        user.listAttenceId = null;
                    } else {
                        user.listAttenceId = cursorQuery.getString(columnIndexOrThrow13);
                    }
                    int i3 = i;
                    if (cursorQuery.isNull(i3)) {
                        user.siteTimetableId = null;
                    } else {
                        user.siteTimetableId = cursorQuery.getString(i3);
                    }
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    user.ispost = cursorQuery.getInt(columnIndexOrThrow15) != 0;
                    int i4 = columnIndexOrThrow16;
                    if (cursorQuery.isNull(i4)) {
                        user.isCard = null;
                    } else {
                        user.isCard = cursorQuery.getString(i4);
                    }
                    int i5 = columnIndexOrThrow17;
                    if (cursorQuery.isNull(i5)) {
                        user.listCouseId = null;
                    } else {
                        user.listCouseId = cursorQuery.getString(i5);
                    }
                    ArrayList arrayList2 = arrayList;
                    arrayList2.add(user);
                    arrayList = arrayList2;
                    columnIndexOrThrow = columnIndexOrThrow;
                    i = i3;
                    columnIndexOrThrow12 = i2;
                    columnIndexOrThrow17 = i5;
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                    columnIndexOrThrow16 = i4;
                }
                ArrayList arrayList3 = arrayList;
                cursorQuery.close();
                roomSQLiteQuery.release();
                return arrayList3;
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
