package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class NcalendarAcFragment_ViewBinding implements Unbinder {
    private NcalendarAcFragment target;

    public NcalendarAcFragment_ViewBinding(NcalendarAcFragment ncalendarAcFragment, View view) {
        this.target = ncalendarAcFragment;
        ncalendarAcFragment.top_grid = (GridView) Utils.findRequiredViewAsType(view, R.id.top_grid, "field 'top_grid'", GridView.class);
        ncalendarAcFragment.week_grid = (GridView) Utils.findRequiredViewAsType(view, R.id.week_grid, "field 'week_grid'", GridView.class);
        ncalendarAcFragment.lyaout_year = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.lyaout_year, "field 'lyaout_year'", LinearLayout.class);
        ncalendarAcFragment.layout_week = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_week, "field 'layout_week'", LinearLayout.class);
        ncalendarAcFragment.layout_month = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_month, "field 'layout_month'", LinearLayout.class);
        ncalendarAcFragment.listview = (ListView) Utils.findRequiredViewAsType(view, R.id.listview, "field 'listview'", ListView.class);
        ncalendarAcFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        ncalendarAcFragment.all_mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.all_mu, "field 'all_mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NcalendarAcFragment ncalendarAcFragment = this.target;
        if (ncalendarAcFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        ncalendarAcFragment.top_grid = null;
        ncalendarAcFragment.week_grid = null;
        ncalendarAcFragment.lyaout_year = null;
        ncalendarAcFragment.layout_week = null;
        ncalendarAcFragment.layout_month = null;
        ncalendarAcFragment.listview = null;
        ncalendarAcFragment.mu = null;
        ncalendarAcFragment.all_mu = null;
    }
}
