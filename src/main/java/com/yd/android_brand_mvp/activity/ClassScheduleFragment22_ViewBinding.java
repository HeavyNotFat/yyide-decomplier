package com.yd.android_brand_mvp.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleFragment22_ViewBinding implements Unbinder {
    private ClassScheduleFragment22 target;
    private View view7f0a06cc;
    private View view7f0a06d9;
    private View view7f0a06dd;

    public ClassScheduleFragment22_ViewBinding(final ClassScheduleFragment22 classScheduleFragment22, View view) {
        this.target = classScheduleFragment22;
        classScheduleFragment22.gvList1 = (GridView) Utils.findRequiredViewAsType(view, R.id.gv_list1, "field 'gvList1'", GridView.class);
        classScheduleFragment22.gvList2 = (GridView) Utils.findRequiredViewAsType(view, R.id.gv_list2, "field 'gvList2'", GridView.class);
        classScheduleFragment22.gvList3 = (GridView) Utils.findRequiredViewAsType(view, R.id.gv_list3, "field 'gvList3'", GridView.class);
        classScheduleFragment22.gvList4 = (GridView) Utils.findRequiredViewAsType(view, R.id.gv_list4, "field 'gvList4'", GridView.class);
        classScheduleFragment22.llMorningReading = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_morning_reading, "field 'llMorningReading'", LinearLayout.class);
        classScheduleFragment22.llForenoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_forenoon, "field 'llForenoon'", LinearLayout.class);
        classScheduleFragment22.llAfternoon = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_afternoon, "field 'llAfternoon'", LinearLayout.class);
        classScheduleFragment22.llNight = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_night, "field 'llNight'", LinearLayout.class);
        classScheduleFragment22.llLab = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_lab, "field 'llLab'", LinearLayout.class);
        classScheduleFragment22.llContent = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_content, "field 'llContent'", LinearLayout.class);
        classScheduleFragment22.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        classScheduleFragment22.rgCheck = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.rg_check, "field 'rgCheck'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rb_week, "field 'rbWeek' and method 'onClick'");
        classScheduleFragment22.rbWeek = (CheckedTextView) Utils.castView(viewFindRequiredView, R.id.rb_week, "field 'rbWeek'", CheckedTextView.class);
        this.view7f0a06dd = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.ClassScheduleFragment22_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleFragment22.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rb_month, "field 'rbMonth' and method 'onClick'");
        classScheduleFragment22.rbMonth = (Button) Utils.castView(viewFindRequiredView2, R.id.rb_month, "field 'rbMonth'", Button.class);
        this.view7f0a06cc = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.ClassScheduleFragment22_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleFragment22.onClick(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.rb_trimester, "field 'rbTrimester' and method 'onClick'");
        classScheduleFragment22.rbTrimester = (CheckedTextView) Utils.castView(viewFindRequiredView3, R.id.rb_trimester, "field 'rbTrimester'", CheckedTextView.class);
        this.view7f0a06d9 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.ClassScheduleFragment22_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleFragment22.onClick(view2);
            }
        });
        classScheduleFragment22.rl_check = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_check, "field 'rl_check'", RelativeLayout.class);
        classScheduleFragment22.rl_rb = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_rb, "field 'rl_rb'", RelativeLayout.class);
        classScheduleFragment22.title_Name = (TextView) Utils.findRequiredViewAsType(view, R.id.title_Name, "field 'title_Name'", TextView.class);
        classScheduleFragment22.week = (TextView) Utils.findRequiredViewAsType(view, R.id.week, "field 'week'", TextView.class);
        classScheduleFragment22.checkbox = (TextView) Utils.findRequiredViewAsType(view, R.id.checkbox, "field 'checkbox'", TextView.class);
        classScheduleFragment22.tv_sunday = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_sunday, "field 'tv_sunday'", TextView.class);
        classScheduleFragment22.v1 = Utils.findRequiredView(view, R.id.v1, "field 'v1'");
        classScheduleFragment22.v2 = Utils.findRequiredView(view, R.id.v2, "field 'v2'");
        classScheduleFragment22.v3 = Utils.findRequiredView(view, R.id.v3, "field 'v3'");
        classScheduleFragment22.tv_saturday = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_saturday, "field 'tv_saturday'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassScheduleFragment22 classScheduleFragment22 = this.target;
        if (classScheduleFragment22 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classScheduleFragment22.gvList1 = null;
        classScheduleFragment22.gvList2 = null;
        classScheduleFragment22.gvList3 = null;
        classScheduleFragment22.gvList4 = null;
        classScheduleFragment22.llMorningReading = null;
        classScheduleFragment22.llForenoon = null;
        classScheduleFragment22.llAfternoon = null;
        classScheduleFragment22.llNight = null;
        classScheduleFragment22.llLab = null;
        classScheduleFragment22.llContent = null;
        classScheduleFragment22.mu = null;
        classScheduleFragment22.rgCheck = null;
        classScheduleFragment22.rbWeek = null;
        classScheduleFragment22.rbMonth = null;
        classScheduleFragment22.rbTrimester = null;
        classScheduleFragment22.rl_check = null;
        classScheduleFragment22.rl_rb = null;
        classScheduleFragment22.title_Name = null;
        classScheduleFragment22.week = null;
        classScheduleFragment22.checkbox = null;
        classScheduleFragment22.tv_sunday = null;
        classScheduleFragment22.v1 = null;
        classScheduleFragment22.v2 = null;
        classScheduleFragment22.v3 = null;
        classScheduleFragment22.tv_saturday = null;
        this.view7f0a06dd.setOnClickListener(null);
        this.view7f0a06dd = null;
        this.view7f0a06cc.setOnClickListener(null);
        this.view7f0a06cc = null;
        this.view7f0a06d9.setOnClickListener(null);
        this.view7f0a06d9 = null;
    }
}
