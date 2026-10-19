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
public final class ItemExamFullSeatBinding implements ViewBinding {
    public final ConstraintLayout clItemExamFullSeatLeft;
    private final ConstraintLayout rootView;
    public final TextView tvItemExamFullExamineNumber;
    public final TextView tvItemExamFullName;
    public final AppCompatTextView tvItemExamFullSeatNumber;
    public final TextView tvItemExamFullSeatSign;
    public final View viewLine;

    private ItemExamFullSeatBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, AppCompatTextView appCompatTextView, TextView textView3, View view) {
        this.rootView = constraintLayout;
        this.clItemExamFullSeatLeft = constraintLayout2;
        this.tvItemExamFullExamineNumber = textView;
        this.tvItemExamFullName = textView2;
        this.tvItemExamFullSeatNumber = appCompatTextView;
        this.tvItemExamFullSeatSign = textView3;
        this.viewLine = view;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemExamFullSeatBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ItemExamFullSeatBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.item_exam_full_seat, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ItemExamFullSeatBinding bind(View view) {
        int i = R.id.cl_item_exam_full_seat_left;
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.cl_item_exam_full_seat_left);
        if (constraintLayout != null) {
            i = R.id.tv_item_exam_full_examineNumber;
            TextView textView = (TextView) view.findViewById(R.id.tv_item_exam_full_examineNumber);
            if (textView != null) {
                i = R.id.tv_item_exam_full_name;
                TextView textView2 = (TextView) view.findViewById(R.id.tv_item_exam_full_name);
                if (textView2 != null) {
                    i = R.id.tv_item_exam_full_seat_number;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.tv_item_exam_full_seat_number);
                    if (appCompatTextView != null) {
                        i = R.id.tv_item_exam_full_seat_sign;
                        TextView textView3 = (TextView) view.findViewById(R.id.tv_item_exam_full_seat_sign);
                        if (textView3 != null) {
                            i = R.id.view_line;
                            View viewFindViewById = view.findViewById(R.id.view_line);
                            if (viewFindViewById != null) {
                                return new ItemExamFullSeatBinding((ConstraintLayout) view, constraintLayout, textView, textView2, appCompatTextView, textView3, viewFindViewById);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
