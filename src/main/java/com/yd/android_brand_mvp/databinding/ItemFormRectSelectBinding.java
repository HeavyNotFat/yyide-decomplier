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
public final class ItemFormRectSelectBinding implements ViewBinding {
    public final ConstraintLayout clItemFormRectSelect;
    public final ImageView ivItemFormRectSelect;
    private final ConstraintLayout rootView;
    public final TextView tvItemFormRectSelect;

    private ItemFormRectSelectBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.clItemFormRectSelect = constraintLayout2;
        this.ivItemFormRectSelect = imageView;
        this.tvItemFormRectSelect = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemFormRectSelectBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemFormRectSelectBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_form_rect_select, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemFormRectSelectBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.iv_item_form_rect_select;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_form_rect_select);
        if (imageView != null) {
            i = R.id.tv_item_form_rect_select;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_form_rect_select);
            if (textView != null) {
                return new ItemFormRectSelectBinding(constraintLayout, constraintLayout, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
