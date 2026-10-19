package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class StudentCenter2_3L_ViewBinding implements Unbinder {
    private StudentCenter2_3L target;

    public StudentCenter2_3L_ViewBinding(StudentCenter2_3L studentCenter2_3L, View view) {
        this.target = studentCenter2_3L;
        studentCenter2_3L.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        studentCenter2_3L.grid = (GridView) Utils.findRequiredViewAsType(view, R.id.grid, "field 'grid'", GridView.class);
        studentCenter2_3L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentCenter2_3L studentCenter2_3L = this.target;
        if (studentCenter2_3L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentCenter2_3L.title = null;
        studentCenter2_3L.grid = null;
        studentCenter2_3L.mu = null;
    }
}
