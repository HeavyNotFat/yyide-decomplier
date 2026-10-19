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
public class KBFragment6_6p2_ViewBinding implements Unbinder {
    private KBFragment6_6p2 target;
    private View view7f0a06cc;
    private View view7f0a06d9;
    private View view7f0a06dd;
    private View view7f0a0863;

    public KBFragment6_6p2_ViewBinding(final KBFragment6_6p2 kBFragment6_6p2, View view) {
        this.target = kBFragment6_6p2;
        kBFragment6_6p2.llMorningReading = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_morning_reading, "field 'llMorningReading'", LinearLayout.class);
        kBFragment6_6p2.llForenoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_forenoon, "field 'llForenoon'", LinearLayout.class);
        kBFragment6_6p2.llAfternoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_afternoon, "field 'llAfternoon'", LinearLayout.class);
        kBFragment6_6p2.llNight = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night, "field 'llNight'", LinearLayout.class);
        kBFragment6_6p2.llNightWS = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night_ws, "field 'llNightWS'", LinearLayout.class);
        kBFragment6_6p2.llLab = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_lab, "field 'llLab'", LinearLayout.class);
        kBFragment6_6p2.gvList1 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list1, "field 'gvList1'", MyGridView.class);
        kBFragment6_6p2.gvList2 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list2, "field 'gvList2'", MyGridView.class);
        kBFragment6_6p2.gvList3 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list3, "field 'gvList3'", MyGridView.class);
        kBFragment6_6p2.gvList4 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list4, "field 'gvList4'", MyGridView.class);
        kBFragment6_6p2.gvList5 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list5, "field 'gvList5'", MyGridView.class);
        kBFragment6_6p2.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rb_month, "field 'rbMonth' and method 'onClick'");
        kBFragment6_6p2.rbMonth = (Button) Utils.castView(viewFindRequiredView, R.id.rb_month, "field 'rbMonth'", Button.class);
        this.view7f0a06cc = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6p2_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment6_6p2.onClick(view2);
            }
        });
        kBFragment6_6p2.weekRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.weekRecyclerView, "field 'weekRecyclerView'", RecyclerView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rb_week, "field 'rbWeek' and method 'onClick'");
        kBFragment6_6p2.rbWeek = (Button) Utils.castView(viewFindRequiredView2, R.id.rb_week, "field 'rbWeek'", Button.class);
        this.view7f0a06dd = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6p2_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment6_6p2.onClick(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rb_trimester, "field 'rbTrimester' and method 'onClick'");
        kBFragment6_6p2.rbTrimester = (Button) Utils.castView(viewFindRequiredView3, R.id.rb_trimester, "field 'rbTrimester'", Button.class);
        this.view7f0a06d9 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6p2_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment6_6p2.onClick(view2);
            }
        });
        kBFragment6_6p2.rlCheck = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_check, "field 'rlCheck'", RelativeLayout.class);
        View viewFindRequiredView4 = Utils.findRequiredView(view, R.id.title, "field 'tvTitle' and method 'onClick'");
        kBFragment6_6p2.tvTitle = (TextView) Utils.castView(viewFindRequiredView4, R.id.title, "field 'tvTitle'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView4;
        viewFindRequiredView4.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.KBFragment6_6p2_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment6_6p2.onClick(view2);
            }
        });
        kBFragment6_6p2.tvWeek = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_week, "field 'tvWeek'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        KBFragment6_6p2 kBFragment6_6p2 = this.target;
        if (kBFragment6_6p2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        kBFragment6_6p2.llMorningReading = null;
        kBFragment6_6p2.llForenoon = null;
        kBFragment6_6p2.llAfternoon = null;
        kBFragment6_6p2.llNight = null;
        kBFragment6_6p2.llNightWS = null;
        kBFragment6_6p2.llLab = null;
        kBFragment6_6p2.gvList1 = null;
        kBFragment6_6p2.gvList2 = null;
        kBFragment6_6p2.gvList3 = null;
        kBFragment6_6p2.gvList4 = null;
        kBFragment6_6p2.gvList5 = null;
        kBFragment6_6p2.mu = null;
        kBFragment6_6p2.rbMonth = null;
        kBFragment6_6p2.weekRecyclerView = null;
        kBFragment6_6p2.rbWeek = null;
        kBFragment6_6p2.rbTrimester = null;
        kBFragment6_6p2.rlCheck = null;
        kBFragment6_6p2.tvTitle = null;
        kBFragment6_6p2.tvWeek = null;
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
