package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomeDormitoryEducationBinding implements ViewBinding {
    public final Banner bannerFragmentDormitoryEducation1Score;
    public final Banner bannerFragmentDormitoryEducation2Score;
    public final Banner bannerFragmentDormitoryEducation3Score;
    public final ConstraintLayout clFragmentHomeDormitoryEducation;
    public final ConstraintLayout clFragmentHomeDormitoryEducationHead;
    public final ConstraintLayout clFragmentHomeDormitoryEducationInfo;
    public final ViewStub emptyView;
    public final ImageView ivFragmentDormitoryEducation1Name;
    public final ImageView ivFragmentDormitoryEducation2Name;
    public final ImageView ivFragmentDormitoryEducation3Name;
    public final ImageView ivFragmentHomeDormitoryEducation;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentHomeDormitoryEducationRank;
    public final TextView tvFragmentDormitoryEducationRanking;
    public final TextView tvFragmentDormitoryEducationScore;
    public final TextView tvFragmentDormitoryEducationTitle;
    public final TextView tvFragmentDormitoryEducationWeek;

    private FragmentHomeDormitoryEducationBinding(ConstraintLayout constraintLayout, Banner banner, Banner banner2, Banner banner3, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ViewStub viewStub, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = constraintLayout;
        this.bannerFragmentDormitoryEducation1Score = banner;
        this.bannerFragmentDormitoryEducation2Score = banner2;
        this.bannerFragmentDormitoryEducation3Score = banner3;
        this.clFragmentHomeDormitoryEducation = constraintLayout2;
        this.clFragmentHomeDormitoryEducationHead = constraintLayout3;
        this.clFragmentHomeDormitoryEducationInfo = constraintLayout4;
        this.emptyView = viewStub;
        this.ivFragmentDormitoryEducation1Name = imageView;
        this.ivFragmentDormitoryEducation2Name = imageView2;
        this.ivFragmentDormitoryEducation3Name = imageView3;
        this.ivFragmentHomeDormitoryEducation = imageView4;
        this.rvFragmentHomeDormitoryEducationRank = recyclerView;
        this.tvFragmentDormitoryEducationRanking = textView;
        this.tvFragmentDormitoryEducationScore = textView2;
        this.tvFragmentDormitoryEducationTitle = textView3;
        this.tvFragmentDormitoryEducationWeek = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeDormitoryEducationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeDormitoryEducationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_dormitory_education, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomeDormitoryEducationBinding bind(View view) {
        int i = R.id.banner_fragment_dormitory_education_1_score;
        Banner banner = (Banner) view.findViewById(R.id.banner_fragment_dormitory_education_1_score);
        if (banner != null) {
            i = R.id.banner_fragment_dormitory_education_2_score;
            Banner banner2 = (Banner) view.findViewById(R.id.banner_fragment_dormitory_education_2_score);
            if (banner2 != null) {
                i = R.id.banner_fragment_dormitory_education_3_score;
                Banner banner3 = (Banner) view.findViewById(R.id.banner_fragment_dormitory_education_3_score);
                if (banner3 != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i = R.id.cl_fragment_home_dormitory_education_head;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_home_dormitory_education_head);
                    if (constraintLayout2 != null) {
                        i = R.id.cl_fragment_home_dormitory_education_info;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_home_dormitory_education_info);
                        if (constraintLayout3 != null) {
                            i = R.id.empty_view;
                            ViewStub viewStub = (ViewStub) view.findViewById(R.id.empty_view);
                            if (viewStub != null) {
                                i = R.id.iv_fragment_dormitory_education_1_name;
                                ImageView imageView = (ImageView) view.findViewById(R.id.iv_fragment_dormitory_education_1_name);
                                if (imageView != null) {
                                    i = R.id.iv_fragment_dormitory_education_2_name;
                                    ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_fragment_dormitory_education_2_name);
                                    if (imageView2 != null) {
                                        i = R.id.iv_fragment_dormitory_education_3_name;
                                        ImageView imageView3 = (ImageView) view.findViewById(R.id.iv_fragment_dormitory_education_3_name);
                                        if (imageView3 != null) {
                                            i = R.id.iv_fragment_home_dormitory_education;
                                            ImageView imageView4 = (ImageView) view.findViewById(R.id.iv_fragment_home_dormitory_education);
                                            if (imageView4 != null) {
                                                i = R.id.rv_fragment_home_dormitory_education_rank;
                                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_home_dormitory_education_rank);
                                                if (recyclerView != null) {
                                                    i = R.id.tv_fragment_dormitory_education_ranking;
                                                    TextView textView = (TextView) view.findViewById(R.id.tv_fragment_dormitory_education_ranking);
                                                    if (textView != null) {
                                                        i = R.id.tv_fragment_dormitory_education_score;
                                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_dormitory_education_score);
                                                        if (textView2 != null) {
                                                            i = R.id.tv_fragment_dormitory_education_title;
                                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_dormitory_education_title);
                                                            if (textView3 != null) {
                                                                i = R.id.tv_fragment_dormitory_education_week;
                                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_fragment_dormitory_education_week);
                                                                if (textView4 != null) {
                                                                    return new FragmentHomeDormitoryEducationBinding(constraintLayout, banner, banner2, banner3, constraintLayout, constraintLayout2, constraintLayout3, viewStub, imageView, imageView2, imageView3, imageView4, recyclerView, textView, textView2, textView3, textView4);
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
