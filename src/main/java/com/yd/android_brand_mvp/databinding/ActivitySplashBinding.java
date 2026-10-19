package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivitySplashBinding implements ViewBinding {
    public final RelativeLayout flashView;
    private final RelativeLayout rootView;

    private ActivitySplashBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2) {
        this.rootView = relativeLayout;
        this.flashView = relativeLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySplashBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_splash, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySplashBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        RelativeLayout relativeLayout = (RelativeLayout) view;
        return new ActivitySplashBinding(relativeLayout, relativeLayout);
    }
}
