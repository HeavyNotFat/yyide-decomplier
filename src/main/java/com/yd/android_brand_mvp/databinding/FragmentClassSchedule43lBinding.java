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
public final class FragmentClassSchedule43lBinding implements ViewBinding {
    public final FrameLayout contentLayout;
    public final GridView listTable;
    private final LinearLayout rootView;

    private FragmentClassSchedule43lBinding(LinearLayout linearLayout, FrameLayout frameLayout, GridView gridView) {
        this.rootView = linearLayout;
        this.contentLayout = frameLayout;
        this.listTable = gridView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassSchedule43lBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassSchedule43lBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule4_3l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassSchedule43lBinding bind(View view) {
        int i = R.id.content_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_layout);
        if (frameLayout != null) {
            i = R.id.list_table;
            GridView gridView = (GridView) view.findViewById(R.id.list_table);
            if (gridView != null) {
                return new FragmentClassSchedule43lBinding((LinearLayout) view, frameLayout, gridView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
