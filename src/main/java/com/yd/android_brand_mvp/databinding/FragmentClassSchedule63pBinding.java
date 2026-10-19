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
import com.yd.android_brand_mvp.customview.MyGridView;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class FragmentClassSchedule63pBinding implements ViewBinding {
    public final FrameLayout contentLayout;
    public final MyGridView gridRl;
    public final GridView listTable;
    public final MultiStateView mu;
    public final TextView nodata;
    private final LinearLayout rootView;
    public final FrameLayout tableView;

    private FragmentClassSchedule63pBinding(LinearLayout linearLayout, FrameLayout frameLayout, MyGridView myGridView, GridView gridView, MultiStateView multiStateView, TextView textView, FrameLayout frameLayout2) {
        this.rootView = linearLayout;
        this.contentLayout = frameLayout;
        this.gridRl = myGridView;
        this.listTable = gridView;
        this.mu = multiStateView;
        this.nodata = textView;
        this.tableView = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentClassSchedule63pBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FragmentClassSchedule63pBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_class_schedule6_3p, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static FragmentClassSchedule63pBinding bind(View view) {
        int i = R.id.content_layout;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.content_layout);
        if (frameLayout != null) {
            i = R.id.grid_rl;
            MyGridView myGridView = (MyGridView) view.findViewById(R.id.grid_rl);
            if (myGridView != null) {
                i = R.id.list_table;
                GridView gridView = (GridView) view.findViewById(R.id.list_table);
                if (gridView != null) {
                    i = R.id.mu;
                    MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                    if (multiStateView != null) {
                        i = R.id.nodata;
                        TextView textView = (TextView) view.findViewById(R.id.nodata);
                        if (textView != null) {
                            i = R.id.table_view;
                            FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.table_view);
                            if (frameLayout2 != null) {
                                return new FragmentClassSchedule63pBinding((LinearLayout) view, frameLayout, myGridView, gridView, multiStateView, textView, frameLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
