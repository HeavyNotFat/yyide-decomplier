package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentRecyclerViewBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RecyclerView rvFragmentContent;
    public final SwipeRefreshLayout srlRecycler;

    private FragmentRecyclerViewBinding(LinearLayout linearLayout, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout) {
        this.rootView = linearLayout;
        this.rvFragmentContent = recyclerView;
        this.srlRecycler = swipeRefreshLayout;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentRecyclerViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentRecyclerViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_recycler_view, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentRecyclerViewBinding bind(View view) {
        int i = R.id.rv_fragment_content;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_content);
        if (recyclerView != null) {
            i = R.id.srl_recycler;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.srl_recycler);
            if (swipeRefreshLayout != null) {
                return new FragmentRecyclerViewBinding((LinearLayout) view, recyclerView, swipeRefreshLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
