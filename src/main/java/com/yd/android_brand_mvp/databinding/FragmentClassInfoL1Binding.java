package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassInfoL1Binding implements ViewBinding {
    public final LinearLayout content;
    public final ImageView imgHead;
    public final RecyclerView recyleview;
    private final FrameLayout rootView;
    public final TextView tvClassName;
    public final TextView tvStudentNum;
    public final TextView tvStudentNum1;
    public final TextView tvTeacherDuty;
    public final TextView tvTeacherName;
    public final TextView tvTeacherName1;
    public final TextView tvTeacherNums;

    private FragmentClassInfoL1Binding(FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = frameLayout;
        this.content = linearLayout;
        this.imgHead = imageView;
        this.recyleview = recyclerView;
        this.tvClassName = textView;
        this.tvStudentNum = textView2;
        this.tvStudentNum1 = textView3;
        this.tvTeacherDuty = textView4;
        this.tvTeacherName = textView5;
        this.tvTeacherName1 = textView6;
        this.tvTeacherNums = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassInfoL1Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassInfoL1Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_info_l1, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassInfoL1Binding bind(View view) {
        int i = R.id.content;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content);
        if (linearLayout != null) {
            i = R.id.img_head;
            ImageView imageView = (ImageView) view.findViewById(R.id.img_head);
            if (imageView != null) {
                i = R.id.recyleview;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyleview);
                if (recyclerView != null) {
                    i = R.id.tv_class_name;
                    TextView textView = (TextView) view.findViewById(R.id.tv_class_name);
                    if (textView != null) {
                        i = R.id.tv_student_num;
                        TextView textView2 = (TextView) view.findViewById(R.id.tv_student_num);
                        if (textView2 != null) {
                            i = R.id.tv_student_num1;
                            TextView textView3 = (TextView) view.findViewById(R.id.tv_student_num1);
                            if (textView3 != null) {
                                i = R.id.tv_teacher_duty;
                                TextView textView4 = (TextView) view.findViewById(R.id.tv_teacher_duty);
                                if (textView4 != null) {
                                    i = R.id.tv_teacher_name;
                                    TextView textView5 = (TextView) view.findViewById(R.id.tv_teacher_name);
                                    if (textView5 != null) {
                                        i = R.id.tv_teacher_name1;
                                        TextView textView6 = (TextView) view.findViewById(R.id.tv_teacher_name1);
                                        if (textView6 != null) {
                                            i = R.id.tv_teacher_nums;
                                            TextView textView7 = (TextView) view.findViewById(R.id.tv_teacher_nums);
                                            if (textView7 != null) {
                                                return new FragmentClassInfoL1Binding((FrameLayout) view, linearLayout, imageView, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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
