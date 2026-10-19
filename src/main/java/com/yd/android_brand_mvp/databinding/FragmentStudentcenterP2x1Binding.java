package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentStudentcenterP2x1Binding implements ViewBinding {
    public final Banner bannerFragment;
    public final LinearLayout content;
    public final MultiStateView mu;
    private final FrameLayout rootView;

    private FragmentStudentcenterP2x1Binding(FrameLayout frameLayout, Banner banner, LinearLayout linearLayout, MultiStateView multiStateView) {
        this.rootView = frameLayout;
        this.bannerFragment = banner;
        this.content = linearLayout;
        this.mu = multiStateView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentStudentcenterP2x1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentStudentcenterP2x1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_studentcenter_p2x1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentStudentcenterP2x1Binding bind(View view) {
        int i = R.id.banner_fragment;
        Banner banner = (Banner) view.findViewById(R.id.banner_fragment);
        if (banner != null) {
            i = R.id.content;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content);
            if (linearLayout != null) {
                i = R.id.mu;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                if (multiStateView != null) {
                    return new FragmentStudentcenterP2x1Binding((FrameLayout) view, banner, linearLayout, multiStateView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
