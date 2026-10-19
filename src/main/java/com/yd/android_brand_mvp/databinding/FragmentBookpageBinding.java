package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentBookpageBinding implements ViewBinding {
    public final GridView grid;
    public final LinearLayout mu;
    private final LinearLayout rootView;

    private FragmentBookpageBinding(LinearLayout linearLayout, GridView gridView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.grid = gridView;
        this.mu = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBookpageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentBookpageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_bookpage, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentBookpageBinding bind(View view) {
        GridView gridView = (GridView) view.findViewById(R.id.grid);
        if (gridView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            return new FragmentBookpageBinding(linearLayout, gridView, linearLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.grid)));
    }
}
