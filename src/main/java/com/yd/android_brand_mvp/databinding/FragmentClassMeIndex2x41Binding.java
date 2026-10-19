package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassMeIndex2x41Binding implements ViewBinding {
    public final ConstraintLayout clRanking;
    public final ConstraintLayout clRedFlag;
    public final ImageView ivClassPhoto;
    public final ImageView ivNoData;
    public final ImageView ivRedFlag;
    public final ImageView ivVerticalBar;
    public final LinearLayout llRedFlag;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFlowRedFlag;
    public final TextView tvClassMoralEducation;
    public final TextView tvClassMoralEducationComparison;
    public final TextView tvEnterForRankingPeople;
    public final TextView tvFlowRedFlagConnection;
    public final TextView tvNoMoralEducationAppraisal;
    public final TextView tvRanking;
    public final TextView tvRankingDate;
    public final TextView tvWeekOfRanking;

    private FragmentClassMeIndex2x41Binding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.clRanking = constraintLayout2;
        this.clRedFlag = constraintLayout3;
        this.ivClassPhoto = imageView;
        this.ivNoData = imageView2;
        this.ivRedFlag = imageView3;
        this.ivVerticalBar = imageView4;
        this.llRedFlag = linearLayout;
        this.rvFlowRedFlag = recyclerView;
        this.tvClassMoralEducation = textView;
        this.tvClassMoralEducationComparison = textView2;
        this.tvEnterForRankingPeople = textView3;
        this.tvFlowRedFlagConnection = textView4;
        this.tvNoMoralEducationAppraisal = textView5;
        this.tvRanking = textView6;
        this.tvRankingDate = textView7;
        this.tvWeekOfRanking = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassMeIndex2x41Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassMeIndex2x41Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_me_index_2x4_1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassMeIndex2x41Binding bind(View view) {
        int i = R.id.cl_ranking;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_ranking);
        if (constraintLayout != null) {
            i = R.id.cl_red_flag;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_red_flag);
            if (constraintLayout2 != null) {
                i = R.id.iv_class_photo;
                ImageView imageView = (ImageView) view.findViewById(R.id.iv_class_photo);
                if (imageView != null) {
                    i = R.id.iv_no_data;
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_no_data);
                    if (imageView2 != null) {
                        i = R.id.iv_red_flag;
                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_red_flag);
                        if (imageView3 != null) {
                            i = R.id.iv_vertical_bar;
                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_vertical_bar);
                            if (imageView4 != null) {
                                i = R.id.ll_red_flag;
                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_red_flag);
                                if (linearLayout != null) {
                                    i = R.id.rv_flow_red_flag;
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_flow_red_flag);
                                    if (recyclerView != null) {
                                        i = R.id.tv_class_moral_education;
                                        TextView textView = (TextView) view.findViewById(R.id.tv_class_moral_education);
                                        if (textView != null) {
                                            i = R.id.tv_class_moral_education_comparison;
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_class_moral_education_comparison);
                                            if (textView2 != null) {
                                                i = R.id.tv_enter_for_ranking_people;
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_enter_for_ranking_people);
                                                if (textView3 != null) {
                                                    i = R.id.tv_flow_red_flag_connection;
                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_flow_red_flag_connection);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_no_moral_education_appraisal;
                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_no_moral_education_appraisal);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_ranking;
                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_ranking);
                                                            if (textView6 != null) {
                                                                i = R.id.tv_ranking_date;
                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_ranking_date);
                                                                if (textView7 != null) {
                                                                    i = R.id.tv_week_of_ranking;
                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_week_of_ranking);
                                                                    if (textView8 != null) {
                                                                        return new FragmentClassMeIndex2x41Binding((ConstraintLayout) view, constraintLayout, constraintLayout2, imageView, imageView2, imageView3, imageView4, linearLayout, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
