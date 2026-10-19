package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class RoepInEveryClassAdapterItem2Binding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final TextView tvClass;
    public final TextView tvRankingInEveryClass;
    public final TextView tvScoreInEveryClass;

    private RoepInEveryClassAdapterItem2Binding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.tvClass = textView;
        this.tvRankingInEveryClass = textView2;
        this.tvScoreInEveryClass = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RoepInEveryClassAdapterItem2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RoepInEveryClassAdapterItem2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.roep_in_every_class_adapter_item2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RoepInEveryClassAdapterItem2Binding bind(View view) {
        int i = R.id.tv_class;
        TextView textView = (TextView) view.findViewById(R.id.tv_class);
        if (textView != null) {
            i = R.id.tv_ranking_in_every_class;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_ranking_in_every_class);
            if (textView2 != null) {
                i = R.id.tv_score_in_every_class;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_score_in_every_class);
                if (textView3 != null) {
                    return new RoepInEveryClassAdapterItem2Binding((ConstraintLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
