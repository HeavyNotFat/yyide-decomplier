package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomeNormalBannerBinding implements ViewBinding {
    public final Banner bannerFragmentHomeNormal;
    public final ConstraintLayout clFragmentHomeNormal;
    public final LayoutHeadTitleBinding gankInclude;
    private final ConstraintLayout rootView;
    public final ItemMinNullLayout2Binding viewEmpty;

    private FragmentHomeNormalBannerBinding(ConstraintLayout constraintLayout, Banner banner, ConstraintLayout constraintLayout2, LayoutHeadTitleBinding layoutHeadTitleBinding, ItemMinNullLayout2Binding itemMinNullLayout2Binding) {
        this.rootView = constraintLayout;
        this.bannerFragmentHomeNormal = banner;
        this.clFragmentHomeNormal = constraintLayout2;
        this.gankInclude = layoutHeadTitleBinding;
        this.viewEmpty = itemMinNullLayout2Binding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeNormalBannerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeNormalBannerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_normal_banner, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomeNormalBannerBinding bind(View view) {
        int i = R.id.banner_fragment_home_normal;
        Banner banner = (Banner) view.findViewById(R.id.banner_fragment_home_normal);
        if (banner != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.gank_include;
            View viewFindViewById = view.findViewById(R.id.gank_include);
            if (viewFindViewById != null) {
                LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                i = R.id.view_empty;
                View viewFindViewById2 = view.findViewById(R.id.view_empty);
                if (viewFindViewById2 != null) {
                    return new FragmentHomeNormalBannerBinding(constraintLayout, banner, constraintLayout, layoutHeadTitleBindingBind, ItemMinNullLayout2Binding.bind(viewFindViewById2));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
