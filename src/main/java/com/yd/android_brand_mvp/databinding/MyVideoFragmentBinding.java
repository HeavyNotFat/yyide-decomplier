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
public final class MyVideoFragmentBinding implements ViewBinding {
    public final ChangeBanner banner;
    public final LayoutHeadTitleBinding inTop;
    public final MultiStateView mu;
    private final FrameLayout rootView;

    private MyVideoFragmentBinding(FrameLayout frameLayout, ChangeBanner changeBanner, LayoutHeadTitleBinding layoutHeadTitleBinding, MultiStateView multiStateView) {
        this.rootView = frameLayout;
        this.banner = changeBanner;
        this.inTop = layoutHeadTitleBinding;
        this.mu = multiStateView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static MyVideoFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MyVideoFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.my_video_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static MyVideoFragmentBinding bind(View view) {
        int i = R.id.banner;
        ChangeBanner changeBanner = (ChangeBanner) view.findViewById(R.id.banner);
        if (changeBanner != null) {
            i = R.id.in_top;
            View viewFindViewById = view.findViewById(R.id.in_top);
            if (viewFindViewById != null) {
                LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                if (multiStateView != null) {
                    return new MyVideoFragmentBinding((FrameLayout) view, changeBanner, layoutHeadTitleBindingBind, multiStateView);
                }
                i = R.id.mu;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
