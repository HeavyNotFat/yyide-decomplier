package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.PieChart;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceFragment2_2P_ViewBinding implements Unbinder {
    private AttenceFragment2_2P target;

    public AttenceFragment2_2P_ViewBinding(AttenceFragment2_2P attenceFragment2_2P, View view) {
        this.target = attenceFragment2_2P;
        attenceFragment2_2P.s1 = (TextView) Utils.findRequiredViewAsType(view, R.id.s1, "field 's1'", TextView.class);
        attenceFragment2_2P.s2 = (TextView) Utils.findRequiredViewAsType(view, R.id.s2, "field 's2'", TextView.class);
        attenceFragment2_2P.s3 = (TextView) Utils.findRequiredViewAsType(view, R.id.s3, "field 's3'", TextView.class);
        attenceFragment2_2P.s4 = (TextView) Utils.findRequiredViewAsType(view, R.id.s4, "field 's4'", TextView.class);
        attenceFragment2_2P.t1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv1, "field 't1'", TextView.class);
        attenceFragment2_2P.t2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv2, "field 't2'", TextView.class);
        attenceFragment2_2P.t3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv3, "field 't3'", TextView.class);
        attenceFragment2_2P.t4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv4, "field 't4'", TextView.class);
        attenceFragment2_2P.piechart = (PieChart) Utils.findRequiredViewAsType(view, R.id.piechart, "field 'piechart'", PieChart.class);
        attenceFragment2_2P.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        attenceFragment2_2P.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttenceFragment2_2P attenceFragment2_2P = this.target;
        if (attenceFragment2_2P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attenceFragment2_2P.s1 = null;
        attenceFragment2_2P.s2 = null;
        attenceFragment2_2P.s3 = null;
        attenceFragment2_2P.s4 = null;
        attenceFragment2_2P.t1 = null;
        attenceFragment2_2P.t2 = null;
        attenceFragment2_2P.t3 = null;
        attenceFragment2_2P.t4 = null;
        attenceFragment2_2P.piechart = null;
        attenceFragment2_2P.tvName = null;
        attenceFragment2_2P.tvTime = null;
    }
}
