package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemFormImageBinding implements ViewBinding {
    public final ImageView ivItemFormImage;
    public final ImageView ivItemFormImageDel;
    private final ConstraintLayout rootView;

    private ItemFormImageBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2) {
        this.rootView = constraintLayout;
        this.ivItemFormImage = imageView;
        this.ivItemFormImageDel = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemFormImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemFormImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_form_image, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemFormImageBinding bind(View view) {
        int i = R.id.iv_item_form_image;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_form_image);
        if (imageView != null) {
            i = R.id.iv_item_form_image_del;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_item_form_image_del);
            if (imageView2 != null) {
                return new ItemFormImageBinding((ConstraintLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
