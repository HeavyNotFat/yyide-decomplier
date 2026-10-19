package com.yd.android_brand_mvp.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class doorListActivity_ViewBinding implements Unbinder {
    private doorListActivity target;

    public doorListActivity_ViewBinding(doorListActivity doorlistactivity) {
        this(doorlistactivity, doorlistactivity.getWindow().getDecorView());
    }

    public doorListActivity_ViewBinding(doorListActivity doorlistactivity, View view) {
        this.target = doorlistactivity;
        doorlistactivity.listDevice = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.list_device, "field 'listDevice'", RecyclerView.class);
        doorlistactivity.llBack = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_back, "field 'llBack'", LinearLayout.class);
        doorlistactivity.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        doorListActivity doorlistactivity = this.target;
        if (doorlistactivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        doorlistactivity.listDevice = null;
        doorlistactivity.llBack = null;
        doorlistactivity.title = null;
    }
}
