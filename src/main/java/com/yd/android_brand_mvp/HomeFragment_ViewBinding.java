package com.yd.android_brand_mvp;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class HomeFragment_ViewBinding implements Unbinder {
    private HomeFragment target;

    public HomeFragment_ViewBinding(HomeFragment homeFragment, View view) {
        this.target = homeFragment;
        homeFragment.frame = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.frame, "field 'frame'", FrameLayout.class);
        homeFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        HomeFragment homeFragment = this.target;
        if (homeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        homeFragment.frame = null;
        homeFragment.mu = null;
    }
}
