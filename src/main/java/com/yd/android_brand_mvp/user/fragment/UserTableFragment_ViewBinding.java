package com.yd.android_brand_mvp.user.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class UserTableFragment_ViewBinding implements Unbinder {
    private UserTableFragment target;

    public UserTableFragment_ViewBinding(UserTableFragment userTableFragment, View view) {
        this.target = userTableFragment;
        userTableFragment.gridRl = (GridView) Utils.findRequiredViewAsType(view, R.id.grid_rl, "field 'gridRl'", GridView.class);
        userTableFragment.listTable = (GridView) Utils.findRequiredViewAsType(view, R.id.list_table, "field 'listTable'", GridView.class);
        userTableFragment.table_view = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.table_view, "field 'table_view'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        UserTableFragment userTableFragment = this.target;
        if (userTableFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        userTableFragment.gridRl = null;
        userTableFragment.listTable = null;
        userTableFragment.table_view = null;
    }
}
