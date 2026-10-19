package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemUserExamBinding implements ViewBinding {
    public final ConstraintLayout clItemUserExamNumber;
    private final ConstraintLayout rootView;
    public final TextView tvItemUserExamAddress;
    public final TextView tvItemUserExamAddressTip;
    public final TextView tvItemUserExamNumber;
    public final TextView tvItemUserExamNumberTip;
    public final TextView tvItemUserExamTeacher;
    public final TextView tvItemUserExamTeacherTip;
    public final TextView tvItemUserExamTime;
    public final TextView tvItemUserExamTimeTip;
    public final TextView tvItemUserExamTitle;

    private ItemUserExamBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        this.rootView = constraintLayout;
        this.clItemUserExamNumber = constraintLayout2;
        this.tvItemUserExamAddress = textView;
        this.tvItemUserExamAddressTip = textView2;
        this.tvItemUserExamNumber = textView3;
        this.tvItemUserExamNumberTip = textView4;
        this.tvItemUserExamTeacher = textView5;
        this.tvItemUserExamTeacherTip = textView6;
        this.tvItemUserExamTime = textView7;
        this.tvItemUserExamTimeTip = textView8;
        this.tvItemUserExamTitle = textView9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemUserExamBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemUserExamBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_user_exam, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemUserExamBinding bind(View view) {
        int i = R.id.cl_item_user_exam_number;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_item_user_exam_number);
        if (constraintLayout != null) {
            i = R.id.tv_item_user_exam_address;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_user_exam_address);
            if (textView != null) {
                i = R.id.tv_item_user_exam_address_tip;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_item_user_exam_address_tip);
                if (textView2 != null) {
                    i = R.id.tv_item_user_exam_number;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_item_user_exam_number);
                    if (textView3 != null) {
                        i = R.id.tv_item_user_exam_number_tip;
                        TextView textView4 = (TextView) view.findViewById(R.id.tv_item_user_exam_number_tip);
                        if (textView4 != null) {
                            i = R.id.tv_item_user_exam_teacher;
                            TextView textView5 = (TextView) view.findViewById(R.id.tv_item_user_exam_teacher);
                            if (textView5 != null) {
                                i = R.id.tv_item_user_exam_teacher_tip;
                                TextView textView6 = (TextView) view.findViewById(R.id.tv_item_user_exam_teacher_tip);
                                if (textView6 != null) {
                                    i = R.id.tv_item_user_exam_time;
                                    TextView textView7 = (TextView) view.findViewById(R.id.tv_item_user_exam_time);
                                    if (textView7 != null) {
                                        i = R.id.tv_item_user_exam_time_tip;
                                        TextView textView8 = (TextView) view.findViewById(R.id.tv_item_user_exam_time_tip);
                                        if (textView8 != null) {
                                            i = R.id.tv_item_user_exam_title;
                                            TextView textView9 = (TextView) view.findViewById(R.id.tv_item_user_exam_title);
                                            if (textView9 != null) {
                                                return new ItemUserExamBinding((ConstraintLayout) view, constraintLayout, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9);
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
