package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class LayoutImageShowPopupBinding implements ViewBinding {
    public final ImageView ivClose;
    public final ImageView ivProduction;
    private final RelativeLayout rootView;

    private LayoutImageShowPopupBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2) {
        this.rootView = relativeLayout;
        this.ivClose = imageView;
        this.ivProduction = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutImageShowPopupBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LayoutImageShowPopupBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_image_show_popup, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static LayoutImageShowPopupBinding bind(View view) {
        int i = R.id.iv_close;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_close);
        if (imageView != null) {
            i = R.id.iv_production;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_production);
            if (imageView2 != null) {
                return new LayoutImageShowPopupBinding((RelativeLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
