package com.yd.android_brand_mvp.data;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.yd.android_brand_mvp.data.model.LoggedInUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LoginRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u000bH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/yd/android_brand_mvp/data/LoginRepository;", "", "dataSource", "Lcom/yd/android_brand_mvp/data/LoginDataSource;", "(Lcom/yd/android_brand_mvp/data/LoginDataSource;)V", "getDataSource", "()Lcom/yd/android_brand_mvp/data/LoginDataSource;", "isLoggedIn", "", "()Z", "<set-?>", "Lcom/yd/android_brand_mvp/data/model/LoggedInUser;", "user", "getUser", "()Lcom/yd/android_brand_mvp/data/model/LoggedInUser;", FirebaseAnalytics.Event.LOGIN, "Lcom/yd/android_brand_mvp/data/Result;", "username", "", "password", "logout", "", "setLoggedInUser", "loggedInUser", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LoginRepository {
    private final LoginDataSource dataSource;
    private LoggedInUser user;

    public LoginRepository(LoginDataSource dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.dataSource = dataSource;
        this.user = null;
    }

    public final LoginDataSource getDataSource() {
        return this.dataSource;
    }

    public final LoggedInUser getUser() {
        return this.user;
    }

    public final boolean isLoggedIn() {
        return this.user != null;
    }

    public final void logout() {
        this.user = null;
        this.dataSource.logout();
    }

    public final Result<LoggedInUser> login(String username, String password) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Result<LoggedInUser> resultLogin = this.dataSource.login(username, password);
        if (resultLogin instanceof Result.Success) {
            setLoggedInUser((LoggedInUser) ((Result.Success) resultLogin).getData());
        }
        return resultLogin;
    }

    private final void setLoggedInUser(LoggedInUser loggedInUser) {
        this.user = loggedInUser;
    }
}
