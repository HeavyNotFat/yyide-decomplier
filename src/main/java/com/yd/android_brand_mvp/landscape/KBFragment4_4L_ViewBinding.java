package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class KBFragment4_4L_ViewBinding implements Unbinder {
    private KBFragment4_4L target;
    private View view7f0a0863;

    public KBFragment4_4L_ViewBinding(final KBFragment4_4L kBFragment4_4L, View view) {
        this.target = kBFragment4_4L;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onViewClicked'");
        kBFragment4_4L.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.KBFragment4_4L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment4_4L.onViewClicked(view2);
            }
        });
        kBFragment4_4L.tv_week = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_week, "field 'tv_week'", TextView.class);
        kBFragment4_4L.gridRl = (GridView) Utils.findRequiredViewAsType(view, R.id.grid_rl, "field 'gridRl'", GridView.class);
        kBFragment4_4L.listTable = (GridView) Utils.findRequiredViewAsType(view, R.id.list_table, "field 'listTable'", GridView.class);
        kBFragment4_4L.tableView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.table_view, "field 'tableView'", FrameLayout.class);
        kBFragment4_4L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        KBFragment4_4L kBFragment4_4L = this.target;
        if (kBFragment4_4L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        kBFragment4_4L.title = null;
        kBFragment4_4L.tv_week = null;
        kBFragment4_4L.gridRl = null;
        kBFragment4_4L.listTable = null;
        kBFragment4_4L.tableView = null;
        kBFragment4_4L.mu = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
    }
}
