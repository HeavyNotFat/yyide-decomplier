package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentSimpleFullScreenExamBinding implements ViewBinding {
    public final TextView btnFragmentFullExamSign;
    public final ConstraintLayout clFragmentFullExamAddress;
    public final ConstraintLayout clFragmentFullExamTarget;
    public final ConstraintLayout clFragmentSimpleFullScreenExamTop;
    private final ConstraintLayout rootView;
    public final TextView tvFragmentFullExamAddress;
    public final TextView tvFragmentFullExamAddressTip;
    public final TextView tvFragmentFullExamTarget;
    public final TextView tvFragmentFullExamTargetTip;
    public final TextView tvFragmentSimpleFullScreenExamCourse;
    public final TextView tvFragmentSimpleFullScreenExamRate;
    public final TextView tvFragmentSimpleFullScreenExamTeacher;

    private FragmentSimpleFullScreenExamBinding(ConstraintLayout constraintLayout, TextView textView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.rootView = constraintLayout;
        this.btnFragmentFullExamSign = textView;
        this.clFragmentFullExamAddress = constraintLayout2;
        this.clFragmentFullExamTarget = constraintLayout3;
        this.clFragmentSimpleFullScreenExamTop = constraintLayout4;
        this.tvFragmentFullExamAddress = textView2;
        this.tvFragmentFullExamAddressTip = textView3;
        this.tvFragmentFullExamTarget = textView4;
        this.tvFragmentFullExamTargetTip = textView5;
        this.tvFragmentSimpleFullScreenExamCourse = textView6;
        this.tvFragmentSimpleFullScreenExamRate = textView7;
        this.tvFragmentSimpleFullScreenExamTeacher = textView8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentSimpleFullScreenExamBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentSimpleFullScreenExamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_simple_full_screen_exam, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentSimpleFullScreenExamBinding bind(View view) {
        int i = R.id.btn_fragment_full_exam_sign;
        TextView textView = (TextView) view.findViewById(R.id.btn_fragment_full_exam_sign);
        if (textView != null) {
            i = R.id.cl_fragment_full_exam_address;
            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_fragment_full_exam_address);
            if (constraintLayout != null) {
                i = R.id.cl_fragment_full_exam_target;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_full_exam_target);
                if (constraintLayout2 != null) {
                    i = R.id.cl_fragment_simple_full_screen_exam_top;
                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(R.id.cl_fragment_simple_full_screen_exam_top);
                    if (constraintLayout3 != null) {
                        i = R.id.tv_fragment_full_exam_address;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_address);
                        if (textView2 != null) {
                            i = R.id.tv_fragment_full_exam_address_tip;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_address_tip);
                            if (textView3 != null) {
                                i = R.id.tv_fragment_full_exam_target;
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_target);
                                if (textView4 != null) {
                                    i = R.id.tv_fragment_full_exam_target_tip;
                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_fragment_full_exam_target_tip);
                                    if (textView5 != null) {
                                        i = R.id.tv_fragment_simple_full_screen_exam_course;
                                        TextView textView6 = (TextView) view.findViewById(R.id.tv_fragment_simple_full_screen_exam_course);
                                        if (textView6 != null) {
                                            i = R.id.tv_fragment_simple_full_screen_exam_rate;
                                            TextView textView7 = (TextView) view.findViewById(R.id.tv_fragment_simple_full_screen_exam_rate);
                                            if (textView7 != null) {
                                                i = R.id.tv_fragment_simple_full_screen_exam_teacher;
                                                TextView textView8 = (TextView) view.findViewById(R.id.tv_fragment_simple_full_screen_exam_teacher);
                                                if (textView8 != null) {
                                                    return new FragmentSimpleFullScreenExamBinding((ConstraintLayout) view, textView, constraintLayout, constraintLayout2, constraintLayout3, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
