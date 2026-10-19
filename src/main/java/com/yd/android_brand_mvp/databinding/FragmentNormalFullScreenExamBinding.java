package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentNormalFullScreenExamBinding implements ViewBinding {
    public final TextView btnFragmentFullExamSign;
    public final ConstraintLayout clFragmentFullExamAddress;
    public final ConstraintLayout clFragmentFullExamNumber;
    public final ConstraintLayout clFragmentFullExamSeatTeacher;
    public final ConstraintLayout clFragmentFullExamTarget;
    public final ConstraintLayout clFragmentFullExamTime;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentNormalFullScreenSeat;
    public final RecyclerView rvFragmentNormalFullScreenTeacher;
    public final TextView tvFragmentFullExamAddress;
    public final TextView tvFragmentFullExamAddressTip;
    public final TextView tvFragmentFullExamNumber;
    public final TextView tvFragmentFullExamNumberTip;
    public final TextView tvFragmentFullExamSeatTeacherTip;
    public final TextView tvFragmentFullExamSeatTop;
    public final TextView tvFragmentFullExamTarget;
    public final TextView tvFragmentFullExamTargetTip;
    public final TextView tvFragmentFullExamTime;
    public final TextView tvFragmentFullExamTimeTip;
    public final TextView tvFragmentNormalFullScreenCourse;

    private FragmentNormalFullScreenExamBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = constraintLayout;
        this.btnFragmentFullExamSign = textView;
        this.clFragmentFullExamAddress = constraintLayout2;
        this.clFragmentFullExamNumber = constraintLayout3;
        this.clFragmentFullExamSeatTeacher = constraintLayout4;
        this.clFragmentFullExamTarget = constraintLayout5;
        this.clFragmentFullExamTime = constraintLayout6;
        this.rvFragmentNormalFullScreenSeat = recyclerView;
        this.rvFragmentNormalFullScreenTeacher = recyclerView2;
        this.tvFragmentFullExamAddress = textView2;
        this.tvFragmentFullExamAddressTip = textView3;
        this.tvFragmentFullExamNumber = textView4;
        this.tvFragmentFullExamNumberTip = textView5;
        this.tvFragmentFullExamSeatTeacherTip = textView6;
        this.tvFragmentFullExamSeatTop = textView7;
        this.tvFragmentFullExamTarget = textView8;
        this.tvFragmentFullExamTargetTip = textView9;
        this.tvFragmentFullExamTime = textView10;
        this.tvFragmentFullExamTimeTip = textView11;
        this.tvFragmentNormalFullScreenCourse = textView12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNormalFullScreenExamBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentNormalFullScreenExamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_normal_full_screen_exam, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentNormalFullScreenExamBinding bind(View view) {
        int i = R.id.btn_fragment_full_exam_sign;
        TextView textView = (TextView) view.findViewById(R.id.btn_fragment_full_exam_sign);
        if (textView != null) {
            i = R.id.cl_fragment_full_exam_address;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_fragment_full_exam_address);
            if (constraintLayout != null) {
                i = R.id.cl_fragment_full_exam_number;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_full_exam_number);
                if (constraintLayout2 != null) {
                    i = R.id.cl_fragment_full_exam_seat_teacher;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_full_exam_seat_teacher);
                    if (constraintLayout3 != null) {
                        i = R.id.cl_fragment_full_exam_target;
                        ConstraintLayout constraintLayout4 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_full_exam_target);
                        if (constraintLayout4 != null) {
                            i = R.id.cl_fragment_full_exam_time;
                            ConstraintLayout constraintLayout5 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_full_exam_time);
                            if (constraintLayout5 != null) {
                                i = R.id.rv_fragment_normal_full_screen_seat;
                                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_normal_full_screen_seat);
                                if (recyclerView != null) {
                                    i = R.id.rv_fragment_normal_full_screen_teacher;
                                    RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rv_fragment_normal_full_screen_teacher);
                                    if (recyclerView2 != null) {
                                        i = R.id.tv_fragment_full_exam_address;
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_address);
                                        if (textView2 != null) {
                                            i = R.id.tv_fragment_full_exam_address_tip;
                                            TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_address_tip);
                                            if (textView3 != null) {
                                                i = R.id.tv_fragment_full_exam_number;
                                                TextView textView4 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_number);
                                                if (textView4 != null) {
                                                    i = R.id.tv_fragment_full_exam_number_tip;
                                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_number_tip);
                                                    if (textView5 != null) {
                                                        i = R.id.tv_fragment_full_exam_seat_teacher_tip;
                                                        TextView textView6 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_seat_teacher_tip);
                                                        if (textView6 != null) {
                                                            i = R.id.tv_fragment_full_exam_seat_top;
                                                            TextView textView7 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_seat_top);
                                                            if (textView7 != null) {
                                                                i = R.id.tv_fragment_full_exam_target;
                                                                TextView textView8 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_target);
                                                                if (textView8 != null) {
                                                                    i = R.id.tv_fragment_full_exam_target_tip;
                                                                    TextView textView9 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_target_tip);
                                                                    if (textView9 != null) {
                                                                        i = R.id.tv_fragment_full_exam_time;
                                                                        TextView textView10 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_time);
                                                                        if (textView10 != null) {
                                                                            i = R.id.tv_fragment_full_exam_time_tip;
                                                                            TextView textView11 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_time_tip);
                                                                            if (textView11 != null) {
                                                                                i = R.id.tv_fragment_normal_full_screen_course;
                                                                                TextView textView12 = (TextView) view.findViewById(R.id.tv_fragment_normal_full_screen_course);
                                                                                if (textView12 != null) {
                                                                                    return new FragmentNormalFullScreenExamBinding((ConstraintLayout) view, textView, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, constraintLayout5, recyclerView, recyclerView2, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
