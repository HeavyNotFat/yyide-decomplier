package com.yd.android_brand_mvp.activity;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class doorControlActivity_ViewBinding implements Unbinder {
    private doorControlActivity target;
    private View view7f0a0015;
    private View view7f0a0288;

    public doorControlActivity_ViewBinding(doorControlActivity doorcontrolactivity) {
        this(doorcontrolactivity, doorcontrolactivity.getWindow().getDecorView());
    }

    public doorControlActivity_ViewBinding(final doorControlActivity doorcontrolactivity, View view) {
        this.target = doorcontrolactivity;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.Reconnection, "field 'Reconnection' and method 'onViewClicked'");
        doorcontrolactivity.Reconnection = (FrameLayout) Utils.castView(viewFindRequiredView, R.id.Reconnection, "field 'Reconnection'", FrameLayout.class);
        this.view7f0a0015 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.doorControlActivity_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                doorcontrolactivity.onViewClicked(view2);
            }
        });
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.delectconnect, "field 'delectconnect' and method 'onViewClicked'");
        doorcontrolactivity.delectconnect = (FrameLayout) Utils.castView(viewFindRequiredView2, R.id.delectconnect, "field 'delectconnect'", FrameLayout.class);
        this.view7f0a0288 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.activity.doorControlActivity_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                doorcontrolactivity.onViewClicked(view2);
            }
        });
        doorcontrolactivity.tvRC = (TextView) Utils.findRequiredViewAsType(view, R.id.tvRC, "field 'tvRC'", TextView.class);
        doorcontrolactivity.tvUD = (TextView) Utils.findRequiredViewAsType(view, R.id.tvUD, "field 'tvUD'", TextView.class);
        doorcontrolactivity.open = (Button) Utils.findRequiredViewAsType(view, R.id.open, "field 'open'", Button.class);
        doorcontrolactivity.device = (TextView) Utils.findRequiredViewAsType(view, R.id.device, "field 'device'", TextView.class);
        doorcontrolactivity.llBack = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_back, "field 'llBack'", LinearLayout.class);
        doorcontrolactivity.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        doorControlActivity doorcontrolactivity = this.target;
        if (doorcontrolactivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        doorcontrolactivity.Reconnection = null;
        doorcontrolactivity.delectconnect = null;
        doorcontrolactivity.tvRC = null;
        doorcontrolactivity.tvUD = null;
        doorcontrolactivity.open = null;
        doorcontrolactivity.device = null;
        doorcontrolactivity.llBack = null;
        doorcontrolactivity.title = null;
        this.view7f0a0015.setOnClickListener(null);
        this.view7f0a0015 = null;
        this.view7f0a0288.setOnClickListener(null);
        this.view7f0a0288 = null;
    }
}
