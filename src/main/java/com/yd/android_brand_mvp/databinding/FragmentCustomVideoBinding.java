package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCustomVideoBinding implements ViewBinding {
    public final LinearLayout llIndicator;
    private final ConstraintLayout rootView;
    public final ViewPager2 viewPager2;

    private FragmentCustomVideoBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.llIndicator = linearLayout;
        this.viewPager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCustomVideoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCustomVideoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_custom_video, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCustomVideoBinding bind(View view) {
        int i = R.id.ll_indicator;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_indicator);
        if (linearLayout != null) {
            i = R.id.view_pager2;
            ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.view_pager2);
            if (viewPager2 != null) {
                return new FragmentCustomVideoBinding((ConstraintLayout) view, linearLayout, viewPager2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
