package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentYwbook44LBinding implements ViewBinding {
    public final GridView grid;
    public final LayoutHeadTitleBinding inTop;
    private final FrameLayout rootView;

    private FragmentYwbook44LBinding(FrameLayout frameLayout, GridView gridView, LayoutHeadTitleBinding layoutHeadTitleBinding) {
        this.rootView = frameLayout;
        this.grid = gridView;
        this.inTop = layoutHeadTitleBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static FragmentYwbook44LBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentYwbook44LBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ywbook4_4_l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentYwbook44LBinding bind(View view) {
        int i = R.id.grid;
        GridView gridView = (GridView) view.findViewById(R.id.grid);
        if (gridView != null) {
            i = R.id.in_top;
            View viewFindViewById = view.findViewById(R.id.in_top);
            if (viewFindViewById != null) {
                return new FragmentYwbook44LBinding((FrameLayout) view, gridView, LayoutHeadTitleBinding.bind(viewFindViewById));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
