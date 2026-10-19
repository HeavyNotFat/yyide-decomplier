package com.yd.android_brand_mvp.user;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.landscape.PhotoAlbumAllFragment;
import com.yd.android_brand_mvp.landscape.exam.comments.CommentsHomeFragment;

/* JADX INFO: loaded from: classes4.dex */
public class PhotoAlbumActivity extends BaseLayoutActivity {
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
        return new PhotoAlbumAllFragment();
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public String getName() {
        String stringExtra = getIntent().getStringExtra("titleName");
        this.titleName = stringExtra;
        return stringExtra;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
