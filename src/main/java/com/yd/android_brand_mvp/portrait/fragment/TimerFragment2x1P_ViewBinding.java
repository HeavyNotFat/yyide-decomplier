package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jude.rollviewpager.RollPagerView;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class TimerFragment2x1P_ViewBinding implements Unbinder {
    private TimerFragment2x1P target;

    public TimerFragment2x1P_ViewBinding(TimerFragment2x1P timerFragment2x1P, View view) {
        this.target = timerFragment2x1P;
        timerFragment2x1P.announRoll = (RollPagerView) Utils.findRequiredViewAsType(view, R.id.announRoll, "field 'announRoll'", RollPagerView.class);
        timerFragment2x1P.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        timerFragment2x1P.item = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fitem, "field 'item'", FrameLayout.class);
        timerFragment2x1P.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        timerFragment2x1P.tv_num = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_num, "field 'tv_num'", TextView.class);
        timerFragment2x1P.tv_content = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_content, "field 'tv_content'", TextView.class);
        timerFragment2x1P.iv_img = (ImageView) Utils.findRequiredViewAsType(view, R.id.iv_img, "field 'iv_img'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        TimerFragment2x1P timerFragment2x1P = this.target;
        if (timerFragment2x1P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        timerFragment2x1P.announRoll = null;
        timerFragment2x1P.title = null;
        timerFragment2x1P.item = null;
        timerFragment2x1P.mu = null;
        timerFragment2x1P.tv_num = null;
        timerFragment2x1P.tv_content = null;
        timerFragment2x1P.iv_img = null;
    }
}
