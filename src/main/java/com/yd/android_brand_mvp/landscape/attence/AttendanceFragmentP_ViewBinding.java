package com.yd.android_brand_mvp.landscape.attence;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class AttendanceFragmentP_ViewBinding implements Unbinder {
    private AttendanceFragmentP target;
    private View view7f0a0a9c;
    private View view7f0a0bb7;

    public AttendanceFragmentP_ViewBinding(final AttendanceFragmentP attendanceFragmentP, View view) {
        this.target = attendanceFragmentP;
        attendanceFragmentP.rl_has_clock = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rl_has_clock, "field 'rl_has_clock'", RecyclerView.class);
        attendanceFragmentP.rl_attence = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rl_attence, "field 'rl_attence'", RecyclerView.class);
        attendanceFragmentP.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        attendanceFragmentP.mu1 = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu1, "field 'mu1'", MultiStateView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_human_face, "field 'tvface' and method 'onClick'");
        attendanceFragmentP.tvface = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_human_face, "field 'tvface'", TextView.class);
        this.view7f0a0a9c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentP_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                attendanceFragmentP.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_swiping_card, "field 'tvcard' and method 'onClick'");
        attendanceFragmentP.tvcard = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_swiping_card, "field 'tvcard'", TextView.class);
        this.view7f0a0bb7 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentP_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                attendanceFragmentP.onClick(view2);
            }
        });
        attendanceFragmentP.flLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_layout, "field 'flLayout'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttendanceFragmentP attendanceFragmentP = this.target;
        if (attendanceFragmentP == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attendanceFragmentP.rl_has_clock = null;
        attendanceFragmentP.rl_attence = null;
        attendanceFragmentP.mu = null;
        attendanceFragmentP.mu1 = null;
        attendanceFragmentP.tvface = null;
        attendanceFragmentP.tvcard = null;
        attendanceFragmentP.flLayout = null;
        this.view7f0a0a9c.setOnClickListener(null);
        this.view7f0a0a9c = null;
        this.view7f0a0bb7.setOnClickListener(null);
        this.view7f0a0bb7 = null;
    }
}
