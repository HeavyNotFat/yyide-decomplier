package com.yd.android_brand_mvp.landscape.customized.tianjin;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.weight.MultiStateView;

/* JADX INFO: loaded from: classes4.dex */
public class CustomAttendanceFragment_ViewBinding implements Unbinder {
    private CustomAttendanceFragment target;

    public CustomAttendanceFragment_ViewBinding(CustomAttendanceFragment customAttendanceFragment, View view) {
        this.target = customAttendanceFragment;
        customAttendanceFragment.pager = (ViewPager) Utils.findRequiredViewAsType(view, R.id.pager, "field 'pager'", ViewPager.class);
        customAttendanceFragment.title = (TextView) Utils.findRequiredViewAsType(view, R.id.title, "field 'title'", TextView.class);
        customAttendanceFragment.mu = (MultiStateView) Utils.findRequiredViewAsType(view, R.id.mu, "field 'mu'", MultiStateView.class);
        customAttendanceFragment.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        CustomAttendanceFragment customAttendanceFragment = this.target;
        if (customAttendanceFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        customAttendanceFragment.pager = null;
        customAttendanceFragment.title = null;
        customAttendanceFragment.mu = null;
        customAttendanceFragment.llIndicator = null;
    }
}
