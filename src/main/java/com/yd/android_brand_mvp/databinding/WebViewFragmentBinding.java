package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDWebView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class WebViewFragmentBinding implements ViewBinding {
    public final Banner banner;
    public final ConstraintLayout clContent;
    public final FragmentContainerView container;
    private final ConstraintLayout rootView;
    public final LayoutHeadTitleBinding top;
    public final YDWebView webView;

    private WebViewFragmentBinding(ConstraintLayout constraintLayout, Banner banner, ConstraintLayout constraintLayout2, FragmentContainerView fragmentContainerView, LayoutHeadTitleBinding layoutHeadTitleBinding, YDWebView yDWebView) {
        this.rootView = constraintLayout;
        this.banner = banner;
        this.clContent = constraintLayout2;
        this.container = fragmentContainerView;
        this.top = layoutHeadTitleBinding;
        this.webView = yDWebView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WebViewFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WebViewFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.web_view_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static WebViewFragmentBinding bind(View view) {
        int i = R.id.banner;
        Banner banner = (Banner) view.findViewById(R.id.banner);
        if (banner != null) {
            i = R.id.cl_content;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_content);
            if (constraintLayout != null) {
                i = R.id.container;
                FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.container);
                if (fragmentContainerView != null) {
                    i = R.id.top;
                    View viewFindViewById = view.findViewById(R.id.top);
                    if (viewFindViewById != null) {
                        LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                        i = R.id.webView;
                        YDWebView yDWebView = (YDWebView) view.findViewById(R.id.webView);
                        if (yDWebView != null) {
                            return new WebViewFragmentBinding((ConstraintLayout) view, banner, constraintLayout, fragmentContainerView, layoutHeadTitleBindingBind, yDWebView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
