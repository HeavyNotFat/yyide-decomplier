package com.yd.android_brand_mvp.landscape.attence;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.PieChart;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class NewAttencesFragment4_2P_ViewBinding implements Unbinder {
    private NewAttencesFragment4_2P target;

    public NewAttencesFragment4_2P_ViewBinding(NewAttencesFragment4_2P newAttencesFragment4_2P, View view) {
        this.target = newAttencesFragment4_2P;
        newAttencesFragment4_2P.s1 = (TextView) Utils.findRequiredViewAsType(view, R.id.s1, "field 's1'", TextView.class);
        newAttencesFragment4_2P.s2 = (TextView) Utils.findRequiredViewAsType(view, R.id.s2, "field 's2'", TextView.class);
        newAttencesFragment4_2P.s3 = (TextView) Utils.findRequiredViewAsType(view, R.id.s3, "field 's3'", TextView.class);
        newAttencesFragment4_2P.s4 = (TextView) Utils.findRequiredViewAsType(view, R.id.s4, "field 's4'", TextView.class);
        newAttencesFragment4_2P.t1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv1, "field 't1'", TextView.class);
        newAttencesFragment4_2P.t2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv2, "field 't2'", TextView.class);
        newAttencesFragment4_2P.t3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv3, "field 't3'", TextView.class);
        newAttencesFragment4_2P.t4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv4, "field 't4'", TextView.class);
        newAttencesFragment4_2P.piechart = (PieChart) Utils.findRequiredViewAsType(view, R.id.piechart, "field 'piechart'", PieChart.class);
        newAttencesFragment4_2P.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        newAttencesFragment4_2P.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        newAttencesFragment4_2P.rv = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv, "field 'rv'", RecyclerView.class);
        newAttencesFragment4_2P.expandableListView = (ExpandableListView) Utils.findRequiredViewAsType(view, R.id.expandableListView, "field 'expandableListView'", ExpandableListView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NewAttencesFragment4_2P newAttencesFragment4_2P = this.target;
        if (newAttencesFragment4_2P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        newAttencesFragment4_2P.s1 = null;
        newAttencesFragment4_2P.s2 = null;
        newAttencesFragment4_2P.s3 = null;
        newAttencesFragment4_2P.s4 = null;
        newAttencesFragment4_2P.t1 = null;
        newAttencesFragment4_2P.t2 = null;
        newAttencesFragment4_2P.t3 = null;
        newAttencesFragment4_2P.t4 = null;
        newAttencesFragment4_2P.piechart = null;
        newAttencesFragment4_2P.tvName = null;
        newAttencesFragment4_2P.tvTime = null;
        newAttencesFragment4_2P.rv = null;
        newAttencesFragment4_2P.expandableListView = null;
    }
}
