package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class StudentDutyFragment4_1P_ViewBinding implements Unbinder {
    private StudentDutyFragment4_1P target;
    private View view7f0a0863;

    public StudentDutyFragment4_1P_ViewBinding(final StudentDutyFragment4_1P studentDutyFragment4_1P, View view) {
        this.target = studentDutyFragment4_1P;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onClick'");
        studentDutyFragment4_1P.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.portrait.fragment.StudentDutyFragment4_1P_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                studentDutyFragment4_1P.onClick(view2);
            }
        });
        studentDutyFragment4_1P.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        studentDutyFragment4_1P.rvDuty = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_duty, "field 'rvDuty'", RecyclerView.class);
        studentDutyFragment4_1P.content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentDutyFragment4_1P studentDutyFragment4_1P = this.target;
        if (studentDutyFragment4_1P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentDutyFragment4_1P.title = null;
        studentDutyFragment4_1P.mu = null;
        studentDutyFragment4_1P.rvDuty = null;
        studentDutyFragment4_1P.content = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
    }
}
