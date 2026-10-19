package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityVideoViewPagerBinding implements ViewBinding {
    public final RelativeLayout activityDetailPlayer;
    public final TextView close;
    public final LinearLayout llIndicator;
    private final RelativeLayout rootView;
    public final ViewPager2 viewPager2;

    private ActivityVideoViewPagerBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, LinearLayout linearLayout, ViewPager2 viewPager2) {
        this.rootView = relativeLayout;
        this.activityDetailPlayer = relativeLayout2;
        this.close = textView;
        this.llIndicator = linearLayout;
        this.viewPager2 = viewPager2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityVideoViewPagerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityVideoViewPagerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_video_view_pager, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityVideoViewPagerBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R.id.close;
        TextView textView = (TextView) view.findViewById(R.id.close);
        if (textView != null) {
            i = R.id.ll_indicator;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_indicator);
            if (linearLayout != null) {
                i = R.id.view_pager2;
                ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.view_pager2);
                if (viewPager2 != null) {
                    return new ActivityVideoViewPagerBinding(relativeLayout, relativeLayout, textView, linearLayout, viewPager2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
