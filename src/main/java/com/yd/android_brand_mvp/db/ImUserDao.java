package com.yd.android_brand_mvp.db;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ImUserDao {
    void delete(ImUser imUser);

    void deleteAll();

    List<ImUser> findById(String str);

    List<ImUser> getAll();

    void insertAll(ImUser... imUserArr);

    void update(ImUser imUser);
}
