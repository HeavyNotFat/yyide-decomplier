package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.view.ExtendedWebView;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemDominateMessageBinding implements ViewBinding {
    public final ImageView ivContent;
    private final ConstraintLayout rootView;
    public final ExtendedWebView webView;

    private ItemDominateMessageBinding(ConstraintLayout constraintLayout, ImageView imageView, ExtendedWebView extendedWebView) {
        this.rootView = constraintLayout;
        this.ivContent = imageView;
        this.webView = extendedWebView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemDominateMessageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemDominateMessageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_dominate_message, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemDominateMessageBinding bind(View view) {
        int i = R.id.ivContent;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivContent);
        if (imageView != null) {
            i = R.id.webView;
            ExtendedWebView extendedWebView = (ExtendedWebView) view.findViewById(R.id.webView);
            if (extendedWebView != null) {
                return new ItemDominateMessageBinding((ConstraintLayout) view, imageView, extendedWebView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
