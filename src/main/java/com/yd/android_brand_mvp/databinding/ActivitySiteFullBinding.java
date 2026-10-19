package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivitySiteFullBinding implements ViewBinding {
    public final FragmentContainerView containerView;
    private final ConstraintLayout rootView;

    private ActivitySiteFullBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView) {
        this.rootView = constraintLayout;
        this.containerView = fragmentContainerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySiteFullBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivitySiteFullBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_site_full, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivitySiteFullBinding bind(View view) {
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.containerView);
        if (fragmentContainerView != null) {
            return new ActivitySiteFullBinding((ConstraintLayout) view, fragmentContainerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.containerView)));
    }
}
