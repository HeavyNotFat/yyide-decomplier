package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemCartoonMenuBinding implements ViewBinding {
    public final ConstraintLayout constraintlayout;
    public final ImageView ivCover;
    private final ConstraintLayout rootView;
    public final TextView tvMenuName;

    private ItemCartoonMenuBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.constraintlayout = constraintLayout2;
        this.ivCover = imageView;
        this.tvMenuName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemCartoonMenuBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemCartoonMenuBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_cartoon_menu, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemCartoonMenuBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.ivCover;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivCover);
        if (imageView != null) {
            i = R.id.tvMenuName;
            TextView textView = (TextView) view.findViewById(R.id.tvMenuName);
            if (textView != null) {
                return new ItemCartoonMenuBinding(constraintLayout, constraintLayout, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
