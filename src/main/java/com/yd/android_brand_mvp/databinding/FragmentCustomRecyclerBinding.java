package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCustomRecyclerBinding implements ViewBinding {
    public final ConstraintLayout clFragmentCustomRecycler;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentCustomRecycler;
    public final LayoutHeadTitle2Binding topFragmentTitle;

    private FragmentCustomRecyclerBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, LayoutHeadTitle2Binding layoutHeadTitle2Binding) {
        this.rootView = constraintLayout;
        this.clFragmentCustomRecycler = constraintLayout2;
        this.rvFragmentCustomRecycler = recyclerView;
        this.topFragmentTitle = layoutHeadTitle2Binding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCustomRecyclerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCustomRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_custom_recycler, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCustomRecyclerBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.rv_fragment_custom_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_custom_recycler);
        if (recyclerView != null) {
            i = R.id.top_fragment_title;
            View viewFindViewById = view.findViewById(R.id.top_fragment_title);
            if (viewFindViewById != null) {
                return new FragmentCustomRecyclerBinding(constraintLayout, constraintLayout, recyclerView, LayoutHeadTitle2Binding.bind(viewFindViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
