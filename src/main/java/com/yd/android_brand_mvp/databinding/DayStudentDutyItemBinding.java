package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.customview.NestRecyclerView;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class DayStudentDutyItemBinding implements ViewBinding {
    public final Button btDutyToday;
    public final LinearLayout llZr;
    public final MultiStateView mu;
    private final LinearLayout rootView;
    public final NestRecyclerView rvDuty;
    public final TextView tvTitle;

    private DayStudentDutyItemBinding(LinearLayout linearLayout, Button button, LinearLayout linearLayout2, MultiStateView multiStateView, NestRecyclerView nestRecyclerView, TextView textView) {
        this.rootView = linearLayout;
        this.btDutyToday = button;
        this.llZr = linearLayout2;
        this.mu = multiStateView;
        this.rvDuty = nestRecyclerView;
        this.tvTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DayStudentDutyItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DayStudentDutyItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.day_student_duty_item, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static DayStudentDutyItemBinding bind(View view) {
        int i = R.id.bt_duty_today;
        Button button = (Button) view.findViewById(R.id.bt_duty_today);
        if (button != null) {
            i = R.id.ll_zr;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_zr);
            if (linearLayout != null) {
                i = R.id.mu;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                if (multiStateView != null) {
                    i = R.id.rv_duty;
                    NestRecyclerView nestRecyclerView = (NestRecyclerView) view.findViewById(R.id.rv_duty);
                    if (nestRecyclerView != null) {
                        i = R.id.tv_title;
                        TextView textView = (TextView) view.findViewById(R.id.tv_title);
                        if (textView != null) {
                            return new DayStudentDutyItemBinding((LinearLayout) view, button, linearLayout, multiStateView, nestRecyclerView, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
