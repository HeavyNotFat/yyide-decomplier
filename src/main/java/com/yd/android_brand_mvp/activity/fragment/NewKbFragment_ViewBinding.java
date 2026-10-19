package com.yd.android_brand_mvp.activity.fragment;

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
public class NewKbFragment_ViewBinding implements Unbinder {
    private NewKbFragment target;
    private View view7f0a06cc;
    private View view7f0a06d9;
    private View view7f0a06dd;

    public NewKbFragment_ViewBinding(final NewKbFragment newKbFragment, View view) {
        this.target = newKbFragment;
        newKbFragment.llMorningReading = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_morning_reading, "field 'llMorningReading'", LinearLayout.class);
        newKbFragment.llForenoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_forenoon, "field 'llForenoon'", LinearLayout.class);
        newKbFragment.llAfternoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_afternoon, "field 'llAfternoon'", LinearLayout.class);
        newKbFragment.llNight = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night, "field 'llNight'", LinearLayout.class);
        newKbFragment.llNightZx = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night_zx, "field 'llNightZx'", LinearLayout.class);
        newKbFragment.llLab = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_lab, "field 'llLab'", LinearLayout.class);
        newKbFragment.gvList1 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list1, "field 'gvList1'", MyGridView.class);
        newKbFragment.v1 = Utils.findRequiredView(view, R.id.v1, "field 'v1'");
        newKbFragment.gvList2 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list2, "field 'gvList2'", MyGridView.class);
        newKbFragment.v2 = Utils.findRequiredView(view, R.id.v2, "field 'v2'");
        newKbFragment.gvList3 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list3, "field 'gvList3'", MyGridView.class);
        newKbFragment.weekRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.weekRecyclerView, "field 'weekRecyclerView'", RecyclerView.class);
        newKbFragment.v4 = Utils.findRequiredView(view, R.id.v4, "field 'v4'");
        newKbFragment.gvList4 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list4, "field 'gvList4'", MyGridView.class);
        newKbFragment.gvList5 = (MyGridView) Utils.findRequiredViewAsType(view, R.id.gv_list5, "field 'gvList5'", MyGridView.class);
        newKbFragment.llContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_content, "field 'llContent'", LinearLayout.class);
        newKbFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rb_month, "field 'rbMonth' and method 'onClick'");
        newKbFragment.rbMonth = (Button) Utils.castView(viewFindRequiredView, R.id.rb_month, "field 'rbMonth'", Button.class);
        this.view7f0a06cc = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.NewKbFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                newKbFragment.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rb_week, "field 'rbWeek' and method 'onClick'");
        newKbFragment.rbWeek = (Button) Utils.castView(viewFindRequiredView2, R.id.rb_week, "field 'rbWeek'", Button.class);
        this.view7f0a06dd = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.NewKbFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                newKbFragment.onClick(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rb_trimester, "field 'rbTrimester' and method 'onClick'");
        newKbFragment.rbTrimester = (Button) Utils.castView(viewFindRequiredView3, R.id.rb_trimester, "field 'rbTrimester'", Button.class);
        this.view7f0a06d9 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.NewKbFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                newKbFragment.onClick(view2);
            }
        });
        newKbFragment.rlCheck = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_check, "field 'rlCheck'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NewKbFragment newKbFragment = this.target;
        if (newKbFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        newKbFragment.llMorningReading = null;
        newKbFragment.llForenoon = null;
        newKbFragment.llAfternoon = null;
        newKbFragment.llNight = null;
        newKbFragment.llNightZx = null;
        newKbFragment.llLab = null;
        newKbFragment.gvList1 = null;
        newKbFragment.v1 = null;
        newKbFragment.gvList2 = null;
        newKbFragment.v2 = null;
        newKbFragment.gvList3 = null;
        newKbFragment.weekRecyclerView = null;
        newKbFragment.v4 = null;
        newKbFragment.gvList4 = null;
        newKbFragment.gvList5 = null;
        newKbFragment.llContent = null;
        newKbFragment.mu = null;
        newKbFragment.rbMonth = null;
        newKbFragment.rbWeek = null;
        newKbFragment.rbTrimester = null;
        newKbFragment.rlCheck = null;
        this.view7f0a06cc.setOnClickListener(null);
        this.view7f0a06cc = null;
        this.view7f0a06dd.setOnClickListener(null);
        this.view7f0a06dd = null;
        this.view7f0a06d9.setOnClickListener(null);
        this.view7f0a06d9 = null;
    }
}
