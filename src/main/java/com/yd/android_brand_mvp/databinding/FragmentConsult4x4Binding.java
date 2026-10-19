package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentConsult4x4Binding implements ViewBinding {
    public final RecyclerView recyclerView;
    private final LinearLayoutCompat rootView;
    public final LayoutHeadTitleBinding top;

    private FragmentConsult4x4Binding(LinearLayoutCompat linearLayoutCompat, RecyclerView recyclerView, LayoutHeadTitleBinding layoutHeadTitleBinding) {
        this.rootView = linearLayoutCompat;
        this.recyclerView = recyclerView;
        this.top = layoutHeadTitleBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static FragmentConsult4x4Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentConsult4x4Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_consult4x4, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentConsult4x4Binding bind(View view) {
        int i = R.id.recyclerView;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        if (recyclerView != null) {
            i = R.id.top;
            View viewFindViewById = view.findViewById(R.id.top);
            if (viewFindViewById != null) {
                return new FragmentConsult4x4Binding((LinearLayoutCompat) view, recyclerView, LayoutHeadTitleBinding.bind(viewFindViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
