package com.yd.android_brand_mvp.landscape.attence;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.PieChart;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class NewAttencesFragment_ViewBinding implements Unbinder {
    private NewAttencesFragment target;

    public NewAttencesFragment_ViewBinding(NewAttencesFragment newAttencesFragment, View view) {
        this.target = newAttencesFragment;
        newAttencesFragment.post = (TextView) Utils.findRequiredViewAsType(view, R.id.post, "field 'post'", TextView.class);
        newAttencesFragment.s1 = (TextView) Utils.findRequiredViewAsType(view, R.id.s1, "field 's1'", TextView.class);
        newAttencesFragment.s2 = (TextView) Utils.findRequiredViewAsType(view, R.id.s2, "field 's2'", TextView.class);
        newAttencesFragment.s3 = (TextView) Utils.findRequiredViewAsType(view, R.id.s3, "field 's3'", TextView.class);
        newAttencesFragment.s4 = (TextView) Utils.findRequiredViewAsType(view, R.id.s4, "field 's4'", TextView.class);
        newAttencesFragment.t1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv1, "field 't1'", TextView.class);
        newAttencesFragment.t2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv2, "field 't2'", TextView.class);
        newAttencesFragment.t3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv3, "field 't3'", TextView.class);
        newAttencesFragment.t4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv4, "field 't4'", TextView.class);
        newAttencesFragment.y1 = (TextView) Utils.findRequiredViewAsType(view, R.id.y1, "field 'y1'", TextView.class);
        newAttencesFragment.y2 = (TextView) Utils.findRequiredViewAsType(view, R.id.y2, "field 'y2'", TextView.class);
        newAttencesFragment.y3 = (TextView) Utils.findRequiredViewAsType(view, R.id.y3, "field 'y3'", TextView.class);
        newAttencesFragment.y4 = (TextView) Utils.findRequiredViewAsType(view, R.id.y4, "field 'y4'", TextView.class);
        newAttencesFragment.piechart = (PieChart) Utils.findRequiredViewAsType(view, R.id.piechart, "field 'piechart'", PieChart.class);
        newAttencesFragment.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        newAttencesFragment.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        newAttencesFragment.llItem = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_item, "field 'llItem'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NewAttencesFragment newAttencesFragment = this.target;
        if (newAttencesFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        newAttencesFragment.post = null;
        newAttencesFragment.s1 = null;
        newAttencesFragment.s2 = null;
        newAttencesFragment.s3 = null;
        newAttencesFragment.s4 = null;
        newAttencesFragment.t1 = null;
        newAttencesFragment.t2 = null;
        newAttencesFragment.t3 = null;
        newAttencesFragment.t4 = null;
        newAttencesFragment.y1 = null;
        newAttencesFragment.y2 = null;
        newAttencesFragment.y3 = null;
        newAttencesFragment.y4 = null;
        newAttencesFragment.piechart = null;
        newAttencesFragment.tvName = null;
        newAttencesFragment.tvTime = null;
        newAttencesFragment.llItem = null;
    }
}
