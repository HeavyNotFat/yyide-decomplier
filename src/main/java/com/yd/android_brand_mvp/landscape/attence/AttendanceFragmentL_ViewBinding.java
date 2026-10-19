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
public class AttendanceFragmentL_ViewBinding implements Unbinder {
    private AttendanceFragmentL target;
    private View view7f0a0a9c;
    private View view7f0a0bb7;

    public AttendanceFragmentL_ViewBinding(final AttendanceFragmentL attendanceFragmentL, View view) {
        this.target = attendanceFragmentL;
        attendanceFragmentL.rl_has_clock = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rl_has_clock, "field 'rl_has_clock'", RecyclerView.class);
        attendanceFragmentL.rl_attence = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rl_attence, "field 'rl_attence'", RecyclerView.class);
        attendanceFragmentL.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        attendanceFragmentL.mu1 = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu1, "field 'mu1'", MultiStateView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.tv_human_face, "field 'tvface' and method 'onClick'");
        attendanceFragmentL.tvface = (TextView) Utils.castView(viewFindRequiredView, R.id.tv_human_face, "field 'tvface'", TextView.class);
        this.view7f0a0a9c = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentL_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                attendanceFragmentL.onClick(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_swiping_card, "field 'tvcard' and method 'onClick'");
        attendanceFragmentL.tvcard = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_swiping_card, "field 'tvcard'", TextView.class);
        this.view7f0a0bb7 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttendanceFragmentL_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                attendanceFragmentL.onClick(view2);
            }
        });
        attendanceFragmentL.tvTip = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTip, "field 'tvTip'", TextView.class);
        attendanceFragmentL.flLayout = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fl_layout, "field 'flLayout'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttendanceFragmentL attendanceFragmentL = this.target;
        if (attendanceFragmentL == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attendanceFragmentL.rl_has_clock = null;
        attendanceFragmentL.rl_attence = null;
        attendanceFragmentL.mu = null;
        attendanceFragmentL.mu1 = null;
        attendanceFragmentL.tvface = null;
        attendanceFragmentL.tvcard = null;
        attendanceFragmentL.tvTip = null;
        attendanceFragmentL.flLayout = null;
        this.view7f0a0a9c.setOnClickListener(null);
        this.view7f0a0a9c = null;
        this.view7f0a0bb7.setOnClickListener(null);
        this.view7f0a0bb7 = null;
    }
}
