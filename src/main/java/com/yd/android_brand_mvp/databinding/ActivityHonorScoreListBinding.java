package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityHonorScoreListBinding implements ViewBinding {
    public final CardView cardView;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;
    public final TextView textView50;
    public final TextView tvNameDesc;

    private ActivityHonorScoreListBinding(ConstraintLayout constraintLayout, CardView cardView, RecyclerView recyclerView, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.cardView = cardView;
        this.recyclerView = recyclerView;
        this.textView50 = textView;
        this.tvNameDesc = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityHonorScoreListBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityHonorScoreListBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_honor_score_list, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityHonorScoreListBinding bind(View view) {
        int i = R.id.cardView;
        CardView cardView = (CardView) view.findViewById(R.id.cardView);
        if (cardView != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                i = R.id.textView50;
                TextView textView = (TextView) view.findViewById(R.id.textView50);
                if (textView != null) {
                    i = R.id.tvNameDesc;
                    TextView textView2 = (TextView) view.findViewById(R.id.tvNameDesc);
                    if (textView2 != null) {
                        return new ActivityHonorScoreListBinding((ConstraintLayout) view, cardView, recyclerView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
