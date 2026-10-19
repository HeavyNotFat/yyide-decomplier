package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionFragment6_3P_ViewBinding implements Unbinder {
    private StudentProductionFragment6_3P target;

    public StudentProductionFragment6_3P_ViewBinding(StudentProductionFragment6_3P studentProductionFragment6_3P, View view) {
        this.target = studentProductionFragment6_3P;
        studentProductionFragment6_3P.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'tvTitle'", TextView.class);
        studentProductionFragment6_3P.vpProduction = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vp_production6_3, "field 'vpProduction'", ViewPager.class);
        studentProductionFragment6_3P.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator6_3, "field 'llIndicator'", LinearLayout.class);
        studentProductionFragment6_3P.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu6_3, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentProductionFragment6_3P studentProductionFragment6_3P = this.target;
        if (studentProductionFragment6_3P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentProductionFragment6_3P.tvTitle = null;
        studentProductionFragment6_3P.vpProduction = null;
        studentProductionFragment6_3P.llIndicator = null;
        studentProductionFragment6_3P.mu = null;
    }
}
