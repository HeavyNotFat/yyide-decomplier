package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.yd.android_brand_mvp.widget.YDViewPager;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionFragment_ViewBinding implements Unbinder {
    private StudentProductionFragment target;
    private View view7f0a0b19;
    private View view7f0a0b38;

    public StudentProductionFragment_ViewBinding(final StudentProductionFragment studentProductionFragment, View view) {
        this.target = studentProductionFragment;
        studentProductionFragment.vpStuProduction = (YDViewPager) Utils.findRequiredViewAsType(view, R.id.vp_stu_production, "field 'vpStuProduction'", YDViewPager.class);
        studentProductionFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_last, "field 'tvLast' and method 'onClick'");
        studentProductionFragment.tvLast = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_last, "field 'tvLast'", TextView.class);
        this.view7f0a0b19 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentProductionFragment.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_next, "field 'tvNext' and method 'onClick'");
        studentProductionFragment.tvNext = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_next, "field 'tvNext'", TextView.class);
        this.view7f0a0b38 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.StudentProductionFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentProductionFragment.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentProductionFragment studentProductionFragment = this.target;
        if (studentProductionFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentProductionFragment.vpStuProduction = null;
        studentProductionFragment.mu = null;
        studentProductionFragment.tvLast = null;
        studentProductionFragment.tvNext = null;
        this.view7f0a0b19.setOnClickListener(null);
        this.view7f0a0b19 = null;
        this.view7f0a0b38.setOnClickListener(null);
        this.view7f0a0b38 = null;
    }
}
