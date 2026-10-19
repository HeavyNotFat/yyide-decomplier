package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public class StudentCenter2_2P_ViewBinding implements Unbinder {
    private StudentCenter2_2P target;

    public StudentCenter2_2P_ViewBinding(StudentCenter2_2P studentCenter2_2P, View view) {
        this.target = studentCenter2_2P;
        studentCenter2_2P.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        studentCenter2_2P.mBanner = (Banner) Utils.findRequiredViewAsType(view, R.id.banner_fragment, "field 'mBanner'", Banner.class);
        studentCenter2_2P.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentCenter2_2P studentCenter2_2P = this.target;
        if (studentCenter2_2P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentCenter2_2P.title = null;
        studentCenter2_2P.mBanner = null;
        studentCenter2_2P.mu = null;
    }
}
