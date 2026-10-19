package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutHometopviewBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final FrameLayout toplayout;
    public final TextView tvCouse;

    private LayoutHometopviewBinding(FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView) {
        this.rootView = frameLayout;
        this.toplayout = frameLayout2;
        this.tvCouse = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutHometopviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutHometopviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_hometopview, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutHometopviewBinding bind(View view) {
        int i = R.id.toplayout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.toplayout);
        if (frameLayout != null) {
            i = R.id.tv_couse;
            TextView textView = (TextView) view.findViewById(R.id.tv_couse);
            if (textView != null) {
                return new LayoutHometopviewBinding((FrameLayout) view, frameLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
