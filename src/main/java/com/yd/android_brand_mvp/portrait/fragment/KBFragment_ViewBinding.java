package com.yd.android_brand_mvp.portrait.fragment;

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
public class KBFragment_ViewBinding implements Unbinder {
    private KBFragment target;
    private View view7f0a06cc;
    private View view7f0a06d9;
    private View view7f0a06dd;

    public KBFragment_ViewBinding(final KBFragment kBFragment, View view) {
        this.target = kBFragment;
        kBFragment.llMorningReading = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_morning_reading, "field 'llMorningReading'", LinearLayout.class);
        kBFragment.llForenoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_forenoon, "field 'llForenoon'", LinearLayout.class);
        kBFragment.llAfternoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_afternoon, "field 'llAfternoon'", LinearLayout.class);
        kBFragment.llNight = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night, "field 'llNight'", LinearLayout.class);
        kBFragment.llNightZx = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night_zx, "field 'llNightZx'", LinearLayout.class);
        kBFragment.llLab = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_lab, "field 'llLab'", LinearLayout.class);
        kBFragment.gvList1 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list1, "field 'gvList1'", MyGridView.class);
        kBFragment.v1 = Utils.findRequiredView(view, R.id.v1, "field 'v1'");
        kBFragment.gvList2 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list2, "field 'gvList2'", MyGridView.class);
        kBFragment.v2 = Utils.findRequiredView(view, R.id.v2, "field 'v2'");
        kBFragment.v3 = Utils.findRequiredView(view, R.id.v3, "field 'v3'");
        kBFragment.gvList3 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list3, "field 'gvList3'", MyGridView.class);
        kBFragment.weekRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.weekRecyclerView, "field 'weekRecyclerView'", RecyclerView.class);
        kBFragment.gvList4 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list4, "field 'gvList4'", MyGridView.class);
        kBFragment.gvList5 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list5, "field 'gvList5'", MyGridView.class);
        kBFragment.llContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_content, "field 'llContent'", LinearLayout.class);
        kBFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rb_month, "field 'rbMonth' and method 'onClick'");
        kBFragment.rbMonth = (Button) Utils.castView(viewFindRequiredView, R.id.rb_month, "field 'rbMonth'", Button.class);
        this.view7f0a06cc = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rb_week, "field 'rbWeek' and method 'onClick'");
        kBFragment.rbWeek = (Button) Utils.castView(viewFindRequiredView2, R.id.rb_week, "field 'rbWeek'", Button.class);
        this.view7f0a06dd = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment.onClick(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rb_trimester, "field 'rbTrimester' and method 'onClick'");
        kBFragment.rbTrimester = (Button) Utils.castView(viewFindRequiredView3, R.id.rb_trimester, "field 'rbTrimester'", Button.class);
        this.view7f0a06d9 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment.onClick(view2);
            }
        });
        kBFragment.rlCheck = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_check, "field 'rlCheck'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        KBFragment kBFragment = this.target;
        if (kBFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        kBFragment.llMorningReading = null;
        kBFragment.llForenoon = null;
        kBFragment.llAfternoon = null;
        kBFragment.llNight = null;
        kBFragment.llNightZx = null;
        kBFragment.llLab = null;
        kBFragment.gvList1 = null;
        kBFragment.v1 = null;
        kBFragment.gvList2 = null;
        kBFragment.v2 = null;
        kBFragment.v3 = null;
        kBFragment.gvList3 = null;
        kBFragment.weekRecyclerView = null;
        kBFragment.gvList4 = null;
        kBFragment.gvList5 = null;
        kBFragment.llContent = null;
        kBFragment.mu = null;
        kBFragment.rbMonth = null;
        kBFragment.rbWeek = null;
        kBFragment.rbTrimester = null;
        kBFragment.rlCheck = null;
        this.view7f0a06cc.setOnClickListener(null);
        this.view7f0a06cc = null;
        this.view7f0a06dd.setOnClickListener(null);
        this.view7f0a06dd = null;
        this.view7f0a06d9.setOnClickListener(null);
        this.view7f0a06d9 = null;
    }
}
