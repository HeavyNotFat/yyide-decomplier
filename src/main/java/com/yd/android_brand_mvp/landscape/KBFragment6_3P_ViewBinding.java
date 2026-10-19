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
public class KBFragment6_3P_ViewBinding implements Unbinder {
    private KBFragment6_3P target;
    private View view7f0a0863;

    public KBFragment6_3P_ViewBinding(final KBFragment6_3P kBFragment6_3P, View view) {
        this.target = kBFragment6_3P;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onViewClicked'");
        kBFragment6_3P.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.KBFragment6_3P_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment6_3P.onViewClicked(view2);
            }
        });
        kBFragment6_3P.gridRl = (GridView) Utils.findRequiredViewAsType(view, R.id.grid_rl, "field 'gridRl'", GridView.class);
        kBFragment6_3P.tv_week = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_week, "field 'tv_week'", TextView.class);
        kBFragment6_3P.listTable = (GridView) Utils.findRequiredViewAsType(view, R.id.list_table, "field 'listTable'", GridView.class);
        kBFragment6_3P.nodata = (TextView) Utils.findRequiredViewAsType(view, R.id.nodata, "field 'nodata'", TextView.class);
        kBFragment6_3P.tableView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.table_view, "field 'tableView'", FrameLayout.class);
        kBFragment6_3P.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        KBFragment6_3P kBFragment6_3P = this.target;
        if (kBFragment6_3P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        kBFragment6_3P.title = null;
        kBFragment6_3P.gridRl = null;
        kBFragment6_3P.tv_week = null;
        kBFragment6_3P.listTable = null;
        kBFragment6_3P.nodata = null;
        kBFragment6_3P.tableView = null;
        kBFragment6_3P.mu = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
    }
}
