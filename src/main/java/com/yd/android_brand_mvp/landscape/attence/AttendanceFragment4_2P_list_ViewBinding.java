package com.yd.android_brand_mvp.landscape.attence;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class AttendanceFragment4_2P_list_ViewBinding implements Unbinder {
    private AttendanceFragment4_2P_list target;

    public AttendanceFragment4_2P_list_ViewBinding(AttendanceFragment4_2P_list attendanceFragment4_2P_list, View view) {
        this.target = attendanceFragment4_2P_list;
        attendanceFragment4_2P_list.post = (TextView) Utils.findRequiredViewAsType(view, R.id.post, "field 'post'", TextView.class);
        attendanceFragment4_2P_list.pager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.pager, "field 'pager'", ViewPager.class);
        attendanceFragment4_2P_list.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        attendanceFragment4_2P_list.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        attendanceFragment4_2P_list.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
        attendanceFragment4_2P_list.rlAtt = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_att, "field 'rlAtt'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttendanceFragment4_2P_list attendanceFragment4_2P_list = this.target;
        if (attendanceFragment4_2P_list == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attendanceFragment4_2P_list.post = null;
        attendanceFragment4_2P_list.pager = null;
        attendanceFragment4_2P_list.title = null;
        attendanceFragment4_2P_list.mu = null;
        attendanceFragment4_2P_list.llIndicator = null;
        attendanceFragment4_2P_list.rlAtt = null;
    }
}
