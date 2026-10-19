package com.yd.android_brand_mvp.landscape.attence;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class AttendanceFragment2_2_2L_ViewBinding implements Unbinder {
    private AttendanceFragment2_2_2L target;
    private View view7f0a0863;
    private View view7f0a0971;

    public AttendanceFragment2_2_2L_ViewBinding(final AttendanceFragment2_2_2L attendanceFragment2_2_2L, View view) {
        this.target = attendanceFragment2_2_2L;
        attendanceFragment2_2_2L.rl_attence = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rl_attence, "field 'rl_attence'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onClick'");
        attendanceFragment2_2_2L.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragment2_2_2L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                attendanceFragment2_2_2L.onClick(view2);
            }
        });
        attendanceFragment2_2_2L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_att, "field 'tv_att' and method 'onClick'");
        attendanceFragment2_2_2L.tv_att = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_att, "field 'tv_att'", TextView.class);
        this.view7f0a0971 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragment2_2_2L_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                attendanceFragment2_2_2L.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttendanceFragment2_2_2L attendanceFragment2_2_2L = this.target;
        if (attendanceFragment2_2_2L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attendanceFragment2_2_2L.rl_attence = null;
        attendanceFragment2_2_2L.title = null;
        attendanceFragment2_2_2L.mu = null;
        attendanceFragment2_2_2L.tv_att = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
        this.view7f0a0971.setOnClickListener(null);
        this.view7f0a0971 = null;
    }
}
