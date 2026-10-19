package com.yd.android_brand_mvp;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class SettingActivity_ViewBinding implements Unbinder {
    private SettingActivity target;

    public SettingActivity_ViewBinding(SettingActivity settingActivity) {
        this(settingActivity, settingActivity.getWindow().getDecorView());
    }

    public SettingActivity_ViewBinding(SettingActivity settingActivity, View view) {
        this.target = settingActivity;
        settingActivity.fm_setting = (FrameLayout) Utils.findRequiredViewAsType(view, R.id.fm_setting, "field 'fm_setting'", FrameLayout.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SettingActivity settingActivity = this.target;
        if (settingActivity == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.target = null;
        settingActivity.fm_setting = null;
    }
}
