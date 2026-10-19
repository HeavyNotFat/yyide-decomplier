package com.yd.android_brand_mvp.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.yd.android_brand_mvp.R;

/* JADX INFO: loaded from: classes4.dex */
public class BaseLayoutActivity_ViewBinding implements Unbinder {
    private BaseLayoutActivity target;

    public BaseLayoutActivity_ViewBinding(BaseLayoutActivity baseLayoutActivity) {
        this(baseLayoutActivity, baseLayoutActivity.getWindow().getDecorView());
    }

    public BaseLayoutActivity_ViewBinding(BaseLayoutActivity baseLayoutActivity, View view) {
        this.target = baseLayoutActivity;
        baseLayoutActivity.logo = (ImageView) Utils.findRequiredViewAsType(view, R.id.logo, "field 'logo'", ImageView.class);
        baseLayoutActivity.officename = (TextView) Utils.findRequiredViewAsType(view, R.id.officename, "field 'officename'", TextView.class);
        baseLayoutActivity.weathertext = (TextView) Utils.findRequiredViewAsType(view, R.id.weathertext, "field 'weathertext'", TextView.class);
        baseLayoutActivity.weathericon = (ImageView) Utils.findRequiredViewAsType(view, R.id.weathericon, "field 'weathericon'", ImageView.class);
        baseLayoutActivity.bg = (ImageView) Utils.findRequiredViewAsType(view, R.id.bg, "field 'bg'", ImageView.class);
        baseLayoutActivity.wd = (TextView) Utils.findRequiredViewAsType(view, R.id.wd, "field 'wd'", TextView.class);
        baseLayoutActivity.wifi = (ImageView) Utils.findRequiredViewAsType(view, R.id.wifi, "field 'wifi'", ImageView.class);
        baseLayoutActivity.tv_text = (TextView) Utils.findRequiredViewAsType(view, R.id.tv_text, "field 'tv_text'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        BaseLayoutActivity baseLayoutActivity = this.target;
        if (baseLayoutActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        baseLayoutActivity.logo = null;
        baseLayoutActivity.officename = null;
        baseLayoutActivity.weathertext = null;
        baseLayoutActivity.weathericon = null;
        baseLayoutActivity.bg = null;
        baseLayoutActivity.wd = null;
        baseLayoutActivity.wifi = null;
        baseLayoutActivity.tv_text = null;
    }
}
