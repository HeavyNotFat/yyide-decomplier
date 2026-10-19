package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityXxxxxBinding implements ViewBinding {
    public final ConstraintLayout main;
    private final ConstraintLayout rootView;

    private ActivityXxxxxBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.main = constraintLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityXxxxxBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityXxxxxBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_xxxxx, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityXxxxxBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        return new ActivityXxxxxBinding(constraintLayout, constraintLayout);
    }
}
