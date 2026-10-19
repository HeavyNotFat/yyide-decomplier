package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class AssignmentWeekFragmentP_ViewBinding implements Unbinder {
    private AssignmentWeekFragmentP target;

    public AssignmentWeekFragmentP_ViewBinding(AssignmentWeekFragmentP assignmentWeekFragmentP, View view) {
        this.target = assignmentWeekFragmentP;
        assignmentWeekFragmentP.rg_check = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.rg_check, "field 'rg_check'", RadioGroup.class);
        assignmentWeekFragmentP.rb_monday = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_monday, "field 'rb_monday'", RadioButton.class);
        assignmentWeekFragmentP.rb_tuesday = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_tuesday, "field 'rb_tuesday'", RadioButton.class);
        assignmentWeekFragmentP.rb_wednesday = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_wednesday, "field 'rb_wednesday'", RadioButton.class);
        assignmentWeekFragmentP.rb_thursday = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_thursday, "field 'rb_thursday'", RadioButton.class);
        assignmentWeekFragmentP.rb_fri = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_fri, "field 'rb_fri'", RadioButton.class);
        assignmentWeekFragmentP.rb_sat = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_sat, "field 'rb_sat'", RadioButton.class);
        assignmentWeekFragmentP.rb_week = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_week, "field 'rb_week'", RadioButton.class);
        assignmentWeekFragmentP.tvNull = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_null, "field 'tvNull'", TextView.class);
        assignmentWeekFragmentP.rvList = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rl_list, "field 'rvList'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AssignmentWeekFragmentP assignmentWeekFragmentP = this.target;
        if (assignmentWeekFragmentP == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        assignmentWeekFragmentP.rg_check = null;
        assignmentWeekFragmentP.rb_monday = null;
        assignmentWeekFragmentP.rb_tuesday = null;
        assignmentWeekFragmentP.rb_wednesday = null;
        assignmentWeekFragmentP.rb_thursday = null;
        assignmentWeekFragmentP.rb_fri = null;
        assignmentWeekFragmentP.rb_sat = null;
        assignmentWeekFragmentP.rb_week = null;
        assignmentWeekFragmentP.tvNull = null;
        assignmentWeekFragmentP.rvList = null;
    }
}
