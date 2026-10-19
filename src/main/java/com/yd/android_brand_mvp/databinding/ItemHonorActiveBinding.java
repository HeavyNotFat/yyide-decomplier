package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemHonorActiveBinding implements ViewBinding {
    public final CardView cardViewState;
    public final ImageView ivCover;
    private final ConstraintLayout rootView;
    public final TextView tvContent;
    public final TextView tvState;
    public final TextView tvTime;
    public final TextView tvTitle;

    private ItemHonorActiveBinding(ConstraintLayout constraintLayout, CardView cardView, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.cardViewState = cardView;
        this.ivCover = imageView;
        this.tvContent = textView;
        this.tvState = textView2;
        this.tvTime = textView3;
        this.tvTitle = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemHonorActiveBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemHonorActiveBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_honor_active, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemHonorActiveBinding bind(View view) {
        int i = R.id.cardViewState;
        CardView cardView = (CardView) view.findViewById(R.id.cardViewState);
        if (cardView != null) {
            i = R.id.ivCover;
            ImageView imageView = (ImageView) view.findViewById(R.id.ivCover);
            if (imageView != null) {
                i = R.id.tvContent;
                TextView textView = (TextView) view.findViewById(R.id.tvContent);
                if (textView != null) {
                    i = R.id.tvState;
                    TextView textView2 = (TextView) view.findViewById(R.id.tvState);
                    if (textView2 != null) {
                        i = R.id.tvTime;
                        TextView textView3 = (TextView) view.findViewById(R.id.tvTime);
                        if (textView3 != null) {
                            i = R.id.tvTitle;
                            TextView textView4 = (TextView) view.findViewById(R.id.tvTitle);
                            if (textView4 != null) {
                                return new ItemHonorActiveBinding((ConstraintLayout) view, cardView, imageView, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
