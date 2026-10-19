package com.yd.android_brand_mvp.landscape.attence;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.mikephil.charting.charts.PieChart;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class NewAttencesCartoonFragment_ViewBinding implements Unbinder {
    private NewAttencesCartoonFragment target;

    public NewAttencesCartoonFragment_ViewBinding(NewAttencesCartoonFragment newAttencesCartoonFragment, View view) {
        this.target = newAttencesCartoonFragment;
        newAttencesCartoonFragment.post = (TextView) Utils.findRequiredViewAsType(view, R.id.post, "field 'post'", TextView.class);
        newAttencesCartoonFragment.s1 = (TextView) Utils.findRequiredViewAsType(view, R.id.s1, "field 's1'", TextView.class);
        newAttencesCartoonFragment.s2 = (TextView) Utils.findRequiredViewAsType(view, R.id.s2, "field 's2'", TextView.class);
        newAttencesCartoonFragment.s3 = (TextView) Utils.findRequiredViewAsType(view, R.id.s3, "field 's3'", TextView.class);
        newAttencesCartoonFragment.s4 = (TextView) Utils.findRequiredViewAsType(view, R.id.s4, "field 's4'", TextView.class);
        newAttencesCartoonFragment.t1 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv1, "field 't1'", TextView.class);
        newAttencesCartoonFragment.t2 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv2, "field 't2'", TextView.class);
        newAttencesCartoonFragment.t3 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv3, "field 't3'", TextView.class);
        newAttencesCartoonFragment.t4 = (TextView) Utils.findRequiredViewAsType(view, R.id.tv4, "field 't4'", TextView.class);
        newAttencesCartoonFragment.y1 = (TextView) Utils.findRequiredViewAsType(view, R.id.y1, "field 'y1'", TextView.class);
        newAttencesCartoonFragment.y2 = (TextView) Utils.findRequiredViewAsType(view, R.id.y2, "field 'y2'", TextView.class);
        newAttencesCartoonFragment.y3 = (TextView) Utils.findRequiredViewAsType(view, R.id.y3, "field 'y3'", TextView.class);
        newAttencesCartoonFragment.y4 = (TextView) Utils.findRequiredViewAsType(view, R.id.y4, "field 'y4'", TextView.class);
        newAttencesCartoonFragment.piechart = (PieChart) Utils.findRequiredViewAsType(view, R.id.piechart, "field 'piechart'", PieChart.class);
        newAttencesCartoonFragment.tvName = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_name, "field 'tvName'", TextView.class);
        newAttencesCartoonFragment.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        newAttencesCartoonFragment.llItem = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_item, "field 'llItem'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NewAttencesCartoonFragment newAttencesCartoonFragment = this.target;
        if (newAttencesCartoonFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        newAttencesCartoonFragment.post = null;
        newAttencesCartoonFragment.s1 = null;
        newAttencesCartoonFragment.s2 = null;
        newAttencesCartoonFragment.s3 = null;
        newAttencesCartoonFragment.s4 = null;
        newAttencesCartoonFragment.t1 = null;
        newAttencesCartoonFragment.t2 = null;
        newAttencesCartoonFragment.t3 = null;
        newAttencesCartoonFragment.t4 = null;
        newAttencesCartoonFragment.y1 = null;
        newAttencesCartoonFragment.y2 = null;
        newAttencesCartoonFragment.y3 = null;
        newAttencesCartoonFragment.y4 = null;
        newAttencesCartoonFragment.piechart = null;
        newAttencesCartoonFragment.tvName = null;
        newAttencesCartoonFragment.tvTime = null;
        newAttencesCartoonFragment.llItem = null;
    }
}
