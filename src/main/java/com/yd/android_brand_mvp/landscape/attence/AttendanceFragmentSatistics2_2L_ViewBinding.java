package com.yd.android_brand_mvp.landscape.attence;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class AttendanceFragmentSatistics2_2L_ViewBinding implements Unbinder {
    private AttendanceFragmentSatistics2_2L target;

    public AttendanceFragmentSatistics2_2L_ViewBinding(AttendanceFragmentSatistics2_2L attendanceFragmentSatistics2_2L, View view) {
        this.target = attendanceFragmentSatistics2_2L;
        attendanceFragmentSatistics2_2L.pager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.pager, "field 'pager'", ViewPager.class);
        attendanceFragmentSatistics2_2L.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        attendanceFragmentSatistics2_2L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        attendanceFragmentSatistics2_2L.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttendanceFragmentSatistics2_2L attendanceFragmentSatistics2_2L = this.target;
        if (attendanceFragmentSatistics2_2L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attendanceFragmentSatistics2_2L.pager = null;
        attendanceFragmentSatistics2_2L.title = null;
        attendanceFragmentSatistics2_2L.mu = null;
        attendanceFragmentSatistics2_2L.llIndicator = null;
    }
}
