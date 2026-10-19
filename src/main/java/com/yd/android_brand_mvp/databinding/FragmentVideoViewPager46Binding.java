package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentVideoViewPager46Binding implements ViewBinding {
    public final RelativeLayout activityDetailPlayer;
    public final RelativeLayout content;
    public final LayoutHeadTitleBinding inTop;
    public final LinearLayout llIndicator;
    public final MultiStateView mu;
    private final RelativeLayout rootView;
    public final ViewPager2 viewPager2;

    private FragmentVideoViewPager46Binding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, LayoutHeadTitleBinding layoutHeadTitleBinding, LinearLayout linearLayout, MultiStateView multiStateView, ViewPager2 viewPager2) {
        this.rootView = relativeLayout;
        this.activityDetailPlayer = relativeLayout2;
        this.content = relativeLayout3;
        this.inTop = layoutHeadTitleBinding;
        this.llIndicator = linearLayout;
        this.mu = multiStateView;
        this.viewPager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentVideoViewPager46Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentVideoViewPager46Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_video_view_pager46, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentVideoViewPager46Binding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R.id.content;
        RelativeLayout relativeLayout2 = (RelativeLayout) view.findViewById(R.id.content);
        if (relativeLayout2 != null) {
            i = R.id.in_top;
            View viewFindViewById = view.findViewById(R.id.in_top);
            if (viewFindViewById != null) {
                LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                i = R.id.ll_indicator;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_indicator);
                if (linearLayout != null) {
                    i = R.id.mu;
                    MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                    if (multiStateView != null) {
                        i = R.id.view_pager2;
                        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.view_pager2);
                        if (viewPager2 != null) {
                            return new FragmentVideoViewPager46Binding(relativeLayout, relativeLayout, relativeLayout2, layoutHeadTitleBindingBind, linearLayout, multiStateView, viewPager2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
