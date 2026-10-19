package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentBlackBroadTodayBinding implements ViewBinding {
    public final MultiStateView mu;
    private final ConstraintLayout rootView;
    public final RecyclerView rvContent;
    public final RecyclerView rvHome;
    public final TextView tvSubject;

    private FragmentBlackBroadTodayBinding(ConstraintLayout constraintLayout, MultiStateView multiStateView, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView) {
        this.rootView = constraintLayout;
        this.mu = multiStateView;
        this.rvContent = recyclerView;
        this.rvHome = recyclerView2;
        this.tvSubject = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBlackBroadTodayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBlackBroadTodayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_black_broad_today, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentBlackBroadTodayBinding bind(View view) {
        int i = R.id.mu;
        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
        if (multiStateView != null) {
            i = R.id.rvContent;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvContent);
            if (recyclerView != null) {
                i = R.id.rvHome;
                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rvHome);
                if (recyclerView2 != null) {
                    i = R.id.tvSubject;
                    TextView textView = (TextView) view.findViewById(R.id.tvSubject);
                    if (textView != null) {
                        return new FragmentBlackBroadTodayBinding((ConstraintLayout) view, multiStateView, recyclerView, recyclerView2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
