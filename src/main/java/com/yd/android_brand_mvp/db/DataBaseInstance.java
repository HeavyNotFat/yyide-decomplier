package com.yd.android_brand_mvp.db;

import android.content.Context;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes4.dex */
public class DataBaseInstance {
    static AppDatabase instance;
    static final Migration MIGRATION_1_2 = new Migration(1, 2) { // from class: com.yd.android_brand_mvp.db.DataBaseInstance.1
        @Override // androidx.room.migration.Migration
        public void migrate(SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    };
    public static String DBName = "bp6.0.db";

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = (AppDatabase) Room.databaseBuilder(context, AppDatabase.class, DBName).fallbackToDestructiveMigration().build();
                }
            }
        }
        return instance;
    }
}
