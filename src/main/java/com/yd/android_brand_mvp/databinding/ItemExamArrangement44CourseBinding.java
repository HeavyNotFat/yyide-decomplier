package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemExamArrangement44CourseBinding implements ViewBinding {
    public final ConstraintLayout clItemExamArrangement44Course;
    private final ConstraintLayout rootView;
    public final TextView tvItemExamArrangement44CourseClass;
    public final TextView tvItemExamArrangement44CourseName;
    public final TextView tvItemExamArrangement44CourseTime;

    private ItemExamArrangement44CourseBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clItemExamArrangement44Course = constraintLayout2;
        this.tvItemExamArrangement44CourseClass = textView;
        this.tvItemExamArrangement44CourseName = textView2;
        this.tvItemExamArrangement44CourseTime = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemExamArrangement44CourseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemExamArrangement44CourseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_exam_arrangement44_course, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemExamArrangement44CourseBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.tv_item_exam_arrangement44_course_class;
        TextView textView = (TextView) view.findViewById(R.id.tv_item_exam_arrangement44_course_class);
        if (textView != null) {
            i = R.id.tv_item_exam_arrangement44_course_name;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_item_exam_arrangement44_course_name);
            if (textView2 != null) {
                i = R.id.tv_item_exam_arrangement44_course_time;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_item_exam_arrangement44_course_time);
                if (textView3 != null) {
                    return new ItemExamArrangement44CourseBinding(constraintLayout, constraintLayout, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
