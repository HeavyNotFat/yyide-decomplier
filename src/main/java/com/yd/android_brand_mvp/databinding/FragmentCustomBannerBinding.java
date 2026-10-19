package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCustomBannerBinding implements ViewBinding {
    public final Banner bannerFragmentCustomBanner;
    public final ConstraintLayout clFragmentCustomBanner;
    private final ConstraintLayout rootView;
    public final LayoutHeadTitle2Binding topFragmentTitle;

    private FragmentCustomBannerBinding(ConstraintLayout constraintLayout, Banner banner, ConstraintLayout constraintLayout2, LayoutHeadTitle2Binding layoutHeadTitle2Binding) {
        this.rootView = constraintLayout;
        this.bannerFragmentCustomBanner = banner;
        this.clFragmentCustomBanner = constraintLayout2;
        this.topFragmentTitle = layoutHeadTitle2Binding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCustomBannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCustomBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_custom_banner, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCustomBannerBinding bind(View view) {
        int i = R.id.banner_fragment_custom_banner;
        Banner banner = (Banner) view.findViewById(R.id.banner_fragment_custom_banner);
        if (banner != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            View viewFindViewById = view.findViewById(R.id.top_fragment_title);
            if (viewFindViewById != null) {
                return new FragmentCustomBannerBinding(constraintLayout, banner, constraintLayout, LayoutHeadTitle2Binding.bind(viewFindViewById));
            }
            i = R.id.top_fragment_title;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
