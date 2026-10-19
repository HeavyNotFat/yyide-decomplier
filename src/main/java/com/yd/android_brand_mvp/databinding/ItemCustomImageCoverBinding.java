package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemCustomImageCoverBinding implements ViewBinding {
    public final ImageView ivCover;
    private final LinearLayoutCompat rootView;

    private ItemCustomImageCoverBinding(LinearLayoutCompat linearLayoutCompat, ImageView imageView) {
        this.rootView = linearLayoutCompat;
        this.ivCover = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static ItemCustomImageCoverBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemCustomImageCoverBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_custom_image_cover, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemCustomImageCoverBinding bind(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.ivCover);
        if (imageView != null) {
            return new ItemCustomImageCoverBinding((LinearLayoutCompat) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.ivCover)));
    }
}
