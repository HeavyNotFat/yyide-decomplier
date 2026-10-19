package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentDayFragment_ViewBinding implements Unbinder {
    private AssignmentDayFragment target;

    public AssignmentDayFragment_ViewBinding(AssignmentDayFragment assignmentDayFragment, View view) {
        this.target = assignmentDayFragment;
        assignmentDayFragment.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_list, "field 'rvList'", RecyclerView.class);
        assignmentDayFragment.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
        assignmentDayFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AssignmentDayFragment assignmentDayFragment = this.target;
        if (assignmentDayFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        assignmentDayFragment.rvList = null;
        assignmentDayFragment.llIndicator = null;
        assignmentDayFragment.mu = null;
    }
}
