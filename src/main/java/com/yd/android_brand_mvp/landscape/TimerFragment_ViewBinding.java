package com.yd.android_brand_mvp.landscape;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class TimerFragment_ViewBinding implements Unbinder {
    private TimerFragment target;

    public TimerFragment_ViewBinding(TimerFragment timerFragment, View view) {
        this.target = timerFragment;
        timerFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TimerFragment timerFragment = this.target;
        if (timerFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        timerFragment.mu = null;
    }
}
