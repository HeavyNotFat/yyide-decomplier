package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class WebViewFragment64Binding implements ViewBinding {
    private final FrameLayout rootView;
    public final WebView webView;

    private WebViewFragment64Binding(FrameLayout frameLayout, WebView webView) {
        this.rootView = frameLayout;
        this.webView = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static WebViewFragment64Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WebViewFragment64Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.web_view_fragment_6_4, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static WebViewFragment64Binding bind(View view) {
        WebView webView = (WebView) view.findViewById(R.id.webView);
        if (webView != null) {
            return new WebViewFragment64Binding((FrameLayout) view, webView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.webView)));
    }
}
