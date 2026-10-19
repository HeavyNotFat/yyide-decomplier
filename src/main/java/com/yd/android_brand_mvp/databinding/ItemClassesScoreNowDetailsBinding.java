package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemClassesScoreNowDetailsBinding implements ViewBinding {
    public final LinearLayoutCompat llIndex;
    public final LinearLayoutCompat llRemark;
    public final LinearLayoutCompat llScoringStandard;
    private final ConstraintLayout rootView;
    public final TextView tvFirstIndex;
    public final TextView tvRemarkContent;
    public final TextView tvScore;
    public final TextView tvSecondIndex;
    public final TextView tvSeq;
    public final TextView tvStandardContent;

    private ItemClassesScoreNowDetailsBinding(ConstraintLayout constraintLayout, LinearLayoutCompat linearLayoutCompat, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.llIndex = linearLayoutCompat;
        this.llRemark = linearLayoutCompat2;
        this.llScoringStandard = linearLayoutCompat3;
        this.tvFirstIndex = textView;
        this.tvRemarkContent = textView2;
        this.tvScore = textView3;
        this.tvSecondIndex = textView4;
        this.tvSeq = textView5;
        this.tvStandardContent = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemClassesScoreNowDetailsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemClassesScoreNowDetailsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_classes_score_now_details, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemClassesScoreNowDetailsBinding bind(View view) {
        int i = R.id.ll_index;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view.findViewById(R.id.ll_index);
        if (linearLayoutCompat != null) {
            i = R.id.ll_remark;
            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) view.findViewById(R.id.ll_remark);
            if (linearLayoutCompat2 != null) {
                i = R.id.ll_scoring_standard;
                LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) view.findViewById(R.id.ll_scoring_standard);
                if (linearLayoutCompat3 != null) {
                    i = R.id.tv_first_index;
                    TextView textView = (TextView) view.findViewById(R.id.tv_first_index);
                    if (textView != null) {
                        i = R.id.tv_remark_content;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_remark_content);
                        if (textView2 != null) {
                            i = R.id.tv_score;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_score);
                            if (textView3 != null) {
                                i = R.id.tv_second_index;
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_second_index);
                                if (textView4 != null) {
                                    i = R.id.tv_seq;
                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_seq);
                                    if (textView5 != null) {
                                        i = R.id.tv_standard_content;
                                        TextView textView6 = (TextView) view.findViewById(R.id.tv_standard_content);
                                        if (textView6 != null) {
                                            return new ItemClassesScoreNowDetailsBinding((ConstraintLayout) view, linearLayoutCompat, linearLayoutCompat2, linearLayoutCompat3, textView, textView2, textView3, textView4, textView5, textView6);
                                        }
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
