package com.yd.android_brand_mvp.activity;

import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity_ViewBinding;

/* JADX INFO: loaded from: classes4.dex */
public class SiteKBActivity_ViewBinding extends BaseLayoutActivity_ViewBinding {
    private SiteKBActivity target;

    public SiteKBActivity_ViewBinding(SiteKBActivity siteKBActivity) {
        this(siteKBActivity, siteKBActivity.getWindow().getDecorView());
    }

    public SiteKBActivity_ViewBinding(SiteKBActivity siteKBActivity, View view) {
        super(siteKBActivity, view);
        this.target = siteKBActivity;
        siteKBActivity.rl_check = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_check, "field 'rl_check'", RelativeLayout.class);
        siteKBActivity.rl_rb = (RelativeLayout) Utils.findRequiredViewAsType(view, R.id.rl_rb, "field 'rl_rb'", RelativeLayout.class);
        siteKBActivity.rgCheck = (LinearLayout) Utils.findRequiredViewAsType(view, R.id.rg_check, "field 'rgCheck'", LinearLayout.class);
        siteKBActivity.rbWeek = (Button) Utils.findRequiredViewAsType(view, R.id.rb_week, "field 'rbWeek'", Button.class);
        siteKBActivity.rbTrimester = (Button) Utils.findRequiredViewAsType(view, R.id.rb_trimester, "field 'rbTrimester'", Button.class);
        siteKBActivity.checkbox = (TextView) Utils.findRequiredViewAsType(view, R.id.checkbox, "field 'checkbox'", TextView.class);
        siteKBActivity.title_Name = (TextView) Utils.findRequiredViewAsType(view, R.id.title_Name, "field 'title_Name'", TextView.class);
        siteKBActivity.leftBack = (TextView) Utils.findRequiredViewAsType(view, R.id.left, "field 'leftBack'", TextView.class);
        siteKBActivity.layoutTop = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.layoutTop, "field 'layoutTop'", FrameLayout.class);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity_ViewBinding, butterknife.Unbinder
    public void unbind() {
        SiteKBActivity siteKBActivity = this.target;
        if (siteKBActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        siteKBActivity.rl_check = null;
        siteKBActivity.rl_rb = null;
        siteKBActivity.rgCheck = null;
        siteKBActivity.rbWeek = null;
        siteKBActivity.rbTrimester = null;
        siteKBActivity.checkbox = null;
        siteKBActivity.title_Name = null;
        siteKBActivity.leftBack = null;
        siteKBActivity.layoutTop = null;
        super.unbind();
    }
}
