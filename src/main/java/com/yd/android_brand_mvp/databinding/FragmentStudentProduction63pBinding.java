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
public final class FragmentStudentProduction63pBinding implements ViewBinding {
    public final LayoutHeadTitleBinding inTop;
    public final LinearLayout llIndicator63;
    public final MultiStateView mu63;
    private final FrameLayout rootView;
    public final ViewPager vpProduction63;

    private FragmentStudentProduction63pBinding(FrameLayout frameLayout, LayoutHeadTitleBinding layoutHeadTitleBinding, LinearLayout linearLayout, MultiStateView multiStateView, ViewPager viewPager) {
        this.rootView = frameLayout;
        this.inTop = layoutHeadTitleBinding;
        this.llIndicator63 = linearLayout;
        this.mu63 = multiStateView;
        this.vpProduction63 = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentStudentProduction63pBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentStudentProduction63pBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_student_production6_3p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentStudentProduction63pBinding bind(View view) {
        int i = R.id.in_top;
        View viewFindViewById = view.findViewById(R.id.in_top);
        if (viewFindViewById != null) {
            LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
            i = R.id.ll_indicator6_3;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_indicator6_3);
            if (linearLayout != null) {
                i = R.id.mu6_3;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu6_3);
                if (multiStateView != null) {
                    i = R.id.vp_production6_3;
                    ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp_production6_3);
                    if (viewPager != null) {
                        return new FragmentStudentProduction63pBinding((FrameLayout) view, layoutHeadTitleBindingBind, linearLayout, multiStateView, viewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
