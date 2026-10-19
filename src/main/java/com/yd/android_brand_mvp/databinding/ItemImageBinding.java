package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemImageBinding implements ViewBinding {
    public final ImageView ivImg;
    private final FrameLayout rootView;

    private ItemImageBinding(FrameLayout frameLayout, ImageView imageView) {
        this.rootView = frameLayout;
        this.ivImg = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ItemImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_image, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemImageBinding bind(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_img);
        if (imageView != null) {
            return new ItemImageBinding((FrameLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.iv_img)));
    }
}
