package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentYwbookBinding implements ViewBinding {
    public final FrameLayout content;
    public final GridView grid;
    public final LinearLayout llContent;
    private final LinearLayout rootView;

    private FragmentYwbookBinding(LinearLayout linearLayout, FrameLayout frameLayout, GridView gridView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.content = frameLayout;
        this.grid = gridView;
        this.llContent = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentYwbookBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentYwbookBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_ywbook, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentYwbookBinding bind(View view) {
        int i = R.id.content;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content);
        if (frameLayout != null) {
            i = R.id.grid;
            GridView gridView = (GridView) view.findViewById(R.id.grid);
            if (gridView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new FragmentYwbookBinding(linearLayout, frameLayout, gridView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
