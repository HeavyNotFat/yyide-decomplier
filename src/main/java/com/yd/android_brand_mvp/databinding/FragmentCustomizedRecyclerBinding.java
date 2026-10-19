package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCustomizedRecyclerBinding implements ViewBinding {
    public final ConstraintLayout clFragmentCustomRecycler;
    private final ConstraintLayout rootView;
    public final RecyclerView rvFragmentCustomRecycler;
    public final LayoutCustomHeadTitleBinding topFragmentTitle;

    private FragmentCustomizedRecyclerBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, LayoutCustomHeadTitleBinding layoutCustomHeadTitleBinding) {
        this.rootView = constraintLayout;
        this.clFragmentCustomRecycler = constraintLayout2;
        this.rvFragmentCustomRecycler = recyclerView;
        this.topFragmentTitle = layoutCustomHeadTitleBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCustomizedRecyclerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCustomizedRecyclerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_customized_recycler, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCustomizedRecyclerBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.rv_fragment_custom_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_fragment_custom_recycler);
        if (recyclerView != null) {
            i = R.id.top_fragment_title;
            View viewFindViewById = view.findViewById(R.id.top_fragment_title);
            if (viewFindViewById != null) {
                return new FragmentCustomizedRecyclerBinding(constraintLayout, constraintLayout, recyclerView, LayoutCustomHeadTitleBinding.bind(viewFindViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
