package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class DayStudentDutyItemPBinding implements ViewBinding {
    public final Button btDutyToday;
    public final LinearLayout llZr;
    private final LinearLayout rootView;
    public final RecyclerView rvDuty;
    public final TextView tvTitle;

    private DayStudentDutyItemPBinding(LinearLayout linearLayout, Button button, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.btDutyToday = button;
        this.llZr = linearLayout2;
        this.rvDuty = recyclerView;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DayStudentDutyItemPBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DayStudentDutyItemPBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.day_student_duty_item_p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DayStudentDutyItemPBinding bind(View view) {
        int i = R.id.bt_duty_today;
        Button button = (Button) view.findViewById(R.id.bt_duty_today);
        if (button != null) {
            i = R.id.ll_zr;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_zr);
            if (linearLayout != null) {
                i = R.id.rv_duty;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_duty);
                if (recyclerView != null) {
                    i = R.id.tv_title;
                    TextView textView = (TextView) view.findViewById(R.id.tv_title);
                    if (textView != null) {
                        return new DayStudentDutyItemPBinding((LinearLayout) view, button, linearLayout, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
