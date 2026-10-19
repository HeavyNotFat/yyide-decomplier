package com.yd.android_brand_mvp.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.yd.android_brand_mvp.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GetVersionUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/yd/android_brand_mvp/utils/GetVersionUtils;", "", "()V", "getApkVersionName", "", "context", "Landroid/content/Context;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class GetVersionUtils {
    public static final GetVersionUtils INSTANCE = new GetVersionUtils();

    private GetVersionUtils() {
    }

    public final String getApkVersionName(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(BuildConfig.APPLICATION_ID, 0);
            Intrinsics.checkNotNullExpressionValue(packageInfo, "context.packageManager.g…yd.android_brand_mvp\", 0)");
            String str = packageInfo.versionName;
            Intrinsics.checkNotNullExpressionValue(str, "packInfo.versionName");
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
