package com.yd.android_brand_mvp.photo;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.portrait.fragment.ShowPhotoAlbumAllPFragment;

/* JADX INFO: loaded from: classes4.dex */
public class ShowPhotoAlbumActivity extends BaseLayoutActivity {
    String imgJson;
    String titleName;

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        if (ScreenUtils.isLandscape()) {
            return new ShowPhotoAlbumAllFragment(this.imgJson);
        }
        return new ShowPhotoAlbumAllPFragment(this.imgJson);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public String getName() {
        this.imgJson = getIntent().getStringExtra("imgJson");
        String stringExtra = getIntent().getStringExtra("titleName");
        this.titleName = stringExtra;
        return stringExtra;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
