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
public final class ItemHonorKidsBinding implements ViewBinding {
    public final CardView cardView4;
    public final ImageView ivCoverLab;
    private final ConstraintLayout rootView;
    public final View round;
    public final TextView tvRanking;
    public final TextView tvTime;
    public final TextView tvTimeClass;
    public final View viewTop;

    private ItemHonorKidsBinding(ConstraintLayout constraintLayout, CardView cardView, ImageView imageView, View view, TextView textView, TextView textView2, TextView textView3, View view2) {
        this.rootView = constraintLayout;
        this.cardView4 = cardView;
        this.ivCoverLab = imageView;
        this.round = view;
        this.tvRanking = textView;
        this.tvTime = textView2;
        this.tvTimeClass = textView3;
        this.viewTop = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemHonorKidsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemHonorKidsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_honor_kids, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemHonorKidsBinding bind(View view) {
        int i = R.id.cardView4;
        CardView cardView = (CardView) view.findViewById(R.id.cardView4);
        if (cardView != null) {
            i = R.id.ivCoverLab;
            ImageView imageView = (ImageView) view.findViewById(R.id.ivCoverLab);
            if (imageView != null) {
                i = R.id.round;
                View viewFindViewById = view.findViewById(R.id.round);
                if (viewFindViewById != null) {
                    i = R.id.tvRanking;
                    TextView textView = (TextView) view.findViewById(R.id.tvRanking);
                    if (textView != null) {
                        i = R.id.tvTime;
                        TextView textView2 = (TextView) view.findViewById(R.id.tvTime);
                        if (textView2 != null) {
                            i = R.id.tvTimeClass;
                            TextView textView3 = (TextView) view.findViewById(R.id.tvTimeClass);
                            if (textView3 != null) {
                                i = R.id.viewTop;
                                View viewFindViewById2 = view.findViewById(R.id.viewTop);
                                if (viewFindViewById2 != null) {
                                    return new ItemHonorKidsBinding((ConstraintLayout) view, cardView, imageView, viewFindViewById, textView, textView2, textView3, viewFindViewById2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
