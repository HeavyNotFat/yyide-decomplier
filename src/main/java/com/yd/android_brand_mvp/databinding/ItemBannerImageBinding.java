package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemBannerImageBinding implements ViewBinding {
    public final RoundedImageView ivItemBannerImage;
    private final ConstraintLayout rootView;

    private ItemBannerImageBinding(ConstraintLayout constraintLayout, RoundedImageView roundedImageView) {
        this.rootView = constraintLayout;
        this.ivItemBannerImage = roundedImageView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemBannerImageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemBannerImageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_banner_image, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemBannerImageBinding bind(View view) {
        RoundedImageView roundedImageView = (RoundedImageView) view.findViewById(R.id.iv_item_banner_image);
        if (roundedImageView != null) {
            return new ItemBannerImageBinding((ConstraintLayout) view, roundedImageView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.iv_item_banner_image)));
    }
}
