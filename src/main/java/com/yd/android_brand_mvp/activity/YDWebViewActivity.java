package com.yd.android_brand_mvp.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import com.yd.android_brand_mvp.base.BaseTimerActivity;
import com.yd.android_brand_mvp.databinding.LayoutContentBinding;
import com.yd.android_brand_mvp.landscape.YDWebViewFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: YDWebViewActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/yd/android_brand_mvp/activity/YDWebViewActivity;", "Lcom/yd/android_brand_mvp/base/BaseTimerActivity;", "()V", "viewBinding", "Lcom/yd/android_brand_mvp/databinding/LayoutContentBinding;", "getFragment", "Landroidx/fragment/app/Fragment;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_commonRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class YDWebViewActivity extends BaseTimerActivity {
    private LayoutContentBinding viewBinding;
    private static final String URL = "url";
    private static final String TITLE = "title";
    private static final String IDENTITY = "identity";

    private final Fragment getFragment() {
        return YDWebViewFragment.INSTANCE.newInstance(getIntent().getStringExtra(URL), getIntent().getStringExtra(TITLE), getIntent().getStringExtra(IDENTITY));
    }

    @Override // com.yd.android_brand_mvp.base.BaseTimerActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutContentBinding layoutContentBindingInflate = LayoutContentBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(layoutContentBindingInflate, "inflate(layoutInflater)");
        this.viewBinding = layoutContentBindingInflate;
        LayoutContentBinding layoutContentBinding = null;
        if (layoutContentBindingInflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutContentBindingInflate = null;
        }
        setContentView(layoutContentBindingInflate.getRoot());
        LayoutContentBinding layoutContentBinding2 = this.viewBinding;
        if (layoutContentBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
            layoutContentBinding2 = null;
        }
        FragmentContainerView fragmentContainerView = layoutContentBinding2.fragmentContainerView;
        FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
        LayoutContentBinding layoutContentBinding3 = this.viewBinding;
        if (layoutContentBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        } else {
            layoutContentBinding = layoutContentBinding3;
        }
        fragmentTransactionBeginTransaction.add(layoutContentBinding.fragmentContainerView.getId(), getFragment()).commit();
    }
}
