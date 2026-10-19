package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentHomeExamArrangement66Binding implements ViewBinding {
    public final TextView btnFragmentExamSign;
    public final ConstraintLayout clFragmentExamArrangement;
    public final ConstraintLayout clFragmentExamArrangementCourse;
    public final ConstraintLayout clFragmentExamArrangementTarget;
    public final ConstraintLayout clFragmentExamArrangementTeacher;
    public final ConstraintLayout clFragmentExamArrangementTime;
    public final ViewStub emptyView;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentExamArrangementCourse;
    public final RecyclerView rvFragmentExamArrangementSeat;
    public final LayoutHeadTitleBinding topFragmentExamArrangement;
    public final TextView tvFragmentExamArrangementCourse;
    public final TextView tvFragmentExamArrangementCourseTip;
    public final TextView tvFragmentExamArrangementTarget;
    public final TextView tvFragmentExamArrangementTargetTip;
    public final TextView tvFragmentExamArrangementTeacher;
    public final TextView tvFragmentExamArrangementTeacherTip;
    public final TextView tvFragmentExamArrangementTime;
    public final TextView tvFragmentExamArrangementTimeTip;

    private FragmentHomeExamArrangement66Binding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ViewStub viewStub, RecyclerView recyclerView, RecyclerView recyclerView2, LayoutHeadTitleBinding layoutHeadTitleBinding, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.btnFragmentExamSign = textView;
        this.clFragmentExamArrangement = constraintLayout2;
        this.clFragmentExamArrangementCourse = constraintLayout3;
        this.clFragmentExamArrangementTarget = constraintLayout4;
        this.clFragmentExamArrangementTeacher = constraintLayout5;
        this.clFragmentExamArrangementTime = constraintLayout6;
        this.emptyView = viewStub;
        this.rvFragmentExamArrangementCourse = recyclerView;
        this.rvFragmentExamArrangementSeat = recyclerView2;
        this.topFragmentExamArrangement = layoutHeadTitleBinding;
        this.tvFragmentExamArrangementCourse = textView2;
        this.tvFragmentExamArrangementCourseTip = textView3;
        this.tvFragmentExamArrangementTarget = textView4;
        this.tvFragmentExamArrangementTargetTip = textView5;
        this.tvFragmentExamArrangementTeacher = textView6;
        this.tvFragmentExamArrangementTeacherTip = textView7;
        this.tvFragmentExamArrangementTime = textView8;
        this.tvFragmentExamArrangementTimeTip = textView9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHomeExamArrangement66Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentHomeExamArrangement66Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_home_exam_arrangement66, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentHomeExamArrangement66Binding bind(View view) {
        int i = R.id.btn_fragment_exam_sign;
        TextView textView = (TextView) view.findViewById(R.id.btn_fragment_exam_sign);
        if (textView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.cl_fragment_exam_arrangement_course;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_exam_arrangement_course);
            if (constraintLayout2 != null) {
                i = R.id.cl_fragment_exam_arrangement_target;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_exam_arrangement_target);
                if (constraintLayout3 != null) {
                    i = R.id.cl_fragment_exam_arrangement_teacher;
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_exam_arrangement_teacher);
                    if (constraintLayout4 != null) {
                        i = R.id.cl_fragment_exam_arrangement_time;
                        ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_exam_arrangement_time);
                        if (constraintLayout5 != null) {
                            i = R.id.empty_view;
                            ViewStub viewStub = (ViewStub) view.findViewById(R.id.empty_view);
                            if (viewStub != null) {
                                i = R.id.rv_fragment_exam_arrangement_course;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_exam_arrangement_course);
                                if (recyclerView != null) {
                                    i = R.id.rv_fragment_exam_arrangement_seat;
                                    RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_fragment_exam_arrangement_seat);
                                    if (recyclerView2 != null) {
                                        i = R.id.top_fragment_exam_arrangement;
                                        View viewFindViewById = view.findViewById(R.id.top_fragment_exam_arrangement);
                                        if (viewFindViewById != null) {
                                            LayoutHeadTitleBinding layoutHeadTitleBindingBind = LayoutHeadTitleBinding.bind(viewFindViewById);
                                            i = R.id.tv_fragment_exam_arrangement_course;
                                            TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_course);
                                            if (textView2 != null) {
                                                i = R.id.tv_fragment_exam_arrangement_course_tip;
                                                TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_course_tip);
                                                if (textView3 != null) {
                                                    i = R.id.tv_fragment_exam_arrangement_target;
                                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_target);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_fragment_exam_arrangement_target_tip;
                                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_target_tip);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_fragment_exam_arrangement_teacher;
                                                            TextView textView6 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_teacher);
                                                            if (textView6 != null) {
                                                                i = R.id.tv_fragment_exam_arrangement_teacher_tip;
                                                                TextView textView7 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_teacher_tip);
                                                                if (textView7 != null) {
                                                                    i = R.id.tv_fragment_exam_arrangement_time;
                                                                    TextView textView8 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_time);
                                                                    if (textView8 != null) {
                                                                        i = R.id.tv_fragment_exam_arrangement_time_tip;
                                                                        TextView textView9 = (TextView) view.findViewById(R.id.tv_fragment_exam_arrangement_time_tip);
                                                                        if (textView9 != null) {
                                                                            return new FragmentHomeExamArrangement66Binding(constraintLayout, textView, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, viewStub, recyclerView, recyclerView2, layoutHeadTitleBindingBind, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
