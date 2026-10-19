package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.PieChart;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceFragment_ViewBinding implements Unbinder {
    private AttenceFragment target;

    public AttenceFragment_ViewBinding(AttenceFragment attenceFragment, View view) {
        this.target = attenceFragment;
        attenceFragment.post = (TextView) Utils.findRequiredViewAsType(view, R.id.post, "field 'post'", TextView.class);
        attenceFragment.s1 = (TextView) Utils.findRequiredViewAsType(view, R.id.s1, "field 's1'", TextView.class);
        attenceFragment.s2 = (TextView) Utils.findRequiredViewAsType(view, R.id.s2, "field 's2'", TextView.class);
        attenceFragment.s3 = (TextView) Utils.findRequiredViewAsType(view, R.id.s3, "field 's3'", TextView.class);
        attenceFragment.s4 = (TextView) Utils.findRequiredViewAsType(view, R.id.s4, "field 's4'", TextView.class);
        attenceFragment.t1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv1, "field 't1'", TextView.class);
        attenceFragment.t2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv2, "field 't2'", TextView.class);
        attenceFragment.t3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv3, "field 't3'", TextView.class);
        attenceFragment.t4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv4, "field 't4'", TextView.class);
        attenceFragment.y1 = (TextView) Utils.findRequiredViewAsType(view, R.id.y1, "field 'y1'", TextView.class);
        attenceFragment.y2 = (TextView) Utils.findRequiredViewAsType(view, R.id.y2, "field 'y2'", TextView.class);
        attenceFragment.y3 = (TextView) Utils.findRequiredViewAsType(view, R.id.y3, "field 'y3'", TextView.class);
        attenceFragment.y4 = (TextView) Utils.findRequiredViewAsType(view, R.id.y4, "field 'y4'", TextView.class);
        attenceFragment.piechart = (PieChart) Utils.findRequiredViewAsType(view, R.id.piechart, "field 'piechart'", PieChart.class);
        attenceFragment.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        attenceFragment.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        attenceFragment.llItem = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_item, "field 'llItem'", LinearLayout.class);
        attenceFragment.rlItem = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_item, "field 'rlItem'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttenceFragment attenceFragment = this.target;
        if (attenceFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attenceFragment.post = null;
        attenceFragment.s1 = null;
        attenceFragment.s2 = null;
        attenceFragment.s3 = null;
        attenceFragment.s4 = null;
        attenceFragment.t1 = null;
        attenceFragment.t2 = null;
        attenceFragment.t3 = null;
        attenceFragment.t4 = null;
        attenceFragment.y1 = null;
        attenceFragment.y2 = null;
        attenceFragment.y3 = null;
        attenceFragment.y4 = null;
        attenceFragment.piechart = null;
        attenceFragment.tvName = null;
        attenceFragment.tvTime = null;
        attenceFragment.llItem = null;
        attenceFragment.rlItem = null;
    }
}
