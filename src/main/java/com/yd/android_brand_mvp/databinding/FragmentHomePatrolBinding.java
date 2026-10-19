package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomePatrolBinding implements ViewBinding {
    public final ConstraintLayout clFragmentHomePatrol;
    public final ImageView ivFragmentHomePatrol;
    private final ConstraintLayout rootView;

    private FragmentHomePatrolBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView) {
        this.rootView = constraintLayout;
        this.clFragmentHomePatrol = constraintLayout2;
        this.ivFragmentHomePatrol = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomePatrolBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomePatrolBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_patrol, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomePatrolBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_fragment_home_patrol);
        if (imageView != null) {
            return new FragmentHomePatrolBinding(constraintLayout, constraintLayout, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.iv_fragment_home_patrol)));
    }
}
