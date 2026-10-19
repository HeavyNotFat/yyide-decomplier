package com.yd.android_brand_mvp.activity;

import android.os.Bundle;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;

/* JADX INFO: loaded from: classes4.dex */
public class KBActivity extends BaseLayoutActivity {
    TextView tv_week;

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public int addTitle() {
        return R.layout.kb_title_layout;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public String getName() {
        return "课表";
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        return new com.yd.android_brand_mvp.activity.fragment.NewKbFragment();
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.tv_week = (TextView) findViewById(R.id.week);
    }

    public void setRightTitle(String str) {
        this.tv_week.setText(str);
    }
}
