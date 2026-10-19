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
public final class ItemFormFileBinding implements ViewBinding {
    public final ImageView ivItemFormFile;
    public final ImageView ivItemFormFileDel;
    private final ConstraintLayout rootView;
    public final TextView tvItemFormFileName;

    private ItemFormFileBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        this.rootView = constraintLayout;
        this.ivItemFormFile = imageView;
        this.ivItemFormFileDel = imageView2;
        this.tvItemFormFileName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemFormFileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemFormFileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_form_file, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemFormFileBinding bind(View view) {
        int i = R.id.iv_item_form_file;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_form_file);
        if (imageView != null) {
            i = R.id.iv_item_form_file_del;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_item_form_file_del);
            if (imageView2 != null) {
                i = R.id.tv_item_form_file_name;
                TextView textView = (TextView) view.findViewById(R.id.tv_item_form_file_name);
                if (textView != null) {
                    return new ItemFormFileBinding((ConstraintLayout) view, imageView, imageView2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
