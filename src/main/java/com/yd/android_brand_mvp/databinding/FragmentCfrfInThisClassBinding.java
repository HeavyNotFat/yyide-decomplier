package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentCfrfInThisClassBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final RecyclerView rvCfrfInThisClass;

    private FragmentCfrfInThisClassBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.rvCfrfInThisClass = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentCfrfInThisClassBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentCfrfInThisClassBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_cfrf_in_this_class, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentCfrfInThisClassBinding bind(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_cfrf_in_this_class);
        if (recyclerView != null) {
            return new FragmentCfrfInThisClassBinding((ConstraintLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.rv_cfrf_in_this_class)));
    }
}
