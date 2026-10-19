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

/* JADX INFO: loaded from: classes4.dex */
public final class ActivityTableActiviy2Binding implements ViewBinding {
    public final TextView back;
    public final FrameLayout backLayout;
    public final MyGridView gridRl;
    public final GridView listTable;
    private final LinearLayout rootView;
    public final FrameLayout tableView;

    private ActivityTableActiviy2Binding(LinearLayout linearLayout, TextView textView, FrameLayout frameLayout, MyGridView myGridView, GridView gridView, FrameLayout frameLayout2) {
        this.rootView = linearLayout;
        this.back = textView;
        this.backLayout = frameLayout;
        this.gridRl = myGridView;
        this.listTable = gridView;
        this.tableView = frameLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityTableActiviy2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivityTableActiviy2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_table_activiy2, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ActivityTableActiviy2Binding bind(View view) {
        int i = R.id.back;
        TextView textView = (TextView) view.findViewById(R.id.back);
        if (textView != null) {
            i = R.id.back_layout;
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.back_layout);
            if (frameLayout != null) {
                i = R.id.grid_rl;
                MyGridView myGridView = (MyGridView) view.findViewById(R.id.grid_rl);
                if (myGridView != null) {
                    i = R.id.list_table;
                    GridView gridView = (GridView) view.findViewById(R.id.list_table);
                    if (gridView != null) {
                        i = R.id.table_view;
                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.table_view);
                        if (frameLayout2 != null) {
                            return new ActivityTableActiviy2Binding((LinearLayout) view, textView, frameLayout, myGridView, gridView, frameLayout2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
