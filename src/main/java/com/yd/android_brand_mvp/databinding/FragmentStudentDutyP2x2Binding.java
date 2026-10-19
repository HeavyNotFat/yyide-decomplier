package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentStudentDutyP2x2Binding implements ViewBinding {
    public final MultiStateView mu;
    private final FrameLayout rootView;
    public final RecyclerView rvDuty;

    private FragmentStudentDutyP2x2Binding(FrameLayout frameLayout, MultiStateView multiStateView, RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.mu = multiStateView;
        this.rvDuty = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentStudentDutyP2x2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentStudentDutyP2x2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_student_duty_p2x2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentStudentDutyP2x2Binding bind(View view) {
        int i = R.id.mu;
        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
        if (multiStateView != null) {
            i = R.id.rv_duty;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_duty);
            if (recyclerView != null) {
                return new FragmentStudentDutyP2x2Binding((FrameLayout) view, multiStateView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
