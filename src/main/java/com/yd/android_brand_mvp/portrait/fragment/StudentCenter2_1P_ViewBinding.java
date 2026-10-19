package com.yd.android_brand_mvp.portrait.fragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public class StudentCenter2_1P_ViewBinding implements Unbinder {
    private StudentCenter2_1P target;

    public StudentCenter2_1P_ViewBinding(StudentCenter2_1P studentCenter2_1P, View view) {
        this.target = studentCenter2_1P;
        studentCenter2_1P.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        studentCenter2_1P.mBanner = (Banner) Utils.findRequiredViewAsType(view, R.id.banner_fragment, "field 'mBanner'", Banner.class);
        studentCenter2_1P.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        studentCenter2_1P.content = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.content, "field 'content'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentCenter2_1P studentCenter2_1P = this.target;
        if (studentCenter2_1P == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentCenter2_1P.title = null;
        studentCenter2_1P.mBanner = null;
        studentCenter2_1P.mu = null;
        studentCenter2_1P.content = null;
    }
}
