package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityYdwebViewBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ActivityYdwebViewBinding(ConstraintLayout constraintLayout) {
        this.rootView = constraintLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityYdwebViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityYdwebViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_ydweb_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityYdwebViewBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new ActivityYdwebViewBinding((ConstraintLayout) view);
    }
}
