package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class NetWorkFragment_ViewBinding implements Unbinder {
    private NetWorkFragment target;

    public NetWorkFragment_ViewBinding(NetWorkFragment netWorkFragment, View view) {
        this.target = netWorkFragment;
        netWorkFragment.content = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", FrameLayout.class);
        netWorkFragment.type = (TextView) Utils.findRequiredViewAsType(view, R.id.type, "field 'type'", TextView.class);
        netWorkFragment.tvTest = (TextView) Utils.findRequiredViewAsType(view, R.id.tvTest, "field 'tvTest'", TextView.class);
        netWorkFragment.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        netWorkFragment.btn_close = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.btn_close, "field 'btn_close'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        NetWorkFragment netWorkFragment = this.target;
        if (netWorkFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        netWorkFragment.content = null;
        netWorkFragment.type = null;
        netWorkFragment.tvTest = null;
        netWorkFragment.title = null;
        netWorkFragment.btn_close = null;
    }
}
