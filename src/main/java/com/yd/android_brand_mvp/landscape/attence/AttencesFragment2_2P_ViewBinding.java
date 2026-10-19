package com.yd.android_brand_mvp.landscape.attence;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.PieChart;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class AttencesFragment2_2P_ViewBinding implements Unbinder {
    private AttencesFragment2_2P target;

    public AttencesFragment2_2P_ViewBinding(AttencesFragment2_2P attencesFragment2_2P, View view) {
        this.target = attencesFragment2_2P;
        attencesFragment2_2P.s1 = (TextView) Utils.findRequiredViewAsType(view, R.id.s1, "field 's1'", TextView.class);
        attencesFragment2_2P.s2 = (TextView) Utils.findRequiredViewAsType(view, R.id.s2, "field 's2'", TextView.class);
        attencesFragment2_2P.s3 = (TextView) Utils.findRequiredViewAsType(view, R.id.s3, "field 's3'", TextView.class);
        attencesFragment2_2P.s4 = (TextView) Utils.findRequiredViewAsType(view, R.id.s4, "field 's4'", TextView.class);
        attencesFragment2_2P.t1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv1, "field 't1'", TextView.class);
        attencesFragment2_2P.t2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv2, "field 't2'", TextView.class);
        attencesFragment2_2P.t3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv3, "field 't3'", TextView.class);
        attencesFragment2_2P.t4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv4, "field 't4'", TextView.class);
        attencesFragment2_2P.piechart = (PieChart) Utils.findRequiredViewAsType(view, R.id.piechart, "field 'piechart'", PieChart.class);
        attencesFragment2_2P.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        attencesFragment2_2P.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttencesFragment2_2P attencesFragment2_2P = this.target;
        if (attencesFragment2_2P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attencesFragment2_2P.s1 = null;
        attencesFragment2_2P.s2 = null;
        attencesFragment2_2P.s3 = null;
        attencesFragment2_2P.s4 = null;
        attencesFragment2_2P.t1 = null;
        attencesFragment2_2P.t2 = null;
        attencesFragment2_2P.t3 = null;
        attencesFragment2_2P.t4 = null;
        attencesFragment2_2P.piechart = null;
        attencesFragment2_2P.tvName = null;
        attencesFragment2_2P.tvTime = null;
    }
}
