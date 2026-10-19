package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHonorScoreDetailBinding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView tvPoints;
    public final TextView tvScore;
    public final TextView tvStart;

    private FragmentHonorScoreDetailBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.recyclerView = recyclerView;
        this.tvPoints = textView;
        this.tvScore = textView2;
        this.tvStart = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHonorScoreDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHonorScoreDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_honor_score_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHonorScoreDetailBinding bind(View view) {
        int i = R.id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            i = R.id.tv_points;
            TextView textView = (TextView) view.findViewById(R.id.tv_points);
            if (textView != null) {
                i = R.id.tv_score;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_score);
                if (textView2 != null) {
                    i = R.id.tv_start;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_start);
                    if (textView3 != null) {
                        return new FragmentHonorScoreDetailBinding((ConstraintLayout) view, recyclerView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
