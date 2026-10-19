package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentStudentDutyL2x3Binding implements ViewBinding {
    public final MultiStateView mu;
    private final FrameLayout rootView;
    public final RecyclerView rvDuty;
    public final TextView title;

    private FragmentStudentDutyL2x3Binding(FrameLayout frameLayout, MultiStateView multiStateView, RecyclerView recyclerView, TextView textView) {
        this.rootView = frameLayout;
        this.mu = multiStateView;
        this.rvDuty = recyclerView;
        this.title = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentStudentDutyL2x3Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentStudentDutyL2x3Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_student_duty_l2x3, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentStudentDutyL2x3Binding bind(View view) {
        int i = R.id.mu;
        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
        if (multiStateView != null) {
            i = R.id.rv_duty;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_duty);
            if (recyclerView != null) {
                i = R.id.title;
                TextView textView = (TextView) view.findViewById(R.id.title);
                if (textView != null) {
                    return new FragmentStudentDutyL2x3Binding((FrameLayout) view, multiStateView, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
