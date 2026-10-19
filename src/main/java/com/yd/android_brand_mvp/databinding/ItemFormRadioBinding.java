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
public final class ItemFormRadioBinding implements ViewBinding {
    public final ImageView ivItemFormRadioSelect;
    private final ConstraintLayout rootView;
    public final TextView tvItemFormRadioName;

    private ItemFormRadioBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivItemFormRadioSelect = imageView;
        this.tvItemFormRadioName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemFormRadioBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemFormRadioBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_form_radio, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemFormRadioBinding bind(View view) {
        int i = R.id.iv_item_form_radio_select;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_form_radio_select);
        if (imageView != null) {
            i = R.id.tv_item_form_radio_name;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_form_radio_name);
            if (textView != null) {
                return new ItemFormRadioBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
