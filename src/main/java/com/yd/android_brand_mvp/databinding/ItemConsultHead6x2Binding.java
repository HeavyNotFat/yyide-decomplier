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
public final class ItemConsultHead6x2Binding implements ViewBinding {
    public final ImageView ivHead;
    private final ConstraintLayout rootView;
    public final TextView tvName;
    public final TextView tvNameText;

    private ItemConsultHead6x2Binding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.ivHead = imageView;
        this.tvName = textView;
        this.tvNameText = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemConsultHead6x2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemConsultHead6x2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_consult_head_6x2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemConsultHead6x2Binding bind(View view) {
        int i = R.id.iv_head;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_head);
        if (imageView != null) {
            i = R.id.tv_name;
            TextView textView = (TextView) view.findViewById(R.id.tv_name);
            if (textView != null) {
                i = R.id.tv_name_text;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_name_text);
                if (textView2 != null) {
                    return new ItemConsultHead6x2Binding((ConstraintLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
