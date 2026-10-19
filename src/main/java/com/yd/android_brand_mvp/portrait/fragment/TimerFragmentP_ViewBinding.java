package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.ListView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class TimerFragmentP_ViewBinding implements Unbinder {
    private TimerFragmentP target;

    public TimerFragmentP_ViewBinding(TimerFragmentP timerFragmentP, View view) {
        this.target = timerFragmentP;
        timerFragmentP.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        timerFragmentP.lvlist = (ListView) Utils.findRequiredViewAsType(view, R.id.lvlist, "field 'lvlist'", ListView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TimerFragmentP timerFragmentP = this.target;
        if (timerFragmentP == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        timerFragmentP.mu = null;
        timerFragmentP.lvlist = null;
    }
}
