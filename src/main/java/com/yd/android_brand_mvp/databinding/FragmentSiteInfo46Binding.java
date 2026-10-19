package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentSiteInfo46Binding implements ViewBinding {
    public final Banner bannerFragmentSiteInfo46;
    public final ConstraintLayout clFragmentSiteInfo;
    public final ViewStub emptyViewBanner;
    public final ViewStub emptyViewBottom;
    public final ImageView ivFragmentSiteInfo46;
    public final ImageView ivFragmentSiteInfo46Bottom;
    private final ConstraintLayout rootView;
    public final LayoutHeadTitleBinding topFragmentSiteInfo46;
    public final TextView tvFragmentSiteInfo46Content;
    public final TextView tvFragmentSiteInfo46Name;

    private FragmentSiteInfo46Binding(ConstraintLayout constraintLayout, Banner banner, ConstraintLayout constraintLayout2, ViewStub viewStub, ViewStub viewStub2, ImageView imageView, ImageView imageView2, LayoutHeadTitleBinding layoutHeadTitleBinding, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.bannerFragmentSiteInfo46 = banner;
        this.clFragmentSiteInfo = constraintLayout2;
        this.emptyViewBanner = viewStub;
        this.emptyViewBottom = viewStub2;
        this.ivFragmentSiteInfo46 = imageView;
        this.ivFragmentSiteInfo46Bottom = imageView2;
        this.topFragmentSiteInfo46 = layoutHeadTitleBinding;
        this.tvFragmentSiteInfo46Content = textView;
        this.tvFragmentSiteInfo46Name = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSiteInfo46Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSiteInfo46Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_site_info46, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSiteInfo46Binding bind(View view) {
        int i = R.id.banner_fragment_site_info46;
        Banner banner = (Banner) view.findViewById(R.id.banner_fragment_site_info46);
        if (banner != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.empty_view_banner;
            ViewStub viewStub = (ViewStub) view.findViewById(R.id.empty_view_banner);
            if (viewStub != null) {
                i = R.id.empty_view_bottom;
                ViewStub viewStub2 = (ViewStub) view.findViewById(R.id.empty_view_bottom);
                if (viewStub2 != null) {
                    i = R.id.iv_fragment_site_info46;
                    ImageView imageView = (ImageView) view.findViewById(R.id.iv_fragment_site_info46);
                    if (imageView != null) {
                        i = R.id.iv_fragment_site_info46_bottom;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_fragment_site_info46_bottom);
                        if (imageView2 != null) {
                            i = R.id.top_fragment_site_info46;
                            View viewFindViewById = view.findViewById(R.id.top_fragment_site_info46);
                            if (viewFindViewById != null) {
                                LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                                i = R.id.tv_fragment_site_info46_content;
                                TextView textView = (TextView) view.findViewById(R.id.tv_fragment_site_info46_content);
                                if (textView != null) {
                                    i = R.id.tv_fragment_site_info46_name;
                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_site_info46_name);
                                    if (textView2 != null) {
                                        return new FragmentSiteInfo46Binding(constraintLayout, banner, constraintLayout, viewStub, viewStub2, imageView, imageView2, layoutHeadTitleBindingBind, textView, textView2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
