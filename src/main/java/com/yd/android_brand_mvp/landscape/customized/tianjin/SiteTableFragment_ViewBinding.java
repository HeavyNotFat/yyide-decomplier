package com.yd.android_brand_mvp.landscape.customized.tianjin;

import android.view.View;
import android.widget.GridView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class SiteTableFragment_ViewBinding implements Unbinder {
    private SiteTableFragment target;
    private View view7f0a0863;

    public SiteTableFragment_ViewBinding(final SiteTableFragment siteTableFragment, View view) {
        this.target = siteTableFragment;
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onViewClicked'");
        siteTableFragment.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.customized.tianjin.SiteTableFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                siteTableFragment.onViewClicked(view2);
            }
        });
        siteTableFragment.tv_week = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_week, "field 'tv_week'", TextView.class);
        siteTableFragment.listTable = (GridView) Utils.findRequiredViewAsType(view, R.id.list_table, "field 'listTable'", GridView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SiteTableFragment siteTableFragment = this.target;
        if (siteTableFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        siteTableFragment.title = null;
        siteTableFragment.tv_week = null;
        siteTableFragment.listTable = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
    }
}
