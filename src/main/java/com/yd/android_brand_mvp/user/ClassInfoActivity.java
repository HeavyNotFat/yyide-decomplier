package com.yd.android_brand_mvp.user;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.landscape.ClassInfoFragmentL;

/* JADX INFO: loaded from: classes4.dex */
public class ClassInfoActivity extends BaseLayoutActivity {
    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        return new ClassInfoFragmentL();
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public String getName() {
        return getString(R.string.st_class_info);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
