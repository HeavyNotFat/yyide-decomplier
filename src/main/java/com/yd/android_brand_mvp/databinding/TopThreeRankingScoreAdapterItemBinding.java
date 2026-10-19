package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class TopThreeRankingScoreAdapterItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvRankingClassName;
    public final TextView tvRankingScore;

    private TopThreeRankingScoreAdapterItemBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.tvRankingClassName = textView;
        this.tvRankingScore = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static TopThreeRankingScoreAdapterItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static TopThreeRankingScoreAdapterItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.top_three_ranking_score_adapter_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static TopThreeRankingScoreAdapterItemBinding bind(View view) {
        int i = R.id.tv_ranking_class_name;
        TextView textView = (TextView) view.findViewById(R.id.tv_ranking_class_name);
        if (textView != null) {
            i = R.id.tv_ranking_score;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_ranking_score);
            if (textView2 != null) {
                return new TopThreeRankingScoreAdapterItemBinding((ConstraintLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
