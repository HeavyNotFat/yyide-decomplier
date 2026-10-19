package com.yd.android_brand_mvp.db;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface UserDao {
    void delete(User user);

    void deleteAll();

    void deleteAll(List<User> list);

    void deleteUsersBefore(String str);

    List<User> findById(long j);

    List<User> getAll();

    User getUserById(Long l);

    void insertAll(User... userArr);

    void update(User user);
}
