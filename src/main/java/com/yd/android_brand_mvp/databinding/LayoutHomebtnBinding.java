package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutHomebtnBinding implements ViewBinding {
    public final ImageView homeBtn;
    private final FrameLayout rootView;

    private LayoutHomebtnBinding(FrameLayout frameLayout, ImageView imageView) {
        this.rootView = frameLayout;
        this.homeBtn = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LayoutHomebtnBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutHomebtnBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_homebtn, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutHomebtnBinding bind(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.home_btn);
        if (imageView != null) {
            return new LayoutHomebtnBinding((FrameLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.home_btn)));
    }
}
