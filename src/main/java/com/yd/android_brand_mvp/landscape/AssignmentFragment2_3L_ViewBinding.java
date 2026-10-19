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
public class AssignmentFragment2_3L_ViewBinding implements Unbinder {
    private AssignmentFragment2_3L target;

    public AssignmentFragment2_3L_ViewBinding(AssignmentFragment2_3L assignmentFragment2_3L, View view) {
        this.target = assignmentFragment2_3L;
        assignmentFragment2_3L.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'tvTitle'", TextView.class);
        assignmentFragment2_3L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        assignmentFragment2_3L.vpAssignment = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vp_assignment, "field 'vpAssignment'", ViewPager.class);
        assignmentFragment2_3L.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AssignmentFragment2_3L assignmentFragment2_3L = this.target;
        if (assignmentFragment2_3L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        assignmentFragment2_3L.tvTitle = null;
        assignmentFragment2_3L.mu = null;
        assignmentFragment2_3L.vpAssignment = null;
        assignmentFragment2_3L.llIndicator = null;
    }
}
