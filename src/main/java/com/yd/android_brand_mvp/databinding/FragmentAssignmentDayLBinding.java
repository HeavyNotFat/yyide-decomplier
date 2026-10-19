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
public final class FragmentAssignmentDayLBinding implements ViewBinding {
    public final MultiStateView mu;
    public final RecyclerView rlList;
    private final FrameLayout rootView;

    private FragmentAssignmentDayLBinding(FrameLayout frameLayout, MultiStateView multiStateView, RecyclerView recyclerView) {
        this.rootView = frameLayout;
        this.mu = multiStateView;
        this.rlList = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentAssignmentDayLBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentAssignmentDayLBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_assignment_day_l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentAssignmentDayLBinding bind(View view) {
        int i = R.id.mu;
        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
        if (multiStateView != null) {
            i = R.id.rl_list;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rl_list);
            if (recyclerView != null) {
                return new FragmentAssignmentDayLBinding((FrameLayout) view, multiStateView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
