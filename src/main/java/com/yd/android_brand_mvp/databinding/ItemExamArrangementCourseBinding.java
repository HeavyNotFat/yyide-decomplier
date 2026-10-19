package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemExamArrangementCourseBinding implements ViewBinding {
    public final ConstraintLayout clItemExamArrangementCourse;
    private final ConstraintLayout rootView;
    public final TextView tvItemExamArrangementCourseClass;
    public final TextView tvItemExamArrangementCourseName;
    public final TextView tvItemExamArrangementCourseTime;

    private ItemExamArrangementCourseBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.clItemExamArrangementCourse = constraintLayout2;
        this.tvItemExamArrangementCourseClass = textView;
        this.tvItemExamArrangementCourseName = textView2;
        this.tvItemExamArrangementCourseTime = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemExamArrangementCourseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemExamArrangementCourseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_exam_arrangement_course, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemExamArrangementCourseBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.tv_item_exam_arrangement_course_class;
        TextView textView = (TextView) view.findViewById(R.id.tv_item_exam_arrangement_course_class);
        if (textView != null) {
            i = R.id.tv_item_exam_arrangement_course_name;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_item_exam_arrangement_course_name);
            if (textView2 != null) {
                i = R.id.tv_item_exam_arrangement_course_time;
                TextView textView3 = (TextView) view.findViewById(R.id.tv_item_exam_arrangement_course_time);
                if (textView3 != null) {
                    return new ItemExamArrangementCourseBinding(constraintLayout, constraintLayout, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
