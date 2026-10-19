package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class KBFragment2_4L_ViewBinding implements Unbinder {
    private KBFragment2_4L target;
    private View view7f0a0863;

    public KBFragment2_4L_ViewBinding(final KBFragment2_4L kBFragment2_4L, View view) {
        this.target = kBFragment2_4L;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onViewClicked'");
        kBFragment2_4L.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.KBFragment2_4L_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                kBFragment2_4L.onViewClicked(view2);
            }
        });
        kBFragment2_4L.tv_week = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_week, "field 'tv_week'", TextView.class);
        kBFragment2_4L.listview = (ListView) Utils.findRequiredViewAsType(view, R.id.listview, "field 'listview'", ListView.class);
        kBFragment2_4L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        KBFragment2_4L kBFragment2_4L = this.target;
        if (kBFragment2_4L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        kBFragment2_4L.title = null;
        kBFragment2_4L.tv_week = null;
        kBFragment2_4L.listview = null;
        kBFragment2_4L.mu = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
    }
}
