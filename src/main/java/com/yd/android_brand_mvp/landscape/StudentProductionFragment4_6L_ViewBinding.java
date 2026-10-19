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
public class StudentProductionFragment4_6L_ViewBinding implements Unbinder {
    private StudentProductionFragment4_6L target;

    public StudentProductionFragment4_6L_ViewBinding(StudentProductionFragment4_6L studentProductionFragment4_6L, View view) {
        this.target = studentProductionFragment4_6L;
        studentProductionFragment4_6L.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'tvTitle'", TextView.class);
        studentProductionFragment4_6L.vpProduction = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vp_production_4_4, "field 'vpProduction'", ViewPager.class);
        studentProductionFragment4_6L.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
        studentProductionFragment4_6L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentProductionFragment4_6L studentProductionFragment4_6L = this.target;
        if (studentProductionFragment4_6L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentProductionFragment4_6L.tvTitle = null;
        studentProductionFragment4_6L.vpProduction = null;
        studentProductionFragment4_6L.llIndicator = null;
        studentProductionFragment4_6L.mu = null;
    }
}
