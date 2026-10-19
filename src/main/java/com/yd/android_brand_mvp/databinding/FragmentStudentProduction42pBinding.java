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
public final class FragmentStudentProduction42pBinding implements ViewBinding {
    public final LayoutHeadTitleBinding inTop;
    public final LinearLayout llIndicator24L;
    public final MultiStateView mu24L;
    private final FrameLayout rootView;
    public final ViewPager vpProduction24L;

    private FragmentStudentProduction42pBinding(FrameLayout frameLayout, LayoutHeadTitleBinding layoutHeadTitleBinding, LinearLayout linearLayout, MultiStateView multiStateView, ViewPager viewPager) {
        this.rootView = frameLayout;
        this.inTop = layoutHeadTitleBinding;
        this.llIndicator24L = linearLayout;
        this.mu24L = multiStateView;
        this.vpProduction24L = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentStudentProduction42pBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentStudentProduction42pBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_student_production4_2p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentStudentProduction42pBinding bind(View view) {
        int i = R.id.in_top;
        View viewFindViewById = view.findViewById(R.id.in_top);
        if (viewFindViewById != null) {
            LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
            i = R.id.ll_indicator2_4L;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_indicator2_4L);
            if (linearLayout != null) {
                i = R.id.mu2_4L;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu2_4L);
                if (multiStateView != null) {
                    i = R.id.vp_production2_4L;
                    ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp_production2_4L);
                    if (viewPager != null) {
                        return new FragmentStudentProduction42pBinding((FrameLayout) view, layoutHeadTitleBindingBind, linearLayout, multiStateView, viewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
