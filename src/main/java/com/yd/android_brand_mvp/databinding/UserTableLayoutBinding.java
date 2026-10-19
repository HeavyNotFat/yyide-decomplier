package com.yd.android_brand_mvp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridView;
import androidx.viewbinding.ViewBinding;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.customview.MyGridView;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public final class UserTableLayoutBinding implements ViewBinding {
    public final MyGridView gridRl;
    public final GridView listTable;
    public final MultiStateView mu;
    private final FrameLayout rootView;
    public final FrameLayout tableView;

    private UserTableLayoutBinding(FrameLayout frameLayout, MyGridView myGridView, GridView gridView, MultiStateView multiStateView, FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.gridRl = myGridView;
        this.listTable = gridView;
        this.mu = multiStateView;
        this.tableView = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static UserTableLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static UserTableLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.user_table_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static UserTableLayoutBinding bind(View view) {
        int i = R.id.grid_rl;
        MyGridView myGridView = (MyGridView) view.findViewById(R.id.grid_rl);
        if (myGridView != null) {
            i = R.id.list_table;
            GridView gridView = (GridView) view.findViewById(R.id.list_table);
            if (gridView != null) {
                i = R.id.mu;
                MultiStateView multiStateView = (MultiStateView) view.findViewById(R.id.mu);
                if (multiStateView != null) {
                    i = R.id.table_view;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.table_view);
                    if (frameLayout != null) {
                        return new UserTableLayoutBinding((FrameLayout) view, myGridView, gridView, multiStateView, frameLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
