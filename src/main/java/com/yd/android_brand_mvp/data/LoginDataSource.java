package com.yd.android_brand_mvp.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.data.model.LoggedInUser;
import java.io.IOException;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/yd/android_brand_mvp/data/LoginDataSource;", "", "()V", FirebaseAnalytics.Event.LOGIN, "Lcom/yd/android_brand_mvp/data/Result;", "Lcom/yd/android_brand_mvp/data/model/LoggedInUser;", "username", "", "password", "logout", "", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LoginDataSource {
    public final void logout() {
    }

    public final Result<LoggedInUser> login(String username, String password) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        try {
            String string = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
            return new Result.Success(new LoggedInUser(string, "Jane Doe"));
        } catch (Throwable th) {
            return new Result.Error(new IOException("Error logging in", th));
        }
    }
}
