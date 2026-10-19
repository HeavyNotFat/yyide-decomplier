package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.customview.NestRecyclerView;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentWeekStudentDutyBinding implements ViewBinding {
    public final MultiStateView mu;
    private final FrameLayout rootView;
    public final NestRecyclerView rvAllDuty;

    private FragmentWeekStudentDutyBinding(FrameLayout frameLayout, MultiStateView multiStateView, NestRecyclerView nestRecyclerView) {
        this.rootView = frameLayout;
        this.mu = multiStateView;
        this.rvAllDuty = nestRecyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentWeekStudentDutyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentWeekStudentDutyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_week_student_duty, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentWeekStudentDutyBinding bind(View view) {
        int i = R.id.mu;
        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
        if (multiStateView != null) {
            i = R.id.rv_all_duty;
            NestRecyclerView nestRecyclerView = (NestRecyclerView) view.findViewById(R.id.rv_all_duty);
            if (nestRecyclerView != null) {
                return new FragmentWeekStudentDutyBinding((FrameLayout) view, multiStateView, nestRecyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
