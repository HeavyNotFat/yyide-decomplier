package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityWelcome2Binding implements ViewBinding {
    private final FrameLayout rootView;

    private ActivityWelcome2Binding(FrameLayout frameLayout) {
        this.rootView = frameLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ActivityWelcome2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWelcome2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_welcome2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWelcome2Binding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new ActivityWelcome2Binding((FrameLayout) view);
    }
}
