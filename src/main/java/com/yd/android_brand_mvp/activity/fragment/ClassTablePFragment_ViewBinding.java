package com.yd.android_brand_mvp.activity.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class ClassTablePFragment_ViewBinding implements Unbinder {
    private ClassTablePFragment target;

    public ClassTablePFragment_ViewBinding(ClassTablePFragment classTablePFragment, View view) {
        this.target = classTablePFragment;
        classTablePFragment.rg_check = (RadioGroup) Utils.findRequiredViewAsType(view, R.id.rg_check, "field 'rg_check'", RadioGroup.class);
        classTablePFragment.rb_monday = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_monday, "field 'rb_monday'", RadioButton.class);
        classTablePFragment.rb_tuesday = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_tuesday, "field 'rb_tuesday'", RadioButton.class);
        classTablePFragment.rb_wednesday = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_wednesday, "field 'rb_wednesday'", RadioButton.class);
        classTablePFragment.rb_thursday = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_thursday, "field 'rb_thursday'", RadioButton.class);
        classTablePFragment.rb_fri = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_fri, "field 'rb_fri'", RadioButton.class);
        classTablePFragment.rb_sat = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_sat, "field 'rb_sat'", RadioButton.class);
        classTablePFragment.rb_week = (RadioButton) Utils.findRequiredViewAsType(view, R.id.rb_week, "field 'rb_week'", RadioButton.class);
        classTablePFragment.listTable = (GridView) Utils.findRequiredViewAsType(view, R.id.list_table, "field 'listTable'", GridView.class);
        classTablePFragment.table_view = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.table_view, "field 'table_view'", FrameLayout.class);
        classTablePFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ClassTablePFragment classTablePFragment = this.target;
        if (classTablePFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        classTablePFragment.rg_check = null;
        classTablePFragment.rb_monday = null;
        classTablePFragment.rb_tuesday = null;
        classTablePFragment.rb_wednesday = null;
        classTablePFragment.rb_thursday = null;
        classTablePFragment.rb_fri = null;
        classTablePFragment.rb_sat = null;
        classTablePFragment.rb_week = null;
        classTablePFragment.listTable = null;
        classTablePFragment.table_view = null;
        classTablePFragment.mu = null;
    }
}
