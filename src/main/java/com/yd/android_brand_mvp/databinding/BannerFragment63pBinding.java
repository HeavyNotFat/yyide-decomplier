package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.banner.manager.ChangeBanner;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class BannerFragment63pBinding implements ViewBinding {
    public final ChangeBanner banner;
    public final MultiStateView mu;
    private final FrameLayout rootView;

    private BannerFragment63pBinding(FrameLayout frameLayout, ChangeBanner changeBanner, MultiStateView multiStateView) {
        this.rootView = frameLayout;
        this.banner = changeBanner;
        this.mu = multiStateView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BannerFragment63pBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BannerFragment63pBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.banner_fragment_6_3p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BannerFragment63pBinding bind(View view) {
        int i = R.id.banner;
        ChangeBanner changeBanner = (ChangeBanner) view.findViewById(R.id.banner);
        if (changeBanner != null) {
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                return new BannerFragment63pBinding((FrameLayout) view, changeBanner, multiStateView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
