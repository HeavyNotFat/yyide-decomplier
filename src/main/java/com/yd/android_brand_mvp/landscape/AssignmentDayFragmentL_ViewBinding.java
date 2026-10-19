package com.yd.android_brand_mvp.landscape;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentDayFragmentL_ViewBinding implements Unbinder {
    private AssignmentDayFragmentL target;

    public AssignmentDayFragmentL_ViewBinding(AssignmentDayFragmentL assignmentDayFragmentL, View view) {
        this.target = assignmentDayFragmentL;
        assignmentDayFragmentL.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rl_list, "field 'rvList'", RecyclerView.class);
        assignmentDayFragmentL.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AssignmentDayFragmentL assignmentDayFragmentL = this.target;
        if (assignmentDayFragmentL == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        assignmentDayFragmentL.rvList = null;
        assignmentDayFragmentL.mu = null;
    }
}
