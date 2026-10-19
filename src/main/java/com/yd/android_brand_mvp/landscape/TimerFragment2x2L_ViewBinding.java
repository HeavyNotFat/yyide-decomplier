package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public class TimerFragment2x2L_ViewBinding implements Unbinder {
    private TimerFragment2x2L target;

    public TimerFragment2x2L_ViewBinding(TimerFragment2x2L timerFragment2x2L, View view) {
        this.target = timerFragment2x2L;
        timerFragment2x2L.mBanner = (Banner) Utils.findRequiredViewAsType(view, R.id.announRoll, "field 'mBanner'", Banner.class);
        timerFragment2x2L.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        timerFragment2x2L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        timerFragment2x2L.layout_content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.layout_content, "field 'layout_content'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TimerFragment2x2L timerFragment2x2L = this.target;
        if (timerFragment2x2L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        timerFragment2x2L.mBanner = null;
        timerFragment2x2L.title = null;
        timerFragment2x2L.mu = null;
        timerFragment2x2L.layout_content = null;
    }
}
