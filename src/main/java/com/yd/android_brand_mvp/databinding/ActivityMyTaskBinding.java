package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityMyTaskBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TabLayout tlActivityMyTask;
    public final ViewPager2 vpActivityMyTask;

    private ActivityMyTaskBinding(ConstraintLayout constraintLayout, TabLayout tabLayout, ViewPager2 viewPager2) {
        this.rootView = constraintLayout;
        this.tlActivityMyTask = tabLayout;
        this.vpActivityMyTask = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityMyTaskBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityMyTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_my_task, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityMyTaskBinding bind(View view) {
        int i = R.id.tl_activity_my_task;
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tl_activity_my_task);
        if (tabLayout != null) {
            i = R.id.vp_activity_my_task;
            ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.vp_activity_my_task);
            if (viewPager2 != null) {
                return new ActivityMyTaskBinding((ConstraintLayout) view, tabLayout, viewPager2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
