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
public class AssignmentFragment2_4L_ViewBinding implements Unbinder {
    private AssignmentFragment2_4L target;

    public AssignmentFragment2_4L_ViewBinding(AssignmentFragment2_4L assignmentFragment2_4L, View view) {
        this.target = assignmentFragment2_4L;
        assignmentFragment2_4L.tvTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'tvTitle'", TextView.class);
        assignmentFragment2_4L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        assignmentFragment2_4L.vpAssignment = (ViewPager) Utils.findRequiredViewAsType(view, R.id.vp_assignment, "field 'vpAssignment'", ViewPager.class);
        assignmentFragment2_4L.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AssignmentFragment2_4L assignmentFragment2_4L = this.target;
        if (assignmentFragment2_4L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        assignmentFragment2_4L.tvTitle = null;
        assignmentFragment2_4L.mu = null;
        assignmentFragment2_4L.vpAssignment = null;
        assignmentFragment2_4L.llIndicator = null;
    }
}
