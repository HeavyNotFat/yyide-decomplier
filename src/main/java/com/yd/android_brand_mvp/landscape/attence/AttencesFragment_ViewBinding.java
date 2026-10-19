package com.yd.android_brand_mvp.landscape.attence;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.PieChart;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class AttencesFragment_ViewBinding implements Unbinder {
    private AttencesFragment target;

    public AttencesFragment_ViewBinding(AttencesFragment attencesFragment, View view) {
        this.target = attencesFragment;
        attencesFragment.post = (TextView) Utils.findRequiredViewAsType(view, R.id.post, "field 'post'", TextView.class);
        attencesFragment.s1 = (TextView) Utils.findRequiredViewAsType(view, R.id.s1, "field 's1'", TextView.class);
        attencesFragment.s2 = (TextView) Utils.findRequiredViewAsType(view, R.id.s2, "field 's2'", TextView.class);
        attencesFragment.s3 = (TextView) Utils.findRequiredViewAsType(view, R.id.s3, "field 's3'", TextView.class);
        attencesFragment.s4 = (TextView) Utils.findRequiredViewAsType(view, R.id.s4, "field 's4'", TextView.class);
        attencesFragment.t1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv1, "field 't1'", TextView.class);
        attencesFragment.t2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv2, "field 't2'", TextView.class);
        attencesFragment.t3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv3, "field 't3'", TextView.class);
        attencesFragment.t4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv4, "field 't4'", TextView.class);
        attencesFragment.y1 = (TextView) Utils.findRequiredViewAsType(view, R.id.y1, "field 'y1'", TextView.class);
        attencesFragment.y2 = (TextView) Utils.findRequiredViewAsType(view, R.id.y2, "field 'y2'", TextView.class);
        attencesFragment.y3 = (TextView) Utils.findRequiredViewAsType(view, R.id.y3, "field 'y3'", TextView.class);
        attencesFragment.y4 = (TextView) Utils.findRequiredViewAsType(view, R.id.y4, "field 'y4'", TextView.class);
        attencesFragment.piechart = (PieChart) Utils.findRequiredViewAsType(view, R.id.piechart, "field 'piechart'", PieChart.class);
        attencesFragment.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        attencesFragment.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        attencesFragment.llItem = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_item, "field 'llItem'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttencesFragment attencesFragment = this.target;
        if (attencesFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attencesFragment.post = null;
        attencesFragment.s1 = null;
        attencesFragment.s2 = null;
        attencesFragment.s3 = null;
        attencesFragment.s4 = null;
        attencesFragment.t1 = null;
        attencesFragment.t2 = null;
        attencesFragment.t3 = null;
        attencesFragment.t4 = null;
        attencesFragment.y1 = null;
        attencesFragment.y2 = null;
        attencesFragment.y3 = null;
        attencesFragment.y4 = null;
        attencesFragment.piechart = null;
        attencesFragment.tvName = null;
        attencesFragment.tvTime = null;
        attencesFragment.llItem = null;
    }
}
