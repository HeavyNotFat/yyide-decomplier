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
public final class FragmentAssignment24pBinding implements ViewBinding {
    public final LayoutHeadTitleBinding inTop;
    public final LinearLayout llIndicator;
    public final MultiStateView mu;
    private final FrameLayout rootView;
    public final ViewPager vpAssignment;

    private FragmentAssignment24pBinding(FrameLayout frameLayout, LayoutHeadTitleBinding layoutHeadTitleBinding, LinearLayout linearLayout, MultiStateView multiStateView, ViewPager viewPager) {
        this.rootView = frameLayout;
        this.inTop = layoutHeadTitleBinding;
        this.llIndicator = linearLayout;
        this.mu = multiStateView;
        this.vpAssignment = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAssignment24pBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAssignment24pBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_assignment2_4p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAssignment24pBinding bind(View view) {
        int i = R.id.in_top;
        View viewFindViewById = view.findViewById(R.id.in_top);
        if (viewFindViewById != null) {
            LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
            i = R.id.ll_indicator;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_indicator);
            if (linearLayout != null) {
                i = R.id.mu;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                if (multiStateView != null) {
                    i = R.id.vp_assignment;
                    ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp_assignment);
                    if (viewPager != null) {
                        return new FragmentAssignment24pBinding((FrameLayout) view, layoutHeadTitleBindingBind, linearLayout, multiStateView, viewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
