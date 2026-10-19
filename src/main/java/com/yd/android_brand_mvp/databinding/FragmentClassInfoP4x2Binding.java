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
public final class FragmentClassInfoP4x2Binding implements ViewBinding {
    public final LinearLayout content;
    public final ImageView imgHead;
    public final LinearLayout llStudentNum;
    public final LinearLayout llTab;
    public final LinearLayout llTeacherName;
    public final RecyclerView recyleview;
    private final FrameLayout rootView;
    public final TextView tvClassName;
    public final TextView tvStudentNum;
    public final TextView tvTeacherDuty;
    public final TextView tvTeacherName;

    private FragmentClassInfoP4x2Binding(FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = frameLayout;
        this.content = linearLayout;
        this.imgHead = imageView;
        this.llStudentNum = linearLayout2;
        this.llTab = linearLayout3;
        this.llTeacherName = linearLayout4;
        this.recyleview = recyclerView;
        this.tvClassName = textView;
        this.tvStudentNum = textView2;
        this.tvTeacherDuty = textView3;
        this.tvTeacherName = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassInfoP4x2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassInfoP4x2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_info_p4x2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassInfoP4x2Binding bind(View view) {
        int i = R.id.content;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.content);
        if (linearLayout != null) {
            i = R.id.img_head;
            ImageView imageView = (ImageView) view.findViewById(R.id.img_head);
            if (imageView != null) {
                i = R.id.ll_student_num;
                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.ll_student_num);
                if (linearLayout2 != null) {
                    i = R.id.ll_tab;
                    LinearLayout linearLayout3 = (LinearLayout) view.findViewById(R.id.ll_tab);
                    if (linearLayout3 != null) {
                        i = R.id.ll_teacher_name;
                        LinearLayout linearLayout4 = (LinearLayout) view.findViewById(R.id.ll_teacher_name);
                        if (linearLayout4 != null) {
                            i = R.id.recyleview;
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyleview);
                            if (recyclerView != null) {
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
                                                return new FragmentClassInfoP4x2Binding((FrameLayout) view, linearLayout, imageView, linearLayout2, linearLayout3, linearLayout4, recyclerView, textView, textView2, textView3, textView4);
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
