package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.widget.X5WebView;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityWeb3Binding implements ViewBinding {
    public final TextView back;
    private final LinearLayout rootView;
    public final X5WebView webView1;

    private ActivityWeb3Binding(LinearLayout linearLayout, TextView textView, X5WebView x5WebView) {
        this.rootView = linearLayout;
        this.back = textView;
        this.webView1 = x5WebView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityWeb3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityWeb3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_web3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityWeb3Binding bind(View view) {
        int i = R.id.back;
        TextView textView = (TextView) view.findViewById(R.id.back);
        if (textView != null) {
            i = R.id.webView1;
            X5WebView x5WebView = (X5WebView) view.findViewById(R.id.webView1);
            if (x5WebView != null) {
                return new ActivityWeb3Binding((LinearLayout) view, textView, x5WebView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
