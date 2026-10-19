package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentAssignmentDayBinding implements ViewBinding {
    public final LinearLayout llIndicator;
    public final MultiStateView mu;
    private final RelativeLayout rootView;
    public final RecyclerView rvList;

    private FragmentAssignmentDayBinding(RelativeLayout relativeLayout, LinearLayout linearLayout, MultiStateView multiStateView, RecyclerView recyclerView) {
        this.rootView = relativeLayout;
        this.llIndicator = linearLayout;
        this.mu = multiStateView;
        this.rvList = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAssignmentDayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAssignmentDayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_assignment_day, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAssignmentDayBinding bind(View view) {
        int i = R.id.ll_indicator;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_indicator);
        if (linearLayout != null) {
            i = R.id.mu;
            MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
            if (multiStateView != null) {
                i = R.id.rv_list;
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_list);
                if (recyclerView != null) {
                    return new FragmentAssignmentDayBinding((RelativeLayout) view, linearLayout, multiStateView, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
