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
public final class ItemMessageDocumentBinding implements ViewBinding {
    public final ImageView ivItemMessageDocument;
    private final ConstraintLayout rootView;
    public final TextView tvItemMessageDocument;

    private ItemMessageDocumentBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivItemMessageDocument = imageView;
        this.tvItemMessageDocument = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemMessageDocumentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemMessageDocumentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_message_document, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemMessageDocumentBinding bind(View view) {
        int i = R.id.iv_item_message_document;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_item_message_document);
        if (imageView != null) {
            i = R.id.tv_item_message_document;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_message_document);
            if (textView != null) {
                return new ItemMessageDocumentBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
