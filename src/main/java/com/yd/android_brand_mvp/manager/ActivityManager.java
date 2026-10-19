package com.yd.android_brand_mvp.manager;

import android.app.Activity;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/yd/android_brand_mvp/manager/ActivityManager;", "", "()V", "mCurrentActivityWeakRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getCurrentActivity", "setCurrentActivity", "", PushConstants.INTENT_ACTIVITY_NAME, "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityManager {
    public static final ActivityManager INSTANCE = new ActivityManager();
    private static WeakReference<Activity> mCurrentActivityWeakRef;

    private ActivityManager() {
    }

    public final Activity getCurrentActivity() {
        WeakReference<Activity> weakReference = mCurrentActivityWeakRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final void setCurrentActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        mCurrentActivityWeakRef = new WeakReference<>(activity);
    }
}
