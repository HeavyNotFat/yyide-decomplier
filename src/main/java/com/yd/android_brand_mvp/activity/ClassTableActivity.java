package com.yd.android_brand_mvp.activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.StringUtils;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;

/* JADX INFO: loaded from: classes4.dex */
public class ClassTableActivity extends BaseLayoutActivity {
    String title;

    private void setLab() {
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        if (ScreenUtils.isLandscape()) {
            return new com.yd.android_brand_mvp.activity.fragment.ClassTableFragment();
        }
        return new com.yd.android_brand_mvp.activity.fragment.ClassTablePFragment();
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public String getName() {
        String stringExtra = getIntent().getStringExtra("title");
        this.title = stringExtra;
        return StringUtils.isEmpty(stringExtra) ? "课表" : this.title;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
