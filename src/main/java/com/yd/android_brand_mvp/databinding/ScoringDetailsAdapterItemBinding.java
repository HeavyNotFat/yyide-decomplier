package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ScoringDetailsAdapterItemBinding implements ViewBinding {
    public final LinearLayout llSerialNumber;
    private final ConstraintLayout rootView;
    public final TextView tvFirstIndex;
    public final TextView tvScore;
    public final TextView tvScoreRemarks;
    public final TextView tvScoringCriteria;
    public final TextView tvSecondIndex;
    public final TextView tvSerialNumber;
    public final TextView tvTime;

    private ScoringDetailsAdapterItemBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = constraintLayout;
        this.llSerialNumber = linearLayout;
        this.tvFirstIndex = textView;
        this.tvScore = textView2;
        this.tvScoreRemarks = textView3;
        this.tvScoringCriteria = textView4;
        this.tvSecondIndex = textView5;
        this.tvSerialNumber = textView6;
        this.tvTime = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ScoringDetailsAdapterItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ScoringDetailsAdapterItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.scoring_details_adapter_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ScoringDetailsAdapterItemBinding bind(View view) {
        int i = R.id.ll_serial_number;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_serial_number);
        if (linearLayout != null) {
            i = R.id.tv_first_index;
            TextView textView = (TextView) view.findViewById(R.id.tv_first_index);
            if (textView != null) {
                i = R.id.tv_score;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_score);
                if (textView2 != null) {
                    i = R.id.tv_score_remarks;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_score_remarks);
                    if (textView3 != null) {
                        i = R.id.tv_scoring_criteria;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_scoring_criteria);
                        if (textView4 != null) {
                            i = R.id.tv_second_index;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_second_index);
                            if (textView5 != null) {
                                i = R.id.tv_serial_number;
                                TextView textView6 = (TextView) view.findViewById(R.id.tv_serial_number);
                                if (textView6 != null) {
                                    i = R.id.tv_time;
                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_time);
                                    if (textView7 != null) {
                                        return new ScoringDetailsAdapterItemBinding((ConstraintLayout) view, linearLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7);
                                    }
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
