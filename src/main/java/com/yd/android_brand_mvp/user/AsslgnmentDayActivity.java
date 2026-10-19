package com.yd.android_brand_mvp.user;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blankj.utilcode.util.ScreenUtils;
import com.yd.android_brand_mvp.R;
import com.yd.android_brand_mvp.base.BaseLayoutActivity;
import com.yd.android_brand_mvp.landscape.AssignmentDayFragment;
import com.yd.android_brand_mvp.landscape.AssignmentDayFragmentL;

/* JADX INFO: loaded from: classes4.dex */
public class AsslgnmentDayActivity extends BaseLayoutActivity {
    TextView rightBack;

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public int addTitle() {
        return R.layout.activity_assignment_titile_layout;
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    public Fragment getFragment() {
        if (ScreenUtils.isLandscape()) {
            return new AssignmentDayFragment();
        }
        return new AssignmentDayFragmentL();
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity
    /* JADX INFO: renamed from: getName */
    public String getTitleName() {
        return getString(R.string.st_day_assignment);
    }

    @Override // com.yd.android_brand_mvp.base.BaseLayoutActivity, com.yd.android_brand_mvp.base.BaseActivity, skin.support.app.SkinCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TextView textView = (TextView) findViewById(R.id.tv_wednesday);
        this.rightBack = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.yd.android_brand_mvp.user.AsslgnmentDayActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AsslgnmentDayActivity.this.goActivity(AsslgnmentWeekActivity.class);
            }
        });
    }
}
