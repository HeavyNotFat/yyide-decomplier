package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class StudentDutyFragment2_2L_ViewBinding implements Unbinder {
    private StudentDutyFragment2_2L target;
    private View view7f0a0863;

    public StudentDutyFragment2_2L_ViewBinding(final StudentDutyFragment2_2L studentDutyFragment2_2L, View view) {
        this.target = studentDutyFragment2_2L;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onClick'");
        studentDutyFragment2_2L.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.StudentDutyFragment2_2L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentDutyFragment2_2L.onClick(view2);
            }
        });
        studentDutyFragment2_2L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        studentDutyFragment2_2L.rvDuty = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_duty, "field 'rvDuty'", RecyclerView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentDutyFragment2_2L studentDutyFragment2_2L = this.target;
        if (studentDutyFragment2_2L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentDutyFragment2_2L.title = null;
        studentDutyFragment2_2L.mu = null;
        studentDutyFragment2_2L.rvDuty = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
    }
}
