package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAttenceCartoonL2x2ListBinding implements ViewBinding {
    public final LinearLayout content;
    public final LinearLayout llIndicator;
    public final MultiStateView mu;
    public final ViewPager pager;
    private final FrameLayout rootView;

    private FragmentAttenceCartoonL2x2ListBinding(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, MultiStateView multiStateView, ViewPager viewPager) {
        this.rootView = frameLayout;
        this.content = linearLayout;
        this.llIndicator = linearLayout2;
        this.mu = multiStateView;
        this.pager = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAttenceCartoonL2x2ListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAttenceCartoonL2x2ListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_attence_cartoon_l2x2_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAttenceCartoonL2x2ListBinding bind(View view) {
        int i = R.id.content;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content);
        if (linearLayout != null) {
            i = R.id.ll_indicator;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_indicator);
            if (linearLayout2 != null) {
                i = R.id.mu;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                if (multiStateView != null) {
                    i = R.id.pager;
                    ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager);
                    if (viewPager != null) {
                        return new FragmentAttenceCartoonL2x2ListBinding((FrameLayout) view, linearLayout, linearLayout2, multiStateView, viewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
