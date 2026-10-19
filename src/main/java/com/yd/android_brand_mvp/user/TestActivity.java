package com.yd.android_brand_mvp.user;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.landscape.message.AnnouncementListFragment;
import com.yd.android_brand_mvp.portrait.fragment.AnnouncementListFragmentP;

/* JADX INFO: loaded from: classes4.dex */
public class TestActivity extends BaseLayoutActivity {
    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return "个人中心";
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        if (ScreenUtils.isLandscape()) {
            return new AnnouncementListFragment();
        }
        return new AnnouncementListFragmentP();
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
