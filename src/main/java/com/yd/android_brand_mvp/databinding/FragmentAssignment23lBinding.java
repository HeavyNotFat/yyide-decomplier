package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAssignment23lBinding implements ViewBinding {
    public final LinearLayout llIndicator;
    public final LinearLayout llTop;
    public final MultiStateView mu;
    private final FrameLayout rootView;
    public final TextView title;
    public final ViewPager vpAssignment;

    private FragmentAssignment23lBinding(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, MultiStateView multiStateView, TextView textView, ViewPager viewPager) {
        this.rootView = frameLayout;
        this.llIndicator = linearLayout;
        this.llTop = linearLayout2;
        this.mu = multiStateView;
        this.title = textView;
        this.vpAssignment = viewPager;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAssignment23lBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAssignment23lBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_assignment2_3l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAssignment23lBinding bind(View view) {
        int i = R.id.ll_indicator;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_indicator);
        if (linearLayout != null) {
            i = R.id.ll_top;
            LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_top);
            if (linearLayout2 != null) {
                i = R.id.mu;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                if (multiStateView != null) {
                    i = R.id.title;
                    TextView textView = (TextView) view.findViewById(R.id.title);
                    if (textView != null) {
                        i = R.id.vp_assignment;
                        ViewPager viewPager = (ViewPager) view.findViewById(R.id.vp_assignment);
                        if (viewPager != null) {
                            return new FragmentAssignment23lBinding((FrameLayout) view, linearLayout, linearLayout2, multiStateView, textView, viewPager);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
