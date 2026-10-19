package com.yd.android_brand_mvp.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.view.MyGridView;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class KBFragmentP_ViewBinding implements Unbinder {
    private KBFragmentP target;
    private View view7f0a06cc;
    private View view7f0a06d9;
    private View view7f0a06dd;

    public KBFragmentP_ViewBinding(final KBFragmentP kBFragmentP, View view) {
        this.target = kBFragmentP;
        kBFragmentP.weekRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.weekRecyclerView, "field 'weekRecyclerView'", RecyclerView.class);
        kBFragmentP.llMorningReading = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_morning_reading, "field 'llMorningReading'", LinearLayout.class);
        kBFragmentP.llForenoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_forenoon, "field 'llForenoon'", LinearLayout.class);
        kBFragmentP.llAfternoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_afternoon, "field 'llAfternoon'", LinearLayout.class);
        kBFragmentP.llNight = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night_zx, "field 'llNight'", LinearLayout.class);
        kBFragmentP.llNightWS = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night, "field 'llNightWS'", LinearLayout.class);
        kBFragmentP.llLab = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_lab, "field 'llLab'", LinearLayout.class);
        kBFragmentP.gvList1 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list1, "field 'gvList1'", MyGridView.class);
        kBFragmentP.v1 = Utils.findRequiredView(view, R.id.v1, "field 'v1'");
        kBFragmentP.gvList2 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list2, "field 'gvList2'", MyGridView.class);
        kBFragmentP.v2 = Utils.findRequiredView(view, R.id.v2, "field 'v2'");
        kBFragmentP.gvList3 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list3, "field 'gvList3'", MyGridView.class);
        kBFragmentP.v3 = Utils.findRequiredView(view, R.id.v3, "field 'v3'");
        kBFragmentP.gvList4 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list4, "field 'gvList4'", MyGridView.class);
        kBFragmentP.gvList5 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list5, "field 'gvList5'", MyGridView.class);
        kBFragmentP.llContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_content, "field 'llContent'", LinearLayout.class);
        kBFragmentP.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rb_month, "field 'rbMonth' and method 'onClick'");
        kBFragmentP.rbMonth = (Button) Utils.castView(viewFindRequiredView, R.id.rb_month, "field 'rbMonth'", Button.class);
        this.view7f0a06cc = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.KBFragmentP_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragmentP.onClick(view2);
            }
        });
        kBFragmentP.rlCheck = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_check, "field 'rlCheck'", RelativeLayout.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rb_week, "method 'onClick'");
        this.view7f0a06dd = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.KBFragmentP_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragmentP.onClick(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rb_trimester, "method 'onClick'");
        this.view7f0a06d9 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.KBFragmentP_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragmentP.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        KBFragmentP kBFragmentP = this.target;
        if (kBFragmentP == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        kBFragmentP.weekRecyclerView = null;
        kBFragmentP.llMorningReading = null;
        kBFragmentP.llForenoon = null;
        kBFragmentP.llAfternoon = null;
        kBFragmentP.llNight = null;
        kBFragmentP.llNightWS = null;
        kBFragmentP.llLab = null;
        kBFragmentP.gvList1 = null;
        kBFragmentP.v1 = null;
        kBFragmentP.gvList2 = null;
        kBFragmentP.v2 = null;
        kBFragmentP.gvList3 = null;
        kBFragmentP.v3 = null;
        kBFragmentP.gvList4 = null;
        kBFragmentP.gvList5 = null;
        kBFragmentP.llContent = null;
        kBFragmentP.mu = null;
        kBFragmentP.rbMonth = null;
        kBFragmentP.rlCheck = null;
        this.view7f0a06cc.setOnClickListener(null);
        this.view7f0a06cc = null;
        this.view7f0a06dd.setOnClickListener(null);
        this.view7f0a06dd = null;
        this.view7f0a06d9.setOnClickListener(null);
        this.view7f0a06d9 = null;
    }
}
