package com.yd.android_brand_mvp.landscape;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class WeekStudentDutyFragment_ViewBinding implements Unbinder {
    private WeekStudentDutyFragment target;

    public WeekStudentDutyFragment_ViewBinding(WeekStudentDutyFragment weekStudentDutyFragment, View view) {
        this.target = weekStudentDutyFragment;
        weekStudentDutyFragment.rvAllDuty = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rv_all_duty, "field 'rvAllDuty'", RecyclerView.class);
        weekStudentDutyFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WeekStudentDutyFragment weekStudentDutyFragment = this.target;
        if (weekStudentDutyFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        weekStudentDutyFragment.rvAllDuty = null;
        weekStudentDutyFragment.mu = null;
    }
}
