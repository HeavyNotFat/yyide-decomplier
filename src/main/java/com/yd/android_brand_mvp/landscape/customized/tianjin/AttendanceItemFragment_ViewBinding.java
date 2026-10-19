package com.yd.android_brand_mvp.landscape.customized.tianjin;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.PieChart;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class AttendanceItemFragment_ViewBinding implements Unbinder {
    private AttendanceItemFragment target;

    public AttendanceItemFragment_ViewBinding(AttendanceItemFragment attendanceItemFragment, View view) {
        this.target = attendanceItemFragment;
        attendanceItemFragment.post = (TextView) Utils.findRequiredViewAsType(view, R.id.post, "field 'post'", TextView.class);
        attendanceItemFragment.s1 = (TextView) Utils.findRequiredViewAsType(view, R.id.s1, "field 's1'", TextView.class);
        attendanceItemFragment.s2 = (TextView) Utils.findRequiredViewAsType(view, R.id.s2, "field 's2'", TextView.class);
        attendanceItemFragment.s3 = (TextView) Utils.findRequiredViewAsType(view, R.id.s3, "field 's3'", TextView.class);
        attendanceItemFragment.s4 = (TextView) Utils.findRequiredViewAsType(view, R.id.s4, "field 's4'", TextView.class);
        attendanceItemFragment.t1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv1, "field 't1'", TextView.class);
        attendanceItemFragment.t2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv2, "field 't2'", TextView.class);
        attendanceItemFragment.t3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv3, "field 't3'", TextView.class);
        attendanceItemFragment.t4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv4, "field 't4'", TextView.class);
        attendanceItemFragment.y1 = (TextView) Utils.findRequiredViewAsType(view, R.id.y1, "field 'y1'", TextView.class);
        attendanceItemFragment.y2 = (TextView) Utils.findRequiredViewAsType(view, R.id.y2, "field 'y2'", TextView.class);
        attendanceItemFragment.y3 = (TextView) Utils.findRequiredViewAsType(view, R.id.y3, "field 'y3'", TextView.class);
        attendanceItemFragment.y4 = (TextView) Utils.findRequiredViewAsType(view, R.id.y4, "field 'y4'", TextView.class);
        attendanceItemFragment.piechart = (PieChart) Utils.findRequiredViewAsType(view, R.id.piechart, "field 'piechart'", PieChart.class);
        attendanceItemFragment.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        attendanceItemFragment.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        attendanceItemFragment.llItem = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_item, "field 'llItem'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttendanceItemFragment attendanceItemFragment = this.target;
        if (attendanceItemFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attendanceItemFragment.post = null;
        attendanceItemFragment.s1 = null;
        attendanceItemFragment.s2 = null;
        attendanceItemFragment.s3 = null;
        attendanceItemFragment.s4 = null;
        attendanceItemFragment.t1 = null;
        attendanceItemFragment.t2 = null;
        attendanceItemFragment.t3 = null;
        attendanceItemFragment.t4 = null;
        attendanceItemFragment.y1 = null;
        attendanceItemFragment.y2 = null;
        attendanceItemFragment.y3 = null;
        attendanceItemFragment.y4 = null;
        attendanceItemFragment.piechart = null;
        attendanceItemFragment.tvName = null;
        attendanceItemFragment.tvTime = null;
        attendanceItemFragment.llItem = null;
    }
}
