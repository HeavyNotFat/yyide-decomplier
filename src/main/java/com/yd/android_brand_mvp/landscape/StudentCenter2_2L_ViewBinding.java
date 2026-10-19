package com.yd.android_brand_mvp.landscape;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;
import com.youth.banner.Banner;

/* JADX INFO: loaded from: classes4.dex */
public class StudentCenter2_2L_ViewBinding implements Unbinder {
    private StudentCenter2_2L target;

    public StudentCenter2_2L_ViewBinding(StudentCenter2_2L studentCenter2_2L, View view) {
        this.target = studentCenter2_2L;
        studentCenter2_2L.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        studentCenter2_2L.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        studentCenter2_2L.mBanner = (Banner) Utils.findRequiredViewAsType(view, R.id.banner_fragment, "field 'mBanner'", Banner.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        StudentCenter2_2L studentCenter2_2L = this.target;
        if (studentCenter2_2L == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        studentCenter2_2L.title = null;
        studentCenter2_2L.mu = null;
        studentCenter2_2L.mBanner = null;
    }
}
