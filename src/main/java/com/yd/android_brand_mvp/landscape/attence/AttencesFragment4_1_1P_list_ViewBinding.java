package com.yd.android_brand_mvp.landscape.attence;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class AttencesFragment4_1_1P_list_ViewBinding implements Unbinder {
    private AttencesFragment4_1_1P_list target;
    private View view7f0a0863;
    private View view7f0a0971;

    public AttencesFragment4_1_1P_list_ViewBinding(final AttencesFragment4_1_1P_list attencesFragment4_1_1P_list, View view) {
        this.target = attencesFragment4_1_1P_list;
        attencesFragment4_1_1P_list.rl_attence = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rl_attence, "field 'rl_attence'", RecyclerView.class);
        View viewFindRequiredView = Utils.findRequiredView(view, R.id.title, "field 'title' and method 'onClick'");
        attencesFragment4_1_1P_list.title = (TextView) Utils.castView(viewFindRequiredView, R.id.title, "field 'title'", TextView.class);
        this.view7f0a0863 = viewFindRequiredView;
        viewFindRequiredView.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment4_1_1P_list_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                attencesFragment4_1_1P_list.onClick(view2);
            }
        });
        attencesFragment4_1_1P_list.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        View viewFindRequiredView2 = Utils.findRequiredView(view, R.id.tv_att, "method 'onClick'");
        this.view7f0a0971 = viewFindRequiredView2;
        viewFindRequiredView2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.yd.android_brand_mvp.landscape.attence.AttencesFragment4_1_1P_list_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public void doClick(View view2) {
                attencesFragment4_1_1P_list.onClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttencesFragment4_1_1P_list attencesFragment4_1_1P_list = this.target;
        if (attencesFragment4_1_1P_list == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attencesFragment4_1_1P_list.rl_attence = null;
        attencesFragment4_1_1P_list.title = null;
        attencesFragment4_1_1P_list.mu = null;
        this.view7f0a0863.setOnClickListener(null);
        this.view7f0a0863 = null;
        this.view7f0a0971.setOnClickListener(null);
        this.view7f0a0971 = null;
    }
}
