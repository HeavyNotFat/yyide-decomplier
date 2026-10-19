package com.yd.android_brand_mvp.user;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.landscape.AssignmentWeekFragment;
import com.yd.android_brand_mvp.landscape.AssignmentWeekFragmentP;

/* JADX INFO: loaded from: classes4.dex */
public class AsslgnmentWeekActivity extends BaseLayoutActivity {
    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        if (ScreenUtils.isLandscape()) {
            return new AssignmentWeekFragment();
        }
        return new AssignmentWeekFragmentP();
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public String getName() {
        return getString(R.string.st_week_assignment);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
