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
public final class ItemEvaluationPointCardBinding implements ViewBinding {
    public final ImageView ivIcon;
    private final ConstraintLayout rootView;
    public final TextView tvName;

    private ItemEvaluationPointCardBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        this.rootView = constraintLayout;
        this.ivIcon = imageView;
        this.tvName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemEvaluationPointCardBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemEvaluationPointCardBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_evaluation_point_card, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemEvaluationPointCardBinding bind(View view) {
        int i = R.id.ivIcon;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivIcon);
        if (imageView != null) {
            i = R.id.tvName;
            TextView textView = (TextView) view.findViewById(R.id.tvName);
            if (textView != null) {
                return new ItemEvaluationPointCardBinding((ConstraintLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
