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
public class StudentProductionFragment2_4L_ViewBinding implements Unbinder {
    private StudentProductionFragment2_4L target;

    public StudentProductionFragment2_4L_ViewBinding(StudentProductionFragment2_4L studentProductionFragment2_4L, View view) {
        this.target = studentProductionFragment2_4L;
        studentProductionFragment2_4L.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'tvTitle'", TextView.class);
        studentProductionFragment2_4L.vpProduction = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vp_production2_4L, "field 'vpProduction'", ViewPager.class);
        studentProductionFragment2_4L.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator2_4L, "field 'llIndicator'", LinearLayout.class);
        studentProductionFragment2_4L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu2_4L, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentProductionFragment2_4L studentProductionFragment2_4L = this.target;
        if (studentProductionFragment2_4L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentProductionFragment2_4L.tvTitle = null;
        studentProductionFragment2_4L.vpProduction = null;
        studentProductionFragment2_4L.llIndicator = null;
        studentProductionFragment2_4L.mu = null;
    }
}
