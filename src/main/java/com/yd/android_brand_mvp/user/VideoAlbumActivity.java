package com.yd.android_brand_mvp.user;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.brand.BroCast;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;
import com.yd.android_brand_mvp.video1.VideoAlbum1Fragment;

/* JADX INFO: loaded from: classes4.dex */
public class VideoAlbumActivity extends BaseLayoutActivity {
    public String classesId;
    public String kind;
    public String schoolId;
    public String titleName;
    public String type;

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        this.type = getIntent().getStringExtra("type");
        this.kind = getIntent().getStringExtra("kind");
        this.schoolId = getIntent().getStringExtra("schoolId");
        this.classesId = getIntent().getStringExtra(CommentsHomeFragment.TYPE_CLASSESID);
        return new VideoAlbum1Fragment(this.kind);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        String stringExtra = getIntent().getStringExtra("titleName");
        this.titleName = stringExtra;
        return stringExtra;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        BroCast.hidebar(this);
    }
}
