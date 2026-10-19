package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class StudentDutyItemBinding implements ViewBinding {
    public final ConstraintLayout clLab;
    public final ImageView ivIcon;
    public final ConstraintLayout llDuty;
    private final ConstraintLayout rootView;
    public final RecyclerView rvName;
    public final TextView tvProjectName;

    private StudentDutyItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ConstraintLayout constraintLayout3, RecyclerView recyclerView, TextView textView) {
        this.rootView = constraintLayout;
        this.clLab = constraintLayout2;
        this.ivIcon = imageView;
        this.llDuty = constraintLayout3;
        this.rvName = recyclerView;
        this.tvProjectName = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static StudentDutyItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static StudentDutyItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.student_duty_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static StudentDutyItemBinding bind(View view) {
        int i = R.id.cl_lab;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_lab);
        if (constraintLayout != null) {
            i = R.id.iv_icon;
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_icon);
            if (imageView != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                i = R.id.rv_name;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_name);
                if (recyclerView != null) {
                    i = R.id.tv_project_name;
                    TextView textView = (TextView) view.findViewById(R.id.tv_project_name);
                    if (textView != null) {
                        return new StudentDutyItemBinding(constraintLayout2, constraintLayout, imageView, constraintLayout2, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
