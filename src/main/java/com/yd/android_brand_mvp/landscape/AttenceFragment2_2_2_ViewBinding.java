package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceFragment2_2_2_ViewBinding implements Unbinder {
    private AttenceFragment2_2_2 target;
    private View view7f0a0863;
    private View view7f0a0971;

    public AttenceFragment2_2_2_ViewBinding(final AttenceFragment2_2_2 attenceFragment2_2_2, View view) {
        this.target = attenceFragment2_2_2;
        attenceFragment2_2_2.rl_attence = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rl_attence, "field 'rl_attence'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onClick'");
        attenceFragment2_2_2.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment2_2_2_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                attenceFragment2_2_2.onClick(view2);
            }
        });
        attenceFragment2_2_2.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_att, "field 'tv_att' and method 'onClick'");
        attenceFragment2_2_2.tv_att = (TextView) Utils.castView(viewFindRequiredView2, R.id.tv_att, "field 'tv_att'", TextView.class);
        this.view7f0a0971 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.AttenceFragment2_2_2_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                attenceFragment2_2_2.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttenceFragment2_2_2 attenceFragment2_2_2 = this.target;
        if (attenceFragment2_2_2 == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attenceFragment2_2_2.rl_attence = null;
        attenceFragment2_2_2.title = null;
        attenceFragment2_2_2.mu = null;
        attenceFragment2_2_2.tv_att = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
        this.view7f0a0971.setOnClickListener(null);
        this.view7f0a0971 = null;
    }
}
