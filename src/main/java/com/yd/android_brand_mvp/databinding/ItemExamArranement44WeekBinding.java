package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemExamArranement44WeekBinding implements ViewBinding {
    public final ConstraintLayout clItemExamArrangement44Week;
    private final ConstraintLayout rootView;
    public final TextView tvItemExamArrangement44WeekName;
    public final TextView tvItemExamArrangement44WeekTime;

    private ItemExamArranement44WeekBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clItemExamArrangement44Week = constraintLayout2;
        this.tvItemExamArrangement44WeekName = textView;
        this.tvItemExamArrangement44WeekTime = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemExamArranement44WeekBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemExamArranement44WeekBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_exam_arranement44_week, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemExamArranement44WeekBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.tv_item_exam_arrangement44_week_name;
        TextView textView = (TextView) view.findViewById(R.id.tv_item_exam_arrangement44_week_name);
        if (textView != null) {
            i = R.id.tv_item_exam_arrangement44_week_time;
            TextView textView2 = (TextView) view.findViewById(R.id.tv_item_exam_arrangement44_week_time);
            if (textView2 != null) {
                return new ItemExamArranement44WeekBinding(constraintLayout, constraintLayout, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
