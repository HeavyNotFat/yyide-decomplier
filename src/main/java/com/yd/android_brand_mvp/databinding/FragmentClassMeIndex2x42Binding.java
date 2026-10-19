package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.landscape.moraleducation.custom.view.CustomLinearLayout;
import com.zhpan.bannerview.BannerViewPager;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassMeIndex2x42Binding implements ViewBinding {
    public final BannerViewPager bvpClassIcon1;
    public final BannerViewPager bvpClassIcon2;
    public final BannerViewPager bvpClassIcon3;
    public final BannerViewPager bvpClassScore1;
    public final BannerViewPager bvpClassScore2;
    public final BannerViewPager bvpClassScore3;
    public final ConstraintLayout clRanking;
    public final ConstraintLayout clThisClassRanking;
    public final ConstraintLayout constraintLayout5;
    public final ImageView ivRankingPillar;
    public final ImageView ivThisClassIcon;
    public final ImageView ivVerticalBar;
    public final CustomLinearLayout llRanking;
    public final ConstraintLayout llRankingSecond;
    public final ConstraintLayout llRankingThird;
    private final ConstraintLayout rootView;
    public final TextView tvClassMoralEducation;
    public final TextView tvEnterForRankingPeople;
    public final TextView tvNoMoralEducationAppraisal;
    public final TextView tvRankingDate;
    public final TextView tvRankingFirst;
    public final TextView tvRankingSecond;
    public final TextView tvRankingThird;
    public final TextView tvThisClassName;
    public final TextView tvThisClassRanking;
    public final TextView tvThisClassRankingLabel;
    public final TextView tvThisClassScore;

    private FragmentClassMeIndex2x42Binding(ConstraintLayout constraintLayout, BannerViewPager bannerViewPager, BannerViewPager bannerViewPager2, BannerViewPager bannerViewPager3, BannerViewPager bannerViewPager4, BannerViewPager bannerViewPager5, BannerViewPager bannerViewPager6, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ImageView imageView, ImageView imageView2, ImageView imageView3, CustomLinearLayout customLinearLayout, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        this.rootView = constraintLayout;
        this.bvpClassIcon1 = bannerViewPager;
        this.bvpClassIcon2 = bannerViewPager2;
        this.bvpClassIcon3 = bannerViewPager3;
        this.bvpClassScore1 = bannerViewPager4;
        this.bvpClassScore2 = bannerViewPager5;
        this.bvpClassScore3 = bannerViewPager6;
        this.clRanking = constraintLayout2;
        this.clThisClassRanking = constraintLayout3;
        this.constraintLayout5 = constraintLayout4;
        this.ivRankingPillar = imageView;
        this.ivThisClassIcon = imageView2;
        this.ivVerticalBar = imageView3;
        this.llRanking = customLinearLayout;
        this.llRankingSecond = constraintLayout5;
        this.llRankingThird = constraintLayout6;
        this.tvClassMoralEducation = textView;
        this.tvEnterForRankingPeople = textView2;
        this.tvNoMoralEducationAppraisal = textView3;
        this.tvRankingDate = textView4;
        this.tvRankingFirst = textView5;
        this.tvRankingSecond = textView6;
        this.tvRankingThird = textView7;
        this.tvThisClassName = textView8;
        this.tvThisClassRanking = textView9;
        this.tvThisClassRankingLabel = textView10;
        this.tvThisClassScore = textView11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassMeIndex2x42Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassMeIndex2x42Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_me_index_2x4_2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassMeIndex2x42Binding bind(View view) {
        int i = R.id.bvp_class_icon1;
        BannerViewPager bannerViewPager = (BannerViewPager) view.findViewById(R.id.bvp_class_icon1);
        if (bannerViewPager != null) {
            i = R.id.bvp_class_icon2;
            BannerViewPager bannerViewPager2 = (BannerViewPager) view.findViewById(R.id.bvp_class_icon2);
            if (bannerViewPager2 != null) {
                i = R.id.bvp_class_icon3;
                BannerViewPager bannerViewPager3 = (BannerViewPager) view.findViewById(R.id.bvp_class_icon3);
                if (bannerViewPager3 != null) {
                    i = R.id.bvp_class_score1;
                    BannerViewPager bannerViewPager4 = (BannerViewPager) view.findViewById(R.id.bvp_class_score1);
                    if (bannerViewPager4 != null) {
                        i = R.id.bvp_class_score2;
                        BannerViewPager bannerViewPager5 = (BannerViewPager) view.findViewById(R.id.bvp_class_score2);
                        if (bannerViewPager5 != null) {
                            i = R.id.bvp_class_score3;
                            BannerViewPager bannerViewPager6 = (BannerViewPager) view.findViewById(R.id.bvp_class_score3);
                            if (bannerViewPager6 != null) {
                                i = R.id.cl_ranking;
                                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_ranking);
                                if (constraintLayout != null) {
                                    i = R.id.cl_this_class_ranking;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_this_class_ranking);
                                    if (constraintLayout2 != null) {
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.constraintLayout5);
                                        i = R.id.iv_ranking_pillar;
                                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_ranking_pillar);
                                        if (imageView != null) {
                                            i = R.id.iv_this_class_icon;
                                            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_this_class_icon);
                                            if (imageView2 != null) {
                                                i = R.id.iv_vertical_bar;
                                                ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_vertical_bar);
                                                if (imageView3 != null) {
                                                    i = R.id.ll_ranking;
                                                    CustomLinearLayout customLinearLayout = (CustomLinearLayout) view.findViewById(R.id.ll_ranking);
                                                    if (customLinearLayout != null) {
                                                        i = R.id.ll_ranking_second;
                                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.ll_ranking_second);
                                                        if (constraintLayout4 != null) {
                                                            i = R.id.ll_ranking_third;
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.ll_ranking_third);
                                                            if (constraintLayout5 != null) {
                                                                i = R.id.tv_class_moral_education;
                                                                TextView textView = (TextView) view.findViewById(R.id.tv_class_moral_education);
                                                                if (textView != null) {
                                                                    i = R.id.tv_enter_for_ranking_people;
                                                                    TextView textView2 = (TextView) view.findViewById(R.id.tv_enter_for_ranking_people);
                                                                    if (textView2 != null) {
                                                                        i = R.id.tv_no_moral_education_appraisal;
                                                                        TextView textView3 = (TextView) view.findViewById(R.id.tv_no_moral_education_appraisal);
                                                                        if (textView3 != null) {
                                                                            i = R.id.tv_ranking_date;
                                                                            TextView textView4 = (TextView) view.findViewById(R.id.tv_ranking_date);
                                                                            if (textView4 != null) {
                                                                                i = R.id.tv_ranking_first;
                                                                                TextView textView5 = (TextView) view.findViewById(R.id.tv_ranking_first);
                                                                                if (textView5 != null) {
                                                                                    i = R.id.tv_ranking_second;
                                                                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_ranking_second);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.tv_ranking_third;
                                                                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_ranking_third);
                                                                                        if (textView7 != null) {
                                                                                            i = R.id.tv_this_class_name;
                                                                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_this_class_name);
                                                                                            if (textView8 != null) {
                                                                                                i = R.id.tv_this_class_ranking;
                                                                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_this_class_ranking);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.tv_this_class_ranking_label;
                                                                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_this_class_ranking_label);
                                                                                                    if (textView10 != null) {
                                                                                                        i = R.id.tv_this_class_score;
                                                                                                        TextView textView11 = (TextView) view.findViewById(R.id.tv_this_class_score);
                                                                                                        if (textView11 != null) {
                                                                                                            return new FragmentClassMeIndex2x42Binding((ConstraintLayout) view, bannerViewPager, bannerViewPager2, bannerViewPager3, bannerViewPager4, bannerViewPager5, bannerViewPager6, constraintLayout, constraintLayout2, constraintLayout3, imageView, imageView2, imageView3, customLinearLayout, constraintLayout4, constraintLayout5, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11);
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
