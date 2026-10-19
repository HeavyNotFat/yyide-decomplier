package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class ItemExamArrangement66SeatBinding implements ViewBinding {
    public final ConstraintLayout clItemExamArrangementSeatLeft;
    private final ConstraintLayout rootView;
    public final TextView tvItemExamArrangement66Name;
    public final AppCompatTextView tvItemExamArrangement66SeatNumber;
    public final TextView tvItemExamArrangement66SeatSign;

    private ItemExamArrangement66SeatBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, AppCompatTextView appCompatTextView, TextView textView2) {
        this.rootView = constraintLayout;
        this.clItemExamArrangementSeatLeft = constraintLayout2;
        this.tvItemExamArrangement66Name = textView;
        this.tvItemExamArrangement66SeatNumber = appCompatTextView;
        this.tvItemExamArrangement66SeatSign = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemExamArrangement66SeatBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemExamArrangement66SeatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_exam_arrangement66_seat, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemExamArrangement66SeatBinding bind(View view) {
        int i = R.id.cl_item_exam_arrangement_seat_left;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_item_exam_arrangement_seat_left);
        if (constraintLayout != null) {
            i = R.id.tv_item_exam_arrangement66_name;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_exam_arrangement66_name);
            if (textView != null) {
                i = R.id.tv_item_exam_arrangement66_seat_number;
                AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.tv_item_exam_arrangement66_seat_number);
                if (appCompatTextView != null) {
                    i = R.id.tv_item_exam_arrangement66_seat_sign;
                    TextView textView2 = (TextView) view.findViewById(R.id.tv_item_exam_arrangement66_seat_sign);
                    if (textView2 != null) {
                        return new ItemExamArrangement66SeatBinding((ConstraintLayout) view, constraintLayout, textView, appCompatTextView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
