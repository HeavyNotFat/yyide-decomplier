package com.yd.android_brand_mvp.landscape.attence;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class AttendanceFragmentSatistics_cartoon_2_2L_ViewBinding implements Unbinder {
    private AttendanceFragmentSatistics_cartoon_2_2L target;

    public AttendanceFragmentSatistics_cartoon_2_2L_ViewBinding(AttendanceFragmentSatistics_cartoon_2_2L attendanceFragmentSatistics_cartoon_2_2L, View view) {
        this.target = attendanceFragmentSatistics_cartoon_2_2L;
        attendanceFragmentSatistics_cartoon_2_2L.pager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.pager, "field 'pager'", ViewPager.class);
        attendanceFragmentSatistics_cartoon_2_2L.content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", LinearLayout.class);
        attendanceFragmentSatistics_cartoon_2_2L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        attendanceFragmentSatistics_cartoon_2_2L.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttendanceFragmentSatistics_cartoon_2_2L attendanceFragmentSatistics_cartoon_2_2L = this.target;
        if (attendanceFragmentSatistics_cartoon_2_2L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attendanceFragmentSatistics_cartoon_2_2L.pager = null;
        attendanceFragmentSatistics_cartoon_2_2L.content = null;
        attendanceFragmentSatistics_cartoon_2_2L.mu = null;
        attendanceFragmentSatistics_cartoon_2_2L.llIndicator = null;
    }
}
