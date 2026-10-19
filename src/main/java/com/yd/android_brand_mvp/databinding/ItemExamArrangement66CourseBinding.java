package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemExamArrangement66CourseBinding implements ViewBinding {
    public final ConstraintLayout clItemExamArrangement66Course;
    public final ConstraintLayout clItemExamArrangement66CourseTitle;
    private final ConstraintLayout rootView;
    public final TextView tvItemExamArrangement66CourseClass;
    public final TextView tvItemExamArrangement66CourseName;
    public final TextView tvItemExamArrangement66CourseTime;
    public final View viewLine;

    private ItemExamArrangement66CourseBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, TextView textView3, View view) {
        this.rootView = constraintLayout;
        this.clItemExamArrangement66Course = constraintLayout2;
        this.clItemExamArrangement66CourseTitle = constraintLayout3;
        this.tvItemExamArrangement66CourseClass = textView;
        this.tvItemExamArrangement66CourseName = textView2;
        this.tvItemExamArrangement66CourseTime = textView3;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemExamArrangement66CourseBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemExamArrangement66CourseBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_exam_arrangement66_course, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemExamArrangement66CourseBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.cl_item_exam_arrangement66_course_title;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(R.id.cl_item_exam_arrangement66_course_title);
        if (constraintLayout2 != null) {
            i = R.id.tv_item_exam_arrangement66_course_class;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_exam_arrangement66_course_class);
            if (textView != null) {
                i = R.id.tv_item_exam_arrangement66_course_name;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_item_exam_arrangement66_course_name);
                if (textView2 != null) {
                    i = R.id.tv_item_exam_arrangement66_course_time;
                    TextView textView3 = (TextView) view.findViewById(R.id.tv_item_exam_arrangement66_course_time);
                    if (textView3 != null) {
                        i = R.id.view_line;
                        View viewFindViewById = view.findViewById(R.id.view_line);
                        if (viewFindViewById != null) {
                            return new ItemExamArrangement66CourseBinding(constraintLayout, constraintLayout, constraintLayout2, textView, textView2, textView3, viewFindViewById);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
