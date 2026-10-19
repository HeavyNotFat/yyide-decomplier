package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassScheduleSk44lBinding implements ViewBinding {
    public final FrameLayout contentLayout;
    public final GridView gridRl;
    public final GridView listTable;
    public final MultiStateView mu;
    public final TextView nodata;
    private final LinearLayout rootView;
    public final FrameLayout tableView;

    private FragmentClassScheduleSk44lBinding(LinearLayout linearLayout, FrameLayout frameLayout, GridView gridView, GridView gridView2, MultiStateView multiStateView, TextView textView, FrameLayout frameLayout2) {
        this.rootView = linearLayout;
        this.contentLayout = frameLayout;
        this.gridRl = gridView;
        this.listTable = gridView2;
        this.mu = multiStateView;
        this.nodata = textView;
        this.tableView = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassScheduleSk44lBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassScheduleSk44lBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule_sk4_4l, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassScheduleSk44lBinding bind(View view) {
        int i = R.id.content_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_layout);
        if (frameLayout != null) {
            i = R.id.grid_rl;
            GridView gridView = (GridView) view.findViewById(R.id.grid_rl);
            if (gridView != null) {
                i = R.id.list_table;
                GridView gridView2 = (GridView) view.findViewById(R.id.list_table);
                if (gridView2 != null) {
                    i = R.id.mu;
                    MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                    if (multiStateView != null) {
                        i = R.id.nodata;
                        TextView textView = (TextView) view.findViewById(R.id.nodata);
                        if (textView != null) {
                            i = R.id.table_view;
                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.table_view);
                            if (frameLayout2 != null) {
                                return new FragmentClassScheduleSk44lBinding((LinearLayout) view, frameLayout, gridView, gridView2, multiStateView, textView, frameLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
