package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class WIfiFragment_ViewBinding implements Unbinder {
    private WIfiFragment target;
    private View view7f0a0c2c;
    private View view7f0a0caf;

    public WIfiFragment_ViewBinding(final WIfiFragment wIfiFragment, View view) {
        this.target = wIfiFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.wifi_back, "field 'wifi_back' and method 'onViewClicked'");
        wIfiFragment.wifi_back = (LinearLayout) Utils.castView(viewFindRequiredView, R.id.wifi_back, "field 'wifi_back'", LinearLayout.class);
        this.view7f0a0caf = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.WIfiFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                wIfiFragment.onViewClicked(view2);
            }
        });
        wIfiFragment.rc_view = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rc_view, "field 'rc_view'", RecyclerView.class);
        wIfiFragment.checkbox = (CheckedTextView) Utils.findRequiredViewAsType(view, R.id.checkbox, "field 'checkbox'", CheckedTextView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_yt, "method 'onViewClicked'");
        this.view7f0a0c2c = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.WIfiFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                wIfiFragment.onViewClicked(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WIfiFragment wIfiFragment = this.target;
        if (wIfiFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        wIfiFragment.wifi_back = null;
        wIfiFragment.rc_view = null;
        wIfiFragment.checkbox = null;
        this.view7f0a0caf.setOnClickListener(null);
        this.view7f0a0caf = null;
        this.view7f0a0c2c.setOnClickListener(null);
        this.view7f0a0c2c = null;
    }
}
