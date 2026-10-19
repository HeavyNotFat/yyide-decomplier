package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentPageFragment_ViewBinding implements Unbinder {
    private AssignmentPageFragment target;

    public AssignmentPageFragment_ViewBinding(AssignmentPageFragment assignmentPageFragment, View view) {
        this.target = assignmentPageFragment;
        assignmentPageFragment.tvSubject = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_subject, "field 'tvSubject'", TextView.class);
        assignmentPageFragment.tvTime = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_time, "field 'tvTime'", TextView.class);
        assignmentPageFragment.tvContent = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_content, "field 'tvContent'", TextView.class);
        assignmentPageFragment.tv_create_people = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_create_people, "field 'tv_create_people'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AssignmentPageFragment assignmentPageFragment = this.target;
        if (assignmentPageFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        assignmentPageFragment.tvSubject = null;
        assignmentPageFragment.tvTime = null;
        assignmentPageFragment.tvContent = null;
        assignmentPageFragment.tv_create_people = null;
    }
}
