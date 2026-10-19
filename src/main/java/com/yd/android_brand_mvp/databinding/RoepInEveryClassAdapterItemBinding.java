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
public final class RoepInEveryClassAdapterItemBinding implements ViewBinding {
    public final ImageView ivMedalOfHonor;
    private final ConstraintLayout rootView;
    public final TextView tvClass;
    public final TextView tvHonoraryTitle;
    public final TextView tvRankingInEveryClass;
    public final TextView tvScoreInEveryClass;

    private RoepInEveryClassAdapterItemBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.ivMedalOfHonor = imageView;
        this.tvClass = textView;
        this.tvHonoraryTitle = textView2;
        this.tvRankingInEveryClass = textView3;
        this.tvScoreInEveryClass = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RoepInEveryClassAdapterItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RoepInEveryClassAdapterItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.roep_in_every_class_adapter_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RoepInEveryClassAdapterItemBinding bind(View view) {
        int i = R.id.iv_medal_of_honor;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_medal_of_honor);
        if (imageView != null) {
            i = R.id.tv_class;
            TextView textView = (TextView) view.findViewById(R.id.tv_class);
            if (textView != null) {
                i = R.id.tv_honorary_title;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_honorary_title);
                if (textView2 != null) {
                    i = R.id.tv_ranking_in_every_class;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_ranking_in_every_class);
                    if (textView3 != null) {
                        i = R.id.tv_score_in_every_class;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_score_in_every_class);
                        if (textView4 != null) {
                            return new RoepInEveryClassAdapterItemBinding((ConstraintLayout) view, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
