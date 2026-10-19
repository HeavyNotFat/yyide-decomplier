package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DialogExamDetailBinding implements ViewBinding {
    public final Button btnFragmentExamSign;
    private final ConstraintLayout rootView;
    public final View topDialogExamDetailContent;
    public final TextView tvDialogExamDetailAddress;
    public final TextView tvDialogExamDetailAddressTip;
    public final TextView tvDialogExamDetailRate;
    public final TextView tvDialogExamDetailRateTip;
    public final TextView tvDialogExamDetailSubject;
    public final TextView tvDialogExamDetailTarget;
    public final TextView tvDialogExamDetailTargetTip;
    public final TextView tvDialogExamDetailTeacher;
    public final TextView tvDialogExamDetailTeacherTip;
    public final TextView tvDialogExamDetailTime;
    public final TextView tvDialogExamDetailTimeTip;
    public final TextView tvDialogExamDetailTitle;

    private DialogExamDetailBinding(ConstraintLayout constraintLayout, Button button, View view, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = constraintLayout;
        this.btnFragmentExamSign = button;
        this.topDialogExamDetailContent = view;
        this.tvDialogExamDetailAddress = textView;
        this.tvDialogExamDetailAddressTip = textView2;
        this.tvDialogExamDetailRate = textView3;
        this.tvDialogExamDetailRateTip = textView4;
        this.tvDialogExamDetailSubject = textView5;
        this.tvDialogExamDetailTarget = textView6;
        this.tvDialogExamDetailTargetTip = textView7;
        this.tvDialogExamDetailTeacher = textView8;
        this.tvDialogExamDetailTeacherTip = textView9;
        this.tvDialogExamDetailTime = textView10;
        this.tvDialogExamDetailTimeTip = textView11;
        this.tvDialogExamDetailTitle = textView12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogExamDetailBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DialogExamDetailBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.dialog_exam_detail, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DialogExamDetailBinding bind(View view) {
        int i = R.id.btn_fragment_exam_sign;
        Button button = (Button) view.findViewById(R.id.btn_fragment_exam_sign);
        if (button != null) {
            i = R.id.top_dialog_exam_detail_content;
            View viewFindViewById = view.findViewById(R.id.top_dialog_exam_detail_content);
            if (viewFindViewById != null) {
                i = R.id.tv_dialog_exam_detail_address;
                TextView textView = (TextView) view.findViewById(R.id.tv_dialog_exam_detail_address);
                if (textView != null) {
                    i = R.id.tv_dialog_exam_detail_address_tip;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_dialog_exam_detail_address_tip);
                    if (textView2 != null) {
                        i = R.id.tv_dialog_exam_detail_rate;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_dialog_exam_detail_rate);
                        if (textView3 != null) {
                            i = R.id.tv_dialog_exam_detail_rate_tip;
                            TextView textView4 = (TextView) view.findViewById(R.id.tv_dialog_exam_detail_rate_tip);
                            if (textView4 != null) {
                                i = R.id.tv_dialog_exam_detail_subject;
                                TextView textView5 = (TextView) view.findViewById(R.id.tv_dialog_exam_detail_subject);
                                if (textView5 != null) {
                                    i = R.id.tv_dialog_exam_detail_target;
                                    TextView textView6 = (TextView) view.findViewById(R.id.tv_dialog_exam_detail_target);
                                    if (textView6 != null) {
                                        i = R.id.tv_dialog_exam_detail_target_tip;
                                        TextView textView7 = (TextView) view.findViewById(R.id.tv_dialog_exam_detail_target_tip);
                                        if (textView7 != null) {
                                            i = R.id.tv_dialog_exam_detail_teacher;
                                            TextView textView8 = (TextView) view.findViewById(R.id.tv_dialog_exam_detail_teacher);
                                            if (textView8 != null) {
                                                i = R.id.tv_dialog_exam_detail_teacher_tip;
                                                TextView textView9 = (TextView) view.findViewById(R.id.tv_dialog_exam_detail_teacher_tip);
                                                if (textView9 != null) {
                                                    i = R.id.tv_dialog_exam_detail_time;
                                                    TextView textView10 = (TextView) view.findViewById(R.id.tv_dialog_exam_detail_time);
                                                    if (textView10 != null) {
                                                        i = R.id.tv_dialog_exam_detail_time_tip;
                                                        TextView textView11 = (TextView) view.findViewById(R.id.tv_dialog_exam_detail_time_tip);
                                                        if (textView11 != null) {
                                                            i = R.id.tv_dialog_exam_detail_title;
                                                            TextView textView12 = (TextView) view.findViewById(R.id.tv_dialog_exam_detail_title);
                                                            if (textView12 != null) {
                                                                return new DialogExamDetailBinding((ConstraintLayout) view, button, viewFindViewById, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
