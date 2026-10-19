package com.yd.android_brand_mvp.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.yd.android_brand_mvp.databinding.ActivitySiteFullBinding;
import com.yd.android_brand_mvp.landscape.SiteFullScreenFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SiteFullActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/yd/android_brand_mvp/activity/SiteFullActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/yd/android_brand_mvp/databinding/ActivitySiteFullBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SiteFullActivity extends AppCompatActivity {
    private ActivitySiteFullBinding binding;

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySiteFullBinding activitySiteFullBindingInflate = ActivitySiteFullBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(activitySiteFullBindingInflate, "inflate(layoutInflater)");
        this.binding = activitySiteFullBindingInflate;
        ActivitySiteFullBinding activitySiteFullBinding = null;
        if (activitySiteFullBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activitySiteFullBindingInflate = null;
        }
        setContentView(activitySiteFullBindingInflate.getRoot());
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        ActivitySiteFullBinding activitySiteFullBinding2 = this.binding;
        if (activitySiteFullBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activitySiteFullBinding = activitySiteFullBinding2;
        }
        fragmentTransactionBeginTransaction.replace(activitySiteFullBinding.containerView.getId(), SiteFullScreenFragment.INSTANCE.newInstance()).commit();
    }
}
