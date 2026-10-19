package com.yd.android_brand_mvp.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.view.MyGridView;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class KBFragment2_ViewBinding implements Unbinder {
    private KBFragment2 target;
    private View view7f0a06cc;
    private View view7f0a06d9;
    private View view7f0a06dd;

    public KBFragment2_ViewBinding(final KBFragment2 kBFragment2, View view) {
        this.target = kBFragment2;
        kBFragment2.tvSaturday = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_saturday, "field 'tvSaturday'", TextView.class);
        kBFragment2.tvSunday = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sunday, "field 'tvSunday'", TextView.class);
        kBFragment2.week = (TextView) Utils.findRequiredViewAsType(view, R.id.week, "field 'week'", TextView.class);
        kBFragment2.tvKb = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_kb, "field 'tvKb'", TextView.class);
        kBFragment2.llMorningReading = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_morning_reading, "field 'llMorningReading'", LinearLayout.class);
        kBFragment2.llForenoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_forenoon, "field 'llForenoon'", LinearLayout.class);
        kBFragment2.llAfternoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_afternoon, "field 'llAfternoon'", LinearLayout.class);
        kBFragment2.ll_nightZx = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night, "field 'll_nightZx'", LinearLayout.class);
        kBFragment2.llNight = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_nightZx, "field 'llNight'", LinearLayout.class);
        kBFragment2.llLab = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_lab, "field 'llLab'", LinearLayout.class);
        kBFragment2.gvList1 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list1, "field 'gvList1'", MyGridView.class);
        kBFragment2.v1 = Utils.findRequiredView(view, R.id.v1, "field 'v1'");
        kBFragment2.gvList2 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list2, "field 'gvList2'", MyGridView.class);
        kBFragment2.v2 = Utils.findRequiredView(view, R.id.v2, "field 'v2'");
        kBFragment2.gvList3 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list3, "field 'gvList3'", MyGridView.class);
        kBFragment2.v3 = Utils.findRequiredView(view, R.id.v3, "field 'v3'");
        kBFragment2.gvList4 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list4, "field 'gvList4'", MyGridView.class);
        kBFragment2.gvList5 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list5, "field 'gvList5'", MyGridView.class);
        kBFragment2.llContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_content, "field 'llContent'", LinearLayout.class);
        kBFragment2.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rb_month, "field 'rbMonth' and method 'onClick'");
        kBFragment2.rbMonth = (Button) Utils.castView(viewFindRequiredView, R.id.rb_month, "field 'rbMonth'", Button.class);
        this.view7f0a06cc = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.KBFragment2_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment2.onClick(view2);
            }
        });
        kBFragment2.rlCheck = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_check, "field 'rlCheck'", RelativeLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rb_week, "method 'onClick'");
        this.view7f0a06dd = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.KBFragment2_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment2.onClick(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rb_trimester, "method 'onClick'");
        this.view7f0a06d9 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.KBFragment2_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment2.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        KBFragment2 kBFragment2 = this.target;
        if (kBFragment2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        kBFragment2.tvSaturday = null;
        kBFragment2.tvSunday = null;
        kBFragment2.week = null;
        kBFragment2.tvKb = null;
        kBFragment2.llMorningReading = null;
        kBFragment2.llForenoon = null;
        kBFragment2.llAfternoon = null;
        kBFragment2.ll_nightZx = null;
        kBFragment2.llNight = null;
        kBFragment2.llLab = null;
        kBFragment2.gvList1 = null;
        kBFragment2.v1 = null;
        kBFragment2.gvList2 = null;
        kBFragment2.v2 = null;
        kBFragment2.gvList3 = null;
        kBFragment2.v3 = null;
        kBFragment2.gvList4 = null;
        kBFragment2.gvList5 = null;
        kBFragment2.llContent = null;
        kBFragment2.mu = null;
        kBFragment2.rbMonth = null;
        kBFragment2.rlCheck = null;
        this.view7f0a06cc.setOnClickListener(null);
        this.view7f0a06cc = null;
        this.view7f0a06dd.setOnClickListener(null);
        this.view7f0a06dd = null;
        this.view7f0a06d9.setOnClickListener(null);
        this.view7f0a06d9 = null;
    }
}
