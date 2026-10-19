package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class BannerImageBinding implements ViewBinding {
    public final ImageView image;
    private final ImageView rootView;

    private BannerImageBinding(ImageView imageView, ImageView imageView2) {
        this.rootView = imageView;
        this.image = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }

    public static BannerImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BannerImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.banner_image, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BannerImageBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ImageView imageView = (ImageView) view;
        return new BannerImageBinding(imageView, imageView);
    }
}
