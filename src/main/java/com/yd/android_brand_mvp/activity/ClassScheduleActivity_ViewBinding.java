package com.yd.android_brand_mvp.activity;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity_ViewBinding;

/* JADX INFO: loaded from: classes4.dex */
public class ClassScheduleActivity_ViewBinding extends BaseLayoutActivity_ViewBinding {
    private ClassScheduleActivity target;
    private View view7f0a0189;
    private View view7f0a06d9;
    private View view7f0a06dd;

    public ClassScheduleActivity_ViewBinding(ClassScheduleActivity classScheduleActivity) {
        this(classScheduleActivity, classScheduleActivity.getWindow().getDecorView());
    }

    public ClassScheduleActivity_ViewBinding(final ClassScheduleActivity classScheduleActivity, View view) {
        super(classScheduleActivity, view);
        this.target = classScheduleActivity;
        classScheduleActivity.rl_check = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_check, "field 'rl_check'", RelativeLayout.class);
        classScheduleActivity.rl_rb = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_rb, "field 'rl_rb'", RelativeLayout.class);
        classScheduleActivity.rgCheck = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.rg_check, "field 'rgCheck'", LinearLayout.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.rb_week, "field 'rbWeek' and method 'onClick'");
        classScheduleActivity.rbWeek = (Button) Utils.castView(viewFindRequiredView, R.id.rb_week, "field 'rbWeek'", Button.class);
        this.view7f0a06dd = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.ClassScheduleActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleActivity.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.rb_trimester, "field 'rbTrimester' and method 'onClick'");
        classScheduleActivity.rbTrimester = (Button) Utils.castView(viewFindRequiredView2, R.id.rb_trimester, "field 'rbTrimester'", Button.class);
        this.view7f0a06d9 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.ClassScheduleActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleActivity.onClick(view2);
            }
        });
        View viewFindRequiredView3 = Utils.findRequiredView(view, R.id.checkbox, "field 'checkbox' and method 'onClick'");
        classScheduleActivity.checkbox = (TextView) Utils.castView(viewFindRequiredView3, R.id.checkbox, "field 'checkbox'", TextView.class);
        this.view7f0a0189 = viewFindRequiredView3;
        viewFindRequiredView3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.ClassScheduleActivity_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                classScheduleActivity.onClick(view2);
            }
        });
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity_ViewBinding, butterknife.Unbinder
    public void unbind() {
        ClassScheduleActivity classScheduleActivity = this.target;
        if (classScheduleActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classScheduleActivity.rl_check = null;
        classScheduleActivity.rl_rb = null;
        classScheduleActivity.rgCheck = null;
        classScheduleActivity.rbWeek = null;
        classScheduleActivity.rbTrimester = null;
        classScheduleActivity.checkbox = null;
        this.view7f0a06dd.setOnClickListener(null);
        this.view7f0a06dd = null;
        this.view7f0a06d9.setOnClickListener(null);
        this.view7f0a06d9 = null;
        this.view7f0a0189.setOnClickListener(null);
        this.view7f0a0189 = null;
        super.unbind();
    }
}
