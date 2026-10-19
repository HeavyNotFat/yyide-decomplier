package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemDormitoryEducationRankingBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvItemDormitoryEducationRankingNumber;
    public final TextView tvItemDormitoryEducationRankingRanking;
    public final TextView tvItemDormitoryEducationRankingScore;
    public final View viewLine;

    private ItemDormitoryEducationRankingBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, View view) {
        this.rootView = constraintLayout;
        this.tvItemDormitoryEducationRankingNumber = textView;
        this.tvItemDormitoryEducationRankingRanking = textView2;
        this.tvItemDormitoryEducationRankingScore = textView3;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemDormitoryEducationRankingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemDormitoryEducationRankingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_dormitory_education_ranking, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemDormitoryEducationRankingBinding bind(View view) {
        int i = R.id.tv_item_dormitory_education_ranking_number;
        TextView textView = (TextView) view.findViewById(R.id.tv_item_dormitory_education_ranking_number);
        if (textView != null) {
            i = R.id.tv_item_dormitory_education_ranking_ranking;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_item_dormitory_education_ranking_ranking);
            if (textView2 != null) {
                i = R.id.tv_item_dormitory_education_ranking_score;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_item_dormitory_education_ranking_score);
                if (textView3 != null) {
                    i = R.id.view_line;
                    View viewFindViewById = view.findViewById(R.id.view_line);
                    if (viewFindViewById != null) {
                        return new ItemDormitoryEducationRankingBinding((ConstraintLayout) view, textView, textView2, textView3, viewFindViewById);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
