package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentSiteInfo68Binding implements ViewBinding {
    public final Banner bannerFragmentSiteInfo46;
    public final ConstraintLayout clFragmentSiteInfo;
    public final ViewStub emptyViewBanner;
    public final ViewStub emptyViewBottom;
    public final ImageView ivBack;
    public final ImageView ivFragmentSiteInfo46;
    public final ImageView ivFragmentSiteInfo46Bottom;
    public final LinearLayout linearLayout2;
    private final ConstraintLayout rootView;
    public final TextView title;
    public final TextView tvFragmentSiteInfo46Content;
    public final TextView tvFragmentSiteInfo46Name;

    private FragmentSiteInfo68Binding(ConstraintLayout constraintLayout, Banner banner, ConstraintLayout constraintLayout2, ViewStub viewStub, ViewStub viewStub2, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.bannerFragmentSiteInfo46 = banner;
        this.clFragmentSiteInfo = constraintLayout2;
        this.emptyViewBanner = viewStub;
        this.emptyViewBottom = viewStub2;
        this.ivBack = imageView;
        this.ivFragmentSiteInfo46 = imageView2;
        this.ivFragmentSiteInfo46Bottom = imageView3;
        this.linearLayout2 = linearLayout;
        this.title = textView;
        this.tvFragmentSiteInfo46Content = textView2;
        this.tvFragmentSiteInfo46Name = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSiteInfo68Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSiteInfo68Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_site_info68, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSiteInfo68Binding bind(View view) {
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
                    i = R.id.ivBack;
                    ImageView imageView = (ImageView) view.findViewById(R.id.ivBack);
                    if (imageView != null) {
                        i = R.id.iv_fragment_site_info46;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_fragment_site_info46);
                        if (imageView2 != null) {
                            i = R.id.iv_fragment_site_info46_bottom;
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_fragment_site_info46_bottom);
                            if (imageView3 != null) {
                                i = R.id.linearLayout2;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout2);
                                if (linearLayout != null) {
                                    i = R.id.title;
                                    TextView textView = (TextView) view.findViewById(R.id.title);
                                    if (textView != null) {
                                        i = R.id.tv_fragment_site_info46_content;
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_site_info46_content);
                                        if (textView2 != null) {
                                            i = R.id.tv_fragment_site_info46_name;
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_site_info46_name);
                                            if (textView3 != null) {
                                                return new FragmentSiteInfo68Binding(constraintLayout, banner, constraintLayout, viewStub, viewStub2, imageView, imageView2, imageView3, linearLayout, textView, textView2, textView3);
                                            }
                                        }
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
