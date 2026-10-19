package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.to.aboomy.pager2banner.Banner;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class BannerImageFragment46Binding implements ViewBinding {
    public final Banner banner;
    public final LinearLayout content;
    public final LayoutHeadTitleBinding inTop;
    public final MultiStateView mu;
    private final FrameLayout rootView;
    public final TextView tvIndex;

    private BannerImageFragment46Binding(FrameLayout frameLayout, Banner banner, LinearLayout linearLayout, LayoutHeadTitleBinding layoutHeadTitleBinding, MultiStateView multiStateView, TextView textView) {
        this.rootView = frameLayout;
        this.banner = banner;
        this.content = linearLayout;
        this.inTop = layoutHeadTitleBinding;
        this.mu = multiStateView;
        this.tvIndex = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BannerImageFragment46Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BannerImageFragment46Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.banner_image_fragment46, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BannerImageFragment46Binding bind(View view) {
        int i = R.id.banner;
        Banner banner = (Banner) view.findViewById(R.id.banner);
        if (banner != null) {
            i = R.id.content;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content);
            if (linearLayout != null) {
                i = R.id.in_top;
                View viewFindViewById = view.findViewById(R.id.in_top);
                if (viewFindViewById != null) {
                    LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                    i = R.id.mu;
                    MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                    if (multiStateView != null) {
                        i = R.id.tv_index;
                        TextView textView = (TextView) view.findViewById(R.id.tv_index);
                        if (textView != null) {
                            return new BannerImageFragment46Binding((FrameLayout) view, banner, linearLayout, layoutHeadTitleBindingBind, multiStateView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
