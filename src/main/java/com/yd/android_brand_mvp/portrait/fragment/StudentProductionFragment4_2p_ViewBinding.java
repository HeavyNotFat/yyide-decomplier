package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class StudentProductionFragment4_2p_ViewBinding implements Unbinder {
    private StudentProductionFragment4_2p target;

    public StudentProductionFragment4_2p_ViewBinding(StudentProductionFragment4_2p studentProductionFragment4_2p, View view) {
        this.target = studentProductionFragment4_2p;
        studentProductionFragment4_2p.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'tvTitle'", TextView.class);
        studentProductionFragment4_2p.vpProduction = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vp_production, "field 'vpProduction'", ViewPager.class);
        studentProductionFragment4_2p.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentProductionFragment4_2p studentProductionFragment4_2p = this.target;
        if (studentProductionFragment4_2p == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentProductionFragment4_2p.tvTitle = null;
        studentProductionFragment4_2p.vpProduction = null;
        studentProductionFragment4_2p.llIndicator = null;
    }
}
