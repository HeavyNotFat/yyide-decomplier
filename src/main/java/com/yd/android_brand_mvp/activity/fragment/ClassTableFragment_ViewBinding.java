package com.yd.android_brand_mvp.activity.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class ClassTableFragment_ViewBinding implements Unbinder {
    private ClassTableFragment target;

    public ClassTableFragment_ViewBinding(ClassTableFragment classTableFragment, View view) {
        this.target = classTableFragment;
        classTableFragment.gridRl = (GridView) Utils.findRequiredViewAsType(view, R.id.grid_rl, "field 'gridRl'", GridView.class);
        classTableFragment.listTable = (GridView) Utils.findRequiredViewAsType(view, R.id.list_table, "field 'listTable'", GridView.class);
        classTableFragment.table_view = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.table_view, "field 'table_view'", FrameLayout.class);
        classTableFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassTableFragment classTableFragment = this.target;
        if (classTableFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classTableFragment.gridRl = null;
        classTableFragment.listTable = null;
        classTableFragment.table_view = null;
        classTableFragment.mu = null;
    }
}
