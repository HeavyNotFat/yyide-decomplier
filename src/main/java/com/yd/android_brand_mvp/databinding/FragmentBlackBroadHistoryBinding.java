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
public final class FragmentBlackBroadHistoryBinding implements ViewBinding {
    public final MultiStateView mu;
    private final ConstraintLayout rootView;
    public final RecyclerView rvChild;
    public final RecyclerView rvContent;
    public final RecyclerView rvHome;
    public final TextView tvSubject;
    public final TextView tvSubjectName;

    private FragmentBlackBroadHistoryBinding(ConstraintLayout constraintLayout, MultiStateView multiStateView, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, TextView textView, TextView textView2) {
        this.rootView = constraintLayout;
        this.mu = multiStateView;
        this.rvChild = recyclerView;
        this.rvContent = recyclerView2;
        this.rvHome = recyclerView3;
        this.tvSubject = textView;
        this.tvSubjectName = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBlackBroadHistoryBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBlackBroadHistoryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_black_broad_history, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentBlackBroadHistoryBinding bind(View view) {
        int i = R.id.mu;
        MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
        if (multiStateView != null) {
            i = R.id.rvChild;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvChild);
            if (recyclerView != null) {
                i = R.id.rvContent;
                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.rvContent);
                if (recyclerView2 != null) {
                    i = R.id.rvHome;
                    RecyclerView recyclerView3 = (RecyclerView) view.findViewById(R.id.rvHome);
                    if (recyclerView3 != null) {
                        i = R.id.tvSubject;
                        TextView textView = (TextView) view.findViewById(R.id.tvSubject);
                        if (textView != null) {
                            i = R.id.tvSubjectName;
                            TextView textView2 = (TextView) view.findViewById(R.id.tvSubjectName);
                            if (textView2 != null) {
                                return new FragmentBlackBroadHistoryBinding((ConstraintLayout) view, multiStateView, recyclerView, recyclerView2, recyclerView3, textView, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
