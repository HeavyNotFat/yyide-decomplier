package com.yd.android_brand_mvp.activity.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleFragment_ViewBinding implements Unbinder {
    private ClassScheduleFragment target;
    private View view7f0a06cc;
    private View view7f0a06d9;
    private View view7f0a06dd;

    public ClassScheduleFragment_ViewBinding(final ClassScheduleFragment classScheduleFragment, View view) {
        this.target = classScheduleFragment;
        classScheduleFragment.gvList1 = (GridView) Utils.findRequiredViewAsType(view, R.id.gv_list1, "field 'gvList1'", GridView.class);
        classScheduleFragment.gvList2 = (GridView) Utils.findRequiredViewAsType(view, R.id.gv_list2, "field 'gvList2'", GridView.class);
        classScheduleFragment.gvList3 = (GridView) Utils.findRequiredViewAsType(view, R.id.gv_list3, "field 'gvList3'", GridView.class);
        classScheduleFragment.gvList4 = (GridView) Utils.findRequiredViewAsType(view, R.id.gv_list4, "field 'gvList4'", GridView.class);
        classScheduleFragment.v1 = Utils.findRequiredView(view, R.id.v1, "field 'v1'");
        classScheduleFragment.v2 = Utils.findRequiredView(view, R.id.v2, "field 'v2'");
        classScheduleFragment.v3 = Utils.findRequiredView(view, R.id.v3, "field 'v3'");
        classScheduleFragment.llMorningReading = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_morning_reading, "field 'llMorningReading'", LinearLayout.class);
        classScheduleFragment.llForenoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_forenoon, "field 'llForenoon'", LinearLayout.class);
        classScheduleFragment.llAfternoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_afternoon, "field 'llAfternoon'", LinearLayout.class);
        classScheduleFragment.llNight = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night, "field 'llNight'", LinearLayout.class);
        classScheduleFragment.llLab = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_lab, "field 'llLab'", LinearLayout.class);
        classScheduleFragment.llContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_content, "field 'llContent'", LinearLayout.class);
        classScheduleFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        classScheduleFragment.rgCheck = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.rg_check, "field 'rgCheck'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rb_week, "field 'rbWeek' and method 'onClick'");
        classScheduleFragment.rbWeek = (Button) Utils.castView(viewFindRequiredView, R.id.rb_week, "field 'rbWeek'", Button.class);
        this.view7f0a06dd = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.ClassScheduleFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleFragment.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rb_month, "field 'rbMonth' and method 'onClick'");
        classScheduleFragment.rbMonth = (Button) Utils.castView(viewFindRequiredView2, R.id.rb_month, "field 'rbMonth'", Button.class);
        this.view7f0a06cc = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.ClassScheduleFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleFragment.onClick(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rb_trimester, "field 'rbTrimester' and method 'onClick'");
        classScheduleFragment.rbTrimester = (Button) Utils.castView(viewFindRequiredView3, R.id.rb_trimester, "field 'rbTrimester'", Button.class);
        this.view7f0a06d9 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.fragment.ClassScheduleFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleFragment.onClick(view2);
            }
        });
        classScheduleFragment.rl_check = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_check, "field 'rl_check'", RelativeLayout.class);
        classScheduleFragment.rl_rb = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_rb, "field 'rl_rb'", RelativeLayout.class);
        classScheduleFragment.rb_d_week = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_d_week, "field 'rb_d_week'", RadioButton.class);
        classScheduleFragment.rb_s_week = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_s_week, "field 'rb_s_week'", RadioButton.class);
        classScheduleFragment.rg_d_check = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.rg_d_check, "field 'rg_d_check'", RadioGroup.class);
        classScheduleFragment.tv_saturday = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_saturday, "field 'tv_saturday'", TextView.class);
        classScheduleFragment.tv_sunday = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sunday, "field 'tv_sunday'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassScheduleFragment classScheduleFragment = this.target;
        if (classScheduleFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classScheduleFragment.gvList1 = null;
        classScheduleFragment.gvList2 = null;
        classScheduleFragment.gvList3 = null;
        classScheduleFragment.gvList4 = null;
        classScheduleFragment.v1 = null;
        classScheduleFragment.v2 = null;
        classScheduleFragment.v3 = null;
        classScheduleFragment.llMorningReading = null;
        classScheduleFragment.llForenoon = null;
        classScheduleFragment.llAfternoon = null;
        classScheduleFragment.llNight = null;
        classScheduleFragment.llLab = null;
        classScheduleFragment.llContent = null;
        classScheduleFragment.mu = null;
        classScheduleFragment.rgCheck = null;
        classScheduleFragment.rbWeek = null;
        classScheduleFragment.rbMonth = null;
        classScheduleFragment.rbTrimester = null;
        classScheduleFragment.rl_check = null;
        classScheduleFragment.rl_rb = null;
        classScheduleFragment.rb_d_week = null;
        classScheduleFragment.rb_s_week = null;
        classScheduleFragment.rg_d_check = null;
        classScheduleFragment.tv_saturday = null;
        classScheduleFragment.tv_sunday = null;
        this.view7f0a06dd.setOnClickListener(null);
        this.view7f0a06dd = null;
        this.view7f0a06cc.setOnClickListener(null);
        this.view7f0a06cc = null;
        this.view7f0a06d9.setOnClickListener(null);
        this.view7f0a06d9 = null;
    }
}
