package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityBlackBoardBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TabLayout tablayout;
    public final ViewPager viewPager;

    private ActivityBlackBoardBinding(ConstraintLayout constraintLayout, TabLayout tabLayout, ViewPager viewPager) {
        this.rootView = constraintLayout;
        this.tablayout = tabLayout;
        this.viewPager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBlackBoardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBlackBoardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_black_board, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBlackBoardBinding bind(View view) {
        int i = R.id.tablayout;
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        if (tabLayout != null) {
            i = R.id.viewPager;
            ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);
            if (viewPager != null) {
                return new ActivityBlackBoardBinding((ConstraintLayout) view, tabLayout, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
