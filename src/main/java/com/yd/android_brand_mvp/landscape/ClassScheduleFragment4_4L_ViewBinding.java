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
public class ClassScheduleFragment4_4L_ViewBinding implements Unbinder {
    private ClassScheduleFragment4_4L target;
    private View view7f0a0863;

    public ClassScheduleFragment4_4L_ViewBinding(final ClassScheduleFragment4_4L classScheduleFragment4_4L, View view) {
        this.target = classScheduleFragment4_4L;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onViewClicked'");
        classScheduleFragment4_4L.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.ClassScheduleFragment4_4L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleFragment4_4L.onViewClicked(view2);
            }
        });
        classScheduleFragment4_4L.tv_week = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_week, "field 'tv_week'", TextView.class);
        classScheduleFragment4_4L.gridRl = (GridView) Utils.findRequiredViewAsType(view, R.id.grid_rl, "field 'gridRl'", GridView.class);
        classScheduleFragment4_4L.listTable = (GridView) Utils.findRequiredViewAsType(view, R.id.list_table, "field 'listTable'", GridView.class);
        classScheduleFragment4_4L.nodata = (TextView) Utils.findRequiredViewAsType(view, R.id.nodata, "field 'nodata'", TextView.class);
        classScheduleFragment4_4L.tableView = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.table_view, "field 'tableView'", FrameLayout.class);
        classScheduleFragment4_4L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassScheduleFragment4_4L classScheduleFragment4_4L = this.target;
        if (classScheduleFragment4_4L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classScheduleFragment4_4L.title = null;
        classScheduleFragment4_4L.tv_week = null;
        classScheduleFragment4_4L.gridRl = null;
        classScheduleFragment4_4L.listTable = null;
        classScheduleFragment4_4L.nodata = null;
        classScheduleFragment4_4L.tableView = null;
        classScheduleFragment4_4L.mu = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
    }
}
