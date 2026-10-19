package com.yd.android_brand_mvp.video1;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager2.widget.ViewPager2;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class ViewPagerVideoActivity_ViewBinding implements Unbinder {
    private ViewPagerVideoActivity target;

    public ViewPagerVideoActivity_ViewBinding(ViewPagerVideoActivity viewPagerVideoActivity) {
        this(viewPagerVideoActivity, viewPagerVideoActivity.getWindow().getDecorView());
    }

    public ViewPagerVideoActivity_ViewBinding(ViewPagerVideoActivity viewPagerVideoActivity, View view) {
        this.target = viewPagerVideoActivity;
        viewPagerVideoActivity.viewPager2 = (ViewPager2) Utils.findRequiredViewAsType(view, R.id.view_pager2, "field 'viewPager2'", ViewPager2.class);
        viewPagerVideoActivity.llIndicator = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.ll_indicator, "field 'llIndicator'", LinearLayout.class);
        viewPagerVideoActivity.close = (TextView) Utils.findRequiredViewAsType(view, R.id.close, "field 'close'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ViewPagerVideoActivity viewPagerVideoActivity = this.target;
        if (viewPagerVideoActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        viewPagerVideoActivity.viewPager2 = null;
        viewPagerVideoActivity.llIndicator = null;
        viewPagerVideoActivity.close = null;
    }
}
