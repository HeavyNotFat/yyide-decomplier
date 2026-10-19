package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassInfoP4x1Binding implements ViewBinding {
    public final LinearLayout content;
    public final RoundedImageView imgHead;
    public final LinearLayout llNo;
    public final LinearLayout llTab;
    private final FrameLayout rootView;
    public final TextView tvClassName;
    public final TextView tvStudentNum;
    public final TextView tvTeacherDuty;
    public final TextView tvTeacherName;
    public final TextView tvTeacherNums;

    private FragmentClassInfoP4x1Binding(FrameLayout frameLayout, LinearLayout linearLayout, RoundedImageView roundedImageView, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = frameLayout;
        this.content = linearLayout;
        this.imgHead = roundedImageView;
        this.llNo = linearLayout2;
        this.llTab = linearLayout3;
        this.tvClassName = textView;
        this.tvStudentNum = textView2;
        this.tvTeacherDuty = textView3;
        this.tvTeacherName = textView4;
        this.tvTeacherNums = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassInfoP4x1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassInfoP4x1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_info_p4x1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassInfoP4x1Binding bind(View view) {
        int i = R.id.content;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content);
        if (linearLayout != null) {
            i = R.id.img_head;
            RoundedImageView roundedImageView = (RoundedImageView) view.findViewById(R.id.img_head);
            if (roundedImageView != null) {
                i = R.id.ll_no;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_no);
                if (linearLayout2 != null) {
                    i = R.id.ll_tab;
                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_tab);
                    if (linearLayout3 != null) {
                        i = R.id.tv_class_name;
                        TextView textView = (TextView) view.findViewById(R.id.tv_class_name);
                        if (textView != null) {
                            i = R.id.tv_student_num;
                            TextView textView2 = (TextView) view.findViewById(R.id.tv_student_num);
                            if (textView2 != null) {
                                i = R.id.tv_teacher_duty;
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_teacher_duty);
                                if (textView3 != null) {
                                    i = R.id.tv_teacher_name;
                                    TextView textView4 = (TextView) view.findViewById(R.id.tv_teacher_name);
                                    if (textView4 != null) {
                                        i = R.id.tv_teacher_nums;
                                        TextView textView5 = (TextView) view.findViewById(R.id.tv_teacher_nums);
                                        if (textView5 != null) {
                                            return new FragmentClassInfoP4x1Binding((FrameLayout) view, linearLayout, roundedImageView, linearLayout2, linearLayout3, textView, textView2, textView3, textView4, textView5);
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
