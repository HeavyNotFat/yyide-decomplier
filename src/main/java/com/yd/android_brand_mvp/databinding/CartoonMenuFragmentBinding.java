package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class CartoonMenuFragmentBinding implements ViewBinding {
    public final FragmentContainerView containerView;
    public final RecyclerView menuRecyclerView;
    private final ConstraintLayout rootView;

    private CartoonMenuFragmentBinding(ConstraintLayout constraintLayout, FragmentContainerView fragmentContainerView, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.containerView = fragmentContainerView;
        this.menuRecyclerView = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static CartoonMenuFragmentBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CartoonMenuFragmentBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.cartoon_menu_fragment, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CartoonMenuFragmentBinding bind(View view) {
        int i = R.id.containerView;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) view.findViewById(R.id.containerView);
        if (fragmentContainerView != null) {
            i = R.id.menuRecyclerView;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.menuRecyclerView);
            if (recyclerView != null) {
                return new CartoonMenuFragmentBinding((ConstraintLayout) view, fragmentContainerView, recyclerView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
