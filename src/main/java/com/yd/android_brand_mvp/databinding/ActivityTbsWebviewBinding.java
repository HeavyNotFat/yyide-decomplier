package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.tencent.smtt.sdk.WebView;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityTbsWebviewBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TitleLayoutBinding topActivityTbsWeb;
    public final WebView wvActivityTbs;

    private ActivityTbsWebviewBinding(ConstraintLayout constraintLayout, TitleLayoutBinding titleLayoutBinding, WebView webView) {
        this.rootView = constraintLayout;
        this.topActivityTbsWeb = titleLayoutBinding;
        this.wvActivityTbs = webView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTbsWebviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityTbsWebviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_tbs_webview, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTbsWebviewBinding bind(View view) {
        int i = R.id.top_activity_tbs_web;
        View viewFindViewById = view.findViewById(R.id.top_activity_tbs_web);
        if (viewFindViewById != null) {
            TitleLayoutBinding titleLayoutBindingBind = TitleLayoutBinding.bind(viewFindViewById);
            WebView webView = (WebView) view.findViewById(R.id.wv_activity_tbs);
            if (webView != null) {
                return new ActivityTbsWebviewBinding((ConstraintLayout) view, titleLayoutBindingBind, webView);
            }
            i = R.id.wv_activity_tbs;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
