package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityBitmapShowBinding implements ViewBinding {
    public final ImageView ivIcon;
    private final ConstraintLayout rootView;

    private ActivityBitmapShowBinding(ConstraintLayout constraintLayout, ImageView imageView) {
        this.rootView = constraintLayout;
        this.ivIcon = imageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityBitmapShowBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityBitmapShowBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_bitmap_show, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityBitmapShowBinding bind(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.ivIcon);
        if (imageView != null) {
            return new ActivityBitmapShowBinding((ConstraintLayout) view, imageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.ivIcon)));
    }
}
