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
public class ClassScheduleFragment6_3P2_ViewBinding implements Unbinder {
    private ClassScheduleFragment6_3P2 target;
    private View view7f0a0863;

    public ClassScheduleFragment6_3P2_ViewBinding(final ClassScheduleFragment6_3P2 classScheduleFragment6_3P2, View view) {
        this.target = classScheduleFragment6_3P2;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onViewClicked'");
        classScheduleFragment6_3P2.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.ClassScheduleFragment6_3P2_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleFragment6_3P2.onViewClicked(view2);
            }
        });
        classScheduleFragment6_3P2.tv_week = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_week, "field 'tv_week'", TextView.class);
        classScheduleFragment6_3P2.gridRl = (GridView) Utils.findRequiredViewAsType(view, R.id.grid_rl, "field 'gridRl'", GridView.class);
        classScheduleFragment6_3P2.listTable = (GridView) Utils.findRequiredViewAsType(view, R.id.list_table, "field 'listTable'", GridView.class);
        classScheduleFragment6_3P2.nodata = (TextView) Utils.findRequiredViewAsType(view, R.id.nodata, "field 'nodata'", TextView.class);
        classScheduleFragment6_3P2.tableView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.table_view, "field 'tableView'", FrameLayout.class);
        classScheduleFragment6_3P2.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassScheduleFragment6_3P2 classScheduleFragment6_3P2 = this.target;
        if (classScheduleFragment6_3P2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classScheduleFragment6_3P2.title = null;
        classScheduleFragment6_3P2.tv_week = null;
        classScheduleFragment6_3P2.gridRl = null;
        classScheduleFragment6_3P2.listTable = null;
        classScheduleFragment6_3P2.nodata = null;
        classScheduleFragment6_3P2.tableView = null;
        classScheduleFragment6_3P2.mu = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
    }
}
