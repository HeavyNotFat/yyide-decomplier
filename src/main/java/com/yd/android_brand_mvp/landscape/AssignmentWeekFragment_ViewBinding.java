package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentWeekFragment_ViewBinding implements Unbinder {
    private AssignmentWeekFragment target;

    public AssignmentWeekFragment_ViewBinding(AssignmentWeekFragment assignmentWeekFragment, View view) {
        this.target = assignmentWeekFragment;
        assignmentWeekFragment.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_list, "field 'rvList'", RecyclerView.class);
        assignmentWeekFragment.rg_check = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.rg_check, "field 'rg_check'", RadioGroup.class);
        assignmentWeekFragment.rb_monday = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_monday, "field 'rb_monday'", RadioButton.class);
        assignmentWeekFragment.rb_tuesday = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_tuesday, "field 'rb_tuesday'", RadioButton.class);
        assignmentWeekFragment.rb_wednesday = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_wednesday, "field 'rb_wednesday'", RadioButton.class);
        assignmentWeekFragment.rb_thursday = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_thursday, "field 'rb_thursday'", RadioButton.class);
        assignmentWeekFragment.rb_fri = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_fri, "field 'rb_fri'", RadioButton.class);
        assignmentWeekFragment.rb_sat = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_sat, "field 'rb_sat'", RadioButton.class);
        assignmentWeekFragment.rb_week = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_week, "field 'rb_week'", RadioButton.class);
        assignmentWeekFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AssignmentWeekFragment assignmentWeekFragment = this.target;
        if (assignmentWeekFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        assignmentWeekFragment.rvList = null;
        assignmentWeekFragment.rg_check = null;
        assignmentWeekFragment.rb_monday = null;
        assignmentWeekFragment.rb_tuesday = null;
        assignmentWeekFragment.rb_wednesday = null;
        assignmentWeekFragment.rb_thursday = null;
        assignmentWeekFragment.rb_fri = null;
        assignmentWeekFragment.rb_sat = null;
        assignmentWeekFragment.rb_week = null;
        assignmentWeekFragment.mu = null;
    }
}
