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
public final class ItemHonorClassBinding implements ViewBinding {
    public final ImageView ivCover;
    public final ImageView ivCoverLab;
    private final ConstraintLayout rootView;
    public final TextView tvRanking;
    public final TextView tvTime;
    public final TextView tvTitle;

    private ItemHonorClassBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.ivCover = imageView;
        this.ivCoverLab = imageView2;
        this.tvRanking = textView;
        this.tvTime = textView2;
        this.tvTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemHonorClassBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemHonorClassBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_honor_class, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemHonorClassBinding bind(View view) {
        int i = R.id.ivCover;
        ImageView imageView = (ImageView) view.findViewById(R.id.ivCover);
        if (imageView != null) {
            i = R.id.ivCoverLab;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.ivCoverLab);
            if (imageView2 != null) {
                i = R.id.tvRanking;
                TextView textView = (TextView) view.findViewById(R.id.tvRanking);
                if (textView != null) {
                    i = R.id.tvTime;
                    TextView textView2 = (TextView) view.findViewById(R.id.tvTime);
                    if (textView2 != null) {
                        i = R.id.tvTitle;
                        TextView textView3 = (TextView) view.findViewById(R.id.tvTitle);
                        if (textView3 != null) {
                            return new ItemHonorClassBinding((ConstraintLayout) view, imageView, imageView2, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
