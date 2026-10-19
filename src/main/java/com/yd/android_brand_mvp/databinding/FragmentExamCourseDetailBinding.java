package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentExamCourseDetailBinding implements ViewBinding {
    public final ConstraintLayout clFragmentExamCourseDetailContent;
    public final ImageView ivFragmentExamCourseDetailLogo;
    private final ConstraintLayout rootView;
    public final TextView tvFragmentExamArrangementAddress;
    public final TextView tvFragmentExamArrangementAddressTip;
    public final TextView tvFragmentExamArrangementNumber;
    public final TextView tvFragmentExamArrangementNumberTip;
    public final TextView tvFragmentExamArrangementRate;
    public final TextView tvFragmentExamArrangementRateTip;
    public final TextView tvFragmentExamArrangementTarget;
    public final TextView tvFragmentExamArrangementTargetTip;
    public final TextView tvFragmentExamArrangementTeacher;
    public final TextView tvFragmentExamArrangementTeacherTip;
    public final TextView tvFragmentExamArrangementTime;
    public final TextView tvFragmentExamArrangementTimeTip;
    public final TextView tvFragmentExamCourseDetailName;

    private FragmentExamCourseDetailBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        this.rootView = constraintLayout;
        this.clFragmentExamCourseDetailContent = constraintLayout2;
        this.ivFragmentExamCourseDetailLogo = imageView;
        this.tvFragmentExamArrangementAddress = textView;
        this.tvFragmentExamArrangementAddressTip = textView2;
        this.tvFragmentExamArrangementNumber = textView3;
        this.tvFragmentExamArrangementNumberTip = textView4;
        this.tvFragmentExamArrangementRate = textView5;
        this.tvFragmentExamArrangementRateTip = textView6;
        this.tvFragmentExamArrangementTarget = textView7;
        this.tvFragmentExamArrangementTargetTip = textView8;
        this.tvFragmentExamArrangementTeacher = textView9;
        this.tvFragmentExamArrangementTeacherTip = textView10;
        this.tvFragmentExamArrangementTime = textView11;
        this.tvFragmentExamArrangementTimeTip = textView12;
        this.tvFragmentExamCourseDetailName = textView13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentExamCourseDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentExamCourseDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_exam_course_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentExamCourseDetailBinding bind(View view) {
        int i = R.id.cl_fragment_exam_course_detail_content;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_fragment_exam_course_detail_content);
        if (constraintLayout != null) {
            i = R.id.iv_fragment_exam_course_detail_logo;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_fragment_exam_course_detail_logo);
            if (imageView != null) {
                i = R.id.tv_fragment_exam_arrangement_address;
                TextView textView = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_address);
                if (textView != null) {
                    i = R.id.tv_fragment_exam_arrangement_address_tip;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_address_tip);
                    if (textView2 != null) {
                        i = R.id.tv_fragment_exam_arrangement_number;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_number);
                        if (textView3 != null) {
                            i = R.id.tv_fragment_exam_arrangement_number_tip;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_number_tip);
                            if (textView4 != null) {
                                i = R.id.tv_fragment_exam_arrangement_rate;
                                TextView textView5 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_rate);
                                if (textView5 != null) {
                                    i = R.id.tv_fragment_exam_arrangement_rate_tip;
                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_rate_tip);
                                    if (textView6 != null) {
                                        i = R.id.tv_fragment_exam_arrangement_target;
                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_target);
                                        if (textView7 != null) {
                                            i = R.id.tv_fragment_exam_arrangement_target_tip;
                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_target_tip);
                                            if (textView8 != null) {
                                                i = R.id.tv_fragment_exam_arrangement_teacher;
                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_teacher);
                                                if (textView9 != null) {
                                                    i = R.id.tv_fragment_exam_arrangement_teacher_tip;
                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_teacher_tip);
                                                    if (textView10 != null) {
                                                        i = R.id.tv_fragment_exam_arrangement_time;
                                                        TextView textView11 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_time);
                                                        if (textView11 != null) {
                                                            i = R.id.tv_fragment_exam_arrangement_time_tip;
                                                            TextView textView12 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_time_tip);
                                                            if (textView12 != null) {
                                                                i = R.id.tv_fragment_exam_course_detail_name;
                                                                TextView textView13 = (TextView) view.findViewById(R.id.tv_fragment_exam_course_detail_name);
                                                                if (textView13 != null) {
                                                                    return new FragmentExamCourseDetailBinding((ConstraintLayout) view, constraintLayout, imageView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13);
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
