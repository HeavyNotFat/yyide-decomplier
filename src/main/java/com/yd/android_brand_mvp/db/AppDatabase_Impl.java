package com.yd.android_brand_mvp.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.yd.android_brand_mvp.db.reservation.ReservationDao;
import com.yd.android_brand_mvp.db.reservation.ReservationDao_Impl;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class AppDatabase_Impl extends AppDatabase {
    private volatile AttendanceDao _attendanceDao;
    private volatile ImUserDao _imUserDao;
    private volatile ReservationDao _reservationDao;
    private volatile UserDao _userDao;

    @Override // androidx.room.RoomDatabase
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration) {
        return databaseConfiguration.sqliteOpenHelperFactory.create(SupportSQLiteOpenHelper.Configuration.builder(databaseConfiguration.context).name(databaseConfiguration.name).callback(new RoomOpenHelper(databaseConfiguration, new RoomOpenHelper.Delegate(11) { // from class: com.yd.android_brand_mvp.db.AppDatabase_Impl.1
            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPostMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `User` (`id` INTEGER, `userId` INTEGER NOT NULL, `name` TEXT, `time` TEXT, `type` INTEGER NOT NULL, `AttenceId` INTEGER NOT NULL, `Timeid` INTEGER NOT NULL, `classesId` TEXT, `identy` TEXT, `AttenceName` TEXT, `CardNo` TEXT, `photo` TEXT, `listAttenceId` TEXT, `siteTimetableId` TEXT, `ispost` INTEGER NOT NULL, `isCard` TEXT, `listCouseId` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `Attendance` (`id` INTEGER, `type` TEXT, `peopleId` TEXT, `schoolId` TEXT, `attendanceId` TEXT, `attendanceTimeId` TEXT, `attendanceName` TEXT, `no` TEXT, `peopleName` TEXT, `attendanceType` TEXT, `createdDateTime` INTEGER NOT NULL, `createdBy` TEXT, `deviceName` TEXT, `path` TEXT, `cardNo` TEXT, `iscard` TEXT, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `ImUser` (`id` INTEGER, `userId` TEXT, `name` TEXT, `time` TEXT, `count` INTEGER, `videotime` TEXT, `videocount` INTEGER, PRIMARY KEY(`id`))");
                supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `reservation_sign` (`userId` TEXT NOT NULL, `signInTime` TEXT NOT NULL, `siteBookingId` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
                supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9e9b2b44e806d1b8f27c586ea6f9b750')");
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void dropAllTables(SupportSQLiteDatabase supportSQLiteDatabase) {
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `User`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `Attendance`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `ImUser`");
                supportSQLiteDatabase.execSQL("DROP TABLE IF EXISTS `reservation_sign`");
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AppDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected void onCreate(SupportSQLiteDatabase supportSQLiteDatabase) {
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AppDatabase_Impl.this.mCallbacks.get(i)).onCreate(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
                AppDatabase_Impl.this.mDatabase = supportSQLiteDatabase;
                AppDatabase_Impl.this.internalInitInvalidationTracker(supportSQLiteDatabase);
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((RoomDatabase.Callback) AppDatabase_Impl.this.mCallbacks.get(i)).onOpen(supportSQLiteDatabase);
                    }
                }
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            public void onPreMigrate(SupportSQLiteDatabase supportSQLiteDatabase) {
                DBUtil.dropFtsSyncTriggers(supportSQLiteDatabase);
            }

            @Override // androidx.room.RoomOpenHelper.Delegate
            protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase) {
                HashMap map = new HashMap(17);
                map.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, 1));
                map.put("userId", new TableInfo.Column("userId", "INTEGER", true, 0, null, 1));
                map.put(AppMeasurementSdk.ConditionalUserProperty.NAME, new TableInfo.Column(AppMeasurementSdk.ConditionalUserProperty.NAME, "TEXT", false, 0, null, 1));
                map.put("time", new TableInfo.Column("time", "TEXT", false, 0, null, 1));
                map.put("type", new TableInfo.Column("type", "INTEGER", true, 0, null, 1));
                map.put("AttenceId", new TableInfo.Column("AttenceId", "INTEGER", true, 0, null, 1));
                map.put("Timeid", new TableInfo.Column("Timeid", "INTEGER", true, 0, null, 1));
                map.put(CommentsHomeFragment.TYPE_CLASSESID, new TableInfo.Column(CommentsHomeFragment.TYPE_CLASSESID, "TEXT", false, 0, null, 1));
                map.put("identy", new TableInfo.Column("identy", "TEXT", false, 0, null, 1));
                map.put("AttenceName", new TableInfo.Column("AttenceName", "TEXT", false, 0, null, 1));
                map.put("CardNo", new TableInfo.Column("CardNo", "TEXT", false, 0, null, 1));
                map.put("photo", new TableInfo.Column("photo", "TEXT", false, 0, null, 1));
                map.put("listAttenceId", new TableInfo.Column("listAttenceId", "TEXT", false, 0, null, 1));
                map.put("siteTimetableId", new TableInfo.Column("siteTimetableId", "TEXT", false, 0, null, 1));
                map.put("ispost", new TableInfo.Column("ispost", "INTEGER", true, 0, null, 1));
                map.put("isCard", new TableInfo.Column("isCard", "TEXT", false, 0, null, 1));
                map.put("listCouseId", new TableInfo.Column("listCouseId", "TEXT", false, 0, null, 1));
                TableInfo tableInfo = new TableInfo("User", map, new HashSet(0), new HashSet(0));
                TableInfo tableInfo2 = TableInfo.read(supportSQLiteDatabase, "User");
                if (!tableInfo.equals(tableInfo2)) {
                    return new RoomOpenHelper.ValidationResult(false, "User(com.yd.android_brand_mvp.db.User).\n Expected:\n" + tableInfo + "\n Found:\n" + tableInfo2);
                }
                HashMap map2 = new HashMap(16);
                map2.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, 1));
                map2.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, 1));
                map2.put("peopleId", new TableInfo.Column("peopleId", "TEXT", false, 0, null, 1));
                map2.put("schoolId", new TableInfo.Column("schoolId", "TEXT", false, 0, null, 1));
                map2.put("attendanceId", new TableInfo.Column("attendanceId", "TEXT", false, 0, null, 1));
                map2.put("attendanceTimeId", new TableInfo.Column("attendanceTimeId", "TEXT", false, 0, null, 1));
                map2.put("attendanceName", new TableInfo.Column("attendanceName", "TEXT", false, 0, null, 1));
                map2.put("no", new TableInfo.Column("no", "TEXT", false, 0, null, 1));
                map2.put("peopleName", new TableInfo.Column("peopleName", "TEXT", false, 0, null, 1));
                map2.put("attendanceType", new TableInfo.Column("attendanceType", "TEXT", false, 0, null, 1));
                map2.put("createdDateTime", new TableInfo.Column("createdDateTime", "INTEGER", true, 0, null, 1));
                map2.put("createdBy", new TableInfo.Column("createdBy", "TEXT", false, 0, null, 1));
                map2.put("deviceName", new TableInfo.Column("deviceName", "TEXT", false, 0, null, 1));
                map2.put("path", new TableInfo.Column("path", "TEXT", false, 0, null, 1));
                map2.put("cardNo", new TableInfo.Column("cardNo", "TEXT", false, 0, null, 1));
                map2.put("iscard", new TableInfo.Column("iscard", "TEXT", false, 0, null, 1));
                TableInfo tableInfo3 = new TableInfo("Attendance", map2, new HashSet(0), new HashSet(0));
                TableInfo tableInfo4 = TableInfo.read(supportSQLiteDatabase, "Attendance");
                if (!tableInfo3.equals(tableInfo4)) {
                    return new RoomOpenHelper.ValidationResult(false, "Attendance(com.yd.android_brand_mvp.db.Attendance).\n Expected:\n" + tableInfo3 + "\n Found:\n" + tableInfo4);
                }
                HashMap map3 = new HashMap(7);
                map3.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, 1));
                map3.put("userId", new TableInfo.Column("userId", "TEXT", false, 0, null, 1));
                map3.put(AppMeasurementSdk.ConditionalUserProperty.NAME, new TableInfo.Column(AppMeasurementSdk.ConditionalUserProperty.NAME, "TEXT", false, 0, null, 1));
                map3.put("time", new TableInfo.Column("time", "TEXT", false, 0, null, 1));
                map3.put("count", new TableInfo.Column("count", "INTEGER", false, 0, null, 1));
                map3.put("videotime", new TableInfo.Column("videotime", "TEXT", false, 0, null, 1));
                map3.put("videocount", new TableInfo.Column("videocount", "INTEGER", false, 0, null, 1));
                TableInfo tableInfo5 = new TableInfo("ImUser", map3, new HashSet(0), new HashSet(0));
                TableInfo tableInfo6 = TableInfo.read(supportSQLiteDatabase, "ImUser");
                if (!tableInfo5.equals(tableInfo6)) {
                    return new RoomOpenHelper.ValidationResult(false, "ImUser(com.yd.android_brand_mvp.db.ImUser).\n Expected:\n" + tableInfo5 + "\n Found:\n" + tableInfo6);
                }
                HashMap map4 = new HashMap(4);
                map4.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, 1));
                map4.put("signInTime", new TableInfo.Column("signInTime", "TEXT", true, 0, null, 1));
                map4.put("siteBookingId", new TableInfo.Column("siteBookingId", "TEXT", true, 0, null, 1));
                map4.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, 1));
                TableInfo tableInfo7 = new TableInfo("reservation_sign", map4, new HashSet(0), new HashSet(0));
                TableInfo tableInfo8 = TableInfo.read(supportSQLiteDatabase, "reservation_sign");
                if (!tableInfo7.equals(tableInfo8)) {
                    return new RoomOpenHelper.ValidationResult(false, "reservation_sign(com.yd.android_brand_mvp.db.reservation.ReservationSignBean).\n Expected:\n" + tableInfo7 + "\n Found:\n" + tableInfo8);
                }
                return new RoomOpenHelper.ValidationResult(true, null);
            }
        }, "9e9b2b44e806d1b8f27c586ea6f9b750", "9bee81753188ebabe902fba572504c74")).build());
    }

    @Override // androidx.room.RoomDatabase
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), "User", "Attendance", "ImUser", "reservation_sign");
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = super.getOpenHelper().getWritableDatabase();
        try {
            super.beginTransaction();
            writableDatabase.execSQL("DELETE FROM `User`");
            writableDatabase.execSQL("DELETE FROM `Attendance`");
            writableDatabase.execSQL("DELETE FROM `ImUser`");
            writableDatabase.execSQL("DELETE FROM `reservation_sign`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            writableDatabase.query("PRAGMA wal_checkpoint(FULL)").close();
            if (!writableDatabase.inTransaction()) {
                writableDatabase.execSQL("VACUUM");
            }
        }
    }

    @Override // androidx.room.RoomDatabase
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap map = new HashMap();
        map.put(UserDao.class, UserDao_Impl.getRequiredConverters());
        map.put(AttendanceDao.class, AttendanceDao_Impl.getRequiredConverters());
        map.put(ImUserDao.class, ImUserDao_Impl.getRequiredConverters());
        map.put(ReservationDao.class, ReservationDao_Impl.getRequiredConverters());
        return map;
    }

    @Override // androidx.room.RoomDatabase
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> getAutoMigrations(Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Arrays.asList(new Migration[0]);
    }

    @Override // com.yd.android_brand_mvp.db.AppDatabase
    public UserDao userDao() {
        UserDao userDao;
        if (this._userDao != null) {
            return this._userDao;
        }
        synchronized (this) {
            if (this._userDao == null) {
                this._userDao = new UserDao_Impl(this);
            }
            userDao = this._userDao;
        }
        return userDao;
    }

    @Override // com.yd.android_brand_mvp.db.AppDatabase
    public AttendanceDao AttendanceDao() {
        AttendanceDao attendanceDao;
        if (this._attendanceDao != null) {
            return this._attendanceDao;
        }
        synchronized (this) {
            if (this._attendanceDao == null) {
                this._attendanceDao = new AttendanceDao_Impl(this);
            }
            attendanceDao = this._attendanceDao;
        }
        return attendanceDao;
    }

    @Override // com.yd.android_brand_mvp.db.AppDatabase
    public ImUserDao ImUserDao() {
        ImUserDao imUserDao;
        if (this._imUserDao != null) {
            return this._imUserDao;
        }
        synchronized (this) {
            if (this._imUserDao == null) {
                this._imUserDao = new ImUserDao_Impl(this);
            }
            imUserDao = this._imUserDao;
        }
        return imUserDao;
    }

    @Override // com.yd.android_brand_mvp.db.AppDatabase
    public ReservationDao reservationDao() {
        ReservationDao reservationDao;
        if (this._reservationDao != null) {
            return this._reservationDao;
        }
        synchronized (this) {
            if (this._reservationDao == null) {
                this._reservationDao = new ReservationDao_Impl(this);
            }
            reservationDao = this._reservationDao;
        }
        return reservationDao;
    }
}
