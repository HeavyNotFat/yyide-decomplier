package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAttenceP42ListBinding implements ViewBinding {
    public final LinearLayout content;
    public final LinearLayout llIndicator;
    public final MultiStateView mu;
    public final ViewPager pager;
    public final TextView post;
    public final RelativeLayout rlAtt;
    private final FrameLayout rootView;

    private FragmentAttenceP42ListBinding(FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, MultiStateView multiStateView, ViewPager viewPager, TextView textView, RelativeLayout relativeLayout) {
        this.rootView = frameLayout;
        this.content = linearLayout;
        this.llIndicator = linearLayout2;
        this.mu = multiStateView;
        this.pager = viewPager;
        this.post = textView;
        this.rlAtt = relativeLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAttenceP42ListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAttenceP42ListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_attence_p4_2_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAttenceP42ListBinding bind(View view) {
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
                        i = R.id.post;
                        TextView textView = (TextView) view.findViewById(R.id.post);
                        if (textView != null) {
                            i = R.id.rl_att;
                            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.rl_att);
                            if (relativeLayout != null) {
                                return new FragmentAttenceP42ListBinding((FrameLayout) view, linearLayout, linearLayout2, multiStateView, viewPager, textView, relativeLayout);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
