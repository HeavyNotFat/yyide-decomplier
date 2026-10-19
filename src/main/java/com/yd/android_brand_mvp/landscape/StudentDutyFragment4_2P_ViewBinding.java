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
public class StudentDutyFragment4_2P_ViewBinding implements Unbinder {
    private StudentDutyFragment4_2P target;
    private View view7f0a0863;

    public StudentDutyFragment4_2P_ViewBinding(final StudentDutyFragment4_2P studentDutyFragment4_2P, View view) {
        this.target = studentDutyFragment4_2P;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onClick'");
        studentDutyFragment4_2P.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.StudentDutyFragment4_2P_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentDutyFragment4_2P.onClick(view2);
            }
        });
        studentDutyFragment4_2P.rvDuty = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_duty, "field 'rvDuty'", RecyclerView.class);
        studentDutyFragment4_2P.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentDutyFragment4_2P studentDutyFragment4_2P = this.target;
        if (studentDutyFragment4_2P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentDutyFragment4_2P.title = null;
        studentDutyFragment4_2P.rvDuty = null;
        studentDutyFragment4_2P.mu = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
    }
}
