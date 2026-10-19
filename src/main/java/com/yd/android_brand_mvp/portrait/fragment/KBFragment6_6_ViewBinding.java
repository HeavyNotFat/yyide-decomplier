package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.utils.view.MyGridView;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class KBFragment6_6_ViewBinding implements Unbinder {
    private KBFragment6_6 target;
    private View view7f0a06cc;
    private View view7f0a06d9;
    private View view7f0a06dd;
    private View view7f0a0863;

    public KBFragment6_6_ViewBinding(final KBFragment6_6 kBFragment6_6, View view) {
        this.target = kBFragment6_6;
        kBFragment6_6.llMorningReading = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_morning_reading, "field 'llMorningReading'", LinearLayout.class);
        kBFragment6_6.llForenoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_forenoon, "field 'llForenoon'", LinearLayout.class);
        kBFragment6_6.llAfternoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_afternoon, "field 'llAfternoon'", LinearLayout.class);
        kBFragment6_6.llNight = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night, "field 'llNight'", LinearLayout.class);
        kBFragment6_6.llNightZx = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night_zx, "field 'llNightZx'", LinearLayout.class);
        kBFragment6_6.llLab = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_lab, "field 'llLab'", LinearLayout.class);
        kBFragment6_6.gvList1 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list1, "field 'gvList1'", MyGridView.class);
        kBFragment6_6.v1 = Utils.findRequiredView(view, R.id.v1, "field 'v1'");
        kBFragment6_6.gvList2 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list2, "field 'gvList2'", MyGridView.class);
        kBFragment6_6.v2 = Utils.findRequiredView(view, R.id.v2, "field 'v2'");
        kBFragment6_6.gvList3 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list3, "field 'gvList3'", MyGridView.class);
        kBFragment6_6.weekRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.weekRecyclerView, "field 'weekRecyclerView'", RecyclerView.class);
        kBFragment6_6.gvList4 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list4, "field 'gvList4'", MyGridView.class);
        kBFragment6_6.gvList5 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list5, "field 'gvList5'", MyGridView.class);
        kBFragment6_6.llContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_content, "field 'llContent'", LinearLayout.class);
        kBFragment6_6.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rb_month, "field 'rbMonth' and method 'onClick'");
        kBFragment6_6.rbMonth = (Button) Utils.castView(viewFindRequiredView, R.id.rb_month, "field 'rbMonth'", Button.class);
        this.view7f0a06cc = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment6_6.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rb_week, "field 'rbWeek' and method 'onClick'");
        kBFragment6_6.rbWeek = (Button) Utils.castView(viewFindRequiredView2, R.id.rb_week, "field 'rbWeek'", Button.class);
        this.view7f0a06dd = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment6_6.onClick(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rb_trimester, "field 'rbTrimester' and method 'onClick'");
        kBFragment6_6.rbTrimester = (Button) Utils.castView(viewFindRequiredView3, R.id.rb_trimester, "field 'rbTrimester'", Button.class);
        this.view7f0a06d9 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment6_6.onClick(view2);
            }
        });
        kBFragment6_6.rlCheck = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_check, "field 'rlCheck'", RelativeLayout.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.title, "field 'tvTitle' and method 'onViewClicked'");
        kBFragment6_6.tvTitle = (TextView) Utils.castView(viewFindRequiredView4, R.id.title, "field 'tvTitle'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment6_6.onViewClicked(view2);
            }
        });
        kBFragment6_6.tvWeek = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_week, "field 'tvWeek'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        KBFragment6_6 kBFragment6_6 = this.target;
        if (kBFragment6_6 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        kBFragment6_6.llMorningReading = null;
        kBFragment6_6.llForenoon = null;
        kBFragment6_6.llAfternoon = null;
        kBFragment6_6.llNight = null;
        kBFragment6_6.llNightZx = null;
        kBFragment6_6.llLab = null;
        kBFragment6_6.gvList1 = null;
        kBFragment6_6.v1 = null;
        kBFragment6_6.gvList2 = null;
        kBFragment6_6.v2 = null;
        kBFragment6_6.gvList3 = null;
        kBFragment6_6.weekRecyclerView = null;
        kBFragment6_6.gvList4 = null;
        kBFragment6_6.gvList5 = null;
        kBFragment6_6.llContent = null;
        kBFragment6_6.mu = null;
        kBFragment6_6.rbMonth = null;
        kBFragment6_6.rbWeek = null;
        kBFragment6_6.rbTrimester = null;
        kBFragment6_6.rlCheck = null;
        kBFragment6_6.tvTitle = null;
        kBFragment6_6.tvWeek = null;
        this.view7f0a06cc.setOnClickListener(null);
        this.view7f0a06cc = null;
        this.view7f0a06dd.setOnClickListener(null);
        this.view7f0a06dd = null;
        this.view7f0a06d9.setOnClickListener(null);
        this.view7f0a06d9 = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
    }
}
