package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.YDWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutYdWebViewFragmentBinding implements ViewBinding {
    public final ImageView ivClose;
    public final ProgressBar progress;
    private final ConstraintLayout rootView;
    public final TextView tvReload;
    public final YDWebView webView;

    private LayoutYdWebViewFragmentBinding(ConstraintLayout constraintLayout, ImageView imageView, ProgressBar progressBar, TextView textView, YDWebView yDWebView) {
        this.rootView = constraintLayout;
        this.ivClose = imageView;
        this.progress = progressBar;
        this.tvReload = textView;
        this.webView = yDWebView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LayoutYdWebViewFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutYdWebViewFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_yd_web_view_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutYdWebViewFragmentBinding bind(View view) {
        int i = R.id.ivClose;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivClose);
        if (imageView != null) {
            i = R.id.progress;
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress);
            if (progressBar != null) {
                i = R.id.tvReload;
                TextView textView = (TextView) view.findViewById(R.id.tvReload);
                if (textView != null) {
                    i = R.id.webView;
                    YDWebView yDWebView = (YDWebView) view.findViewById(R.id.webView);
                    if (yDWebView != null) {
                        return new LayoutYdWebViewFragmentBinding((ConstraintLayout) view, imageView, progressBar, textView, yDWebView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
