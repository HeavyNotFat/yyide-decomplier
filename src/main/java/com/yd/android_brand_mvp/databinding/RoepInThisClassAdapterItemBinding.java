package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class RoepInThisClassAdapterItemBinding implements ViewBinding {
    public final ImageView ivMedalOfHonor;
    private final LinearLayout rootView;
    public final TextView tvActivityCycle;
    public final TextView tvActivityCycleLabel;
    public final TextView tvCurrentCycleLabel;
    public final TextView tvHonoraryTitle;
    public final TextView tvHonoraryTitleLabel;
    public final TextView tvMedalOfHonorLabel;
    public final TextView tvNoMedalOfHonor;
    public final TextView tvRankingInThisClass;
    public final TextView tvRankingInThisClassLabel;
    public final TextView tvScoreInThisClass;
    public final TextView tvScoreInThisClassLabel;

    private RoepInThisClassAdapterItemBinding(LinearLayout linearLayout, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = linearLayout;
        this.ivMedalOfHonor = imageView;
        this.tvActivityCycle = textView;
        this.tvActivityCycleLabel = textView2;
        this.tvCurrentCycleLabel = textView3;
        this.tvHonoraryTitle = textView4;
        this.tvHonoraryTitleLabel = textView5;
        this.tvMedalOfHonorLabel = textView6;
        this.tvNoMedalOfHonor = textView7;
        this.tvRankingInThisClass = textView8;
        this.tvRankingInThisClassLabel = textView9;
        this.tvScoreInThisClass = textView10;
        this.tvScoreInThisClassLabel = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RoepInThisClassAdapterItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RoepInThisClassAdapterItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.roep_in_this_class_adapter_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static RoepInThisClassAdapterItemBinding bind(View view) {
        int i = R.id.iv_medal_of_honor;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_medal_of_honor);
        if (imageView != null) {
            i = R.id.tv_activity_cycle;
            TextView textView = (TextView) view.findViewById(R.id.tv_activity_cycle);
            if (textView != null) {
                i = R.id.tv_activity_cycle_label;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_activity_cycle_label);
                if (textView2 != null) {
                    i = R.id.tv_current_cycle_label;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_current_cycle_label);
                    if (textView3 != null) {
                        i = R.id.tv_honorary_title;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_honorary_title);
                        if (textView4 != null) {
                            i = R.id.tv_honorary_title_label;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_honorary_title_label);
                            if (textView5 != null) {
                                i = R.id.tv_medal_of_honor_label;
                                TextView textView6 = (TextView) view.findViewById(R.id.tv_medal_of_honor_label);
                                if (textView6 != null) {
                                    i = R.id.tv_no_medal_of_honor;
                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_no_medal_of_honor);
                                    if (textView7 != null) {
                                        i = R.id.tv_ranking_in_this_class;
                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_ranking_in_this_class);
                                        if (textView8 != null) {
                                            i = R.id.tv_ranking_in_this_class_label;
                                            TextView textView9 = (TextView) view.findViewById(R.id.tv_ranking_in_this_class_label);
                                            if (textView9 != null) {
                                                i = R.id.tv_score_in_this_class;
                                                TextView textView10 = (TextView) view.findViewById(R.id.tv_score_in_this_class);
                                                if (textView10 != null) {
                                                    i = R.id.tv_score_in_this_class_label;
                                                    TextView textView11 = (TextView) view.findViewById(R.id.tv_score_in_this_class_label);
                                                    if (textView11 != null) {
                                                        return new RoepInThisClassAdapterItemBinding((LinearLayout) view, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
                                                    }
                                                }
                                            }
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
