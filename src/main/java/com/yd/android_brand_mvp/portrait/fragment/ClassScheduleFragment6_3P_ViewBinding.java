package com.yd.android_brand_mvp.portrait.fragment;

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
public class ClassScheduleFragment6_3P_ViewBinding implements Unbinder {
    private ClassScheduleFragment6_3P target;
    private View view7f0a0863;

    public ClassScheduleFragment6_3P_ViewBinding(final ClassScheduleFragment6_3P classScheduleFragment6_3P, View view) {
        this.target = classScheduleFragment6_3P;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onViewClicked'");
        classScheduleFragment6_3P.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassScheduleFragment6_3P_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleFragment6_3P.onViewClicked(view2);
            }
        });
        classScheduleFragment6_3P.tv_week = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_week, "field 'tv_week'", TextView.class);
        classScheduleFragment6_3P.gridRl = (GridView) Utils.findRequiredViewAsType(view, R.id.grid_rl, "field 'gridRl'", GridView.class);
        classScheduleFragment6_3P.listTable = (GridView) Utils.findRequiredViewAsType(view, R.id.list_table, "field 'listTable'", GridView.class);
        classScheduleFragment6_3P.nodata = (TextView) Utils.findRequiredViewAsType(view, R.id.nodata, "field 'nodata'", TextView.class);
        classScheduleFragment6_3P.tableView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.table_view, "field 'tableView'", FrameLayout.class);
        classScheduleFragment6_3P.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassScheduleFragment6_3P classScheduleFragment6_3P = this.target;
        if (classScheduleFragment6_3P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classScheduleFragment6_3P.title = null;
        classScheduleFragment6_3P.tv_week = null;
        classScheduleFragment6_3P.gridRl = null;
        classScheduleFragment6_3P.listTable = null;
        classScheduleFragment6_3P.nodata = null;
        classScheduleFragment6_3P.tableView = null;
        classScheduleFragment6_3P.mu = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
    }
}
