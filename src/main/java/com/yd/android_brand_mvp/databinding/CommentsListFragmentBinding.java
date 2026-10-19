package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class CommentsListFragmentBinding implements ViewBinding {
    public final MultiStateView mu;
    public final RecyclerView recyclerView;
    private final ConstraintLayout rootView;

    private CommentsListFragmentBinding(ConstraintLayout constraintLayout, MultiStateView multiStateView, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.mu = multiStateView;
        this.recyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CommentsListFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CommentsListFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.comments_list_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CommentsListFragmentBinding bind(View view) {
        int i = R.id.mu;
        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
        if (multiStateView != null) {
            i = R.id.recyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            if (recyclerView != null) {
                return new CommentsListFragmentBinding((ConstraintLayout) view, multiStateView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
