package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.zhpan.bannerview.BannerViewPager;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentRoepInEveryClassBinding implements ViewBinding {
    public final BannerViewPager bvpClassIcon1;
    public final BannerViewPager bvpClassIcon2;
    public final BannerViewPager bvpClassIcon3;
    public final BannerViewPager bvpClassScore1;
    public final BannerViewPager bvpClassScore2;
    public final BannerViewPager bvpClassScore3;
    public final ConstraintLayout clRanking;
    public final ConstraintLayout clRankingCurrentWeekInThisClass;
    public final ConstraintLayout clRankingLastWeekInThisClass;
    public final ConstraintLayout clTitleForCurrentWeek;
    public final ConstraintLayout clTitleForLastWeek;
    public final ConstraintLayout clTitles;
    public final ImageView ivRankingPillar;
    public final ConstraintLayout llRankingFirst;
    public final ConstraintLayout llRankingSecond;
    public final ConstraintLayout llRankingThird;
    public final RadioButton rbRankingForCurrentWeek;
    public final RadioButton rbRankingForLastWeek;
    public final RadioGroup rgWeek;
    private final ConstraintLayout rootView;
    public final RecyclerView rvRankingEveryClass;
    public final TextView tvRankingCurrentWeekInThisClass;
    public final TextView tvRankingFirst;
    public final TextView tvRankingLastWeekInThisClass;
    public final TextView tvRankingSecond;
    public final TextView tvRankingThird;
    public final TextView tvScoringCurrentWeekInThisClass;
    public final TextView tvScoringLastWeekInThisClass;
    public final TextView tvWeekCycle;

    private FragmentRoepInEveryClassBinding(ConstraintLayout constraintLayout, BannerViewPager bannerViewPager, BannerViewPager bannerViewPager2, BannerViewPager bannerViewPager3, BannerViewPager bannerViewPager4, BannerViewPager bannerViewPager5, BannerViewPager bannerViewPager6, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ImageView imageView, ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, ConstraintLayout constraintLayout10, RadioButton radioButton, RadioButton radioButton2, RadioGroup radioGroup, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.bvpClassIcon1 = bannerViewPager;
        this.bvpClassIcon2 = bannerViewPager2;
        this.bvpClassIcon3 = bannerViewPager3;
        this.bvpClassScore1 = bannerViewPager4;
        this.bvpClassScore2 = bannerViewPager5;
        this.bvpClassScore3 = bannerViewPager6;
        this.clRanking = constraintLayout2;
        this.clRankingCurrentWeekInThisClass = constraintLayout3;
        this.clRankingLastWeekInThisClass = constraintLayout4;
        this.clTitleForCurrentWeek = constraintLayout5;
        this.clTitleForLastWeek = constraintLayout6;
        this.clTitles = constraintLayout7;
        this.ivRankingPillar = imageView;
        this.llRankingFirst = constraintLayout8;
        this.llRankingSecond = constraintLayout9;
        this.llRankingThird = constraintLayout10;
        this.rbRankingForCurrentWeek = radioButton;
        this.rbRankingForLastWeek = radioButton2;
        this.rgWeek = radioGroup;
        this.rvRankingEveryClass = recyclerView;
        this.tvRankingCurrentWeekInThisClass = textView;
        this.tvRankingFirst = textView2;
        this.tvRankingLastWeekInThisClass = textView3;
        this.tvRankingSecond = textView4;
        this.tvRankingThird = textView5;
        this.tvScoringCurrentWeekInThisClass = textView6;
        this.tvScoringLastWeekInThisClass = textView7;
        this.tvWeekCycle = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentRoepInEveryClassBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentRoepInEveryClassBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_roep_in_every_class, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentRoepInEveryClassBinding bind(View view) {
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
                                    i = R.id.cl_ranking_current_week_in_this_class;
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_ranking_current_week_in_this_class);
                                    if (constraintLayout2 != null) {
                                        i = R.id.cl_ranking_last_week_in_this_class;
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_ranking_last_week_in_this_class);
                                        if (constraintLayout3 != null) {
                                            i = R.id.cl_title_for_current_week;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.cl_title_for_current_week);
                                            if (constraintLayout4 != null) {
                                                i = R.id.cl_title_for_last_week;
                                                ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.cl_title_for_last_week);
                                                if (constraintLayout5 != null) {
                                                    i = R.id.cl_titles;
                                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) view.findViewById(R.id.cl_titles);
                                                    if (constraintLayout6 != null) {
                                                        i = R.id.iv_ranking_pillar;
                                                        ImageView imageView = (ImageView) view.findViewById(R.id.iv_ranking_pillar);
                                                        if (imageView != null) {
                                                            i = R.id.ll_ranking_first;
                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) view.findViewById(R.id.ll_ranking_first);
                                                            if (constraintLayout7 != null) {
                                                                i = R.id.ll_ranking_second;
                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) view.findViewById(R.id.ll_ranking_second);
                                                                if (constraintLayout8 != null) {
                                                                    i = R.id.ll_ranking_third;
                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) view.findViewById(R.id.ll_ranking_third);
                                                                    if (constraintLayout9 != null) {
                                                                        i = R.id.rb_ranking_for_current_week;
                                                                        RadioButton radioButton = (RadioButton) view.findViewById(R.id.rb_ranking_for_current_week);
                                                                        if (radioButton != null) {
                                                                            i = R.id.rb_ranking_for_last_week;
                                                                            RadioButton radioButton2 = (RadioButton) view.findViewById(R.id.rb_ranking_for_last_week);
                                                                            if (radioButton2 != null) {
                                                                                i = R.id.rg_week;
                                                                                RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.rg_week);
                                                                                if (radioGroup != null) {
                                                                                    i = R.id.rv_ranking_every_class;
                                                                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_ranking_every_class);
                                                                                    if (recyclerView != null) {
                                                                                        i = R.id.tv_ranking_current_week_in_this_class;
                                                                                        TextView textView = (TextView) view.findViewById(R.id.tv_ranking_current_week_in_this_class);
                                                                                        if (textView != null) {
                                                                                            i = R.id.tv_ranking_first;
                                                                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_ranking_first);
                                                                                            if (textView2 != null) {
                                                                                                i = R.id.tv_ranking_last_week_in_this_class;
                                                                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_ranking_last_week_in_this_class);
                                                                                                if (textView3 != null) {
                                                                                                    i = R.id.tv_ranking_second;
                                                                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_ranking_second);
                                                                                                    if (textView4 != null) {
                                                                                                        i = R.id.tv_ranking_third;
                                                                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_ranking_third);
                                                                                                        if (textView5 != null) {
                                                                                                            i = R.id.tv_scoring_current_week_in_this_class;
                                                                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_scoring_current_week_in_this_class);
                                                                                                            if (textView6 != null) {
                                                                                                                i = R.id.tv_scoring_last_week_in_this_class;
                                                                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_scoring_last_week_in_this_class);
                                                                                                                if (textView7 != null) {
                                                                                                                    i = R.id.tv_week_cycle;
                                                                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_week_cycle);
                                                                                                                    if (textView8 != null) {
                                                                                                                        return new FragmentRoepInEveryClassBinding((ConstraintLayout) view, bannerViewPager, bannerViewPager2, bannerViewPager3, bannerViewPager4, bannerViewPager5, bannerViewPager6, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, constraintLayout6, imageView, constraintLayout7, constraintLayout8, constraintLayout9, radioButton, radioButton2, radioGroup, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
