package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class AttenceFragment4_2P_list_ViewBinding implements Unbinder {
    private AttenceFragment4_2P_list target;

    public AttenceFragment4_2P_list_ViewBinding(AttenceFragment4_2P_list attenceFragment4_2P_list, View view) {
        this.target = attenceFragment4_2P_list;
        attenceFragment4_2P_list.post = (TextView) Utils.findRequiredViewAsType(view, R.id.post, "field 'post'", TextView.class);
        attenceFragment4_2P_list.pager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.pager, "field 'pager'", ViewPager.class);
        attenceFragment4_2P_list.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        attenceFragment4_2P_list.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        attenceFragment4_2P_list.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
        attenceFragment4_2P_list.rlAtt = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_att, "field 'rlAtt'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        AttenceFragment4_2P_list attenceFragment4_2P_list = this.target;
        if (attenceFragment4_2P_list == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        attenceFragment4_2P_list.post = null;
        attenceFragment4_2P_list.pager = null;
        attenceFragment4_2P_list.title = null;
        attenceFragment4_2P_list.mu = null;
        attenceFragment4_2P_list.llIndicator = null;
        attenceFragment4_2P_list.rlAtt = null;
    }
}
